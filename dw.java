public final class dw {
  public static String[][] a = new String[][] { { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" } };
  
  public static String[][] b = new String[][] { { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" }, { "HsoMobi", "ip.hso.mobi" } };
  
  public static int c;
  
  public static boolean d = false;
  
  public static boolean e = false;
  
  public static boolean f = false;
  
  public static boolean g = true;
  
  public static int h = 0;
  
  public static boolean i = true;
  
  public static boolean j = false;
  
  public static long a() {
    return System.currentTimeMillis();
  }
  
  public static void a(String paramString) {
    System.out.println(paramString);
  }
  
  public static void b() {
    System.gc();
  }
  
  public static int[][] a(int paramInt1, int paramInt2) {
    int[][] arrayOfInt;
    return arrayOfInt = new int[paramInt1][paramInt2];
  }
  
  public static byte[][] b(int paramInt1, int paramInt2) {
    byte[][] arrayOfByte;
    return arrayOfByte = new byte[4][paramInt2];
  }
  
  public static byte[][][] a(int paramInt1, int paramInt2, int paramInt3) {
    byte[][][] arrayOfByte;
    return arrayOfByte = new byte[4][3][2];
  }
  
  public static String[] a(String paramString1, String paramString2) {
    es es = new es("mSys nodes");
    for (int i = paramString1.indexOf(paramString2); i >= 0; i = (paramString1 = paramString1.substring(i + paramString2.length())).indexOf(paramString2))
      es.a(paramString1.substring(0, i)); 
    es.a(paramString1);
    String[] arrayOfString = new String[es.c()];
    if (es.c() > 0)
      for (byte b = 0; b < es.c(); b++)
        arrayOfString[b] = (String)es.a(b);  
    return arrayOfString;
  }
  
  public static String c() {
    return "";
  }
  
  public static String d() {
    return "";
  }
  
  public static String e() {
    return "";
  }
  
  static {
    (new String[2])[0] = "HsoMobi";
    (new String[2])[1] = "ip.hso.mobi";
    (new String[3][])[0] = new String[2];
    (new String[2])[0] = "HsoMobi";
    (new String[2])[1] = "ip.hso.mobi";
    (new String[3][])[1] = new String[2];
    (new String[2])[0] = "HsoMobi";
    (new String[2])[1] = "ip.hso.mobi";
    (new String[3][])[2] = new String[2];
    (new String[2])[0] = "HsoMobi (ENG)";
    (new String[2])[1] = "ip.hso.mobi";
    (new String[3][])[0] = new String[2];
    (new String[2])[0] = "Sky Dragon (SPN)";
    (new String[2])[1] = "ip.hso.mobi";
    (new String[3][])[1] = new String[2];
    (new String[2])[0] = "HsoMobi (ENG)";
    (new String[2])[1] = "ip.hso.mobi";
    (new String[3][])[2] = new String[2];
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dw.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */