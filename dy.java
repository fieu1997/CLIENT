public final class dy extends da {
  public fi a;
  
  private bt b = new bt(df.Z, -1);
  
  private fi[] c;
  
  private boolean d = false;
  
  private boolean e;
  
  private boolean f = false;
  
  private long g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private short k = 0;
  
  private short r = -1;
  
  private static int s = 0;
  
  private static int t = 0;
  
  private static int u;
  
  private o v = o.j;
  
  private bp w;
  
  private String x;
  
  private int y = 0;
  
  public dy() {
    t = 15;
    if (ft.A)
      s = bt.k + 5; 
  }
  
  private static void c() {
    if (ft.r != null) {
      ft.r = null;
      return;
    } 
    ft.s = null;
  }
  
  public final void b(int paramInt1, int paramInt2) {
    String[] arrayOfString;
    boolean bool;
    byte b1;
    es es;
    byte b2;
    switch (paramInt1) {
      case -1:
        c();
        break;
      case 0:
        arrayOfString = new String[this.c.length];
        for (b1 = 0; b1 < arrayOfString.length; b1++) {
          arrayOfString[b1] = "";
          if (this.c[b1].j().length() > 0)
            arrayOfString[b1] = this.c[b1].j(); 
        } 
        q.a().a(this.k, arrayOfString);
        ft.a(df.aG, new bt(df.Z, -1));
        break;
      case 1:
        es = new es();
        bool = (this.r == cn.a) ? true : false;
        for (b2 = 0; b2 < this.c.length; b2++) {
          String str = "";
          if (this.c[b2].j().length() > 0)
            str = this.c[b2].j(); 
          es.a(str);
        } 
        if (bool) {
          es.a(dw.e());
          es.a(dw.d());
        } 
        q.a().a(this.r, this.k, es);
        c();
        break;
    } 
    super.b(paramInt1, paramInt2);
  }
  
  public final void a(String paramString1, bt parambt, boolean paramBoolean, String paramString2) {
    this.d = false;
    this.f = false;
    this.Y = null;
    this.Z = null;
    this.aa = null;
    if (parambt == null)
      ft.r = null; 
    this.l = ft.W - 30;
    if (this.l > 200)
      this.l = 200; 
    this.q = this.v.a(paramString1, this.l - 20);
    this.h = paramString2;
    this.m = 15 * this.q.length + 10 + fi.c() + ft.aa;
    this.m += s + t;
    this.n = ft.Y - this.l / 2;
    this.o = ft.X - (ft.aa << 1) - this.m + 15;
    this.a = new fi(this.n + 10, this.o + this.m - s - fi.c() + 8, this.l - 20);
    this.a.c(100);
    if (paramBoolean)
      this.a.d(1); 
    this.a.b("");
    if (ft.A) {
      parambt.a(this.n + this.l / 2, this.o + this.m - bt.k / 2 - 5, (ce)null, parambt.a);
      this.b.a(this.n + this.l - 13, this.o + 10, cf.t, "");
      this.Z = this.b;
      this.Y = parambt;
      this.a.j = paramString1;
      return;
    } 
    this.aa = parambt;
    this.Y = this.b;
    this.a.a(true);
    this.Z = this.a.i;
  }
  
  public final void a(String[] paramArrayOfString1, bt parambt, short paramShort1, short paramShort2, String paramString, String[] paramArrayOfString2, byte paramByte) {
    this.d = true;
    this.f = false;
    this.Y = null;
    this.Z = null;
    this.aa = null;
    this.c = null;
    u = 50;
    this.k = paramShort1;
    this.r = paramShort2;
    if (parambt == null)
      ft.s = null; 
    this.l = ft.W - 30;
    if (this.l > 140)
      this.l = 140; 
    this.c = new fi[paramArrayOfString1.length];
    this.q = paramArrayOfString1;
    this.h = paramString;
    if (this.c.length > 3)
      this.e = true; 
    if (this.e) {
      this.l = ft.W / 4 * 3;
      this.m = ft.X / 5 << 2;
      this.l = ft.W - 30;
      if (this.l > 140)
        this.l = 140; 
      if (this.m < 210) {
        this.m = 210;
      } else if (this.m > 280) {
        this.m = 280;
      } 
      if (this.m < 210) {
        this.m = 210;
      } else if (this.m > 280) {
        this.m = 280;
      } 
      this.n = ft.Y - this.l / 2;
      this.o = ft.Z - this.m / 2;
      if (this.o < 20)
        this.o = 20; 
      if (ft.C)
        this.o = 0; 
    } else {
      this.m = (fi.c() + 18) * this.q.length + 6 + ft.aa;
      this.m += s + t;
      this.n = ft.Y - this.l / 2;
      this.o = ft.X - (ft.aa << 1) - this.m + 15;
    } 
    for (paramShort1 = 0; paramShort1 < this.c.length; paramShort1++) {
      this.c[paramShort1] = new fi(this.n + 10, this.o + 8 + (fi.c() + 18) * paramShort1 + t + ft.aa, this.l - 20);
      this.c[paramShort1].b("");
    } 
    if (ft.A) {
      parambt.a(this.n + this.l / 2, this.o + this.m - bt.k / 2 - 5, (ce)null, parambt.a);
      this.b.a(this.n + this.l - 13, this.o + 10, cf.t, "");
      if (ft.a != ft.j)
        this.Z = this.b; 
      this.Y = parambt;
    } else {
      this.aa = parambt;
      this.Y = this.b;
    } 
    if (!ft.A) {
      this.c[0].a(true);
      this.Z = (this.c[0]).i;
    } 
    if (this.e) {
      p.e.a(0, this.c.length * u - this.m + ft.aa + 30, 0, 0);
      this.w = new bp(this.n, this.o, this.l, this.m, u, 0, p.e.f);
    } 
    if (paramByte == 0)
      for (paramShort1 = 0; paramShort1 < this.c.length; paramShort1++)
        this.c[paramShort1].a(paramArrayOfString1[paramShort1]);  
    for (paramShort1 = 0; paramShort1 < this.c.length; paramShort1++)
      this.c[paramShort1].b(paramArrayOfString2[paramShort1]); 
  }
  
  public final void a(String[] paramArrayOfString, bt parambt, short paramShort1, short paramShort2, String paramString) {
    this.d = true;
    this.f = false;
    this.Y = null;
    this.Z = null;
    this.aa = null;
    this.c = null;
    u = 50;
    this.k = paramShort1;
    this.r = paramShort2;
    if (parambt == null)
      ft.s = null; 
    this.l = ft.W - 30;
    if (this.l > 140)
      this.l = 140; 
    this.c = new fi[paramArrayOfString.length];
    this.q = paramArrayOfString;
    this.h = paramString;
    if (this.c.length > 3)
      this.e = true; 
    if (this.e) {
      this.l = ft.W / 4 * 3;
      this.m = ft.X / 5 << 2;
      this.l = ft.W - 30;
      if (this.l > 140)
        this.l = 140; 
      if (this.m < 210) {
        this.m = 210;
      } else if (this.m > 280) {
        this.m = 280;
      } 
      if (this.m < 210) {
        this.m = 210;
      } else if (this.m > 280) {
        this.m = 280;
      } 
      this.n = ft.Y - this.l / 2;
      this.o = ft.Z - this.m / 2;
      if (this.o < 20)
        this.o = 20; 
      if (ft.C)
        this.o = 0; 
    } else {
      this.m = (fi.c() + 18) * this.q.length + 6 + ft.aa;
      this.m += s + t;
      this.n = ft.Y - this.l / 2;
      this.o = ft.X - (ft.aa << 1) - this.m + 15;
    } 
    for (byte b = 0; b < this.c.length; b++) {
      this.c[b] = new fi(this.n + 10, this.o + 8 + (fi.c() + 18) * b + t + ft.aa, this.l - 20);
      this.c[b].b("");
    } 
    if (ft.A) {
      parambt.a(this.n + this.l / 2, this.o + this.m - bt.k / 2 - 5, (ce)null, parambt.a);
      this.b.a(this.n + this.l - 13, this.o + 10, cf.t, "");
      this.Z = this.b;
      this.Y = parambt;
    } else {
      this.aa = parambt;
      this.Y = this.b;
    } 
    if (!ft.A) {
      this.c[0].a(true);
      this.Z = (this.c[0]).i;
    } 
    if (this.e) {
      p.e.a(0, this.c.length * u - this.m + ft.aa + 30, 0, 0);
      this.w = new bp(this.n, this.o, this.l, this.m, u, 0, p.e.f);
    } 
  }
  
  public final void a(String paramString1, bt parambt, boolean paramBoolean, int paramInt, long paramLong, String paramString2) {
    this.d = false;
    this.f = true;
    this.Y = null;
    this.Z = null;
    this.aa = null;
    if (parambt == null)
      ft.r = null; 
    this.g = 0L;
    this.i = paramString1;
    this.h = "";
    this.j = paramString2;
    this.l = ft.W / 3 << 1;
    if (this.l > 160)
      this.l = 160; 
    String str = "";
    this.q = this.v.a(String.valueOf(paramString1) + " " + str, this.l - 20);
    this.m = 15 * this.q.length + 10 + fi.c() + ft.aa;
    this.m += s + t;
    this.n = ft.Y - this.l / 2;
    this.o = ft.X - (ft.aa << 1) - this.m + 15;
    int i;
    if ((i = this.l - 100) < 40)
      i = 40; 
    this.a = new fi(this.n + this.l / 2 - i / 2, this.o + this.m - s - fi.c() + 8, i);
    this.x = this.a.j();
    if (ft.A) {
      parambt.a(this.n + this.l / 2, this.o + this.m - bt.k / 2 - 5, (ce)null, parambt.a);
      this.b.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      this.Z = this.b;
      this.Y = parambt;
      return;
    } 
    this.aa = parambt;
    this.Y = this.b;
    this.a.a(true);
    this.Z = this.a.i;
  }
  
  public final void a(String paramString1, bt parambt, boolean paramBoolean, int paramInt, long paramLong, String paramString2, String paramString3) {
    this.d = false;
    this.f = true;
    this.Y = null;
    this.Z = null;
    this.aa = null;
    if (parambt == null)
      ft.r = null; 
    this.g = paramLong;
    this.i = paramString1;
    this.h = paramString2;
    this.j = paramString3;
    this.l = ft.W / 3 << 1;
    if (this.l > 160)
      this.l = 160; 
    String str = "\n" + df.ba + " " + paramLong + " " + paramString3;
    this.q = this.v.a(String.valueOf(paramString1) + " " + str, this.l - 20);
    this.m = 15 * this.q.length + 10 + fi.c() + ft.aa;
    this.m += s + t;
    this.n = ft.Y - this.l / 2;
    this.o = ft.X - (ft.aa << 1) - this.m + 15;
    int i;
    if ((i = this.l - 100) < 40)
      i = 40; 
    this.a = new fi(this.n + this.l / 2 - i / 2, this.o + this.m - s - fi.c() + 8, i);
    this.a.d(1);
    this.x = this.a.j();
    if (ft.A) {
      parambt.a(this.n + this.l / 2, this.o + this.m - bt.k / 2 - 5, (ce)null, parambt.a);
      this.b.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      this.Z = this.b;
      this.Y = parambt;
      return;
    } 
    this.aa = parambt;
    this.Y = this.b;
    this.a.a(true);
    this.Z = this.a.i;
  }
  
  public final void a(bx parambx) {
    ft.a(parambx);
    cg.a(parambx, this.n, this.o, this.l, this.m, this.h);
    if (this.e) {
      parambx.d(this.n + 10, this.o + ft.aa, this.l, this.m - u - 10);
      parambx.a(0, -p.e.b);
    } 
    int i = this.o + t + ft.aa;
    if (this.d) {
      for (byte b = 0; b < this.c.length; b++) {
        this.v.a(parambx, this.q[b], ft.W / 2, i - 5 + b * (fi.c() + 18), 2, true);
        if (this.e) {
          this.c[b].b(parambx);
        } else {
          this.c[b].a(parambx);
        } 
      } 
    } else {
      for (byte b = 0; b < this.q.length; b++)
        this.v.a(parambx, this.q[b], ft.W / 2, i + b * 15 - 5, 2, true); 
      this.a.a(parambx);
    } 
    ft.a(parambx);
    c(parambx);
  }
  
  public final void e(int paramInt) {
    if (this.d) {
      for (byte b = 0; b < this.c.length; b++) {
        if (this.c[b].f()) {
          this.c[b].b(paramInt);
          return;
        } 
      } 
    } else {
      this.a.b(paramInt);
    } 
    super.e(paramInt);
  }
  
  public final void a() {
    d();
    e();
    if (this.d) {
      for (byte b = 0; b < this.c.length; b++)
        this.c[b].a(); 
    } else if (this.a != null) {
      this.a.a();
      if (!ft.A && this.Z != this.a.i)
        this.Z = this.a.i; 
      if (this.f && this.a.j().compareTo(this.x) != 0) {
        this.x = this.a.j();
        boolean bool = false;
        try {
          bool = Integer.parseInt(this.x);
        } catch (Exception exception) {
          bool = false;
        } 
        String str = "\n" + df.ba + " " + (this.g * bool) + " " + this.j;
        this.q = this.v.a(String.valueOf(this.i) + " " + str, this.l - 20);
        this.m = 15 * this.q.length + 10 + fi.c() + s + t + ft.aa;
        int i;
        if ((i = this.l - 100) < 40)
          i = 40; 
        this.n = ft.Y - this.l / 2;
        this.o = ft.X - (ft.aa << 1) - this.m + 15;
        this.a.a = this.n + this.l / 2 - i / 2;
        this.a.b = this.o + this.m - fi.c() + 8 - s;
      } 
    } 
    super.a();
  }
  
  public final void d() {
    if (this.d) {
      int i = this.y;
      if (ft.al[8]) {
        for (byte b = 0; b < this.c.length; b++) {
          if (this.c[b].f()) {
            this.c[b].a(false);
            if (b < this.c.length - 1) {
              this.c[b + 1].a(true);
              this.y = b + 1;
              if (!ft.A)
                this.Z = (this.c[b + 1]).i; 
              break;
            } 
            this.c[0].a(true);
            this.y = 0;
            if (!ft.A)
              this.Z = (this.c[0]).i; 
            break;
          } 
        } 
        ft.d(8);
      } else if (ft.al[2]) {
        for (byte b = 0; b < this.c.length; b++) {
          if (this.c[b].f()) {
            this.c[b].a(false);
            if (b > 0) {
              this.c[b - 1].a(true);
              this.y = b - 1;
              break;
            } 
            this.c[this.c.length - 1].a(true);
            this.y = this.c.length - 1;
            break;
          } 
        } 
        ft.d(2);
      } 
      this.y = cg.a(this.y, this.c.length - 1, false);
      if (i != this.y)
        p.e.a(0, this.y * 40 - this.m / 2 + 40 + ft.aa); 
    } 
    super.d();
  }
  
  public final void e() {
    super.e();
    if (this.d) {
      if (this.e) {
        if (ft.b(this.n, this.o + ft.aa, this.l, this.m - ft.aa)) {
          int i;
          for (i = 0; i < this.c.length; i++) {
            if ((this.c[i]).e)
              return; 
          } 
          if ((i = (p.e.b + ft.af - this.o - ft.aa) / u) >= 0 && i < this.c.length)
            if (ft.A) {
              this.c[i].a(true);
              this.c[i].h();
            } else {
              this.c[i].g();
            }  
          ft.S = false;
        } 
      } else {
        for (byte b = 0; b < this.c.length; b++)
          this.c[b].g(); 
      } 
    } else if (this.a != null) {
      this.a.g();
    } 
    if (this.e)
      if (ft.A && this.w != null) {
        this.w.c();
      } else {
        p.e.a();
      }  
    if (ft.A && this.w != null) {
      this.w.a();
      p.e.b = this.w.f;
    } 
  }
  
  public final String[] b() {
    String[] arrayOfString = new String[this.c.length];
    for (byte b = 0; b < this.c.length; b++)
      arrayOfString[b] = this.c[b].j(); 
    return arrayOfString;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dy.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */