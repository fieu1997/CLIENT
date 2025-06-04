public final class eg extends p {
  public boolean a = false;
  
  public boolean b = false;
  
  public boolean f = false;
  
  public static boolean g = false;
  
  private long i;
  
  private long j;
  
  public byte[] h;
  
  private static byte[] k = new byte[] { 
      2, 3, 2, 3, 2, 6, 2, 2, 2, 6, 
      5, 5, 5, 6, 4, 4, 3, 6, 8, 8, 
      8, 8, 8, 8, 4, 4, 4, 6, 3, 3, 
      3, 6, 1, 1, 1, 5, 5, 5, 5, 5, 
      5, 8, 8, 8, 8, 5, 6, 5, 5, 5, 
      2, 5 };
  
  public final void c() {
    dw.b();
    super.c();
    this.i = ft.aj;
    ft.z.a();
    cf.C = 0;
  }
  
  public final void a(bx parambx) {
    parambx.a(0);
    parambx.c(0, 0, ft.W, ft.X);
    if (bs.l != null) {
      parambx.a(bs.l, ft.Y, ft.Z - 16, 3);
      parambx.a(cg.an, 0, ft.ai % 12 << 4, 16, 16, 0, ft.Y, ft.Z + aq.b(bs.l.a) / 2 - 9, 3);
      if (this.j > 0L)
        o.j.a(parambx, (new StringBuffer(String.valueOf(this.j))).toString(), ft.Y, ft.Z + aq.b(bs.l.a) / 2 - 15, 2, false); 
    } 
  }
  
  public final void a() {
    if ((ft.aj - this.i) / 1000L > 180L && ft.r != null) {
      ft.b(df.ck, new bt(df.bR, 0));
      if (cn.f != null)
        cn.f.N(); 
    } 
    if (g && this.a && co.a && (di.a.c() <= 5 || (ft.aj - this.i) / 1000L > 45L)) {
      if (cn.p.d(0, -5)) {
        (ft.f = new dn()).g();
        ft.f.c();
      } else {
        cn.f.u();
        cn.f.cN = null;
        cn.f.N();
        ft.c.c();
        ft.c.g();
        if (co.c.length() > 0 && co.b) {
          co.b = false;
          ft.b(String.valueOf(df.cJ) + "\n" + co.c, df.cI);
        } 
        ft.ad = ft.X / 4 * 3;
        cf.g();
        if (this.b) {
          cn.a(58, cn.f.ct, cn.f.cu, cn.f.ct, cn.f.cu, 0, cn.f.br);
          cn.f.bF = true;
        } 
        if (ft.p.d == 0 && cn.p.d(5, 8) && (ft.D || f.a)) {
          cn.p.f();
          cn.p.g();
        } 
      } 
      if (this.f) {
        cn.p.g();
        this.f = false;
      } 
      x.f = true;
      q q;
      (q = q.a()).n((byte)12);
      q.b();
      q.a().g((byte)59);
      bj.a.d();
    } 
    boolean bool = false;
    if (ft.J - dw.a() > 0L)
      this.j = (ft.J - dw.a()) / 1000L; 
    if (ft.J - dw.a() <= 0L && ft.J > 0L)
      bool = true; 
    if (bool) {
      this.j = 0L;
      ft.J = 0L;
      ft.b.a(ft.H);
      x.g = true;
      x.h = true;
    } 
    if (ft.N > 0L && (dw.a() - ft.N) / 1000L > 15L) {
      ft.N = 0L;
      ft.a(df.S, new bt(df.Z, 16));
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\eg.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */