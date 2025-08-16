#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
HSO Map Viewer - Standalone Edition (Fixed)
Ứng dụng PyQt6 để xem và phân tích bản đồ HsoMobi (Huyền Thoại Sơn Hà)

Tích hợp đầy đủ với terminology chính xác:
- Map parser 
- PyQt6 GUI
- Embedded test map data
- Generated sample tileset
- Dark theme
- Correct object visualization

Phân tích chính xác:
- 77 Decorative Icons (effect objects) - cây cối, đá, decorations
- 7 Effect Triggers (eff data) - game events/triggers  
- 1 Map Warp (external VGO) - portal to "Làng Sói Trắng"

Cách sử dụng:
    python3 hso_map_viewer_standalone_fixed.py

Dependencies:
    pip install PyQt6

Author: AI Assistant
License: Open Source
"""

import sys
import struct
import base64
import zlib
import io
import binascii
from PyQt6.QtWidgets import (QApplication, QMainWindow, QWidget, QVBoxLayout, 
                             QHBoxLayout, QPushButton, QLabel, QFileDialog, 
                             QScrollArea, QFrame, QTextEdit, QSplitter,
                             QGroupBox, QMessageBox, QComboBox)
from PyQt6.QtCore import Qt, QRect, pyqtSignal
from PyQt6.QtGui import QPainter, QPixmap, QColor, QPen, QFont, QBrush

TILE_SIZE = 24

# Map name lookup table from df.java
MAP_NAMES = [
    "Ngôi Làng Nhỏ", "Làng Sói Trắng", "Khu mỏ", "Bìa Rừng", "Hang Lửa", 
    "Rừng Ảo Giác", "Khe Vực", "Cánh Đồng Sói", "Thung Lũng Kỳ Bí", "Hồ Ký Ức",
    "Bãi Đất Trống", "Bờ Biển", "Vực Đá", "Rặng Đá Ngầm", "Nghĩa Địa Tàu Đắm",
    "Đầm Lầy", "Đền Cổ", "Hang Dơi", "Hang Sói Quỷ", "Cửa Biển",
    "Sa Mạc", "Đồi Cát", "Vực Lún", "Hố Tử Thần", "Nghĩa địa cát",
    "Rừng Chết", "Suối Ma", "Thung Lũng Đá", "Boss Guardian", "Hầm Mộ Tầng 1",
    "Hầm Mộ Tầng 2", "Hầm Mộ Tầng 3", "Hầm mộ quái vật", "Thành Phố Kho Báu", 
    "Khu phía Tây", "Khu phía Đông", "Đấu Trường", "Rừng cao nguyên", 
    "Con đường hiểm trở", "Vách đá cheo leo"
]

# ============================================================================
# EMBEDDED TEST MAP DATA (HSO Format)
# ============================================================================
EMBEDDED_MAP_HEX = """00 00 00 11 4E 67 C3 B4 69 20 4C C3 A0 6E 67 20 4E 68 E1 BB 8F 06 CF 3A 1E 00 2E 2F 30 31 31 32 2D 38 02 02 39 2E 2E 2E 2E 38 01 02 01 30 2D 2E 2E 38 02 02 39 2F 32 01 02 01 02 30 2D 2E 2E 38 02 02 01 39 2F 01 02 02 01 34 01 0D 05 05 0E 02 2D 38 02 02 31 32 01 02 01 01 30 2D 2E 2E 2F 31 31 31 31 2D 2E 38 02 02 30 31 31 2D 2E 2E 2F 32 02 02 01 03 02 24 30 31 31 2D 38 02 39 2F 32 02 01 02 02 34 01 0D 05 05 05 09 30 33 01 02 01 01 01 02 02 01 01 30 31 31 32 01 02 01 01 30 31 33 01 02 01 02 01 30 31 31 32 01 02 03 02 02 01 02 01 02 01 30 2D 2E 2F 32 01 02 02 02 39 2F 07 05 05 05 05 0C 02 33 02 02 01 02 04 02 02 02 02 01 02 01 02 01 02 02 25 01 01 2D 38 02 03 01 02 02 01 02 02 01 02 02 01 01 01 02 02 02 02 01 30 31 32 02 04 02 02 01 34 32 0D 05 05 05 0E 02 35 3A 24 02 01 01 02 01 01 01 02 02 01 02 02 02 02 01 02 24 02 30 2D 38 02 01 01 07 09 01 02 01 25 07 08 08 09 01 02 01 02 02 02 01 02 02 01 01 02 39 2F 07 05 05 05 05 0C 25 33 02 02 01 02 02 01 01 03 03 02 02 03 01 02 01 02 01 01 02 02 02 30 33 01 04 07 05 06 08 09 02 07 05 05 05 0C 02 35 36 37 25 01 02 01 02 02 02 39 2F 32 0D 05 06 05 0E 03 35 3A 02 02 07 01 02 01 02 01 25 02 01 01 03 02 04 02 01 01 01 01 02 01 2D 38 02 0D 06 05 06 05 08 06 06 05 0E 02 35 3A 02 3B 36 37 01 02 01 01 03 34 32 07 06 06 05 06 0C 02 33 01 04 07 06 03 01 02 01 02 01 01 02 02 01 01 01 01 02 02 01 02 02 01 30 33 02 0A 0B 05 06 05 06 05 06 0B 0C 02 33 25 02 02 02 34 02 02 03 01 02 34 02 0A 05 05 05 0E 01 03 33 02 03 0D 06 02 01 02 02 01 02 02 03 02 02 01 02 01 01 02 01 03 02 02 01 33 01 02 02 0A 05 06 06 06 0C 02 25 02 2D 38 02 01 39 2F 02 03 02 39 2E 2F 26 26 0D 06 06 0E 26 26 2D 38 02 0A 05 02 02 01 01 02 01 02 01 01 01 02 02 01 02 01 02 02 01 02 01 33 02 03 02 07 06 06 05 06 09 02 01 02 30 2D 2E 2E 2F 32 01 02 02 34 31 32 02 07 05 05 05 0C 02 02 30 2D 38 02 0A 07 08 09 01 02 01 02 01 02 02 01 01 02 02 02 01 01 02 01 01 2D 38 02 02 0A 0B 06 06 05 06 08 09 01 02 30 31 31 32 02 02 02 39 2F 24 02 01 0D 05 06 06 09 01 02 02 30 2D 2E 38 0A 0B 0C 01 03 02 01 02 02 02 01 02 01 02 01 03 02 01 25 02 30 2D 2E 38 02 03 0A 06 05 06 06 0E 02 02 02 01 02 02 02 03 39 2F 32 02 02 03 0A 05 05 06 06 09 02 02 02 30 31 33 01 26 26 01 01 02 02 01 26 26 01 26 26 01 02 02 01 01 01 26 02 30 31 33 03 02 02 0A 06 05 05 0C 02 39 2E 38 03 01 02 02 34 32 02 03 01 02 01 0A 06 06 05 05 09 02 24 02 02 33 01 02 01 02 02 02 02 01 01 01 01 02 03 02 02 01 02 02 02 28 03 02 02 2D 38 02 03 2A 0D 06 0E 29 02 34 31 33 02 02 39 2E 2F 24 02 01 02 01 02 02 0D 05 05 06 0E 03 02 01 04 33 01 01 02 02 01 02 01 07 08 08 08 09 01 01 02 02 03 03 02 28 26 26 26 30 2D 2E 2E 2F 10 10 10 2D 2E 2F 02 2D 2E 2E 2F 31 32 02 01 02 03 25 02 01 0D 06 06 05 0C 02 01 02 35 3A 09 02 01 01 07 08 08 06 05 06 06 06 08 08 08 09 02 02 02 01 02 01 02 01 30 31 31 32 10 10 10 30 31 32 02 30 31 31 32 02 01 02 01 02 03 02 01 07 06 05 05 0E 02 01 02 01 33 02 06 08 08 08 05 06 05 06 06 05 06 05 06 06 05 05 08 09 02 02 07 08 09 01 02 02 02 02 0D 06 06 09 01 02 02 01 02 02 02 03 02 01 02 02 02 02 07 06 05 06 05 0E 02 01 02 25 33 02 06 05 05 06 06 05 05 05 05 0B 0B 06 05 05 05 06 05 06 08 08 05 06 06 08 08 09 01 07 06 05 06 06 09 01 02 07 08 09 03 02 02 02 01 02 03 07 05 05 06 06 06 0E 24 02 01 02 33 03 05 05 05 05 05 0B 0B 0B 0C 02 02 0A 0B 0B 06 05 06 05 06 06 05 05 06 05 06 05 08 06 05 06 05 05 05 08 08 05 06 05 08 08 08 09 02 02 07 06 06 05 06 06 0B 0C 01 03 02 35 3A 25 05 05 05 0B 0C 01 02 01 03 01 02 02 02 01 0A 0B 0B 05 05 05 06 0B 0B 06 05 05 05 06 06 05 05 05 06 06 05 06 05 05 06 06 05 06 08 08 06 05 06 05 06 0E 02 01 02 01 02 33 01 02 0A 0B 0C 02 03 01 01 03 01 1A 1B 1B 1B 1C 02 02 02 0A 0B 0B 0C 02 02 0A 05 06 06 05 06 05 06 05 06 05 06 05 0B 06 05 06 06 06 06 05 05 06 06 06 0B 0C 01 04 01 02 02 33 03 01 02 02 01 02 02 03 02 01 02 1D 22 22 22 22 1B 1C 02 02 02 01 03 02 02 02 0A 0B 05 05 06 05 06 06 05 05 0B 0C 02 0A 0B 06 05 05 06 05 06 06 0B 0C 03 02 01 01 02 03 35 3A 02 02 01 02 02 02 01 02 02 01 03 01 20 22 22 22 22 21 03 02 02 03 01 02 03 02 02 01 0D 06 06 05 05 0B 0B 0C 01 03 02 01 02 0A 06 06 05 06 06 0C 01 02 02 01 02 35 36 36 3A 02 02 25 01 02 03 02 01 02 24 01 02 1A 22 22 23 22 22 1F 02 01 02 26 26 02 02 02 01 02 0A 0B 0B 0B 0C 02 01 02 01 02 01 02 01 03 0A 0B 0B 0B 0C 03 01 02 01 35 36 3A 03 02 01 02 25 35 02 02 03 04 02 02 02 25 01 1D 22 22 22 1E 1F 25 01 26 26 27 02 02 01 02 02 02 01 02 03 01 03 01 02 02 02 01 02 01 02 02 02 01 02 01 03 02 02 02 35 3A 02 24 02 01 01 02 35 3A 01 02 01 01 02 02 35 36 36 37 1D 1E 1F 25 01 03 01 01 01 02 01 35 36 36 36 37 02 01 03 01 01 02 02 01 01 02 01 04 01 02 01 02 01 02 01 01 01 01 33 25 01 07 08 08 09 02 33 02 01 01 35 36 36 36 3A 01 02 3B 37 02 02 02 01 01 02 02 01 35 36 3A 01 02 02 3B 37 02 01 02 24 01 01 02 01 03 03 02 02 01 02 01 02 01 02 02 02 35 3A 01 07 05 05 05 0C 02 33 02 36 36 3A 01 02 01 03 01 01 03 34 02 24 02 01 03 02 01 35 3A 02 01 04 01 02 02 3B 36 37 02 02 04 02 01 03 01 01 02 01 03 01 01 02 02 02 01 02 33 03 02 0D 05 05 0C 01 35 3A 02 01 03 01 07 08 09 01 07 09 01 3B 37 03 01 02 02 25 35 3A 02 02 03 01 02 02 25 02 02 3B 36 37 02 02 01 02 24 01 01 02 02 02 25 02 03 01 02 35 3A 02 07 05 05 0C 01 35 3A 02 01 01 01 07 05 05 05 08 05 05 09 01 3B 36 36 36 37 25 33 02 02 25 03 07 08 08 08 09 02 02 03 3B 37 02 01 02 24 02 01 02 02 25 02 02 03 01 02 33 03 02 0D 05 0E 01 35 3A 02 02 02 FF 02 72 00 4D 00 01 00 04 00 0A 00 12 00 11 00 0E 00 22 00 0D 00 09 00 23 00 11 00 15 00 01 00 02 00 15 00 03 00 10 00 17 00 06 00 1A 00 10 00 07 00 04 00 1A 00 07 00 13 00 1A 00 07 00 17 00 19 00 07 00 03 00 1A 00 07 00 00 00 1B 00 07 00 34 00 16 00 08 00 0E 00 15 00 0A 00 12 00 01 00 0B 00 2A 00 10 00 0C 00 08 00 0B 00 0C 00 05 00 17 00 0C 00 1D 00 19 00 11 00 11 00 0A 00 11 00 04 00 17 00 17 00 03 00 08 00 17 00 1E 00 02 00 17 00 26 00 1C 00 18 00 11 00 1A 00 18 00 2E 00 19 00 18 00 2A 00 0C 00 00 00 02 00 08 00 00 00 02 00 0D 00 00 00 02 00 04 00 00 00 01 00 06 00 00 00 04 00 03 00 00 00 00 00 0E 00 00 00 08 00 16 00 00 00 00 00 04 00 00 00 02 00 02 00 00 00 05 00 02 00 00 00 06 00 03 00 00 00 00 00 0A 00 00 00 12 00 08 00 00 00 10 00 05 00 00 00 0F 00 03 00 00 00 0E 00 02 00 00 00 13 00 03 00 00 00 15 00 07 00 00 00 15 00 02 00 00 00 0D 00 13 00 00 00 1A 00 18 00 00 00 25 00 1D 00 00 00 27 00 10 00 00 00 28 00 19 00 00 00 2B 00 1B 00 00 00 31 00 16 00 00 00 2B 00 0E 00 01 00 0C 00 04 00 22 00 05 00 04 00 11 00 04 00 06 00 00 00 2B 00 03 00 00 00 20 00 01 00 00 00 1E 00 00 00 00 00 1C 00 02 00 00 00 2C 00 01 00 00 00 33 00 14 00 00 00 35 00 14 00 00 00 25 00 0D 00 00 00 36 00 06 00 00 00 20 00 1C 00 07 00 06 00 19 00 07 00 15 00 19 00 00 00 37 00 0D 00 00 00 35 00 0B 00 00 00 2E 00 07 00 00 00 09 00 00 00 00 00 37 00 1A 00 00 00 0D 00 1C 00 00 00 0F 00 1C 00 55 00 1B 00 08 00 07 03 65 66 66 12 30 3B 31 3B 32 37 3B 38 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 31 3B 37 3B 31 32 3B 31 34 3B 30 3B 30 3B 31 3B 30 03 65 66 66 13 33 3B 34 3B 34 36 3B 32 34 3B 31 32 3B 31 32 3B 31 3B 30 03 65 66 66 11 34 3B 34 3B 33 38 3B 32 37 3B 30 3B 30 3B 31 3B 30 03 65 66 66 11 35 3B 35 3B 34 31 3B 31 30 3B 30 3B 30 3B 31 3B 30 03 65 66 66 12 36 3B 36 3B 31 32 3B 32 31 3B 30 3B 30 3B 30 3B 38 30 03 65 66 66 13 37 3B 36 3B 31 32 3B 32 34 3B 30 3B 30 3B 30 3B 31 30 30 01 04 C8 00 24 00 12 4C C3 A0 6E 67 20 53 C3 B3 69 20 54 72 E1 BA AF 6E 67 FF"""

# ============================================================================
# MAP DATA CLASSES
# ============================================================================
class MapData:
    def __init__(self):
        self.name = ""
        self.version = 0
        self.width = 0
        self.height = 0
        self.tileset_id = 0
        self.tiles = []
        self.decorative_icons = []  # Renamed from effect_objects for clarity
        self.internal_vgos = []     # Internal warps 
        self.effect_triggers = []   # Renamed from eff_data for clarity
        self.map_warps = []         # Renamed from external_vgos for clarity

class MapParser:
    def __init__(self, data):
        self.data = data
        self.offset = 0
        
    def read_byte(self):
        result = struct.unpack('b', self.data[self.offset:self.offset+1])[0]
        self.offset += 1
        return result
        
    def read_ubyte(self):
        result = self.data[self.offset]
        self.offset += 1
        return result
        
    def read_short(self):
        result = struct.unpack('>h', self.data[self.offset:self.offset+2])[0]
        self.offset += 2
        return result
        
    def read_ushort(self):
        result = struct.unpack('>H', self.data[self.offset:self.offset+2])[0]
        self.offset += 2
        return result
        
    def read_utf(self):
        length = self.read_ushort()
        if length > len(self.data) - self.offset:
            raise ValueError(f"String length {length} exceeds remaining data")
        result = self.data[self.offset:self.offset+length].decode('utf-8')
        self.offset += length
        return result
        
    def read_bytes(self, count):
        result = self.data[self.offset:self.offset+count]
        self.offset += count
        return result
        
    def seek(self, offset, from_start=True):
        if from_start:
            self.offset = offset
        else:
            self.offset += offset
            
    def eof(self):
        return self.offset >= len(self.data)
        
    def get_byte_at(self, offset):
        return struct.unpack('b', self.data[offset:offset+1])[0]
        
    def parse(self):
        map_data = MapData()
        
        try:
            # Skip padding
            self.seek(2)
            
            # Read header
            map_data.name = self.read_utf()
            map_data.version = self.read_short()
            map_data.width = self.read_ubyte()
            map_data.height = self.read_ubyte()
            map_data.tileset_id = self.read_ubyte()
            
            # Read tile data
            tile_count = map_data.width * map_data.height
            tile_data = []
            for i in range(tile_count):
                tile_data.append(self.read_ubyte())
                
            # Convert to 2D array
            for y in range(map_data.height):
                row = tile_data[y * map_data.width:(y + 1) * map_data.width]
                map_data.tiles.append(row)
                
            # Check for separator
            if not self.eof() and self.get_byte_at(self.offset) == -1:
                self.read_byte()  # Skip separator
                
            # Parse object block
            if not self.eof():
                object_block_length = self.read_short()
                object_block_start = self.offset
                
                # Decorative Icons (Effect Objects)
                num_icons = self.read_short()
                for i in range(num_icons):
                    if self.offset + 6 > object_block_start + object_block_length:
                        break
                    template_id = self.read_short()
                    x = self.read_short()
                    y = self.read_short()
                                         map_data.decorative_icons.append({
                         'template_id': template_id,
                         'x': x * TILE_SIZE,  # Convert to pixels like TypeScript
                         'y': y * TILE_SIZE,  # Convert to pixels like TypeScript
                         'name': f'Icon ID: {template_id}'
                     })
                    
                # Internal VGO count
                if self.offset + 2 <= object_block_start + object_block_length:
                    internal_vgo_count = self.read_short()
                
                # Parse Internal VGOs and Effect Triggers
                while self.offset < object_block_start + object_block_length:
                    # Check for effect trigger magic
                    if (self.offset + 4 <= object_block_start + object_block_length and
                        self.data[self.offset:self.offset+4] == b'\x03eff'):
                        
                        self.offset += 4  # Skip magic
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
                                                                                 map_data.effect_triggers.append({
                                             'id': eff_id,
                                             'x': eff_x * TILE_SIZE,  # Convert to pixels
                                             'y': eff_y * TILE_SIZE,  # Convert to pixels
                                             'name': f'Trigger ID: {eff_id}',
                                             'raw': eff_string
                                         })
                                    except ValueError:
                                        pass
                            else:
                                break
                        except:
                            break
                            
                    elif self.offset + 5 <= object_block_start + object_block_length:
                        # Try to parse Internal VGO
                        try:
                            vgo_x = self.read_short()
                            vgo_y = self.read_short()
                            vgo_type = self.read_ubyte()
                            
                            if vgo_type == 0:
                                name_length = self.read_ubyte()
                                if self.offset + name_length <= object_block_start + object_block_length:
                                    name_bytes = self.read_bytes(name_length)
                                    name = name_bytes.decode('utf-8', errors='replace')
                                else:
                                    break
                            elif vgo_type == 1:
                                if self.offset + 2 <= object_block_start + object_block_length:
                                    name = self.read_utf()
                                else:
                                    break
                            else:
                                break
                                
                                                         map_data.internal_vgos.append({
                                 'x': vgo_x * TILE_SIZE,  # Convert to pixels
                                 'y': vgo_y * TILE_SIZE,  # Convert to pixels
                                 'name': name,
                                 'type': vgo_type
                             })
                            
                        except:
                            break
                    else:
                        break
                        
                # Skip to end of object block
                self.seek(object_block_start + object_block_length)
                
            # Parse Map Warps (External VGOs)
            if not self.eof():
                try:
                    map_warp_count = self.read_ubyte()
                    if 0 < map_warp_count < 100:
                        for i in range(map_warp_count):
                            if self.eof():
                                break
                            x = self.read_short()
                            y = self.read_short()
                            dest_map_name = self.read_utf()
                            
                            # Try to find map ID from name
                            map_id = -1
                            try:
                                map_id = MAP_NAMES.index(dest_map_name)
                            except ValueError:
                                pass
                                
                                                         map_data.map_warps.append({
                                 'x': x,  # Already in pixels from TypeScript code
                                 'y': y,  # Already in pixels from TypeScript code
                                 'dest_map_name': dest_map_name,
                                 'dest_map_id': map_id
                             })
                except:
                    pass
                    
            return map_data
            
        except Exception as e:
            raise Exception(f"Parse error at offset {self.offset}: {e}")

# ============================================================================
# TILESET GENERATOR
# ============================================================================
def generate_sample_tileset():
    """Generate a sample tileset in memory as QPixmap"""
    
    tile_size = 24
    tiles_per_row = 16
    num_rows = 4
    
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
    
    # Create PNG file in memory
    png_data = create_png(width, height, pixels)
    
    # Convert to QPixmap
    pixmap = QPixmap()
    pixmap.loadFromData(png_data, "PNG")
    
    return pixmap

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

# ============================================================================
# GUI COMPONENTS
# ============================================================================
class MapCanvas(QWidget):
    def __init__(self):
        super().__init__()
        self.map_data = None
        self.tileset_pixmap = None
        self.scale = 1.0
        self.offset_x = 0
        self.offset_y = 0
        self.setMinimumSize(800, 600)
        self.setMouseTracking(True)
        self.dragging = False
        self.last_pos = None
        
    def set_map_data(self, map_data):
        self.map_data = map_data
        if map_data:
            # Reset view
            self.scale = 1.0
            self.offset_x = 0
            self.offset_y = 0
            self.update()
            
    def set_tileset(self, pixmap):
        self.tileset_pixmap = pixmap
        self.update()
        
    def wheelEvent(self, event):
        if self.map_data:
            # Zoom
            delta = event.angleDelta().y()
            zoom_factor = 1.1 if delta > 0 else 1/1.1
            old_scale = self.scale
            self.scale = max(0.1, min(self.scale * zoom_factor, 5.0))
            
            # Adjust offset to zoom towards mouse position
            mouse_x = event.position().x()
            mouse_y = event.position().y()
            self.offset_x = mouse_x - (mouse_x - self.offset_x) * (self.scale / old_scale)
            self.offset_y = mouse_y - (mouse_y - self.offset_y) * (self.scale / old_scale)
            
            self.update()
            
    def mousePressEvent(self, event):
        if event.button() == Qt.MouseButton.LeftButton:
            self.dragging = True
            self.last_pos = event.position()
            self.setCursor(Qt.CursorShape.ClosedHandCursor)
            
    def mouseMoveEvent(self, event):
        if self.dragging and self.last_pos:
            delta = event.position() - self.last_pos
            self.offset_x += delta.x()
            self.offset_y += delta.y()
            self.last_pos = event.position()
            self.update()
            
    def mouseReleaseEvent(self, event):
        if event.button() == Qt.MouseButton.LeftButton:
            self.dragging = False
            self.setCursor(Qt.CursorShape.ArrowCursor)
            
    def paintEvent(self, event):
        painter = QPainter(self)
        painter.fillRect(self.rect(), QColor(50, 50, 50))
        
        if not self.map_data:
            painter.setPen(QColor(255, 255, 255))
            painter.setFont(QFont("Arial", 16))
            painter.drawText(self.rect(), Qt.AlignmentFlag.AlignCenter, 
                           "Chọn map data để hiển thị bản đồ\n\nSample: 'Ngôi Làng Nhỏ' → 'Làng Sói Trắng'")
            return
            
        painter.save()
        painter.translate(self.offset_x, self.offset_y)
        painter.scale(self.scale, self.scale)
        
        self.draw_tiles(painter)
        self.draw_objects(painter)
        
        painter.restore()
        
        # Draw info
        self.draw_info(painter)
        
    def draw_tiles(self, painter):
        if not self.tileset_pixmap:
            # Draw grid placeholder
            painter.setPen(QPen(QColor(100, 100, 100), 1))
            for y in range(self.map_data.height):
                for x in range(self.map_data.width):
                    rect = QRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE)
                    painter.drawRect(rect)
                    
                    # Draw tile ID
                    tile_id = self.map_data.tiles[y][x]
                    if tile_id > 0:
                        painter.setPen(QColor(255, 255, 255))
                        painter.setFont(QFont("Arial", 8))
                        painter.drawText(rect, Qt.AlignmentFlag.AlignCenter, str(tile_id))
            return
            
        # Draw tiles using tileset
        tileset_cols = self.tileset_pixmap.width() // TILE_SIZE
        
        for y in range(self.map_data.height):
            for x in range(self.map_data.width):
                tile_id = self.map_data.tiles[y][x]
                if tile_id <= 0:
                    continue
                    
                tile_id -= 1  # Convert to 0-based
                src_x = (tile_id % tileset_cols) * TILE_SIZE
                src_y = (tile_id // tileset_cols) * TILE_SIZE
                
                src_rect = QRect(src_x, src_y, TILE_SIZE, TILE_SIZE)
                dst_rect = QRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE)
                
                painter.drawPixmap(dst_rect, self.tileset_pixmap, src_rect)
                
         def draw_objects(self, painter):
         # Sort all objects by Y coordinate for proper layering (like TypeScript)
         all_objects = []
         
         # Add decorative icons (effectObjects)
         for icon in self.map_data.decorative_icons:
             all_objects.append(('icon', icon))
             
         # Add internal VGOs
         for vgo in self.map_data.internal_vgos:
             all_objects.append(('vgo', vgo))
             
         # Add map warps (external VGOs)
         for warp in self.map_data.map_warps:
             all_objects.append(('warp', warp))
             
         # Add effect triggers (effData)
         for trigger in self.map_data.effect_triggers:
             all_objects.append(('trigger', trigger))
             
         # Sort by Y coordinate
         all_objects.sort(key=lambda obj: obj[1]['y'])
         
         # Draw all objects in order
         for obj_type, obj in all_objects:
             if obj_type == 'icon':
                 self.draw_decorative_icon(painter, obj)
             elif obj_type == 'vgo':
                 self.draw_internal_vgo(painter, obj)
             elif obj_type == 'warp':
                 self.draw_map_warp(painter, obj)
             elif obj_type == 'trigger':
                 self.draw_effect_trigger(painter, obj)
                 
    def draw_decorative_icon(self, painter, icon):
        # Draw placeholder yellow square (like TypeScript drawEffect with placeholder)
        painter.setPen(QPen(QColor(255, 255, 0), 2))
        painter.setBrush(QBrush(QColor(255, 255, 0, 128)))
        rect = QRect(icon['x'], icon['y'], TILE_SIZE, TILE_SIZE)
        painter.drawRect(rect)
        
        # Draw ID
        painter.setPen(QColor(0, 0, 0))
        painter.setFont(QFont("Arial", int(8 / self.scale), QFont.Weight.Bold))
        painter.drawText(rect, Qt.AlignmentFlag.AlignCenter, str(icon['template_id']))
        
    def draw_internal_vgo(self, painter, vgo):
        # Draw like TypeScript drawVgo
        center_x = vgo['x'] + TILE_SIZE // 2
        center_y = vgo['y'] + TILE_SIZE // 2
        
        painter.setPen(QPen(QColor(59, 130, 246), int(1.5 / self.scale)))
        painter.setBrush(QBrush(QColor(59, 130, 246, 179)))  # 0.7 alpha = 179
        painter.drawEllipse(center_x - TILE_SIZE//2, center_y - TILE_SIZE//2, TILE_SIZE, TILE_SIZE)
        
        # Draw name above
        if vgo['name']:
            painter.setPen(QColor(255, 255, 255))
            painter.setFont(QFont("Arial", int(11 / self.scale), QFont.Weight.Bold))
            
            # Draw text outline
            painter.setPen(QColor(0, 0, 0))
            text_y = vgo['y'] - int(4 / self.scale)
            painter.drawText(QRect(center_x - 50, text_y - 10, 100, 20), 
                           Qt.AlignmentFlag.AlignCenter, vgo['name'])
            
            # Draw text fill
            painter.setPen(QColor(255, 255, 255))
            painter.drawText(QRect(center_x - 50, text_y - 10, 100, 20), 
                           Qt.AlignmentFlag.AlignCenter, vgo['name'])
        
    def draw_map_warp(self, painter, warp):
        # Draw larger circle for external VGOs (like TypeScript)
        center_x = warp['x'] + TILE_SIZE // 2
        center_y = warp['y'] + TILE_SIZE // 2
        
        painter.setPen(QPen(QColor(255, 0, 150), 3))
        painter.setBrush(QBrush(QColor(255, 0, 150, 100)))
        painter.drawEllipse(center_x - 15, center_y - 15, 30, 30)
        
        # Draw destination map name
        painter.setPen(QColor(255, 255, 255))
        painter.setFont(QFont("Arial", int(10 / self.scale), QFont.Weight.Bold))
        text_rect = QRect(center_x - 60, center_y - 35, 120, 20)
        painter.drawText(text_rect, Qt.AlignmentFlag.AlignCenter, warp['dest_map_name'])
        
        # Draw map ID if known
        if warp['dest_map_id'] >= 0:
            painter.setPen(QColor(255, 255, 0))
            painter.setFont(QFont("Arial", int(8 / self.scale)))
            id_rect = QRect(center_x - 30, center_y + 20, 60, 15)
            painter.drawText(id_rect, Qt.AlignmentFlag.AlignCenter, f"ID: {warp['dest_map_id']}")
             
    def draw_effect_trigger(self, painter, trigger):
        # Draw like TypeScript drawEff
        painter.setPen(QPen(QColor(34, 197, 94), int(1 / self.scale)))
        painter.setBrush(QBrush(QColor(34, 197, 94, 128)))  # 0.5 alpha = 128
        rect = QRect(trigger['x'], trigger['y'], TILE_SIZE, TILE_SIZE)
        painter.drawRect(rect)
        
        # Draw text in center
        painter.setPen(QColor(255, 255, 255))
        painter.setFont(QFont("Arial", int(14 / self.scale), QFont.Weight.Bold))
        
        # Draw text outline
        painter.setPen(QColor(0, 0, 0))
        text_x = trigger['x'] + TILE_SIZE // 2
        text_y = trigger['y'] + TILE_SIZE // 2
        painter.drawText(QRect(trigger['x'], trigger['y'], TILE_SIZE, TILE_SIZE), 
                       Qt.AlignmentFlag.AlignCenter, f"T{trigger['id']}")
        
        # Draw text fill
        painter.setPen(QColor(255, 255, 255))
        painter.drawText(QRect(trigger['x'], trigger['y'], TILE_SIZE, TILE_SIZE), 
                       Qt.AlignmentFlag.AlignCenter, f"T{trigger['id']}")
            
    def draw_info(self, painter):
        if not self.map_data:
            return
            
        # Draw map info
        painter.setPen(QColor(255, 255, 255))
        painter.setFont(QFont("Arial", 12))
        info_text = f"Map: {self.map_data.name} | Size: {self.map_data.width}x{self.map_data.height} | Scale: {self.scale:.2f}"
        painter.drawText(10, 20, info_text)
        
        # Draw legend
        legend_y = 40
        painter.setFont(QFont("Arial", 10))
        
        # Yellow squares - Decorative Icons
        painter.fillRect(10, legend_y, 15, 15, QColor(255, 255, 0))
        painter.drawText(30, legend_y + 12, f"Decorative Icons ({len(self.map_data.decorative_icons)})")
        
        # Blue circles - Internal VGOs (if any)
        if len(self.map_data.internal_vgos) > 0:
            legend_y += 20
            painter.setPen(QPen(QColor(0, 150, 255), 2))
            painter.setBrush(QBrush(QColor(0, 150, 255, 100)))
            painter.drawEllipse(10, legend_y, 15, 15)
            painter.setPen(QColor(255, 255, 255))
            painter.drawText(30, legend_y + 12, f"Internal Warps ({len(self.map_data.internal_vgos)})")
        
        # Pink circles - Map Warps
        legend_y += 20
        painter.setPen(QPen(QColor(255, 0, 150), 2))
        painter.setBrush(QBrush(QColor(255, 0, 150, 100)))
        painter.drawEllipse(10, legend_y, 15, 15)
        painter.setPen(QColor(255, 255, 255))
        painter.drawText(30, legend_y + 12, f"Map Warps ({len(self.map_data.map_warps)})")
        
        # Green squares - Effect Triggers
        legend_y += 20
        painter.fillRect(10, legend_y, 15, 15, QColor(0, 255, 0))
        painter.drawText(30, legend_y + 12, f"Effect Triggers ({len(self.map_data.effect_triggers)})")

# ============================================================================
# MAIN APPLICATION
# ============================================================================
class HSOMapViewer(QMainWindow):
    def __init__(self):
        super().__init__()
        self.map_data = None
        self.init_ui()
        
    def init_ui(self):
        self.setWindowTitle("HSO Map Viewer - Fixed Edition")
        self.setGeometry(100, 100, 1200, 800)
        
        # Central widget
        central_widget = QWidget()
        self.setCentralWidget(central_widget)
        
        # Main layout
        main_layout = QHBoxLayout(central_widget)
        
        # Left panel for controls
        left_panel = QFrame()
        left_panel.setFixedWidth(300)
        left_panel.setFrameStyle(QFrame.Shape.StyledPanel)
        left_layout = QVBoxLayout(left_panel)
        
        # File loading group
        file_group = QGroupBox("Tải File")
        file_layout = QVBoxLayout(file_group)
        
        # Data source selection
        self.data_source_combo = QComboBox()
        self.data_source_combo.addItems([
            "Sample: Ngôi Làng Nhỏ",
            "Tải từ file..."
        ])
        self.data_source_combo.currentTextChanged.connect(self.data_source_changed)
        file_layout.addWidget(QLabel("Nguồn Map Data:"))
        file_layout.addWidget(self.data_source_combo)
        
        self.load_map_btn = QPushButton("Tải Map Data")
        self.load_map_btn.clicked.connect(self.load_map_data)
        file_layout.addWidget(self.load_map_btn)
        
        # Tileset selection
        self.tileset_combo = QComboBox()
        self.tileset_combo.addItems([
            "Generated Sample Tileset",
            "Tải từ file..."
        ])
        self.tileset_combo.currentTextChanged.connect(self.tileset_source_changed)
        file_layout.addWidget(QLabel("Nguồn Tileset:"))
        file_layout.addWidget(self.tileset_combo)
        
        self.load_tileset_btn = QPushButton("Tải Tileset")
        self.load_tileset_btn.clicked.connect(self.load_tileset)
        file_layout.addWidget(self.load_tileset_btn)
        
        left_layout.addWidget(file_group)
        
        # Map info group
        info_group = QGroupBox("Thông Tin Map")
        info_layout = QVBoxLayout(info_group)
        
        self.info_label = QLabel("Chọn map data để hiển thị thông tin")
        self.info_label.setWordWrap(True)
        info_layout.addWidget(self.info_label)
        
        left_layout.addWidget(info_group)
        
        # Object list
        objects_group = QGroupBox("Objects")
        objects_layout = QVBoxLayout(objects_group)
        
        self.objects_text = QTextEdit()
        self.objects_text.setMaximumHeight(300)
        self.objects_text.setReadOnly(True)
        objects_layout.addWidget(self.objects_text)
        
        left_layout.addWidget(objects_group)
        
        # Instructions
        instructions_group = QGroupBox("Hướng Dẫn")
        instructions_layout = QVBoxLayout(instructions_group)
        
        instructions_text = QLabel("""
