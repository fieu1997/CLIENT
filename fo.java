public final class fo {
  public int a;
  
  public int b;
  
  public String c;
  
  private int q;
  
  public static boolean d = true;
  
  public int e;
  
  public int[] f;
  
  public byte g;
  
  public long h;
  
  public byte i;
  
  public String j;
  
  public static int[] k = new int[] { 
      -1, 3, 4, 5, 12, 2, 1, 6, 4, 7, 
      -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, 
      -2, -2, -2, -2 };
  
  public static int[] l = new int[] { 1, 7, 6, 2, -1, 4, 8, 10, 5 };
  
  public static ek m = new ek();
  
  public static ek n = new ek();
  
  public static ek o = new ek();
  
  public static ek p = new ek();
  
  public fo() {}
  
  public fo(short paramShort1, String paramString, byte paramByte1, byte paramByte2, byte paramByte3, short paramShort2, int[] paramArrayOfint, byte[] paramArrayOfbyte) {
    this.a = paramShort1;
    this.b = paramShort2;
    this.c = paramString;
    this.e = paramByte1;
    this.f = paramArrayOfint;
  }
  
  public fo(short paramShort1, short paramShort2, long paramLong, String paramString1, String paramString2, byte paramByte1, byte paramByte2, byte paramByte3, short paramShort3, boolean paramBoolean) {
    this.a = paramShort1;
    this.b = paramShort2;
    this.h = paramLong;
    this.c = paramString1;
    this.j = paramString2;
    this.i = paramByte1;
    this.g = paramByte2;
  }
  
  public static void a(int paramInt, es parames) {
    for (byte b = 0; b < parames.c(); b++) {
      bw bw;
      if ((bw = (bw)parames.a(b)).u == paramInt) {
        parames.d(bw);
        b--;
      } 
    } 
  }
  
  public static fo a(short paramShort) {
    fo fo1;
    if ((fo1 = (fo)o.a(paramShort)) == null) {
      fo1 = new fo();
      o.a(paramShort, fo1);
      q.a().f(paramShort);
    } 
    if (fo1.c == null) {
      fo1.q++;
      if (fo1.q >= 200) {
        q.a().f(paramShort);
        fo1.q = 0;
      } 
    } 
    return fo1;
  }
  
  public static fo b(short paramShort) {
    fo fo1;
    return fo1 = (fo)m.a(paramShort);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fo.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */