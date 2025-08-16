#!/usr/bin/env python3
"""
Fix User's Incomplete Map Data
Thêm missing tile để complete user's map data
"""

import binascii
import struct

# User's incomplete hex data (missing 1 tile)
USER_HEX = "00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1F 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01"

class HSO_MapWriter:
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

def fix_user_map():
    """Fix user's incomplete map data"""
    print("🔧 Fixing User's Incomplete Map Data")
    print("=" * 40)
    
    # Parse original incomplete data
    binary_data = binascii.unhexlify(USER_HEX.replace(' ', ''))
    print(f"Original data: {len(binary_data)} bytes")
    
    # Parse header to get dimensions
    offset = 2  # Skip padding
    name_len = int.from_bytes(binary_data[offset:offset+2], 'big')
    offset += 2
    map_name = binary_data[offset:offset+name_len].decode('utf-8')
    offset += name_len
    
    version = int.from_bytes(binary_data[offset:offset+2], 'big', signed=True)
    offset += 2
    
    width = binary_data[offset]
    height = binary_data[offset + 1]
    tileset_id = binary_data[offset + 2]
    offset += 3
    
    print(f"Map: '{map_name}' {width}x{height}, tileset {tileset_id}")
    
    expected_tiles = width * height
    available_tiles = len(binary_data) - offset
    missing_tiles = expected_tiles - available_tiles
    
    print(f"Expected tiles: {expected_tiles}")
    print(f"Available tiles: {available_tiles}")
    print(f"Missing tiles: {missing_tiles}")
    
    if missing_tiles <= 0:
        print("✅ No tiles missing!")
        return
        
    # Extract existing tiles
    existing_tiles = list(binary_data[offset:])
    print(f"Existing tiles extracted: {len(existing_tiles)}")
    
    # Analyze most common tile for padding
    tile_counts = {}
    for tile in existing_tiles:
        tile_counts[tile] = tile_counts.get(tile, 0) + 1
        
    most_common_tile = max(tile_counts.items(), key=lambda x: x[1])[0]
    print(f"Most common tile: {most_common_tile} (appears {tile_counts[most_common_tile]} times)")
    
    # Add missing tiles
    complete_tiles = existing_tiles + [most_common_tile] * missing_tiles
    print(f"✅ Added {missing_tiles} tiles (ID {most_common_tile}) to complete the map")
    
    # Create complete map file
    writer = HSO_MapWriter()
    
    # Header
    writer.write_ushort(0)  # Padding
    writer.write_utf(map_name)
    writer.write_short(version)
    writer.write_ubyte(width)
    writer.write_ubyte(height)
    writer.write_ubyte(tileset_id)
    
    # All tiles
    for tile in complete_tiles:
        writer.write_ubyte(tile)
        
    # Get final data
    fixed_binary = writer.get_data()
    
    # Verify completeness
    header_size = 2 + 2 + len(map_name.encode('utf-8')) + 2 + 3
    expected_size = header_size + expected_tiles
    
    print(f"\n📊 Fixed Map Verification:")
    print(f"   Header size: {header_size} bytes")
    print(f"   Tiles size: {expected_tiles} bytes")
    print(f"   Expected total: {expected_size} bytes")
    print(f"   Actual size: {len(fixed_binary)} bytes")
    
    if len(fixed_binary) == expected_size:
        print(f"   ✅ Perfect size match!")
    else:
        print(f"   ❌ Size mismatch!")
        
    # Save fixed map
    with open('fixed_complete_map.dat', 'wb') as f:
        f.write(fixed_binary)
        
    # Create hex version
    with open('fixed_complete_map.hex', 'w') as f:
        hex_string = binascii.hexlify(fixed_binary).decode('ascii')
        formatted_hex = ' '.join(hex_string[i:i+2] for i in range(0, len(hex_string), 2))
        f.write(formatted_hex.upper())
        
    print(f"\n🎉 Fixed map saved:")
    print(f"   📁 fixed_complete_map.dat ({len(fixed_binary)} bytes)")
    print(f"   📄 fixed_complete_map.hex")
    print(f"   🎯 Ready for HSO client!")
    
    # Generate expanded versions
    test_sizes = [(60, 35), (70, 40), (50, 25)]
    
    for new_w, new_h in test_sizes:
        print(f"\n🧪 Creating expanded {new_w}x{new_h}")
        
        # Create expanded tiles
        expanded_tiles = []
        for y in range(new_h):
            for x in range(new_w):
                if y < height and x < width:
                    # Copy from original
                    original_index = y * width + x
                    if original_index < len(complete_tiles):
                        expanded_tiles.append(complete_tiles[original_index])
                    else:
                        expanded_tiles.append(1)  # Default
                else:
                    # Fill new area
                    expanded_tiles.append(1)  # Grass
                    
        # Create expanded map
        expanded_writer = HSO_MapWriter()
        expanded_writer.write_ushort(0)
        expanded_writer.write_utf(map_name)
        expanded_writer.write_short(version)
        expanded_writer.write_ubyte(new_w)
        expanded_writer.write_ubyte(new_h)
        expanded_writer.write_ubyte(tileset_id)
        
        for tile in expanded_tiles:
            expanded_writer.write_ubyte(tile)
            
        expanded_binary = expanded_writer.get_data()
        
        filename = f'fixed_expanded_{new_w}x{new_h}.dat'
        with open(filename, 'wb') as f:
            f.write(expanded_binary)
            
        print(f"   ✅ {filename} ({len(expanded_binary)} bytes)")

if __name__ == "__main__":
    fix_user_map()