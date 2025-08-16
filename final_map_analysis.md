# HsoMobi Map Data - Phân Tích Hoàn Chỉnh

## 🔍 **Tổng Quan**
**Map ID:** 17  
**Map Name:** "Ngôi Làng Nhỏ" (Village)  
**Total Size:** 2,420 bytes  
**Format:** Binary packed data với separator 0xFF  

## 📊 **Cấu Trúc Data**

### 1. Header Section (offset 0x00 - 0x1A)
```
00 00 00 11          - Map ID (int32 big-endian) = 17
4E 67 C3 B4 69 20    - Map name UTF-8: "Ngôi "
4C C3 A0 6E 67 20    - continues: "Làng "  
4E 68 E1 BB 8F       - continues: "Nhỏ"
06                   - Map metadata byte
CF 3A                - Unknown flags/properties
1E 00                - Additional header data
```

### 2. Tile Data Section (offset 0x1A - 0x6E8) 
**Kích thước:** ~1,740 bytes  
**Đặc điểm:**
- Tile values trong range 0-63 (98-100% data)
- Tile patterns cho terrain, buildings, decorations
- Compressed/packed format 
- Values `01-3B` (1-59) chủ yếu
- Special tiles: `0D-0E` (boundaries), `1A-1F` (water), `22-23` (bridges)

**Map Layout Pattern:**
```
Typical tile sequences:
2E 2F 30 31 31 32 2D 38  → Path/road tiles
0D 05 05 0E              → Water boundaries  
1A 1B 1B 1B 1C          → Water surfaces
22 22 22 22             → Bridge tiles
35 36 37 / 3A 3B        → Building/structure tiles
```

### 3. Separator (0xFF)
Phân chia section tile data và object data

### 4. Object/Waypoint Data (653 bytes)
**Format:** Coordinate pairs và metadata
```
02 72 - Object section header
00 4D - Object count or type (77 objects)

Coordinate patterns (x,y pairs):
00 01 00 04  → Point (1,4)  
00 0A 00 12  → Point (10,18)
00 11 00 0E  → Point (17,14) 
00 22 00 0D  → Point (34,13)
...và nhiều coordinates khác
```

**Phân loại Objects:**
- NPCs positions 
- Waypoints cho navigation
- Item spawn points
- Interactive objects
- Portal/exit points

### 5. End Section
**Kết thúc với dữ liệu đặc biệt:**
```
03 65 66 66 12 30 3B 31 3B 32 37 3B 38 3B 31 32 3B 31 32 3B 31 3B 30
03 65 66 66 11 31 3B 37 3B 31 32 3B 31 34 3B 30 3B 30 3B 31 3B 30
...
```
**Pattern "eff":** Có thể là effect data hoặc NPC dialogue strings

**Final string:** `4C C3 A0 6E 67 20 53 C3 B3 69 20 54 72 E1 BA AF 6E 67` = "Làng Sói Trắng" (White Wolf Village)

## 🎮 **Game Logic**

### Tile ID Mapping
**Terrain:**
- `01-02`: Empty ground/grass
- `05-06`: Water tiles  
- `0D-0E`: Water boundaries
- `0A-0C`: Ground transitions

**Structures:**
- `2D-32`: Buildings, walls
- `35-3B`: Decorative elements
- `1A-1F`: Water features
- `22-23`: Bridges/paths

**Movement:**
- `24-25`: Walkable decorations
- `26-27`: Special ground types
- `30-33`: Road/path tiles

### Navigation System
Objects data chứa waypoint network cho:
- NPC patrol routes
- Player navigation hints  
- Quest trigger locations
- Inter-map connections

## 🔧 **Kỹ Thuật**

### Data Compression
- Tile data được packed efficiently
- Repetitive patterns indicate compression
- No visible run-length encoding
- Possibly dictionary-based encoding

### Network Protocol 
**Từ analysis cmd -51:**
- Server gửi map data via cmd -51
- Format: `[cmd:-51][mapID:short][dataSize:varies][mapData:bytes]`
- Client parse và cache trong `cn.m` (ek hashtable)
- Map được load theo range ID 10600-10699

### Memory Layout
**Client-side storage:**
```java
cs.q = aq; // Background tiles (10400-10499)
cs.r = aq; // Collision data (10500-10599)  
cs.s = aq; // Tile graphics (10600-10699)
cn.m.a(mapID, new fd(aq)); // Main cache
```

## 📍 **Map "Ngôi Làng Nhỏ" Details**

**Đặc điểm:**
- Làng nhỏ với các tòa nhà
- Có hệ thống đường xá (tiles 2E-32)
- Có nguồn nước (tiles 05-06, 0D-0E)
- Cầu bắc qua nước (tiles 22-23)
- Khu vực trang trí (tiles 35-3B)

**NPCs/Objects:** ~77 entities
**Map Type:** Village/town area
**Navigation:** Waypoint-based movement system

## 🚀 **Kết Luận**

Map data của HsoMobi sử dụng binary format hiệu quả với:
1. **Header** chứa map metadata và tên
2. **Tile data** packed với values 0-63  
3. **Object coordinates** cho NPCs và interactive elements
4. **Effect/dialogue data** ở cuối
5. **Separator 0xFF** phân chia sections

Format này optimized cho J2ME devices với memory constraints, sử dụng compact representation và efficient parsing.