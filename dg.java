public final class dg {
  private int a = 1;
  
  private int[][] b = new int[][] { { -1, -1, -1052689, -1052689, -4079167, -4079167, -6250336 }, { -14097665, -14097665, -14104585, -14104585, -14114080, -14114080, -14249063 }, { -1280, -1280, -1251840, -1251840, -3949821, -3949821, -5594621 }, { -423937, -423937, -1473281, -1473281, -3768833, -3768833, -5934642 }, { -20158, -20158, -26313, -26313, -34787, -34787, -3179218 } };
  
  private int[] c = new int[] { 1, 1, 1, 1, 1 };
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bx parambx, int paramInt5) {
    if (paramInt3 <= 0)
      return; 
    int i = paramInt4;
    int j = (paramInt3 - 1) % 5;
    parambx.a(this.b[j][6]);
    parambx.b(paramInt1 - paramInt4 / 2 - paramInt5, paramInt2 - paramInt4 / 2 - paramInt5, paramInt4, paramInt4);
    byte b;
    for (b = 0; b < this.c.length; b++) {
      int k = paramInt1 - i / 2 + b(ft.ai - b * this.a, paramInt4);
      int m = paramInt2 - i / 2 + a(ft.ai - b * this.a, paramInt4);
      parambx.a(this.b[j][b]);
      parambx.c(k - this.c[b] / 2 - paramInt5, m - this.c[b] / 2 - paramInt5, this.c[b], this.c[b]);
    } 
    if (paramInt3 >= 6 && paramInt3 < 11)
      for (b = 0; b < this.c.length; b++) {
        int k = paramInt1 - i / 2 + b(ft.ai - (i << 1) - b * this.a, paramInt4);
        int m = paramInt2 - i / 2 + a(ft.ai - (i << 1) - b * this.a, paramInt4);
        parambx.a(this.b[j][b]);
        parambx.c(k - this.c[b] / 2 - paramInt5, m - this.c[b] / 2 - paramInt5, this.c[b], this.c[b]);
      }  
    if (paramInt3 >= 11) {
      for (b = 0; b < this.c.length; b++) {
        int k = paramInt1 - i / 2 + b(ft.ai - i * 13 / 10 - b * this.a, paramInt4);
        int m = paramInt2 - i / 2 + a(ft.ai - i * 13 / 10 - b * this.a, paramInt4);
        parambx.a(this.b[j][b]);
        parambx.c(k - this.c[b] / 2 - paramInt5, m - this.c[b] / 2 - paramInt5, this.c[b], this.c[b]);
      } 
      for (b = 0; b < this.c.length; b++) {
        int k = paramInt1 - i / 2 + b(ft.ai - i * 13 / 5 - b * this.a, paramInt4);
        int m = paramInt2 - i / 2 + a(ft.ai - i * 13 / 5 - b * this.a, paramInt4);
        parambx.a(this.b[j][b]);
        parambx.c(k - this.c[b] / 2 - paramInt5, m - this.c[b] / 2 - paramInt5, this.c[b], this.c[b]);
      } 
    } 
  }
  
  private static int a(int paramInt1, int paramInt2) {
    paramInt2 = paramInt2;
    return ((paramInt1 %= paramInt2 * 4) >= 0 && paramInt1 < paramInt2) ? 0 : ((paramInt2 <= paramInt1 && paramInt1 < paramInt2 << 1) ? (paramInt1 % paramInt2) : ((paramInt2 << 1 <= paramInt1 && paramInt1 < paramInt2 * 3) ? paramInt2 : (paramInt2 - paramInt1 % paramInt2)));
  }
  
  private static int b(int paramInt1, int paramInt2) {
    paramInt2 = paramInt2;
    return ((paramInt1 %= paramInt2 * 4) >= 0 && paramInt1 < paramInt2) ? (paramInt1 % paramInt2) : ((paramInt2 <= paramInt1 && paramInt1 < paramInt2 << 1) ? paramInt2 : ((paramInt2 << 1 <= paramInt1 && paramInt1 < paramInt2 * 3) ? (paramInt2 - paramInt1 % paramInt2) : 0));
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dg.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */