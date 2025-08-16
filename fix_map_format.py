#!/usr/bin/env python3
"""
Fix HSO Map Format
Tạo correct map format dựa trên phân tích cs.java:
- b(byte[]) method chỉ đọc header + tiles
- c(byte[]) method đọc objects riêng biệt

Client expect map file chỉ có:
[2 bytes padding]
[UTF map name]
[2 bytes version]  
[1 byte width]
[1 byte height]
[1 byte tileset_id]
[width*height bytes tile data]
KHÔNG CÓ separators hay objects!
"""

import binascii
import struct
import sys
import os

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from map_core import MapParser, MapData, TILE_SIZE

# Original hex data
ORIGINAL_HEX = "00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1F 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01"

class CorrectMapWriter:
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
        
    def write_tiles_only_map(self, map_data):
        """Write ONLY tiles data như cs.java b() method expects"""
        # Header padding
        self.write_ushort(0)
        
        # Map header
        self.write_utf(map_data.name)
        self.write_short(map_data.version)
        self.write_ubyte(map_data.width)
        self.write_ubyte(map_data.height)
        self.write_ubyte(map_data.tileset_id)
        
        # ONLY tile data - NO separators, NO objects
        for row in map_data.tiles:
            for tile in row:
                self.write_ubyte(tile)
                
        # THAT'S IT! No separators, objects, or EOF markers
        
    def get_data(self):
        return bytes(self.data)

def extract_tiles_from_original(original_binary):
    """Extract chỉ tiles từ original corrupt data"""
    print("🔧 Extracting tiles from original data...")
    
    offset = 0
    
    # Skip padding
    offset += 2
    
    # Skip map name
    name_len = int.from_bytes(original_binary[offset:offset+2], 'big')
    offset += 2 + name_len
    
    # Skip version
    offset += 2
    
    # Read dimensions
    width = original_binary[offset]
    height = original_binary[offset + 1]
    tileset_id = original_binary[offset + 2]
    offset += 3
    
    print(f"   Map: {width}x{height}, tileset: {tileset_id}")
    
    # Extract tile data
    tile_count = width * height
    tile_data = list(original_binary[offset:offset + tile_count])
    
    print(f"   Extracted {len(tile_data)} tiles")
    
    # Convert to 2D array
    tiles = []
    for y in range(height):
        row = tile_data[y * width:(y + 1) * width]
        tiles.append(row)
        
    return {
        'width': width,
        'height': height,
        'tileset_id': tileset_id,
        'tiles': tiles
    }

def create_correct_maps():
    """Tạo correct map formats cho testing"""
    print("🎯 Creating CORRECT HSO Map Formats")
    print("Based on cs.java b(byte[]) method analysis")
    
    # Parse original để lấy tiles
    original_binary = binascii.unhexlify(ORIGINAL_HEX.replace(' ', ''))
    original_tiles = extract_tiles_from_original(original_binary)
    
    test_cases = [
        # Original size
        {
            'name': 'original',
            'width': original_tiles['width'],
            'height': original_tiles['height'],
            'tiles': original_tiles['tiles']
        },
        # Expanded
        {
            'name': 'expanded_60x35', 
            'width': 60,
            'height': 35,
            'tiles': None  # Will generate
        },
        {
            'name': 'expanded_70x40',
            'width': 70, 
            'height': 40,
            'tiles': None
        },
        # Reduced
        {
            'name': 'reduced_50x25',
            'width': 50,
            'height': 25, 
            'tiles': None
        }
    ]
    
    for case in test_cases:
        print(f"\n📝 Creating {case['name']} ({case['width']}x{case['height']})")
        
        # Create map data
        map_data = MapData()
        map_data.name = "Ngôi Làng Nhỏ"
        map_data.version = 1743
        map_data.width = case['width']
        map_data.height = case['height'] 
        map_data.tileset_id = 0
        
                # Generate or copy tiles
        if case['tiles'] is None:
            # Generate new tiles
            map_data.tiles = []
            for y in range(case['height']):
                row = []
                for x in range(case['width']):
                    if (y < len(original_tiles['tiles']) and 
                        x < len(original_tiles['tiles'][y])):
                        # Copy original tile
                        row.append(original_tiles['tiles'][y][x])
                    else:
                        # Fill with grass
                        row.append(1)
                map_data.tiles.append(row)
        else:
            # Use provided tiles
            map_data.tiles = case['tiles']
        
        # Write correct format
        writer = CorrectMapWriter()
        writer.write_tiles_only_map(map_data)
        binary_data = writer.get_data()
        
        # Save file
        filename = f"correct_{case['name']}.dat"
        with open(filename, 'wb') as f:
            f.write(binary_data)
            
        # Create hex file
        hex_filename = f"correct_{case['name']}.hex"
        with open(hex_filename, 'w') as f:
            hex_string = binascii.hexlify(binary_data).decode('ascii')
            formatted_hex = ' '.join(hex_string[i:i+2] for i in range(0, len(hex_string), 2))
            f.write(formatted_hex.upper())
            
        print(f"   ✅ Generated: {filename} ({len(binary_data)} bytes)")
        print(f"   📄 Hex dump: {hex_filename}")
        
        # Verify structure
        print(f"   📊 Structure:")
        print(f"      Header: {2 + 2 + len(map_data.name.encode('utf-8')) + 2 + 3} bytes")
        print(f"      Tiles: {case['width'] * case['height']} bytes")
        print(f"      Total: {len(binary_data)} bytes")

def main():
    print("🔍 HSO Map Format Fix")
    print("Creating tiles-only maps based on cs.java analysis")
    print("=" * 50)
    
    create_correct_maps()
    
    print(f"\n🎉 All correct map formats generated!")
    print(f"📋 Test với HSO client:")
    print(f"   1. Copy files .dat vào map folder")
    print(f"   2. Test loading trong client") 
    print(f"   3. Verify rendering works properly")
    
    print(f"\n💡 Key insight:")
    print(f"   HSO client expects ONLY tiles data")
    print(f"   Objects được load riêng qua method c()")
    print(f"   NO separators hay EOF markers needed!")

if __name__ == "__main__":
    main()