public final class fz {
  int a;
  
  int b;
  
  int c;
  
  int d;
  
  int e;
  
  int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private int v;
  
  private int[] w = new int[3];
  
  private boolean x;
  
  private boolean y;
  
  private int z;
  
  private int A;
  
  private int B;
  
  private int C;
  
  private boolean D = true;
  
  private boolean E;
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    parambx.d(paramInt1, paramInt2, paramInt3, paramInt4 - 1);
    parambx.a(-parambx.a(), -parambx.b());
    parambx.a(-this.i, -this.j);
  }
  
  public final cq a() {
    if (this.D) {
      int n = (this = this).o;
      int i1 = this.p;
      int i2 = this.q;
      int i3 = this.r;
      if (ft.Q)
        if (!this.x && ft.a(n, i1, i2, i3)) {
          for (i2 = 0; i2 < this.w.length; i2++)
            this.w[0] = ft.af; 
          this.v = ft.af;
          this.x = true;
          this.A = -1;
          this.y = (this.z != 0);
          this.z = 0;
        } else if (this.x) {
          this.u++;
          if (this.u > 5 && this.v == ft.af && !this.y) {
            this.v = -1000;
            if (this.C > 1) {
              i2 = (this.h + ft.af - i1) / this.B;
              i3 = (this.g + ft.ae - n) / this.B;
              this.A = i2 * this.C + i3;
            } else {
              this.A = (this.h + ft.af - i1) / this.B;
            } 
          } 
          if ((i2 = ft.af - this.w[0]) != 0 && this.A != -1)
            this.A = -1; 
          for (i3 = this.w.length - 1; i3 > 0; i3--)
            this.w[i3] = this.w[i3 - 1]; 
          this.w[0] = ft.af;
          this.h -= i2;
          if (this.h < 0)
            this.h = 0; 
          if (this.h > this.t)
            this.h = this.t; 
          if (this.j < 0 || this.j > this.t)
            i2 /= 2; 
          this.j -= i2;
        }  
      i2 = 0;
      if (ft.R && this.x) {
        i3 = ft.af - this.w[0];
        ft.R = false;
        if (Math.abs(i3) < 20 && Math.abs(ft.af - this.v) < 20 && !this.y) {
          this.z = 0;
          this.h = this.j;
          this.v = -1000;
          if (this.C > 1) {
            i1 = (this.h + ft.af - i1) / this.B;
            n = (this.g + ft.ae - n) / this.B;
            this.A = i1 * this.C + n;
          } else {
            this.A = (this.h + ft.af - i1) / this.B;
          } 
          this.u = 0;
          i2 = 1;
        } else if (this.A != -1 && this.u > 5) {
          this.u = 0;
          i2 = 1;
        } else if (this.A == -1 && !this.y) {
          if (this.j < 0) {
            this.h = 0;
          } else if (this.j > this.t) {
            this.h = this.t;
          } else {
            if ((i1 = ft.af - this.w[0] + this.w[0] - this.w[1] + this.w[1] - this.w[2]) > 10) {
              i1 = 10;
            } else if (i1 < -10) {
              i1 = -10;
            } else {
              i1 = 0;
            } 
            this.z = -i1 * 100;
          } 
        } 
        this.x = false;
        this.u = 0;
        ft.R = false;
      } 
      cq cq1;
      (cq1 = new cq()).b = i2;
      cq1.a = this.x;
      return cq1;
    } 
    int i = (this = this).o;
    int j = this.p;
    int k = this.q;
    int m = this.r;
    if (ft.Q)
      if (!this.x && ft.a(i, j, k, m)) {
        for (k = 0; k < this.w.length; k++)
          this.w[0] = ft.ae; 
        this.v = ft.ae;
        this.x = true;
        this.A = -1;
        this.y = (this.z != 0);
        this.z = 0;
      } else if (this.x) {
        this.u++;
        if (this.u > 5 && this.v == ft.ae && !this.y) {
          this.v = -1000;
          this.A = (this.g + ft.ae - i) / this.B;
        } 
        if ((k = ft.ae - this.w[0]) != 0 && this.A != -1)
          this.A = -1; 
        for (m = this.w.length - 1; m > 0; m--)
          this.w[m] = this.w[m - 1]; 
        this.w[0] = ft.ae;
        this.g -= k;
        if (this.g < 0)
          this.g = 0; 
        if (this.g > this.s)
          this.g = this.s; 
        if (this.i < 0 || this.i > this.s)
          k /= 2; 
        this.i -= k;
      }  
    k = 0;
    if (ft.R && this.x) {
      m = ft.ae - this.w[0];
      ft.R = false;
      if (Math.abs(m) < 20 && Math.abs(ft.ae - this.v) < 20 && !this.y) {
        this.z = 0;
        this.g = this.i;
        this.v = -1000;
        this.A = (this.g + ft.ae - i) / this.B;
        this.u = 0;
        k = 1;
      } else if (this.A != -1 && this.u > 5) {
        this.u = 0;
        k = 1;
      } else if (this.A == -1 && !this.y) {
        if (this.i < 0) {
          this.g = 0;
        } else if (this.i > this.s) {
          this.g = this.s;
        } else {
          if ((j = ft.ae - this.w[0] + this.w[0] - this.w[1] + this.w[1] - this.w[2]) > 10) {
            j = 10;
          } else if (j < -10) {
            j = -10;
          } else {
            j = 0;
          } 
          this.z = -j * 100;
        } 
      } 
      this.x = false;
      this.u = 0;
      ft.R = false;
    } 
    cq cq;
    (cq = new cq()).b = k;
    cq.a = this.x;
    return cq;
  }
  
  public final void b() {
    int i = this.o;
    int j = this.p;
    int k = this.q;
    int m = this.r;
    if (ft.a(i, j, k, m) && ft.A && !this.E)
      this.E = true; 
    if (this.z != 0 && !this.x) {
      if (this.D) {
        this.h += this.z / 100;
        if (this.h < 0) {
          this.h = 0;
        } else if (this.h > this.t) {
          this.h = this.t;
        } else {
          this.j = this.h;
        } 
      } else {
        this.g += this.z / 100;
        if (this.g < 0) {
          this.g = 0;
        } else if (this.g > this.s) {
          this.g = this.s;
        } else {
          this.i = this.g;
        } 
      } 
      this.z = this.z * 9 / 10;
      if (this.z < 100 && this.z > -100)
        this.z = 0; 
    } 
    if (this.i != this.g && !this.x) {
      this.k = this.g - this.i << 2;
      this.m += this.k;
      this.i += this.m >> 4;
      this.m &= 0xF;
    } 
    if (this.j != this.h && !this.x) {
      this.l = this.h - this.j << 2;
      this.n += this.l;
      this.j += this.n >> 4;
      this.n &= 0xF;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7) {
    this.o = paramInt3;
    this.p = paramInt4;
    this.B = paramInt2;
    this.q = paramInt5;
    this.r = paramInt6;
    this.D = true;
    this.C = 1;
    this.t = paramInt1 * paramInt2 - paramInt6;
    if (this.t < 0)
      this.t = 0; 
    if (this.s < 0)
      this.s = 0; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fz.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */