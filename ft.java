import com.silverknight.a;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public final class ft {
  public static p a;
  
  private static u am;
  
  public static bs b;
  
  public static cn c;
  
  public static eg d;
  
  public static ck e;
  
  public static dn f;
  
  public static et g;
  
  public static ff h;
  
  public static x i;
  
  public static ep j;
  
  public static dc k;
  
  public static fw l;
  
  public static by m;
  
  public static az n;
  
  private bx an = new bx();
  
  public static fq o = new fq();
  
  public static cs p;
  
  public static ex q;
  
  public static da r;
  
  public static da s;
  
  public static eq t;
  
  public static eu u;
  
  public static eu v;
  
  public static eu w;
  
  private static eu ao;
  
  public static ec x;
  
  public static dz y;
  
  public static di z;
  
  public static boolean A;
  
  public static boolean B = false;
  
  public static boolean C = false;
  
  public static boolean D = true;
  
  public static byte E = 0;
  
  public static String F = "";
  
  public static byte G = -1;
  
  public static byte H = 6;
  
  public static short I = -1;
  
  public static long J;
  
  public static int K;
  
  public static int[] L = new int[] { 19129, 19129, 19129, 19129, 19129, 19129, 19129 };
  
  public static int[] M = new int[] { 0, 0, 1 };
  
  public static long N = 0L;
  
  public static String O = "http://knightageonline.com/srvip/";
  
  public static boolean P = false;
  
  public static boolean Q = false;
  
  public static boolean R = false;
  
  public static boolean S = false;
  
  public static boolean T = false;
  
  public static boolean U = false;
  
  public static boolean V = false;
  
  public static int W;
  
  public static int X;
  
  public static int Y;
  
  public static int Z;
  
  public static int aa = 25;
  
  public static int ab = 14;
  
  public static int ac;
  
  public static int ad = 0;
  
  public static int ae;
  
  public static int af;
  
  public static int ag;
  
  public static int ah;
  
  public static int ai;
  
  public static long aj = 0L;
  
  public static boolean[] ak = new boolean[30];
  
  private static boolean[] ap = new boolean[30];
  
  public static boolean[] al = new boolean[30];
  
  private static int aq;
  
  private static es ar;
  
  private static boolean as = false;
  
  private static long at = 0L;
  
  private static int au = 0;
  
  public ft() {
    E = 0;
    F = dw.c();
    fi.a(0);
    W = a.a;
    X = a.b;
    Y = W / 2;
    Z = X / 2;
    o.a();
    cd.a();
    f.a();
    if (W < 200 || X < 200) {
      C = true;
      if (bs.k == 1)
        bs.k = 2; 
      bt.j = 56;
    } 
    ac = 36;
    if (A) {
      ac = 40;
      ar = new es("GameCanvas listPoint");
      bt.k = 30;
      bt.j = 80;
      ah.d = 58;
    } else if (C) {
      ac = 30;
    } 
    z = new di();
    if (ak.a("isQty") != null)
      fi.h = true; 
    try {
      byte[] arrayOfByte;
      if ((arrayOfByte = ak.a("isLowDevice")) != null) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this);
        DataInputStream dataInputStream;
        byte b;
        if ((b = (dataInputStream = new DataInputStream(this)).readByte()) == 1) {
          B = true;
        } else {
          B = false;
        } 
      } 
    } catch (Exception exception) {}
    try {
      byte[] arrayOfByte;
      if ((arrayOfByte = ak.a("isIndexRes")) != null) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this);
        DataInputStream dataInputStream;
        G = (dataInputStream = new DataInputStream(this)).readByte();
      } 
    } catch (Exception exception) {}
    try {
      I = 0;
    } catch (Exception exception) {}
    H = 6;
    try {
      byte[] arrayOfByte;
      if ((arrayOfByte = ak.a("isIndexServer")) != null)
        H = this[0]; 
    } catch (Exception exception) {}
    if (f.a) {
      H = 1;
      try {
        byte[] arrayOfByte;
        if ((arrayOfByte = ak.a("isIndexServer")) != null)
          H = this[0]; 
      } catch (Exception exception) {}
    } 
    if (cd.a)
      H = 0; 
    ae.a();
    p.d = new aw();
    p.e = new aw();
    p = new cs();
    q = new ex();
    b = new bs();
    c = new cn();
    d = new eg();
    e = new ck();
    t = new eq();
    u = new eu();
    ao = new eu();
    g = new et();
    i = new x();
    h = new ff();
    ct.a();
    (am = new u()).c();
    dn.b();
  }
  
  public static void a() {
    b.b();
    c.h();
    eu.b();
    et.b();
    i.b();
    h.b();
    cn.p.b();
  }
  
  public final void a(bl parambl) {
    this.an.a = parambl.a;
    a.a(this.an);
    if (q()) {
      cn.q.e(this.an);
      cn.q.b(this.an);
    } 
    if (s != null)
      s.a(this.an); 
    if (r != null) {
      r.a(this.an);
    } else if (o.a) {
      o.b(this.an);
    } else if (d.b) {
      d.b().a(this.an);
    } 
    a(this.an);
    if (ad > 0) {
      this.an.a(0);
      this.an.c(0, 0, W, X);
    } 
  }
  
  private static boolean q() {
    return (a == ao || a == c || a == u || a == v || a == w || a == e || a == x || a == l || a == h || a == m || a == az.b() || a == ag.b());
  }
  
  public final void b() {
    if (++ai > 10000)
      ai = 0; 
    if (ai % 5 == 0)
      aj = dw.a(); 
    if (ad > 0)
      ad -= X / 10; 
    if (q()) {
      cn.q.e();
      cn.q.b();
      cn.q.d();
      cn.q.c();
    } 
    if (r != null) {
      r.a();
    } else if (o.a) {
      o.g();
      o.c();
    } else if (s != null) {
      s.a();
    } else if (d.b) {
      d.b().d();
      d.b().e();
    } else {
      a.d();
      a.e();
    } 
    a.a();
    U = false;
    if (cn.R > 0 && --cn.R == 0)
      cn.L = false; 
    if (at != 0L && dw.a() - at >= 600000L) {
      au = ak.f(df.gB.length);
      b(String.valueOf(df.gj) + df.gB[au]);
    } 
  }
  
  public static void a(bx parambx) {
    parambx.a(-parambx.a(), -parambx.b());
    parambx.a(0, 0);
    parambx.d(0, 0, W, X);
  }
  
  public static void a(String paramString) {
    ah ah;
    (ah = new ah()).a(paramString, new bt("Ok", -1), true);
    r = ah;
  }
  
  public static void a(String paramString, byte paramByte) {
    ah ah;
    (ah = new ah()).a(paramString, new bt("Ok", paramByte), true);
    r = ah;
  }
  
  public static void a(String paramString1, String paramString2) {
    ah ah;
    (ah = new ah()).a(paramString1, paramString2);
    r = ah;
  }
  
  public static void b(String paramString1, String paramString2) {
    ah ah;
    (ah = new ah()).a(paramString1, new bt(df.Z, -1), true, paramString2);
    r = ah;
  }
  
  public static void a(String paramString, bt parambt) {
    ah ah;
    (ah = new ah()).a(paramString, parambt);
    r = ah;
  }
  
  public static void a(String paramString, es parames) {
    ah ah;
    (ah = new ah()).a(paramString, parames);
    r = ah;
  }
  
  public static void b(String paramString, bt parambt) {
    ah ah;
    (ah = new ah()).a(paramString, parambt, true);
    r = ah;
  }
  
  public static void c(String paramString, bt parambt) {
    ah ah;
    (ah = new ah()).a(paramString, parambt, false);
    r = ah;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte paramByte) {
    ah ah;
    (ah = new ah()).a(paramString1, paramString2, paramInt1, paramInt2, paramByte);
    s = ah;
  }
  
  public static void a(ew paramew) {
    ah ah;
    (ah = new ah()).a(paramew);
    s = ah;
  }
  
  public static void c() {
    ah ah;
    (ah = new ah()).b();
    s = ah;
  }
  
  public static void d() {
    ah ah;
    (ah = new ah()).c();
    r = ah;
  }
  
  public static void e() {
    ah ah;
    (ah = new ah()).f();
    r = ah;
  }
  
  public static void f() {
    ah ah;
    (ah = new ah()).g();
    r = ah;
  }
  
  public static void g() {
    ah ah;
    (ah = new ah()).h();
    s = ah;
  }
  
  public static void h() {
    et.f();
    g.c();
    s = g;
  }
  
  public static void a(String[] paramArrayOfString, bt parambt, short paramShort1, short paramShort2, String paramString) {
    dy dy;
    (dy = new dy()).a(paramArrayOfString, parambt, paramShort1, (short)-1, paramString);
    s = dy;
  }
  
  public static void a(String[] paramArrayOfString1, bt parambt, short paramShort1, short paramShort2, String paramString, String[] paramArrayOfString2, byte paramByte) {
    j();
    dy dy;
    (dy = new dy()).a(paramArrayOfString1, parambt, paramShort1, paramShort2, paramString, paramArrayOfString2, paramByte);
    s = dy;
  }
  
  public static void a(String paramString1, String paramString2, j[] paramArrayOfj, byte paramByte1, byte paramByte2) {
    if (paramString2 != null && paramString2.trim().length() == 0)
      paramString2 = null; 
    ah ah;
    (ah = new ah()).a(paramString1, paramArrayOfj, paramString2, paramByte1, paramByte2);
    r = ah;
  }
  
  public static void i() {
    ah ah;
    (ah = new ah()).i();
    r = ah;
  }
  
  public static void a(ea paramea, byte paramByte) {
    ah ah;
    (ah = new ah()).a(paramea, paramByte);
    s = ah;
    if (paramea != null)
      q.a().c(fn.s, (short)paramea.O); 
  }
  
  public static void j() {
    r = null;
    s = null;
    m();
    l();
    if (cn.p.a >= 0)
      cn.p.c = 20; 
  }
  
  public static void k() {
    r = null;
  }
  
  public static void b(String paramString) {
    at = dw.a();
    au = 0;
    if (paramString != null && paramString.length() > 0)
      cn.j.a(paramString); 
  }
  
  public static void c(String paramString) {
    if (paramString != null && paramString.length() > 0) {
      if (o.i.a(paramString) > 140) {
        if ((paramString = paramString) != null && paramString.length() > 0)
          cn.k.a(paramString); 
        return;
      } 
      cn.q.G = paramString;
      cn.q.d = 10;
      cn.q.c = 0;
    } 
  }
  
  public final void a(int paramInt) {
    if (fi.h && ((paramInt >= 48 && paramInt <= 57) || (paramInt >= 65 && paramInt <= 122) || paramInt == 10 || paramInt == 8 || paramInt == 13 || paramInt == 32))
      aq = paramInt; 
    int i = paramInt;
    cf.M = true;
    if (r != null) {
      r.e(i);
    } else if (s != null) {
      s.e(i);
    } else if (d.b) {
      d.b().a(i);
    } else {
      a.a(i);
    } 
    if (fi.h)
      if (aq == 114 || aq == 82) {
        al[21] = true;
        ak[21] = true;
      } else if (aq == 116 || aq == 84) {
        al[23] = true;
        ak[23] = true;
      } else if (aq == 121 || aq == 89) {
        al[25] = true;
        ak[25] = true;
      } else if (aq == 117 || aq == 85) {
        al[27] = true;
        ak[27] = true;
      } else if (aq == 105 || aq == 73) {
        al[29] = true;
        ak[29] = true;
      }  
    switch (i) {
      case -1:
        al[2] = true;
        ak[2] = true;
        return;
      case -2:
        al[8] = true;
        ak[8] = true;
        return;
      case -3:
        al[4] = true;
        ak[4] = true;
        return;
      case -4:
        al[6] = true;
        ak[6] = true;
        return;
      case -5:
      case 10:
        al[5] = true;
        ak[5] = true;
        return;
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
        al[i - 28] = true;
        ak[i - 28] = true;
        return;
      case 42:
        al[10] = true;
        ak[10] = true;
        return;
      case 35:
        al[11] = true;
        ak[11] = true;
        return;
      case -6:
        al[12] = true;
        ak[12] = true;
        return;
      case -7:
        al[13] = true;
        ak[13] = true;
        break;
    } 
  }
  
  public final void b(int paramInt) {
    if (fi.h)
      aq = 0; 
    int i;
    switch (i = paramInt) {
      case -1:
        al[2] = false;
        ak[2] = false;
        return;
      case -2:
        al[8] = false;
        ak[8] = false;
        return;
      case -3:
        al[4] = false;
        ak[4] = false;
        return;
      case -4:
        al[6] = false;
        ak[6] = false;
        return;
      case -5:
      case 10:
        al[5] = false;
        ak[5] = false;
        return;
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
        al[i - 28] = false;
        return;
      case 42:
        al[10] = false;
        return;
      case 35:
        al[11] = false;
        return;
      case -6:
        al[12] = false;
        return;
      case -7:
        al[13] = false;
        break;
    } 
  }
  
  public static void a(int paramInt1, int paramInt2) {
    ae = paramInt1 / bx.b;
    af = paramInt2 / bx.b;
    if (T) {
      ar.a(new de(paramInt1, paramInt2));
      return;
    } 
    if (ak.e(ae - ag) >= 15 || ak.e(af - ah) >= 15)
      T = true; 
  }
  
  public static void b(int paramInt1, int paramInt2) {
    cf.M = true;
    Q = true;
    T = false;
    S = false;
    R = false;
    V = false;
    if (a == r.b())
      U = true; 
    ag = paramInt1 / bx.b;
    ah = paramInt2 / bx.b;
    ae = paramInt1 / bx.b;
    af = paramInt2 / bx.b;
  }
  
  public static void c(int paramInt1, int paramInt2) {
    if (!T && !V)
      S = true; 
    m();
    l();
    Q = false;
    R = true;
    T = false;
    U = true;
    V = false;
    ae = paramInt1 / bx.b;
    af = paramInt2 / bx.b;
  }
  
  public static void l() {
    R = false;
    Q = false;
    for (byte b = 0; b < 30; b++)
      ak[b] = false; 
  }
  
  public static void c(int paramInt) {
    R = false;
    Q = false;
    ak[paramInt] = false;
  }
  
  public static void m() {
    R = false;
    Q = false;
    for (byte b = 0; b < 30; b++)
      al[b] = false; 
  }
  
  public static void d(int paramInt) {
    R = false;
    Q = false;
    al[paramInt] = false;
  }
  
  public static void n() {
    m();
    l();
    Q = false;
    R = false;
    for (byte b = 0; b < 30; b++)
      ap[b] = false; 
    S = false;
    T = false;
    U = false;
    Q = false;
  }
  
  public static void o() {
    if (!l.a().b()) {
      String str = dw.a[H][1];
      char c = '䪹';
      if (f.a && H == 1)
        c = '䪺'; 
      l.a().a(str, c);
    } 
  }
  
  public static int p() {
    return (int)(dw.a() / 1000L);
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (!Q && !R) ? false : c(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return !S ? false : c(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (ae >= paramInt1 && ae <= paramInt1 + paramInt3 && af >= paramInt2 && af <= paramInt2 + paramInt4);
  }
  
  public static boolean d(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (ag >= paramInt1 && ag <= paramInt1 + paramInt3 && ah >= paramInt2 && ah <= paramInt2 + paramInt4);
  }
  
  public static boolean e(int paramInt) {
    switch (paramInt) {
      case 1:
        if (al[2] || al[22])
          return true; 
        break;
      case 0:
        if (al[8] || al[28])
          return true; 
        break;
      case 2:
        if (al[4] || al[24])
          return true; 
        break;
      case 3:
        if (al[6] || al[26])
          return true; 
        break;
    } 
    return false;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ft.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */