public final class cu extends au {
  private byte a = -1;
  
  private byte b = 0;
  
  private dq c;
  
  private int d;
  
  private ce e;
  
  private int[] f = new int[] { 
      0, 30, 60, 90, 120, 150, 180, 210, 240, 270, 
      300, 330 };
  
  private long g = 0L;
  
  public cu(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.cu = 1;
    this.di = 13;
    this.ct = paramInt1;
    this.B = paramInt2;
    this.F = paramInt4;
    this.G = paramInt5;
    this.aY = paramInt4;
    this.aZ = paramInt5;
    this.cB = paramString;
    this.bs = paramInt6;
    this.br = paramInt6;
    this.by = (short)paramInt7;
    this.M = 1;
    this.cG = 0;
    this.N = 5;
    this.bd = this.be = -1;
    this.bi = 3;
    this.e = new ce(1);
    this.d = 120;
    this.C = 60;
    this.A = ak.c(50, 70);
    this.D = 50;
    this.bn = 0;
    this.bo = -2;
    this.cY = dw.a();
    if (this.B == 110) {
      this.a = 52;
      this.d = 120;
      this.c = new dq(this.a, paramInt4, paramInt5, 0, 0, 1, 0);
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, short paramShort) {
    this.a = (byte)paramInt1;
    this.c = new dq(this.a, this.aY, this.aZ, 0, 0, 1, 0);
    this.d = paramInt2;
    this.by = paramShort;
  }
  
  public final void a(long paramLong) {
    this.g = paramLong;
  }
  
  public final boolean x() {
    return true;
  }
  
  public final void a(int paramInt) {
    this.by = (byte)paramInt;
    if (this.B == 110) {
      if (this.by == 1) {
        this.a = 52;
        this.d = 120;
      } 
      if (this.by == 2) {
        this.a = 53;
        this.d = 130;
      } else if (this.by == 3) {
        this.a = 54;
        this.d = 140;
      } else if (this.by == 4) {
        this.a = 55;
        this.d = 150;
      } 
      this.c = new dq(this.a, this.aY, this.aZ, 0, 0, 1, 0);
    } 
  }
  
  public final void b_() {}
  
  public final void a() {
    super.a();
    long l1;
    long l2;
    if (!this.cW && (l2 = (l1 = dw.a()) - this.cY) >= 5000L) {
      this.cY = l1;
      q.a().c((short)this.ct);
    } 
    a_();
    cu cu1 = this;
    this.b = (byte)(this.b + 1);
    if (this.b > 10)
      this.b = 0; 
    if (this.c != null)
      this.c.a(); 
    boolean bool = false;
    if (this.cO != null) {
      if (cn.f.cO != null && this.cO.b == cn.f.cO.b)
        bool = true; 
    } else if (this.R.equals(cn.f.cB)) {
      bool = true;
    } 
    if (bool) {
      this.bo = 10;
      for (byte b = 0; b < this.f.length; b++) {
        this.f[b] = this.f[b] + 1;
        if (this.f[b] >= 360)
          this.f[b] = 0; 
      } 
    } 
  }
  
  public final void a(bx parambx) {
    if (this.c != null)
      this.c.a(parambx); 
    boolean bool = false;
    if (this.cO != null) {
      if (cn.f.cO != null && this.cO.b == cn.f.cO.b)
        bool = true; 
    } else if (this.R.equals(cn.f.cB)) {
      bool = true;
    } 
    if (bool) {
      a(parambx, this.aY - 1, this.aZ - this.bo - this.bj + this.bk - this.be - 20, 2);
      String str = null;
      long l;
      if (!(str = cs.b(l = this.g - dw.a())).equals(""))
        o.k.a(parambx, str, this.aY, this.aZ - this.bo - this.bj + this.bk - this.be - 40, 3, false); 
      o.k.a(parambx, String.valueOf(df.ac) + this.by, this.aY, this.aZ - this.bo - this.bj + this.bk - this.be - 55, 3, false);
      for (byte b = 0; b < this.f.length; b++) {
        if (this.e != null)
          this.e.c(this.b / 2 % this.e.c, ak.b(this.f[b]) * this.d / 1024 + this.aY + 2, ak.a(this.f[b]) * this.d / 1024 + this.aZ, 0, 3, parambx); 
      } 
    } 
  }
  
  public final void h() {}
  
  public final void p_() {}
  
  public final void z() {}
  
  public final void A() {}
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cu.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */