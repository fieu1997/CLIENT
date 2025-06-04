public final class ff extends p {
  private int h = ft.aa + 5;
  
  public int a = ft.W / 4 * 3;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  public int b;
  
  private int p;
  
  private bt q = new bt(df.ay, 2, 0, this);
  
  private bt r = new bt(df.fK, 2, 1, this);
  
  public static es f = new es("EventScreen vecListEvent");
  
  public static es g = new es("EventScreen vecEventShow");
  
  private static es s = new es("EventScreen cmdList");
  
  private aw t = new aw();
  
  private bp u;
  
  private int v;
  
  private int w;
  
  public ff() {
    if (this.a > 180)
      this.a = 180; 
  }
  
  public final void b() {
    this.q.a = df.ay;
    this.r.a = df.fK;
  }
  
  public final void a(p paramp) {
    super.a(paramp);
    cf.i = 0;
  }
  
  public final void g() {
    for (byte b = 0; b < f.c(); b++) {
      fm fm;
      if ((fm = (fm)f.a(b)).g) {
        f.d(fm);
        b--;
      } 
    } 
    this.j = bt.k * 3 / 2;
    if (ft.A)
      this.j = 0; 
    this.i = (ft.X / 4 * 3 - 10 + ft.aa) / this.h + 1;
    this.k = this.h * this.i + 10 + ft.aa;
    this.i += 2;
    this.l = 0;
    this.m = this.i;
    if (this.m > f.c())
      this.m = f.c(); 
    this.n = ft.Y - this.a / 2;
    this.o = ft.Z - this.k / 2 - ft.aa / 2;
    h();
  }
  
  private void h() {
    s.d();
    bt bt1 = new bt(df.Z, -1, this);
    if (ft.A) {
      bt1.a(this.n + this.a - 12, this.o + 10, cf.t, "");
      s.a(bt1);
    } else {
      if (f.c() > 0) {
        bt bt2 = new bt(df.X, 1, this);
        s.a(bt2);
      } 
      s.a(bt1);
      b(0);
      this.Z = bt1;
    } 
    this.t.a(0, this.h * f.c() - this.k - ft.aa - this.j, 0, 0);
    this.u = new bp(this.n, this.o, this.a, this.k, 0, 0, this.t.f);
    if (this.b >= f.c()) {
      if (ft.A) {
        this.b = -1;
        return;
      } 
      this.b = 0;
    } 
  }
  
  private void b(int paramInt) {
    this.p = 0;
    if (s.c() > 0) {
      if ((paramInt = s.c()) == 1) {
        this.v = this.n + this.a / 2;
        this.w = 0;
      } else {
        2;
        this.w = 20;
        this.v = this.n + this.a / 2 - this.w / 2 - bt.j / 2;
      } 
      for (byte b = 0; b < paramInt; b++) {
        bt bt1;
        (bt1 = (bt)s.a(b)).g = false;
        if (paramInt == 3 && b == 2) {
          bt1.a(this.n + this.a / 2, this.o + this.k - bt.k - (paramInt - 1) / 2 * (bt.k + 5) + 7 + b / 2 * (bt.k + 5), (ce)null, bt1.a);
        } else {
          bt1.a(this.v + b % 2 * (bt.j + this.w), this.o + this.k - bt.k - (paramInt - 1) / 2 * (bt.k + 5) + 7 + b / 2 * (bt.k + 5), (ce)null, bt1.a);
        } 
        if (b == 0)
          bt1.g = true; 
      } 
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    fm fm;
    switch (paramInt1) {
      case -1:
        this.c.a(this.c.c);
        return;
      case 1:
        if (this.b < 0 || this.b >= f.c())
          return; 
        if (this.b > 0) {
          es es1;
          (es1 = new es("EventScreen vec")).a(this.q);
          es1.a(this.r);
          ft.o.a(es1, 2, df.eo, false, (es)null);
          return;
        } 
        this.q.a();
        return;
      case 2:
        if (this.b < 0 || this.b >= f.c())
          return; 
        paramInt1 = 0;
        if (paramInt2 == 1)
          paramInt1 = 1; 
        fm = (fm)f.a(this.b);
        a(paramInt1, this);
        break;
    } 
  }
  
  public final void a(bx parambx) {
    if (this.c != null)
      this.c.a(parambx); 
    if (ft.a != this)
      return; 
    ft.a(parambx);
    cg.a(parambx, this.n, this.o, this.a, this.k, df.eo);
    int i = this.o + ft.aa + 3;
    if (f.c() > 0) {
      parambx.d(this.n + 4, i, this.a - 8, this.k - ft.aa - this.j - 6);
      parambx.a(0, -this.t.b);
      if (this.b >= 0) {
        parambx.a(-4873075);
        parambx.c(this.n + 4, i - 2 + this.b * this.h, this.a - 8, this.h - 1);
      } 
      i += this.h * this.l;
      for (int j = this.l; j < this.m; j++) {
        if (j >= 0 || j < f.c()) {
          fm fm = (fm)f.a(j);
          byte b = 0;
          if (fm.c == 1 && ft.ai % 20 > 9)
            b = 1; 
          cf.x.b((fm.b << 1) + 1 - b, this.n + 20, i + this.h / 2 - 2, 0, 3, parambx);
          if (ft.A && j > 0)
            cf.o.b(0, this.n + this.a - 20, i + this.h / 2 - 2, 0, 3, parambx); 
          o.f.a(parambx, fm.e, this.n + 35, i + 1, 0, true);
          o.j.a(parambx, fm.f, this.n + 42, i + 13, 0, true);
          i += this.h;
          if (j < f.c() - 1) {
            parambx.a(cg.aL[4]);
            parambx.c(this.n + 6, i - 3, this.a - 12, 1);
          } 
        } 
      } 
    } else {
      o.j.a(parambx, df.en, this.n + this.a / 2, i + 3, 2, true);
    } 
    ft.a(parambx);
    if (s != null)
      for (byte b = 0; b < s.c(); b++) {
        bt bt1;
        (bt1 = (bt)s.a(b)).a(parambx, bt1.h, bt1.i);
      }  
    d(parambx);
  }
  
  public final void a() {
    if (ft.a == this)
      this.c.a(); 
    int i = this.t.b;
    if (ft.A) {
      this.u.c();
    } else {
      this.t.a();
    } 
    super.a();
    int j = f.c();
    for (byte b = 0; b < f.c(); b++) {
      fm fm;
      if ((fm = (fm)f.a(b)).g) {
        f.d(fm);
        b--;
      } 
    } 
    if (this.b < 0 || this.b >= f.c())
      if (ft.A) {
        this.b = -1;
      } else {
        this.b = 0;
      }  
    if (this.t.b != i || j != f.c()) {
      this.l = this.t.b / this.h;
      this.m = this.l + this.i;
      if (this.m > f.c()) {
        this.m = f.c();
        this.l = this.m - this.i;
      } 
      if (this.l < 0)
        this.l = 0; 
    } 
  }
  
  public final void d() {
    if (f.c() > 0) {
      if (ft.al[2]) {
        this.b--;
        ft.d(2);
      } else if (ft.al[8]) {
        this.b++;
        ft.d(8);
      } 
      this.b = cg.a(this.b, f.c() - 1, true);
      this.t.a(0, this.b * this.h - this.k / 2 - ft.aa - this.j);
    } else if (s.c() > 1) {
      s.d();
      s.a(new bt(df.Z, -1, this));
      b(0);
      this.b = 0;
    } 
    if (s != null) {
      int i = s.c();
      if (!ft.A && i > 0) {
        int j = this.p;
        if (ft.al[4]) {
          this.p--;
          ft.d(4);
        } else if (ft.al[6]) {
          this.p++;
          ft.d(6);
        } 
        this.p = cg.a(this.p, i - 1, false);
        if (j != this.p)
          for (j = 0; j < i; j++) {
            bt bt1 = (bt)s.a(j);
            if (j == this.p) {
              bt1.g = true;
            } else {
              bt1.g = false;
            } 
          }  
      } 
    } 
    if (ft.al[5]) {
      ft.d(5);
      if (s != null && this.p < s.c())
        ((bt)s.a(this.p)).a(); 
    } 
    super.d();
  }
  
  public final void e() {
    if (ft.A) {
      this.u.a();
      this.t.b = this.u.f;
    } 
    int i;
    if (f.c() > 0 && ft.b(this.n, this.o + ft.aa, this.a, this.k - ft.aa) && (i = (ft.af - this.o + ft.aa) / this.h) >= 0 && i <= f.c() - 1) {
      this.b = i;
      this.b = cg.a(this.b, f.c() - 1, false);
      boolean bool = false;
      if (ft.b(this.n + this.a - 30, this.o + ft.aa, 30, this.k - ft.aa) && this.b > 0)
        bool = true; 
      fm fm = (fm)f.a(this.b);
      a(bool, this);
      ft.S = false;
    } 
    if (s != null)
      for (i = 0; i < s.c(); i++) {
        bt bt1;
        (bt1 = (bt)s.a(i)).b();
      }  
  }
  
  public static void a(boolean paramBoolean, fm paramfm) {
    if (paramBoolean) {
      paramfm.g = true;
      return;
    } 
    es es1 = null;
    if (cf.i > 0)
      cf.i--; 
    switch (paramfm.b) {
      case 0:
        et.a(paramfm.e);
        ft.h();
        paramfm.c = 0;
        return;
      case 1:
        (es1 = new es("EventScreen vec2")).a(new bt(df.bI, 1, 1, paramfm));
        es1.a(new bt(df.bJ, 1, 2, paramfm));
        es1.a(new bt(df.Z, -1));
        ft.a(String.valueOf(paramfm.e) + df.bH, es1);
        paramfm.c = 0;
        return;
      case 2:
        (es1 = new es("EventScreen vec3")).a(new bt(df.bI, 2, 1, paramfm));
        es1.a(new bt(df.bJ, 2, 0, paramfm));
        es1.a(new bt(df.Z, -1));
        ft.a(String.valueOf(paramfm.e) + df.cf, es1);
        paramfm.c = 0;
        return;
      case 3:
        (es1 = new es("EventScreen vec4")).a(new bt(df.bI, 3, 1, paramfm));
        es1.a(new bt(df.bJ, 3, 0, paramfm));
        es1.a(new bt(df.Z, -1));
        ft.a(String.valueOf(paramfm.e) + df.cl, es1);
        paramfm.c = 0;
        return;
      case 4:
        (es1 = new es("EventScreen vec5")).a(new bt(df.bI, 4, 1, paramfm));
        es1.a(new bt(df.bK, 4, 2, paramfm));
        es1.a(new bt(df.as, 4, 0, paramfm));
        ft.a(String.valueOf(paramfm.e) + df.et + paramfm.d + " " + df.bO + ".", es1);
        paramfm.c = 0;
        return;
      case 5:
        (es1 = new es("EventScreen vec6")).a(new bt(df.bI, 5, 1, paramfm));
        es1.a(new bt(df.Z, -1));
        ft.a(String.valueOf(paramfm.e) + df.eC, es1);
        paramfm.c = 0;
        break;
    } 
  }
  
  public static fm a(String paramString, byte paramByte) {
    for (byte b = 0; b < f.c(); b++) {
      fm fm;
      if ((fm = (fm)f.a(b)).g) {
        f.d(fm);
        b--;
      } else if (fm.b == paramByte && fm.e.compareTo(paramString) == 0) {
        return fm;
      } 
    } 
    return null;
  }
  
  public static int b(String paramString, byte paramByte) {
    for (byte b = 0; b < f.c(); b++) {
      fm fm;
      if ((fm = (fm)f.a(b)).b == paramByte && fm.e.compareTo(paramString) == 0)
        return b; 
    } 
    return -1;
  }
  
  public final void a(String paramString1, byte paramByte, String paramString2, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokestatic a : (Ljava/lang/String;B)Lfm;
    //   5: dup
    //   6: astore #5
    //   8: ifnonnull -> 116
    //   11: new fm
    //   14: dup
    //   15: iconst_0
    //   16: iload_2
    //   17: aload_1
    //   18: aload_3
    //   19: invokespecial <init> : (IILjava/lang/String;Ljava/lang/String;)V
    //   22: astore #5
    //   24: getstatic ff.f : Les;
    //   27: aload #5
    //   29: invokevirtual a : (Ljava/lang/Object;)V
    //   32: aload_0
    //   33: invokespecial h : ()V
    //   36: aload_0
    //   37: aload_0
    //   38: getfield t : Law;
    //   41: getfield b : I
    //   44: aload_0
    //   45: getfield h : I
    //   48: idiv
    //   49: putfield l : I
    //   52: aload_0
    //   53: aload_0
    //   54: getfield l : I
    //   57: aload_0
    //   58: getfield i : I
    //   61: iadd
    //   62: putfield m : I
    //   65: aload_0
    //   66: getfield m : I
    //   69: getstatic ff.f : Les;
    //   72: invokevirtual c : ()I
    //   75: if_icmple -> 101
    //   78: aload_0
    //   79: getstatic ff.f : Les;
    //   82: invokevirtual c : ()I
    //   85: putfield m : I
    //   88: aload_0
    //   89: aload_0
    //   90: getfield m : I
    //   93: aload_0
    //   94: getfield i : I
    //   97: isub
    //   98: putfield l : I
    //   101: aload_0
    //   102: getfield l : I
    //   105: ifge -> 126
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield l : I
    //   113: goto -> 126
    //   116: iload_2
    //   117: ifne -> 126
    //   120: aload #5
    //   122: aload_3
    //   123: putfield f : Ljava/lang/String;
    //   126: aload_1
    //   127: getstatic df.cz : Ljava/lang/String;
    //   130: invokevirtual compareTo : (Ljava/lang/String;)I
    //   133: ifeq -> 295
    //   136: getstatic cf.i : I
    //   139: iconst_1
    //   140: iadd
    //   141: putstatic cf.i : I
    //   144: aload #5
    //   146: iconst_1
    //   147: putfield c : I
    //   150: aload #5
    //   152: iload #4
    //   154: putfield d : I
    //   157: iload_2
    //   158: ifne -> 181
    //   161: aload_1
    //   162: getstatic df.eV : Ljava/lang/String;
    //   165: invokevirtual compareTo : (Ljava/lang/String;)I
    //   168: ifeq -> 295
    //   171: aload_1
    //   172: getstatic df.eU : Ljava/lang/String;
    //   175: invokevirtual compareTo : (Ljava/lang/String;)I
    //   178: ifeq -> 295
    //   181: aload_1
    //   182: iload_2
    //   183: istore_1
    //   184: astore_0
    //   185: iconst_0
    //   186: istore_3
    //   187: goto -> 230
    //   190: getstatic ff.g : Les;
    //   193: iload_3
    //   194: invokevirtual a : (I)Ljava/lang/Object;
    //   197: checkcast fm
    //   200: dup
    //   201: astore #4
    //   203: getfield b : I
    //   206: iload_1
    //   207: if_icmpne -> 227
    //   210: aload #4
    //   212: getfield e : Ljava/lang/String;
    //   215: aload_0
    //   216: invokevirtual compareTo : (Ljava/lang/String;)I
    //   219: ifne -> 227
    //   222: aload #4
    //   224: goto -> 241
    //   227: iinc #3, 1
    //   230: iload_3
    //   231: getstatic ff.g : Les;
    //   234: invokevirtual c : ()I
    //   237: if_icmplt -> 190
    //   240: aconst_null
    //   241: dup
    //   242: astore_0
    //   243: ifnonnull -> 282
    //   246: new fm
    //   249: dup
    //   250: aload #5
    //   252: getfield a : I
    //   255: aload #5
    //   257: getfield b : I
    //   260: aload #5
    //   262: getfield e : Ljava/lang/String;
    //   265: aload #5
    //   267: getfield f : Ljava/lang/String;
    //   270: invokespecial <init> : (IILjava/lang/String;Ljava/lang/String;)V
    //   273: astore_0
    //   274: getstatic ff.g : Les;
    //   277: aload_0
    //   278: invokevirtual a : (Ljava/lang/Object;)V
    //   281: return
    //   282: iload_2
    //   283: ifne -> 295
    //   286: aload_0
    //   287: aload #5
    //   289: getfield f : Ljava/lang/String;
    //   292: putfield f : Ljava/lang/String;
    //   295: return
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ff.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */