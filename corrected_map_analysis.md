# HsoMobi Map Data - Phân Tích Chính Xác (Dựa Trên Code)

## 🔍 **Cấu Trúc Thực Tế Của Map Data**

Dựa trên code TypeScript Map Viewer, cấu trúc thực sự của file map HsoMobi như sau:

### 📊 **Format Chính Xác**

```typescript
// Cấu trúc MapData class
class MapData {
    mapName = "";           // Tên map (UTF-8 string)
    mapVersion = 0;         // Version của map (short)
    width = 0;              // Chiều rộng (byte)
    height = 0;             // Chiều cao (byte) 
    tilesetId = -1;         // ID của tileset (byte)
    tileMap: number[][];    // Ma trận tiles 2D
    vgos: Vgo[];           // VGO objects (warps/portals)
    effectObjects: EffectObject[]; // Decorative objects
    effData: EffData[];     // Effect data blocks
}
```

### 🗂️ **Cấu Trúc File Binary**

#### **Part 1: Header & Tile Data**
```
[00-01] 2 bytes     - Skip/padding (0x00 0x00)
[02-XX] UTF String  - Map name (length-prefixed)
[XX+0]  2 bytes     - Map version (short, big-endian)
[XX+2]  1 byte      - Width
[XX+3]  1 byte      - Height  
[XX+4]  1 byte      - Tileset ID
[XX+5]  W*H bytes   - Tile data (row by row)
```

#### **Part 2: Separator**
```
[XX] 1 byte - 0xFF separator
```

#### **Part 3: Object Block**
```
[XX+0] 2 bytes - Object block length
[XX+2] 2 bytes - Number of effect objects (icons)
[XX+4] N*6 bytes - Effect objects:
    [0-1] templateId (short)
    [2-3] x position in tiles (short) 
    [4-5] y position in tiles (short)

[XX] 2 bytes - Internal VGO count
[XX] Variable - Internal VGOs:
    [0-1] x (short)
    [2-3] y (short) 
    [4]   type (byte): 0 or 1
    [5+]  name (byte-length + bytes OR UTF string)

[XX] Variable - Eff blocks:
    [0-3] Magic: 0x03 0x65 0x66 0x66 ("eff")
    [4]   length (byte)
    [5+]  eff string data
```

#### **Part 4: External VGOs** 
```
[XX] 1 byte - External VGO count
[XX] Variable - External VGOs:
    [0-1] x (short)
    [2-3] y (short)
    [4+]  name (UTF string)
```

#### **Part 5: EOF**
```
[XX] 1 byte - 0xFF EOF marker
```

## 🎯 **Phân Tích Data Của Bạn**

Áp dụng format chính xác vào data của bạn:

```
00 00 00 11 - Skip + Map ID sai (thực ra là skip + map name length)
```

**Thực tế:**
```
00 00           - Skip padding  
00 11           - Map name length = 17 bytes
4E 67...8F      - "Ngôi Làng Nhỏ" (17 bytes UTF-8)
06              - Map version (low byte) 
CF              - Map version (high byte) → 0x06CF = 1743
3A              - Width = 58 tiles
1E              - Height = 30 tiles  
00              - Tileset ID = 0
```

**Tile Data:** 58 × 30 = 1,740 bytes tiếp theo

**Objects:** Sau separator 0xFF

## 🔧 **Object Types**

### **1. Effect Objects (Icons)**
- **Template ID:** Numeric ID for decorative sprites
- **Position:** Tile coordinates (converted to pixels × 24)
- **Purpose:** Visual decorations, trees, rocks, buildings

### **2. VGOs (Warps/Portals)**
- **Type 0:** Internal warps (byte-length name)
- **Type 1:** Internal warps (UTF string name)  
- **Type 100+:** External warps to other maps
- **Purpose:** Map transitions, teleportation

### **3. Eff Data**
- **Magic:** Always starts with "eff" (0x03656666)
- **Format:** `id;x;y;...` semicolon-separated
- **Purpose:** Special effects, triggers, scripts

## 🎮 **Game Logic Integration**

### **CMD -51 Usage**
```java
// Server gửi map data qua cmd -51
if (s >= 10600) {
    cs.s = aq;  // Tile graphics data
    ft.q.a();   // Process map loading
    return;
}
```

### **Rendering**
- **Tile Size:** 24×24 pixels constant
- **Layer Order:** Tiles → Effects → VGOs → Eff blocks
- **Coordinates:** Tile positions × 24 = pixel positions

## 📝 **Ví Dụ Parsing**

```typescript
// Parse header 
reader.seek(2);  // Skip padding
mapName = reader.readUTF();
mapVersion = reader.readShort(); 
width = reader.readByte();
height = reader.readByte();
tilesetId = reader.readByte();

// Parse tiles
tileData = reader.readBytes(width * height);

// Parse objects after 0xFF separator
if (reader.readByte() === -1) {
    objectBlockLength = reader.readShort();
    // ... parse objects
}
```

## 🔍 **So Sánh Với Phân Tích Cũ**

| Aspect | Phân Tích Cũ | Thực Tế |
|--------|--------------|---------|
| Map ID | 4 bytes đầu | Là skip + name length |
| Map Name | Sau Map ID | Ngay sau skip |  
| Dimensions | Không xác định | Width/Height bytes |
| Tile Values | 0-63 | 0-255 (any byte value) |
| Objects | Coordinates pairs | Structured objects với types |
| Format | Compressed/packed | Raw binary với clear structure |

## ✅ **Kết Luận**

Code TypeScript này cho thấy format thực sự của HsoMobi maps:
- **Clear binary structure** với các sections được định nghĩa rõ ràng
- **Multiple object types** cho gameplay features khác nhau  
- **Tile-based coordinates** với conversion sang pixels
- **UTF-8 strings** cho tên maps và objects
- **Version tracking** cho map compatibility

Cảm ơn bạn đã chia sẻ code này - nó cho thấy importance của việc có reference implementation để hiểu đúng binary formats!