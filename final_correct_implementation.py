#!/usr/bin/env python3
"""
Final Correct Implementation
Dựa trên discovery: Little endian, no separator, no object block length
"""

import struct

class MapData:
    def __init__(self):
        self.map_name = ""
        self.map_version = 0
        self.width = 0
        self.height = 0
        self.tileset_id = 0
        self.tile_map = []
        self.effect_objects = []
        self.eff_data = []
        self.vgos = []
        self.internal_vgo_count = None

class EffectObject:
    def __init__(self, template_id, x, y):
        self.template_id = template_id
        self.x = x
        self.y = y

class EffData:
    def __init__(self, id_val, x, y, raw):
        self.id = id_val
        self.x = x
        self.y = y
        self.raw = raw

class Vgo:
    def __init__(self, x, y, name, map_go_id):
        self.x = x
        self.y = y
        self.name = name
        self.map_go_id = map_go_id

def load_map_correct_format(buffer):
    """Load map với format đúng đã discover"""
    print("🔄 Loading map with CORRECT format...")
    
    map_data = MapData()
    offset = 0
    
    # Header (BIG ENDIAN for header)
    offset += 2  # Skip padding
    
    name_len = int.from_bytes(buffer[offset:offset+2], 'big')
    offset += 2
    map_data.map_name = buffer[offset:offset+name_len].decode('utf-8')
    offset += name_len
    
    map_data.map_version = int.from_bytes(buffer[offset:offset+2], 'big', signed=True)
    offset += 2
    
    map_data.width = buffer[offset]
    map_data.height = buffer[offset + 1]
    map_data.tileset_id = buffer[offset + 2]
    offset += 3
    
    print(f"📋 Map: '{map_data.map_name}' {map_data.width}x{map_data.height}")
    print(f"📋 Version: 0x{map_data.map_version:04X}, Tileset: {map_data.tileset_id}")
    
    # Tiles
    tiles_count = map_data.width * map_data.height
    tile_data = buffer[offset:offset + tiles_count]
    for y in range(map_data.height):
        row = []
        for x in range(map_data.width):
            row.append(tile_data[y * map_data.width + x])
        map_data.tile_map.append(row)
    offset += tiles_count
    
    print(f"📋 Read {tiles_count} tiles")
    
    # Object data starts immediately (NO SEPARATOR, NO BLOCK LENGTH)
    # USE LITTLE ENDIAN FOR OBJECT DATA
    print(f"📦 Object data starts at offset {offset}")
    
    # Read icon count (LITTLE ENDIAN)
    if offset + 2 <= len(buffer):
        icon_count = int.from_bytes(buffer[offset:offset+2], 'little')
        offset += 2
        print(f"📦 Icon count: {icon_count}")
        
        # Read icons (LITTLE ENDIAN)
        for i in range(icon_count):
            if offset + 6 <= len(buffer):
                template_id = int.from_bytes(buffer[offset:offset+2], 'little')
                x = int.from_bytes(buffer[offset+2:offset+4], 'little')
                y = int.from_bytes(buffer[offset+4:offset+6], 'little')
                map_data.effect_objects.append(EffectObject(template_id, x, y))
                offset += 6
            else:
                break
        
        print(f"📦 Read {len(map_data.effect_objects)} icons")
        
        # Read internal VGO count (LITTLE ENDIAN)
        if offset + 2 <= len(buffer):
            map_data.internal_vgo_count = int.from_bytes(buffer[offset:offset+2], 'little')
            offset += 2
            print(f"📦 Internal VGO count: {map_data.internal_vgo_count}")
            
            # Search for eff pattern
            remaining = buffer[offset:]
            eff_magic = b'\x03eff'
            eff_positions = []
            search_offset = 0
            
            while True:
                pos = remaining.find(eff_magic, search_offset)
                if pos == -1:
                    break
                eff_positions.append(offset + pos)
                search_offset = pos + 1
            
            print(f"📦 Found {len(eff_positions)} eff patterns")
            
            # Parse eff data
            for eff_abs_pos in eff_positions:
                if eff_abs_pos + 5 < len(buffer):
                    data_length = buffer[eff_abs_pos + 4]
                    if eff_abs_pos + 5 + data_length <= len(buffer):
                        eff_string = buffer[eff_abs_pos + 5:eff_abs_pos + 5 + data_length].decode('utf-8')
                        parts = eff_string.split(';')
                        if len(parts) >= 4:
                            try:
                                eff_id = int(parts[1])
                                eff_x = int(parts[2])
                                eff_y = int(parts[3])
                                map_data.eff_data.append(EffData(eff_id, eff_x, eff_y, eff_string))
                            except:
                                pass
            
            print(f"📦 Read {len(map_data.eff_data)} eff blocks")
    
    # Find external VGOs (work backwards from EOF)
    if buffer[-1] == 0xFF:
        # Find external VGO section
        for test_start in range(len(buffer) - 50, len(buffer) - 1):
            if test_start < 0:
                continue
                
            try:
                vgo_count = buffer[test_start]
                if 0 < vgo_count < 10:
                    vgo_offset = test_start + 1
                    external_vgos = []
                    success = True
                    
                    for i in range(vgo_count):
                        if vgo_offset + 4 >= len(buffer):
                            success = False
                            break
                            
                        x = int.from_bytes(buffer[vgo_offset:vgo_offset+2], 'big')  # External VGOs use big endian
                        y = int.from_bytes(buffer[vgo_offset+2:vgo_offset+4], 'big')
                        vgo_offset += 4
                        
                        if vgo_offset + 2 >= len(buffer):
                            success = False
                            break
                            
                        name_len = int.from_bytes(buffer[vgo_offset:vgo_offset+2], 'big')
                        vgo_offset += 2
                        
                        if vgo_offset + name_len >= len(buffer):
                            success = False
                            break
                            
                        name = buffer[vgo_offset:vgo_offset+name_len].decode('utf-8')
                        vgo_offset += name_len
                        external_vgos.append(Vgo(x, y, name, 100))
                    
                    if success and vgo_offset == len(buffer) - 1:
                        map_data.vgos.extend(external_vgos)
                        print(f"📦 Read {len(external_vgos)} external VGOs")
                        break
            except:
                continue
    
    print("✅ Map loading completed successfully")
    return map_data

def save_map_correct_format(map_data):
    """Save map với format đúng"""
    print("💾 Saving map with CORRECT format...")
    
    buffer = bytearray()
    
    # Header (BIG ENDIAN)
    buffer.extend(struct.pack('>H', 0))  # Padding
    
    name_bytes = map_data.map_name.encode('utf-8')
    buffer.extend(struct.pack('>H', len(name_bytes)))
    buffer.extend(name_bytes)
    
    buffer.extend(struct.pack('>h', map_data.map_version))
    buffer.append(map_data.width)
    buffer.append(map_data.height)
    buffer.append(map_data.tileset_id)
    
    # Tiles
    for row in map_data.tile_map:
        for tile in row:
            buffer.append(tile)
    
    print("💾 Wrote header and tiles")
    
    # Object data (LITTLE ENDIAN, NO SEPARATOR, NO BLOCK LENGTH)
    # Icon count (LITTLE ENDIAN)
    buffer.extend(struct.pack('<H', len(map_data.effect_objects)))
    
    # Icons (LITTLE ENDIAN)
    for obj in map_data.effect_objects:
        buffer.extend(struct.pack('<H', obj.template_id))
        buffer.extend(struct.pack('<H', obj.x))
        buffer.extend(struct.pack('<H', obj.y))
    
    # Internal VGO count (LITTLE ENDIAN)
    buffer.extend(struct.pack('<H', map_data.internal_vgo_count or 0))
    
    # Eff data
    for eff in map_data.eff_data:
        buffer.extend(b'\x03eff')  # Magic
        eff_bytes = eff.raw.encode('utf-8')
        buffer.append(len(eff_bytes))
        buffer.extend(eff_bytes)
    
    print("💾 Wrote object data")
    
    # External VGOs (BIG ENDIAN)
    external_vgos = [vgo for vgo in map_data.vgos if vgo.map_go_id >= 100]
    if external_vgos:
        buffer.append(len(external_vgos))
        for vgo in external_vgos:
            buffer.extend(struct.pack('>H', vgo.x))
            buffer.extend(struct.pack('>H', vgo.y))
            name_bytes = vgo.name.encode('utf-8')
            buffer.extend(struct.pack('>H', len(name_bytes)))
            buffer.extend(name_bytes)
        print(f"💾 Wrote {len(external_vgos)} external VGOs")
    
    # EOF
    buffer.append(0xFF)
    print("💾 Wrote EOF marker")
    
    return bytes(buffer)

def test_final_implementation():
    """Test final implementation"""
    print("🧪 TESTING FINAL CORRECT IMPLEMENTATION")
    print("=" * 50)
    
    # Load working data
    with open('complete_working_format.dat', 'rb') as f:
        working_data = f.read()
    
    print(f"📁 Loaded working data: {len(working_data)} bytes")
    
    # Parse with correct format
    map_data = load_map_correct_format(working_data)
    
    # Save with correct format
    saved_data = save_map_correct_format(map_data)
    
    print(f"📁 Generated data: {len(saved_data)} bytes")
    
    # Compare
    if len(saved_data) == len(working_data):
        print("✅ Size matches!")
        
        # Check exact match
        differences = 0
        for i in range(len(saved_data)):
            if saved_data[i] != working_data[i]:
                differences += 1
                if differences <= 10:
                    print(f"   Byte {i}: 0x{saved_data[i]:02X} vs 0x{working_data[i]:02X}")
        
        if differences == 0:
            print("🎉 PERFECT MATCH! Generated data is identical to working original!")
        else:
            print(f"❌ Found {differences} byte differences")
    else:
        print(f"❌ Size mismatch: {len(saved_data)} vs {len(working_data)}")
    
    # Save result
    with open('final_correct_implementation.dat', 'wb') as f:
        f.write(saved_data)
    
    print(f"💾 Saved result: final_correct_implementation.dat")

if __name__ == "__main__":
    test_final_implementation()