public final class by extends p {
  public static boolean a = true;
  
  private int b;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i = 0;
  
  private em j;
  
  private String[] k;
  
  private String[] l;
  
  private byte m;
  
  private bt n;
  
  private bt o;
  
  private bt p;
  
  private bt q;
  
  private bt r;
  
  private bt s;
  
  private bt t;
  
  private bt u;
  
  private bt v;
  
  private bt w;
  
  private bt x;
  
  private bt y;
  
  private bt z;
  
  private bt A;
  
  private dy B;
  
  private bp C;
  
  private aw D = new aw();
  
  private byte[] E = new byte[] { 0, 1, 2, 1 };
  
  private byte F = 0;
  
  public by() {
    if (ft.A)
      this.i = bt.k; 
    b(180);
  }
  
  private void b(int paramInt) {
    this.g = paramInt;
    this.h = paramInt;
    if (this.h > ft.X - 20)
      this.h = ft.X - 20; 
    if (this.g > ft.W - 20)
      this.g = ft.W - 20; 
    this.b = ft.Y - this.g / 2;
    this.f = ft.Z - this.h / 2;
  }
  
  public final void a(p paramp) {
    super.a(paramp);
    ft.j();
  }
  
  public final void a(em paramem, byte paramByte) {
    this.m = paramByte;
    this.j = paramem;
    if (this.j == null) {
      this.c.a(this.c.c);
      return;
    } 
    b();
    this.w = new bt(df.Z, -1, this);
    this.o = new bt(df.eG, 2, this);
    if (paramByte == 1) {
      this.o.a = df.eQ;
      this.Y = this.o;
    } else if (paramByte == 0) {
      this.n = new bt(df.X, 0, this);
      this.p = new bt(String.valueOf(df.eH) + df.bO, 3, this);
      this.q = new bt(String.valueOf(df.eH) + df.bP, 4, this);
      this.r = new bt(String.valueOf(df.bK) + " " + df.bu, 6, this);
      this.s = new bt(df.cW, 7, this);
      this.t = new bt(df.eK, 8, this);
      this.u = new bt(df.eL, 9, this);
      this.v = new bt(df.eM, 2, this);
      this.x = new bt(df.eT, 11, this);
      this.y = new bt(df.eW, 12, this);
      this.z = new bt(df.eX, 13, this);
      this.A = new bt(String.valueOf(df.dx) + " " + df.eE, 14, this);
      this.Y = this.n;
    } 
    this.Z = this.w;
    if (ft.A) {
      this.Y.a(this.b + this.g / 2, this.f + this.g - bt.k / 2 - 4, cf.r, this.Y.a);
      this.Z.a(this.b + this.g - 12, this.f + 10, cf.t, "");
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    es es;
    int i;
    String str;
    em em1;
    switch (paramInt1) {
      case -1:
        this.c.a(this.c.c);
        return;
      case 0:
        es = new es("Clan_Screen menu");
        if (this.m == 1) {
          es.a(this.o);
          es.a((Object)null);
        } else if (this.m == 0) {
          if (cn.f.cO == null || cn.f.cO.q) {
            this.c.a(this.c.c);
            ft.a(df.eY);
            return;
          } 
          es.a(this.o);
          es.a(this.r);
          es.a(this.y);
          if (((em1 = cn.f.cO).o == Byte.MAX_VALUE || em1.o == 126 || em1.o == 125)) {
            es.a(this.s);
            es.a(this.A);
          } 
          es.a(this.p);
          es.a(this.q);
          if (cn.f.cO.o != Byte.MAX_VALUE)
            es.a(this.x); 
        } 
        ft.o.a(es, 2, df.cW, false, (es)null);
        return;
      case 1:
        q.a().b((byte)0, this.j.b);
        ft.a(df.bV);
        return;
      case 2:
        q.a().b((byte)13, this.j.b);
        ft.a(df.aD, new bt(df.Z, -1));
        return;
      case 3:
        this.B = new dy();
        this.B.a(df.eI, new bt(df.eH, 5, 6, this), true, String.valueOf(df.eH) + df.bO);
        ft.r = this.B;
        return;
      case 4:
        this.B = new dy();
        this.B.a(df.eJ, new bt(df.eH, 5, 7, this), true, String.valueOf(df.eH) + df.bP);
        ft.r = this.B;
        return;
      case 5:
        i = 0;
        try {
          i = Integer.parseInt(this.B.a.j());
        } catch (Exception exception) {
          return;
        } 
        if (exception > null) {
          q.a().c((byte)em1, exception);
          ft.a(df.aG);
          return;
        } 
        break;
      case 6:
        q.a().e((byte)14, cn.f.cB);
        ft.a(df.aD, new bt(df.Z, -1));
        return;
      case 7:
        if (cn.f.cO == null || cn.f.cO.q) {
          this.c.a(this.c.c);
          ft.a(df.eY);
          return;
        } 
        if (cn.f.cO.o == Byte.MAX_VALUE) {
          es es1;
          (es1 = new es("Clan_Screen menu2")).a(this.v);
          es1.a(this.t);
          es1.a(this.u);
          es1.a(this.z);
          ft.o.a(es1, 2, df.cW, false, (es)null);
          return;
        } 
        this.v.a();
        return;
      case 8:
        this.B = new dy();
        this.B.a(df.eN, new bt(df.az, 10, 16, this), false, String.valueOf(df.az) + " " + df.eO);
        ft.r = this.B;
        return;
      case 9:
        this.B = new dy();
        this.B.a(df.eN, new bt(df.az, 10, 17, this), false, String.valueOf(df.az) + " " + df.eP);
        ft.r = this.B;
        return;
      case 10:
        if ((str = this.B.a.j()) != null) {
          q.a().g((byte)em1, str);
          ft.a(df.aG);
          return;
        } 
        break;
      case 11:
        ft.c(df.fA, new bt(df.eT, 15, this));
        return;
      case 12:
        ft.g.a(df.eV, "", "", (byte)0, true);
        ft.h();
        return;
      case 13:
        this.B = new dy();
        this.B.a(df.eN, new bt(df.az, 10, 2, this), false, String.valueOf(df.az) + " " + df.ew);
        ft.r = this.B;
        return;
      case 14:
        q.a().j((byte)21);
        ft.a(df.aG);
        return;
      case 15:
        q.a().f((byte)18, cn.f.cB);
        this.c.a(this.c.c);
        break;
    } 
  }
  
  public final void a(bx parambx) {
    if (this.c != null)
      this.c.a(parambx); 
    if (ft.a != this)
      return; 
    ft.a(parambx);
    int i = this.f;
    int j = this.b;
    cg.a(parambx, j, i, this.g, this.h, df.eE);
    j += 5;
    i += ft.aa + 2;
    parambx.d(this.b, i, this.g, this.h - ft.aa - this.i - 5);
    parambx.a(0, -this.D.b);
    cg.a(parambx, this.j.d, this.b + this.g / 2, i + 4, 2);
    i += ft.ab + ft.ab / 2;
    o.f.a(parambx, df.eF, j, i, 0, true);
    fd fd;
    if ((fd = bk.i(this.j.a)).a != null)
      if (aq.b(fd.a.a) / 18 == 3) {
        if (ft.ai % 6 == 0) {
          int k;
          if ((k = this.E.length) == 0)
            k = 1; 
          this.F = (byte)((this.F + 1) % k);
        } 
        parambx.a(fd.a, 0, this.E[this.F] * 18, 18, 18, 0, j + 70, i + 6, 3);
      } else {
        parambx.a(fd.a, j + 70, i + 6, 3);
      }  
    o.f.a(parambx, this.j.c, j + 78, i, 0, true);
    i += ft.ab;
    o.f.a(parambx, String.valueOf(df.ac) + this.j.j + " +" + (this.j.m / 10) + "," + (this.j.m % 10) + "%" + "    " + df.dM + ": " + this.j.k, j, i, 0, true);
    i += ft.ab;
    o.f.a(parambx, String.valueOf(df.i) + this.j.h + "/" + this.j.i, j, i, 0, true);
    i += ft.ab;
    o.f.a(parambx, String.valueOf(df.gw[0]) + ": " + this.j.f, j, i, 0, true);
    i += ft.ab;
    byte b;
    for (b = 0; b < this.k.length; b++) {
      o.j.a(parambx, this.k[b], j, i, 0, true);
      i += ft.ab;
    } 
    o.f.a(parambx, String.valueOf(df.fb) + j.a(this.j.n), j, i, 0, true);
    i += ft.ab;
    o.f.a(parambx, String.valueOf(df.fc) + j.a(this.j.l), j, i, 0, true);
    if (this.j.p != null) {
      for (b = 0; b < this.j.p.length; b++) {
        i += 20;
        if ((fd = bk.j((short)(this.j.p[b]).a)).a != null)
          parambx.a(fd.a, j + 9, i + 5, 3); 
        o.k.a(parambx, (new StringBuffer(String.valueOf((this.j.p[b]).b))).toString(), j + 16, i + 4, 2, true);
        o.f.a(parambx, ": " + (this.j.p[b]).c, j + 22, i, 0, true);
      } 
      i += 5;
    } 
    i += ft.ab;
    for (b = 0; b < this.l.length; b++) {
      o.j.a(parambx, this.l[b], j, i, 0, true);
      i += ft.ab;
    } 
    if (ft.a == this && !ft.o.a && ft.r == null && ft.s == null)
      super.a(parambx); 
  }
  
  private void b() {
    if (this.j.e.length() > 100) {
      b(220);
    } else if (this.j.g.length() > 100) {
      b(220);
    } 
    this.k = o.j.a(this.j.e, this.g - 10);
    this.l = o.j.a(this.j.g, this.g - 10);
    int i = ft.aa + 2 + (6 + this.l.length + this.k.length) * ft.ab;
    if (this.j.p != null)
      i += 20 * this.j.p.length + 5; 
    if (i > this.h - ft.aa - this.i - 5) {
      this.C = new bp(this.b, this.f, this.g, this.h, 0, 0, i - this.h - ft.aa - this.i - 5);
    } else {
      this.C = new bp(this.b, this.f, this.g, this.h, 0, 0, 0);
    } 
    this.D.a(0, this.C.g, 0, 0);
    a = false;
  }
  
  public final void a() {
    if (this.c != null)
      this.c.a(); 
    if (a) {
      b();
      a = false;
    } 
    if (ft.A) {
      this.C.c();
      this.D.b = this.C.f;
    } else {
      this.D.a();
    } 
    super.a();
  }
  
  public final void d() {
    if (this.D.f > 0)
      if (ft.al[2]) {
        if (this.D.d > 0)
          this.D.d -= ft.ab; 
        if (this.D.d < 0)
          this.D.d = 0; 
        ft.d(2);
      } else if (ft.al[8]) {
        if (this.D.d < this.D.f)
          this.D.d += ft.ab; 
        if (this.D.d > this.D.f)
          this.D.d = this.D.f; 
        ft.d(2);
      }  
    super.d();
  }
  
  public final void e() {
    if (ft.A)
      this.C.a(); 
    super.e();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\by.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */