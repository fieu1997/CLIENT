public final class eh {
  private boolean c = false;
  
  public String[] a;
  
  private int d;
  
  private int e;
  
  private int f;
  
  public int b;
  
  private int g;
  
  private int h;
  
  private o i;
  
  public final void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, o paramo) {
    this.i = paramo;
    this.d = paramInt2;
    this.e = paramInt3;
    this.g = paramInt4;
    if (this.g > ft.W - 10)
      this.g = ft.W - 10; 
    this.a = paramo.a(paramString, this.g);
    this.h = this.d;
    this.c = true;
    this.f = 0;
    this.b = 0;
  }
  
  public final boolean a() {
    if (this.b < this.a.length) {
      this.b = this.a.length;
      this.f = 0;
      return false;
    } 
    this.f = this.b = 0;
    return true;
  }
  
  public final void b() {
    if (this.c && this.b < this.a.length) {
      this.f += 2;
      if (this.f >= this.a[this.b].length()) {
        this.f = 0;
        this.b++;
      } 
    } 
  }
  
  public final void a(bx parambx) {
    int i = 0;
    i = this.e;
    for (byte b = 0; b < this.b; b++)
      this.i.a(parambx, this.a[b], this.h, i + b * ft.ab, 0, false); 
    if (this.b < this.a.length)
      this.i.a(parambx, this.a[this.b].substring(0, this.f), this.h, i + this.b * ft.ab, 0, false); 
  }
  
  public final void a(bx parambx, int paramInt) {
    int i = 0;
    i = this.e;
    if (paramInt == 2) {
      for (paramInt = 0; paramInt < this.b; paramInt++)
        this.i.a(parambx, this.a[paramInt], this.h + this.g / 2, i + paramInt * ft.ab, 2, false); 
      if (this.b < this.a.length) {
        this.i.a(parambx, this.a[this.b].substring(0, this.f), this.h + this.g / 2, i + this.b * ft.ab, 2, false);
        return;
      } 
    } else {
      for (paramInt = 0; paramInt < this.b; paramInt++)
        this.i.a(parambx, this.a[paramInt], this.h, i + paramInt * ft.ab, 0, false); 
      if (this.b < this.a.length)
        this.i.a(parambx, this.a[this.b].substring(0, this.f), this.h, i + this.b * ft.ab, 0, false); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\eh.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */