public final class ck extends p {
  private int f = (ft.W - 480) / 2;
  
  private int g = (ft.X - 320) / 2;
  
  private int h;
  
  private int i = 0;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int[][] m = new int[][] { 
      { 222, 263 }, { 266, 213 }, { 266, 213 }, { 238, 205 }, { 225, 197 }, { 201, 195 }, { 201, 195 }, { 329, 182 }, { 317, 161 }, { 305, 151 }, 
      { 305, 151 }, { 362, 189 }, { 387, 195 }, { 415, 191 }, { 415, 191 }, { 372, 165 }, { 386, 148 }, { 390, 134 }, { 345, 161 } };
  
  public static String[] a = null;
  
  public static ce b;
  
  private aw n = new aw();
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private boolean s;
  
  public final void a(p paramp) {
    ft.a(df.fJ);
  }
  
  public final void c() {
    p p1 = ft.a;
    p1 = this;
    ft.a(df.fJ);
  }
  
  public ck() {
    if (this.f < 0)
      this.f = 0; 
    if (this.g < 0)
      this.g = 0; 
    this.n.a(480 - ft.W, 320 - ft.X, 0, 0);
    this.j = this.m[1][0];
    this.k = this.m[1][1];
    this.n.a = this.j - ft.Y;
    this.n.b = this.k - ft.Z;
    if (this.n.a < 0)
      this.n.a = 0; 
    if (this.n.a > this.n.e)
      this.n.a = this.n.e; 
    if (this.n.b < 0)
      this.n.b = 0; 
    if (this.n.b > this.n.f)
      this.n.b = this.n.f; 
    this.n.c = this.n.a;
    this.n.d = this.n.b;
    bt bt = new bt(df.Z, -1);
    if (!ft.A) {
      this.Y = new bt(df.Y, 0);
    } else {
      bt.a(cf.q.a / 2, ft.X - cf.q.b / 2, cf.q, bt.a);
    } 
    this.Z = bt;
  }
  
  public final void b(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case -1:
        if (this.c == ft.u) {
          this.c.a(this.c.c);
          break;
        } 
        this.c.c();
        break;
    } 
    super.b(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    super.a(paramInt1, paramInt2);
  }
  
  public final void a(bx parambx) {
    parambx.a(-11181978);
    parambx.c(0, 0, ft.W, ft.X);
    parambx.a(-this.n.a, -this.n.b);
    parambx.a((aq)null, this.f, this.g, 0);
    if (this.i == -1 && (!ft.A || ft.Q || ft.T)) {
      o.c.a(parambx, a[this.l], this.n.a + ft.W - 5, this.n.b + 4, 1, false);
      o.f.a(parambx, a[this.l], this.n.a + ft.W - 4, this.n.b + 5, 1, false);
    } 
    b.b(ft.ai / 2 % b.c, this.f - 1, this.g - 1, 0, 3, parambx);
    if (!ft.A)
      parambx.a(cg.ak, this.f + this.j, this.g + this.k - this.h, 33); 
    if (!ft.o.a && ft.r == null) {
      if (ft.A) {
        super.a(parambx);
        return;
      } 
      d(parambx);
    } 
  }
  
  public final void a() {
    ck ck1 = this;
    if (ft.al[4] || ft.al[24]) {
      if (ck1.j > 10) {
        ck1.j -= 5;
      } else {
        ck1.j = 5;
      } 
      ck1.i = 3;
      if (ck1.n.e > 0)
        ck1.n.c -= 5; 
    } else if (ft.al[6] || ft.al[26]) {
      if (ck1.j < 470) {
        ck1.j += 5;
      } else {
        ck1.j = 475;
      } 
      ck1.i = 3;
      if (ck1.n.e > 0)
        ck1.n.c += 5; 
    } else if (ft.al[2] || ft.al[22]) {
      if (ck1.k > 10) {
        ck1.k -= 5;
      } else {
        ck1.k = 5;
      } 
      ck1.i = 3;
      if (ck1.n.f > 0)
        ck1.n.d -= 5; 
    } else if (ft.al[8] || ft.al[28]) {
      if (ck1.k < 315) {
        ck1.k += 5;
      } else {
        ck1.k = 320;
      } 
      ck1.i = 3;
      if (ck1.n.f > 0)
        ck1.n.d += 5; 
    } 
    ck1.d();
    if (this.i > 0) {
      this.i--;
      if (this.i == 1)
        for (byte b = 0; b < this.m.length; b++) {
          if (ak.e(this.m[b][0] - this.j) <= 6 && ak.e(this.m[b][1] - this.k) <= 6) {
            this.j = this.m[b][0];
            this.k = this.m[b][1];
            this.l = b;
            this.i = -1;
            break;
          } 
        }  
    } 
    if (this.i < 0) {
      this.h = ft.ai % 4;
    } else {
      this.h = 0;
    } 
    this.n.a();
  }
  
  public final void e() {
    super.e();
    if (ft.T)
      if (!this.s) {
        this.o = ft.ae;
        this.p = ft.af;
        this.q = this.n.a;
        this.r = this.n.b;
        this.s = true;
      } else {
        this.n.a = this.q - ft.ae - this.o;
        this.n.b = this.r - ft.af - this.p;
        if (this.n.a < 0)
          this.n.a = 0; 
        if (this.n.a > this.n.e)
          this.n.a = this.n.e; 
        if (this.n.b < 0)
          this.n.b = 0; 
        if (this.n.b > this.n.f)
          this.n.b = this.n.f; 
        this.n.c = this.n.a;
        this.n.d = this.n.b;
      }  
    if (ft.R || !ft.T) {
      this.s = false;
      this.o = 0;
      this.p = 0;
    } 
    if (ft.Q || ft.T) {
      this.j = ft.ae + this.n.a - this.f;
      this.k = ft.af + this.n.b - this.g;
    } 
    for (byte b = 0; b < this.m.length; b++) {
      if (ak.e(this.m[b][0] - this.j) <= 8 && ak.e(this.m[b][1] - this.k) <= 8) {
        this.l = b;
        this.i = -1;
        return;
      } 
    } 
    this.i = 3;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ck.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */