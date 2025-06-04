public final class eu extends p {
  public int a = 0;
  
  public es b = new es("TabScreenNew VecTabScreen");
  
  private static bt i;
  
  public static int f = 0;
  
  public static int g;
  
  public static int h;
  
  public eu() {
    i = new bt(df.Z, 0, this);
    g = ft.W - 20;
    h = 17;
    if (ft.A)
      i.a(g, h, cf.t, ""); 
  }
  
  public static void b() {
    if (!ft.A)
      i.a = df.Z; 
  }
  
  public final void c() {}
  
  public final void a(p paramp) {
    f = 10;
    if (cn.p.d(6, 2))
      this.a = 2; 
    if (ft.A) {
      fl.aO = 1;
      fl fl;
      (fl = g()).b();
      fl.bi = 0;
      this.Z = i;
    } else {
      fl.aO = 0;
    } 
    super.c();
    ft.a.c = paramp;
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 0:
        if (this.c == null || this.c == ft.a || ft.a == ft.u) {
          ft.c.c();
        } else {
          this.c.a(this.c.c);
        } 
        if (cn.p.d(4, 9)) {
          cn.p.f();
          cn.p.g();
        } 
        break;
    } 
  }
  
  public final void a(es parames) {
    this.b.d();
    this.b = parames;
  }
  
  public final void a(bx parambx) {
    fl fl = g();
    ft.a(parambx);
    fl.g().a(parambx, fl.X, this.a, this.b, false);
    fl.a(parambx);
    ft.a(parambx);
    if (!ft.o.a && ft.r == null && ft.s == null && ft.a == this) {
      if (ft.A) {
        c(parambx);
      } else if (fl.aO == 0) {
        d(parambx);
      } else {
        fl.d(parambx);
      } 
    } else {
      f = 10;
    } 
    if (cn.p.a >= 0 && !ft.o.a && ft.r == null && ft.s == null && fl.K != 0)
      cn.p.a(parambx, null, fl.K); 
  }
  
  public final void a() {
    if (this.c == ft.c)
      this.c.a(); 
    fl fl = g();
    if (!ft.o.a && ft.r == null && ft.a == this)
      fl.a(); 
    if (ft.o.a || ft.r != null) {
      f = 10;
      return;
    } 
    if (f > 0)
      f--; 
  }
  
  private fl g() {
    return (fl)this.b.a(this.a);
  }
  
  public final void d() {
    if (ft.o.a || ft.r != null || ft.s != null)
      return; 
    if (fl.aO == 0) {
      f = 10;
      this.Y = null;
      this.aa = null;
      this.Z = i;
      int i = this.a;
      if (ft.al[2]) {
        this.a--;
        ft.m();
        if (c.H) {
          c.n = null;
          c.m = null;
          c.o = null;
          c.H = false;
        } 
      } else if (ft.al[8]) {
        this.a++;
        ft.m();
        if (c.H) {
          c.n = null;
          c.m = null;
          c.o = null;
          c.H = false;
        } 
      } else if (ft.al[4] || ft.al[6]) {
        ft.m();
        ft.l();
        h();
      } 
      this.a = cg.a(this.a, this.b.c() - 1, true);
      if (i != this.a)
        p.e.b = 0; 
      fl fl1;
      if ((fl1 = g()).K == 7 || fl1.K == 11)
        fl1.b(); 
      if (cn.p.d(3, 8)) {
        if (fl1.K == 1) {
          fl1.b();
          cn.p.f();
          cn.p.g();
        } 
      } else if (cn.p.d(7, 9)) {
        if (fl1.K == 3) {
          fl1.b();
          cn.p.f();
          cn.p.g();
        } 
      } else if (cn.p.d(9, 1) && fl1.K == 4) {
        fl1.b();
        cn.p.b++;
        cn.p.g();
      } 
      super.d();
      return;
    } 
    fl fl = g();
    if (!ft.o.a && ft.r == null)
      fl.d(); 
  }
  
  public final void e() {
    if (ft.o.a || ft.r != null || ft.s != null)
      return; 
    fl fl;
    if ((fl = g()).K == 10 && c.B != 0)
      return; 
    fl.g();
    if (ft.b((fl.g()).L, 0 + ft.X / 5, fl.aM + (fl.aN << 1), fl.aM * this.b.c())) {
      fl.g();
      int i;
      if ((i = cg.a(i = (ft.af - 0 + ft.X / 5) / fl.aM, this.b.c() - 1, false)) != this.a) {
        if (c.H) {
          c.n = null;
          c.m = null;
          c.o = null;
          c.H = false;
        } 
        f = 10;
        this.a = i;
        h();
        fl = g();
        if (cn.p.d(3, 8)) {
          if (fl.K == 1) {
            cn.p.f();
            cn.p.g();
          } 
        } else if (cn.p.d(7, 9)) {
          if (fl.K == 3) {
            cn.p.f();
            cn.p.g();
          } 
        } else if (cn.p.d(9, 1) && fl.K == 4) {
          cn.p.b++;
          cn.p.g();
        } 
      } 
      ft.S = false;
    } 
    fl.e();
    super.e();
  }
  
  private void h() {
    fl.aO = 1;
    fl fl;
    (fl = g()).b();
  }
  
  public final void a(int paramInt) {
    fl fl;
    (fl = g()).e(paramInt);
    super.a(paramInt);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\eu.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */