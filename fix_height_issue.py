#!/usr/bin/env python3
"""
Fix Height Issue: 30 → 31
Sửa lỗi height của map từ 30 thành 31 như data gốc
"""

import binascii
import struct

# Data từ code (58x30 - SAI)
INCORRECT_CODE_DATA = "00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1E 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02"

class MapHeightFixer:
    def __init__(self):
        self.data = bytearray()
        
    def write_ushort(self, value):
        self.data.extend(struct.pack('>H', value))
        
    def write_short(self, value):
        self.data.extend(struct.pack('>h', value))
        
    def write_ubyte(self, value):
        self.data.append(value & 0xFF)
        
    def write_utf(self, text):
        encoded = text.encode('utf-8')
        self.write_ushort(len(encoded))
        self.data.extend(encoded)
        
    def get_data(self):
        return bytes(self.data)

def fix_height_from_30_to_31():
    """Fix height từ 30 thành 31 và thêm 1 row tiles"""
    print("🔧 Fixing Height Issue: 30 → 31")
    print("=" * 40)
    
    # Parse incorrect data (58x30)
    binary_data = binascii.unhexlify(INCORRECT_CODE_DATA.replace(' ', ''))
    print(f"Original data: {len(binary_data)} bytes")
    
    # Parse header
    offset = 2  # Skip padding
    name_len = int.from_bytes(binary_data[offset:offset+2], 'big')
    offset += 2
    map_name = binary_data[offset:offset+name_len].decode('utf-8')
    offset += name_len
    
    version = int.from_bytes(binary_data[offset:offset+2], 'big', signed=True)
    offset += 2
    
    width = binary_data[offset]
    height = binary_data[offset + 1]  # This is 30 (0x1E) - WRONG!
    tileset_id = binary_data[offset + 2]
    offset += 3
    
    print(f"Current map: '{map_name}' {width}x{height}, tileset {tileset_id}")
    print(f"Version: {version} (0x{version:04X})")
    
    # Extract existing tiles (58x30 = 1740 tiles)
    current_tiles = list(binary_data[offset:offset + width * height])
    print(f"Current tiles: {len(current_tiles)} (58x30)")
    
    # Create new row (58 tiles) - duplicate last row
    if len(current_tiles) >= width:
        last_row_start = len(current_tiles) - width
        last_row = current_tiles[last_row_start:]
        new_row = last_row[:]  # Copy last row
        print(f"Adding new row: {len(new_row)} tiles (copy of last row)")
    else:
        # Fallback: fill with tile 1 (grass)
        new_row = [1] * width
        print(f"Adding new row: {len(new_row)} tiles (fallback grass)")
    
    # Combined tiles (58x31 = 1798 tiles)
    fixed_tiles = current_tiles + new_row
    print(f"Fixed tiles: {len(fixed_tiles)} (58x31)")
    
    # Create corrected map
    fixer = MapHeightFixer()
    
    # Header with CORRECTED height
    fixer.write_ushort(0)  # Padding
    fixer.write_utf(map_name)
    fixer.write_short(version)
    fixer.write_ubyte(width)
    fixer.write_ubyte(31)  # FIXED HEIGHT: 30 → 31 (0x1E → 0x1F)
    fixer.write_ubyte(tileset_id)
    
    # All tiles (now 1798 instead of 1740)
    for tile in fixed_tiles:
        fixer.write_ubyte(tile)
        
    # Get final data
    fixed_binary = fixer.get_data()
    
    # Verify dimensions
    header_size = 2 + 2 + len(map_name.encode('utf-8')) + 2 + 3
    expected_size = header_size + (58 * 31)  # 1798 tiles
    
    print(f"\n📊 Fixed Map Verification:")
    print(f"   Header size: {header_size} bytes")
    print(f"   Tiles size: 58×31 = {58 * 31} bytes")
    print(f"   Expected total: {expected_size} bytes")
    print(f"   Actual size: {len(fixed_binary)} bytes")
    
    if len(fixed_binary) == expected_size:
        print(f"   ✅ Perfect size match!")
    else:
        print(f"   ❌ Size mismatch!")
        
    # Save fixed map
    with open('height_fixed_58x31.dat', 'wb') as f:
        f.write(fixed_binary)
        
    # Create hex version  
    with open('height_fixed_58x31.hex', 'w') as f:
        hex_string = binascii.hexlify(fixed_binary).decode('ascii')
        formatted_hex = ' '.join(hex_string[i:i+2] for i in range(0, len(hex_string), 2))
        f.write(formatted_hex.upper())
        
    print(f"\n🎉 Height fixed map saved:")
    print(f"   📁 height_fixed_58x31.dat ({len(fixed_binary)} bytes)")
    print(f"   📄 height_fixed_58x31.hex")
    print(f"   🎯 Corrected: 58x30 → 58x31 (height byte: 0x1E → 0x1F)")
    
    # Check the critical byte
    check_offset = 24  # Byte 24 should now be 0x1F instead of 0x1E
    if len(fixed_binary) > check_offset:
        critical_byte = fixed_binary[check_offset]
        print(f"   ✅ Byte 24 (height): 0x{critical_byte:02X} {'✅ CORRECT' if critical_byte == 0x1F else '❌ WRONG'}")

if __name__ == "__main__":
    fix_height_from_30_to_31()