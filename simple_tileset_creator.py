#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import struct
import zlib

def create_simple_png_tileset():
    """Create a simple PNG tileset without external dependencies"""
    
    tile_size = 24
    tiles_per_row = 16
    num_rows = 4  # Reduced for simplicity
    
    width = tiles_per_row * tile_size
    height = num_rows * tile_size
    
    # Create RGB data
    pixels = []
    
    for y in range(height):
        row = []
        for x in range(width):
            # Determine which tile we're in
            tile_x = x // tile_size
            tile_y = y // tile_size
            tile_id = tile_y * tiles_per_row + tile_x + 1
            
            # Position within tile
            local_x = x % tile_size
            local_y = y % tile_size
            
            # Generate color based on tile ID
            if tile_id <= 64:  # Only first 64 tiles
                r = (tile_id * 50) % 256
                g = (tile_id * 80) % 256
                b = (tile_id * 120) % 256
                
                # Add border
                if local_x == 0 or local_y == 0 or local_x == tile_size-1 or local_y == tile_size-1:
                    r, g, b = 0, 0, 0  # Black border
                
                # Add tile ID in center (simple pattern)
                center_x, center_y = tile_size // 2, tile_size // 2
                if abs(local_x - center_x) <= 2 and abs(local_y - center_y) <= 2:
                    r, g, b = 255, 255, 255  # White center
                    
            else:
                r, g, b = 128, 128, 128  # Gray for unused tiles
            
            row.extend([r, g, b])
        pixels.append(bytes(row))
    
    # Create PNG file
    png_data = create_png(width, height, pixels)
    
    with open('/workspace/simple_tileset.png', 'wb') as f:
        f.write(png_data)
    
    print(f"Simple tileset created: {width}x{height} pixels")
    print(f"Tiles: {tiles_per_row}x{num_rows} = {tiles_per_row * num_rows} tiles")
    print("File saved as: simple_tileset.png")

def create_png(width, height, pixel_rows):
    """Create a PNG file from RGB pixel data"""
    
    def write_chunk(chunk_type, data):
        chunk_len = len(data)
        crc = zlib.crc32(chunk_type + data) & 0xffffffff
        return struct.pack('>I', chunk_len) + chunk_type + data + struct.pack('>I', crc)
    
    # PNG signature
    png_signature = b'\x89PNG\r\n\x1a\n'
    
    # IHDR chunk
    ihdr_data = struct.pack('>IIBBBBB', width, height, 8, 2, 0, 0, 0)
    ihdr_chunk = write_chunk(b'IHDR', ihdr_data)
    
    # IDAT chunk (image data)
    raw_data = b''
    for row in pixel_rows:
        raw_data += b'\x00'  # Filter type 0 (None)
        raw_data += row
    
    compressed_data = zlib.compress(raw_data)
    idat_chunk = write_chunk(b'IDAT', compressed_data)
    
    # IEND chunk
    iend_chunk = write_chunk(b'IEND', b'')
    
    return png_signature + ihdr_chunk + idat_chunk + iend_chunk

if __name__ == "__main__":
    create_simple_png_tileset()