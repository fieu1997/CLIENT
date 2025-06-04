public final class bd extends ez {
  private short a;
  
  private short b;
  
  private short c;
  
  private short d;
  
  private short e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i = -1;
  
  private int j = -1;
  
  private int k;
  
  private int l;
  
  private bm m = null;
  
  private aq n;
  
  private ce o;
  
  private byte p = Byte.MAX_VALUE;
  
  private byte[] q;
  
  private byte r;
  
  public bd(byte paramByte1, short paramShort1, short paramShort2, byte paramByte2, byte paramByte3, byte paramByte4, String paramString1, String paramString2, short paramShort3, short paramShort4, byte paramByte5, byte paramByte6, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
    this.a = paramByte1;
    this.aY = paramShort1;
    this.aZ = paramShort2;
    this.k = paramByte2;
    this.l = paramByte3;
    this.f = paramByte4;
    this.cB = paramString2;
    this.cC = paramString1;
    this.b = paramByte5;
    this.c = paramByte6;
    this.d = paramShort3;
    this.e = paramShort4;
    this.cL = false;
    this.cK = false;
    "npc_server" + this.a;
    this.n = aq.a(paramArrayOfbyte2);
    this.o = new ce(this.n, aq.a(this.n.a), aq.b(this.n.a) / this.f);
    this.q = paramArrayOfbyte3;
    ft.p.b(this.d - 12, this.e, this.b, this.c);
    if (this.a != this.p) {
      this.m = new bm(this.a, (byte)0, this.cB, this.aY, this.aZ);
      this.m.bx = 1;
      this.m.cG = 0;
      this.m.a(paramArrayOfbyte1[12], paramArrayOfbyte1[13], paramArrayOfbyte1[14]);
      this.m.b(paramArrayOfbyte1);
      ex.a(new fk(paramByte1, this.aY, this.aZ));
      q();
      this.m.aY = this.aY + this.k;
      this.m.aZ = this.aZ + this.l;
      this.m.bf = this.m.aY;
      this.m.bg = this.m.aZ;
      this.be = aq.b(this.n.a) + this.m.be - 10;
      this.br = 100;
      this.bs = 100;
      this.by = 1;
    } 
  }
  
  public final void a(byte paramByte1, short paramShort1, short paramShort2, byte paramByte2, byte paramByte3, byte paramByte4, String paramString1, String paramString2, short paramShort3, short paramShort4, byte paramByte5, byte paramByte6, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
    this.m = null;
    this.n = null;
    this.o = null;
    this.a = paramByte1;
    this.aY = paramShort1;
    this.aZ = paramShort2;
    this.k = paramByte2;
    this.l = paramByte3;
    this.f = paramByte4;
    this.cB = paramString2;
    this.cC = paramString1;
    this.b = paramByte5;
    this.c = paramByte6;
    this.d = paramShort3;
    this.e = paramShort4;
    this.cL = false;
    this.cK = false;
    "npc_server" + this.a;
    this.n = aq.a(paramArrayOfbyte2);
    this.o = new ce(this.n, aq.a(this.n.a), aq.b(this.n.a) / this.f);
    this.q = paramArrayOfbyte3;
    ft.p.b(this.d - 12, this.e, this.b, this.c);
    if (this.a != this.p) {
      this.m = new bm(this.a, (byte)0, this.cB, this.aY, this.aZ);
      this.m.bx = 1;
      this.m.cG = 0;
      this.m.a(paramArrayOfbyte1[12], paramArrayOfbyte1[13], paramArrayOfbyte1[14]);
      this.m.b(paramArrayOfbyte1);
      ex.a(new fk(paramByte1, this.aY, this.aZ));
      q();
      this.m.aY = this.aY + this.k;
      this.m.aZ = this.aZ + this.l;
      this.m.bf = this.m.aY;
      this.m.bg = this.m.aZ;
      this.be = aq.b(this.n.a) + this.m.be - 10;
    } 
  }
  
  public final void a(bx parambx) {
    if (this.o != null)
      this.o.b(this.q[this.r], this.aY, this.aZ, 0, 33, parambx); 
    if (this.m != null) {
      this.m.a(parambx);
      a(parambx, 2);
    } 
  }
  
  public final void a(bx parambx, int paramInt) {
    o o = null;
    (o = fl.a(paramInt)).a(parambx, this.cC, this.m.aY, this.m.aZ - 70, 2, false);
  }
  
  public final void a() {
    this.r = (byte)(this.r + 1);
    if (this.r > this.q.length - 1)
      this.r = 0; 
    if (this.cE != null) {
      a(this.cE, true);
      this.cE = null;
    } 
    if (this.dk != null) {
      this.dk.d(this.aY, this.aZ - this.be - 30);
      if (this.dk.b())
        this.dk = null; 
    } 
    if (this.i >= 0 && ft.ai % this.j == 0 && ez.c(this) && this.i == 44) {
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
      if (this.g <= 0) {
        if (this.bd < 0) {
          this.be = aq.b(fd.a.a) / this.f;
          this.bd = aq.a(fd.a.a);
        } 
        this.g = this.bd;
        this.h = this.be;
        if (this.g > 26)
          this.g = 26; 
        if (this.h > 26)
          this.h = 26; 
      } 
      parambx.a(fd.a, this.bd / 2 - this.g / 2, 0, this.g, this.h, 0, paramInt1, paramInt2, 3);
    } 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2) {
    fd fd;
    if ((fd = bk.a((short)this.cT)).a != null)
      parambx.a(this.a, paramInt1, paramInt2, 40); 
  }
  
  public final boolean b() {
    return (this.a != this.p);
  }
  
  public final boolean i_() {
    return (this.a != this.p);
  }
  
  public final void b(bx parambx) {}
  
  public final boolean j_() {
    return true;
  }
  
  public final int j() {
    return this.a;
  }
  
  public final void k() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual i_ : ()Z
    //   4: ifeq -> 296
    //   7: getstatic cn.f : Lbq;
    //   10: aload_0
    //   11: invokestatic a : (Lez;Lez;)V
    //   14: aload_0
    //   15: getfield co : B
    //   18: ifne -> 35
    //   21: invokestatic a : ()Lq;
    //   24: aload_0
    //   25: dup
    //   26: astore_0
    //   27: getfield a : S
    //   30: i2b
    //   31: invokevirtual a : (B)V
    //   34: return
    //   35: new es
    //   38: dup
    //   39: ldc 'NPCserver menu'
    //   41: invokespecial <init> : (Ljava/lang/String;)V
    //   44: astore_1
    //   45: aload_0
    //   46: getfield cC : Ljava/lang/String;
    //   49: invokevirtual length : ()I
    //   52: ifle -> 74
    //   55: new bt
    //   58: dup
    //   59: aload_0
    //   60: getfield cC : Ljava/lang/String;
    //   63: iconst_4
    //   64: aload_0
    //   65: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   68: astore_2
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual a : (Ljava/lang/Object;)V
    //   74: aload_0
    //   75: astore_2
    //   76: iconst_0
    //   77: istore_3
    //   78: goto -> 111
    //   81: getstatic ew.a : Les;
    //   84: iload_3
    //   85: invokevirtual a : (I)Ljava/lang/Object;
    //   88: checkcast ew
    //   91: dup
    //   92: astore #4
    //   94: getfield h : I
    //   97: aload_2
    //   98: getfield ct : I
    //   101: if_icmpne -> 108
    //   104: iconst_1
    //   105: goto -> 257
    //   108: iinc #3, 1
    //   111: iload_3
    //   112: getstatic ew.a : Les;
    //   115: invokevirtual c : ()I
    //   118: if_icmplt -> 81
    //   121: iconst_0
    //   122: istore_3
    //   123: goto -> 156
    //   126: getstatic ew.b : Les;
    //   129: iload_3
    //   130: invokevirtual a : (I)Ljava/lang/Object;
    //   133: checkcast ew
    //   136: dup
    //   137: astore #4
    //   139: getfield g : I
    //   142: aload_2
    //   143: getfield ct : I
    //   146: if_icmpne -> 153
    //   149: iconst_1
    //   150: goto -> 257
    //   153: iinc #3, 1
    //   156: iload_3
    //   157: getstatic ew.b : Les;
    //   160: invokevirtual c : ()I
    //   163: if_icmplt -> 126
    //   166: iconst_0
    //   167: istore_3
    //   168: goto -> 201
    //   171: getstatic ew.c : Les;
    //   174: iload_3
    //   175: invokevirtual a : (I)Ljava/lang/Object;
    //   178: checkcast ew
    //   181: dup
    //   182: astore #4
    //   184: getfield g : I
    //   187: aload_2
    //   188: getfield ct : I
    //   191: if_icmpne -> 198
    //   194: iconst_1
    //   195: goto -> 257
    //   198: iinc #3, 1
    //   201: iload_3
    //   202: getstatic ew.c : Les;
    //   205: invokevirtual c : ()I
    //   208: if_icmplt -> 171
    //   211: iconst_0
    //   212: istore_3
    //   213: goto -> 246
    //   216: getstatic ew.d : Les;
    //   219: iload_3
    //   220: invokevirtual a : (I)Ljava/lang/Object;
    //   223: checkcast ew
    //   226: dup
    //   227: astore #4
    //   229: getfield g : I
    //   232: aload_2
    //   233: getfield ct : I
    //   236: if_icmpne -> 243
    //   239: iconst_1
    //   240: goto -> 257
    //   243: iinc #3, 1
    //   246: iload_3
    //   247: getstatic ew.d : Les;
    //   250: invokevirtual c : ()I
    //   253: if_icmplt -> 216
    //   256: iconst_0
    //   257: ifeq -> 278
    //   260: new bt
    //   263: dup
    //   264: getstatic df.at : Ljava/lang/String;
    //   267: iconst_5
    //   268: aload_0
    //   269: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   272: astore_2
    //   273: aload_1
    //   274: aload_2
    //   275: invokevirtual a : (Ljava/lang/Object;)V
    //   278: getstatic ft.o : Lfq;
    //   281: aload_1
    //   282: aload_0
    //   283: getfield cD : Ljava/lang/String;
    //   286: aload_0
    //   287: getfield ct : I
    //   290: iconst_2
    //   291: iconst_0
    //   292: iconst_0
    //   293: invokevirtual a : (Les;Ljava/lang/String;IBZI)V
    //   296: return
  }
  
  private void q() {
    switch (this.ct) {
      case -21:
      case -5:
        this.i = 43;
        this.j = 150;
        return;
      case -36:
      case -20:
      case -3:
        this.i = 44;
        this.j = 150;
        break;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    bd bd1;
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
        bd1 = this;
        es = new es("NPCserver menu2");
        for (b = 0; b < ew.a.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.a.a(b)).h == bd1.ct) {
            bt bt;
            (bt = new bt(ew.k, 0, b, bd1)).a(cg.aF, 1, 1);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.b.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.b.a(b)).g == bd1.ct) {
            bt bt;
            (bt = new bt(ew.k, 1, b, bd1)).a(cg.aF, 1, 3);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.c.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.c.a(b)).g == bd1.ct) {
            bt bt;
            (bt = new bt(ew.k, 2, b, bd1)).a(cg.aF, 1, 2);
            es.a(bt);
          } 
        } 
        for (b = 0; b < ew.d.c(); b++) {
          ew ew;
          if ((ew = (ew)ew.d.a(b)).g == bd1.ct) {
            bt bt;
            (bt = new bt(ew.k, 3, b, bd1)).a(cg.aF, 1, 2);
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
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bd.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */