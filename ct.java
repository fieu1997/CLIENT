public class ct {
  public static int[][] a = new int[][] { { 
        15, 23, 41, 21, 5, 42, 43, 42, 5, 45, 
        45, 54, 58, 64, 68 }, { 
        15, 44, 36, 22, 37, 27, 34, 27, 14, 45, 
        45, 55, 60, 65, 69 }, { 
        31, 46, 20, 39, 51, 6, 48, 47, 48, 45, 
        45, 56, 61, 62, 66 }, { 
        31, 19, 18, 24, 40, 49, 50, 52, 53, 45, 
        45, 57, 59, 63, 67 }, { 
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 
        20, 21, 22, 23, 24, 25, 26, 27, 70, 70, 
        70, 70 }, new int[10], { 
        45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 
        45, 45, 45, 45, 45, 45, 45, 45 } };
  
  public static int[][] b = new int[][] { { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 5, 9 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 1, 6, 9 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 7, 9 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 3, 8, 9 }, { 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 28, 29, 
        30, 31 }, new int[10], { 
        10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 
        10, 10, 10, 10, 10, 10, 10, 10, 10, 10 } };
  
  static int[] c = new int[] { 
      200, 60, 200, 50, 200, 110, 110, 70, 100, 200, 
      200, 200, 200, 200, 110, 60, 30, 110, 110, 110, 
      110, 110, 75, 60, 110, 100, 120, 110, 160, 140, 
      120, 70, 60, 100, 110, 50, 60, 110, 110, 110, 
      110, 60, 110, 110, 60, 120, 110, 110, 110, 110, 
      110, 110, 110, 110, 110, 110, 110, 110, 110, 110, 
      110, 110, 110, 110, 110, 110, 110, 110, 110, 110 };
  
  static int[] d = new int[] { 
      0, 0, 0, 0, 0, 5, 7, 7, 16, 16, 
      1, 5, 1, 1, 11, 2, 5, 4, 10, 7, 
      12, 7, 14, 1, 5, 5, 6, 1, 7, 7, 
      1, 9, 1, 7, 2, 13, 11, 5, 10, 10 };
  
  static int[] e = new int[] { 
      5, 5, 5, 5, 5, 11, 15, 5, 5, 5, 
      5, 5, 5, 5, 15, 5, 5, 5, 9, 9, 
      9, 11, 9, 9, 11, 5, 5, 9, 5, 5, 
      5, 5, 5, 5, 15, 5, 9, 11, 5, 11, 
      11, 9, 15, 15, 9, 5, 9, 15, 15, 11, 
      11, 11, 20, 20, 5, 5, 5, 5, 5, 5, 
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
  
  public static int[] f;
  
  public static void a() {
    (f = new int[d.length])[5] = 11;
    f[6] = 12;
    f[14] = 20;
    f[15] = 21;
    f[18] = 22;
    f[19] = 23;
    f[20] = 25;
    f[21] = 26;
    f[22] = 27;
    f[23] = 28;
    f[24] = 31;
    f[27] = 34;
    f[31] = 38;
    f[34] = 40;
    f[35] = 38;
    f[36] = 46;
    f[37] = 47;
    f[39] = 49;
    f[40] = 51;
    f[41] = 52;
    f[42] = 53;
    f[43] = 54;
    f[44] = 55;
    f[45] = 57;
    f[46] = 59;
    f[47] = 60;
    f[48] = 61;
    f[49] = 62;
    f[50] = 82;
    f[51] = 64;
    f[52] = 65;
    f[53] = 66;
    f[54] = 110;
    f[55] = 112;
    f[56] = 109;
    f[57] = 111;
    f[58] = 0;
    f[59] = 0;
    f[60] = 0;
    f[61] = 0;
    f[62] = 119;
    f[63] = 118;
    f[64] = 116;
    f[65] = 117;
    f[66] = 123;
    f[67] = 122;
    f[68] = 120;
    f[69] = 121;
  }
  
  public static void a(int paramInt) {
    bq.H = new int[y.a.c()];
    for (byte b = 0; b < bq.H.length; b++)
      bq.H[b] = a[paramInt][b]; 
  }
  
  public static int a(ez paramez1, ez paramez2) {
    int j = paramez1.aY - paramez2.aY;
    int i = paramez1.aZ - paramez2.aZ;
    if (ak.e(j) > ak.e(i)) {
      if (j > 0) {
        i = 2;
      } else {
        i = 3;
      } 
    } else if (i > 0) {
      i = 1;
    } else {
      i = 0;
    } 
    return i;
  }
  
  public static int b(int paramInt) {
    ev ev;
    return ((ev = c(paramInt)) != null) ? ev.h : 50;
  }
  
  public static ev c(int paramInt) {
    for (byte b = 0; b < y.a.c(); b++) {
      ev ev;
      if ((ev = (ev)y.a.a(b)).b == paramInt)
        return ev; 
    } 
    return null;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ct.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */