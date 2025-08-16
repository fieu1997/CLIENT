#!/usr/bin/env python3
"""
Reverse Engineer Working Format
Dựa trên TypeScript code và working data để hiểu đúng format
"""

def analyze_typescript_step_by_step():
    """Phân tích TypeScript code step by step"""
    print("📋 TYPESCRIPT CODE ANALYSIS")
    print("=" * 50)
    
    print("TypeScript logic in handleMapFile:")
    print("1. Skip 2 bytes padding")
    print("2. Read UTF string (map name)")
    print("3. Read short (version)")
    print("4. Read 3 bytes (width, height, tileset)")
    print("5. Read width*height bytes (tiles)")
    print("6. Check if next byte == -1 (0xFF), if yes skip it")  # This is WRONG for our data!
    print("7. Read short (objectBlockLength)")
    print("8. Create separate reader for object block")
    print("9. In object block:")
    print("   - Read short (numIcons)")
    print("   - Loop: read 6 bytes per icon (templateId, x, y)")
    print("   - Read short (internalVgoCount)")
    print("   - Search for eff magic [0x03, 0x65, 0x66, 0x66]")
    print("   - Read VGOs")
    print("10. After object block: read external VGOs")
    print("11. Final EOF check")

def reverse_working_data():
    """Reverse engineering working data"""
    print(f"\n🔍 REVERSE ENGINEERING WORKING DATA")
    print("=" * 50)
    
    with open('complete_working_format.dat', 'rb') as f:
        data = f.read()
    
    # Known structure
    offset = 26  # Header ends
    tiles_size = 58 * 31  # 1798
    tiles_end = offset + tiles_size  # 1824
    
    print(f"Tiles end at: {tiles_end}")
    print(f"Object data starts at: {tiles_end}")
    print(f"Total data: {len(data)} bytes")
    print(f"Object data size: {len(data) - tiles_end} bytes")
    
    # Key insight: TypeScript assumes separator but our data doesn't have it!
    # So object block starts immediately at tiles_end
    
    obj_start = tiles_end
    
    # Try TypeScript logic WITHOUT separator check
    print(f"\n📦 OBJECT BLOCK ANALYSIS (No Separator):")
    
    # Read object block length (first 2 bytes of object data)
    if obj_start + 2 <= len(data):
        obj_length = int.from_bytes(data[obj_start:obj_start+2], 'big')
        print(f"Object block length: {obj_length}")
        
        # This should be reasonable
        remaining = len(data) - obj_start - 2
        if obj_length <= remaining:
            print(f"✅ Object length {obj_length} fits in remaining {remaining}")
            
            # Read object block content
            obj_content_start = obj_start + 2
            obj_content = data[obj_content_start:obj_content_start + obj_length]
            
            print(f"Object content: {len(obj_content)} bytes")
            
            # Parse object content
            parse_object_content(obj_content)
            
            # What's after object block?
            after_obj = obj_content_start + obj_length
            if after_obj < len(data):
                remaining_after = data[after_obj:]
                print(f"\nAfter object block ({after_obj}): {len(remaining_after)} bytes")
                print(f"First bytes: {' '.join(f'{b:02X}' for b in remaining_after[:10])}")
                
                # Check for external VGOs
                if len(remaining_after) > 0:
                    vgo_count = remaining_after[0]
                    print(f"Potential external VGO count: {vgo_count}")
                    
                    if vgo_count < 10:  # Reasonable
                        parse_external_vgos(remaining_after)
        else:
            print(f"❌ Object length {obj_length} > remaining {remaining}")
            print("Maybe no object block length prefix?")

def parse_object_content(content):
    """Parse object block content theo TypeScript logic"""
    print(f"\n🔧 PARSING OBJECT CONTENT ({len(content)} bytes):")
    
    offset = 0
    
    # Read icon count
    if offset + 2 <= len(content):
        icon_count = int.from_bytes(content[offset:offset+2], 'big')
        offset += 2
        print(f"Icon count: {icon_count}")
        
        # Read icons
        icons = []
        for i in range(icon_count):
            if offset + 6 <= len(content):
                template_id = int.from_bytes(content[offset:offset+2], 'big')
                x = int.from_bytes(content[offset+2:offset+4], 'big')
                y = int.from_bytes(content[offset+4:offset+6], 'big')
                icons.append((template_id, x, y))
                offset += 6
            else:
                break
        
        print(f"Read {len(icons)} icons:")
        for i, (tid, x, y) in enumerate(icons[:5]):  # Show first 5
            print(f"  Icon {i}: template={tid}, x={x}, y={y}")
        if len(icons) > 5:
            print(f"  ... and {len(icons) - 5} more")
        
        # Read internal VGO count
        if offset + 2 <= len(content):
            vgo_count = int.from_bytes(content[offset:offset+2], 'big')
            offset += 2
            print(f"Internal VGO count: {vgo_count}")
            
            # Look for eff pattern
            print(f"\nSearching for 'eff' pattern from offset {offset}:")
            eff_magic = b'\x03eff'
            remaining_content = content[offset:]
            eff_pos = remaining_content.find(eff_magic)
            
            if eff_pos != -1:
                print(f"Found 'eff' at relative offset {eff_pos}")
                # Parse eff data
                parse_eff_data(remaining_content, eff_pos)
            else:
                print("No 'eff' pattern found")

def parse_eff_data(content, eff_start):
    """Parse eff data"""
    print(f"\n📄 PARSING EFF DATA:")
    
    offset = eff_start
    eff_count = 0
    
    while offset < len(content):
        # Look for eff magic
        if offset + 4 <= len(content) and content[offset:offset+4] == b'\x03eff':
            offset += 4  # Skip magic
            eff_count += 1
            
            if offset + 1 <= len(content):
                data_length = content[offset]
                offset += 1
                
                if offset + data_length <= len(content):
                    eff_string = content[offset:offset+data_length].decode('utf-8')
                    offset += data_length
                    print(f"  Eff {eff_count}: length={data_length}, data='{eff_string}'")
                else:
                    break
            else:
                break
        else:
            offset += 1
    
    print(f"Found {eff_count} eff blocks")

def parse_external_vgos(data):
    """Parse external VGOs"""
    print(f"\n🌐 PARSING EXTERNAL VGOs:")
    
    if len(data) < 1:
        return
        
    vgo_count = data[0]
    print(f"External VGO count: {vgo_count}")
    
    offset = 1
    for i in range(vgo_count):
        if offset + 4 <= len(data):
            x = int.from_bytes(data[offset:offset+2], 'big')
            y = int.from_bytes(data[offset+2:offset+4], 'big')
            offset += 4
            
            # Read name (UTF string)
            if offset + 2 <= len(data):
                name_len = int.from_bytes(data[offset:offset+2], 'big')
                offset += 2
                
                if offset + name_len <= len(data):
                    name = data[offset:offset+name_len].decode('utf-8')
                    offset += name_len
                    print(f"  VGO {i}: x={x}, y={y}, name='{name}'")
                else:
                    break
            else:
                break
        else:
            break

if __name__ == "__main__":
    analyze_typescript_step_by_step()
    reverse_working_data()