public final class ba extends au {
  private byte a;
  
  private byte b = 0;
  
  private byte[][][] c = new byte[][][] { { { 
          7, 7, 7, 8, 8, 8, 9, 9, 9, 6, 
          6, 6, 6 }, { 
          12, 12, 12, 13, 13, 13, 14, 14, 14, 11, 
          11, 11, 11 }, { 
          2, 2, 2, 3, 3, 3, 4, 4, 4, 1, 
          1, 1, 1 }, { 
          2, 2, 2, 3, 3, 3, 4, 4, 4, 1, 
          1, 1, 1 } }, { { 
          7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 
          9, 9, 6, 6, 6, 6 }, { 
          12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 
          14, 14, 11, 11, 11, 11 }, { 
          2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 
          4, 4, 1, 1, 1, 1 }, { 
          2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 
          4, 4, 1, 1, 1, 1 } }, { { 
          7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 
          9, 9, 6, 6, 6, 6 }, { 
          12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 
          14, 14, 11, 11, 11, 11 }, { 
          2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 
          4, 4, 1, 1, 1, 1 }, { 
          2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 
          4, 4, 1, 1, 1, 1 } } };
  
  private byte[][] d = new byte[][] { { 
        5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 
        5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 
        6 }, { 
        10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 
        11, 11, 11, 11, 11, 11, 11, 11, 11, 11 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
  
  private byte[] e = new byte[] { -11, -7, -4 };
  
  private byte f;
  
  private byte g;
  
  private byte h = 0;
  
  private byte i = 0;
  
  public ba(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.di = 14;
    this.ct = paramInt1;
    this.B = paramInt2;
    this.cu = 1;
    this.cB = paramString;
    this.aY = paramInt4;
    this.aZ = paramInt5;
    this.be = -1;
    this.bd = -1;
    this.bs = paramInt6;
    this.by = (short)paramInt7;
    this.b = 2;
    this.cF = 0;
    this.M = 0;
    this.f = 3;
    this.g = 5;
    this.N = this.f * this.g;
    this.cY = dw.a();
  }
  
  public final boolean l_() {
    return true;
  }
  
  public final void d(int paramInt) {
    this.bi = paramInt;
    this.a = (byte)paramInt;
    this.h = (byte)(paramInt + 1);
  }
  
  public final String f() {
    return this.R;
  }
  
  public final void a(bx parambx) {
    fd fd;
    if ((fd = bk.c((short)this.B)) != null && !this.bI && fd.a != null) {
      if (this.cG == 3) {
        this.i = 2;
      } else if (this.cG == 2) {
        this.i = -2;
      } else {
        this.i = 0;
      } 
      if (this.bd < 0) {
        this.bd = aq.a(fd.a.a) / this.f;
        this.be = aq.b(fd.a.a) / this.g;
        this.bq = this.be / 2;
      } 
      if (this.ef >= 0 && this.ef < this.N) {
        int i = 0;
        int j = 0;
        i = this.ef / this.g * this.bd;
        j = this.ef % this.g * this.be;
        if (this.cV) {
          parambx.a(fd.a, i, j, this.bd, this.be, (this.cG > 2) ? 2 : 0, this.aY, this.aZ - this.bo - this.bj + this.bk, 33);
          parambx.a(ez.dd, 0, ((this.cF != 0) ? 2 : 0) * 17 + ft.ai / 2 % 2 * 17, 28, 17, 0, this.aY + this.i, this.aZ + this.bk - 8, 3);
        } else {
          ez.c(parambx, this.aY + this.i, this.aZ - this.bo + this.e[this.b]);
          parambx.a(fd.a, i, j, this.bd, this.be, (this.cG > 2) ? 2 : 0, this.aY, this.aZ - this.bo - this.bj + this.bk, 33);
        } 
      } 
    } 
    o.j.a(parambx, this.R.equals("") ? this.cB : this.R, this.aY, this.aZ - this.be - 8 - (this.bI ? 5 : 0), 2, false);
    super.a(parambx);
  }
  
  public final void a() {
    super.a();
    ba ba1;
    (ba1 = this).eg = (byte)((ba1 = this).eg + 1);
    if (ba1.cF == 0) {
      if (ba1.eg > (ba1.d[ba1.cG]).length - 1)
        ba1.eg = 0; 
      ba1.ef = ba1.d[ba1.cG][ba1.eg];
    } else if (ba1.cF == 1) {
      if (ba1.eg > (ba1.c[ba1.b][ba1.cG]).length - 1)
        ba1.eg = 0; 
      ba1.ef = ba1.c[ba1.b][ba1.cG][ba1.eg];
    } 
    int i = ft.p.a(this.aY + this.bb, this.aZ + this.bc);
    g(this.M, i);
    if (!H() || this.bH)
      return; 
    long l1;
    long l2;
    if (!this.cW && (l2 = (l1 = dw.a()) - this.cY) >= 5000L) {
      this.cY = l1;
      q.a().c((short)this.ct);
    } 
    if (this.bb == 0 && this.bc == 0)
      this.cF = 0; 
    if (ez.c(this.aY, this.aZ, this.bf, this.bg) >= cs.l * 3 && ez.c(this.aY, this.aZ, this.bf, this.bg) <= cs.l << 2)
      this.a = this.h; 
    if (ez.c(this.aY, this.aZ, this.bf, this.bg) < cs.l * 3)
      this.bi = (byte)(this.h - 1); 
    if (this.a > 1) {
      if (this.ef == 3 || this.ef == 8 || this.ef == 13) {
        this.bi = this.a - 1;
        return;
      } 
      this.bi = this.a;
    } 
  }
  
  public final void a(String paramString) {
    this.R = paramString;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ba.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */