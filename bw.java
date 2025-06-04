public class bw {
  public static byte a = 49;
  
  public static byte b = 50;
  
  public static int c = 51;
  
  public static String[] d;
  
  public static byte[] e;
  
  public static byte[] f;
  
  public String g;
  
  public String h;
  
  public String i;
  
  public cz[] j;
  
  public String[] k;
  
  public String[] l;
  
  public int[] m;
  
  public int[] n;
  
  public int o;
  
  public int p;
  
  public long q;
  
  public static dg r = new dg();
  
  public int s = 60;
  
  public int t;
  
  public int u;
  
  public short v;
  
  public static ce w;
  
  public byte x = 0;
  
  public byte y = 0;
  
  public byte z = 0;
  
  public byte A;
  
  public byte B = 0;
  
  public byte C = 0;
  
  public long D = 0L;
  
  public byte E = 0;
  
  public int F = -1;
  
  public long G = -1L;
  
  public boolean H = false;
  
  public String[] I = new String[] { "", "" };
  
  public es J = new es("EffectSkill moreContenGem");
  
  public int K;
  
  public byte L;
  
  public int M;
  
  public int N = 0;
  
  public int O;
  
  public int P;
  
  public byte Q;
  
  public int R;
  
  public int S;
  
  public String T = "";
  
  public static ek U = new ek();
  
  public static es V = new es("Item VecInvetoryPlayer");
  
  public static es W = new es("Item VecChestPlayer");
  
  public static es X = new es("Item VecPetContainer");
  
  public static es Y = new es("Item VecClanInvetory");
  
  public static es Z = new es("Item VecLotteryReward");
  
  public static es aa = new es("Item Sell");
  
  public static es ab = new es("Item Sell in store");
  
  public static ek ac = new ek();
  
  public static ek ad = new ek();
  
  public static ek ae = new ek();
  
  public static ek af = new ek();
  
  public static ek ag = new ek();
  
  public static ek ah = new ek();
  
  public static ek ai = new ek();
  
  public static ek aj = new ek();
  
  private static byte[] am = new byte[] { 0, 1, 2, 1 };
  
  private byte an = 0;
  
  public bw ak;
  
  public static byte[] al;
  
  private boolean f() {
    return (this.F != -1);
  }
  
  public final long a() {
    return dw.a() - this.G;
  }
  
  public void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    fd fd = null;
    if (this.g == null) {
      if (b())
        return; 
    } else {
      if (this.N > 0) {
        int i = this.N;
        if (this.N >= 20 && this.N < 30) {
          i = 6;
        } else if (this.N >= 30 && this.N < 40) {
          i = 7;
        } else if (this.N >= 40 && this.N < 50) {
          i = 8;
        } 
        parambx.a(cg.as, 0, i - 1 << 5, paramInt3 - 1, paramInt3 - 1, 2, paramInt1 - (paramInt3 - 1) / 2, paramInt2 - (paramInt3 - 1) / 2, 0);
      } 
      if (this.u == 6) {
        if (this.q <= 0L)
          parambx.a(cg.as, 0, 0, paramInt3 - 1, paramInt3 - 1, 2, paramInt1 - (paramInt3 - 1) / 2, paramInt2 - (paramInt3 - 1) / 2, 0); 
        ak.d(5, this.t).b(parambx, paramInt1, paramInt2, 0, 0);
        return;
      } 
      if (this.u == 5) {
        fd = bk.f((short)this.t);
      } else if (this.u == 4) {
        fd = bk.e((short)this.t);
      } else if (this.u == 3) {
        fd = bk.d((short)this.t);
      } else if (this.u == 7) {
        fd = bk.g((short)this.t);
      } else if (this.u == 8) {
        fd = bk.i((short)this.O);
      } else if (this.u == 9) {
        fd = bk.k((short)this.t);
      } 
      if (this.u != 6)
        if (fd != null && fd.a != null) {
          if (aq.b(fd.a.a) / 18 == 3) {
            if (ft.ai % 6 == 0) {
              int i;
              if ((i = am.length) == 0)
                i = 1; 
              this.an = (byte)((this.an + 1) % i);
            } 
            parambx.a(fd.a, 0, am[this.an] * 18, 18, 18, 0, paramInt1, paramInt2, 3);
          } else {
            parambx.a(fd.a, paramInt1, paramInt2, 3);
          } 
        } else {
          parambx.a(cg.an, 0, ft.ai % 12 << 4, 16, 16, 0, paramInt1, paramInt2, 3);
        }  
      if (this.u == 3 && this.z > 0) {
        int i = this.z;
        if (this.R == 7)
          i = this.z / 2; 
        r.a(paramInt1, paramInt2, i, paramInt3 - 4, parambx, paramInt4);
      } 
    } 
    if (this.K > 1)
      o.q.a(parambx, (new StringBuffer(String.valueOf(this.K))).toString(), paramInt1 + paramInt3 / 2 - 1 - paramInt5, paramInt2 + paramInt3 / 2 - 9 - paramInt5, 1, true); 
    if (this.B > 0)
      parambx.a(cg.av, paramInt1 + 4, paramInt2 + 3, 0); 
    if (this.u == 3) {
      if (this.p > 0)
        g(); 
      if (f())
        h(); 
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    fd fd = null;
    if (this.g == null) {
      if (b())
        return; 
    } else {
      if (this.N > 0) {
        int i = this.N;
        if (this.N >= 20 && this.N < 30) {
          i = 6;
        } else if (this.N >= 30 && this.N < 40) {
          i = 7;
        } else if (this.N >= 40 && this.N < 50) {
          i = 8;
        } 
        parambx.a(cg.as, 0, i - 1 << 5, paramInt3 - 1, paramInt3 - 1, 2, paramInt1 - (paramInt3 - 1) / 2, paramInt2 - (paramInt3 - 1) / 2, 0);
      } 
      if (this.u == 6) {
        if (this.q <= 0L)
          parambx.a(cg.as, 0, 0, paramInt3 - 1, paramInt3 - 1, 2, paramInt1 - (paramInt3 - 1) / 2, paramInt2 - (paramInt3 - 1) / 2, 0); 
        ak.d(5, this.t).b(parambx, paramInt1, paramInt2, 0, 0);
        return;
      } 
      if (this.u == 5) {
        fd = bk.f((short)this.t);
      } else if (this.u == 4) {
        fd = bk.e((short)this.t);
      } else if (this.u == 3) {
        fd = bk.d((short)this.t);
      } else if (this.u == 7) {
        fd = bk.g((short)this.t);
      } else if (this.u == 8) {
        fd = bk.i((short)this.O);
      } else if (this.u == 9) {
        fd = bk.k((short)this.t);
      } 
      if (this.u != 6)
        if (fd != null && fd.a != null) {
          if (aq.b(fd.a.a) / 18 == 3) {
            if (ft.ai % 6 == 0) {
              int i;
              if ((i = am.length) == 0)
                i = 1; 
              this.an = (byte)((this.an + 1) % i);
            } 
            parambx.a(fd.a, 0, am[this.an] * 18, 18, 18, 0, paramInt1, paramInt2, 3);
          } else {
            parambx.a(fd.a, paramInt1, paramInt2, 3);
          } 
        } else {
          parambx.a(cg.an, 0, ft.ai % 12 << 4, 16, 16, 0, paramInt1, paramInt2, 3);
        }  
      if (this.u == 3 && this.z > 0) {
        int i = this.z;
        if (this.R == 7)
          i = this.z / 2; 
        r.a(paramInt1, paramInt2, i, paramInt3 - 4, parambx, paramInt4);
      } 
    } 
    if (this.B > 0)
      parambx.a(cg.av, paramInt1 + 4, paramInt2 + 3, 0); 
    if (this.u == 3) {
      if (this.p > 0)
        g(); 
      if (f())
        h(); 
    } 
  }
  
  public void c(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    fd fd = null;
    if (this.g == null) {
      if (b())
        return; 
    } else {
      if (this.N > 0) {
        int i = this.N;
        if (this.N >= 20 && this.N < 30) {
          i = 6;
        } else if (this.N >= 30 && this.N < 40) {
          i = 7;
        } else if (this.N >= 40 && this.N < 50) {
          i = 8;
        } 
        parambx.a(cg.as, 0, i - 1 << 5, paramInt3 - 1, paramInt3 - 1, 2, paramInt1 - (paramInt3 - 1) / 2, paramInt2 - (paramInt3 - 1) / 2, 0);
      } 
      if (this.u == 6) {
        if (this.q <= 0L)
          parambx.a(cg.as, 0, 0, paramInt3 - 1, paramInt3 - 1, 2, paramInt1 - (paramInt3 - 1) / 2, paramInt2 - (paramInt3 - 1) / 2, 0); 
        ak.d(5, this.t).b(parambx, paramInt1, paramInt2, 0, 0);
        return;
      } 
      if (this.u == 5) {
        fd = bk.f((short)this.t);
      } else if (this.u == 4) {
        fd = bk.e((short)this.t);
      } else if (this.u == 3) {
        fd = bk.d((short)this.t);
      } else if (this.u == 7) {
        fd = bk.g((short)this.t);
      } else if (this.u == 8) {
        fd = bk.i((short)this.O);
      } else if (this.u == 9) {
        fd = bk.k((short)this.t);
      } 
      if (this.u != 6)
        if (fd != null && fd.a != null) {
          if (aq.b(fd.a.a) / 18 == 3) {
            if (ft.ai % 10 == 0) {
              int i;
              if ((i = am.length) == 0)
                i = 1; 
              this.an = (byte)((this.an + 1) % i);
            } 
            parambx.a(fd.a, 0, am[this.an] * 18, 18, 18, 0, paramInt1, paramInt2, 3);
          } else {
            parambx.a(fd.a, paramInt1, paramInt2, 3);
          } 
        } else {
          parambx.a(cg.an, 0, ft.ai % 12 << 4, 16, 16, 0, paramInt1, paramInt2, 3);
        }  
      if (this.u == 3 && this.z > 0) {
        int i = this.z;
        if (this.R == 7)
          i = this.z / 2; 
        r.a(paramInt1, paramInt2, i, paramInt3 - 4, parambx, paramInt4);
      } 
    } 
    if (this.B > 0)
      parambx.a(cg.av, paramInt1 + 4, paramInt2 + 3, 0); 
    if (this.u == 3) {
      if (this.p > 0)
        g(); 
      if (f())
        h(); 
    } 
  }
  
  private void g() {
    if ((ft.aj - this.D) / 1000L >= 60L && !f()) {
      this.D += 60000L;
      this.p--;
      if (this.l != null) {
        if (this.p > 0) {
          if (this.R == 14) {
            this.l[0] = String.valueOf(df.fQ) + cf.a(this.p);
            return;
          } 
          this.l[0] = String.valueOf(df.j) + cf.a(this.p);
          return;
        } 
        this.l[0] = "";
      } 
    } 
  }
  
  private void h() {
    if ((ft.aj - this.D) / 1000L >= 60L) {
      this.D += 60000L;
      int i = (int)(this.F - a() / 60000L);
      if (this.l != null) {
        if (i > 0) {
          if (this.R == 14) {
            this.l[0] = String.valueOf(df.fQ) + cf.a(i);
            return;
          } 
          this.l[0] = String.valueOf(df.j) + cf.a(i);
          return;
        } 
        this.l[0] = "";
      } 
    } 
  }
  
  public final boolean b() {
    if (this.g == null) {
      fo fo;
      if ((fo = fo.a(this.v)) != null && fo.c != null) {
        fo = fo;
        (this = this).g = fo.c;
        this.t = fo.b;
        this.R = fo.e;
        if (this.j == null) {
          cz[] arrayOfCz = new cz[fo.f.length];
          for (byte b = 0; b < fo.f.length; b++)
            arrayOfCz[b] = new cz(b, fo.f[b]); 
          this.j = arrayOfCz;
          c();
        } 
        return false;
      } 
      fo.a(this.v);
      ft.a(df.aD);
      return true;
    } 
    return false;
  }
  
  public final void c() {
    byte b1 = 0;
    int i;
    for (i = 0; i < this.j.length; i++) {
      cz cz1;
      if ((cz1 = this.j[i]).b > 0)
        b1++; 
    } 
    this.k = new String[b1];
    this.m = new int[b1];
    b1 = 0;
    if ((i = o.f.a(this.g)) > this.s - 10)
      this.s = i + 10; 
    for (byte b2 = 0; b2 < this.j.length; b2++) {
      cz cz1;
      if ((cz1 = this.j[b2]).b > 0) {
        this.k[b1] = String.valueOf(d[b2]) + ": " + cz1.b;
        if (f[b2] == 1)
          this.k[b1] = String.valueOf(this.k[b1]) + "%"; 
        this.m[b1] = e[b2];
        int j;
        if ((j = o.i.a(this.k[b1])) > this.s - 10)
          this.s = j + 10; 
        b1++;
      } 
    } 
    if (this.s > 200 && ft.A)
      this.s = 130; 
    i();
  }
  
  public final void d() {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Ljava/lang/String;
    //   4: ifnonnull -> 13
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield g : Ljava/lang/String;
    //   12: return
    //   13: iconst_0
    //   14: istore_1
    //   15: new es
    //   18: dup
    //   19: ldc 'EffectSkill tem'
    //   21: invokespecial <init> : (Ljava/lang/String;)V
    //   24: astore_2
    //   25: iconst_0
    //   26: istore_3
    //   27: goto -> 133
    //   30: aload_0
    //   31: getfield j : [Lcz;
    //   34: iload_3
    //   35: aaload
    //   36: astore #4
    //   38: getstatic bw.f : [B
    //   41: aload #4
    //   43: getfield a : I
    //   46: baload
    //   47: iconst_4
    //   48: if_icmpne -> 78
    //   51: new dl
    //   54: dup
    //   55: aload #4
    //   57: getfield b : I
    //   60: iload_3
    //   61: invokespecial <init> : (II)V
    //   64: astore #5
    //   66: aload_0
    //   67: getfield J : Les;
    //   70: aload #5
    //   72: invokevirtual a : (Ljava/lang/Object;)V
    //   75: goto -> 130
    //   78: getstatic bw.f : [B
    //   81: aload #4
    //   83: getfield a : I
    //   86: baload
    //   87: istore_1
    //   88: iconst_0
    //   89: istore #5
    //   91: goto -> 111
    //   94: iload_1
    //   95: getstatic bw.al : [B
    //   98: iload #5
    //   100: baload
    //   101: if_icmpne -> 108
    //   104: iconst_0
    //   105: goto -> 121
    //   108: iinc #5, 1
    //   111: iload #5
    //   113: getstatic bw.al : [B
    //   116: arraylength
    //   117: if_icmplt -> 94
    //   120: iconst_1
    //   121: ifeq -> 130
    //   124: aload_2
    //   125: aload #4
    //   127: invokevirtual a : (Ljava/lang/Object;)V
    //   130: iinc #3, 1
    //   133: iload_3
    //   134: aload_0
    //   135: getfield j : [Lcz;
    //   138: arraylength
    //   139: if_icmplt -> 30
    //   142: aload_2
    //   143: invokevirtual c : ()I
    //   146: istore_1
    //   147: aload_0
    //   148: iload_1
    //   149: anewarray java/lang/String
    //   152: putfield k : [Ljava/lang/String;
    //   155: aload_0
    //   156: iload_1
    //   157: newarray int
    //   159: putfield m : [I
    //   162: getstatic o.f : Lo;
    //   165: aload_0
    //   166: getfield g : Ljava/lang/String;
    //   169: invokevirtual a : (Ljava/lang/String;)I
    //   172: dup
    //   173: istore_3
    //   174: aload_0
    //   175: getfield s : I
    //   178: bipush #10
    //   180: isub
    //   181: if_icmple -> 192
    //   184: aload_0
    //   185: iload_3
    //   186: bipush #10
    //   188: iadd
    //   189: putfield s : I
    //   192: iconst_0
    //   193: istore #4
    //   195: goto -> 483
    //   198: aload_2
    //   199: iload #4
    //   201: invokevirtual a : (I)Ljava/lang/Object;
    //   204: checkcast cz
    //   207: dup
    //   208: astore #5
    //   210: getfield b : I
    //   213: ifne -> 235
    //   216: aload_0
    //   217: getfield k : [Ljava/lang/String;
    //   220: iload #4
    //   222: getstatic bw.d : [Ljava/lang/String;
    //   225: aload #5
    //   227: getfield a : I
    //   230: aaload
    //   231: aastore
    //   232: goto -> 431
    //   235: aload_0
    //   236: getfield R : I
    //   239: bipush #14
    //   241: if_icmpne -> 355
    //   244: aload #5
    //   246: getfield c : I
    //   249: ifle -> 322
    //   252: aload_0
    //   253: getfield k : [Ljava/lang/String;
    //   256: iload #4
    //   258: new java/lang/StringBuffer
    //   261: dup
    //   262: getstatic bw.d : [Ljava/lang/String;
    //   265: aload #5
    //   267: getfield a : I
    //   270: aaload
    //   271: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   274: invokespecial <init> : (Ljava/lang/String;)V
    //   277: ldc ': '
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   282: getstatic bw.f : [B
    //   285: aload #5
    //   287: getfield a : I
    //   290: baload
    //   291: aload #5
    //   293: getfield b : I
    //   296: invokestatic a : (II)Ljava/lang/String;
    //   299: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   302: ldc '-'
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   307: aload #5
    //   309: getfield c : I
    //   312: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   315: invokevirtual toString : ()Ljava/lang/String;
    //   318: aastore
    //   319: goto -> 431
    //   322: aload_0
    //   323: getfield k : [Ljava/lang/String;
    //   326: iload #4
    //   328: new java/lang/StringBuffer
    //   331: dup
    //   332: getstatic bw.d : [Ljava/lang/String;
    //   335: aload #5
    //   337: getfield a : I
    //   340: aaload
    //   341: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   344: invokespecial <init> : (Ljava/lang/String;)V
    //   347: ldc ': '
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   352: goto -> 407
    //   355: aload_0
    //   356: getfield k : [Ljava/lang/String;
    //   359: iload #4
    //   361: new java/lang/StringBuffer
    //   364: dup
    //   365: getstatic bw.d : [Ljava/lang/String;
    //   368: aload #5
    //   370: getfield a : I
    //   373: aaload
    //   374: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   377: invokespecial <init> : (Ljava/lang/String;)V
    //   380: ldc ': '
    //   382: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   385: aload #5
    //   387: getfield a : I
    //   390: bipush #70
    //   392: if_icmpne -> 407
    //   395: aload #5
    //   397: getfield b : I
    //   400: i2l
    //   401: invokestatic a : (J)Ljava/lang/String;
    //   404: goto -> 424
    //   407: getstatic bw.f : [B
    //   410: aload #5
    //   412: getfield a : I
    //   415: baload
    //   416: aload #5
    //   418: getfield b : I
    //   421: invokestatic a : (II)Ljava/lang/String;
    //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   427: invokevirtual toString : ()Ljava/lang/String;
    //   430: aastore
    //   431: aload_0
    //   432: getfield m : [I
    //   435: iload #4
    //   437: getstatic bw.e : [B
    //   440: aload #5
    //   442: getfield a : I
    //   445: baload
    //   446: iastore
    //   447: getstatic o.i : Lo;
    //   450: aload_0
    //   451: getfield k : [Ljava/lang/String;
    //   454: iload #4
    //   456: aaload
    //   457: invokevirtual a : (Ljava/lang/String;)I
    //   460: dup
    //   461: istore_3
    //   462: aload_0
    //   463: getfield s : I
    //   466: bipush #10
    //   468: isub
    //   469: if_icmple -> 480
    //   472: aload_0
    //   473: iload_3
    //   474: bipush #10
    //   476: iadd
    //   477: putfield s : I
    //   480: iinc #4, 1
    //   483: iload #4
    //   485: iload_1
    //   486: if_icmplt -> 198
    //   489: iconst_0
    //   490: istore #4
    //   492: aload_0
    //   493: getfield p : I
    //   496: ifle -> 502
    //   499: iinc #4, 1
    //   502: aload_0
    //   503: invokespecial f : ()Z
    //   506: istore #5
    //   508: aload_0
    //   509: getfield F : I
    //   512: i2l
    //   513: aload_0
    //   514: invokevirtual a : ()J
    //   517: ldc2_w 60000
    //   520: ldiv
    //   521: lsub
    //   522: l2i
    //   523: dup
    //   524: istore_1
    //   525: ifgt -> 531
    //   528: iconst_0
    //   529: istore #5
    //   531: iload #5
    //   533: ifeq -> 539
    //   536: iinc #4, 1
    //   539: aload_0
    //   540: getfield q : J
    //   543: lconst_0
    //   544: lcmp
    //   545: ifle -> 551
    //   548: iinc #4, 1
    //   551: aload_0
    //   552: getfield u : I
    //   555: iconst_3
    //   556: if_icmpne -> 578
    //   559: aload_0
    //   560: getfield M : I
    //   563: iconst_4
    //   564: if_icmpge -> 578
    //   567: aload_0
    //   568: getfield M : I
    //   571: iconst_m1
    //   572: if_icmple -> 578
    //   575: iinc #4, 1
    //   578: aload_0
    //   579: getfield R : I
    //   582: bipush #14
    //   584: if_icmpeq -> 597
    //   587: aload_0
    //   588: getfield S : I
    //   591: ifle -> 597
    //   594: iinc #4, 1
    //   597: iload #4
    //   599: ifle -> 1042
    //   602: aload_0
    //   603: iload #4
    //   605: anewarray java/lang/String
    //   608: putfield l : [Ljava/lang/String;
    //   611: aload_0
    //   612: iload #4
    //   614: newarray int
    //   616: putfield n : [I
    //   619: iconst_0
    //   620: istore #4
    //   622: aload_0
    //   623: getfield p : I
    //   626: ifle -> 748
    //   629: aload_0
    //   630: getfield n : [I
    //   633: iconst_0
    //   634: bipush #6
    //   636: iastore
    //   637: aload_0
    //   638: getfield R : I
    //   641: bipush #14
    //   643: if_icmpne -> 681
    //   646: aload_0
    //   647: getfield l : [Ljava/lang/String;
    //   650: iconst_0
    //   651: new java/lang/StringBuffer
    //   654: dup
    //   655: getstatic df.fQ : Ljava/lang/String;
    //   658: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   661: invokespecial <init> : (Ljava/lang/String;)V
    //   664: aload_0
    //   665: getfield p : I
    //   668: invokestatic a : (I)Ljava/lang/String;
    //   671: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   674: invokevirtual toString : ()Ljava/lang/String;
    //   677: aastore
    //   678: goto -> 713
    //   681: aload_0
    //   682: getfield l : [Ljava/lang/String;
    //   685: iconst_0
    //   686: new java/lang/StringBuffer
    //   689: dup
    //   690: getstatic df.j : Ljava/lang/String;
    //   693: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   696: invokespecial <init> : (Ljava/lang/String;)V
    //   699: aload_0
    //   700: getfield p : I
    //   703: invokestatic a : (I)Ljava/lang/String;
    //   706: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   709: invokevirtual toString : ()Ljava/lang/String;
    //   712: aastore
    //   713: getstatic o.i : Lo;
    //   716: aload_0
    //   717: getfield l : [Ljava/lang/String;
    //   720: iconst_0
    //   721: aaload
    //   722: invokevirtual a : (Ljava/lang/String;)I
    //   725: dup
    //   726: istore_3
    //   727: aload_0
    //   728: getfield s : I
    //   731: bipush #10
    //   733: isub
    //   734: if_icmple -> 745
    //   737: aload_0
    //   738: iload_3
    //   739: bipush #10
    //   741: iadd
    //   742: putfield s : I
    //   745: iinc #4, 1
    //   748: iload #5
    //   750: ifeq -> 795
    //   753: aload_0
    //   754: getfield n : [I
    //   757: iload #4
    //   759: bipush #6
    //   761: iastore
    //   762: aload_0
    //   763: getfield l : [Ljava/lang/String;
    //   766: iload #4
    //   768: new java/lang/StringBuffer
    //   771: dup
    //   772: getstatic df.j : Ljava/lang/String;
    //   775: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   778: invokespecial <init> : (Ljava/lang/String;)V
    //   781: iload_1
    //   782: invokestatic a : (I)Ljava/lang/String;
    //   785: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   788: invokevirtual toString : ()Ljava/lang/String;
    //   791: aastore
    //   792: iinc #4, 1
    //   795: aload_0
    //   796: getfield u : I
    //   799: iconst_3
    //   800: if_icmpne -> 890
    //   803: aload_0
    //   804: getfield M : I
    //   807: iconst_4
    //   808: if_icmpge -> 890
    //   811: aload_0
    //   812: getfield M : I
    //   815: iconst_m1
    //   816: if_icmple -> 890
    //   819: aload_0
    //   820: getfield l : [Ljava/lang/String;
    //   823: iload #4
    //   825: new java/lang/StringBuffer
    //   828: dup
    //   829: ldc '['
    //   831: invokespecial <init> : (Ljava/lang/String;)V
    //   834: getstatic df.gn : [Ljava/lang/String;
    //   837: aload_0
    //   838: getfield M : I
    //   841: aaload
    //   842: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   845: ldc ']'
    //   847: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   850: invokevirtual toString : ()Ljava/lang/String;
    //   853: aastore
    //   854: aload_0
    //   855: getfield M : I
    //   858: getstatic cn.f : Lbq;
    //   861: getfield bx : B
    //   864: if_icmpne -> 878
    //   867: aload_0
    //   868: getfield n : [I
    //   871: iload #4
    //   873: iconst_0
    //   874: iastore
    //   875: goto -> 887
    //   878: aload_0
    //   879: getfield n : [I
    //   882: iload #4
    //   884: bipush #6
    //   886: iastore
    //   887: iinc #4, 1
    //   890: aload_0
    //   891: getfield q : J
    //   894: lconst_0
    //   895: lcmp
    //   896: ifle -> 952
    //   899: aload_0
    //   900: getfield l : [Ljava/lang/String;
    //   903: iload #4
    //   905: new java/lang/StringBuffer
    //   908: dup
    //   909: getstatic df.ba : Ljava/lang/String;
    //   912: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   915: invokespecial <init> : (Ljava/lang/String;)V
    //   918: ldc ': '
    //   920: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   923: aload_0
    //   924: getfield q : J
    //   927: invokevirtual append : (J)Ljava/lang/StringBuffer;
    //   930: aload_0
    //   931: invokevirtual e : ()Ljava/lang/String;
    //   934: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   937: invokevirtual toString : ()Ljava/lang/String;
    //   940: aastore
    //   941: aload_0
    //   942: getfield n : [I
    //   945: iload #4
    //   947: iconst_2
    //   948: iastore
    //   949: iinc #4, 1
    //   952: aload_0
    //   953: getfield R : I
    //   956: bipush #14
    //   958: if_icmpeq -> 1052
    //   961: aload_0
    //   962: getfield S : I
    //   965: ifle -> 1052
    //   968: aload_0
    //   969: getfield l : [Ljava/lang/String;
    //   972: iload #4
    //   974: new java/lang/StringBuffer
    //   977: dup
    //   978: getstatic df.bG : Ljava/lang/String;
    //   981: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   984: invokespecial <init> : (Ljava/lang/String;)V
    //   987: aload_0
    //   988: getfield S : I
    //   991: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   994: invokevirtual toString : ()Ljava/lang/String;
    //   997: aastore
    //   998: aload_0
    //   999: getfield n : [I
    //   1002: iload #4
    //   1004: iconst_0
    //   1005: iastore
    //   1006: getstatic o.i : Lo;
    //   1009: aload_0
    //   1010: getfield l : [Ljava/lang/String;
    //   1013: iload #4
    //   1015: aaload
    //   1016: invokevirtual a : (Ljava/lang/String;)I
    //   1019: dup
    //   1020: istore_3
    //   1021: aload_0
    //   1022: getfield s : I
    //   1025: bipush #10
    //   1027: isub
    //   1028: if_icmple -> 1052
    //   1031: aload_0
    //   1032: iload_3
    //   1033: bipush #10
    //   1035: iadd
    //   1036: putfield s : I
    //   1039: goto -> 1052
    //   1042: aload_0
    //   1043: aconst_null
    //   1044: putfield l : [Ljava/lang/String;
    //   1047: aload_0
    //   1048: aconst_null
    //   1049: putfield n : [I
    //   1052: aload_0
    //   1053: getfield s : I
    //   1056: sipush #200
    //   1059: if_icmple -> 1075
    //   1062: getstatic ft.A : Z
    //   1065: ifeq -> 1075
    //   1068: aload_0
    //   1069: sipush #130
    //   1072: putfield s : I
    //   1075: aload_0
    //   1076: invokespecial i : ()V
    //   1079: return
  }
  
  private void i() {
    if (this.k == null || (this.k != null && this.k.length == 1) || this.k.length == 0)
      return; 
    if (this.u != 3)
      return; 
    int i = this.s;
    es es1 = new es();
    String str = this.k[0];
    int j = this.m[0];
    byte b;
    for (b = 1; b < this.k.length; b++) {
      String[] arrayOfString = o.i.a(this.k[b], i);
      for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
        ci ci = new ci(arrayOfString[b1], (byte)this.m[b]);
        es1.a(ci);
      } 
    } 
    this.k = new String[es1.c() + 1];
    this.m = new int[es1.c() + 1];
    this.k[0] = str;
    this.m[0] = j;
    for (b = 0; b < es1.c(); b++) {
      ci ci = (ci)es1.a(b);
      this.k[b + 1] = ci.a;
      this.m[b + 1] = ci.b;
    } 
  }
  
  public static String a(int paramInt1, int paramInt2) {
    return (String)((paramInt1 == 1) ? ((paramInt2 % 100 == 0) ? (String.valueOf(paramInt2 / 100) + "%") : ((paramInt2 % 10 == 0) ? (String.valueOf(paramInt2 / 100) + "." + (paramInt2 % 100 / 10) + "%") : (String.valueOf(paramInt2 / 100) + "." + (paramInt2 % 100 / 10) + (paramInt2 % 10) + "%"))) : ((paramInt1 == 2) ? (String.valueOf(paramInt2 / 1000) + "," + (paramInt2 % 1000 / 100) + "s") : ((paramInt1 == 3) ? (String.valueOf(paramInt2) + "$") : ((paramInt1 == 4) ? " " : ((paramInt1 == 6) ? (String.valueOf(paramInt2) + " " + df.bO) : ((paramInt1 == 7) ? "" : paramInt2))))));
  }
  
  public final String e() {
    String str = " " + df.bO;
    if (this.Q == 1)
      str = " " + df.bP; 
    return str;
  }
  
  public static bw a(int paramInt, short paramShort, es parames) {
    for (byte b = 0; b < parames.c(); b++) {
      bw bw1;
      if ((bw1 = (bw)parames.a(b)).O == paramShort && bw1.u == paramInt)
        return bw1; 
    } 
    return null;
  }
  
  public static bw a(int paramInt, short paramShort) {
    for (byte b = 0; b < V.c(); b++) {
      bw bw1;
      if ((bw1 = (bw)V.a(b)).O == paramShort && bw1.u == paramInt)
        return bw1; 
    } 
    return null;
  }
  
  public static j b(int paramInt) {
    j j = null;
    return ((j = (j)fo.n.a((new StringBuffer(String.valueOf(paramInt))).toString())) != null) ? j : null;
  }
  
  public static void c(int paramInt) {
    j j = new j();
    fo.n.a(paramInt, j);
    q.a().g((short)paramInt);
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, long paramLong, byte paramByte1, String paramString2, int paramInt4, byte paramByte2, byte paramByte3, byte paramByte4) {
    this.g = paramString1;
    this.t = paramInt2;
    this.O = paramInt1;
    this.u = 7;
    this.q = paramLong;
    this.Q = paramByte1;
    this.P = paramInt4;
    this.x = paramByte3;
    this.y = paramByte4;
    this.h = paramString2;
    this.A = paramByte2;
    if (paramString2 != null)
      a(paramString2); 
    this.C = 2;
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, byte paramByte1, String paramString2, int paramInt3, byte paramByte2, byte paramByte3, byte paramByte4) {
    this.g = paramString1;
    this.t = paramInt1;
    this.u = 7;
    this.q = paramLong;
    this.Q = paramByte1;
    this.P = paramInt3;
    this.x = paramByte3;
    this.y = paramByte4;
    this.h = paramString2;
    this.A = paramByte2;
    if (paramString2 != null)
      a(paramString2); 
    this.C = 2;
  }
  
  public void a(String paramString) {
    this.s = 86;
    if (fl.aU > 0)
      this.s = fl.aU - 5; 
    this.k = o.i.a(paramString, this.s - 5);
    if (fl.aU == 0 && ((this.k.length + 1) * ft.ab > ft.X / 4 * 3 || o.c.a(this.g) > 70)) {
      this.s = 120;
      this.k = o.i.a(paramString, this.s - 5);
    } 
    this.m = new int[this.k.length];
    byte b;
    for (b = 0; b < this.m.length; b++)
      this.m[b] = 0; 
    b = 0;
    if (this.q > 0L)
      b++; 
    if (b > 0) {
      this.l = new String[1];
      this.n = new int[1];
      if (this.q > 0L) {
        this.l[0] = String.valueOf(df.ba) + ": " + j.a(this.q) + e();
        this.n[0] = 2;
      } 
    } else {
      this.l = null;
      this.n = null;
    } 
    if (this.s > 200 && ft.A)
      this.s = 120; 
    i();
  }
  
  public final void d(int paramInt) {
    this.N = paramInt;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bw.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */