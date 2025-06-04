public final class fx extends s {
  public fx(ez paramez, short paramShort, byte paramByte1, byte paramByte2, byte paramByte3) {
    super(paramShort, paramByte1, paramByte2, paramByte3);
    this.w = paramez;
    this.cu = 9;
    this.ct = paramez.ct;
    this.F = paramez.aY;
    this.G = paramez.aZ;
    this.aY = paramez.aY;
    this.aZ = paramez.aZ;
    this.o = paramez.aY;
    this.p = paramez.aZ;
    this.bd = -1;
    this.be = -1;
    this.C = 60;
    this.cG = 0;
    this.bi = 4;
    this.cF = 0;
    this.k = 0;
    this.A = ak.c(50, 70);
    this.M = 0;
    this.D = 30;
    this.O = 0;
  }
  
  public fx(short paramShort, int paramInt, byte paramByte1, byte paramByte2, byte paramByte3) {
    super(paramShort, paramByte1, paramByte2, paramByte3);
    this.w = null;
    this.cu = 9;
    this.ct = paramInt;
    int i = (this.h[ak.f(this.h.length)]).a;
    paramInt = (this.h[ak.f(this.h.length)]).b;
    this.F = i;
    this.G = paramInt;
    this.aY = i;
    this.aZ = paramInt;
    this.o = i;
    this.p = paramInt;
    this.bd = -1;
    this.be = -1;
    this.C = 120;
    this.cG = 0;
    this.bi = 4;
    this.cF = 0;
    this.k = 0;
    this.A = ak.c(50, 70);
    this.M = 3;
    this.D = 200;
    this.O = 0;
  }
  
  public final void a(bx parambx) {
    try {
      e(parambx, this.aY, this.aZ);
      f(parambx);
      fd fd = bk.l(this.j);
      if (this.k == 1 && (this.cG == 1 || this.cG == 0))
        this.cG = this.cH; 
      int i;
      if ((i = this.cF) > this.z.length - 1)
        i = 0; 
      if (this.ba > (this.z[i][(this.cG > 2) ? 2 : this.cG]).length - 1)
        this.ba = 0; 
      if (fd.a != null) {
        if (this.bd < 0) {
          this.be = aq.b(fd.a.a) / this.N;
          this.bd = aq.a(fd.a.a) / 2;
        } 
        int j = 0;
        int k = 0;
        j = this.z[i][(this.cG > 2) ? 2 : this.cG][this.ba] / 3 * this.bd;
        k = this.z[i][(this.cG > 2) ? 2 : this.cG][this.ba] % 3 * this.be;
        if (this.cV) {
          parambx.a(fd.a, j, k, this.bd, this.be, (this.cG > 2) ? 2 : 0, this.aY + this.s, this.aZ + this.bk + 4, 33);
          parambx.a(ez.dd, 0, ((i != 0) ? 2 : 0) * 17 + ft.ai / 2 % 2 * 17, 28, 17, 0, this.aY + 1 + this.s, this.aZ + this.bk - 4, 3);
        } else {
          parambx.a(fd.a, j, k, this.bd, this.be, (this.cG > 2) ? 2 : 0, this.aY + this.s, this.aZ, 33);
        } 
      } 
      e(parambx);
      f(parambx, this.aY, this.aZ);
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      exception1.toString();
      return;
    } 
  }
  
  protected final void i() {
    if (this.dn == null)
      this.dn = new do((byte)2); 
    this.bi = 9;
    if (this.Q != null && this.Q.c() > 0) {
      bf bf;
      ez ez;
      if ((ez = ez.a((bf = (bf)this.Q.a(this.n)).a, bf.b)) == null) {
        this.cU = false;
        return;
      } 
      if (ez.c(this.aY + this.bb, this.aZ + this.bc, ez.aY, ez.aZ) > this.D && ez.br > 0) {
        this.bf = ez.aY;
        this.bg = ez.aZ;
        h();
        return;
      } 
      if (ft.aj - this.P > this.O) {
        this.cQ = bf.a;
        bf.g = this.dn;
        t();
        l();
        this.O = 200;
        this.P = ft.aj;
        if (this.m == 2) {
          if (this.n >= this.Q.c() - 1) {
            this.i = false;
            a((byte)4);
            this.n = 0;
            return;
          } 
        } else if (this.m == 5 && this.n == 3) {
          this.i = false;
          a((byte)4);
          this.n = 0;
        } 
      } 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fx.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */