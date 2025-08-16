#!/usr/bin/env python3
"""
Debug Object Block Parsing Issue
"""

import struct
import binascii

def debug_object_block():
    """Debug object block để tìm lỗi parsing"""
    print("🔍 DEBUGGING OBJECT BLOCK PARSING")
    print("=" * 50)
    
    # Load working data
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    print(f"Total data: {len(data)} bytes")
    
    # Parse header to find tiles end
    offset = 2  # Skip padding
    name_len = int.from_bytes(data[offset:offset+2], 'big')
    offset += 2 + name_len + 2 + 3  # name + version + dimensions
    
    width = data[offset - 3]
    height = data[offset - 2]
    tiles_count = width * height
    
    print(f"Map: {width}x{height} = {tiles_count} tiles")
    print(f"Tiles start at offset: {offset}")
    print(f"Tiles end at offset: {offset + tiles_count}")
    
    # Check separator
    separator_offset = offset + tiles_count
    if separator_offset < len(data):
        separator_byte = data[separator_offset]
        print(f"Separator at {separator_offset}: 0x{separator_byte:02X}")
        
        if separator_byte == 0xFF:
            print("✅ Found separator 0xFF")
            object_start = separator_offset + 1
        else:
            print(f"❌ Expected 0xFF but found 0x{separator_byte:02X}")
            # Try to find where objects actually start
            print("🔍 Searching for object data...")
            for i in range(separator_offset, min(separator_offset + 20, len(data))):
                print(f"  Byte {i}: 0x{data[i]:02X}")
            object_start = separator_offset  # No separator
        
        # Read object block length
        if object_start + 2 <= len(data):
            block_length = int.from_bytes(data[object_start:object_start+2], 'big')
            print(f"Object block length at {object_start}: {block_length} (0x{block_length:04X})")
            
            if block_length > 10000:  # Suspiciously large
                print("❌ Block length seems too large, trying little endian...")
                block_length_le = int.from_bytes(data[object_start:object_start+2], 'little')
                print(f"Little endian length: {block_length_le}")
            
            # Show first few bytes of object block
            print(f"Object block content preview:")
            obj_end = min(object_start + 2 + 50, len(data))
            for i in range(object_start, obj_end):
                print(f"  {i:04d}: 0x{data[i]:02X}")
                
        # Try to find pattern manually
        print(f"\n🔍 Looking for 0xFF separator pattern:")
        for i in range(separator_offset - 5, min(separator_offset + 20, len(data))):
            if data[i] == 0xFF:
                print(f"  Found 0xFF at offset {i}")
                
    # Look at actual working object data that we extracted
    print(f"\n📋 REFERENCE: Check extracted object data")
    try:
        with open('extracted_object_data.bin', 'rb') as f:
            obj_data = f.read()
        print(f"Extracted object data: {len(obj_data)} bytes")
        print("First 20 bytes:")
        for i in range(min(20, len(obj_data))):
            print(f"  {i:02d}: 0x{obj_data[i]:02X}")
    except:
        print("No extracted object data found")

def check_typescript_vs_working():
    """So sánh logic TypeScript với working data thực tế"""
    print(f"\n🔍 TYPESCRIPT VS WORKING DATA ANALYSIS")
    print("=" * 50)
    
    # Load working original
    with open('complete_working_format.dat', 'rb') as f:
        working = f.read()
        
    # Compare with expected structure
    print(f"Working data: {len(working)} bytes")
    
    # Header analysis
    offset = 0
    print(f"Offset {offset}: Padding = 0x{working[offset]:02X}{working[offset+1]:02X}")
    offset += 2
    
    name_len = int.from_bytes(working[offset:offset+2], 'big')
    offset += 2
    name = working[offset:offset+name_len].decode('utf-8')
    offset += name_len
    print(f"Map name: '{name}' ({name_len} bytes)")
    
    version = int.from_bytes(working[offset:offset+2], 'big', signed=True)
    offset += 2
    print(f"Version: {version} (0x{version:04X})")
    
    width = working[offset]
    height = working[offset + 1]
    tileset = working[offset + 2]
    offset += 3
    print(f"Dimensions: {width}x{height}, tileset {tileset}")
    
    # Tiles
    tiles_expected = width * height
    tiles_end = offset + tiles_expected
    print(f"Tiles: {tiles_expected} bytes from {offset} to {tiles_end}")
    
    # What comes after tiles?
    if tiles_end < len(working):
        next_bytes = working[tiles_end:tiles_end+10]
        print(f"After tiles ({tiles_end}): {' '.join(f'{b:02X}' for b in next_bytes)}")
        
        # Is first byte 0xFF (separator)?
        if working[tiles_end] == 0xFF:
            print("✅ Found separator 0xFF after tiles")
            obj_start = tiles_end + 1
        else:
            print(f"❌ No separator found, first byte is 0x{working[tiles_end]:02X}")
            obj_start = tiles_end
            
        # Check object block length
        if obj_start + 2 <= len(working):
            obj_len = int.from_bytes(working[obj_start:obj_start+2], 'big')
            print(f"Object block length: {obj_len}")
            
            # Verify this makes sense
            remaining = len(working) - obj_start - 2
            print(f"Remaining data after length field: {remaining} bytes")
            if obj_len > remaining:
                print(f"❌ Object length {obj_len} > remaining {remaining}")
            else:
                print(f"✅ Object length {obj_len} fits in remaining {remaining}")

if __name__ == "__main__":
    debug_object_block()
    check_typescript_vs_working()