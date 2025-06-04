public final class n extends p {
  private static n f;
  
  private byte g = -1;
  
  public byte a = 1;
  
  private dq h;
  
  private int i = 1;
  
  private short j;
  
  private long k;
  
  private long l;
  
  private long m;
  
  private long n;
  
  public boolean b;
  
  private bt o;
  
  private int p;
  
  private int q;
  
  private long r = 0L;
  
  public static n b() {
    if (f == null)
      f = new n(); 
    return f;
  }
  
  public final void a(short paramShort) {
    this.b = false;
    this.Y = null;
    this.Z = null;
    this.o = new bt(df.gi, -1, this);
    this.aa = this.o;
    this.n = dw.a();
    this.j = paramShort;
    this.m = this.n + (paramShort * 1000);
    this.p = 0;
    this.q = (ft.X << 1) / 3;
    this.i = 0;
    this.g = 50;
    this.h = new dq(this.g, 0, this.q, 0, 0, 1, 0);
    this.r = (paramShort * 1000 / (ft.W + 120));
  }
  
  public final void a() {
    cs.a(this.n, this.j);
    gb.b();
    n n1;
    (n1 = this).l = dw.a();
    if (!n1.b) {
      if (n1.l - n1.k >= n1.r) {
        n1.i++;
        n1.k = n1.l;
      } 
      if (n1.m - dw.a() <= 0L) {
        n1.m = dw.a() + 20000L;
        q.a().l(n1.a);
      } 
    } else {
      n1.i += 2;
      if (0 + n1.i >= ft.W) {
        n1.m = dw.a() + 20000L;
        q.a().l(n1.a);
      } 
    } 
    if (n1.h != null) {
      n1.h.a();
      n1.h.h = n1.i;
    } 
    if (this.b || this.m - dw.a() <= 10000L)
      this.aa = null; 
    cn.f.bk = 0;
    cn.f.cF = 0;
    cn.f.aY = 0 + this.i + 30;
    cn.f.aZ = this.q - 40;
    cn.f.cG = 3;
    cn.f.J();
    super.a();
  }
  
  public final void a(bx parambx) {
    if (ft.a != this)
      return; 
    parambx.a(-13286542);
    parambx.c(0, 0, ft.W, ft.X);
    gb.f(parambx);
    bx bx1 = parambx;
    n n1;
    if ((n1 = this).h != null)
      n1.h.a(bx1); 
    cn.f.c(parambx, -1);
    gb.e(parambx);
    super.a(parambx);
  }
  
  public final void c() {
    this.c = ft.c;
    super.c();
    ft.n();
    cn.q.l();
  }
  
  public final void d() {
    super.d();
  }
  
  public final void e() {
    super.e();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case -1:
        q.a().l((byte)2);
        break;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\n.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */