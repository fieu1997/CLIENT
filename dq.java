import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Enumeration;

public final class dq extends z {
  private bc n;
  
  private int o = 0;
  
  private boolean p = true;
  
  private boolean q = false;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private long u;
  
  public boolean a;
  
  private int v = -1;
  
  private int w = -1;
  
  private static long x = 0L;
  
  private static long y = 0L;
  
  private static long z = 0L;
  
  private static long A = 0L;
  
  private long B;
  
  private short C;
  
  private byte D = 0;
  
  public static ek b = new ek();
  
  private int E;
  
  private int F;
  
  private byte G;
  
  public dq(String paramString) {
    this.c = 1;
    String[] arrayOfString = o.a(paramString, ";");
    this.d = Short.parseShort(arrayOfString[0]);
    this.e = Short.parseShort(arrayOfString[1]);
    this.h = Integer.parseInt(arrayOfString[2]) * cs.l;
    this.i = Integer.parseInt(arrayOfString[3]) * cs.l;
    this.f = Integer.parseInt(arrayOfString[4]);
    this.g = Integer.parseInt(arrayOfString[5]);
    this.r = Integer.parseInt(arrayOfString[6]);
    this.s = Integer.parseInt(arrayOfString[7]);
    this.j = 70;
    this.k = 70;
    b((byte[])null);
  }
  
  public dq(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.c = 1;
    this.d = (short)paramInt1;
    this.e = (short)paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.f = paramInt4;
    this.g = paramInt5;
    this.r = paramInt6;
    this.s = paramInt7;
    this.j = 70;
    this.k = 70;
    this.E = 0;
    this.F = 0;
    b((byte[])null);
  }
  
  public dq(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfbyte, long paramLong, byte paramByte, int paramInt8, int paramInt9) {
    this.D = 1;
    this.c = 2;
    this.d = (short)paramInt1;
    this.e = (short)paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.f = paramInt4;
    this.g = paramInt5;
    this.r = paramInt6;
    this.s = paramInt7;
    this.j = 70;
    this.k = 70;
    this.B = paramLong;
    this.G = paramByte;
    this.E = paramInt8;
    this.F = paramInt9;
    a(paramArrayOfbyte);
  }
  
  public dq(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfbyte) {
    this.D = 1;
    this.c = 1;
    this.d = (short)paramInt1;
    this.e = (short)paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.f = 0;
    this.g = 0;
    this.r = paramInt6;
    this.s = 0;
    this.j = 70;
    this.k = 70;
    this.E = 0;
    this.F = 0;
    a(paramArrayOfbyte);
  }
  
  public dq(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte) {
    this.D = 1;
    this.c = 3;
    this.d = (short)paramInt1;
    this.e = (short)paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = 70;
    this.k = 70;
    this.E = 0;
    this.F = 0;
    a(paramArrayOfbyte);
  }
  
  private byte[] f() {
    byte[] arrayOfByte = null;
    try {
      byte[] arrayOfByte1;
      if ((arrayOfByte1 = ak.a("data_eff" + this.e)) != null) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this);
        DataInputStream dataInputStream;
        arrayOfByte = new byte[(dataInputStream = new DataInputStream(this)).readShort()];
        read(arrayOfByte);
        close();
      } 
    } catch (Exception exception) {}
    return arrayOfByte;
  }
  
  public dq(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfbyte, short paramShort) {
    this.D = 1;
    this.c = 1;
    this.d = (short)paramInt1;
    this.e = (short)paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.f = 0;
    this.g = 0;
    this.r = paramInt6;
    this.s = 5;
    this.j = 70;
    this.k = 70;
    this.E = 0;
    this.F = 0;
    this.C = paramShort;
    a(paramArrayOfbyte);
  }
  
  private void a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0) {
      this.n = a(this.e, paramArrayOfbyte);
      this.u = ft.aj;
      this.p = true;
      this.q = true;
      g();
      return;
    } 
    cb cb;
    if ((cb = (cb)b.a(this.e)) == null) {
      byte[] arrayOfByte;
      if ((arrayOfByte = f()) != null && arrayOfByte.length > 0) {
        byte[] arrayOfByte1 = arrayOfByte;
        cb cb1;
        (cb1 = cb = new cb(this.e)).a = arrayOfByte1;
        b.a((new StringBuffer(String.valueOf(this.e))).toString(), cb);
        this.n = a(this.e, cb.a);
        this.u = ft.aj;
        this.p = true;
        this.q = true;
        cb.b = (int)(dw.a() / 1000L);
        g();
      } else {
        cb = new cb(this.e);
        b.a((new StringBuffer(String.valueOf(this.e))).toString(), cb);
        cr.a(this.e);
        cb.b = (int)(dw.a() / 1000L);
      } 
    } 
    if (cb != null && cb.a != null && cb.a.length > 0) {
      this.n = a(this.e, cb.a);
      this.u = ft.aj;
      this.p = true;
      this.q = true;
      g();
    } 
  }
  
  private void b(byte[] paramArrayOfbyte) {
    this.n = a(this.e, null);
    this.u = ft.aj;
    this.p = true;
    this.q = true;
    g();
  }
  
  private void b(bx parambx) {
    if (this.D == 1 && !this.q) {
      a((byte[])null);
      return;
    } 
    try {
      if (this.n != null && this.p) {
        short s = this.n.d[this.t];
        int i = (this.n.c[s]).a.length;
        for (byte b = 0; b < i; b++) {
          fg fg = (fg)this.n.b.a(((this.n.c[s]).a[b]).c);
          aq aq = cr.a(this.e);
          if (fg != null && aq != null && aq.a != null)
            parambx.a(aq, fg.a, fg.b, fg.c, fg.d, 0, this.h + this.f + ((this.n.c[s]).a[b]).a, this.i + this.g + ((this.n.c[s]).a[b]).b, 0); 
        } 
        return;
      } 
    } catch (Exception exception) {
      dw.a("paint effauto null img1: " + exception.toString());
      this.p = false;
      this.q = false;
    } 
  }
  
  public final void a(bx parambx) {
    if (this.D == 1 && !this.q) {
      a((byte[])null);
      return;
    } 
    if (this.c == 3) {
      try {
        if (this.n != null && this.p) {
          short s = this.n.d[this.t];
          int i = (this.n.c[s]).a.length;
          for (byte b = 0; b < i; b++) {
            fg fg = (fg)this.n.b.a(((this.n.c[s]).a[b]).c);
            aq aq = cr.a(this.e);
            if (fg != null && aq != null && aq.a != null)
              parambx.a(aq, fg.a, fg.b, fg.c, fg.d, 0, this.h + this.f + ((this.n.c[s]).a[b]).a, this.i + this.g + ((this.n.c[s]).a[b]).b, 0); 
          } 
          return;
        } 
      } catch (Exception exception) {
        dw.a("paint effauto null img1: " + exception.toString());
        this.p = false;
        this.q = false;
      } 
      return;
    } 
    if (this.c == 4) {
      b(parambx);
      return;
    } 
    if ((ft.B || !this.q || cs.i == cs.j) && !cf.j())
      return; 
    try {
      if (this.n != null && this.p) {
        short s = this.n.d[this.t];
        int i = (this.n.c[s]).a.length;
        for (byte b = 0; b < i; b++) {
          fg fg = (fg)this.n.b.a(((this.n.c[s]).a[b]).c);
          aq aq = cr.a(this.e);
          if (fg != null && aq != null && aq.a != null)
            parambx.a(aq, fg.a, fg.b, fg.c, fg.d, 0, this.h + this.f + ((this.n.c[s]).a[b]).a, this.i + this.g + ((this.n.c[s]).a[b]).b, 0); 
        } 
        return;
      } 
    } catch (Exception exception) {
      dw.a("paint effauto null img1: " + this.e + " " + exception.toString() + " " + this.n.d.length);
      this.p = false;
      this.q = false;
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    if (this.D == 1 && !this.q) {
      a((byte[])null);
      return;
    } 
    if (ft.B || !this.q || cs.i == cs.j)
      return; 
    try {
      if (this.n != null && this.p) {
        short s = this.n.d[this.t];
        int i = (this.n.c[s]).a.length;
        for (byte b = 0; b < i; b++) {
          fg fg = (fg)this.n.b.a(((this.n.c[s]).a[b]).c);
          aq aq = cr.a(this.e);
          if (fg != null && aq != null && aq.a != null)
            parambx.a(aq, fg.a, fg.b, fg.c, fg.d, 0, paramInt1 + this.f + ((this.n.c[s]).a[b]).a + this.E, paramInt2 + this.g + ((this.n.c[s]).a[b]).b + this.F, 0); 
        } 
        return;
      } 
    } catch (Exception exception) {
      dw.a("paint effauto null img " + this.e + " " + exception.toString());
      this.p = false;
      this.q = false;
    } 
  }
  
  public final boolean c() {
    return (this.B - dw.a() > 0L && this.G == 1);
  }
  
  public final boolean d() {
    return (this.B - dw.a() > 0L && this.G == 2);
  }
  
  public final void a() {
    if (this.D == 1 && !this.q)
      return; 
    try {
      if (this.c == 3) {
        this.t++;
        if (this.t >= this.n.d.length - 1) {
          this.t = 0;
          this.a = true;
        } 
        return;
      } 
      if ((ft.B || !this.q || cs.i == cs.j) && !cf.j())
        return; 
      if (this.c == 2 && this.B - dw.a() < 0L)
        this.a = true; 
      if (this.e == 51) {
        this.t++;
        if (this.t >= this.n.d.length - 1)
          this.t = this.n.d.length - 1; 
      } else if (this.t >= this.n.d.length - 1) {
        switch (this.r) {
          case 0:
            this.o++;
            this.p = false;
            if (this.o >= this.s) {
              this.o = 0;
              this.p = true;
              this.t = 0;
            } 
            break;
          case 1:
            this.t = 0;
            break;
          case 2:
            this.p = false;
            if (ft.ai % 5 == 0 && (ft.aj - this.u) / 1000L > this.s) {
              this.u = ft.aj;
              this.t = 0;
              this.p = true;
            } 
            break;
          case 3:
            if (this.C > 0 && ak.f(this.s) == 0) {
              this.C = (short)(this.C - 1);
              this.t = 0;
              break;
            } 
            if (this.C <= 0) {
              this.a = true;
              this.p = false;
              this.q = false;
            } 
            break;
          case 4:
            if (ak.f(this.s) == 0) {
              this.t = 0;
              if (this.v < 0 || ak.f(this.w) != 0 || b());
            } 
            break;
        } 
      } else {
        this.t++;
      } 
    } catch (Exception exception) {
      dw.a("eff=" + this.e + exception.toString());
      this.p = false;
      this.q = false;
    } 
    if ((this = this).v == 48) {
      if (ak.f(this.w) == 0 && b())
        return; 
    } else if (this.v == 49) {
      if (this.t == 35 || this.t == 43) {
        if (b())
          return; 
      } else if (this.t == 125 && b()) {
        return;
      } 
    } else if (this.v == 52) {
      if (this.t == 50 && b())
        return; 
    } else if (this.v == 54) {
      if (this.t % 5 == 0 && b() && (ft.aj - z) / 100L > 48L) {
        z = ft.aj;
        return;
      } 
    } else if (this.v == 53) {
      if (this.t % 5 == 0 && b() && (ft.aj - x) / 100L > 68L && ft.a == ft.c) {
        x = ft.aj;
        return;
      } 
    } else if (this.v == 55) {
      if (this.t % 5 == 0 && b() && (ft.aj - y) / 100L > 28L) {
        y = ft.aj;
        return;
      } 
    } else if (this.v == 50) {
      if (this.t == 30 && b())
        return; 
    } else if (this.v == 56 && this.t % 5 == 0 && b() && (ft.aj - A) / 100L > 48L) {
      A = ft.aj;
    } 
  }
  
  private static bc a(int paramInt, byte[] paramArrayOfbyte) {
    bc bc1;
    if ((bc1 = (bc)bc.a.a(paramInt)) == null) {
      bc1 = new bc(paramInt, paramArrayOfbyte);
      bc.a.a((new StringBuffer(String.valueOf(paramInt))).toString(), bc1);
    } 
    return bc1;
  }
  
  public static aq a(int paramInt) {
    aq aq = new aq();
    q.a().a((byte)111, (short)paramInt);
    return aq;
  }
  
  private void g() {
    switch (this.e) {
      case 7:
        this.v = 48;
        this.w = 200;
        return;
      case 29:
        this.v = 47;
        this.w = 3;
        return;
      case 11:
        this.v = 49;
        this.w = 2;
        return;
      case 9:
      case 12:
        this.v = 52;
        this.w = 2;
        return;
      case 28:
        this.v = 54;
        this.w = 2;
        return;
      case 0:
      case 15:
      case 17:
      case 18:
      case 30:
      case 32:
        this.v = 53;
        this.w = 2;
        return;
      case 19:
      case 20:
      case 31:
        this.v = 55;
        this.w = 2;
        return;
      case 6:
        this.v = 50;
        this.w = 2;
        return;
      case 22:
        this.v = 56;
        this.w = 2;
        break;
    } 
  }
  
  public final void b(int paramInt) {
    this.l = (short)paramInt;
  }
  
  public static void e() {
    ek ek1;
    Enumeration enumeration = (ek1 = b).a.keys();
    while (enumeration.hasMoreElements()) {
      String str = enumeration.nextElement();
      cb cb = (cb)b.a(str);
      if ((ft.aj - cb.b) / 1000L > 60L)
        b.a(str); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dq.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */