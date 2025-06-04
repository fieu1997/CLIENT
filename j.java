public final class j extends bw {
  public j(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, long paramLong, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
    this.O = paramInt1;
    this.t = paramInt2;
    this.g = paramString1;
    this.L = paramByte1;
    this.K = paramInt3;
    this.u = paramInt4;
    this.q = paramLong;
    this.Q = paramByte2;
    this.x = paramByte3;
    this.y = paramByte4;
    String str = paramString2;
    j j1;
    (j1 = this).a(str);
    this.C = 0;
  }
  
  public final void a(String paramString) {
    super.a(paramString);
  }
  
  public j() {}
  
  public static j a(int paramInt1, String paramString, int paramInt2, byte paramByte1, int paramInt3, int paramInt4, int paramInt5, cz[] paramArrayOfcz, int paramInt6, boolean paramBoolean, short paramShort1, long paramLong, short paramShort2, byte paramByte2, byte paramByte3, int paramInt7, byte paramByte4, byte paramByte5) {
    return new j(paramInt1, paramString, paramInt2, paramByte1, paramInt3, paramInt4, paramInt5, paramArrayOfcz, paramInt6, false, paramShort1, paramLong, paramShort2, paramByte2, paramByte3, paramInt7, paramByte4, paramByte5);
  }
  
  public j(int paramInt1, String paramString, int paramInt2, byte paramByte1, int paramInt3, int paramInt4, int paramInt5, cz[] paramArrayOfcz, int paramInt6, boolean paramBoolean, short paramShort1, long paramLong1, short paramShort2, byte paramByte2, byte paramByte3, int paramInt7, byte paramByte4, byte paramByte5, int paramInt8, long paramLong2) {
    this.i = paramString;
    this.g = paramString;
    this.t = paramInt2;
    this.O = paramInt1;
    this.z = paramByte1;
    if (this.z > 0)
      this.g = String.valueOf(this.g) + " +" + this.z; 
    this.N = paramInt3;
    this.M = paramInt4;
    this.u = paramInt5;
    this.j = paramArrayOfcz;
    this.R = paramInt6;
    this.v = paramShort1;
    this.q = paramLong1;
    this.S = paramShort2;
    this.x = paramByte2;
    this.y = paramByte3;
    this.p = paramInt7;
    this.B = paramByte5;
    this.F = paramInt8;
    this.G = paramLong2;
    if (paramInt7 > 0) {
      this.D = ft.aj;
    } else {
      this.D = 0L;
    } 
    this.Q = paramByte4;
    if ((this.j != null && this.j.length > 0) || this.q > 0L || this.D > 0L) {
      if (this.j != null && this.j.length > 0)
        ak.a(paramArrayOfcz); 
      if (!paramBoolean) {
        d();
      } else {
        c();
      } 
    } 
    this.C = 10;
  }
  
  public j(int paramInt1, String paramString, int paramInt2, byte paramByte1, int paramInt3, int paramInt4, int paramInt5, cz[] paramArrayOfcz, int paramInt6, boolean paramBoolean, short paramShort1, long paramLong, short paramShort2, byte paramByte2, byte paramByte3, int paramInt7, byte paramByte4, byte paramByte5) {
    this.i = paramString;
    this.g = paramString;
    this.t = paramInt2;
    this.O = paramInt1;
    this.z = paramByte1;
    if (this.z > 0)
      this.g = String.valueOf(this.g) + " +" + this.z; 
    this.N = paramInt3;
    this.M = paramInt4;
    this.u = paramInt5;
    this.j = paramArrayOfcz;
    this.R = paramInt6;
    this.v = paramShort1;
    this.q = paramLong;
    this.S = paramShort2;
    this.x = paramByte2;
    this.y = paramByte3;
    this.p = paramInt7;
    this.B = paramByte5;
    if (paramInt7 > 0) {
      this.D = ft.aj;
    } else {
      this.D = 0L;
    } 
    this.Q = paramByte4;
    if ((this.j != null && this.j.length > 0) || this.q > 0L || this.D > 0L) {
      if (this.j != null && this.j.length > 0)
        ak.a(paramArrayOfcz); 
      if (!paramBoolean) {
        d();
      } else {
        c();
      } 
    } 
    this.C = 10;
    this.I = new String[] { "", "" };
  }
  
  public j(int paramInt1, String paramString, int paramInt2, byte paramByte1, int paramInt3, cz[] paramArrayOfcz, short paramShort, long paramLong, byte paramByte2, byte paramByte3, byte paramByte4) {
    this.g = paramString;
    this.t = paramInt2;
    this.O = paramInt1;
    this.z = paramByte1;
    this.u = paramInt3;
    this.j = paramArrayOfcz;
    this.v = paramShort;
    this.q = paramLong;
    this.Q = paramByte2;
    this.x = paramByte3;
    this.y = paramByte4;
    if (this.j != null) {
      ak.a(paramArrayOfcz);
      j j1;
      if ((j1 = this).g == null) {
        j1.g = null;
      } else {
        int i = j1.j.length;
        j1.k = new String[i];
        j1.m = new int[i];
        if ((paramInt2 = o.f.a(j1.g)) > j1.s - 10)
          j1.s = paramInt2 + 10; 
        for (paramByte1 = 0; paramByte1 < i; paramByte1++) {
          cz cz1 = j1.j[paramByte1];
          j1.k[paramByte1] = String.valueOf(bw.d[cz1.a]) + ": " + bw.a(bw.f[cz1.a], cz1.b);
          j1.m[paramByte1] = bw.e[cz1.a];
          int k;
          if ((k = o.i.a(j1.k[paramByte1])) > j1.s - 10)
            j1.s = k + 10; 
        } 
        j1.l = new String[1];
        j1.n = new int[1];
        if (j1.q > 0L) {
          j1.l[0] = String.valueOf(df.ba) + ": " + j1.q + j1.e();
          j1.n[0] = 2;
        } else {
          j1.l[0] = df.dK;
          j1.n[0] = 2;
        } 
      } 
    } 
    this.C = 1;
  }
  
  public j(int paramInt, long paramLong) {
    this.O = paramInt;
    this.q = paramLong;
    this.Q = 1;
    this.u = 8;
    this.g = df.ey;
    String str = df.ez;
    j j1;
    (j1 = this).a(str);
    this.C = 1;
  }
  
  public static j a(int paramInt1, String paramString1, int paramInt2, int paramInt3, long paramLong, byte paramByte1, String paramString2, int paramInt4, byte paramByte2, short paramShort, byte paramByte3, byte paramByte4) {
    return new j(paramInt1, paramString1, paramInt2, 7, paramLong, paramByte1, paramString2, paramInt4, paramByte2, paramShort, paramByte3, paramByte4);
  }
  
  private j(int paramInt1, String paramString1, int paramInt2, int paramInt3, long paramLong, byte paramByte1, String paramString2, int paramInt4, byte paramByte2, short paramShort, byte paramByte3, byte paramByte4) {
    this.g = paramString1;
    this.t = paramInt2;
    this.O = paramInt1;
    this.u = paramInt3;
    this.q = paramLong;
    this.Q = paramByte1;
    this.P = paramInt4;
    this.K = paramShort;
    this.x = paramByte3;
    this.y = paramByte4;
    this.h = paramString2;
    this.A = paramByte2;
    if (paramString2 != null) {
      paramString1 = paramString2;
      j j1;
      (j1 = this).a(paramString1);
    } 
    this.C = 2;
  }
  
  public j(int paramInt1, String paramString1, int paramInt2, String paramString2, byte paramByte1, byte paramByte2) {
    this.O = paramInt1;
    this.t = paramInt1;
    this.g = paramString1;
    this.K = paramInt2;
    this.u = 5;
    this.x = paramByte1;
    this.y = paramByte2;
    paramString1 = paramString2;
    j j1;
    (j1 = this).a(paramString1);
    this.C = 3;
  }
  
  public j(int paramInt1, String paramString1, int paramInt2, int paramInt3, byte paramByte1, String paramString2, cz[] paramArrayOfcz, byte paramByte2, byte paramByte3, short paramShort, byte paramByte4, byte paramByte5, byte paramByte6) {
    this.O = paramInt1;
    this.g = paramString1;
    this.K = paramInt2;
    this.t = paramInt3;
    this.u = paramByte1;
    this.N = paramByte2;
    this.j = paramArrayOfcz;
    this.M = paramByte3;
    this.S = paramShort;
    this.x = 0;
    this.y = 0;
    this.z = paramByte4;
    if (this.z > 0)
      this.g = String.valueOf(this.g) + " +" + this.z; 
    if (paramString2 != null) {
      a(paramString2);
    } else {
      d();
    } 
    this.C = 4;
  }
  
  public j(String paramString, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2, byte paramByte3) {
    this.N = paramByte3;
    this.g = paramString;
    this.K = paramInt2;
    this.t = paramInt1;
    this.u = paramByte1;
    this.z = paramByte2;
    if (this.z > 0)
      this.g = String.valueOf(this.g) + " +" + this.z; 
  }
  
  public static String a(long paramLong) {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: lload_0
    //   8: invokevirtual append : (J)Ljava/lang/StringBuffer;
    //   11: invokevirtual toString : ()Ljava/lang/String;
    //   14: dup
    //   15: astore_0
    //   16: invokevirtual length : ()I
    //   19: iconst_3
    //   20: idiv
    //   21: istore_1
    //   22: aload_0
    //   23: invokevirtual length : ()I
    //   26: iconst_3
    //   27: irem
    //   28: ifne -> 34
    //   31: iinc #1, -1
    //   34: iconst_0
    //   35: istore_2
    //   36: goto -> 92
    //   39: aload_0
    //   40: invokevirtual length : ()I
    //   43: iload_2
    //   44: iconst_1
    //   45: iadd
    //   46: iconst_3
    //   47: imul
    //   48: isub
    //   49: iload_2
    //   50: isub
    //   51: istore_3
    //   52: new java/lang/StringBuffer
    //   55: dup
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual substring : (II)Ljava/lang/String;
    //   62: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: ldc '.'
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: aload_0
    //   74: iload_3
    //   75: aload_0
    //   76: invokevirtual length : ()I
    //   79: invokevirtual substring : (II)Ljava/lang/String;
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: invokevirtual toString : ()Ljava/lang/String;
    //   88: astore_0
    //   89: iinc #2, 1
    //   92: iload_2
    //   93: iload_1
    //   94: if_icmplt -> 39
    //   97: aload_0
    //   98: areturn
  }
  
  public static String a(int paramInt) {
    return (paramInt % 100 == 0) ? (new StringBuffer(String.valueOf(paramInt / 100))).toString() : ((paramInt % 10 == 0) ? (String.valueOf(paramInt / 100) + "." + (paramInt % 100 / 10)) : (String.valueOf(paramInt / 100) + "." + (paramInt % 100 / 10) + (paramInt % 10)));
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    super.a(parambx, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    a(parambx, paramInt1, paramInt2, 21, 1);
  }
  
  public final void c(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    super.c(parambx, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public static void a(byte paramByte, boolean paramBoolean) {
    ao ao = null;
    if (paramByte == 0) {
      ao = bq.w[bq.d][4];
    } else if (paramByte == 1) {
      ao = bq.w[bq.d][3];
    } 
    if (ao == null || ao.b != ao.d)
      (ao = new ao()).b = ao.d; 
    for (byte b = 0; b < bw.V.c(); b++) {
      j j1;
      if ((j1 = (j)bw.V.a(b)).u == 4 && j1.L == paramByte && ((ao.a < j1.O && paramBoolean) || (ao.a > j1.O && !paramBoolean) || ao.b == ao.d))
        ao.a(j1.O, ao.f, paramByte); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\j.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */