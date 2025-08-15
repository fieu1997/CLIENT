(function() {
  const canvas = document.getElementById('canvas');
  const ctx = canvas.getContext('2d');
  const fileInput = document.getElementById('fileInput');
  const importJsonInput = document.getElementById('importJsonInput');

  const widthInput = document.getElementById('widthInput');
  const heightInput = document.getElementById('heightInput');
  const themeInput = document.getElementById('themeInput');
  const cellSizeInput = document.getElementById('cellSizeInput');
  const gridToggle = document.getElementById('gridToggle');
  const tileInput = document.getElementById('tileInput');

  const tileImageInput = document.getElementById('tileImageInput');
  const tileFrameWInput = document.getElementById('tileFrameWInput');
  const tileFrameHInput = document.getElementById('tileFrameHInput');
  const tileColsInput = document.getElementById('tileColsInput');
  const showIndexToggle = document.getElementById('showIndexToggle');
  const clearTileImgBtn = document.getElementById('clearTileImgBtn');

  const newMapBtn = document.getElementById('newMapBtn');
  const exportBinBtn = document.getElementById('exportBinBtn');
  const exportJsonBtn = document.getElementById('exportJsonBtn');
  const fillAllBtn = document.getElementById('fillAllBtn');
  const clearAllBtn = document.getElementById('clearAllBtn');
  const addRowBtn = document.getElementById('addRowBtn');
  const removeRowBtn = document.getElementById('removeRowBtn');
  const addColBtn = document.getElementById('addColBtn');
  const removeColBtn = document.getElementById('removeColBtn');

  const state = {
    width: 32,
    height: 24,
    theme: 0,
    tiles: new Uint8Array(32 * 24),
    cellSize: 24,
    isMouseDown: false,
    lastPainted: new Set(),
    // tile atlas
    tileImg: null,
    tileImgBitmap: null,
    tileCols: 1,
    tileFrameW: 24,
    tileFrameH: 24,
  };

  function clamp(v, min, max) { return Math.max(min, Math.min(max, v)); }

  function setSizeFromInputs() {
    const w = clamp(parseInt(widthInput.value || '1', 10), 1, 255);
    const h = clamp(parseInt(heightInput.value || '1', 10), 1, 255);
    const k = clamp(parseInt(themeInput.value || '0', 10), 0, 255);
    const cs = clamp(parseInt(cellSizeInput.value || '24', 10), 8, 64);
    state.cellSize = cs;
    if (w !== state.width || h !== state.height) {
      resizeGrid(w, h);
    }
    state.theme = k;
    requestDraw();
  }

  function setTileAtlasFromInputs() {
    state.tileCols = clamp(parseInt(tileColsInput.value || '1', 10), 1, 4096);
    state.tileFrameW = clamp(parseInt(tileFrameWInput.value || '24', 10), 1, 1024);
    state.tileFrameH = clamp(parseInt(tileFrameHInput.value || '24', 10), 1, 1024);
    requestDraw();
  }

  function idx(x, y) { return y * state.width + x; }

  function resizeGrid(newW, newH) {
    const newTiles = new Uint8Array(newW * newH);
    const minW = Math.min(state.width, newW);
    const minH = Math.min(state.height, newH);
    for (let y = 0; y < minH; y++) {
      for (let x = 0; x < minW; x++) {
        newTiles[y * newW + x] = state.tiles[idx(x, y)];
      }
    }
    state.width = newW;
    state.height = newH;
    state.tiles = newTiles;
    widthInput.value = String(newW);
    heightInput.value = String(newH);
  }

  function parseBinaryMap(buffer) {
    const view = new DataView(buffer);
    if (view.byteLength < 3) throw new Error('File quá nhỏ');
    const w = view.getUint8(0);
    const h = view.getUint8(1);
    const k = view.getUint8(2);
    const expected = 3 + w * h;
    if (view.byteLength < expected) {
      throw new Error(`Kích thước không khớp. Mong đợi >= ${expected} bytes, thực tế ${view.byteLength}`);
    }
    resizeGrid(w, h);
    state.theme = k;
    themeInput.value = String(k);
    for (let i = 0; i < w * h; i++) {
      state.tiles[i] = view.getUint8(3 + i);
    }
  }

  function serializeBinaryMap() {
    const buffer = new ArrayBuffer(3 + state.width * state.height);
    const view = new DataView(buffer);
    view.setUint8(0, state.width & 0xFF);
    view.setUint8(1, state.height & 0xFF);
    view.setUint8(2, state.theme & 0xFF);
    for (let i = 0; i < state.tiles.length; i++) view.setUint8(3 + i, state.tiles[i] & 0xFF);
    return buffer;
  }

  function downloadBlob(blob, filename) {
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = filename;
    document.body.appendChild(a);
    a.click();
    a.remove();
    URL.revokeObjectURL(url);
  }

  function toJson() {
    return JSON.stringify({ width: state.width, height: state.height, theme: state.theme, tiles: Array.from(state.tiles) });
  }

  function fromJsonText(text) {
    const obj = JSON.parse(text);
    const w = clamp(parseInt(obj.width, 10), 1, 255);
    const h = clamp(parseInt(obj.height, 10), 1, 255);
    const k = clamp(parseInt(obj.theme, 10), 0, 255);
    if (!Array.isArray(obj.tiles) || obj.tiles.length !== w * h) throw new Error('JSON tiles không hợp lệ');
    resizeGrid(w, h);
    state.theme = k;
    for (let i = 0; i < obj.tiles.length; i++) state.tiles[i] = clamp(parseInt(obj.tiles[i], 10) || 0, 0, 255);
  }

  function requestDraw() { window.requestAnimationFrame(draw); }

  function draw() {
    const cell = state.cellSize;
    const wpx = state.width * cell;
    const hpx = state.height * cell;
    if (canvas.width !== wpx || canvas.height !== hpx) {
      canvas.width = wpx;
      canvas.height = hpx;
    }
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // background
    ctx.fillStyle = '#ffffff';
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    const hasAtlas = !!state.tileImgBitmap;

    // draw tiles
    for (let y = 0; y < state.height; y++) {
      for (let x = 0; x < state.width; x++) {
        const t = state.tiles[idx(x, y)];
        const px = x * cell;
        const py = y * cell;
        if (hasAtlas && t > 0) {
          const index = t - 1; // 1-based to 0-based index
          const cols = state.tileCols;
          const sx = (index % cols) * state.tileFrameW;
          const sy = Math.floor(index / cols) * state.tileFrameH;
          ctx.imageSmoothingEnabled = false;
          ctx.drawImage(
            state.tileImgBitmap,
            sx, sy, state.tileFrameW, state.tileFrameH,
            px, py, cell, cell
          );
        } else {
          if (t !== 0) {
            const hue = (t * 37) % 360;
            ctx.fillStyle = `hsl(${hue} 60% 90%)`;
            ctx.fillRect(px, py, cell, cell);
          } else {
            ctx.fillStyle = '#f8fafc';
            ctx.fillRect(px, py, cell, cell);
          }
        }

        if (!hasAtlas && t !== 0) {
          const hue = (t * 37) % 360;
          ctx.fillStyle = `hsl(${hue} 70% 30%)`;
          ctx.font = `${Math.floor(cell * 0.45)}px monospace`;
          ctx.textAlign = 'center';
          ctx.textBaseline = 'middle';
          ctx.fillText(String(t), px + cell / 2, py + cell / 2);
        } else if (showIndexToggle.checked) {
          // overlay index text on top of atlas render
          ctx.fillStyle = 'rgba(0,0,0,0.6)';
          ctx.font = `${Math.floor(cell * 0.4)}px monospace`;
          ctx.textAlign = 'center';
          ctx.textBaseline = 'middle';
          ctx.fillText(String(t), px + cell / 2, py + cell / 2);
        }
      }
    }

    if (gridToggle.checked) {
      ctx.strokeStyle = '#e5e7eb';
      ctx.lineWidth = 1;
      for (let x = 0; x <= state.width; x++) {
        const px = x * cell + 0.5;
        ctx.beginPath();
        ctx.moveTo(px, 0);
        ctx.lineTo(px, state.height * cell);
        ctx.stroke();
      }
      for (let y = 0; y <= state.height; y++) {
        const py = y * cell + 0.5;
        ctx.beginPath();
        ctx.moveTo(0, py);
        ctx.lineTo(state.width * cell, py);
        ctx.stroke();
      }
    }
  }

  function getMouseCell(evt) {
    const rect = canvas.getBoundingClientRect();
    const x = Math.floor((evt.clientX - rect.left) / state.cellSize);
    const y = Math.floor((evt.clientY - rect.top) / state.cellSize);
    if (x < 0 || y < 0 || x >= state.width || y >= state.height) return null;
    return { x, y };
  }

  function paintCell(x, y, value) {
    const i = idx(x, y);
    const key = (y << 16) | x;
    if (state.lastPainted.has(key)) return; // avoid redundant draws while dragging
    state.lastPainted.add(key);
    state.tiles[i] = value;
    const cell = state.cellSize;
    const px = x * cell;
    const py = y * cell;
    // draw only one cell for responsiveness
    ctx.clearRect(px, py, cell, cell);
    const t = value;
    const hasAtlas = !!state.tileImgBitmap;
    if (hasAtlas && t > 0) {
      const index = t - 1;
      const cols = state.tileCols;
      const sx = (index % cols) * state.tileFrameW;
      const sy = Math.floor(index / cols) * state.tileFrameH;
      ctx.imageSmoothingEnabled = false;
      ctx.drawImage(state.tileImgBitmap, sx, sy, state.tileFrameW, state.tileFrameH, px, py, cell, cell);
    } else {
      if (t !== 0) {
        const hue = (t * 37) % 360;
        ctx.fillStyle = `hsl(${hue} 60% 90%)`;
        ctx.fillRect(px, py, cell, cell);
        ctx.fillStyle = `hsl(${hue} 70% 30%)`;
        ctx.font = `${Math.floor(cell * 0.45)}px monospace`;
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText(String(t), px + cell / 2, py + cell / 2);
      } else {
        ctx.fillStyle = '#f8fafc';
        ctx.fillRect(px, py, cell, cell);
      }
    }
    if (gridToggle.checked) {
      ctx.strokeStyle = '#e5e7eb';
      ctx.lineWidth = 1;
      ctx.strokeRect(px + 0.5, py + 0.5, cell - 1, cell - 1);
    }
  }

  // Events
  fileInput.addEventListener('change', async (e) => {
    const file = e.target.files && e.target.files[0];
    if (!file) return;
    const buffer = await file.arrayBuffer();
    try {
      parseBinaryMap(buffer);
      requestDraw();
    } catch (err) {
      alert('Lỗi đọc map: ' + err.message);
    }
  });

  importJsonInput.addEventListener('change', async (e) => {
    const file = e.target.files && e.target.files[0];
    if (!file) return;
    const text = await file.text();
    try {
      fromJsonText(text);
      themeInput.value = String(state.theme);
      widthInput.value = String(state.width);
      heightInput.value = String(state.height);
      requestDraw();
    } catch (err) {
      alert('Lỗi JSON: ' + err.message);
    }
  });

  tileImageInput.addEventListener('change', async (e) => {
    const file = e.target.files && e.target.files[0];
    if (!file) return;
    try {
      const url = URL.createObjectURL(file);
      const img = new Image();
      img.decoding = 'async';
      img.onload = async () => {
        try {
          state.tileImg = img;
          // Use createImageBitmap for better drawImage performance
          state.tileImgBitmap = await createImageBitmap(img);
          setTileAtlasFromInputs();
          requestDraw();
        } catch (err) {
          console.error(err);
          alert('Không thể tạo bitmap từ ảnh');
        }
      };
      img.onerror = () => { alert('Không load được ảnh'); };
      img.src = url;
    } catch (err) {
      alert('Lỗi ảnh: ' + err.message);
    }
  });

  [tileFrameWInput, tileFrameHInput, tileColsInput].forEach(el => el.addEventListener('change', setTileAtlasFromInputs));
  showIndexToggle.addEventListener('change', requestDraw);
  clearTileImgBtn.addEventListener('click', () => {
    state.tileImg = null;
    state.tileImgBitmap = null;
    requestDraw();
  });

  newMapBtn.addEventListener('click', () => {
    const w = clamp(parseInt(widthInput.value || '32', 10), 1, 255);
    const h = clamp(parseInt(heightInput.value || '24', 10), 1, 255);
    resizeGrid(w, h);
    state.theme = clamp(parseInt(themeInput.value || '0', 10), 0, 255);
    state.tiles.fill(0);
    requestDraw();
  });

  exportBinBtn.addEventListener('click', () => {
    try {
      const buf = serializeBinaryMap();
      downloadBlob(new Blob([buf], { type: 'application/octet-stream' }), 'map');
    } catch (err) {
      alert('Không thể xuất: ' + err.message);
    }
  });

  exportJsonBtn.addEventListener('click', () => {
    const json = toJson();
    downloadBlob(new Blob([json], { type: 'application/json' }), 'map.json');
  });

  fillAllBtn.addEventListener('click', () => {
    const t = clamp(parseInt(tileInput.value || '0', 10), 0, 255);
    state.tiles.fill(t);
    requestDraw();
  });

  clearAllBtn.addEventListener('click', () => {
    state.tiles.fill(0);
    requestDraw();
  });

  addRowBtn.addEventListener('click', () => {
    resizeGrid(state.width, clamp(state.height + 1, 1, 255));
    requestDraw();
  });
  removeRowBtn.addEventListener('click', () => {
    resizeGrid(state.width, clamp(state.height - 1, 1, 255));
    requestDraw();
  });
  addColBtn.addEventListener('click', () => {
    resizeGrid(clamp(state.width + 1, 1, 255), state.height);
    requestDraw();
  });
  removeColBtn.addEventListener('click', () => {
    resizeGrid(clamp(state.width - 1, 1, 255), state.height);
    requestDraw();
  });

  widthInput.addEventListener('change', setSizeFromInputs);
  heightInput.addEventListener('change', setSizeFromInputs);
  themeInput.addEventListener('change', setSizeFromInputs);
  cellSizeInput.addEventListener('change', setSizeFromInputs);

  // Canvas interactions
  canvas.addEventListener('contextmenu', (e) => e.preventDefault());
  canvas.addEventListener('mousedown', (e) => {
    const cell = getMouseCell(e);
    if (!cell) return;
    state.isMouseDown = true;
    state.lastPainted.clear();
    const t = e.button === 2 ? 0 : clamp(parseInt(tileInput.value || '0', 10), 0, 255);
    paintCell(cell.x, cell.y, t);
  });
  window.addEventListener('mouseup', () => { state.isMouseDown = false; state.lastPainted.clear(); });
  canvas.addEventListener('mousemove', (e) => {
    if (!state.isMouseDown) return;
    const cell = getMouseCell(e);
    if (!cell) return;
    const t = (e.buttons & 2) ? 0 : clamp(parseInt(tileInput.value || '0', 10), 0, 255);
    paintCell(cell.x, cell.y, t);
  });

  // Initial draw
  widthInput.value = String(state.width);
  heightInput.value = String(state.height);
  themeInput.value = String(state.theme);
  cellSizeInput.value = String(state.cellSize);
  tileFrameWInput.value = String(state.tileFrameW);
  tileFrameHInput.value = String(state.tileFrameH);
  tileColsInput.value = String(state.tileCols);
  requestDraw();
})();