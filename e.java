public final class e {
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  public int a;
  
  private int i;
  
  public int b;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int[] o = new int[3];
  
  private boolean p;
  
  private boolean q;
  
  private int r;
  
  private es s;
  
  private bt t = null;
  
  private int u;
  
  private int v;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, es parames) {
    this.g = paramInt1;
    this.h = paramInt2;
    this.c = paramInt3;
    this.e = paramInt4;
    this.d = paramInt5;
    this.f = paramInt6;
    this.a = paramInt8;
    this.j = paramInt7;
    this.s = parames;
  }
  
  public final void a() {
    e e1;
    if ((e1 = this).r != 0 && !e1.p) {
      e1.i += e1.r / 100;
      if (e1.i < 0) {
        e1.i = 0;
      } else if (e1.i > e1.j) {
        e1.i = e1.j;
      } else {
        e1.b = e1.i;
      } 
      e1.r = e1.r * 9 / 10;
      if (e1.r < 100 && e1.r > -100)
        e1.r = 0; 
    } 
    if (e1.b != e1.i && !e1.p) {
      e1.u = e1.i - e1.b << 2;
      e1.v += e1.u;
      e1.b += e1.v >> 4;
      e1.v &= 0xF;
    } 
    e1 = this;
    boolean bool = false;
    if (ft.ak[2] || ft.ak[4]) {
      bool = true;
      e1.a--;
      if (e1.a < 0)
        e1.a = e1.f - 1; 
      ft.c(2);
      ft.c(4);
    } else if (ft.ak[8] || ft.ak[6]) {
      bool = true;
      e1.a++;
      if (e1.a > e1.f - 1)
        e1.a = 0; 
      ft.c(6);
      ft.c(8);
    } 
    if (bool) {
      e1.i = (e1.a + 1) * e1.d - e1.e / 2;
      if (e1.i > e1.j)
        e1.i = e1.j; 
      if (e1.i < 0)
        e1.i = 0; 
      if (e1.a == e1.f - 1 || e1.a == 0)
        e1.b = e1.i; 
    } 
    e1 = e1;
    bt bt1;
    if (ft.al[5] && e1.s != null && (bt1 = (bt)e1.s.a(e1.a)) != null) {
      if (bt1.c == null)
        if (bt1.d != null) {
          bt1.d.a(bt1.e, bt1.f);
        } else {
          ft.a.a_(bt1.e, bt1.f);
        }  
      ft.m();
      ft.l();
    } 
    if (ft.Q)
      if (!e1.p && ft.a(e1.g, e1.h, e1.c, e1.e)) {
        for (byte b = 0; b < e1.o.length; b++)
          e1.o[0] = ft.af; 
        e1.n = ft.af;
        e1.p = true;
        e1.q = (e1.r != 0);
        e1.r = 0;
      } else if (e1.p) {
        e1.l++;
        if (e1.l > 5 && e1.n == ft.af && !e1.q) {
          e1.n = -1000;
          e1.a = (e1.i + ft.af - e1.h) / e1.d;
        } 
        int i;
        if ((i = ft.af - e1.o[0]) != 0 && e1.a != -1)
          e1.a = -1; 
        for (int j = e1.o.length - 1; j > 0; j--)
          e1.o[j] = e1.o[j - 1]; 
        e1.o[0] = ft.af;
        e1.i -= i;
        if (e1.i < 0)
          e1.i = 0; 
        if (e1.i > e1.j)
          e1.i = e1.j; 
        if (e1.b < 0 || e1.b > e1.j)
          i /= 2; 
        e1.b -= i;
      }  
    if (ft.U && e1.p) {
      int i = ft.af - e1.o[0];
      ft.U = false;
      if (ak.e(i) < 20 && ak.e(ft.af - e1.n) < 20 && !e1.q) {
        e1.r = 0;
        e1.i = e1.b;
        e1.n = -1000;
        e1.a = (e1.i + ft.af - e1.h) / e1.d;
        e1.l = 0;
        e1.m = 5;
      } else if (e1.a != -1 && e1.l > 5) {
        e1.l = 0;
        e1.m = 1;
      } else if (e1.a == -1 && !e1.q) {
        if (e1.b < 0) {
          e1.i = 0;
        } else if (e1.b > e1.j) {
          e1.i = e1.j;
        } else {
          int j;
          if ((j = ft.af - e1.o[0] + e1.o[0] - e1.o[1] + e1.o[1] - e1.o[2]) > 10) {
            j = 10;
          } else if (j < -10) {
            j = -10;
          } else {
            j = 0;
          } 
          e1.r = -j * 100;
        } 
      } 
      e1.p = false;
      e1.l = 0;
      ft.U = false;
    } 
    if (this.k != 0) {
      this.k >>= 1;
      if (this.k < 0)
        this.k = 0; 
    } 
    if (this.m > 0) {
      this.m--;
      if (this.m == 0 && this.a >= 0) {
        bt bt2;
        if (this.s != null && (bt2 = (bt)this.s.a(this.a)) != null) {
          if (this.c == null)
            if (this.d != null) {
              this.d.a(this.e, this.f);
            } else {
              ft.a.a_(this.e, this.f);
            }  
          ft.m();
          ft.l();
        } 
        ft.m();
        ft.l();
        ft.V = true;
        ft.S = false;
      } 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\e.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */