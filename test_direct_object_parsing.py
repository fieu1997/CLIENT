#!/usr/bin/env python3
"""
Test Direct Object Parsing - No Block Length
Test việc đọc object data trực tiếp không có block length prefix
"""

def test_direct_object_parsing():
    """Test đọc object data trực tiếp"""
    print("🔧 TESTING DIRECT OBJECT PARSING")
    print("=" * 50)
    
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    # Object data starts at 1824
    obj_start = 1824
    obj_data = data[obj_start:]
    
    print(f"Object data: {len(obj_data)} bytes")
    
    # Hypothesis: Object data format is:
    # [2 bytes icon count] + [6 bytes per icon] + [2 bytes VGO count] + [VGO data] + [eff data] + [external VGOs] + [EOF]
    
    offset = 0
    
    # Read icon count
    if offset + 2 <= len(obj_data):
        icon_count = int.from_bytes(obj_data[offset:offset+2], 'big')
        offset += 2
        print(f"Icon count: {icon_count}")
        
        # Verify this makes sense
        required_icon_bytes = icon_count * 6
        if offset + required_icon_bytes <= len(obj_data):
            print(f"✅ Icon count {icon_count} requires {required_icon_bytes} bytes - fits")
            
            # Read icons
            icons = []
            for i in range(icon_count):
                template_id = int.from_bytes(obj_data[offset:offset+2], 'big')
                x = int.from_bytes(obj_data[offset+2:offset+4], 'big')
                y = int.from_bytes(obj_data[offset+4:offset+6], 'big')
                icons.append((template_id, x, y))
                offset += 6
                
            print(f"Read {len(icons)} icons:")
            for i, (tid, x, y) in enumerate(icons[:10]):  # Show first 10
                print(f"  Icon {i}: template={tid}, x={x}, y={y}")
            if len(icons) > 10:
                print(f"  ... and {len(icons) - 10} more")
                
            # Read VGO count
            if offset + 2 <= len(obj_data):
                vgo_count = int.from_bytes(obj_data[offset:offset+2], 'big')
                offset += 2
                print(f"\nInternal VGO count: {vgo_count}")
                
                # Search for rest of data
                remaining = obj_data[offset:]
                print(f"Remaining data: {len(remaining)} bytes")
                
                # Look for eff pattern
                eff_magic = b'\x03eff'
                eff_positions = []
                search_offset = 0
                while True:
                    pos = remaining.find(eff_magic, search_offset)
                    if pos == -1:
                        break
                    eff_positions.append(pos)
                    search_offset = pos + 1
                
                print(f"Found {len(eff_positions)} 'eff' patterns at: {eff_positions}")
                
                # Parse eff data
                for i, eff_pos in enumerate(eff_positions):
                    if eff_pos + 5 < len(remaining):
                        data_length = remaining[eff_pos + 4]  # After magic
                        if eff_pos + 5 + data_length <= len(remaining):
                            eff_string = remaining[eff_pos + 5:eff_pos + 5 + data_length].decode('utf-8')
                            print(f"  Eff {i+1}: '{eff_string}'")
                
                # Look for external VGO section
                # Try to find the last section (external VGOs + EOF)
                # EOF is 0xFF at the end
                if obj_data[-1] == 0xFF:
                    print(f"\n✅ Found EOF marker 0xFF at end")
                    
                    # Work backwards to find external VGO section
                    # Format: [count] + [x, y, name] + ... + [0xFF]
                    find_external_vgos(obj_data)
                
        else:
            print(f"❌ Icon count {icon_count} requires {required_icon_bytes} bytes - too large")
    
def find_external_vgos(obj_data):
    """Tìm external VGO section"""
    print(f"\n🌐 SEARCHING FOR EXTERNAL VGOs:")
    
    # Work backwards from EOF
    if obj_data[-1] != 0xFF:
        print("No EOF marker found")
        return
    
    # Look for string pattern before EOF
    # External VGOs have format: count + (x, y, utf_string) + ...
    
    # Try different positions for external VGO start
    for test_start in range(len(obj_data) - 50, len(obj_data) - 1):
        if test_start < 0:
            continue
            
        try:
            # Try to read as VGO count
            if test_start + 1 < len(obj_data):
                potential_count = obj_data[test_start]
                
                if 0 < potential_count < 10:  # Reasonable count
                    print(f"Trying external VGO start at {test_start}, count={potential_count}")
                    
                    offset = test_start + 1
                    success = True
                    vgos = []
                    
                    for i in range(potential_count):
                        if offset + 4 >= len(obj_data):
                            success = False
                            break
                            
                        x = int.from_bytes(obj_data[offset:offset+2], 'big')
                        y = int.from_bytes(obj_data[offset+2:offset+4], 'big')
                        offset += 4
                        
                        if offset + 2 >= len(obj_data):
                            success = False
                            break
                            
                        name_len = int.from_bytes(obj_data[offset:offset+2], 'big')
                        offset += 2
                        
                        if offset + name_len >= len(obj_data):
                            success = False
                            break
                            
                        name = obj_data[offset:offset+name_len].decode('utf-8')
                        offset += name_len
                        vgos.append((x, y, name))
                    
                    # Check if we end up at EOF
                    if success and offset == len(obj_data) - 1 and obj_data[offset] == 0xFF:
                        print(f"✅ Found external VGOs starting at {test_start}:")
                        for i, (x, y, name) in enumerate(vgos):
                            print(f"  VGO {i}: x={x}, y={y}, name='{name}'")
                        return
                        
        except Exception as e:
            continue
    
    print("Could not find external VGO pattern")

if __name__ == "__main__":
    test_direct_object_parsing()