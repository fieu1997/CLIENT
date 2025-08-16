# HSO Map Viewer

Ứng dụng PyQt6 để xem và phân tích bản đồ HsoMobi (Huyền Thoại Sơn Hà).

## 🚀 Cài Đặt

### Yêu Cầu Hệ Thống
- Python 3.8+
- PyQt6
- Pillow

### Cài Đặt Dependencies
```bash
pip install -r requirements.txt
```

Hoặc cài đặt thủ công:
```bash
pip install PyQt6 Pillow
```

## 🎮 Sử Dụng

### Chạy Ứng Dụng
```bash
python3 hso_map_viewer.py
```

### Các Bước Cơ Bản

1. **Tải Map Data**
   - Click nút "Tải Map Data"
   - Chọn file map (có thể không có đuôi file)
   - Ứng dụng sẽ parse và hiển thị thông tin

2. **Tải Tileset (Tùy chọn)**
   - Click nút "Tải Tileset (tile.png)"
   - Chọn file hình ảnh tileset (PNG, JPG, etc.)
   - Map sẽ được hiển thị với graphics thực tế

3. **Điều Khiển View**
   - **Mouse Wheel**: Zoom in/out
   - **Left Click + Drag**: Pan (di chuyển view)
   - **Scale info**: Hiển thị ở góc trên bên trái

## 🗺️ Hiểu Bản Đồ

### Legend (Chú Thích)
- **Ô vàng**: Effect Objects (decorative items)
- **Vòng tròn xanh**: VGOs (warps nội bộ)
- **Vòng tròn hồng**: External VGOs (warps ra map khác)
- **Ô xanh lá**: Eff Data (effect triggers)

### Panel Thông Tin
- **Thông Tin Map**: Tên, version, kích thước, tileset ID
- **Objects List**: Chi tiết tất cả objects trên map

### Cấu Trúc Map Data
```
Map Header:
- Tên map (UTF-8)
- Version (2 bytes)
- Kích thước (width × height)
- Tileset ID

Tile Data:
- Ma trận tiles (width × height bytes)

Objects:
- Effect Objects: Decorative items
- VGOs: Warp points
- Eff Data: Effect triggers
```

## 📁 File Test

Đi kèm với ứng dụng có file `test_map.bin` để test:
- Map: "Ngôi Làng Nhỏ"
- Size: 58×30 tiles
- 77 effect objects
- 7 eff data blocks
- 1 external VGO

## 🛠️ Tính Năng

### Hiện Tại
✅ Parse HSO map data format  
✅ Hiển thị tile map (grid mode khi không có tileset)  
✅ Render với tileset graphics  
✅ Hiển thị tất cả object types  
✅ Zoom và pan controls  
✅ Object information panel  
✅ Dark theme UI  

### Tương Lai
🔄 Edit mode (chỉnh sửa map)  
🔄 Export map data  
🔄 Object property editor  
🔄 Multiple tileset support  

## 📋 Format Specification

HSO Map format được reverse engineer từ client code:

```
[2 bytes]     - Padding
[UTF String]  - Map name
[2 bytes]     - Version
[1 byte]      - Width
[1 byte]      - Height  
[1 byte]      - Tileset ID
[W×H bytes]   - Tile data
[0xFF]        - Separator
[Object Block]- Objects data
[External VGOs]- External warps
[0xFF]        - EOF
```

## 🐛 Troubleshooting

### Lỗi Thường Gặp

**"Không thể tải map data"**
- Kiểm tra file có đúng format HSO map không
- Thử với file test_map.bin đi kèm

**"Không thể đọc file hình ảnh"**
- Chỉ hỗ trợ PNG, JPG, JPEG, BMP
- Kiểm tra file tileset có bị corrupted không

**Interface không hiển thị đúng**
- Cần PyQt6 version 6.5.0 trở lên
- Thử chạy với Python 3.8+

### Debug Mode
Để xem chi tiết parsing:
```bash
python3 correct_map_parser.py
```

## 📞 Liên Hệ

Ứng dụng được phát triển để phân tích format map của game HsoMobi.  
Code dựa trên reverse engineering của client Java và TypeScript reference implementation.

## 📄 License

Open source - sử dụng tự do cho mục đích nghiên cứu và phát triển.