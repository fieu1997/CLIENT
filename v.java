public final class v extends z {
  public static boolean a = false;
  
  public static ce[] b;
  
  private static int[] n = new int[] { 420, 376, 290, 310 };
  
  private static int[] o = new int[] { 188, 447, 426, 105 };
  
  public v(short paramShort1, short paramShort2, int paramInt1, int paramInt2, int[][] paramArrayOfint) {
    super(paramShort1, paramShort2, paramInt1, paramInt2, paramArrayOfint);
    this.c = 0;
  }
  
  public final void a(int paramInt1, int paramInt2) {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public final void a(bx parambx) {
    fd fd;
    if ((fd = bk.b(this.e)).a != null)
      parambx.a(fd.a, this.h + this.f, this.i + this.g, 0); 
  }
  
  public static void b(bx parambx) {
    if (a) {
      if (ft.p.d == 58) {
        b[0].b(0, n[0], o[0], 0, parambx);
        return;
      } 
      if (ft.p.d == 56) {
        b[1].b(0, n[1], o[1], 0, parambx);
        return;
      } 
      if (ft.p.d == 54) {
        b[2].b(0, n[2], o[2], 0, parambx);
        return;
      } 
      if (ft.p.d == 60)
        b[3].b(0, n[3], o[3], 0, parambx); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\v.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */