public final class af extends fl {
  private int f;
  
  private int g;
  
  public static int a = 12;
  
  private int h;
  
  private int i;
  
  public static int b = 0;
  
  private byte j;
  
  private int k;
  
  private int l;
  
  public static cz[] c;
  
  public static cz[] d;
  
  private int[] m;
  
  private es n = new es("TabMySeftNew vecItemMenu");
  
  public static String[] e = new String[5];
  
  private boolean o = false;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private boolean u = false;
  
  private es v = new es("vec List cmd");
  
  private byte w;
  
  private bt x;
  
  private bt y;
  
  private bt z;
  
  private bt A;
  
  private bt B;
  
  private bt C;
  
  private bt D;
  
  private bp E;
  
  private int F = fl.aM;
  
  public af(String paramString) {
    this.K = 1;
    if (ft.C)
      b = 10; 
    this.V = this.L + fl.aM + fl.aN * 3;
    this.W = 0 + ft.X / 5 + fl.aM;
    this.h = fl.T / 12;
    this.i = fl.S / 5;
    this.f = fl.S / fl.aM;
    if (this.f > 6)
      this.f = 6; 
    this.k = this.V + fl.S / 2 - this.f * fl.aM / 2 + (ft.C ? 0 : (this.f / 2));
    this.l = this.W + this.h * 10 - fl.aM;
    this.g = a / this.f;
    this.X = paramString;
    if (paramString == null || paramString.length() == 0)
      this.X = "Name Tab"; 
    this.z = new bt(df.Z, -2, this);
    this.aT = new bt(df.af, -1, this);
    if (ft.A)
      this.aT.a = df.Z; 
    this.x = new bt(df.az, 0, this);
    this.y = new bt(df.aA, 1, this);
    this.A = new bt(df.fI, 3, this);
    this.B = new bt(df.r, 4, this);
    this.C = new bt(df.q, 5, this);
    this.D = new bt(df.a, 6, this);
    if (!ft.A)
      this.Y = this.B; 
    this.w = 0;
  }
  
  public final void b() {
    if (ft.A) {
      this.j = -1;
    } else {
      this.j = 0;
    } 
    this.o = false;
    this.aY = null;
    if (!ft.A) {
      this.Z = this.aT;
      this.aa = this.x;
    } 
    fl.bi = 0;
    super.b();
  }
  
  public final void c() {
    fl.aO = 0;
    if (ft.A) {
      this.j = -1;
    } else {
      this.j = 0;
    } 
    super.c();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    bw bw;
    es es1;
    int i;
    fn fn;
    if (this.j == -1 && paramInt1 != -1)
      return; 
    switch (paramInt1) {
      case -1:
        c();
        break;
      case 0:
        "Command pointer tab myself index = " + paramInt1;
        i = fo.k[this.j + this.w];
        if ((bw = (bw)bw.U.a(this.j + this.w)) == null) {
          if (i == -2)
            return; 
          if (i == -1)
            if (cn.f.bx == 2) {
              i = 11;
            } else if (cn.f.bx == 3) {
              i = 10;
            } else {
              i = 8 + cn.f.bx;
            }  
        } else {
          i = bw.R;
        } 
        if (i == 14) {
          if (bw != null)
            ft.a((ea)bw, (byte)1); 
          return;
        } 
        c(i);
        if (this.n != null && this.n.c() > 0) {
          eu.f = 10;
          this.p = this.n.c();
          if (this.p > this.f)
            this.p = this.f; 
          int j = this.k + this.j % this.f * this.F - this.p * this.F / 2 + fl.aM / 2;
          i = this.l + this.j / this.f * this.F + fl.aM + fl.aN;
          if (j < this.V + (fl.aN << 1)) {
            j = this.V + (fl.aN << 1);
          } else if (j + this.p * this.F + fl.aN > this.V + fl.S - fl.aN) {
            j = this.V + fl.S - fl.aN - this.p * this.F + fl.aN;
          } 
          if (i + fl.aM + (fl.aN << 1) > ft.X - ft.aa / 2)
            i = ft.X - ft.aa / 2 - fl.aM - (fl.aN << 1); 
          this.r = j;
          this.s = i;
          j = 0;
          j = 0;
          j = 0;
          i = (this.n.c() - this.p) * this.F;
          aw aw;
          (aw = p.e).e = i;
          aw.f = 0;
          if (aw.f < 0)
            aw.f = 0; 
          if (aw.e < 0)
            aw.e = 0; 
          aw.c = 0;
          aw.d = 0;
          this.E = new bp(this.r, this.s, this.p * this.F, this.F, 0, 0, (this.n.c() - this.p) * this.F);
          this.o = true;
          c = null;
          d = null;
          if (!ft.A) {
            this.aa = this.y;
            if (!ft.A) {
              this.Z = this.z;
            } else {
              this.Z = null;
            } 
          } 
          fl.bi = 0;
          break;
        } 
        if (!ft.A) {
          this.Z = this.aT;
          this.aa = this.x;
        } 
        this.o = false;
        ft.a(df.aL);
        break;
      case 1:
        if ((bw = (bw)this.n.a(this.q)).b())
          return; 
        q.a().b((byte)bw.O, this.j);
        fl.bi = 0;
        eu.f = 10;
        if (!ft.A) {
          this.Z = this.aT;
          this.aa = this.x;
        } 
        this.o = false;
        this.n.d();
        this.q = 0;
        break;
      case -2:
        fl.bi = 0;
        eu.f = 10;
        if (!ft.A) {
          this.Z = this.aT;
          this.aa = this.x;
        } 
        this.o = false;
        this.n.d();
        this.q = 0;
        break;
      case 2:
        if ((bw = (bw)bw.U.a(this.j)) != null && bw.u == 9)
          ft.a((ea)bw, (byte)1); 
        break;
      case 3:
        if ((bw = (bw)bw.U.a(this.j)) != null && bw.u == 9)
          ft.a((ea)bw, (byte)1); 
        es1 = new es("TabMySeftNew vecItemMenu");
        (fn = new fn(bw.V, (byte)0, df.fI, -1, fn.j)).D = ah.i;
        es1.a(fn);
        (ft.w = new eu()).a = 0;
        ft.w.a(es1);
        ft.w.a(ft.a);
        break;
      case 4:
        this.w = 12;
        if (ft.A) {
          this.v = a((bw)null);
          b(this.v);
        } 
        if (!ft.A || (dw.g && ft.A))
          this.Y = this.C; 
        break;
      case 5:
        this.w = 0;
        if (ft.A) {
          this.v = a((bw)null);
          b(this.v);
        } 
        if (!ft.A || (dw.g && ft.A))
          this.Y = this.B; 
        break;
      case 6:
        this.w = 24;
        if (ft.A) {
          this.v = a((bw)null);
          b(this.v);
        } 
        if (!ft.A || (dw.g && ft.A))
          this.Y = this.C; 
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  public final void a(bx parambx) {
    cn.f.b(parambx, this.V + this.i + b / 2, this.W + this.h * 5 / 2 + 15, 0);
    parambx.a(fl.bf[1]);
    if (!ft.C) {
      parambx.c(this.V + this.i / 4, this.W + this.h * 6 - this.h / 2, (this.i << 1) - this.i / 2 + b, 1);
      parambx.c(this.V + (this.i << 1) + b + this.i / 4, this.W + this.h * 6 - this.h / 2, (this.i << 1) + b + this.i / 2, 1);
    } 
    parambx.c(this.V + (this.i << 1) + b, this.W + this.h / 4, 1, (this.h << 3) - this.h / 2);
    o.l.a(parambx, cn.f.cA, this.V + 15, this.W + this.h * 6 - this.h / 2 + 4 - (ft.C ? 8 : 0), 0, false);
    o.l.a(parambx, bq.e, this.V + 15, this.W + this.h * 6 - this.h / 2 + ft.ab + 4 - (ft.C ? 12 : 0), 0, false);
    parambx.a(fl.aR, this.V + 4, this.W + this.h * 6 - this.h / 2 + 4 - (ft.C ? 8 : 0), 0);
    parambx.a(fl.aQ, this.V + 4, this.W + this.h * 6 - this.h / 2 + ft.ab + 4 - (ft.C ? 12 : 0), 0);
    if (!ft.C)
      for (byte b = 0; b < 5; b++) {
        parambx.a(fl.aP[5], 0, b * 10, 10, 10, 0, this.V + (this.i << 1) + b + 10 + b % 3 * this.i + 3, this.W + this.h * 6 - this.h / 2 + 9 + b / 3 * this.h, 10);
        String str = "";
        if (this.o) {
          if (d != null)
            str = (new StringBuffer(String.valueOf(e[b]))).toString(); 
        } else {
          str = cn.f.K[b];
        } 
        o.j.a(parambx, str, this.V + (this.i << 1) + b + 14 + b % 3 * this.i, this.W + this.h * 6 - this.h / 2 + 3 + b / 3 * this.h, 0, false);
      }  
    bx bx1 = parambx;
    af af1 = this;
    if (!ft.C) {
      bx1.a(fl.aS, 0, 0, 10, 9, 0, af1.V + (af1.i << 1) + b + 10 + 2 * af1.i + 3, af1.W + af1.h * 6 - af1.h / 2 + 9 + 1 * af1.h, 10);
      o.l.a(bx1, bq.i, af1.V + (af1.i << 1) + b + 14 + 2 * af1.i, af1.W + af1.h * 6 - af1.h / 2 + 3 + 1 * af1.h, 0, false);
    } else {
      o.l.a(bx1, bq.i, af1.V + 15, af1.W + af1.h * 6 - af1.h / 2 + 2 * ft.ab + 3 - (ft.C ? 16 : 0), 0, false);
      bx1.a(fl.aS, af1.V + 4, af1.W + af1.h * 6 - af1.h / 2 + 2 * ft.ab + 4 - (ft.C ? 16 : 0), 0);
    } 
    parambx.a(fl.bf[4]);
    int i;
    for (i = 0; i < a; i = (byte)(i + 1)) {
      int j = this.k + i % this.f * this.F;
      int k = this.l + i / this.f * this.F;
      bw bw;
      if ((bw = (bw)bw.U.a(i + this.w)) != null) {
        if (bw.O > -1) {
          bw.a(parambx, j + fl.aM / 2, k + fl.aM / 2, fl.aM, 0, 0);
        } else if (this.w <= 0) {
          parambx.a(fl.aP[6], 0, i * 20, 20, 20, 0, j + fl.aM / 2, k + fl.aM / 2, 3);
        } 
      } else if (this.w <= 0) {
        parambx.a(fl.aP[6], 0, i * 20, 20, 20, 0, j + fl.aM / 2, k + fl.aM / 2, 3);
      } 
      parambx.a(fl.bf[4]);
      parambx.b(j, k, this.F, this.F);
    } 
    parambx.a(fl.bf[3]);
    if (fl.aO == 1 && this.j >= 0) {
      i = this.k + this.j % this.f * this.F;
      int j = this.l + this.j / this.f * this.F;
      parambx.b(i, j, this.F, this.F);
      parambx.a(fl.bf[2]);
      parambx.b(i + 1, j + 1, this.F - 2, this.F - 2);
    } 
    if (this.o) {
      if (d != null) {
        a(parambx, this.V + (this.i << 1) + 4 + b, this.W + 4, d, this.u);
      } else {
        o.j.a(parambx, df.aD, this.V + (this.i << 1) + 4 + b, this.W + 4, 0, false);
      } 
    } else {
      a(parambx, this.V + (this.i << 1) + 4 + b, this.W + 4, cn.f.L, true);
    } 
    if (fl.aO == 1) {
      if ((fl.bi > fl.aX || (this.o && fl.bi > 5)) && !ft.o.a && ft.r == null)
        a(parambx, (fl.aU > 0) ? false : this.o); 
      if (this.o)
        b(parambx); 
    } 
    if (this.v != null)
      for (i = 0; i < this.v.c(); i++) {
        bt bt1;
        (bt1 = (bt)this.v.a(i)).a(parambx, bt1.h, bt1.i);
      }  
  }
  
  private void b(bx parambx) {
    int i = this.n.c();
    int j;
    if ((j = fl.aM + (fl.aN << 1)) < 32)
      j = 32; 
    cg.a(parambx, this.r - this.p / 2 - fl.aN, this.s - fl.aN, this.p * fl.aM + (fl.aN << 1), j, 12);
    parambx.d(this.r + ((i == 1) ? 1 : 0), this.s, this.p * this.F + 2, fl.aM + (fl.aN << 1));
    parambx.a(-p.e.a, 0);
    for (j = 0; j < i; j++) {
      bw bw;
      (bw = (bw)this.n.a(j)).a(parambx, this.r + j * this.F + fl.aM / 2 + ((i == 1) ? 1 : 0), this.s + fl.aM / 2, fl.aM, 0, 0);
    } 
    if (i > 0) {
      parambx.a(fl.bf[2]);
      parambx.b(this.r + this.q * this.F + ((i == 1) ? 1 : 0), this.s + 1, this.F, this.F);
    } 
    ft.a(parambx);
  }
  
  private static void a(bx parambx, int paramInt1, int paramInt2, cz[] paramArrayOfcz, boolean paramBoolean) {
    if (paramArrayOfcz != null)
      for (byte b = 0; b < paramArrayOfcz.length; b++) {
        cz cz1;
        if ((cz1 = paramArrayOfcz[b]) != null && (cz1.a <= 4 || cz1.a == 40 || cz1.a == 14) && cz1.b != 0) {
          o o = null;
          if (!paramBoolean) {
            o = o.i;
          } else {
            o = fl.a(bw.e[cz1.a]);
          } 
          String str = String.valueOf(bw.d[cz1.a]) + ": " + bw.a(bw.f[cz1.a], cz1.b);
          o.a(parambx, str, paramInt1, paramInt2, 0, false);
          int i = 0;
          if (cn.f.df != null && !ft.C)
            for (byte b1 = 0; b1 < cn.f.df.c(); b1++) {
              ei ei;
              if ((ei = (ei)cn.f.df.a(b1)).l != null)
                for (byte b2 = 0; b2 < ei.l.length; b2++) {
                  if (cz1.a == (ei.l[b2]).a)
                    i += (ei.l[b2]).b; 
                }  
            }  
          if (i != 0) {
            String str1 = null;
            o o1 = o.o;
            if (i > 0) {
              str1 = " +" + bw.a(bw.f[cz1.a], i);
            } else {
              str1 = " " + bw.a(bw.f[cz1.a], i);
              o1 = o.m;
            } 
            int j = o.j.a(str);
            o1.a(parambx, " " + str1, paramInt1 + j, paramInt2, 0, false);
          } 
          paramInt2 += ft.ab;
        } 
      }  
  }
  
  public final void a() {
    if (fl.aO == 1) {
      if (this.aY != null)
        this.aY.c(); 
      if (this.o)
        if (ft.A) {
          this.E.c();
        } else {
          p.e.a();
        }  
      if ((this = this).j != -1)
        if (fl.bi < fl.aX + 2) {
          fl.bi++;
          if (this.o) {
            if (fl.bi == 5)
              f(); 
          } else if (fl.bi == fl.aX) {
            f();
          } 
        } else if (this.o && !this.u) {
          if (c == null) {
            this.t++;
            j j;
            if (this.t % 100 == 3 && (j = (j)this.n.a(this.q)) != null)
              q.a().a(this.j, (byte)j.O); 
          } else {
            this.m = new int[c.length];
            for (byte b = 0; b < c.length; b++) {
              cz cz1 = c[b];
              this.m[b] = 0;
              for (byte b1 = 0; b1 < cn.f.L.length; b1++) {
                cz cz2 = cn.f.L[b];
                if (cz1.a == cz2.a) {
                  if (cz1.b > cz2.b) {
                    this.m[b] = 2;
                    break;
                  } 
                  if (cz1.b < cz2.b)
                    this.m[b] = 3; 
                  break;
                } 
              } 
            } 
            this.u = true;
          } 
        }  
    } else {
      fl.bi = 0;
    } 
    cn.f.K();
  }
  
  public final void d() {
    if (fl.aO == 1)
      if (this.o) {
        if (this.aY != null)
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
        int i = this.q;
        if (ft.al[4]) {
          this.q--;
          ft.d(4);
        } else if (ft.al[6]) {
          this.q++;
          ft.d(6);
        } 
        this.q = cg.a(this.q, this.n.c() - 1, true);
        if (i != this.q) {
          p.e.a(this.q * this.F - this.p * this.F / 2, 0);
          fl.bi = 0;
        } 
      } else {
        byte b = this.j;
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
          if (this.j >= this.f)
            this.j = (byte)(this.j - this.f); 
          ft.d(2);
        } else if (ft.al[8]) {
          if (this.j < a - this.f)
            this.j = (byte)(this.j + this.f); 
          ft.d(8);
        } 
        if (ft.al[4]) {
          if (this.j % this.f == 0) {
            fl.aO = 0;
          } else {
            this.j = (byte)(this.j - 1);
          } 
          ft.d(4);
        } else if (ft.al[6]) {
          this.j = (byte)(this.j + 1);
          ft.d(6);
        } 
        if (this.j >= 0) {
          this.j = (byte)cg.a(this.j, a - 1, false);
        } else {
          this.j = -1;
          this.v = null;
        } 
        if (b != this.j) {
          fl.bi = 0;
          this.aY = null;
        } 
      }  
    super.d();
  }
  
  private void f() {
    if (this.j == -1 && !this.o)
      return; 
    bw bw = null;
    if (this.o) {
      bw = (bw)this.n.a(this.q);
    } else {
      bw = (bw)bw.U.a(this.j + this.w);
    } 
    if (bw == null) {
      fl.bi = 0;
      return;
    } 
    if (bw.b()) {
      fl.bi = 0;
      return;
    } 
    if (bw.u == 9) {
      ah.i = (ea)bw;
      this.R = true;
    } else {
      this.R = false;
    } 
    int i = 0;
    this.bj = bw.k;
    this.bu = bw.J;
    this.bl = bw.l;
    this.bo = bw.n;
    this.bm = bw.m;
    this.bp = bw.g;
    this.br = bw.N;
    if (this.o) {
      c = null;
      this.t = 0;
      this.u = false;
      int j;
      if ((j = o.f.a(bw.g) + 8) < 40)
        j = 40; 
      this.bq = j;
    } 
    this.aY = null;
    if (fl.aU > 0) {
      if (this.bj == null) {
        i++;
      } else {
        i = 0 + this.bj.length;
      } 
      if (this.bl != null)
        i += this.bl.length; 
      if (i * ft.ab > fl.U) {
        this.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, i * ft.ab - fl.U + 4 * ft.ab);
        return;
      } 
      if (ft.A)
        this.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, 4 * ft.ab); 
      return;
    } 
    if (this.bj == null) {
      i++;
    } else {
      i = 0 + this.bj.length;
    } 
    if (this.bl != null)
      i += this.bl.length; 
    if (this.o) {
      this.bt = this.s - (ft.ab << 1) + fl.aN / 2;
      this.bk = null;
      this.bj = null;
      this.bl = null;
      this.bs = this.r + this.p * fl.aM / 2 - this.bq / 2;
    } else {
      this.bt = this.l + this.j / this.f * fl.aM - 9 - (i + 1) * ft.ab;
      this.bq = bw.s;
      if (this.j % this.f < 2) {
        this.bs = this.k + fl.aM / 2 + this.j % this.f * fl.aM;
      } else if (this.j % this.f < 4) {
        this.bs = this.k + fl.aM / 2 + this.j % this.f * fl.aM - 45;
      } else {
        this.bs = this.k + fl.aM / 2 + this.j % this.f * fl.aM - 90;
      } 
    } 
    if (this.bt + p.e.b < 2)
      this.bt = 2 - p.e.b; 
    if ((i + 1) * ft.ab > fl.U)
      this.aY = new bp(this.bs, this.bt, this.bq, fl.U, 0, 0, (i + 1) * ft.ab - fl.U); 
  }
  
  private void c(int paramInt) {
    this.n.d();
    for (byte b = 0; b < bw.V.c(); b++) {
      bw bw;
      if ((bw = (bw)bw.V.a(b)).u == 3 && bw.R == paramInt && (bw.M == cn.f.bx || bw.M > 3))
        this.n.a(bw); 
    } 
  }
  
  public final void e() {
    byte b = 0;
    if (this.o) {
      if (this.aY != null && ft.c(this.aY.c, this.aY.d, this.aY.a, this.aY.b)) {
        this.aY.a();
        b = 1;
      } 
      if (ft.A && !b) {
        this.E.b();
        p.e.a = this.E.f;
      } 
      if (ft.S && !b)
        if (ft.c(this.r, this.s, this.F * this.p, fl.aM)) {
          if ((b = (byte)((p.e.a + ft.ae - this.r) / this.F)) >= 0 && b < this.n.c()) {
            if (b == this.q) {
              this.y.a();
            } else {
              this.q = b;
              fl.bi = 0;
            } 
            this.aY = null;
          } 
          ft.S = false;
        } else if (!ft.c(0, ft.X - ft.aa, ft.W, ft.aa)) {
          this.z.a();
          ft.S = false;
        }  
    } else {
      if (this.aY != null && ft.c(this.aY.c, this.aY.d, this.aY.a, this.aY.b)) {
        this.aY.a();
        b = 1;
      } 
      ft.S = false;
      if (ft.b(this.k, this.l, this.F * this.f, this.F * this.g) && b == 0 && (b = (byte)((ft.ae - this.k) / this.F + (ft.af - this.l) / this.F * this.f)) >= 0 && b < a) {
        if (b == this.j) {
          this.x.a();
        } else {
          this.j = b;
          fl.bi = 0;
          if (this.j >= 0) {
            bw bw;
            if ((bw = (bw)bw.U.a(this.j + this.w)) != null) {
              if (fl.aU > 0) {
                this.v = a(bw);
                b(this.v);
              } 
            } else if (this.w > 0) {
              this.v = a(bw);
              b(this.v);
            } 
          } 
        } 
        this.aY = null;
        if (fl.aO != 1)
          fl.aO = 1; 
      } 
    } 
    if (this.v != null)
      for (b = 0; b < this.v.c(); b++) {
        bt bt1;
        if ((bt1 = (bt)this.v.a(b)) != null)
          bt1.b(); 
      }  
    super.e();
  }
  
  private es a(bw parambw) {
    es es1 = new es("TabMySeftNew menu");
    if (this.w <= 0) {
      es1.a(this.B);
      es1.a(this.D);
    } else if (this.w > 0) {
      es1.a(this.C);
    } 
    if (parambw != null && parambw.R == 14)
      es1.a(this.A); 
    return es1;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\af.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */