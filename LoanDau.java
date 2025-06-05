package ai;

import BossHDL.BossManager;
import client.Player;
import client.Squire;
import core.Manager;
import core.SQL;
import core.Service;
import core.Util;
import io.Message;
import io.Session;
import java.io.File;
import map.Map;
import map.MapService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import map.ItemMap;
import map.Mob_in_map;
import map.Vgo;
import template.Item3;
import template.ItemTemplate3;
import template.Option;

public class LoanDau {

    public static boolean isEventActive = false;
    public static long startTime = 0;
    public static long currentTime = 0;
    public static boolean isTimerRunning = false;
    public static int time_ld = 60 * 60;
    public static boolean bossCalled = false;

    public static void startEvent() throws IOException {
        if (!isEventActive) {// kiểm tra xem sk có bật hay k
            isEventActive = true;       
            Manager.isMap = true; // mở map
            startTime = System.currentTimeMillis(); // Khởi tạo thời gian bắt đầu
           isTimerRunning = true; // Bắt đầu bộ đếm thời gian      
           goiBoss124();
           PlayerPoints.deleteTempFile();
           Manager.gI().chatKTGprocess("Loạn Đấu Đã Bắt Đầu Hãy Đi xuống Ngôi Làng Nhỏ");
        
            } else {
            System.out.println("Sự kiện đã được bật trước đó.");
        }
    }
 // kết thúc 
    public static void endEvent() throws IOException {
        if (isEventActive) {
            isEventActive = false;
            isTimerRunning = false; // Dừng bộ đếm thời gian
            removeBoss(); // Xóa boss
            VeLang(); // Di chuyển tất cả người chơi ra khỏi map
            Manager.isMap = false; // Đặt lại trạng thái của map
            Manager.gI().chatKTGprocess("Loạn Đấu Đã Kết Thúc!");
        } else {
            System.out.println("Sự kiện chưa được bật.");
        }
    }
    
   // vào map 124
    public static void LoanDau_map(Player p) throws IOException {
    // Kiểm tra nếu người chơi đang ở map 1 và cố gắng di chuyển đến map 0
    if (Manager.isMap && p.map.map_id == 1) {
        for (Vgo vgo : p.map.vgos) {
            if (vgo != null && vgo.id_map_go == 0) {
                // Kiểm tra nếu người chơi ở vị trí gần cổng chuyển map 0
                if (Math.abs(p.x - vgo.x_old) < 100 && Math.abs(p.y - vgo.y_old) < 100) {
                    // Kiểm tra cấp độ của người chơi
                    if (p.level < 20) {
                        // Hiển thị thông báo cho người chơi biết rằng họ chưa đủ cấp độ để vào map 124
                        Service.send_notice_nobox_white(p.conn, "Bạn cần đạt cấp độ 20 để vào Loạn Đấu!");
                        break; // Ngăn không cho người chơi di chuyển
                    }

                    // Nếu level >= 20, chuyển họ vào map 124 thay vì map 0
                    Map newMap = Map.get_map_by_id(124)[0];
                    
                    // Thực hiện di chuyển người chơi từ map cũ sang map mới
                    MapService.leave(p.map, p);
                    p.map = newMap;
                    p.x = 516; //
                    p.y = 372; //
                    p.typepk = 0; // mặc định đồ sát
                    isTimerRunning = true;
                    // Đưa người chơi vào map mới
                    MapService.enter(p.map, p);
                    return; // 
                }
            }
        }
    }
}

    public static void update(Map map) throws IOException {
        if (map.map_id == 124 && isTimerRunning) {
            currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 1000; // Thời gian đã trôi qua tính bằng giây

            int remainingTime = (int) (time_ld - elapsedTime); // Tính toán thời gian còn lại

            // Cập nhật thời gian còn lại cho tất cả người chơi trong map ngay từ đầu
            for (Player player : map.players) {
                if (remainingTime <= 10) {
                    Service.send_notice_nobox_white(player.conn, "Rời map sau " + remainingTime + " giây!");
                } else {
                    khu2.khu2_time_box(player, (byte) 1, new int[]{remainingTime}, new String[]{"Loạn Đấu "});
                }
            }

            if (remainingTime <= 0) { // khi thời gian về mo              
                endEvent();
            }

        }
    }
    
    
    public static void removeBoss() {
        Iterator<Mob_in_map> iterator = BossManager.entrys.iterator();
        while (iterator.hasNext()) {
            Mob_in_map boss = iterator.next();
            if (boss.map_id == 124) {
                boss.is_boss_active = false;
                boss.isdie = true;
                boss.hp = 0;

                Map bossMap = Map.get_map_by_id(boss.map_id)[boss.zone_id];
                if (bossMap != null) {
                    bossMap.Boss_entrys.remove(boss);
                }
                iterator.remove();
                bossCalled = false;
            }
        }
    }

   

public static void NhanQua(Player player) throws IOException {
    if (isTimerRunning) {
        Service.send_notice_box(player.conn, "Chưa kết thúc thời gian sự kiện, không thể nhận quà.");
        return;
    }

    int playerPoints = PlayerPoints.loadPlayerPointsFromFile(player);
    if (playerPoints == 0) {
        Service.send_notice_box(player.conn, "Bạn không có điểm nào để nhận thưởng.");
        return;
    }

    // Load all players' data to determine rankings
    File file = new File(PlayerPoints.TEMP_FILE_PATH);
    List<Entry<Integer, Integer>> sortedPlayers = new ArrayList<>();

    if (file.exists()) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 4) { // ID, tên, điểm, trạng thái
                    int playerId = Integer.parseInt(data[0]);
                    int points = Integer.parseInt(data[2]);
                    sortedPlayers.add(new AbstractMap.SimpleEntry<>(playerId, points));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Service.send_notice_box(player.conn, "Lỗi khi đọc dữ liệu nhận quà.");
            return;
        }
    } else {
        Service.send_notice_box(player.conn, "Không tìm thấy dữ liệu để nhận quà.");
        return;
    }

    // Sort players by points and only take the top 10
    sortedPlayers.sort((a, b) -> b.getValue().compareTo(a.getValue()));
    sortedPlayers = sortedPlayers.subList(0, Math.min(10, sortedPlayers.size()));

    // Reward list for top 10 players
    int[] rewards = {50000, 45000, 35000, 25000, 10000, 8000, 6000, 5000, 4000, 2500}; 
    String rewardMessageTemplate = "Bạn đứng hạng %d và nhận được %d ngọc!";

    // Check if the player is in the top 10 and hasn't received the reward
    for (int i = 0; i < sortedPlayers.size(); i++) {
        int playerId = sortedPlayers.get(i).getKey();
        if (playerId == player.index) {
            if (PlayerPoints.loadPlayerGiftStatus(player)) { // Check if the player has received the reward
                Service.send_notice_box(player.conn, "Bạn đã nhận quà rồi.");
                return;
            }

            int reward = rewards[i];
            String message = String.format(rewardMessageTemplate, i + 1, reward);

            player.addReward(reward); // Add reward to the player
            Service.send_notice_box(player.conn, message);

            // Update the player's reward status
            PlayerPoints.savePlayerPointsToFile(player, playerPoints, true);

            return;
        }
    }

    Service.send_notice_box(player.conn, "Không thể trao quà. Bạn không nằm trong top 10.");
}

    public static Mob_in_map goiBoss124() {
        int mapId = 124;
        int khu = 0;
        int id = 193;
        int x = 516, y = 366;
        int level = 1000;
        int hp = 100;
        int defense = 5000;
        int damage = 1;
        int type = 1; // 1 hồi sinh, 0 không hồi sinh
        int time = 1000 * 60 * 1;
        int playerId = 0;

        Mob_in_map boss = BossManager.callBossToMap(mapId, khu, id, x, y, level, hp, defense, damage, type, time, playerId);
        bossCalled = true; // Đánh dấu rằng boss đã được gọi một lần
        boss.isBoss_124 = true; // đánh dấu được gọi ở map 124 ^^

        return boss;
    }

    public static void VeLang() throws IOException {
    for (Map[] maps : Map.entrys) {
        for (Map map : maps) {
            if (map.map_id == 124) {
                List<Player> playersToMove = new ArrayList<>(map.players);
                for (Player player : playersToMove) {
                    // Đảm bảo chỉ xử lý với người chơi thực sự, không phải Squire
                    if (player.isSquire) continue;

                    // Loại bỏ Squire khỏi map cũ (nếu có)
                    // if (player.isLiveSquire && player.squire != null) {
                        // MapService.leave(player.squire.map, player.squire);
                        // //player.squire = null;
                    // }

                    // Chuyển map người chơi
                    map = Map.get_map_by_id(1)[0];
                    MapService.leave(player.map, player);
                    player.map = map;
                    player.x = 516;
                    player.y = 504;
                    player.typepk = -1;

                    // Đưa người chơi vào map mới
                    MapService.enter(player.map, player);
                }
            }
        }
    }
}


    ///
    public static void leave_item3_124(Map map, Mob_in_map mob, Player p) throws IOException {
        // Mảng chứa các id của các item3 có thể rơi
        // cải trang                   mặt nạ                    cánh                áo ch             vk2                   danh hiệu 
        short[] danhsach = new short[]{4618, 4711, 4756, 4763, 4764, 4757, 4632, 4633, 4634, 4635, 4793, 4794, 4795, 4796, 4797, 4690, 4691, 4692, 4693, 4694, 4755, 4775, 4776, 4777, 4778, 4783};

        short[] id_item_leave3 = new short[]{};

        if (mob != null) {
            // Lựa chọn ngẫu nhiên một id từ mảng available_ids
            if (100 > Util.random(100)) {
                int randomIndex = Util.ngaunhien(0, danhsach.length - 1);
                id_item_leave3 = new short[]{danhsach[randomIndex]};
            }

            for (short id : id_item_leave3) {
                ItemTemplate3 temp = ItemTemplate3.item.get(id);

                LoanDau.leave_item_by_type3(map, id, temp.getColor(), p, temp.getName(), mob.index);
            }
        }
    }

    public static void leave_item_by_type3(Map map, int index_real, int color_, Player p_master, String name, int index)
        throws IOException {
    int index_item_map = map.get_item_map_index_able();
    if (index_item_map > -1) {
        map.item_map[index_item_map] = new ItemMap();
        map.item_map[index_item_map].id_item = (short) index_real;
        map.item_map[index_item_map].color = (byte) color_;
        map.item_map[index_item_map].quantity = 1;
        map.item_map[index_item_map].category = 3;
        map.item_map[index_item_map].idmaster = (short) p_master.index;

        Item3 item3 = new Item3(ItemTemplate3.item.get(index_real));
        item3.color = (byte) color_;
        item3.map_124 = true; // Đánh dấu rằng vật phẩm này rơi ra từ khu2

        item3.level = 1;
        item3.tier = (byte) Util.ngaunhien(1, 15);
        int time = Util.ngaunhien(3, 7);
        // thêm thời gian hết hạn cho trang bị
        item3.expiry_date = System.currentTimeMillis() + time * 60 * 60 * 1000;
        
        // Thêm đoạn mã mới
        List<Option> opnew = new ArrayList<>();
        for (Option op_old : ItemTemplate3.item.get(index_real).getOp()) {
            Option temp = new Option(1, 1, (short) 0);
            temp.id = op_old.id;
            if (temp.id != 37 && temp.id != 38) {
                if (op_old.getParam(0) < 10) {
                    temp.setParam(Util.random(0, 10));
                } else {
                    temp.setParam(Util.random((9 * op_old.getParam(0)) / 10, op_old.getParam(0)));
                }
            } else {
                temp.setParam(1);
            }
            opnew.add(temp);
        }
        map.item_map[index_item_map].op = opnew;

        // Cập nhật thêm thuộc tính từ opnew vào item3
        item3.op = opnew;

        map.item_map[index_item_map].item3 = item3;

        map.item_map[index_item_map].expiration_time = item3.expiry_date;
        map.item_map[index_item_map].time_exist = item3.expiry_date;
        map.item_map[index_item_map].time_pick = System.currentTimeMillis() + 1_500L;

        Message mi = new Message(19);
        mi.writer().writeByte(3);
        mi.writer().writeShort(index);
        mi.writer().writeShort(item3.icon);
        mi.writer().writeShort(index_item_map);
        mi.writer().writeUTF(item3.name);
        mi.writer().writeByte(item3.color);
        mi.writer().writeShort(-1);
        MapService.send_msg_player_inside(map, p_master, mi, true);
        mi.cleanup();
    }
}


}
