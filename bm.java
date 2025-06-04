public final class bm extends ez {
  private cj a;
  
  public bm(int paramInt1, byte paramByte, String paramString, int paramInt2, int paramInt3) {
    super(paramInt1, paramByte, paramString, paramInt2, paramInt3);
    (new byte[2])[0] = -1;
    (new byte[2])[1] = 1;
    this.bi = 6;
    this.be = 40;
    this.bd = 30;
    this.br = 0;
    this.bs = 0;
    this.bt = 0;
    this.bu = 0;
    this.bn = 1;
    this.bo = 2;
    this.dg = new ds();
    this.dh = new dh();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    bm bm1;
    es es;
    byte b;
    switch (paramInt1) {
      case 0:
        if (paramInt2 >= 0 && paramInt2 <= ew.a.c()) {
          ew ew;
          (ew = (ew)ew.a.a(paramInt2)).b();
        } 
        break;
      case 1:
        if (paramInt2 >= 0 && paramInt2 <= ew.b.c()) {
          ew ew;
          (ew = (ew)ew.b.a(paramInt2)).b();
        } 
        break;
      case 2:
        if (paramInt2 >= 0 && paramInt2 <= ew.c.c()) {
          ew ew;
          (ew = (ew)ew.c.a(paramInt2)).c();
        } 
        break;
      case 3:
        if (paramInt2 >= 0 && paramInt2 <= ew.d.c()) {
          ew ew;
          (ew = (ew)ew.d.a(paramInt2)).c();
        } 
        break;
      case 4:
        q.a().a((byte)this.ct);
        break;
      case 5:
        bm1 = this;
        es = new es("Other_Player menu3");
        for (b = 0; b < ew.a.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.a.a(b)).h == bm1.ct) {
            bt bt;
            (bt = new bt(ew.k, 0, b, bm1)).a(cg.aF, 1, 1);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.b.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.b.a(b)).g == bm1.ct) {
            bt bt;
            (bt = new bt(ew.k, 1, b, bm1)).a(cg.aF, 1, 3);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.c.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.c.a(b)).g == bm1.ct) {
            bt bt;
            (bt = new bt(ew.k, 2, b, bm1)).a(cg.aF, 1, 2);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.d.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.d.a(b)).g == bm1.ct) {
            bt bt;
            (bt = new bt(ew.k, 3, b, bm1)).a(cg.aF, 1, 2);
            es.a(bt);
          } 
        } 
        if (es.c() == 0) {
          ft.m();
          ft.l();
          ft.o.f();
          break;
        } 
        ft.o.f();
        ft.m();
        ft.l();
        ft.o.a(es, 2, df.at, false, (es)null);
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  public final void a(bx parambx, int paramInt) {
    if (cf.i())
      return; 
    byte b = cn.f.cv;
    boolean bool = true;
    if (cn.q.c(ft.p.d) && this.cv == b)
      bool = false; 
    String str = this.cB;
    o o = null;
    o = fl.a(paramInt);
    paramInt = 1;
    byte b1 = 0;
    if (this.cy == 1) {
      if (this.cv > 0)
        paramInt = 0; 
      b1 = 5;
    } 
    byte b2 = 18;
    if (cf.I)
      b2 = 12; 
    if (this.di == 7)
      b2 += 8; 
    if (this.cp && cf.I)
      b2 += 6; 
    if (this.aS != -1)
      paramInt = 0; 
    if (paramInt != 0 && !this.dP)
      o.a(parambx, str, this.aY, this.aZ - this.bo - this.bj + this.bk - (this.bI ? 5 : 0) - this.be - b2 - this.eb - this.bw, 2, false); 
    if (this.cu == 0 && this.cy == 1 && paramInt != 0 && !this.cM) {
      b2 += 10;
      o.a(parambx, df.fs, this.aY, this.aZ - this.bo - this.bj + this.bk - (this.bI ? 5 : 0) - this.be - b2 - this.eb - this.bw, 2, false);
    } 
    if (this.cu == 2 && this.dk == null)
      cg.aF.b(this.cn, this.aY - 6, this.aZ - this.bo - this.bj + this.bk - this.be - b2 - 18 - 4 + ft.ai / 2 % 4, 0, parambx); 
    paramInt = 0;
    if ((bq.N != null && this.cX) || this.bG || this.di == 7) {
      int i = 44;
      if (this.cu == 2 || this.di == 7)
        i = this.be + 5; 
      parambx.a(-8714722);
      parambx.c(this.aY - 20, this.aZ - this.bo - this.bj + this.bk - i - b2 - this.eb - this.bw, 40, 3);
      parambx.a(-579511);
      parambx.c(this.aY - 20, this.aZ - this.bo - this.bj + this.bk - i - b2 - this.eb - this.bw, 40 * this.br / this.bs, 3);
      paramInt += 5;
    } 
    if (this.cO != null && this.cy != 1 && !this.dP) {
      a(parambx, this.aY - 1, this.aZ - this.bo - this.bj + this.bk - this.be - b2 - 8 - paramInt - this.eb - this.bw, 2);
      paramInt += 16;
    } 
    if (this.cv >= 0 && this.cu == 0 && bool && !E()) {
      paramInt += 59;
      cg.aE.b(this.cv * 3 + ft.ai / 3 % 3, this.aY, this.aZ - this.bj + this.bk - this.bo - paramInt + 18 - b2 + b1 - this.eb - this.bw, 0, 33, parambx);
    } 
  }
  
  public final void a(bx parambx) {
    if (dw.g) {
      if (this.cu == 0) {
        if (cn.aM) {
          b(parambx, 0);
          k(parambx);
          return;
        } 
        if (cn.aN) {
          a(parambx, 0);
          k(parambx);
          return;
        } 
      } 
    } else if (this.cu == 0 && cn.aM) {
      b(parambx, 0);
      k(parambx);
      return;
    } 
    if (this.cu == 2 && this.cS != -1) {
      g(parambx);
    } else {
      c(parambx, 0);
    } 
    j(parambx);
    k(parambx);
  }
  
  private void k(bx parambx) {
    if (this.a != null && !this.a.d.equals(""))
      this.a.a(parambx); 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    if (cf.i())
      return; 
    super.a(parambx, paramInt1, paramInt2);
  }
  
  public final void a() {
    I();
    S();
    J();
    if (this.a != null)
      this.a.d(this.aY, this.aZ - this.be - 30); 
    if (this.cz != -1) {
      if (ak.e(this.aY - this.bl) <= this.bi + Q() && ak.e(this.aZ - this.bm) <= this.bi + Q()) {
        this.bE++;
        this.cN = null;
        this.dh.a(this, this.cR, this.cz, (byte)-1);
        if (this.bE > 5) {
          this.dh.b();
          this.bE = 0;
          this.cz = -1;
        } 
      } 
    } else {
      this.bE = 0;
    } 
    if (!ez.c(this) && !ez.d(this.bf, this.bg, this.bd, this.be)) {
      this.aY = this.bf;
      this.aZ = this.bg;
      this.bb = 0;
      this.bc = 0;
      if (this.cF != 4)
        this.cF = 0; 
      return;
    } 
    L();
    int i = ft.p.a(this.aY + this.bb, this.aZ + this.bc);
    g(1, i);
    K();
    R();
    super.a();
    if (this.dq && this.cJ < 70) {
      this.cJ++;
      if (ak.f(3) == 1) {
        if (ak.f(2) == 1)
          cs.t = 103; 
        i = ak.c(1, 3);
        for (byte b = 0; b < i; b++) {
          int j = ak.g(25);
          int k = ak.g(30);
          cn.a(36, this.aY + j, this.aZ + k - this.be / 2);
          if (ak.f(3) == 1)
            cn.a(9, this.aY + j, this.aZ + k - this.be / 2); 
        } 
      } 
      if (this.cJ >= 70) {
        for (i = 0; i < 6; i++) {
          int j = ak.g(25);
          int k = ak.g(30);
          cn.a(36, this.aY + j, this.aZ + k - this.be / 2);
          if (ak.f(3) == 1)
            cn.a(9, this.aY + j, this.aZ + k - this.be / 2); 
        } 
        cn.a(81, this.aY, this.aZ - 20, 200, (short)0, (byte)0);
        this.cK = true;
        this.dq = false;
      } 
    } 
  }
  
  public final int j() {
    return this.dN;
  }
  
  public final void k() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual i_ : ()Z
    //   4: ifeq -> 300
    //   7: aload_0
    //   8: getfield cp : Z
    //   11: ifeq -> 15
    //   14: return
    //   15: getstatic cn.f : Lbq;
    //   18: aload_0
    //   19: invokestatic a : (Lez;Lez;)V
    //   22: aload_0
    //   23: getfield co : B
    //   26: ifne -> 43
    //   29: invokestatic a : ()Lq;
    //   32: aload_0
    //   33: dup
    //   34: astore_0
    //   35: getfield dN : B
    //   38: i2b
    //   39: invokevirtual a : (B)V
    //   42: return
    //   43: new es
    //   46: dup
    //   47: ldc 'Other_Player menu'
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_0
    //   54: getfield cC : Ljava/lang/String;
    //   57: invokevirtual length : ()I
    //   60: ifle -> 82
    //   63: new bt
    //   66: dup
    //   67: aload_0
    //   68: getfield cC : Ljava/lang/String;
    //   71: iconst_4
    //   72: aload_0
    //   73: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   76: astore_2
    //   77: aload_1
    //   78: aload_2
    //   79: invokevirtual a : (Ljava/lang/Object;)V
    //   82: aload_0
    //   83: astore_2
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -> 119
    //   89: getstatic ew.a : Les;
    //   92: iload_3
    //   93: invokevirtual a : (I)Ljava/lang/Object;
    //   96: checkcast ew
    //   99: dup
    //   100: astore #4
    //   102: getfield h : I
    //   105: aload_2
    //   106: getfield ct : I
    //   109: if_icmpne -> 116
    //   112: iconst_1
    //   113: goto -> 265
    //   116: iinc #3, 1
    //   119: iload_3
    //   120: getstatic ew.a : Les;
    //   123: invokevirtual c : ()I
    //   126: if_icmplt -> 89
    //   129: iconst_0
    //   130: istore_3
    //   131: goto -> 164
    //   134: getstatic ew.b : Les;
    //   137: iload_3
    //   138: invokevirtual a : (I)Ljava/lang/Object;
    //   141: checkcast ew
    //   144: dup
    //   145: astore #4
    //   147: getfield g : I
    //   150: aload_2
    //   151: getfield ct : I
    //   154: if_icmpne -> 161
    //   157: iconst_1
    //   158: goto -> 265
    //   161: iinc #3, 1
    //   164: iload_3
    //   165: getstatic ew.b : Les;
    //   168: invokevirtual c : ()I
    //   171: if_icmplt -> 134
    //   174: iconst_0
    //   175: istore_3
    //   176: goto -> 209
    //   179: getstatic ew.c : Les;
    //   182: iload_3
    //   183: invokevirtual a : (I)Ljava/lang/Object;
    //   186: checkcast ew
    //   189: dup
    //   190: astore #4
    //   192: getfield g : I
    //   195: aload_2
    //   196: getfield ct : I
    //   199: if_icmpne -> 206
    //   202: iconst_1
    //   203: goto -> 265
    //   206: iinc #3, 1
    //   209: iload_3
    //   210: getstatic ew.c : Les;
    //   213: invokevirtual c : ()I
    //   216: if_icmplt -> 179
    //   219: iconst_0
    //   220: istore_3
    //   221: goto -> 254
    //   224: getstatic ew.d : Les;
    //   227: iload_3
    //   228: invokevirtual a : (I)Ljava/lang/Object;
    //   231: checkcast ew
    //   234: dup
    //   235: astore #4
    //   237: getfield g : I
    //   240: aload_2
    //   241: getfield ct : I
    //   244: if_icmpne -> 251
    //   247: iconst_1
    //   248: goto -> 265
    //   251: iinc #3, 1
    //   254: iload_3
    //   255: getstatic ew.d : Les;
    //   258: invokevirtual c : ()I
    //   261: if_icmplt -> 224
    //   264: iconst_0
    //   265: ifeq -> 286
    //   268: new bt
    //   271: dup
    //   272: getstatic df.at : Ljava/lang/String;
    //   275: iconst_5
    //   276: aload_0
    //   277: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   280: astore_2
    //   281: aload_1
    //   282: aload_2
    //   283: invokevirtual a : (Ljava/lang/Object;)V
    //   286: getstatic ft.o : Lfq;
    //   289: aload_1
    //   290: iconst_2
    //   291: getstatic df.ai : Ljava/lang/String;
    //   294: iconst_0
    //   295: aconst_null
    //   296: invokevirtual a : (Les;ILjava/lang/String;ZLes;)V
    //   299: return
    //   300: aload_0
    //   301: getfield cu : B
    //   304: ifne -> 493
    //   307: aload_0
    //   308: getfield cy : B
    //   311: ifne -> 493
    //   314: new es
    //   317: dup
    //   318: ldc 'Other_Player menu2'
    //   320: invokespecial <init> : (Ljava/lang/String;)V
    //   323: dup
    //   324: astore_1
    //   325: invokestatic b : ()Lcn;
    //   328: getfield v : Lbt;
    //   331: invokevirtual a : (Ljava/lang/Object;)V
    //   334: aload_1
    //   335: invokestatic b : ()Lcn;
    //   338: getfield t : Lbt;
    //   341: invokevirtual a : (Ljava/lang/Object;)V
    //   344: aload_1
    //   345: invokestatic b : ()Lcn;
    //   348: getfield u : Lbt;
    //   351: invokevirtual a : (Ljava/lang/Object;)V
    //   354: getstatic bq.N : Lw;
    //   357: ifnull -> 373
    //   360: getstatic bq.N : Lw;
    //   363: getfield b : Les;
    //   366: invokevirtual c : ()I
    //   369: iconst_5
    //   370: if_icmpge -> 383
    //   373: aload_1
    //   374: invokestatic b : ()Lcn;
    //   377: getfield w : Lbt;
    //   380: invokevirtual a : (Ljava/lang/Object;)V
    //   383: aload_1
    //   384: invokestatic b : ()Lcn;
    //   387: getfield y : Lbt;
    //   390: invokevirtual a : (Ljava/lang/Object;)V
    //   393: getstatic cs.w : B
    //   396: iconst_1
    //   397: if_icmpeq -> 417
    //   400: getstatic cs.w : B
    //   403: iconst_2
    //   404: if_icmpeq -> 417
    //   407: aload_1
    //   408: invokestatic b : ()Lcn;
    //   411: getfield E : Lbt;
    //   414: invokevirtual a : (Ljava/lang/Object;)V
    //   417: getstatic cn.f : Lbq;
    //   420: getfield cO : Lem;
    //   423: ifnull -> 469
    //   426: getstatic cn.f : Lbq;
    //   429: getfield cO : Lem;
    //   432: dup
    //   433: astore_2
    //   434: getfield o : B
    //   437: bipush #127
    //   439: if_icmpeq -> 451
    //   442: aload_2
    //   443: getfield o : B
    //   446: bipush #126
    //   448: if_icmpne -> 455
    //   451: iconst_1
    //   452: goto -> 456
    //   455: iconst_0
    //   456: ifeq -> 469
    //   459: aload_1
    //   460: invokestatic b : ()Lcn;
    //   463: getfield F : Lbt;
    //   466: invokevirtual a : (Ljava/lang/Object;)V
    //   469: aload_0
    //   470: invokevirtual P : ()Les;
    //   473: dup
    //   474: astore_2
    //   475: aload_0
    //   476: iconst_0
    //   477: invokevirtual b : (Ljava/lang/Object;I)V
    //   480: getstatic ft.o : Lfq;
    //   483: aload_1
    //   484: iconst_2
    //   485: getstatic df.ai : Ljava/lang/String;
    //   488: iconst_1
    //   489: aload_2
    //   490: invokevirtual a : (Les;ILjava/lang/String;ZLes;)V
    //   493: return
  }
  
  public final void c(int paramInt1, int paramInt2) {
    aa aa = new aa((byte)paramInt1, paramInt2);
    this.dw.a(aa);
  }
  
  public final void k_() {
    this.a = null;
  }
  
  public final void b(String paramString) {
    if (this.a == null)
      this.a = new cj(); 
    this.a.a(paramString, this.cL);
    this.a.d(this.aY, this.aZ - this.be - 30);
  }
  
  public final boolean e_() {
    return (this.a != null);
  }
  
  public final boolean b() {
    return (this.dS == 1);
  }
  
  public final boolean n() {
    return (this.dT == 1);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bm.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */