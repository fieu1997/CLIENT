public final class cj extends cg {
  private int f = ft.Y;
  
  private int g = ft.Z;
  
  private int h;
  
  public int a;
  
  private int i;
  
  private int j;
  
  public int b = 0;
  
  public String[] c;
  
  public String d;
  
  public static aq[] e = new aq[2];
  
  private boolean k = true;
  
  private int[] l = new int[] { -13427660, -16788 };
  
  public final void a(String paramString, boolean paramBoolean) {
    this.k = paramBoolean;
    paramString = paramString.trim();
    this.i = o.i.a(paramString);
    if (this.i > 100) {
      this.i = 100;
    } else if (this.i < 20) {
      this.i = 20;
    } 
    this.h = 8;
    this.d = paramString;
    this.c = o.i.a(paramString, this.i);
    this.a = this.c.length * ft.ab;
    if (this.c.length <= 2) {
      this.j = 80;
      return;
    } 
    this.j = 140;
  }
  
  public final void a(bx parambx) {
    if (this.h > 0)
      this.h -= 2; 
    parambx = parambx;
    this = this;
    try {
      int i = this.g - this.a + this.h;
      int j = this.f - this.i / 2;
      parambx.a(this.l[0]);
      parambx.c(j - 3, i, this.i + 6, this.a);
      parambx.c(j, i - 3, this.i, this.a + 6);
      parambx.a(this.l[1]);
      parambx.c(j, i - 2, this.i, this.a + 4);
      parambx.c(j - 2, i, this.i + 4, this.a);
      parambx.a(e[0], 0, 0, 3, 3, 0, j - 3, i - 3, 0);
      parambx.a(e[0], 0, 3, 3, 3, 0, j + this.i, i - 3, 0);
      parambx.a(e[0], 0, 9, 3, 3, 0, j - 3, i + this.a, 0);
      parambx.a(e[0], 0, 6, 3, 3, 0, j + this.i, i + this.a, 0);
      if (this.b == 1) {
        parambx.a(e[1], 0, 0, 7, 7, 3, j + this.i / 2 - 3, i - 9, 0);
      } else {
        parambx.a(e[1], j + this.i / 2 - 3, i + this.a + 2, 0);
      } 
      if (this.c != null) {
        for (byte b = 0; b < this.c.length; b++)
          o.i.a(parambx, this.c[b], j + this.i / 2, i + 1 + b * ft.ab, 2, false); 
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public final void d(int paramInt1, int paramInt2) {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public final boolean b() {
    this.j--;
    return (this.j <= 0 && this.k);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cj.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */