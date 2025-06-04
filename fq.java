public final class fq extends cg {
  public boolean a;
  
  private es g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private static int p;
  
  private static int q;
  
  private static int r;
  
  private static int s;
  
  private int t;
  
  private int u;
  
  private String v = "";
  
  private String[] w;
  
  public eh b;
  
  public static boolean c = false;
  
  private static boolean x = false;
  
  private static boolean y = true;
  
  private static boolean z = true;
  
  public static byte d;
  
  private es A;
  
  public static ez e = null;
  
  private int B;
  
  private int C;
  
  public static int f;
  
  private byte D;
  
  private byte E = 0;
  
  private int F;
  
  private int G;
  
  private boolean H = false;
  
  private int I;
  
  private boolean J = false;
  
  private bt K;
  
  private bt L;
  
  private int M;
  
  private int N;
  
  private int O;
  
  private int P;
  
  private int Q;
  
  private int[] R = new int[3];
  
  private boolean S;
  
  private boolean T;
  
  private int U;
  
  private int V;
  
  private int W;
  
  private int X;
  
  public final void a(es parames1, int paramInt, String paramString, boolean paramBoolean, es parames2) {
    bt bt1;
    int i;
    z = false;
    this.H = false;
    this.U = 0;
    this.b = null;
    this.Z = null;
    d = 0;
    x = paramBoolean;
    this.A = parames2;
    this.i = 0;
    if (x && (this.A == null || this.A.c() == 0))
      return; 
    this.v = paramString;
    c = false;
    this.h = 0;
    this.t = paramInt;
    if (parames1 == null || parames1.c() == 0)
      return; 
    this.g = parames1;
    this.a = true;
    if (paramInt == -1) {
      this.g.a(new bt(df.Z, 1, this));
      this.o = 0;
      this.l = 60;
      this.m = 60;
      for (paramInt = 0; paramInt < parames1.c(); paramInt++) {
        bt1 = (bt)parames1.a(paramInt);
        if ((i = o.k.a(bt1.a)) > this.l - 8)
          bt1.b = o.d.a(bt1.a, this.l - 8); 
      } 
      this.O = parames1.c() * this.l - 1;
      if (this.O > ft.W - 2)
        this.O = ft.W - 2; 
      this.j = ft.Y - this.O / 2;
      if (this.j < 1)
        this.j = 1; 
      this.k = ft.X - this.m - ft.aa + 1;
      if (ft.A)
        this.k -= 3; 
      this.k += 27;
      this.n = this.k;
      if ((r = this.g.c() * this.l - ft.W) < 0)
        r = 0; 
      p = 0;
      q = 0;
      s = 50;
    } else {
      if (x)
        e = (ez)this.A.a(0); 
      this.l = ft.aa;
      if (ft.A)
        this.l = 32; 
      this.u = ft.X / 4 * 3 / this.l - ((i != 0) ? 2 : 1);
      if (ft.A)
        this.u++; 
      this.O = ft.W / 3;
      if (this.O < o.f.a((String)bt1) + 30)
        this.O = o.f.a((String)bt1) + 30; 
      this.o = ft.aa;
      if (i != 0)
        this.o += this.l; 
      paramInt = 120;
      byte b = 30;
      if (i != 0)
        b = 50; 
      for (i = 0; i < parames1.c(); i++) {
        bt bt3 = (bt)parames1.a(i);
        int j;
        if ((j = o.f.a(bt3.a) + b) > paramInt)
          paramInt = j; 
      } 
      if (this.O < paramInt)
        this.O = paramInt; 
      if (this.O > ft.W)
        this.O = ft.W; 
      p = 0;
      q = 0;
      bt bt2 = null;
      if (ft.A) {
        bt2 = new bt(df.Z, 1, this);
      } else {
        bt2 = new bt(df.af, 1, this);
      } 
      if (parames1.c() > this.u) {
        this.m = this.u * this.l + 8;
        r = (parames1.c() - this.u) * this.l;
      } else {
        this.m = parames1.c() * this.l + 8;
        r = 0;
      } 
      i();
      this.n = this.k;
      if (ft.A)
        bt2.a(this.j + this.O - 11, this.k - this.o + ft.aa / 2 - 2, cf.t, ""); 
      this.Z = bt2;
    } 
    if (ft.A)
      this.h = -1; 
    z = true;
    h();
  }
  
  public final void b(es parames1, int paramInt, String paramString, boolean paramBoolean, es parames2) {
    this.H = true;
    z = false;
    this.U = 0;
    this.b = null;
    this.Z = null;
    d = 0;
    x = false;
    this.A = null;
    this.i = 0;
    if (x && (this.A == null || this.A.c() == 0))
      return; 
    this.v = paramString;
    c = false;
    this.h = 0;
    this.t = 2;
    if (parames1.c() == 0)
      return; 
    this.g = parames1;
    this.a = true;
    if (x)
      e = (ez)this.A.a(0); 
    this.l = ft.aa;
    if (ft.A)
      this.l = 32; 
    this.u = ft.X / 4 * 3 / this.l - 1;
    if (ft.A)
      this.u++; 
    this.O = ft.W / 3;
    if (this.O < o.f.a(paramString) + 30)
      this.O = o.f.a(paramString) + 30; 
    this.o = ft.aa;
    paramInt = 120;
    for (byte b = 0; b < parames1.c(); b++) {
      bt bt2 = (bt)parames1.a(b);
      int i;
      if ((i = o.f.a(bt2.a) + 30) > paramInt)
        paramInt = i; 
    } 
    if (this.O < paramInt)
      this.O = paramInt; 
    if (this.O > ft.W)
      this.O = ft.W; 
    p = 0;
    q = 0;
    bt bt1 = null;
    if (ft.A) {
      bt1 = new bt(df.Z, 1, this);
    } else {
      bt1 = new bt(df.af, 1, this);
    } 
    if (parames1.c() > this.u) {
      this.m = this.u * this.l + 8;
      r = (parames1.c() - this.u) * this.l;
    } else {
      this.m = parames1.c() * this.l + 8;
      r = 0;
    } 
    i();
    this.n = this.k;
    if (ft.A)
      bt1.a(this.j + this.O - 11, this.k - this.o + ft.aa / 2 - 2, cf.t, ""); 
    this.Z = bt1;
    if (ft.A)
      this.h = -1; 
    z = true;
    h();
  }
  
  public final void a(es parames, int paramInt1, int paramInt2, int paramInt3, String paramString) {
    z = false;
    this.H = false;
    this.U = 0;
    this.Z = null;
    this.b = null;
    x = false;
    this.A = null;
    this.v = paramString;
    c = false;
    d = 0;
    this.h = 0;
    this.B = paramInt2;
    this.C = paramInt3;
    this.t = 2;
    this.a = true;
    this.g = new es("Menu2 menuItem2");
    this.l = ft.aa;
    if (ft.A)
      this.l = 32; 
    this.u = ft.X / 4 * 3 / this.l - 1;
    if (ft.A)
      this.u++; 
    this.O = ft.W / 3;
    this.o = this.l;
    paramInt1 = 120;
    if (120 < o.f.a(paramString) + 30)
      paramInt1 = o.f.a(paramString) + 30; 
    for (paramInt2 = 0; paramInt2 < parames.c(); paramInt2++) {
      bt bt2 = (bt)parames.a(paramInt2);
      bt bt3 = new bt(bt2.a, 2, this);
      int i;
      if ((i = o.f.a(bt2.a) + 20) > paramInt1)
        paramInt1 = i; 
      this.g.a(bt3);
    } 
    bt bt1 = null;
    if (ft.A) {
      bt1 = new bt(df.Z, 1, this);
    } else {
      bt1 = new bt(df.af, 1, this);
    } 
    this.O = paramInt1;
    if (this.O > ft.W)
      this.O = ft.W; 
    if (this.g.c() > this.u) {
      this.m = this.u * this.l + 8;
      r = (this.g.c() - this.u) * this.l;
    } else {
      this.m = this.g.c() * this.l + 8;
      r = 0;
    } 
    p = 0;
    q = 0;
    i();
    this.n = this.k;
    if (ft.A)
      bt1.a(this.j + this.O - 11, this.k - this.o + ft.aa / 2 - 2, cf.t, ""); 
    this.Z = bt1;
    if (ft.A)
      this.h = -1; 
    z = true;
    h();
  }
  
  public final void a(es parames, String paramString, int paramInt1, byte paramByte, boolean paramBoolean, int paramInt2) {
    z = false;
    this.H = false;
    this.U = 0;
    this.Z = null;
    d = 1;
    this.i = 0;
    this.v = paramString;
    c = false;
    x = false;
    this.C = paramInt1;
    f = paramInt1;
    this.D = paramByte;
    this.I = paramInt2;
    this.h = 0;
    if (parames == null || parames.c() == 0) {
      this.g = new es("Menu2 menuItem3");
    } else {
      this.g = parames;
    } 
    this.a = true;
    this.l = ft.aa;
    if (ft.A)
      this.l = 32; 
    this.u = 0;
    this.O = ft.W - 10;
    if (this.O > 300)
      this.O = 300; 
    this.w = o.i.a(paramString, this.O - 20);
    this.o = ft.aa;
    p = 0;
    q = 0;
    int i = this.w.length;
    if (!paramBoolean) {
      this.g.a(new bt(df.Z, 1, this));
    } else if (i == 1) {
      i = 2;
    } 
    this.m = (i + 2) * ft.ab + ((this.g.c() - 1) / 2 + 1) * (bt.k + 5) + 5;
    r = 0;
    this.j = ft.Y - this.O / 2;
    this.k = ft.X - this.m - 10;
    this.n = this.k;
    this.b = new eh();
    this.b.a(paramString, 0, this.j + 10, this.k + 10 + ft.ab, this.O - 20, o.j);
    fq fq1;
    int j;
    if ((j = (fq1 = this).g.c()) == 1) {
      fq1.M = fq1.j + fq1.O / 2;
      fq1.N = 0;
    } else {
      2;
      fq1.N = 20;
      fq1.M = fq1.j + fq1.O / 2 - fq1.N / 2 - bt.j / 2;
    } 
    for (paramInt1 = 0; paramInt1 < j; paramInt1++) {
      bt bt1 = (bt)fq1.g.a(paramInt1);
      if (j == 3 && paramInt1 == 2) {
        bt1.a(fq1.j + fq1.O / 2, fq1.k + fq1.m - bt.k - (j - 1) / 2 * (bt.k + 5) + 7 + paramInt1 / 2 * (bt.k + 5), (ce)null, bt1.a);
      } else {
        bt1.a(fq1.M + paramInt1 % 2 * (bt.j + fq1.N), fq1.k + fq1.m - bt.k - (j - 1) / 2 * (bt.k + 5) + 7 + paramInt1 / 2 * (bt.k + 5), (ce)null, bt1.a);
      } 
      if (paramInt1 == 0)
        bt1.g = true; 
    } 
    if (ft.A)
      this.h = -1; 
    z = true;
    h();
  }
  
  public final void b() {
    this.J = cf.I;
    this.E = 1;
    z = false;
    this.H = false;
    this.U = 0;
    this.Z = null;
    d = 2;
    this.i = 0;
    this.v = "";
    c = false;
    x = false;
    this.h = 0;
    this.O = ft.W - 40;
    this.a = true;
    this.l = 40;
    p = 0;
    q = 0;
    this.F = 0;
    this.m = 40;
    this.G = (byte)(this.O / this.m);
    this.g = new es("Menu2 menuItems");
    bt bt1 = new bt(df.cI, 3, 2, this);
    bt bt2 = new bt(df.cu, 4, 4, this);
    bt bt3 = new bt(df.ct, 5, 3, this);
    bt bt4 = new bt(df.eo, 6, 0, this);
    bt bt5 = new bt(df.bd, 7, 1, this);
    this.L = new bt(df.gl, 14, 10, this);
    this.K = new bt(String.valueOf(df.cT) + "/" + df.cS, 8, 5, this);
    bt bt6 = new bt(df.dI, 11, 9, this);
    bt bt7 = new bt(df.cG, 12, 8, this);
    this.g.a(this.L);
    this.g.a(bt4);
    this.g.a(bt5);
    if (cn.f.cO != null) {
      bt4 = new bt(df.eE, 9, 6, this);
      this.g.a(bt4);
    } 
    if (bq.N != null) {
      bt4 = new bt(df.aS, 10, 7, this);
      this.g.a(bt4);
    } 
    this.g.a(bt1);
    this.g.a(bt3);
    this.g.a(bt6);
    this.g.a(bt2);
    this.g.a(this.K);
    this.g.a(bt7);
    if (this.G > this.g.c())
      this.G = this.g.c(); 
    this.O = this.G * this.m;
    r = 0;
    if (!this.J) {
      this.j = ft.Y - this.O / 2;
    } else {
      this.j = 20;
    } 
    this.k = ft.X - 40;
    this.n = this.k;
    if (ft.A)
      this.h = -1; 
    z = true;
    for (byte b = 0; b < this.g.c(); b++)
      (bt1 = (bt)this.g.a(b)).b(this.j + this.m / 2 + b * this.m, this.k + this.m / 2, cf.y[bt1.f], bt1.a, 0, -32); 
    r = (this.g.c() - this.G) * this.m;
    this.h = -1;
    h();
  }
  
  private void h() {
    for (byte b = 0; b < this.R.length; b++)
      this.R[b] = 0; 
    this.P = 0;
    this.Q = 0;
    this.S = false;
    this.T = false;
    this.U = 0;
    this.V = 0;
  }
  
  private void i() {
    switch (this.t) {
      case 0:
        this.j = 2;
        this.k = ft.X - ft.aa - this.m - 2;
        if (ft.A) {
          this.k += ft.aa;
          return;
        } 
        break;
      case 1:
        this.j = ft.W - this.O - 2;
        this.k = ft.X - ft.aa - this.m - 2;
        if (ft.A) {
          this.k += ft.aa;
          return;
        } 
        break;
      case 2:
      case 4:
        this.j = ft.Y - this.O / 2;
        this.k = ft.X / 2 - this.m / 2 - 2 + this.l / 2 + 6;
        return;
      case 3:
        this.j = 2;
        this.k = 2;
        break;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    bt bt1;
    es es2;
    byte b;
    es es1 = bw.V;
    switch (paramInt1) {
      case 0:
        this.a = false;
        a(bt1 = (bt)this.g.a(this.h));
        break;
      case 2:
        q.a().b((short)this.C, (byte)this.B, (byte)this.h);
        this.a = false;
        ft.S = false;
        break;
      case 3:
        this.a = false;
        cn.b().j();
        break;
      case 4:
        this.a = false;
        (cn.b()).C.a();
        break;
      case 5:
        this.a = false;
        (cn.b()).B.a();
        break;
      case 6:
        this.a = false;
        bg.a.a();
        break;
      case 7:
        (cn.b()).A.a();
        break;
      case 8:
        bg.b.a();
        break;
      case 9:
        bg.c.a();
        break;
      case 10:
        (cn.b()).x.a();
        break;
      case 11:
        q.a().g((byte)-56);
        ft.a(df.aG);
        break;
      case 12:
        cn.f.N();
        l.a().c();
        ft.b.c();
        cn.f = new bq(0, (byte)0, "unname", 0, 0);
        break;
      case 1:
        f();
        break;
      case 14:
        es2 = new es("Menu2 vecngua");
        this.a = false;
        if (cn.f.ee != -1) {
          bg.d.a();
          break;
        } 
        for (b = 0; b < bt1.c(); b++) {
          j j;
          short s;
          if ((j = (j)bt1.a(b)) != null && j.u == 4 && (!((s = (short)j.O) != 62 && s != 63 && s != 64 && s != 65 && s != 66)))
            es2.a(j); 
        } 
        if (es2.c() > 0) {
          cn.b().a(es2);
          break;
        } 
        ft.a(df.R);
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  public final void c() {
    if (!y)
      return; 
    if (!this.a)
      return; 
    boolean bool = false;
    if (x) {
      if (ft.ak[2]) {
        bool = true;
        this.h--;
        if (this.h < 0)
          this.h = this.g.c() - 1; 
        ft.c(2);
      } else if (ft.ak[8]) {
        bool = true;
        this.h++;
        if (this.h > this.g.c() - 1)
          this.h = 0; 
        ft.c(8);
      } 
      int i = this.i;
      if (ft.ak[4]) {
        this.i--;
        ft.c(4);
      } 
      if (ft.ak[6]) {
        this.i++;
        ft.c(6);
      } 
      this.i = cg.a(this.i, this.A.c() - 1, true);
      if (this.i != i)
        e = (ez)this.A.a(this.i); 
    } else if (d == 1) {
      int i = this.h;
      if (ft.al[4] || ft.al[2]) {
        this.h--;
        ft.d(4);
        ft.d(2);
      } else if (ft.al[6] || ft.al[8]) {
        this.h++;
        ft.d(6);
        ft.d(8);
      } 
      this.h = cg.a(this.h, this.g.c() - 1, false);
      if (i != this.h)
        for (i = 0; i < this.g.c(); i++) {
          bt bt1 = (bt)this.g.a(i);
          if (i == this.h) {
            bt1.g = true;
          } else {
            bt1.g = false;
          } 
        }  
      if (ft.al[5]) {
        ft.d(5);
        if (this.h < this.g.c() && this.h >= 0)
          ((bt)this.g.a(this.h)).a(); 
      } 
    } else if (d == 0) {
      if (ft.ak[2] || ft.ak[4]) {
        bool = true;
        this.h--;
        if (this.h < 0)
          this.h = this.g.c() - 1; 
        ft.c(2);
        ft.c(4);
      } else if (ft.ak[8] || ft.ak[6]) {
        bool = true;
        this.h++;
        if (this.h > this.g.c() - 1)
          this.h = 0; 
        ft.c(6);
        ft.c(8);
      } 
    } 
    if (bool) {
      if (this.t == -1) {
        p = this.h * this.l + this.l - ft.W / 2;
      } else {
        p = (this.h + 1) * this.l - this.m / 2;
      } 
      if (p > r)
        p = r; 
      if (p < 0)
        p = 0; 
      if (this.h == this.g.c() - 1 || this.h == 0)
        q = p; 
    } 
    if (d == 0) {
      if (this.t == -1) {
        j();
      } else {
        fq fq1 = this;
        if (ft.ak[5]) {
          ft.m();
          ft.l();
          fq1.f();
          bt bt1;
          a(bt1 = (bt)fq1.g.a(fq1.h));
        } else if (ft.ak[12]) {
          ft.m();
          ft.l();
          fq1.f();
          bt bt1;
          a(bt1 = (bt)fq1.g.a(fq1.h));
        } 
        if (ft.S && x) {
          int i = fq1.i;
          if (ft.c(fq1.j + 13 - 14, fq1.n - fq1.o + ft.aa + fq1.l / 2 - 14, 28, 28)) {
            fq1.i--;
            ft.S = false;
          } 
          if (ft.c(fq1.j + fq1.O - 13 - 14, fq1.n - fq1.o + ft.aa + fq1.l / 2 - 14, 28, 28)) {
            fq1.i++;
            ft.S = false;
          } 
          fq1.i = cg.a(fq1.i, fq1.A.c() - 1, true);
          if (fq1.i != i)
            e = (ez)fq1.A.a(fq1.i); 
        } 
        if (ft.Q)
          if (!fq1.S && ft.a(fq1.j, fq1.k, fq1.O, fq1.m)) {
            for (byte b = 0; b < fq1.R.length; b++)
              fq1.R[0] = ft.af; 
            fq1.Q = ft.af;
            fq1.S = true;
            fq1.T = (fq1.V != 0);
            fq1.V = 0;
          } else if (fq1.S) {
            fq1.P++;
            if (fq1.P > 5 && fq1.Q == ft.af && !fq1.T) {
              fq1.Q = -1000;
              fq1.h = (p + ft.af - fq1.k) / fq1.l;
            } 
            int i;
            if ((i = ft.af - fq1.R[0]) != 0 && fq1.h != -1)
              fq1.h = -1; 
            for (int j = fq1.R.length - 1; j > 0; j--)
              fq1.R[j] = fq1.R[j - 1]; 
            fq1.R[0] = ft.af;
            if ((p -= i) < 0)
              p = 0; 
            if (p > r)
              p = r; 
            if (q < 0 || q > r)
              i /= 2; 
            q -= i;
          }  
        if (ft.U && fq1.S) {
          int i = ft.af - fq1.R[0];
          ft.U = false;
          if (ak.e(i) < 20 && ak.e(ft.af - fq1.Q) < 20 && !fq1.T && ft.S) {
            fq1.V = 0;
            p = q;
            fq1.Q = -1000;
            fq1.h = (p + ft.af - fq1.k) / fq1.l;
            fq1.P = 0;
            fq1.U = 1;
          } else if (fq1.h != -1 && fq1.P > 5) {
            fq1.P = 0;
            fq1.U = 1;
          } else if (fq1.h == -1 && !fq1.T) {
            if (q < 0) {
              p = 0;
            } else if (q > r) {
              p = r;
            } else {
              int j;
              if ((j = ft.af - fq1.R[0] + fq1.R[0] - fq1.R[1] + fq1.R[1] - fq1.R[2]) > 10) {
                j = 10;
              } else if (j < -10) {
                j = -10;
              } else {
                j = 0;
              } 
              fq1.V = -j * 100;
            } 
          } 
          fq1.S = false;
          fq1.P = 0;
          ft.U = false;
        } 
        if (ft.R && fq1.S)
          fq1.S = false; 
      } 
      if (ft.S && !ft.c(this.j - 5, this.n - 5 - this.o, this.O + 10, this.m + 10 + this.o) && !this.H)
        f(); 
    } else if (d == 2) {
      j();
      if (ft.S && !ft.c(this.j - 5, this.k - 5, this.O + 10, this.m + 10))
        this.E = -1; 
    } 
    d();
  }
  
  private void j() {
    if (ft.Q)
      if (!this.S && ft.a(this.j, this.k, this.O, this.m)) {
        for (byte b = 0; b < this.R.length; b++)
          this.R[0] = ft.ae; 
        this.Q = ft.ae;
        this.S = true;
        this.T = (this.V != 0);
        this.V = 0;
      } else if (this.S) {
        this.P++;
        if (this.P > 5 && this.Q == ft.ae && !this.T) {
          this.Q = -1000;
          this.h = (p + ft.ae - this.j) / this.l;
        } 
        int i;
        if ((i = ft.ae - this.R[0]) != 0 && this.h != -1)
          this.h = -1; 
        for (int j = this.R.length - 1; j > 0; j--)
          this.R[j] = this.R[j - 1]; 
        this.R[0] = ft.ae;
        if ((p -= i) < 0)
          p = 0; 
        if (p > r)
          p = r; 
        if (q < 0 || q > r)
          i /= 2; 
        q -= i;
      }  
    if (ft.U && this.S) {
      int i = ft.ae - this.R[0];
      ft.U = false;
      if (ak.e(i) < 20 && ak.e(ft.ae - this.Q) < 20 && !this.T) {
        this.V = 0;
        p = q;
        this.Q = -1000;
        this.h = (p + ft.ae - this.j) / this.l;
        this.P = 0;
        this.U = 1;
      } else if (this.h != -1 && this.P > 5) {
        this.P = 0;
        this.U = 1;
      } else if (this.h == -1 && !this.T) {
        if (q < 0) {
          p = 0;
        } else if (q > r) {
          p = r;
        } else {
          int j;
          if ((j = ft.ae - this.R[0] + this.R[0] - this.R[1] + this.R[1] - this.R[2]) > 10) {
            j = 10;
          } else if (j < -10) {
            j = -10;
          } else {
            j = 0;
          } 
          this.V = -j * 100;
        } 
      } 
      this.S = false;
      this.P = 0;
      ft.U = false;
    } 
    if (ft.R && this.S)
      this.S = false; 
  }
  
  public final void b(bx parambx) {
    ft.a(parambx);
    if (!z)
      return; 
    if (d == 1) {
      parambx = parambx;
      int i = (this = this).j + 6;
      int j = this.k + 8;
      cg.a(parambx, this.j, this.n, this.O, this.m, 12);
      ez ez1;
      if ((ez1 = ez.a(this.C, this.D)) != null) {
        ez1.b(parambx, this.j + this.O - 10, this.k);
        cg.a(parambx, ez1.cB, i + 10, j, 0);
        if (this.b != null)
          this.b.a(parambx, this.I); 
        ft.a(parambx);
        for (i = 0; i < this.g.c(); i++) {
          bt bt1;
          (bt1 = (bt)this.g.a(i)).a(parambx, bt1.h, bt1.i);
        } 
      } 
      return;
    } 
    if (d == 0) {
      cg.a(parambx, this.j - 6, this.n - this.o - 6, this.O + 12, this.m + this.o + 12, 0);
      cg.a(parambx, this.j, this.n, this.O, this.m, (byte)2);
      o.c.a(parambx, this.v, this.j + this.O / 2, this.n - this.o + ft.aa / 4, 2, true);
      if (x) {
        if (ft.B) {
          fl.c(parambx, this.j, this.k - this.o + ft.aa + 2, this.O, this.l - 4, 1);
        } else {
          for (byte b = 0; b <= this.O / 32; b++) {
            if (b < this.O / 32) {
              parambx.a(fl.aP[1], 0, 0, 32, this.l - 4, 0, this.j + (b << 5), this.n - this.o + ft.aa + 2, 0);
            } else {
              parambx.a(fl.aP[1], 0, 0, 32, this.l - 4, 0, this.j + this.O - 32, this.n - this.o + ft.aa + 2, 0);
            } 
          } 
        } 
        if (this.A.c() > 1) {
          parambx.a(fl.aP[7], 0, 16, 13, 8, 6, this.j + 8 - ft.ai % 3, this.n - this.o + ft.aa + this.l / 2, 3);
          parambx.a(fl.aP[7], 0, 24, 13, 8, 6, this.j + this.O - 8 + ft.ai % 3, this.n - this.o + ft.aa + this.l / 2, 3);
        } 
        cg.a(parambx, e.cB, this.j + this.O / 2 + 13, this.n - this.o + ft.aa + this.l / 4 + 3, 2, 2);
        int m = o.c.a(e.cB) / 2 + 1;
        e.a(parambx, this.j + this.O / 2 - m - 2, this.n - this.o + ft.aa + this.l / 4 + 8);
      } 
      if (!y)
        return; 
      if (this.t == -1) {
        parambx.d(this.j + 2, this.n + 2, this.O - 4, this.m - 4);
        parambx.a(-q, 0);
        for (byte b = 0; b < this.g.c(); b++) {
          if (b == this.h) {
            parambx.a(cg.aL[3]);
            parambx.a(this.j + b * this.l + 3, this.n + 3, this.l - 8, this.m - 6, 6, 6);
          } 
          String[] arrayOfString;
          if ((arrayOfString = ((bt)this.g.a(b)).b) == null)
            arrayOfString = new String[] { ((bt)this.g.a(b)).a }; 
          int m = this.n + (this.m - arrayOfString.length * 14) / 2 + 1;
          for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
            if (b == this.h) {
              o.f.a(parambx, arrayOfString[b1], this.j + b * this.l + this.l / 2 - 1, m + b1 * 14, 2, true);
            } else {
              o.c.a(parambx, arrayOfString[b1], this.j + b * this.l + this.l / 2 - 1, m + b1 * 14, 2, true);
            } 
          } 
        } 
        return;
      } 
      parambx.d(this.j + 3, this.k + 3, this.O - 6, this.m - 6);
      parambx.a(0, -q);
      parambx.a(cg.aL[4]);
      if (this.t == 2 || this.t == 4)
        for (byte b = 0; b < this.g.c() - 1; b++) {
          parambx.a(cg.aL[4]);
          parambx.c(this.j + 8, this.k + 3 + this.l + b * this.l, this.O - 16, 1);
        }  
      int i;
      if ((i = q / this.l - 1) < 0)
        i = 0; 
      int j;
      if ((j = i + this.u + 2) > this.g.c() && (i = (j = this.g.c()) - this.u - 2) < 0)
        i = 0; 
      if (this.h > -1)
        cg.a(parambx, this.j + 3, this.k + 3 + this.h * this.l, this.O - 6, this.l + 1); 
      int k;
      for (k = i; k < j; k++) {
        bt bt1 = (bt)this.g.a(k);
        if (this.t == 2) {
          bt1.c(parambx, this.j + this.O / 2, this.k + 6 + this.l / 4 + k * this.l, 2);
        } else if (this.t == 0 || this.t == 3) {
          bt1.c(parambx, this.j + 6, this.k + 6 + this.l / 4 + k * this.l, 0);
        } else if (this.t == 1) {
          bt1.c(parambx, this.j + this.O - 6, this.k + 6 + this.l / 4 + k * this.l, 1);
        } else if (this.t == 4) {
          bt1.c(parambx, this.j + 10, this.k + 6 + this.l / 4 + k * this.l, 0);
        } 
      } 
      ft.a(parambx);
      if (cn.p.a >= 0 && c && (k = cn.p.i()) >= 0) {
        fb.a(parambx, this.j - 6 - 70, this.k + 16 + k * this.l - ft.ab, 70, ft.ab, -1, df.gt);
        parambx.a(cg.ak, 0, 0, 12, 16, 4, this.j + 4 + ft.ai / 2 % 4, this.k + 14 + k * this.l, 10);
      } 
      if (!this.H) {
        c(parambx);
        return;
      } 
    } else if (d == 2) {
      if (this.J) {
        parambx.a(cf.k[4], 0, 0, 20, 16, 0, this.j - 20, this.k + this.m - 16, 0);
        parambx.a(cf.k[4], 20, 0, 20, 16, 0, this.j + this.F, this.k + this.m - 16, 0);
        if (this.F == this.m) {
          parambx.a(cf.n, 20, 0, 20, 40, 2, this.j, this.k, 0);
          parambx.a(cf.n, 20, 0, 20, 40, 0, this.j + 20, this.k, 0);
        } else {
          for (int i = 0; i < this.F; i += this.m) {
            if (i == 0) {
              parambx.a(cf.n, 0, 0, 40, 40, 2, this.j, this.k, 0);
            } else if (i + this.m >= this.F) {
              parambx.a(cf.n, 0, 0, 40, 40, 0, this.j + i, this.k, 0);
            } else {
              parambx.a(cf.n, 0, 20, 40, 40, 0, this.j + i, this.k, 0);
            } 
          } 
        } 
        parambx.d(this.j + 5, this.k - 20, this.F - 10, this.m + 20);
      } else {
        parambx.a(cf.k[4], 0, 0, 20, 16, 0, this.j + this.O / 2 - this.F / 2 - 20, this.k + this.m - 16, 0);
        parambx.a(cf.k[4], 20, 0, 20, 16, 0, this.j + this.O / 2 + this.F / 2, this.k + this.m - 16, 0);
        if (this.F == this.m) {
          parambx.a(cf.n, 20, 0, 20, 40, 2, this.j + this.O / 2 - 20, this.k, 0);
          parambx.a(cf.n, 20, 0, 20, 40, 0, this.j + this.O / 2, this.k, 0);
        } else {
          for (int i = 0; i < this.F; i += this.m) {
            if (i == 0) {
              parambx.a(cf.n, 0, 0, 40, 40, 2, this.j + this.O / 2 - this.F / 2 + i, this.k, 0);
            } else if (i + this.m >= this.F) {
              parambx.a(cf.n, 0, 0, 40, 40, 0, this.j + this.O / 2 - this.F / 2 + i, this.k, 0);
            } else {
              parambx.a(cf.n, 0, 20, 40, 40, 0, this.j + this.O / 2 - this.F / 2 + i, this.k, 0);
            } 
          } 
        } 
        parambx.d(this.j + this.O / 2 - this.F / 2 + 5, this.k - 20, this.F - 10, this.m + 20);
      } 
      parambx.a(-q, 0);
      byte b;
      for (b = 0; b < this.g.c(); b++) {
        bt bt1;
        (bt1 = (bt)this.g.a(b)).a(parambx, bt1.h, bt1.i);
      } 
      ft.a(parambx);
      parambx.a(-q, 0);
      for (b = 0; b < this.g.c(); b++) {
        bt bt1;
        (bt1 = (bt)this.g.a(b)).b(parambx, bt1.h, bt1.i, 2);
      } 
    } 
  }
  
  public final void f() {
    this.a = false;
    this.H = false;
    ft.S = false;
    ft.U = false;
    ft.V = true;
  }
  
  public final void g() {
    if (this.E > 0) {
      this.E = (byte)(this.E + 1);
      if (this.F < this.O) {
        this.F += this.m;
        if (this.F >= this.O) {
          this.F = this.O;
          this.E = 0;
        } 
      } 
    } else if (this.E < 0) {
      this.E = (byte)(this.E - 1);
      if (this.F > 0) {
        this.F -= this.m;
        if (this.F <= 0) {
          this.F = 0;
          this.E = 0;
          f();
        } 
      } 
    } 
    if (!z)
      return; 
    fq fq1;
    if ((fq1 = this).V != 0 && !fq1.S) {
      if ((p += fq1.V / 100) < 0) {
        p = 0;
      } else if (p > r) {
        p = r;
      } else {
        q = p;
      } 
      fq1.V = fq1.V * 9 / 10;
      if (fq1.V < 100 && fq1.V > -100)
        fq1.V = 0; 
    } 
    if (q != p && !fq1.S) {
      fq1.W = p - q << 2;
      fq1.X += fq1.W;
      q += fq1.X >> 4;
      fq1.X &= 0xF;
    } 
    if (d == 1) {
      if (this.b != null)
        this.b.b(); 
      for (byte b = 0; b < this.g.c(); b++) {
        bt bt1;
        (bt1 = (bt)this.g.a(b)).b();
      } 
    } else if (d == 2 && !ft.T && this.E == 0) {
      for (byte b = 0; b < this.g.c(); b++) {
        bt bt1;
        (bt1 = (bt)this.g.a(b)).b(q, 0);
      } 
    } 
    if (this.n > this.k) {
      int i;
      if ((i = this.n - this.k >> 1) < 1)
        i = 1; 
      this.n -= i;
    } 
    if (s != 0 && (s >>= 1) < 0)
      s = 0; 
    if (this.U > 0) {
      this.U--;
      if (this.U == 0) {
        this.a = false;
        if (this.h >= 0) {
          bt bt1;
          a(bt1 = (bt)this.g.a(this.h));
          ft.m();
          ft.l();
          ft.V = true;
          ft.S = false;
        } 
      } 
    } 
    e();
  }
  
  private static void a(bt parambt) {
    if (parambt != null) {
      if (parambt.c == null)
        if (parambt.d != null) {
          parambt.d.a(parambt.e, parambt.f);
        } else {
          ft.a.a_(parambt.e, parambt.f);
        }  
      ft.S = false;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fq.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */