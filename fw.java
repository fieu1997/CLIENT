public final class fw extends p {
  public static ea a = new ea();
  
  public static ez b = new ez();
  
  public static ek f = new ek();
  
  private int i;
  
  private int j;
  
  private int k = 180;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private bt r;
  
  private bt s;
  
  private bt t;
  
  private bt u;
  
  private bt v;
  
  private bt w;
  
  private bt x;
  
  private bt y;
  
  private bt z;
  
  private bt A;
  
  private bt B;
  
  private fl C = new fl();
  
  public static byte g = 0;
  
  private static byte D = 1;
  
  public static byte h = 100;
  
  private byte E;
  
  private int F = fl.aM;
  
  private int G = 0;
  
  private bw H;
  
  public final void a(p paramp) {
    super.a(paramp);
    if (!ft.A) {
      this.o = 0;
      this.H = (bw)f.a(this.o + this.G);
    } else {
      this.o = -1;
    } 
    this.C.aY = null;
    this.H = null;
  }
  
  public fw() {
    if (ft.C)
      this.k = 160; 
    this.n = 12;
    this.l = 6;
    this.m = 2;
    this.i = ft.Y - this.k / 2;
    this.j = ft.Z - this.k / 2;
    if (!ft.A)
      this.j -= bt.k / 2; 
    this.p = this.i + this.k / 2 - this.l * this.F / 2;
    this.q = this.j + (this.k / 3 << 1);
    this.r = new bt(df.Z, -1);
    this.s = new bt(df.X, 0);
    this.t = new bt(df.bL, 0);
    this.u = new bt(df.aW, 1);
    this.v = new bt(df.bM, 2);
    this.w = new bt(df.aY, 3);
    this.y = new bt(df.es, 4);
    this.x = new bt(df.bI, 1);
    if (ft.A) {
      this.x.a(this.i + this.k / 2, this.j + this.k + bt.k / 2, (ce)null, this.x.a);
      this.r.a(this.i + this.k - 12, this.j + 10, cf.t, "");
    } 
    this.z = new bt(df.ak, 0, this);
    this.B = new bt(df.r, 1, this);
    this.A = new bt(df.q, 2, this);
    if (ft.A) {
      this.B.a(this.i + bt.j / 2, this.q - bt.k / 2, cf.v, this.B.a);
      this.A.a(this.i + bt.j / 2, this.q - bt.k / 2, cf.v, this.A.a);
    } 
    if (!ft.A)
      this.aa = this.B; 
  }
  
  public final void b(int paramInt1, int paramInt2) {
    fw fw1;
    es es;
    switch (paramInt1) {
      case -1:
        if (this.c.c != null) {
          this.c.a(this.c.c);
          break;
        } 
        this.c.c();
        break;
      case 0:
        fw1 = this;
        (es = new es("Info_Other_Player menu")).a(fw1.t);
        es.a(fw1.u);
        if (bq.N == null || bq.N.b.c() < 5)
          es.a(fw1.v); 
        es.a(fw1.w);
        if (fw1.E == 0 && cs.w != 1)
          es.a(fw1.y); 
        ft.o.a(es, 2, df.ai, false, (es)null);
        break;
      case 1:
        q.a().c((byte)1, b.cB);
        break;
    } 
    super.b(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    bw bw1 = (bw)f.a(this.o + this.G);
    switch (paramInt1) {
      case 0:
        if (bw1 != null) {
          q.a().a(5, null, "", (short)b.ct, bw1.O, (byte)0);
          dw.a("send buy fastion item to sv " + bw1.O + " " + b.ct);
          return;
        } 
        break;
      case 1:
        this.G = 12;
        if (!ft.A) {
          this.aa = this.A;
          return;
        } 
        break;
      case 2:
        this.G = 0;
        if (!ft.A)
          this.aa = this.B; 
        break;
    } 
  }
  
  public final void a_(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 1:
        q.a().a((byte)0, b.cB);
        break;
      case 0:
        ft.g.a(b.cB, "", "", (byte)0, true);
        ft.h();
        break;
      case 2:
        q.a().b((byte)1, b.cB);
        break;
      case 3:
        q.a().a((byte)0, b.cB, (byte)0, (short)0, 0);
        break;
      case 4:
        q.a().c((byte)0, b.cB);
        break;
    } 
    super.a_(paramInt1, paramInt2);
  }
  
  public final void a(byte paramByte) {
    if (ft.A)
      this.aa = null; 
    this.E = paramByte;
    if (paramByte == D) {
      if (!ft.A) {
        this.Z = this.r;
        this.aa = this.x;
        this.Y = this.s;
        return;
      } 
      this.aa = this.x;
    } else {
      this.E = 0;
      if (!ft.A) {
        this.Z = this.r;
        this.Y = this.s;
        return;
      } 
    } 
    this.Z = this.r;
  }
  
  public final void a(bx parambx) {
    this.c.a(parambx);
    if (ft.a != this)
      return; 
    ft.a(parambx);
    int i = this.j;
    int j = this.i;
    cg.a(parambx, j, i, this.k, this.k, b.cB);
    j += 10;
    i += ft.aa + 2;
    if (b.cO != null) {
      b.a(parambx, j - 10 + this.k / 2, i + 7, -2);
      i += this.n;
    } 
    o.j.a(parambx, String.valueOf(df.ac) + b.by, j, i, 0, false);
    i += this.n;
    o.j.a(parambx, "HP: " + b.br + "/" + b.bs, j, i, 0, false);
    if (a != null)
      a.b(parambx, this.i + this.k / 2 + 30, this.j + 90 - fl.aM / 2 + 5, fl.aM / 2, 0); 
    b.b(parambx, this.i + this.k / 2, this.j + 90, 0);
    for (i = 0; i < af.a; i = (byte)(i + 1)) {
      j = this.p + i % this.l * this.F;
      int k = this.q + i / this.l * this.F;
      bw bw1;
      if ((bw1 = (bw)f.a(i + this.G)) != null) {
        if (bw1.O > -1) {
          bw1.a(parambx, j + fl.aM / 2, k + fl.aM / 2, fl.aM, 0, 0);
        } else if (this.G < 12) {
          parambx.a(fl.aP[6], 0, i * 20, 20, 20, 0, j + fl.aM / 2, k + fl.aM / 2, 3);
        } 
      } else if (this.G < 12) {
        parambx.a(fl.aP[6], 0, i * 20, 20, 20, 0, j + fl.aM / 2, k + fl.aM / 2, 3);
      } 
      parambx.a(fl.bf[4]);
      parambx.b(j, k, this.F, this.F);
    } 
    parambx.a(fl.bf[3]);
    if (this.o >= 0) {
      i = this.p + this.o % this.l * this.F;
      j = this.q + this.o / this.l * this.F;
      parambx.b(i, j, this.F, this.F);
      parambx.a(fl.bf[2]);
      parambx.b(i + 1, j + 1, this.F - 2, this.F - 2);
    } 
    if (ft.A)
      if (this.G < 12) {
        this.B.a(parambx, this.i + bt.j / 2, this.q - bt.k / 2);
      } else {
        this.A.a(parambx, this.i + bt.j / 2, this.q - bt.k / 2);
      }  
    if (!ft.o.a && ft.r == null && fl.bi > fl.aX)
      this.C.b(parambx, false); 
    super.a(parambx);
  }
  
  public final void a() {
    if (ft.A)
      if (this.G < 12) {
        this.B.b();
      } else {
        this.A.b();
      }  
    if (b == null)
      this.r.a(); 
    this.c.a();
    if (this.C.aY != null)
      this.C.aY.c(); 
    if (this.H != null) {
      bw bw1 = this.H;
      fw fw1 = this;
      if (fl.bi < fl.aX + 2 && ++fl.bi == fl.aX) {
        bw bw2 = bw1;
        fw fw2;
        if ((fw2 = fw1).o < 0) {
          fl.bi = 0;
        } else {
          fw2.C.bj = null;
          fw2.C.bk = null;
          fw2.C.bl = null;
          int i = fw2.o;
          if (bw2 == null) {
            fl.bi = 0;
          } else if (bw2.b()) {
            fl.bi = 0;
          } else {
            fw2.C.bq = bw2.s;
            fw2.C.bs = fw2.p + i % fw2.l * fw2.F + fl.aM / 2 - fw2.C.bq / 2;
            if (fw2.C.bs < 0)
              fw2.C.bs = 0; 
            if (fw2.C.bs + fw2.C.bq > ft.W)
              fw2.C.bs = ft.W - fw2.C.bq; 
            fw2.a(bw2);
            fw2.C.bp = bw2.g;
            fw2.C.bl = bw2.l;
            fw2.C.bo = bw2.n;
            fw2.C.br = bw2.N;
            fw2.C.bu = bw2.J;
          } 
        } 
      } 
      if (fw1.C.bj == null && bw1 != null && bw1.u != 5)
        if (bw1.k == null) {
          if (bw1.o % 100 == 3) {
            if (fw1.C.K == 0)
              q.a().a((byte)0, (byte)bw1.O); 
            bw1.o++;
          } else {
            bw1.o++;
          } 
        } else {
          fw1.C.bu = bw1.J;
          fw1.C.bj = bw1.k;
          fw1.C.bm = bw1.m;
          fw1.a(bw1);
        }  
    } 
    if (this.C != null)
      this.C.a(); 
  }
  
  public final void d() {
    int i = this.o;
    if (this.C.aY != null) {
      if (ft.al[2]) {
        if (this.C.aY.e > 0) {
          this.C.aY.e -= ft.ab;
        } else {
          this.C.aY.e = 0;
        } 
        ft.d(2);
      } else if (ft.al[8]) {
        if (this.C.aY.e < this.C.aY.g) {
          this.C.aY.e += ft.ab;
        } else {
          this.C.aY.e = this.C.aY.g;
        } 
        ft.d(8);
      } 
    } else if (ft.al[2]) {
      if (this.o >= this.l)
        this.o -= this.l; 
      ft.d(2);
    } else if (ft.al[8]) {
      if (this.o < af.a - this.l)
        this.o += this.l; 
      ft.d(8);
    } 
    if (ft.al[4]) {
      this.o--;
      ft.d(4);
    } else if (ft.al[6]) {
      this.o++;
      ft.d(6);
    } 
    if (i != this.o) {
      if (this.o >= 0) {
        this.o = (byte)cg.a(this.o, af.a - 1, false);
        fl.bi = 0;
        this.H = (bw)f.a(this.o + this.G);
      } else {
        this.o = -1;
      } 
      this.C.aY = null;
    } 
    super.d();
  }
  
  private void a(bw parambw) {
    int i = 2;
    this.C.bj = parambw.k;
    this.C.bu = parambw.J;
    this.C.bm = parambw.m;
    if (parambw.k != null)
      i = 2 + parambw.k.length; 
    if (parambw.l != null)
      i += parambw.l.length; 
    int j = this.o;
    this.C.bt = this.q + (j / this.l + 1) * this.F;
    if (ft.A) {
      if (this.C.bt + i * ft.ab > ft.X)
        this.C.bt = ft.X - i * ft.ab; 
    } else if (this.C.bt + i * ft.ab > ft.X - bt.k) {
      this.C.bt = ft.X - bt.k - i * ft.ab;
    } 
    if (this.E == D && ft.A && this.C.bt + i * ft.ab > this.j + this.k)
      this.C.bt = this.j + this.k - i * ft.ab; 
    this.C.aY = null;
    if ((i + 1) * ft.ab > fl.U)
      this.C.aY = new bp(this.C.bs, this.C.bt, this.C.bq, fl.U, 0, 0, (i + 1) * ft.ab - fl.U); 
    if (parambw.E == 1) {
      this.C.bq += bt.j / 2;
      this.C.bc = this.z;
      return;
    } 
    this.C.bc = null;
    this.C.bg = 0;
    this.C.bh = 0;
  }
  
  public final void e() {
    if (this.C.aY != null && ft.c(this.C.aY.c, this.C.aY.d, this.C.aY.a, this.C.aY.b))
      this.C.aY.a(); 
    ft.S = false;
    byte b;
    if (ft.b(this.p, this.q, this.F * this.l, this.F * this.m) && (b = (byte)((ft.ae - this.p) / this.F + (ft.af - this.q) / this.F * this.l)) >= 0 && b < af.a && b != this.o) {
      this.o = b;
      fl.bi = 0;
      this.H = (bw)f.a(this.o + this.G);
      this.C.aY = null;
    } 
    if (ft.S && ft.c(this.i + this.k / 2 - 25, this.j + 90 - 60, 50, 70)) {
      this.s.a();
      ft.S = false;
    } 
    super.e();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fw.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */