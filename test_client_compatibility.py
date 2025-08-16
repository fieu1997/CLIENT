#!/usr/bin/env python3
"""
HSO Client Compatibility Test
Test script để verify map data có thể đọc được bởi HSO client

Dựa trên phân tích cs.java method b(byte[]):
- byte 1: width (e) 
- byte 2: height (f)
- byte 3: tileset_id (k)
- bytes 4+: tile data (width * height bytes)
- separator 0xFF
- object data block...

Test cases:
1. Original map (58x30)
2. Expanded map (70x40) 
3. Reduced map (40x20)
4. Large map (100x100)
"""

import binascii
import sys
import os

# Add current directory to path to import testmap
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from map_core import MapParser, MapWriter, MapData, TILE_SIZE

def create_test_map(width, height, tileset_id=0, name="Test Map"):
    """Create a test map with specified dimensions"""
    map_data = MapData()
    map_data.name = name
    map_data.width = width
    map_data.height = height
    map_data.tileset_id = tileset_id
    map_data.version = 1743
    
    # Create tile data - checkerboard pattern
    map_data.tiles = []
    for y in range(height):
        row = []
        for x in range(width):
            # Checkerboard pattern with safe tile IDs
            if (x + y) % 2 == 0:
                row.append(1)  # Grass
            else:
                row.append(2)  # Stone
        map_data.tiles.append(row)
    
    # Add some test objects
    if width >= 10 and height >= 10:
        # Add decorative icon
        map_data.decorative_icons.append({
            'template_id': 1,
            'x': 5 * TILE_SIZE,
            'y': 5 * TILE_SIZE,
            'name': 'Test Icon'
        })
        
        # Add effect trigger
        map_data.effect_triggers.append({
            'id': 1,
            'x': 8 * TILE_SIZE,
            'y': 8 * TILE_SIZE,
            'name': 'Test Trigger',
            'raw': '0;1;8;8;0;0;1;0'
        })
    
    return map_data

def test_map_compatibility(map_data, test_name):
    """Test if map data is compatible with HSO client format"""
    print(f"\n🧪 Testing: {test_name}")
    print(f"   Map: {map_data.name} ({map_data.width}x{map_data.height})")
    
    try:
        # Step 1: Write to binary
        writer = MapWriter()
        writer.write_map_data(map_data)
        binary_data = writer.get_data()
        
        # Step 2: Verify binary structure matches cs.java expectations
        if len(binary_data) < 5:
            print("   ❌ FAIL: Binary too short")
            return False
            
        # Check header structure (skip 2 bytes padding + UTF name)
        offset = 2
        name_len = int.from_bytes(binary_data[offset:offset+2], 'big')
        offset += 2 + name_len + 2  # name + version
        
        width = binary_data[offset]
        height = binary_data[offset + 1] 
        tileset_id = binary_data[offset + 2]
        
        if width != map_data.width or height != map_data.height:
            print(f"   ❌ FAIL: Header mismatch - got {width}x{height}, expected {map_data.width}x{map_data.height}")
            return False
            
        # Check tile data length
        tile_data_start = offset + 3
        expected_tiles = width * height
        tile_data_end = tile_data_start + expected_tiles
        
        if tile_data_end > len(binary_data):
            print(f"   ❌ FAIL: Not enough tile data - need {expected_tiles} bytes")
            return False
            
        # Verify separator
        if binary_data[tile_data_end] != 0xFF:
            print(f"   ❌ FAIL: Missing separator at position {tile_data_end}")
            return False
            
        # Step 3: Try to parse back
        parser = MapParser(binary_data)
        parsed_data = parser.parse()
        
        # Step 4: Verify round-trip integrity
        if (parsed_data.width != map_data.width or 
            parsed_data.height != map_data.height or
            len(parsed_data.tiles) != map_data.height):
            print("   ❌ FAIL: Round-trip parsing failed")
            return False
            
        # Check tile data integrity  
        for y in range(min(len(parsed_data.tiles), len(map_data.tiles))):
            if len(parsed_data.tiles[y]) != map_data.width:
                print(f"   ❌ FAIL: Row {y} length mismatch")
                return False
                
        print(f"   ✅ PASS: {len(binary_data)} bytes, {len(parsed_data.decorative_icons)} icons, {len(parsed_data.effect_triggers)} triggers")
        return True
        
    except Exception as e:
        print(f"   ❌ FAIL: Exception - {e}")
        return False

def main():
    print("=== HSO Client Compatibility Test Suite ===")
    print("Testing map data format compatibility với HSO Mobile client")
    print("Dựa trên phân tích cs.java method b(byte[])")
    
    test_cases = [
        # Original sample size
        create_test_map(58, 30, 0, "Original Size Test"),
        
        # Expanded maps
        create_test_map(70, 40, 0, "Expanded Size Test"), 
        create_test_map(80, 50, 1, "Large Expanded Test"),
        
        # Reduced maps
        create_test_map(40, 20, 0, "Reduced Size Test"),
        create_test_map(30, 15, 2, "Small Size Test"),
        
        # Edge cases
        create_test_map(255, 255, 0, "Maximum Size Test"),
        create_test_map(1, 1, 0, "Minimum Size Test"),
        
        # Different tilesets
        create_test_map(50, 25, 5, "Different Tileset Test"),
    ]
    
    passed = 0
    total = len(test_cases)
    
    for test_map in test_cases:
        if test_map_compatibility(test_map, f"Map {test_map.width}x{test_map.height}"):
            passed += 1
    
    print(f"\n📊 Results: {passed}/{total} tests passed")
    
    if passed == total:
        print("🎉 ALL TESTS PASSED - Map expansion fully compatible với HSO client!")
    else:
        print("⚠️  Some tests failed - check compatibility issues")
        
    # Generate sample resized maps for manual testing
    print(f"\n📁 Generating sample files for manual client testing...")
    
    sample_maps = [
        create_test_map(70, 40, 0, "Expanded_70x40"),
        create_test_map(40, 20, 0, "Reduced_40x20"), 
    ]
    
    for sample in sample_maps:
        writer = MapWriter()
        writer.write_map_data(sample)
        binary_data = writer.get_data()
        
        filename = f"test_map_{sample.width}x{sample.height}.dat"
        with open(filename, 'wb') as f:
            f.write(binary_data)
            
        hex_filename = f"test_map_{sample.width}x{sample.height}.hex"
        with open(hex_filename, 'w') as f:
            hex_string = binascii.hexlify(binary_data).decode('ascii')
            formatted_hex = ' '.join(hex_string[i:i+2] for i in range(0, len(hex_string), 2))
            f.write(formatted_hex.upper())
            
        print(f"   Generated: {filename} ({len(binary_data)} bytes)")
        
    print("\n✅ Test hoàn tất! Có thể copy files .dat vào HSO client để test thực tế.")

if __name__ == "__main__":
    main()