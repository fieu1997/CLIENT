#!/usr/bin/env python3
"""
Exhaust All Possibilities for Object Structure
Test mọi khả năng cho object data structure
"""

def test_all_endianness():
    """Test big vs little endian"""
    print("🔄 TESTING ENDIANNESS")
    print("=" * 30)
    
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    obj_start = 1824
    obj_data = data[obj_start:]
    
    # Test first 2 bytes
    first_2_big = int.from_bytes(obj_data[0:2], 'big')
    first_2_little = int.from_bytes(obj_data[0:2], 'little')
    
    print(f"First 2 bytes: 0x{obj_data[0]:02X} {obj_data[1]:02X}")
    print(f"Big endian: {first_2_big}")
    print(f"Little endian: {first_2_little}")
    
    # Test if little endian makes sense
    if first_2_little < 1000:  # Reasonable icon count
        print(f"✅ Little endian {first_2_little} seems reasonable")
        test_little_endian_parsing(obj_data)
    
    # Also test if it's not a count at all
    print(f"\n🤔 Maybe not a count? Testing other interpretations...")

def test_little_endian_parsing(obj_data):
    """Test little endian parsing"""
    print(f"\n📋 TESTING LITTLE ENDIAN PARSING:")
    
    offset = 0
    
    # Icon count (little endian)
    icon_count = int.from_bytes(obj_data[offset:offset+2], 'little')
    offset += 2
    print(f"Icon count (LE): {icon_count}")
    
    if icon_count > 1000:
        print(f"❌ Still too large: {icon_count}")
        return
    
    # Read icons
    icons = []
    for i in range(min(icon_count, 100)):  # Limit to 100 for safety
        if offset + 6 <= len(obj_data):
            # Try little endian for coordinates too
            template_id = int.from_bytes(obj_data[offset:offset+2], 'little')
            x = int.from_bytes(obj_data[offset+2:offset+4], 'little') 
            y = int.from_bytes(obj_data[offset+4:offset+6], 'little')
            icons.append((template_id, x, y))
            offset += 6
        else:
            break
    
    print(f"Read {len(icons)} icons (LE):")
    for i, (tid, x, y) in enumerate(icons[:10]):
        print(f"  Icon {i}: template={tid}, x={x}, y={y}")

def test_different_structures():
    """Test completely different structures"""
    print(f"\n🧩 TESTING DIFFERENT STRUCTURES:")
    
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    obj_start = 1824
    obj_data = data[obj_start:]
    
    print(f"Object data: {len(obj_data)} bytes")
    print(f"First 20 bytes: {' '.join(f'{b:02X}' for b in obj_data[:20])}")
    
    # Possibility 1: No icon count, direct icon list with sentinel
    print(f"\n📋 Test 1: Direct icon list (no count)")
    test_direct_icon_list(obj_data)
    
    # Possibility 2: Different byte order (mixed endian)
    print(f"\n📋 Test 2: Mixed endian")
    test_mixed_endian(obj_data)
    
    # Possibility 3: Completely different format
    print(f"\n📋 Test 3: Alternative format")
    test_alternative_format(obj_data)

def test_direct_icon_list(obj_data):
    """Test direct icon list without count"""
    print("Assuming direct 6-byte icon records...")
    
    icons = []
    offset = 0
    
    # Read until we hit unreasonable values
    while offset + 6 <= len(obj_data):
        template_id = int.from_bytes(obj_data[offset:offset+2], 'big')
        x = int.from_bytes(obj_data[offset+2:offset+4], 'big')
        y = int.from_bytes(obj_data[offset+4:offset+6], 'big')
        
        # Stop if values seem unreasonable
        if template_id > 1000 or x > 1000 or y > 1000:
            print(f"  Stopped at offset {offset}: unreasonable values {template_id}, {x}, {y}")
            break
            
        icons.append((template_id, x, y))
        offset += 6
        
        if len(icons) > 100:  # Safety limit
            break
    
    print(f"Found {len(icons)} potential icons:")
    for i, (tid, x, y) in enumerate(icons[:5]):
        print(f"  Icon {i}: template={tid}, x={x}, y={y}")

def test_mixed_endian(obj_data):
    """Test mixed endian (some big, some little)"""
    print("Testing mixed endian interpretations...")
    
    # Try different combinations
    combinations = [
        ("big", "little", "little"),
        ("little", "big", "big"),
        ("big", "big", "little"),
        ("little", "little", "big")
    ]
    
    for i, (tid_endian, x_endian, y_endian) in enumerate(combinations):
        print(f"  Combo {i+1}: template_id={tid_endian}, x={x_endian}, y={y_endian}")
        
        offset = 0
        icons = []
        
        # Skip potential count and try first icon
        if offset + 8 <= len(obj_data):  # Skip 2 bytes + read 6
            # Skip first 2 bytes
            offset += 2
            
            template_id = int.from_bytes(obj_data[offset:offset+2], tid_endian)
            x = int.from_bytes(obj_data[offset+2:offset+4], x_endian)
            y = int.from_bytes(obj_data[offset+4:offset+6], y_endian)
            
            print(f"    First icon: template={template_id}, x={x}, y={y}")

def test_alternative_format(obj_data):
    """Test alternative formats"""
    print("Testing alternative interpretations...")
    
    # Maybe it's coordinate pairs followed by other data
    print("  Interpretation: Coordinate pairs")
    offset = 0
    coords = []
    
    for i in range(min(10, len(obj_data) // 4)):
        if offset + 4 <= len(obj_data):
            x = int.from_bytes(obj_data[offset:offset+2], 'big')
            y = int.from_bytes(obj_data[offset+2:offset+4], 'big')
            coords.append((x, y))
            offset += 4
        else:
            break
    
    print(f"    Coordinate pairs: {coords[:5]}")
    
    # Maybe it's a different structure entirely
    print("  Looking for string data...")
    try:
        # Look for UTF-8 strings
        for i in range(0, min(100, len(obj_data))):
            if obj_data[i] > 0 and obj_data[i] < 50:  # Potential string length
                try:
                    if i + 1 + obj_data[i] <= len(obj_data):
                        potential_string = obj_data[i+1:i+1+obj_data[i]].decode('utf-8')
                        if potential_string.isprintable() and len(potential_string) > 3:
                            print(f"    Potential string at {i}: length={obj_data[i]}, text='{potential_string}'")
                except:
                    pass
    except:
        pass

def analyze_known_patterns():
    """Analyze known patterns from previous analysis"""
    print(f"\n🔍 ANALYZING KNOWN PATTERNS:")
    
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    obj_start = 1824
    obj_data = data[obj_start:]
    
    # We know:
    # - EOF is 0xFF at position 596 (last byte)
    # - "eff" pattern at position 411
    
    print(f"EOF at position: {len(obj_data) - 1} (value: 0x{obj_data[-1]:02X})")
    
    eff_pos = obj_data.find(b'\x03eff')
    if eff_pos != -1:
        print(f"'eff' pattern at position: {eff_pos}")
        
        # What's before eff?
        print(f"Before eff (pos {eff_pos-10} to {eff_pos}):")
        for i in range(max(0, eff_pos-10), eff_pos):
            print(f"  {i}: 0x{obj_data[i]:02X}")
            
        # What's after eff?
        print(f"After eff (pos {eff_pos} to {eff_pos+20}):")
        for i in range(eff_pos, min(len(obj_data), eff_pos+20)):
            print(f"  {i}: 0x{obj_data[i]:02X}")

if __name__ == "__main__":
    test_all_endianness()
    test_different_structures() 
    analyze_known_patterns()