🎮 Điều Khiển:
• Mouse Wheel: Zoom in/out
• Left Click + Drag: Pan map
• Combo boxes: Chọn data source

🗺️ Legend (Chính xác):
🟨 Decorative Icons (77)
🔵 Internal Warps (0)  
🔴 Map Warps (1 → Làng Sói Trắng)
🟩 Effect Triggers (7)

📋 Sample Data:
Map: "Ngôi Làng Nhỏ" (ID: 0)
→ Warp to "Làng Sói Trắng" (ID: 1)
Size: 58×30 tiles
        """.strip())
        instructions_text.setWordWrap(True)
        instructions_text.setStyleSheet("font-size: 10px;")
        instructions_layout.addWidget(instructions_text)
        
        left_layout.addWidget(instructions_group)
        
        left_layout.addStretch()
        
        # Right panel for map canvas
        self.map_canvas = MapCanvas()
        
        # Scroll area for map
        scroll_area = QScrollArea()
        scroll_area.setWidget(self.map_canvas)
        scroll_area.setWidgetResizable(True)
        
        # Add to main layout
        main_layout.addWidget(left_panel)
        main_layout.addWidget(scroll_area, 1)
        
        # Load default data
        self.load_sample_data()
        self.load_sample_tileset()
        
    def data_source_changed(self, text):
        if "Sample" in text:
            self.load_map_btn.setText("Tải Sample Data")
        else:
            self.load_map_btn.setText("Tải từ File...")
            
    def tileset_source_changed(self, text):
        if "Generated" in text:
            self.load_tileset_btn.setText("Tải Generated Tileset")
        else:
            self.load_tileset_btn.setText("Tải từ File...")
            
    def load_map_data(self):
        if "Sample" in self.data_source_combo.currentText():
            self.load_sample_data()
        else:
            self.load_map_from_file()
            
    def load_sample_data(self):
        """Load embedded sample map data"""
        try:
            # Convert hex to binary
            binary_data = binascii.unhexlify(EMBEDDED_MAP_HEX.replace(' ', ''))
            
            parser = MapParser(binary_data)
            self.map_data = parser.parse()
            
            self.map_canvas.set_map_data(self.map_data)
            self.update_info()
            self.update_objects_list()
            
            QMessageBox.information(self, "Thành công", 
                                  f"Đã tải sample map '{self.map_data.name}' thành công!")
                                  
        except Exception as e:
            QMessageBox.critical(self, "Lỗi", f"Không thể tải sample data:\n{str(e)}")
            
    def load_map_from_file(self):
        """Load map data from file"""
        file_path, _ = QFileDialog.getOpenFileName(
            self, "Chọn Map Data File", "", "All Files (*)"
        )
        
        if file_path:
            try:
                with open(file_path, 'rb') as f:
                    data = f.read()
                    
                parser = MapParser(data)
                self.map_data = parser.parse()
                
                self.map_canvas.set_map_data(self.map_data)
                self.update_info()
                self.update_objects_list()
                
                QMessageBox.information(self, "Thành công", 
                                      f"Đã tải map '{self.map_data.name}' thành công!")
                
            except Exception as e:
                QMessageBox.critical(self, "Lỗi", f"Không thể tải map data:\n{str(e)}")
                
    def load_tileset(self):
        if "Generated" in self.tileset_combo.currentText():
            self.load_sample_tileset()
        else:
            self.load_tileset_from_file()
            
    def load_sample_tileset(self):
        """Load generated sample tileset"""
        try:
            pixmap = generate_sample_tileset()
            self.map_canvas.set_tileset(pixmap)
            QMessageBox.information(self, "Thành công", "Đã tải generated tileset thành công!")
        except Exception as e:
            QMessageBox.critical(self, "Lỗi", f"Không thể tạo tileset:\n{str(e)}")
            
    def load_tileset_from_file(self):
        """Load tileset from file"""
        file_path, _ = QFileDialog.getOpenFileName(
            self, "Chọn Tileset File", "", "Image Files (*.png *.jpg *.jpeg *.bmp)"
        )
        
        if file_path:
            try:
                pixmap = QPixmap(file_path)
                if pixmap.isNull():
                    raise Exception("Không thể đọc file hình ảnh")
                    
                self.map_canvas.set_tileset(pixmap)
                QMessageBox.information(self, "Thành công", "Đã tải tileset thành công!")
                
            except Exception as e:
                QMessageBox.critical(self, "Lỗi", f"Không thể tải tileset:\n{str(e)}")
                
    def update_info(self):
        if not self.map_data:
            self.info_label.setText("Chọn map data để hiển thị thông tin")
            return
            
        info_text = f"""
Tên Map: {self.map_data.name}
Version: {self.map_data.version} (0x{self.map_data.version:04X})
Kích thước: {self.map_data.width} x {self.map_data.height}
Tileset ID: {self.map_data.tileset_id}

Objects (Chính xác):
- Decorative Icons: {len(self.map_data.decorative_icons)}
- Internal Warps: {len(self.map_data.internal_vgos)}
- Map Warps: {len(self.map_data.map_warps)}
- Effect Triggers: {len(self.map_data.effect_triggers)}

Total Tiles: {self.map_data.width * self.map_data.height}
        """.strip()
        
        self.info_label.setText(info_text)
        
    def update_objects_list(self):
        if not self.map_data:
            self.objects_text.clear()
            return
            
        text = ""
        
        # Decorative Icons
        if self.map_data.decorative_icons:
            text += "=== DECORATIVE ICONS ===\n"
            for i, icon in enumerate(self.map_data.decorative_icons):
                text += f"{i+1:2d}. ID:{icon['template_id']:3d} at ({icon['x']:2d}, {icon['y']:2d})\n"
            text += "\n"
            
        # Internal VGOs
        if self.map_data.internal_vgos:
            text += "=== INTERNAL WARPS ===\n"
            for i, vgo in enumerate(self.map_data.internal_vgos):
                text += f"{i+1:2d}. '{vgo['name']}' at ({vgo['x']:2d}, {vgo['y']:2d})\n"
            text += "\n"
            
        # Map Warps
        if self.map_data.map_warps:
            text += "=== MAP WARPS ===\n"
            for i, warp in enumerate(self.map_data.map_warps):
                map_id_text = f" (ID: {warp['dest_map_id']})" if warp['dest_map_id'] >= 0 else ""
                text += f"{i+1:2d}. '{warp['dest_map_name']}'{map_id_text} at ({warp['x']:4d}, {warp['y']:4d})\n"
            text += "\n"
            
        # Effect Triggers
        if self.map_data.effect_triggers:
            text += "=== EFFECT TRIGGERS ===\n"
            for i, trigger in enumerate(self.map_data.effect_triggers):
                text += f"{i+1:2d}. ID:{trigger['id']:2d} at ({trigger['x']:2d}, {trigger['y']:2d})\n"
                text += f"     Raw: {trigger['raw']}\n"
            
        self.objects_text.setPlainText(text)

# ============================================================================
# APPLICATION ENTRY POINT
# ============================================================================
def check_dependencies():
    """Check if PyQt6 is available"""
    try:
        from PyQt6.QtWidgets import QApplication
        return True
    except ImportError:
        print("❌ PyQt6 not found!")
        print("\n📝 To install PyQt6:")
        print("pip install PyQt6")
        print("\nOr in a virtual environment:")
        print("python3 -m venv venv")
        print("source venv/bin/activate  # Linux/Mac")
        print("venv\\Scripts\\activate     # Windows")
        print("pip install PyQt6")
        return False

def main():
    print("=== HSO Map Viewer - Fixed Edition ===")
    print("Terminology chính xác dựa trên code analysis:")
    print("✅ 77 Decorative Icons (cây cối, đá, decorations)")
    print("✅ 7 Effect Triggers (game events/triggers)")
    print("✅ 1 Map Warp (portal to 'Làng Sói Trắng')")
    print("✅ Hiển thị Map ID và destination names")
    print()
    
    if not check_dependencies():
        return
        
    app = QApplication(sys.argv)
    
    # Set application style
    app.setStyle('Fusion')
    
    # Dark theme
    palette = app.palette()
    palette.setColor(palette.ColorRole.Window, QColor(53, 53, 53))
    palette.setColor(palette.ColorRole.WindowText, QColor(255, 255, 255))
    palette.setColor(palette.ColorRole.Base, QColor(25, 25, 25))
    palette.setColor(palette.ColorRole.AlternateBase, QColor(53, 53, 53))
    palette.setColor(palette.ColorRole.ToolTipBase, QColor(0, 0, 0))
    palette.setColor(palette.ColorRole.ToolTipText, QColor(255, 255, 255))
    palette.setColor(palette.ColorRole.Text, QColor(255, 255, 255))
    palette.setColor(palette.ColorRole.Button, QColor(53, 53, 53))
    palette.setColor(palette.ColorRole.ButtonText, QColor(255, 255, 255))
    palette.setColor(palette.ColorRole.BrightText, QColor(255, 0, 0))
    palette.setColor(palette.ColorRole.Link, QColor(42, 130, 218))
    palette.setColor(palette.ColorRole.Highlight, QColor(42, 130, 218))
    palette.setColor(palette.ColorRole.HighlightedText, QColor(0, 0, 0))
    app.setPalette(palette)
    
    print("🚀 Starting HSO Map Viewer (Fixed)...")
    print("📋 Features:")
    print("  ✅ Correct terminology và visualization")
    print("  ✅ Map name lookup từ game client")
    print("  ✅ Map ID display cho destinations")
    print("  ✅ Embedded sample data với precise parsing")
    print("  ✅ Generated tileset")
    print("  ✅ Interactive controls")
    print()
    
    viewer = HSOMapViewer()
    viewer.show()
    
    sys.exit(app.exec())

if __name__ == "__main__":
    main()