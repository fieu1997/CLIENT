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
        
    def read_string_modified(self):
        """Read modified UTF-8 string (Java style)"""
        length = self.read_short()
        print(f"String length at offset {self.offset-2}: {length}")
        
        if length > 200:  # Reasonable limit
            print(f"Suspiciously long string length: {length}, treating as binary data")
            self.offset -= 2  # Rewind
            return None
            
        result = self.data[self.offset:self.offset+length].decode('utf-8', errors='replace')
        self.offset += length
        return result
        
    def read_bytes(self, count):
        """Read specified number of bytes"""
        result = self.data[self.offset:self.offset+count]
        self.offset += count
        return result
        
    def parse_header(self):
        """Parse map header"""
        print(f"Parsing header at offset: {self.offset}")
        self.parsed['map_id'] = self.read_int()
        print(f"Map ID: {self.parsed['map_id']}")
        
        # Try to read map name
        map_name = self.read_string_modified()
        if map_name:
            self.parsed['map_name'] = map_name
            print(f"Map Name: '{map_name}'")
        else:
            print("Could not parse map name properly")
        
    def manual_parse(self):
        """Manually parse the structure step by step"""
        print("=== MANUAL PARSING ===")
        
        # Reset to start
        self.offset = 0
        
        # Map ID (4 bytes)
        map_id = self.read_int()
        print(f"Map ID: {map_id}")
        
        # Map name length (2 bytes) and string
        name_len = self.read_short()
        print(f"Name length: {name_len}")
        
        if name_len > 0 and name_len < 100:
            name_bytes = self.read_bytes(name_len)
            name = name_bytes.decode('utf-8', errors='replace')
            print(f"Map Name: '{name}'")
        else:
            print(f"Invalid name length: {name_len}")
            
        # Next few bytes
        print(f"Next bytes at offset {self.offset}:")
        for i in range(min(20, len(self.data) - self.offset)):
            byte_val = self.data[self.offset + i]
            print(f"  [{self.offset + i:04x}]: 0x{byte_val:02x} ({byte_val})")
            
        # Look for patterns
        print("\n=== LOOKING FOR PATTERNS ===")
        
        # Look for possible map dimensions
        # Common sizes: 30-100 for width/height
        for i in range(self.offset, min(self.offset + 50, len(self.data))):
            byte_val = self.data[i]
            if 20 <= byte_val <= 100:  # Reasonable map size
                next_byte = self.data[i+1] if i+1 < len(self.data) else 0
                if 20 <= next_byte <= 100:
                    print(f"Possible dimensions at offset {i}: {byte_val}x{next_byte}")
        
        # Look for tile patterns - usually low values (0-255 but commonly 0-50)
        print(f"\n=== ANALYZING FROM OFFSET {self.offset} ===")
        tile_start = self.offset
        
        # Skip some header bytes and look for tile data
        for skip in [0, 1, 2, 3, 4, 5, 10, 15, 20]:
            test_offset = self.offset + skip
            if test_offset + 100 < len(self.data):
                sample = self.data[test_offset:test_offset+100]
                
                # Count how many bytes are in typical tile range (0-63)
                tile_like = sum(1 for b in sample if b <= 63)
                zero_count = sum(1 for b in sample if b == 0)
                
                print(f"Offset +{skip}: tile-like={tile_like}/100, zeros={zero_count}")
                
                if tile_like > 70:  # Likely tile data
                    print(f"  -> Likely tile data starts at offset {test_offset}")
                    self.show_tile_preview(test_offset, 30, 20)
                    
    def show_tile_preview(self, start_offset, width, height):
        """Show a preview of tile data"""
        print(f"\nTile preview from offset {start_offset} ({width}x{height}):")
        
        for y in range(min(height, 20)):  # Limit rows
            line = f"{y:2d}: "
            for x in range(min(width, 40)):  # Limit cols
                pos = start_offset + y * width + x
                if pos < len(self.data):
                    tile = self.data[pos]
                    if tile == 0:
                        line += " ."
                    elif tile < 10:
                        line += f" {tile}"
                    elif tile < 16:
                        line += f" {tile:x}"
                    else:
                        line += f"{tile:02x}"
                else:
                    line += " ?"
            print(line)
            
    def analyze_separator_sections(self):
        """Analyze data sections separated by 0xFF"""
        print("\n=== ANALYZING SECTIONS ===")
        
        sections = []
        start = 0
        
        while True:
            pos = self.data.find(b'\xff', start)
            if pos == -1:
                sections.append(self.data[start:])
                break
            else:
                sections.append(self.data[start:pos])
                start = pos + 1
                
        print(f"Found {len(sections)} sections:")
        for i, section in enumerate(sections):
            print(f"Section {i}: {len(section)} bytes")
            if len(section) > 0:
                # Show first few bytes
                preview = ' '.join(f'{b:02x}' for b in section[:20])
                print(f"  Start: {preview}...")
                
                # Try to find text
                try:
                    text = section.decode('utf-8', errors='ignore')
                    printable = ''.join(c if c.isprintable() else '.' for c in text)
                    if len(printable.strip()) > 3:
                        print(f"  Text: {printable[:50]}...")
                except:
                    pass
                    
        # Analyze the last section which might contain coordinate data
        if len(sections) > 1:
            last_section = sections[-1]
            print(f"\n=== LAST SECTION ANALYSIS ({len(last_section)} bytes) ===")
            
            # Look for coordinate patterns (pairs of shorts)
            coords = []
            for i in range(0, len(last_section)-1, 2):
                if i + 1 < len(last_section):
                    x = struct.unpack('>H', last_section[i:i+2])[0]
                    if i + 3 < len(last_section):
                        y = struct.unpack('>H', last_section[i+2:i+4])[0]
                        if 0 <= x <= 1000 and 0 <= y <= 1000:  # Reasonable coordinates
                            coords.append((x, y))
                            
            print(f"Found {len(coords)} potential coordinate pairs:")
            for i, (x, y) in enumerate(coords[:20]):  # Show first 20
                print(f"  Point {i}: ({x}, {y})")
        
    def parse_all(self):
        """Parse entire map data"""
        print("=== HSOMOMBI MAP PARSER (FIXED) ===\n")
        
        try:
            self.manual_parse()
            self.analyze_separator_sections()
            
        except Exception as e:
            print(f"Parse error at offset {self.offset}: {e}")
            import traceback
            traceback.print_exc()
            
        return self.parsed

def main():
    # Map data từ user
    hex_data = """00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1E 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 FF 02 72 00 4D 00 01 00 04 00 0A 00 12 00 11 00 0E 00 22 00 0D 00 09 00 23 00 11 00 15 00 01 00 02 00 15 00 03 00 10 00 17 00 06 00 1A 00 10 00 07 00 04 00 1A 00 07 00 13 00 1A 00 07 00 17 00 19 00 07 00 03 00 1A 00 07 00 00 00 1B 00 07 00 34 00 16 00 08 00 0E 00 15 00 0A 00 12 00 01 00 0B 00 2A 00 10 00 0C 00 08 00 0B 00 0C 00 05 00 17 00 0C 00 1D 00 19 00 11 00 11 00 0A 00 11 00 04 00 17 00 17 00 03 00 08 00 17 00 1E 00 02 00 17 00 26 00 1C 00 18 00 11 00 1A 00 18 00 2E 00 19 00 18 00 2A 00 0C 00 00 00 02 00 08 00 00 00 02 00 0D 00 00 00 02 00 04 00 00 00 01 00 06 00 00 00 04 00 03 00 00 00 00 00 0E 00 00 00 08 00 16 00 00 00 00 00 04 00 00 00 02 00 02 00 00 00 05 00 02 00 00 00 06 00 03 00 00 00 00 00 0A 00 00 00 12 00 08 00 00 00 10 00 05 00 00 00 0F 00 03 00 00 00 0E 00 02 00 00 00 13 00 03 00 00 00 15 00 07 00 00 00 15 00 02 00 00 00 0D 00 13 00 00 00 1A 00 18 00 00 00 25 00 1D 00 00 00 27 00 10 00 00 00 28 00 19 00 00 00 2B 00 1B 00 00 00 31 00 16 00 00 00 2B 00 0E 00 01 00 0C 00 04 00 22 00 05 00 04 00 11 00 04 00 06 00 00 00 2B 00 03 00 00 00 20 00 01 00 00 00 1E 00 00 00 00 00 1C 00 02 00 00 00 2C 00 01 00 00 00 33 00 14 00 00 00 35 00 14 00 00 00 25 00 0D 00 00 00 36 00 06 00 00 00 20 00 1C 00 07 00 06 00 19 00 07 00 15 00 19 00 00 00 37 00 0D 00 00 00 35 00 0B 00 00 00 2E 00 07 00 00 00 09 00 00 00 00 00 37 00 1A 00 00 00 0D 00 1C 00 00 00 0F 00 1C 00 55 00 1B 00 08 00 07 03 65 66 66 12 30 3B 31 3B 32 37 3B 38 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 31 3B 37 3B 31 32 3B 31 34 3B 30 3B 30 3B 31 3B 30 03 65 66 66 13 33 3B 34 3B 34 36 3B 32 34 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 34 3B 34 3B 33 38 3B 32 37 3B 30 3B 30 3B 31 3B 30 03 65 66 66 11 35 3B 35 3B 34 31 3B 31 30 3B 30 3B 30 3B 31 3B 30 03 65 66 66 12 36 3B 36 3B 31 32 3B 32 31 3B 30 3B 30 3B 30 3B 38 30 03 65 66 66 13 37 3B 36 3B 31 32 3B 32 34 3B 30 3B 30 3B 30 3B 31 30 30 01 04 C8 00 24 00 12 4C C3 A0 6E 67 20 53 C3 B3 69 20 54 72 E1 BA AF 6E 67 FF"""
    
    parser = HsoMapParser(hex_data)
    result = parser.parse_all()

if __name__ == "__main__":
    main()