import com.silverknight.TemMidlet;

public final class dc extends p {
  private int a;
  
  private int b;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private e j;
  
  private es k = new es("List_Ip_Server_Screen vecchoice");
  
  public dc() {
    u.a(u.a = TemMidlet.c(ft.O), false);
    this.i = ft.aa;
    this.f = ft.W - 20;
    if (this.f > 180)
      this.f = 180; 
    this.g = dw.a.length * this.i;
    int i = 0;
    if (this.g > ft.X / 5 << 2) {
      i = this.g - (ft.X / 5 << 2);
      this.g = ft.X / 5 << 2;
    } 
    this.a = ft.Y - this.f / 2;
    this.b = ft.Z - this.g / 2 + this.i / 2;
    this.k.d();
    for (byte b = 0; b < dw.a.length; b++)
      this.k.a(new bt(dw.a[b][0], 0, b, this)); 
    if (ft.A)
      this.h = -1; 
    this.j = new e(this.a, this.b, this.f, this.g, this.i, dw.a.length, i, this.h, this.k);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    boolean bool;
    switch (paramInt1) {
      case 0:
        if ((l.a()).c)
          l.a().c(); 
        ft.H = (byte)paramInt2;
        ft.b.c();
        bool = ft.D;
        if ((ft.D = (ft.M[ft.H] == 0)) != bool) {
          u.b();
          ft.a(df.gk);
        } 
        if (ft.D) {
          bs.b = true;
        } else {
          bs.b = false;
        } 
        if (f.a) {
          bs.b = false;
          u.b();
        } 
        if (cd.a) {
          bs.b = false;
          if (ft.H == 0) {
          
          } else if (ft.H == 1) {
          
          } 
          u.b();
        } 
        ft.b.a(ft.H);
        break;
    } 
  }
  
  public final void a(bx parambx) {
    gb.a(parambx);
    if (cf.W == 0) {
      parambx.a(cg.aB, 0, 0, 0);
    } else if (cf.W == 1) {
      cf.j(parambx);
    } 
    cg.a(parambx, this.a, this.b - this.i, this.f, this.g + this.i, df.fE);
    parambx.d(this.a, this.b, this.f, this.g);
    parambx.a(0, -this.j.b);
    if (this.h > -1) {
      bx bx1 = parambx;
      dc dc1 = this;
      bx1.a(-3689060);
      bx1.c(dc1.a + 5, dc1.b + dc1.h * dc1.i + dc1.i / 2 - 11, dc1.f - 10, 22);
    } 
    for (byte b = 0; b < this.k.c(); b++) {
      bt bt = (bt)this.k.a(b);
      o.f.a(parambx, bt.a, this.a + this.f / 2, this.b + this.i / 2 + b * this.i - 6, 2, true);
      if (b < this.k.c() - 1) {
        parambx.a(cg.aL[4]);
        parambx.c(this.a + 8, this.b + (b + 1) * this.i - 1, this.f - 16, 1);
      } 
    } 
  }
  
  public final void a() {
    this.j.a();
    this.h = this.j.a;
    if (this.h >= this.k.c()) {
      this.h = -1;
      this.j.a = -1;
    } 
    gb.b();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dc.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */