public final class em {
  public short a;
  
  public int b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public String g;
  
  public int h;
  
  public int i;
  
  public int j;
  
  public int k;
  
  public int l;
  
  public int m;
  
  public long n;
  
  public byte o = 0;
  
  public dv[] p = null;
  
  public boolean q = false;
  
  public em(int paramInt, short paramShort, String paramString, byte paramByte) {
    this.b = paramInt;
    this.a = paramShort;
    this.c = paramString.toUpperCase();
    this.o = paramByte;
  }
  
  public final void a(String paramString1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt, dv[] paramArrayOfdv) {
    this.d = paramString1;
    this.j = paramShort1;
    this.m = paramShort2;
    this.k = paramShort3;
    this.h = paramShort4;
    this.i = paramShort5;
    this.e = paramString2;
    this.g = paramString3;
    this.f = paramString4;
    this.n = paramLong;
    this.l = paramInt;
    this.p = paramArrayOfdv;
  }
  
  public final int a() {
    return (this.o == Byte.MAX_VALUE) ? 13 : ((this.o == 126) ? 7 : -1);
  }
  
  public static String a(byte paramByte) {
    return (paramByte >= 121 && paramByte <= Byte.MAX_VALUE) ? df.gw[127 - paramByte] : "";
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\em.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */