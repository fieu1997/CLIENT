public final class ep extends p {
  private int a = 180;
  
  private int b = 160;
  
  private fi f;
  
  private static es g = new es("CreateChar VecDefaultchar");
  
  private int h;
  
  private int i;
  
  private int j = 0;
  
  private int k = 0;
  
  private int l;
  
  private int m;
  
  private byte n;
  
  private es o;
  
  private bt p;
  
  private bt q;
  
  private bt r;
  
  private bt s;
  
  private bt t;
  
  private int u;
  
  public final void a(byte paramByte) {
    this.n = paramByte;
    c();
  }
  
  public ep() {
    (new byte[2])[0] = 8;
    (new byte[2])[1] = 9;
    (new byte[2][])[0] = new byte[2];
    (new byte[2])[0] = 10;
    (new byte[2])[1] = 11;
    (new byte[2][])[1] = new byte[2];
    (new byte[2])[1] = 1;
    (new byte[2][])[0] = new byte[2];
    (new byte[2])[0] = 2;
    (new byte[2])[1] = 3;
    (new byte[2][])[1] = new byte[2];
    this.l = 2;
    this.m = 2;
    this.n = 0;
    this.o = new es("CreateChar veccmd");
    if (ft.A) {
      this.b = 182;
      this.a = 200;
    } 
    this = this;
    g.d();
    this.aa = new bt(df.ab, 0);
    this.t = new bt(df.af, 1);
    if (ft.A) {
      int k;
      if ((k = bt.j / 2) < this.a / 4)
        k = this.a / 4; 
      this.aa.a(ft.Y - k, ft.Z + this.b / 2 + 4, (ce)null, this.aa.a);
      this.t.a(ft.Y + k, ft.Z + this.b / 2 + 4, (ce)null, this.t.a);
    } 
    this.Y = this.t;
    for (byte b1 = 0; b1 < 4; b1++) {
      bm bm1;
      (bm1 = new bm(b1, (byte)0, "", 0, 0)).bx = (byte)b1;
      bm1.bZ = b1;
      bm1.bY = b1;
      bm1.bW = -1;
      bm1.bX = 0;
      bm1.cb = b1;
      bm1.ca = b1 + 8;
      bm1.bU = bm1.ca;
      bm1.cG = 0;
      bm1.cc = -1;
      bm1.aY = this.a / 5 + b1 * this.a / 4;
      bm1.aZ = this.b / 5 << 1;
      bm1.dX = 0;
      g.a(bm1);
    } 
    this.k = ak.f(4);
    this.j = 0;
    p.e.a(g.c() * this.a / 4, 0, this.k * this.a / 4, 0);
    this.f = new fi(ft.Y - this.a / 2 + this.a / 5 - 25, ft.Z - this.b / 2 + this.b / 2 + 10, 60);
    if (!ft.A) {
      this.f.a(true);
      return;
    } 
    this.p = new bt(df.gn[this.k], 0, this);
    this.o.a(this.p);
    bm bm = (bm)g.a(this.k);
    this.q = new bt(df.gE[this.k / 2][bm.cb % this.l], 1, this);
    this.o.a(this.q);
    int j;
    if ((j = bm.ca) < 8)
      j = bm.bU; 
    this.r = new bt(df.gF[0][j - 8], 2, this);
    this.o.a(this.r);
    this.s = new bt(df.gF[1][bm.bX], 3, this);
    this.o.a(this.s);
    int i = ft.Y - this.a / 2;
    j = ft.Z - this.b / 2 - ft.aa / 2;
    for (byte b2 = 0; b2 < this.o.c(); b2++) {
      bt bt1;
      (bt1 = (bt)this.o.a(b2)).a(i + (this.a / 3 << 1), j + this.b / 5 * (b2 + 1) + 5, cf.v, bt1.a);
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    bm bm;
    switch (paramInt1) {
      case 0:
        this.j = 0;
        this.k++;
        this.h = 0;
        if (this.k == 4)
          p.e.a = -this.a / 4; 
        this.k = cg.a(this.k, df.gn.length - 1, true);
        p.e.c = this.k * this.a / 4;
        this.p.a = df.gn[this.k];
        bm = (bm)g.a(this.k);
        this.q.a = df.gE[this.k / 2][bm.cb % this.l];
        return;
      case 1:
      case 2:
      case 3:
        this.j = bm;
        b(1);
        break;
    } 
  }
  
  public final void b(int paramInt1, int paramInt2) {
    String str;
    bm bm;
    switch (paramInt1) {
      case 0:
        if ((str = this.f.j()).length() < 6) {
          ft.a(df.ae);
          break;
        } 
        bm = (bm)g.a(this.k);
        q.a().a(bm.bx, str, (byte)bm.cb, (byte)bm.bU, (byte)bm.bX);
        ft.a(df.aG, (bt)null);
        break;
      case 1:
        if (x.a.c() == 0) {
          ft.b.c();
          l.a().c();
          cn.f = new bq(0, (byte)0, "unname", 0, 0);
          break;
        } 
        ft.i.c();
        break;
    } 
    super.b(paramInt1, paramInt2);
  }
  
  public final void a(bx parambx) {
    gb.a(parambx);
    cg.a(parambx, ft.Y - this.a / 2, ft.Z - this.b / 2 - ft.aa / 2, this.a, this.b, true, (byte)0);
    parambx.a(ft.Y - this.a / 2, ft.Z - this.b / 2 - ft.aa / 2);
    bm bm = (bm)g.a(this.k);
    int i;
    for (i = 0; i < df.gm.length; i++)
      o.c.a(parambx, df.gm[i], this.a / 3 << 1, this.b / 5 * i + this.b / 10, 2, false); 
    if (!ft.A) {
      cg.a(parambx, df.gn[this.k], this.a / 3 << 1, this.b / 5, 2, 2);
      cg.a(parambx, df.gE[this.k / 2][bm.cb % this.l], this.a / 3 << 1, this.b / 5 << 1, 2, 2);
      if ((i = bm.ca) < 8)
        i = bm.bU; 
      cg.a(parambx, df.gF[0][i - 8], this.a / 3 << 1, this.b / 5 * 3, 2, 2);
      cg.a(parambx, df.gF[1][bm.bX], this.a / 3 << 1, this.b / 5 << 2, 2, 2);
    } 
    if (!ft.A) {
      parambx.a(ez.cZ, 0, 0, 11, 9, 5, (this.a / 3 << 1) - 35 - this.i / 2 % 4, this.b / 5 * (this.j + 1) + 4, 3);
      parambx.a(ez.cZ, 0, 0, 11, 9, 6, (this.a / 3 << 1) + 35 + this.i / 2 % 4, this.b / 5 * (this.j + 1) + 4, 3);
    } 
    o.i.a(parambx, df.ad, this.a / 5 + 4, this.b / 2 + 5, 2, false);
    parambx.d(8, 2, (this.a / 5 << 1) - 12, this.b - 4);
    parambx.a(-p.e.a, 0);
    for (i = 0; i < g.c(); i++) {
      bm = (bm)g.a(i);
      if (i == 0)
        bm.b(parambx, bm.aY + this.a / 4 * g.c(), bm.aZ, bm.cG); 
      if (i == g.c() - 1)
        bm.b(parambx, bm.aY - this.a / 4 * g.c(), bm.aZ, bm.cG); 
      bm.c(parambx, -1);
      if (bm.cF == 2) {
        bm.dg.a(bm);
      } else if (bm.cF == 1) {
        bm.ba++;
        if (bm.ba > bm.cf.length - 1)
          bm.ba = 0; 
        bm.ce = bm.cf[bm.ba];
      } else {
        bm.J();
      } 
      bm.K();
    } 
    ft.a(parambx);
    for (i = 0; i < this.o.c(); i++) {
      bt bt1;
      (bt1 = (bt)this.o.a(i)).a(parambx, bt1.h, bt1.i);
    } 
    this.f.a(parambx);
    if (cf.W == 0) {
      parambx.a(cg.aB, 0, 0, 0);
    } else if (cf.W == 1) {
      cf.j(parambx);
    } 
    if (bs.b) {
      o.k.a(parambx, df.F, ft.W, 0, 1, false);
      parambx.a(16514362);
      parambx.c(ft.W - bs.p, 10, bs.p, 1);
    } 
    super.a(parambx);
  }
  
  public final void a() {
    if (bs.j < 20 && (bs.j += 4) > 20)
      bs.j = 20; 
    if (this.h == 0) {
      bm bm;
      (bm = (bm)g.a(this.k)).cG = 0;
    } else if (this.h == 30 || this.h == 10) {
      bm bm;
      (bm = (bm)g.a(this.k)).cF = 2;
      bm.ba = 0;
      bm.t();
      bm.dg.a(bm.bx);
    } else if (this.h == 50) {
      bm bm;
      (bm = (bm)g.a(this.k)).cF = 1;
      bm.ba = 0;
    } else if (this.h > 80) {
      bm bm = (bm)g.a(this.k);
      this.h = 1;
      bm.cF = 0;
      bm.ba = 0;
      bm.cG = ++bm.cG % 4;
    } 
    this.h++;
    this.f.a();
    this.i++;
    p.e.b();
    p.e.b();
    gb.b();
  }
  
  public final void d() {
    if (ft.al[4]) {
      if (this.j == 0) {
        this.k--;
        this.h = 0;
      } else {
        b(-1);
      } 
      ft.d(4);
      this.f.g = this.f.j().length() + 1;
    } else if (ft.al[6]) {
      if (this.j == 0) {
        this.k++;
        this.h = 0;
      } else {
        b(1);
      } 
      ft.d(6);
      this.f.g = this.f.j().length() + 1;
    } else if (ft.al[2]) {
      this.j--;
      ft.d(2);
    } else if (ft.al[8]) {
      this.j++;
      ft.d(8);
    } 
    this.j = cg.a(this.j, df.gm.length - 1, true);
    if (this.k == 4) {
      p.e.a = -this.a / 4;
    } else if (this.k == -1) {
      p.e.a = 4 * this.a / 4;
    } 
    this.k = cg.a(this.k, df.gn.length - 1, true);
    p.e.c = this.k * this.a / 4;
    if (this.f.f()) {
      this.Z = this.f.b();
    } else {
      this.Z = null;
    } 
    if (ft.ak[3])
      this.u = (this.u + 1) % 4; 
    super.d();
  }
  
  private void b(int paramInt) {
    bm bm = (bm)g.a(this.k);
    switch (this.j) {
      case 1:
        bm.cb += paramInt;
        bm.cb = this.k / this.l * this.l + cg.a(bm.cb - this.k / this.l * this.l, this.l - 1, true);
        if (ft.A) {
          this.q.a = df.gE[this.k / 2][bm.cb % this.l];
          return;
        } 
        break;
      case 2:
        bm.ca += paramInt;
        bm.ca = 8 + this.k / this.m * this.m + cg.a(bm.ca - 8 - this.k / this.m * this.m, this.m - 1, true);
        bm.bU = bm.ca;
        if (ft.A) {
          if ((paramInt = bm.ca) < 8)
            paramInt = bm.bU; 
          this.r.a = df.gF[0][paramInt - 8];
          return;
        } 
        break;
      case 3:
        bm.bX += paramInt;
        bm.bX = cg.a(bm.bX, (df.gF[1]).length - 1, true);
        if (ft.A)
          this.s.a = df.gF[1][bm.bX]; 
        break;
    } 
  }
  
  public final void a(int paramInt) {
    if (this.f.f())
      this.f.b(paramInt); 
    super.a(paramInt);
  }
  
  public final void e() {
    this.f.g();
    for (byte b = 0; b < this.o.c(); b++) {
      bt bt1;
      (bt1 = (bt)this.o.a(b)).b();
    } 
    super.e();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ep.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */