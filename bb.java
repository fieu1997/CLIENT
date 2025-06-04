public final class bb extends fl {
  private int c;
  
  private int d;
  
  private int e = 12;
  
  private int f = 6;
  
  private int g = 6;
  
  private int h = 0;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private static boolean m;
  
  private static boolean n;
  
  private boolean o;
  
  private boolean p;
  
  public static boolean a;
  
  private cp[] q;
  
  private cp[] r;
  
  private cp[] s;
  
  private cp t;
  
  private static bt u;
  
  private static bt v;
  
  private static bt w;
  
  private static bt x;
  
  private static bt y;
  
  private static es z = new es("TabLottery vecListCmd");
  
  private es A = new es("TabLottery vecEffEnd");
  
  private es B = new es("TabLottery vecRewardList");
  
  private int[] C = new int[] { -1, -1, -1, -1 };
  
  private cp D;
  
  private cp E;
  
  private cp F;
  
  private cp G;
  
  private float H;
  
  private float I;
  
  private float J;
  
  private static byte bv;
  
  private static byte bw;
  
  private int bx;
  
  private bp by;
  
  public static boolean b;
  
  public static void a(byte paramByte) {
    bv = 1;
    f();
  }
  
  public static void b(byte paramByte) {
    bw = paramByte;
  }
  
  private static void f() {
    if (ft.A) {
      z.d();
      if (bv == 0) {
        z.a(v);
        return;
      } 
      if (m) {
        z.a(w);
        z.a(x);
        return;
      } 
      if (!n)
        z.a(u); 
    } 
  }
  
  public bb(String paramString, es parames, byte paramByte) {
    this.X = paramString;
    m = false;
    n = false;
    this.o = false;
    a = false;
    this.p = true;
    b = false;
    this.i = 0;
    this.H = 0.0F;
    this.I = 1.0F;
    this.J = 1.0F;
    this.j = -1;
    this.k = -1;
    this.bx = -1;
    bw = -1;
    this.B = parames;
    bv = 0;
    this.K = 0;
    this.V = this.L + fl.aM + fl.aN * 3;
    this.W = 0 + ft.X / 5 + fl.aM;
    this.c = (fl.S - 8) / 32;
    this.d = (fl.T - 8) / 32;
    this.s = new cp[5];
    this.s[0] = new cp((this.V + fl.S / 2 - 52), (this.W + fl.T / 2 - 16));
    this.s[1] = new cp((this.V + fl.S / 2 - 32), (this.W + fl.T / 2 + 45));
    this.s[2] = new cp((this.V + fl.S / 2 + 32), (this.W + fl.T / 2 + 45));
    this.s[3] = new cp((this.V + fl.S / 2 + 52), (this.W + fl.T / 2 - 16));
    this.s[4] = new cp((this.V + fl.S / 2), (this.W + fl.T / 2 - 52));
    this.q = new cp[5];
    this.q[0] = new cp((this.V + fl.S / 2 - 52), (this.W + fl.T / 2 - 16));
    this.q[1] = new cp((this.V + fl.S / 2 - 32), (this.W + fl.T / 2 + 45));
    this.q[2] = new cp((this.V + fl.S / 2 + 32), (this.W + fl.T / 2 + 45));
    this.q[3] = new cp((this.V + fl.S / 2 + 52), (this.W + fl.T / 2 - 16));
    this.q[4] = new cp((this.V + fl.S / 2), (this.W + fl.T / 2 - 52));
    this.r = new cp[5];
    this.r[0] = new cp((this.V + fl.S / 2 - 52), (this.W + fl.T / 2 - 16));
    this.r[1] = new cp((this.V + fl.S / 2 - 32), (this.W + fl.T / 2 + 45));
    this.r[2] = new cp((this.V + fl.S / 2 + 32), (this.W + fl.T / 2 + 45));
    this.r[3] = new cp((this.V + fl.S / 2 + 52), (this.W + fl.T / 2 - 16));
    this.r[4] = new cp((this.V + fl.S / 2), (this.W + fl.T / 2 - 52));
    this.t = new cp((this.V + fl.S / 2), (this.W + fl.T / 2));
    u = new bt(df.fU, 0, this);
    v = new bt(df.Y, 1, this);
    w = new bt(df.fW, 2, this);
    x = new bt(df.fV, 4, this);
    y = new bt(df.Y, 3, this);
    this.aT = new bt(df.af, -1, this);
    if (ft.A)
      this.aT.a = df.Z; 
    if (fl.aU > 0) {
      int i = fl.aW + this.N;
      int j = fl.aV;
      if (fl.aZ) {
        u.a(j + fl.aU / 2, i - 10, cf.v, u.a);
        v.a(j + fl.aU / 2, i - 10, cf.v, v.a);
        w.a(j + fl.aU / 2 - 30, i - 10, cf.v, w.a);
        x.a(j + fl.aU / 2 + 30, i - 10, cf.v, x.a);
      } else {
        u.a(j + fl.aU / 2, i - 15, (ce)null, u.a);
        v.a(j + fl.aU / 2, i - 15, (ce)null, v.a);
        w.a(j + fl.aU / 2 - 42, i - 15, (ce)null, w.a);
        x.a(j + fl.aU / 2 + 42, i - 15, (ce)null, x.a);
      } 
    } else if (ft.A) {
      u.a(bt.j / 2 + 2, ft.X - bt.k / 2 - 2, (ce)null, u.a);
      v.a(bt.j / 2 + 2, ft.X - bt.k / 2 - 2, (ce)null, v.a);
      w.a(bt.j / 2 + 2 - 42, ft.X - bt.k / 2 - 2, (ce)null, w.a);
      x.a(bt.j / 2 + 2 + 42, ft.X - bt.k / 2 - 2, (ce)null, x.a);
    } 
    b();
  }
  
  public final void b() {
    this.by = new bp(this.V, this.W, fl.S, fl.T, 0, 0, p.e.f);
    f();
    if (!ft.A) {
      this.aa = v;
      this.Z = this.aT;
    } 
    this.A.d();
    this.ba = aq.a("/interface/rebuild.img");
  }
  
  public final void a(bx parambx) {
    if (bv == 0) {
      parambx = parambx;
      this = this;
      try {
        ft.a(parambx);
        parambx.d(this.V - fl.aN, this.W, fl.S + (fl.aN << 1), fl.T - fl.aN / 2 + 1);
        parambx.a(-p.e.a, -p.e.b);
        byte b;
        for (b = 0; b < this.B.c(); b++) {
          bw bw;
          if ((bw = (bw)this.B.a(b)) != null)
            if (bw.u == 7) {
              j j;
              if ((j = bw.b(bw.O)) != null) {
                bw.a(j.g, j.t, 7, j.q, j.Q, j.h, (short)j.P, j.A, j.x, j.y);
                bw.a(parambx, this.V + fl.aM / 2 + b % this.f * fl.aM, this.W + fl.aM / 2 + b / this.f * fl.aM, fl.aM, 0, 0);
                if (bw.p > 0)
                  parambx.a(cg.am, 0, 0, fl.aM - 1, fl.aM - 1, 0, this.V + fl.aM / 2 + b % this.f * fl.aM, this.W + fl.aM / 2 + b / this.f * fl.aM, 3); 
              } else {
                bw.c(bw.O);
              } 
            } else {
              bw.a(parambx, this.V + fl.aM / 2 + b % this.f * fl.aM, this.W + fl.aM / 2 + b / this.f * fl.aM, fl.aM, 0, 0);
              if (bw.p > 0)
                parambx.a(cg.am, 0, 0, fl.aM - 1, fl.aM - 1, 0, this.V + fl.aM / 2 + b % this.f * fl.aM, this.W + fl.aM / 2 + b / this.f * fl.aM, 3); 
            }  
        } 
        parambx.a(fl.bf[1]);
        parambx.b(this.V, this.W, fl.S, fl.aM * this.g);
        for (b = 0; b < this.f / 2; b++)
          parambx.b(this.V + fl.aM + (b * fl.aM << 1), this.W, fl.aM, fl.aM * this.g); 
        for (b = 0; b < this.g / 2; b++)
          parambx.b(this.V, this.W + fl.aM + (b * fl.aM << 1), fl.S, fl.aM); 
        if (this.l > -1 && fl.aO == 1) {
          parambx.a(fl.bf[2]);
          parambx.b(this.V + this.l % this.f * fl.aM + 1, this.W + this.l / this.f * fl.aM + 1, fl.aM - 2, fl.aM - 2);
          parambx.a(fl.bf[3]);
          parambx.b(this.V + this.l % this.f * fl.aM, this.W + this.l / this.f * fl.aM, fl.aM, fl.aM);
        } 
        if (!ft.o.a && ft.r == null && ft.s == null && fl.aO == 1 && fl.bi > fl.aX) {
          a(parambx, false);
          if (z != null) {
            for (b = 0; b < z.c(); b++) {
              bt bt1;
              (bt1 = (bt)z.a(b)).a(parambx, bt1.h, bt1.i);
            } 
          } else {
            return;
          } 
        } else {
          return;
        } 
      } catch (Exception exception) {
        return;
      } 
    } else if (bv == 1) {
      parambx = parambx;
      this = this;
      try {
        parambx.c(this.V + 2, this.W + 2, fl.S - 4, fl.T - 4);
        if (ft.B) {
          fl.c(parambx, this.V + 4, this.W + 4, fl.S - 8, fl.T - 8, 4);
        } else {
          bx bx1 = parambx;
          bb bb1 = this;
          for (byte b1 = 0; b1 <= bb1.c; b1++) {
            for (byte b2 = 0; b2 <= bb1.d; b2++) {
              bb1.e = 12;
              if (b2 == 0)
                bb1.e = 12; 
              if (b1 == bb1.c) {
                if (b2 == bb1.d) {
                  bx1.a(fl.aP[bb1.e], bb1.V + 4 + fl.S - 8 - 32, bb1.W + 4 + fl.T - 8 - 32, 0);
                } else {
                  bx1.a(fl.aP[bb1.e], bb1.V + 4 + fl.S - 8 - 32, bb1.W + 4 + (b2 << 5), 0);
                } 
              } else if (b2 == bb1.d) {
                bx1.a(fl.aP[bb1.e], bb1.V + 4 + (b1 << 5), bb1.W + 4 + fl.T - 8 - 32, 0);
              } else {
                bx1.a(fl.aP[bb1.e], bb1.V + 4 + (b1 << 5), bb1.W + 4 + (b2 << 5), 0);
              } 
            } 
          } 
        } 
        parambx.a(this.ba, this.V + fl.S / 2 - 54, this.W + fl.T / 2 - 52, 0);
        parambx.a(this.ba, 0, 0, 54, 105, 2, this.V + fl.S / 2, this.W + fl.T / 2 - 52, 0);
        bw bw = (bw)this.B.a(this.l);
        if (!a && bw != null) {
          parambx.a(cg.ap, (int)this.t.a, (int)this.t.b, 3);
          bw.a(parambx, (int)this.t.a, (int)this.t.b, 20, 0, 0);
        } 
        byte b;
        for (b = 0; b < this.r.length; b++) {
          if (this.bx == -1) {
            parambx.a(cg.au, (int)(this.r[b]).a, (int)(this.r[b]).b, 3);
          } else if (b) {
            if (bw == b) {
              parambx.a(cg.ap, (int)(this.s[b]).a, (int)(this.s[b]).b, 3);
              bw.a(parambx, (int)(this.s[b]).a, (int)(this.s[b]).b, 20, 0, 0);
            } else {
              parambx.a(cg.au, (int)(this.s[b]).a, (int)(this.s[b]).b, 3);
            } 
          } else if (bw == b) {
            parambx.a(cg.ap, (int)(this.s[b]).a, (int)(this.s[b]).b, 3);
            bw.a(parambx, (int)(this.s[b]).a, (int)(this.s[b]).b, 20, 0, 0);
          } else if (this.bx != b) {
            parambx.a(cg.au, (int)(this.s[b]).a, (int)(this.s[b]).b, 3);
          } else {
            continue;
          } 
          if (!ft.A && this.o && this.k > -1) {
            if (ez.ch == 0) {
              ez.ch = aq.a(ez.da.a);
              ez.ci = aq.b(ez.da.a) / 10;
            } 
            parambx.a(ez.da, 0, 0, ez.ch, ez.ci, 0, (int)(this.s[this.k]).a, (int)(this.s[this.k]).b - ft.ai % 5 - 10, 3);
          } 
          continue;
        } 
        for (b = 0; b < this.A.c(); b++) {
          dx dx;
          (dx = (dx)this.A.a(b)).a(parambx);
        } 
        if (!ft.o.a && ft.r == null && ft.s == null && (fl.aO == 1 || fl.aU > 0) && z != null) {
          for (b = 0; b < z.c(); b++) {
            bt bt1;
            (bt1 = (bt)z.a(b)).a(parambx, bt1.h, bt1.i);
          } 
          return;
        } 
      } catch (Exception exception2) {
        Exception exception1;
        (exception1 = null).printStackTrace();
      } 
    } 
  }
  
  public final void a() {
    try {
      if (bv == 0) {
        if (fl.aO == 1) {
          if (this.aY != null)
            this.aY.c(); 
          if (ft.A) {
            this.by.c();
          } else {
            p.e.a();
          } 
          es es1;
          if ((es1 = this.B).c() == 0) {
            fl.aO = 0;
            return;
          } 
          int i = this.l;
          es1 = es1;
          this = this;
          if (fl.bi < fl.aX + 2 && ++fl.bi == fl.aX) {
            bb bb1;
            es es2 = (bb1 = this).B;
            bb1.bj = null;
            bb1.bk = null;
            bb1.bl = null;
            if (bb1.l >= es2.c() || bb1.l < 0) {
              if (bb1.l > es2.c() - 1)
                bb1.l = es2.c() - 1; 
              fl.bi = 0;
            } else {
              bw bw1;
              if ((bw1 = (bw)es2.a(bb1.l)).b()) {
                fl.bi = 0;
              } else {
                if (bw1.u == 9) {
                  ah.i = (ea)bw1;
                  bb1.R = true;
                } else {
                  bb1.R = false;
                } 
                bb1.bp = bw1.g;
                bb1.br = bw1.N;
                if (bw1.u == 3 || bb1.K == 8) {
                  bb1.bl = bw1.l;
                  bb1.bo = bw1.n;
                } 
                bb1.aY = null;
                if (fl.aU > 0) {
                  int j = 1;
                  bb1.bj = bw1.k;
                  bb1.bm = bw1.m;
                  if (bw1.k != null)
                    j = 1 + bb1.bj.length; 
                  if (bw1.l != null)
                    j += bw1.l.length; 
                  if (j * ft.ab > fl.U) {
                    bb1.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, j * ft.ab - fl.U);
                  } else if (ft.A) {
                    bb1.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, 0);
                  } 
                } else {
                  bb1.bq = bw1.s;
                  bb1.a(bw1);
                  if (bb1.l % bb1.f < 2) {
                    bb1.bs = bb1.V + fl.aM / 2 + bb1.l % bb1.f * fl.aM;
                  } else if (bb1.l % bb1.f < 5) {
                    bb1.bs = bb1.V + fl.aM / 2 + bb1.l % bb1.f * fl.aM - bb1.bq / 2;
                  } else {
                    bb1.bs = bb1.V + fl.aM / 2 + bb1.l % bb1.f * fl.aM - bb1.bq;
                  } 
                } 
              } 
            } 
          } 
          bw bw;
          if (this.bj == null && i >= 0 && i < es1.c() && (bw = (bw)es1.a(i)).u != 5) {
            if (bw.k == null) {
              if (bw.o % 100 == 3) {
                if (this.K == 0)
                  q.a().a((byte)0, (byte)bw.O); 
                bw.o++;
              } else {
                bw.o++;
              } 
            } else {
              this.bj = bw.k;
              this.bm = bw.m;
              a(bw);
              return;
            } 
          } else {
            return;
          } 
        } else {
          fl.bi = 0;
          return;
        } 
      } else if (bv == 1) {
        int i;
        for (i = 0; i < this.A.c(); i++) {
          dx dx;
          (dx = (dx)this.A.a(i)).a();
          if (dx.y)
            this.A.d(dx); 
        } 
        if (this.j > -1) {
          cx cx = new cx(34, (int)(this.s[this.j]).a, (int)(this.s[this.j]).b);
          this.A.a(cx);
          q.a().d((byte)2, (byte)this.j);
          this.bx = this.j;
          this.j = -1;
          this.o = false;
          m = true;
          f();
        } 
        if (!a) {
          cp cp1;
          (cp1 = cp.a(this.t, this.q[bw])).a();
          this.J += 0.5F;
          this.t.a(cp1.a * this.J, cp1.b * this.J);
          if (a(this.t, this.q[bw])) {
            bw = -1;
            a = true;
          } 
        } 
        if (this.i >= 30)
          n = false; 
        if (n) {
          ft.S = false;
          if (this.p) {
            i = 0;
            byte b = 0;
            if (this.i > 16)
              i = ak.c(0, 2); 
            if (i == 0) {
              b = 2;
            } else {
              b = 4;
            } 
            i = 0;
            while (i < b) {
              boolean bool = false;
              int j = ak.c(0, 5);
              for (byte b1 = 0; b1 < this.C.length; b1++) {
                if (j == this.C[b1])
                  bool = true; 
              } 
              if (!bool) {
                this.C[i] = j;
                i++;
              } 
            } 
            this.D = cp.a(this.r[this.C[0]], this.r[this.C[1]]);
            this.E = cp.a(this.r[this.C[1]], this.r[this.C[0]]);
            this.D.a();
            this.E.a();
            if (this.C[2] > -1 && this.C[3] > -1) {
              this.F = cp.a(this.r[this.C[2]], this.r[this.C[3]]);
              this.G = cp.a(this.r[this.C[3]], this.r[this.C[2]]);
              this.F.a();
              this.G.a();
            } 
            this.p = false;
            this.H = ((this.i < 16) ? this.i : 16);
            return;
          } 
          if (this.H < 16.0F)
            this.H += this.I; 
          this.r[this.C[0]].a(this.D.a * this.H, this.D.b * this.H);
          this.r[this.C[1]].a(this.E.a * this.H, this.E.b * this.H);
          if (this.C[2] > -1 && this.C[3] > -1) {
            this.r[this.C[2]].a(this.F.a * this.H, this.F.b * this.H);
            this.r[this.C[3]].a(this.G.a * this.H, this.G.b * this.H);
          } 
          if (a(this.r[this.C[0]], this.q[this.C[1]])) {
            this.r[this.C[0]].a(this.q[this.C[1]]);
            this.r[this.C[1]].a(this.q[this.C[0]]);
            this.q[this.C[0]].a(this.r[this.C[0]]);
            this.q[this.C[1]].a(this.r[this.C[1]]);
            if (this.C[2] > -1 && this.C[3] > -1) {
              this.r[this.C[2]].a(this.q[this.C[3]]);
              this.r[this.C[3]].a(this.q[this.C[2]]);
              this.q[this.C[2]].a(this.r[this.C[2]]);
              this.q[this.C[3]].a(this.r[this.C[3]]);
            } 
            if (this.i == 29) {
              this.o = true;
              this.k = 0;
              if (!ft.A)
                this.aa = y; 
            } 
            this.p = true;
            this.i++;
            for (i = 0; i < this.C.length; i++)
              this.C[i] = -1; 
            return;
          } 
        } 
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  private void a(bw parambw) {
    int i = 0;
    if (p.e.b > 0)
      i = p.e.b / fl.aM; 
    int j = 1;
    this.bj = parambw.k;
    this.bm = parambw.m;
    if (parambw.k != null)
      j = 1 + this.bj.length; 
    if (parambw.l != null)
      j += parambw.l.length; 
    if (this.l / this.f < i + 0) {
      this.bt = this.W + (this.l / this.f + 1) * fl.aM + 2;
      if (this.bt - p.e.b + (j + 1) * ft.ab > ft.X - ft.aa - 5)
        this.bt = ft.X - ft.aa - 5 - (j + 1) * ft.ab - p.e.b; 
    } else {
      this.bt = this.W + this.l / this.f * fl.aM - 7 - j * ft.ab - p.e.b;
      if (this.bt - p.e.b < 6)
        this.bt = 6 + p.e.b; 
    } 
    if ((j + 1) * ft.ab > fl.U)
      this.aY = new bp(this.bs, this.bt, this.bq, fl.U, 0, 0, (j + 1) * ft.ab - fl.U); 
  }
  
  public final void c() {
    fl.aO = 0;
    super.c();
  }
  
  private static boolean a(cp paramcp1, cp paramcp2) {
    paramcp2 = paramcp2;
    paramcp1 = paramcp1;
    float f2 = paramcp2.a - paramcp1.a;
    float f1 = paramcp2.b - paramcp1.b;
    return ((f1 = ak.a(f2 * f2 + f1 * f1)) < 20.0F);
  }
  
  public final void d() {
    es es1 = this.B;
    if (fl.aO == 1) {
      int i = this.l;
      boolean bool = false;
      if (bv == 1) {
        if (this.o)
          if (ft.al[4]) {
            this.k--;
            if (this.k < 0)
              this.k = 4; 
            ft.d(4);
          } else if (ft.al[6]) {
            this.k++;
            if (this.k > 4)
              this.k = 0; 
            ft.d(6);
          }  
      } else {
        if (this.aY != null) {
          if (ft.al[2]) {
            if (this.aY.e > 0) {
              this.aY.e -= ft.ab;
            } else {
              this.aY.e = 0;
            } 
            ft.d(2);
          } else if (ft.al[8]) {
            if (this.aY.e < this.aY.g) {
              this.aY.e += ft.ab;
            } else {
              this.aY.e = this.aY.g;
            } 
            ft.d(8);
          } 
        } else if (ft.al[2]) {
          this.l -= this.f;
          ft.d(2);
          bool = true;
        } else if (ft.al[8]) {
          this.l += this.f;
          ft.d(8);
          bool = true;
        } 
        if (ft.al[4]) {
          if (this.l % this.f == 0) {
            fl.aO = 0;
          } else {
            this.l--;
          } 
          ft.d(4);
          bool = true;
        } else if (ft.al[6]) {
          this.l++;
          ft.d(6);
          bool = true;
        } 
        if (bool) {
          this.aY = null;
          this.l = cg.a(this.l, es1.c() - 1, false);
          eu.f = 10;
        } 
        if (i != this.l) {
          p.e.a(0, (this.l / this.f - 1) * fl.aM);
          fl.bi = 0;
        } 
      } 
    } 
    super.d();
  }
  
  public final void e() {
    if (bv == 1) {
      int i = aq.a(cg.au.a);
      int j = aq.b(cg.au.a);
      if (this.o)
        for (byte b = 0; b < this.q.length; b++) {
          if (ft.b((int)(this.s[b]).a - i / 2, (int)(this.s[b]).b - j / 2, i, j)) {
            this.j = b;
            ft.S = false;
            break;
          } 
        }  
    } else if (bv == 0) {
      boolean bool = false;
      if (this.aY != null && ft.c(this.aY.c, this.aY.d, this.aY.a, this.aY.b)) {
        this.aY.a();
        bool = true;
      } 
      if (ft.A && !bool) {
        this.by.a();
        p.e.b = this.by.f;
      } 
      if (ft.b(this.V, this.W, this.f * fl.aM, fl.T - fl.aN / 2) && !bool) {
        int i;
        if ((i = (ft.ae - this.V) / fl.aM + (ft.af - this.W + p.e.b) / fl.aM * this.f) >= 0 && i < this.B.c()) {
          ft.S = false;
          fl.bi = 0;
          this.l = i;
          if (fl.aO != 1)
            fl.aO = 1; 
        } else {
          fl.bi = 0;
          this.l = -1;
        } 
      } 
    } 
    if (z != null && !ft.o.a && ft.r == null && ft.s == null && (fl.aO == 1 || fl.aU > 0))
      for (byte b = 0; b < z.c(); b++) {
        bt bt1;
        (bt1 = (bt)z.a(b)).b();
      }  
    super.e();
  }
  
  public final void b(int paramInt1, int paramInt2) {
    super.b(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case -1:
        if (m) {
          ft.c.c();
          break;
        } 
        c();
        break;
      case 0:
        if (n || this.o)
          return; 
        n = true;
        this.i = 0;
        this.H = 0.0F;
        if (!ft.A) {
          this.aa = null;
          this.Z = null;
          this.Y = null;
        } 
        f();
        break;
      case 1:
        if (!m) {
          q.a().d((byte)1, (byte)this.l);
          if (!ft.A) {
            this.aa = u;
            this.Z = null;
            this.Y = null;
          } 
        } 
        break;
      case 2:
        q.a().d((byte)0, (byte)0);
        break;
      case 3:
        this.j = this.k;
        if (!ft.A) {
          this.aa = x;
          this.Y = w;
          this.aT.a = df.Z;
          this.Z = this.aT;
        } 
        break;
      case 4:
        q.a().d((byte)1, (byte)this.l);
        if (!ft.A) {
          this.aa = u;
          this.Z = null;
          this.Y = null;
        } 
        m = false;
        n = false;
        this.o = false;
        this.p = true;
        b = false;
        this.i = 0;
        this.j = -1;
        this.k = -1;
        this.bx = -1;
        bw = -1;
        this.J = 1.0F;
        this.t = new cp((this.V + fl.S / 2), (this.W + fl.T / 2));
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bb.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */