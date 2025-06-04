public final class fn extends fl {
  public static byte a = 0;
  
  public static byte b = 1;
  
  public static byte c = 2;
  
  public static byte d = 3;
  
  public static byte e = 4;
  
  public static byte f = 6;
  
  public static byte g = 7;
  
  public static byte h = 7;
  
  public static byte i = 8;
  
  public static byte j = 9;
  
  public static byte k = 11;
  
  public static byte l = 12;
  
  public static byte m = 13;
  
  public static byte n = 14;
  
  public static byte o = 15;
  
  public static byte p = 16;
  
  public static byte q = 17;
  
  public static byte r = 18;
  
  private static byte H = 0;
  
  private static byte I = 1;
  
  public static byte s = 2;
  
  private static byte J = 0;
  
  private static byte bv = 1;
  
  public static boolean t;
  
  public static short u;
  
  public static short v;
  
  public static short w;
  
  public static short x;
  
  public static short y = 1;
  
  public static short z;
  
  public static short A;
  
  public static short B = 0;
  
  public static boolean C = false;
  
  private int bw;
  
  private int bx = 6;
  
  private int by = 6;
  
  private int bz;
  
  private int bA = 60;
  
  private int bB = 0;
  
  private int bC = 0;
  
  private dy bD;
  
  private String bE = "";
  
  private es bF = new es("TabShopNew vecShop");
  
  public ea D = null;
  
  private byte bG;
  
  public static short E = 0;
  
  public boolean F = false;
  
  private byte bH;
  
  public static byte G;
  
  private bt bI;
  
  private bt bJ;
  
  private bt bK;
  
  private bt bL;
  
  private bt bM;
  
  private bt bN;
  
  private bt bO;
  
  private bt bP;
  
  private bt bQ;
  
  private bt bR;
  
  private bt bS;
  
  private bt bT;
  
  private bt bU;
  
  private bt bV;
  
  private bt bW;
  
  private bt bX;
  
  private bt bY;
  
  private bt bZ;
  
  private bt ca;
  
  private bt cb;
  
  private bt cc;
  
  private bt cd;
  
  private bt ce;
  
  private bt cf;
  
  private bt cg;
  
  private bt ch;
  
  private bt ci;
  
  private bt cj;
  
  private bt ck;
  
  private bt cl;
  
  private bt cm;
  
  private bt cn;
  
  private bt co;
  
  private bt cp;
  
  private bt cq;
  
  private bt cr;
  
  private bt cs;
  
  private bt ct;
  
  private bt cu;
  
  private bt cv;
  
  private bt cw;
  
  private bt cx;
  
  private bt cy;
  
  private bt cz;
  
  private bt cA;
  
  private bt cB;
  
  private bt cC;
  
  private bt cD;
  
  private bt cE;
  
  private dy cF;
  
  private bp cG;
  
  private es cH = new es("list cmd");
  
  private byte cI = 0;
  
  private String cJ = "";
  
  private boolean cK;
  
  public fn(es parames, byte paramByte1, String paramString, int paramInt, byte paramByte2) {
    this.K = paramByte1;
    this.cK = false;
    this.V = this.L + fl.aM + fl.aN * 3;
    this.W = 0 + ft.X / 5 + fl.aM + 1;
    this.bx = fl.S / fl.aM;
    this.bz = fl.T / fl.aM;
    this.bA = parames.c();
    if (this.bA % this.bx != 0)
      this.bA += this.bx - this.bA % this.bx; 
    if (this.K == 0 || this.K == 16) {
      this.bF = bw.V;
      if (this.bA < bq.x)
        this.bA = bq.x; 
    } else if (this.K == 15) {
      this.bF = bw.aa;
    } else if (this.K == 9) {
      this.bF = bw.W;
      if (this.bA < bq.y)
        this.bA = bq.y; 
    } else if (this.K == 13) {
      this.bF = bw.X;
      if (this.bA < bq.z)
        this.bA = bq.y; 
    } else if (this.K == 12) {
      this.bF = bw.Y;
    } else {
      this.bF = parames;
      this.cK = true;
    } 
    this.bA = 42;
    this.bH = 0;
    G = (byte)(bq.x / 42);
    if (this.K == 13)
      G = (byte)(bq.z / 42); 
    if (this.cK)
      this.bA = this.bF.c(); 
    this.by = (this.bA - 1) / this.bx + 1;
    this.X = paramString;
    this.bw = paramInt;
    this.cI = paramByte2;
    if (paramByte2 == l)
      this.bG = 2; 
    if (paramByte2 == m || paramByte2 == p)
      this.bG = 5; 
    if (paramString == null || paramString.length() == 0)
      this.X = "Name Tab"; 
    this.bI = new bt(df.ak, 0, this);
    this.bJ = new bt(df.bj, 6, this);
    this.aT = new bt(df.af, -1, this);
    if (ft.A)
      this.aT.a = df.Z; 
    this.bK = new bt(df.ak, 2, this);
    this.bL = new bt(df.ak, 3, this);
    this.bM = new bt(df.bN, 4, this);
    this.bN = new bt(df.bN, 5, this);
    this.bO = new bt(df.Y, 7, this);
    this.bP = new bt(df.aQ, 8, this);
    this.bQ = new bt(df.bE, 11, this);
    this.bR = new bt(df.bE, 10, this);
    this.bS = new bt(df.dR, 13, this);
    this.bT = new bt(df.dS, 14, this);
    this.bU = new bt(df.dR, 15, this);
    this.bV = new bt(df.dS, 16, this);
    this.bW = new bt(df.dV, 17, this);
    this.bX = new bt(df.eg, 20, this);
    this.bY = new bt(df.dR, 21, this);
    this.bZ = new bt(df.aa, 22, this);
    this.ca = new bt(df.fk, 23, this);
    this.cb = new bt(df.fx, 24, this);
    this.cc = new bt(df.fv, 3, this);
    this.cd = new bt(df.fR, 25, this);
    this.ce = new bt(df.bj, 26, this);
    this.cf = new bt(df.fI, 27, this);
    this.cg = new bt(df.fI, 29, this);
    this.ch = new bt(df.gd, 30, this);
    this.ci = new bt(String.valueOf(df.ak) + " 1", 31, this);
    this.cj = new bt(String.valueOf(df.ak) + " 10", 32, this);
    this.ck = new bt(String.valueOf(df.ak) + " 30", 33, this);
    this.cl = new bt(df.Q, 36, this);
    this.co = new bt(df.P, 37, this);
    this.cn = new bt(df.P, 38, this);
    this.cp = new bt(df.dR, 39, this);
    this.cq = new bt(df.J, 0, this);
    this.cm = new bt(df.I, 40, this);
    this.cr = new bt(df.C, 41, this);
    this.cs = new bt(df.C, 42, this);
    this.ct = new bt(df.y, 44, this);
    this.cu = new bt(df.y, 45, this);
    this.cv = new bt(df.ak, 46, this);
    this.cw = new bt(df.as, 47, this);
    this.cx = new bt(df.w, 48, this);
    this.cy = new bt(df.fr, 49, this);
    this.cz = new bt(df.s, 52, this);
    this.cA = new bt(df.dR, 53, this);
    this.cC = new bt(df.P, 54, this);
    this.cB = new bt(df.C, 55, this);
    this.cD = new bt(df.dx, 56, this);
    this.cE = new bt(df.d, 57, this);
    b();
  }
  
  public final void a(String paramString) {
    this.cJ = paramString;
    this.bI.a = paramString;
    this.bL.a = paramString;
  }
  
  public final void b() {
    if (ft.A) {
      this.bB = -1;
    } else {
      this.bB = 0;
    } 
    fl.bi = 0;
    int i = 0;
    if (this.K == 0 || this.K == 16) {
      if (C) {
        bw.V = ak.e(bw.V);
        C = false;
      } 
      i = bw.V.c();
    } else if (this.K == 15) {
      i = bw.aa.c();
    } else if (this.K == 9) {
      i = bw.W.c();
    } else if (this.K == 12) {
      i = bw.Y.c();
    } else if (this.K == 13) {
      i = bw.X.c();
    } else {
      i = this.bF.c();
    } 
    p.e.a(0, this.by * fl.aM - fl.T - fl.aN + 8, 0, 0);
    this.cG = new bp(this.V, this.W, fl.S, fl.T, 0, 0, p.e.f);
    this.aY = null;
    if (i == 0) {
      fl.aO = 0;
    } else if (!ft.A) {
      if (this.K == 8) {
        if (this.cI == e) {
          this.aa = this.bO;
        } else if (this.cI == h) {
          this.aa = this.cc;
        } else {
          this.aa = this.bI;
        } 
      } else if (this.K == 9 || this.K == 15) {
        if (bw.W.c() > 0)
          this.aa = this.bO; 
      } else if (this.K == 12) {
        if (bw.Y.c() > 0)
          this.aa = this.bO; 
      } else if (this.K == 0 || this.K == 16) {
        if (bw.V.c() > 0)
          this.aa = this.bO; 
      } else if (this.K == 13 && bw.X.c() > 0) {
        this.aa = this.bO;
      } 
      this.Z = this.aT;
    } 
    this.bH = 0;
    super.b();
  }
  
  public final void c() {
    fl.aO = 0;
    this.bB = 0;
    super.c();
  }
  
  public final void a(int paramInt, Object paramObject) {
    j j;
    es es1;
    "commandPointer index = " + paramInt;
    if (this.K == 15) {
      es1 = bw.aa;
    } else if (this.K == 0 || this.K == 16) {
      es1 = bw.V;
    } else if (this.K == 9) {
      es1 = bw.W;
    } else if (this.K == 13) {
      es1 = bw.X;
    } else if (this.K == 12) {
      es1 = bw.Y;
    } else {
      es1 = this.bF;
    } 
    if (this.bB < 0 && paramInt > 0)
      return; 
    if (fl.aU == 0)
      fl.bi = 0; 
    switch (paramInt) {
      case 43:
        if ((j = (j)es1.a(this.bB)) != null) {
          paramObject = paramObject;
          int i = 0;
          short s1 = 1;
          try {
            if (paramObject != null) {
              i = ((fh)paramObject).a;
              s1 = ((fh)paramObject).c;
            } 
          } catch (Exception exception) {
            ft.a(df.z);
            return;
          } 
          short s = (short)j.O;
          fh fh = new fh(s, i, s1, j.u);
          bw.ab.a(fh);
          if (j.u == 4) {
            j = j;
            j j1;
            (j1 = new j()).O = j.O;
            j1.t = j.t;
            j1.g = j.g;
            j1.L = j.L;
            j1.K = j.K;
            j1.u = j.u;
            j1.q = j.q;
            j1.Q = j.Q;
            j1.x = j.Q;
            j1.y = j.Q;
            if (j.h != null)
              j1.a(j.h); 
            j.C = 0;
            (j = j1).K = s1;
            bw.aa.a(j);
          } else if (j.u == 7) {
            j = j;
            j j1;
            (j1 = new j()).g = j.g;
            j1.t = j.t;
            j1.O = j.O;
            j1.u = j.u;
            j1.q = j.q;
            j1.Q = j.Q;
            j1.P = j.P;
            j1.x = j.x;
            j1.y = j.y;
            j1.h = j.h;
            j1.A = j.A;
            if (j.h != null)
              j1.a(j.h); 
            j1.C = 2;
            (j = j1).K = s1;
            bw.aa.a(j);
          } else {
            bw.aa.a(j);
          } 
        } 
        if (this.cH != null)
          this.cH.d(); 
        ft.j();
        break;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new java/lang/StringBuffer
    //   5: dup
    //   6: ldc 'commandPointer index = '
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: iload_1
    //   12: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   15: invokevirtual toString : ()Ljava/lang/String;
    //   18: pop
    //   19: aload_0
    //   20: getfield K : B
    //   23: bipush #15
    //   25: if_icmpne -> 35
    //   28: getstatic bw.aa : Les;
    //   31: astore_3
    //   32: goto -> 111
    //   35: aload_0
    //   36: getfield K : B
    //   39: ifeq -> 51
    //   42: aload_0
    //   43: getfield K : B
    //   46: bipush #16
    //   48: if_icmpne -> 58
    //   51: getstatic bw.V : Les;
    //   54: astore_3
    //   55: goto -> 111
    //   58: aload_0
    //   59: getfield K : B
    //   62: bipush #9
    //   64: if_icmpne -> 74
    //   67: getstatic bw.W : Les;
    //   70: astore_3
    //   71: goto -> 111
    //   74: aload_0
    //   75: getfield K : B
    //   78: bipush #13
    //   80: if_icmpne -> 90
    //   83: getstatic bw.X : Les;
    //   86: astore_3
    //   87: goto -> 111
    //   90: aload_0
    //   91: getfield K : B
    //   94: bipush #12
    //   96: if_icmpne -> 106
    //   99: getstatic bw.Y : Les;
    //   102: astore_3
    //   103: goto -> 111
    //   106: aload_0
    //   107: getfield bF : Les;
    //   110: astore_3
    //   111: aload_0
    //   112: getfield bB : I
    //   115: ifge -> 123
    //   118: iload_1
    //   119: ifle -> 123
    //   122: return
    //   123: getstatic fl.aU : I
    //   126: ifne -> 133
    //   129: iconst_0
    //   130: putstatic fl.bi : I
    //   133: iload_1
    //   134: tableswitch default -> 5488, -1 -> 384, 0 -> 389, 1 -> 777, 2 -> 814, 3 -> 875, 4 -> 920, 5 -> 980, 6 -> 1029, 7 -> 1700, 8 -> 1801, 9 -> 2012, 10 -> 2123, 11 -> 2183, 12 -> 2382, 13 -> 2434, 14 -> 2528, 15 -> 2624, 16 -> 2694, 17 -> 2764, 18 -> 2827, 19 -> 2976, 20 -> 3187, 21 -> 3238, 22 -> 3308, 23 -> 3334, 24 -> 3365, 25 -> 3397, 26 -> 3494, 27 -> 3554, 28 -> 3602, 29 -> 3636, 30 -> 3747, 31 -> 875, 32 -> 3798, 33 -> 3964, 34 -> 4130, 35 -> 4176, 36 -> 4180, 37 -> 4222, 38 -> 4280, 39 -> 4362, 40 -> 4180, 41 -> 4418, 42 -> 4465, 43 -> 5488, 44 -> 4787, 45 -> 4825, 46 -> 4885, 47 -> 4995, 48 -> 5008, 49 -> 5022, 50 -> 5068, 51 -> 5183, 52 -> 5197, 53 -> 5250, 54 -> 5293, 55 -> 5340, 56 -> 5393, 57 -> 5454
    //   384: aload_0
    //   385: invokevirtual c : ()V
    //   388: return
    //   389: aload_3
    //   390: aload_0
    //   391: getfield bB : I
    //   394: invokevirtual a : (I)Ljava/lang/Object;
    //   397: checkcast bw
    //   400: dup
    //   401: astore_3
    //   402: ifnull -> 412
    //   405: aload_3
    //   406: invokevirtual b : ()Z
    //   409: ifeq -> 413
    //   412: return
    //   413: aload_0
    //   414: getfield cI : B
    //   417: getstatic fn.o : B
    //   420: if_icmpne -> 449
    //   423: getstatic ft.A : Z
    //   426: ifeq -> 441
    //   429: getstatic ft.A : Z
    //   432: ifeq -> 449
    //   435: getstatic dw.g : Z
    //   438: ifeq -> 449
    //   441: aload_0
    //   442: getfield cv : Lbt;
    //   445: invokevirtual a : ()V
    //   448: return
    //   449: aload_3
    //   450: getfield T : Ljava/lang/String;
    //   453: ldc ''
    //   455: if_acmpeq -> 470
    //   458: aload_3
    //   459: getfield T : Ljava/lang/String;
    //   462: aload_0
    //   463: getfield bL : Lbt;
    //   466: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   469: return
    //   470: aload_3
    //   471: getfield u : I
    //   474: iconst_4
    //   475: if_icmpeq -> 487
    //   478: aload_3
    //   479: getfield u : I
    //   482: bipush #7
    //   484: if_icmpne -> 533
    //   487: aload_0
    //   488: new dy
    //   491: dup
    //   492: invokespecial <init> : ()V
    //   495: putfield cF : Ldy;
    //   498: aload_0
    //   499: getfield cF : Ldy;
    //   502: getstatic df.aK : Ljava/lang/String;
    //   505: aload_0
    //   506: getfield bK : Lbt;
    //   509: iconst_1
    //   510: iconst_m1
    //   511: aload_3
    //   512: getfield q : J
    //   515: getstatic df.aY : Ljava/lang/String;
    //   518: aload_3
    //   519: invokevirtual e : ()Ljava/lang/String;
    //   522: invokevirtual a : (Ljava/lang/String;Lbt;ZIJLjava/lang/String;Ljava/lang/String;)V
    //   525: aload_0
    //   526: getfield cF : Ldy;
    //   529: putstatic ft.r : Lda;
    //   532: return
    //   533: aload_3
    //   534: getfield u : I
    //   537: iconst_3
    //   538: if_icmpne -> 617
    //   541: aload_0
    //   542: getfield bL : Lbt;
    //   545: getstatic df.ak : Ljava/lang/String;
    //   548: putfield a : Ljava/lang/String;
    //   551: new java/lang/StringBuffer
    //   554: dup
    //   555: getstatic df.aF : Ljava/lang/String;
    //   558: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   561: invokespecial <init> : (Ljava/lang/String;)V
    //   564: ldc '1 '
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   569: aload_3
    //   570: getfield g : Ljava/lang/String;
    //   573: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   576: ldc '. '
    //   578: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   581: getstatic df.cy : Ljava/lang/String;
    //   584: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   587: aload_3
    //   588: getfield q : J
    //   591: invokevirtual append : (J)Ljava/lang/StringBuffer;
    //   594: aload_3
    //   595: invokevirtual e : ()Ljava/lang/String;
    //   598: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   601: ldc '?'
    //   603: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   606: invokevirtual toString : ()Ljava/lang/String;
    //   609: aload_0
    //   610: getfield bL : Lbt;
    //   613: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   616: return
    //   617: aload_3
    //   618: getfield u : I
    //   621: bipush #6
    //   623: if_icmpne -> 747
    //   626: aload_3
    //   627: getfield q : J
    //   630: lconst_0
    //   631: lcmp
    //   632: ifle -> 706
    //   635: aload_0
    //   636: getfield bL : Lbt;
    //   639: getstatic df.ak : Ljava/lang/String;
    //   642: putfield a : Ljava/lang/String;
    //   645: new java/lang/StringBuffer
    //   648: dup
    //   649: getstatic df.aF : Ljava/lang/String;
    //   652: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   655: invokespecial <init> : (Ljava/lang/String;)V
    //   658: aload_3
    //   659: getfield g : Ljava/lang/String;
    //   662: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   665: ldc '. '
    //   667: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   670: getstatic df.cy : Ljava/lang/String;
    //   673: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   676: aload_3
    //   677: getfield q : J
    //   680: invokevirtual append : (J)Ljava/lang/StringBuffer;
    //   683: aload_3
    //   684: invokevirtual e : ()Ljava/lang/String;
    //   687: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   690: ldc '?'
    //   692: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   695: invokevirtual toString : ()Ljava/lang/String;
    //   698: aload_0
    //   699: getfield bL : Lbt;
    //   702: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   705: return
    //   706: aload_3
    //   707: getfield t : I
    //   710: getstatic cn.f : Lbq;
    //   713: getfield cb : I
    //   716: if_icmpne -> 726
    //   719: getstatic df.dJ : Ljava/lang/String;
    //   722: invokestatic a : (Ljava/lang/String;)V
    //   725: return
    //   726: aload_0
    //   727: getfield bL : Lbt;
    //   730: getstatic df.bj : Ljava/lang/String;
    //   733: putfield a : Ljava/lang/String;
    //   736: getstatic df.bi : Ljava/lang/String;
    //   739: aload_0
    //   740: getfield bL : Lbt;
    //   743: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   746: return
    //   747: aload_3
    //   748: getfield u : I
    //   751: bipush #8
    //   753: if_icmpne -> 5488
    //   756: aload_0
    //   757: getfield bL : Lbt;
    //   760: getstatic df.Y : Ljava/lang/String;
    //   763: putfield a : Ljava/lang/String;
    //   766: getstatic df.ex : Ljava/lang/String;
    //   769: aload_0
    //   770: getfield bL : Lbt;
    //   773: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   776: return
    //   777: aload_3
    //   778: aload_0
    //   779: getfield bB : I
    //   782: invokevirtual a : (I)Ljava/lang/Object;
    //   785: checkcast bw
    //   788: dup
    //   789: astore_1
    //   790: ifnonnull -> 794
    //   793: return
    //   794: getstatic df.bi : Ljava/lang/String;
    //   797: new bt
    //   800: dup
    //   801: getstatic df.bj : Ljava/lang/String;
    //   804: bipush #6
    //   806: aload_0
    //   807: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   810: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   813: return
    //   814: aload_3
    //   815: aload_0
    //   816: getfield bB : I
    //   819: invokevirtual a : (I)Ljava/lang/Object;
    //   822: checkcast j
    //   825: dup
    //   826: astore_1
    //   827: ifnonnull -> 831
    //   830: return
    //   831: iconst_0
    //   832: istore_2
    //   833: aload_0
    //   834: getfield cF : Ldy;
    //   837: getfield a : Lfi;
    //   840: invokevirtual j : ()Ljava/lang/String;
    //   843: invokestatic parseInt : (Ljava/lang/String;)I
    //   846: istore_2
    //   847: goto -> 853
    //   850: astore_2
    //   851: iconst_1
    //   852: istore_2
    //   853: invokestatic a : ()Lq;
    //   856: aload_0
    //   857: getfield bw : I
    //   860: i2b
    //   861: aload_1
    //   862: getfield O : I
    //   865: i2s
    //   866: iload_2
    //   867: i2s
    //   868: invokevirtual a : (BSS)V
    //   871: invokestatic j : ()V
    //   874: return
    //   875: aload_3
    //   876: aload_0
    //   877: getfield bB : I
    //   880: invokevirtual a : (I)Ljava/lang/Object;
    //   883: checkcast j
    //   886: dup
    //   887: astore_3
    //   888: ifnull -> 898
    //   891: aload_3
    //   892: invokevirtual b : ()Z
    //   895: ifeq -> 899
    //   898: return
    //   899: invokestatic a : ()Lq;
    //   902: aload_0
    //   903: getfield bw : I
    //   906: i2b
    //   907: aload_3
    //   908: getfield O : I
    //   911: i2s
    //   912: iconst_1
    //   913: invokevirtual a : (BSS)V
    //   916: invokestatic j : ()V
    //   919: return
    //   920: aload_3
    //   921: aload_0
    //   922: getfield bB : I
    //   925: invokevirtual a : (I)Ljava/lang/Object;
    //   928: checkcast j
    //   931: dup
    //   932: astore_3
    //   933: ifnull -> 943
    //   936: aload_3
    //   937: invokevirtual b : ()Z
    //   940: ifeq -> 944
    //   943: return
    //   944: new java/lang/StringBuffer
    //   947: dup
    //   948: getstatic df.aJ : Ljava/lang/String;
    //   951: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   954: invokespecial <init> : (Ljava/lang/String;)V
    //   957: aload_3
    //   958: getfield g : Ljava/lang/String;
    //   961: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   964: ldc '?'
    //   966: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   969: invokevirtual toString : ()Ljava/lang/String;
    //   972: aload_0
    //   973: getfield bN : Lbt;
    //   976: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   979: return
    //   980: aload_3
    //   981: aload_0
    //   982: getfield bB : I
    //   985: invokevirtual a : (I)Ljava/lang/Object;
    //   988: checkcast j
    //   991: dup
    //   992: astore_3
    //   993: ifnull -> 1003
    //   996: aload_3
    //   997: invokevirtual b : ()Z
    //   1000: ifeq -> 1004
    //   1003: return
    //   1004: invokestatic a : ()Lq;
    //   1007: aload_3
    //   1008: getfield u : I
    //   1011: i2b
    //   1012: aload_3
    //   1013: getfield O : I
    //   1016: i2s
    //   1017: iconst_0
    //   1018: invokevirtual a : (BSB)V
    //   1021: iconst_0
    //   1022: putstatic fl.bi : I
    //   1025: invokestatic j : ()V
    //   1028: return
    //   1029: aload_3
    //   1030: aload_0
    //   1031: getfield bB : I
    //   1034: invokevirtual a : (I)Ljava/lang/Object;
    //   1037: checkcast j
    //   1040: dup
    //   1041: astore_2
    //   1042: ifnonnull -> 1046
    //   1045: return
    //   1046: aload_2
    //   1047: getfield u : I
    //   1050: iconst_5
    //   1051: if_icmpne -> 1061
    //   1054: getstatic df.fL : Ljava/lang/String;
    //   1057: invokestatic a : (Ljava/lang/String;)V
    //   1060: return
    //   1061: aload_2
    //   1062: getfield u : I
    //   1065: iconst_4
    //   1066: if_icmpne -> 1273
    //   1069: aload_2
    //   1070: getfield L : B
    //   1073: iconst_1
    //   1074: if_icmpgt -> 1091
    //   1077: getstatic bq.s : [Lad;
    //   1080: aload_2
    //   1081: getfield L : B
    //   1084: aaload
    //   1085: getfield b : I
    //   1088: ifgt -> 1670
    //   1091: getstatic cn.p : Lfb;
    //   1094: iconst_2
    //   1095: iconst_4
    //   1096: invokevirtual d : (II)Z
    //   1099: ifeq -> 1127
    //   1102: aload_2
    //   1103: getfield L : B
    //   1106: ifne -> 1127
    //   1109: getstatic cn.p : Lfb;
    //   1112: dup
    //   1113: getfield b : I
    //   1116: iconst_1
    //   1117: iadd
    //   1118: putfield b : I
    //   1121: getstatic cn.p : Lfb;
    //   1124: invokevirtual g : ()V
    //   1127: aload_2
    //   1128: getfield L : B
    //   1131: iconst_2
    //   1132: if_icmpge -> 1180
    //   1135: aload_2
    //   1136: getfield L : B
    //   1139: ifne -> 1157
    //   1142: getstatic cn.f : Lbq;
    //   1145: getfield br : I
    //   1148: getstatic cn.f : Lbq;
    //   1151: getfield bs : I
    //   1154: if_icmpeq -> 1670
    //   1157: aload_2
    //   1158: getfield L : B
    //   1161: iconst_1
    //   1162: if_icmpne -> 1180
    //   1165: getstatic cn.f : Lbq;
    //   1168: getfield bt : I
    //   1171: getstatic cn.f : Lbq;
    //   1174: getfield bu : I
    //   1177: if_icmpeq -> 1670
    //   1180: aload_2
    //   1181: getfield L : B
    //   1184: getstatic bw.c : I
    //   1187: if_icmpne -> 1209
    //   1190: getstatic cn.f : Lbq;
    //   1193: invokevirtual e_ : ()Z
    //   1196: ifne -> 1670
    //   1199: invokestatic b : ()Lcn;
    //   1202: pop
    //   1203: invokestatic i : ()V
    //   1206: goto -> 1670
    //   1209: invokestatic a : ()Lq;
    //   1212: aload_2
    //   1213: getfield O : I
    //   1216: i2s
    //   1217: invokevirtual e : (S)V
    //   1220: aload_2
    //   1221: getfield L : B
    //   1224: iconst_2
    //   1225: if_icmpge -> 1670
    //   1228: getstatic bq.s : [Lad;
    //   1231: aload_2
    //   1232: getfield L : B
    //   1235: aaload
    //   1236: sipush #2000
    //   1239: putfield b : I
    //   1242: getstatic bq.s : [Lad;
    //   1245: aload_2
    //   1246: getfield L : B
    //   1249: aaload
    //   1250: sipush #2000
    //   1253: putfield c : I
    //   1256: getstatic bq.s : [Lad;
    //   1259: aload_2
    //   1260: getfield L : B
    //   1263: aaload
    //   1264: invokestatic a : ()J
    //   1267: putfield a : J
    //   1270: goto -> 1670
    //   1273: iconst_0
    //   1274: istore_1
    //   1275: aload_2
    //   1276: getfield R : I
    //   1279: bipush #12
    //   1281: if_icmpge -> 1293
    //   1284: getstatic fo.l : [I
    //   1287: aload_2
    //   1288: getfield R : I
    //   1291: iaload
    //   1292: istore_1
    //   1293: iload_1
    //   1294: iconst_m1
    //   1295: if_icmpne -> 1605
    //   1298: new es
    //   1301: dup
    //   1302: ldc 'TabShopNew menu'
    //   1304: invokespecial <init> : (Ljava/lang/String;)V
    //   1307: astore_2
    //   1308: new bt
    //   1311: dup
    //   1312: getstatic df.aH : Ljava/lang/String;
    //   1315: bipush #12
    //   1317: iconst_0
    //   1318: aload_0
    //   1319: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   1322: astore_1
    //   1323: getstatic bw.U : Lek;
    //   1326: ldc '3'
    //   1328: invokevirtual a : (Ljava/lang/String;)Ljava/lang/Object;
    //   1331: checkcast bw
    //   1334: dup
    //   1335: astore #4
    //   1337: ifnull -> 1443
    //   1340: aload #4
    //   1342: getfield t : I
    //   1345: i2s
    //   1346: invokestatic d : (S)Lfd;
    //   1349: dup
    //   1350: astore #5
    //   1352: ifnull -> 1443
    //   1355: aload #5
    //   1357: getfield a : Laq;
    //   1360: ifnull -> 1443
    //   1363: aload #5
    //   1365: getfield b : S
    //   1368: ifeq -> 1379
    //   1371: aload #5
    //   1373: getfield c : S
    //   1376: ifne -> 1413
    //   1379: aload #5
    //   1381: aload #5
    //   1383: getfield a : Laq;
    //   1386: getfield a : Ljavax/microedition/lcdui/Image;
    //   1389: invokestatic b : (Ljavax/microedition/lcdui/Image;)I
    //   1392: i2s
    //   1393: putfield c : S
    //   1396: aload #5
    //   1398: aload #5
    //   1400: getfield a : Laq;
    //   1403: getfield a : Ljavax/microedition/lcdui/Image;
    //   1406: invokestatic a : (Ljavax/microedition/lcdui/Image;)I
    //   1409: i2s
    //   1410: putfield b : S
    //   1413: new ce
    //   1416: dup
    //   1417: aload #5
    //   1419: getfield a : Laq;
    //   1422: aload #5
    //   1424: getfield b : S
    //   1427: aload #5
    //   1429: getfield c : S
    //   1432: invokespecial <init> : (Laq;II)V
    //   1435: astore #4
    //   1437: aload_1
    //   1438: aload #4
    //   1440: invokevirtual a : (Lce;)V
    //   1443: new bt
    //   1446: dup
    //   1447: getstatic df.aI : Ljava/lang/String;
    //   1450: bipush #12
    //   1452: iconst_1
    //   1453: aload_0
    //   1454: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   1457: astore #5
    //   1459: getstatic bw.U : Lek;
    //   1462: ldc '9'
    //   1464: invokevirtual a : (Ljava/lang/String;)Ljava/lang/Object;
    //   1467: checkcast bw
    //   1470: dup
    //   1471: astore #4
    //   1473: ifnull -> 1578
    //   1476: aload #4
    //   1478: getfield t : I
    //   1481: i2s
    //   1482: invokestatic d : (S)Lfd;
    //   1485: dup
    //   1486: astore #6
    //   1488: ifnull -> 1578
    //   1491: aload #6
    //   1493: getfield a : Laq;
    //   1496: ifnull -> 1578
    //   1499: aload #6
    //   1501: getfield b : S
    //   1504: ifeq -> 1515
    //   1507: aload #6
    //   1509: getfield c : S
    //   1512: ifne -> 1549
    //   1515: aload #6
    //   1517: aload #6
    //   1519: getfield a : Laq;
    //   1522: getfield a : Ljavax/microedition/lcdui/Image;
    //   1525: invokestatic b : (Ljavax/microedition/lcdui/Image;)I
    //   1528: i2s
    //   1529: putfield c : S
    //   1532: aload #6
    //   1534: aload #6
    //   1536: getfield a : Laq;
    //   1539: getfield a : Ljavax/microedition/lcdui/Image;
    //   1542: invokestatic a : (Ljavax/microedition/lcdui/Image;)I
    //   1545: i2s
    //   1546: putfield b : S
    //   1549: new ce
    //   1552: dup
    //   1553: aload #6
    //   1555: getfield a : Laq;
    //   1558: aload #6
    //   1560: getfield b : S
    //   1563: aload #6
    //   1565: getfield c : S
    //   1568: invokespecial <init> : (Laq;II)V
    //   1571: astore_3
    //   1572: aload #5
    //   1574: aload_3
    //   1575: invokevirtual a : (Lce;)V
    //   1578: aload_2
    //   1579: aload_1
    //   1580: invokevirtual a : (Ljava/lang/Object;)V
    //   1583: aload_2
    //   1584: aload #5
    //   1586: invokevirtual a : (Ljava/lang/Object;)V
    //   1589: getstatic ft.o : Lfq;
    //   1592: aload_2
    //   1593: iconst_2
    //   1594: getstatic df.cU : Ljava/lang/String;
    //   1597: iconst_0
    //   1598: aconst_null
    //   1599: invokevirtual a : (Les;ILjava/lang/String;ZLes;)V
    //   1602: goto -> 1670
    //   1605: aload_2
    //   1606: getfield u : I
    //   1609: bipush #7
    //   1611: if_icmpne -> 1628
    //   1614: invokestatic a : ()Lq;
    //   1617: aload_2
    //   1618: getfield O : I
    //   1621: i2s
    //   1622: invokevirtual h : (S)V
    //   1625: goto -> 1641
    //   1628: invokestatic a : ()Lq;
    //   1631: aload_2
    //   1632: getfield O : I
    //   1635: i2b
    //   1636: iload_1
    //   1637: i2b
    //   1638: invokevirtual b : (BB)V
    //   1641: getstatic cn.p : Lfb;
    //   1644: iconst_3
    //   1645: iconst_4
    //   1646: invokevirtual d : (II)Z
    //   1649: ifeq -> 1670
    //   1652: getstatic cn.p : Lfb;
    //   1655: dup
    //   1656: getfield b : I
    //   1659: iconst_1
    //   1660: iadd
    //   1661: putfield b : I
    //   1664: getstatic cn.p : Lfb;
    //   1667: invokevirtual g : ()V
    //   1670: iconst_0
    //   1671: putstatic fl.bi : I
    //   1674: getstatic cn.p : Lfb;
    //   1677: iconst_2
    //   1678: iconst_5
    //   1679: invokevirtual d : (II)Z
    //   1682: ifne -> 5488
    //   1685: getstatic cn.p : Lfb;
    //   1688: iconst_3
    //   1689: iconst_5
    //   1690: invokevirtual d : (II)Z
    //   1693: ifne -> 5488
    //   1696: invokestatic j : ()V
    //   1699: return
    //   1700: aload_3
    //   1701: aload_0
    //   1702: getfield bB : I
    //   1705: invokevirtual a : (I)Ljava/lang/Object;
    //   1708: checkcast bw
    //   1711: dup
    //   1712: astore_3
    //   1713: ifnonnull -> 1717
    //   1716: return
    //   1717: new es
    //   1720: ldc 'TabShopNew menu2'
    //   1722: invokespecial <init> : (Ljava/lang/String;)V
    //   1725: aconst_null
    //   1726: astore_1
    //   1727: aload_0
    //   1728: aload_3
    //   1729: invokespecial a : (Lbw;)Les;
    //   1732: astore_1
    //   1733: getstatic df.bh : Ljava/lang/String;
    //   1736: astore_2
    //   1737: aload_0
    //   1738: getfield cI : B
    //   1741: getstatic fn.e : B
    //   1744: if_icmpne -> 1751
    //   1747: getstatic df.ey : Ljava/lang/String;
    //   1750: astore_2
    //   1751: getstatic ft.o : Lfq;
    //   1754: aload_1
    //   1755: iconst_2
    //   1756: aload_2
    //   1757: iconst_0
    //   1758: aconst_null
    //   1759: invokevirtual a : (Les;ILjava/lang/String;ZLes;)V
    //   1762: getstatic cn.p : Lfb;
    //   1765: iconst_2
    //   1766: bipush #9
    //   1768: invokevirtual d : (II)Z
    //   1771: ifne -> 1796
    //   1774: getstatic cn.p : Lfb;
    //   1777: iconst_2
    //   1778: iconst_4
    //   1779: invokevirtual d : (II)Z
    //   1782: ifne -> 1796
    //   1785: getstatic cn.p : Lfb;
    //   1788: iconst_3
    //   1789: iconst_4
    //   1790: invokevirtual d : (II)Z
    //   1793: ifeq -> 5488
    //   1796: iconst_1
    //   1797: putstatic fq.c : Z
    //   1800: return
    //   1801: new es
    //   1804: dup
    //   1805: ldc 'TabShopNew menu3'
    //   1807: invokespecial <init> : (Ljava/lang/String;)V
    //   1810: astore_1
    //   1811: iconst_0
    //   1812: istore #4
    //   1814: goto -> 1959
    //   1817: getstatic ft.A : Z
    //   1820: ifne -> 1913
    //   1823: getstatic fi.h : Z
    //   1826: ifeq -> 1871
    //   1829: new bt
    //   1832: dup
    //   1833: new java/lang/StringBuffer
    //   1836: dup
    //   1837: getstatic df.ag : Ljava/lang/String;
    //   1840: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1843: invokespecial <init> : (Ljava/lang/String;)V
    //   1846: getstatic cf.A : [Ljava/lang/String;
    //   1849: iload #4
    //   1851: aaload
    //   1852: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1855: invokevirtual toString : ()Ljava/lang/String;
    //   1858: bipush #9
    //   1860: iload #4
    //   1862: aload_0
    //   1863: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   1866: astore #5
    //   1868: goto -> 1950
    //   1871: new bt
    //   1874: dup
    //   1875: new java/lang/StringBuffer
    //   1878: dup
    //   1879: getstatic df.ag : Ljava/lang/String;
    //   1882: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1885: invokespecial <init> : (Ljava/lang/String;)V
    //   1888: getstatic cf.z : [I
    //   1891: iload #4
    //   1893: iaload
    //   1894: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1897: invokevirtual toString : ()Ljava/lang/String;
    //   1900: bipush #9
    //   1902: iload #4
    //   1904: aload_0
    //   1905: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   1908: astore #5
    //   1910: goto -> 1950
    //   1913: new bt
    //   1916: dup
    //   1917: new java/lang/StringBuffer
    //   1920: dup
    //   1921: getstatic df.ce : Ljava/lang/String;
    //   1924: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1927: invokespecial <init> : (Ljava/lang/String;)V
    //   1930: iload #4
    //   1932: iconst_1
    //   1933: iadd
    //   1934: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1937: invokevirtual toString : ()Ljava/lang/String;
    //   1940: bipush #9
    //   1942: iload #4
    //   1944: aload_0
    //   1945: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   1948: astore #5
    //   1950: aload_1
    //   1951: aload #5
    //   1953: invokevirtual a : (Ljava/lang/Object;)V
    //   1956: iinc #4, 1
    //   1959: iload #4
    //   1961: iconst_5
    //   1962: if_icmplt -> 1817
    //   1965: getstatic ft.o : Lfq;
    //   1968: aload_1
    //   1969: iconst_2
    //   1970: getstatic df.aQ : Ljava/lang/String;
    //   1973: iconst_0
    //   1974: aconst_null
    //   1975: invokevirtual a : (Les;ILjava/lang/String;ZLes;)V
    //   1978: getstatic cn.p : Lfb;
    //   1981: getfield a : I
    //   1984: iflt -> 5488
    //   1987: getstatic cn.p : Lfb;
    //   1990: iconst_2
    //   1991: bipush #9
    //   1993: invokevirtual d : (II)Z
    //   1996: ifeq -> 5488
    //   1999: getstatic cn.p : Lfb;
    //   2002: bipush #10
    //   2004: putfield b : I
    //   2007: iconst_1
    //   2008: putstatic fq.c : Z
    //   2011: return
    //   2012: aload_3
    //   2013: aload_0
    //   2014: getfield bB : I
    //   2017: invokevirtual a : (I)Ljava/lang/Object;
    //   2020: checkcast j
    //   2023: dup
    //   2024: astore_3
    //   2025: ifnull -> 2036
    //   2028: aload_3
    //   2029: getfield L : B
    //   2032: iconst_1
    //   2033: if_icmple -> 2037
    //   2036: return
    //   2037: iload_2
    //   2038: iconst_2
    //   2039: if_icmpne -> 2049
    //   2042: getstatic df.dP : Ljava/lang/String;
    //   2045: invokestatic a : (Ljava/lang/String;)V
    //   2048: return
    //   2049: getstatic bq.w : [[Lao;
    //   2052: getstatic bq.d : I
    //   2055: aaload
    //   2056: iload_2
    //   2057: aaload
    //   2058: aload_3
    //   2059: getfield O : I
    //   2062: getstatic ao.f : B
    //   2065: aload_3
    //   2066: getfield L : B
    //   2069: invokevirtual a : (IIB)V
    //   2072: invokestatic f : ()V
    //   2075: getstatic cn.p : Lfb;
    //   2078: getfield a : I
    //   2081: iflt -> 5488
    //   2084: getstatic cn.p : Lfb;
    //   2087: iconst_2
    //   2088: bipush #9
    //   2090: invokevirtual d : (II)Z
    //   2093: ifne -> 2108
    //   2096: getstatic cn.p : Lfb;
    //   2099: iconst_2
    //   2100: bipush #10
    //   2102: invokevirtual d : (II)Z
    //   2105: ifeq -> 5488
    //   2108: getstatic cn.p : Lfb;
    //   2111: bipush #11
    //   2113: putfield b : I
    //   2116: getstatic cn.p : Lfb;
    //   2119: invokevirtual g : ()V
    //   2122: return
    //   2123: aload_3
    //   2124: aload_0
    //   2125: getfield bB : I
    //   2128: invokevirtual a : (I)Ljava/lang/Object;
    //   2131: checkcast j
    //   2134: dup
    //   2135: astore_3
    //   2136: ifnull -> 2146
    //   2139: aload_3
    //   2140: invokevirtual b : ()Z
    //   2143: ifeq -> 2147
    //   2146: return
    //   2147: invokestatic a : ()Lq;
    //   2150: aload_3
    //   2151: getfield u : I
    //   2154: i2b
    //   2155: aload_3
    //   2156: getfield O : I
    //   2159: i2s
    //   2160: iconst_1
    //   2161: invokevirtual a : (BSB)V
    //   2164: getstatic ft.A : Z
    //   2167: ifeq -> 2175
    //   2170: aload_0
    //   2171: iconst_m1
    //   2172: putfield bB : I
    //   2175: iconst_0
    //   2176: putstatic fl.bi : I
    //   2179: invokestatic j : ()V
    //   2182: return
    //   2183: aload_3
    //   2184: aload_0
    //   2185: getfield bB : I
    //   2188: invokevirtual a : (I)Ljava/lang/Object;
    //   2191: checkcast j
    //   2194: dup
    //   2195: astore_3
    //   2196: ifnull -> 2206
    //   2199: aload_3
    //   2200: invokevirtual b : ()Z
    //   2203: ifeq -> 2207
    //   2206: return
    //   2207: iconst_0
    //   2208: istore #4
    //   2210: aload_3
    //   2211: getfield u : I
    //   2214: iconst_3
    //   2215: if_icmpne -> 2264
    //   2218: iconst_1
    //   2219: aload_3
    //   2220: getfield S : I
    //   2223: getstatic fn.w : S
    //   2226: idiv
    //   2227: iadd
    //   2228: getstatic fn.v : S
    //   2231: imul
    //   2232: bipush #100
    //   2234: aload_3
    //   2235: getfield N : I
    //   2238: getstatic fn.x : S
    //   2241: imul
    //   2242: iadd
    //   2243: imul
    //   2244: bipush #100
    //   2246: idiv
    //   2247: dup
    //   2248: istore #4
    //   2250: getstatic fn.z : S
    //   2253: if_icmple -> 2290
    //   2256: getstatic fn.z : S
    //   2259: istore #4
    //   2261: goto -> 2290
    //   2264: aload_3
    //   2265: getfield u : I
    //   2268: iconst_5
    //   2269: if_icmpne -> 2285
    //   2272: aload_3
    //   2273: getfield K : I
    //   2276: getstatic fn.y : S
    //   2279: imul
    //   2280: istore #4
    //   2282: goto -> 2290
    //   2285: getstatic fn.u : S
    //   2288: istore #4
    //   2290: aload_3
    //   2291: getfield u : I
    //   2294: iconst_3
    //   2295: if_icmpne -> 2319
    //   2298: aload_3
    //   2299: getfield N : I
    //   2302: ifne -> 2308
    //   2305: iconst_1
    //   2306: istore #4
    //   2308: aload_3
    //   2309: getfield N : I
    //   2312: iconst_1
    //   2313: if_icmpne -> 2319
    //   2316: iconst_3
    //   2317: istore #4
    //   2319: new java/lang/StringBuffer
    //   2322: dup
    //   2323: getstatic df.bF : Ljava/lang/String;
    //   2326: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   2329: invokespecial <init> : (Ljava/lang/String;)V
    //   2332: aload_3
    //   2333: getfield g : Ljava/lang/String;
    //   2336: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2339: ldc '? '
    //   2341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2344: getstatic df.cy : Ljava/lang/String;
    //   2347: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2350: iload #4
    //   2352: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   2355: ldc ' '
    //   2357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2360: getstatic df.bO : Ljava/lang/String;
    //   2363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2366: ldc '.'
    //   2368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2371: invokevirtual toString : ()Ljava/lang/String;
    //   2374: aload_0
    //   2375: getfield bR : Lbt;
    //   2378: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   2381: return
    //   2382: aload_3
    //   2383: aload_0
    //   2384: getfield bB : I
    //   2387: invokevirtual a : (I)Ljava/lang/Object;
    //   2390: checkcast j
    //   2393: dup
    //   2394: astore_3
    //   2395: ifnull -> 5488
    //   2398: iload_2
    //   2399: ifne -> 2415
    //   2402: invokestatic a : ()Lq;
    //   2405: aload_3
    //   2406: getfield O : I
    //   2409: i2b
    //   2410: iconst_3
    //   2411: invokevirtual b : (BB)V
    //   2414: return
    //   2415: iload_2
    //   2416: iconst_1
    //   2417: if_icmpne -> 5488
    //   2420: invokestatic a : ()Lq;
    //   2423: aload_3
    //   2424: getfield O : I
    //   2427: i2b
    //   2428: bipush #9
    //   2430: invokevirtual b : (BB)V
    //   2433: return
    //   2434: aload_3
    //   2435: aload_0
    //   2436: getfield bB : I
    //   2439: invokevirtual a : (I)Ljava/lang/Object;
    //   2442: checkcast j
    //   2445: dup
    //   2446: astore_3
    //   2447: ifnull -> 2524
    //   2450: iconst_1
    //   2451: istore #5
    //   2453: aload_3
    //   2454: getfield u : I
    //   2457: iconst_4
    //   2458: if_icmpeq -> 2470
    //   2461: aload_3
    //   2462: getfield u : I
    //   2465: bipush #7
    //   2467: if_icmpne -> 2493
    //   2470: aload_0
    //   2471: getfield cF : Ldy;
    //   2474: getfield a : Lfi;
    //   2477: invokevirtual j : ()Ljava/lang/String;
    //   2480: invokestatic parseInt : (Ljava/lang/String;)I
    //   2483: istore #5
    //   2485: goto -> 2493
    //   2488: astore #4
    //   2490: iconst_1
    //   2491: istore #5
    //   2493: invokestatic a : ()Lq;
    //   2496: iconst_0
    //   2497: aload_3
    //   2498: getfield O : I
    //   2501: i2s
    //   2502: aload_3
    //   2503: getfield u : I
    //   2506: i2b
    //   2507: iload #5
    //   2509: i2s
    //   2510: invokevirtual a : (BSBS)V
    //   2513: getstatic ft.A : Z
    //   2516: ifeq -> 2524
    //   2519: aload_0
    //   2520: iconst_m1
    //   2521: putfield bB : I
    //   2524: invokestatic j : ()V
    //   2527: return
    //   2528: aload_3
    //   2529: aload_0
    //   2530: getfield bB : I
    //   2533: invokevirtual a : (I)Ljava/lang/Object;
    //   2536: checkcast j
    //   2539: dup
    //   2540: astore_3
    //   2541: ifnull -> 2620
    //   2544: iconst_1
    //   2545: istore #5
    //   2547: aload_3
    //   2548: getfield u : I
    //   2551: iconst_4
    //   2552: if_icmpeq -> 2564
    //   2555: aload_3
    //   2556: getfield u : I
    //   2559: bipush #7
    //   2561: if_icmpne -> 2587
    //   2564: aload_0
    //   2565: getfield cF : Ldy;
    //   2568: getfield a : Lfi;
    //   2571: invokevirtual j : ()Ljava/lang/String;
    //   2574: invokestatic parseInt : (Ljava/lang/String;)I
    //   2577: istore #5
    //   2579: goto -> 2587
    //   2582: astore #4
    //   2584: iconst_1
    //   2585: istore #5
    //   2587: invokestatic a : ()Lq;
    //   2590: getstatic fn.I : B
    //   2593: aload_3
    //   2594: getfield O : I
    //   2597: i2s
    //   2598: aload_3
    //   2599: getfield u : I
    //   2602: i2b
    //   2603: iload #5
    //   2605: i2s
    //   2606: invokevirtual a : (BSBS)V
    //   2609: getstatic ft.A : Z
    //   2612: ifeq -> 2620
    //   2615: aload_0
    //   2616: iconst_m1
    //   2617: putfield bB : I
    //   2620: invokestatic j : ()V
    //   2623: return
    //   2624: aload_3
    //   2625: aload_0
    //   2626: getfield bB : I
    //   2629: invokevirtual a : (I)Ljava/lang/Object;
    //   2632: checkcast j
    //   2635: dup
    //   2636: astore_3
    //   2637: ifnull -> 5488
    //   2640: aload_3
    //   2641: getfield u : I
    //   2644: iconst_4
    //   2645: if_icmpeq -> 2657
    //   2648: aload_3
    //   2649: getfield u : I
    //   2652: bipush #7
    //   2654: if_icmpne -> 5488
    //   2657: aload_0
    //   2658: new dy
    //   2661: dup
    //   2662: invokespecial <init> : ()V
    //   2665: putfield cF : Ldy;
    //   2668: aload_0
    //   2669: getfield cF : Ldy;
    //   2672: getstatic df.dT : Ljava/lang/String;
    //   2675: aload_0
    //   2676: getfield bS : Lbt;
    //   2679: iconst_1
    //   2680: getstatic df.el : Ljava/lang/String;
    //   2683: invokevirtual a : (Ljava/lang/String;Lbt;ZLjava/lang/String;)V
    //   2686: aload_0
    //   2687: getfield cF : Ldy;
    //   2690: putstatic ft.r : Lda;
    //   2693: return
    //   2694: aload_3
    //   2695: aload_0
    //   2696: getfield bB : I
    //   2699: invokevirtual a : (I)Ljava/lang/Object;
    //   2702: checkcast j
    //   2705: dup
    //   2706: astore_3
    //   2707: ifnull -> 5488
    //   2710: aload_3
    //   2711: getfield u : I
    //   2714: iconst_4
    //   2715: if_icmpeq -> 2727
    //   2718: aload_3
    //   2719: getfield u : I
    //   2722: bipush #7
    //   2724: if_icmpne -> 5488
    //   2727: aload_0
    //   2728: new dy
    //   2731: dup
    //   2732: invokespecial <init> : ()V
    //   2735: putfield cF : Ldy;
    //   2738: aload_0
    //   2739: getfield cF : Ldy;
    //   2742: getstatic df.dU : Ljava/lang/String;
    //   2745: aload_0
    //   2746: getfield bT : Lbt;
    //   2749: iconst_1
    //   2750: getstatic df.dx : Ljava/lang/String;
    //   2753: invokevirtual a : (Ljava/lang/String;Lbt;ZLjava/lang/String;)V
    //   2756: aload_0
    //   2757: getfield cF : Ldy;
    //   2760: putstatic ft.r : Lda;
    //   2763: return
    //   2764: new es
    //   2767: dup
    //   2768: ldc 'TabShopNew menusell'
    //   2770: invokespecial <init> : (Ljava/lang/String;)V
    //   2773: dup
    //   2774: astore #5
    //   2776: new bt
    //   2779: dup
    //   2780: getstatic df.dX : Ljava/lang/String;
    //   2783: bipush #19
    //   2785: iconst_0
    //   2786: aload_0
    //   2787: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   2790: invokevirtual a : (Ljava/lang/Object;)V
    //   2793: aload #5
    //   2795: new bt
    //   2798: dup
    //   2799: getstatic df.dW : Ljava/lang/String;
    //   2802: bipush #19
    //   2804: iconst_1
    //   2805: aload_0
    //   2806: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   2809: invokevirtual a : (Ljava/lang/Object;)V
    //   2812: getstatic ft.o : Lfq;
    //   2815: aload #5
    //   2817: iconst_2
    //   2818: getstatic df.bE : Ljava/lang/String;
    //   2821: iconst_0
    //   2822: aconst_null
    //   2823: invokevirtual a : (Les;ILjava/lang/String;ZLes;)V
    //   2826: return
    //   2827: iconst_0
    //   2828: istore #4
    //   2830: goto -> 2950
    //   2833: getstatic bw.V : Les;
    //   2836: iload #4
    //   2838: invokevirtual a : (I)Ljava/lang/Object;
    //   2841: checkcast j
    //   2844: astore #6
    //   2846: iload_2
    //   2847: ifne -> 2897
    //   2850: aload #6
    //   2852: getfield u : I
    //   2855: iconst_3
    //   2856: if_icmpne -> 2947
    //   2859: aload #6
    //   2861: getfield N : I
    //   2864: ifne -> 2947
    //   2867: aload #6
    //   2869: getfield z : B
    //   2872: ifne -> 2947
    //   2875: invokestatic a : ()Lq;
    //   2878: aload #6
    //   2880: getfield u : I
    //   2883: i2b
    //   2884: aload #6
    //   2886: getfield O : I
    //   2889: i2s
    //   2890: iconst_1
    //   2891: invokevirtual a : (BSB)V
    //   2894: goto -> 2947
    //   2897: iload_2
    //   2898: iconst_1
    //   2899: if_icmpne -> 2947
    //   2902: aload #6
    //   2904: getfield u : I
    //   2907: iconst_3
    //   2908: if_icmpne -> 2947
    //   2911: aload #6
    //   2913: getfield N : I
    //   2916: iconst_1
    //   2917: if_icmpne -> 2947
    //   2920: aload #6
    //   2922: getfield z : B
    //   2925: ifne -> 2947
    //   2928: invokestatic a : ()Lq;
    //   2931: aload #6
    //   2933: getfield u : I
    //   2936: i2b
    //   2937: aload #6
    //   2939: getfield O : I
    //   2942: i2s
    //   2943: iconst_1
    //   2944: invokevirtual a : (BSB)V
    //   2947: iinc #4, 1
    //   2950: iload #4
    //   2952: getstatic bw.V : Les;
    //   2955: invokevirtual c : ()I
    //   2958: if_icmplt -> 2833
    //   2961: getstatic ft.A : Z
    //   2964: ifeq -> 2972
    //   2967: aload_0
    //   2968: iconst_m1
    //   2969: putfield bB : I
    //   2972: invokestatic j : ()V
    //   2975: return
    //   2976: iconst_0
    //   2977: istore #4
    //   2979: iconst_0
    //   2980: istore #6
    //   2982: goto -> 3049
    //   2985: getstatic bw.V : Les;
    //   2988: iload #6
    //   2990: invokevirtual a : (I)Ljava/lang/Object;
    //   2993: checkcast j
    //   2996: astore_3
    //   2997: iload_2
    //   2998: ifne -> 3022
    //   3001: aload_3
    //   3002: getfield u : I
    //   3005: iconst_3
    //   3006: if_icmpne -> 3046
    //   3009: aload_3
    //   3010: getfield N : I
    //   3013: ifne -> 3046
    //   3016: iinc #4, 1
    //   3019: goto -> 3046
    //   3022: iload_2
    //   3023: iconst_1
    //   3024: if_icmpne -> 3046
    //   3027: aload_3
    //   3028: getfield u : I
    //   3031: iconst_3
    //   3032: if_icmpne -> 3046
    //   3035: aload_3
    //   3036: getfield N : I
    //   3039: iconst_1
    //   3040: if_icmpne -> 3046
    //   3043: iinc #4, 1
    //   3046: iinc #6, 1
    //   3049: iload #6
    //   3051: getstatic bw.V : Les;
    //   3054: invokevirtual c : ()I
    //   3057: if_icmplt -> 2985
    //   3060: iload #4
    //   3062: ifne -> 3088
    //   3065: iload_2
    //   3066: ifne -> 3076
    //   3069: getstatic df.dY : Ljava/lang/String;
    //   3072: invokestatic a : (Ljava/lang/String;)V
    //   3075: return
    //   3076: iload_2
    //   3077: iconst_1
    //   3078: if_icmpne -> 5488
    //   3081: getstatic df.dZ : Ljava/lang/String;
    //   3084: invokestatic a : (Ljava/lang/String;)V
    //   3087: return
    //   3088: iload_2
    //   3089: ifne -> 3137
    //   3092: new java/lang/StringBuffer
    //   3095: dup
    //   3096: getstatic df.bF : Ljava/lang/String;
    //   3099: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   3102: invokespecial <init> : (Ljava/lang/String;)V
    //   3105: iload #4
    //   3107: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   3110: getstatic df.ea : Ljava/lang/String;
    //   3113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3116: invokevirtual toString : ()Ljava/lang/String;
    //   3119: new bt
    //   3122: dup
    //   3123: getstatic df.bE : Ljava/lang/String;
    //   3126: bipush #18
    //   3128: iconst_0
    //   3129: aload_0
    //   3130: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   3133: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   3136: return
    //   3137: iload_2
    //   3138: iconst_1
    //   3139: if_icmpne -> 5488
    //   3142: new java/lang/StringBuffer
    //   3145: dup
    //   3146: getstatic df.bF : Ljava/lang/String;
    //   3149: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   3152: invokespecial <init> : (Ljava/lang/String;)V
    //   3155: iload #4
    //   3157: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   3160: getstatic df.eb : Ljava/lang/String;
    //   3163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3166: invokevirtual toString : ()Ljava/lang/String;
    //   3169: new bt
    //   3172: dup
    //   3173: getstatic df.bE : Ljava/lang/String;
    //   3176: bipush #18
    //   3178: iconst_1
    //   3179: aload_0
    //   3180: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   3183: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   3186: return
    //   3187: getstatic bw.V : Les;
    //   3190: aload_0
    //   3191: getfield bB : I
    //   3194: invokevirtual a : (I)Ljava/lang/Object;
    //   3197: checkcast j
    //   3200: dup
    //   3201: astore_3
    //   3202: ifnull -> 5488
    //   3205: invokestatic a : ()Lq;
    //   3208: iconst_0
    //   3209: aload_3
    //   3210: getfield O : I
    //   3213: i2s
    //   3214: aload_3
    //   3215: getfield u : I
    //   3218: i2b
    //   3219: invokevirtual b : (BSB)V
    //   3222: getstatic fl.aU : I
    //   3225: ifle -> 5488
    //   3228: aload_0
    //   3229: iconst_m1
    //   3230: putfield bB : I
    //   3233: iconst_0
    //   3234: putstatic fl.bi : I
    //   3237: return
    //   3238: getstatic bw.V : Les;
    //   3241: aload_0
    //   3242: getfield bB : I
    //   3245: invokevirtual a : (I)Ljava/lang/Object;
    //   3248: checkcast j
    //   3251: dup
    //   3252: astore_3
    //   3253: ifnull -> 5488
    //   3256: aload_3
    //   3257: getfield O : I
    //   3260: invokestatic f : (I)Z
    //   3263: ifeq -> 3271
    //   3266: bipush #6
    //   3268: goto -> 3272
    //   3271: iconst_1
    //   3272: istore #6
    //   3274: invokestatic a : ()Lq;
    //   3277: iload #6
    //   3279: aload_3
    //   3280: getfield O : I
    //   3283: i2s
    //   3284: aload_3
    //   3285: getfield u : I
    //   3288: i2b
    //   3289: invokevirtual b : (BSB)V
    //   3292: getstatic fl.aU : I
    //   3295: ifle -> 5488
    //   3298: aload_0
    //   3299: iconst_m1
    //   3300: putfield bB : I
    //   3303: iconst_0
    //   3304: putstatic fl.bi : I
    //   3307: return
    //   3308: invokestatic a : ()Lq;
    //   3311: bipush #8
    //   3313: invokevirtual i : (B)V
    //   3316: getstatic df.aG : Ljava/lang/String;
    //   3319: new bt
    //   3322: dup
    //   3323: getstatic df.Z : Ljava/lang/String;
    //   3326: iconst_m1
    //   3327: invokespecial <init> : (Ljava/lang/String;I)V
    //   3330: invokestatic a : (Ljava/lang/String;Lbt;)V
    //   3333: return
    //   3334: getstatic bw.V : Les;
    //   3337: aload_0
    //   3338: getfield bB : I
    //   3341: invokevirtual a : (I)Ljava/lang/Object;
    //   3344: checkcast j
    //   3347: dup
    //   3348: astore_3
    //   3349: ifnull -> 5488
    //   3352: invokestatic a : ()Lq;
    //   3355: iconst_0
    //   3356: aload_3
    //   3357: getfield O : I
    //   3360: i2s
    //   3361: invokevirtual b : (BS)V
    //   3364: return
    //   3365: getstatic bw.V : Les;
    //   3368: aload_0
    //   3369: getfield bB : I
    //   3372: invokevirtual a : (I)Ljava/lang/Object;
    //   3375: checkcast j
    //   3378: dup
    //   3379: astore_3
    //   3380: ifnull -> 5488
    //   3383: invokestatic a : ()Lq;
    //   3386: iconst_2
    //   3387: iconst_0
    //   3388: aload_3
    //   3389: getfield O : I
    //   3392: i2s
    //   3393: invokevirtual a : (BIS)V
    //   3396: return
    //   3397: aload_3
    //   3398: aload_0
    //   3399: getfield bB : I
    //   3402: invokevirtual a : (I)Ljava/lang/Object;
    //   3405: checkcast bw
    //   3408: dup
    //   3409: astore_3
    //   3410: ifnull -> 3490
    //   3413: iconst_0
    //   3414: istore #6
    //   3416: invokestatic a : ()Lq;
    //   3419: getstatic fn.bv : B
    //   3422: aload_3
    //   3423: getfield O : I
    //   3426: i2s
    //   3427: aload_3
    //   3428: getfield u : I
    //   3431: i2b
    //   3432: iconst_1
    //   3433: invokevirtual b : (BSBS)V
    //   3436: new java/lang/StringBuffer
    //   3439: dup
    //   3440: ldc 'ap trung '
    //   3442: invokespecial <init> : (Ljava/lang/String;)V
    //   3445: aload_3
    //   3446: getfield O : I
    //   3449: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   3452: ldc ' '
    //   3454: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3457: aload_3
    //   3458: getfield u : I
    //   3461: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   3464: ldc ' '
    //   3466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3469: iconst_1
    //   3470: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   3473: invokevirtual toString : ()Ljava/lang/String;
    //   3476: invokestatic a : (Ljava/lang/String;)V
    //   3479: getstatic ft.A : Z
    //   3482: ifeq -> 3490
    //   3485: aload_0
    //   3486: iconst_m1
    //   3487: putfield bB : I
    //   3490: invokestatic j : ()V
    //   3493: return
    //   3494: aload_3
    //   3495: aload_0
    //   3496: getfield bB : I
    //   3499: invokevirtual a : (I)Ljava/lang/Object;
    //   3502: checkcast bw
    //   3505: dup
    //   3506: astore_3
    //   3507: ifnull -> 3545
    //   3510: iconst_0
    //   3511: istore #6
    //   3513: invokestatic a : ()Lq;
    //   3516: iconst_0
    //   3517: aload_3
    //   3518: getfield O : I
    //   3521: i2s
    //   3522: aload_3
    //   3523: getfield u : I
    //   3526: i2b
    //   3527: iconst_1
    //   3528: invokevirtual b : (BSBS)V
    //   3531: getstatic ft.A : Z
    //   3534: ifeq -> 3550
    //   3537: aload_0
    //   3538: iconst_m1
    //   3539: putfield bB : I
    //   3542: goto -> 3550
    //   3545: ldc 'null cmnr'
    //   3547: invokestatic a : (Ljava/lang/String;)V
    //   3550: invokestatic j : ()V
    //   3553: return
    //   3554: aload_0
    //   3555: getfield D : Lea;
    //   3558: ifnonnull -> 3562
    //   3561: return
    //   3562: aload_3
    //   3563: aload_0
    //   3564: getfield bB : I
    //   3567: invokevirtual a : (I)Ljava/lang/Object;
    //   3570: checkcast bw
    //   3573: astore_3
    //   3574: invokestatic a : ()Lq;
    //   3577: aload_0
    //   3578: getfield D : Lea;
    //   3581: getfield O : I
    //   3584: i2s
    //   3585: aload_3
    //   3586: getfield O : I
    //   3589: i2s
    //   3590: aload_3
    //   3591: getfield u : I
    //   3594: i2b
    //   3595: getstatic ah.j : B
    //   3598: invokevirtual a : (SSBB)V
    //   3601: return
    //   3602: aload_3
    //   3603: aload_0
    //   3604: getfield bB : I
    //   3607: invokevirtual a : (I)Ljava/lang/Object;
    //   3610: checkcast bw
    //   3613: dup
    //   3614: astore_3
    //   3615: ifnull -> 5488
    //   3618: aload_3
    //   3619: getfield u : I
    //   3622: bipush #9
    //   3624: if_icmpne -> 5488
    //   3627: aload_3
    //   3628: checkcast ea
    //   3631: iconst_0
    //   3632: invokestatic a : (Lea;B)V
    //   3635: return
    //   3636: getstatic bw.X : Les;
    //   3639: aload_0
    //   3640: getfield bB : I
    //   3643: invokevirtual a : (I)Ljava/lang/Object;
    //   3646: checkcast bw
    //   3649: dup
    //   3650: astore_3
    //   3651: ifnull -> 3671
    //   3654: aload_3
    //   3655: getfield u : I
    //   3658: bipush #9
    //   3660: if_icmpne -> 3671
    //   3663: aload_3
    //   3664: checkcast ea
    //   3667: iconst_0
    //   3668: invokestatic a : (Lea;B)V
    //   3671: new es
    //   3674: dup
    //   3675: ldc 'TabShopNew vectab'
    //   3677: invokespecial <init> : (Ljava/lang/String;)V
    //   3680: astore #6
    //   3682: new fn
    //   3685: dup
    //   3686: getstatic bw.V : Les;
    //   3689: iconst_0
    //   3690: getstatic df.fI : Ljava/lang/String;
    //   3693: iconst_m1
    //   3694: getstatic fn.j : B
    //   3697: invokespecial <init> : (Les;BLjava/lang/String;IB)V
    //   3700: dup
    //   3701: astore_3
    //   3702: getstatic ah.i : Lea;
    //   3705: putfield D : Lea;
    //   3708: aload #6
    //   3710: aload_3
    //   3711: invokevirtual a : (Ljava/lang/Object;)V
    //   3714: new eu
    //   3717: dup
    //   3718: invokespecial <init> : ()V
    //   3721: dup
    //   3722: putstatic ft.w : Leu;
    //   3725: iconst_0
    //   3726: putfield a : I
    //   3729: getstatic ft.w : Leu;
    //   3732: aload #6
    //   3734: invokevirtual a : (Les;)V
    //   3737: getstatic ft.w : Leu;
    //   3740: getstatic ft.a : Lp;
    //   3743: invokevirtual a : (Lp;)V
    //   3746: return
    //   3747: getstatic bw.V : Les;
    //   3750: aload_0
    //   3751: getfield bB : I
    //   3754: invokevirtual a : (I)Ljava/lang/Object;
    //   3757: checkcast j
    //   3760: dup
    //   3761: astore_3
    //   3762: ifnull -> 5488
    //   3765: invokestatic a : ()Lq;
    //   3768: iconst_4
    //   3769: aload_3
    //   3770: getfield O : I
    //   3773: i2s
    //   3774: aload_3
    //   3775: getfield u : I
    //   3778: i2b
    //   3779: invokevirtual b : (BSB)V
    //   3782: getstatic fl.aU : I
    //   3785: ifle -> 5488
    //   3788: aload_0
    //   3789: iconst_m1
    //   3790: putfield bB : I
    //   3793: iconst_0
    //   3794: putstatic fl.bi : I
    //   3797: return
    //   3798: aload_3
    //   3799: aload_0
    //   3800: getfield bB : I
    //   3803: invokevirtual a : (I)Ljava/lang/Object;
    //   3806: checkcast j
    //   3809: dup
    //   3810: astore_3
    //   3811: ifnull -> 3821
    //   3814: aload_3
    //   3815: invokevirtual b : ()Z
    //   3818: ifeq -> 3822
    //   3821: return
    //   3822: new es
    //   3825: dup
    //   3826: ldc 'TabShopNew menu4'
    //   3828: invokespecial <init> : (Ljava/lang/String;)V
    //   3831: astore_1
    //   3832: new java/lang/StringBuffer
    //   3835: dup
    //   3836: getstatic df.aF : Ljava/lang/String;
    //   3839: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   3842: invokespecial <init> : (Ljava/lang/String;)V
    //   3845: ldc ' '
    //   3847: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3850: bipush #10
    //   3852: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   3855: ldc ' '
    //   3857: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3860: aload_3
    //   3861: getfield g : Ljava/lang/String;
    //   3864: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3867: ldc ' '
    //   3869: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3872: getstatic df.cy : Ljava/lang/String;
    //   3875: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3878: ldc ' '
    //   3880: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3883: aload_3
    //   3884: getfield q : J
    //   3887: ldc2_w 10
    //   3890: lmul
    //   3891: invokevirtual append : (J)Ljava/lang/StringBuffer;
    //   3894: ldc ' '
    //   3896: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3899: aload_3
    //   3900: getfield Q : B
    //   3903: ifne -> 3912
    //   3906: getstatic df.bO : Ljava/lang/String;
    //   3909: goto -> 3915
    //   3912: getstatic df.bP : Ljava/lang/String;
    //   3915: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3918: invokevirtual toString : ()Ljava/lang/String;
    //   3921: astore_2
    //   3922: aload_1
    //   3923: new bt
    //   3926: dup
    //   3927: getstatic df.ga : Ljava/lang/String;
    //   3930: bipush #34
    //   3932: bipush #10
    //   3934: aload_0
    //   3935: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   3938: invokevirtual a : (Ljava/lang/Object;)V
    //   3941: aload_1
    //   3942: new bt
    //   3945: dup
    //   3946: getstatic df.as : Ljava/lang/String;
    //   3949: bipush #35
    //   3951: aload_0
    //   3952: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   3955: invokevirtual a : (Ljava/lang/Object;)V
    //   3958: aload_2
    //   3959: aload_1
    //   3960: invokestatic a : (Ljava/lang/String;Les;)V
    //   3963: return
    //   3964: aload_3
    //   3965: aload_0
    //   3966: getfield bB : I
    //   3969: invokevirtual a : (I)Ljava/lang/Object;
    //   3972: checkcast j
    //   3975: dup
    //   3976: astore_3
    //   3977: ifnull -> 3987
    //   3980: aload_3
    //   3981: invokevirtual b : ()Z
    //   3984: ifeq -> 3988
    //   3987: return
    //   3988: new es
    //   3991: dup
    //   3992: ldc 'TabShopNew menu5'
    //   3994: invokespecial <init> : (Ljava/lang/String;)V
    //   3997: astore_1
    //   3998: new java/lang/StringBuffer
    //   4001: dup
    //   4002: getstatic df.aF : Ljava/lang/String;
    //   4005: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   4008: invokespecial <init> : (Ljava/lang/String;)V
    //   4011: ldc ' '
    //   4013: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4016: bipush #30
    //   4018: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   4021: ldc ' '
    //   4023: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4026: aload_3
    //   4027: getfield g : Ljava/lang/String;
    //   4030: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4033: ldc ' '
    //   4035: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4038: getstatic df.cy : Ljava/lang/String;
    //   4041: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4044: ldc ' '
    //   4046: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4049: aload_3
    //   4050: getfield q : J
    //   4053: ldc2_w 30
    //   4056: lmul
    //   4057: invokevirtual append : (J)Ljava/lang/StringBuffer;
    //   4060: ldc ' '
    //   4062: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4065: aload_3
    //   4066: getfield Q : B
    //   4069: ifne -> 4078
    //   4072: getstatic df.bO : Ljava/lang/String;
    //   4075: goto -> 4081
    //   4078: getstatic df.bP : Ljava/lang/String;
    //   4081: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4084: invokevirtual toString : ()Ljava/lang/String;
    //   4087: astore_2
    //   4088: aload_1
    //   4089: new bt
    //   4092: dup
    //   4093: getstatic df.ga : Ljava/lang/String;
    //   4096: bipush #34
    //   4098: bipush #30
    //   4100: aload_0
    //   4101: invokespecial <init> : (Ljava/lang/String;IILcg;)V
    //   4104: invokevirtual a : (Ljava/lang/Object;)V
    //   4107: aload_1
    //   4108: new bt
    //   4111: dup
    //   4112: getstatic df.as : Ljava/lang/String;
    //   4115: bipush #35
    //   4117: aload_0
    //   4118: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   4121: invokevirtual a : (Ljava/lang/Object;)V
    //   4124: aload_2
    //   4125: aload_1
    //   4126: invokestatic a : (Ljava/lang/String;Les;)V
    //   4129: return
    //   4130: aload_3
    //   4131: aload_0
    //   4132: getfield bB : I
    //   4135: invokevirtual a : (I)Ljava/lang/Object;
    //   4138: checkcast j
    //   4141: dup
    //   4142: astore_3
    //   4143: ifnull -> 4153
    //   4146: aload_3
    //   4147: invokevirtual b : ()Z
    //   4150: ifeq -> 4154
    //   4153: return
    //   4154: invokestatic a : ()Lq;
    //   4157: aload_0
    //   4158: getfield bw : I
    //   4161: i2b
    //   4162: aload_3
    //   4163: getfield O : I
    //   4166: i2s
    //   4167: iload_2
    //   4168: i2s
    //   4169: invokevirtual a : (BSS)V
    //   4172: invokestatic j : ()V
    //   4175: return
    //   4176: invokestatic j : ()V
    //   4179: return
    //   4180: getstatic bw.V : Les;
    //   4183: aload_0
    //   4184: getfield bB : I
    //   4187: invokevirtual a : (I)Ljava/lang/Object;
    //   4190: checkcast j
    //   4193: dup
    //   4194: astore_1
    //   4195: ifnull -> 5488
    //   4198: aload_1
    //   4199: putstatic c.l : Lj;
    //   4202: iconst_1
    //   4203: putstatic c.J : B
    //   4206: getstatic fl.aU : I
    //   4209: ifle -> 5488
    //   4212: aload_0
    //   4213: iconst_m1
    //   4214: putfield bB : I
    //   4217: iconst_0
    //   4218: putstatic fl.bi : I
    //   4221: return
    //   4222: getstatic bw.V : Les;
    //   4225: aload_0
    //   4226: getfield bB : I
    //   4229: invokevirtual a : (I)Ljava/lang/Object;
    //   4232: checkcast j
    //   4235: dup
    //   4236: astore_1
    //   4237: ifnull -> 5488
    //   4240: getstatic c.G : Les;
    //   4243: invokevirtual c : ()I
    //   4246: aload_0
    //   4247: getfield bG : B
    //   4250: if_icmple -> 4260
    //   4253: getstatic df.N : Ljava/lang/String;
    //   4256: invokestatic a : (Ljava/lang/String;)V
    //   4259: return
    //   4260: aload_1
    //   4261: invokestatic a : (Lj;)V
    //   4264: getstatic fl.aU : I
    //   4267: ifle -> 5488
    //   4270: aload_0
    //   4271: iconst_m1
    //   4272: putfield bB : I
    //   4275: iconst_0
    //   4276: putstatic fl.bi : I
    //   4279: return
    //   4280: getstatic c.G : Les;
    //   4283: invokevirtual d : ()V
    //   4286: aconst_null
    //   4287: putstatic c.l : Lj;
    //   4290: getstatic bw.V : Les;
    //   4293: aload_0
    //   4294: getfield bB : I
    //   4297: invokevirtual a : (I)Ljava/lang/Object;
    //   4300: checkcast j
    //   4303: dup
    //   4304: astore_1
    //   4305: ifnull -> 5488
    //   4308: aload_1
    //   4309: getfield K : I
    //   4312: aload_0
    //   4313: getfield bG : B
    //   4316: if_icmpge -> 4326
    //   4319: getstatic df.M : Ljava/lang/String;
    //   4322: invokestatic a : (Ljava/lang/String;)V
    //   4325: return
    //   4326: iconst_0
    //   4327: istore_2
    //   4328: goto -> 4353
    //   4331: aload_1
    //   4332: invokestatic a : (Lj;)V
    //   4335: getstatic fl.aU : I
    //   4338: ifle -> 4350
    //   4341: aload_0
    //   4342: iconst_m1
    //   4343: putfield bB : I
    //   4346: iconst_0
    //   4347: putstatic fl.bi : I
    //   4350: iinc #2, 1
    //   4353: iload_2
    //   4354: aload_0
    //   4355: getfield bG : B
    //   4358: if_icmplt -> 4331
    //   4361: return
    //   4362: aload_3
    //   4363: aload_0
    //   4364: getfield bB : I
    //   4367: invokevirtual a : (I)Ljava/lang/Object;
    //   4370: checkcast j
    //   4373: dup
    //   4374: astore_3
    //   4375: ifnonnull -> 4379
    //   4378: return
    //   4379: aload_0
    //   4380: getfield cI : B
    //   4383: getstatic fn.l : B
    //   4386: if_icmpne -> 4401
    //   4389: aload_3
    //   4390: invokestatic b : (Lbw;)Z
    //   4393: ifeq -> 5488
    //   4396: aload_3
    //   4397: invokestatic a : (Lbw;)V
    //   4400: return
    //   4401: aload_0
    //   4402: getfield cI : B
    //   4405: getstatic fn.m : B
    //   4408: if_icmpne -> 5488
    //   4411: getstatic c.G : Les;
    //   4414: invokevirtual d : ()V
    //   4417: return
    //   4418: aload_0
    //   4419: new dy
    //   4422: dup
    //   4423: invokespecial <init> : ()V
    //   4426: putfield cF : Ldy;
    //   4429: iconst_1
    //   4430: anewarray java/lang/String
    //   4433: dup
    //   4434: iconst_0
    //   4435: getstatic df.B : Ljava/lang/String;
    //   4438: aastore
    //   4439: astore_2
    //   4440: aload_0
    //   4441: getfield cF : Ldy;
    //   4444: aload_2
    //   4445: aload_0
    //   4446: getfield cs : Lbt;
    //   4449: iconst_m1
    //   4450: iconst_0
    //   4451: getstatic df.C : Ljava/lang/String;
    //   4454: invokevirtual a : ([Ljava/lang/String;Lbt;SSLjava/lang/String;)V
    //   4457: aload_0
    //   4458: getfield cF : Ldy;
    //   4461: putstatic ft.r : Lda;
    //   4464: return
    //   4465: aload_3
    //   4466: aload_0
    //   4467: getfield bB : I
    //   4470: invokevirtual a : (I)Ljava/lang/Object;
    //   4473: checkcast j
    //   4476: dup
    //   4477: astore_1
    //   4478: ifnonnull -> 4482
    //   4481: return
    //   4482: iconst_1
    //   4483: istore_2
    //   4484: iconst_1
    //   4485: istore_3
    //   4486: aload_0
    //   4487: getfield cF : Ldy;
    //   4490: invokevirtual b : ()[Ljava/lang/String;
    //   4493: astore #4
    //   4495: aload #4
    //   4497: arraylength
    //   4498: iconst_1
    //   4499: if_icmpne -> 4520
    //   4502: aload #4
    //   4504: iconst_0
    //   4505: aaload
    //   4506: ifnull -> 4569
    //   4509: aload #4
    //   4511: iconst_0
    //   4512: aaload
    //   4513: invokestatic parseInt : (Ljava/lang/String;)I
    //   4516: istore_2
    //   4517: goto -> 4569
    //   4520: aload #4
    //   4522: arraylength
    //   4523: iconst_2
    //   4524: if_icmpne -> 4569
    //   4527: aload #4
    //   4529: iconst_0
    //   4530: aaload
    //   4531: ifnull -> 4542
    //   4534: aload #4
    //   4536: iconst_0
    //   4537: aaload
    //   4538: invokestatic parseInt : (Ljava/lang/String;)I
    //   4541: istore_2
    //   4542: aload #4
    //   4544: iconst_1
    //   4545: aaload
    //   4546: ifnull -> 4569
    //   4549: aload #4
    //   4551: iconst_1
    //   4552: aaload
    //   4553: invokestatic parseInt : (Ljava/lang/String;)I
    //   4556: istore_3
    //   4557: goto -> 4569
    //   4560: astore #4
    //   4562: getstatic df.z : Ljava/lang/String;
    //   4565: invokestatic a : (Ljava/lang/String;)V
    //   4568: return
    //   4569: new java/lang/StringBuffer
    //   4572: dup
    //   4573: getstatic df.A : Ljava/lang/String;
    //   4576: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   4579: invokespecial <init> : (Ljava/lang/String;)V
    //   4582: aload_1
    //   4583: getfield g : Ljava/lang/String;
    //   4586: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4589: ldc ' '
    //   4591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4594: getstatic df.cy : Ljava/lang/String;
    //   4597: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4600: ldc ' '
    //   4602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4605: iload_2
    //   4606: i2l
    //   4607: invokestatic a : (J)Ljava/lang/String;
    //   4610: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4613: ldc ' '
    //   4615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4618: getstatic df.bO : Ljava/lang/String;
    //   4621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4624: ldc ' ?'
    //   4626: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4629: invokevirtual toString : ()Ljava/lang/String;
    //   4632: astore #4
    //   4634: iload_3
    //   4635: iconst_1
    //   4636: if_icmple -> 4718
    //   4639: new java/lang/StringBuffer
    //   4642: dup
    //   4643: getstatic df.A : Ljava/lang/String;
    //   4646: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   4649: invokespecial <init> : (Ljava/lang/String;)V
    //   4652: ldc ' '
    //   4654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4657: iload_3
    //   4658: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   4661: ldc ' '
    //   4663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4666: aload_1
    //   4667: getfield g : Ljava/lang/String;
    //   4670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4673: ldc ' '
    //   4675: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4678: getstatic df.cy : Ljava/lang/String;
    //   4681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4684: ldc ' '
    //   4686: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4689: iload_2
    //   4690: i2l
    //   4691: invokestatic a : (J)Ljava/lang/String;
    //   4694: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4697: ldc ' '
    //   4699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4702: getstatic df.bO : Ljava/lang/String;
    //   4705: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4708: ldc ' ?'
    //   4710: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   4713: invokevirtual toString : ()Ljava/lang/String;
    //   4716: astore #4
    //   4718: new fh
    //   4721: dup
    //   4722: invokespecial <init> : ()V
    //   4725: dup
    //   4726: astore_1
    //   4727: iload_2
    //   4728: putfield a : I
    //   4731: aload_1
    //   4732: iload_3
    //   4733: i2s
    //   4734: putfield c : S
    //   4737: new es
    //   4740: dup
    //   4741: invokespecial <init> : ()V
    //   4744: dup
    //   4745: astore_2
    //   4746: new bt
    //   4749: dup
    //   4750: getstatic df.ga : Ljava/lang/String;
    //   4753: bipush #43
    //   4755: aload_1
    //   4756: aload_0
    //   4757: invokespecial <init> : (Ljava/lang/String;ILjava/lang/Object;Lcg;)V
    //   4760: invokevirtual a : (Ljava/lang/Object;)V
    //   4763: aload_2
    //   4764: new bt
    //   4767: dup
    //   4768: getstatic df.as : Ljava/lang/String;
    //   4771: bipush #35
    //   4773: aload_0
    //   4774: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   4777: invokevirtual a : (Ljava/lang/Object;)V
    //   4780: aload #4
    //   4782: aload_2
    //   4783: invokestatic a : (Ljava/lang/String;Les;)V
    //   4786: return
    //   4787: aload_0
    //   4788: new dy
    //   4791: dup
    //   4792: invokespecial <init> : ()V
    //   4795: putfield cF : Ldy;
    //   4798: aload_0
    //   4799: getfield cF : Ldy;
    //   4802: getstatic df.x : Ljava/lang/String;
    //   4805: aload_0
    //   4806: getfield cu : Lbt;
    //   4809: iconst_0
    //   4810: iconst_m1
    //   4811: lconst_0
    //   4812: ldc ''
    //   4814: invokevirtual a : (Ljava/lang/String;Lbt;ZIJLjava/lang/String;)V
    //   4817: aload_0
    //   4818: getfield cF : Ldy;
    //   4821: putstatic ft.r : Lda;
    //   4824: return
    //   4825: invokestatic a : ()Lq;
    //   4828: iconst_0
    //   4829: getstatic bw.ab : Les;
    //   4832: aload_0
    //   4833: getfield cF : Ldy;
    //   4836: getfield a : Lfi;
    //   4839: invokevirtual j : ()Ljava/lang/String;
    //   4842: iconst_0
    //   4843: iconst_0
    //   4844: iconst_0
    //   4845: invokevirtual a : (ILes;Ljava/lang/String;SIB)V
    //   4848: invokestatic j : ()V
    //   4851: aload_0
    //   4852: getfield cH : Les;
    //   4855: ifnull -> 5488
    //   4858: aload_0
    //   4859: getfield cH : Les;
    //   4862: invokevirtual d : ()V
    //   4865: aload_0
    //   4866: getfield cH : Les;
    //   4869: aload_0
    //   4870: getfield cx : Lbt;
    //   4873: invokevirtual a : (Ljava/lang/Object;)V
    //   4876: aload_0
    //   4877: aload_0
    //   4878: getfield cH : Les;
    //   4881: invokevirtual b : (Les;)V
    //   4884: return
    //   4885: aload_3
    //   4886: aload_0
    //   4887: getfield bB : I
    //   4890: invokevirtual a : (I)Ljava/lang/Object;
    //   4893: checkcast j
    //   4896: dup
    //   4897: astore_0
    //   4898: ifnull -> 5488
    //   4901: aload_0
    //   4902: getfield u : I
    //   4905: iconst_3
    //   4906: if_icmpne -> 4932
    //   4909: invokestatic a : ()Lq;
    //   4912: iconst_2
    //   4913: aconst_null
    //   4914: ldc ''
    //   4916: getstatic fn.E : S
    //   4919: aload_0
    //   4920: getfield O : I
    //   4923: aload_0
    //   4924: getfield u : I
    //   4927: i2b
    //   4928: invokevirtual a : (ILes;Ljava/lang/String;SIB)V
    //   4931: return
    //   4932: aload_0
    //   4933: getfield u : I
    //   4936: bipush #7
    //   4938: if_icmpne -> 4964
    //   4941: invokestatic a : ()Lq;
    //   4944: iconst_2
    //   4945: aconst_null
    //   4946: ldc ''
    //   4948: getstatic fn.E : S
    //   4951: aload_0
    //   4952: getfield O : I
    //   4955: aload_0
    //   4956: getfield u : I
    //   4959: i2b
    //   4960: invokevirtual a : (ILes;Ljava/lang/String;SIB)V
    //   4963: return
    //   4964: aload_0
    //   4965: getfield u : I
    //   4968: iconst_4
    //   4969: if_icmpne -> 5488
    //   4972: invokestatic a : ()Lq;
    //   4975: iconst_2
    //   4976: aconst_null
    //   4977: ldc ''
    //   4979: getstatic fn.E : S
    //   4982: aload_0
    //   4983: getfield O : I
    //   4986: aload_0
    //   4987: getfield u : I
    //   4990: i2b
    //   4991: invokevirtual a : (ILes;Ljava/lang/String;SIB)V
    //   4994: return
    //   4995: getstatic bw.ab : Les;
    //   4998: invokevirtual d : ()V
    //   5001: getstatic bw.aa : Les;
    //   5004: invokevirtual d : ()V
    //   5007: return
    //   5008: invokestatic a : ()Lq;
    //   5011: iconst_4
    //   5012: aconst_null
    //   5013: ldc ''
    //   5015: iconst_0
    //   5016: iconst_0
    //   5017: iconst_0
    //   5018: invokevirtual a : (ILes;Ljava/lang/String;SIB)V
    //   5021: return
    //   5022: aload_0
    //   5023: new dy
    //   5026: dup
    //   5027: invokespecial <init> : ()V
    //   5030: putfield bD : Ldy;
    //   5033: aload_0
    //   5034: getfield bD : Ldy;
    //   5037: getstatic df.fh : Ljava/lang/String;
    //   5040: new bt
    //   5043: dup
    //   5044: getstatic df.au : Ljava/lang/String;
    //   5047: bipush #50
    //   5049: aload_0
    //   5050: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   5053: iconst_0
    //   5054: getstatic df.fq : Ljava/lang/String;
    //   5057: invokevirtual a : (Ljava/lang/String;Lbt;ZLjava/lang/String;)V
    //   5060: aload_0
    //   5061: getfield bD : Ldy;
    //   5064: putstatic ft.r : Lda;
    //   5067: return
    //   5068: aload_0
    //   5069: aload_0
    //   5070: getfield bD : Ldy;
    //   5073: getfield a : Lfi;
    //   5076: invokevirtual j : ()Ljava/lang/String;
    //   5079: putfield bE : Ljava/lang/String;
    //   5082: aload_0
    //   5083: getfield bE : Ljava/lang/String;
    //   5086: ifnull -> 5488
    //   5089: aload_0
    //   5090: getfield bE : Ljava/lang/String;
    //   5093: invokevirtual length : ()I
    //   5096: ifle -> 5488
    //   5099: new java/lang/StringBuffer
    //   5102: dup
    //   5103: getstatic df.fg : Ljava/lang/String;
    //   5106: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   5109: invokespecial <init> : (Ljava/lang/String;)V
    //   5112: ldc ' ('
    //   5114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5117: getstatic df.fj : Ljava/lang/String;
    //   5120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5123: getstatic fn.B : S
    //   5126: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   5129: ldc ' '
    //   5131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5134: getstatic df.bP : Ljava/lang/String;
    //   5137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5140: ldc ')'
    //   5142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5145: getstatic df.fp : Ljava/lang/String;
    //   5148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5151: ldc '\\n'
    //   5153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5156: aload_0
    //   5157: getfield bE : Ljava/lang/String;
    //   5160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   5163: invokevirtual toString : ()Ljava/lang/String;
    //   5166: new bt
    //   5169: dup
    //   5170: getstatic df.au : Ljava/lang/String;
    //   5173: bipush #51
    //   5175: aload_0
    //   5176: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   5179: invokestatic c : (Ljava/lang/String;Lbt;)V
    //   5182: return
    //   5183: invokestatic a : ()Lq;
    //   5186: aload_0
    //   5187: getfield bE : Ljava/lang/String;
    //   5190: invokevirtual b : (Ljava/lang/String;)V
    //   5193: invokestatic j : ()V
    //   5196: return
    //   5197: getstatic bw.V : Les;
    //   5200: aload_0
    //   5201: getfield bB : I
    //   5204: invokevirtual a : (I)Ljava/lang/Object;
    //   5207: checkcast j
    //   5210: dup
    //   5211: astore_1
    //   5212: ifnull -> 5242
    //   5215: getstatic c.l : Lj;
    //   5218: ifnull -> 5225
    //   5221: aconst_null
    //   5222: putstatic c.l : Lj;
    //   5225: invokestatic a : ()Lq;
    //   5228: iconst_0
    //   5229: aload_1
    //   5230: getfield O : I
    //   5233: i2s
    //   5234: aload_1
    //   5235: getfield u : I
    //   5238: i2b
    //   5239: invokevirtual c : (BSB)V
    //   5242: aload_0
    //   5243: getfield cH : Les;
    //   5246: invokevirtual d : ()V
    //   5249: return
    //   5250: getstatic bw.V : Les;
    //   5253: aload_0
    //   5254: getfield bB : I
    //   5257: invokevirtual a : (I)Ljava/lang/Object;
    //   5260: checkcast j
    //   5263: dup
    //   5264: astore_1
    //   5265: ifnull -> 5285
    //   5268: invokestatic a : ()Lq;
    //   5271: iconst_1
    //   5272: aload_1
    //   5273: getfield O : I
    //   5276: i2s
    //   5277: aload_1
    //   5278: getfield u : I
    //   5281: i2b
    //   5282: invokevirtual c : (BSB)V
    //   5285: aload_0
    //   5286: getfield cH : Les;
    //   5289: invokevirtual d : ()V
    //   5292: return
    //   5293: getstatic bw.V : Les;
    //   5296: aload_0
    //   5297: getfield bB : I
    //   5300: invokevirtual a : (I)Ljava/lang/Object;
    //   5303: checkcast j
    //   5306: dup
    //   5307: astore_1
    //   5308: ifnull -> 5332
    //   5311: aload_1
    //   5312: putstatic c.l : Lj;
    //   5315: invokestatic a : ()Lq;
    //   5318: iconst_0
    //   5319: aload_1
    //   5320: getfield O : I
    //   5323: i2s
    //   5324: aload_1
    //   5325: getfield u : I
    //   5328: i2b
    //   5329: invokevirtual c : (BSB)V
    //   5332: aload_0
    //   5333: getfield cH : Les;
    //   5336: invokevirtual d : ()V
    //   5339: return
    //   5340: aload_0
    //   5341: new dy
    //   5344: dup
    //   5345: invokespecial <init> : ()V
    //   5348: putfield cF : Ldy;
    //   5351: iconst_2
    //   5352: anewarray java/lang/String
    //   5355: dup
    //   5356: iconst_0
    //   5357: getstatic df.B : Ljava/lang/String;
    //   5360: aastore
    //   5361: dup
    //   5362: iconst_1
    //   5363: getstatic df.eZ : Ljava/lang/String;
    //   5366: aastore
    //   5367: astore_1
    //   5368: aload_0
    //   5369: getfield cF : Ldy;
    //   5372: aload_1
    //   5373: aload_0
    //   5374: getfield cs : Lbt;
    //   5377: iconst_m1
    //   5378: iconst_0
    //   5379: getstatic df.C : Ljava/lang/String;
    //   5382: invokevirtual a : ([Ljava/lang/String;Lbt;SSLjava/lang/String;)V
    //   5385: aload_0
    //   5386: getfield cF : Ldy;
    //   5389: putstatic ft.r : Lda;
    //   5392: return
    //   5393: aload_0
    //   5394: dup
    //   5395: getfield bH : B
    //   5398: iconst_1
    //   5399: iadd
    //   5400: i2b
    //   5401: putfield bH : B
    //   5404: aload_0
    //   5405: getfield bH : B
    //   5408: getstatic fn.G : B
    //   5411: iconst_1
    //   5412: isub
    //   5413: if_icmple -> 5421
    //   5416: aload_0
    //   5417: iconst_0
    //   5418: putfield bH : B
    //   5421: getstatic ft.A : Z
    //   5424: ifne -> 5488
    //   5427: aload_0
    //   5428: getfield bH : B
    //   5431: ifne -> 5439
    //   5434: aload_0
    //   5435: iconst_0
    //   5436: putfield bB : I
    //   5439: aload_0
    //   5440: getfield bH : B
    //   5443: iconst_1
    //   5444: if_icmpne -> 5488
    //   5447: aload_0
    //   5448: bipush #42
    //   5450: putfield bB : I
    //   5453: return
    //   5454: aload_3
    //   5455: aload_0
    //   5456: getfield bB : I
    //   5459: invokevirtual a : (I)Ljava/lang/Object;
    //   5462: checkcast j
    //   5465: dup
    //   5466: astore_0
    //   5467: ifnull -> 5488
    //   5470: invokestatic a : ()Lq;
    //   5473: bipush #6
    //   5475: aload_0
    //   5476: getfield u : I
    //   5479: i2b
    //   5480: aload_0
    //   5481: getfield O : I
    //   5484: i2s
    //   5485: invokevirtual b : (BBS)V
    //   5488: return
    // Exception table:
    //   from	to	target	type
    //   833	847	850	java/lang/Exception
    //   2470	2485	2488	java/lang/Exception
    //   2564	2579	2582	java/lang/Exception
    //   4495	4557	4560	java/lang/Exception
  }
  
  private es a(bw parambw) {
    es es1 = new es("TabShopNew menu7");
    if (this.K == 9 && (G = (byte)(bq.y / 42)) == 1 && bw.W.c() > 42)
      G = 2; 
    if (this.K == 0)
      G = (byte)(bq.x / 42); 
    if (this.K != 8 && G > 1)
      es1.a(this.cD); 
    if (this.cI == r) {
      es1.a(this.cC);
      return es1;
    } 
    if (this.cI == q)
      return es1; 
    if (this.cI == r)
      return es1; 
    if (cn.f.e_()) {
      es1.a(this.cx);
      es1.a(this.cy);
      return es1;
    } 
    if (this.cI == o) {
      es1.a(this.cv);
      return es1;
    } 
    if (this.K == 15) {
      es1.a(this.ct);
      es1.a(this.cw);
      return es1;
    } 
    if (this.K == 16) {
      if (bw.aa.c() > 0)
        for (byte b = 0; b < bw.aa.c(); b++) {
          j j;
          if ((j = (j)bw.aa.a(b)).O == parambw.O)
            return es1; 
        }  
      if (parambw.u == 3) {
        es1.a(this.cr);
      } else {
        es1.a(this.cB);
      } 
    } else if (this.K == 0 && !this.F) {
      if (this.cI == o) {
        es1.a(this.cv);
      } else if (this.cI == n) {
        if (parambw.u == 7 && parambw.A == bw.b)
          es1.a(this.co); 
        if (parambw.u == 3)
          es1.a(this.cm); 
      } else if (this.cI == p) {
        if (parambw.u == 7) {
          j j;
          if (c.G.c() > 0 && (j = (j)c.G.a(0)).O == parambw.O) {
            es1.a(this.cA);
            return es1;
          } 
          es1.a(this.cz);
        } 
      } else if (this.cI == m) {
        if (parambw.u == 7 && parambw.A == bw.a) {
          if (!c.b(parambw))
            es1.a(this.cn); 
          if (c.b(parambw))
            es1.a(this.cp); 
        } 
      } else if (this.cI == l) {
        if (parambw.u == 3) {
          if (!t && (c.l == null || c.l.O != parambw.O || c.l.u != parambw.u))
            es1.a(this.cl); 
        } else if (parambw.u == 7 && parambw.A == 49) {
          es1.a(this.co);
          if (c.b(parambw))
            es1.a(this.cp); 
        } 
      } else if (this.cI == d) {
        if (parambw.u == 3) {
          if (!t)
            if (c.l == null || c.l.O != parambw.O || c.l.u != parambw.u) {
              es1.a(this.bX);
            } else {
              es1.a(this.bY);
            }  
        } else if (parambw.u == 7) {
          if (parambw.A == 11) {
            if (!t)
              if (!c.D) {
                c.I = parambw;
                es1.a(this.bX);
              } else {
                es1.a(this.bY);
              }  
          } else if (ez.f((short)parambw.O) && t) {
            if (c.l == null || c.l.O != parambw.O || c.l.u != parambw.u) {
              es1.a(this.ch);
            } else {
              es1.a(this.bY);
            } 
          } 
        } 
      } else if (this.cI == f) {
        if (parambw.u == 3)
          es1.a(this.ca); 
      } else if (this.cI == c) {
        if (parambw.u != 5)
          if (parambw.u == 4 || parambw.u == 7) {
            es1.a(this.bV);
          } else {
            es1.a(this.bT);
          }  
      } else if (this.cI == i) {
        if (parambw.u == 3 && parambw.R == 14)
          es1.a(this.cd); 
      } else if (this.cI == g) {
        if (parambw.u == 3 && parambw.R == 7)
          es1.a(this.cb); 
      } else if (this.cI == j) {
        es1.a(this.cf);
      } else {
        if (ft.a == ft.v && parambw.x == 1) {
          es1.a(this.bQ);
          if (parambw.u == 3)
            es1.a(this.bW); 
        } 
        if (ft.a != ft.v) {
          es1.a(this.bJ);
          if (parambw.u == 4 && parambw.L < 2)
            es1.a(this.bP); 
        } 
        if (ft.a == ft.u)
          es1.a(this.bM); 
      } 
    } else if (this.K == 9) {
      if (parambw.u == 4 || parambw.u == 7) {
        es1.a(this.bU);
      } else {
        es1.a(this.bS);
      } 
    } else if (this.K != 15) {
      if (this.K == 13) {
        if (this.cI == i && parambw.u == 9) {
          es1.a(this.cg);
          es1.a(this.ce);
        } 
      } else if (this.K == 12) {
        es1.a(this.bJ);
      } else {
        this.bI.a = df.ak;
        if (this.bw == eq.a)
          this.bI.a = this.cJ; 
        if (parambw.u == 6 && parambw.q <= 0L)
          this.bI.a = df.bj; 
        if (this.cI == h) {
          es1.a(this.cc);
        } else {
          es es2;
          if (this.cI != k && !this.F && ((parambw = (bw)(es2 = this.bF).a(this.bB)) != null || !parambw.b()))
            if (parambw.u == 4 || parambw.u == 7) {
              es1.a(this.ci);
              es1.a(this.cj);
              es1.a(this.ck);
              es1.a(this.cq);
            } else {
              es1.a(this.bI);
            }  
        } 
        if (this.cI == e) {
          this.bI.a = df.Y;
          es1.a(this.bZ);
        } 
      } 
    } 
    if (this.K == 0)
      es1.a(this.cE); 
    return es1;
  }
  
  public final void a(bx parambx) {
    es es1;
    if (this.K == 15) {
      es1 = bw.aa;
    } else if (this.K == 0 || this.K == 16) {
      es1 = bw.V;
    } else if (this.K == 9) {
      es1 = bw.W;
    } else if (this.K == 13) {
      es1 = bw.X;
    } else if (this.K == 12) {
      es1 = bw.Y;
    } else {
      es1 = this.bF;
    } 
    ft.a(parambx);
    parambx.d(this.V - fl.aN, this.W, fl.S + (fl.aN << 1), fl.T - fl.aN / 2 + 1);
    parambx.a(-p.e.a, -p.e.b);
    int i;
    if ((i = es1.c()) > 42)
      i = 42; 
    if (this.cK)
      i = this.bF.c(); 
    int j = i * this.bH;
    byte b;
    for (b = 0; b < i; b++) {
      bw bw;
      if ((bw = (bw)es1.a(b + j)) != null) {
        if (bw.u == 7) {
          j j1;
          if ((j1 = bw.b(bw.O)) != null) {
            bw.a(j1.g, j1.t, 7, bw.q, bw.Q, j1.h, (short)j1.P, j1.A, j1.x, j1.y);
            bw.d(j1.N);
          } else {
            bw.c(bw.O);
            if (bw.p > 0)
              parambx.a(cg.am, 0, 0, fl.aM - 1, fl.aM - 1, 0, this.V + fl.aM / 2 + b % this.bx * fl.aM, this.W + fl.aM / 2 + b / this.bx * fl.aM, 3); 
          } 
        } 
        bw.a(parambx, this.V + fl.aM / 2 + b % this.bx * fl.aM, this.W + fl.aM / 2 + b / this.bx * fl.aM, fl.aM, 0, 0);
      } else {
        continue;
      } 
      if (bw.p > 0)
        parambx.a(cg.am, 0, 0, fl.aM - 1, fl.aM - 1, 0, this.V + fl.aM / 2 + b % this.bx * fl.aM, this.W + fl.aM / 2 + b / this.bx * fl.aM, 3); 
    } 
    parambx.a(fl.bf[1]);
    parambx.b(this.V, this.W, fl.S, fl.aM * this.by);
    for (b = 0; b < this.bx / 2; b++)
      parambx.b(this.V + fl.aM + (b * fl.aM << 1), this.W, fl.aM, fl.aM * this.by); 
    for (b = 0; b < this.by / 2; b++)
      parambx.b(this.V, this.W + fl.aM + (b * fl.aM << 1), fl.S, fl.aM); 
    if (this.bB > -1 && fl.aO == 1) {
      parambx.a(fl.bf[2]);
      parambx.b(this.V + (this.bB - this.bH * 42) % this.bx * fl.aM + 1, this.W + (this.bB - this.bH * 42) / this.bx * fl.aM + 1, fl.aM - 2, fl.aM - 2);
      parambx.a(fl.bf[3]);
      parambx.b(this.V + (this.bB - this.bH * 42) % this.bx * fl.aM, this.W + (this.bB - this.bH * 42) / this.bx * fl.aM, fl.aM, fl.aM);
    } 
    if (!ft.o.a && ft.r == null && ft.s == null && fl.aO == 1 && fl.bi > fl.aX) {
      a(parambx, false);
      if (this.cH != null)
        for (b = 0; b < this.cH.c(); b++) {
          bt bt1;
          (bt1 = (bt)this.cH.a(b)).a(parambx, bt1.h, bt1.i);
        }  
    } 
    if (cn.p.a >= 0) {
      bw bw = null;
      if (this.bB > -1 && fl.aO == 1)
        bw = (bw)es1.a(this.bB); 
      if (!ft.o.a && ft.r == null && ft.s == null)
        cn.p.a(parambx, bw, this.K); 
    } 
    if (!ft.C && this.cI == b) {
      bw bw = null;
      if (this.bB > -1 && fl.aO == 1)
        bw = (bw)es1.a(this.bB); 
      int k = cn.f.cb;
      if (bw != null)
        k = bw.t; 
      fl.a(parambx, k);
    } 
    fh fh;
    if (!cn.f.e_() && this.K == 15 && this.bB >= 0 && this.bB < bw.ab.c() && (fh = (fh)bw.ab.a(this.bB)) != null)
      o.k.a(parambx, String.valueOf(df.ba) + ": " + j.a(fh.a) + " " + df.bO, this.V, this.W + fl.aM * 6, 0, false); 
  }
  
  public final void a() {
    if (this.K != 0 && this.K != 16 && this.K != 9 && this.K != 13 && this.bH != 0)
      this.bH = 0; 
    if (cn.p.a > 0)
      cn.p.h(); 
    if (fl.aO == 1) {
      es es1;
      if (this.aY != null)
        this.aY.c(); 
      if (ft.A) {
        this.cG.c();
      } else {
        p.e.a();
      } 
      if (this.K == 15) {
        es1 = bw.aa;
      } else if (this.K == 0 || this.K == 16) {
        es1 = bw.V;
      } else if (this.K == 9) {
        es1 = bw.W;
      } else if (this.K == 12) {
        es1 = bw.Y;
      } else {
        es1 = this.bF;
      } 
      if (es1.c() == 0) {
        fl.aO = 0;
        return;
      } 
      if (this.bB >= es1.c())
        if (ft.A) {
          this.bB = -1;
          this.cH = null;
        } else {
          this.bB = es1.c() - 1;
        }  
      if (this.K != e) {
        int i = this.bB;
        es es2 = es1;
        fn fn1 = this;
        if (fl.bi < fl.aX + 2 && ++fl.bi == fl.aX)
          fn1.f(); 
        bw bw;
        if (fn1.bj == null && i >= 0 && i < es2.c() && (bw = (bw)es2.a(i)).u != 5)
          if (bw.k == null) {
            if (bw.o % 100 == 3) {
              if (fn1.K == 0 || fn1.K == 16)
                q.a().a((byte)0, (byte)bw.O); 
              bw.o++;
            } else {
              bw.o++;
            } 
          } else {
            fn1.bu = bw.J;
            fn1.bj = bw.k;
            fn1.bm = bw.m;
            fn1.b(bw);
          }  
      } 
    } else {
      fl.bi = 0;
    } 
    if (this.bH == 0 && this.bB > 42 && !this.cK)
      this.bB = -1; 
  }
  
  public final void d() {
    // Byte code:
    //   0: aload_0
    //   1: getfield K : B
    //   4: bipush #15
    //   6: if_icmpne -> 16
    //   9: getstatic bw.aa : Les;
    //   12: astore_1
    //   13: goto -> 76
    //   16: aload_0
    //   17: getfield K : B
    //   20: ifeq -> 32
    //   23: aload_0
    //   24: getfield K : B
    //   27: bipush #16
    //   29: if_icmpne -> 39
    //   32: getstatic bw.V : Les;
    //   35: astore_1
    //   36: goto -> 76
    //   39: aload_0
    //   40: getfield K : B
    //   43: bipush #9
    //   45: if_icmpne -> 55
    //   48: getstatic bw.W : Les;
    //   51: astore_1
    //   52: goto -> 76
    //   55: aload_0
    //   56: getfield K : B
    //   59: bipush #12
    //   61: if_icmpne -> 71
    //   64: getstatic bw.Y : Les;
    //   67: astore_1
    //   68: goto -> 76
    //   71: aload_0
    //   72: getfield bF : Les;
    //   75: astore_1
    //   76: getstatic fl.aO : B
    //   79: iconst_1
    //   80: if_icmpne -> 577
    //   83: aload_0
    //   84: getfield bB : I
    //   87: istore_2
    //   88: iconst_0
    //   89: istore_3
    //   90: aload_0
    //   91: getfield aY : Lbp;
    //   94: ifnull -> 214
    //   97: getstatic ft.al : [Z
    //   100: iconst_2
    //   101: baload
    //   102: ifeq -> 148
    //   105: aload_0
    //   106: getfield aY : Lbp;
    //   109: getfield e : I
    //   112: ifle -> 133
    //   115: aload_0
    //   116: getfield aY : Lbp;
    //   119: dup
    //   120: getfield e : I
    //   123: getstatic ft.ab : I
    //   126: isub
    //   127: putfield e : I
    //   130: goto -> 141
    //   133: aload_0
    //   134: getfield aY : Lbp;
    //   137: iconst_0
    //   138: putfield e : I
    //   141: iconst_2
    //   142: invokestatic d : (I)V
    //   145: goto -> 273
    //   148: getstatic ft.al : [Z
    //   151: bipush #8
    //   153: baload
    //   154: ifeq -> 273
    //   157: aload_0
    //   158: getfield aY : Lbp;
    //   161: getfield e : I
    //   164: aload_0
    //   165: getfield aY : Lbp;
    //   168: getfield g : I
    //   171: if_icmpge -> 192
    //   174: aload_0
    //   175: getfield aY : Lbp;
    //   178: dup
    //   179: getfield e : I
    //   182: getstatic ft.ab : I
    //   185: iadd
    //   186: putfield e : I
    //   189: goto -> 206
    //   192: aload_0
    //   193: getfield aY : Lbp;
    //   196: aload_0
    //   197: getfield aY : Lbp;
    //   200: getfield g : I
    //   203: putfield e : I
    //   206: bipush #8
    //   208: invokestatic d : (I)V
    //   211: goto -> 273
    //   214: getstatic ft.al : [Z
    //   217: iconst_2
    //   218: baload
    //   219: ifeq -> 244
    //   222: aload_0
    //   223: dup
    //   224: getfield bB : I
    //   227: aload_0
    //   228: getfield bx : I
    //   231: isub
    //   232: putfield bB : I
    //   235: iconst_2
    //   236: invokestatic d : (I)V
    //   239: iconst_1
    //   240: istore_3
    //   241: goto -> 273
    //   244: getstatic ft.al : [Z
    //   247: bipush #8
    //   249: baload
    //   250: ifeq -> 273
    //   253: aload_0
    //   254: dup
    //   255: getfield bB : I
    //   258: aload_0
    //   259: getfield bx : I
    //   262: iadd
    //   263: putfield bB : I
    //   266: bipush #8
    //   268: invokestatic d : (I)V
    //   271: iconst_1
    //   272: istore_3
    //   273: getstatic ft.al : [Z
    //   276: iconst_4
    //   277: baload
    //   278: ifeq -> 380
    //   281: aload_0
    //   282: getfield bB : I
    //   285: aload_0
    //   286: getfield bx : I
    //   289: irem
    //   290: ifne -> 307
    //   293: aload_0
    //   294: getfield bH : B
    //   297: ifne -> 307
    //   300: iconst_0
    //   301: putstatic fl.aO : B
    //   304: goto -> 317
    //   307: aload_0
    //   308: dup
    //   309: getfield bB : I
    //   312: iconst_1
    //   313: isub
    //   314: putfield bB : I
    //   317: aload_0
    //   318: getfield bH : B
    //   321: iconst_1
    //   322: if_icmpne -> 345
    //   325: aload_0
    //   326: getfield bB : I
    //   329: bipush #41
    //   331: if_icmpne -> 345
    //   334: aload_0
    //   335: dup
    //   336: getfield bH : B
    //   339: iconst_1
    //   340: isub
    //   341: i2b
    //   342: putfield bH : B
    //   345: aload_0
    //   346: getfield bH : B
    //   349: iconst_2
    //   350: if_icmpne -> 373
    //   353: aload_0
    //   354: getfield bB : I
    //   357: bipush #82
    //   359: if_icmpne -> 373
    //   362: aload_0
    //   363: dup
    //   364: getfield bH : B
    //   367: iconst_1
    //   368: isub
    //   369: i2b
    //   370: putfield bH : B
    //   373: iconst_4
    //   374: invokestatic d : (I)V
    //   377: goto -> 461
    //   380: getstatic ft.al : [Z
    //   383: bipush #6
    //   385: baload
    //   386: ifeq -> 463
    //   389: aload_0
    //   390: dup
    //   391: getfield bB : I
    //   394: iconst_1
    //   395: iadd
    //   396: putfield bB : I
    //   399: bipush #6
    //   401: invokestatic d : (I)V
    //   404: getstatic fn.G : B
    //   407: iconst_1
    //   408: if_icmple -> 461
    //   411: aload_0
    //   412: getfield bB : I
    //   415: ifle -> 461
    //   418: aload_0
    //   419: getfield bB : I
    //   422: bipush #42
    //   424: irem
    //   425: ifne -> 461
    //   428: aload_0
    //   429: dup
    //   430: getfield bH : B
    //   433: iconst_1
    //   434: iadd
    //   435: i2b
    //   436: putfield bH : B
    //   439: aload_0
    //   440: getfield bH : B
    //   443: getstatic fn.G : B
    //   446: iconst_1
    //   447: isub
    //   448: if_icmple -> 461
    //   451: aload_0
    //   452: iconst_0
    //   453: putfield bH : B
    //   456: aload_0
    //   457: iconst_0
    //   458: putfield bB : I
    //   461: iconst_1
    //   462: istore_3
    //   463: iload_3
    //   464: ifeq -> 543
    //   467: aload_0
    //   468: aconst_null
    //   469: putfield aY : Lbp;
    //   472: aload_0
    //   473: aload_0
    //   474: getfield bB : I
    //   477: aload_1
    //   478: invokevirtual c : ()I
    //   481: iconst_1
    //   482: isub
    //   483: iconst_0
    //   484: invokestatic a : (IIZ)I
    //   487: putfield bB : I
    //   490: getstatic ft.A : Z
    //   493: ifne -> 538
    //   496: aload_0
    //   497: getfield K : B
    //   500: ifeq -> 530
    //   503: aload_0
    //   504: getfield K : B
    //   507: bipush #16
    //   509: if_icmpeq -> 530
    //   512: aload_0
    //   513: getfield K : B
    //   516: bipush #9
    //   518: if_icmpeq -> 530
    //   521: aload_0
    //   522: getfield K : B
    //   525: bipush #15
    //   527: if_icmpne -> 538
    //   530: aload_0
    //   531: aload_0
    //   532: getfield bO : Lbt;
    //   535: putfield aa : Lbt;
    //   538: bipush #10
    //   540: putstatic eu.f : I
    //   543: iload_2
    //   544: aload_0
    //   545: getfield bB : I
    //   548: if_icmpeq -> 577
    //   551: getstatic p.e : Law;
    //   554: iconst_0
    //   555: aload_0
    //   556: getfield bB : I
    //   559: aload_0
    //   560: getfield bx : I
    //   563: idiv
    //   564: iconst_1
    //   565: isub
    //   566: getstatic fl.aM : B
    //   569: imul
    //   570: invokevirtual a : (II)V
    //   573: iconst_0
    //   574: putstatic fl.bi : I
    //   577: aload_0
    //   578: invokespecial d : ()V
    //   581: return
  }
  
  private void f() {
    try {
      es es1;
      this.bj = null;
      this.bk = null;
      this.bl = null;
      if (this.K == 15) {
        es1 = bw.aa;
      } else if (this.K == 0 || this.K == 16) {
        es1 = bw.V;
      } else if (this.K == 9) {
        es1 = bw.W;
      } else if (this.K == 12) {
        es1 = bw.Y;
      } else {
        es1 = this.bF;
      } 
      if (this.bB >= es1.c() || this.bB < 0) {
        if (this.bB > es1.c() - 1)
          this.bB = es1.c() - 1; 
        fl.bi = 0;
        return;
      } 
      bw bw;
      if ((bw = (bw)es1.a(this.bB)) != null && bw.b()) {
        fl.bi = 0;
        return;
      } 
      if (bw.u == 9) {
        ah.i = (ea)bw;
        this.R = true;
      } else {
        this.R = false;
      } 
      this.bp = bw.g;
      this.br = bw.N;
      j j;
      if (bw.u == 7 && (j = bw.b(bw.O)) != null) {
        this.br = j.N;
        if (this.K == 15 && bw.H) {
          this.bl = bw.l;
          this.bo = bw.n;
        } 
      } 
      this.bu = bw.J;
      if (bw.u == 3 || this.K == 8) {
        this.bl = bw.l;
        this.bo = bw.n;
      } 
      this.aY = null;
      if (fl.aU > 0) {
        int i = 1;
        this.bj = bw.k;
        this.bm = bw.m;
        if (bw.k != null)
          i = 1 + this.bj.length; 
        if (bw.l != null)
          i += bw.l.length; 
        if (i * ft.ab > fl.U - this.bC) {
          this.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, i * ft.ab - fl.U - this.bC);
        } else if (ft.A) {
          this.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, 0);
        } 
        c(bw);
        return;
      } 
      this.bq = bw.s;
      b(bw);
      if (this.bB % this.bx < 2) {
        this.bs = this.V + fl.aM / 2 + this.bB % this.bx * fl.aM;
        return;
      } 
      if (this.bB % this.bx < 5) {
        this.bs = this.V + fl.aM / 2 + this.bB % this.bx * fl.aM - this.bq / 2;
        return;
      } 
      this.bs = this.V + fl.aM / 2 + this.bB % this.bx * fl.aM - this.bq;
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void b(bw parambw) {
    int i = 0;
    if (p.e.b > 0)
      i = p.e.b / fl.aM; 
    int j = 1;
    this.bj = parambw.k;
    this.bu = parambw.J;
    this.bm = parambw.m;
    if (parambw.k != null)
      j = 1 + this.bj.length; 
    if (parambw.l != null)
      j += parambw.l.length; 
    if (this.bB / this.bx < this.bz / 2 + i) {
      this.bt = this.W + (this.bB / this.bx + 1) * fl.aM + 2;
      if (this.bt - p.e.b + (j + 1) * ft.ab > ft.X - ft.aa - 5)
        this.bt = ft.X - ft.aa - 5 - (j + 1) * ft.ab - p.e.b; 
    } else if (dw.g) {
      i = this.bB;
      if (this.bH > 0)
        i -= 42; 
      this.bt = this.W + (i / this.bx + 1) * fl.aM + 2;
      if (this.bt - p.e.b + (j + 1) * ft.ab > ft.X - ft.aa - 5)
        this.bt = ft.X - ft.aa - 5 - (j + 1) * ft.ab - p.e.b; 
    } else {
      this.bt = this.W + (this.bB / this.bx + 1) * fl.aM - 7 - j * ft.ab - p.e.b;
      if (this.bt - p.e.b < 6)
        this.bt = 6 + p.e.b; 
    } 
    if (dw.g && this.bt >= ft.X / 4)
      this.bt = ft.X / 2; 
    if ((j + 1) * ft.ab > fl.U - this.bC)
      this.aY = new bp(this.bs, this.bt, this.bq, fl.U, 0, 0, (j + 1) * ft.ab - fl.U - this.bC); 
    c(parambw);
  }
  
  private void c(bw parambw) {
    if (this.K == 0 && parambw.u == 3 && (parambw.M == 4 || parambw.M == cn.f.bx) && parambw.R < 12) {
      int i = (byte)fo.l[parambw.R];
      bw bw1 = null;
      if (i == -1) {
        i = 0;
        int j = 0;
        bw bw2 = (bw)bw.U.a("3");
        bw bw3 = (bw)bw.U.a("9");
        if (bw2 == null) {
          bw1 = bw3;
        } else if (bw3 == null) {
          bw1 = bw2;
        } else {
          byte b;
          for (b = 0; b < bw2.j.length; b++)
            i = i + (bw2.j[b]).b; 
          for (b = 0; b < bw3.j.length; b++)
            j += (bw3.j[b]).b; 
          if (i >= j) {
            bw1 = bw3;
          } else {
            bw1 = bw2;
          } 
        } 
      } else {
        bw1 = (bw)bw.U.a(i);
      } 
      if (bw1 != null && bw1.R == parambw.R && this.bj != null && bw1.J.c() <= 0) {
        this.bk = new String[this.bj.length];
        this.bn = new int[this.bj.length];
        for (i = 0; i < this.bk.length; i++) {
          this.bk[i] = "";
          this.bn[i] = 0;
          for (byte b = 0; b < bw1.j.length; b++) {
            if ((parambw.j[i]).a == (bw1.j[b]).a) {
              int j;
              if ((j = (parambw.j[i]).b - (bw1.j[b]).b) >= 0) {
                this.bn[i] = 5;
                this.bk[i] = "+";
              } else {
                this.bk[i] = "-";
                this.bn[i] = 6;
              } 
              this.bk[i] = String.valueOf(this.bk[i]) + bw.a(bw.f[(parambw.j[i]).a], ak.e(j));
              String str = String.valueOf(bw.d[(parambw.j[i]).a]) + ": " + bw.a(bw.f[(parambw.j[i]).a], (parambw.j[i]).b);
              int k = o.i.a(String.valueOf(str) + " " + this.bk[i]);
              if (this.bq < k + 10)
                this.bq = k + 10; 
              break;
            } 
          } 
        } 
      } 
    } 
  }
  
  public final void e() {
    int i = 0;
    if (this.aY != null && ft.c(this.aY.c, this.aY.d, this.aY.a, this.aY.b)) {
      this.aY.a();
      i = 1;
    } 
    if (ft.A && !i) {
      this.cG.a();
      p.e.b = this.cG.f;
    } 
    if (ft.b(this.V, this.W, this.bx * fl.aM, fl.T - fl.aN / 2) && !i) {
      i = (ft.ae - this.V) / fl.aM + (ft.af - this.W + p.e.b) / fl.aM * this.bx;
      int j = 0;
      if (this.K == 15) {
        j = bw.aa.c();
      } else if (this.K == 0 || this.K == 16) {
        j = bw.V.c();
      } else if (this.K == 9) {
        j = bw.W.c();
      } else if (this.K == 12) {
        j = bw.Y.c();
      } else if (this.K == 13) {
        j = bw.X.c();
      } else {
        j = this.bF.c();
      } 
      if (i >= 0 && i < j) {
        ft.S = false;
        j = this.bB;
        if (this.bH == 1)
          j -= 42; 
        if (i == j) {
          if (fl.aU == 0)
            if (this.K == 0 || this.K == 16 || this.K == 9 || this.K == 15 || this.K == 12 || (this.K == 8 && this.cI == e) || this.K == 13) {
              this.bO.a();
            } else if (this.cI == h) {
              this.cc.a();
            } else {
              this.bI.a();
            }  
        } else {
          fl.bi = 0;
          this.bB = i + 42 * this.bH;
          if (this.bH == 0 && this.bB == 42)
            this.bB = -1; 
          if (this.bH == 1 && this.bB == 84)
            this.bB = -1; 
          if (this.bH == 3 && this.bB == 126)
            this.bB = -1; 
          if (this.cK)
            this.bB = i; 
          fn fn1 = this;
          if (fl.aU > 0 && ft.A) {
            es es1;
            fn1.bC = 0;
            if (fn1.K == 15) {
              es1 = bw.aa;
            } else if (fn1.K == 0 || fn1.K == 16) {
              es1 = bw.V;
            } else if (fn1.K == 9) {
              es1 = bw.W;
            } else {
              es1 = fn1.bF;
            } 
            if (fn1.bB >= 0 && fn1.bB < es1.c()) {
              bw bw = (bw)es1.a(fn1.bB);
              fn1.cH = fn1.a(bw);
              fn1.b(fn1.cH);
              fn1.bC = (fn1.cH.c() + 1) / 2 * bt.k;
            } 
          } 
          this.aY = null;
        } 
        if (fl.aO != 1)
          fl.aO = 1; 
      } else {
        this.bB = -1;
        fl.bi = 0;
        this.aY = null;
      } 
    } 
    if (this.cH != null && fl.aO == 1 && fl.bi > fl.aX)
      for (i = 0; i < this.cH.c(); i++) {
        bt bt1;
        (bt1 = (bt)this.cH.a(i)).b();
      }  
    super.e();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fn.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */