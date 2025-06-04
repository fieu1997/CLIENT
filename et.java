public final class et extends da {
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private byte j = 5;
  
  private static int k = 0;
  
  private int r;
  
  public static es a = new es("MsgChat vecChatTab");
  
  private static String[] s;
  
  public static er b;
  
  public static bt c;
  
  private static bt t;
  
  private static bt u;
  
  private static bt v;
  
  private static bt w;
  
  private static bt x;
  
  private boolean y;
  
  private boolean z;
  
  private fz A = new fz();
  
  private bp B;
  
  private aw C = new aw();
  
  private int D = fl.aM;
  
  int d = fl.aN;
  
  private int E;
  
  private int F;
  
  private int G;
  
  public et() {
    this.l = ft.W / 4 * 3;
    if (this.l < 160) {
      this.l = 160;
    } else if (this.l > 240) {
      this.l = 240;
    } 
    this.m = ft.X - (bt.k << 1) - 16;
    if (this.m > 240)
      this.m = 240; 
    this.G = (this.m - 3 * this.D) / ft.ab + 5;
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - this.m / 2;
    this.C.a(0, 0, 0, 0);
    this.e = this.D * 3;
    if (this.e > 70)
      this.e = 70; 
    if (this.D < 20)
      this.j = 4; 
    this.f = (this.l - this.e - 20) / (this.D - 1) + 1;
    this.g = k - this.f / 2;
    if (this.g < 0)
      this.g = 0; 
    this.h = this.g + this.f;
    if (this.h > a.c())
      this.h = a.c(); 
    this.i = (this.l - (this.f - 1) * (this.D - 1) - this.e) / 2;
    c = new bt(df.au, 0, this);
    t = new bt(df.aw, 1, this);
    u = new bt(df.cD, -1, this);
    v = new bt(df.X, 2, this);
    w = new bt(df.bI, 3, this);
    x = new bt(df.bJ, 4, this);
    this.B = new bp(this.n, this.o + this.D, this.l, this.m - 3 * this.D, 0, 0, 0);
    int m = fl.bf[9];
    int k = this.m - this.D - fi.c() - 25;
    int j = this.o + this.D + 10;
    int i = this.n + this.l - 6;
    fz fz1;
    (fz1 = this.A).a = i;
    fz1.b = j;
    fz1.c = k;
    fz1.d = m;
    fz1.f = k - fl.aM;
    c();
  }
  
  public static void b() {
    c.a = df.au;
    t.a = df.aw;
    u.a = df.cD;
    v.a = df.X;
    w.a = df.bI;
    x.a = df.bJ;
  }
  
  public final void c() {
    if (a.c() != 0) {
      if (b == null && a.c() > 0) {
        if (k < 0 || k >= a.c())
          k = 0; 
        b = (er)a.a(k);
        h();
      } 
      if (b != null)
        h(); 
      if (ft.A)
        v.a(this.n + this.l - 12, this.o - 14, cf.t, ""); 
      this.Y = v;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    er er1;
    es es1;
    switch (paramInt1) {
      case -1:
        ft.j();
        break;
      case 0:
        b.a(cn.f.cB);
        break;
      case 1:
        if (k < 0 || k >= a.c())
          return; 
        if ((er1 = (er)a.a(k)) != null) {
          fm fm;
          if ((fm = ff.a(er1.b, (byte)0)) != null)
            fm.g = true; 
          a.b(k);
          if (k > 0)
            k--; 
          if (a.c() == 0) {
            b = null;
            this.Y = null;
            this.aa = null;
            this.Z = u;
            break;
          } 
          h();
        } 
        break;
      case 2:
        if (ft.A && a.c() == 1) {
          ft.j();
          return;
        } 
        es1 = new es("MsgChat menu");
        if (k > 0)
          es1.a(t); 
        es1.a(u);
        ft.o.a(es1, 2, df.bL, false, (es)null);
        break;
      case 3:
        q.a().a((byte)1, b.c);
        t.a();
        break;
      case 4:
        q.a().a((byte)2, b.c);
        t.a();
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  public final void a(bx parambx) {
    ft.a(parambx);
    cg.b(parambx, this.n - 10, this.o - ft.aa - 6, this.l + 20, this.m + ft.aa + 12, 0);
    bx bx1 = parambx;
    et et1 = this;
    if (ft.B) {
      fl.c(bx1, et1.n, et1.o + et1.D, et1.l, et1.m - et1.D, 2);
    } else {
      int k = et1.m - et1.D;
      int m = et1.l / 32;
      int n = k / 32;
      for (byte b = 0; b <= m; b++) {
        for (k = 0; k <= n; k++) {
          if (b == m) {
            if (k == n) {
              bx1.a(fl.aP[2], et1.n + et1.l - 32, et1.o + et1.m - 32, 0);
            } else {
              bx1.a(fl.aP[2], et1.n + et1.l - 32, et1.o + et1.D + (k << 5), 0);
            } 
          } else if (k == n) {
            bx1.a(fl.aP[2], et1.n + (b << 5), et1.o + et1.m - 32, 0);
          } else {
            bx1.a(fl.aP[2], et1.n + (b << 5), et1.o + et1.D + (k << 5), 0);
          } 
        } 
      } 
    } 
    cg.a(parambx, df.bL, this.n + this.l / 2, this.o - ft.aa + ft.aa / 4, 2, 0);
    int i = this.n + this.i;
    int j = this.o + this.d;
    if (a.c() > 0 && b != null) {
      if (this.g > 0)
        parambx.a(fl.aP[13], 0, (this.y && ft.ai % 6 < 3) ? 16 : 0, 13, 8, 6, i - 6, j + (this.d << 1), 3); 
      parambx.a(fl.bf[7]);
      int m;
      for (m = this.g; m < k; m++) {
        er er1 = (er)a.a(m);
        a(parambx, i, j, this.D, this.D, er1.e, er1.d);
        o.i.a(parambx, s[m], i + this.D / 2, j + this.D / 2 - 7, 2, true);
        i += this.D - 1;
      } 
      this.r = i;
      i += this.e - 1;
      for (m = k + 1; m < this.h; m++) {
        er er1 = (er)a.a(m);
        a(parambx, i, j, this.D, this.D, er1.e, er1.d);
        o.i.a(parambx, s[m], i + this.D / 2, j + this.D / 2 - 7, 2, true);
        i += this.D - 1;
      } 
      if (this.h < a.c())
        parambx.a(fl.aP[13], 0, (this.z && ft.ai % 6 < 3) ? 24 : 8, 13, 8, 6, i + 7, j + (this.d << 1), 3); 
      int i1 = this.e;
      int n = j - 1;
      m = this.r;
      bx bx2 = parambx;
      if (ft.B) {
        fl.c(bx2, m, n, i1, 32, 2);
      } else {
        for (byte b = 0; b <= i1 / 32; b++) {
          if (b == 0) {
            bx2.a(fl.aP[9], m, n, 0);
          } else if (b == i1 / 32) {
            bx2.a(fl.aP[9], 0, 0, 32, 32, 2, m + i1 - 32, n, 0);
          } else {
            bx2.a(fl.aP[2], m + (b << 5), n, 0);
          } 
        } 
      } 
      String str = null;
      if (o.f.a(b.b) < this.e - 4) {
        str = b.b;
      } else {
        str = String.valueOf(b.b.substring(0, this.j - 1 << 1)) + "..";
      } 
      o o;
      (o = o.f).a(parambx, str, this.r + this.e / 2, j + this.D / 2 - 7, 2, true);
      j += this.D;
      parambx.d(this.n, j, this.l, this.m - this.D - 7 - ((b.g == 0) ? 17 : 0));
      parambx.a(0, -this.C.b);
      this.E = this.C.b / ft.ab - 2;
      if (this.E < 0)
        this.E = 0; 
      this.F = this.E + this.G;
      for (int k = this.E; k <= this.F; k++) {
        if (k < b.a.c() && k >= 0) {
          bu bu;
          fl.a((bu = (bu)b.a.a(k)).b).a(parambx, bu.a, this.n + this.d, j + 2 + k * ft.ab, 0, true);
        } 
      } 
      ft.a(parambx);
      if (this.C.f > 0) {
        bx bx3 = parambx;
        fz fz1 = this.A;
        bx3.a(fz1.d);
        bx3.c(fz1.a - 2, fz1.b - 1, 3, 1);
        bx3.c(fz1.a - 3, fz1.b, 1, fz1.c - 1);
        bx3.c(fz1.a + 1, fz1.b, 1, fz1.c - 1);
        bx3.c(fz1.a - 2, fz1.b + fz1.c - 1, 3, 1);
        bx3.c(fz1.a - 2, fz1.b + fz1.e, 3, fl.aM);
      } 
      if (b.g == 0)
        b.f.a(parambx); 
    } else {
      j += this.D;
      o.j.a(parambx, df.av, this.n + this.l / 2, j + 2, 2, true);
    } 
    super.a(parambx);
  }
  
  public final void d() {
    if (a.c() > 0 && b != null) {
      int i = k;
      if (ft.al[4]) {
        if (k != 0)
          k--; 
        ft.d(4);
      } else if (ft.al[6]) {
        k++;
        ft.d(6);
      } 
      k = cg.a(k, a.c() - 1, true);
      if (ft.al[2]) {
        this.C.d -= ft.ab;
        if (this.C.d < 0)
          this.C.d = 0; 
        ft.d(2);
      } else if (ft.al[8]) {
        this.C.d += ft.ab;
        if (this.C.d > this.C.f)
          this.C.d = this.C.f; 
        ft.d(8);
      } 
      if (i != k)
        h(); 
    } 
    super.d();
  }
  
  public final void a() {
    if (ft.A) {
      this.B.a();
      this.C.b = this.B.f;
    } 
    this.y = false;
    this.z = false;
    if (a.c() > 0 && b != null) {
      for (byte b = 0; b < a.c(); b++) {
        er er1;
        if ((b < this.g || b >= this.h) && (er1 = (er)a.a(b)).e)
          if (b < this.g) {
            this.y = true;
          } else {
            this.z = true;
          }  
      } 
      if (a.c() == 0)
        k = 0; 
      if (this.C.f > 0) {
        int j = this.C.f;
        int i = this.C.b;
        fz fz1;
        (fz1 = this.A).e = i * fz1.f / j;
      } 
      if (ft.A) {
        this.B.c();
      } else {
        this.C.a();
        this.C.a();
      } 
      if (b.g == 0)
        b.f.a(); 
    } else if (b == null && a.c() > 0) {
      k = 0;
      b = (er)a.a(k);
      h();
    } 
    d();
    e();
    super.a();
  }
  
  public final void e(int paramInt) {
    if (a.c() > 0 && b != null && b.g == 0)
      b.f.b(paramInt); 
    super.e(paramInt);
  }
  
  private static void g() {
    s = new String[a.c()];
    for (byte b = 0; b < s.length; b++) {
      er er1;
      if ((er1 = (er)a.a(b)).b.length() <= 4) {
        s[b] = er1.b;
      } else {
        s[b] = er1.b.substring(0, 4);
      } 
    } 
  }
  
  public final void a(int paramInt) {
    if (ft.A) {
      this.B.g = b.h;
      if (this.B.f + this.m / 4 > this.B.g && this.B.g > 0) {
        this.B.e += ft.ab * paramInt;
        return;
      } 
    } else {
      this.C.f = b.h;
      if (this.C.b + this.m / 4 > this.C.f)
        this.C.d += ft.ab * paramInt; 
    } 
  }
  
  private void h() {
    b = (er)a.a(k);
    if (this.Y == null)
      this.Y = v; 
    if (b.g == 0) {
      b.f.b("");
      if (!ft.A) {
        b.f.a(true);
        this.aa = c;
        this.Z = b.f.b();
      } 
    } else if (b.g == 2) {
      this.aa = w;
      this.Z = x;
    } else {
      this.aa = null;
      this.Z = null;
    } 
    if (b.d > 0) {
      b.d = -1;
      b.e = false;
    } 
    if (b.h > 0) {
      int i;
      if ((i = b.h - this.m / 4) < 0)
        i = 0; 
      if (ft.A) {
        this.B.g = b.h;
        this.B.e = b.h;
      } else {
        this.C.a(0, b.h, 0, i);
        this.C.d = b.h;
      } 
    } else if (!ft.A) {
      this.C.a(0, 0, 0, 0);
    } else {
      this.B.g = 0;
      this.B.e = 0;
    } 
    this.g = k - this.f / 2;
    if (this.g < 0)
      this.g = 0; 
    this.h = this.g + this.f;
    if (this.h > a.c()) {
      this.h = a.c();
      this.g = this.h - this.f;
      if (this.g < 0)
        this.g = 0; 
    } 
    g();
    eu.f = 10;
  }
  
  public final void e() {
    if (a.c() > 0 && b != null) {
      if (b.g == 0)
        b.f.g(); 
      if (ft.S) {
        int i = this.n;
        int j = this.o;
        int k = (i += this.i) + (this.f - 1) * (this.D - 1) + this.e;
        int m = k;
        if (ft.c(this.n, j, this.l, this.D))
          if (ft.ae < this.r && ft.ae > i) {
            m = k + (ft.ae - this.r) / (this.D - 1) - 1;
            eu.f = 10;
          } else if (ft.ae > this.r + this.e && ft.ae < k) {
            m = k + (ft.ae - this.r - this.e) / (this.D - 1) + 1;
          } else if (ft.ae < i) {
            m = k - this.f;
          } else if (ft.ae > k) {
            m = k + this.f;
          }  
        if ((m = cg.a(m, a.c() - 1, false)) != k) {
          k = m;
          h();
          ft.S = false;
          eu.f = 10;
        } 
      } 
    } 
    super.e();
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, byte paramByte, boolean paramBoolean) {
    for (byte b = 0; b < a.c(); b++) {
      er er2;
      if ((er2 = (er)a.a(b)).b.compareTo(paramString1) == 0) {
        if (paramBoolean)
          k = b; 
        if (paramString3.length() > 0) {
          er2.a(String.valueOf(paramString2) + paramString3, paramString1);
          arrayOfString = o.j.a(paramString3, ft.h.a / 5 << 1);
          ft.h.a(paramString1, (byte)0, this[0], 0);
        } 
        return;
      } 
    } 
    er er1 = new er(paramString1, paramByte);
    if (paramByte == 0)
      er1.a(String.valueOf(df.bc) + paramString1, paramString1); 
    if (paramString3.length() > 0) {
      er1.a(String.valueOf(paramString2) + paramString3, paramString1);
      String[] arrayOfString1 = o.j.a(paramString3, ft.h.a / 2);
      ft.h.a(paramString1, (byte)0, arrayOfString1[0], 0);
    } 
    a.a(er1);
    String[] arrayOfString = this;
    g();
    ((et)super).g = k - ((et)super).f / 2;
    if (((et)super).g < 0)
      ((et)super).g = 0; 
    ((et)super).h = ((et)super).g + ((et)super).f;
    if (((et)super).h > a.c()) {
      ((et)super).h = a.c();
      ((et)super).g = ((et)super).h - ((et)super).f;
      if (((et)super).g < 0)
        ((et)super).g = 0; 
    } 
    if (paramBoolean)
      k = a.c() - 1; 
  }
  
  private void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5) {
    if (paramBoolean && (paramInt5 + ft.ai) % 8 < 4) {
      eu.f = 10;
      if (ft.B) {
        fl.c(parambx, paramInt1 + 1, paramInt2 + 1, paramInt3 - 2, paramInt4 - this.d - 1, 3);
      } else {
        parambx.a(fl.aP[10], 0, 0, paramInt3 - 2, paramInt4 - this.d - 1, 0, paramInt1 + 1, paramInt2 + 1, 0);
      } 
    } 
    parambx.c(paramInt1, paramInt2 + 1, 1, paramInt4 - 1);
    parambx.c(paramInt1 + 1, paramInt2, paramInt3 - 2, 1);
    parambx.c(paramInt1 + paramInt3 - 1, paramInt2 + 1, 1, paramInt4 - 1);
  }
  
  public static void a(String paramString) {
    for (byte b = 0; b < a.c(); b++) {
      er er1;
      if ((er1 = (er)a.a(b)).b.compareTo(paramString) == 0) {
        k = b;
        return;
      } 
    } 
  }
  
  public static void f() {
    for (byte b = 0; b < a.c(); b++) {
      er er1;
      int i;
      if ((i = (er1 = (er)a.a(b)).a.c()) > 80) {
        for (byte b1 = 0; b1 < i - 80; b1++)
          er1.a.b(b); 
        er1.a();
      } 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\et.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */