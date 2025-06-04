import com.silverknight.TemMidlet;

public final class ah extends da {
  private String r;
  
  private String s = "";
  
  private String t;
  
  public static int a;
  
  private int u = 0;
  
  private int v;
  
  private int w;
  
  private int x;
  
  private int y;
  
  private byte z;
  
  private boolean A = false;
  
  private boolean B = false;
  
  public static byte b = 0;
  
  private es C = new es("MsgChat cmdList");
  
  private bt D = new bt(df.Z, -1, this);
  
  private bt E = new bt(df.as, 10, this);
  
  private bt F;
  
  private bt G;
  
  private bt H;
  
  public static ce c;
  
  private aw I = new aw();
  
  private bp J;
  
  private int K = 0;
  
  private int L;
  
  private int M = 0;
  
  public static int d = 52;
  
  private static int N = 0;
  
  private ew O;
  
  private static int P = 0;
  
  public static int[] e = new int[] { 50, 50 };
  
  private int Q = -1;
  
  private byte[] R = new byte[3];
  
  private static byte[] S = null;
  
  private int T = 0;
  
  public static int[][] f;
  
  private o U = o.j;
  
  private byte V;
  
  private int W = 1;
  
  private short X = 0;
  
  private long aM = 0L;
  
  private int aN = 0;
  
  private int aO;
  
  private int[][] aP;
  
  private j[] aQ;
  
  private int aR;
  
  private int aS = 0;
  
  private int aT = 0;
  
  private byte aU = 0;
  
  public static int g;
  
  public static int h;
  
  private static int aV;
  
  private static int aW;
  
  public static ea i;
  
  public static byte j = 0;
  
  private int aX;
  
  private int aY;
  
  public static boolean k = false;
  
  public final void b(int paramInt1, int paramInt2) {
    bt bt1;
    es es1;
    byte b;
    bt bt2;
    ft.m();
    ft.l();
    switch (paramInt1) {
      case -1:
      case 7:
        l();
        bv.b = 0L;
        bv.a = false;
        bv.c = false;
        k = false;
        return;
      case 6:
        cn.f.n_();
        ft.b.c();
        l();
        bv.b = 0L;
        bv.a = false;
        bv.c = false;
        k = false;
        return;
      case 0:
        if (ft.a != ft.b && ft.a != ft.d) {
          if (x.f) {
            ft.b.c();
            byte[] arrayOfByte;
            if ((arrayOfByte = ak.a("user_pass")) != null) {
              try {
                bs.i();
              } catch (Exception exception) {}
              ft.o();
              q.a().a(bs.f.j(), bs.g.j(), k.a, "0", "0", "0", x.b, cs.u);
              cn.f.n_();
              if (ck.a == null || dr.b == null)
                q.a().g((byte)61); 
              l();
            } else {
              ft.b.c();
              l();
            } 
          } 
        } else {
          if (ft.a != ft.b)
            ft.b.c(); 
          l();
        } 
        bv.b = 0L;
        bv.a = false;
        bv.c = false;
        k = false;
        return;
      case 2:
        q.a().a((short)this.v, this.z, (byte)this.w);
        break;
      case 1:
        l();
        return;
      case 3:
        ft.e.a(ft.c);
        break;
      case 4:
        k();
        return;
      case 5:
        bq.l = true;
        (bq.w[bq.d][4]).b = ao.d;
        (bq.w[bq.d][3]).b = ao.d;
        j.a((byte)1, !(P == 0));
        j.a((byte)0, !(P == 0));
        co.b();
        y.f();
        break;
      case 8:
        if (bq.N == null)
          return; 
        if (cn.f.cB.compareTo(bq.N.a) == 0) {
          this = this;
          if (bq.N != null) {
            aj aj = (aj)bq.N.b.a(this.x);
            es es2 = new es("MsgChat menu2");
            if (aj.b.compareTo(cn.f.cB) != 0) {
              String str;
              if ((str = aj.b).length() > 8)
                str = String.valueOf(str.substring(0, 7)) + "..."; 
              bt bt4 = new bt(String.valueOf(df.bl) + " " + str + " " + df.aU, 6, this);
              es2.a(bt4);
            } 
            bt bt3 = new bt(df.aU, 8, this);
            es2.a(bt3);
            bt3 = new bt(df.aV, 7, this);
            es2.a(bt3);
            bt1 = new bt(df.fi, 15, this);
            es2.a(this);
            ft.o.a(es2, 2, df.cW, false, (es)null);
          } 
          return;
        } 
        es1 = new es("MsgChat menu");
        bt2 = new bt(df.aU, 8, (cg)this);
        es1.a(bt2);
        bt1 = new bt(df.fi, 15, (cg)this);
        es1.a(this);
        ft.o.a(es1, 2, df.cW, false, (es)null);
        return;
      case 9:
        b = -1;
        if (((ah)super).R[0] < (byte)((df.gI[0]).length - 1))
          b = ((ah)super).R[0]; 
        bq.q = new be((byte)b, ((ah)super).R[1], ((ah)super).R[2]);
        co.b();
        break;
      case 10:
        if (((ah)super).x >= 0 && ((ah)super).x < b) {
          b(((ah)super).x);
          return;
        } 
        return;
      case 11:
        l();
        return;
      case 15:
        l();
        q.a().k((byte)b);
        return;
      case 16:
        l();
        cn.f.N();
        l.a().c();
        ft.b.c();
        cn.f = new bq(0, (byte)0, "unname", 0, 0);
        x.g = false;
        x.h = false;
        return;
    } 
    l();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    es es1;
    fn fn;
    ft.m();
    ft.l();
    aj aj = null;
    switch (paramInt1) {
      case -1:
        l();
        return;
      case 6:
        if (bq.N == null)
          return; 
        aj = (aj)bq.N.b.a(this.x);
        q.a().b((byte)3, aj.b);
        return;
      case 7:
        l();
        q.a().b((byte)4, "");
        return;
      case 8:
        l();
        q.a().b((byte)5, "");
        return;
      case 9:
        if (bq.N == null)
          return; 
        aj = (aj)bq.N.b.a(this.x);
        q.a().a((byte)0, aj.b);
        return;
      case 2:
        if (bq.N == null)
          return; 
        if (this.x >= 0 && this.x < bq.N.b.c()) {
          aj = (aj)bq.N.b.a(this.x);
          ft.c(String.valueOf(df.bf) + aj.b + "?", new bt(df.aX, 0, this));
          return;
        } 
        break;
      case 3:
        if (bq.N == null)
          return; 
        if (this.x >= 0 && this.x < bq.N.b.c()) {
          ft.c(df.bg, new bt(df.aX, 1, this));
          return;
        } 
        break;
      case 10:
        if (this.O == null)
          return; 
        ft.c(String.valueOf(df.aE) + this.O.k, new bt(df.as, 11, this));
        return;
      case 11:
        if (this.O == null)
          return; 
        q.a().a((short)this.O.f, (byte)(this.O.j ? 0 : 1), (byte)2);
        dr.a.a(true);
        if (!cn.p.d(9, 0)) {
          l();
          l();
          return;
        } 
        break;
      case 12:
        if (this.s.length() > 0) {
          TemMidlet.b(this.s);
          return;
        } 
        break;
      case 14:
        if (bq.N == null)
          return; 
        aj = (aj)bq.N.b.a(this.x);
        ft.g.a(aj.b, "", "", (byte)0, true);
        ft.h();
        return;
      case 15:
        ft.g.a(df.aS, "", "", (byte)0, true);
        ft.h();
        return;
      case 16:
        es1 = new es("MsgChat vec");
        (fn = new fn(bw.V, (byte)0, df.fI, -1, fn.j)).D = i;
        a(fn);
        (ft.w = new eu()).a = 0;
        ft.w.a(this);
        ft.w.a(ft.a);
        break;
    } 
  }
  
  private void j() {
    cn.f.O();
    this.Y = null;
    this.Z = null;
    this.aa = null;
    this.C.d();
  }
  
  public final void a(String paramString, bt parambt, boolean paramBoolean) {
    j();
    if (parambt == null)
      ft.r = null; 
    this.A = false;
    this.B = false;
    this.p = 0;
    this.l = ft.W - 30;
    if (this.l > 200)
      this.l = 200; 
    this.C = new es("MsgChat cmdlist2");
    this.C.a(parambt);
    if (!paramBoolean)
      this.C.a(this.D); 
    int i = this.C.c();
    if (this.l < i * bt.j + (i - 1) * 10 + 10)
      this.l = i * bt.j + (i - 1) * 10 + 10; 
    if (this.l > ft.W)
      this.l = ft.W; 
    this.q = this.U.a(paramString, this.l - 20);
    this.m = 15 * this.q.length + d;
    this.n = ft.Y - this.l / 2;
    this.o = ft.X - (ft.aa << 1) - this.m - 5;
    a(0);
  }
  
  public final void a(String paramString1, String paramString2) {
    j();
    this.s = paramString2;
    this.A = false;
    this.B = false;
    this.p = 0;
    this.l = ft.W - 30;
    if (this.l > 200)
      this.l = 200; 
    this.C = new es("MsgChat cmdlist3");
    bt bt1 = new bt(df.ga, 12, this);
    this.C.a(bt1);
    this.C.a(this.D);
    int i = this.C.c();
    if (this.l < i * bt.j + (i - 1) * 10 + 10)
      this.l = i * bt.j + (i - 1) * 10 + 10; 
    if (this.l > ft.W)
      this.l = ft.W; 
    this.q = this.U.a(paramString1, this.l - 20);
    this.m = 15 * this.q.length + d;
    this.n = ft.Y - this.l / 2;
    this.o = ft.X - (ft.aa << 1) - this.m - 5;
    a(0);
  }
  
  public final void a(String paramString, bt parambt) {
    j();
    this.A = true;
    this.B = false;
    this.p = 0;
    this.l = ft.W - 30;
    if (this.l > 200)
      this.l = 200; 
    this.C = new es("MsgChat cmdList7");
    this.L = 0;
    if (parambt != null) {
      this.C.a(parambt);
      this.L = bt.k;
    } 
    this.q = this.U.a(paramString, this.l - 20);
    this.m = 15 * this.q.length + d + this.L;
    this.n = ft.Y - this.l / 2;
    this.o = ft.X - (ft.aa << 1) - this.m - 5;
    a(0);
  }
  
  public final void a(String paramString, es parames) {
    j();
    if (parames == null || parames.c() <= 0)
      ft.r = null; 
    this.A = false;
    this.B = false;
    this.p = 0;
    this.C = parames;
    this.l = ft.W - 30;
    if (this.l > 200)
      this.l = 200; 
    int i = this.C.c();
    if (this.l < 2 * bt.j + 10)
      this.l = 2 * bt.j + 10; 
    if (this.l > ft.W)
      this.l = ft.W; 
    int k = 0;
    if (this.C.c() > 2)
      k = bt.k; 
    this.q = this.U.a(paramString, this.l - 20);
    this.m = 15 * this.q.length + d + k;
    this.n = ft.Y - this.l / 2;
    this.o = ft.X - (ft.aa << 1) - this.m - 5 + ((i > 2) ? (bt.k + 5) : 0);
    a(0);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte paramByte) {
    j();
    this.M = 2;
    this.v = paramInt1;
    this.w = paramInt2;
    this.z = paramByte;
    this.B = true;
    bt bt1 = new bt(df.aq, 2);
    if (paramInt2 == 1) {
      bt1.a = df.ar;
      this.C.a(bt1);
    } else {
      this.C.a(bt1);
      bt1 = new bt(df.Z, 1);
      if (paramByte == 1)
        this.C.a(bt1); 
    } 
    this.r = paramString2;
    o.f.a(paramString2);
    this.A = false;
    this.p = 1;
    this.W = 1;
    this.l = ft.W / 5 << 2;
    if (this.l > 200)
      this.l = 200; 
    this.q = o.j.a(paramString1, this.l - 20);
    this.m = ft.ab * (this.q.length + 1) + d + 20 + ((this.C.c() > 2) ? (bt.k + 5) : 0);
    if (this.m > ft.X / 2 + 10)
      this.m = ft.X / 2 + 10; 
    this.I.a(0, ft.ab * (this.q.length + 1) + 30 - this.m, 0, 0);
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - ft.aa - this.m / 2;
    a(0);
  }
  
  public final void a(ew paramew) {
    j();
    this.M = 2;
    this.r = paramew.k;
    this.O = paramew;
    this.B = true;
    o.f.a(this.r);
    this.A = false;
    this.p = 1;
    this.W = 2;
    this.l = ft.W / 5 << 2;
    if (this.l > 200)
      this.l = 200; 
    bt bt1 = new bt(df.ap, 3);
    this.C.a(bt1);
    this.C.a(this.E);
    this.C.a(this.D);
    if (!ft.A) {
      bt1 = new bt(df.af, -1, this);
      this.Z = bt1;
    } 
    this.q = o.j.a(paramew.n, this.l - 20);
    this.m = ft.ab * (this.q.length + 1) + d + 15 + ((this.C.c() > 2) ? (bt.k + 5) : 0);
    if (!ft.A && this.m > ft.X * 6 / 7)
      this.m = ft.X * 6 / 7; 
    this.I.a(0, ft.ab * (this.q.length + 1) + 45 - this.m + bt.k * this.W, 0, 0);
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - this.m / 2;
    a(4);
  }
  
  public final void b() {
    j();
    N = 0;
    this.A = false;
    this.B = true;
    this.p = 2;
    this.K = ft.aa + 5;
    this.l = ft.W / 4 * 3;
    if (this.l > 180)
      this.l = 180; 
    if (bq.N != null) {
      a = bq.N.b.c();
    } else {
      a = 0;
    } 
    this.m = this.K * a + d - 10 + ft.aa;
    bt bt1 = new bt(df.ai, 4);
    this.F = new bt(df.cW, 8);
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - ft.aa - this.m / 2 + (ft.A ? ft.aa : 0);
    bt bt2 = this.D;
    if (ft.A) {
      this.C.a(this.F);
      a(4);
      bt2.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      this.C.a(bt2);
      return;
    } 
    this.C.a(this.F);
    this.C.a(bt1);
    a(0);
    this.Z = bt2;
  }
  
  public final void c() {
    j();
    N = 0;
    this.A = false;
    this.B = false;
    this.p = 4;
    this.K = ft.aa;
    this.l = ft.W;
    if (this.l > 220)
      this.l = 220; 
    this.m = this.K * 3 + d + ft.aa - 5;
    if (!ft.A)
      this.m -= bt.k; 
    bt bt1 = new bt("Ok", 5);
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - ft.aa - this.m / 2;
    bt bt2 = this.D;
    if (ft.A) {
      bt2.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      this.C.a(bt2);
      bt1.a(this.n + this.l / 2, this.o + this.m - bt.k + 7 - this.M, (ce)null, bt1.a);
      this.C.a(bt1);
      return;
    } 
    this.Z = bt2;
    this.Y = bt1;
  }
  
  public final void f() {
    j();
    N = 0;
    this.A = false;
    this.B = false;
    this.p = 7;
    this.K = ft.aa;
    this.l = ft.W;
    if (this.l > 220)
      this.l = 220; 
    this.m = this.K * 3 + d - 5 + ft.aa;
    if (!ft.A)
      this.m -= bt.k; 
    bt bt1 = new bt("Ok", 9);
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - ft.aa - this.m / 2;
    bt bt2 = this.D;
    if (ft.A) {
      bt2.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      this.C.a(bt2);
      bt1.a(this.n + this.l / 2, this.o + this.m - bt.k + 7 - this.M, (ce)null, bt1.a);
      this.C.a(bt1);
      return;
    } 
    this.Z = bt2;
    this.Y = bt1;
  }
  
  public final void g() {
    j();
    N = 0;
    this.A = false;
    this.B = false;
    this.p = 13;
    this.K = ft.aa;
    this.l = ft.W;
    if (this.l > 180)
      this.l = 180; 
    this.m = (this.K << 1) + d - 5 + ft.aa;
    if (!ft.A)
      this.m -= bt.k; 
    bt bt1 = new bt("Ok", 11);
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - this.m / 2;
    bt bt2 = this.D;
    if (ft.A) {
      bt2.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      this.C.a(bt2);
      bt1.a(this.n + this.l / 2, this.o + this.m - bt.k + 7 - this.M, (ce)null, bt1.a);
      this.C.a(bt1);
      return;
    } 
    this.Z = bt2;
    this.Y = bt1;
  }
  
  public final void a(String paramString, bt parambt, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    j();
    if (parambt == null)
      ft.r = null; 
    this.A = false;
    this.B = false;
    this.p = 5;
    this.l = paramInt4;
    this.G = parambt;
    this.C = new es("MsgChat cmdlist");
    this.G.a(ft.Y, ft.X - bt.k / 2, (ce)null, this.G.a);
    this.C.a(this.G);
    this.q = o.j.a(paramString, this.l - 4);
    this.m = ft.ab * this.q.length;
    this.n = paramInt1;
    this.o = paramInt2;
    if (paramInt3 == 5 || paramInt3 == 3 || paramInt3 == 4 || paramInt3 == 6)
      this.o += this.m; 
    if (paramInt3 == 8)
      this.n -= this.l; 
    this.Q = paramInt3;
  }
  
  public final void a(String paramString1, bt parambt, boolean paramBoolean, String paramString2) {
    j();
    this.t = paramString2;
    this.A = false;
    this.B = false;
    this.p = 6;
    this.l = ft.W - 30;
    if (this.l > 200)
      this.l = 200; 
    this.C = new es("MsgChat cmdlist4");
    this.C.a(parambt);
    if (!ft.A) {
      Object object = null;
      this.Z = parambt;
    } 
    int i = this.C.c();
    if (this.l < i * bt.j + (i - 1) * 10 + 10)
      this.l = i * bt.j + (i - 1) * 10 + 10; 
    if (this.l > ft.W)
      this.l = ft.W; 
    this.q = o.j.a(paramString1, this.l - 20);
    this.m = ft.ab * (this.q.length + 1) + bt.k + 20;
    if (this.m > ft.X - ft.aa) {
      this.m = ft.X - ft.aa;
      this.n = ft.Y - this.l / 2;
      this.o = ft.Z - this.m / 2;
      this.J = new bp(this.n, this.o, this.l, this.m, 0, 0, ft.ab * (this.q.length + 1) + bt.k + 20 - this.m);
    } else {
      this.n = ft.Y - this.l / 2;
      this.o = ft.Z - this.m / 2;
      this.J = new bp(this.n, this.o, this.l, this.m, 0, 0, 0);
    } 
    a(ft.A ? 4 : 0);
  }
  
  public final void h() {
    j();
    N = 0;
    this.A = false;
    this.B = false;
    this.p = 8;
    this.K = ft.aa;
    this.l = b * 60;
    if (this.l > 220)
      this.l = 220; 
    this.T = this.l / b;
    this.m = (this.K << 1) + ft.aa;
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - ft.aa - this.m / 2;
    if (ft.A) {
      this.D.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      this.C.a(this.D);
      return;
    } 
    bt bt1 = new bt(df.Y, 10);
    this.Y = bt1;
    this.Z = this.D;
  }
  
  public final void a(String paramString1, j[] paramArrayOfj, String paramString2, byte paramByte1, byte paramByte2) {
    c.E.d();
    j();
    this.A = false;
    this.B = false;
    this.V = paramByte2;
    this.aU = paramByte1;
    this.t = paramString1;
    this.aQ = paramArrayOfj;
    this.aN = 0;
    this.aO = 0;
    this.aS = 0;
    this.aT = 0;
    this.p = 11;
    this.l = ft.W - 30;
    if (this.l > 240)
      this.l = 240; 
    if (paramString2 != null) {
      this.q = this.U.a(paramString2, this.l - 20);
    } else {
      this.q = null;
    } 
    this.C = new es("MsgDiaLog cmdList3");
    this.m = d + 60;
    if (this.q != null)
      this.m += this.q.length * ft.ab; 
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - this.m / 2;
    this.aR = 55;
    if (this.aR * (paramArrayOfj.length - 1) > this.l - 30)
      this.aR = 30; 
    int i = 0;
    if (paramArrayOfj.length % 2 == 0)
      i = this.aR / 2; 
    i += (paramArrayOfj.length - 1) / 2 * this.aR;
    this.aP = new int[this.aQ.length][2];
    for (byte b = 0; b < this.aP.length; b++) {
      this.aP[b][0] = this.n + this.l / 2 - i + b * this.aR;
      this.aP[b][1] = this.o + this.m - ft.aa - 45;
    } 
  }
  
  public final void i() {
    this.t = df.fe;
    h = 0;
    g = 20;
    j();
    this.A = false;
    this.B = false;
    this.p = 12;
    this.l = ft.W - 30;
    if (this.l > 240)
      this.l = 240; 
    aV = this.l / 4 * 3;
    aW = 16;
    this.C = new es("MsgDiaLog cmdList4");
    this.q = this.U.a(df.fB, this.l - 20);
    this.m = 30 + d;
    this.n = ft.Y - this.l / 2;
    this.o = ft.Z - this.m / 2;
  }
  
  public final void a(ea paramea, byte paramByte) {
    if (paramByte != -1)
      j = paramByte; 
    i = paramea;
    this.t = paramea.g;
    this.K = ft.ab;
    j();
    this.A = false;
    this.B = false;
    this.p = 14;
    this.l = ft.W - 30;
    aW = 8;
    if (this.l > 200)
      this.l = 200; 
    aV = this.l / 2;
    this.H = new bt(df.fI, 16, this);
    this.C = new es("MsgDiaLog cmdList");
    this.C.a(this.H);
    int i;
    if ((i = (7 + paramea.k.length) * ft.ab + d + 10) > ft.X - (ft.aa << 1)) {
      this.m = ft.X - (ft.aa << 1);
      this.n = ft.Y - this.l / 2;
      this.o = ft.Z - this.m / 2;
      this.J = new bp(this.n, this.o, this.l, this.m, 0, 0, i - this.m);
    } else {
      this.m = i;
      this.n = ft.Y - this.l / 2;
      this.o = ft.Z - this.m / 2;
      this.J = new bp(this.n, this.o, this.l, this.m, 0, 0, 0);
    } 
    if (ft.A)
      a(4); 
    this.C.a(this.D);
    if (ft.A) {
      this.D.a(this.n + this.l - 12, this.o + 10, cf.t, "");
      return;
    } 
    a(0);
  }
  
  private void a(int paramInt) {
    this.y = 0;
    if (this.C.c() > 0) {
      int i;
      if ((i = this.C.c()) == 1) {
        this.aX = this.n + this.l / 2;
        this.aY = 0;
      } else {
        2;
        this.aY = 10;
        this.aX = this.n + this.l / 2 - this.aY / 2 - bt.j / 2;
      } 
      for (byte b = 0; b < i; b++) {
        bt bt1;
        (bt1 = (bt)this.C.a(b)).g = false;
        if (i == 3 && b == 2) {
          bt1.a(this.n + this.l / 2, this.o + this.m - bt.k - (i - 1) / 2 * (bt.k + 5) + 7 - this.M + b / 2 * (bt.k + 5) - (this.B ? 4 : 0) + paramInt, (ce)null, bt1.a);
        } else {
          bt1.a(this.aX + b % 2 * (bt.j + this.aY), this.o + this.m - bt.k - (i - 1) / 2 * (bt.k + 5) + 7 - this.M + b / 2 * (bt.k + 5) - (this.B ? 4 : 0) + paramInt, (ce)null, bt1.a);
        } 
        if (b == 0)
          bt1.g = true; 
      } 
    } 
  }
  
  public final void a(bx parambx) {
    int i;
    int k;
    int m;
    int n;
    int i1;
    ft.a(parambx);
    switch (this.p) {
      case 0:
        cg.a(parambx, this.n, this.o, this.l, this.m, 12);
        for (k = 0; k < this.q.length; k++)
          this.U.a(parambx, this.q[k], ft.W / 2, this.o + 12 + k * 15, 2, true); 
        if (this.A)
          c.b(this.u % c.c, ft.Y, this.o + 25 + this.q.length * 15, 0, 3, parambx); 
        break;
      case 1:
        cg.a(parambx, this.n, this.o, this.l, this.m, true, (byte)0);
        if (ft.B) {
          fl.c(parambx, ft.Y - 32, this.o + 11, 64, 14, 2);
        } else {
          for (k = 0; k < 2; k++)
            parambx.a(fl.aP[2], 0, 0, 32, 14, 0, ft.Y - 32 + (k << 5), this.o + 11, 0); 
        } 
        o.f.a(parambx, df.at, ft.Y, this.o + 12, 2, false);
        o.c.a(parambx, this.r, this.n + 10, this.o + 27, 0, true);
        parambx.d(this.n + 3, this.o + 39, this.l - 6, this.m - 55 - bt.k * this.W);
        parambx.a(0, -this.I.b);
        for (k = 0; k < this.q.length; k++)
          o.i.a(parambx, this.q[k], this.n + 11, this.o + 27 + (k + 1) * ft.ab, 0, true); 
        if (!ft.A)
          d(parambx); 
        break;
      case 2:
        cg.a(parambx, this.n, this.o, this.l, this.m, df.aS);
        i = this.o + ft.aa + 3;
        k = 0;
        if (bq.N != null) {
          if (!ft.A || N > 0) {
            parambx.a(-4873075);
            parambx.c(this.n + 9, i - 2 + this.x * this.K, this.l - 17, this.K - 1);
          } 
          if (bq.N != null)
            for (byte b = 0; b < bq.N.b.c(); b++) {
              aj aj;
              if ((aj = (aj)bq.N.b.a(b)).b.compareTo(bq.N.a) == 0) {
                cg.a(parambx, String.valueOf(aj.b) + " " + df.ah + aj.a, this.n + 11, i, 0, (byte)7, (byte)0);
              } else {
                o.f.a(parambx, String.valueOf(aj.b) + " " + df.ah + aj.a, this.n + 11, i, 0, true);
              } 
              if (aj.b.compareTo(cn.f.cB) == 0) {
                aj.g = cn.f.br;
                aj.h = cn.f.bs;
              } 
              parambx.a(0);
              parambx.c(this.n + 11, i + 14 - 2, 42, 4);
              parambx.a(-8714722);
              parambx.c(this.n + 12, i + 15 - 2, 40, 2);
              parambx.a(-579511);
              parambx.c(this.n + 12, i + 15 - 2, 40 * aj.g / aj.h, 2);
              String str = "map";
              if (ck.a != null && aj.f < ck.a.length)
                str = ck.a[aj.f]; 
              o.j.a(parambx, String.valueOf(str) + " - " + df.cC + (aj.c + 1), this.n + 11, i + 20 - 4, 0, true);
              i += this.K;
              if (b < bq.N.b.c() - 1) {
                parambx.a(cg.aL[4]);
                parambx.c(this.n + 12, i - 3, this.l - 24, 1);
              } 
            }  
        } else {
          o.i.a(parambx, df.aT, this.n + this.l / 2, i, 2, true);
        } 
        super.a(parambx);
        break;
      case 4:
        cg.a(parambx, this.n, this.o, this.l, this.m, df.cI);
        m = this.o + this.K + 11;
        k = this.n + 30 - (ft.A ? 10 : 0);
        parambx.a(fl.bf[0]);
        for (n = 0; n < df.gr.length; n++) {
          o.j.a(parambx, df.gr[n], k, m, 0, true);
          i = o.i.a(df.gr[0]);
          parambx.c(k + i, m - 3, 35, 18);
          o.j.a(parambx, "  " + e[n] + "%", k + 3 + i, m, 0, true);
          m += this.K;
        } 
        o.j.a(parambx, df.gs[P], k, m, 0, true);
        if (!ft.A)
          parambx.a(cg.ak, 0, 0, 12, 16, 4, k - 4 + ft.ai % 3, this.o + this.K + 17 + this.x * this.K, 10); 
        ft.a(parambx);
        c(parambx);
        break;
      case 5:
        fb.a(parambx, this.n, this.o, this.l, this.m, this.Q, this.q);
        break;
      case 6:
        cg.a(parambx, this.n, this.o, this.l, this.m, this.t);
        parambx.d(this.n, this.o + ft.aa + 2, this.l, this.m - ft.aa - bt.k - 8);
        parambx.a(0, -this.J.f);
        for (n = 0; n < this.q.length; n++)
          o.j.a(parambx, this.q[n], this.n + 8, this.o + ft.aa + 2 + n * ft.ab, 0, true); 
        if (!ft.A)
          d(parambx); 
        break;
      case 7:
        cg.a(parambx, this.n, this.o, this.l, this.m, df.cI);
        n = this.o + this.K + 11;
        i = this.n + 30 - (ft.A ? 10 : 0);
        parambx.a(fl.bf[3]);
        for (k = 0; k < df.gu.length; k++) {
          o.f.a(parambx, df.gu[k], i, n, 0, true);
          m = o.f.a(df.gu[k]);
          o.j.a(parambx, "< " + df.gI[k][this.R[k]] + " >", i + 3 + m, n, 0, true);
          n += this.K;
        } 
        if (!ft.A)
          parambx.a(cg.ak, 0, 0, 12, 16, 4, i - 4 + ft.ai % 3, this.o + this.K + 17 + this.x * this.K, 10); 
        ft.a(parambx);
        c(parambx);
        break;
      case 8:
        cg.a(parambx, this.n, this.o, this.l, this.m, df.cI);
        k = this.o + ft.aa + this.K;
        m = this.n + this.T / 2;
        if (!ft.A) {
          parambx.a(-1054968);
          parambx.c(m - 12 + this.x * this.T, k - 12, 24, 24);
        } 
        for (n = 0; n < b; n++) {
          ev ev;
          (ev = (ev)y.a.a(f[n][2])).a(parambx, m, k, 3);
          if (f[n][1] == 0)
            parambx.a(cg.am, 0, 0, 20, 20, 0, m, k, 3); 
          m += this.T;
        } 
        ft.a(parambx);
        c(parambx);
        break;
      case 9:
        cg.a(parambx, this.n, this.o, this.l, this.m, 12);
        for (n = 0; n < this.q.length; n++) {
          if (n == this.q.length - 1) {
            this.U.a(parambx, String.valueOf(this.q[n]) + " " + ((this.X > 0) ? (new StringBuffer(String.valueOf(this.X))).toString() : "") + "'.", ft.W / 2, this.o + 12 + n * 15, 2, true);
          } else {
            this.U.a(parambx, this.q[n], ft.W / 2, this.o + 12 + n * 15, 2, true);
          } 
        } 
        break;
      case 10:
        cg.a(parambx, this.n, this.o, this.l, this.m, this.t);
        if (this.aN < 2) {
          for (n = 0; n < this.aP.length; n++)
            parambx.a(cg.ap, this.aP[n][0], this.aP[n][1], 3); 
          if (this.aN == 0);
        } else if (this.aN == 2) {
          for (n = 0; n < this.q.length; n++)
            o.j.a(parambx, this.q[n], this.n + 8, this.o + ft.aa + 2 + n * ft.ab, 0, true); 
          n = this.aP.length - 1;
          parambx.a(cg.ap, this.aP[n][0], this.aP[n][1], 3);
        } 
        for (n = 0; n < c.E.c(); n++) {
          dx dx;
          (dx = (dx)c.E.a(n)).a(parambx);
        } 
        break;
      case 11:
        cg.a(parambx, this.n, this.o, this.l, this.m, this.t);
        if (this.q != null)
          for (n = 0; n < this.q.length; n++)
            o.j.a(parambx, this.q[n], this.n + 8, this.o + ft.aa + 2 + n * ft.ab, 0, true);  
        for (n = 0; n < this.aP.length; n++) {
          if (this.aS == -1 || n <= this.aS)
            parambx.a(cg.ap, this.aP[n][0], this.aP[n][1], 3); 
        } 
        for (n = 0; n < this.aQ.length; n++) {
          if ((this.aQ[n]).x != 0) {
            this.aQ[n].a(parambx, this.aP[n][0], this.aP[n][1], 21, 1, 0);
            if (this.V == 0) {
              if ((this.aQ[n]).u == 3)
                fl.b((this.aQ[n]).N).a(parambx, (this.aQ[n]).g, this.aP[n][0], this.aP[n][1] + 14, 2, true); 
            } else if (n == 1) {
              fl.b((this.aQ[n]).N).a(parambx, (this.aQ[n]).g, this.aP[n][0], this.aP[n][1] + 14, 2, true);
            } 
          } 
        } 
        for (n = 0; n < c.E.c(); n++) {
          dx dx;
          (dx = (dx)c.E.a(n)).a(parambx);
        } 
        break;
      case 12:
        cg.a(parambx, this.n, this.o, this.l, this.m, this.t);
        for (n = 0; n < this.q.length; n++)
          o.j.a(parambx, this.q[n], this.n + 8, this.o + ft.aa + 4 + n * ft.ab, 0, true); 
        n = this.n + this.l / 2 - aV / 2;
        i1 = aW - 10;
        i = (i = this.o + this.m - i1 - 25) - 5;
        parambx.a(2698542);
        parambx.c(n - 4, i + 15, aV + 2, i1);
        parambx.c(n - 4 + 1, i + 14, aV, 1);
        parambx.c(n - 4 + 1, i + 15 + i1, aV, 1);
        parambx.a(3027507);
        parambx.c(n - 4 + 1, i + 15, aV, i1);
        k = 0;
        if (g > 0 && h > 0) {
          if ((k = h * aV / g) <= 0) {
            k = 1;
          } else if (k > aV) {
            k = aV;
          } 
          parambx.a(-6437568);
          parambx.c(n - 4 + 1, i + 15, k, i1);
        } 
        k = h * 100 / g;
        o.f.a(parambx, String.valueOf(k) + "%", this.n + this.l / 2, i, 2, true);
        break;
      case 13:
        cg.a(parambx, this.n, this.o, this.l, this.m, df.fF);
        i = this.o + this.K + 11;
        k = this.n + 30 - (ft.A ? 10 : 0);
        parambx.a(fl.bf[3]);
        for (m = 0; m < df.gx.length; m++) {
          o.f.a(parambx, df.gx[m], k, i, 0, true);
          n = o.f.a(df.gx[m]);
          o.j.a(parambx, "< " + ((null[m] == null) ? df.cv : df.cw) + " >", k + 3 + n, i, 0, true);
          i += this.K;
        } 
        if (!ft.A)
          parambx.a(cg.ak, 0, 0, 12, 16, 4, k - 4 + ft.ai % 3, this.o + this.K + 17 + this.x * this.K, 10); 
        ft.a(parambx);
        c(parambx);
        break;
      case 14:
        if (i == null)
          return; 
        cg.a(parambx, this.n, this.o, this.l, this.m, this.t);
        m = this.o + (this.K << 1);
        n = this.n + 10;
        parambx.d(this.n, this.o + ft.aa + 2, this.l, this.m - ft.aa - bt.k - 8);
        parambx.a(0, -this.J.f);
        i.b(parambx, n + fl.aM / 2, m + fl.aM / 2 + fl.aM / 4, fl.aM / 2, 1);
        o.j.a(parambx, String.valueOf(df.ac) + i.S + " + " + (i.ap / 10) + "," + (i.ap % 10) + "%", n + 40, m, 0, true);
        m += ft.ab;
        i = i.aq / 24;
        k = i.aq % 24;
        o.j.a(parambx, String.valueOf(df.fH) + i + "d " + k + "h", n + 40, m, 0, true);
        m += ft.ab;
        fl.a(bw.e[i.au.a]).a(parambx, String.valueOf(bw.d[i.au.a]) + ": " + i.au.b + "-" + i.au.c, n + 40, m, 0, true);
        m += this.K;
        o.j.a(parambx, df.fI, n + 8, m, 0, true);
        b(parambx, i.ar, n + 65, m + 1, i.as);
        m += this.K;
        for (i = 0; i < df.gz.length; i++) {
          o.j.a(parambx, df.gz[i], n + 8, m, 0, true);
          b(parambx, i.av[i], n + 65, m + 1, i.at);
          m += this.K;
        } 
        for (i = 0; i < i.j.length; i++) {
          if ((i.j[i]).a > 6) {
            String str = String.valueOf(bw.d[(i.j[i]).a]) + ": " + bw.a(bw.f[(i.j[i]).a], (i.j[i]).b);
            fl.a(bw.e[(i.j[i]).a]).a(parambx, str, n + 8, m, 0, true);
            m += this.K;
          } 
        } 
        ft.a(parambx);
        c(parambx);
        break;
    } 
    ft.a(parambx);
    if (this.C != null)
      for (k = 0; k < this.C.c(); k++) {
        bt bt1;
        (bt1 = (bt)this.C.a(k)).a(parambx, bt1.h, bt1.i);
      }  
  }
  
  private static void b(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    parambx.a(-14078674);
    parambx.c(paramInt2 - 4, paramInt3 + 1, aV + 2, aW);
    parambx.c(paramInt2 - 4 + 1, paramInt3, aV, 1);
    parambx.c(paramInt2 - 4 + 1, paramInt3 + 1 + aW, aV, 1);
    parambx.a(-13749709);
    parambx.c(paramInt2 - 4 + 1, paramInt3 + 1, aV, aW);
    int i = 0;
    if (paramInt1 * 100 / paramInt4 > 0) {
      if ((i = paramInt1 * 100 / paramInt4 * aV / 100) <= 0) {
        i = 1;
      } else if (i > aV) {
        i = aV;
      } 
      parambx.a(-6437568);
      parambx.c(paramInt2 - 4 + 1, paramInt3 + 1, i, aW);
    } 
    o.f.a(parambx, (new StringBuffer(String.valueOf(paramInt1))).toString(), paramInt2 + aV / 2, paramInt3, 2, true);
  }
  
  public final void a() {
    if (this.A) {
      this.u++;
      if (this.u > 1200)
        if (l.a().b() && ft.a != ft.b && ft.a != ft.d) {
          ft.a(df.bX);
        } else {
          es es1 = new es("MsgDiaLog vec");
          if (x.f && ft.a != ft.b)
            es1.a(new bt(df.cL, 0)); 
          es1.a(new bt(df.bR, 6));
          ft.a(df.ck, es1);
          bv.a = true;
          bv.b = dw.a() + 30000L;
        }  
    } 
    if (this.p == 6 || this.p == 14)
      this.J.c(); 
    if (bv.a && bv.b - dw.a() <= 0L) {
      ah ah1 = this;
      bv.a = true;
      bv.b = dw.a() + 30000L;
      if (ft.a.f()) {
        if (x.f) {
          ft.b.c();
          byte[] arrayOfByte;
          if ((arrayOfByte = ak.a("user_pass")) != null) {
            try {
              bs.i();
            } catch (Exception exception) {}
            ft.o();
            q.a().a(bs.f.j(), bs.g.j(), k.a, "0", "0", "0", x.b, cs.u);
            k = true;
            cn.f.n_();
            if (ck.a == null || dr.b == null)
              q.a().g((byte)61); 
            l();
          } else {
            ft.b.c();
            l();
          } 
        } 
      } else {
        byte[] arrayOfByte;
        if ((arrayOfByte = ak.a("user_pass")) != null) {
          try {
            bs.i();
          } catch (Exception exception) {}
          ft.o();
          q.a().a(bs.f.j(), bs.g.j(), k.a, "0", "0", "0", x.b, cs.u);
          k = true;
          cn.f.n_();
          if (ck.a == null || dr.b == null)
            q.a().g((byte)61); 
          l();
        } else {
          ft.b.c();
          l();
        } 
      } 
      ft.a(df.bS, new bt(df.Z, 7));
      ft.N = dw.a();
    } 
    d();
    e();
    if (this.p == 2) {
      if (bq.N != null) {
        if (bq.N.b.c() != a || a == -1) {
          a = bq.N.b.c();
          this.m = this.K * a + d - 10 + ft.aa;
          this.o = ft.Z - ft.aa - this.m / 2 + (ft.A ? ft.aa : 0);
          this.C.d();
          bt bt1 = new bt(df.ai, 4);
          this.F = new bt(df.aU, 8);
          if (cn.f.cB.compareTo(bq.N.a) == 0)
            this.F.a = df.cW; 
          bt bt2 = this.D;
          if (ft.A) {
            this.C.a(this.F);
            a(4);
            bt2.a(this.n + this.l - 12, this.o + 10, cf.t, "");
            this.C.a(bt2);
          } else {
            this.C.a(this.F);
            this.C.a(bt1);
            a(4);
            this.Z = bt2;
          } 
        } 
        if (N > 0) {
          N--;
          return;
        } 
      } else {
        this.C.d();
        bt bt1 = this.D;
        if (ft.A) {
          bt1.a(this.n + this.l - 6, this.o + 4, cf.t, "");
          this.C.a(bt1);
          return;
        } 
        this.Z = bt1;
        return;
      } 
    } else {
      if (this.p == 3 || this.p == 6 || this.p == 14) {
        this.I.a();
        return;
      } 
      if (this.p == 9) {
        if ((ft.aj - this.aM) / 1000L > 1L) {
          this.aM += 1000L;
          this.X = (short)(this.X - 1);
          if (this.X <= 0) {
            this.D.a();
            return;
          } 
        } 
      } else {
        if (this.p == 10) {
          this.aO++;
          if (this.aN == 0) {
            if (this.aO == 30) {
              this.aO = 0;
              this.aN = 1;
            } 
          } else if (this.aN == 1) {
            if (this.aO == 1)
              for (byte b1 = 0; b1 < this.aP.length - 1; b1++)
                c.a(41, this.aP[b1][0], this.aP[b1][1], this.aP[this.aP.length - 1][0], this.aP[this.aP.length - 1][1], 1);  
            if (this.aO >= 16) {
              this.aN = 2;
              this.aO = 0;
              this.C.a(this.D);
              a(0);
              c.a(33, this.aP[this.aP.length - 1][0], this.aP[this.aP.length - 1][1]);
              c.a(34, this.aP[this.aP.length - 1][0], this.aP[this.aP.length - 1][1]);
            } 
          } 
          for (byte b = 0; b < c.E.c(); b++) {
            dx dx;
            (dx = (dx)c.E.a(b)).a();
            if (dx.y)
              c.E.d(dx); 
          } 
          return;
        } 
        if (this.p == 11) {
          this.aO++;
          if (this.aN == 0) {
            if (this.aS >= 0 && this.aO % 5 == 1) {
              c.a(34, this.aP[this.aS][0], this.aP[this.aS][1]);
              if (this.aS < this.aQ.length - 1) {
                this.aS++;
              } else {
                this.aS = -1;
              } 
            } 
            if (this.aO > 5 && this.aO % 5 == 1) {
              if (this.aU == 0)
                c.a(33, this.aP[this.aT][0], this.aP[this.aT][1]); 
              (this.aQ[this.aT]).x = 1;
              if (this.aT < this.aQ.length - 1) {
                this.aT++;
              } else {
                this.aT = -1;
                this.aS = -1;
                this.aO = 0;
                this.aN = 1;
                this.C.a(this.D);
                a(0);
              } 
            } 
          } 
          for (byte b = 0; b < c.E.c(); b++) {
            dx dx;
            (dx = (dx)c.E.a(b)).a();
            if (dx.y)
              c.E.d(dx); 
          } 
          return;
        } 
        if (this.p == 12)
          if (l.a().b()) {
            if (h >= g && ft.ai % 40 == 20) {
              ft.a(df.fC);
              return;
            } 
          } else {
            ft.b(df.ck, new bt(df.bR, -1));
          }  
      } 
    } 
  }
  
  public final void d() {
    if (this.p == 1) {
      this.I.a();
      if (ft.al[2]) {
        this.I.d -= ft.ab;
        if (this.I.d < 0)
          this.I.d = 0; 
        ft.d(2);
      } else if (ft.al[8]) {
        this.I.d += ft.ab;
        if (this.I.d > this.I.f)
          this.I.d = this.I.f; 
        ft.d(8);
      } 
    } else if (this.p == 2) {
      if (bq.N != null) {
        if (ft.al[2]) {
          this.x--;
          ft.d(2);
        } else if (ft.al[8]) {
          this.x++;
          ft.d(8);
        } 
        this.x = cg.a(this.x, bq.N.b.c() - 1, true);
      } else {
        this.Y = null;
      } 
    } else if (this.p == 6 || this.p == 14) {
      if (ft.al[2]) {
        this.J.e -= ft.ab;
        ft.d(2);
      } else if (ft.al[8]) {
        this.J.e += ft.ab;
        ft.d(8);
      } 
      if (this.J.e > this.J.g)
        this.J.e = this.J.g; 
      if (this.J.e < 0)
        this.J.e = 0; 
    } else if (this.p == 4) {
      if (ft.al[2]) {
        this.x--;
        ft.d(2);
      } else if (ft.al[8]) {
        this.x++;
        ft.d(8);
      } 
      this.x = cg.a(this.x, 2, true);
      if (ft.al[4]) {
        switch (this.x) {
          case 0:
            if (e[0] > 10)
              e[0] = e[0] - 10; 
            break;
          case 1:
            if (e[1] > 10)
              e[1] = e[1] - 10; 
            break;
          case 2:
            if (P == 1)
              P = 0; 
            break;
        } 
        ft.d(4);
      } else if (ft.al[6]) {
        switch (this.x) {
          case 0:
            if (e[0] < 90)
              e[0] = e[0] + 10; 
            break;
          case 1:
            if (e[1] < 90)
              e[1] = e[1] + 10; 
            break;
          case 2:
            if (P == 0)
              P = 1; 
            break;
        } 
        ft.d(6);
      } 
    } else if (this.p == 7) {
      if (ft.al[2]) {
        this.x--;
        ft.d(2);
      } else if (ft.al[8]) {
        this.x++;
        ft.d(8);
      } 
      this.x = cg.a(this.x, 2, true);
      if (ft.al[4]) {
        if (this.R[this.x] == 0) {
          this.R[this.x] = (byte)((df.gI[this.x]).length - 1);
        } else {
          this.R[this.x] = (byte)(this.R[this.x] - 1);
        } 
        ft.d(4);
      } else if (ft.al[6]) {
        if (this.R[this.x] == (byte)((df.gI[this.x]).length - 1)) {
          this.R[this.x] = 0;
        } else {
          this.R[this.x] = (byte)(this.R[this.x] + 1);
        } 
        ft.d(6);
      } 
    } else if (this.p == 13) {
      if (ft.al[2]) {
        this.x--;
        ft.d(2);
      } else if (ft.al[8]) {
        this.x++;
        ft.d(8);
      } 
      this.x = cg.a(this.x, 1, true);
      if (ft.al[4]) {
        if (this.R[this.x] == 0) {
          this.R[this.x] = 1;
        } else {
          this.R[this.x] = (byte)(this.R[this.x] - 1);
        } 
        ft.d(4);
      } else if (ft.al[6]) {
        if (this.R[this.x] == 1) {
          this.R[this.x] = 0;
        } else {
          this.R[this.x] = (byte)(this.R[this.x] + 1);
        } 
        ft.d(6);
      } 
    } else if (this.p == 8) {
      if (ft.al[4]) {
        this.x--;
        ft.d(4);
      } else if (ft.al[6]) {
        this.x++;
        ft.d(6);
      } 
      this.x = cg.a(this.x, b - 1, true);
    } 
    if (this.C != null) {
      int i = this.C.c();
      if (!ft.A && i > 0) {
        int k = this.y;
        if (ft.al[4]) {
          this.y--;
          ft.d(4);
        } else if (ft.al[6]) {
          this.y++;
          ft.d(6);
        } 
        this.y = cg.a(this.y, i - 1, false);
        bt bt1;
        if (this.w == 2 && (bt1 = (bt)this.C.a(this.y)) == this.D)
          this.y = 0; 
        if (k != this.y)
          for (byte b = 0; b < i; b++) {
            bt bt2 = (bt)this.C.a(b);
            if (b == this.y) {
              bt2.g = true;
            } else {
              bt2.g = false;
            } 
          }  
      } 
    } 
    if (ft.al[5]) {
      ft.d(5);
      if (this.C != null && this.y < this.C.c())
        ((bt)this.C.a(this.y)).a(); 
    } 
    super.d();
  }
  
  public final void e() {
    if (this.p == 2) {
      int i;
      if (bq.N != null && ft.b(this.n, this.o + ft.aa, this.l, this.m - ft.aa) && (i = (ft.af - this.o + ft.aa) / this.K) >= 0 && i <= bq.N.b.c() - 1) {
        this.x = i;
        this.x = cg.a(this.x, bq.N.b.c() - 1, false);
        N = 3;
        k();
        ft.S = false;
      } 
    } else if (this.p == 4) {
      int i = this.o + this.K + 11;
      int k;
      if (ft.b(k = this.n + 30 - (ft.A ? 10 : 0) + o.i.a(df.gr[0]), i - 5, 40, 20)) {
        if (e[0] < 90) {
          e[0] = e[0] + 10;
        } else {
          e[0] = 10;
        } 
        ft.S = false;
      } else if (ft.b(k, i + this.K - 5, 40, 20)) {
        if (e[1] < 90) {
          e[1] = e[1] + 10;
        } else {
          e[1] = 10;
        } 
        ft.S = false;
      } else if (ft.b(this.n + 30 - (ft.A ? 10 : 0), i + (this.K << 1), 120, 20)) {
        if (P == 0) {
          P = 1;
        } else {
          P = 0;
        } 
        ft.S = false;
      } 
    } else if (this.p == 7) {
      int i = this.o + this.K + 11;
      int k;
      if (ft.b(k = this.n, i - 4, this.l, 20)) {
        if (this.R[0] == (byte)((df.gI[0]).length - 1)) {
          this.R[0] = 0;
        } else {
          this.R[0] = (byte)(this.R[0] + 1);
        } 
        ft.S = false;
      } else if (ft.b(k, i + this.K - 4, this.l, 20)) {
        if (this.R[1] == (byte)((df.gI[1]).length - 1)) {
          this.R[1] = 0;
        } else {
          this.R[1] = (byte)(this.R[1] + 1);
        } 
        ft.S = false;
      } else if (ft.b(k, i + (this.K << 1), this.l, 20)) {
        if (this.R[2] == (byte)((df.gI[2]).length - 1)) {
          this.R[2] = 0;
        } else {
          this.R[2] = (byte)(this.R[2] + 1);
        } 
        ft.S = false;
      } 
    } else if (this.p == 13) {
      int i = this.o + this.K + 11;
      int k;
      if (ft.b(k = this.n, i - 4, this.l, 20)) {
        if (null[0] == true) {
          null[0] = false;
        } else {
          null[0] = (byte)(null[0] + 1);
        } 
        ft.S = false;
      } else if (ft.b(k, i + this.K - 4, this.l, 20)) {
        if (null[1] == true) {
          null[1] = false;
        } else {
          null[1] = (byte)(null[1] + 1);
        } 
        ft.S = false;
      } 
    } else if (this.p == 6 || this.p == 14) {
      this.J.a();
    } else if (this.p == 8) {
      int i = this.o + ft.aa + this.K;
      int k = this.n + this.T / 2;
      for (byte b = 0; b < b; b++) {
        if (ft.b(k + b * this.T - 20, i - 20, 40, 40)) {
          ft.S = false;
          b(b);
          break;
        } 
      } 
    } else if (this.p == 5 && ft.b(0, 0, ft.W, ft.X)) {
      this.G.a();
      ft.S = false;
    } 
    if (this.C != null)
      for (byte b = 0; b < this.C.c(); b++) {
        bt bt1;
        (bt1 = (bt)this.C.a(b)).b();
      }  
  }
  
  private void k() {
    if (bq.N == null)
      return; 
    aj aj;
    if ((aj = (aj)bq.N.b.a(this.x)).b.compareTo(cn.f.cB) == 0)
      return; 
    es es1 = new es("MsgDiaLog menu");
    bt bt1 = new bt(df.aW, 9, this);
    es1.a(bt1);
    bt1 = new bt(df.bL, 14, this);
    es1.a(bt1);
    if (cn.f.cB.compareTo(bq.N.a) == 0) {
      String str;
      if ((str = aj.b).length() > 8)
        str = String.valueOf(str.substring(0, 7)) + "..."; 
      bt bt2 = new bt(String.valueOf(df.bl) + str + " " + df.aU, 6, this);
      es1.a(this);
    } 
    ft.o.a(es1, 2, aj.b, false, (es)null);
  }
  
  private static void l() {
    if (ft.r != null) {
      ft.r = null;
      return;
    } 
    ft.s = null;
  }
  
  private static void b(int paramInt) {
    if (f[paramInt][1] == 0) {
      if (bq.I[f[paramInt][0]] > 0) {
        f[paramInt][1] = 1;
        bq.p = 1;
      } else {
        ft.a(df.bk);
      } 
    } else {
      f[paramInt][1] = 0;
      bq.p = 0;
      for (paramInt = 0; paramInt < f.length; paramInt++) {
        if (f[paramInt][1] == 1) {
          bq.p = 1;
          break;
        } 
      } 
    } 
    co.b();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ah.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */