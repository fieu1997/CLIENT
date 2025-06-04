public final class ac extends au {
  private int a = 0;
  
  private static byte[][][] b = new byte[][][] { { { 0, 0, 1, 1, 2, 2 }, { 1, 1, 2, 2 }, { 2, 2, 1, 1 } }, { { 0, 0, 1, 1, 2, 2 }, { 1, 1, 2, 2 }, { 2, 2, 1, 1 } }, { { 2, 2, 2, 3, 3, 3 }, { 2, 2, 2, 3, 3, 3 }, { 2, 2, 2, 3, 3, 3 } }, { { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 } }, { { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 } } };
  
  private static byte[][][] c = new byte[][][] { { { 0, 0, 1, 1, 2, 2 }, { 1, 1, 2, 2 }, { 2, 2, 1, 1 } }, { { 0, 0, 1, 1, 2, 2 }, { 1, 1, 2, 2 }, { 2, 2, 1, 1 } }, { { 2, 2, 2, 2, 3, 3, 3, 3 }, { 2, 2, 2, 2, 3, 3, 3, 3 }, { 2, 2, 2, 2, 3, 3, 3, 3 } }, { { 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4 } }, { { 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4 } } };
  
  private static byte[][][] d = new byte[][][] { { { 0, 0, 1, 1, 2, 2 }, { 1, 1, 2, 2 }, { 2, 2, 1, 1 } }, { { 0, 0, 1, 1, 2, 2 }, { 1, 1, 2, 2 }, { 2, 2, 1, 1 } }, { { 2, 2, 2, 3, 3, 3 }, { 2, 2, 2, 3, 3, 3 }, { 2, 2, 2, 3, 3, 3 } }, { { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 } }, { { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4 } } };
  
  public ac(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.dx = 0;
    this.di = paramInt3;
    this.cu = 1;
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
    this.cG = 0;
    this.M = 0;
    this.bd = this.be = -1;
    this.N = 5;
    this.bi = 3;
    this.C = 70;
    this.bn = 0;
    this.bo = -2;
    this.A = ak.c(60, 85);
    this.D = 50;
    switch (paramInt3) {
      case 5:
      case 19:
        this.z = c;
        break;
      case 3:
        this.z = b;
        break;
      case 8:
        this.z = b;
        this.D = 80;
        break;
      case 10:
        this.z = d;
        break;
    } 
    this.cY = dw.a();
  }
  
  public final void a(bx parambx) {
    if (!this.dj) {
      if (this.cx == 2 && ez.de != null) {
        cg.a(parambx, ez.dp, this.aY, this.aZ - this.bj - this.a - this.be - 20 - 30, 2);
        parambx.a(ez.de, this.aY, this.aZ - this.bj - this.J - this.be - 20, 33);
      } 
      e(parambx, this.aY, this.aZ);
      g(parambx, this.aY, this.aZ);
      f(parambx);
      fd fd = bk.c((short)this.B);
      int i;
      if ((i = this.cF) > this.z.length - 1)
        i = 0; 
      if (this.ba > (this.z[i][(this.cG > 2) ? 2 : this.cG]).length - 1)
        this.ba = 0; 
      parambx.a(ez.db, this.aY, this.aZ - this.bj - this.a, 3);
      if (fd.a != null) {
        if (this.bd < 0)
          if (this.B <= 92) {
            this.be = aq.b(fd.a.a) / this.N;
            this.bd = aq.a(fd.a.a);
          } else {
            this.be = aq.b(fd.a.a) / 3;
            this.bd = aq.a(fd.a.a) / 2;
          }  
        int j = 0;
        int k = this.z[i][(this.cG > 2) ? 2 : this.cG][this.ba] * this.be;
        if (this.B > 92) {
          j = this.z[i][(this.cG > 2) ? 2 : this.cG][this.ba] / 3 * this.bd;
          k = this.z[i][(this.cG > 2) ? 2 : this.cG][this.ba] % 3 * this.be;
        } 
        parambx.a(fd.a, j, k, this.bd, this.be, (this.cG > 2) ? 2 : 0, this.aY, this.aZ - 8 - this.bj - this.J, 33);
        this.dR = true;
      } else {
        this.dR = false;
      } 
      a(parambx, this.aY - 1, this.aZ - this.bo - this.bj + this.bk - this.be - 20, 2);
      f(parambx, this.aY, this.aZ);
      e(parambx);
      super.a(parambx);
    } 
  }
  
  public final void a() {
    super.a();
    long l1;
    long l2;
    if (!this.cW && (l2 = (l1 = dw.a()) - this.cY) >= 5000L) {
      this.cY = l1;
      q.a().c((short)this.ct);
    } 
    I();
    a_();
    if (this.cF == 4) {
      this.a += 3;
      if (this.a > 11)
        this.a = 11; 
    } else {
      this.a = 0;
    } 
    if (!H() || this.bH)
      return; 
    b_();
    if (this.cF != 4 && this.cF != 3 && this.cF != 2)
      if (this.cU && !this.dq) {
        if (this.E > 0) {
          if (!this.dE)
            p(); 
        } else if (!u()) {
          q();
        } 
      } else if (!this.dE) {
        o();
      }  
    int i = ft.p.a(this.aY + this.bb, this.aZ + this.bc);
    if (!this.dE)
      g(this.M, i); 
    if (this.cx == 2) {
      this = this;
      if (ez.de == null) {
        if (this.dm > 0)
          this.dm--; 
        if (this.dm <= 0) {
          q.a().d((short)9999);
          this.dm = 120;
        } 
      } 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ac.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */