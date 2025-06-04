public final class bg extends fl {
  private es e = new es("TabConfig vecConfig");
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private bt j;
  
  private bt k;
  
  private bt l;
  
  private bt m;
  
  private bt n;
  
  private bt o;
  
  private bt p;
  
  private bt q;
  
  private bt r;
  
  private bt s;
  
  public static bt a;
  
  public static bt b;
  
  public static bt c;
  
  public static bt d;
  
  private e t;
  
  private dy u;
  
  private String v = "";
  
  public bg(String paramString, es parames, byte paramByte) {
    this.K = paramByte;
    this.X = paramString;
    this.e = parames;
    this.V = this.L + fl.aM + fl.aN * 3;
    this.W = 0 + ft.X / 5 + fl.aM;
    this.f = fl.S / 2;
    this.g = fl.S - (fl.aN << 1);
    if (this.g > 130)
      this.g = 130; 
    this.i = ft.aa;
    if (ft.A)
      this.i = 28; 
    this.aT = new bt(df.af, -1, this);
    this.j = new bt(df.Y, 0, this);
    this.k = new bt(df.cG, 4, this);
    b = new bt(df.cR, 7, this);
    this.l = new bt(df.bT, 10, this);
    this.m = new bt(df.cI, 11, this);
    a = new bt(df.eo, 13, this);
    c = new bt(df.eE, 14, this);
    this.n = new bt(df.ff, 15, this);
    this.o = new bt(df.fq, 16, this);
    this.p = new bt(String.valueOf(df.dI) + " " + df.bP, 19, this);
    d = new bt((new StringBuffer(String.valueOf(df.gg))).toString(), 37, this);
    this.q = new bt(df.u, 40, this);
    this.r = new bt(df.d, 45, this);
    this.s = new bt(df.b, 46, this);
    b();
  }
  
  public final void b() {
    es es1 = new es("TabConfig mcmdTest");
    if (ft.A) {
      if (cn.p.a >= 0)
        es1.a((cn.b()).D); 
      es1.a(this.l);
      if (cn.f.cO != null)
        es1.a(c); 
      if (bq.N != null)
        es1.a((cn.b()).x); 
      es1.a(this.o);
      if (cn.f.ee != -1)
        es1.a(d); 
    } else if (this.K == 7) {
      String str = String.valueOf(df.cw) + " " + df.cu;
      if (cn.f.cv != 0)
        str = String.valueOf(df.cv) + " " + df.cu; 
      (cn.b()).C.a = str;
      es1.a((cn.b()).B);
      es1.a((cn.b()).C);
      es1.a(this.m);
      if (cn.p.a >= 0)
        es1.a((cn.b()).D); 
      es1.a(this.l);
      if (cn.f.by >= 10)
        es1.a(this.p); 
      es1.a(this.k);
    } else if (this.K == 11) {
      es1.a((cn.b()).A);
      a.a = df.eo;
      if (cf.i > 0)
        a.a = String.valueOf(df.eo) + "*"; 
      es1.a(a);
      if (cn.f.cO != null)
        es1.a(c); 
      if (bq.N != null)
        es1.a((cn.b()).x); 
      es1.a((cn.b()).z);
      es1.a(this.n);
      es1.a(this.o);
      if (cn.f.ee != -1)
        es1.a(d); 
    } 
    es1.a(this.q);
    es1.a(this.r);
    es1.a(this.s);
    this.e = es1;
    int i;
    if ((i = this.e.c() * this.i - fl.T) < 0)
      i = 0; 
    this.h = 0;
    if (!ft.A) {
      this.Z = this.aT;
      this.Y = this.j;
    } else {
      this.h = -1;
    } 
    this.t = new e(this.V, this.W, fl.S, fl.T, this.i, this.e.c(), i, this.h, this.e);
    p.e.a(0, i, 0, 0);
    super.b();
  }
  
  public final void c() {
    fl.aO = 0;
    this.h = 0;
    super.c();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    bt bt1;
    bt bt2;
    es es1;
    bt bt3;
    switch (paramInt1) {
      case -1:
        c();
        return;
      case 0:
        if (this.h > -1 && (bt2 = (bt)this.e.a(this.h)) != null && bt2.c == null) {
          if (bt2.d != null) {
            bt2.d.a(bt2.e, bt2.f);
            return;
          } 
          ft.a.a_(bt2.e, bt2.f);
          return;
        } 
        break;
      case 4:
        cn.f.N();
        l.a().c();
        ft.b.c();
        cn.f = new bq(0, (byte)0, "unname", 0, 0);
        bv.b = 0L;
        bv.c = false;
        bv.a = false;
        ah.k = false;
        return;
      case 6:
        k.a();
        return;
      case 7:
        cf.I = !cf.I;
        co.c();
        if (cf.I) {
          b.a = String.valueOf(df.cR) + df.cS;
        } else {
          b.a = String.valueOf(df.cR) + df.cT;
        } 
        ft.S = false;
        cf.h();
        return;
      case 9:
        q.a().c((byte)paramInt2);
        return;
      case 10:
        ft.b(df.do, df.bT);
        return;
      case 11:
        cn.b().j();
        return;
      case 13:
        ft.h.g();
        ft.h.a(ft.a);
        return;
      case 14:
        if (cn.f.cO != null) {
          q.a().b((byte)15, cn.f.cO.b);
          ft.a(df.aD, new bt(df.Z, -1));
          return;
        } 
        break;
      case 15:
        az.b().c();
        return;
      case 16:
        this.u = new dy();
        this.u.a(df.fh, new bt(df.au, 17, this), false, df.fq);
        ft.r = this.u;
        return;
      case 17:
        this.v = this.u.a.j();
        if (this.v != null && this.v.length() > 0) {
          ft.c(String.valueOf(df.fg) + " (" + df.fj + fn.B + " " + df.bP + ")" + df.fp + "\n" + this.v, new bt(df.au, 18, this));
          return;
        } 
        break;
      case 18:
        q.a().b(this.v);
        ft.j();
        return;
      case 19:
        q.a().g((byte)-56);
        ft.a(df.aG);
        return;
      case 20:
        return;
      case 36:
        ft.f();
        return;
      case 37:
        (es1 = new es("TabConfig vec3")).a(new bt(df.ga, 38, this));
        es1.a(new bt(df.as, 39, this));
        ft.a(df.gh, es1);
        return;
      case 38:
        q.a().h((byte)-1);
        f();
        return;
      case 39:
        f();
        return;
      case 40:
        if (!dw.g) {
          if (!cn.aM) {
            es1 = new es();
            bt bt5 = new bt(df.ga, 41, this);
            bt1 = new bt(df.gb, 42, this);
            es1.a(bt5);
            es1.a(this);
            ft.a(df.p, es1);
            return;
          } 
          es1 = new es();
          bt bt4 = new bt(df.ga, 43, (cg)this);
          bt1 = new bt(df.gb, 42, (cg)this);
          es1.a(bt4);
          es1.a(this);
          ft.a(df.o, es1);
          return;
        } 
        if (!cn.aM && !cn.aN) {
          es1 = new es();
          bt bt4 = new bt(df.l, 41, (cg)this);
          bt1 = new bt(df.m, 44, (cg)this);
          es1.a(bt4);
          es1.a(this);
          ft.o.a(es1, 2, df.u, false, (es)null);
          return;
        } 
        es1 = new es();
        bt3 = new bt(df.ga, 43, (cg)this);
        bt1 = new bt(df.gb, 42, (cg)this);
        es1.a(bt3);
        es1.a(this);
        ft.a(df.o, es1);
        return;
      case 41:
        cn.aM = true;
        ((bg)super).q.a = df.n;
        ft.j();
        return;
      case 42:
        ft.j();
        return;
      case 43:
        cn.aM = false;
        cn.aN = false;
        ((bg)super).q.a = df.u;
        ft.j();
        return;
      case 44:
        cn.aN = true;
        ((bg)super).q.a = df.n;
        ft.j();
        return;
      case 45:
        q.a().d((byte)5, (byte)0);
        return;
      case 46:
        if (ez.cg == 0) {
          ez.cg = 1;
          ((bg)super).s.a = df.c;
          return;
        } 
        ez.cg = 0;
        ((bg)super).s.a = df.b;
        break;
    } 
  }
  
  private static void f() {
    if (ft.r != null) {
      ft.r = null;
      return;
    } 
    ft.s = null;
  }
  
  public final void a(bx parambx) {
    parambx.d(this.V, this.W, fl.S, fl.T);
    parambx.a(0, -this.t.b);
    if (fl.aO == 1 && this.h > -1) {
      bx bx1 = parambx;
      bg bg1 = this;
      bx1.a(fl.bf[5]);
      bx1.c(bg1.V + bg1.f - bg1.g / 2 - 1, bg1.W + bg1.h * bg1.i + bg1.i / 2 - 11, bg1.g + 2, 22);
      if (ft.B) {
        fl.c(bx1, bg1.V + bg1.f - bg1.g / 2, bg1.W + bg1.h * bg1.i + bg1.i / 2 - 10, bg1.g, 20, 4);
      } else {
        for (byte b1 = 0; b1 <= bg1.g / 24; b1++) {
          int i = bg1.V + bg1.f - bg1.g / 2 + b1 * 24;
          if (b1 == bg1.g / 24)
            i = bg1.V + bg1.f + bg1.g / 2 - 24; 
          bx1.a(fl.aP[8], 0, 0, 24, 20, 0, i, bg1.W + bg1.h * bg1.i + bg1.i / 2 - 10, 0);
        } 
      } 
    } 
    for (byte b = 0; b < this.e.c(); b++) {
      bt bt1 = (bt)this.e.a(b);
      o.f.a(parambx, bt1.a, this.V + this.f, this.W + this.i / 2 + b * this.i - 6, 2, true);
      if (b < this.e.c() - 1) {
        parambx.a(fl.bf[4]);
        parambx.c(this.V + 8, this.W + (b + 1) * this.i - 1, fl.S - 16, 1);
      } 
    } 
  }
  
  public final void a() {
    p.e.a();
    if (fl.aO == 1) {
      if (ft.o.a || ft.r != null || ft.s != null || ft.a != ft.u)
        return; 
      this.t.a();
      this.h = this.t.a;
      if (this.h >= this.e.c()) {
        this.h = -1;
        this.t.a = -1;
      } 
    } 
  }
  
  public final void d() {
    if (fl.aO == 1 && (ft.al[4] || ft.al[6])) {
      fl.aO = 0;
      this.h = 0;
      ft.d(4);
      ft.d(6);
    } 
    super.d();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bg.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */