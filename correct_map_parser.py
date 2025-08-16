#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import struct
import sys

class CorrectMapParser:
    def __init__(self, hex_data):
        # Convert hex string to bytes
        self.data = bytes.fromhex(hex_data.replace(' ', ''))
        self.offset = 0
        self.text_decoder = 'utf-8'
        
    def read_byte(self):
        """Read 1 byte"""
        result = struct.unpack('b', self.data[self.offset:self.offset+1])[0]
        self.offset += 1
        return result
        
    def read_ubyte(self):
        """Read 1 unsigned byte"""
        result = self.data[self.offset]
        self.offset += 1
        return result
        
    def read_short(self):
        """Read 2-byte short (big endian)"""
        result = struct.unpack('>h', self.data[self.offset:self.offset+2])[0]
        self.offset += 2
        return result
        
    def read_ushort(self):
        """Read 2-byte unsigned short (big endian)"""
        result = struct.unpack('>H', self.data[self.offset:self.offset+2])[0]
        self.offset += 2
        return result
        
    def read_utf(self):
        """Read UTF-8 string with length prefix"""
        length = self.read_ushort()
        if length > len(self.data) - self.offset:
            raise ValueError(f"String length {length} exceeds remaining data")
        result = self.data[self.offset:self.offset+length].decode('utf-8')
        self.offset += length
        return result
        
    def read_bytes(self, count):
        """Read specified number of bytes"""
        result = self.data[self.offset:self.offset+count]
        self.offset += count
        return result
        
    def seek(self, offset, from_start=True):
        """Seek to position"""
        if from_start:
            self.offset = offset
        else:
            self.offset += offset
            
    def eof(self):
        """Check if at end of file"""
        return self.offset >= len(self.data)
        
    def get_byte_at(self, offset):
        """Get byte at specific offset without moving position"""
        return struct.unpack('b', self.data[offset:offset+1])[0]
        
    def parse_map(self):
        """Parse HSO map file according to correct format"""
        print("=== HSO MAP PARSER (CORRECT FORMAT) ===\n")
        
        map_data = {}
        
        try:
            # Part 1: Header and Tile Data
            print("📋 PARSING HEADER...")
            
            # Skip 2 bytes padding
            self.seek(2)
            print(f"Skipped padding, now at offset: {self.offset}")
            
            # Read map name
            map_name = self.read_utf()
            map_data['name'] = map_name
            print(f"Map Name: '{map_name}'")
            
            # Read map version
            map_version = self.read_short()
            map_data['version'] = map_version
            print(f"Map Version: {map_version} (0x{map_version:04X})")
            
            # Read dimensions
            width = self.read_ubyte()
            height = self.read_ubyte()
            map_data['width'] = width
            map_data['height'] = height
            print(f"Dimensions: {width} x {height}")
            
            # Read tileset ID
            tileset_id = self.read_ubyte()
            map_data['tileset_id'] = tileset_id
            print(f"Tileset ID: {tileset_id}")
            
            # Read tile data
            print(f"\n🗺️  PARSING TILE DATA...")
            tile_count = width * height
            tile_data = []
            for i in range(tile_count):
                tile_data.append(self.read_ubyte())
                
            # Convert to 2D array
            tile_map = []
            for y in range(height):
                row = tile_data[y * width:(y + 1) * width]
                tile_map.append(row)
                
            map_data['tiles'] = tile_map
            print(f"Read {tile_count} tiles ({width}x{height})")
            
            # Show tile preview
            print("\nTile Map Preview (first 10 rows):")
            for y in range(min(10, height)):
                line = f"{y:2d}: "
                for x in range(min(20, width)):
                    tile = tile_map[y][x]
                    if tile == 0:
                        line += " ."
                    elif tile < 10:
                        line += f" {tile}"
                    else:
                        line += f"{tile:2x}"
                print(line)
                
            # Part 2: Check for separator
            print(f"\n🔍 CHECKING SEPARATOR...")
            if not self.eof() and self.get_byte_at(self.offset) == -1:
                separator = self.read_byte()
                print(f"Found separator: {separator} (0xFF)")
            else:
                print("No separator found")
                
            # Part 3: Object Block
            if not self.eof():
                print(f"\n📦 PARSING OBJECT BLOCK...")
                object_block_length = self.read_short()
                print(f"Object block length: {object_block_length} bytes")
                
                object_block_start = self.offset
                
                # Effect Objects (Icons)
                num_icons = self.read_short()
                print(f"Number of effect objects: {num_icons}")
                
                effect_objects = []
                for i in range(num_icons):
                    if self.offset + 6 > object_block_start + object_block_length:
                        break
                    template_id = self.read_short()
                    x = self.read_short()
                    y = self.read_short()
                    effect_objects.append({
                        'template_id': template_id,
                        'x': x * 24,  # Convert to pixels
                        'y': y * 24,
                        'name': f'Effect ID: {template_id}'
                    })
                    print(f"  Effect {i}: ID={template_id}, pos=({x}, {y})")
                    
                map_data['effect_objects'] = effect_objects
                
                # Internal VGO count
                if self.offset + 2 <= object_block_start + object_block_length:
                    internal_vgo_count = self.read_short()
                    print(f"Internal VGO count: {internal_vgo_count}")
                    map_data['internal_vgo_count'] = internal_vgo_count
                
                # Parse remaining object data
                vgos = []
                eff_data = []
                
                while self.offset < object_block_start + object_block_length:
                    # Check for eff magic number
                    if (self.offset + 4 <= object_block_start + object_block_length and
                        self.data[self.offset:self.offset+4] == b'\x03eff'):
                        
                        # Skip magic
                        self.offset += 4
                        
                        # Read eff data
                        try:
                            data_length = self.read_ubyte()
                            if self.offset + data_length <= object_block_start + object_block_length:
                                eff_string_bytes = self.read_bytes(data_length)
                                eff_string = eff_string_bytes.decode('utf-8', errors='replace')
                                
                                parts = eff_string.split(';')
                                if len(parts) >= 4:
                                    try:
                                        eff_id = int(parts[1])
                                        eff_x = int(parts[2])
                                        eff_y = int(parts[3])
                                        eff_data.append({
                                            'id': eff_id,
                                            'x': eff_x * 24,
                                            'y': eff_y * 24,
                                            'name': f'Eff ID: {eff_id}',
                                            'text': f'Eff: {eff_id}',
                                            'raw': eff_string
                                        })
                                        print(f"  Eff: ID={eff_id}, pos=({eff_x}, {eff_y})")
                                    except ValueError:
                                        pass
                            else:
                                break
                        except:
                            break
                            
                    elif self.offset + 5 <= object_block_start + object_block_length:
                        # Try to parse VGO
                        try:
                            vgo_x = self.read_short()
                            vgo_y = self.read_short()
                            vgo_type = self.read_ubyte()
                            
                            if vgo_type == 0:
                                # Type 0: byte-length name
                                name_length = self.read_ubyte()
                                if self.offset + name_length <= object_block_start + object_block_length:
                                    name_bytes = self.read_bytes(name_length)
                                    name = name_bytes.decode('utf-8', errors='replace')
                                else:
                                    break
                            elif vgo_type == 1:
                                # Type 1: UTF string name
                                if self.offset + 2 <= object_block_start + object_block_length:
                                    name = self.read_utf()
                                else:
                                    break
                            else:
                                break
                                
                            vgos.append({
                                'x': vgo_x,
                                'y': vgo_y,
                                'name': name,
                                'map_go_id': vgo_type + 1
                            })
                            print(f"  VGO: pos=({vgo_x}, {vgo_y}), type={vgo_type}, name='{name}'")
                            
                        except:
                            break
                    else:
                        break
                        
                map_data['vgos'] = vgos
                map_data['eff_data'] = eff_data
                print(f"Total VGOs: {len(vgos)}, Eff blocks: {len(eff_data)}")
                
                # Skip to end of object block
                self.seek(object_block_start + object_block_length)
                
            # Part 4: External VGOs
            if not self.eof():
                print(f"\n🌐 PARSING EXTERNAL VGOS...")
                try:
                    external_vgo_count = self.read_ubyte()
                    if 0 < external_vgo_count < 100:
                        external_vgos = []
                        for i in range(external_vgo_count):
                            if self.eof():
                                break
                            x = self.read_short()
                            y = self.read_short()
                            name = self.read_utf()
                            external_vgos.append({
                                'x': x, 'y': y, 'name': name, 'map_go_id': 100
                            })
                            print(f"  External VGO {i}: pos=({x}, {y}), name='{name}'")
                        map_data['external_vgos'] = external_vgos
                    else:
                        print("No external VGOs")
                except:
                    print("No external VGO data")
                    
            print(f"\n✅ PARSING COMPLETE!")
            return map_data
            
        except Exception as e:
            print(f"❌ Parse error at offset {self.offset}: {e}")
            import traceback
            traceback.print_exc()
            return None

def main():
    # Map data từ user
    hex_data = """00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1E 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 FF 02 72 00 4D 00 01 00 04 00 0A 00 12 00 11 00 0E 00 22 00 0D 00 09 00 23 00 11 00 15 00 01 00 02 00 15 00 03 00 10 00 17 00 06 00 1A 00 10 00 07 00 04 00 1A 00 07 00 13 00 1A 00 07 00 17 00 19 00 07 00 03 00 1A 00 07 00 00 00 1B 00 07 00 34 00 16 00 08 00 0E 00 15 00 0A 00 12 00 01 00 0B 00 2A 00 10 00 0C 00 08 00 0B 00 0C 00 05 00 17 00 0C 00 1D 00 19 00 11 00 11 00 0A 00 11 00 04 00 17 00 17 00 03 00 08 00 17 00 1E 00 02 00 17 00 26 00 1C 00 18 00 11 00 1A 00 18 00 2E 00 19 00 18 00 2A 00 0C 00 00 00 02 00 08 00 00 00 02 00 0D 00 00 00 02 00 04 00 00 00 01 00 06 00 00 00 04 00 03 00 00 00 00 00 0E 00 00 00 08 00 16 00 00 00 00 00 04 00 00 00 02 00 02 00 00 00 05 00 02 00 00 00 06 00 03 00 00 00 00 00 0A 00 00 00 12 00 08 00 00 00 10 00 05 00 00 00 0F 00 03 00 00 00 0E 00 02 00 00 00 13 00 03 00 00 00 15 00 07 00 00 00 15 00 02 00 00 00 0D 00 13 00 00 00 1A 00 18 00 00 00 25 00 1D 00 00 00 27 00 10 00 00 00 28 00 19 00 00 00 2B 00 1B 00 00 00 31 00 16 00 00 00 2B 00 0E 00 01 00 0C 00 04 00 22 00 05 00 04 00 11 00 04 00 06 00 00 00 2B 00 03 00 00 00 20 00 01 00 00 00 1E 00 00 00 00 00 1C 00 02 00 00 00 2C 00 01 00 00 00 33 00 14 00 00 00 35 00 14 00 00 00 25 00 0D 00 00 00 36 00 06 00 00 00 20 00 1C 00 07 00 06 00 19 00 07 00 15 00 19 00 00 00 37 00 0D 00 00 00 35 00 0B 00 00 00 2E 00 07 00 00 00 09 00 00 00 00 00 37 00 1A 00 00 00 0D 00 1C 00 00 00 0F 00 1C 00 55 00 1B 00 08 00 07 03 65 66 66 12 30 3B 31 3B 32 37 3B 38 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 31 3B 37 3B 31 32 3B 31 34 3B 30 3B 30 3B 31 3B 30 03 65 66 66 13 33 3B 34 3B 34 36 3B 32 34 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 34 3B 34 3B 33 38 3B 32 37 3B 30 3B 30 3B 31 3B 30 03 65 66 66 11 35 3B 35 3B 34 31 3B 31 30 3B 30 3B 30 3B 31 3B 30 03 65 66 66 12 36 3B 36 3B 31 32 3B 32 31 3B 30 3B 30 3B 30 3B 38 30 03 65 66 66 13 37 3B 36 3B 31 32 3B 32 34 3B 30 3B 30 3B 30 3B 31 30 30 01 04 C8 00 24 00 12 4C C3 A0 6E 67 20 53 C3 B3 69 20 54 72 E1 BA AF 6E 67 FF"""
    
    parser = CorrectMapParser(hex_data)
    result = parser.parse_map()
    
    if result:
        print(f"\n📊 SUMMARY:")
        print(f"  Map: '{result['name']}'")
        print(f"  Version: {result['version']}")
        print(f"  Size: {result['width']}x{result['height']}")
        print(f"  Tileset: {result['tileset_id']}")
        print(f"  Effect Objects: {len(result.get('effect_objects', []))}")
        print(f"  VGOs: {len(result.get('vgos', []))}")
        print(f"  Eff Data: {len(result.get('eff_data', []))}")

if __name__ == "__main__":
    main()