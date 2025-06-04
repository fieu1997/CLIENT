public class fl extends cg {
  public byte K;
  
  private static byte a = 13;
  
  public int L;
  
  public int M;
  
  private int b;
  
  public int N;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  public int O;
  
  public int P;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private static int j;
  
  private static int k;
  
  public boolean Q = false;
  
  public boolean R = false;
  
  public static int S;
  
  public static int T;
  
  public static int U;
  
  int V;
  
  int W;
  
  public String X = "";
  
  public static byte aM = 20;
  
  public static byte aN;
  
  public static byte aO = 0;
  
  public static aq[] aP = new aq[15];
  
  public static aq aQ;
  
  public static aq aR;
  
  public static aq aS;
  
  private static fl l;
  
  bt aT;
  
  public static int aU = 0;
  
  public static int aV;
  
  public static int aW;
  
  public static int aX = 15;
  
  public bp aY = null;
  
  public static boolean aZ = false;
  
  aq ba;
  
  public boolean bb;
  
  public bt bc;
  
  public boolean bd = false;
  
  public boolean be;
  
  public static int[] bf = new int[] { 
      -5727870, -4543854, -477112, -1315861, -5859456, -3689060, -4807282, -9411756, -1845826, -5267575, 
      -460632 };
  
  public int bg = 0;
  
  public int bh = 0;
  
  private static String m = "";
  
  private static String[] n = new String[2];
  
  public static int bi;
  
  public String[] bj;
  
  public String[] bk;
  
  public String[] bl = null;
  
  public int[] bm;
  
  public int[] bn;
  
  public int[] bo;
  
  public String bp;
  
  public int bq;
  
  public int br;
  
  public int bs;
  
  public int bt;
  
  public es bu = new es("MainTabNew moreInfoconten");
  
  private static int[] o = new int[] { -2701394, -6517641, -9411756, -7832985, -11844807 };
  
  public static fl g() {
    if (l == null)
      l = new fl(); 
    return l;
  }
  
  public fl() {
    if (ft.A) {
      aM = 26;
    } else if (ft.W >= 240) {
      aM = 24;
    } 
    if (ft.X < 240 && aM > 24)
      aM = 24; 
    U = ft.X - (ft.aa << 1);
    aN = (byte)(aM / 5);
    j = ft.W / 32 + 1;
    k = ft.X / 32 + 1;
    int i;
    if ((i = ft.W / aM) > 9)
      i = 9; 
    int j = (ft.X / 5 << 2) - ft.aa / 2;
    if (ft.A)
      j += ft.aa / 2; 
    if ((j /= aM) > 8)
      j = 8; 
    this.b = (i - 1) * aM - aN * 3 + (ft.C ? aN : 0);
    this.N = j * aM + aN;
    if (this.N % 2 != 0)
      this.N--; 
    if (ft.A)
      if (ft.W >= 380) {
        aU = 170;
        aX = 5;
        U = this.N - aM - aN;
        this.L = (ft.W - i * aM - aU) / 2;
        aV = ft.W - this.L - aU;
        aW = 0 + ft.X / 5;
      } else if (ft.W > 315) {
        aZ = true;
        if (bs.k == 1)
          bs.k = 2; 
        i = 8;
        this.b = 7 * aM - aN * 3;
        aU = 130;
        aX = 5;
        U = this.N - aM - aN;
        aV = ft.W - this.L - aU + 5;
        aW = 0 + ft.X / 5;
      }  
    if (aZ) {
      this.L = -5;
      aV = this.L + this.b + aM + (aN << 1);
      aU = ft.W - aV;
    } else {
      this.L = (ft.W - i * aM - aU) / 2;
    } 
    this.M = 0;
    this.c = this.b / 32;
    this.d = this.N / 32;
    S = this.b / aM * aM;
    T = (this.N / aM - 1) * aM;
    this.h = S / 32;
    this.i = T / 32;
    this.e = ft.W - this.L - 9 - 72;
    if (ft.A && this.e > ft.W - 112)
      this.e = ft.W - 112; 
    this.f = 5;
    if (ft.C)
      this.f = 2; 
    this.O = 0;
    this.P = ft.X / 10 - 21;
    if (ft.C)
      this.P += 4; 
    this.g = aN + aM;
    if (this.g > 32)
      this.g = 32; 
  }
  
  public void b() {}
  
  public void a(String paramString) {}
  
  public void c() {
    p.e.a(0, 0, 0, 0);
    if (ft.A) {
      if (ft.a == ft.u) {
        if (ft.u.c != null && ft.u.c != ft.u && ft.u.c != ft.v) {
          ft.u.c.c();
          return;
        } 
        ft.c.c();
        return;
      } 
      if (ft.a == ft.v) {
        if (ft.u.c != null && ft.u.c != ft.u && ft.u.c != ft.v) {
          ft.v.c.c();
          return;
        } 
        ft.c.c();
        return;
      } 
      if (ft.a == ft.w) {
        if (ft.w.c != null) {
          ft.w.c.c();
          return;
        } 
        ft.c.c();
      } 
    } 
  }
  
  public final void e(int paramInt) {}
  
  public static void a(bx parambx, int paramInt) {
    ft.a(parambx);
    cn.f.c(parambx, ft.Y, ft.X / 10 + 15, paramInt);
  }
  
  public final void a(bx parambx, String paramString, int paramInt, es parames, int paramBoolean) {
    int i = parames.c();
    if (ft.B) {
      c(parambx, 0, 0, ft.W, ft.X, 0);
      c(parambx, this.e, this.f, 66, 32, 1);
      c(parambx, this.L + aM + (aN << 1), 0 + ft.X / 5, this.b, this.N, 1);
    } else {
      byte b1;
      for (b1 = 0; b1 < j; b1++) {
        for (byte b2 = 0; b2 < k; b2++)
          parambx.a(aP[0], b1 << 5, b2 << 5, 0); 
      } 
      for (b1 = 0; b1 < 3; b1++)
        parambx.a(aP[1], this.e + b1 * 22, this.f, 0); 
      for (b1 = 0; b1 <= this.c; b1++) {
        for (byte b2 = 0; b2 <= this.d; b2++) {
          if (b1 == 0 || b1 == this.c || b2 == this.d || b2 == 0)
            if (b1 == this.c) {
              if (b2 == this.d) {
                parambx.a(aP[1], this.L + aM + (aN << 1) + this.b - 32, 0 + ft.X / 5 + this.N - 32, 0);
              } else {
                parambx.a(aP[1], this.L + aM + (aN << 1) + this.b - 32, 0 + (b2 << 5) + ft.X / 5, 0);
              } 
            } else if (b2 == this.d) {
              parambx.a(aP[1], this.L + aM + (aN << 1) + (b1 << 5), 0 + ft.X / 5 + this.N - 32, 0);
            } else {
              parambx.a(aP[1], this.L + aM + (aN << 1) + (b1 << 5), 0 + (b2 << 5) + ft.X / 5, 0);
            }  
        } 
      } 
    } 
    cg.a(parambx, paramString, this.L + aM + (aN << 1) + this.b / 2, 0 + ft.X / 5 + aM / 2 - 6, 2);
    cn.q.a(parambx, 0, 0, !ft.C, ft.C ? o.i : o.j);
    parambx.a(aP[4], 0, 0, 14, 14, 0, this.e + 4, this.f + 2, 0);
    parambx.a(aP[4], 0, 14, 14, 14, 0, this.e + 4, this.f + 17, 0);
    if (paramBoolean) {
      cf.x.b(10, this.e - 12, this.f + 10, 0, 3, parambx);
      if (cn.f.cO != null) {
        o.j.a(parambx, j.a(cn.f.cO.n), this.e + 19, this.f + 3, 0, false);
        o.j.a(parambx, j.a(cn.f.cO.l), this.e + 19, this.f + 18, 0, false);
      } 
    } else {
      o.j.a(parambx, j.a(cn.f.bC), this.e + 19, this.f + 3, 0, false);
      o.j.a(parambx, j.a(cn.f.bB), this.e + 19, this.f + 18, 0, false);
    } 
    if (ft.B) {
      c(parambx, this.L + aN, 0 + ft.X / 5 + aM * paramInt, aN + aM, aM, 1);
    } else if (aN + aM > 32) {
      parambx.a(aP[1], 0, 0, aM, aM, 0, this.L + aN, 0 + ft.X / 5 + aM * paramInt, 0);
      parambx.a(aP[1], 0, 0, aN, aM, 0, this.L + aN + aM, 0 + ft.X / 5 + aM * paramInt, 0);
    } else {
      parambx.a(aP[1], 0, 0, aN + aM, aM, 0, this.L + aN, 0 + ft.X / 5 + aM * paramInt, 0);
    } 
    if (!ft.A && aO == 0) {
      parambx.a(bf[3]);
      parambx.b(this.L + aN + 1, 0 + ft.X / 5 + aM * paramInt + 1, aN + aM - 3, aM - 5);
    } 
    parambx.a(bf[0]);
    byte b;
    for (b = 0; b < i; b++) {
      fl fl1 = (fl)parames.a(b);
      int j = 0;
      if (b != paramInt) {
        parambx.b(this.L + aN, 0 + ft.X / 5 + aM * b, aN + aM, aM);
      } else if (aO == 0 || ft.A) {
        j = -1 + ft.ai / 2 % 3;
      } 
      byte b1;
      if ((b1 = fl1.K) > a)
        b1 = this.K; 
      parambx.a(aP[3], 0, b1 << 4, 16, 16, 0, this.L + aN + aN / 2 + aM / 2 + j, 0 + ft.X / 5 + aM / 2 + aM * b, 3);
      if (fl1.K == 2 && bq.t > 0) {
        cf.u.b(ft.ai / 4 % 2, this.L + aN + aN / 2 + aM + j - 4, 0 + ft.X / 5 + aM + aM * b - 6, 0, 3, parambx);
      } else if (fl1.K == 3 && bq.u > 0) {
        cf.u.b(2 + ft.ai / 4 % 2, this.L + aN + aN / 2 + aM + j - 4, 0 + ft.X / 5 + aM + aM * b - 6, 0, 3, parambx);
      } 
    } 
    if (ft.B) {
      c(parambx, this.L + aM + aN * 3, 0 + ft.X / 5 + aM, S, T, 2);
    } else {
      for (b = 0; b <= this.h; b++) {
        for (byte b1 = 0; b1 <= this.i; b1++) {
          if (b == this.h) {
            if (b1 == this.i) {
              parambx.a(aP[2], this.L + aM + aN * 3 + S - 32, 0 + ft.X / 5 + aM + T - 32, 0);
            } else {
              parambx.a(aP[2], this.L + aM + aN * 3 + S - 32, 0 + ft.X / 5 + aM + (b1 << 5), 0);
            } 
          } else if (b1 == this.i) {
            parambx.a(aP[2], this.L + aM + aN * 3 + (b << 5), 0 + ft.X / 5 + aM + T - 32, 0);
          } else {
            parambx.a(aP[2], this.L + aM + aN * 3 + (b << 5), 0 + ft.X / 5 + aM + (b1 << 5), 0);
          } 
        } 
      } 
    } 
    if (aU > 0) {
      ft.a(parambx);
      if (ft.B) {
        c(parambx, aV, aW, aU, this.N, 12);
      } else {
        int m = aU / 32;
        int k = this.N / 32;
        for (paramBoolean = 0; paramBoolean <= m; paramBoolean++) {
          for (paramInt = 0; paramInt <= k; paramInt++) {
            if (paramBoolean == m) {
              if (paramInt == k) {
                parambx.a(aP[12], aV + aU - 32, aW + this.N - 32, 0);
              } else {
                parambx.a(aP[12], aV + aU - 32, aW + (paramInt << 5), 0);
              } 
            } else if (paramInt == k) {
              parambx.a(aP[12], aV + (paramBoolean << 5), aW + this.N - 32, 0);
            } else {
              parambx.a(aP[12], aV + (paramBoolean << 5), aW + (paramInt << 5), 0);
            } 
          } 
        } 
      } 
      for (int j = aV; j < aV + aU; j += 6)
        parambx.c(j, aW + aM, 4, 1); 
    } 
  }
  
  public final void a(bx parambx, boolean paramBoolean) {
    if (aU > 0) {
      c(parambx, paramBoolean);
      return;
    } 
    b(parambx, paramBoolean);
  }
  
  public final void b(bx parambx, boolean paramBoolean) {
    eu.f = 10;
    parambx.d(-parambx.a(), -parambx.b(), ft.W, ft.X);
    parambx.a();
    parambx.b();
    int i = 1;
    if (this.bj != null)
      i = this.bj.length; 
    if (this.bl != null)
      i += this.bl.length; 
    if (this.bu != null && this.bu.c() > 0 && this.bl == null)
      i++; 
    if ((i = (i + 1) * ft.ab + 8) > U)
      i = U; 
    if (this.bs + this.bq > ft.W)
      this.bs = ft.W / 2 - this.bq / 2; 
    int j = this.bt;
    parambx.a(bf[10]);
    parambx.c(this.bs - 1, j - 1, this.bq + 2, i + 2);
    parambx.a(bf[2]);
    parambx.c(this.bs, j, this.bq + 1, i + 1);
    if (ft.B) {
      c(parambx, this.bs, j, this.bq, i, 4);
    } else {
      int m = this.bq / 32;
      int n = i / 32;
      for (byte b = 0; b <= m; b++) {
        for (byte b1 = 0; b1 <= n; b1++) {
          if (b == m) {
            if (b1 == n) {
              parambx.a(aP[12], this.bs + this.bq - 32, j + i - 32, 0);
            } else {
              parambx.a(aP[12], this.bs + this.bq - 32, j + (b1 << 5), 0);
            } 
          } else if (b1 == n) {
            parambx.a(aP[12], this.bs + (b << 5), j + i - 32, 0);
          } else {
            parambx.a(aP[12], this.bs + (b << 5), j + (b1 << 5), 0);
          } 
        } 
      } 
    } 
    parambx.d(this.bs + 1, j + 1, this.bq - 2, i - 2);
    if (!paramBoolean && this.bp != null) {
      int m = j + 2;
      if (this.bj == null && dw.g)
        m = j + 6; 
      a(parambx, this.bs + this.bq / 2, m, this.bq, this.bp, this.br);
    } 
    if (!paramBoolean && this.aY != null) {
      parambx.d(this.bs, j + ft.ab, this.bq, U - ft.ab - 20);
      parambx.a(0, -this.aY.f);
    } 
    if (this.bl != null)
      for (byte b = 0; b < this.bl.length; b++) {
        j += ft.ab;
        a(this.bo[b]).a(parambx, this.bl[b], this.bs + 4, j + 2, 0, true);
      }  
    if (this.bl == null && this.bu.c() > 0)
      j += ft.ab; 
    int k;
    for (k = 0; k < this.bu.c(); k++) {
      dl dl;
      if ((dl = (dl)this.bu.a(k)) != null) {
        if (this.bl != null) {
          bw.r.a(this.bs + 4 + this.bl[0].length() * 5 + 3 + k * 15, j - ft.ab / 2 + ((this.bl.length == 1) ? ft.ab : 0), 13, 13, parambx, 0);
        } else {
          bw.r.a(this.bs + 4 + 16 + k * 15, j + ft.ab - 8, 13, 13, parambx, 0);
        } 
        if (dl.a != -1) {
          j j1;
          if ((j1 = bw.b(dl.a)) != null) {
            if (this.bl != null && this.bl[0] != null) {
              j1.b(parambx, this.bs + 4 + this.bl[0].length() * 5 + 3 + k * 15 + 1, j - ft.ab / 2 + 1 + ((this.bl.length == 1) ? ft.ab : 0), 21, 1, 0);
            } else {
              j1.b(parambx, this.bs + 4 + 16 + k * 15, j + ft.ab + 1 - 8, 21, 1, 0);
            } 
          } else {
            bw.c(dl.a);
          } 
        } 
      } 
    } 
    if (this.bj != null) {
      for (k = 0; k < this.bj.length; k++) {
        if (this.bj[k] != null) {
          o o = null;
          if (this.bm != null) {
            o = a(this.bm[k]);
          } else {
            o = o.j;
          } 
          o.a(parambx, this.bj[k], this.bs + 4, j + 2 + (k + 1) * ft.ab, 0, true);
          if (this.bk != null) {
            int m = o.a(this.bj[k]) + 5;
            (o = a(this.bn[k])).a(parambx, this.bk[k], this.bs + m + 4, j + 2 + (k + 1) * ft.ab, 0, true);
          } 
        } 
      } 
    } else if (!paramBoolean) {
      if (this.bp != null) {
        k = j + 2;
        if (this.bj == null && dw.g)
          k = j + 6; 
        a(parambx, this.bs + this.bq / 2, k, this.bq, this.bp, this.br);
      } 
    } else if (this.bp != null) {
      a(parambx, this.bs + this.bq / 2, j + ft.ab / 4, this.bq, this.bp, this.br);
    } 
    if (this.bc != null) {
      this.bc.a(parambx, this.bs + this.bq - bt.j / 2, j + i - bt.k);
      if (this.bg == 0 || this.bh == 0) {
        this.bg = this.bs + this.bq - bt.j / 2;
        this.bh = j + i - bt.k;
      } 
    } 
    ft.a(parambx);
  }
  
  public void a() {
    if ((this = this).bc != null) {
      if (this.bg != 0 && this.bh != 0)
        this.bc.a(this.bg, this.bh, cf.r, this.bc.a); 
      if (ft.A) {
        this.bc.b();
        return;
      } 
      if (ft.ak[5]) {
        ft.ak[5] = false;
        this.bc.a();
      } 
    } 
  }
  
  public final void c(bx parambx, boolean paramBoolean) {
    // Byte code:
    //   0: bipush #10
    //   2: putstatic eu.f : I
    //   5: aload_1
    //   6: invokestatic a : (Lbx;)V
    //   9: getstatic fl.aV : I
    //   12: istore_3
    //   13: getstatic fl.aW : I
    //   16: dup
    //   17: istore #4
    //   19: istore #4
    //   21: iload_3
    //   22: iconst_1
    //   23: iadd
    //   24: istore #5
    //   26: iload #4
    //   28: iconst_1
    //   29: iadd
    //   30: istore #6
    //   32: getstatic fl.aU : I
    //   35: iconst_2
    //   36: isub
    //   37: istore #7
    //   39: aload_0
    //   40: getfield N : I
    //   43: iconst_2
    //   44: isub
    //   45: istore #8
    //   47: iconst_0
    //   48: istore #9
    //   50: iload_2
    //   51: ifne -> 168
    //   54: aload_1
    //   55: iload_3
    //   56: getstatic fl.aU : I
    //   59: iconst_2
    //   60: idiv
    //   61: iadd
    //   62: iload #4
    //   64: getstatic fl.aM : B
    //   67: iconst_2
    //   68: idiv
    //   69: iadd
    //   70: iconst_5
    //   71: isub
    //   72: getstatic fl.aU : I
    //   75: aload_0
    //   76: getfield bp : Ljava/lang/String;
    //   79: aload_0
    //   80: getfield br : I
    //   83: invokestatic a : (Lbx;IIILjava/lang/String;I)V
    //   86: aload_0
    //   87: getfield aY : Lbp;
    //   90: ifnull -> 150
    //   93: aload_1
    //   94: iload_3
    //   95: iload #4
    //   97: getstatic fl.aM : B
    //   100: iadd
    //   101: iconst_2
    //   102: iadd
    //   103: getstatic fl.aU : I
    //   106: getstatic fl.U : I
    //   109: getstatic fl.aM : B
    //   112: isub
    //   113: iconst_2
    //   114: isub
    //   115: invokevirtual d : (IIII)V
    //   118: iload_3
    //   119: istore #5
    //   121: iload #4
    //   123: getstatic fl.aM : B
    //   126: iadd
    //   127: iconst_2
    //   128: iadd
    //   129: istore #6
    //   131: getstatic fl.aU : I
    //   134: istore #7
    //   136: getstatic fl.U : I
    //   139: getstatic fl.aM : B
    //   142: isub
    //   143: iconst_2
    //   144: isub
    //   145: istore #8
    //   147: iconst_1
    //   148: istore #9
    //   150: iload #4
    //   152: getstatic fl.aM : B
    //   155: getstatic ft.ab : I
    //   158: isub
    //   159: getstatic ft.ab : I
    //   162: iconst_4
    //   163: idiv
    //   164: iadd
    //   165: iadd
    //   166: istore #4
    //   168: aload_1
    //   169: iload #5
    //   171: iload #6
    //   173: iload #7
    //   175: iload #8
    //   177: invokevirtual d : (IIII)V
    //   180: iload #9
    //   182: ifeq -> 198
    //   185: aload_1
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield aY : Lbp;
    //   191: getfield f : I
    //   194: ineg
    //   195: invokevirtual a : (II)V
    //   198: aload_0
    //   199: getfield bl : [Ljava/lang/String;
    //   202: ifnull -> 262
    //   205: iconst_0
    //   206: istore #5
    //   208: goto -> 252
    //   211: iload #4
    //   213: getstatic ft.ab : I
    //   216: iadd
    //   217: istore #4
    //   219: aload_0
    //   220: getfield bo : [I
    //   223: iload #5
    //   225: iaload
    //   226: invokestatic a : (I)Lo;
    //   229: aload_1
    //   230: aload_0
    //   231: getfield bl : [Ljava/lang/String;
    //   234: iload #5
    //   236: aaload
    //   237: iload_3
    //   238: iconst_4
    //   239: iadd
    //   240: iload #4
    //   242: iconst_2
    //   243: iadd
    //   244: iconst_0
    //   245: iconst_1
    //   246: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   249: iinc #5, 1
    //   252: iload #5
    //   254: aload_0
    //   255: getfield bl : [Ljava/lang/String;
    //   258: arraylength
    //   259: if_icmplt -> 211
    //   262: aload_0
    //   263: getfield bl : [Ljava/lang/String;
    //   266: ifnonnull -> 287
    //   269: aload_0
    //   270: getfield bu : Les;
    //   273: invokevirtual c : ()I
    //   276: ifle -> 287
    //   279: iload #4
    //   281: getstatic ft.ab : I
    //   284: iadd
    //   285: istore #4
    //   287: iconst_0
    //   288: istore #5
    //   290: goto -> 571
    //   293: aload_0
    //   294: getfield bu : Les;
    //   297: iload #5
    //   299: invokevirtual a : (I)Ljava/lang/Object;
    //   302: checkcast dl
    //   305: dup
    //   306: astore #6
    //   308: ifnull -> 568
    //   311: aload_0
    //   312: getfield bo : [I
    //   315: ifnull -> 381
    //   318: getstatic bw.r : Ldg;
    //   321: iload_3
    //   322: iconst_4
    //   323: iadd
    //   324: aload_0
    //   325: getfield bl : [Ljava/lang/String;
    //   328: iconst_0
    //   329: aaload
    //   330: invokevirtual length : ()I
    //   333: iconst_5
    //   334: imul
    //   335: iadd
    //   336: iconst_3
    //   337: iadd
    //   338: iload #5
    //   340: bipush #15
    //   342: imul
    //   343: iadd
    //   344: iload #4
    //   346: getstatic ft.ab : I
    //   349: iconst_2
    //   350: idiv
    //   351: isub
    //   352: aload_0
    //   353: getfield bl : [Ljava/lang/String;
    //   356: arraylength
    //   357: iconst_1
    //   358: if_icmpne -> 367
    //   361: getstatic ft.ab : I
    //   364: goto -> 368
    //   367: iconst_0
    //   368: iadd
    //   369: bipush #13
    //   371: bipush #13
    //   373: aload_1
    //   374: iconst_0
    //   375: invokevirtual a : (IIIILbx;I)V
    //   378: goto -> 417
    //   381: getstatic bw.r : Ldg;
    //   384: iload_3
    //   385: iconst_4
    //   386: iadd
    //   387: bipush #16
    //   389: iadd
    //   390: iload #5
    //   392: bipush #15
    //   394: imul
    //   395: iadd
    //   396: iload #4
    //   398: getstatic ft.ab : I
    //   401: iconst_2
    //   402: idiv
    //   403: isub
    //   404: getstatic ft.ab : I
    //   407: iadd
    //   408: bipush #13
    //   410: bipush #13
    //   412: aload_1
    //   413: iconst_0
    //   414: invokevirtual a : (IIIILbx;I)V
    //   417: aload #6
    //   419: getfield a : I
    //   422: iconst_m1
    //   423: if_icmpeq -> 568
    //   426: aload #6
    //   428: getfield a : I
    //   431: invokestatic b : (I)Lj;
    //   434: dup
    //   435: astore #7
    //   437: ifnull -> 560
    //   440: aload_0
    //   441: getfield bl : [Ljava/lang/String;
    //   444: ifnull -> 521
    //   447: aload_0
    //   448: getfield bl : [Ljava/lang/String;
    //   451: iconst_0
    //   452: aaload
    //   453: ifnull -> 521
    //   456: aload #7
    //   458: aload_1
    //   459: iload_3
    //   460: iconst_4
    //   461: iadd
    //   462: aload_0
    //   463: getfield bl : [Ljava/lang/String;
    //   466: iconst_0
    //   467: aaload
    //   468: invokevirtual length : ()I
    //   471: iconst_5
    //   472: imul
    //   473: iadd
    //   474: iconst_3
    //   475: iadd
    //   476: iload #5
    //   478: bipush #15
    //   480: imul
    //   481: iadd
    //   482: iconst_1
    //   483: iadd
    //   484: iload #4
    //   486: getstatic ft.ab : I
    //   489: iconst_2
    //   490: idiv
    //   491: isub
    //   492: iconst_1
    //   493: iadd
    //   494: aload_0
    //   495: getfield bl : [Ljava/lang/String;
    //   498: arraylength
    //   499: iconst_1
    //   500: if_icmpne -> 509
    //   503: getstatic ft.ab : I
    //   506: goto -> 510
    //   509: iconst_0
    //   510: iadd
    //   511: bipush #21
    //   513: iconst_1
    //   514: iconst_0
    //   515: invokevirtual b : (Lbx;IIIII)V
    //   518: goto -> 568
    //   521: aload #7
    //   523: aload_1
    //   524: iload_3
    //   525: iconst_4
    //   526: iadd
    //   527: bipush #16
    //   529: iadd
    //   530: iload #5
    //   532: bipush #15
    //   534: imul
    //   535: iadd
    //   536: iload #4
    //   538: getstatic ft.ab : I
    //   541: iconst_2
    //   542: idiv
    //   543: isub
    //   544: getstatic ft.ab : I
    //   547: iadd
    //   548: iconst_1
    //   549: iadd
    //   550: bipush #21
    //   552: iconst_1
    //   553: iconst_0
    //   554: invokevirtual b : (Lbx;IIIII)V
    //   557: goto -> 568
    //   560: aload #6
    //   562: getfield a : I
    //   565: invokestatic c : (I)V
    //   568: iinc #5, 1
    //   571: iload #5
    //   573: aload_0
    //   574: getfield bu : Les;
    //   577: invokevirtual c : ()I
    //   580: if_icmplt -> 293
    //   583: aload_0
    //   584: getfield bj : [Ljava/lang/String;
    //   587: ifnull -> 1404
    //   590: getstatic ah.i : Lea;
    //   593: astore #5
    //   595: aload_0
    //   596: getfield R : Z
    //   599: ifeq -> 1245
    //   602: aload #5
    //   604: ifnull -> 1245
    //   607: iload #4
    //   609: getstatic ft.ab : I
    //   612: iadd
    //   613: istore #4
    //   615: getstatic o.j : Lo;
    //   618: aload_1
    //   619: new java/lang/StringBuffer
    //   622: dup
    //   623: getstatic df.ac : Ljava/lang/String;
    //   626: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   629: invokespecial <init> : (Ljava/lang/String;)V
    //   632: aload #5
    //   634: getfield S : I
    //   637: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   640: ldc ' + '
    //   642: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   645: aload #5
    //   647: getfield ap : S
    //   650: bipush #10
    //   652: idiv
    //   653: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   656: ldc ','
    //   658: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   661: aload #5
    //   663: getfield ap : S
    //   666: bipush #10
    //   668: irem
    //   669: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   672: ldc '%'
    //   674: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   677: invokevirtual toString : ()Ljava/lang/String;
    //   680: iload_3
    //   681: iconst_4
    //   682: iadd
    //   683: iload #4
    //   685: iconst_2
    //   686: iadd
    //   687: iconst_0
    //   688: iconst_1
    //   689: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   692: iload #4
    //   694: getstatic ft.ab : I
    //   697: iadd
    //   698: istore #4
    //   700: aload #5
    //   702: getfield aq : I
    //   705: bipush #24
    //   707: idiv
    //   708: istore #6
    //   710: aload #5
    //   712: getfield aq : I
    //   715: bipush #24
    //   717: irem
    //   718: istore #7
    //   720: aload #5
    //   722: getfield F : I
    //   725: i2l
    //   726: aload #5
    //   728: invokevirtual a : ()J
    //   731: ldc2_w 60000
    //   734: ldiv
    //   735: lsub
    //   736: l2i
    //   737: dup
    //   738: istore_2
    //   739: ifle -> 794
    //   742: getstatic o.m : Lo;
    //   745: aload_1
    //   746: new java/lang/StringBuffer
    //   749: dup
    //   750: getstatic df.fy : Ljava/lang/String;
    //   753: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   756: invokespecial <init> : (Ljava/lang/String;)V
    //   759: ldc ' '
    //   761: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   764: iload_2
    //   765: invokestatic a : (I)Ljava/lang/String;
    //   768: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   771: invokevirtual toString : ()Ljava/lang/String;
    //   774: iload_3
    //   775: iconst_4
    //   776: iadd
    //   777: iload #4
    //   779: iconst_2
    //   780: iadd
    //   781: iconst_0
    //   782: iconst_1
    //   783: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   786: iload #4
    //   788: getstatic ft.ab : I
    //   791: iadd
    //   792: istore #4
    //   794: getstatic o.j : Lo;
    //   797: aload_1
    //   798: new java/lang/StringBuffer
    //   801: dup
    //   802: getstatic df.fH : Ljava/lang/String;
    //   805: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   808: invokespecial <init> : (Ljava/lang/String;)V
    //   811: iload #6
    //   813: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   816: ldc 'd '
    //   818: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   821: iload #7
    //   823: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   826: ldc 'h'
    //   828: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   831: invokevirtual toString : ()Ljava/lang/String;
    //   834: iload_3
    //   835: iconst_4
    //   836: iadd
    //   837: iload #4
    //   839: iconst_2
    //   840: iadd
    //   841: iconst_0
    //   842: iconst_1
    //   843: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   846: iload #4
    //   848: getstatic ft.ab : I
    //   851: iadd
    //   852: istore #4
    //   854: aload #5
    //   856: getfield au : Lcz;
    //   859: ifnull -> 947
    //   862: getstatic bw.e : [B
    //   865: aload #5
    //   867: getfield au : Lcz;
    //   870: getfield a : I
    //   873: baload
    //   874: invokestatic a : (I)Lo;
    //   877: aload_1
    //   878: new java/lang/StringBuffer
    //   881: dup
    //   882: getstatic bw.d : [Ljava/lang/String;
    //   885: aload #5
    //   887: getfield au : Lcz;
    //   890: getfield a : I
    //   893: aaload
    //   894: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   897: invokespecial <init> : (Ljava/lang/String;)V
    //   900: ldc ': '
    //   902: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   905: aload #5
    //   907: getfield au : Lcz;
    //   910: getfield b : I
    //   913: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   916: ldc '-'
    //   918: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   921: aload #5
    //   923: getfield au : Lcz;
    //   926: getfield c : I
    //   929: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   932: invokevirtual toString : ()Ljava/lang/String;
    //   935: iload_3
    //   936: iconst_4
    //   937: iadd
    //   938: iload #4
    //   940: iconst_2
    //   941: iadd
    //   942: iconst_0
    //   943: iconst_1
    //   944: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   947: iload #4
    //   949: getstatic ft.ab : I
    //   952: iadd
    //   953: istore #4
    //   955: getstatic o.j : Lo;
    //   958: aload_1
    //   959: new java/lang/StringBuffer
    //   962: dup
    //   963: getstatic df.fI : Ljava/lang/String;
    //   966: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   969: invokespecial <init> : (Ljava/lang/String;)V
    //   972: ldc ': '
    //   974: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   977: aload #5
    //   979: getfield ar : S
    //   982: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   985: ldc '/'
    //   987: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   990: aload #5
    //   992: getfield as : S
    //   995: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   998: invokevirtual toString : ()Ljava/lang/String;
    //   1001: iload_3
    //   1002: iconst_4
    //   1003: iadd
    //   1004: iload #4
    //   1006: iconst_2
    //   1007: iadd
    //   1008: iconst_0
    //   1009: iconst_1
    //   1010: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   1013: iload #4
    //   1015: getstatic ft.ab : I
    //   1018: iadd
    //   1019: istore #4
    //   1021: iconst_0
    //   1022: istore_0
    //   1023: goto -> 1099
    //   1026: getstatic o.j : Lo;
    //   1029: aload_1
    //   1030: new java/lang/StringBuffer
    //   1033: dup
    //   1034: getstatic df.gz : [Ljava/lang/String;
    //   1037: iload_0
    //   1038: aaload
    //   1039: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1042: invokespecial <init> : (Ljava/lang/String;)V
    //   1045: ldc ': '
    //   1047: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1050: aload #5
    //   1052: getfield av : [S
    //   1055: iload_0
    //   1056: saload
    //   1057: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1060: ldc '/'
    //   1062: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1065: aload #5
    //   1067: getfield at : S
    //   1070: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1073: invokevirtual toString : ()Ljava/lang/String;
    //   1076: iload_3
    //   1077: iconst_4
    //   1078: iadd
    //   1079: iload #4
    //   1081: iconst_2
    //   1082: iadd
    //   1083: iconst_0
    //   1084: iconst_1
    //   1085: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   1088: iload #4
    //   1090: getstatic ft.ab : I
    //   1093: iadd
    //   1094: istore #4
    //   1096: iinc #0, 1
    //   1099: iload_0
    //   1100: getstatic df.gz : [Ljava/lang/String;
    //   1103: arraylength
    //   1104: if_icmplt -> 1026
    //   1107: iconst_0
    //   1108: istore_0
    //   1109: goto -> 1232
    //   1112: aload #5
    //   1114: getfield j : [Lcz;
    //   1117: iload_0
    //   1118: aaload
    //   1119: getfield a : I
    //   1122: bipush #6
    //   1124: if_icmple -> 1229
    //   1127: new java/lang/StringBuffer
    //   1130: dup
    //   1131: getstatic bw.d : [Ljava/lang/String;
    //   1134: aload #5
    //   1136: getfield j : [Lcz;
    //   1139: iload_0
    //   1140: aaload
    //   1141: getfield a : I
    //   1144: aaload
    //   1145: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1148: invokespecial <init> : (Ljava/lang/String;)V
    //   1151: ldc ': '
    //   1153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1156: getstatic bw.f : [B
    //   1159: aload #5
    //   1161: getfield j : [Lcz;
    //   1164: iload_0
    //   1165: aaload
    //   1166: getfield a : I
    //   1169: baload
    //   1170: aload #5
    //   1172: getfield j : [Lcz;
    //   1175: iload_0
    //   1176: aaload
    //   1177: getfield b : I
    //   1180: invokestatic a : (II)Ljava/lang/String;
    //   1183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1186: invokevirtual toString : ()Ljava/lang/String;
    //   1189: astore_2
    //   1190: getstatic bw.e : [B
    //   1193: aload #5
    //   1195: getfield j : [Lcz;
    //   1198: iload_0
    //   1199: aaload
    //   1200: getfield a : I
    //   1203: baload
    //   1204: invokestatic a : (I)Lo;
    //   1207: aload_1
    //   1208: aload_2
    //   1209: iload_3
    //   1210: iconst_4
    //   1211: iadd
    //   1212: iload #4
    //   1214: iconst_2
    //   1215: iadd
    //   1216: iconst_0
    //   1217: iconst_1
    //   1218: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   1221: iload #4
    //   1223: getstatic ft.ab : I
    //   1226: iadd
    //   1227: istore #4
    //   1229: iinc #0, 1
    //   1232: iload_0
    //   1233: aload #5
    //   1235: getfield j : [Lcz;
    //   1238: arraylength
    //   1239: if_icmplt -> 1112
    //   1242: goto -> 1438
    //   1245: iconst_0
    //   1246: istore #6
    //   1248: goto -> 1391
    //   1251: aload_0
    //   1252: getfield bj : [Ljava/lang/String;
    //   1255: iload #6
    //   1257: aaload
    //   1258: ifnull -> 1388
    //   1261: aconst_null
    //   1262: astore #7
    //   1264: aload_0
    //   1265: getfield bm : [I
    //   1268: ifnull -> 1286
    //   1271: aload_0
    //   1272: getfield bm : [I
    //   1275: iload #6
    //   1277: iaload
    //   1278: invokestatic a : (I)Lo;
    //   1281: astore #7
    //   1283: goto -> 1291
    //   1286: getstatic o.j : Lo;
    //   1289: astore #7
    //   1291: aload #7
    //   1293: aload_1
    //   1294: aload_0
    //   1295: getfield bj : [Ljava/lang/String;
    //   1298: iload #6
    //   1300: aaload
    //   1301: iload_3
    //   1302: iconst_4
    //   1303: iadd
    //   1304: iload #4
    //   1306: iconst_2
    //   1307: iadd
    //   1308: iload #6
    //   1310: iconst_1
    //   1311: iadd
    //   1312: getstatic ft.ab : I
    //   1315: imul
    //   1316: iadd
    //   1317: iconst_0
    //   1318: iconst_1
    //   1319: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   1322: aload_0
    //   1323: getfield bk : [Ljava/lang/String;
    //   1326: ifnull -> 1388
    //   1329: aload #7
    //   1331: aload_0
    //   1332: getfield bj : [Ljava/lang/String;
    //   1335: iload #6
    //   1337: aaload
    //   1338: invokevirtual a : (Ljava/lang/String;)I
    //   1341: iconst_5
    //   1342: iadd
    //   1343: istore_2
    //   1344: aload_0
    //   1345: getfield bn : [I
    //   1348: iload #6
    //   1350: iaload
    //   1351: invokestatic a : (I)Lo;
    //   1354: dup
    //   1355: astore #7
    //   1357: aload_1
    //   1358: aload_0
    //   1359: getfield bk : [Ljava/lang/String;
    //   1362: iload #6
    //   1364: aaload
    //   1365: iload_3
    //   1366: iload_2
    //   1367: iadd
    //   1368: iconst_4
    //   1369: iadd
    //   1370: iload #4
    //   1372: iconst_2
    //   1373: iadd
    //   1374: iload #6
    //   1376: iconst_1
    //   1377: iadd
    //   1378: getstatic ft.ab : I
    //   1381: imul
    //   1382: iadd
    //   1383: iconst_0
    //   1384: iconst_1
    //   1385: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   1388: iinc #6, 1
    //   1391: iload #6
    //   1393: aload_0
    //   1394: getfield bj : [Ljava/lang/String;
    //   1397: arraylength
    //   1398: if_icmplt -> 1251
    //   1401: goto -> 1438
    //   1404: iload_2
    //   1405: ifeq -> 1438
    //   1408: getstatic o.f : Lo;
    //   1411: aload_1
    //   1412: aload_0
    //   1413: getfield bp : Ljava/lang/String;
    //   1416: iload_3
    //   1417: getstatic fl.aU : I
    //   1420: iconst_2
    //   1421: idiv
    //   1422: iadd
    //   1423: iload #4
    //   1425: getstatic fl.aM : B
    //   1428: iconst_2
    //   1429: idiv
    //   1430: iadd
    //   1431: iconst_5
    //   1432: isub
    //   1433: iconst_2
    //   1434: iconst_1
    //   1435: invokevirtual a : (Lbx;Ljava/lang/String;IIIZ)V
    //   1438: aload_1
    //   1439: invokestatic a : (Lbx;)V
    //   1442: return
  }
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4) {
    if (o.c.a(paramString) <= paramInt3) {
      o o1;
      (o1 = b(paramInt4)).a(parambx, paramString, paramInt1, paramInt2, 2, true);
      return;
    } 
    if (m.compareTo(paramString.trim()) != 0) {
      String str;
      m = (str = paramString).trim();
      n = new String[2];
      for (byte b1 = 0; b1 < n.length; b1++)
        n[b1] = ""; 
      String[] arrayOfString = o.a(m, " ");
      for (byte b2 = 0; b2 < arrayOfString.length; b2++) {
        if (b2 <= arrayOfString.length / 2) {
          n[0] = String.valueOf(n[0]) + arrayOfString[b2];
          if (b2 < arrayOfString.length / 2)
            n[0] = String.valueOf(n[0]) + " "; 
        } else {
          n[1] = String.valueOf(n[1]) + arrayOfString[b2];
          if (b2 < arrayOfString.length - 1)
            n[1] = String.valueOf(n[1]) + " "; 
        } 
      } 
    } 
    o o;
    (o = a(paramInt4)).a(parambx, n[0], paramInt1, paramInt2 - 6, 2, true);
    o.a(parambx, n[1], paramInt1, paramInt2 + 6, 2, true);
  }
  
  public static o a(int paramInt) {
    int i = paramInt;
    if (paramInt >= 20 && paramInt < 30) {
      i = paramInt - 20;
    } else if (paramInt >= 30 && paramInt < 40) {
      i = paramInt - 30;
    } else if (paramInt >= 40 && paramInt < 50) {
      i = paramInt - 40;
    } 
    switch (i) {
      case 0:
        return o.j;
      case 1:
        return o.n;
      case 2:
        return o.k;
      case 3:
        return o.p;
      case 4:
        return o.l;
      case 5:
        return o.o;
      case 6:
        return o.m;
      case 7:
        return o.i;
      case 8:
        return o.r;
    } 
    return o.j;
  }
  
  public static o b(int paramInt) {
    int i = paramInt;
    if (paramInt >= 20 && paramInt < 30) {
      i = paramInt - 20;
    } else if (paramInt >= 30 && paramInt < 40) {
      i = paramInt - 30;
    } else if (paramInt >= 40 && paramInt < 50) {
      i = paramInt - 40;
    } 
    switch (i) {
      case 0:
        return o.f;
      case 1:
        return o.b;
      case 2:
        return o.d;
      case 3:
        return o.e;
      case 4:
        return o.a;
      case 5:
        return o.g;
      case 7:
        return o.c;
      case 8:
        return o.r;
    } 
    return o.f;
  }
  
  public final void b(es parames) {
    if (parames == null)
      return; 
    int j;
    if ((j = parames.c()) == 0)
      return; 
    int i = aW + this.N;
    int k = aV;
    if (j == 1) {
      bt bt1 = (bt)parames.a(0);
      if (aZ) {
        bt1.a(k + aU / 2, i - 10, cf.v, bt1.a);
        return;
      } 
      bt1.a(k + aU / 2, i - 15, (ce)null, bt1.a);
      return;
    } 
    if (j == 2) {
      bt bt1 = (bt)parames.a(0);
      if (aZ) {
        bt1.a(k + aU / 4, i - 10, cf.v, bt1.a);
      } else {
        bt1.a(k + aU / 4, i - 15, (ce)null, bt1.a);
      } 
      bt bt2 = (bt)parames.a(1);
      if (aZ) {
        bt2.a(k + aU / 4 * 3 + 2, i - 10, cf.v, bt2.a);
        return;
      } 
      bt2.a(k + aU / 4 * 3 + 2, i - 15, (ce)null, bt2.a);
      return;
    } 
    for (byte b = 0; b < j; b++) {
      bt bt1 = (bt)parames.a(b);
      if (b == j - 1 && j % 2 == 1) {
        if (aZ) {
          bt1.a(k + aU / 2, i - 10, cf.v, bt1.a);
        } else {
          bt1.a(k + aU / 2, i - 15 - (j - 1) / 2 * 30 + b / 2 * 30, (ce)null, bt1.a);
        } 
      } else if (aZ) {
        bt1.a(k + aU / 4 + b % 2 * (aU / 2 + 2), i - 10 - (j - 1) / 2 * 22 + b / 2 * 22, cf.v, bt1.a);
      } else {
        bt1.a(k + aU / 4 + b % 2 * (aU / 2 + 2), i - 15 - (j - 1) / 2 * 30 + b / 2 * 30, (ce)null, bt1.a);
      } 
    } 
  }
  
  public static void c(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    parambx.a(o[paramInt5]);
    parambx.c(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fl.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */