#!/usr/bin/env python3
"""
Debug Missing Data in HSO Map
Phân tích chi tiết hex data để tìm dữ liệu bị thiếu
"""

import binascii
import sys
import os

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from map_core import MapParser, MapData, TILE_SIZE

# User's hex data
USER_HEX = "00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1F 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01"

def analyze_map_structure(hex_data, name):
    """Phân tích chi tiết cấu trúc map"""
    print(f"\n=== {name} Analysis ===")
    
    binary_data = binascii.unhexlify(hex_data.replace(' ', ''))
    print(f"Total data: {len(binary_data)} bytes")
    
    offset = 0
    
    # Header
    padding = int.from_bytes(binary_data[offset:offset+2], 'big')
    offset += 2
    print(f"Padding: {padding}")
    
    # Map name
    name_len = int.from_bytes(binary_data[offset:offset+2], 'big')
    offset += 2
    map_name = binary_data[offset:offset+name_len].decode('utf-8')
    offset += name_len
    print(f"Map name: '{map_name}' (length: {name_len})")
    
    # Version
    version = int.from_bytes(binary_data[offset:offset+2], 'big', signed=True)
    offset += 2
    print(f"Version: {version} (0x{version:04X})")
    
    # Dimensions
    width = binary_data[offset]
    height = binary_data[offset + 1]
    tileset_id = binary_data[offset + 2]
    offset += 3
    print(f"Dimensions: {width}x{height}, Tileset: {tileset_id}")
    
    expected_tiles = width * height
    print(f"Expected tiles: {expected_tiles}")
    
    # Check available data for tiles
    available_for_tiles = len(binary_data) - offset
    print(f"Available data for tiles: {available_for_tiles} bytes")
    
    if available_for_tiles < expected_tiles:
        print(f"❌ MISSING TILES: Need {expected_tiles}, have {available_for_tiles}")
        missing = expected_tiles - available_for_tiles
        print(f"   Missing {missing} tiles at the end")
    elif available_for_tiles == expected_tiles:
        print(f"✅ EXACT TILES: Perfect match")
    else:
        print(f"⚠️  EXTRA DATA: {available_for_tiles - expected_tiles} bytes beyond tiles")
        
    # Extract tiles
    tile_data = list(binary_data[offset:offset + min(expected_tiles, available_for_tiles)])
    print(f"Extracted tiles: {len(tile_data)}")
    
    # Analyze tile distribution  
    tile_counts = {}
    for tile in tile_data:
        tile_counts[tile] = tile_counts.get(tile, 0) + 1
    
    print(f"Tile distribution (top 10):")
    sorted_tiles = sorted(tile_counts.items(), key=lambda x: x[1], reverse=True)
    for tile_id, count in sorted_tiles[:10]:
        print(f"   Tile {tile_id}: {count} times")
        
    # Check for patterns at end
    if len(tile_data) > 50:
        last_50 = tile_data[-50:]
        print(f"Last 50 tiles: {last_50}")
        
        # Check for repeating pattern
        if len(set(last_50)) == 1:
            print(f"   ⚠️  Last 50 tiles are all {last_50[0]} - possible padding!")
            
    return {
        'width': width,
        'height': height,
        'expected_tiles': expected_tiles,
        'actual_tiles': len(tile_data),
        'missing_tiles': max(0, expected_tiles - len(tile_data)),
        'tile_data': tile_data
    }

def fix_missing_tiles(tile_data, expected_count):
    """Fix missing tiles by padding với tile phổ biến nhất"""
    if len(tile_data) >= expected_count:
        return tile_data[:expected_count]
        
    # Find most common tile
    tile_counts = {}
    for tile in tile_data:
        tile_counts[tile] = tile_counts.get(tile, 0) + 1
        
    most_common_tile = max(tile_counts.items(), key=lambda x: x[1])[0]
    
    # Pad với most common tile
    missing = expected_count - len(tile_data)
    fixed_data = tile_data + [most_common_tile] * missing
    
    print(f"✅ Fixed: Added {missing} tiles (ID {most_common_tile}) to complete map")
    return fixed_data

def create_fixed_map(analysis):
    """Tạo map với missing tiles được fix"""
    print(f"\n🔧 Creating Fixed Map")
    
    # Fix tiles
    fixed_tiles = fix_missing_tiles(analysis['tile_data'], analysis['expected_tiles'])
    
    # Convert to 2D
    tiles_2d = []
    for y in range(analysis['height']):
        row = fixed_tiles[y * analysis['width']:(y + 1) * analysis['width']]
        tiles_2d.append(row)
    
    # Create map data
    map_data = MapData()
    map_data.name = "Ngôi Làng Nhỏ"
    map_data.version = 1743
    map_data.width = analysis['width']
    map_data.height = analysis['height']
    map_data.tileset_id = 0
    map_data.tiles = tiles_2d
    
    return map_data

def main():
    print("🔍 HSO Map Missing Data Debug")
    print("Analyzing user's hex data for missing tiles")
    print("=" * 50)
    
    # Analyze user's data
    analysis = analyze_map_structure(USER_HEX, "User's Map Data")
    
    if analysis['missing_tiles'] > 0:
        print(f"\n🚨 ISSUE FOUND: Missing {analysis['missing_tiles']} tiles!")
        
        # Create fixed map
        fixed_map = create_fixed_map(analysis)
        
        # Export fixed version
        from fix_map_format import CorrectMapWriter
        
        writer = CorrectMapWriter()
        writer.write_tiles_only_map(fixed_map)
        fixed_binary = writer.get_data()
        
        # Save fixed version
        with open('fixed_user_map.dat', 'wb') as f:
            f.write(fixed_binary)
            
        # Create hex
        with open('fixed_user_map.hex', 'w') as f:
            hex_string = binascii.hexlify(fixed_binary).decode('ascii')
            formatted_hex = ' '.join(hex_string[i:i+2] for i in range(0, len(hex_string), 2))
            f.write(formatted_hex.upper())
            
        print(f"\n✅ Fixed map saved:")
        print(f"   📁 fixed_user_map.dat ({len(fixed_binary)} bytes)")
        print(f"   📄 fixed_user_map.hex")
        print(f"   📊 Complete: {analysis['width']}x{analysis['height']} = {analysis['expected_tiles']} tiles")
        
        # Test with expanded versions
        test_sizes = [(60, 35), (70, 40), (50, 25)]
        
        for new_w, new_h in test_sizes:
            print(f"\n🧪 Creating expanded {new_w}x{new_h}")
            
            expanded_map = MapData()
            expanded_map.name = "Ngôi Làng Nhỏ" 
            expanded_map.version = 1743
            expanded_map.width = new_w
            expanded_map.height = new_h
                         expanded_map.tileset_id = 0
             
             # Expand tiles
             expanded_map.tiles = []
             for y in range(new_h):
                 row = []
                 for x in range(new_w):
                     if y < analysis['height'] and x < analysis['width']:
                         row.append(fixed_map.tiles[y][x])
                     else:
                         row.append(1)  # Default grass
                 expanded_map.tiles.append(row)
                
            # Export expanded
            expanded_writer = CorrectMapWriter()
            expanded_writer.write_tiles_only_map(expanded_map)
            expanded_binary = expanded_writer.get_data()
            
            filename = f'fixed_expanded_{new_w}x{new_h}.dat'
            with open(filename, 'wb') as f:
                f.write(expanded_binary)
                
            print(f"   ✅ {filename} ({len(expanded_binary)} bytes)")
            
    else:
        print(f"\n✅ No missing tiles found - data is complete!")

if __name__ == "__main__":
    main()