#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import struct
import sys

class HsoMapParser:
    def __init__(self, hex_data):
        # Convert hex string to bytes
        self.data = bytes.fromhex(hex_data.replace(' ', ''))
        self.offset = 0
        self.parsed = {}
        
    def read_int(self):
        """Read 4-byte integer (big endian)"""
        result = struct.unpack('>I', self.data[self.offset:self.offset+4])[0]
        self.offset += 4
        return result
        
    def read_short(self):
        """Read 2-byte short (big endian)"""
        result = struct.unpack('>H', self.data[self.offset:self.offset+2])[0]
        self.offset += 2
        return result
        
    def read_byte(self):
        """Read 1 byte"""
        result = self.data[self.offset]
        self.offset += 1
        return result
        
    def read_string(self):
        """Read UTF-8 string with length prefix"""
        length = self.read_short()
        result = self.data[self.offset:self.offset+length].decode('utf-8')
        self.offset += length
        return result
        
    def read_bytes(self, count):
        """Read specified number of bytes"""
        result = self.data[self.offset:self.offset+count]
        self.offset += count
        return result
        
    def parse_header(self):
        """Parse map header"""
        self.parsed['map_id'] = self.read_int()
        self.parsed['map_name'] = self.read_string()
        print(f"Map ID: {self.parsed['map_id']}")
        print(f"Map Name: {self.parsed['map_name']}")
        
    def parse_map_info(self):
        """Parse map dimensions and basic info"""
        # Đọc thêm thông tin về map
        map_type = self.read_byte()
        width = self.read_byte() 
        height = self.read_byte()
        
        self.parsed['map_type'] = map_type
        self.parsed['width'] = width
        self.parsed['height'] = height
        
        print(f"Map Type: {map_type}")
        print(f"Dimensions: {width} x {height}")
        
    def parse_tile_data(self):
        """Parse map tile data"""
        print(f"\n=== TILE DATA (offset: {self.offset}) ===")
        
        width = self.parsed['width']
        height = self.parsed['height'] 
        
        tiles = []
        for y in range(height):
            row = []
            for x in range(width):
                if self.offset < len(self.data):
                    tile = self.read_byte()
                    row.append(tile)
                else:
                    row.append(0)
            tiles.append(row)
            
        self.parsed['tiles'] = tiles
        
        # Print tile map
        print("Tile Map:")
        for y, row in enumerate(tiles):
            line = f"{y:2d}: "
            for tile in row:
                if tile == 0:
                    line += "  ."
                elif tile < 16:
                    line += f" {tile:1x}"
                else:
                    line += f"{tile:02x}"
            print(line)
            
    def find_separator(self, pattern=b'\xff'):
        """Find separator pattern in data"""
        pos = self.data.find(pattern, self.offset)
        return pos if pos != -1 else len(self.data)
        
    def parse_objects(self):
        """Parse objects/NPCs on map"""
        print(f"\n=== OBJECTS DATA (offset: {self.offset}) ===")
        
        # Tìm separator để xác định end of tiles
        separator_pos = self.find_separator(b'\xff')
        
        # Skip đến sau tile data
        if separator_pos > self.offset:
            remaining_bytes = separator_pos - self.offset
            print(f"Skipping {remaining_bytes} bytes to objects section")
            
            # Show some of the raw tile data
            sample_data = self.data[self.offset:min(self.offset+100, separator_pos)]
            print("Sample tile data:")
            print(' '.join(f'{b:02x}' for b in sample_data))
            
            self.offset = separator_pos + 1  # Skip separator
            
        if self.offset >= len(self.data):
            print("No object data found")
            return
            
        # Parse object count
        if self.offset + 2 <= len(self.data):
            obj_count = self.read_short()
            print(f"Object count: {obj_count}")
            
            objects = []
            for i in range(min(obj_count, 50)):  # Limit to prevent overflow
                if self.offset + 6 <= len(self.data):
                    obj = {}
                    obj['type'] = self.read_short()
                    obj['x'] = self.read_short() 
                    obj['y'] = self.read_short()
                    objects.append(obj)
                    print(f"Object {i}: type={obj['type']}, pos=({obj['x']}, {obj['y']})")
                else:
                    break
                    
            self.parsed['objects'] = objects
            
    def parse_npcs(self):
        """Parse NPC data"""
        print(f"\n=== NPC DATA (offset: {self.offset}) ===")
        
        if self.offset + 2 <= len(self.data):
            npc_count = self.read_short()
            print(f"NPC count: {npc_count}")
            
            npcs = []
            for i in range(min(npc_count, 20)):  # Limit to prevent overflow
                if self.offset + 20 <= len(self.data):  # Estimate NPC data size
                    npc = {}
                    npc['id'] = self.read_short()
                    npc['x'] = self.read_short()
                    npc['y'] = self.read_short()
                    npc['type'] = self.read_byte()
                    
                    # Try to read name if present
                    if self.offset + 2 <= len(self.data):
                        name_len = self.read_short()
                        if 0 < name_len < 100 and self.offset + name_len <= len(self.data):
                            npc['name'] = self.data[self.offset:self.offset+name_len].decode('utf-8', errors='ignore')
                            self.offset += name_len
                        else:
                            self.offset -= 2  # Rewind if not a valid string length
                            npc['name'] = f"NPC_{npc['id']}"
                    
                    npcs.append(npc)
                    print(f"NPC {i}: id={npc['id']}, pos=({npc['x']}, {npc['y']}), type={npc['type']}, name={npc.get('name', 'Unknown')}")
                else:
                    break
                    
            self.parsed['npcs'] = npcs
            
    def show_remaining_data(self):
        """Show remaining unparsed data"""
        remaining = len(self.data) - self.offset
        if remaining > 0:
            print(f"\n=== REMAINING DATA ({remaining} bytes) ===")
            end_pos = min(self.offset + 200, len(self.data))
            sample = self.data[self.offset:end_pos]
            
            # Hex dump
            print("Hex dump:")
            for i in range(0, len(sample), 16):
                chunk = sample[i:i+16]
                hex_part = ' '.join(f'{b:02x}' for b in chunk)
                ascii_part = ''.join(chr(b) if 32 <= b <= 126 else '.' for b in chunk)
                print(f"{self.offset + i:04x}: {hex_part:<48} {ascii_part}")
                
            # Try to find text strings
            print("\nPossible text strings:")
            text = sample.decode('utf-8', errors='ignore')
            for line in text.split('\x00'):
                if len(line) > 3 and line.isprintable():
                    print(f"  '{line}'")
        
    def parse_all(self):
        """Parse entire map data"""
        print("=== HSOMOMBI MAP PARSER ===\n")
        
        try:
            self.parse_header()
            self.parse_map_info()
            self.parse_tile_data() 
            self.parse_objects()
            self.parse_npcs()
            self.show_remaining_data()
            
        except Exception as e:
            print(f"Parse error at offset {self.offset}: {e}")
            self.show_remaining_data()
            
        return self.parsed

def main():
    # Map data từ user
    hex_data = """00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1E 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 FF 02 72 00 4D 00 01 00 04 00 0A 00 12 00 11 00 0E 00 22 00 0D 00 09 00 23 00 11 00 15 00 01 00 02 00 15 00 03 00 10 00 17 00 06 00 1A 00 10 00 07 00 04 00 1A 00 07 00 13 00 1A 00 07 00 17 00 19 00 07 00 03 00 1A 00 07 00 00 00 1B 00 07 00 34 00 16 00 08 00 0E 00 15 00 0A 00 12 00 01 00 0B 00 2A 00 10 00 0C 00 08 00 0B 00 0C 00 05 00 17 00 0C 00 1D 00 19 00 11 00 11 00 0A 00 11 00 04 00 17 00 17 00 03 00 08 00 17 00 1E 00 02 00 17 00 26 00 1C 00 18 00 11 00 1A 00 18 00 2E 00 19 00 18 00 2A 00 0C 00 00 00 02 00 08 00 00 00 02 00 0D 00 00 00 02 00 04 00 00 00 01 00 06 00 00 00 04 00 03 00 00 00 00 00 0E 00 00 00 08 00 16 00 00 00 00 00 04 00 00 00 02 00 02 00 00 00 05 00 02 00 00 00 06 00 03 00 00 00 00 00 0A 00 00 00 12 00 08 00 00 00 10 00 05 00 00 00 0F 00 03 00 00 00 0E 00 02 00 00 00 13 00 03 00 00 00 15 00 07 00 00 00 15 00 02 00 00 00 0D 00 13 00 00 00 1A 00 18 00 00 00 25 00 1D 00 00 00 27 00 10 00 00 00 28 00 19 00 00 00 2B 00 1B 00 00 00 31 00 16 00 00 00 2B 00 0E 00 01 00 0C 00 04 00 22 00 05 00 04 00 11 00 04 00 06 00 00 00 2B 00 03 00 00 00 20 00 01 00 00 00 1E 00 00 00 00 00 1C 00 02 00 00 00 2C 00 01 00 00 00 33 00 14 00 00 00 35 00 14 00 00 00 25 00 0D 00 00 00 36 00 06 00 00 00 20 00 1C 00 07 00 06 00 19 00 07 00 15 00 19 00 00 00 37 00 0D 00 00 00 35 00 0B 00 00 00 2E 00 07 00 00 00 09 00 00 00 00 00 37 00 1A 00 00 00 0D 00 1C 00 00 00 0F 00 1C 00 55 00 1B 00 08 00 07 03 65 66 66 12 30 3B 31 3B 32 37 3B 38 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 31 3B 37 3B 31 32 3B 31 34 3B 30 3B 30 3B 31 3B 30 03 65 66 66 13 33 3B 34 3B 34 36 3B 32 34 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 34 3B 34 3B 33 38 3B 32 37 3B 30 3B 30 3B 31 3B 30 03 65 66 66 11 35 3B 35 3B 34 31 3B 31 30 3B 30 3B 30 3B 31 3B 30 03 65 66 66 12 36 3B 36 3B 31 32 3B 32 31 3B 30 3B 30 3B 30 3B 38 30 03 65 66 66 13 37 3B 36 3B 31 32 3B 32 34 3B 30 3B 30 3B 30 3B 31 30 30 01 04 C8 00 24 00 12 4C C3 A0 6E 67 20 53 C3 B3 69 20 54 72 E1 BA AF 6E 67 FF"""
    
    parser = HsoMapParser(hex_data)
    result = parser.parse_all()
    
    print(f"\n=== PARSE SUMMARY ===")
    print(f"Map ID: {result.get('map_id')}")
    print(f"Map Name: {result.get('map_name')}")
    print(f"Dimensions: {result.get('width')} x {result.get('height')}")
    print(f"Objects: {len(result.get('objects', []))}")
    print(f"NPCs: {len(result.get('npcs', []))}")

if __name__ == "__main__":
    main()