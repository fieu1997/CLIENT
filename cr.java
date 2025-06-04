import java.util.Enumeration;

public final class cr {
  public static ek a = new ek();
  
  public long b;
  
  public aq c;
  
  private cr(int paramInt) {
    this.c = aq.a("/effauto/eff_" + paramInt + ".png");
    if (this.c == null || this.c.a == null)
      this.c = dq.a(paramInt); 
    this.b = ft.aj;
  }
  
  public static void a() {
    ek ek1;
    Enumeration enumeration = (ek1 = a).a.keys();
    while (enumeration.hasMoreElements()) {
      String str = enumeration.nextElement();
      cr cr1 = (cr)a.a(str);
      if ((ft.aj - cr1.b) / 1000L > 60L)
        a.a(str); 
    } 
  }
  
  public static aq a(int paramInt) {
    cr cr1;
    if ((cr1 = (cr)a.a(paramInt)) == null) {
      cr1 = new cr(paramInt);
      a.a(paramInt, cr1);
      if (cr1.c == null)
        q.a().a((byte)111, (short)paramInt); 
    } else {
      cr1.b = ft.aj;
    } 
    return cr1.c;
  }
  
  public static void b() {
    ek ek1;
    (ek1 = a).a.clear();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cr.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */