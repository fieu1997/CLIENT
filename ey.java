public final class ey extends ez {
  private short a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e = -1;
  
  private int f = -1;
  
  public final void a(int paramInt1, int paramInt2) {
    ey ey1;
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
        ey1 = this;
        es = new es("NPC menu2");
        for (b = 0; b < ew.a.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.a.a(b)).h == ey1.ct) {
            bt bt;
            (bt = new bt(ew.k, 0, b, ey1)).a(cg.aF, 1, 1);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.b.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.b.a(b)).g == ey1.ct) {
            bt bt;
            (bt = new bt(ew.k, 1, b, ey1)).a(cg.aF, 1, 3);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.c.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.c.a(b)).g == ey1.ct) {
            bt bt;
            (bt = new bt(ew.k, 2, b, ey1)).a(cg.aF, 1, 2);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.d.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.d.a(b)).g == ey1.ct) {
            bt bt;
            (bt = new bt(ew.k, 3, b, ey1)).a(cg.aF, 1, 2);
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
  
  public ey(String paramString1, String paramString2, byte paramByte1, byte paramByte2, short paramShort1, short paramShort2, byte paramByte3, byte paramByte4, byte paramByte5) {
    this.cB = paramString1;
    this.cC = paramString2;
    this.ct = paramByte1;
    this.a = paramByte2;
    this.aY = paramShort1 + 12;
    this.aZ = paramShort2;
    this.b = paramByte5;
    this.br = 100;
    this.bs = 100;
    this.bo = 0;
    ft.p.a(paramShort1, paramShort2 - 24, paramByte3, paramByte4);
    switch ((this = this).ct) {
      case -21:
      case -5:
        this.e = 43;
        this.f = 150;
        return;
      case -36:
      case -20:
      case -3:
        this.e = 44;
        this.f = 150;
        break;
    } 
  }
  
  public final void a(bx parambx) {
    fd fd;
    if (this.a != -1 && (fd = bk.a(this.a)).a != null) {
      if (this.bd == 0) {
        this.be = aq.b(fd.a.a) / this.b;
        this.bd = aq.a(fd.a.a);
      } 
      parambx.a(fd.a, 0, ft.ai / 7 % this.b * this.be, this.bd, this.be, 0, this.aY, this.aZ, 33);
    } 
    if (cn.h == null || (cn.h != null && this != cn.h) || cf.I)
      a(parambx, 0); 
  }
  
  public final void a() {
    if (this.cE != null) {
      a(this.cE, true);
      this.cE = null;
    } 
    if (this.dk != null) {
      this.dk.d(this.aY, this.aZ - this.be - 30);
      if (this.dk.b())
        this.dk = null; 
    } 
    if (this.dq && this.cJ < 70) {
      this.cJ++;
      if (ak.f(3) == 1) {
        if (ak.f(2) == 1)
          cs.t = 103; 
        int i = ak.c(1, 3);
        for (byte b = 0; b < i; b++) {
          int j = ak.g(25);
          int k = ak.g(30);
          cn.a(36, this.aY + j, this.aZ + k - this.be / 2);
          if (ak.f(3) == 1)
            cn.a(9, this.aY + j, this.aZ + k - this.be / 2); 
        } 
      } 
      if (this.cJ >= 70) {
        for (byte b = 0; b < 6; b++) {
          int i = ak.g(25);
          int j = ak.g(30);
          cn.a(36, this.aY + i, this.aZ + j - this.be / 2);
          if (ak.f(3) == 1)
            cn.a(9, this.aY + i, this.aZ + j - this.be / 2); 
        } 
        cn.a(81, this.aY, this.aZ - 20, 200, (short)0, (byte)0);
        this.cK = true;
        this.dq = false;
      } 
    } 
    if (this.e >= 0 && ft.ai % this.f == 0 && ez.c(this) && this.e == 44) {
      this = this;
      byte b1 = 0;
      for (byte b2 = 0; b2 < cn.i.c(); b2++) {
        ez ez1;
        if ((ez1 = (ez)cn.i.a(b2)).cu == 0 && ez.c(this.aY, this.aZ, ez1.aY, ez1.aZ) <= 120)
          b1++; 
      } 
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    fd fd;
    if ((fd = bk.a(this.a)).a != null) {
      if (this.c <= 0) {
        if (this.bd < 0) {
          this.be = aq.b(fd.a.a) / this.b;
          this.bd = aq.a(fd.a.a);
        } 
        this.c = this.bd;
        this.d = this.be;
        if (this.c > 26)
          this.c = 26; 
        if (this.d > 26)
          this.d = 26; 
      } 
      parambx.a(fd.a, this.bd / 2 - this.c / 2, 0, this.c, this.d, 0, paramInt1, paramInt2, 3);
    } 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2) {
    fd fd;
    if ((fd = bk.a((short)this.cT)).a != null)
      parambx.a(this.a, paramInt1, paramInt2, 40); 
  }
  
  public final boolean i_() {
    return true;
  }
  
  public final void k() {
    // Byte code:
    //   0: getstatic cn.f : Lbq;
    //   3: aload_0
    //   4: invokestatic a : (Lez;Lez;)V
    //   7: aload_0
    //   8: getfield co : B
    //   11: ifne -> 26
    //   14: invokestatic a : ()Lq;
    //   17: aload_0
    //   18: getfield ct : I
    //   21: i2b
    //   22: invokevirtual a : (B)V
    //   25: return
    //   26: new es
    //   29: dup
    //   30: ldc 'NPC menu'
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_0
    //   37: getfield cC : Ljava/lang/String;
    //   40: invokevirtual length : ()I
    //   43: ifle -> 65
    //   46: new bt
    //   49: dup
    //   50: aload_0
    //   51: getfield cC : Ljava/lang/String;
    //   54: iconst_4
    //   55: aload_0
    //   56: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   59: astore_2
    //   60: aload_1
    //   61: aload_2
    //   62: invokevirtual a : (Ljava/lang/Object;)V
    //   65: aload_0
    //   66: astore_2
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -> 102
    //   72: getstatic ew.a : Les;
    //   75: iload_3
    //   76: invokevirtual a : (I)Ljava/lang/Object;
    //   79: checkcast ew
    //   82: dup
    //   83: astore #4
    //   85: getfield h : I
    //   88: aload_2
    //   89: getfield ct : I
    //   92: if_icmpne -> 99
    //   95: iconst_1
    //   96: goto -> 248
    //   99: iinc #3, 1
    //   102: iload_3
    //   103: getstatic ew.a : Les;
    //   106: invokevirtual c : ()I
    //   109: if_icmplt -> 72
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -> 147
    //   117: getstatic ew.b : Les;
    //   120: iload_3
    //   121: invokevirtual a : (I)Ljava/lang/Object;
    //   124: checkcast ew
    //   127: dup
    //   128: astore #4
    //   130: getfield g : I
    //   133: aload_2
    //   134: getfield ct : I
    //   137: if_icmpne -> 144
    //   140: iconst_1
    //   141: goto -> 248
    //   144: iinc #3, 1
    //   147: iload_3
    //   148: getstatic ew.b : Les;
    //   151: invokevirtual c : ()I
    //   154: if_icmplt -> 117
    //   157: iconst_0
    //   158: istore_3
    //   159: goto -> 192
    //   162: getstatic ew.c : Les;
    //   165: iload_3
    //   166: invokevirtual a : (I)Ljava/lang/Object;
    //   169: checkcast ew
    //   172: dup
    //   173: astore #4
    //   175: getfield g : I
    //   178: aload_2
    //   179: getfield ct : I
    //   182: if_icmpne -> 189
    //   185: iconst_1
    //   186: goto -> 248
    //   189: iinc #3, 1
    //   192: iload_3
    //   193: getstatic ew.c : Les;
    //   196: invokevirtual c : ()I
    //   199: if_icmplt -> 162
    //   202: iconst_0
    //   203: istore_3
    //   204: goto -> 237
    //   207: getstatic ew.d : Les;
    //   210: iload_3
    //   211: invokevirtual a : (I)Ljava/lang/Object;
    //   214: checkcast ew
    //   217: dup
    //   218: astore #4
    //   220: getfield g : I
    //   223: aload_2
    //   224: getfield ct : I
    //   227: if_icmpne -> 234
    //   230: iconst_1
    //   231: goto -> 248
    //   234: iinc #3, 1
    //   237: iload_3
    //   238: getstatic ew.d : Les;
    //   241: invokevirtual c : ()I
    //   244: if_icmplt -> 207
    //   247: iconst_0
    //   248: ifeq -> 269
    //   251: new bt
    //   254: dup
    //   255: getstatic df.at : Ljava/lang/String;
    //   258: iconst_5
    //   259: aload_0
    //   260: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   263: astore_2
    //   264: aload_1
    //   265: aload_2
    //   266: invokevirtual a : (Ljava/lang/Object;)V
    //   269: getstatic ft.o : Lfq;
    //   272: aload_1
    //   273: aload_0
    //   274: getfield cD : Ljava/lang/String;
    //   277: aload_0
    //   278: getfield ct : I
    //   281: iconst_2
    //   282: iconst_0
    //   283: iconst_0
    //   284: invokevirtual a : (Les;Ljava/lang/String;IBZI)V
    //   287: return
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ey.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */