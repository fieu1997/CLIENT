public final class a extends au {
  private int a = 0;
  
  private boolean b = false;
  
  private static byte[] c = new byte[] { 
      0, 1, 2, 3, 4, 5, 5, 5, 5, 4, 
      3, 2, 1 };
  
  private static byte[][] d = new byte[][] { new byte[8], { 0, 0, -1, -1, 1, 1 } };
  
  private int e = 0;
  
  private int f;
  
  public a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.cu = 1;
    this.di = paramInt3;
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
    this.N = 6;
    this.bd = this.be = -1;
    this.bo = -2;
  }
  
  public final void a(bx parambx) {
    if (!this.dj) {
      fd fd;
      if ((fd = bk.c((short)this.B)).a != null) {
        if (this.bd < 0)
          if (this.B <= 92) {
            this.be = aq.b(fd.a.a) / this.N;
            this.bd = aq.a(fd.a.a);
          } else {
            this.be = aq.b(fd.a.a) / 3;
            this.bd = aq.a(fd.a.a) / 2;
          }  
        int i = 0;
        int j = c[this.ba / 3] * this.be;
        if (this.B > 92) {
          i = c[this.ba / 3] / 3 * this.bd;
          j = c[this.ba / 3] % 3 * this.be;
        } 
        if (this.b) {
          if (this.bR > 0) {
            parambx.a(fd.a, i, j, this.bd, this.f, 0, this.aY, this.aZ - this.be / 2, 33);
            parambx.a(fd.a, i, j + this.be - this.f, this.bd, this.f, 0, this.aY, this.aZ - this.be / 2 + this.f, 33);
          } 
        } else {
          parambx.a(fd.a, i, j, this.bd, this.be, 0, this.aY + d[0][this.a / 3], this.aZ + d[1][this.a / 3], 33);
        } 
      } 
      if (this.cF != 4 && !this.b)
        a(parambx, 0); 
    } 
  }
  
  public final void a() {
    a_();
    if (this.cF != 4) {
      if (this.b) {
        this.bR++;
        this.f += 2;
        if (this.f >= (this.be - 1) / 2) {
          this.b = false;
          this.bR = 0;
          this.f = 10;
        } 
      } 
      this.ba++;
      if (this.ba / 3 > c.length - 1)
        this.ba = 0; 
      this.a++;
      if (this.a / 3 > (d[0]).length - 1)
        this.a = 0; 
    } 
    super.a();
  }
  
  public final void a_() {
    if (this.cF == 4) {
      if (ak.f(3) == 1) {
        if (ak.f(2) == 1)
          cs.t = 103; 
        int i = ak.c(1, 3);
        for (byte b = 0; b < i; b++) {
          int j = ak.g(20);
          int k = ak.g(30);
          cn.a(36, this.aY + j, this.aZ + k - this.be / 2);
          if (ak.f(3) == 1)
            cn.a(9, this.aY + j, this.aZ + k - this.be / 2); 
        } 
      } 
      if (this.dA >= 0 && (ft.aj - this.aW) / 1000L > (this.dA - 1)) {
        r();
        this.b = true;
        this.bR = 0;
        this.f = 10;
        cn.a(81, this.aY, this.aZ - 20, 200, (short)0, (byte)0);
        cn.a(39, this.aY, this.aZ - this.be / 2);
        return;
      } 
    } else if (this.br <= 0) {
      this.br = 0;
      this.cF = 4;
      M();
      this.aW = ft.aj;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\a.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */