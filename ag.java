public final class ag extends p {
  private static ag j;
  
  public es a = new es("List_server vecListServer");
  
  public static es b = new es("List_server vecMyFriend");
  
  public static boolean f = false;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n = 50;
  
  private int o = 0;
  
  private int p;
  
  private int q;
  
  private int r = 0;
  
  private int s = 0;
  
  private int t;
  
  private int u;
  
  private bt v;
  
  private bt w;
  
  private bt x;
  
  private bt y;
  
  private bt z;
  
  private bt A;
  
  private bt B;
  
  private bt C;
  
  private bt D;
  
  private bt E;
  
  private bt F;
  
  private bt G;
  
  private bt H;
  
  private bt I;
  
  private bt J;
  
  private bp K;
  
  public String g;
  
  public byte h;
  
  public byte i;
  
  private byte[] L;
  
  private byte M;
  
  public static ag b() {
    return (j == null) ? (j = new ag()) : j;
  }
  
  public ag() {
    (new int[2])[0] = 6;
    (new int[2])[1] = 20;
    (new int[5][])[0] = new int[2];
    (new int[2])[0] = 22;
    (new int[2])[1] = 18;
    (new int[5][])[1] = new int[2];
    (new int[2])[0] = 38;
    (new int[2])[1] = 20;
    (new int[5][])[2] = new int[2];
    (new int[2])[0] = 14;
    (new int[2])[1] = 8;
    (new int[5][])[3] = new int[2];
    (new int[2])[0] = 30;
    (new int[2])[1] = 8;
    (new int[5][])[4] = new int[2];
    this.L = new byte[] { 0, 1, 2, 1 };
    this.M = 0;
    this.y = new bt(df.Z, -1);
    this.v = new bt(df.bL, 1, this);
    this.w = new bt(df.X, 3, this);
    this.x = new bt(df.bK, 4, this);
    this.A = new bt(df.dk, 5, this);
    this.z = new bt(df.dl, 6, this);
    this.B = new bt(df.U, 0, this);
    this.C = new bt(df.U, 2, this);
    this.D = new bt(df.eM, 7, this);
    this.E = new bt(df.eS, 8, this);
    this.F = new bt(df.bK, 10, this);
    this.G = new bt(df.eG, 11, this);
    this.H = new bt(df.fa, 12, this);
    this.I = new bt(df.fe, 13, this);
    this.J = new bt(df.es, 14, this);
  }
  
  public final void g() {
    this.y.a = df.Z;
    this.v.a = df.bL;
    this.w.a = df.X;
    this.x.a = df.bK;
    this.A.a = df.dk;
    this.z.a = df.dl;
    this.B.a = df.U;
    this.C.a = df.U;
    this.D.a = df.eM;
    this.E.a = df.eS;
    this.F.a = df.bK;
    this.G.a = df.eG;
    this.H.a = df.fa;
    this.I.a = df.fe;
    this.J.a = df.es;
  }
  
  public final void c() {
    a(ft.a);
  }
  
  public final void a(byte paramByte) {
    this.i = paramByte;
    this.n = 50;
    if (this.i == 2)
      this.n = 70; 
    this.t = ft.W / 4 * 3;
    this.u = ft.X / 5 << 2;
    if (this.t < 160) {
      this.t = 160;
    } else if (this.t > 280) {
      this.t = 280;
    } 
    if (this.u < 210) {
      this.u = 210;
    } else if (this.u > 280) {
      this.u = 280;
    } 
    this.r = ft.Y - this.t / 2;
    this.s = ft.Z - this.u / 2;
    this.k = 0;
    this.o = (this.u - ft.aa) / this.n + 3;
    if (this.a.c() > 0) {
      i();
      p.e.a(0, this.a.c() * this.n - this.u + ft.aa + 10, 0, 0);
      this.K = new bp(this.r, this.s, this.t, this.u, this.n, 0, p.e.f);
      this.p = 0;
      this.q = this.o;
      if (this.q > this.a.c())
        this.q = this.a.c(); 
      j();
    } 
    if (ft.A)
      this.y.a(this.r + this.t - 12, this.s + 10, cf.t, ""); 
    this.Z = this.y;
  }
  
  public final void b(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case -1:
        if (this.c == ft.u) {
          this.c.a(this.c.c);
          break;
        } 
        this.c.c();
        break;
    } 
    super.b(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    ez ez2;
    em em;
    ez ez1;
    ez ez3;
    es es1;
    switch (paramInt1) {
      case 0:
        ez3 = (ez)b.a(this.k);
        q.a().a((byte)3, ez3.cB);
        b.b(this.k);
        if (this.k > 0)
          this.k--; 
        if (b.c() == 0) {
          this.Y = null;
          this.aa = null;
        } 
        ft.j();
        return;
      case 2:
        ft.c(df.bb, this.B);
        return;
      case 1:
        if ((ez2 = (ez)this.a.a(this.k)) != null && this.bD != -1) {
          ft.g.a(this.cB, "", "", (byte)0, true);
          ft.h();
          return;
        } 
        break;
      case 3:
        if (((ag)super).i == 1 || ((ag)super).i == 0 || ((ag)super).i == 6) {
          ez2 = this;
          es es2 = new es("List_server menu");
          if (((ag)super).i == 0) {
            es2.a(((ag)super).v);
            es2.a(((ag)super).C);
            es2.a(((ag)super).I);
          } 
          ez ez;
          if (((ag)super).i != 6 && ((ag)super).k >= 0 && ((ag)super).k < ((ag)super).a.c() && (ez = (ez)((ag)super).a.a(((ag)super).k)) != null && ez.cw == 1 && ez.bD != -1 && ez.cB.compareTo(cn.f.cB) != 0)
            es2.a(((ag)super).x); 
          if (((ag)super).i == 6 && (ez = (ez)((ag)super).a.a(((ag)super).k)) != null && ez.bD != -1 && ez.cB.compareTo(cn.f.cB) != 0) {
            es2.a(((ag)super).x);
            es2.a(((ag)super).J);
          } 
          if (((ag)super).h != 99) {
            if (((ag)super).h != 0) {
              ((ag)super).A.a = String.valueOf(df.dk) + ak.e(((ag)super).h);
              es2.a(((ag)super).A);
            } 
            if (((ag)super).h >= 0) {
              ((ag)super).z.a = String.valueOf(df.dl) + (((ag)super).h + 2);
              es2.a(((ag)super).z);
            } 
          } 
          ft.o.a(es2, 2, df.cF, false, (es)null);
          return;
        } 
        if (((ag)super).i == 5 || ((ag)super).i == 4) {
          if (((ag)(ez2 = this)).k >= 0 && ((ag)super).k < ((ag)super).a.c() && (ez3 = (ez)((ag)super).a.a(((ag)super).k)).cB.compareTo(cn.f.cB) != 0) {
            es1 = new es("List_server menu3");
            if (((ag)super).i == 4) {
              if (cn.f.cO.o >= 125) {
                es1.a(((ag)super).D);
                if (cn.f.cO.o >= 126)
                  es1.a(((ag)super).E); 
              } 
              es1.a(((ag)super).H);
            } 
            if (ez3 != null && ez3.cw == 1 && ez3.bD != -1 && ez3.cB.compareTo(cn.f.cB) != 0) {
              es1.a(((ag)super).x);
              es1.a(((ag)super).v);
            } 
            ft.o.a(es1, 2, df.cW, false, (es)null);
          } 
          return;
        } 
        if (((ag)super).i == 3) {
          em em1;
          if (((ag)(ez2 = this)).k >= 0 && ((ag)super).k < ((ag)super).a.c() && (em1 = (em)((ag)super).a.a(((ag)super).k)).k != -1) {
            (es1 = new es("List_server menu2")).a(((ag)super).F);
            es1.a(((ag)super).G);
            ft.o.a(es1, 2, df.eE, false, (es)null);
          } 
          return;
        } 
        break;
      case 4:
        if (((ag)super).k < 0 || ((ag)super).k >= ((ag)super).a.c())
          return; 
        if ((ez3 = (ez)((ag)super).a.a(((ag)super).k)) != null && ez3.bD != -1) {
          if (((ag)super).i == 6) {
            q.a().a(ez3.cB, fw.h);
            return;
          } 
          q.a().a(ez3.cB, (byte)0);
          return;
        } 
        break;
      case 5:
        q.a().e((byte)(ak.e(((ag)super).h) - 1));
        ft.a(df.aG, new bt(df.as, -1));
        return;
      case 6:
        q.a().e((byte)ak.e(((ag)super).h + 1));
        ft.a(df.aG, new bt(df.as, -1));
        return;
      case 7:
        if (((ag)(ez2 = this)).k >= 0 && ((ag)super).k < ((ag)super).a.c() && (ez3 = (ez)((ag)super).a.a(((ag)super).k)) != null) {
          es1 = new es("List_server menu4");
          if (cn.f.cO.o == Byte.MAX_VALUE)
            es1.a(new bt(df.gw[1], 9, 126, this)); 
          if (cn.f.cO.o >= 126)
            es1.a(new bt(df.gw[2], 9, 125, this)); 
          if (cn.f.cO.o >= 125) {
            es1.a(new bt(df.gw[3], 9, 124, this));
            es1.a(new bt(df.gw[4], 9, 123, this));
            es1.a(new bt(df.gw[5], 9, 122, this));
          } 
          ft.o.a(es1, 2, ez3.cB, false, (es)null);
        } 
        return;
      case 8:
        if ((ez2 = (ez)((ag)super).a.a(((ag)super).k)) != null) {
          q.a().f((byte)18, this.cB);
          return;
        } 
        break;
      case 9:
        if ((ez2 = (ez)((ag)super).a.a(((ag)super).k)) != null)
          q.a().a((byte)4, (byte)es1, this.cB); 
        ft.a(df.aG);
        return;
      case 10:
        if ((em = (em)((ag)super).a.a(((ag)super).k)) != null && this.k != -1) {
          q.a().b((byte)15, this.b);
          ft.a(df.aD, new bt(df.Z, -1));
          return;
        } 
        break;
      case 11:
        if ((em = (em)((ag)super).a.a(((ag)super).k)) != null && this.k != -1) {
          q.a().b((byte)13, this.b);
          ft.a(df.aD, new bt(df.Z, -1));
          return;
        } 
        break;
      case 12:
        if ((ez1 = (ez)((ag)super).a.a(((ag)super).k)) != null) {
          q.a().e((byte)14, this.cB);
          ft.a(df.aD, new bt(df.Z, -1));
          return;
        } 
        break;
      case 13:
        q.a().a((byte)4, "");
        ft.a(df.aG, new bt(df.as, -1));
        return;
      case 14:
        if (((ag)super).k < 0 || ((ag)super).k >= ((ag)super).a.c())
          return; 
        if ((ez1 = (ez)((ag)super).a.a(((ag)super).k)) != null && this.bD != -1)
          q.a().h((byte)0, this.cB); 
        break;
    } 
  }
  
  public final void a(bx parambx) {
    if (this.c != null)
      this.c.a(parambx); 
    if (ft.a != this)
      return; 
    ft.a(parambx);
    cg.a(parambx, this.r, this.s, this.t, this.u, this.g);
    parambx.a(this.r, this.s + ft.aa);
    parambx.d(3, 0, this.t, this.u - ft.aa);
    if (this.a == null)
      return; 
    if (this.a.c() > 0) {
      if (this.i == 3) {
        int i = 5;
        bx bx1 = parambx;
        ag ag1 = this;
        bx1.a(-6517641);
        bx1.c(3, -p.e.b + 5 + ag1.k * ag1.n + 1, ag1.t - 6, ag1.n - 1);
        bx1.a(0, -p.e.b);
        i = 5 + ag1.p * ag1.n;
        for (int j = ag1.p; j < ag1.q; j++) {
          em em;
          if ((em = (em)ag1.a.a(j)).k == -1) {
            o.f.a(bx1, em.c, 20, i + 5, 0, true);
            i += ag1.n;
          } else {
            fd fd;
            if ((fd = bk.i(em.a)).a != null)
              if (aq.b(fd.a.a) / 18 == 3) {
                if (ft.ai % 6 == 0) {
                  int k;
                  if ((k = ag1.L.length) == 0)
                    k = 1; 
                  ag1.M = (byte)((ag1.M + 1) % k);
                } 
                bx1.a(fd.a, 0, ag1.L[ag1.M] * 18, 18, 18, 0, 9, i + 11, 3);
              } else {
                bx1.a(fd.a, 9, i + 11, 3);
              }  
            if (cn.f.cO != null && cn.f.cO.c.compareTo(em.c) == 0) {
              cg.a(bx1, String.valueOf(em.c) + " - " + em.d, 20, i + 5, 0);
            } else {
              o.f.a(bx1, String.valueOf(em.c) + " - " + em.d, 20, i + 5, 0, true);
            } 
            o.j.a(bx1, em.e, 10, i + 20, 0, true);
            if (em.k < 4) {
              o.f.a(bx1, String.valueOf(df.dM) + " " + df.gv[em.k], 10, i + 35, 0, true);
            } else {
              o.j.a(bx1, String.valueOf(df.dM) + " " + (em.k + 1), 10, i + 35, 0, true);
            } 
            i += ag1.n;
            if (j < ag1.a.c() - 1) {
              bx1.a(cg.aL[4]);
              bx1.c(4, i, ag1.t - 8, 1);
            } 
          } 
        } 
      } else {
        a(parambx, 5);
      } 
    } else if (this.i == 0) {
      o.j.a(parambx, df.be, this.t / 2, 5, 2, true);
    } else {
      o.j.a(parambx, df.dm, this.t / 2, 5, 2, true);
    } 
    if (!ft.o.a && ft.r == null && ft.a == this && !d.b && ft.s == null)
      super.a(parambx); 
  }
  
  private void a(bx parambx, int paramInt) {
    parambx.a(-6517641);
    parambx.c(3, -p.e.b + 5 + this.k * this.n + 1, this.t - 6, this.n - 1);
    parambx.a(0, -p.e.b);
    paramInt = 5 + this.p * this.n;
    for (int i = this.p; i < this.q; i++) {
      if (i >= 0 && i < this.a.c()) {
        ez ez;
        if ((ez = (ez)this.a.a(i)).bD == -1) {
          ez.h(parambx, 50, paramInt + 5);
          paramInt += this.n;
          if (i < this.a.c() - 1) {
            parambx.a(cg.aL[4]);
            parambx.c(4, paramInt, this.t - 8, 1);
          } 
        } else {
          ez.b(parambx, 20, paramInt + 40, 0);
          int k = paramInt + 10;
          byte b1 = 40;
          byte b = ez.cw;
          bx bx1 = parambx;
          byte b2 = 0;
          if (b == 0)
            b2 = 2; 
          cf.s.b(b2, 40, k, 0, 3, bx1);
          if (ez.cB.compareTo(cn.f.cB) == 0) {
            String str = ez.c(" - ");
            b = 0;
            if (ez.cO != null) {
              b = 16;
              ez.a(parambx, 59, paramInt + 5 + 6, -1);
            } 
            cg.a(parambx, str, b + 50, paramInt + 5, 0, 0);
          } else {
            ez.h(parambx, 50, paramInt + 5);
          } 
          int j = 40;
          if (i == this.k) {
            parambx.d(35, p.e.b, this.t - 40, this.u - ft.aa);
            j = 40 - this.l;
          } 
          if (this.i == 6) {
            if (ez.bD < 4) {
              o.f.a(parambx, String.valueOf(df.dM) + " " + df.gv[ez.bD], j, paramInt + 35, 0, true);
            } else {
              o.j.a(parambx, String.valueOf(df.dM) + " " + (ez.bD + 1), j, paramInt + 35, 0, true);
            } 
            o.j.a(parambx, ez.cD, j, paramInt + 20, 0, true);
          } else {
            if (this.i == 4 || this.i == 5) {
              o.j.a(parambx, String.valueOf(df.ac) + ez.by, j, paramInt + 20, 0, true);
              o.j.a(parambx, em.a(ez.cO.o), j, paramInt + 35, 0, true);
            } else {
              o.j.a(parambx, ez.cD, j, paramInt + 20, 0, true);
            } 
            if (this.i == 1)
              if (ez.bD < 4) {
                o.f.a(parambx, String.valueOf(df.dM) + " " + df.gv[ez.bD], j, paramInt + 35, 0, true);
              } else {
                o.j.a(parambx, String.valueOf(df.dM) + " " + (ez.bD + 1), j, paramInt + 35, 0, true);
              }  
          } 
          if (i == this.k)
            parambx.d(5, p.e.b, this.t - 10, this.u - ft.aa); 
          paramInt += this.n;
          if (i < this.a.c() - 1) {
            parambx.a(cg.aL[4]);
            parambx.c(4, paramInt, this.t - 8, 1);
          } 
        } 
      } 
    } 
  }
  
  public final void a() {
    this.c.a();
    if (this.m > 0) {
      this.l += 2;
      if (this.l > this.m)
        this.l = 0; 
    } 
    if (this.a.c() > 0) {
      if (ft.A && this.K != null) {
        this.K.c();
      } else {
        p.e.a();
      } 
      if (p.e.b != p.e.d) {
        h();
        return;
      } 
    } else if (this.aa != null || this.Y != null) {
      this.aa = null;
      this.Y = null;
    } 
  }
  
  public final void d() {
    if (this.a.c() > 0) {
      int i = this.k;
      if (ft.al[2]) {
        this.k--;
        ft.d(2);
      } else if (ft.al[8]) {
        this.k++;
        ft.d(8);
      } 
      this.k = cg.a(this.k, this.a.c() - 1, false);
      if (i != this.k) {
        i();
        p.e.a(0, this.k * this.n - this.u / 2 + 40 + ft.aa);
      } 
    } 
    super.d();
  }
  
  public final void e() {
    if (this.a.c() > 0) {
      if (ft.b(this.r, this.s + ft.aa, this.t, this.u - ft.aa)) {
        int i;
        if ((i = (p.e.b + ft.af - this.s - ft.aa) / this.n) >= 0 && i < this.a.c()) {
          ft.S = false;
          if (i == this.k) {
            this.w.a();
          } else {
            this.k = i;
            i();
          } 
        } else {
          this.k = 0;
        } 
        ft.S = false;
      } 
      if (ft.A && this.K != null) {
        this.K.a();
        p.e.b = this.K.f;
      } 
    } 
    super.e();
  }
  
  public final void h() {
    this.p = p.e.b / this.n - 1;
    if (this.p < 0)
      this.p = 0; 
    this.q = this.p + this.o;
    if (this.q > this.a.c()) {
      this.q = this.a.c();
      this.p = this.q - this.o;
      if (this.p < 0)
        this.p = 0; 
    } 
  }
  
  public final void i() {
    if (this.a == null || this.k == -1 || this.k > this.a.c() - 1)
      return; 
    this.l = 0;
    String str = "";
    byte b = 40;
    if (this.i == 3) {
      em em;
      if ((em = (em)this.a.a(this.k)).k != -1)
        str = em.e; 
      b = 20;
    } else {
      ez ez;
      str = (ez = (ez)this.a.a(this.k)).cD;
    } 
    if (this.i == 2)
      b = 50; 
    this.m = o.i.a(str) - this.t - b + 5;
    if (this.m > 0)
      this.m += 25; 
  }
  
  public final void j() {
    if (this.a.c() > 0 && !ft.A) {
      this.Y = this.w;
      if (this.i == 0)
        this.aa = this.v; 
    } 
  }
  
  public final void k() {
    p.e.a(0, this.a.c() * this.n - this.u + ft.aa + 10, 0, 0);
    this.K = new bp(this.r, this.s, this.t, this.u, this.n, 0, p.e.f);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ag.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */