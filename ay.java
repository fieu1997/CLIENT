import java.util.Enumeration;

public final class ay {
  public static ek a = new ek();
  
  public long b;
  
  public aq c;
  
  private ay(int paramInt) {
    this.c = aq.a("/eff/g" + paramInt + ".png");
    if (this.c == null || this.c.a == null) {
      paramInt = paramInt;
      aq aq1 = new aq();
      q.a().a((byte)110, (short)paramInt);
      this.c = aq1;
    } 
    this.b = ft.aj;
  }
  
  public ay() {}
  
  public static aq a(int paramInt) {
    ay ay1;
    if ((ay1 = (ay)a.a(paramInt)) == null) {
      ay1 = new ay(paramInt);
      a.a(paramInt, ay1);
    } else {
      ay1.b = ft.aj;
    } 
    return ay1.c;
  }
  
  public static void a() {
    ek ek1;
    Enumeration enumeration = (ek1 = a).a.keys();
    while (enumeration.hasMoreElements()) {
      String str = enumeration.nextElement();
      ay ay1 = (ay)a.a(str);
      if ((ft.aj - ay1.b) / 1000L > 60L)
        a.a(str); 
    } 
  }
  
  public static void b() {
    ek ek1;
    (ek1 = a).a.clear();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ay.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */