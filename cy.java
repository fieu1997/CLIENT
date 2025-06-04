public final class cy {
  private long b;
  
  private int c;
  
  public boolean a;
  
  private String d = "";
  
  private int e;
  
  private int f;
  
  public cy(long paramLong, String paramString) {
    this.d = paramString;
    this.b = paramLong;
    this.c = 60;
    this.e = (int)(this.b - dw.a());
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    int i = 0;
    long l = this.b - dw.a();
    i = (int)(60L - l * this.c / this.e);
    parambx.a(cg.ay, 0, 0, 62, 9, 0, paramInt1, paramInt2, 0);
    parambx.a(cg.ah, 0, 7, i, 7, 0, paramInt1 + 1, paramInt2 + 1, 0);
    o.i.a(parambx, this.d, paramInt1 + this.c / 2 + 1, paramInt2 - 10 + 1 - 3, 2, false);
    o.j.a(parambx, this.d, paramInt1 + this.c / 2, paramInt2 - 10 - 3, 2, false);
    o.f.a(parambx, this.f + "%", paramInt1 + this.c / 2, paramInt2 - 1, 2, false);
  }
  
  public final void a() {
    long l = this.b - dw.a();
    this.f = (int)(100L - l * 100L / this.e);
    if (this.b - dw.a() <= 0L)
      this.a = true; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cy.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */