#!/usr/bin/env python3
"""
Correct Format Analysis - No Separator
Phân tích lại format đúng dựa trên discovery mới
"""

def analyze_correct_format():
    """Phân tích format đúng dựa trên working data"""
    print("🔍 CORRECT FORMAT ANALYSIS")
    print("=" * 50)
    
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    print(f"Total: {len(data)} bytes")
    
    # Header
    offset = 2  # padding
    name_len = int.from_bytes(data[offset:offset+2], 'big')
    offset += 2 + name_len + 2 + 3  # name + version + dimensions
    
    width = data[offset - 3]
    height = data[offset - 2]
    tiles_count = width * height
    tiles_end = offset + tiles_count
    
    print(f"Header ends at: {offset}")
    print(f"Tiles: {tiles_count} bytes ({offset} to {tiles_end})")
    
    # What's after tiles?
    print(f"\n📦 OBJECT DATA STARTS AT {tiles_end}:")
    
    # The working TypeScript is wrong about separator!
    # Object data starts immediately after tiles
    obj_start = tiles_end
    remaining = len(data) - obj_start
    
    print(f"Remaining object data: {remaining} bytes")
    
    # Try to understand the structure
    print("\nFirst 50 bytes of object data:")
    for i in range(min(50, remaining)):
        pos = obj_start + i
        print(f"  {i:02d} ({pos:04d}): 0x{data[pos]:02X}")
    
    # Pattern analysis
    print(f"\n🔍 PATTERN ANALYSIS:")
    
    # Check if it's icon data (pairs of coordinates)
    print("Assuming pairs of shorts (icon coordinates):")
    for i in range(0, min(40, remaining), 2):
        if obj_start + i + 1 < len(data):
            val = int.from_bytes(data[obj_start + i:obj_start + i + 2], 'big')
            print(f"  Pair {i//2}: {val} (0x{val:04X})")
    
    # Look for separators or patterns
    print(f"\n🔍 SEARCHING FOR PATTERNS:")
    
    # Find 0xFF bytes
    ff_positions = []
    for i in range(obj_start, len(data)):
        if data[i] == 0xFF:
            ff_positions.append(i)
    
    if ff_positions:
        print(f"Found 0xFF at positions: {[p - obj_start for p in ff_positions]}")
        for pos in ff_positions:
            print(f"  Context around {pos}: {' '.join(f'{data[pos-2:pos+3].hex().upper()[i:i+2]}' for i in range(0, 10, 2))}")
    else:
        print("No 0xFF bytes found in object data")
    
    # Look for "eff" pattern
    eff_pattern = b'\x03eff'
    eff_pos = data.find(eff_pattern, obj_start)
    if eff_pos != -1:
        print(f"Found 'eff' pattern at offset {eff_pos} (object offset {eff_pos - obj_start})")
        
    # Look for string patterns
    print(f"\n🔍 STRING PATTERNS:")
    try:
        # Try to find readable text
        for i in range(obj_start, min(obj_start + 200, len(data))):
            # Look for length-prefixed strings
            if data[i] > 0 and data[i] < 50:  # Reasonable string length
                try:
                    text = data[i+1:i+1+data[i]].decode('utf-8')
                    if text.isprintable() and len(text) > 2:
                        print(f"  String at {i}: length={data[i]}, text='{text}'")
                except:
                    pass
    except:
        pass

def compare_with_typescript_assumptions():
    """So sánh với assumptions của TypeScript code"""
    print(f"\n📋 TYPESCRIPT ASSUMPTIONS vs REALITY")
    print("=" * 50)
    
    print("TypeScript assumes:")
    print("  1. ✅ Header format - CORRECT")
    print("  2. ✅ Tiles format - CORRECT") 
    print("  3. ❌ Separator 0xFF after tiles - WRONG!")
    print("  4. ❌ Object block with length prefix - WRONG!")
    print("  5. ❌ Icons as templateId+x+y - NEEDS VERIFICATION")
    
    print("\nReality from working data:")
    print("  1. ✅ Header: padding + name + version + dimensions")
    print("  2. ✅ Tiles: width*height bytes")
    print("  3. ❌ NO separator 0xFF")
    print("  4. ❌ Object data starts immediately after tiles")
    print("  5. ❓ Object structure unknown - needs analysis")

def manual_object_parsing():
    """Manual parsing để hiểu object structure"""
    print(f"\n🔧 MANUAL OBJECT PARSING")
    print("=" * 50)
    
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    # Find object start
    obj_start = 1824
    obj_data = data[obj_start:]
    
    print(f"Object data: {len(obj_data)} bytes")
    
    # Try different interpretations
    offset = 0
    
    # Interpretation 1: Direct icon list
    print("\n📋 Interpretation 1: Direct icon coordinates")
    for i in range(0, min(20, len(obj_data)), 6):  # 6 bytes per icon
        if offset + 6 <= len(obj_data):
            template_id = int.from_bytes(obj_data[i:i+2], 'big')
            x = int.from_bytes(obj_data[i+2:i+4], 'big')
            y = int.from_bytes(obj_data[i+4:i+6], 'big')
            print(f"  Icon {i//6}: template={template_id}, x={x}, y={y}")
    
    # Interpretation 2: Look for length prefix
    print("\n📋 Interpretation 2: Length prefixed data")
    if len(obj_data) >= 2:
        potential_length = int.from_bytes(obj_data[0:2], 'big')
        print(f"First 2 bytes as length: {potential_length}")
        if potential_length < len(obj_data):
            print(f"  This could be valid (< {len(obj_data)})")
        else:
            print(f"  This is too large (> {len(obj_data)})")

if __name__ == "__main__":
    analyze_correct_format()
    compare_with_typescript_assumptions()
    manual_object_parsing()