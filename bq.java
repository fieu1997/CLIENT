public final class bq extends ez {
  public static bt a;
  
  public static bt b;
  
  public static bt c;
  
  public static int d = 0;
  
  public static int e = 0;
  
  public static int f = 21;
  
  public static int g = 0;
  
  public static int h = 0;
  
  public static int i = 0;
  
  public static long j;
  
  public static boolean k = false;
  
  public static boolean l = false;
  
  public static boolean m = false;
  
  public static boolean n = true;
  
  public static byte o = 1;
  
  public static byte p = 0;
  
  public static be q;
  
  private static boolean ej = false;
  
  public static ad[] r = new ad[f];
  
  public static ad[] s = new ad[3];
  
  public static int t = 0;
  
  public static int u = 0;
  
  public static int[][] v = dw.a(2, 4);
  
  public static ao[][] w = new ao[3][];
  
  public static short x = 42;
  
  public static short y = 20;
  
  public static short z = 24;
  
  public static byte A = 0;
  
  private byte ek;
  
  private long el;
  
  public boolean B;
  
  public boolean C;
  
  public int D;
  
  public static byte[] E;
  
  private cj em;
  
  public int F = 1000000;
  
  public int G = 1000000;
  
  public static int[] H = new int[f];
  
  public static int[] I = new int[f];
  
  public static int[] J = new int[f];
  
  public String[] K = new String[5];
  
  public cz[] L;
  
  public ew M;
  
  public static w N;
  
  public static int O = -1;
  
  public static int P = -1;
  
  public static int Q = 0;
  
  public static int R = -1;
  
  public static int S = -1;
  
  public static short[] T = new short[0];
  
  public y U;
  
  private int en;
  
  private static byte eo = 0;
  
  private long ep;
  
  private static short eq = 0;
  
  private static int er = 0;
  
  private static int es;
  
  private static byte et = -1;
  
  private static byte eu = 0;
  
  private int ev = 0;
  
  public static boolean V = false;
  
  public static int W = 0;
  
  public static boolean X = false;
  
  public final boolean c_() {
    return true;
  }
  
  public bq(int paramInt1, byte paramByte, String paramString, int paramInt2, int paramInt3) {
    super(paramInt1, (byte)0, paramString, paramInt2, paramInt3);
    N = null;
    this.cu = 0;
    this.be = 40;
    this.bd = 30;
    this.bi = 6;
    this.cB = paramString;
    this.bh = 140;
    a = new bt(df.aa, 0, this);
    (b = new bt(df.cc, 1, this)).a(bt.j / 2, ft.X - bt.k / 2 - 2, (ce)null, b.a);
    (c = new bt(df.bC, 2, this)).a(ft.W - bt.j / 2, ft.X - bt.k / 2 - 2, (ce)null, c.a);
    this.dg = new ds();
    this.dh = new dh();
    k = false;
    this.bn = 1;
    this.bo = 2;
    for (paramInt1 = 0; paramInt1 < r.length; paramInt1++) {
      r[paramInt1] = new ad();
      (r[paramInt1]).b = 0;
      (r[paramInt1]).a = dw.a();
    } 
    for (paramInt1 = 0; paramInt1 < s.length; paramInt1++) {
      s[paramInt1] = new ad();
      (s[paramInt1]).b = 0;
      (s[paramInt1]).a = dw.a();
    } 
    this.el = dw.a();
    this.D = -1;
  }
  
  public final void p() {
    fn fn = new fn(bw.V, (byte)0, df.dx, -1, (byte)0);
    es es2;
    (es2 = new es("Player (init) v")).a(fn);
    af af = new af(df.dp);
    es2.a(af);
    m m = new m(df.dq);
    es2.a(m);
    this.U = new y(df.dr);
    es2.a(this.U);
    dr dr = new dr();
    es2.a(this);
    es es1 = new es("Player mcmdTest");
    if (ft.A) {
      bg bg = new bg(df.du, this, (byte)11);
      es2.a(bg);
    } else {
      bg bg2 = new bg(df.dt, this, (byte)7);
      es2.a(bg2);
      bg bg1 = new bg(df.du, this, (byte)11);
      es2.a(this);
    } 
    ft.u.a(es2);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 0:
        W();
        return;
      case 1:
        q.a().b((byte)1);
        ft.a(df.aG);
        return;
      case 2:
        ft.c(df.bD, new bt(c.a, 3, this));
        return;
      case 3:
        q.a().b((byte)0);
      case 4:
        q.a().a(4, null, "", (short)0, 0, (byte)0);
        return;
      case 5:
        ft.j();
        break;
    } 
  }
  
  public final void a(byte paramByte, boolean paramBoolean) {
    this.ek = 4;
    this.C = paramBoolean;
  }
  
  public final void a(bx parambx) {
    c(parambx, 100);
    j(parambx);
    parambx = parambx;
    if ((this = this).em != null && !this.em.d.equals(""))
      this.em.a(parambx); 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2) {}
  
  public final void a() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual J : ()V
    //   4: aload_0
    //   5: getfield M : Lew;
    //   8: ifnonnull -> 820
    //   11: aload_0
    //   12: astore_1
    //   13: getstatic bq.o : B
    //   16: iconst_1
    //   17: if_icmpeq -> 820
    //   20: getstatic cn.h : Lez;
    //   23: ifnull -> 48
    //   26: getstatic cn.h : Lez;
    //   29: getfield cx : B
    //   32: iconst_2
    //   33: if_icmpeq -> 45
    //   36: getstatic cn.h : Lez;
    //   39: invokevirtual x : ()Z
    //   42: ifeq -> 48
    //   45: goto -> 820
    //   48: getstatic cn.h : Lez;
    //   51: ifnull -> 227
    //   54: getstatic cn.h : Lez;
    //   57: getfield cF : I
    //   60: iconst_4
    //   61: if_icmpne -> 73
    //   64: getstatic cn.h : Lez;
    //   67: getfield cu : B
    //   70: ifne -> 125
    //   73: getstatic cn.h : Lez;
    //   76: getfield aY : I
    //   79: getstatic cn.h : Lez;
    //   82: getfield aZ : I
    //   85: aload_1
    //   86: getfield aY : I
    //   89: aload_1
    //   90: getfield aZ : I
    //   93: invokestatic c : (IIII)I
    //   96: aload_1
    //   97: getfield bh : I
    //   100: bipush #20
    //   102: iadd
    //   103: if_icmpgt -> 125
    //   106: getstatic cn.h : Lez;
    //   109: getfield dj : Z
    //   112: ifeq -> 142
    //   115: getstatic cn.h : Lez;
    //   118: getfield cu : B
    //   121: iconst_1
    //   122: if_icmpne -> 142
    //   125: invokestatic i : ()Z
    //   128: ifne -> 227
    //   131: aconst_null
    //   132: putstatic cn.h : Lez;
    //   135: iconst_0
    //   136: putstatic cf.K : Z
    //   139: goto -> 227
    //   142: getstatic ft.A : Z
    //   145: ifne -> 227
    //   148: getstatic cn.h : Lez;
    //   151: getfield cu : B
    //   154: iconst_2
    //   155: if_icmpeq -> 215
    //   158: getstatic cn.h : Lez;
    //   161: getfield cu : B
    //   164: ifne -> 227
    //   167: aload_1
    //   168: getstatic cn.h : Lez;
    //   171: invokevirtual b : (Lez;)Z
    //   174: ifne -> 227
    //   177: invokestatic b : ()Lcn;
    //   180: getfield aa : Lbt;
    //   183: invokestatic b : ()Lcn;
    //   186: getfield s : Lbt;
    //   189: if_acmpeq -> 227
    //   192: aload_1
    //   193: getfield cv : B
    //   196: iconst_m1
    //   197: if_icmpeq -> 215
    //   200: aload_1
    //   201: getfield cv : B
    //   204: bipush #10
    //   206: if_icmpeq -> 215
    //   209: invokestatic a : ()Z
    //   212: ifeq -> 227
    //   215: invokestatic b : ()Lcn;
    //   218: invokestatic b : ()Lcn;
    //   221: getfield s : Lbt;
    //   224: putfield aa : Lbt;
    //   227: getstatic cn.h : Lez;
    //   230: ifnonnull -> 820
    //   233: invokestatic b : ()Lcn;
    //   236: getfield aa : Lbt;
    //   239: ifnull -> 249
    //   242: invokestatic b : ()Lcn;
    //   245: aconst_null
    //   246: putfield aa : Lbt;
    //   249: getstatic cn.i : Les;
    //   252: invokevirtual c : ()I
    //   255: istore_2
    //   256: aload_1
    //   257: getfield ev : I
    //   260: iload_2
    //   261: iconst_1
    //   262: isub
    //   263: if_icmple -> 273
    //   266: aload_1
    //   267: iload_2
    //   268: iconst_1
    //   269: isub
    //   270: putfield ev : I
    //   273: sipush #1000
    //   276: istore_3
    //   277: iconst_m1
    //   278: istore #4
    //   280: aconst_null
    //   281: astore #6
    //   283: iconst_0
    //   284: istore #7
    //   286: goto -> 664
    //   289: iconst_0
    //   290: istore #5
    //   292: getstatic cn.i : Les;
    //   295: iload #7
    //   297: aload_1
    //   298: getfield ev : I
    //   301: iadd
    //   302: iload_2
    //   303: irem
    //   304: invokevirtual a : (I)Ljava/lang/Object;
    //   307: checkcast ez
    //   310: dup
    //   311: astore #8
    //   313: ifnull -> 339
    //   316: aload #8
    //   318: getfield aY : I
    //   321: aload #8
    //   323: getfield aZ : I
    //   326: aload_1
    //   327: getfield aY : I
    //   330: aload_1
    //   331: getfield aZ : I
    //   334: invokestatic c : (IIII)I
    //   337: istore #5
    //   339: iload #5
    //   341: aload_1
    //   342: getfield bh : I
    //   345: if_icmpgt -> 661
    //   348: aload #8
    //   350: getfield cu : B
    //   353: istore #9
    //   355: iconst_m1
    //   356: istore #10
    //   358: iload #9
    //   360: tableswitch default -> 423, 0 -> 408, 1 -> 414, 2 -> 408, 3 -> 420, 4 -> 420, 5 -> 420, 6 -> 423, 7 -> 420
    //   408: iconst_0
    //   409: istore #10
    //   411: goto -> 423
    //   414: iconst_1
    //   415: istore #10
    //   417: goto -> 423
    //   420: iconst_2
    //   421: istore #10
    //   423: iload #10
    //   425: istore #9
    //   427: aload #8
    //   429: getfield ct : I
    //   432: getstatic cn.f : Lbq;
    //   435: getfield ct : I
    //   438: if_icmpeq -> 661
    //   441: aload #8
    //   443: getfield cF : I
    //   446: iconst_4
    //   447: if_icmpne -> 458
    //   450: aload #8
    //   452: getfield cu : B
    //   455: ifne -> 661
    //   458: aload #8
    //   460: getfield cK : Z
    //   463: ifne -> 661
    //   466: iload #9
    //   468: iload #4
    //   470: if_icmplt -> 661
    //   473: aload #8
    //   475: getfield dj : Z
    //   478: ifeq -> 490
    //   481: aload #8
    //   483: getfield cu : B
    //   486: iconst_1
    //   487: if_icmpeq -> 661
    //   490: aload #8
    //   492: getfield cu : B
    //   495: bipush #9
    //   497: if_icmpeq -> 661
    //   500: aload #8
    //   502: invokevirtual x : ()Z
    //   505: ifne -> 661
    //   508: aload #8
    //   510: getfield bI : Z
    //   513: ifne -> 661
    //   516: iload #5
    //   518: aload_1
    //   519: getfield bh : I
    //   522: if_icmplt -> 593
    //   525: aload #6
    //   527: ifnull -> 661
    //   530: aload #6
    //   532: getfield cu : B
    //   535: ifeq -> 547
    //   538: aload #6
    //   540: getfield cu : B
    //   543: iconst_2
    //   544: if_icmpne -> 661
    //   547: aload #8
    //   549: getfield cu : B
    //   552: iconst_3
    //   553: if_icmpeq -> 593
    //   556: aload #8
    //   558: getfield cu : B
    //   561: iconst_1
    //   562: if_icmpeq -> 593
    //   565: aload #8
    //   567: getfield cu : B
    //   570: iconst_4
    //   571: if_icmpeq -> 593
    //   574: aload #8
    //   576: getfield cu : B
    //   579: iconst_5
    //   580: if_icmpeq -> 593
    //   583: aload #8
    //   585: getfield cu : B
    //   588: bipush #7
    //   590: if_icmpne -> 661
    //   593: iload #5
    //   595: iload_3
    //   596: if_icmplt -> 606
    //   599: iload #9
    //   601: iload #4
    //   603: if_icmple -> 661
    //   606: aload #8
    //   608: getfield cu : B
    //   611: ifeq -> 623
    //   614: aload #8
    //   616: getfield cu : B
    //   619: iconst_2
    //   620: if_icmpne -> 644
    //   623: getstatic bq.eu : B
    //   626: bipush #20
    //   628: if_icmpge -> 644
    //   631: getstatic bq.et : B
    //   634: ifeq -> 644
    //   637: getstatic bq.et : B
    //   640: iconst_2
    //   641: if_icmpne -> 661
    //   644: aload #8
    //   646: astore #6
    //   648: iload #5
    //   650: istore_3
    //   651: aload_1
    //   652: iload #7
    //   654: putfield ev : I
    //   657: iload #9
    //   659: istore #4
    //   661: iinc #7, 1
    //   664: iload #7
    //   666: iload_2
    //   667: if_icmplt -> 289
    //   670: aload #6
    //   672: ifnull -> 801
    //   675: aload #6
    //   677: invokevirtual b : ()Z
    //   680: ifeq -> 820
    //   683: aload #6
    //   685: putstatic cn.h : Lez;
    //   688: getstatic ft.A : Z
    //   691: ifne -> 820
    //   694: getstatic cn.h : Lez;
    //   697: ifnull -> 710
    //   700: getstatic cn.h : Lez;
    //   703: getfield cu : B
    //   706: iconst_2
    //   707: if_icmpeq -> 752
    //   710: getstatic cn.h : Lez;
    //   713: getfield cu : B
    //   716: ifne -> 767
    //   719: aload_1
    //   720: getstatic cn.h : Lez;
    //   723: invokevirtual b : (Lez;)Z
    //   726: ifne -> 767
    //   729: aload_1
    //   730: getfield cv : B
    //   733: iconst_m1
    //   734: if_icmpeq -> 752
    //   737: aload_1
    //   738: getfield cv : B
    //   741: bipush #10
    //   743: if_icmpeq -> 752
    //   746: invokestatic a : ()Z
    //   749: ifeq -> 767
    //   752: invokestatic b : ()Lcn;
    //   755: invokestatic b : ()Lcn;
    //   758: getfield s : Lbt;
    //   761: putfield aa : Lbt;
    //   764: goto -> 789
    //   767: invokestatic b : ()Lcn;
    //   770: getfield aa : Lbt;
    //   773: invokestatic b : ()Lcn;
    //   776: getfield s : Lbt;
    //   779: if_acmpne -> 789
    //   782: invokestatic b : ()Lcn;
    //   785: aconst_null
    //   786: putfield aa : Lbt;
    //   789: invokestatic b : ()Lcn;
    //   792: getstatic bq.a : Lbt;
    //   795: putfield Z : Lbt;
    //   798: goto -> 820
    //   801: invokestatic b : ()Lcn;
    //   804: getfield Z : Lbt;
    //   807: getstatic bq.a : Lbt;
    //   810: if_acmpne -> 820
    //   813: invokestatic b : ()Lcn;
    //   816: aconst_null
    //   817: putfield Z : Lbt;
    //   820: aload_0
    //   821: iconst_1
    //   822: invokevirtual a : (Z)V
    //   825: aload_0
    //   826: astore_1
    //   827: getstatic bq.l : Z
    //   830: ifeq -> 1116
    //   833: aload_1
    //   834: getfield cF : I
    //   837: iconst_4
    //   838: if_icmpeq -> 1116
    //   841: getstatic ft.ai : I
    //   844: iconst_5
    //   845: irem
    //   846: ifne -> 1116
    //   849: aload_1
    //   850: getfield br : I
    //   853: bipush #100
    //   855: imul
    //   856: aload_1
    //   857: getfield bs : I
    //   860: idiv
    //   861: getstatic ah.e : [I
    //   864: iconst_0
    //   865: iaload
    //   866: if_icmpge -> 984
    //   869: getstatic bq.w : [[Lao;
    //   872: getstatic bq.d : I
    //   875: aaload
    //   876: iconst_4
    //   877: aaload
    //   878: dup
    //   879: astore_2
    //   880: getfield b : B
    //   883: getstatic ao.f : B
    //   886: if_icmpne -> 984
    //   889: aload_2
    //   890: getfield c : B
    //   893: ifne -> 984
    //   896: iconst_4
    //   897: aload_2
    //   898: getfield a : S
    //   901: invokestatic a : (IS)Lbw;
    //   904: dup
    //   905: astore_3
    //   906: ifnull -> 984
    //   909: aload_3
    //   910: getfield L : B
    //   913: iconst_2
    //   914: if_icmpge -> 984
    //   917: getstatic bq.s : [Lad;
    //   920: aload_3
    //   921: getfield L : B
    //   924: aaload
    //   925: getfield b : I
    //   928: ifgt -> 984
    //   931: invokestatic a : ()Lq;
    //   934: aload_3
    //   935: getfield O : I
    //   938: i2s
    //   939: invokevirtual e : (S)V
    //   942: getstatic bq.s : [Lad;
    //   945: aload_3
    //   946: getfield L : B
    //   949: aaload
    //   950: sipush #2000
    //   953: putfield b : I
    //   956: getstatic bq.s : [Lad;
    //   959: aload_3
    //   960: getfield L : B
    //   963: aaload
    //   964: sipush #2000
    //   967: putfield c : I
    //   970: getstatic bq.s : [Lad;
    //   973: aload_3
    //   974: getfield L : B
    //   977: aaload
    //   978: invokestatic a : ()J
    //   981: putfield a : J
    //   984: aload_1
    //   985: getfield bt : I
    //   988: bipush #100
    //   990: imul
    //   991: aload_1
    //   992: getfield bu : I
    //   995: idiv
    //   996: getstatic ah.e : [I
    //   999: iconst_1
    //   1000: iaload
    //   1001: if_icmpge -> 1116
    //   1004: getstatic bq.w : [[Lao;
    //   1007: getstatic bq.d : I
    //   1010: aaload
    //   1011: iconst_3
    //   1012: aaload
    //   1013: dup
    //   1014: astore_2
    //   1015: ifnull -> 1116
    //   1018: aload_2
    //   1019: getfield b : B
    //   1022: getstatic ao.f : B
    //   1025: if_icmpne -> 1116
    //   1028: aload_2
    //   1029: getfield c : B
    //   1032: iconst_1
    //   1033: if_icmpne -> 1116
    //   1036: iconst_4
    //   1037: aload_2
    //   1038: getfield a : S
    //   1041: invokestatic a : (IS)Lbw;
    //   1044: dup
    //   1045: astore_3
    //   1046: ifnull -> 1116
    //   1049: getstatic bq.s : [Lad;
    //   1052: aload_3
    //   1053: getfield L : B
    //   1056: aaload
    //   1057: getfield b : I
    //   1060: ifgt -> 1116
    //   1063: invokestatic a : ()Lq;
    //   1066: aload_3
    //   1067: getfield O : I
    //   1070: i2s
    //   1071: invokevirtual e : (S)V
    //   1074: getstatic bq.s : [Lad;
    //   1077: aload_3
    //   1078: getfield L : B
    //   1081: aaload
    //   1082: sipush #2000
    //   1085: putfield b : I
    //   1088: getstatic bq.s : [Lad;
    //   1091: aload_3
    //   1092: getfield L : B
    //   1095: aaload
    //   1096: sipush #2000
    //   1099: putfield c : I
    //   1102: getstatic bq.s : [Lad;
    //   1105: aload_3
    //   1106: getfield L : B
    //   1109: aaload
    //   1110: invokestatic a : ()J
    //   1113: putfield a : J
    //   1116: aload_1
    //   1117: getfield cz : I
    //   1120: iconst_m1
    //   1121: if_icmpeq -> 1259
    //   1124: aload_1
    //   1125: getfield aY : I
    //   1128: aload_1
    //   1129: getfield bl : I
    //   1132: isub
    //   1133: invokestatic e : (I)I
    //   1136: iconst_4
    //   1137: if_icmpgt -> 1213
    //   1140: aload_1
    //   1141: getfield aZ : I
    //   1144: aload_1
    //   1145: getfield bm : I
    //   1148: isub
    //   1149: invokestatic e : (I)I
    //   1152: iconst_4
    //   1153: if_icmpgt -> 1213
    //   1156: aload_1
    //   1157: dup
    //   1158: getfield bE : I
    //   1161: iconst_1
    //   1162: iadd
    //   1163: putfield bE : I
    //   1166: aload_1
    //   1167: aconst_null
    //   1168: putfield cN : [S
    //   1171: aload_1
    //   1172: getfield dh : Ldh;
    //   1175: aload_1
    //   1176: aload_1
    //   1177: getfield cR : Les;
    //   1180: aload_1
    //   1181: getfield cz : I
    //   1184: iconst_m1
    //   1185: invokevirtual a : (Lez;Les;IB)V
    //   1188: aload_1
    //   1189: getfield bE : I
    //   1192: iconst_5
    //   1193: if_icmple -> 1213
    //   1196: aload_1
    //   1197: getfield dh : Ldh;
    //   1200: invokevirtual b : ()V
    //   1203: aload_1
    //   1204: iconst_0
    //   1205: putfield bE : I
    //   1208: aload_1
    //   1209: iconst_m1
    //   1210: putfield cz : I
    //   1213: aload_1
    //   1214: getfield cN : [S
    //   1217: ifnonnull -> 1264
    //   1220: aload_1
    //   1221: getfield aY : I
    //   1224: aload_1
    //   1225: getfield bl : I
    //   1228: isub
    //   1229: invokestatic e : (I)I
    //   1232: iconst_4
    //   1233: if_icmpgt -> 1252
    //   1236: aload_1
    //   1237: getfield aZ : I
    //   1240: aload_1
    //   1241: getfield bm : I
    //   1244: isub
    //   1245: invokestatic e : (I)I
    //   1248: iconst_4
    //   1249: if_icmple -> 1264
    //   1252: aload_1
    //   1253: invokevirtual L : ()V
    //   1256: goto -> 1264
    //   1259: aload_1
    //   1260: iconst_0
    //   1261: putfield bE : I
    //   1264: aload_1
    //   1265: getfield br : I
    //   1268: ifgt -> 1479
    //   1271: aload_1
    //   1272: getfield cF : I
    //   1275: iconst_4
    //   1276: if_icmpeq -> 1479
    //   1279: aload_1
    //   1280: invokevirtual N : ()V
    //   1283: aload_1
    //   1284: iconst_4
    //   1285: putfield cF : I
    //   1288: getstatic cs.w : B
    //   1291: iconst_1
    //   1292: if_icmpne -> 1334
    //   1295: invokestatic b : ()Lcn;
    //   1298: getstatic bq.c : Lbt;
    //   1301: putfield aa : Lbt;
    //   1304: getstatic bq.c : Lbt;
    //   1307: getstatic ft.Y : I
    //   1310: getstatic ft.X : I
    //   1313: getstatic bt.k : I
    //   1316: iconst_2
    //   1317: idiv
    //   1318: isub
    //   1319: iconst_2
    //   1320: isub
    //   1321: aconst_null
    //   1322: getstatic bq.c : Lbt;
    //   1325: getfield a : Ljava/lang/String;
    //   1328: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1331: goto -> 1466
    //   1334: getstatic cs.w : B
    //   1337: iconst_2
    //   1338: if_icmpne -> 1380
    //   1341: invokestatic b : ()Lcn;
    //   1344: getstatic bq.b : Lbt;
    //   1347: putfield aa : Lbt;
    //   1350: getstatic bq.b : Lbt;
    //   1353: getstatic ft.Y : I
    //   1356: getstatic ft.X : I
    //   1359: getstatic bt.k : I
    //   1362: iconst_2
    //   1363: idiv
    //   1364: isub
    //   1365: iconst_2
    //   1366: isub
    //   1367: aconst_null
    //   1368: getstatic bq.b : Lbt;
    //   1371: getfield a : Ljava/lang/String;
    //   1374: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1377: goto -> 1466
    //   1380: invokestatic i : ()Z
    //   1383: ifne -> 1466
    //   1386: invokestatic b : ()Lcn;
    //   1389: getstatic bq.b : Lbt;
    //   1392: putfield Y : Lbt;
    //   1395: invokestatic b : ()Lcn;
    //   1398: getstatic bq.c : Lbt;
    //   1401: putfield Z : Lbt;
    //   1404: getstatic bq.b : Lbt;
    //   1407: getstatic bt.j : I
    //   1410: iconst_2
    //   1411: idiv
    //   1412: getstatic ft.X : I
    //   1415: getstatic bt.k : I
    //   1418: iconst_2
    //   1419: idiv
    //   1420: isub
    //   1421: iconst_2
    //   1422: isub
    //   1423: aconst_null
    //   1424: getstatic bq.b : Lbt;
    //   1427: getfield a : Ljava/lang/String;
    //   1430: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1433: getstatic bq.c : Lbt;
    //   1436: getstatic ft.W : I
    //   1439: getstatic bt.j : I
    //   1442: iconst_2
    //   1443: idiv
    //   1444: isub
    //   1445: getstatic ft.X : I
    //   1448: getstatic bt.k : I
    //   1451: iconst_2
    //   1452: idiv
    //   1453: isub
    //   1454: iconst_2
    //   1455: isub
    //   1456: aconst_null
    //   1457: getstatic bq.c : Lbt;
    //   1460: getfield a : Ljava/lang/String;
    //   1463: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1466: bipush #11
    //   1468: aload_1
    //   1469: getfield aY : I
    //   1472: aload_1
    //   1473: getfield aZ : I
    //   1476: invokestatic a : (III)V
    //   1479: aload_1
    //   1480: getfield M : Lew;
    //   1483: ifnonnull -> 1900
    //   1486: aload_1
    //   1487: getfield cF : I
    //   1490: iconst_4
    //   1491: if_icmpne -> 1723
    //   1494: invokestatic i : ()Z
    //   1497: ifne -> 1723
    //   1500: getstatic cs.w : B
    //   1503: iconst_1
    //   1504: if_icmpne -> 1558
    //   1507: invokestatic b : ()Lcn;
    //   1510: getfield aa : Lbt;
    //   1513: getstatic bq.c : Lbt;
    //   1516: if_acmpeq -> 1900
    //   1519: invokestatic b : ()Lcn;
    //   1522: getstatic bq.c : Lbt;
    //   1525: putfield aa : Lbt;
    //   1528: getstatic bq.c : Lbt;
    //   1531: getstatic ft.Y : I
    //   1534: getstatic ft.X : I
    //   1537: getstatic bt.k : I
    //   1540: iconst_2
    //   1541: idiv
    //   1542: isub
    //   1543: iconst_2
    //   1544: isub
    //   1545: aconst_null
    //   1546: getstatic bq.c : Lbt;
    //   1549: getfield a : Ljava/lang/String;
    //   1552: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1555: goto -> 1900
    //   1558: getstatic cs.w : B
    //   1561: iconst_2
    //   1562: if_icmpne -> 1616
    //   1565: invokestatic b : ()Lcn;
    //   1568: getfield aa : Lbt;
    //   1571: getstatic bq.b : Lbt;
    //   1574: if_acmpeq -> 1900
    //   1577: invokestatic b : ()Lcn;
    //   1580: getstatic bq.b : Lbt;
    //   1583: putfield aa : Lbt;
    //   1586: getstatic bq.b : Lbt;
    //   1589: getstatic ft.Y : I
    //   1592: getstatic ft.X : I
    //   1595: getstatic bt.k : I
    //   1598: iconst_2
    //   1599: idiv
    //   1600: isub
    //   1601: iconst_2
    //   1602: isub
    //   1603: aconst_null
    //   1604: getstatic bq.b : Lbt;
    //   1607: getfield a : Ljava/lang/String;
    //   1610: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1613: goto -> 1900
    //   1616: invokestatic b : ()Lcn;
    //   1619: getfield Y : Lbt;
    //   1622: getstatic bq.b : Lbt;
    //   1625: if_acmpeq -> 1666
    //   1628: invokestatic b : ()Lcn;
    //   1631: getstatic bq.b : Lbt;
    //   1634: putfield Y : Lbt;
    //   1637: getstatic bq.b : Lbt;
    //   1640: getstatic bt.j : I
    //   1643: iconst_2
    //   1644: idiv
    //   1645: getstatic ft.X : I
    //   1648: getstatic bt.k : I
    //   1651: iconst_2
    //   1652: idiv
    //   1653: isub
    //   1654: iconst_2
    //   1655: isub
    //   1656: aconst_null
    //   1657: getstatic bq.b : Lbt;
    //   1660: getfield a : Ljava/lang/String;
    //   1663: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1666: invokestatic b : ()Lcn;
    //   1669: getfield Z : Lbt;
    //   1672: getstatic bq.c : Lbt;
    //   1675: if_acmpeq -> 1900
    //   1678: invokestatic b : ()Lcn;
    //   1681: getstatic bq.c : Lbt;
    //   1684: putfield Z : Lbt;
    //   1687: getstatic bq.c : Lbt;
    //   1690: getstatic ft.W : I
    //   1693: getstatic bt.j : I
    //   1696: iconst_2
    //   1697: idiv
    //   1698: isub
    //   1699: getstatic ft.X : I
    //   1702: getstatic bt.k : I
    //   1705: iconst_2
    //   1706: idiv
    //   1707: isub
    //   1708: iconst_2
    //   1709: isub
    //   1710: aconst_null
    //   1711: getstatic bq.c : Lbt;
    //   1714: getfield a : Ljava/lang/String;
    //   1717: invokevirtual a : (IILce;Ljava/lang/String;)V
    //   1720: goto -> 1900
    //   1723: getstatic ft.A : Z
    //   1726: ifeq -> 1828
    //   1729: getstatic cs.w : B
    //   1732: iconst_1
    //   1733: if_icmpne -> 1758
    //   1736: invokestatic b : ()Lcn;
    //   1739: getfield aa : Lbt;
    //   1742: getstatic bq.c : Lbt;
    //   1745: if_acmpne -> 1900
    //   1748: invokestatic b : ()Lcn;
    //   1751: aconst_null
    //   1752: putfield aa : Lbt;
    //   1755: goto -> 1900
    //   1758: getstatic cs.w : B
    //   1761: iconst_2
    //   1762: if_icmpne -> 1787
    //   1765: invokestatic b : ()Lcn;
    //   1768: getfield aa : Lbt;
    //   1771: getstatic bq.b : Lbt;
    //   1774: if_acmpne -> 1900
    //   1777: invokestatic b : ()Lcn;
    //   1780: aconst_null
    //   1781: putfield aa : Lbt;
    //   1784: goto -> 1900
    //   1787: invokestatic b : ()Lcn;
    //   1790: getfield Y : Lbt;
    //   1793: getstatic bq.b : Lbt;
    //   1796: if_acmpne -> 1806
    //   1799: invokestatic b : ()Lcn;
    //   1802: aconst_null
    //   1803: putfield Y : Lbt;
    //   1806: invokestatic b : ()Lcn;
    //   1809: getfield Z : Lbt;
    //   1812: getstatic bq.c : Lbt;
    //   1815: if_acmpne -> 1900
    //   1818: invokestatic b : ()Lcn;
    //   1821: aconst_null
    //   1822: putfield Z : Lbt;
    //   1825: goto -> 1900
    //   1828: aload_1
    //   1829: getfield aa : Lbt;
    //   1832: getstatic bq.b : Lbt;
    //   1835: if_acmpne -> 1843
    //   1838: aload_1
    //   1839: aconst_null
    //   1840: putfield aa : Lbt;
    //   1843: invokestatic b : ()Lcn;
    //   1846: getfield Z : Lbt;
    //   1849: ifnull -> 1864
    //   1852: invokestatic b : ()Lcn;
    //   1855: getfield Z : Lbt;
    //   1858: getstatic bq.a : Lbt;
    //   1861: if_acmpeq -> 1873
    //   1864: invokestatic b : ()Lcn;
    //   1867: getstatic bq.a : Lbt;
    //   1870: putfield Z : Lbt;
    //   1873: invokestatic b : ()Lcn;
    //   1876: getfield Y : Lbt;
    //   1879: invokestatic b : ()Lcn;
    //   1882: getfield r : Lbt;
    //   1885: if_acmpeq -> 1900
    //   1888: invokestatic b : ()Lcn;
    //   1891: invokestatic b : ()Lcn;
    //   1894: getfield r : Lbt;
    //   1897: putfield Y : Lbt;
    //   1900: aload_1
    //   1901: getfield cN : [S
    //   1904: ifnull -> 2108
    //   1907: aload_1
    //   1908: getfield bH : Z
    //   1911: ifne -> 3610
    //   1914: aload_1
    //   1915: getfield aY : I
    //   1918: aload_1
    //   1919: getfield bf : I
    //   1922: isub
    //   1923: invokestatic e : (I)I
    //   1926: bipush #6
    //   1928: if_icmpgt -> 2101
    //   1931: aload_1
    //   1932: getfield aZ : I
    //   1935: aload_1
    //   1936: getfield bg : I
    //   1939: isub
    //   1940: invokestatic e : (I)I
    //   1943: bipush #6
    //   1945: if_icmpgt -> 2101
    //   1948: aload_1
    //   1949: getfield cI : I
    //   1952: aload_1
    //   1953: getfield cN : [S
    //   1956: arraylength
    //   1957: iconst_1
    //   1958: isub
    //   1959: if_icmple -> 1989
    //   1962: aload_1
    //   1963: iconst_0
    //   1964: putfield cI : I
    //   1967: aload_1
    //   1968: aconst_null
    //   1969: putfield cN : [S
    //   1972: iconst_0
    //   1973: putstatic bq.er : I
    //   1976: aload_1
    //   1977: iconst_0
    //   1978: putfield cl : I
    //   1981: aload_1
    //   1982: iconst_0
    //   1983: putfield cm : I
    //   1986: goto -> 2101
    //   1989: aload_1
    //   1990: getfield cI : I
    //   1993: aload_1
    //   1994: getfield cN : [S
    //   1997: arraylength
    //   1998: iconst_1
    //   1999: isub
    //   2000: if_icmpne -> 2036
    //   2003: aload_1
    //   2004: getfield cl : I
    //   2007: ifle -> 2036
    //   2010: aload_1
    //   2011: getfield cm : I
    //   2014: ifle -> 2036
    //   2017: aload_1
    //   2018: aload_1
    //   2019: getfield cl : I
    //   2022: putfield bf : I
    //   2025: aload_1
    //   2026: aload_1
    //   2027: getfield cm : I
    //   2030: putfield bg : I
    //   2033: goto -> 2091
    //   2036: aload_1
    //   2037: getfield cN : [S
    //   2040: aload_1
    //   2041: getfield cI : I
    //   2044: saload
    //   2045: bipush #8
    //   2047: ishr
    //   2048: i2b
    //   2049: istore_2
    //   2050: aload_1
    //   2051: getfield cN : [S
    //   2054: aload_1
    //   2055: getfield cI : I
    //   2058: saload
    //   2059: i2b
    //   2060: istore_3
    //   2061: aload_1
    //   2062: iload_2
    //   2063: getstatic cs.l : I
    //   2066: imul
    //   2067: getstatic cs.l : I
    //   2070: iconst_2
    //   2071: idiv
    //   2072: iadd
    //   2073: putfield bf : I
    //   2076: aload_1
    //   2077: iload_3
    //   2078: getstatic cs.l : I
    //   2081: imul
    //   2082: getstatic cs.l : I
    //   2085: iconst_2
    //   2086: idiv
    //   2087: iadd
    //   2088: putfield bg : I
    //   2091: aload_1
    //   2092: dup
    //   2093: getfield cI : I
    //   2096: iconst_1
    //   2097: iadd
    //   2098: putfield cI : I
    //   2101: aload_1
    //   2102: invokevirtual h : ()V
    //   2105: goto -> 2168
    //   2108: getstatic bq.n : Z
    //   2111: ifne -> 2134
    //   2114: iconst_1
    //   2115: putstatic bq.n : Z
    //   2118: aload_1
    //   2119: aload_1
    //   2120: getfield aY : I
    //   2123: putfield cj : I
    //   2126: aload_1
    //   2127: aload_1
    //   2128: getfield aZ : I
    //   2131: putfield ck : I
    //   2134: getstatic bq.m : Z
    //   2137: ifeq -> 2168
    //   2140: getstatic cn.p : Lfb;
    //   2143: iconst_0
    //   2144: bipush #-4
    //   2146: invokevirtual d : (II)Z
    //   2149: ifne -> 2168
    //   2152: getstatic cn.p : Lfb;
    //   2155: iconst_0
    //   2156: bipush #-2
    //   2158: invokevirtual d : (II)Z
    //   2161: ifne -> 2168
    //   2164: iconst_0
    //   2165: putstatic bq.m : Z
    //   2168: aload_1
    //   2169: getfield cj : I
    //   2172: aload_1
    //   2173: getfield ck : I
    //   2176: aload_1
    //   2177: getfield aY : I
    //   2180: aload_1
    //   2181: getfield aZ : I
    //   2184: invokestatic c : (IIII)I
    //   2187: istore_2
    //   2188: iconst_0
    //   2189: istore_3
    //   2190: invokestatic a : ()J
    //   2193: aload_1
    //   2194: getfield el : J
    //   2197: lsub
    //   2198: ldc2_w 250
    //   2201: lcmp
    //   2202: ifle -> 2213
    //   2205: getstatic bq.er : I
    //   2208: ifgt -> 2213
    //   2211: iconst_1
    //   2212: istore_3
    //   2213: aload_1
    //   2214: getfield cN : [S
    //   2217: ifnull -> 2237
    //   2220: invokestatic a : ()J
    //   2223: aload_1
    //   2224: getfield el : J
    //   2227: lsub
    //   2228: ldc2_w 250
    //   2231: lcmp
    //   2232: ifle -> 2237
    //   2235: iconst_1
    //   2236: istore_3
    //   2237: iload_3
    //   2238: ifne -> 2261
    //   2241: getstatic bq.er : I
    //   2244: bipush #20
    //   2246: if_icmple -> 2313
    //   2249: iload_2
    //   2250: iconst_5
    //   2251: if_icmplt -> 2313
    //   2254: aload_1
    //   2255: getfield cN : [S
    //   2258: ifnonnull -> 2313
    //   2261: getstatic bq.n : Z
    //   2264: ifeq -> 2297
    //   2267: aload_1
    //   2268: getfield dZ : Z
    //   2271: ifne -> 2297
    //   2274: invokestatic a : ()Lq;
    //   2277: aload_1
    //   2278: getfield aY : I
    //   2281: i2s
    //   2282: aload_1
    //   2283: getfield aZ : I
    //   2286: i2s
    //   2287: invokevirtual a : (SS)V
    //   2290: aload_1
    //   2291: invokestatic a : ()J
    //   2294: putfield el : J
    //   2297: aload_1
    //   2298: aload_1
    //   2299: getfield aY : I
    //   2302: putfield cj : I
    //   2305: aload_1
    //   2306: aload_1
    //   2307: getfield aZ : I
    //   2310: putfield ck : I
    //   2313: getstatic bq.q : Lbe;
    //   2316: ifnull -> 2772
    //   2319: getstatic ft.ai : I
    //   2322: iconst_5
    //   2323: irem
    //   2324: ifne -> 2772
    //   2327: aload_1
    //   2328: astore #4
    //   2330: getstatic ft.ai : I
    //   2333: sipush #200
    //   2336: irem
    //   2337: ifne -> 2452
    //   2340: getstatic bw.V : Les;
    //   2343: invokevirtual c : ()I
    //   2346: istore #6
    //   2348: getstatic bq.ej : Z
    //   2351: ifeq -> 2440
    //   2354: iload #6
    //   2356: getstatic bq.x : S
    //   2359: if_icmpge -> 2369
    //   2362: iconst_0
    //   2363: putstatic bq.ej : Z
    //   2366: goto -> 2452
    //   2369: getstatic df.dF : Ljava/lang/String;
    //   2372: invokestatic c : (Ljava/lang/String;)V
    //   2375: getstatic cn.h : Lez;
    //   2378: ifnull -> 2452
    //   2381: getstatic cn.h : Lez;
    //   2384: getfield cu : B
    //   2387: iconst_4
    //   2388: if_icmpeq -> 2432
    //   2391: getstatic cn.h : Lez;
    //   2394: getfield cu : B
    //   2397: iconst_3
    //   2398: if_icmpeq -> 2432
    //   2401: getstatic cn.h : Lez;
    //   2404: getfield cu : B
    //   2407: iconst_5
    //   2408: if_icmpeq -> 2432
    //   2411: getstatic cn.h : Lez;
    //   2414: getfield cu : B
    //   2417: bipush #7
    //   2419: if_icmpeq -> 2432
    //   2422: getstatic cn.h : Lez;
    //   2425: getfield cu : B
    //   2428: iconst_3
    //   2429: if_icmpne -> 2452
    //   2432: aload #4
    //   2434: invokespecial W : ()V
    //   2437: goto -> 2452
    //   2440: iload #6
    //   2442: getstatic bq.x : S
    //   2445: if_icmplt -> 2452
    //   2448: iconst_1
    //   2449: putstatic bq.ej : Z
    //   2452: iconst_0
    //   2453: istore #6
    //   2455: goto -> 2761
    //   2458: getstatic cn.i : Les;
    //   2461: iload #6
    //   2463: invokevirtual a : (I)Ljava/lang/Object;
    //   2466: checkcast ez
    //   2469: dup
    //   2470: astore #7
    //   2472: ifnull -> 2758
    //   2475: aload #7
    //   2477: getfield dy : Z
    //   2480: ifne -> 2758
    //   2483: aload #7
    //   2485: getfield cu : B
    //   2488: iconst_4
    //   2489: if_icmpeq -> 2520
    //   2492: aload #7
    //   2494: getfield cu : B
    //   2497: iconst_3
    //   2498: if_icmpeq -> 2520
    //   2501: aload #7
    //   2503: getfield cu : B
    //   2506: iconst_5
    //   2507: if_icmpeq -> 2520
    //   2510: aload #7
    //   2512: getfield cu : B
    //   2515: bipush #7
    //   2517: if_icmpne -> 2758
    //   2520: aload #7
    //   2522: dup
    //   2523: astore #5
    //   2525: getfield cu : B
    //   2528: tableswitch default -> 2700, 3 -> 2564, 4 -> 2598, 5 -> 2696, 6 -> 2700, 7 -> 2696
    //   2564: getstatic bq.ej : Z
    //   2567: ifne -> 2700
    //   2570: getstatic bq.q : Lbe;
    //   2573: getfield a : B
    //   2576: iconst_m1
    //   2577: if_icmpeq -> 2700
    //   2580: aload #5
    //   2582: getfield cs : B
    //   2585: getstatic bq.q : Lbe;
    //   2588: getfield a : B
    //   2591: if_icmplt -> 2700
    //   2594: iconst_1
    //   2595: goto -> 2701
    //   2598: aload #5
    //   2600: getfield cs : B
    //   2603: ifne -> 2631
    //   2606: getstatic bq.q : Lbe;
    //   2609: getfield c : B
    //   2612: getstatic be.e : B
    //   2615: if_icmpeq -> 2627
    //   2618: getstatic bq.q : Lbe;
    //   2621: getfield c : B
    //   2624: ifne -> 2700
    //   2627: iconst_1
    //   2628: goto -> 2701
    //   2631: aload #5
    //   2633: getfield cs : B
    //   2636: iconst_1
    //   2637: if_icmpne -> 2665
    //   2640: getstatic bq.q : Lbe;
    //   2643: getfield c : B
    //   2646: getstatic be.f : B
    //   2649: if_icmpeq -> 2661
    //   2652: getstatic bq.q : Lbe;
    //   2655: getfield c : B
    //   2658: ifne -> 2700
    //   2661: iconst_1
    //   2662: goto -> 2701
    //   2665: aload #5
    //   2667: getfield cs : B
    //   2670: iconst_2
    //   2671: if_icmpne -> 2678
    //   2674: iconst_1
    //   2675: goto -> 2701
    //   2678: aload #5
    //   2680: getfield cs : B
    //   2683: bipush #6
    //   2685: if_icmpne -> 2692
    //   2688: iconst_1
    //   2689: goto -> 2701
    //   2692: iconst_1
    //   2693: goto -> 2701
    //   2696: iconst_1
    //   2697: goto -> 2701
    //   2700: iconst_0
    //   2701: ifeq -> 2752
    //   2704: aload #4
    //   2706: getfield aY : I
    //   2709: aload #4
    //   2711: getfield aZ : I
    //   2714: aload #7
    //   2716: getfield aY : I
    //   2719: aload #7
    //   2721: getfield aZ : I
    //   2724: invokestatic c : (IIII)I
    //   2727: aload #4
    //   2729: getfield bh : I
    //   2732: if_icmpge -> 2752
    //   2735: invokestatic a : ()Lq;
    //   2738: aload #7
    //   2740: getfield ct : I
    //   2743: i2s
    //   2744: aload #7
    //   2746: getfield cu : B
    //   2749: invokevirtual a : (SB)V
    //   2752: aload #7
    //   2754: iconst_1
    //   2755: putfield dy : Z
    //   2758: iinc #6, 1
    //   2761: iload #6
    //   2763: getstatic cn.i : Les;
    //   2766: invokevirtual c : ()I
    //   2769: if_icmplt -> 2458
    //   2772: getstatic bq.o : B
    //   2775: iconst_1
    //   2776: if_icmpne -> 3466
    //   2779: aload_1
    //   2780: getfield cN : [S
    //   2783: ifnonnull -> 3466
    //   2786: getstatic bq.e : I
    //   2789: ifgt -> 2796
    //   2792: iconst_0
    //   2793: putstatic bq.o : B
    //   2796: getstatic bq.o : B
    //   2799: iconst_1
    //   2800: if_icmpne -> 2868
    //   2803: aload_1
    //   2804: getfield cF : I
    //   2807: ifne -> 2823
    //   2810: aload_1
    //   2811: dup
    //   2812: getfield en : I
    //   2815: iconst_1
    //   2816: iadd
    //   2817: putfield en : I
    //   2820: goto -> 2828
    //   2823: aload_1
    //   2824: iconst_0
    //   2825: putfield en : I
    //   2828: aload_1
    //   2829: getfield en : I
    //   2832: sipush #500
    //   2835: if_icmple -> 2868
    //   2838: getstatic df.aR : Ljava/lang/String;
    //   2841: invokestatic c : (Ljava/lang/String;)V
    //   2844: aload_1
    //   2845: iconst_m1
    //   2846: putfield cz : I
    //   2849: aload_1
    //   2850: iconst_m1
    //   2851: putfield cQ : I
    //   2854: aload_1
    //   2855: aconst_null
    //   2856: putfield cR : Les;
    //   2859: aload_1
    //   2860: iconst_0
    //   2861: putfield en : I
    //   2864: aload_1
    //   2865: invokespecial X : ()V
    //   2868: aload_1
    //   2869: getfield cF : I
    //   2872: iconst_2
    //   2873: if_icmpeq -> 3024
    //   2876: aload_1
    //   2877: getfield cF : I
    //   2880: iconst_4
    //   2881: if_icmpeq -> 3024
    //   2884: aload_1
    //   2885: getfield aY : I
    //   2888: aload_1
    //   2889: getfield aZ : I
    //   2892: getstatic bq.R : I
    //   2895: getstatic bq.S : I
    //   2898: invokestatic c : (IIII)I
    //   2901: aload_1
    //   2902: getfield bh : I
    //   2905: iconst_3
    //   2906: imul
    //   2907: iconst_2
    //   2908: idiv
    //   2909: if_icmpgt -> 2920
    //   2912: getstatic bq.eq : S
    //   2915: bipush #100
    //   2917: if_icmple -> 3024
    //   2920: aload_1
    //   2921: aload_1
    //   2922: getfield aY : I
    //   2925: putfield bf : I
    //   2928: aload_1
    //   2929: aload_1
    //   2930: getfield aZ : I
    //   2933: putfield bg : I
    //   2936: aload_1
    //   2937: getstatic bq.R : I
    //   2940: putfield cl : I
    //   2943: aload_1
    //   2944: getstatic bq.S : I
    //   2947: putfield cm : I
    //   2950: aload_1
    //   2951: getstatic ft.c : Lcn;
    //   2954: aload_1
    //   2955: getfield cl : I
    //   2958: getstatic cs.l : I
    //   2961: idiv
    //   2962: aload_1
    //   2963: getfield cm : I
    //   2966: getstatic cs.l : I
    //   2969: idiv
    //   2970: aload_1
    //   2971: getfield aY : I
    //   2974: getstatic cs.l : I
    //   2977: idiv
    //   2978: aload_1
    //   2979: getfield aZ : I
    //   2982: getstatic cs.l : I
    //   2985: idiv
    //   2986: bipush #20
    //   2988: invokevirtual a : (IIIII)[S
    //   2991: putfield cN : [S
    //   2994: iconst_m1
    //   2995: putstatic bq.O : I
    //   2998: iconst_m1
    //   2999: putstatic bq.P : I
    //   3002: aload_1
    //   3003: getfield cN : [S
    //   3006: ifnull -> 3024
    //   3009: aload_1
    //   3010: getfield cN : [S
    //   3013: arraylength
    //   3014: bipush #20
    //   3016: if_icmple -> 3024
    //   3019: aload_1
    //   3020: aconst_null
    //   3021: putfield cN : [S
    //   3024: aload_1
    //   3025: getfield cN : [S
    //   3028: ifnonnull -> 3455
    //   3031: aload_1
    //   3032: getfield cF : I
    //   3035: iconst_2
    //   3036: if_icmpeq -> 3455
    //   3039: aload_1
    //   3040: getfield cF : I
    //   3043: iconst_4
    //   3044: if_icmpeq -> 3455
    //   3047: aload_1
    //   3048: astore #4
    //   3050: invokestatic e : ()Z
    //   3053: ifeq -> 3455
    //   3056: invokestatic currentTimeMillis : ()J
    //   3059: lstore #6
    //   3061: getstatic cn.h : Lez;
    //   3064: dup
    //   3065: astore #5
    //   3067: ifnull -> 3104
    //   3070: aload #5
    //   3072: getfield cF : I
    //   3075: iconst_4
    //   3076: if_icmpeq -> 3104
    //   3079: aload #5
    //   3081: getfield cu : B
    //   3084: iconst_1
    //   3085: if_icmpne -> 3104
    //   3088: aload #5
    //   3090: getfield dy : Z
    //   3093: ifne -> 3104
    //   3096: aload #5
    //   3098: getfield dj : Z
    //   3101: ifeq -> 3126
    //   3104: aload #5
    //   3106: ifnull -> 3121
    //   3109: aload #5
    //   3111: getfield dj : Z
    //   3114: ifeq -> 3121
    //   3117: aconst_null
    //   3118: putstatic cn.h : Lez;
    //   3121: aload #4
    //   3123: invokevirtual q : ()V
    //   3126: getstatic cn.h : Lez;
    //   3129: ifnull -> 3152
    //   3132: getstatic cn.h : Lez;
    //   3135: getfield cu : B
    //   3138: iconst_1
    //   3139: if_icmpne -> 3152
    //   3142: getstatic cn.h : Lez;
    //   3145: getfield cx : B
    //   3148: iconst_2
    //   3149: if_icmpne -> 3155
    //   3152: goto -> 3455
    //   3155: getstatic bq.p : B
    //   3158: iconst_1
    //   3159: if_icmpne -> 3277
    //   3162: lload #6
    //   3164: aload #4
    //   3166: getfield ep : J
    //   3169: lsub
    //   3170: getstatic dh.h : I
    //   3173: i2l
    //   3174: ldiv
    //   3175: ldc2_w 2
    //   3178: lcmp
    //   3179: ifle -> 3277
    //   3182: aload #4
    //   3184: lload #6
    //   3186: putfield ep : J
    //   3189: iconst_0
    //   3190: istore #8
    //   3192: goto -> 3269
    //   3195: getstatic ah.f : [[I
    //   3198: iload #8
    //   3200: aaload
    //   3201: iconst_1
    //   3202: iaload
    //   3203: ifeq -> 3266
    //   3206: aload #4
    //   3208: getstatic ah.f : [[I
    //   3211: iload #8
    //   3213: aaload
    //   3214: iconst_0
    //   3215: iaload
    //   3216: iconst_m1
    //   3217: invokespecial j : (II)Z
    //   3220: ifeq -> 3266
    //   3223: getstatic ah.f : [[I
    //   3226: iload #8
    //   3228: aaload
    //   3229: iconst_0
    //   3230: iaload
    //   3231: invokestatic c : (I)Lev;
    //   3234: dup
    //   3235: astore #9
    //   3237: getfield e : B
    //   3240: iconst_1
    //   3241: if_icmpne -> 3266
    //   3244: aload #4
    //   3246: aload #9
    //   3248: getfield g : B
    //   3251: getstatic ah.f : [[I
    //   3254: iload #8
    //   3256: aaload
    //   3257: iconst_0
    //   3258: iaload
    //   3259: getstatic cn.h : Lez;
    //   3262: invokespecial a : (IILez;)Z
    //   3265: pop
    //   3266: iinc #8, 1
    //   3269: iload #8
    //   3271: getstatic ah.b : B
    //   3274: if_icmplt -> 3195
    //   3277: getstatic bq.eo : B
    //   3280: getstatic bq.w : [[Lao;
    //   3283: iconst_0
    //   3284: aaload
    //   3285: arraylength
    //   3286: iconst_1
    //   3287: isub
    //   3288: if_icmpge -> 3365
    //   3291: getstatic bq.eo : B
    //   3294: iconst_1
    //   3295: iadd
    //   3296: istore #8
    //   3298: goto -> 3354
    //   3301: getstatic bq.w : [[Lao;
    //   3304: getstatic bq.d : I
    //   3307: aaload
    //   3308: iload #8
    //   3310: aaload
    //   3311: dup
    //   3312: astore #9
    //   3314: getfield b : B
    //   3317: ifne -> 3351
    //   3320: aload #4
    //   3322: aload #9
    //   3324: getfield a : S
    //   3327: iconst_m1
    //   3328: invokespecial j : (II)Z
    //   3331: ifeq -> 3351
    //   3334: aload #4
    //   3336: iload #8
    //   3338: iconst_0
    //   3339: invokevirtual a : (IZ)V
    //   3342: iload #8
    //   3344: i2b
    //   3345: putstatic bq.eo : B
    //   3348: goto -> 3455
    //   3351: iinc #8, 1
    //   3354: iload #8
    //   3356: getstatic bq.w : [[Lao;
    //   3359: iconst_0
    //   3360: aaload
    //   3361: arraylength
    //   3362: if_icmplt -> 3301
    //   3365: getstatic bq.eo : B
    //   3368: ifle -> 3438
    //   3371: iconst_0
    //   3372: istore #8
    //   3374: goto -> 3430
    //   3377: getstatic bq.w : [[Lao;
    //   3380: getstatic bq.d : I
    //   3383: aaload
    //   3384: iload #8
    //   3386: aaload
    //   3387: dup
    //   3388: astore #9
    //   3390: getfield b : B
    //   3393: ifne -> 3427
    //   3396: aload #4
    //   3398: aload #9
    //   3400: getfield a : S
    //   3403: iconst_m1
    //   3404: invokespecial j : (II)Z
    //   3407: ifeq -> 3427
    //   3410: aload #4
    //   3412: iload #8
    //   3414: iconst_0
    //   3415: invokevirtual a : (IZ)V
    //   3418: iload #8
    //   3420: i2b
    //   3421: putstatic bq.eo : B
    //   3424: goto -> 3455
    //   3427: iinc #8, 1
    //   3430: iload #8
    //   3432: getstatic bq.eo : B
    //   3435: if_icmple -> 3377
    //   3438: aload #4
    //   3440: iconst_0
    //   3441: iconst_m1
    //   3442: invokespecial j : (II)Z
    //   3445: ifeq -> 3455
    //   3448: aload #4
    //   3450: iconst_m1
    //   3451: iconst_0
    //   3452: invokevirtual a : (IZ)V
    //   3455: aload_1
    //   3456: getfield cF : I
    //   3459: iconst_4
    //   3460: if_icmpne -> 3466
    //   3463: invokestatic o_ : ()V
    //   3466: getstatic cn.h : Lez;
    //   3469: ifnull -> 3488
    //   3472: getstatic cn.h : Lez;
    //   3475: getfield cu : B
    //   3478: putstatic bq.et : B
    //   3481: iconst_0
    //   3482: putstatic bq.eu : B
    //   3485: goto -> 3505
    //   3488: getstatic bq.eu : B
    //   3491: bipush #20
    //   3493: if_icmpge -> 3505
    //   3496: getstatic bq.eu : B
    //   3499: iconst_1
    //   3500: iadd
    //   3501: i2b
    //   3502: putstatic bq.eu : B
    //   3505: aload_1
    //   3506: getfield bb : I
    //   3509: ifne -> 3519
    //   3512: aload_1
    //   3513: getfield bc : I
    //   3516: ifeq -> 3531
    //   3519: getstatic bq.W : I
    //   3522: iconst_5
    //   3523: if_icmpge -> 3531
    //   3526: bipush #10
    //   3528: putstatic bq.W : I
    //   3531: getstatic bq.V : Z
    //   3534: ifne -> 3566
    //   3537: getstatic bq.W : I
    //   3540: iconst_5
    //   3541: if_icmple -> 3566
    //   3544: getstatic bq.W : I
    //   3547: iconst_1
    //   3548: iadd
    //   3549: dup
    //   3550: putstatic bq.W : I
    //   3553: bipush #60
    //   3555: if_icmple -> 3566
    //   3558: iconst_1
    //   3559: putstatic bq.V : Z
    //   3562: iconst_0
    //   3563: putstatic bq.W : I
    //   3566: getstatic bq.o : B
    //   3569: iconst_1
    //   3570: if_icmpne -> 3610
    //   3573: getstatic cn.h : Lez;
    //   3576: ifnull -> 3610
    //   3579: getstatic bq.R : I
    //   3582: getstatic bq.S : I
    //   3585: getstatic cn.h : Lez;
    //   3588: getfield aY : I
    //   3591: getstatic cn.h : Lez;
    //   3594: getfield aZ : I
    //   3597: invokestatic c : (IIII)I
    //   3600: sipush #240
    //   3603: if_icmple -> 3610
    //   3606: aload_1
    //   3607: invokevirtual q : ()V
    //   3610: aload_0
    //   3611: invokevirtual K : ()V
    //   3614: getstatic bq.N : Lw;
    //   3617: ifnull -> 3655
    //   3620: getstatic bq.N : Lw;
    //   3623: astore_1
    //   3624: iconst_0
    //   3625: istore_2
    //   3626: goto -> 3641
    //   3629: aload_1
    //   3630: getfield b : Les;
    //   3633: iload_2
    //   3634: invokevirtual a : (I)Ljava/lang/Object;
    //   3637: pop
    //   3638: iinc #2, 1
    //   3641: iload_2
    //   3642: aload_1
    //   3643: getfield b : Les;
    //   3646: invokevirtual c : ()I
    //   3649: if_icmplt -> 3629
    //   3652: goto -> 3655
    //   3655: iconst_0
    //   3656: istore_1
    //   3657: goto -> 3722
    //   3660: getstatic bq.r : [Lad;
    //   3663: iload_1
    //   3664: aaload
    //   3665: ifnull -> 3719
    //   3668: getstatic bq.r : [Lad;
    //   3671: iload_1
    //   3672: aaload
    //   3673: getfield b : I
    //   3676: sipush #-150
    //   3679: if_icmple -> 3719
    //   3682: getstatic bq.r : [Lad;
    //   3685: iload_1
    //   3686: aaload
    //   3687: dup
    //   3688: getfield b : I
    //   3691: invokestatic a : ()J
    //   3694: getstatic bq.r : [Lad;
    //   3697: iload_1
    //   3698: aaload
    //   3699: getfield a : J
    //   3702: lsub
    //   3703: l2i
    //   3704: isub
    //   3705: putfield b : I
    //   3708: getstatic bq.r : [Lad;
    //   3711: iload_1
    //   3712: aaload
    //   3713: invokestatic a : ()J
    //   3716: putfield a : J
    //   3719: iinc #1, 1
    //   3722: iload_1
    //   3723: getstatic bq.r : [Lad;
    //   3726: arraylength
    //   3727: if_icmplt -> 3660
    //   3730: iconst_0
    //   3731: istore_1
    //   3732: goto -> 3789
    //   3735: getstatic bq.s : [Lad;
    //   3738: iload_1
    //   3739: aaload
    //   3740: getfield b : I
    //   3743: sipush #-150
    //   3746: if_icmple -> 3786
    //   3749: getstatic bq.s : [Lad;
    //   3752: iload_1
    //   3753: aaload
    //   3754: dup
    //   3755: getfield b : I
    //   3758: invokestatic a : ()J
    //   3761: getstatic bq.s : [Lad;
    //   3764: iload_1
    //   3765: aaload
    //   3766: getfield a : J
    //   3769: lsub
    //   3770: l2i
    //   3771: isub
    //   3772: putfield b : I
    //   3775: getstatic bq.s : [Lad;
    //   3778: iload_1
    //   3779: aaload
    //   3780: invokestatic a : ()J
    //   3783: putfield a : J
    //   3786: iinc #1, 1
    //   3789: iload_1
    //   3790: getstatic bq.s : [Lad;
    //   3793: arraylength
    //   3794: if_icmplt -> 3735
    //   3797: aload_0
    //   3798: invokevirtual I : ()V
    //   3801: getstatic bq.h : I
    //   3804: ifle -> 3815
    //   3807: getstatic bq.h : I
    //   3810: iconst_1
    //   3811: isub
    //   3812: putstatic bq.h : I
    //   3815: aload_0
    //   3816: getfield bb : I
    //   3819: ifne -> 3829
    //   3822: aload_0
    //   3823: getfield bc : I
    //   3826: ifeq -> 3983
    //   3829: aload_0
    //   3830: getfield bF : Z
    //   3833: ifne -> 3983
    //   3836: getstatic ft.ai : I
    //   3839: iconst_3
    //   3840: irem
    //   3841: ifne -> 3983
    //   3844: aload_0
    //   3845: getfield cV : Z
    //   3848: ifne -> 3967
    //   3851: aload_0
    //   3852: getfield bK : Z
    //   3855: ifne -> 3967
    //   3858: aload_0
    //   3859: getfield cG : I
    //   3862: iconst_2
    //   3863: if_icmpne -> 3897
    //   3866: aload_0
    //   3867: getfield aY : I
    //   3870: iconst_0
    //   3871: iconst_3
    //   3872: invokestatic b : (II)I
    //   3875: iadd
    //   3876: aload_0
    //   3877: getfield aZ : I
    //   3880: iconst_0
    //   3881: iconst_3
    //   3882: invokestatic b : (II)I
    //   3885: iadd
    //   3886: iconst_0
    //   3887: aload_0
    //   3888: getfield cG : I
    //   3891: invokestatic b : (IIII)V
    //   3894: goto -> 3983
    //   3897: aload_0
    //   3898: getfield cG : I
    //   3901: iconst_3
    //   3902: if_icmpne -> 3936
    //   3905: aload_0
    //   3906: getfield aY : I
    //   3909: iconst_0
    //   3910: iconst_3
    //   3911: invokestatic b : (II)I
    //   3914: iadd
    //   3915: aload_0
    //   3916: getfield aZ : I
    //   3919: iconst_0
    //   3920: iconst_3
    //   3921: invokestatic b : (II)I
    //   3924: iadd
    //   3925: iconst_0
    //   3926: aload_0
    //   3927: getfield cG : I
    //   3930: invokestatic b : (IIII)V
    //   3933: goto -> 3983
    //   3936: aload_0
    //   3937: getfield aY : I
    //   3940: iconst_0
    //   3941: iconst_3
    //   3942: invokestatic b : (II)I
    //   3945: iadd
    //   3946: aload_0
    //   3947: getfield aZ : I
    //   3950: iconst_0
    //   3951: iconst_3
    //   3952: invokestatic b : (II)I
    //   3955: iadd
    //   3956: iconst_0
    //   3957: aload_0
    //   3958: getfield cG : I
    //   3961: invokestatic b : (IIII)V
    //   3964: goto -> 3983
    //   3967: aload_0
    //   3968: getfield aY : I
    //   3971: aload_0
    //   3972: getfield aZ : I
    //   3975: iconst_1
    //   3976: aload_0
    //   3977: getfield cG : I
    //   3980: invokestatic b : (IIII)V
    //   3983: aload_0
    //   3984: invokevirtual R : ()V
    //   3987: aload_0
    //   3988: invokevirtual S : ()V
    //   3991: aload_0
    //   3992: getfield em : Lcj;
    //   3995: ifnull -> 4021
    //   3998: aload_0
    //   3999: getfield em : Lcj;
    //   4002: aload_0
    //   4003: getfield aY : I
    //   4006: aload_0
    //   4007: getfield aZ : I
    //   4010: aload_0
    //   4011: getfield be : I
    //   4014: isub
    //   4015: bipush #30
    //   4017: isub
    //   4018: invokevirtual d : (II)V
    //   4021: aload_0
    //   4022: invokespecial a : ()V
    //   4025: aload_0
    //   4026: getfield ek : B
    //   4029: ifle -> 4049
    //   4032: aload_0
    //   4033: iconst_1
    //   4034: putfield B : Z
    //   4037: aload_0
    //   4038: dup
    //   4039: getfield ek : B
    //   4042: iconst_1
    //   4043: isub
    //   4044: i2b
    //   4045: putfield ek : B
    //   4048: return
    //   4049: aload_0
    //   4050: iconst_0
    //   4051: putfield B : Z
    //   4054: return
    //   4055: dup
    //   4056: astore_0
    //   4057: invokevirtual printStackTrace : ()V
    //   4060: return
    // Exception table:
    //   from	to	target	type
    //   0	4054	4055	java/lang/Exception
  }
  
  public final void q() {
    if (!X) {
      o = -1;
      return;
    } 
    int i = this.bh * 3 / 2;
    ez ez1 = null;
    for (byte b = 0; b < cn.i.c(); b++) {
      ez ez2;
      int j;
      if ((ez2 = (ez)cn.i.a(b)) != null && ez2.cF != 4 && !ez2.dy && ez2.cu == 1 && !ez2.x() && ((j = ez.c(this.aY, this.aZ, ez2.aY, ez2.aZ)) < i || ez2.cx == 2)) {
        i = j;
        ez1 = ez2;
        if (ez2.cx != 2)
          continue; 
        break;
      } 
      continue;
    } 
    if (ez1 != null) {
      cf.K = true;
      cn.h = ez1;
      eq = 0;
      return;
    } 
    cf.K = false;
    eq = (short)(eq + 1);
  }
  
  public final void r() {
    if (!H())
      return; 
    if (cs.i == cs.j)
      return; 
    if (m)
      return; 
    if (this.M != null) {
      if (!ft.o.a) {
        if (++es > 100) {
          this.M = null;
          (cn.b()).aa = null;
          ft.m();
          ft.S = false;
        } 
      } else {
        es = 0;
      } 
    } else {
      if (this.cF != 4 && !this.bF) {
        if (!this.bH && !this.dK && !this.dJ && !this.dZ && !this.bI && this.cF != 2 && this.cF != 3) {
          this.bb = 0;
          this.bc = 0;
          if (ft.e(2)) {
            if (!e_()) {
              this.cF = 1;
              this.cG = 2;
              this.bb = -(this.bi + Q());
              this.bc = 0;
              u();
              a(0);
            } else {
              es es;
              (es = new es()).a(new bt(df.ga, 4, this));
              es.a(new bt(df.as, 5, this));
              ft.a(df.v, es);
            } 
          } else if (ft.e(3)) {
            if (!e_()) {
              this.cF = 1;
              this.cG = 3;
              this.bb = this.bi + Q();
              this.bc = 0;
              u();
              a(0);
            } else {
              es es;
              (es = new es()).a(new bt(df.ga, 4, this));
              es.a(new bt(df.as, 5, this));
              ft.a(df.v, es);
            } 
          } else if (ft.e(1)) {
            if (!e_()) {
              this.cF = 1;
              this.cG = 1;
              this.bc = -(this.bi + Q());
              this.bb = 0;
              u();
              a(0);
            } else {
              es es;
              (es = new es()).a(new bt(df.ga, 4, this));
              es.a(new bt(df.as, 5, this));
              ft.a(df.v, es);
            } 
          } else if (ft.e(0)) {
            if (!e_()) {
              this.cF = 1;
              this.cG = 0;
              this.bc = this.bi + Q();
              this.bb = 0;
              u();
              a(0);
            } else {
              es es;
              (es = new es()).a(new bt(df.ga, 4, this));
              es.a(new bt(df.as, 5, this));
              ft.a(df.v, es);
            } 
          } 
          if (this.bb == 0 && this.bc == 0) {
            er++;
          } else {
            er = 0;
          } 
        } 
        if (ft.al[10] && !ft.A) {
          ft.d(10);
          d.b = !d.b;
        } 
        if (ft.al[11] && !ft.A) {
          ft.d(11);
          ft.h.g();
          ft.h.a(ft.a);
        } 
      } 
      if (ft.ak[21]) {
        a(0, true);
      } else if (ft.ak[23]) {
        a(1, true);
      } else if (ft.al[5] || ft.ak[25]) {
        a(2, true);
      } else if (ft.ak[27]) {
        a(3, true);
      } else if (ft.ak[29]) {
        a(4, true);
      } 
    } 
    if (ft.al[20]) {
      if ((cn.h == null || cn.h.cx != 2) && cf.C == 0)
        cf.C = 1; 
      ft.d(20);
    } 
  }
  
  private void W() {
    // Byte code:
    //   0: getstatic cn.h : Lez;
    //   3: ifnull -> 17
    //   6: getstatic cn.h : Lez;
    //   9: getfield cx : B
    //   12: iconst_2
    //   13: if_icmpne -> 17
    //   16: return
    //   17: iconst_0
    //   18: invokestatic a : (I)V
    //   21: aconst_null
    //   22: astore_1
    //   23: iconst_0
    //   24: istore_2
    //   25: iconst_0
    //   26: istore_3
    //   27: getstatic bq.V : Z
    //   30: ifeq -> 268
    //   33: iconst_0
    //   34: istore #4
    //   36: goto -> 257
    //   39: getstatic cn.i : Les;
    //   42: iload #4
    //   44: invokevirtual a : (I)Ljava/lang/Object;
    //   47: checkcast ez
    //   50: astore #5
    //   52: getstatic cn.q : Lcf;
    //   55: getstatic ft.p : Lcs;
    //   58: getfield d : I
    //   61: invokevirtual c : (I)Z
    //   64: ifeq -> 87
    //   67: aload #5
    //   69: getfield cv : B
    //   72: aload_0
    //   73: getfield cv : B
    //   76: if_icmpne -> 87
    //   79: aload #5
    //   81: getfield cu : B
    //   84: ifeq -> 254
    //   87: aload #5
    //   89: invokevirtual i_ : ()Z
    //   92: ifeq -> 254
    //   95: getstatic cn.h : Lez;
    //   98: ifnull -> 109
    //   101: aload #5
    //   103: getstatic cn.h : Lez;
    //   106: if_acmpeq -> 254
    //   109: aload #5
    //   111: getfield aY : I
    //   114: aload #5
    //   116: getfield aZ : I
    //   119: aload_0
    //   120: getfield aY : I
    //   123: aload_0
    //   124: getfield aZ : I
    //   127: invokestatic c : (IIII)I
    //   130: aload_0
    //   131: getfield bh : I
    //   134: if_icmpge -> 254
    //   137: aload #5
    //   139: astore_1
    //   140: aload_0
    //   141: iload #4
    //   143: putfield ev : I
    //   146: aload_1
    //   147: putstatic cn.h : Lez;
    //   150: getstatic ft.A : Z
    //   153: ifne -> 249
    //   156: aload_1
    //   157: getfield cu : B
    //   160: iconst_2
    //   161: if_icmpeq -> 212
    //   164: getstatic cn.h : Lez;
    //   167: ifnull -> 227
    //   170: getstatic cn.h : Lez;
    //   173: getfield cu : B
    //   176: ifne -> 227
    //   179: aload_0
    //   180: getstatic cn.h : Lez;
    //   183: invokevirtual b : (Lez;)Z
    //   186: ifne -> 227
    //   189: aload_0
    //   190: getfield cv : B
    //   193: iconst_m1
    //   194: if_icmpeq -> 212
    //   197: aload_0
    //   198: getfield cv : B
    //   201: bipush #10
    //   203: if_icmpeq -> 212
    //   206: invokestatic a : ()Z
    //   209: ifeq -> 227
    //   212: invokestatic b : ()Lcn;
    //   215: invokestatic b : ()Lcn;
    //   218: getfield s : Lbt;
    //   221: putfield aa : Lbt;
    //   224: goto -> 249
    //   227: invokestatic b : ()Lcn;
    //   230: getfield aa : Lbt;
    //   233: invokestatic b : ()Lcn;
    //   236: getfield s : Lbt;
    //   239: if_acmpne -> 249
    //   242: invokestatic b : ()Lcn;
    //   245: aconst_null
    //   246: putfield aa : Lbt;
    //   249: iconst_0
    //   250: putstatic bq.V : Z
    //   253: return
    //   254: iinc #4, 1
    //   257: iload #4
    //   259: getstatic cn.i : Les;
    //   262: invokevirtual c : ()I
    //   265: if_icmplt -> 39
    //   268: aconst_null
    //   269: astore_1
    //   270: iconst_m1
    //   271: istore_2
    //   272: iconst_m1
    //   273: istore_3
    //   274: iconst_0
    //   275: istore #4
    //   277: goto -> 779
    //   280: getstatic cn.i : Les;
    //   283: iload #4
    //   285: invokevirtual a : (I)Ljava/lang/Object;
    //   288: checkcast ez
    //   291: dup
    //   292: astore #5
    //   294: getstatic cn.f : Lbq;
    //   297: if_acmpeq -> 776
    //   300: aload #5
    //   302: getfield cF : I
    //   305: iconst_4
    //   306: if_icmpne -> 317
    //   309: aload #5
    //   311: getfield cu : B
    //   314: ifne -> 776
    //   317: aload_0
    //   318: aload #5
    //   320: astore #7
    //   322: astore #6
    //   324: invokestatic a : ()Z
    //   327: ifeq -> 334
    //   330: iconst_1
    //   331: goto -> 474
    //   334: aload #7
    //   336: getfield cu : B
    //   339: iconst_2
    //   340: if_icmpne -> 347
    //   343: iconst_1
    //   344: goto -> 474
    //   347: aload #6
    //   349: getfield cv : B
    //   352: iconst_m1
    //   353: if_icmpeq -> 366
    //   356: aload #6
    //   358: getfield cv : B
    //   361: bipush #10
    //   363: if_icmpne -> 370
    //   366: iconst_1
    //   367: goto -> 474
    //   370: aload #7
    //   372: getfield cu : B
    //   375: iconst_1
    //   376: if_icmpne -> 393
    //   379: aload #7
    //   381: getfield di : I
    //   384: bipush #7
    //   386: if_icmpne -> 393
    //   389: iconst_1
    //   390: goto -> 474
    //   393: aload #7
    //   395: invokevirtual D : ()Z
    //   398: ifeq -> 405
    //   401: iconst_1
    //   402: goto -> 474
    //   405: aload #7
    //   407: getfield cu : B
    //   410: ifne -> 473
    //   413: aload #7
    //   415: getfield cv : B
    //   418: ifeq -> 431
    //   421: aload #7
    //   423: getfield cv : B
    //   426: bipush #10
    //   428: if_icmpne -> 435
    //   431: iconst_1
    //   432: goto -> 474
    //   435: aload #7
    //   437: getfield cv : B
    //   440: aload #6
    //   442: getfield cv : B
    //   445: if_icmpeq -> 461
    //   448: aload #7
    //   450: getfield cv : B
    //   453: iconst_m1
    //   454: if_icmpeq -> 461
    //   457: iconst_1
    //   458: goto -> 474
    //   461: aload #6
    //   463: getfield cv : B
    //   466: ifne -> 473
    //   469: iconst_1
    //   470: goto -> 474
    //   473: iconst_0
    //   474: ifeq -> 776
    //   477: aload #5
    //   479: getfield cu : B
    //   482: bipush #9
    //   484: if_icmpeq -> 776
    //   487: aload #5
    //   489: getfield cu : B
    //   492: bipush #10
    //   494: if_icmpeq -> 776
    //   497: aload #5
    //   499: invokevirtual x : ()Z
    //   502: ifne -> 776
    //   505: aload #5
    //   507: getfield bI : Z
    //   510: ifne -> 776
    //   513: aload #5
    //   515: invokevirtual b : ()Z
    //   518: ifeq -> 776
    //   521: getstatic ft.p : Lcs;
    //   524: getfield d : I
    //   527: invokestatic e : (I)Z
    //   530: ifeq -> 549
    //   533: aload #5
    //   535: getfield cu : B
    //   538: ifne -> 549
    //   541: aload #5
    //   543: invokevirtual e_ : ()Z
    //   546: ifeq -> 776
    //   549: aload #5
    //   551: dup
    //   552: astore #6
    //   554: getfield cu : B
    //   557: iconst_4
    //   558: if_icmpeq -> 593
    //   561: aload #6
    //   563: getfield cu : B
    //   566: iconst_3
    //   567: if_icmpeq -> 593
    //   570: aload #6
    //   572: getfield cu : B
    //   575: iconst_5
    //   576: if_icmpeq -> 593
    //   579: aload #6
    //   581: getfield cu : B
    //   584: bipush #7
    //   586: if_icmpeq -> 593
    //   589: iconst_0
    //   590: goto -> 594
    //   593: iconst_1
    //   594: ifeq -> 603
    //   597: getstatic bq.q : Lbe;
    //   600: ifnonnull -> 776
    //   603: getstatic cn.h : Lez;
    //   606: ifnull -> 623
    //   609: aload #5
    //   611: getstatic cn.h : Lez;
    //   614: if_acmpne -> 623
    //   617: iload #4
    //   619: istore_3
    //   620: goto -> 665
    //   623: aload_1
    //   624: ifnull -> 631
    //   627: iload_3
    //   628: iflt -> 665
    //   631: aload #5
    //   633: getfield aY : I
    //   636: aload #5
    //   638: getfield aZ : I
    //   641: aload_0
    //   642: getfield aY : I
    //   645: aload_0
    //   646: getfield aZ : I
    //   649: invokestatic c : (IIII)I
    //   652: aload_0
    //   653: getfield bh : I
    //   656: if_icmpge -> 665
    //   659: aload #5
    //   661: astore_1
    //   662: iload #4
    //   664: istore_2
    //   665: iload_3
    //   666: iflt -> 776
    //   669: iload_2
    //   670: iload_3
    //   671: if_icmple -> 776
    //   674: aload_0
    //   675: iload #4
    //   677: putfield ev : I
    //   680: aload_1
    //   681: putstatic cn.h : Lez;
    //   684: getstatic ft.A : Z
    //   687: ifne -> 775
    //   690: aload_1
    //   691: getfield cu : B
    //   694: iconst_2
    //   695: if_icmpeq -> 740
    //   698: getstatic cn.h : Lez;
    //   701: getfield cu : B
    //   704: ifne -> 753
    //   707: aload_0
    //   708: getstatic cn.h : Lez;
    //   711: invokevirtual b : (Lez;)Z
    //   714: ifne -> 753
    //   717: aload_0
    //   718: getfield cv : B
    //   721: iconst_m1
    //   722: if_icmpeq -> 740
    //   725: aload_0
    //   726: getfield cv : B
    //   729: bipush #10
    //   731: if_icmpeq -> 740
    //   734: invokestatic a : ()Z
    //   737: ifeq -> 753
    //   740: invokestatic b : ()Lcn;
    //   743: invokestatic b : ()Lcn;
    //   746: getfield s : Lbt;
    //   749: putfield aa : Lbt;
    //   752: return
    //   753: invokestatic b : ()Lcn;
    //   756: getfield aa : Lbt;
    //   759: invokestatic b : ()Lcn;
    //   762: getfield s : Lbt;
    //   765: if_acmpne -> 775
    //   768: invokestatic b : ()Lcn;
    //   771: aconst_null
    //   772: putfield aa : Lbt;
    //   775: return
    //   776: iinc #4, 1
    //   779: iload #4
    //   781: getstatic cn.i : Les;
    //   784: invokevirtual c : ()I
    //   787: if_icmplt -> 280
    //   790: aload_1
    //   791: ifnull -> 889
    //   794: aload_1
    //   795: putstatic cn.h : Lez;
    //   798: getstatic ft.A : Z
    //   801: ifne -> 889
    //   804: aload_1
    //   805: getfield cu : B
    //   808: iconst_2
    //   809: if_icmpeq -> 854
    //   812: getstatic cn.h : Lez;
    //   815: getfield cu : B
    //   818: ifne -> 867
    //   821: aload_0
    //   822: getstatic cn.h : Lez;
    //   825: invokevirtual b : (Lez;)Z
    //   828: ifne -> 867
    //   831: aload_0
    //   832: getfield cv : B
    //   835: iconst_m1
    //   836: if_icmpeq -> 854
    //   839: aload_0
    //   840: getfield cv : B
    //   843: bipush #10
    //   845: if_icmpeq -> 854
    //   848: invokestatic a : ()Z
    //   851: ifeq -> 867
    //   854: invokestatic b : ()Lcn;
    //   857: invokestatic b : ()Lcn;
    //   860: getfield s : Lbt;
    //   863: putfield aa : Lbt;
    //   866: return
    //   867: invokestatic b : ()Lcn;
    //   870: getfield aa : Lbt;
    //   873: invokestatic b : ()Lcn;
    //   876: getfield s : Lbt;
    //   879: if_acmpne -> 889
    //   882: invokestatic b : ()Lcn;
    //   885: aconst_null
    //   886: putfield aa : Lbt;
    //   889: return
  }
  
  public final void a(int paramInt, boolean paramBoolean) {
    es es;
    ao ao1;
    ft.n();
    if (this.cF != 4 && cn.h != null && cn.h.cu == 1 && cn.h.cx == 2) {
      if (paramInt >= 0 && paramInt <= 5)
        q.a().f((byte)paramInt); 
      return;
    } 
    if (cn.h != null && cn.h.cu == 1) {
      if (cn.h.D()) {
        if (cn.h.f().equals(this.cB)) {
          (cn.b()).H.a();
          return;
        } 
        if (!cn.h.f().equals(this.cB)) {
          if (this.cv != 0 && !E())
            return; 
          if (this.cv == 11) {
            if (!cn.h.C())
              return; 
          } else if (this.cv == 12) {
            if (!cn.h.B())
              return; 
          } else if (this.cv == 13 && !cn.h.C()) {
            return;
          } 
        } 
      } 
      if (cn.h.l_()) {
        (cn.b()).J.a();
        return;
      } 
    } 
    if (paramInt == -1) {
      (ao1 = new ao()).a(0, 0, (byte)0);
    } else {
      ao1 = w[d][paramInt];
    } 
    if (ao1.b == ao.f) {
      bw bw;
      if ((bw = bw.a(4, ao1.a)) != null && bw.L < 2) {
        if ((s[bw.L]).b <= 0 && (bw.L != 0 || this.br != this.bs) && (bw.L != 1 || this.bt != this.bu)) {
          q.a().e((short)bw.O);
          (s[bw.L]).b = 2000;
          (s[bw.L]).c = 2000;
          (s[bw.L]).a = dw.a();
          return;
        } 
      } else if (cn.h != null && cn.h.cu == 2 && paramInt == 2) {
        (cn.b()).s.a();
        return;
      } 
      return;
    } 
    if (cn.h == null) {
      ev ev;
      if (ao1.b == 0 && j(ao1.a, paramInt) && (ev = ct.c(ao1.a)).e == 1 && (ev.g == 1 || ev.g == 2)) {
        this.cN = null;
        this.cQ = this.ct;
        es = new es("Player vec");
        bf bf = new bf((short)this.ct, this.cu);
        es.a(bf);
        this.dh.a(this, es, ao1.a, (byte)-1);
        return;
      } 
    } else {
      if (cn.h.cu == 3 || cn.h.cu == 4 || cn.h.cu == 5 || cn.h.cu == 7) {
        if (!cn.h.dy) {
          q.a().a((short)cn.h.ct, cn.h.cu);
          cn.h.dy = true;
        } 
        return;
      } 
      if (cn.h.cu == 2 && es == 2) {
        (cn.b()).s.a();
        return;
      } 
      if (this.cF == 2 || this.cF == 4 || this.M != null || this.bF) {
        if (this.cF == 4 && cn.h.cu == 0 && es == 2 && (this.cv == -1 || this.cv == 10 || cs.a()))
          (cn.b()).s.a(); 
        return;
      } 
      if (ao1.b == 0 && j(ao1.a, es)) {
        ev ev;
        if ((ev = ct.c(ao1.a)).e == 1) {
          if (a(ev.g, ao1.a, cn.h))
            return; 
        } else if (ev.e == 0 && cn.h.cF != 4 && cn.h.cu != 2) {
          if (b(cn.h)) {
            short s = ao1.a;
            (this = this).cN = null;
            if (cn.h != null) {
              this.cQ = cn.h.ct;
              es es1 = new es("Player vec8");
              bf bf = new bf((short)cn.h.ct, cn.h.cu);
              es1.a(bf);
              this.dh.a(this, es1, s, (byte)-1);
              System.currentTimeMillis();
              if (cn.h.cu == 1 && o == 0) {
                o = 1;
                X = true;
                R = this.aY;
                S = this.aZ;
              } 
            } 
            return;
          } 
          if (cn.h.cu == 1 && cn.h.di == 7 && this.cO != null && cn.h.cO != null && this.cO.b == cn.h.cO.b) {
            es = new es("Player vec2");
            bf bf = new bf((short)cn.h.ct, cn.h.cu);
            es.a(bf);
            dw.a("Att 1");
            q.a().a(es, (byte)0);
            if (o == 1)
              o_(); 
            return;
          } 
        } 
      } 
      if (cn.h != null && cn.h.cu == 0 && es == 2 && !b(cn.h)) {
        if (cn.h.e_()) {
          (cn.b()).I.a();
          return;
        } 
        if (this.cv == -1 || this.cv == 10 || cs.a()) {
          (cn.b()).s.a();
          return;
        } 
      } 
    } 
  }
  
  private boolean j(int paramInt1, int paramInt2) {
    if (I[paramInt1] - 1 < 0) {
      if (paramInt2 >= 0)
        if (paramInt2 == 2) {
          w[d][paramInt2].a(0, 0, (byte)0);
        } else {
          (w[d][paramInt2]).b = ao.d;
        }  
      return false;
    } 
    if ((r[paramInt1]).b > 0)
      return false; 
    paramInt2 = ((ct.c(paramInt1)).k[I[paramInt1] + J[paramInt1] - 1]).a;
    if (this.bt < paramInt2)
      return false; 
    if (this.ee == 0) {
      ft.c(df.T);
      return false;
    } 
    return !(this.cz == paramInt1);
  }
  
  public final es a(int paramInt, ez paramez) {
    es es = new es("Player vec7");
    bf bf = new bf((short)paramez.ct, paramez.cu);
    es.a(bf);
    byte b = paramez.cu;
    ev ev = ct.c(paramInt);
    if (I[ev.b] == 0)
      return es; 
    if (ev.e == 1) {
      this.dh.g = this.bx;
      if ((ev.k[I[ev.b] + J[ev.b] - 1]).j > 0 && (b == 0 || ev.g == 3)) {
        byte b1 = 1;
        for (byte b2 = 0; b2 < cn.i.c(); b2++) {
          ez ez1;
          if ((ez1 = (ez)cn.i.a(b2)).ct != paramez.ct && ez1 != cn.f && b == ez1.cu && ez1.cF != 4 && (b != 0 || ((ev.g != 3 || b(ez1)) && (ev.g != 2 || !b(ez1))))) {
            if (ez.c(paramez.aY, paramez.aZ, ez1.aY, ez1.aZ) <= (ev.k[I[ev.b] + J[ev.b] - 1]).f) {
              bf bf1 = new bf((short)ez1.ct, ez1.cu);
              es.a(bf1);
              b1++;
            } 
            if (b1 >= (ev.k[I[ev.b] + J[ev.b] - 1]).j)
              return es; 
          } 
        } 
      } 
    } else if ((ev.k[I[ev.b] + J[ev.b] - 1]).j > 1) {
      byte b1 = 1;
      for (byte b2 = 0; b2 < cn.i.c(); b2++) {
        ez ez1;
        if ((ez1 = (ez)cn.i.a(b2)).ct != paramez.ct && ez1 != cn.f && b == ez1.cu && ez1.cF != 4 && (b != 0 || b(ez1))) {
          if (ez.c(paramez.aY, paramez.aZ, ez1.aY, ez1.aZ) <= (ev.k[I[ev.b] + J[ev.b] - 1]).f) {
            bf bf1 = new bf((short)ez1.ct, ez1.cu);
            es.a(bf1);
            b1++;
          } 
          if (b1 >= (ev.k[I[ev.b] + J[ev.b] - 1]).j)
            return es; 
        } 
      } 
    } 
    return es;
  }
  
  public final void d(int paramInt1, int paramInt2) {
    if (paramInt1 == 35) {
      for (paramInt1 = 0; paramInt1 < H.length; paramInt1++) {
        (r[paramInt1]).b = 2000;
        (r[paramInt1]).c = 2000;
        (r[paramInt1]).a = dw.a();
      } 
      return;
    } 
    if (H[paramInt2] == paramInt1) {
      fc fc = (ct.c(paramInt2)).k[I[paramInt2] + J[paramInt2] - 1];
      (r[paramInt2]).b = fc.a();
      (r[paramInt2]).c = fc.a();
      (r[paramInt2]).a = dw.a();
      if (fc.a > 0)
        this.bt -= fc.a; 
      ev ev;
      if ((ev = ct.c(paramInt2)) != null && this.e == 0)
        (r[paramInt2]).d = true; 
    } 
  }
  
  public static void s() {
    for (byte b = 0; b < r.length; b++) {
      if ((r[b]).d)
        (r[b]).b = 0; 
    } 
  }
  
  public final void u() {
    if (this.cz != -1) {
      this.cz = -1;
      this.cN = null;
      this.bf = this.aY;
      this.bg = this.aZ;
      this.cl = 0;
      this.cm = 0;
    } 
  }
  
  public final boolean b(ez paramez) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual n : ()Z
    //   4: ifeq -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_1
    //   10: invokevirtual x : ()Z
    //   13: ifeq -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: invokestatic a : ()Z
    //   21: ifeq -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_1
    //   27: ifnonnull -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: getfield dJ : Z
    //   36: ifne -> 46
    //   39: aload_0
    //   40: getfield bI : Z
    //   43: ifeq -> 48
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: getfield dK : Z
    //   52: ifeq -> 57
    //   55: iconst_1
    //   56: ireturn
    //   57: aload_1
    //   58: getfield dZ : Z
    //   61: ifeq -> 66
    //   64: iconst_1
    //   65: ireturn
    //   66: aload_1
    //   67: getfield cu : B
    //   70: ifne -> 167
    //   73: aload_1
    //   74: getfield cy : B
    //   77: iconst_1
    //   78: if_icmpne -> 167
    //   81: aload_1
    //   82: getfield cv : B
    //   85: iconst_1
    //   86: if_icmplt -> 128
    //   89: aload_1
    //   90: getfield cv : B
    //   93: bipush #9
    //   95: if_icmpgt -> 128
    //   98: aload_0
    //   99: getfield cv : B
    //   102: iconst_1
    //   103: if_icmplt -> 128
    //   106: aload_0
    //   107: getfield cv : B
    //   110: bipush #9
    //   112: if_icmpgt -> 128
    //   115: aload_1
    //   116: getfield cv : B
    //   119: aload_0
    //   120: getfield cv : B
    //   123: if_icmpne -> 128
    //   126: iconst_0
    //   127: ireturn
    //   128: aload_1
    //   129: getfield cO : Lem;
    //   132: ifnull -> 163
    //   135: getstatic cn.f : Lbq;
    //   138: getfield cO : Lem;
    //   141: ifnull -> 163
    //   144: aload_1
    //   145: getfield cO : Lem;
    //   148: getfield b : I
    //   151: getstatic cn.f : Lbq;
    //   154: getfield cO : Lem;
    //   157: getfield b : I
    //   160: if_icmpeq -> 165
    //   163: iconst_1
    //   164: ireturn
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_0
    //   168: getfield cF : I
    //   171: iconst_4
    //   172: if_icmpeq -> 183
    //   175: aload_1
    //   176: getfield cF : I
    //   179: iconst_4
    //   180: if_icmpne -> 185
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_1
    //   186: getfield cu : B
    //   189: ifne -> 522
    //   192: aload_1
    //   193: getfield cv : B
    //   196: iconst_1
    //   197: if_icmplt -> 239
    //   200: aload_1
    //   201: getfield cv : B
    //   204: bipush #9
    //   206: if_icmpgt -> 239
    //   209: aload_0
    //   210: getfield cv : B
    //   213: iconst_1
    //   214: if_icmplt -> 239
    //   217: aload_0
    //   218: getfield cv : B
    //   221: bipush #9
    //   223: if_icmpgt -> 239
    //   226: aload_1
    //   227: getfield cv : B
    //   230: aload_0
    //   231: getfield cv : B
    //   234: if_icmpne -> 239
    //   237: iconst_0
    //   238: ireturn
    //   239: aload_0
    //   240: getfield cA : S
    //   243: sipush #2000
    //   246: if_icmplt -> 251
    //   249: iconst_0
    //   250: ireturn
    //   251: aload_0
    //   252: getfield cv : B
    //   255: bipush #12
    //   257: if_icmpne -> 280
    //   260: aload_1
    //   261: getfield cv : B
    //   264: bipush #13
    //   266: if_icmpeq -> 278
    //   269: aload_1
    //   270: getfield cv : B
    //   273: bipush #11
    //   275: if_icmpne -> 280
    //   278: iconst_1
    //   279: ireturn
    //   280: aload_0
    //   281: getfield cv : B
    //   284: bipush #12
    //   286: if_icmpne -> 300
    //   289: aload_1
    //   290: getfield cv : B
    //   293: bipush #12
    //   295: if_icmpne -> 300
    //   298: iconst_0
    //   299: ireturn
    //   300: aload_0
    //   301: getfield cv : B
    //   304: bipush #13
    //   306: if_icmpne -> 320
    //   309: aload_1
    //   310: getfield cv : B
    //   313: bipush #12
    //   315: if_icmpne -> 320
    //   318: iconst_1
    //   319: ireturn
    //   320: aload_0
    //   321: getfield cv : B
    //   324: bipush #13
    //   326: if_icmpne -> 349
    //   329: aload_1
    //   330: getfield cv : B
    //   333: bipush #13
    //   335: if_icmpeq -> 347
    //   338: aload_1
    //   339: getfield cv : B
    //   342: bipush #11
    //   344: if_icmpne -> 349
    //   347: iconst_0
    //   348: ireturn
    //   349: aload_0
    //   350: getfield cv : B
    //   353: bipush #11
    //   355: if_icmpne -> 369
    //   358: aload_1
    //   359: getfield cv : B
    //   362: bipush #12
    //   364: if_icmpne -> 369
    //   367: iconst_1
    //   368: ireturn
    //   369: aload_0
    //   370: getfield cv : B
    //   373: bipush #11
    //   375: if_icmpne -> 398
    //   378: aload_1
    //   379: getfield cv : B
    //   382: bipush #11
    //   384: if_icmpeq -> 396
    //   387: aload_1
    //   388: getfield cv : B
    //   391: bipush #13
    //   393: if_icmpne -> 398
    //   396: iconst_0
    //   397: ireturn
    //   398: aload_0
    //   399: getfield cv : B
    //   402: bipush #10
    //   404: if_icmpne -> 448
    //   407: aload_1
    //   408: getfield ct : I
    //   411: i2s
    //   412: istore_2
    //   413: iconst_0
    //   414: istore_3
    //   415: goto -> 434
    //   418: iload_2
    //   419: getstatic bq.T : [S
    //   422: iload_3
    //   423: saload
    //   424: if_icmpne -> 431
    //   427: iconst_1
    //   428: goto -> 443
    //   431: iinc #3, 1
    //   434: iload_3
    //   435: getstatic bq.T : [S
    //   438: arraylength
    //   439: if_icmplt -> 418
    //   442: iconst_0
    //   443: ifeq -> 448
    //   446: iconst_1
    //   447: ireturn
    //   448: aload_1
    //   449: getfield cv : B
    //   452: ifeq -> 464
    //   455: aload_1
    //   456: getfield cv : B
    //   459: bipush #10
    //   461: if_icmpne -> 466
    //   464: iconst_1
    //   465: ireturn
    //   466: aload_1
    //   467: getfield cv : B
    //   470: iconst_m1
    //   471: if_icmpeq -> 504
    //   474: aload_0
    //   475: getfield cv : B
    //   478: iconst_m1
    //   479: if_icmpeq -> 504
    //   482: aload_0
    //   483: getfield cv : B
    //   486: aload_1
    //   487: getfield cv : B
    //   490: if_icmpeq -> 504
    //   493: aload_0
    //   494: getfield cv : B
    //   497: bipush #10
    //   499: if_icmpeq -> 504
    //   502: iconst_1
    //   503: ireturn
    //   504: aload_1
    //   505: getfield by : S
    //   508: bipush #10
    //   510: if_icmple -> 588
    //   513: aload_0
    //   514: getfield cv : B
    //   517: ifne -> 588
    //   520: iconst_1
    //   521: ireturn
    //   522: getstatic bq.e : I
    //   525: ifgt -> 536
    //   528: getstatic df.dn : Ljava/lang/String;
    //   531: invokestatic c : (Ljava/lang/String;)V
    //   534: iconst_0
    //   535: ireturn
    //   536: aload_1
    //   537: getfield cu : B
    //   540: iconst_1
    //   541: if_icmpne -> 586
    //   544: aload_1
    //   545: getfield di : I
    //   548: bipush #7
    //   550: if_icmpne -> 586
    //   553: aload_0
    //   554: getfield cO : Lem;
    //   557: ifnull -> 586
    //   560: aload_1
    //   561: getfield cO : Lem;
    //   564: ifnull -> 586
    //   567: aload_0
    //   568: getfield cO : Lem;
    //   571: getfield b : I
    //   574: aload_1
    //   575: getfield cO : Lem;
    //   578: getfield b : I
    //   581: if_icmpne -> 586
    //   584: iconst_0
    //   585: ireturn
    //   586: iconst_1
    //   587: ireturn
    //   588: iconst_0
    //   589: ireturn
  }
  
  private void X() {
    if (o == 0) {
      o = 1;
      R = this.aY;
      S = this.aZ;
      h = 60;
      X = true;
      return;
    } 
    if (o == -1) {
      ft.ak[25] = true;
      ft.ak[5] = true;
      o = 1;
      R = this.aY;
      S = this.aZ;
      h = 60;
      X = false;
    } 
  }
  
  public final void v() {
    o = 1;
    R = this.aY;
    S = this.aZ;
    h = 60;
    X = true;
  }
  
  public final void m_() {
    if (cn.h == null)
      return; 
    if (cn.h.cx == 2)
      return; 
    if (cn.h.i_()) {
      (cn.b()).s.a();
      if (o == 1)
        o_(); 
      ft.S = false;
      return;
    } 
    if (cn.h.cu == 0) {
      if (b(cn.h)) {
        ao ao1;
        if ((ao1 = w[d][eo]).b != 0)
          for (byte b = 0; b < (w[d]).length; b++) {
            if ((ao1 = w[d][b]).b == 0) {
              eo = (byte)b;
              if (o == 1)
                o_(); 
              break;
            } 
          }  
        a(eo, false);
        return;
      } 
      if (cn.h.e_()) {
        (cn.b()).I.a();
        return;
      } 
      if (this.cv == -1 || this.cv == 10 || cs.a()) {
        (cn.b()).s.a(cn.h.aY - p.d.a, cn.h.aZ - p.d.b - cn.h.be - 30, cf.w, "");
        (cn.b()).s.l = cn.h.ct;
        cn.K = 60;
      } 
      return;
    } 
    if (cn.h.cu == 4 || cn.h.cu == 3 || cn.h.cu == 5 || cn.h.cu == 7) {
      if (!cn.h.dy) {
        q.a().a((short)cn.h.ct, cn.h.cu);
        cn.h.dy = true;
      } 
      return;
    } 
    if (cn.h.cu == 1) {
      if (cn.h.cF == 4)
        return; 
      if (cn.h.l_()) {
        (cn.b()).J.a();
        return;
      } 
      if (!cn.h.D()) {
        X();
        return;
      } 
      if (cn.h.D()) {
        if (cn.h.f().equals(this.cB)) {
          (cn.b()).H.a();
          return;
        } 
        if (!cn.h.f().equals(this.cB)) {
          if (this.cv == 0) {
            X();
            return;
          } 
          if (this.cv == 11 || this.cv == 13) {
            if (cn.h.C()) {
              X();
              return;
            } 
          } else if (this.cv == 12 && cn.h.B()) {
            X();
          } 
        } 
      } 
    } 
  }
  
  public final void n_() {
    N = null;
    this.M = null;
    this.dk = null;
  }
  
  private static void a(int paramInt) {
    if (o != -1) {
      if (X) {
        o = 0;
      } else {
        o = -1;
      } 
      if (o == 0) {
        R = -1;
        S = -1;
      } 
    } 
  }
  
  private boolean a(int paramInt1, int paramInt2, ez paramez) {
    es es;
    if (paramez == null) {
      this.cN = null;
      this.cQ = this.ct;
      es = new es("Player vec3");
      bf bf = new bf((short)this.ct, this.cu);
      es.a(bf);
      this.dh.a(this, es, paramInt2, (byte)-1);
      return true;
    } 
    if (es == 2) {
      this.cN = null;
      this.cQ = this.ct;
      es = new es("Player vec4");
      bf bf = null;
      if (paramez.cF == 4 || paramez.cu == 2 || this.cv == 0 || paramez.cv == 0 || paramez.cv == 10 || (paramez.cv != -1 && this.cv != -1 && this.cv != paramez.cv)) {
        bf = new bf((short)this.ct, this.cu);
      } else {
        bf = new bf((short)paramez.ct, paramez.cu);
      } 
      es.a(bf);
      this.dh.a(this, es, paramInt2, (byte)-1);
      return true;
    } 
    if (es == true) {
      this.cN = null;
      this.cQ = this.ct;
      es = new es("Player vec5");
      bf bf = new bf((short)this.ct, this.cu);
      es.a(bf);
      this.dh.a(this, es, paramInt2, (byte)-1);
      return true;
    } 
    if (es == 3 && paramez.cF != 4 && paramez.cu != 2 && b(paramez)) {
      this.cN = null;
      this.cQ = paramez.ct;
      es = new es("Player vec6");
      bf bf = new bf((short)paramez.ct, paramez.cu);
      es.a(bf);
      this.dh.a(this, es, paramInt2, (byte)-1);
      return true;
    } 
    return false;
  }
  
  public final boolean y() {
    return (cn.h == null) ? false : ((cn.h.cu == 2) ? true : ((cn.h.cu == 1 && (cn.h.cO == null || cn.f.cO == null || cn.h.cO.b != cn.f.cO.b)) ? false : (!b(cn.h))));
  }
  
  public final void h() {
    if (e_()) {
      this.bf = this.aY;
      this.bg = this.aZ;
      this.cN = null;
      es es;
      (es = new es()).a(new bt(df.ga, 4, this));
      es.a(new bt(df.as, 5, this));
      ft.a(df.v, es);
      return;
    } 
    if (!H() || this.bH) {
      this.bf = this.aY;
      this.bg = this.aZ;
      return;
    } 
    if (this.dZ)
      return; 
    if (this.aY != this.bf) {
      this.bc = 0;
      this.cF = 1;
      if (ak.e(this.aY - this.bf) > this.bi + Q()) {
        if (this.aY > this.bf) {
          this.bb = -(this.bi + Q());
          this.cH = this.cG;
          this.cG = 2;
          return;
        } 
        this.bb = this.bi + Q();
        this.cH = this.cG;
        this.cG = 3;
        return;
      } 
      if (ak.e(this.aY - this.bf) < this.bi + Q()) {
        if (this.aY > this.bf) {
          this.bb = -ak.e(this.aY - this.bf);
          this.cH = this.cG;
          this.cG = 2;
          return;
        } 
        this.bb = ak.e(this.aY - this.bf);
        this.cH = this.cG;
        this.cG = 3;
        return;
      } 
      if (this.aY > this.bf) {
        this.bb = -(this.bi + Q());
        this.cH = this.cG;
        this.cG = 2;
        return;
      } 
      this.bb = this.bi + Q();
      this.cH = this.cG;
      this.cG = 3;
      return;
    } 
    if (this.aZ != this.bg) {
      this.bb = 0;
      this.cF = 1;
      if (ak.e(this.aZ - this.bg) > this.bi + Q()) {
        if (this.aZ > this.bg) {
          this.bc = -(this.bi + Q());
          this.cH = this.cG;
          this.cG = 1;
          return;
        } 
        this.bc = this.bi + Q();
        this.cH = this.cG;
        this.cG = 0;
        return;
      } 
      if (ak.e(this.aZ - this.bg) < this.bi + Q()) {
        if (this.aZ > this.bg) {
          this.bc = -ak.e(this.aZ - this.bg);
          this.cH = this.cG;
          this.cG = 1;
          return;
        } 
        this.bc = ak.e(this.aZ - this.bg);
        this.cH = this.cG;
        this.cG = 0;
        return;
      } 
      if (this.aZ > this.bg) {
        this.bc = -(this.bi + Q());
        this.cH = this.cG;
        this.cG = 1;
        return;
      } 
      this.bc = this.bi + Q();
      this.cH = this.cG;
      this.cG = 0;
      return;
    } 
    this.bb = 0;
    this.bc = 0;
    this.cF = 0;
  }
  
  public final void c(int paramInt1, int paramInt2) {
    aa aa = new aa((byte)paramInt1, paramInt2);
    this.dw.a(aa);
  }
  
  public static void o_() {
    if (X) {
      o = 0;
      return;
    } 
    o = -1;
  }
  
  public final void k_() {
    this.em = null;
  }
  
  public final void b(String paramString) {
    if (this.em == null)
      this.em = new cj(); 
    this.em.a(paramString, this.cL);
    this.em.d(this.aY, this.aZ - this.be - 30);
  }
  
  public final boolean e_() {
    return (this.em != null);
  }
  
  static {
    for (byte b = 0; b < w.length; b++)
      w[b] = new ao[5]; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bq.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */