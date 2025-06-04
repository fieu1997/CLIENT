public final class dm {
  private short b;
  
  private String c;
  
  private long d;
  
  private long e;
  
  public boolean a;
  
  private int f;
  
  private int g;
  
  public dm(int paramInt1, String paramString, int paramInt2, int paramInt3) {
    this.b = (short)paramInt1;
    this.c = paramString;
    this.f = paramInt2;
    this.g = paramInt3;
    this.d = dw.a();
    this.e = dw.a();
  }
  
  public final void a(bx parambx) {
    parambx.a(cg.aj, this.f, this.g + ft.ab / 2, 3);
    o.f.a(parambx, String.valueOf(this.c) + " : " + cs.a(this.b), this.f, this.g, 2, false);
  }
  
  public final void a() {
    this.d = dw.a();
    if (this.d - this.e >= 1000L) {
      this.e = dw.a();
      this.b = (short)(this.b - 1);
    } 
    if (this.b <= 0)
      this.a = true; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dm.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */