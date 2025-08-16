#!/usr/bin/env python3
"""
Debug Original Map Data
Phân tích hex data gốc và so sánh với expanded map để tìm lỗi client compatibility
"""

import binascii
import sys
import os

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from map_core import MapParser, MapWriter, MapData, TILE_SIZE

# Original hex data từ user
ORIGINAL_HEX = "00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1F 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 FF 02 72 00 4D 00 01 00 04 00 0A 00 12 00 11 00 0E 00 22 00 0D 00 09 00 23 00 11 00 15 00 01 00 02 00 15 00 03 00 10 00 17 00 06 00 1A 00 10 00 07 00 04 00 1A 00 07 00 13 00 1A 00 07 00 17 00 19 00 07 00 03 00 1A 00 07 00 00 00 1B 00 07 00 34 00 16 00 08 00 0E 00 15 00 0A 00 12 00 01 00 0B 00 2A 00 10 00 0C 00 08 00 0B 00 0C 00 05 00 17 00 0C 00 1D 00 19 00 11 00 11 00 0A 00 11 00 04 00 17 00 17 00 03 00 08 00 17 00 1E 00 02 00 17 00 26 00 1C 00 18 00 11 00 1A 00 18 00 2E 00 19 00 18 00 2A 00 0C 00 00 00 02 00 08 00 00 00 02 00 0D 00 00 00 02 00 04 00 00 00 01 00 06 00 00 00 04 00 03 00 00 00 00 00 0E 00 00 00 08 00 16 00 00 00 00 00 04 00 00 00 02 00 02 00 00 00 05 00 02 00 00 00 06 00 03 00 00 00 00 00 0A 00 00 00 12 00 08 00 00 00 10 00 05 00 00 00 0F 00 03 00 00 00 0E 00 02 00 00 00 13 00 03 00 00 00 15 00 07 00 00 00 15 00 02 00 00 00 0D 00 13 00 00 00 1A 00 18 00 00 00 25 00 1D 00 00 00 27 00 10 00 00 00 28 00 19 00 00 00 2B 00 1B 00 00 00 31 00 16 00 00 00 2B 00 0E 00 01 00 0C 00 04 00 22 00 05 00 04 00 11 00 04 00 06 00 00 00 2B 00 03 00 00 00 20 00 01 00 00 00 1E 00 00 00 00 00 1C 00 02 00 00 00 2C 00 01 00 00 00 33 00 14 00 00 00 35 00 14 00 00 00 25 00 0D 00 00 00 36 00 06 00 00 00 20 00 1C 00 07 00 06 00 19 00 07 00 15 00 19 00 00 00 37 00 0D 00 00 00 35 00 0B 00 00 00 2E 00 07 00 00 00 09 00 00 00 00 00 37 00 1A 00 00 00 0D 00 1C 00 00 00 0F 00 1C 00 55 00 1B 00 08 00 00 03 65 66 66 12 30 3B 31 3B 32 37 3B 38 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 31 3B 37 3B 31 32 3B 31 34 3B 30 3B 30 3B 31 3B 30 03 65 66 66 13 33 3B 34 3B 34 36 3B 32 34 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 34 3B 34 3B 33 38 3B 32 37 3B 30 3B 30 3B 31 3B 30 03 65 66 66 11 35 3B 35 3B 34 31 3B 31 30 3B 30 3B 30 3B 31 3B 30 03 65 66 66 12 36 3B 36 3B 31 32 3B 32 31 3B 30 3B 30 3B 30 3B 38 30 03 65 66 66 13 37 3B 36 3B 31 32 3B 32 34 3B 30 3B 30 3B 30 3B 31 30 30 01 04 C8 00 24 00 12 4C C3 A0 6E 67 20 53 C3 B3 69 20 54 72 E1 BA AF 6E 67 FF"

def analyze_binary_structure(data, name):
    """Phân tích cấu trúc binary của map data"""
    print(f"\n=== Analyzing {name} ===")
    print(f"Total size: {len(data)} bytes")
    
    offset = 0
    
    # Header padding
    padding = int.from_bytes(data[offset:offset+2], 'big')
    print(f"Padding: {padding}")
    offset += 2
    
    # Map name
    name_len = int.from_bytes(data[offset:offset+2], 'big')
    offset += 2
    map_name = data[offset:offset+name_len].decode('utf-8')
    print(f"Map name: '{map_name}' (length: {name_len})")
    offset += name_len
    
    # Version
    version = int.from_bytes(data[offset:offset+2], 'big', signed=True)
    print(f"Version: {version} (0x{version:04X})")
    offset += 2
    
    # Dimensions
    width = data[offset]
    height = data[offset + 1]
    tileset_id = data[offset + 2]
    print(f"Dimensions: {width}x{height}, Tileset: {tileset_id}")
    offset += 3
    
    # Tile data
    tile_count = width * height
    print(f"Tile data: {tile_count} bytes at offset {offset}")
    tile_data_end = offset + tile_count
    offset = tile_data_end
    
    # Separator
    if offset < len(data):
        separator = data[offset]
        print(f"Separator: 0x{separator:02X} at offset {offset}")
        if separator == 0xFF:
            offset += 1
            print("✅ Valid separator found")
        else:
            print("❌ Invalid separator!")
            
    # Object block
    if offset + 2 <= len(data):
        object_block_length = int.from_bytes(data[offset:offset+2], 'big')
        print(f"Object block length: {object_block_length} bytes at offset {offset}")
        object_block_start = offset + 2
        object_block_end = object_block_start + object_block_length
        
        # Check if object block is within data bounds
        if object_block_end <= len(data):
            print(f"✅ Object block valid: {object_block_start} to {object_block_end}")
        else:
            print(f"❌ Object block INVALID: extends beyond data ({object_block_end} > {len(data)})")
            
        offset = object_block_end
        
        # Check for external VGOs
        if offset < len(data):
            external_vgo_count = data[offset]
            print(f"External VGO count: {external_vgo_count} at offset {offset}")
            offset += 1
            
            # Process external VGOs
            for i in range(external_vgo_count):
                if offset + 4 < len(data):
                    x = int.from_bytes(data[offset:offset+2], 'big', signed=True)
                    y = int.from_bytes(data[offset+2:offset+4], 'big', signed=True)
                    offset += 4
                    
                    # Read name
                    name_len = int.from_bytes(data[offset:offset+2], 'big')
                    offset += 2
                    if offset + name_len <= len(data):
                        vgo_name = data[offset:offset+name_len].decode('utf-8')
                        offset += name_len
                        print(f"  VGO {i}: ({x}, {y}) '{vgo_name}'")
                    else:
                        print(f"  VGO {i}: Name extends beyond data")
                        break
        
        # Final EOF
        if offset < len(data):
            eof_marker = data[offset]
            print(f"EOF marker: 0x{eof_marker:02X} at offset {offset}")
            if eof_marker == 0xFF:
                print("✅ Valid EOF marker")
            else:
                print("❌ Invalid EOF marker!")
                
    return {
        'width': width,
        'height': height,
        'tileset_id': tileset_id,
        'total_size': len(data)
    }

def create_expanded_map_from_original(original_data, new_width, new_height):
    """Tạo expanded map từ original data"""
    print(f"\n=== Creating Expanded Map {new_width}x{new_height} ===")
    
    # Parse original map
    parser = MapParser(original_data)
    original_map = parser.parse()
    
    print(f"Original: {original_map.width}x{original_map.height}")
    print(f"New: {new_width}x{new_height}")
    
    # Create expanded map
    expanded_map = MapData()
    expanded_map.name = original_map.name
    expanded_map.version = original_map.version
    expanded_map.width = new_width
    expanded_map.height = new_height
    expanded_map.tileset_id = original_map.tileset_id
    
    # Copy and expand tiles
    expanded_map.tiles = []
    for y in range(new_height):
        row = []
        for x in range(new_width):
            if y < original_map.height and x < original_map.width:
                # Copy existing tile
                row.append(original_map.tiles[y][x])
            else:
                # Fill with default tile
                row.append(1)
        expanded_map.tiles.append(row)
    
    # Copy objects (filter those outside new bounds)
    new_width_pixels = new_width * TILE_SIZE
    new_height_pixels = new_height * TILE_SIZE
    
    expanded_map.decorative_icons = [
        icon for icon in original_map.decorative_icons
        if icon['x'] < new_width_pixels and icon['y'] < new_height_pixels
    ]
    
    expanded_map.internal_vgos = [
        vgo for vgo in original_map.internal_vgos
        if vgo['x'] < new_width_pixels and vgo['y'] < new_height_pixels
    ]
    
    expanded_map.effect_triggers = [
        trigger for trigger in original_map.effect_triggers
        if trigger['x'] < new_width_pixels and trigger['y'] < new_height_pixels
    ]
    
    expanded_map.map_warps = [
        warp for warp in original_map.map_warps
        if warp['x'] < new_width_pixels and warp['y'] < new_height_pixels
    ]
    
    return expanded_map

def compare_binary_formats(original_data, expanded_data):
    """So sánh chi tiết format binary"""
    print(f"\n=== Binary Format Comparison ===")
    
    original_info = analyze_binary_structure(original_data, "Original")
    expanded_info = analyze_binary_structure(expanded_data, "Expanded")
    
    print(f"\n=== Key Differences ===")
    print(f"Size: {original_info['total_size']} → {expanded_info['total_size']} bytes")
    print(f"Dimensions: {original_info['width']}x{original_info['height']} → {expanded_info['width']}x{expanded_info['height']}")
    
    # So sánh byte-by-byte cho header
    print(f"\n=== Header Comparison ===")
    min_len = min(50, len(original_data), len(expanded_data))
    for i in range(min_len):
        if original_data[i] != expanded_data[i]:
            print(f"Diff at {i}: {original_data[i]:02X} → {expanded_data[i]:02X}")

def main():
    print("🔍 HSO Map Expansion Debugging")
    print("Analyzing original map data và expanded map compatibility issues")
    
    # Convert hex to binary
    original_binary = binascii.unhexlify(ORIGINAL_HEX.replace(' ', ''))
    
    # Analyze original
    print(f"\n📊 Original Map Analysis:")
    original_info = analyze_binary_structure(original_binary, "Original Map")
    
    # Test parsing original
    try:
        parser = MapParser(original_binary)
        original_map = parser.parse()
        print(f"✅ Original parsing successful")
        print(f"   Objects: {len(original_map.decorative_icons)} icons, {len(original_map.effect_triggers)} triggers, {len(original_map.map_warps)} warps")
    except Exception as e:
        print(f"❌ Original parsing failed: {e}")
        return
    
    # Create expanded versions
    test_sizes = [
        (60, 32),  # Slightly expanded
        (70, 40),  # Medium expansion
        (original_map.width - 5, original_map.height - 3),  # Reduced
    ]
    
    for new_w, new_h in test_sizes:
        print(f"\n🧪 Testing expansion to {new_w}x{new_h}")
        
        try:
            # Create expanded map
            expanded_map = create_expanded_map_from_original(original_binary, new_w, new_h)
            
            # Write to binary
            writer = MapWriter()
            writer.write_map_data(expanded_map)
            expanded_binary = writer.get_data()
            
            # Test parsing
            test_parser = MapParser(expanded_binary)
            test_map = test_parser.parse()
            
            # Compare structures
            compare_binary_formats(original_binary, expanded_binary)
            
            # Write test file
            filename = f"debug_expanded_{new_w}x{new_h}.dat"
            with open(filename, 'wb') as f:
                f.write(expanded_binary)
            
            print(f"✅ {new_w}x{new_h} expansion successful - saved to {filename}")
            print(f"   Size: {len(expanded_binary)} bytes")
            print(f"   Objects: {len(test_map.decorative_icons)} icons, {len(test_map.effect_triggers)} triggers")
            
        except Exception as e:
            print(f"❌ {new_w}x{new_h} expansion failed: {e}")
            import traceback
            traceback.print_exc()

if __name__ == "__main__":
    main()