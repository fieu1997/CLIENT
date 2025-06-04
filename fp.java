import java.util.Enumeration;

public final class fp {
  public static int a = 0;
  
  public static ek b = new ek();
  
  public static el a(short paramShort, int paramInt) {
    el el = (el)b.a((new StringBuffer(String.valueOf(paramShort))).toString());
    short s = paramShort;
    if (el == null) {
      el = new el();
      b.a((new StringBuffer(String.valueOf(paramShort))).toString(), el);
      if (el.a == null && paramShort >= 0)
        try {
          el.a = aq.a("/imgDataEff/" + s + ".png");
        } catch (Exception exception) {} 
      if (el.a == null && dw.a() / 1000L > 30L)
        q.a().a((byte)paramInt, (short)s); 
    } else {
      el.b = ft.aj;
    } 
    return el;
  }
  
  public static void b(short paramShort, int paramInt) {
    el el = (el)b.a((new StringBuffer(String.valueOf(paramShort))).toString());
    short s = paramShort;
    if (el == null) {
      el = new el();
      b.a((new StringBuffer(String.valueOf(paramShort))).toString(), el);
      if (el.a == null && paramShort >= 0)
        try {
          el.a = aq.a("/imgDataEff/" + s + ".png");
        } catch (Exception exception) {} 
      if (el.a == null && dw.a() / 1000L > 30L)
        q.a().a((byte)paramInt, (short)s); 
      el.b = (int)(dw.a() / 1000L);
    } 
  }
  
  public static void a() {
    ek ek1;
    Enumeration enumeration = (ek1 = b).a.keys();
    while (enumeration.hasMoreElements()) {
      String str = enumeration.nextElement();
      el el = (el)b.a(str);
      if ((ft.aj - el.b) / 1000L > 60L)
        b.a(str); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fp.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */