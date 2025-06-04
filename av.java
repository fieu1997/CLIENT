public final class av extends s {
  private byte U;
  
  private int V;
  
  private int W;
  
  private boolean X;
  
  private int ej;
  
  private int ek = 0;
  
  public av(ez paramez, short paramShort, byte paramByte1, byte paramByte2, byte paramByte3) {
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
    this.C = 48;
    this.cG = 0;
    this.bi = 4;
    this.cF = 0;
    this.k = 0;
    this.A = ak.c(200, 250);
    this.M = 0;
    this.D = 10;
    this.O = 0;
    this.a = true;
  }
  
  public av(short paramShort, int paramInt, byte paramByte1, byte paramByte2, byte paramByte3) {
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
    this.C = 48;
    this.cG = 0;
    this.bi = 4;
    this.cF = 0;
    this.U = 0;
    this.k = 0;
    this.A = ak.c(200, 250);
    this.M = 3;
    this.D = 10;
    this.O = 0;
    this.a = true;
  }
  
  public av() {}
  
  public final void a(bx parambx) {
    es es1 = new es();
    es es2;
    if ((es2 = (es)s.b.a(this.j)) != null)
      es1 = es2; 
    if (es1.c() == 0)
      return; 
    try {
      fa fa;
      if ((fa = (fa)es1.a(0)) != null) {
        e(parambx, this.aY, this.aZ);
        byte b = this.U;
        if (this.k == 2 && this.X)
          b = 3; 
        byte b1 = 0;
        int i = this.cF;
        av av1 = this;
        es es5 = new es();
        es es4;
        if ((es4 = (es)s.b.a(av1.j)) != null)
          es5 = es4; 
        fa fa1;
        if (((fa1 = (fa)es5.a(0)) != null && fa1.a <= -5)) {
          b1 = 35;
          parambx.a(ez.db, this.aY, this.aZ - 6, 3);
        } else {
          if (!this.cV)
            parambx.a(ez.db, this.aY, this.aZ, 3); 
          if (this.cV)
            parambx.a(ez.dd, 0, ((i != 0) ? 2 : 0) * 17 + ft.ai / 2 % 2 * 17, 28, 17, 0, this.aY + 1 + this.s, this.aZ + this.bk - 4, 3); 
        } 
        fd fd = bk.l(this.j);
        es es3;
        if ((es3 = (es)s.b.a(this.j)) != null && fd != null && fd.a != null)
          fa.a(parambx, fa.a(this.ce, b, this.V), this.aY, this.aZ - b1, this.W, fd.a); 
        f(parambx, this.aY, this.aZ);
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public final void a() {
    av av1 = this;
    es es1 = new es();
    es es2;
    if ((es2 = (es)s.b.a(av1.j)) != null)
      es1 = es2; 
    es2 = null;
    if (es1.c() > 0) {
      fa fa = (fa)es1.a(0);
      byte b = av1.U;
      if (av1.k == 2 && av1.X)
        b = 3; 
      av1.ce = (byte)((av1.ce + 1) % (fa.a(b, av1.V)).a.length);
      if (av1.ek == 0)
        av1.ek = (fa.a(3, av1.V)).a.length; 
    } 
    try {
      super.a();
      int i = ft.p.a(this.aY + this.bb, this.aZ + this.bc);
      g(this.M, i);
      if (this.w != null) {
        if (ez.c(this.aY, this.aZ, this.bf, this.bg) <= 10)
          this.v.b(0); 
        this.F = this.w.aY;
        this.G = this.w.aZ;
        this.q = this.w.aY;
        this.r = this.w.aZ;
      } 
      this.dV++;
      switch (this.k) {
        case 0:
          f_();
          break;
        case 1:
          this.U = 2;
          g();
          break;
        case 2:
          i();
          break;
        case 3:
          this.U = 2;
          g_();
          break;
        case 4:
          this.U = 0;
          h_();
          break;
      } 
      if (this.k != this.l) {
        this.l = this.k;
        return;
      } 
    } catch (Exception exception) {}
  }
  
  protected final void g_() {
    this.bi = this.w.bi;
    this.bf = this.w.aY;
    this.bg = this.w.aZ;
    d(this.bf, this.bg);
    h();
    if (ez.c(this.aY, this.aZ, this.F, this.G) < 40 && this.w.cF != 2)
      a((byte)0); 
  }
  
  protected final void i() {
    this.bi = 12;
    if (this.Q != null && this.Q.c() > 0) {
      ez ez;
      bf bf;
      if ((ez = ez.a((bf = (bf)this.Q.a(0)).a, bf.b)) == null) {
        this.cU = false;
        a((byte)4);
        return;
      } 
      if (ez.c(this.aY + this.bb, this.aZ + this.bc, ez.aY, ez.aZ) > 30 && !this.X && ez.br > 0) {
        this.bf = ez.aY;
        this.bg = ez.aZ;
        d(this.bf, this.bg);
        h();
        this.U = 2;
      } else {
        this.X = true;
      } 
      this.ej++;
      if (this.ej > this.ek && this.X) {
        try {
          byte b;
          d(ez.aY, ez.aZ);
          switch (this.m) {
            case 11:
              for (b = 0; b < this.Q.c(); b++) {
                bf bf1;
                ez ez1;
                if ((bf1 = (bf)this.Q.a(b)) != null && (ez1 = ez.a(bf1.a, bf1.b)) != null)
                  cn.a(15, this, ez1, this.aY, this.aZ, -1 * bf1.c, (short)163, 163, 24); 
              } 
              break;
            case 12:
              for (b = 0; b < this.Q.c(); b++) {
                bf bf1;
                ez ez1;
                if ((bf1 = (bf)this.Q.a(b)) != null && (ez1 = ez.a(bf1.a, bf1.b)) != null) {
                  cn.a(57, 21, ez1.aY, ez1.aZ);
                  cn.a("-" + bf1.c, ez1.aY, ez1.aZ - ez1.be, 2, ez1.ct);
                } 
              } 
              break;
          } 
        } catch (Exception exception) {}
        this.ej = 0;
        this.X = false;
        a((byte)4);
      } 
    } 
  }
  
  protected final void f_() {
    this.bi = 1;
    if (this.cF == 1) {
      if (this.dV > this.A || ak.f(16) == 0 || ez.c(this.aY + this.bb, this.aZ + this.bc, this.F, this.G) >= this.C) {
        this.dV = 0;
        this.cF = 0;
        this.U = 0;
        this.bb = 0;
        this.bc = 0;
      } 
    } else if (this.cF == 0) {
      this.bb = 0;
      this.bc = 0;
      if (this.dV > this.A / 2 || ak.f(12) == 0) {
        this.dV = 0;
        this.cF = 1;
        this.U = 2;
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
    } else {
      int i;
      if ((i = ez.c(this.aY, this.aZ, cn.f.aY, cn.f.aZ)) < 80 && i > 40 && ak.f(6) == 0)
        a((byte)6); 
    } 
  }
  
  public final void c(int paramInt) {
    int i;
    if (ak.e(i = ak.g(3)) > 1)
      paramInt--; 
    switch (this.cG) {
      case 1:
        this.bc = -paramInt;
        this.bb = i;
        break;
      case 0:
        this.bc = paramInt;
        this.bb = i;
        break;
      case 2:
        this.bc = i;
        this.bb = -paramInt;
        break;
      case 3:
        this.bc = i;
        this.bb = paramInt;
        break;
    } 
    if (this.bb == 0 && ak.f(3) == 0) {
      this.dV = 0;
      this.cF = 0;
      this.bb = 0;
      this.bc = 0;
      this.U = 0;
    } 
    if (this.bb > 0) {
      this.cG = 3;
    } else {
      this.cG = 2;
    } 
    this.V = (byte)((this.aZ > this.bg) ? 1 : 0);
    this.W = (byte)((this.aY - this.bf > 0) ? 0 : 2);
    this.W = 0;
    if (this.cG == 3) {
      this.W = 2;
      return;
    } 
    if (this.cG != 2) {
      if (this.cG == 0) {
        this.V = 0;
        return;
      } 
      if (this.cG == 1)
        this.V = 1; 
    } 
  }
  
  protected final void g() {
    this.bi = this.w.bi;
    this.cF = 1;
    if (ez.c(this.o, this.p, this.q, this.r) > 40) {
      en en = new en(this.q, this.r);
      this.o = this.q;
      this.p = this.r;
      this.v.a(en);
    } else if (ez.c(this.aY, this.aZ, this.F, this.G) < 40) {
      this.v.d();
      a((byte)4);
    } 
    if (this.v.a(0) != null) {
      this.bf = ((en)this.v.a(0)).a;
      this.bg = ((en)this.v.a(0)).b;
      d(this.bf, this.bg);
      h();
    } 
  }
  
  private void d(int paramInt1, int paramInt2) {
    this.V = (byte)((this.aZ > paramInt2) ? 1 : 0);
    this.W = (byte)((this.aY - paramInt1 > 0) ? 0 : 2);
    this.W = 0;
    if (this.cG == 3) {
      this.W = 2;
      return;
    } 
    if (this.cG != 2) {
      if (this.cG == 0) {
        this.V = 0;
        return;
      } 
      if (this.cG == 1)
        this.V = 1; 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\av.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */