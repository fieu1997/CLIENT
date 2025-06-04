public final class ga extends s {
  private byte U;
  
  private int V;
  
  private int W;
  
  private int X;
  
  private int ej;
  
  public ga(ez paramez, short paramShort, byte paramByte1, byte paramByte2, byte paramByte3) {
    super(paramShort, paramByte1, paramByte2, paramByte3);
    (new byte[3])[1] = 5;
    (new byte[3])[2] = 5;
    this.U = 0;
    this.V = 0;
    this.W = 0;
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
    this.C = 48;
    this.cG = 0;
    this.bi = 4;
    this.cF = 0;
    this.k = 0;
    this.A = ak.c(200, 250);
    this.M = 0;
    this.D = 10;
    this.O = 0;
    this.t = 50;
    if (paramByte2 == 3 || paramByte2 == 9) {
      this.U = 0;
      return;
    } 
    this.U = 6;
  }
  
  public ga(short paramShort, int paramInt, byte paramByte1, byte paramByte2, byte paramByte3) {
    super(paramShort, paramByte1, paramByte2, paramByte3);
    (new byte[3])[1] = 5;
    (new byte[3])[2] = 5;
    this.U = 0;
    this.V = 0;
    this.W = 0;
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
    this.C = 48;
    this.cG = 0;
    this.bi = 4;
    this.cF = 0;
    this.k = 0;
    this.A = ak.c(200, 250);
    this.M = 3;
    this.D = 10;
    this.O = 0;
    this.t = 50;
    if (paramByte2 == 3 || paramByte2 == 9) {
      this.U = 0;
      return;
    } 
    this.U = 6;
  }
  
  protected final void f_() {
    int i;
    switch (this.u) {
      case 2:
        this.bi = 1;
        if (this.cF == 1) {
          if ((this.dV > this.A || ez.c(this.aY + this.bb, this.aZ + this.bc, this.F, this.G) >= this.C) && this.t >= 50) {
            if (this.T > 20 && !this.cV) {
              this.dV = 0;
              this.bb = 0;
              this.bc = 0;
              this.cF = 0;
              this.T = 0;
            } 
            if (this.T <= 20)
              this.T++; 
          } 
        } else if (this.cF == 0) {
          this.bb = 0;
          this.bc = 0;
          if (this.t >= 0)
            this.t = (short)(this.t - 5); 
          if (ft.ai % 30 == 0)
            this.cG = ak.f(4); 
          if (this.dV > this.A && this.t <= 0) {
            this.dV = 0;
            c(this.bi);
            this.cF = 1;
          } 
        } 
        if (this.w != null) {
          if (this.w.cF == 1) {
            if (ez.c(this.aY, this.aZ, this.q, this.r) > 40) {
              a((byte)1);
              return;
            } 
            break;
          } 
          if (this.w.cF == 0 && ez.c(this.aY, this.aZ, this.q, this.r) > this.C << 1) {
            a((byte)3);
            return;
          } 
          break;
        } 
        if ((i = ez.c(this.aY, this.aZ, cn.f.aY, cn.f.aZ)) < 80 && i > 40 && ak.f(6) == 0) {
          a((byte)6);
          return;
        } 
        break;
      case 1:
        this.bi = 1;
        if (this.cF == 1) {
          if (this.dV > this.A || ak.f(16) == 0 || ez.c(this.aY + this.bb, this.aZ + this.bc, this.F, this.G) >= this.C) {
            this.dV = 0;
            this.cF = 0;
            this.bb = 0;
            this.bc = 0;
          } 
        } else if (this.cF == 0) {
          this.bb = 0;
          this.bc = 0;
          if (this.dV > this.A / 2 || ak.f(12) == 0) {
            this.dV = 0;
            this.cF = 1;
            this.cG = ak.f(4);
            c(this.bi);
          } 
        } 
        if (this.w != null) {
          if (this.w.cF == 1 && ez.c(this.aY, this.aZ, this.q, this.r) > 40)
            a((byte)1); 
          if (this.w.cF == 0 && ez.c(this.aY, this.aZ, this.q, this.r) > this.C << 1) {
            a((byte)3);
            return;
          } 
          break;
        } 
        if ((i = ez.c(this.aY, this.aZ, cn.f.aY, cn.f.aZ)) < 80 && i > 40 && ak.f(6) == 0)
          a((byte)6); 
        break;
    } 
  }
  
  public final void a(bx parambx) {
    try {
      e(parambx, this.aY, this.aZ);
      f(parambx);
      if (this.k == 1 && (this.cG == 1 || this.cG == 0))
        this.cG = this.cH; 
      fd fd;
      if ((fd = bk.l(this.j)).a != null) {
        if (this.bd < 0) {
          this.be = aq.b(fd.a.a) / this.N;
          this.bd = aq.a(fd.a.a) / 2;
        } 
        parambx.a(ez.db, this.aY + this.s, this.aZ - this.U, 3);
        if (this.cV && this.t <= 0) {
          parambx.a(fd.a, this.V, this.W, this.bd, this.be, (this.cG > 2) ? 2 : 0, this.aY + this.s, this.aZ + this.bk + 8, 33);
          parambx.a(ez.dd, 0, ((this.cF != 0) ? 2 : 0) * 17 + ft.ai / 2 % 2 * 17, 28, 17, 0, this.aY + this.s, this.aZ + this.bk - 8, 3);
        } else {
          parambx.a(fd.a, this.V, this.W, this.bd, this.be, (this.cG > 2) ? 2 : 0, this.aY + this.s, this.aZ - this.t, 33);
        } 
      } 
      e(parambx);
      f(parambx, this.aY, this.aZ);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  protected final void i() {
    this.bi = 12;
    if (this.Q != null && this.Q.c() > 0) {
      bf bf;
      ez ez;
      if ((ez = ez.a((bf = (bf)this.Q.a(this.n)).a, bf.b)) == null || ez.br <= 0) {
        this.cU = false;
        a((byte)4);
        return;
      } 
      this.bf = ez.aY;
      this.bg = ez.aZ;
      h();
      if (ez.c(this.aY + this.bb, this.aZ + this.bc, ez.aY, ez.aZ) < 30) {
        if (this.t >= 15)
          this.t = (short)(this.t - 15); 
        this.ba = 4;
        if (this.t <= 15) {
          l();
          a((byte)4);
          return;
        } 
      } else if (this.t <= 50) {
        this.t = (short)(this.t + 5);
      } 
    } 
  }
  
  public final void a() {
    this.X = this.cF;
    if (this.X > this.z.length - 1)
      this.X = 0; 
    if (this.ba > (this.z[this.X][(this.cG > 2) ? 2 : this.cG]).length - 1)
      this.ba = 0; 
    this.ej = this.z[this.X][(this.cG > 2) ? 2 : this.cG][this.ba] / 3;
    this.V = ((this.ej > 1) ? 1 : this.ej) * this.bd;
    this.ej = this.z[this.X][(this.cG > 2) ? 2 : this.cG][this.ba];
    this.W = this.ej % 3 * this.be;
    if (this.V == -1)
      this.V = 0; 
    if (this.W == -1)
      this.W = 0; 
    if (this.t <= 0)
      this.V = this.W = 0; 
    if (((this.bb < 0 && this.bc > 0) || (this.bb > 0 && this.bc > 0)) && this.k == 0 && this.t >= 30) {
      this.ba = 3;
      if (this.bb < 0) {
        this.bb = -3;
      } else {
        this.bb = 3;
      } 
      if (this.bc < 0) {
        this.bc = -3;
      } else {
        this.bc = 3;
      } 
    } 
    super.a();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ga.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */