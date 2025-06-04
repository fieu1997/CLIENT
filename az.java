public final class az extends p {
  private int a;
  
  private int b;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private aw k = new aw();
  
  private bt l;
  
  private aq m;
  
  private byte n = -1;
  
  private boolean o = true;
  
  public static az b() {
    if (ft.n == null)
      ft.n = new az(); 
    return ft.n;
  }
  
  public final void c() {
    this.o = true;
    this.c = ft.c;
    az az1;
    (az1 = this).l = new bt(df.af, -1, az1);
    az1.a = ft.q.a;
    az1.b = ft.q.b;
    az1.f = ft.p.e;
    az1.g = ft.p.f;
    if (az1.f > ft.W - ft.aa)
      az1.f = ft.W - ft.aa; 
    if (az1.g > ft.X - ft.aa)
      az1.g = ft.X - ft.aa; 
    az1.h = (az1.f - az1.a) / 5;
    az1.i = (az1.g - az1.b) / 5;
    if (ft.A) {
      az1.j = 3;
      az1.m = ex.a(az1.j);
    } else {
      az1.j = ex.c;
      az1.m = ex.e;
    } 
    az1.n = -1;
    super.c();
    if (this.a == this.f && this.b == this.g)
      this.o = false; 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case -1:
        if (!this.o) {
          this.n = 2;
          return;
        } 
        if (this.n == 0)
          this.n = 1; 
        break;
    } 
  }
  
  public final void a(bx parambx) {
    this.c.a(parambx);
    if (cn.q.c(ft.p.d)) {
      ft.a(parambx);
      parambx.e(0, 0, ft.W, ft.X);
    } 
    if (ft.A) {
      parambx.a(ft.W - this.a * this.j, 0);
    } else {
      parambx.a(ft.W - this.a * this.j - 3, ft.X - 23 - this.b * this.j);
    } 
    parambx.a(-9164782);
    parambx.c(-3, -3, this.a * this.j + 6, this.b * this.j + 6);
    parambx.a(-470164);
    parambx.c(-2, -2, this.a * this.j + 4, this.b * this.j + 4);
    parambx.a(-12052464);
    parambx.c(-1, -1, this.a * this.j + 2, this.b * this.j + 2);
    parambx.d(0, 0, this.a * this.j, this.b * this.j);
    if (this.m != null)
      parambx.a(this.m, 0, 0, 0); 
    if (cs.w == 2)
      for (byte b = 0; b < cn.i.c(); b++) {
        ez ez;
        if ((ez = (ez)cn.i.a(b)).cu == 1)
          cg.aD.b(11, ez.aY / cs.l * this.j, ez.aZ / cs.l * this.j, 0, 3, parambx); 
      }  
    int i;
    for (i = 0; i < ex.f.c(); i++) {
      fk fk = (fk)ex.f.a(i);
      cg.aD.b(fk.d + 4, fk.b / cs.l * this.j, fk.c / cs.l * this.j, 0, 3, parambx);
    } 
    cg.aD.b((cn.f.cF == 4) ? 9 : cn.f.cG, cn.f.aY / cs.l * this.j, cn.f.aZ / cs.l * this.j, 0, 3, parambx);
    parambx.a(-16776961);
    if (bq.N != null)
      for (i = 0; i < bq.N.b.c(); i++) {
        aj aj;
        if ((aj = (aj)bq.N.b.a(i)).b.compareTo(cn.f.cB) != 0 && aj.f == ft.p.d)
          cg.aD.b(10, aj.d / cs.l * this.j, aj.e / cs.l * this.j, 0, 3, parambx); 
      }  
    if (ex.g != null && ex.g.p == ft.p.d) {
      i = ex.g.a;
      int j = ex.g.b;
      if (i < this.k.a + 3)
        i = this.k.a + 3; 
      if (i > this.k.a + this.a * this.j - 3)
        i = this.k.a + this.a * this.j - 3; 
      if (j < this.k.b + 3)
        j = this.k.b + 3; 
      if (j > this.k.b + this.b * this.j - 3)
        j = this.k.b + this.b * this.j - 3; 
      ck.b.b(ft.ai / 2 % ck.b.c, i, j, 0, 3, parambx);
    } 
    ft.a(parambx);
    if (cn.q.c(ft.p.d))
      cn.q.a(parambx, 10, 40, 20, 20); 
    cn.q.c(parambx, ft.W, 0);
  }
  
  public final void a() {
    if (this.n == 2) {
      this.m = null;
      this.c.c();
    } else if (this.n == 1) {
      if (this.a > ft.q.a) {
        this.a -= this.h << 1;
        if (this.a <= ft.q.a) {
          this.a = ft.q.a;
          this.n = 2;
        } 
      } 
      if (this.b > ft.q.b) {
        this.b -= this.i << 1;
        if (this.b <= ft.q.b) {
          this.b = ft.q.b;
          this.n = 2;
        } 
      } 
    } else {
      if (this.a < this.f) {
        this.a += this.h;
        if (this.a >= this.f) {
          this.a = this.f;
          this.n = 0;
        } 
      } 
      if (this.b < this.g) {
        this.b += this.i;
        if (this.b >= this.g) {
          this.b = this.g;
          this.n = 0;
        } 
      } 
    } 
    this.c.a();
    for (byte b = 0; b < ft.al.length; b++) {
      if (ft.al[b]) {
        this.l.a();
        ft.d(b);
        return;
      } 
    } 
  }
  
  public final void e() {
    if (ft.Q)
      this.l.a(); 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\az.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */