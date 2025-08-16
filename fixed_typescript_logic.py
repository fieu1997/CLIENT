#!/usr/bin/env python3
"""
Fixed Python Implementation Following TypeScript Logic EXACTLY
Rewrite Python theo logic TypeScript working code để đảm bảo hoạt động
"""

import struct
import io

class MapData:
    def __init__(self):
        self.map_name = ""
        self.map_version = 0
        self.width = 0
        self.height = 0
        self.tileset_id = 0
        self.tile_map = []
        self.vgos = []
        self.effect_objects = []
        self.eff_data = []
        self.internal_vgo_count = None

class EffectObject:
    def __init__(self, template_id, x, y):
        self.template_id = template_id
        self.x = x
        self.y = y
        self.text = ""
        self.name = f"Effect ID: {template_id}"

class Vgo:
    def __init__(self, x, y, name, map_go_id):
        self.x = x
        self.y = y
        self.name = name
        self.map_go_id = map_go_id
        self.x_new = 0
        self.y_new = 0

class EffData:
    def __init__(self, id_val, x, y, name, text, raw):
        self.id = id_val
        self.x = x
        self.y = y
        self.name = name
        self.text = text
        self.raw = raw

class BinaryReader:
    """EXACT copy of TypeScript BinaryReader logic"""
    def __init__(self, buffer):
        self.buffer = buffer
        self.offset = 0
        
    def read_byte(self):
        """readByte(): number"""
        if self.offset >= len(self.buffer):
            raise IndexError("End of buffer")
        val = struct.unpack('>b', self.buffer[self.offset:self.offset+1])[0]
        self.offset += 1
        return val
    
    def read_short(self):
        """readShort(): number (signed)"""
        val = struct.unpack('>h', self.buffer[self.offset:self.offset+2])[0]
        self.offset += 2
        return val
        
    def read_ushort(self):
        """readUShort(): number (unsigned)"""
        val = struct.unpack('>H', self.buffer[self.offset:self.offset+2])[0]
        self.offset += 2
        return val
        
    def read_utf(self):
        """readUTF(): string - Java Modified UTF-8"""
        length = self.read_ushort()
        utf_bytes = self.buffer[self.offset:self.offset+length]
        self.offset += length
        return utf_bytes.decode('utf-8')
        
    def read_bytes(self, num):
        """readBytes(num): Uint8Array"""
        if self.offset + num > len(self.buffer):
            raise IndexError("Not enough bytes")
        data = self.buffer[self.offset:self.offset+num]
        self.offset += num
        return data
        
    def seek(self, offset, from_type='start'):
        """seek(offset, from)"""
        if from_type == 'start':
            self.offset = offset
        else:  # current
            self.offset += offset
            
    def eof(self):
        """get eof(): boolean"""
        return self.offset >= len(self.buffer)
        
    def get_buffer(self):
        """getBuffer(): ArrayBuffer"""
        return self.buffer
        
    def get_int8_at(self, offset):
        """getInt8At(offset): number"""
        return struct.unpack('>b', self.buffer[offset:offset+1])[0]
        
    def get_uint8_at(self, offset):
        """getUint8At(offset): number"""
        return struct.unpack('>B', self.buffer[offset:offset+1])[0]

class BinaryWriter:
    """EXACT copy of TypeScript BinaryWriter logic"""
    def __init__(self):
        self.byte_list = []
        
    def write_byte(self, value):
        """writeByte(value)"""
        self.byte_list.append(value & 0xFF)
        
    def write_short(self, value):
        """writeShort(value)"""
        data = struct.pack('>h', value)
        self.byte_list.extend(data)
        
    def write_utf(self, text):
        """writeUTF(str)"""
        encoded = text.encode('utf-8')
        self.write_short(len(encoded))
        self.byte_list.extend(encoded)
        
    def write_bytes(self, data):
        """writeBytes(bytes)"""
        self.byte_list.extend(data)
        
    def get_buffer(self):
        """getBuffer(): ArrayBuffer"""
        return bytes(self.byte_list)

def load_map_typescript_logic(buffer):
    """
    EXACT copy of TypeScript handleMapFile logic
    Following line-by-line implementation
    """
    print("🔄 Loading map using TypeScript logic...")
    
    map_data = MapData()
    reader = BinaryReader(buffer)
    
    # Part 1: Read map header and tile data (EXACT TypeScript logic)
    reader.seek(2)  # Skip padding
    map_data.map_name = reader.read_utf()
    map_data.map_version = reader.read_short()
    map_data.width = reader.read_byte()
    map_data.height = reader.read_byte()
    map_data.tileset_id = reader.read_byte()
    
    print(f"📋 Map info: {map_data.map_name} ({map_data.width}x{map_data.height})")
    print(f"📋 Version: 0x{map_data.map_version:04X}, Tileset: {map_data.tileset_id}")
    
    # Read tiles
    tile_data = reader.read_bytes(map_data.width * map_data.height)
    for y in range(map_data.height):
        row = []
        for x in range(map_data.width):
            row.append(tile_data[y * map_data.width + x])
        map_data.tile_map.append(row)
    
    print(f"📋 Read {len(tile_data)} tiles")
    
    # Part 2: Skip separator (EXACT TypeScript logic)
    if not reader.eof() and reader.get_int8_at(reader.offset) == -1:
        reader.read_byte()
        print("📋 Skipped separator (0xFF)")
    
    # Part 3: Read Object Block (EXACT TypeScript logic)
    if not reader.eof():
        object_block_length = reader.read_short()
        object_block_start_offset = reader.offset
        
        # Create separate reader for object block
        object_block_buffer = reader.get_buffer()[object_block_start_offset:object_block_start_offset + object_block_length]
        object_reader = BinaryReader(object_block_buffer)
        
        print(f"📦 Object block length: {object_block_length} bytes")
        
        # Read icons
        num_icons = object_reader.read_short()
        for i in range(num_icons):
            if object_reader.offset + 6 > len(object_block_buffer):
                break
            template_id = object_reader.read_short()
            x = object_reader.read_short() * 24  # TILE_SIZE = 24
            y = object_reader.read_short() * 24
            map_data.effect_objects.append(EffectObject(template_id, x, y))
        
        print(f"📦 Read {len(map_data.effect_objects)} decorative objects")
        
        # Read internal VGO count
        if object_reader.offset + 2 <= len(object_reader.get_buffer()):
            map_data.internal_vgo_count = object_reader.read_short()
            print(f"📦 Internal VGO count: {map_data.internal_vgo_count}")
        else:
            map_data.internal_vgo_count = 0
        
        # Search for eff magic and VGOs (EXACT TypeScript logic)
        eff_magic = [0x03, 0x65, 0x66, 0x66]
        while not object_reader.eof():
            current_offset = object_reader.offset
            if current_offset + 4 > len(object_reader.get_buffer()):
                break
                
            # Check for eff magic
            is_eff = (object_reader.get_uint8_at(current_offset) == eff_magic[0] and
                     object_reader.get_uint8_at(current_offset + 1) == eff_magic[1] and
                     object_reader.get_uint8_at(current_offset + 2) == eff_magic[2] and
                     object_reader.get_uint8_at(current_offset + 3) == eff_magic[3])
            
            if is_eff:
                object_reader.seek(4, 'current')
                try:
                    data_length = object_reader.read_byte()
                    if object_reader.offset + data_length > len(object_reader.get_buffer()):
                        break
                    eff_string_bytes = object_reader.read_bytes(data_length)
                    eff_string = eff_string_bytes.decode('utf-8')
                    parts = eff_string.split(';')
                    if len(parts) >= 4:
                        eff_id = int(parts[1])
                        eff_x = int(parts[2]) * 24
                        eff_y = int(parts[3]) * 24
                        map_data.eff_data.append(EffData(eff_id, eff_x, eff_y, f"Eff ID: {eff_id}", f"Eff: {eff_id}", eff_string))
                except:
                    break
            elif len(object_reader.get_buffer()) - current_offset >= 5:
                try:
                    vgo_x = object_reader.read_short()
                    vgo_y = object_reader.read_short()
                    vgo_type = object_reader.read_byte()
                    
                    if vgo_type == 0:
                        name_length = object_reader.read_byte()
                        name_bytes = object_reader.read_bytes(name_length)
                        name = name_bytes.decode('utf-8')
                    elif vgo_type == 1:
                        name = object_reader.read_utf()
                    else:
                        break
                        
                    map_data.vgos.append(Vgo(vgo_x, vgo_y, name, vgo_type + 1))
                except:
                    break
            else:
                break
        
        print(f"📦 Read {len(map_data.vgos)} VGOs and {len(map_data.eff_data)} eff blocks")
        
        # Move main reader past object block
        reader.seek(object_block_start_offset + object_block_length, 'start')
    
    # Part 4: Read External VGO data (EXACT TypeScript logic)
    if not reader.eof():
        try:
            vgo_count = reader.read_byte()
            if 0 < vgo_count < 100:
                for i in range(vgo_count):
                    x = reader.read_short()
                    y = reader.read_short()
                    name = reader.read_utf()
                    map_data.vgos.append(Vgo(x, y, name, 100))
                print(f"📦 Read {vgo_count} external VGOs")
        except:
            pass  # No external VGO block
    
    print("✅ Map loading completed successfully")
    return map_data

def save_map_typescript_logic(map_data):
    """
    EXACT copy of TypeScript handleSaveMap logic
    Following line-by-line implementation
    """
    print("💾 Saving map using TypeScript logic...")
    
    writer = BinaryWriter()
    
    # Part 1: Header and Tile Data (EXACT TypeScript logic)
    writer.write_short(0)  # Padding
    writer.write_utf(map_data.map_name)
    writer.write_short(map_data.map_version)
    writer.write_byte(map_data.width)
    writer.write_byte(map_data.height)
    writer.write_byte(map_data.tileset_id)
    
    # Flatten tile map
    for row in map_data.tile_map:
        for tile in row:
            writer.write_byte(tile)
    
    print("💾 Wrote header and tile data")
    
    # Part 2: Separator (EXACT TypeScript logic)
    writer.write_byte(-1)  # 0xFF separator
    
    # Part 3: Object Data Block (EXACT TypeScript logic)
    object_writer = BinaryWriter()
    
    # Write effect objects
    object_writer.write_short(len(map_data.effect_objects))
    for obj in map_data.effect_objects:
        object_writer.write_short(obj.template_id)
        object_writer.write_short(round(obj.x // 24))
        object_writer.write_short(round(obj.y // 24))
    
    # Write internal VGO count
    object_writer.write_short(map_data.internal_vgo_count or 0)
    
    # Write internal VGOs
    internal_vgos = [vgo for vgo in map_data.vgos if vgo.map_go_id < 100]
    for vgo in internal_vgos:
        vgo_type = vgo.map_go_id - 1
        object_writer.write_short(vgo.x)
        object_writer.write_short(vgo.y)
        object_writer.write_byte(vgo_type)
        
        if vgo_type == 0:
            name_bytes = vgo.name.encode('utf-8')
            object_writer.write_byte(len(name_bytes))
            object_writer.write_bytes(name_bytes)
        else:
            object_writer.write_utf(vgo.name)
    
    # Write eff data
    for eff in map_data.eff_data:
        object_writer.write_bytes([0x03, 0x65, 0x66, 0x66])  # Magic
        eff_string_bytes = eff.raw.encode('utf-8')
        object_writer.write_byte(len(eff_string_bytes))
        object_writer.write_bytes(eff_string_bytes)
    
    # Get object block content and write it to main writer
    object_buffer = object_writer.get_buffer()
    writer.write_short(len(object_buffer))
    writer.write_bytes(object_buffer)
    
    print(f"💾 Wrote object block ({len(object_buffer)} bytes)")
    
    # Part 4: External VGO data (EXACT TypeScript logic)
    external_vgos = [vgo for vgo in map_data.vgos if vgo.map_go_id >= 100]
    if external_vgos:
        writer.write_byte(len(external_vgos))
        for vgo in external_vgos:
            writer.write_short(vgo.x)
            writer.write_short(vgo.y)
            writer.write_utf(vgo.name)
        print(f"💾 Wrote {len(external_vgos)} external VGOs")
    
    # Part 5: EOF Marker (EXACT TypeScript logic)
    writer.write_byte(-1)  # 0xFF EOF
    print("💾 Wrote EOF marker")
    
    return writer.get_buffer()

def test_typescript_logic():
    """Test fixed implementation với working data"""
    print("🧪 TESTING FIXED PYTHON IMPLEMENTATION")
    print("=" * 50)
    
    # Load working original data
    with open('complete_working_format.dat', 'rb') as f:
        working_data = f.read()
    
    print(f"📁 Loaded working data: {len(working_data)} bytes")
    
    # Parse using TypeScript logic
    map_data = load_map_typescript_logic(working_data)
    
    # Save using TypeScript logic
    saved_data = save_map_typescript_logic(map_data)
    
    print(f"📁 Generated data: {len(saved_data)} bytes")
    
    # Compare
    if len(saved_data) == len(working_data):
        print("✅ Size matches!")
    else:
        print(f"❌ Size mismatch: {len(saved_data)} vs {len(working_data)}")
    
    # Check exact match
    differences = 0
    for i in range(min(len(saved_data), len(working_data))):
        if saved_data[i] != working_data[i]:
            differences += 1
            if differences <= 10:  # Show first 10 differences
                print(f"   Byte {i}: 0x{saved_data[i]:02X} vs 0x{working_data[i]:02X}")
    
    if differences == 0:
        print("🎉 PERFECT MATCH! Generated data is identical to working original!")
    else:
        print(f"❌ Found {differences} byte differences")
    
    # Save fixed version
    with open('typescript_logic_fixed.dat', 'wb') as f:
        f.write(saved_data)
    
    print(f"💾 Saved fixed version: typescript_logic_fixed.dat")

if __name__ == "__main__":
    test_typescript_logic()