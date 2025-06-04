public final class d extends cg {
  public fi a = new fi();
  
  private static d c;
  
  public static boolean b = false;
  
  public static d b() {
    return (c == null) ? (c = new d()) : c;
  }
  
  public final void c() {
    if (b = !b)
      this.a.i(); 
  }
  
  public final void b(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 0:
        this.a.b("");
        b = false;
        if (!ft.A) {
          this.a.a(true);
          return;
        } 
        break;
      case 1:
        if ((this = this).a.j().length() > 0) {
          cn.f.cE = this.a.j();
          q.a().a(this.a.j());
          this.a.b("");
        } 
        if (ft.A)
          b = false; 
        break;
    } 
  }
  
  protected d() {
    this.a.f = false;
    this.a.a(true);
    d d1;
    (d1 = this).a.b = ft.X - bt.k - d1.a.d - 5;
    d1.a.c = ft.W - 10;
    this.a.a = (ft.W - this.a.c) / 2;
    this.a.c(70);
    this.a.a(df.au);
    if (!ft.A) {
      this.Y = new bt(df.Z, 0);
      this.aa = new bt(df.au, 1);
      this.Z = this.a.b();
    } 
  }
  
  public final void a(int paramInt) {
    this.a.b(paramInt);
  }
  
  public final void d() {
    this.a.a();
    super.d();
  }
  
  public final void a(bx parambx) {
    super.a(parambx);
    this.a.a(parambx);
  }
  
  public final void e() {
    this.a.g();
    super.e();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\d.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */