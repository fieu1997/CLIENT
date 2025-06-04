public final class dn extends p {
  private String[] a;
  
  private int b;
  
  private int f;
  
  private int g = 0;
  
  private int h;
  
  private eh i = new eh();
  
  private static int[] j = null;
  
  private bt k;
  
  public static void b() {
    if (!ft.D && !f.a) {
      j = new int[3];
      return;
    } 
    j = new int[2];
  }
  
  public final void g() {
    ew ew;
    dn dn1;
    if ((dn1 = this).k == null) {
      dn1.k = new bt(df.aa, -1, dn1);
      dn1.k.a = df.aa;
      dn1.k.a(ft.Y, ft.X - bt.k, (ce)null, dn1.k.a);
      dn1.aa = dn1.k;
    } 
    if (this.g >= j.length) {
      ft.c.c();
      ft.ad = ft.Z;
      this.g = 0;
      if (ew.a != null)
        for (byte b = 0; b < ew.a.c(); b++) {
          (ew = (ew)ew.a.a(b)).b();
          cn.f.cG = 1;
        }  
      return;
    } 
    int i = 220;
    if (220 > ft.W)
      i = ft.W - 10; 
    if (j[((dn)super).g] == 0) {
      ((dn)super).a = o.f.a(df.gp[((dn)super).g], i);
      ((dn)super).b = 180 + ((dn)super).a.length * ft.ab;
      ((dn)super).h = 1;
      if (((dn)super).a.length < 4)
        ((dn)super).h = 2; 
    } else {
      ((dn)super).i.a(df.gp[((dn)super).g], 0, ft.Y - i / 2, ft.Z, 220, o.f);
    } 
    ((dn)super).g++;
  }
  
  public final void a(bx parambx) {
    parambx.a(0);
    parambx.c(0, 0, ft.W, ft.X);
    parambx.d(0, ft.Z - 90, ft.W, 180);
    if (this.a != null) {
      for (byte b = 0; b < this.a.length; b++)
        o.f.a(parambx, this.a[b], ft.Y, ft.Z + 80 + b * ft.ab - this.f, 2, true); 
    } else if (this.i.a != null) {
      this.i.a(parambx);
      ft.a(parambx);
      cg.a(parambx, df.aa, ft.Y, ft.X - ft.aa / 2 - 4, 2);
    } 
    super.a(parambx);
  }
  
  public final void a() {
    if (this.a != null) {
      this.f += this.h;
      if (this.f > this.b) {
        this.a = null;
        g();
        this.f = 0;
        return;
      } 
    } else if (this.i.a != null) {
      this.i.b();
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case -1:
        this.g = j.length;
        g();
        break;
    } 
  }
  
  public final void d() {
    if (ft.ak[5]) {
      this.g = j.length;
      g();
      ft.c(5);
    } 
    if (this.i.a != null) {
      if (ft.al[5] && this.i.a()) {
        this.i.a = null;
        g();
        ft.d(5);
      } 
      super.d();
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dn.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */