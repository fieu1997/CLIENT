public final class x extends p {
  private int i = 50;
  
  private int j;
  
  public static es a = new es("PaintInfoGameScr VecSelectChar");
  
  private int[][] k = dw.a(3, 2);
  
  private boolean l = false;
  
  private boolean m = false;
  
  public static int b = -1;
  
  public static boolean f = false;
  
  public static boolean g = false;
  
  public static boolean h = false;
  
  private bt n;
  
  private byte[] o = new byte[] { 0, 1, 2, 1 };
  
  private byte p = 0;
  
  private bm q = null;
  
  private int r = 0;
  
  public x() {
    this = this;
    if (!ft.A)
      this.aa = new bt(df.Y, 0); 
    this.n = new bt(df.bR, 1);
    if (ft.A)
      this.n.a(cf.q.a / 2, ft.X - cf.q.b / 2, cf.q, this.n.a); 
    this.Y = this.n;
  }
  
  public final void c() {
    this.r = 0;
    this.q = null;
    this.l = false;
    this.m = false;
    bq.k = false;
    cn.i.d();
    super.c();
    f = false;
    ft.z.a();
    cf.a(dw.a[ft.H][0]);
    ft.N = 0L;
  }
  
  public final void b(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 0:
        g();
        break;
      case 1:
        ft.b.c();
        l.a().c();
        cn.f = new bq(0, (byte)0, "unname", 0, 0);
        break;
    } 
    super.b(paramInt1, paramInt2);
  }
  
  public final void b() {
    this.n.a = df.bR;
  }
  
  public final void a(bx parambx) {
    gb.a(parambx);
    if (bs.l != null)
      parambx.a(bs.l, ft.Y, ft.Z - 60, 3); 
    gb.c(parambx);
    cf.a(parambx, dw.a[ft.H][0]);
    gb.d(parambx);
    gb.b(parambx);
    for (byte b = 0; b < 3; b++) {
      if (b < a.c()) {
        bm bm1;
        (bm1 = (bm)a.a(b)).c(parambx, -1);
        o.c.a(parambx, String.valueOf(df.ac) + bm1.by, bm1.aY, bm1.aZ - bm1.be - 10, 2, false);
        a(parambx, bm1.cB, bm1.aY, bm1.aZ - bm1.be, b, bm1.cO);
      } else {
        a(parambx, df.aj, this.k[b][0], this.k[b][1], b, null);
      } 
    } 
    super.a(parambx);
    if (g) {
      parambx.a(0);
      parambx.c(0, 0, ft.W, ft.X);
      if (bs.l != null) {
        parambx.a(bs.l, ft.Y, ft.Z - 16, 3);
        parambx.a(cg.an, 0, ft.ai % 12 << 4, 16, 16, 0, ft.Y, ft.Z + aq.b(bs.l.a) / 2 - 9, 3);
      } 
    } 
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
  }
  
  public final void a() {
    cn.q.d();
    if (bs.j < 20 && (bs.j += 4) > 20)
      bs.j = 20; 
    if (this.r > 0) {
      this.r++;
      if (this.r == 18) {
        this.q.ba = 0;
        this.q.cF = 1;
      } 
    } 
    if (!ft.A)
      if (this.j > a.c() - 1) {
        this.aa.a = df.ab;
      } else {
        this.aa.a = df.Y;
      }  
    if (ah.k) {
      x x1 = this;
      bm bm1 = (bm)a.a(x1.j);
      co.b = true;
      b = bm1.ct;
      q.a().a((byte)0, b);
      eg.g = false;
      ft.d.c();
      x1.m = true;
      cn.p.a = -1;
      q.a().a((byte)1, (byte)2, (byte[])null);
      q.a().a((byte)1, (byte)1, (byte[])null);
      g = false;
      ah.k = false;
    } 
    for (byte b = 0; b < a.c(); b++) {
      bm bm1;
      if ((bm1 = (bm)a.a(b)).cF == 2) {
        bm1.dg.a(bm1);
      } else if (bm1.cF == 1) {
        bm1.ba++;
        if (bm1.ba > bm1.cf.length - 1)
          bm1.ba = 0; 
        bm1.ce = bm1.cf[bm1.ba];
        if (this.l && !this.m) {
          bm bm2 = (bm)a.a(this.j);
          co.b = true;
          b = bm2.ct;
          q.a().a((byte)0, b);
          eg.g = false;
          ft.d.c();
          this.m = true;
          cn.p.a = -1;
          q.a().a((byte)1, (byte)2, (byte[])null);
          q.a().a((byte)1, (byte)1, (byte[])null);
          g = false;
          bv.b = 0L;
          bv.c = false;
          bv.a = false;
          ah.k = false;
        } 
        bm1.aZ += bm1.bc;
      } else {
        bm1.J();
      } 
      bm1.K();
    } 
    gb.b();
    if (g && h) {
      g();
      h = false;
    } 
  }
  
  public final void d() {
    if (g)
      return; 
    if (!this.l) {
      if (ft.al[4]) {
        this.j--;
        ft.m();
      } else if (ft.al[6]) {
        this.j++;
        ft.m();
      } 
      this.j = cg.a(this.j, 2, true);
      super.d();
    } 
  }
  
  public final void a(es parames) {
    a.d();
    a = parames;
    for (byte b = 0; b < 3; b++) {
      int i = ft.Y - 80 + b * 80;
      int j = ft.X - 60 - b % 2 * 25;
      if (b < a.c()) {
        bm bm1 = (bm)a.a(b);
        int k = ft.Y - 80 + b * 80;
        int m = ft.X - 60 - b % 2 * 25;
        bm1.aY = k;
        bm1.aZ = m;
      } 
      this.k[b][0] = i;
      this.k[b][1] = j;
    } 
  }
  
  private void a(bx parambx, String paramString, int paramInt1, int paramInt2, int paramInt3, em paramem) {
    o.c.a(parambx, paramString, paramInt1 - 1, paramInt2 - 25, 2, false);
    o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 - 25, 2, false);
    o.c.a(parambx, paramString, paramInt1 - 1, paramInt2 - 24, 2, false);
    o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 - 24, 2, false);
    o.c.a(parambx, paramString, paramInt1 - 1, paramInt2 - 23, 2, false);
    o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 - 23, 2, false);
    o.c.a(parambx, paramString, paramInt1, paramInt2 - 25, 2, false);
    o.c.a(parambx, paramString, paramInt1, paramInt2 - 23, 2, false);
    o.f.a(parambx, paramString, paramInt1, paramInt2 - 24, 2, false);
    fd fd;
    if (paramem != null && (fd = bk.i(paramem.a)).a != null) {
      int i = (o.f.a(paramem.c) + 11) / 2;
      if (fd.a != null) {
        if (aq.b(fd.a.a) / 18 == 3) {
          if (ft.ai % 6 == 0) {
            int j;
            if ((j = this.o.length) == 0)
              j = 1; 
            this.p = (byte)((this.p + 1) % j);
          } 
          parambx.a(fd.a, 0, this.o[this.p] * 18, 18, 18, 0, paramInt1 - i + 6, paramInt2 - 32, 3);
        } else {
          parambx.a(fd.a, paramInt1 - i + 6, paramInt2 - 32, 3);
        } 
        bw.r.a(paramInt1 - i + 6, paramInt2 - 32 - 1, paramem.a(), 14, parambx, 0);
      } 
      o.f.a(parambx, paramem.c, paramInt1 - i + 15, paramInt2 - 32 - 6, 0, false);
      paramInt2 -= 18;
    } 
    if (paramInt3 == this.j && !this.l && !ft.A)
      parambx.a(cg.ak, paramInt1, paramInt2 - 35 + ft.ai % 5, 3); 
  }
  
  public final void e() {
    if (g)
      return; 
    if (ft.S && !this.l)
      for (byte b = 0; b < this.k.length; b++) {
        if (ft.c(this.k[b][0] - 5, this.k[b][1] - 65, 50, 90)) {
          this.j = b;
          g();
          this.j = cg.a(this.j, 2, true);
          ft.S = false;
          break;
        } 
      }  
    super.e();
  }
  
  private void g() {
    if (this.j > a.c() - 1) {
      (ft.j = new ep()).a((byte)this.j);
      return;
    } 
    this.l = true;
    this.r = 1;
    this.q = (bm)a.a(this.j);
    this.q.cF = 2;
    this.q.ba = 0;
    this.q.t();
    this.q.dg.a((this.q.bx == 3) ? 16 : 1);
    this.q.cG = 0;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\x.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */