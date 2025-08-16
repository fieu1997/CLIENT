#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from PIL import Image, ImageDraw, ImageFont
import colorsys

def create_sample_tileset():
    """Create a sample tileset for testing the map viewer"""
    
    # Tileset dimensions
    tile_size = 24
    tiles_per_row = 16
    num_rows = 16
    total_tiles = tiles_per_row * num_rows
    
    # Create image
    width = tiles_per_row * tile_size
    height = num_rows * tile_size
    image = Image.new('RGB', (width, height), color='white')
    draw = ImageDraw.Draw(image)
    
    # Try to load a font, fallback to default if not available
    try:
        font = ImageFont.truetype("arial.ttf", 12)
    except:
        try:
            font = ImageFont.load_default()
        except:
            font = None
    
    # Generate tiles
    for tile_id in range(1, total_tiles + 1):
        row = (tile_id - 1) // tiles_per_row
        col = (tile_id - 1) % tiles_per_row
        
        x = col * tile_size
        y = row * tile_size
        
        # Generate color based on tile ID
        hue = (tile_id * 0.618) % 1.0  # Golden ratio for nice color distribution
        saturation = 0.3 + 0.4 * ((tile_id % 7) / 6)  # Varying saturation
        lightness = 0.4 + 0.4 * ((tile_id % 5) / 4)   # Varying lightness
        
        rgb = colorsys.hls_to_rgb(hue, lightness, saturation)
        color = tuple(int(c * 255) for c in rgb)
        
        # Draw tile background
        draw.rectangle([x, y, x + tile_size - 1, y + tile_size - 1], 
                      fill=color, outline='black')
        
        # Add tile ID text
        if font:
            text = str(tile_id)
            # Get text size
            bbox = draw.textbbox((0, 0), text, font=font)
            text_width = bbox[2] - bbox[0]
            text_height = bbox[3] - bbox[1]
            
            # Center text
            text_x = x + (tile_size - text_width) // 2
            text_y = y + (tile_size - text_height) // 2
            
            # Draw text with outline for better visibility
            draw.text((text_x - 1, text_y), text, fill='black', font=font)
            draw.text((text_x + 1, text_y), text, fill='black', font=font)
            draw.text((text_x, text_y - 1), text, fill='black', font=font)
            draw.text((text_x, text_y + 1), text, fill='black', font=font)
            draw.text((text_x, text_y), text, fill='white', font=font)
    
    # Save tileset
    image.save('/workspace/sample_tileset.png', 'PNG')
    print(f"Sample tileset created: {width}x{height} pixels")
    print(f"Tiles: {tiles_per_row}x{num_rows} = {total_tiles} tiles")
    print("File saved as: sample_tileset.png")

if __name__ == "__main__":
    create_sample_tileset()