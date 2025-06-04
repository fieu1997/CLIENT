public final class gb {
  public static aq a = new aq();
  
  public static aq b = new aq();
  
  private static aq[] e = new aq[3];
  
  public static aq c = new aq();
  
  public static aq d = new aq();
  
  private static ce f;
  
  private static cp[] g = new cp[7];
  
  private static cp[] h = new cp[3];
  
  private static int[] i = new int[7];
  
  private static int[] j = new int[7];
  
  private static int k = 70;
  
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
  
  private static int[] v = new int[3];
  
  public static void a() {
    c();
    m = aq.a(a.a);
    n = aq.b(a.a);
    l = ft.W / m;
    q = aq.a(b.a);
    r = aq.b(b.a);
    o = ft.W / q;
    p = (ft.X - k + n) / r;
    t = aq.a((e[0]).a);
    u = aq.b((e[0]).a);
    s = ft.W / t;
    byte b;
    for (b = 0; b < g.length; b++) {
      g[b] = new cp();
      (g[b]).a = ak.c(0, ft.W);
      (g[b]).b = (ak.f(6) * 10);
      i[b] = ak.c(1, 3);
      j[b] = ak.c(0, 2);
    } 
    for (b = 0; b < h.length; b++) {
      h[b] = new cp();
      (h[b]).a = (ft.Y - 80 + b * 80);
      (h[b]).b = (ft.X - 50 - b % 2 * 25);
    } 
    v = new int[s + 2];
    for (b = 0; b < v.length; b++)
      v[b] = b * t - aq.a((e[0]).a); 
  }
  
  public static void a(bx parambx) {
    if (a == null || b == null || d == null) {
      c();
    } else {
      bx bx1;
      (bx1 = parambx).a(-11835756);
      bx1.c(0, 0, ft.W, k);
      int i;
      for (i = 0; i < l + 1; i++)
        bx1.a(a, i * m, k, 0); 
      (bx1 = parambx).a(c, 10, k + n / 2, 0);
      bx1 = parambx;
      i = k + n;
      for (byte b = 0; b < o + 1; b++) {
        for (byte b1 = 0; b1 < p + 1; b1++)
          bx1.a(b, b * q, b1 * r + i, 0); 
      } 
      bx1 = parambx;
      for (i = 0; i < 4; i++)
        bx1.a(e[i[i]], (int)(g[i]).a, (int)(g[i]).b, 0); 
    } 
    parambx.a(ft.Y - 0 * cs.l / 2, ft.X - 0 * cs.l);
    ft.a(parambx);
  }
  
  public static void b(bx parambx) {
    int i = ft.X - u;
    for (byte b = 0; b < v.length; b++)
      parambx.a(e[0], v[b], i, 0); 
  }
  
  public static void c(bx parambx) {
    for (byte b = 4; b < g.length; b++)
      parambx.a(e[i[b]], (int)(g[b]).a, (int)(g[b]).b, 0); 
  }
  
  public static void d(bx parambx) {
    for (byte b = 0; b < h.length; b++)
      parambx.a(d, (int)(h[b]).a, (int)(h[b]).b, 3); 
  }
  
  public static void b() {
    byte b;
    for (b = 0; b < g.length; b++) {
      j[b] = 1;
      (g[b]).a += j[b];
      if ((g[b]).a > ft.W) {
        (g[b]).a = -aq.a((e[1]).a);
        (g[b]).b = (ak.f(6) * 10);
        i[b] = ak.c(1, 3);
        j[b] = ak.c(1, 2);
      } 
    } 
    b = -1;
    int i = -1;
    for (byte b1 = 0; b1 < v.length; b1++) {
      v[b1] = v[b1] + 2;
      if (v[b1] > ft.W) {
        int j;
        if ((j = b1 + 1) > v.length - 1)
          j = 0; 
        if (b == -1) {
          b = b1;
          i = j;
        } 
      } 
    } 
    if (b != -1 && i != -1)
      v[b] = v[i] - t; 
  }
  
  public static void c() {
    a = aq.a("/bg/sky.img");
    b = aq.a("/bg/sea.img");
    for (byte b = 0; b < e.length; b++)
      e[b] = aq.a("/bg/cloud" + b + ".img"); 
    c = aq.a("/bg/boat.img");
    d = aq.a("/bg/floating.img");
    if (f == null)
      f = new ce(aq.a("/bg/seabg.png"), 24, 24); 
  }
  
  public static void e(bx parambx) {
    for (byte b = 0; b < 4; b++)
      parambx.a(e[i[b]], (int)(g[b]).a, (int)(g[b]).b + ft.X / 2, 0); 
  }
  
  public static void f(bx parambx) {
    for (byte b = 0; b < ft.W / 24 + 1; b++) {
      for (byte b1 = 0; b1 < ft.X / 24 + 1; b1++)
        f.b((ft.ai % 14 < 7) ? 1 : 0, b * 24, b1 * 24, 0, parambx); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\gb.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */