public final class dr extends fl {
  private fz c = new fz();
  
  private int d;
  
  private int e;
  
  private int f;
  
  static dr a;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k = 0;
  
  private bt l;
  
  private bt m;
  
  private bt n;
  
  private bt o;
  
  private int p;
  
  private int q;
  
  public static String[] b = null;
  
  private es r = new es("TabQuest vecListCmd");
  
  private ew s;
  
  private boolean t = false;
  
  private int u = 0;
  
  public dr() {
    this.K = 4;
    a = this;
    this.X = "";
    this.j = ft.ab;
    if (ft.A)
      this.j = ft.aa; 
    this.V = this.L + fl.aM + fl.aN * 3;
    this.W = 0 + ft.X / 5 + fl.aM;
    b();
    this.l = new bt(df.ay, 0, this);
    this.m = new bt(df.ax, 1, this);
    this.n = new bt(df.af, -1, this);
    this.o = new bt(df.as, 2, this);
    int i = fl.aW + this.N;
    int j = fl.aV;
    this.o.a(j + fl.aU / 2, i - 15, (ce)null, this.o.a);
    if (fl.aZ)
      this.o.a(this.o.h, i - 10, cf.v, this.o.a); 
    if (ft.A)
      this.n.a = df.Z; 
  }
  
  public final void b() {
    a(true);
    this.g = (fl.S - (this.h << 1)) / 2;
    if (!ft.A)
      this.Z = this.n; 
    this.bp = null;
    this.bj = null;
    this.bl = null;
    this.s = null;
    this.aY = null;
    super.b();
  }
  
  public final void c() {
    fl.aO = 0;
    this.d = 0;
    super.c();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    ew ew1;
    switch (paramInt1) {
      case 0:
        r.b().c();
        break;
      case 1:
        if ((ew1 = f()) != null)
          ft.a(ew1); 
        break;
      case -1:
        c();
        break;
      case 2:
        if (this.s == null)
          return; 
        ft.c(String.valueOf(df.aE) + this.s.k, new bt(df.as, 3, this));
        break;
      case 3:
        if (this.s == null)
          return; 
        q.a().a((short)this.s.f, (byte)(this.s.j ? 0 : 1), (byte)2);
        dw.a("huy nhiem vu ");
        a(true);
        ft.j();
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  private ew f() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic ew.c : Les;
    //   5: invokevirtual c : ()I
    //   8: istore_1
    //   9: aload_0
    //   10: getfield d : I
    //   13: iflt -> 31
    //   16: aload_0
    //   17: getfield d : I
    //   20: iload_1
    //   21: getstatic ew.d : Les;
    //   24: invokevirtual c : ()I
    //   27: iadd
    //   28: if_icmplt -> 33
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: getfield d : I
    //   37: iload_1
    //   38: if_icmpge -> 254
    //   41: getstatic ew.c : Les;
    //   44: aload_0
    //   45: getfield d : I
    //   48: invokevirtual a : (I)Ljava/lang/Object;
    //   51: checkcast ew
    //   54: dup
    //   55: astore_1
    //   56: aload_1
    //   57: getfield l : Ljava/lang/String;
    //   60: putfield n : Ljava/lang/String;
    //   63: aload_1
    //   64: getfield e : B
    //   67: ifeq -> 78
    //   70: aload_1
    //   71: getfield e : B
    //   74: iconst_1
    //   75: if_icmpne -> 522
    //   78: aload_1
    //   79: dup
    //   80: getfield n : Ljava/lang/String;
    //   83: new java/lang/StringBuffer
    //   86: dup_x1
    //   87: swap
    //   88: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: ldc '\\n '
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   99: getstatic df.cN : Ljava/lang/String;
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   105: invokevirtual toString : ()Ljava/lang/String;
    //   108: putfield n : Ljava/lang/String;
    //   111: iconst_0
    //   112: istore_0
    //   113: goto -> 242
    //   116: ldc ''
    //   118: astore_2
    //   119: aload_1
    //   120: getfield e : B
    //   123: iconst_1
    //   124: if_icmpne -> 149
    //   127: aload_1
    //   128: getfield o : [S
    //   131: iload_0
    //   132: saload
    //   133: invokestatic b : (I)Ldb;
    //   136: dup
    //   137: astore_3
    //   138: ifnull -> 166
    //   141: aload_3
    //   142: getfield e : Ljava/lang/String;
    //   145: astore_2
    //   146: goto -> 166
    //   149: getstatic dr.b : [Ljava/lang/String;
    //   152: ifnull -> 166
    //   155: getstatic dr.b : [Ljava/lang/String;
    //   158: aload_1
    //   159: getfield o : [S
    //   162: iload_0
    //   163: saload
    //   164: aaload
    //   165: astore_2
    //   166: aload_1
    //   167: dup
    //   168: getfield n : Ljava/lang/String;
    //   171: new java/lang/StringBuffer
    //   174: dup_x1
    //   175: swap
    //   176: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   179: invokespecial <init> : (Ljava/lang/String;)V
    //   182: ldc '\\n '
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   187: aload_2
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   191: aload_2
    //   192: ldc ''
    //   194: invokevirtual equals : (Ljava/lang/Object;)Z
    //   197: ifeq -> 205
    //   200: ldc ''
    //   202: goto -> 207
    //   205: ldc ': '
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   210: aload_1
    //   211: getfield q : [S
    //   214: iload_0
    //   215: saload
    //   216: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   219: ldc '/'
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   224: aload_1
    //   225: getfield p : [S
    //   228: iload_0
    //   229: saload
    //   230: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   233: invokevirtual toString : ()Ljava/lang/String;
    //   236: putfield n : Ljava/lang/String;
    //   239: iinc #0, 1
    //   242: iload_0
    //   243: aload_1
    //   244: getfield o : [S
    //   247: arraylength
    //   248: if_icmplt -> 116
    //   251: goto -> 522
    //   254: getstatic ew.d : Les;
    //   257: aload_0
    //   258: getfield d : I
    //   261: iload_1
    //   262: isub
    //   263: invokevirtual a : (I)Ljava/lang/Object;
    //   266: checkcast ew
    //   269: dup
    //   270: astore_1
    //   271: aload_1
    //   272: getfield l : Ljava/lang/String;
    //   275: putfield n : Ljava/lang/String;
    //   278: aload_1
    //   279: getfield e : B
    //   282: ifeq -> 293
    //   285: aload_1
    //   286: getfield e : B
    //   289: iconst_1
    //   290: if_icmpne -> 522
    //   293: aload_1
    //   294: dup
    //   295: getfield n : Ljava/lang/String;
    //   298: new java/lang/StringBuffer
    //   301: dup_x1
    //   302: swap
    //   303: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   306: invokespecial <init> : (Ljava/lang/String;)V
    //   309: ldc '\\n '
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   314: getstatic df.cN : Ljava/lang/String;
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   320: invokevirtual toString : ()Ljava/lang/String;
    //   323: putfield n : Ljava/lang/String;
    //   326: iconst_0
    //   327: istore_0
    //   328: goto -> 513
    //   331: aconst_null
    //   332: astore_2
    //   333: aload_1
    //   334: getfield e : B
    //   337: iconst_1
    //   338: if_icmpne -> 378
    //   341: ldc ''
    //   343: astore_2
    //   344: aload_1
    //   345: getfield o : [S
    //   348: iload_0
    //   349: saload
    //   350: invokestatic b : (I)Ldb;
    //   353: ifnull -> 437
    //   356: aload_1
    //   357: getfield o : [S
    //   360: iload_0
    //   361: saload
    //   362: invokestatic b : (I)Ldb;
    //   365: dup
    //   366: astore_3
    //   367: ifnull -> 437
    //   370: aload_3
    //   371: getfield e : Ljava/lang/String;
    //   374: astore_2
    //   375: goto -> 437
    //   378: new java/lang/StringBuffer
    //   381: dup
    //   382: ldc 'loi quest '
    //   384: invokespecial <init> : (Ljava/lang/String;)V
    //   387: aload_1
    //   388: getfield o : [S
    //   391: iload_0
    //   392: saload
    //   393: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   396: ldc ' '
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   401: getstatic dr.b : [Ljava/lang/String;
    //   404: arraylength
    //   405: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   408: ldc ' '
    //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   413: aload_1
    //   414: getfield e : B
    //   417: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   420: invokevirtual toString : ()Ljava/lang/String;
    //   423: invokestatic a : (Ljava/lang/String;)V
    //   426: getstatic dr.b : [Ljava/lang/String;
    //   429: aload_1
    //   430: getfield o : [S
    //   433: iload_0
    //   434: saload
    //   435: aaload
    //   436: astore_2
    //   437: aload_1
    //   438: dup
    //   439: getfield n : Ljava/lang/String;
    //   442: new java/lang/StringBuffer
    //   445: dup_x1
    //   446: swap
    //   447: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   450: invokespecial <init> : (Ljava/lang/String;)V
    //   453: ldc '\\n '
    //   455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   458: aload_2
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   462: aload_2
    //   463: ldc ''
    //   465: invokevirtual equals : (Ljava/lang/Object;)Z
    //   468: ifeq -> 476
    //   471: ldc ''
    //   473: goto -> 478
    //   476: ldc ': '
    //   478: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   481: aload_1
    //   482: getfield q : [S
    //   485: iload_0
    //   486: saload
    //   487: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   490: ldc '/'
    //   492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   495: aload_1
    //   496: getfield p : [S
    //   499: iload_0
    //   500: saload
    //   501: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   504: invokevirtual toString : ()Ljava/lang/String;
    //   507: putfield n : Ljava/lang/String;
    //   510: iinc #0, 1
    //   513: iload_0
    //   514: aload_1
    //   515: getfield o : [S
    //   518: arraylength
    //   519: if_icmplt -> 331
    //   522: aload_1
    //   523: areturn
  }
  
  private void h() {
    if (fl.aU == 0)
      return; 
    this.r.d();
    this.s = f();
    if (this.s != null) {
      this.bp = this.s.k;
      this.bj = o.j.a(this.s.n, fl.aU - 8);
      int i;
      if ((i = this.s.n.length() * ft.ab - fl.U - (bt.k << 1)) < 0)
        i = 0; 
      this.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, i);
      if (ft.A)
        this.r.a(this.o); 
      this.bl = null;
      return;
    } 
    this.bp = null;
    this.bj = null;
    this.bl = null;
    this.s = null;
  }
  
  public final void a(bx parambx) {
    bx bx1;
    int j = this.L + fl.aM + fl.aN * 3 + this.g;
    int k = 0 + ft.X / 5 + fl.aN;
    if (this.k == 0) {
      a(parambx, j + this.h, k - 1, this.h);
      o.j.a(parambx, df.gy[1], j + this.h + this.h / 2, k + fl.aM / 2 - 7, 2, false);
    } else {
      a(parambx, j, k - 1, this.h);
      o.j.a(parambx, df.gy[0], j + this.h / 2, k + fl.aM / 2 - 7, 2, false);
      j += this.h;
    } 
    this.i = j;
    int m = this.h;
    int i1 = k - 1;
    int n = this.i;
    bx bx2 = parambx;
    if (ft.B) {
      fl.c(bx2, n, i1, m, 32, 2);
    } else {
      for (byte b = 0; b <= m / 32; b++) {
        if (b == 0) {
          bx2.a(fl.aP[9], n, i1, 0);
        } else if (b == m / 32) {
          bx2.a(fl.aP[9], 0, 0, 32, 32, 2, n + m - 32, i1, 0);
        } else {
          bx2.a(fl.aP[2], n + (b << 5), i1, 0);
        } 
      } 
    } 
    o o = o.f;
    if (fl.aO == 0)
      o = o.j; 
    o.a(parambx, df.gy[this.k], this.i + this.h / 2, k + fl.aM / 2 - 7, 2, false);
    parambx.d(this.V, this.W, fl.S, fl.T);
    parambx.a(0, -p.e.b);
    k = this.W + 4;
    int i = this.V + 4;
    m = 0;
    if (this.e == 0) {
      i1 = k + fl.aN;
      n = i + fl.S / 2 - 4;
      bx1 = parambx;
      o.j.a(bx1, df.ft, n, i1, 2, false);
      k += this.j;
    } else if (this.k == 1) {
      for (n = 0; n < ew.b.c(); n++) {
        if (fl.aO == 1 && this.d == n)
          parambx.a(cg.ak, 0, 0, 12, 16, 4, bx1 - ft.ai % 3, k, 0); 
        ew ew1 = (ew)ew.b.a(n);
        o.f.a(parambx, ew1.k, bx1 + 18, k, 0, true);
        if (fl.aO == 1 && this.d == n)
          for (byte b = 0; b < ew1.m.length; b++) {
            k += ft.ab;
            o.j.a(parambx, ew1.m[b], bx1 + 25, k, 0, true);
          }  
        k += this.j;
        m++;
      } 
    } else {
      if (ew.c.c() > 0) {
        cg.a(parambx, df.an, bx1, k, 0);
        k += this.j;
        for (n = 0; n < ew.c.c(); n++) {
          if (fl.aO == 1 && this.d == m)
            parambx.a(cg.ak, 0, 0, 12, 16, 4, bx1 - ft.ai % 3, k, 0); 
          ew ew1 = (ew)ew.c.a(n);
          o.f.a(parambx, ew1.k, bx1 + 18, k, 0, false);
          k += this.j;
          m++;
        } 
      } 
      if (ew.d.c() > 0) {
        cg.a(parambx, df.ao, bx1, k, 0);
        k += this.j;
        for (n = 0; n < ew.d.c(); n++) {
          ew ew1 = (ew)ew.d.a(n);
          if (fl.aO == 1 && this.d == m)
            parambx.a(cg.ak, 0, 0, 12, 16, 4, bx1 - ft.ai % 3, k, 0); 
          o.f.a(parambx, ew1.k, bx1 + 18, k, 0, false);
          k += this.j;
          m++;
        } 
      } 
    } 
    k += this.j / 2;
    if (fl.aO == 1 && this.d == m) {
      parambx.a(fl.bf[3]);
      parambx.c(this.V + fl.S / 2 - 49, k - 1, 98, 18);
    } 
    this.p = this.V + fl.S / 2 - 48;
    this.q = k;
    if (ft.B) {
      fl.c(parambx, this.p, this.q, 96, 16, 4);
    } else {
      for (n = 0; n < 4; n++)
        parambx.a(fl.aP[8], 0, 0, 24, 16, 0, this.p + n * 24, this.q, 0); 
    } 
    o.j.a(parambx, df.ap, this.V + fl.S / 2, k + 2, 2, false);
    if (fl.aU > 0 && fl.aO == 1 && this.bp != null) {
      bx bx3 = parambx;
      dr dr1 = this;
      eu.f = 10;
      ft.a(bx3);
      m = fl.aV;
      int i2 = fl.aW;
      fl.a(bx3, m + fl.aU / 2, k + fl.aM / 2 - 5, fl.aU, dr1.bp, dr1.br);
      bx3.d(m + 1, k + 1, fl.aU - 2, dr1.N - 2);
      k += fl.aM - ft.ab + ft.ab / 4;
      ft.a(bx3);
      dr1.c.a(dr1.bj.length + 2, ft.ab + 2, m, k + fl.aM + 2 - (ft.ab << 1), fl.aU, fl.U + ft.ab, true, 1);
      dr1.c.a(bx3, m, k + fl.aM + 2 - ft.ab, fl.aU, fl.U - fl.aM - 2 - bt.k / 2);
      if (dr1.bj != null)
        for (i1 = 0; i1 < dr1.bj.length; i1++) {
          if (dr1.bj[i1] != null) {
            o o1 = null;
            if (dr1.bm != null) {
              o1 = fl.a(dr1.bm[i1]);
            } else {
              o1 = o.j;
            } 
            o1.a(bx3, dr1.bj[i1], m + 4, k + 2 + (i1 + 1) * ft.ab, 0, true);
            if (dr1.bk != null) {
              int i3 = o1.a(dr1.bj[i1]) + 5;
              (o1 = fl.a(dr1.bn[i1])).a(bx3, dr1.bk[i1], m + i3 + 4, k + 2 + (i1 + 1) * ft.ab, 0, true);
            } 
          } 
        }  
      ft.a(bx3);
      if (this.r != null)
        for (byte b = 0; b < this.r.c(); b++) {
          bt bt1;
          (bt1 = (bt)this.r.a(b)).a(parambx, bt1.h, bt1.i);
        }  
    } 
  }
  
  private static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3) {
    if (ft.B) {
      fl.c(parambx, paramInt1, paramInt2, paramInt3, fl.aM - fl.aN + 1, 3);
      return;
    } 
    for (byte b = 0; b <= paramInt3 / 32; b++) {
      if (b == 0) {
        parambx.a(fl.aP[11], 0, 0, 32, fl.aM - fl.aN + 1, 0, paramInt1, paramInt2, 0);
      } else if (b == paramInt3 / 32) {
        parambx.a(fl.aP[11], 0, 0, 32, fl.aM - fl.aN + 1, 2, paramInt1 + paramInt3 - 32, paramInt2, 0);
      } else {
        parambx.a(fl.aP[10], 0, 0, 32, fl.aM - fl.aN + 1, 0, paramInt1 + (b << 5), paramInt2, 0);
      } 
    } 
  }
  
  public final void a() {
    cq cq;
    if (!(cq = this.c.a()).a)
      cq.getClass(); 
    this.c.b();
    p.e.a();
    super.a();
  }
  
  public final void d() {
    if (fl.aO == 1) {
      ew ew1;
      int i = this.d;
      if (ft.al[2]) {
        this.d--;
        ft.d(2);
      } else if (ft.al[8]) {
        this.d++;
        ft.d(8);
      } 
      if (ft.al[4]) {
        if (this.k == 0) {
          fl.aO = 0;
          this.d = 0;
        } else {
          this.k = 0;
          a(true);
        } 
        ft.d(4);
      } else if (ft.al[6]) {
        if (this.k == 1) {
          this.k = 0;
          a(true);
        } else {
          this.k = 1;
          a(true);
        } 
        ft.d(6);
      } 
      if (this.e > 0) {
        this.d = cg.a(this.d, this.e, true);
      } else {
        this.d = 0;
      } 
      h();
      if (this.k == 1) {
        if (!ft.A) {
          if (this.d < this.e) {
            if (this.aa != null)
              this.aa = null; 
          } else if (this.aa != this.l) {
            this.aa = this.l;
            eu.f = 10;
          } 
          if (this.Y != null)
            this.Y = null; 
        } 
        if (i != this.d) {
          a(false);
          if (this.d == this.e) {
            p.e.a(0, p.e.f);
          } else {
            ew1 = (ew)ew.b.a(this.d);
            p.e.a(0, this.d * this.j + ew1.m.length * ft.ab - fl.T / 2);
          } 
        } 
      } else if (this.d < this.e) {
        if (!ft.A) {
          if (this.aa != this.m) {
            this.aa = this.m;
            eu.f = 10;
          } 
          if (ew1 != this.d)
            p.e.a(0, (this.d + 2) * this.j - fl.T / 2); 
        } 
      } else if (this.aa != this.l && !ft.A) {
        this.aa = this.l;
        eu.f = 10;
        if (ew1 != this.d)
          p.e.a(0, p.e.f); 
        if (this.Y != null)
          this.Y = null; 
      } 
    } 
    super.d();
  }
  
  public final void a(boolean paramBoolean) {
    eu.f = 10;
    int i = 0;
    if (this.k == 0) {
      this.e = ew.c.c() + ew.d.c();
      i = this.e + ((ew.c.c() > 0) ? 1 : 0) + ((ew.d.c() > 0) ? 1 : 0) + 2;
    } else {
      this.e = ew.b.c();
      if (this.d < this.e) {
        ew ew1 = (ew)ew.b.a(this.d);
        int j = this.e + 2 + ew1.m.length;
      } else {
        i = this.e + 2;
      } 
    } 
    this.f = i * this.j - fl.T + 5;
    if (this.f < 0)
      this.f = 0; 
    this.h = fl.aM * 3;
    if (paramBoolean) {
      p.e.a(0, this.f, 0, 0);
      return;
    } 
    p.e.f = this.f;
  }
  
  public final void e() {
    if (ft.S) {
      int i = this.L + fl.aM + fl.aN * 3 + this.g;
      int j = 0 + ft.X / 5 + fl.aN;
      if (ft.c(i, j, this.h, fl.aM - fl.aN + 1)) {
        if (this.k != 0) {
          this.k = 0;
          a(true);
        } 
        ft.S = false;
      } else if (ft.c(i + this.h, j, this.h, fl.aM - fl.aN + 1)) {
        if (this.k != 1) {
          this.k = 1;
          a(true);
        } 
        ft.S = false;
      } 
    } 
    if (ft.S && ft.c(this.p, this.q - p.e.b - 4, 96, 24)) {
      ft.S = false;
      this.l.a();
    } 
    if (this.e > 0) {
      if (ft.b(this.V, this.W, fl.S, fl.T))
        if (this.k == 0) {
          int i = this.W + 4 + this.j;
          int j = (ft.af - i + p.e.b) / this.j;
          if (ew.c.c() > 0 && ew.d.c() > 0)
            if (j == ew.c.c()) {
              j = -1;
            } else if (j > ew.c.c()) {
              j--;
            }  
          if (j > -1 && j <= this.e) {
            if (j == this.d) {
              if (fl.aU == 0 && this.d < this.e)
                this.m.a(); 
            } else {
              this.d = j;
              this.d = cg.a(this.d, this.e, false);
            } 
            ft.S = false;
          } 
          h();
        } else {
          int i;
          if ((i = (ft.af - this.W + p.e.b) / this.j) < this.d) {
            this.d = i;
          } else {
            ew ew1 = (ew)ew.b.a(this.d);
            if (this.d < this.e && (i = this.W + this.d * this.j + ew1.m.length * ft.ab) < ft.af + p.e.b) {
              i = (ft.af + p.e.b - i) / this.j + this.d;
              this.d = i;
              this.d = cg.a(this.d, this.e, false);
              ft.S = false;
            } 
          } 
          h();
        }  
      if (ft.T) {
        if (this.f > 0 && ft.ag > this.V && ft.ag < this.V + fl.S && ft.ah > this.W && ft.ah < this.W + fl.T)
          if (!this.t) {
            this.t = true;
            this.u = p.e.b;
          } else {
            p.e.d = this.u + ft.ah - ft.af;
            if (p.e.d > p.e.f)
              p.e.d = p.e.f; 
            if (p.e.d < 0)
              p.e.d = 0; 
            eu.f = 10;
          }  
      } else {
        this.t = false;
        this.u = 0;
      } 
      if (this.r != null && fl.aO == 1 && this.bp != null)
        for (byte b = 0; b < this.r.c(); b++) {
          bt bt1;
          (bt1 = (bt)this.r.a(b)).b();
        }  
    } 
    super.e();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dr.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */