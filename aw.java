public final class aw {
  public int a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public int e;
  
  public int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.f < 0)
      this.f = 0; 
    if (this.e < 0)
      this.e = 0; 
    if (paramInt3 > paramInt1)
      paramInt3 = paramInt1; 
    if (paramInt3 < 0)
      paramInt3 = 0; 
    if (paramInt4 > paramInt2)
      paramInt4 = paramInt2; 
    if (paramInt4 < 0)
      paramInt4 = 0; 
    this.a = paramInt3;
    this.b = paramInt4;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public final void a(int paramInt1, int paramInt2) {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public final void a() {
    if (cn.f.dQ)
      if (ft.p.d == 19) {
        if (this.b != 0) {
          this.d = 0;
        } else {
          return;
        } 
      } else {
        return;
      }  
    if (this.a != this.c) {
      this.g = this.c - this.a << 1;
      this.h += this.g;
      this.a += this.h >> 4;
      this.h &= 0xF;
      if (this.a < 0)
        this.a = 0; 
      if (this.a > this.e)
        this.a = this.e; 
    } 
    if (this.b != this.d) {
      this.i = this.d - this.b << 1;
      this.j += this.i;
      this.b += this.j >> 4;
      this.j &= 0xF;
      if (this.b < 0)
        this.b = 0; 
      if (this.b > this.f)
        this.b = this.f; 
    } 
  }
  
  public final void b() {
    if (this.a != this.c) {
      this.g = this.c - this.a << 1;
      this.h += this.g;
      this.a += this.h >> 4;
      this.h &= 0xF;
    } 
    if (this.b != this.d) {
      this.i = this.d - this.b << 1;
      this.j += this.i;
      this.b += this.j >> 4;
      this.j &= 0xF;
      if (this.b < 0)
        this.b = 0; 
      if (this.b > this.f)
        this.b = this.f; 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\aw.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */