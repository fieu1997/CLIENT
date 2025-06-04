public final class ch extends bz {
  private static int[] d = new int[] { 
      0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 
      217, 232, 255, 285, 307, 322, 345, 370 };
  
  private int e;
  
  public static final int[] b = new int[] { 
      0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 
      3, 4, 5, 5, 5, 1 };
  
  public static final byte[] c = new byte[] { 
      0, 1, 2, 1, 1, 2, 1, 1, 2, 1, 
      1, 2, 1, 1, 2, 1, 1, 2, 1 };
  
  public final void a(bx parambx) {}
  
  public static int a(int paramInt) {
    for (byte b = 0; b < d.length - 1; b++) {
      if (paramInt >= d[b] && paramInt <= d[b + 1])
        return (b >= 16) ? 0 : b; 
    } 
    return 0;
  }
  
  public final void a() {
    this.e++;
    if (this.e >= null.length)
      this.e = null.length; 
    if (this.e == null.length) {
      (this = this).a = true;
      return;
    } 
  }
  
  static {
    (new byte[2][])[0] = new byte[0];
    (new byte[2][])[1] = new byte[0];
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ch.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */