public final class fs {
  private byte a;
  
  private int b;
  
  private int c;
  
  private static aq[] d = null;
  
  private int e = 0;
  
  public fs() {}
  
  public fs(int paramInt1, int paramInt2, int paramInt3) {
    this.b = paramInt2;
    this.c = paramInt3;
    this.a = (byte)paramInt1;
    if (d == null) {
      d = new aq[9];
      for (byte b = 0; b < d.length; b++)
        d[b] = aq.a("/tilethac" + b + ".png"); 
    } 
  }
  
  public final void a(bx parambx) {
    if (d != null && this.a < d.length && d[this.a] != null) {
      4;
      d[this.a].a(false, this.e * 24, 24, 24, this.a, 0, this.b, this.c, 0);
    } 
  }
  
  public final void a() {
    if (ft.ai % 4 == 0)
      this.e = (this.e + 1) % 4; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fs.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */