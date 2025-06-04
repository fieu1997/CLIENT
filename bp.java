public final class bp {
  public int a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  private int h;
  
  public int e;
  
  public int f;
  
  public int g;
  
  private int i;
  
  private int j;
  
  private int[] k = new int[3];
  
  private boolean l;
  
  private boolean m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  public bp(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.c = paramInt1;
    this.d = paramInt2;
    this.a = paramInt3;
    this.b = paramInt4;
    this.g = paramInt7;
  }
  
  public final void a() {
    if (ft.Q)
      if (!this.l && ft.a(this.c, this.d, this.a, this.b)) {
        for (byte b = 0; b < this.k.length; b++)
          this.k[0] = ft.af; 
        this.j = ft.af;
        this.l = true;
        this.m = (this.n != 0);
        this.n = 0;
      } else if (this.l) {
        this.i++;
        if (this.i > 5 && this.j == ft.af && !this.m)
          this.j = -1000; 
        int i;
        if ((i = ft.af - this.k[0]) != 0 && this.h != -1)
          this.h = -1; 
        for (int j = this.k.length - 1; j > 0; j--)
          this.k[j] = this.k[j - 1]; 
        this.k[0] = ft.af;
        this.e -= i;
        if (this.e < 0)
          this.e = 0; 
        if (this.e > this.g)
          this.e = this.g; 
        if (this.f < 0 || this.f > this.g)
          i /= 2; 
        this.f -= i;
      }  
    if (ft.U && this.l) {
      int i = ft.af - this.k[0];
      ft.U = false;
      if (ak.e(i) < 20 && ak.e(ft.af - this.j) < 20 && !this.m && ft.S) {
        this.n = 0;
        this.e = this.f;
        this.j = -1000;
        this.i = 0;
      } else if (this.h != -1 && this.i > 5) {
        this.i = 0;
      } else if (this.h == -1 && !this.m) {
        if (this.f < 0) {
          this.e = 0;
        } else if (this.f > this.g) {
          this.e = this.g;
        } else {
          int j;
          if ((j = ft.af - this.k[0] + this.k[0] - this.k[1] + this.k[1] - this.k[2]) > 10) {
            j = 10;
          } else if (j < -10) {
            j = -10;
          } else {
            j = 0;
          } 
          this.n = -j * 100;
        } 
      } 
      this.l = false;
      this.i = 0;
      ft.U = false;
    } 
  }
  
  public final void b() {
    if (ft.Q)
      if (!this.l && ft.a(this.c, this.d, this.a, this.b)) {
        for (byte b = 0; b < this.k.length; b++)
          this.k[0] = ft.ae; 
        this.j = ft.ae;
        this.l = true;
        this.m = (this.n != 0);
        this.n = 0;
      } else if (this.l) {
        this.i++;
        if (this.i > 5 && this.j == ft.ae && !this.m)
          this.j = -1000; 
        int i;
        if ((i = ft.ae - this.k[0]) != 0 && this.h != -1)
          this.h = -1; 
        for (int j = this.k.length - 1; j > 0; j--)
          this.k[j] = this.k[j - 1]; 
        this.k[0] = ft.ae;
        this.e -= i;
        if (this.e < 0)
          this.e = 0; 
        if (this.e > this.g)
          this.e = this.g; 
        if (this.f < 0 || this.f > this.g)
          i /= 2; 
        this.f -= i;
      }  
    if (ft.U && this.l) {
      int i = ft.ae - this.k[0];
      ft.U = false;
      if (ak.e(i) < 20 && ak.e(ft.ae - this.j) < 20 && !this.m && ft.S) {
        this.n = 0;
        this.e = this.f;
        this.j = -1000;
        this.i = 0;
      } else if (this.h != -1 && this.i > 5) {
        this.i = 0;
      } else if (this.h == -1 && !this.m) {
        if (this.f < 0) {
          this.e = 0;
        } else if (this.f > this.g) {
          this.e = this.g;
        } else {
          int j;
          if ((j = ft.ae - this.k[0] + this.k[0] - this.k[1] + this.k[1] - this.k[2]) > 10) {
            j = 10;
          } else if (j < -10) {
            j = -10;
          } else {
            j = 0;
          } 
          this.n = -j * 100;
        } 
      } 
      this.l = false;
      this.i = 0;
      ft.U = false;
    } 
  }
  
  public final void c() {
    if (this.n != 0 && !this.l) {
      this.e += this.n / 100;
      if (this.e < 0) {
        this.e = 0;
      } else if (this.e > this.g) {
        this.e = this.g;
      } else {
        this.f = this.e;
      } 
      this.n = this.n * 9 / 10;
      if (this.n < 100 && this.n > -100)
        this.n = 0; 
    } 
    if (this.f != this.e && !this.l) {
      this.o = this.e - this.f << 2;
      this.p += this.o;
      this.f += this.p >> 4;
      this.p &= 0xF;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bp.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */