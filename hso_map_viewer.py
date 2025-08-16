#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import sys
import struct
from PyQt6.QtWidgets import (QApplication, QMainWindow, QWidget, QVBoxLayout, 
                             QHBoxLayout, QPushButton, QLabel, QFileDialog, 
                             QScrollArea, QFrame, QTextEdit, QSplitter,
                             QGroupBox, QMessageBox)
from PyQt6.QtCore import Qt, QRect, pyqtSignal
from PyQt6.QtGui import QPainter, QPixmap, QColor, QPen, QFont, QBrush

TILE_SIZE = 24

class MapData:
    def __init__(self):
        self.name = ""
        self.version = 0
        self.width = 0
        self.height = 0
        self.tileset_id = 0
        self.tiles = []
        self.effect_objects = []
        self.vgos = []
        self.eff_data = []
        self.external_vgos = []

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
                
                # Effect Objects
                num_icons = self.read_short()
                for i in range(num_icons):
                    if self.offset + 6 > object_block_start + object_block_length:
                        break
                    template_id = self.read_short()
                    x = self.read_short()
                    y = self.read_short()
                    map_data.effect_objects.append({
                        'template_id': template_id,
                        'x': x,
                        'y': y,
                        'name': f'Effect ID: {template_id}'
                    })
                    
                # Internal VGO count
                if self.offset + 2 <= object_block_start + object_block_length:
                    internal_vgo_count = self.read_short()
                
                # Parse VGOs and Eff data
                while self.offset < object_block_start + object_block_length:
                    # Check for eff magic
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
                                        map_data.eff_data.append({
                                            'id': eff_id,
                                            'x': eff_x,
                                            'y': eff_y,
                                            'name': f'Eff ID: {eff_id}',
                                            'raw': eff_string
                                        })
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
                                
                            map_data.vgos.append({
                                'x': vgo_x,
                                'y': vgo_y,
                                'name': name,
                                'type': vgo_type
                            })
                            
                        except:
                            break
                    else:
                        break
                        
                # Skip to end of object block
                self.seek(object_block_start + object_block_length)
                
            # Parse external VGOs
            if not self.eof():
                try:
                    external_vgo_count = self.read_ubyte()
                    if 0 < external_vgo_count < 100:
                        for i in range(external_vgo_count):
                            if self.eof():
                                break
                            x = self.read_short()
                            y = self.read_short()
                            name = self.read_utf()
                            map_data.external_vgos.append({
                                'x': x, 'y': y, 'name': name
                            })
                except:
                    pass
                    
            return map_data
            
        except Exception as e:
            raise Exception(f"Parse error at offset {self.offset}: {e}")

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
                           "Load map data và tileset để hiển thị bản đồ")
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
        # Draw effect objects
        painter.setPen(QPen(QColor(255, 255, 0), 2))
        painter.setBrush(QBrush(QColor(255, 255, 0, 100)))
        for obj in self.map_data.effect_objects:
            x = obj['x'] * TILE_SIZE
            y = obj['y'] * TILE_SIZE
            rect = QRect(x, y, TILE_SIZE, TILE_SIZE)
            painter.drawRect(rect)
            
            # Draw ID
            painter.setPen(QColor(0, 0, 0))
            painter.setFont(QFont("Arial", 8, QFont.Weight.Bold))
            painter.drawText(rect, Qt.AlignmentFlag.AlignCenter, str(obj['template_id']))
            
        # Draw VGOs (warps)
        painter.setPen(QPen(QColor(0, 150, 255), 3))
        painter.setBrush(QBrush(QColor(0, 150, 255, 100)))
        for vgo in self.map_data.vgos:
            x = vgo['x'] * TILE_SIZE + TILE_SIZE // 2
            y = vgo['y'] * TILE_SIZE + TILE_SIZE // 2
            painter.drawEllipse(x - 12, y - 12, 24, 24)
            
            # Draw name
            painter.setPen(QColor(255, 255, 255))
            painter.setFont(QFont("Arial", 8, QFont.Weight.Bold))
            text_rect = QRect(x - 50, y - 30, 100, 20)
            painter.drawText(text_rect, Qt.AlignmentFlag.AlignCenter, vgo['name'])
            
        # Draw external VGOs
        painter.setPen(QPen(QColor(255, 0, 150), 3))
        painter.setBrush(QBrush(QColor(255, 0, 150, 100)))
        for vgo in self.map_data.external_vgos:
            x = vgo['x'] * TILE_SIZE + TILE_SIZE // 2
            y = vgo['y'] * TILE_SIZE + TILE_SIZE // 2
            painter.drawEllipse(x - 15, y - 15, 30, 30)
            
            # Draw name
            painter.setPen(QColor(255, 255, 255))
            painter.setFont(QFont("Arial", 10, QFont.Weight.Bold))
            text_rect = QRect(x - 60, y - 35, 120, 20)
            painter.drawText(text_rect, Qt.AlignmentFlag.AlignCenter, vgo['name'])
            
        # Draw eff data
        painter.setPen(QPen(QColor(0, 255, 0), 2))
        painter.setBrush(QBrush(QColor(0, 255, 0, 100)))
        for eff in self.map_data.eff_data:
            x = eff['x'] * TILE_SIZE
            y = eff['y'] * TILE_SIZE
            rect = QRect(x, y, TILE_SIZE, TILE_SIZE)
            painter.drawRect(rect)
            
            # Draw ID
            painter.setPen(QColor(0, 0, 0))
            painter.setFont(QFont("Arial", 8, QFont.Weight.Bold))
            painter.drawText(rect, Qt.AlignmentFlag.AlignCenter, f"E{eff['id']}")
            
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
        
        # Yellow squares - Effect objects
        painter.fillRect(10, legend_y, 15, 15, QColor(255, 255, 0))
        painter.drawText(30, legend_y + 12, f"Effect Objects ({len(self.map_data.effect_objects)})")
        
        # Blue circles - VGOs
        legend_y += 20
        painter.setPen(QPen(QColor(0, 150, 255), 2))
        painter.setBrush(QBrush(QColor(0, 150, 255, 100)))
        painter.drawEllipse(10, legend_y, 15, 15)
        painter.setPen(QColor(255, 255, 255))
        painter.drawText(30, legend_y + 12, f"VGOs ({len(self.map_data.vgos)})")
        
        # Pink circles - External VGOs
        legend_y += 20
        painter.setPen(QPen(QColor(255, 0, 150), 2))
        painter.setBrush(QBrush(QColor(255, 0, 150, 100)))
        painter.drawEllipse(10, legend_y, 15, 15)
        painter.setPen(QColor(255, 255, 255))
        painter.drawText(30, legend_y + 12, f"External VGOs ({len(self.map_data.external_vgos)})")
        
        # Green squares - Eff data
        legend_y += 20
        painter.fillRect(10, legend_y, 15, 15, QColor(0, 255, 0))
        painter.drawText(30, legend_y + 12, f"Eff Data ({len(self.map_data.eff_data)})")

class HSOMapViewer(QMainWindow):
    def __init__(self):
        super().__init__()
        self.map_data = None
        self.init_ui()
        
    def init_ui(self):
        self.setWindowTitle("HSO Map Viewer")
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
        
        self.load_map_btn = QPushButton("Tải Map Data")
        self.load_map_btn.clicked.connect(self.load_map_data)
        file_layout.addWidget(self.load_map_btn)
        
        self.load_tileset_btn = QPushButton("Tải Tileset (tile.png)")
        self.load_tileset_btn.clicked.connect(self.load_tileset)
        file_layout.addWidget(self.load_tileset_btn)
        
        left_layout.addWidget(file_group)
        
        # Map info group
        info_group = QGroupBox("Thông Tin Map")
        info_layout = QVBoxLayout(info_group)
        
        self.info_label = QLabel("Chưa tải map data")
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
        
    def load_map_data(self):
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
            self.info_label.setText("Chưa tải map data")
            return
            
        info_text = f"""
Tên Map: {self.map_data.name}
Version: {self.map_data.version}
Kích thước: {self.map_data.width} x {self.map_data.height}
Tileset ID: {self.map_data.tileset_id}

Objects:
- Effect Objects: {len(self.map_data.effect_objects)}
- VGOs: {len(self.map_data.vgos)}
- External VGOs: {len(self.map_data.external_vgos)}
- Eff Data: {len(self.map_data.eff_data)}
        """.strip()
        
        self.info_label.setText(info_text)
        
    def update_objects_list(self):
        if not self.map_data:
            self.objects_text.clear()
            return
            
        text = ""
        
        # Effect Objects
        if self.map_data.effect_objects:
            text += "=== EFFECT OBJECTS ===\n"
            for i, obj in enumerate(self.map_data.effect_objects):
                text += f"{i+1:2d}. ID:{obj['template_id']:3d} at ({obj['x']:2d}, {obj['y']:2d})\n"
            text += "\n"
            
        # VGOs
        if self.map_data.vgos:
            text += "=== VGOs ===\n"
            for i, vgo in enumerate(self.map_data.vgos):
                text += f"{i+1:2d}. '{vgo['name']}' at ({vgo['x']:2d}, {vgo['y']:2d})\n"
            text += "\n"
            
        # External VGOs
        if self.map_data.external_vgos:
            text += "=== EXTERNAL VGOs ===\n"
            for i, vgo in enumerate(self.map_data.external_vgos):
                text += f"{i+1:2d}. '{vgo['name']}' at ({vgo['x']:4d}, {vgo['y']:4d})\n"
            text += "\n"
            
        # Eff Data
        if self.map_data.eff_data:
            text += "=== EFF DATA ===\n"
            for i, eff in enumerate(self.map_data.eff_data):
                text += f"{i+1:2d}. ID:{eff['id']:2d} at ({eff['x']:2d}, {eff['y']:2d})\n"
                text += f"     Raw: {eff['raw']}\n"
            
        self.objects_text.setPlainText(text)

def main():
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
    
    viewer = HSOMapViewer()
    viewer.show()
    
    sys.exit(app.exec())

if __name__ == "__main__":
    main()