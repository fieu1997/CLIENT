public final class ea extends bw {
  public byte am;
  
  public byte an;
  
  public int ao;
  
  public short ap;
  
  public int aq;
  
  private int aw;
  
  public short ar;
  
  public short as;
  
  private short ax;
  
  private short ay;
  
  private short az;
  
  private short aA;
  
  public short at;
  
  public cz au;
  
  public short[] av;
  
  private boolean aB;
  
  public ea() {}
  
  public ea(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, cz[] paramArrayOfcz, int paramInt6, short paramShort, int paramInt7, byte paramByte1, byte paramByte2) {
    this.i = paramString;
    this.g = paramString;
    this.t = paramInt2;
    this.O = paramInt1;
    this.z = 0;
    if (this.z > 0)
      this.g = String.valueOf(this.g) + " +" + this.z; 
    this.N = paramInt3;
    this.M = paramInt4;
    this.u = 9;
    this.j = paramArrayOfcz;
    this.R = 14;
    this.v = -1;
    this.q = 0L;
    this.S = paramShort;
    this.x = 0;
    this.y = 0;
    this.p = 0;
    if (this.p > 0) {
      this.D = ft.aj;
    } else {
      this.D = 0L;
    } 
    this.Q = 0;
    this.ao = paramInt7;
    if ((es)s.b.a(paramByte2) != null)
      this.aB = true; 
    this.an = paramByte1;
    this.am = paramByte2;
    if ((this.j != null && this.j.length > 0) || this.q > 0L || this.D > 0L) {
      if (this.j != null && this.j.length > 0)
        ak.a(paramArrayOfcz); 
      d();
    } 
    this.C = 10;
    if (this.j != null && this.j.length > 0)
      for (paramInt1 = 0; paramInt1 < this.j.length; paramInt1++) {
        cz cz1;
        if ((cz1 = this.j[paramInt1]).a <= 6 && cz1.b > 0)
          this.au = cz1; 
      }  
  }
  
  public final void a(int paramInt, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, short paramShort8) {
    this.aq = paramInt;
    this.ar = paramShort1;
    this.as = paramShort6;
    this.aA = paramShort2;
    this.az = paramShort3;
    this.ay = paramShort4;
    this.ax = paramShort5;
    this.at = paramShort7;
    this.ap = paramShort8;
    this.av = new short[4];
    this.av[0] = this.aA;
    this.av[1] = this.az;
    this.av[2] = this.ay;
    this.av[3] = this.ax;
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    super.a(parambx, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: getfield am : B
    //   4: i2s
    //   5: invokestatic l : (S)Lfd;
    //   8: astore #6
    //   10: aload_0
    //   11: getfield aB : Z
    //   14: ifeq -> 379
    //   17: aload #6
    //   19: getfield a : Laq;
    //   22: ifnull -> 487
    //   25: iconst_0
    //   26: istore #7
    //   28: aload_0
    //   29: astore #4
    //   31: new es
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #5
    //   40: getstatic s.b : Lek;
    //   43: new java/lang/StringBuffer
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: aload #4
    //   52: getfield am : B
    //   55: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokevirtual a : (Ljava/lang/String;)Ljava/lang/Object;
    //   64: checkcast es
    //   67: dup
    //   68: astore #8
    //   70: ifnull -> 77
    //   73: aload #8
    //   75: astore #5
    //   77: aload #5
    //   79: iconst_0
    //   80: invokevirtual a : (I)Ljava/lang/Object;
    //   83: checkcast fa
    //   86: dup
    //   87: astore #9
    //   89: ifnull -> 106
    //   92: aload #9
    //   94: getfield a : B
    //   97: bipush #-5
    //   99: if_icmpgt -> 106
    //   102: iconst_1
    //   103: goto -> 107
    //   106: iconst_0
    //   107: ifeq -> 114
    //   110: bipush #15
    //   112: istore #7
    //   114: aload_1
    //   115: getstatic ez.db : Laq;
    //   118: iload_2
    //   119: iload_3
    //   120: bipush #10
    //   122: iadd
    //   123: iconst_3
    //   124: invokevirtual a : (Laq;III)V
    //   127: aload_0
    //   128: aload_1
    //   129: aload #6
    //   131: iload_2
    //   132: iload_3
    //   133: iload #7
    //   135: iadd
    //   136: istore_1
    //   137: istore #9
    //   139: astore #8
    //   141: astore #5
    //   143: astore #4
    //   145: new es
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: astore_2
    //   153: getstatic s.b : Lek;
    //   156: new java/lang/StringBuffer
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: aload #4
    //   165: getfield am : B
    //   168: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   171: invokevirtual toString : ()Ljava/lang/String;
    //   174: invokevirtual a : (Ljava/lang/String;)Ljava/lang/Object;
    //   177: checkcast es
    //   180: dup
    //   181: astore_3
    //   182: ifnull -> 187
    //   185: aload_3
    //   186: astore_2
    //   187: aload_2
    //   188: invokevirtual c : ()I
    //   191: ifeq -> 282
    //   194: aload_2
    //   195: iconst_0
    //   196: invokevirtual a : (I)Ljava/lang/Object;
    //   199: checkcast fa
    //   202: dup
    //   203: astore_2
    //   204: ifnull -> 282
    //   207: getstatic s.b : Lek;
    //   210: new java/lang/StringBuffer
    //   213: dup
    //   214: invokespecial <init> : ()V
    //   217: aload #4
    //   219: getfield am : B
    //   222: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   225: invokevirtual toString : ()Ljava/lang/String;
    //   228: invokevirtual a : (Ljava/lang/String;)Ljava/lang/Object;
    //   231: checkcast es
    //   234: dup
    //   235: astore_3
    //   236: ifnull -> 282
    //   239: aload #8
    //   241: ifnull -> 282
    //   244: aload #8
    //   246: getfield a : Laq;
    //   249: ifnull -> 282
    //   252: aload_2
    //   253: aload #5
    //   255: aload_2
    //   256: aload #4
    //   258: getfield aw : I
    //   261: iconst_0
    //   262: iconst_0
    //   263: invokevirtual a : (III)I
    //   266: iload #9
    //   268: iload_1
    //   269: iconst_0
    //   270: aload #8
    //   272: getfield a : Laq;
    //   275: invokevirtual a : (Lbx;IIIILaq;)V
    //   278: goto -> 282
    //   281: pop
    //   282: aload_0
    //   283: astore #4
    //   285: new es
    //   288: dup
    //   289: invokespecial <init> : ()V
    //   292: astore #5
    //   294: getstatic s.b : Lek;
    //   297: new java/lang/StringBuffer
    //   300: dup
    //   301: invokespecial <init> : ()V
    //   304: aload #4
    //   306: getfield am : B
    //   309: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   312: invokevirtual toString : ()Ljava/lang/String;
    //   315: invokevirtual a : (Ljava/lang/String;)Ljava/lang/Object;
    //   318: checkcast es
    //   321: dup
    //   322: astore #8
    //   324: ifnull -> 331
    //   327: aload #8
    //   329: astore #5
    //   331: aconst_null
    //   332: astore #9
    //   334: aload #5
    //   336: invokevirtual c : ()I
    //   339: ifle -> 378
    //   342: aload #5
    //   344: iconst_0
    //   345: invokevirtual a : (I)Ljava/lang/Object;
    //   348: checkcast fa
    //   351: astore #9
    //   353: aload #4
    //   355: aload #4
    //   357: getfield aw : I
    //   360: iconst_1
    //   361: iadd
    //   362: aload #9
    //   364: iconst_0
    //   365: iconst_0
    //   366: invokevirtual a : (II)Led;
    //   369: getfield a : [B
    //   372: arraylength
    //   373: irem
    //   374: i2b
    //   375: putfield aw : I
    //   378: return
    //   379: aload_0
    //   380: getfield ao : I
    //   383: iconst_2
    //   384: if_icmpeq -> 403
    //   387: aload_1
    //   388: getstatic ez.db : Laq;
    //   391: iload_2
    //   392: iload_3
    //   393: bipush #10
    //   395: iadd
    //   396: iconst_3
    //   397: invokevirtual a : (Laq;III)V
    //   400: iinc #3, -10
    //   403: aload #6
    //   405: getfield a : Laq;
    //   408: ifnull -> 487
    //   411: aload #6
    //   413: getfield a : Laq;
    //   416: getfield a : Ljavax/microedition/lcdui/Image;
    //   419: invokestatic b : (Ljavax/microedition/lcdui/Image;)I
    //   422: aload_0
    //   423: getfield an : B
    //   426: idiv
    //   427: istore #7
    //   429: aload #6
    //   431: getfield a : Laq;
    //   434: getfield a : Ljavax/microedition/lcdui/Image;
    //   437: invokestatic a : (Ljavax/microedition/lcdui/Image;)I
    //   440: iconst_2
    //   441: idiv
    //   442: istore #8
    //   444: aload_1
    //   445: aload #6
    //   447: getfield a : Laq;
    //   450: iload #8
    //   452: aload_0
    //   453: iload #5
    //   455: invokespecial a : (I)I
    //   458: iconst_3
    //   459: idiv
    //   460: imul
    //   461: iload #7
    //   463: aload_0
    //   464: iload #5
    //   466: invokespecial a : (I)I
    //   469: iconst_3
    //   470: irem
    //   471: imul
    //   472: iload #8
    //   474: iload #7
    //   476: iconst_0
    //   477: iload_2
    //   478: iload_3
    //   479: iload #4
    //   481: iadd
    //   482: bipush #33
    //   484: invokevirtual a : (Laq;IIIIIIII)V
    //   487: return
    // Exception table:
    //   from	to	target	type
    //   194	278	281	java/lang/Exception
  }
  
  private int a(int paramInt) {
    switch (this.ao) {
      case 0:
        return s.f[paramInt][0][ft.ai % (s.f[paramInt][0]).length];
      case 1:
        return s.e[paramInt][0][ft.ai % (s.e[paramInt][0]).length];
      case 2:
        return s.d[paramInt][0][ft.ai % (s.d[paramInt][0]).length];
      case 3:
        return s.g[paramInt][0][ft.ai % (s.g[paramInt][0]).length];
    } 
    return s.c[paramInt][0][ft.ai % (s.c[paramInt][0]).length];
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ea.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */