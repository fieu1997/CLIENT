public final class er {
  public es a = new es("ChatDetail vecDetail");
  
  String b;
  
  String c;
  
  byte d = -1;
  
  boolean e = false;
  
  public fi f;
  
  public byte g = 0;
  
  int h = 0;
  
  private int i = 0;
  
  private byte j = 0;
  
  public er(String paramString, byte paramByte) {
    this.b = paramString;
    this.g = paramByte;
    if (this.g == 0) {
      this.f = new fi(ft.g.n + 5, ft.g.o + ft.g.m - fi.c() + 5, ft.g.l - 10);
    } else if (this.g == 2) {
      this.c = paramString;
      this.b = df.aW;
    } 
    if (paramString.compareTo(df.eV) == 0 || paramString.compareTo(df.cz) == 0 || paramString.compareTo(df.eU) == 0) {
      this.j = 1;
      return;
    } 
    this.j = 0;
  }
  
  public final void a(String paramString1, String paramString2) {
    if (paramString1.length() > 0) {
      String[] arrayOfString;
      bu[] arrayOfBu;
      if ((arrayOfBu = a(arrayOfString = o.j.a(paramString1, ft.g.l - (ft.g.d << 1) - 8), b(paramString2))) != null)
        for (byte b = 0; b < arrayOfBu.length; b++)
          this.a.a(arrayOfBu[b]);  
      a();
      if (this.h > 0 && ft.s != null && ft.s == ft.g && et.b != null && et.b == this)
        ft.g.a(arrayOfString.length); 
      if (et.b != null && et.b != this && this.b.compareTo(df.cz) != 0) {
        this.e = true;
        this.d = (byte)ak.c(1, 11);
      } 
    } 
  }
  
  public final void a(String paramString) {
    String str = "";
    if (this.f != null)
      str = this.f.j(); 
    if (str.length() > 0) {
      bu[] arrayOfBu;
      String[] arrayOfString;
      if ((arrayOfBu = a(arrayOfString = o.j.a(String.valueOf(cn.f.cB) + ": " + str, ft.g.l - (ft.g.d << 1) - 8), b(paramString))) != null)
        for (byte b = 0; b < arrayOfBu.length; b++)
          this.a.a(arrayOfBu[b]);  
      a();
      if (et.b != null && et.b == this)
        ft.g.a(arrayOfString.length); 
      q.a().a(this.b, str);
    } 
    if (this.f != null)
      this.f.b(""); 
  }
  
  public final void a() {
    this.h = this.a.c() * ft.ab - ft.g.m - fl.aM - 10 - ((this.g == 0) ? (fi.c() + 2) : 0);
    if (this.h < 0)
      this.h = 0; 
  }
  
  private static bu[] a(String[] paramArrayOfString, byte paramByte) {
    if (paramArrayOfString == null || paramArrayOfString.length == 0)
      return null; 
    bu[] arrayOfBu = new bu[paramArrayOfString.length];
    for (byte b = 0; b < paramArrayOfString.length; b++)
      arrayOfBu[b] = new bu(paramArrayOfString[b], paramByte); 
    return arrayOfBu;
  }
  
  private byte b(String paramString) {
    byte b = 0;
    if (this.j == 1) {
      b = (this.i % 2 == 0) ? 0 : 5;
      this.i++;
    } else if (paramString.compareTo(cn.f.cB) == 0) {
      b = 5;
    } else {
      b = 0;
    } 
    return b;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\er.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */