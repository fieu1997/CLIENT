#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import sys
import os

def check_dependencies():
    """Check if required dependencies are available"""
    missing_deps = []
    
    try:
        import PyQt6
        print("✅ PyQt6 found")
    except ImportError:
        missing_deps.append("PyQt6")
        print("❌ PyQt6 not found")
    
    if missing_deps:
        print("\n🚨 Missing dependencies:")
        for dep in missing_deps:
            print(f"  - {dep}")
        
        print("\n📝 To install missing dependencies:")
        print("pip install PyQt6")
        print("\nOr if you're in a managed environment:")
        print("python3 -m venv venv")
        print("source venv/bin/activate")
        print("pip install PyQt6")
        return False
    
    return True

def main():
    print("=== HSO Map Viewer Launcher ===\n")
    
    # Check if we're in the right directory
    if not os.path.exists('hso_map_viewer.py'):
        print("❌ hso_map_viewer.py not found in current directory")
        print("Please run this script from the same directory as hso_map_viewer.py")
        return
    
    # Check dependencies
    if not check_dependencies():
        return
    
    # Check for test files
    print("\n📁 Available test files:")
    if os.path.exists('test_map.bin'):
        print("✅ test_map.bin (HSO map data)")
    else:
        print("❌ test_map.bin not found")
        
    if os.path.exists('simple_tileset.png'):
        print("✅ simple_tileset.png (sample tileset)")
    else:
        print("❌ simple_tileset.png not found")
        print("   Run: python3 simple_tileset_creator.py")
    
    print("\n🚀 Starting HSO Map Viewer...")
    print("📋 Instructions:")
    print("  1. Click 'Tải Map Data' and select test_map.bin")
    print("  2. Click 'Tải Tileset' and select simple_tileset.png")
    print("  3. Use mouse wheel to zoom, drag to pan")
    print()
    
    # Import and run the map viewer
    try:
        from hso_map_viewer import main as run_viewer
        run_viewer()
    except ImportError as e:
        print(f"❌ Error importing map viewer: {e}")
        print("Make sure hso_map_viewer.py is in the current directory")
    except Exception as e:
        print(f"❌ Error running map viewer: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    main()