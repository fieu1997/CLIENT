import com.silverknight.TemMidlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class bs extends p {
  private int q = 0;
  
  public int a = 0;
  
  private int r = 10;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private static boolean v = true;
  
  public static boolean b = true;
  
  public static fi f;
  
  public static fi g;
  
  public static String h = "";
  
  public static String i = "";
  
  public static int j = 0;
  
  public static byte k = 1;
  
  public static aq l;
  
  public static String m;
  
  private String[] w;
  
  public static String n = null;
  
  public static int o = 0;
  
  public static int p;
  
  private bt x;
  
  private bt y;
  
  private bt z;
  
  private bt A;
  
  private bt B;
  
  private bt C;
  
  private bt D;
  
  private bt E;
  
  private bt F;
  
  private bt G;
  
  private bt H;
  
  private bt I;
  
  private bt J;
  
  private bt K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private boolean O = true;
  
  public bs() {
    this = this;
    if (ft.X < 240)
      this.q = 10; 
    this.u = ft.Z - 30 + this.q;
    if (ft.X - this.u < 160)
      this.u = ft.X - 160 + this.q + 20; 
    if (ft.A) {
      this.t = ft.Y + 40;
      this.r = 10;
      this.L = ft.Z - 50;
    } else {
      this.t = ft.W / 2;
    } 
    p = o.k.a(df.F);
    if (f.a || cd.a)
      b = false; 
    if (ft.M[ft.H] != 0)
      b = false; 
    if (this.t < 130)
      this.t = 130 + ft.Y / 2; 
    if (ft.A) {
      f = new fi(ft.Y - this.t / 2 + 15, this.L + this.r + this.r / 2, this.t - 30);
      g = new fi(ft.Y - this.t / 2 + 15, this.L + (this.r << 1) + this.r / 2 + f.d, this.t - 30, 40);
    } else {
      f = new fi(ft.Y - this.t / 2 + 15, this.u + this.r + this.r / 2, this.t - 30);
      g = new fi(ft.Y - this.t / 2 + 15, this.u + (this.r << 1) + this.r / 2 + f.d, this.t - 30);
    } 
    f.a(df.V);
    g.a(df.W);
    g.d(2);
    if (!ft.A)
      f.a(true); 
    this.x = new bt(df.fX, 0);
    this.A = new bt(df.fS, 1);
    this.B = new bt(df.fS, 1);
    this.E = new bt("OK", 2);
    this.F = new bt(df.X, 3);
    this.C = new bt(df.fX, 4);
    this.D = new bt(df.fY, 5, this);
    this.z = new bt(String.valueOf(df.fG) + ": " + dw.a[ft.H][0], 6, this);
    this.G = new bt(df.bW, 7, this);
    this.H = new bt(df.dH, 8, this);
    this.I = new bt(df.fF, 9, this);
    this.J = new bt(df.F, 23, this);
    this.y = new bt(String.valueOf(df.bR) + " Game", -1, this);
    if (ft.X < 240)
      this.q = -15; 
    this.w = o.i.a(df.bY, this.t - 20);
    a(false);
  }
  
  public final void c() {
    try {
      gb.a();
      o = ak.f(2);
      super.c();
      if (v) {
        byte[] arrayOfByte;
        if ((arrayOfByte = ak.a("local_server")) != null) {
          ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
          DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
          try {
            dataInputStream.readByte();
          } catch (IOException iOException) {
            (dataInputStream = null).printStackTrace();
          } 
        } 
        if ((arrayOfByte = ak.a("user_pass")) != null) {
          try {
            i();
          } catch (IOException iOException) {
            (arrayOfByte = null).printStackTrace();
          } 
          ft.o();
          if (h.length() > 0) {
            a(h, i);
          } else if (f.j().length() > 0) {
            a(f.j(), g.j());
          } 
        } 
      } else {
        byte[] arrayOfByte;
        if ((arrayOfByte = ak.a("user_pass")) != null)
          try {
            i();
          } catch (IOException iOException) {
            (arrayOfByte = null).printStackTrace();
          }  
      } 
      v = false;
      this.a = 0;
      j();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void k() {
    es es = new es();
    for (byte b = 0; b < df.gD.length; b++) {
      bt bt1 = new bt(df.gD[b], 24, b, this);
      es.a(bt1);
    } 
    ft.o.b(es, 2, df.e, false, null);
  }
  
  private static void a(String paramString1, String paramString2) {
    if (f.j().intern() == "doiip" && g.j().equals("master")) {
      ft.O = "http://hiepsionline.com/srvip2/";
      ft.a("Da doi ip thanh cong");
      return;
    } 
    q.a().a(paramString1, paramString2, k.a, "0", "0", "0", -1, (byte)-1);
    if (ck.a == null || dr.b == null)
      q.a().g((byte)61); 
  }
  
  public final void b() {
    f.a(df.V);
    g.a(df.W);
    f.i.a = df.U;
    g.i.a = df.U;
    this.x.a = df.fX;
    this.A.a = df.fS;
    this.B.a = df.fS;
    this.C.a = df.fX;
    this.E.a = "OK";
    if (!ft.A)
      this.F.a = df.X; 
    this.y.a = df.bR;
    this.G.a = df.bW;
    this.H.a = df.dH;
    this.I.a = df.fF;
    l();
    this.w = o.i.a(df.bY, this.t - 20);
  }
  
  public final void a(bx parambx) {
    gb.a(parambx);
    gb.b(parambx);
    if (this.O) {
      if (this.a != 1 && l != null)
        if (ft.A) {
          parambx.a(l, ft.Y, ft.Z - ft.Z / 2, 3);
        } else {
          parambx.a(l, ft.Y, ft.Z - 60 - ft.Z / 8, 3);
        }  
      gb.c(parambx);
      switch (this.a) {
        case 0:
          this.D.b(parambx, this.D.h, this.D.i);
          this.z.b(parambx, this.z.h, this.z.i);
          this.D.a(parambx, this.D.h, this.D.i - 6, 2);
          this.z.a(parambx, this.z.h, this.z.i - 6, 2);
          break;
        case 1:
          if (ft.A) {
            cg.a(parambx, ft.Y - this.t / 2, this.L - 5, this.t, this.s + 5, true, (byte)14);
          } else {
            cg.a(parambx, ft.Y - this.t / 2, this.u - 5, this.t, this.s + 5, true, (byte)14);
          } 
          f.a(parambx);
          g.a(parambx);
          this.G.a(parambx, this.G.h, this.G.i - 6, 3, 1);
          break;
      } 
    } 
    ft.a(parambx);
    o.k.a(parambx, "version: " + k.a, ft.W - 2, 2, 1, false);
    if (cf.W == 0) {
      parambx.a(cg.aB, 0, 0, 0);
    } else if (cf.W == 1) {
      cf.j(parambx);
    } 
    if (b) {
      o.k.a(parambx, df.F, ft.W, 15, 1, false);
      parambx.a(16514362);
      parambx.c(ft.W - p, 25, p, 1);
    } 
    super.a(parambx);
  }
  
  public final void a() {
    if (j < 20 && (j += 4) > 20)
      j = 20; 
    if (this.a != 0) {
      f.a();
      g.a();
    } else {
      l();
    } 
    if (ft.o.a) {
      this.O = false;
    } else {
      this.O = true;
    } 
    gb.b();
  }
  
  public final void d() {
    if (ft.al[8]) {
      if (f.f()) {
        f.a(false);
        if (!ft.A)
          g.a(true); 
      } else if (g.f()) {
        if (!ft.A)
          f.a(true); 
        g.a(false);
      } 
      ft.d(8);
    } else if (ft.al[2]) {
      if (f.f()) {
        f.a(false);
        if (!ft.A)
          g.a(true); 
      } else if (g.f()) {
        if (!ft.A)
          f.a(true); 
        g.a(false);
      } 
      ft.d(2);
    } 
    if (!ft.A)
      if (f.f()) {
        this.Z = f.b();
      } else if (g.f()) {
        this.Z = g.b();
      } else {
        this.Z = null;
      }  
    super.d();
  }
  
  public final void e() {
    if (this.a != 0) {
      f.g();
      g.g();
    } 
    if (this.a == 1) {
      this.G.b();
    } else if (this.a == 0) {
      this.z.b();
      this.D.b();
    } 
    super.e();
  }
  
  public final void a(int paramInt) {
    if (f.f()) {
      f.b(paramInt);
    } else if (g.f()) {
      g.b(paramInt);
    } 
    super.a(paramInt);
  }
  
  public static void g() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      dataOutputStream.writeUTF(f.j());
      dataOutputStream.writeUTF(g.j());
      ak.a("user_pass", byteArrayOutputStream.toByteArray());
      dataOutputStream.close();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void h() {
    try {
      byte[] arrayOfByte = { ft.H };
      ak.a("isIndexServer", arrayOfByte);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void i() {
    byte[] arrayOfByte;
    if ((arrayOfByte = ak.a("user_pass")) == null)
      return; 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
    f.b(dataInputStream.readUTF());
    g.b(dataInputStream.readUTF());
    String str;
    if ((str = f.j()).length() >= 10)
      str = str.substring(0, 10); 
    if (str.compareTo("knightauto") == 0) {
      h = f.j();
      i = g.j();
      f.b("");
      g.b("");
    } 
  }
  
  public final void j() {
    switch (this.a) {
      case 0:
        if (ft.X < 240)
          this.q = 10; 
        f.a(false);
        g.a(false);
        if (!ft.A) {
          this.Y = this.F;
        } else {
          this.Y = null;
        } 
        if (f.j().length() > 0) {
          this.aa = this.x;
          return;
        } 
        if (h.length() > 0) {
          this.aa = this.C;
          return;
        } 
        this.aa = this.A;
        return;
      case 1:
        if (!ft.A) {
          f.a(true);
          g.a(false);
        } 
        this.Y = this.B;
        this.aa = this.E;
        a(false);
        if (ft.X < 240)
          this.q = 10; 
        j = 0;
        return;
      case 2:
        this.Y = null;
        this.aa = null;
        break;
    } 
  }
  
  private void a(boolean paramBoolean) {
    this.s = (f.d << 1) + (this.r << 2);
    if (ft.A) {
      this.s += bt.k + 3;
    } else {
      this.s += ft.Z / 8;
    } 
    int i;
    if ((i = (this = this).u + this.s - bt.k / 2 - this.r) + bt.k / 2 > ft.X)
      i = ft.X - bt.k / 2; 
    int j;
    if ((j = this.L + this.s - bt.k / 2 - this.r) + bt.k / 2 > ft.X)
      j = ft.X - bt.k / 2; 
    this.M = 160;
    this.N = 25;
    if (ft.A) {
      this.E.a(ft.Y - bt.j / 2 - 5, j, (ce)null, this.E.a);
      int k = g.a + g.c - cg.aK.a / 2 - 10;
      this.G.a(k, j - 37, cg.aK, this.G.a);
      this.G.a(cg.aK, 2, 0);
      this.B.a(ft.Y + bt.j / 2 + 5, j, (ce)null, this.B.a);
      this.C.a(ft.Y - this.M / 2, i - 80, null, this.C.a, this.M, this.N);
      this.x.a(ft.Y - this.M / 2, i - 80, null, this.x.a, this.M, this.N);
      this.A.a(ft.Y - this.M / 2, i - 80, null, this.A.a, this.M, this.N);
      this.D.a(ft.Y - this.M / 2, i - 45, null, this.D.a, this.M, this.N);
      this.z.a(ft.Y - this.M / 2, i - 10, null, this.z.a, this.M, this.N);
      return;
    } 
    this.M = 140;
    this.D.a(ft.Y - this.M / 2, i - 60, null, this.D.a, this.M, this.N);
    this.z.a(ft.Y - this.M / 2, i - 20, null, this.z.a, this.M, this.N);
  }
  
  public final void b(int paramInt1, int paramInt2) {
    es es;
    switch (paramInt1) {
      case 0:
        ft.o();
        a(f.j(), g.j());
        bv.b = 0L;
        bv.c = false;
        bv.a = false;
        ah.k = false;
        return;
      case 1:
        ft.o();
        a("1", "1");
        return;
      case 2:
        this.a = 0;
        j();
        return;
      case 3:
        this = this;
        es = new es();
        if (this.a == 0) {
          if (!ft.A) {
            es.a(this.D);
            es.a(this.z);
            es.a(this.G);
            es.a(this.J);
          } 
          if (ft.B) {
            this.H.a = String.valueOf(df.cw) + df.dH;
          } else {
            this.H.a = String.valueOf(df.cv) + df.dH;
          } 
          es.a(this.H);
        } 
        es.a(this.y);
        ft.o.a(es, 2, df.cV, false, (es)null);
        return;
      case 4:
        ft.o();
        a(h, i);
        break;
    } 
  }
  
  public final void a_(int paramInt1, int paramInt2) {
    super.a_(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    String str;
    byte b;
    byte[] arrayOfByte;
    switch (paramInt1) {
      case -1:
        ft.c(df.bQ, new bt(df.bR, 10, this));
        break;
      case 5:
        this.a = 1;
        j();
        bv.b = 0L;
        bv.c = false;
        bv.a = false;
        ah.k = false;
        break;
      case 6:
        (ft.k = new dc()).c();
        bv.b = 0L;
        bv.c = false;
        bv.a = false;
        ah.k = false;
        break;
      case 7:
        str = null;
        if (f.a) {
          str = "http://ksatriaonline.indonaga.com/forum/app/index.php?for=event&do=changepass";
        } else if (ft.H == 2) {
          str = "http://forum.knightageonline.com/app/index.php?for=event&do=resetpass&lang=en";
        } else if (cd.a) {
          str = "http://knightandmagic.com/forum/app/index.php?for=event&do=resetpass";
        } else {
          str = "http://forum.knightageonline.com/app/index.php?for=event&do=resetpass&lang=store";
        } 
        ft.a(df.bU, str);
        break;
      case 8:
        b = (byte)((ft.B = !ft.B) ? 1 : 0);
        arrayOfByte = new byte[] { b };
        try {
          ak.a("isLowDevice", arrayOfByte);
        } catch (Exception exception) {
          (arrayOfByte = null).printStackTrace();
        } 
        break;
      case 9:
        ft.f();
        break;
      case 10:
        k.a();
        break;
      case 21:
        ft.c(String.valueOf(df.fN) + k.a + "\n" + df.fO, new bt(df.fP, 22, this));
        break;
      case 22:
        TemMidlet.b("http://teamobi.com/terms.htm");
        break;
      case 23:
        TemMidlet.b.d(df.E);
        break;
      case 24:
        if (paramInt2 == 0) {
          dw.a = dw.b;
          f.a = false;
          cd.a = false;
          ft.H = 6;
          dw.c = 0;
        } 
        if (paramInt2 == 1) {
          f.a = true;
          cd.a = false;
          f.a();
          dw.c = 1;
          ft.H = 1;
        } 
        if (paramInt2 == 2) {
          cd.a = true;
          f.a = false;
          cd.a();
          dw.c = 2;
          ft.H = 0;
        } 
        ak.b();
        u.b();
        l();
        this.K.a = df.e;
        break;
      case 25:
        k();
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  private void l() {
    if (this.z.a != String.valueOf(df.fG) + ": " + dw.a[ft.H][0])
      this.z.a = String.valueOf(df.fG) + ": " + dw.a[ft.H][0]; 
    if (ft.A) {
      if (f.j().length() > 0) {
        if (this.D.a != df.fZ)
          this.D.a = df.fZ; 
        if (f.j().length() > 13) {
          String str = null;
          if (!f.j().equals(m)) {
            str = String.valueOf(df.fX) + ": " + f.j().substring(0, 12) + "...";
          } else {
            str = df.fS;
          } 
          if (this.x.a != str)
            this.x.a = str; 
          if (this.C.a != str) {
            this.C.a = str;
            return;
          } 
        } else if (this.x.a != String.valueOf(df.fX) + ": " + f.j()) {
          this.x.a = String.valueOf(df.fX) + ": " + f.j();
          this.C.a = String.valueOf(df.fX) + ": " + f.j();
          return;
        } 
      } else if (h.length() > 0) {
        if (this.D.a != df.fZ) {
          this.D.a = df.fZ;
          return;
        } 
      } else if (this.D.a != df.fY) {
        this.D.a = df.fY;
        return;
      } 
    } else if (f.j().length() > 0) {
      if (f.j().length() > 8) {
        String str = String.valueOf(df.V) + ": " + f.j().substring(0, 8) + "...";
        if (this.D.a != str) {
          this.D.a = str;
          return;
        } 
      } else if (this.D.a != String.valueOf(df.V) + ": " + f.j()) {
        this.D.a = String.valueOf(df.V) + ": " + f.j();
        return;
      } 
    } else if (h.length() > 0) {
      if (this.D.a != df.fZ) {
        this.D.a = df.fZ;
        return;
      } 
    } else if (this.D.a != df.fY) {
      this.D.a = df.fY;
    } 
  }
  
  public final void a(byte paramByte) {
    try {
      h = f.j();
      i = g.j();
      if (h.length() > 0) {
        this.aa = this.C;
      } else {
        this.aa = this.A;
      } 
      byte[] arrayOfByte = ak.a("isIndexServer");
      byte b = paramByte;
      if (this != null)
        b = this[0]; 
      if (b == paramByte && (arrayOfByte = ak.a("user_pass")) != null) {
        try {
          i();
        } catch (IOException iOException) {
          (arrayOfByte = null).printStackTrace();
        } 
        ft.o();
        if (h.length() > 0) {
          a(h, i);
          return;
        } 
        if (f.j().length() > 0) {
          a(f.j(), g.j());
          return;
        } 
      } 
    } catch (Exception exception) {}
  }
  
  static {
    (new String[3])[0] = "anh Trí";
    (new String[3])[1] = "ku Ngân";
    (new String[3])[2] = "Server";
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bs.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */