# requirements: selenium-wire, packaging

import warnings
# Tắt cảnh báo deprecated của pkg_resources (dự phòng)
warnings.filterwarnings("ignore", category=UserWarning, message=".*pkg_resources is deprecated.*")

# Monkey-patch pkg_resources.parse_version bằng packaging.version.parse
import pkg_resources
from packaging import version
pkg_resources.parse_version = version.parse

import time
import os
import sys
import random
import string
import collections
import gzip
from seleniumwire import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException, StaleElementReferenceException, NoSuchElementException, WebDriverException

# Vô hiệu hóa đầu ra lỗi
class DevNull:
    def write(self, msg):
        pass
    def flush(self):
        pass

# Chuyển hướng stderr để không in lỗi
sys.stderr = DevNull()

# ==============================================================================
# LỚP QUẢN LÝ TRẠNG THÁI TÁC VỤ (NÂNG CẤP)
# ==============================================================================
class PromptTask:
    """Lớp theo dõi trạng thái và số lần thử lại của từng prompt."""
    def __init__(self, scene_number, original_prompt):
        self.scene_number = scene_number
        self.original_prompt = original_prompt
        self.unique_id = generate_id()
        self.formatted_prompt = f"[ID_{self.unique_id}] CẢNH {self.scene_number}: {self.original_prompt}"
        # Các trạng thái: pending -> submitted -> completed -> downloading -> downloaded -> submit_failed -> download_failed
        self.status = 'pending'
        self.submit_attempts = 0
        self.download_attempts = 0

# === LỚP TƯƠNG THÍCH CHO SELENIUM CŨ ===
class number_of_elements_to_be(object):
    def __init__(self, locator, number):
        self.locator = locator
        self.number = number
    def __call__(self, driver):
        try:
            return len(driver.find_elements(*self.locator)) == self.number
        except:
            return False

# === CÁC HÀM TIỆN ÍCH ===
def generate_id(length=4):
    return ''.join(random.choices(string.ascii_uppercase + string.digits, k=length))

def load_target_url(filename="link.txt"):
    if not os.path.exists(filename):
        print(f"Lỗi: File link '{filename}' không tồn tại. Đang tạo file mẫu...")
        with open(filename, 'w', encoding='utf-8') as f:
            f.write("https://labs.google/fx/vi/tools/flow\n")
        input(f"Đã tạo file '{filename}'. Nhấn Enter để thoát.")
        return None
    with open(filename, 'r', encoding='utf-8') as f:
        for line in f:
            line = line.strip()
            if line and not line.startswith('#'):
                print(f"Đã tải URL từ file: {line}")
                return line
    print(f"Lỗi: Không tìm thấy link hợp lệ trong file '{filename}'.")
    input("Nhấn Enter để thoát.")
    return None

def load_prompts(filename="prompts.txt"):
    if not os.path.exists(filename):
        print(f"Lỗi: File prompt '{filename}' không tồn tại. Đang tạo file mẫu...")
        with open(filename, 'w', encoding='utf-8') as f:
            f.write("SC 1: a beautiful cinematic shot of a futuristic city 🌇\nSC 2: a majestic lion walking across the savanna 🦁\n")
        input("Đã tạo file mẫu. Nhấn Enter để thoát.")
        return None
    prompts = []
    with open(filename, 'r', encoding='utf-8') as f:
        for line in f:
            line = line.strip()
            if line and not line.startswith('#'):
                parts = line.split(':', 1)
                if len(parts) == 2:
                    prompts.append(parts[1].strip())
    if not prompts:
        print(f"Lỗi: Không tìm thấy prompt hợp lệ nào trong file '{filename}'.")
        input("Nhấn Enter để thoát.")
        return None
    return prompts

def load_proxy_config(filename="tai_khoan_proxy.txt"):
    if not os.path.exists(filename):
        print(f"Lỗi: File cấu hình '{filename}' không tồn tại. Đang tạo file mẫu...")
        with open(filename, 'w', encoding='utf-8') as f:
            f.write("PROXY_HOST=your_host\nPROXY_PORT=your_port\nPROXY_USER=your_username\nPROXY_PASS=your_password\n")
        input("Đã tạo file mẫu. Nhấn Enter để thoát.")
        return None
    config = {}
    with open(filename, 'r', encoding='utf-8') as f:
        for line in f:
            line = line.strip()
            if line and not line.startswith('#'):
                try:
                    key, value = line.split('=', 1)
                    config[key.strip()] = value.strip()
                except ValueError:
                    continue
    required_keys = ['PROXY_HOST', 'PROXY_PORT', 'PROXY_USER', 'PROXY_PASS']
    if not all(key in config for key in required_keys):
        print(f"Lỗi: File cấu hình thiếu các khóa: {', '.join(required_keys)}")
        input("Nhấn Enter để thoát.")
        return None
    return config

def submit_prompt(wait, driver, text, is_first_prompt=False):
    prompt_textarea_xpath = "//textarea[@id='PINHOLE_TEXT_AREA_ELEMENT_ID']"
    send_button_xpath = "//i[contains(@class, 'google-symbols') and contains(text(), 'arrow_forward')]"
    prompt_textarea = wait.until(EC.element_to_be_clickable((By.XPATH, prompt_textarea_xpath)))
    if is_first_prompt:
        ActionChains(driver).double_click(prompt_textarea).perform()
    else:
        driver.execute_script("arguments[0].click();", prompt_textarea)
    js_script = "const ta = arguments[0], val = arguments[1]; ta.value = val; ta.dispatchEvent(new Event('input', { bubbles: true })); ta.dispatchEvent(new Event('change', { bubbles: true }));"
    driver.execute_script(js_script, prompt_textarea, text)
    prompt_textarea.send_keys(" " + Keys.BACK_SPACE)
    time.sleep(3)
    send_button = wait.until(EC.element_to_be_clickable((By.XPATH, send_button_xpath)))
    driver.execute_script("arguments[0].click();", send_button)

def wait_for_download_and_rename(download_dir, task, timeout=600):
    files_before = set(os.listdir(download_dir))
    print(f"    - Đang theo dõi thư mục '{download_dir}' để chờ file mới...")
    start_time = time.time()
    while time.time() - start_time < timeout:
        files_after = set(os.listdir(download_dir))
        new_files = files_after - files_before
        if new_files and not any(f.endswith(('.crdownload', '.tmp')) for f in new_files):
            new_file_path = os.path.join(download_dir, new_files.pop())
            # Đợi một chút để đảm bảo file đã được ghi xong hoàn toàn
            time.sleep(2)
            new_filename = f"{task.scene_number}.mp4"
            final_path = os.path.join(download_dir, new_filename)
            print(f"    - Đổi tên tệp: {os.path.basename(new_file_path)} -> {new_filename}")
            try:
                os.rename(new_file_path, final_path)
                return True
            except:
                return False
        time.sleep(1)
    return False

# --- MAIN SCRIPT ---
WAIT_TIMEOUT = 30
MAX_SUBMIT_ATTEMPTS = 5
MAX_DOWNLOAD_ATTEMPTS = 5
MAX_CONCURRENT_TASKS = 5
POLLING_INTERVAL = 5

proxy_config = load_proxy_config()
if not proxy_config:
    sys.exit()
prompts_list = load_prompts()
if not prompts_list:
    sys.exit()
target_url = load_target_url()
if not target_url:
    sys.exit()

# ... (Cấu hình Chrome Options giữ nguyên)
current_path = os.getcwd()
PROFILE_DIR_NAME = 'VEO3_user_profile'
profile_path = os.path.join(current_path, PROFILE_DIR_NAME)
DOWNLOAD_DIR_NAME = 'downloads'
download_path = os.path.join(current_path, DOWNLOAD_DIR_NAME)
os.makedirs(download_path, exist_ok=True)
seleniumwire_options = {
    'proxy': {
        'http': f'http://{proxy_config["PROXY_USER"]}:{proxy_config["PROXY_PASS"]}@{proxy_config["PROXY_HOST"]}:{proxy_config["PROXY_PORT"]}',
        'https': f'https://{proxy_config["PROXY_USER"]}:{proxy_config["PROXY_PASS"]}@{proxy_config["PROXY_HOST"]}:{proxy_config["PROXY_PORT"]}',
        'no_proxy': 'localhost,127.0.0.1'
    },
    'disable_encoding': True
}
chrome_options = Options()
chrome_options.add_argument(f'--user-data-dir={profile_path}')
chrome_options.add_argument('--log-level=3')
chrome_options.add_experimental_option('excludeSwitches', ['enable-logging'])
prefs = {
    "credentials_enable_service": False,
    "profile.password_manager_enabled": False,
    "profile.managed_default_content_settings.images": 2,
    "download.default_directory": download_path,
    "download.prompt_for_download": False,
    "download.directory_upgrade": True,
    "profile.default_content_setting_values.automatic_downloads": 1
}
chrome_options.add_experimental_option("prefs", prefs)
chrome_options.add_argument('user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36')
chrome_options.add_argument('--disable-infobars')
chrome_options.add_argument("--disable-blink-features=AutomationControlled")
chrome_options.add_experimental_option("excludeSwitches", ["enable-automation", "load-extension"])
chrome_options.add_experimental_option('useAutomationExtension', False)
chrome_options.add_argument('--ignore-certificate-errors')
chrome_options.add_argument('--disable-dev-shm-usage')
service = Service(log_output=os.devnull)

# --- KHỞI ĐỘNG KỊCH BẢN ---
driver = None
try:
    print("-" * 60)
    print("VUI LÒNG CHỌN CHẾ ĐỘ CHẠY:")
    print("  1: Chạy ngầm (Headless)")
    print("  2: Trực quan (Hiển thị Chrome)")
    run_mode = ''
    while run_mode not in ['1', '2']:
        run_mode = input("Nhập lựa chọn (1 hoặc 2): ").strip()
    print("-" * 60)
    if run_mode == '1':
        print("KÍCH HOẠT CHẾ ĐỘ HEADLESS.")
        chrome_options.add_argument('--headless=new')
        chrome_options.add_argument('--window-size=1920,1080')
        chrome_options.add_argument('--disable-gpu')
    else:
        print("KÍCH HOẠT CHẾ ĐỘ TRỰC QUAN.")
        chrome_options.add_argument("--start-maximized")
    
    print(f"Đang khởi động Chrome với proxy: {proxy_config['PROXY_HOST']}:{proxy_config['PROXY_PORT']}...")
    try:
        driver = webdriver.Chrome(service=service, seleniumwire_options=seleniumwire_options, options=chrome_options)
        print("Chrome đã khởi động thành công!")
    except WebDriverException as e:
        print(f"Lỗi khởi động Chrome: {e}. Kiểm tra driver Chrome hoặc proxy.")
        sys.exit()

    # Mở URL mục tiêu
    print(f"Đang mở URL: {target_url}")
    driver.get(target_url)
    print(f"Đã mở URL: {driver.current_url}")
    time.sleep(2)  # Đợi để kiểm tra thủ công

    # --- BẮT ĐẦU LOGIC TỰ ĐỘNG HÓA CHÍNH ---
    wait = WebDriverWait(driver, WAIT_TIMEOUT)
    print("[SETUP] Thực hiện các bước thiết lập ban đầu...")
    try:
        model_button_xpath = "//button[.//span[text()='Mô hình']]"
        wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(., 'tune') and contains(., 'Cài đặt')]"))).click()
        time.sleep(1)
        wait.until(EC.element_to_be_clickable((By.XPATH, model_button_xpath))).click()
        time.sleep(1)
        ActionChains(driver).send_keys(Keys.ARROW_DOWN).pause(0.5).send_keys(Keys.ENTER).perform()
        wait.until(EC.text_to_be_present_in_element((By.XPATH, model_button_xpath), 'Veo 3'))
    except Exception as e:
        print(f"Lỗi thiết lập ban đầu: {e}")
    print("[SETUP] THIẾT LẬP BAN ĐẦU HOÀN TẤT!")
    print("-" * 70)
    input("===> [CHỜ LỆNH] Setup đã hoàn tất. Nhấn ENTER để bắt đầu...")
    print("-" * 70)
    
    # --- HỆ THỐNG QUẢN LÝ TÁC VỤ TỰ PHỤC HỒI ---
    tasks = [PromptTask(i + 1, p) for i, p in enumerate(prompts_list)]
    progress_bar_xpath = "//div[contains(@class, 'kNjcfj')]"
    
    while any(task.status not in ['downloaded', 'submit_failed', 'download_failed'] for task in tasks):
        print(f"\n[{time.strftime('%H:%M:%S')}] ------ Bắt đầu chu kỳ quét ------")
        try:
            # 1. CẬP NHẬT TRẠNG THÁI (Reconciliation)
            submitted_tasks = [t for t in tasks if t.status == 'submitted']
            if submitted_tasks:
                print(f"  [QUÉT] Kiểm tra {len(submitted_tasks)} tác vụ đang chạy...")
                for task in submitted_tasks:
                    try:
                        task_container_xpath = f"//*[contains(text(), '{task.unique_id}')]/ancestor::div[3]"
                        container = driver.find_element(By.XPATH, task_container_xpath)
                        if container.find_elements(By.XPATH, ".//video"):
                            task.status = 'completed'
                            print(f"  [PHÁT HIỆN] Cảnh {task.scene_number} đã hoàn thành!")
                    except NoSuchElementException:
                        pass

            # 2. HÀNH ĐỘNG: Tải về các video đã hoàn thành
            completed_tasks = [t for t in tasks if t.status == 'completed']
            if completed_tasks:
                for task in completed_tasks:
                    if task.download_attempts < MAX_DOWNLOAD_ATTEMPTS:
                        print(f"  [HÀNH ĐỘNG] Bắt đầu tải về Cảnh {task.scene_number} (Lần thử {task.download_attempts + 1}/{MAX_DOWNLOAD_ATTEMPTS})...")
                        try:
                            task_container_xpath = f"//*[contains(text(), '{task.unique_id}')]/ancestor::div[3]"
                            container = driver.find_element(By.XPATH, task_container_xpath)
                            video_element = container.find_element(By.XPATH, ".//video")
                            
                            # NÂNG CẤP: Tự động cuộn đến video trước khi tương tác
                            print(f"    - Tự động cuộn đến video Cảnh {task.scene_number}...")
                            driver.execute_script("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", video_element)
                            time.sleep(1)

                            ActionChains(driver).move_to_element(video_element).perform()
                            time.sleep(1)
                            
                            download_button_locator = (By.XPATH, f"{task_container_xpath}//button[contains(., 'Tải xuống')]")
                            download_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable(download_button_locator))
                            driver.execute_script("arguments[0].click();", download_button)
                            time.sleep(1)
                            
                            size_option_locator = (By.XPATH, "//div[contains(text(),'Kích thước gốc (720p)')]")
                            size_option = WebDriverWait(driver, 10).until(EC.element_to_be_clickable(size_option_locator))
                            driver.execute_script("arguments[0].click();", size_option)
                            
                            if wait_for_download_and_rename(download_path, task):
                                task.status = 'downloaded'
                                print(f"  --> Tải và đổi tên Cảnh {task.scene_number} thành công.")
                            else:
                                raise Exception("Chờ file tải về quá lâu.")
                        except:
                            task.download_attempts += 1
                    else:
                        print(f"  [BỎ QUA TẢI] Đã thử tải Cảnh {task.scene_number} {MAX_DOWNLOAD_ATTEMPTS} lần nhưng thất bại.")
                        task.status = 'download_failed'

            # 3. HÀNH ĐỘNG: Gửi prompt mới nếu có khe trống
            active_tasks_count = len(driver.find_elements(By.XPATH, progress_bar_xpath))
            if active_tasks_count < MAX_CONCURRENT_TASKS:
                next_task_to_submit = next((task for task in tasks if task.status == 'pending'), None)
                if next_task_to_submit:
                    if next_task_to_submit.submit_attempts < MAX_SUBMIT_ATTEMPTS:
                        print(f"  [HÀNH ĐỘNG] Có khe trống. Gửi Cảnh {next_task_to_submit.scene_number} (Lần thử {next_task_to_submit.submit_attempts + 1}/{MAX_SUBMIT_ATTEMPTS})...")
                        num_bars_before = len(driver.find_elements(By.XPATH, progress_bar_xpath))
                        submit_prompt(wait, driver, next_task_to_submit.formatted_prompt, next_task_to_submit.scene_number == 1)
                        try:
                            WebDriverWait(driver, 30).until(number_of_elements_to_be((By.XPATH, progress_bar_xpath), num_bars_before + 1))
                            next_task_to_submit.status = 'submitted'
                            print(f"  --> Gửi Cảnh {next_task_to_submit.scene_number} thành công và ĐÃ ĐƯỢC XÁC NHẬN trên tiến trình.")
                        except TimeoutException:
                            print(f"  !!! Gửi Cảnh {next_task_to_submit.scene_number} thất bại, không thấy tiến trình xuất hiện.")
                            next_task_to_submit.submit_attempts += 1
                    else:
                        print(f"  [BỎ QUA GỬI] Đã thử gửi Cảnh {next_task_to_submit.scene_number} {MAX_SUBMIT_ATTEMPTS} lần nhưng thất bại.")
                        next_task_to_submit.status = 'submit_failed'
                
                elif active_tasks_count == 0:
                    print("  [THÔNG TIN] Đã gửi hết các prompt và không còn tác vụ nào đang chạy.")
                    break

            print(f"[{time.strftime('%H:%M:%S')}] ------ Kết thúc chu kỳ quét. Chờ {POLLING_INTERVAL} giây. ------")
            time.sleep(POLLING_INTERVAL)
            
        except Exception as e:
            print(f"Lỗi chu kỳ: {e}")
            time.sleep(POLLING_INTERVAL)
            continue

    print("\n" + "-" * 60)
    print("TẤT CẢ CÁC TÁC VỤ ĐÃ HOÀN TẤT.")
    print("-" * 60 + "\n")
    input("Nhấn Enter để thoát...")

except Exception as e:
    print(f"Lỗi tổng quát: {e}")
    input("Nhấn Enter để thoát.")

finally:
    if driver:
        driver.quit()
    print("Đã đóng trình duyệt.")