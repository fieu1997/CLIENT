public final class r extends p {
  private static r a;
  
  private boolean b;
  
  private static aq f = null;
  
  private static int g;
  
  private static int h;
  
  private static int i;
  
  private static int j;
  
  private static int k;
  
  private static int l;
  
  private static int m;
  
  private static int n;
  
  private static int o;
  
  private static int p;
  
  private static int q;
  
  private static int r;
  
  private static int s;
  
  private static int t;
  
  private static int u;
  
  private static int v;
  
  private static int w = 0;
  
  private static int x = 0;
  
  private static int y = 22;
  
  private static int z = 17;
  
  private static int A = 3;
  
  private static int B = 6;
  
  private static int[] C = new int[] { 
      108, 111, 131, 93, 76, 58, 39, 102, 83, 66, 
      49, 121, 135, 154, 160, 100, 94, 80, 128, 73, 
      100, 88, 53, 83, 73, 127, 109, 89, 72, 171, 
      172, 185, 202, 134, 117, 157, 135, 99, 102, 122, 
      139, 156, 47, 44, 28, 23, 47, 87, 133, 159, 
      23, 207, 207, 239, 226, 207, 207, 168, 182, 217, 
      23, 71, 24, 88, 25, 66, 99, 40, 47, 28, 
      64, 47, 47, 67, 83, 98, 111, 128, 117, 219, 
      191, 219, 241, 218, 1, 1, 1, 1, 1, 1, 
      1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
      1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
      1, 1, 1, 1, 1, 1, 1, 1, 1 };
  
  private static int[] D = new int[] { 
      247, 233, 220, 235, 236, 238, 237, 216, 212, 216, 
      205, 210, 204, 203, 182, 196, 180, 172, 183, 117, 
      144, 130, 134, 146, 134, 162, 160, 160, 160, 141, 
      125, 114, 116, 145, 144, 147, 128, 118, 98, 96, 
      88, 75, 149, 165, 165, 181, 118, 224, 235, 59, 
      200, 201, 187, 162, 167, 129, 143, 171, 171, 166, 
      217, 57, 62, 60, 83, 92, 72, 92, 69, 43, 
      42, 35, 18, 14, 8, 14, 28, 27, 132, 116, 
      96, 71, 94, 94, 1, 1, 1, 1, 1, 1, 
      1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
      1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
      1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
      1, 1, 1, 1 };
  
  private static String[] E;
  
  private int F;
  
  private int G;
  
  private int H;
  
  private int I;
  
  private boolean J = false;
  
  private int K;
  
  private int L;
  
  public r() {
    this.aa = new bt(df.Z, 0, this);
  }
  
  private void g() {
    int i;
    if ((i = ft.p.d) > C.length)
      i = C.length - 1; 
    int j = aq.a(ex.e.a);
    this.H = (ft.W - j) / 2;
    this.I = (ft.X - 20 - aq.b(ex.e.a)) / 2;
    if (this.H < 0)
      this.H = 0; 
    if (this.I < 0)
      this.I = 0; 
    if (this.b) {
      u = j + 20 - ft.W;
      v = aq.b(ex.e.a) + 40 - ft.X;
      this.F = j + 20;
      this.G = j + 40;
      if (this.G < ft.X - 26)
        this.G = ft.X - 26; 
      if (this.F < ft.W)
        this.F = ft.W; 
      i = this.H + cn.f.aY / 12;
      j = this.I + cn.f.aZ / 12;
    } else {
      u = 340 - ft.W;
      v = 340 - ft.X;
      i = C[i] + w;
      j = D[i] + x;
      this.F = 330 + w;
      this.G = 310 + x;
    } 
    this.F -= 10;
    this.G -= 10;
    if (u < 0)
      u = 0; 
    if (v < 0)
      v = 0; 
    s = t = 0;
    m = n = 0;
    m = i - ft.Y;
    n = j - ft.Z;
  }
  
  public static r b() {
    if (a == null)
      a = new r(); 
    return a;
  }
  
  public final void c() {
    super.c();
    this.aa = new bt(df.Z, 0, this);
    if (f == null) {
      g = aq.a((f = aq.a("/wm.png")).a);
      h = aq.a(f.a);
    } 
    if (ft.W > g)
      w = ft.W / 2 - g / 2; 
    if (ft.X > h)
      x = ft.X / 2 - h / 2; 
    g();
    h();
    System.gc();
    E = df.gC;
  }
  
  public final void a(bx parambx) {
    parambx.a(0);
    parambx.c(0, 0, ft.W, ft.X);
    parambx.a(10, 10);
    parambx.a(-s, -t);
    if (ft.W > g && ft.X > h) {
      parambx.a(f, ft.Y, ft.Z, A);
    } else if (ft.W > g) {
      parambx.a(f, ft.Y, 0, z);
    } else if (ft.X > h) {
      parambx.a(f, 0, ft.Z, B);
    } else {
      parambx.a(f, 0, 0, 0);
    } 
    if (ft.p.d < E.length && ft.p.d >= 0) {
      boolean bool = false;
      if (C[ft.p.d] != 1 || D[ft.p.d] != 1) {
        bool = (C[ft.p.d] < 100) ? false : ((C[ft.p.d] > 200) ? true : true);
        parambx.a(cg.al, 0, ft.ai % 3 * 10, 10, 10, 0, C[ft.p.d] + w, D[ft.p.d] + x, 3);
      } 
      int i = 0;
      if (C[ft.p.d] != 1 || D[ft.p.d] != 1) {
        i = D[ft.p.d] - 20;
        o.c.a(parambx, E[ft.p.d], C[ft.p.d] + w + 1, D[ft.p.d] + x - 20 + 1, bool, false);
        o.d.a(parambx, E[ft.p.d], C[ft.p.d] + w, D[ft.p.d] + x - 20, bool, false);
      } 
      if (k >= 0 && k != 0) {
        bool = (C[k] < 100) ? false : ((C[k] > 200) ? true : true);
        int j = C[k];
        int k;
        if ((k = D[k] - 20) > i && k - i < 30)
          k += 40; 
        if (k < i && i - k < 20)
          k -= 5; 
        o.c.a(parambx, E[k], j + w + 1, k + x + 1, bool, false);
        o.d.a(parambx, E[k], j + w, k + x, bool, false);
      } 
    } 
    if (!ft.A) {
      parambx.a(fl.aP[5], 0, 0, 10, 10, 0, i - 2, j, 0);
    } else if (k >= 0) {
      int i = C[k] - 9;
      int j = D[k];
      parambx.a(fl.aP[5], 0, 0, 10, 10, 0, i + w, j + x, 0);
    } 
    parambx.a(-parambx.a(), -parambx.b());
    super.a(parambx);
  }
  
  public final void d() {
    super.d();
    if (++l > 10000)
      l = 0; 
    if (s != m || t != n) {
      o = m - s << 1;
      p = n - t << 1;
      q += o;
      s += q >> 4;
      q &= 0xF;
      r += p;
      t += r >> 4;
      r &= 0xF;
      if (s < 0)
        s = 0; 
      if (s > u)
        s = u; 
      if (t < 0)
        t = 0; 
      if (t > v)
        t = v; 
    } 
    int i = 0;
    if (ft.al[2]) {
      if ((j -= 4) < x - 10)
        j = x - 10; 
      i = 1;
    } 
    if (ft.al[8]) {
      if ((j += 4) > this.G)
        j = this.G; 
      i = 1;
    } 
    if (ft.al[4]) {
      if ((i -= 4) < w - 10)
        i = w - 10; 
      i = 1;
    } 
    if (ft.al[6]) {
      if ((i += 4) > this.F)
        i = this.F; 
      i = 1;
    } 
    if (i) {
      m = i - ft.Y;
      n = j - ft.Z;
      h();
    } 
    if (ft.U && ft.af < ft.X - y) {
      ft.U = false;
      this.J = true;
      this.K = ft.ae;
      this.L = ft.af;
    } else if (ft.Q && this.J) {
      m -= ft.ae - this.K;
      n -= ft.af - this.L;
      if (m < 0)
        m = 0; 
      if (n < 0)
        n = 0; 
      if (m > u)
        m = u; 
      if (n > v)
        n = v; 
      s = m;
      t = n;
      this.K = ft.ae;
      this.L = ft.af;
    } 
    if (ft.R) {
      i = ft.ag - ft.ae;
      int j = ft.ah - ft.af;
      if (i < 10 && j < 10) {
        i = s + ft.ag - 8;
        j = t + ft.ah - 8;
        h();
      } 
      this.J = false;
      ft.R = false;
    } 
    if (ft.A && ft.W >= 320)
      this.aa.h = ft.W / 2 - 35; 
  }
  
  private static void h() {
    k = -1;
    byte b1 = 10;
    if (!ft.A)
      b1 = 13; 
    for (byte b2 = 0; b2 < C.length; b2++) {
      if (ak.e(i - C[b2] + w) < b1 && ak.e(j - D[b2] + x) < b1) {
        k = b2;
        return;
      } 
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 0:
        f = null;
        cn.b().c();
        return;
      case 1:
        this.b = !this.b;
        g();
        break;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\r.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */