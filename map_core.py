#!/usr/bin/env python3
"""
HSO Map Core Classes
Core map parsing và writing classes không có UI dependencies
Để sử dụng trong testing và server-side processing
"""

import struct
import binascii

TILE_SIZE = 24

# Map name lookup table from df.java  
MAP_NAMES = [
    "Ngôi Làng Nhỏ", "Làng Sói Trắng", "Khu mỏ", "Bìa Rừng", "Hang Lửa", 
    "Rừng Ảo Giác", "Khe Vực", "Cánh Đồng Sói", "Thung Lũng Kỳ Bí", "Hồ Ký Ức",
    "Bãi Đất Trống", "Bờ Biển", "Vực Đá", "Rặng Đá Ngầm", "Nghĩa Địa Tàu Đắm",
    "Đầm Lầy", "Đền Cổ", "Hang Dơi", "Hang Sói Quỷ", "Cửa Biển",
    "Sa Mạc", "Đồi Cát", "Vực Lún", "Hố Tử Thần", "Nghĩa địa cát",
    "Rừng Chết", "Suối Ma", "Thung Lũng Đá", "Boss Guardian", "Hầm Mộ Tầng 1",
    "Hầm Mộ Tầng 2", "Hầm Mộ Tầng 3", "Hầm mộ quái vật", "Thành Phố Kho Báu", 
    "Khu phía Tây", "Khu phía Đông", "Đấu Trường", "Rừng cao nguyên", 
    "Con đường hiểm trở", "Vách đá cheo leo"
]

class MapData:
    def __init__(self):
        self.name = ""
        self.version = 0
        self.width = 0
        self.height = 0
        self.tileset_id = 0
        self.tiles = []
        self.decorative_icons = []  # Renamed from effect_objects for clarity
        self.internal_vgos = []     # Internal warps 
        self.effect_triggers = []   # Renamed from eff_data for clarity
        self.map_warps = []         # Renamed from external_vgos for clarity

class MapParser:
    def __init__(self, data):
        self.data = data
        self.offset = 0
        
    def read_byte(self):
        result = struct.unpack('b', self.data[self.offset:self.offset+1])[0]
        self.offset += 1
        return result
        
    def read_ubyte(self):
        result = self.data[self.offset]
        self.offset += 1
        return result
        
    def read_short(self):
        result = struct.unpack('>h', self.data[self.offset:self.offset+2])[0]
        self.offset += 2
        return result
        
    def read_ushort(self):
        result = struct.unpack('>H', self.data[self.offset:self.offset+2])[0]
        self.offset += 2
        return result
        
    def read_utf(self):
        length = self.read_ushort()
        if length > len(self.data) - self.offset:
            raise ValueError(f"String length {length} exceeds remaining data")
        result = self.data[self.offset:self.offset+length].decode('utf-8')
        self.offset += length
        return result
        
    def read_bytes(self, count):
        result = self.data[self.offset:self.offset+count]
        self.offset += count
        return result
        
    def seek(self, offset, from_start=True):
        if from_start:
            self.offset = offset
        else:
            self.offset += offset
            
    def eof(self):
        return self.offset >= len(self.data)
        
    def get_byte_at(self, offset):
        return struct.unpack('b', self.data[offset:offset+1])[0]
        
    def parse(self):
        map_data = MapData()
        
        try:
            # Skip padding
            self.seek(2)
            
            # Read header
            map_data.name = self.read_utf()
            map_data.version = self.read_short()
            map_data.width = self.read_ubyte()
            map_data.height = self.read_ubyte()
            map_data.tileset_id = self.read_ubyte()
            
            # Read tile data
            tile_count = map_data.width * map_data.height
            tile_data = []
            for i in range(tile_count):
                tile_data.append(self.read_ubyte())
                
            # Convert to 2D array
            for y in range(map_data.height):
                row = tile_data[y * map_data.width:(y + 1) * map_data.width]
                map_data.tiles.append(row)
                
            # Check for separator
            if not self.eof() and self.get_byte_at(self.offset) == -1:
                self.read_byte()  # Skip separator
                
            # Parse object block
            if not self.eof():
                object_block_length = self.read_short()
                object_block_start = self.offset
                
                # Decorative Icons (Effect Objects)
                num_icons = self.read_short()
                for i in range(num_icons):
                    if self.offset + 6 > object_block_start + object_block_length:
                        break
                    template_id = self.read_short()
                    x = self.read_short()
                    y = self.read_short()
                    map_data.decorative_icons.append({
                        'template_id': template_id,
                        'x': x * TILE_SIZE,  # Convert to pixels like TypeScript
                        'y': y * TILE_SIZE,  # Convert to pixels like TypeScript
                        'name': f'Icon ID: {template_id}'
                    })
                    
                # Internal VGO count
                if self.offset + 2 <= object_block_start + object_block_length:
                    internal_vgo_count = self.read_short()
                
                # Parse Internal VGOs and Effect Triggers
                while self.offset < object_block_start + object_block_length:
                    # Check for effect trigger magic
                    if (self.offset + 4 <= object_block_start + object_block_length and
                        self.data[self.offset:self.offset+4] == b'\x03eff'):
                        
                        self.offset += 4  # Skip magic
                        try:
                            data_length = self.read_ubyte()
                            if self.offset + data_length <= object_block_start + object_block_length:
                                eff_string_bytes = self.read_bytes(data_length)
                                eff_string = eff_string_bytes.decode('utf-8', errors='replace')
                                
                                parts = eff_string.split(';')
                                if len(parts) >= 4:
                                    try:
                                        eff_id = int(parts[1])
                                        eff_x = int(parts[2])
                                        eff_y = int(parts[3])
                                        map_data.effect_triggers.append({
                                            'id': eff_id,
                                            'x': eff_x * TILE_SIZE,  # Convert to pixels
                                            'y': eff_y * TILE_SIZE,  # Convert to pixels
                                            'name': f'Trigger ID: {eff_id}',
                                            'raw': eff_string
                                        })
                                    except (ValueError, IndexError):
                                        pass
                            else:
                                break
                        except:
                            break
                            
                    elif self.offset + 5 <= object_block_start + object_block_length:
                        # Try to parse Internal VGO
                        try:
                            vgo_x = self.read_short()
                            vgo_y = self.read_short()
                            vgo_type = self.read_ubyte()
                            
                            if vgo_type == 0:
                                name_length = self.read_ubyte()
                                if self.offset + name_length <= object_block_start + object_block_length:
                                    name_bytes = self.read_bytes(name_length)
                                    name = name_bytes.decode('utf-8', errors='replace')
                                else:
                                    break
                            elif vgo_type == 1:
                                if self.offset + 2 <= object_block_start + object_block_length:
                                    name = self.read_utf()
                                else:
                                    break
                            else:
                                break
                                
                            map_data.internal_vgos.append({
                                'x': vgo_x * TILE_SIZE,  # Convert to pixels
                                'y': vgo_y * TILE_SIZE,  # Convert to pixels
                                'name': name,
                                'type': vgo_type
                            })
                            
                        except:
                            break
                    else:
                        break
                        
                # Skip to end of object block
                self.seek(object_block_start + object_block_length)
                
            # Parse Map Warps (External VGOs)
            if not self.eof():
                try:
                    map_warp_count = self.read_ubyte()
                    if 0 < map_warp_count < 100:
                        for i in range(map_warp_count):
                            if self.eof():
                                break
                            x = self.read_short()
                            y = self.read_short()
                            dest_map_name = self.read_utf()
                            
                            # Try to find map ID from name
                            map_id = -1
                            try:
                                map_id = MAP_NAMES.index(dest_map_name)
                            except ValueError:
                                pass
                                
                            map_data.map_warps.append({
                                'x': x,  # Already in pixels from TypeScript code
                                'y': y,  # Already in pixels from TypeScript code
                                'dest_map_name': dest_map_name,
                                'dest_map_id': map_id
                            })
                except:
                    pass
                    
            return map_data
            
        except Exception as e:
            raise Exception(f"Parse error at offset {self.offset}: {e}")

class MapWriter:
    def __init__(self):
        self.data = bytearray()
        
    def write_byte(self, value):
        self.data.append(value & 0xFF)
        
    def write_ubyte(self, value):
        self.data.append(value & 0xFF)
        
    def write_short(self, value):
        self.data.extend(struct.pack('>h', value))
        
    def write_ushort(self, value):
        self.data.extend(struct.pack('>H', value))
        
    def write_utf(self, text):
        encoded = text.encode('utf-8')
        self.write_ushort(len(encoded))
        self.data.extend(encoded)
        
    def write_bytes(self, data):
        self.data.extend(data)
        
    def get_data(self):
        return bytes(self.data)
        
    def write_map_data(self, map_data):
        """Write map data in HSO binary format"""
        # Header padding
        self.write_ushort(0)
        
        # Map header
        self.write_utf(map_data.name)
        self.write_short(map_data.version)
        self.write_ubyte(map_data.width)
        self.write_ubyte(map_data.height)
        self.write_ubyte(map_data.tileset_id)
        
        # Tile data
        for row in map_data.tiles:
            for tile in row:
                self.write_ubyte(tile)
                
        # Separator
        self.write_byte(0xFF)
        
        # Object block
        object_writer = MapWriter()
        
        # Decorative icons count
        object_writer.write_short(len(map_data.decorative_icons))
        
        # Decorative icons data
        for icon in map_data.decorative_icons:
            object_writer.write_short(icon['template_id'])
            object_writer.write_short(icon['x'] // TILE_SIZE)  # Convert back to tile coords
            object_writer.write_short(icon['y'] // TILE_SIZE)
            
        # Internal VGO count
        object_writer.write_short(len(map_data.internal_vgos))
        
        # Internal VGOs
        for vgo in map_data.internal_vgos:
            object_writer.write_short(vgo['x'] // TILE_SIZE)  # Convert back to tile coords
            object_writer.write_short(vgo['y'] // TILE_SIZE)
            object_writer.write_ubyte(vgo['type'])
            
            if vgo['type'] == 0:
                name_bytes = vgo['name'].encode('utf-8')
                object_writer.write_ubyte(len(name_bytes))
                object_writer.write_bytes(name_bytes)
            elif vgo['type'] == 1:
                object_writer.write_utf(vgo['name'])
                
        # Effect triggers (eff data)
        for trigger in map_data.effect_triggers:
            object_writer.write_bytes(b'\x03eff')  # Magic
            eff_string = trigger['raw']
            eff_bytes = eff_string.encode('utf-8')
            object_writer.write_ubyte(len(eff_bytes))
            object_writer.write_bytes(eff_bytes)
            
        # Write object block length and data
        object_data = object_writer.get_data()
        self.write_short(len(object_data))
        self.write_bytes(object_data)
        
        # Map warps (external VGOs)
        if map_data.map_warps:
            self.write_ubyte(len(map_data.map_warps))
            for warp in map_data.map_warps:
                self.write_short(warp['x'])  # Already in pixels
                self.write_short(warp['y'])
                self.write_utf(warp['dest_map_name'])
                
        # EOF marker
        self.write_byte(0xFF)