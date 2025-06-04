import com.silverknight.TemMidlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class eq extends cg {
  private short b;
  
  private byte c;
  
  public static byte a = 100;
  
  private static byte d = 0;
  
  private static byte e = 1;
  
  private static byte f = 2;
  
  private static byte g = 3;
  
  private static byte h = 4;
  
  private static byte i = 5;
  
  private static byte j = 6;
  
  private static byte k = 7;
  
  private static byte l = 8;
  
  private static byte m = 9;
  
  private static byte n = 10;
  
  private static byte o = 11;
  
  private static byte p = 12;
  
  private static byte q = 13;
  
  private static byte r = 14;
  
  private static byte s = 15;
  
  private static byte t = 16;
  
  private static byte u = 17;
  
  private static byte v = 18;
  
  private static byte w = 19;
  
  private static byte x = 20;
  
  private String y = "";
  
  private String z = "";
  
  public final void a(int paramInt1, int paramInt2) {
    bt bt;
    es es;
    switch (paramInt1) {
      case 0:
        q.a().a((byte)1, this.z, (byte)0, (short)0, 0);
        ft.j();
        return;
      case 1:
        q.a().b((byte)2, this.y);
        ft.j();
        return;
      case 2:
        ft.j();
        if (paramInt2 >= 0) {
          q.a().c(this.b, this.c, (byte)paramInt2);
          return;
        } 
        break;
      case 3:
        if ((ez.cr = (byte)(ez.cr + 1)) >= ez.cq.length - 1) {
          ft.o.a(null, ez.cq[ez.cq.length - 1], paramInt2, (byte)2, false, 2);
          return;
        } 
        es = new es("ReadMessenge menu");
        bt = new bt(df.aa, 3, paramInt2, this);
        es.a(this);
        ft.o.a(es, ez.cq[ez.cr], paramInt2, (byte)2, false, 2);
        return;
      case 4:
        ft.o.f();
        q.a().b((byte)2, (short)0);
        ft.a(df.aG, new bt(df.Z, -1));
        break;
    } 
  }
  
  public static void a(eo parameo) {
    try {
      ft.j();
      c.B = 1;
      c.C = parameo.b().readByte();
      c.F = parameo.b().readUTF();
      c.G.d();
      short s = parameo.b().readShort();
      byte b = parameo.b().readByte();
      if (s != -1 && b == 7) {
        j j;
        if ((j = bw.b(s)) != null) {
          c.l = j;
          return;
        } 
        (c.l = new j()).O = s;
        c.l.u = 7;
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void b(eo parameo) {
    try {
      short s1 = parameo.b().readShort();
      String str = (str = parameo.b().readUTF()).toLowerCase();
      int i = parameo.b().readInt();
      int j = parameo.b().readInt();
      int k = parameo.b().readInt();
      int m = parameo.b().readInt();
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      byte b4 = parameo.b().readByte();
      if (cn.f == null)
        cn.f = new bq(s1, (byte)0, str.toLowerCase(), 50, 50); 
      cn.f.a(b1, b3, b4);
      cz[] arrayOfCz = new cz[b1 = parameo.b().readByte()];
      b4 = 0;
      short s3;
      for (s3 = 0; s3 < cn.f.K.length; s3++)
        cn.f.K[s3] = "0"; 
      for (s3 = 0; s3 < b1; s3++) {
        if (k.a.equals("1.1.0")) {
          arrayOfCz[s3] = new cz(parameo.b().readUnsignedByte(), parameo.b().readUnsignedShort());
        } else {
          arrayOfCz[s3] = new cz(parameo.b().readUnsignedByte(), parameo.b().readInt());
        } 
        if ((arrayOfCz[s3]).a >= 16 && (arrayOfCz[s3]).a <= 20)
          cn.f.K[(arrayOfCz[s3]).a - 16] = j.a((arrayOfCz[s3]).b); 
        if ((arrayOfCz[s3]).a >= 23 && (arrayOfCz[s3]).a <= 26)
          b4++; 
      } 
      if (b4 == 0) {
        cn.f.L = arrayOfCz;
      } else {
        cn.f.L = new cz[b1 - b4];
        b4 = 0;
        for (s3 = 0; s3 < arrayOfCz.length; s3++) {
          if ((arrayOfCz[s3]).a < 23 || (arrayOfCz[s3]).a > 26) {
            cn.f.L[b4] = new cz((arrayOfCz[s3]).a, (arrayOfCz[s3]).b);
            b4++;
          } 
        } 
      } 
      cn.f.by = parameo.b().readShort();
      cn.f.bz = parameo.b().readShort();
      bq.t = parameo.b().readShort();
      bq.u = parameo.b().readShort();
      for (s3 = 0; s3 < (bq.v[0]).length; s3++)
        bq.v[0][s3] = parameo.b().readShort(); 
      for (s3 = 0; s3 < (bq.v[0]).length; s3++)
        bq.v[1][s3] = parameo.b().readShort(); 
      bq.I = new int[bq.f];
      for (s3 = 0; s3 < bq.f; s3++)
        bq.I[s3] = parameo.b().readByte(); 
      for (s3 = 0; s3 < bq.f; s3++)
        bq.J[s3] = parameo.b().readByte(); 
      s3 = 0;
      while (s3 < bq.f) {
        b1 = -1;
        boolean bool = true;
        if (bq.I[s3] > 0) {
          if (s3 < 9)
            for (b4 = 0; b4 < 3; b4++) {
              ao ao;
              if ((ao = bq.w[bq.d][b4]) != null)
                if (b1 == -1) {
                  if (ao.b == ao.d) {
                    b1 = b4;
                    bool = false;
                  } 
                } else if (ao.b == 0 && ao.a == s3) {
                  b1 = -1;
                  break;
                }  
            }  
        } else {
          bool = false;
        } 
        if (b1 != -1)
          bq.w[bq.d][b1].a(s3, 0, (byte)0); 
        if (!bool) {
          s3++;
          continue;
        } 
        break;
      } 
      cn.f.cv = parameo.b().readByte();
      cn.f.cA = parameo.b().readShort();
      fn.G = (byte)((bq.x = parameo.b().readByte()) / 42);
      if ((s3 = parameo.b().readShort()) >= 0) {
        int n = parameo.b().readInt();
        cn.f.cO = new em(n, s3, parameo.b().readUTF(), parameo.b().readByte());
      } 
      cn.S = parameo.b().readUTF();
      cn.T = parameo.b().readLong();
      ev.b();
      cn.f.cu = 0;
      cn.f.cB = str.toLowerCase();
      cn.f.ct = s1;
      cn.f.br = i;
      if (cn.f.br > 0 && cn.f.cF == 4) {
        cn.f.N();
        cn.f.dW = 0;
        cn.f.cF = 0;
        cn.f.df.d();
        q.a().a((short)cn.f.aY, (short)cn.f.aZ);
      } 
      cn.f.bs = j;
      cn.f.bv = j / 10;
      cn.f.bt = k;
      cn.f.bu = m;
      cn.f.bx = b2;
      cn.f.dW = 0;
      if (!bq.k) {
        ff.f.d();
        ff.g.d();
        if (!cn.i.equals(cn.f))
          cn.a(cn.f); 
        cn.f.p();
        bq.k = true;
        et.a.d();
        ft.g.a(df.cz, "", df.dO, (byte)1, false);
        bq.T = new short[0];
        co.a();
        q.a().g((byte)59);
        cf.i = 0;
        cn.j.d();
        cn.k.d();
        cn.q.F = null;
        cn.q.G = null;
        cn.q.H = null;
        bq.A = 0;
        if (cn.f.by == 1)
          bq.o = -1; 
        q.a().a((byte)1, (byte)4, (byte[])null);
        q.a().a((byte)1, (byte)3, (byte[])null);
      } 
      fl.bi = 0;
      short[] arrayOfShort = new short[b1 = parameo.b().readByte()];
      for (b4 = 0; b4 < b1; b4++) {
        arrayOfShort[b4] = -1;
        arrayOfShort[b4] = parameo.b().readShort();
      } 
      cn.f.dF = arrayOfShort;
      ft.K = parameo.b().readByte();
      try {
        short s = parameo.b().readShort();
      } catch (Exception exception) {
        b4 = -1;
        exception.printStackTrace();
      } 
      cn.f.aM = b4;
      try {
        byte b;
        if ((b = parameo.b().readByte()) == 1) {
          cn.f.dU = true;
        } else {
          cn.f.dU = false;
        } 
      } catch (Exception exception) {}
      short s4 = 0;
      try {
        s4 = parameo.b().readShort();
      } catch (Exception exception) {
        s4 = -1;
      } 
      cn.f.aN = s4;
      s1 = 0;
      try {
        s1 = parameo.b().readShort();
      } catch (Exception exception) {
        s1 = -1;
      } 
      cn.f.aO = s1;
      s1 = 0;
      try {
        s1 = parameo.b().readShort();
      } catch (Exception exception) {
        s1 = -1;
      } 
      cn.f.aP = s1;
      s1 = 0;
      try {
        s1 = parameo.b().readShort();
      } catch (Exception exception) {
        s1 = -1;
      } 
      cn.f.aQ = s1;
      s1 = -1;
      try {
        s1 = parameo.b().readShort();
      } catch (Exception exception) {}
      cn.f.aR = s1;
      short s2 = 0;
      try {
        s2 = parameo.b().readShort();
      } catch (Exception exception) {
        s2 = -1;
      } 
      cn.f.aS = s2;
      s1 = -1;
      try {
        s1 = parameo.b().readShort();
      } catch (Exception exception) {}
      cn.f.aT = s1;
      s2 = -1;
      try {
        s2 = parameo.b().readShort();
      } catch (Exception exception) {}
      cn.f.aU = s2;
      s1 = -1;
      try {
        s1 = parameo.b().readShort();
      } catch (Exception exception) {}
      cn.f.aV = s1;
      return;
    } catch (IOException iOException2) {
      IOException iOException1;
      (iOException1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void c(eo parameo) {
    try {
      while (parameo.b().available() > 0) {
        byte b1 = parameo.b().readByte();
        short s1 = parameo.b().readShort();
        short s2 = parameo.b().readShort();
        short s3 = parameo.b().readShort();
        short s4 = parameo.b().readShort();
        byte b2 = parameo.b().readByte();
        if (eg.g) {
          if (b2 != Byte.MAX_VALUE) {
            ez ez;
            if ((ez = ez.a(s2, b1)) == null) {
              bm bm;
              if (b1 == 1) {
                au.a(s2, s3, s4, s1);
                q.a().c(s2);
                continue;
              } 
              if (b1 == 0) {
                (bm = new bm(s2, b1, "", s3, s4)).cG = ak.f(4);
                bm.a((byte[])null);
                cn.a(bm);
                q.a().a(s2);
                bm.bV = ft.aj;
                continue;
              } 
              if (bm == 2) {
                (bm = new bm(s2, bm, "", s3, s4)).cp = true;
                cn.a(bm);
                q.a().b(s2);
              } 
              continue;
            } 
            if (ez.cK)
              return; 
            if (ez == cn.f) {
              if (ak.e(cn.f.aY - s3) > 24 || ak.e(cn.f.aZ - s4) > 24) {
                bq.m = true;
                bq.n = false;
                cn.f.bf = cn.f.aY;
                cn.f.bg = cn.f.aZ;
                cn.f.cl = s3;
                cn.f.cm = s4;
                try {
                  cn.f.cN = ft.c.a(s3 / cs.l, s4 / cs.l, cn.f.aY / cs.l, cn.f.aZ / cs.l, 20);
                } catch (Exception exception) {
                  ez.aY = s3;
                  ez.aZ = s4;
                  cn.f.cN = null;
                  bq.m = false;
                  bq.n = true;
                } 
              } 
              if (cn.f.cN == null || cn.f.cN.length >= 20) {
                ez.aY = s3;
                ez.aZ = s4;
                cn.f.cN = null;
                bq.m = false;
                bq.n = true;
              } 
              continue;
            } 
            if (ez.cu == 1) {
              ez.bf = s3;
              ez.bg = s4;
              ez.dD = true;
              if (b2 == 126) {
                if (ez.dO != 1)
                  cn.a(54, ez.aY, ez.aZ - 20); 
                ez.aY = ez.bf;
                ez.aZ = ez.bg;
                ez.dD = false;
                ez.dO = -1;
                continue;
              } 
              if (b2 == 125)
                ez.dO = 0; 
              continue;
            } 
            if (ez.cF != 2 && ez.cF != 4 && ez.cz == -1) {
              ez.bf = s3;
              ez.bg = s4;
              if (bq.N != null)
                bq.N.a(ez.cB, s3, s4, ez.br, ez.bs); 
            } 
            continue;
          } 
          if (b2 == Byte.MAX_VALUE) {
            ez ez;
            if ((ez = ez.a(s2, exception)) != null) {
              if (ez.cK)
                return; 
              ez.dZ = true;
              ez.ea = s4;
              continue;
            } 
            if (exception == null) {
              bm bm;
              (bm = new bm(s2, exception, "", s3, s4)).cG = ak.f(4);
              bm.a((byte[])null);
              cn.a(bm);
              q.a().a(s2);
              bm.bV = ft.aj;
              ez.dZ = true;
              ez.ea = s4;
            } 
          } 
        } 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void d(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readShort : ()S
    //   7: istore_1
    //   8: aload_0
    //   9: invokevirtual b : ()Ljava/io/DataInputStream;
    //   12: invokevirtual readUTF : ()Ljava/lang/String;
    //   15: astore_2
    //   16: aload_0
    //   17: invokevirtual b : ()Ljava/io/DataInputStream;
    //   20: invokevirtual readInt : ()I
    //   23: istore_3
    //   24: aload_0
    //   25: invokevirtual b : ()Ljava/io/DataInputStream;
    //   28: invokevirtual readInt : ()I
    //   31: istore #4
    //   33: aload_0
    //   34: invokevirtual b : ()Ljava/io/DataInputStream;
    //   37: invokevirtual readShort : ()S
    //   40: istore #5
    //   42: aload_0
    //   43: invokevirtual b : ()Ljava/io/DataInputStream;
    //   46: invokevirtual readShort : ()S
    //   49: istore #6
    //   51: aload_0
    //   52: invokevirtual b : ()Ljava/io/DataInputStream;
    //   55: invokevirtual readShort : ()S
    //   58: istore #7
    //   60: aload_0
    //   61: invokevirtual b : ()Ljava/io/DataInputStream;
    //   64: invokevirtual readByte : ()B
    //   67: pop
    //   68: aload_0
    //   69: invokevirtual b : ()Ljava/io/DataInputStream;
    //   72: invokevirtual readByte : ()B
    //   75: pop
    //   76: aload_0
    //   77: invokevirtual b : ()Ljava/io/DataInputStream;
    //   80: invokevirtual readUTF : ()Ljava/lang/String;
    //   83: pop
    //   84: aload_0
    //   85: invokevirtual b : ()Ljava/io/DataInputStream;
    //   88: invokevirtual readShort : ()S
    //   91: istore #8
    //   93: iload_1
    //   94: iconst_2
    //   95: invokestatic a : (IB)Lez;
    //   98: dup
    //   99: astore_1
    //   100: ifnull -> 110
    //   103: aload_1
    //   104: getfield cK : Z
    //   107: ifeq -> 111
    //   110: return
    //   111: aload_1
    //   112: aload_2
    //   113: putfield cB : Ljava/lang/String;
    //   116: aload_1
    //   117: iload #6
    //   119: putfield aY : I
    //   122: aload_1
    //   123: iload #7
    //   125: putfield aZ : I
    //   128: aload_1
    //   129: iload #6
    //   131: putfield bf : I
    //   134: aload_1
    //   135: iload #7
    //   137: putfield bg : I
    //   140: aload_1
    //   141: iload #5
    //   143: putfield by : S
    //   146: aload_1
    //   147: iload_3
    //   148: putfield bs : I
    //   151: aload_1
    //   152: iload #4
    //   154: putfield br : I
    //   157: aload_1
    //   158: iload_3
    //   159: bipush #10
    //   161: idiv
    //   162: putfield bv : I
    //   165: aload_1
    //   166: iload #8
    //   168: putfield cS : I
    //   171: aload_1
    //   172: iconst_2
    //   173: putfield cu : B
    //   176: iload #8
    //   178: iconst_m1
    //   179: if_icmpne -> 355
    //   182: aload_0
    //   183: invokevirtual b : ()Ljava/io/DataInputStream;
    //   186: invokevirtual readByte : ()B
    //   189: istore_2
    //   190: aload_0
    //   191: invokevirtual b : ()Ljava/io/DataInputStream;
    //   194: invokevirtual readByte : ()B
    //   197: istore_3
    //   198: aload_0
    //   199: invokevirtual b : ()Ljava/io/DataInputStream;
    //   202: invokevirtual readByte : ()B
    //   205: istore #4
    //   207: aload_1
    //   208: iload_2
    //   209: iload_3
    //   210: iload #4
    //   212: invokevirtual a : (III)V
    //   215: bipush #12
    //   217: newarray byte
    //   219: astore_2
    //   220: iconst_0
    //   221: istore_3
    //   222: goto -> 232
    //   225: aload_2
    //   226: iload_3
    //   227: iconst_m1
    //   228: bastore
    //   229: iinc #3, 1
    //   232: iload_3
    //   233: aload_2
    //   234: arraylength
    //   235: if_icmplt -> 225
    //   238: aload_0
    //   239: invokevirtual b : ()Ljava/io/DataInputStream;
    //   242: invokevirtual readByte : ()B
    //   245: istore_3
    //   246: iconst_0
    //   247: istore #4
    //   249: goto -> 279
    //   252: aload_0
    //   253: invokevirtual b : ()Ljava/io/DataInputStream;
    //   256: invokevirtual readByte : ()B
    //   259: istore #5
    //   261: aload_0
    //   262: invokevirtual b : ()Ljava/io/DataInputStream;
    //   265: invokevirtual readByte : ()B
    //   268: istore #6
    //   270: aload_2
    //   271: iload #5
    //   273: iload #6
    //   275: bastore
    //   276: iinc #4, 1
    //   279: iload #4
    //   281: iload_3
    //   282: if_icmplt -> 252
    //   285: aload_1
    //   286: aload_2
    //   287: invokevirtual a : ([B)V
    //   290: aload_0
    //   291: invokevirtual b : ()Ljava/io/DataInputStream;
    //   294: invokevirtual readShort : ()S
    //   297: dup
    //   298: istore #4
    //   300: iconst_m1
    //   301: if_icmpeq -> 349
    //   304: aload_0
    //   305: invokevirtual b : ()Ljava/io/DataInputStream;
    //   308: invokevirtual readInt : ()I
    //   311: istore #5
    //   313: aload_0
    //   314: invokevirtual b : ()Ljava/io/DataInputStream;
    //   317: invokevirtual readUTF : ()Ljava/lang/String;
    //   320: astore #6
    //   322: aload_0
    //   323: invokevirtual b : ()Ljava/io/DataInputStream;
    //   326: invokevirtual readByte : ()B
    //   329: istore_0
    //   330: aload_1
    //   331: new em
    //   334: dup
    //   335: iload #5
    //   337: iload #4
    //   339: aload #6
    //   341: iload_0
    //   342: invokespecial <init> : (ISLjava/lang/String;B)V
    //   345: putfield cO : Lem;
    //   348: return
    //   349: aload_1
    //   350: aconst_null
    //   351: putfield cO : Lem;
    //   354: return
    //   355: aload_0
    //   356: invokevirtual b : ()Ljava/io/DataInputStream;
    //   359: invokevirtual readByte : ()B
    //   362: istore_2
    //   363: aload_0
    //   364: invokevirtual b : ()Ljava/io/DataInputStream;
    //   367: invokevirtual readShort : ()S
    //   370: istore_3
    //   371: aload_1
    //   372: iload_2
    //   373: putfield dB : B
    //   376: aload_1
    //   377: iload_3
    //   378: putfield cT : I
    //   381: return
    //   382: dup
    //   383: astore_1
    //   384: invokevirtual printStackTrace : ()V
    //   387: return
    // Exception table:
    //   from	to	target	type
    //   0	110	382	java/lang/Exception
    //   111	381	382	java/lang/Exception
  }
  
  public static void e(eo parameo) {
    try {
      short s1 = parameo.b().readShort();
      String str = (str = parameo.b().readUTF()).toLowerCase();
      short s3 = parameo.b().readShort();
      short s4 = parameo.b().readShort();
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      byte b4 = parameo.b().readByte();
      byte b5 = parameo.b().readByte();
      short s6 = parameo.b().readShort();
      int i = parameo.b().readInt();
      int j = parameo.b().readInt();
      byte b6 = parameo.b().readByte();
      short s7 = parameo.b().readShort();
      ez ez;
      if ((ez = ez.a(s1, (byte)0)) == null || ez.cK)
        return; 
      if (b2 == -126 && str.endsWith(",")) {
        ez.cM = true;
        str = str.substring(0, str.length() - 1);
      } 
      ez.cB = str;
      ez.bf = s3;
      ez.bg = s4;
      ez.bx = b1;
      ez.dW = 0;
      ez.by = s6;
      ez.bs = j;
      ez.br = i;
      ez.cv = b6;
      ez.bv = j / 10;
      ez.cA = s7;
      ez.dN = b2;
      if (ez.i_()) {
        ez.cC = ez.cB;
        ez.cD = df.bJ;
        ex.a(new fk(ez.dN, s3, s4));
      } 
      if (b2 == -126)
        ez.cy = 1; 
      ez.a(b3, b4, b5);
      if (bq.N != null) {
        ez ez1 = ez;
        w w = bq.N;
        for (s4 = 0; s4 < w.b.c(); s4++) {
          aj aj;
          if ((aj = (aj)w.b.a(s4)).b.compareTo(ez1.cB) == 0) {
            ez1.cX = true;
            break;
          } 
        } 
      } 
      if (ez.br <= 0) {
        ez.br = 0;
        ez.bt = 0;
        ez.N();
        ez.cF = 4;
        ez.aW = ft.aj;
      } 
      byte[] arrayOfByte = new byte[12];
      short[][] arrayOfShort = new short[12][];
      for (s4 = 0; s4 < arrayOfShort.length; s4++)
        arrayOfShort[s4] = new short[3]; 
      for (s4 = 0; s4 < arrayOfShort.length; s4++) {
        for (b1 = 0; b1 < (arrayOfShort[s4]).length; b1++)
          arrayOfShort[s4][b1] = -1; 
      } 
      for (s4 = 0; s4 < arrayOfByte.length; s4++)
        arrayOfByte[s4] = -1; 
      s4 = parameo.b().readByte();
      ez.T();
      for (b1 = 0; b1 < s4; b1++) {
        b2 = parameo.b().readByte();
        b3 = parameo.b().readByte();
        arrayOfByte[b2] = b3;
        b4 = parameo.b().readByte();
        for (b5 = 0; b5 < b4; b5++)
          arrayOfShort[b2][b5] = parameo.b().readShort(); 
        short s8;
        if ((s8 = parameo.b().readShort()) != -1)
          if (b2 == 0) {
            ez.c(1, s8);
          } else if (b2 == 2) {
            ez.c(0, s8);
          } else if (b2 == 1) {
            ez.c(2, s8);
          }  
      } 
      ez.a(arrayOfByte);
      ez.a(arrayOfShort);
      short s5;
      if ((s5 = parameo.b().readShort()) >= 0) {
        int k = parameo.b().readInt();
        ez.cO = new em(k, s5, parameo.b().readUTF(), parameo.b().readByte());
      } else {
        ez.cO = null;
      } 
      if ((b2 = parameo.b().readByte()) >= 0) {
        b3 = parameo.b().readByte();
        b4 = parameo.b().readByte();
        ez ez1;
        if ((ez1 = cn.b(ez)) != null)
          cn.i.d(ez1); 
        s s8;
        if ((s8 = s.a(ez, b2, b4, b3)) != null)
          cn.a(s8); 
      } 
      short[] arrayOfShort1 = new short[b3 = parameo.b().readByte()];
      for (b5 = 0; b5 < b3; b5++) {
        arrayOfShort1[b5] = -1;
        arrayOfShort1[b5] = parameo.b().readShort();
      } 
      ez.dF = arrayOfShort1;
      try {
        ez.bA = parameo.b().readShort();
      } catch (Exception exception) {}
      b5 = parameo.b().readByte();
      boolean bool = parameo.b().readBoolean();
      ez.bK = bool;
      ez.ee = b5;
      short s = parameo.b().readByte();
      short s2 = parameo.b().readByte();
      ez.dS = s;
      ez.dT = s2;
      s = 0;
      try {
        short s8 = parameo.b().readShort();
      } catch (Exception exception) {
        s = -1;
      } 
      ez.aM = s;
      try {
        if ((s = parameo.b().readByte()) == 1) {
          ez.dU = true;
        } else {
          ez.dU = false;
        } 
      } catch (Exception exception) {}
      s = 0;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {
        s = -1;
      } 
      ez.aN = s;
      s = 0;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {
        s = -1;
      } 
      ez.aO = s;
      s = 0;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {
        s = -1;
      } 
      ez.aP = s;
      s = 0;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {
        s = -1;
      } 
      ez.aQ = s;
      s = 0;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {
        s = -1;
      } 
      ez.aR = s;
      s = 0;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {
        s = -1;
      } 
      ez.aS = s;
      s = -1;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {}
      ez.aT = s;
      s2 = -1;
      try {
        s2 = parameo.b().readShort();
      } catch (Exception exception) {}
      ez.aU = s2;
      s = -1;
      try {
        s = parameo.b().readShort();
      } catch (Exception exception) {}
      ez.aV = s;
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void f(eo parameo) {
    try {
      short s1 = parameo.b().readShort();
      int i = parameo.b().readUnsignedByte();
      short s2 = parameo.b().readShort();
      short s3 = parameo.b().readShort();
      int j = parameo.b().readInt();
      int k = parameo.b().readInt();
      byte b = parameo.b().readByte();
      int m = parameo.b().readInt();
      au au;
      if ((au = (au)ez.a(s1, (byte)1)) == null || au.cK)
        return; 
      au.by = (short)i;
      au.bf = s2;
      au.bg = s3;
      au.br = j;
      au.bs = k;
      au.cW = true;
      au.a(i);
      au.dA = m;
      if (m == -2)
        au.cx = 1; 
      if (m == -3) {
        parameo.b().readUTF();
        Object object = null;
        au.cx = 2;
        ez.do.d();
        ez.dp = "";
        cn.h = au;
        ft.c(df.dG);
      } 
      if (m == -4) {
        au.cx = 3;
        au.H = parameo.b().readShort();
        au.I = parameo.b().readShort();
      } 
      if (m == -5) {
        au.cx = 4;
        au.H = parameo.b().readShort();
        au.I = parameo.b().readShort();
      } 
      if ((i = parameo.b().readShort()) >= 0) {
        int n = parameo.b().readInt();
        au.cO = new em(n, i, parameo.b().readUTF(), parameo.b().readByte());
      } else {
        au.cO = null;
      } 
      au.dn = new do(b);
      if (au.br <= 0) {
        au.br = 0;
        au.bt = 0;
        if (au.cF != 4)
          ez.a(au, cn.f.ct, ak.f(3)); 
      } 
      if (au.di == 7) {
        ex.a(au.ct, (byte)1);
        au.cB = parameo.b().readUTF();
      } 
      s2 = parameo.b().readByte();
      i = parameo.b().readByte();
      s3 = parameo.b().readByte();
      au.dE = (s2 == 1);
      au.bi = i;
      au.cG = s3;
      String str = parameo.b().readUTF();
      au.R = str;
      if (!str.equals("") || au.l_())
        au.d(i); 
      long l = parameo.b().readLong();
      au.cs = parameo.b().readByte();
      au.a(l);
      bj.a(au);
      return;
    } catch (Exception exception) {
      dw.a("loi cho nay ne monsterinfo " + exception.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void g(eo parameo) {
    try {
      short s;
      if ((s = parameo.b().readShort()) == cn.f.ct)
        return; 
      ez ez1;
      if ((ez1 = ez.a(s, (byte)0)) != null && !ez1.cK) {
        s s1;
        if ((s1 = (s)ez.a(ez1.ct, (byte)9)) != null) {
          cn.a(35, s1.aY, s1.aZ - 20);
          s1.cL = true;
        } 
        cn.a(35, ez1.aY, ez1.aZ - 20);
        ez1.cL = true;
      } 
      ez ez2;
      if ((ez2 = ez.a(s, (byte)1)) != null && !ez2.cK) {
        cn.a(35, ez2.aY, ez2.aZ - 20);
        ez2.cL = true;
        return;
      } 
    } catch (Exception exception) {
      (parameo = null).printStackTrace();
    } 
  }
  
  public static void h(eo parameo) {
    boolean bool = false;
    try {
      ft.c.aT = 0;
      ft.c.aW = false;
      cn.q.a = -1;
      cn.q.b = -1;
      eg.g = false;
      if (bq.o > -1)
        bq.o_(); 
      if (ft.a != ft.d)
        ft.d.c(); 
      cn.k();
      cn.l();
      ft.p.d = parameo.b().readShort();
      cn.q.a(ft.p.d, dw.a(), 30);
      cn.f.aY = parameo.b().readShort() * 24;
      cn.f.aZ = parameo.b().readShort() * 24;
      cn.f.cj = cn.f.aY;
      cn.f.ck = cn.f.aZ;
      cn.f.u();
      cn.f.cN = null;
      cn.f.N();
      if (cn.g != null) {
        cn.g.aY = cn.f.aY;
        cn.g.aZ = cn.f.aZ;
        cn.g.c();
      } 
      parameo.b().readShort();
      parameo.b().readUTF();
      short s1 = parameo.b().readShort();
      byte[] arrayOfByte = null;
      if (s1 > 0) {
        arrayOfByte = new byte[s1];
        parameo.b().read(arrayOfByte);
      } 
      ft.p.b(arrayOfByte);
      if ((s1 = parameo.b().readByte()) >= 0) {
        short s = parameo.b().readShort();
        (ft.y = new dz()).a(s1, s);
      } else {
        ft.y = null;
      } 
      short s2 = parameo.b().readShort();
      ft.d.h = null;
      if (s2 > 0) {
        ft.d.h = new byte[s2];
        parameo.b().read(ft.d.h);
        ft.p.c(ft.d.h);
      } 
      cn.f.dQ = false;
      if (ft.p.d == 19) {
        cn.q.V = new dq(50, 1080, 96, 0, 0, 1, 0);
      } else if (ft.p.d == 67) {
        cn.q.V = new dq(50, 360, 672, 0, 0, 1, 0);
      } 
      bool = true;
      cs.a.d();
      s1 = parameo.b().readByte();
      for (s2 = 0; s2 < s1; s2++) {
        en en;
        (en = new en()).a = parameo.b().readShort();
        en.b = parameo.b().readShort();
        en.t = parameo.b().readUTF();
        if (en.a < 100) {
          en.m = 0;
          en.k = en.a - 8;
          en.l = en.b - 18;
          en.n = 0;
          en.i = -1;
        } else if (en.a > ft.p.e * cs.l - 100) {
          en.m = 1;
          en.n = 1;
          en.k = en.a + 8;
          en.l = en.b - 18;
          en.i = 1;
        } else if (en.b < ft.p.e * cs.l / 2) {
          en.b -= 10;
          en.m = 2;
          en.n = 2;
          en.k = en.a;
          en.l = en.b + 10;
          en.j = -1;
        } else {
          en.m = 3;
          en.n = 2;
          en.k = en.a;
          en.l = en.b - 20;
          en.j = 1;
        } 
        cs.a.a(en);
      } 
      try {
        ft.q.a();
      } catch (Exception exception2) {
        Exception exception1;
        (exception1 = null).printStackTrace();
      } 
      s2 = parameo.b().readByte();
      cs.u = parameo.b().readByte();
      ft.j();
      ft.m();
      ft.d.b = false;
      if (s2 == 1)
        ft.d.b = true; 
      if ((cs.w = parameo.b().readByte()) == 3) {
        cn.W = true;
      } else {
        cn.W = false;
      } 
      eg.g = true;
      ft.J = 0L;
      ft.N = 0L;
      try {
        cn.aP = parameo.b().readBoolean();
        cn.aO = parameo.b().readBoolean();
        return;
      } catch (Exception exception) {
        cn.aO = false;
        cn.aP = false;
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      if (bool)
        eg.g = true; 
      return;
    } 
  }
  
  public final void i(eo parameo) {
    try {
      a(parameo, (byte)0, (byte)1);
      return;
    } catch (Exception exception) {
      (this = null).printStackTrace();
      return;
    } 
  }
  
  public static void j(eo parameo) {
    ez ez = null;
    try {
      short s;
      if ((ez = ez.a(s = parameo.b().readShort(), (byte)0)) == null || ez.cK)
        return; 
      byte[] arrayOfByte = new byte[s = parameo.b().readByte()];
      int i;
      for (i = 0; i < arrayOfByte.length; i++)
        arrayOfByte[i] = -1; 
      if (ez == cn.f) {
        ek ek;
        (ek = bw.U).a.clear();
        if (cn.g != null)
          cn.i.d(cn.g); 
        for (byte b5 = 0; b5 < ez.eh.length; b5++)
          ez.eh[b5] = -1; 
      } 
      i = 0;
      ez.T();
      short s1;
      for (s1 = 0; s1 < s; s1++) {
        byte b5;
        if ((b5 = parameo.b().readByte()) > -1) {
          String str = parameo.b().readUTF();
          byte b6 = parameo.b().readByte();
          byte b7 = parameo.b().readByte();
          short s2 = parameo.b().readShort();
          byte b8 = parameo.b().readByte();
          byte b9 = parameo.b().readByte();
          short s3 = parameo.b().readShort();
          byte b10 = parameo.b().readByte();
          arrayOfByte[s1] = b8;
          byte b11;
          cz[] arrayOfCz = new cz[b11 = parameo.b().readByte()];
          byte b12;
          for (b12 = 0; b12 < b11; b12++) {
            int k = parameo.b().readUnsignedByte();
            int m = parameo.b().readInt();
            arrayOfCz[b12] = new cz(k, m);
            if (b5 == 8 && k == 67)
              i = 1; 
          } 
          b12 = parameo.b().readByte();
          j j = j.a(b5, str, s2, b9, b10, b6, 3, arrayOfCz, b7, false, (short)-1, 0L, s3, (byte)0, (byte)0, 0, (byte)0, b12);
          if (ez == cn.f) {
            bw.U.a(b5, j);
            if (j.J.c() > 0)
              for (byte b13 = 0; b13 < j.J.c(); b13++) {
                dl dl;
                if ((dl = (dl)j.J.a(b13)).a >= 23 && dl.a <= 27) {
                  ez.eh[b13] = 0;
                } else if (dl.a >= 28 && dl.a <= 32) {
                  ez.eh[b13] = 1;
                } else if (dl.a == -1) {
                  ez.eh[b13] = -1;
                } 
              }  
          } 
          if (b7 == 1)
            for (byte b13 = 0; b13 < arrayOfCz.length; b13++) {
              cz cz;
              if ((cz = arrayOfCz[b13]).a == 71)
                ez.c(2, cz.b); 
            }  
          if (b7 == 0)
            for (byte b13 = 0; b13 < arrayOfCz.length; b13++) {
              cz cz;
              if ((cz = arrayOfCz[b13]).a == 71)
                ez.c(1, cz.b); 
            }  
          if (b7 == 2)
            for (byte b13 = 0; b13 < arrayOfCz.length; b13++) {
              cz cz;
              if ((cz = arrayOfCz[b13]).a == 71)
                ez.c(0, cz.b); 
            }  
        } else {
          arrayOfByte[s1] = -1;
        } 
      } 
      ez.bK = i;
      byte b1 = parameo.b().readByte();
      "petId=" + b1;
      byte b2 = 0;
      byte b3 = 6;
      if (b1 > -1) {
        String str = parameo.b().readUTF();
        byte b5 = parameo.b().readByte();
        short s3 = parameo.b().readShort();
        short s4 = parameo.b().readShort();
        byte b6 = parameo.b().readByte();
        byte b7 = parameo.b().readByte();
        byte b8 = parameo.b().readByte();
        byte b9 = parameo.b().readByte();
        int j = parameo.b().readInt();
        short s5 = parameo.b().readShort();
        short s6 = parameo.b().readShort();
        s = parameo.b().readShort();
        i = parameo.b().readShort();
        s1 = parameo.b().readShort();
        short s2 = parameo.b().readShort();
        short s7 = parameo.b().readShort();
        byte b10;
        cz[] arrayOfCz = new cz[b10 = parameo.b().readByte()];
        for (byte b11 = 0; b11 < b10; b11++) {
          int k = parameo.b().readUnsignedByte();
          int m = parameo.b().readInt();
          int n = parameo.b().readInt();
          arrayOfCz[b11] = new cz(k, m, n);
        } 
        ea ea;
        (ea = new ea(b1, str, b6, b9, b5, 9, arrayOfCz, 14, s3, b6, b8, b7)).a(j, s5, s, i, s1, s2, s6, s7, s4);
        byte b12;
        if ((b12 = parameo.b().readByte()) == 1) {
          int k = parameo.b().readInt();
          String str1 = parameo.b().readUTF();
          long l = Long.parseLong(str1);
          i = k;
          ea ea1;
          (ea1 = ea).F = i;
          ea1.G = l;
        } 
        if (ez == cn.f)
          bw.U.a(b1, ea); 
        arrayOfByte[5] = b6;
        if (ft.s != null && ft.s.p == 14 && ah.j == 1)
          ah.i = ea; 
      } 
      ez.b(arrayOfByte);
      if (ez.equals(cn.f)) {
        s s2 = null;
        if (cn.f.cd != -1)
          s2 = s.a(cn.f, (short)cn.f.cd, b3, b2); 
        if ((cn.g = s2) != null)
          cn.a(cn.g); 
      } 
      byte b4;
      short[] arrayOfShort = new short[b4 = parameo.b().readByte()];
      for (byte b = 0; b < b4; b++) {
        arrayOfShort[b] = -1;
        arrayOfShort[b] = parameo.b().readShort();
      } 
      ez.dF = arrayOfShort;
      return;
    } catch (Exception exception) {
      dw.a("loi char wearing");
      if (cn.f == null)
        return; 
      if (ez != cn.f)
        ez.cK = true; 
      return;
    } 
  }
  
  public static void k(eo parameo) {
    try {
      short s2 = parameo.b().readShort();
      short s1;
      ez ez = ez.a(s1 = parameo.b().readShort(), (byte)1);
      if (cn.p.d(1, 2) && s2 == cn.f.ct) {
        cn.p.b++;
        cn.p.g();
        bq.o = -1;
      } 
      if (ez == null || ez.cK)
        return; 
      if (ez.br != 0)
        ez.br = 0; 
      ez.dx = 100;
      if (ez.cF == 4 || ez.dj) {
        if (ez.cx != 0) {
          ez.cK = true;
          if (ez.cx == 2)
            ez.de = null; 
        } 
        ez.aW = ft.aj;
        return;
      } 
      ez.br = 0;
      if (ez.cx != 0) {
        ez.cK = true;
        if (ez.cx == 2)
          ez.de = null; 
      } else {
        ez.a((au)ez, s2, ak.f(3));
      } 
      if (s2 == cn.f.ct && ez.dA >= 0) {
        ew.a(s1);
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public static void l(eo parameo) {
    try {
      byte b1 = parameo.b().readByte();
      short s = parameo.b().readShort();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      es es = new es("ReadMessenge vecObjectBeAttacked");
      for (byte b = 0; b < b3; b++) {
        short s2 = parameo.b().readShort();
        int k = parameo.b().readInt();
        int m = parameo.b().readInt();
        do do = new do((byte)14);
        bf bf;
        (bf = new bf(s2, b2, do)).a(k, m);
        ez ez1;
        if ((ez1 = ez.a(s2, b2)) != null && !ez1.cK)
          es.a(bf); 
      } 
      s s1 = (s)ez.a(s, (byte)9);
      ez ez = ez.a(s, (byte)0);
      int i = parameo.b().readInt();
      int j = parameo.b().readInt();
      if (ez != null) {
        ez.br = i;
        ez.bt = j;
      } 
      if (s1 != null) {
        s1.Q = es;
        s1.a((byte)2);
        s1.b(b1);
        return;
      } 
    } catch (Exception exception) {
      dw.a("loi ham pet attack " + exception.toString());
    } 
  }
  
  public static void m(eo parameo) {
    byte b1 = -1;
    byte b2 = -1;
    try {
      b1 = parameo.b().readByte();
      short s;
      au au;
      if ((au = (au)ez.a(s = parameo.b().readShort(), (byte)1)) == null || au.cK)
        return; 
      boolean bool = au.m();
      if (au.cF == 4) {
        if (au.dA < 0)
          return; 
        au.r();
      } 
      au.dD = false;
      au.bb = 0;
      au.bc = 0;
      if (b1 == 1) {
        int i = parameo.b().readInt();
        byte b = parameo.b().readByte();
        b2 = parameo.b().readByte();
        au.br = i;
        if (b2 <= 0)
          return; 
        if (au.Q != null && au.Q.c() > 0) {
          bf bf = (bf)au.Q.a(0);
          au.cQ = bf.a;
          if (au.dn == null)
            au.dn = new do((byte)14); 
          if (!bool)
            bf.g = au.dn; 
          au.t();
          au.s();
        } 
        es es1 = new es("ReadMessenge vecBe");
        boolean bool1 = false;
        es es2 = new es("ReadMessenge allPlayerDie");
        byte b3;
        for (b3 = 0; b3 < b2; b3++) {
          short s1 = parameo.b().readShort();
          int j = parameo.b().readInt();
          int k = parameo.b().readInt();
          byte b4 = parameo.b().readByte();
          do do = new do(b4);
          bf bf;
          (bf = new bf(s1, b, do)).a(j, k);
          j = parameo.b().readByte();
          bf.e = new int[j];
          bf.f = new int[j];
          for (byte b5 = 0; b5 < j; b5++) {
            bf.e[b5] = parameo.b().readByte();
            bf.f[b5] = parameo.b().readInt();
          } 
          ez ez;
          if ((ez = ez.a(s1, b)) != null && !ez.cK) {
            es1.a(bf);
            if (ez.br > 0)
              ez.br = k; 
            if (ez.ct == cn.f.ct) {
              int m = cn.f.bs;
              m = k / m * 100;
              cn.f.a((byte)4, (m > 20));
            } 
            if (ez.br <= 0) {
              bool1 = true;
              es2.a(ez);
            } 
          } 
        } 
        au.Q = es1;
        au.br = i;
        au.cU = true;
        au.O = 3000;
        au.P = ft.aj;
        if (bool1 || au.cx == 1 || au.cx == 2) {
          bf bf = (bf)au.Q.a(0);
          au.cQ = bf.a;
          if (au.dn == null)
            au.dn = new do((byte)14); 
          if (!bool)
            bf.g = au.dn; 
          au.t();
          au.s();
        } 
        for (b3 = 0; b3 < es2.c(); b3++) {
          ez ez;
          (ez = (ez)es2.a(b3)).N();
          ez.cF = 4;
          ez.aW = ft.aj;
          ez.ba = 0;
          cn.a(11, ez.aY, ez.aZ);
        } 
        return;
      } 
      if (b1 == 0) {
        if (au.Q != null && au.Q.c() > 0) {
          bf bf = (bf)au.Q.a(0);
          au.cQ = bf.a;
          if (au.dn == null)
            au.dn = new do((byte)14); 
          if (!bool)
            bf.g = au.dn; 
          au.t();
          au.s();
        } 
        au.cU = false;
        au.cN = null;
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      String.valueOf(b1) + " istarget";
      String.valueOf(b2) + " size";
    } 
  }
  
  public static void n(eo parameo) {
    try {
      short s = parameo.b().readShort();
      byte[] arrayOfByte = new byte[parameo.b().available()];
      parameo.b().read(arrayOfByte);
      if (s == 9999) {
        ez.de = aq.a(arrayOfByte);
        return;
      } 
      if (bk.m(s))
        di.a.a(new an(s, arrayOfByte)); 
      aq aq = aq.a(arrayOfByte);
      if (s >= 13000) {
        bw.ac.a(s - 2000, new fd(aq));
        return;
      } 
      if (s >= 10700) {
        bw.aj.a(s - 10700, new fd(aq));
        return;
      } 
      if (s >= 10600) {
        cs.s = aq;
        ft.q.a();
        return;
      } 
      if (s >= 10500) {
        cs.r = aq;
        return;
      } 
      if (s >= 10400) {
        cs.q = aq;
        return;
      } 
      if (s >= 10200) {
        s.x.a(s - 10200, new fd(aq));
        return;
      } 
      if (s >= 10000) {
        bw.ai.a(s - 10000, new fd(aq));
        return;
      } 
      if (s >= 9500) {
        bw.ah.a(s - 9500, new fd(aq));
        return;
      } 
      if (s >= 7000) {
        bw.ag.a(s - 7000, new fd(aq));
        return;
      } 
      if (s >= 6000) {
        ev.a.a(s - 6000, new fd(aq));
        return;
      } 
      if (s >= 5500) {
        bw.af.a(s - 5500, new fd(aq));
        return;
      } 
      if (s >= 5000) {
        bw.ae.a(s - 5000, new fd(aq));
        return;
      } 
      if (s >= 4000) {
        bw.ad.a(s - 4000, new fd(aq));
        return;
      } 
      if (s >= 3000) {
        cn.n.a(s - 3000, new fd(aq));
        return;
      } 
      if (s >= 2000) {
        bw.ac.a(s - 2000, new fd(aq));
        return;
      } 
      if (s >= 1000) {
        au.K.a(s - 1000, new fd(aq));
        return;
      } 
      cn.m.a(s, new fd(aq));
      return;
    } catch (Exception exception) {
      dw.a("loi ham load img ");
      exception.printStackTrace();
      return;
    } 
  }
  
  public final void o(eo parameo) {
    a(parameo, bw.V, (byte)0);
  }
  
  private static byte a(short paramShort, int paramInt) {
    for (byte b = 0; b < bw.V.c(); b++) {
      bw bw;
      if ((bw = (bw)bw.V.a(b)) != null && bw.u == 7 && bw.O == paramShort && bw.K >= paramInt)
        return 1; 
    } 
    return 0;
  }
  
  private static String b(short paramShort, int paramInt) {
    for (byte b = 0; b < bw.V.c(); b++) {
      bw bw;
      if ((bw = (bw)bw.V.a(b)) != null && bw.u == 7 && bw.O == paramShort)
        return String.valueOf(bw.K) + "/" + paramInt; 
    } 
    return "0/" + paramInt;
  }
  
  public static void p(eo parameo) {
    try {
      byte b = 8;
      String str1 = "";
      boolean bool = false;
      String str2 = parameo.b().readUTF();
      byte b1 = parameo.b().readByte();
      fn.t = false;
      if (b1 < 0) {
        ez ez;
        if ((ez = ez.a(b1, (byte)2)) != null && !ez.cK) {
          ez.cE = str2;
          return;
        } 
      } else {
        fn fn;
        ft.a(df.aD);
        short s = parameo.b().readShort();
        es es1 = new es("ReadMessenge vectorInfoNPC");
        byte b2 = 0;
        byte b3 = 0;
        if (b1 == u) {
          bool = true;
          b3 = fn.o;
          short s1;
          for (s1 = 0; s1 < s; s1++) {
            byte b4;
            if ((b4 = parameo.b().readByte()) == 3) {
              short s4 = parameo.b().readShort();
              String str = parameo.b().readUTF();
              byte b5 = parameo.b().readByte();
              byte b6 = parameo.b().readByte();
              short s5 = parameo.b().readShort();
              byte b7 = parameo.b().readByte();
              short s6 = parameo.b().readShort();
              byte b8 = parameo.b().readByte();
              byte b9;
              cz[] arrayOfCz = new cz[b9 = parameo.b().readByte()];
              byte b10;
              for (b10 = 0; b10 < b9; b10++) {
                int i = parameo.b().readUnsignedByte();
                int k = parameo.b().readInt();
                arrayOfCz[b10] = new cz(i, k);
              } 
              b10 = parameo.b().readByte();
              j j = j.a(s4, str, s5, b7, b8, b5, 3, arrayOfCz, b6, false, s4, 0L, s6, (byte)0, (byte)0, 0, b10, (byte)0);
              es1.a(j);
            } 
            if (b4 == 7) {
              short s4 = parameo.b().readShort();
              short s5 = parameo.b().readShort();
              byte b5 = parameo.b().readByte();
              byte b6 = parameo.b().readByte();
              long l1 = parameo.b().readLong();
              j j;
              if ((j = bw.b(s4)) != null) {
                j j1 = j.a(s4, j.g, j.t, 7, l1, (byte)0, j.h, j.P, j.A, s5, b5, b6);
                es1.a(j1);
              } else {
                j j1;
                (j1 = new j()).O = s4;
                j1.K = s5;
                j1.x = b5;
                j1.y = b6;
                j1.q = l1;
                j1.Q = 0;
                j1.u = 7;
                bw.c(s4);
                es1.a(j1);
              } 
            } 
            short s2 = parameo.b().readShort();
            short s3 = parameo.b().readShort();
            long l = parameo.b().readLong();
            fo fo;
            if (b4 == 4 && (fo = fo.b(s2)) != null) {
              j j = new j(fo.a, fo.b, fo.c, fo.j, s3, 4, l, fo.i, (byte)0, (byte)0, (byte)0);
              es1.a(j);
            } 
          } 
          fn.E = s1 = parameo.b().readShort();
        } else if (b1 == q) {
          b3 = fn.k;
          for (byte b4 = 0; b4 < s; b4++) {
            short s1 = parameo.b().readShort();
            String str = parameo.b().readUTF();
            byte b5 = parameo.b().readByte();
            byte b6 = parameo.b().readByte();
            short s2 = parameo.b().readShort();
            long l = parameo.b().readLong();
            short s3 = parameo.b().readShort();
            byte b7 = parameo.b().readByte();
            byte b8;
            cz[] arrayOfCz = new cz[b8 = parameo.b().readByte()];
            byte b9;
            for (b9 = 0; b9 < b8; b9++) {
              int i = parameo.b().readUnsignedByte();
              int k = parameo.b().readInt();
              arrayOfCz[b9] = new cz(i, k);
            } 
            b9 = parameo.b().readByte();
            j j = j.a(s1, str, s2, (byte)0, b7, b5, 3, arrayOfCz, b6, false, s1, l, s3, (byte)0, (byte)0, 0, b9, (byte)0);
            es1.a(j);
          } 
        } else if (b1 == 0) {
          for (byte b4 = 0; b4 < s; b4++) {
            short s1;
            fo fo;
            if ((fo = fo.b(s1 = parameo.b().readShort())) != null) {
              j j = new j(fo.a, fo.b, fo.c, fo.j, 1, 4, fo.h, fo.i, fo.g, (byte)0, (byte)0);
              es1.a(j);
            } 
          } 
        } else if (b1 == e || b1 == n || b1 == a) {
          if (b1 == n)
            b3 = fn.h; 
          for (byte b4 = 0; b4 < s; b4++) {
            short s1 = parameo.b().readShort();
            String str = parameo.b().readUTF();
            byte b5 = parameo.b().readByte();
            byte b6 = parameo.b().readByte();
            short s2 = parameo.b().readShort();
            long l = parameo.b().readLong();
            short s3 = parameo.b().readShort();
            byte b7 = parameo.b().readByte();
            byte b8;
            cz[] arrayOfCz = new cz[b8 = parameo.b().readByte()];
            byte b9;
            for (b9 = 0; b9 < b8; b9++) {
              int i = parameo.b().readUnsignedByte();
              int k = parameo.b().readInt();
              arrayOfCz[b9] = new cz(i, k);
            } 
            b9 = parameo.b().readByte();
            j j = j.a(s1, str, s2, (byte)0, b7, b5, 3, arrayOfCz, b6, false, s1, l, s3, (byte)0, (byte)0, 0, b9, (byte)0);
            if (b1 == a)
              j.T = parameo.b().readUTF(); 
            es1.a(j);
          } 
          if (b1 == a)
            str1 = parameo.b().readUTF(); 
        } else if (b1 == f) {
          b3 = fn.b;
          for (byte b4 = 0; b4 < s; b4++) {
            short s1 = parameo.b().readShort();
            String str = parameo.b().readUTF();
            short s2 = parameo.b().readShort();
            long l1 = parameo.b().readLong();
            byte b5 = parameo.b().readByte();
            byte b6;
            cz[] arrayOfCz2 = new cz[b6 = parameo.b().readByte()];
            for (byte b7 = 0; b7 < b6; b7++) {
              int i = parameo.b().readUnsignedByte();
              int k = parameo.b().readInt();
              arrayOfCz2[b7] = new cz(i, k);
            } 
            s1 = 0;
            s1 = 0;
            b5 = b5;
            long l2 = l1;
            short s3 = s1;
            s1 = 0;
            cz[] arrayOfCz1 = arrayOfCz2;
            s1 = 6;
            s1 = 0;
            s2 = s2;
            str = str;
            s1 = s1;
            j j = new j(s1, str, s2, (byte)0, 6, arrayOfCz1, s3, l2, b5, (byte)0, (byte)0);
            es1.a(j);
          } 
        } else if (b1 == g) {
          b2 = fn.c;
          b = 9;
          if (bw.W.c() == 0)
            q.a().a((byte)-1, (short)0, (byte)0, (short)0); 
          es1 = bw.W;
        } else if (b1 == o) {
          b2 = fn.i;
          b = 13;
          b3 = fn.i;
        } else if (b1 == h) {
          b = 8;
          for (byte b4 = 0; b4 < s; b4++) {
            short s1;
            j j;
            if ((j = bw.b(s1 = parameo.b().readShort())) != null) {
              j j1 = j.a(s1, j.g, j.t, 7, j.q, j.Q, j.h, (short)j.P, j.A, (short)1, j.x, j.y);
              es1.a(j1);
            } else {
              j j1;
              (j1 = new j()).O = s1;
              j1.u = 7;
              es1.a(j1);
            } 
          } 
        } else if (b1 == i || b1 == p) {
          b2 = fn.d;
          b = 10;
          if (b1 == p)
            fn.t = true; 
        } else if (b1 == w) {
          b2 = fn.q;
          b = 10;
        } else if (b1 == x) {
          b2 = fn.r;
          b = 10;
        } else if (b1 == v) {
          b2 = fn.p;
          b = 10;
        } else if (b1 == s) {
          b2 = fn.m;
          b = 10;
        } else if (b1 == t) {
          b2 = fn.n;
          b = 10;
        } else if (b1 == r) {
          b2 = fn.l;
          b = 10;
        } else if (b1 == j || b1 == k) {
          b = 8;
          b3 = fn.e;
          for (byte b4 = 0; b4 < s; b4++) {
            short s1 = 0;
            if (b1 == k)
              s1 = fn.A; 
            j j = new j(parameo.b().readShort(), s1);
            es1.a(j);
          } 
        } else if (b1 == l) {
          b = 8;
          b3 = 0;
          for (byte b4 = 0; b4 < s; b4++) {
            short s1;
            fo fo;
            if ((fo = fo.b(s1 = parameo.b().readShort())) != null) {
              j j = new j(fo.a, fo.b, fo.c, fo.j, 1, 4, fo.h, fo.i, fo.g, (byte)0, (byte)0);
              es1.a(j);
            } 
          } 
        } else if (b1 == m) {
          b2 = fn.f;
          b = 10;
        } 
        es es2 = new es("ReadMessenge vec11");
        if (b1 != j && b1 != k && b1 != l) {
          (fn = new fn(bw.V, (byte)0, df.dx, -1, b2)).F = bool;
          es2.a(fn);
        } 
        c c = null;
        if (b1 == i || b1 == p) {
          (c = new c(str2, (byte)0)).bb = (b1 == p);
          if (b1 == p)
            fn.t = true; 
          c.l = null;
          c.m = null;
          c.n = null;
          for (byte b4 = 0; b4 < c.q.length; b4++) {
            j j = bw.b(c.q[b4]);
            int i = 0;
            bw bw;
            if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
              i = bw.K; 
            c.p[b4] = i;
          } 
        } else if (b1 == r) {
          c = new c(str2, c.d);
          c.G.d();
          c.l = null;
          c.m = null;
          c.n = null;
          for (byte b4 = 0; b4 < c.q.length; b4++) {
            j j = bw.b(c.q[b4]);
            int i = 0;
            bw bw;
            if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
              i = bw.K; 
            c.p[b4] = i;
          } 
        } else if (b1 == t) {
          c = new c(str2, c.f);
          c.G.d();
          c.l = null;
          c.m = null;
          c.n = null;
          for (byte b4 = 0; b4 < c.q.length; b4++) {
            j j = bw.b(c.q[b4]);
            int i = 0;
            bw bw;
            if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
              i = bw.K; 
            c.p[b4] = i;
          } 
        } else if (b1 == w) {
          (c = new c(str2, c.g)).bd = true;
          c.G.d();
          c.l = null;
          c.m = null;
          c.n = null;
          byte b4;
          for (b4 = 0; b4 < c.q.length; b4++) {
            j j = bw.b(c.q[b4]);
            int i = 0;
            bw bw;
            if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
              i = bw.K; 
            c.p[b4] = i;
          } 
          b4 = parameo.b().readByte();
          c.G.d();
          for (byte b5 = 0; b5 < b4; b5++) {
            short s1 = parameo.b().readShort();
            short s2 = parameo.b().readShort();
            if (s1 != -1) {
              c.i[b5] = a(s1, s2);
              c.h[b5] = b(s1, s2);
              j j;
              if ((j = bw.b(s1)) != null)
                c.G.a(j); 
              if (j == null) {
                j j1;
                (j1 = new j()).O = s1;
                j1.u = 7;
                c.G.a(j1);
              } 
            } 
          } 
        } else if (b1 == x) {
          (c = new c(str2, c.g)).be = true;
          c.G.d();
          c.l = null;
          c.m = null;
          c.n = null;
          for (byte b4 = 0; b4 < c.q.length; b4++) {
            j j = bw.b(c.q[b4]);
            int i = 0;
            bw bw;
            if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
              i = bw.K; 
            c.p[b4] = i;
          } 
        } else if (b1 == v) {
          c = new c(str2, c.g);
          c.G.d();
          c.l = null;
          c.m = null;
          c.n = null;
          for (byte b4 = 0; b4 < c.q.length; b4++) {
            j j = bw.b(c.q[b4]);
            int i = 0;
            bw bw;
            if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
              i = bw.K; 
            c.p[b4] = i;
          } 
        } else if (b1 == s) {
          c = new c(str2, c.e);
          c.G.d();
          c.l = null;
          c.m = null;
          c.n = null;
          for (byte b4 = 0; b4 < c.q.length; b4++) {
            j j = bw.b(c.q[b4]);
            int i = 0;
            bw bw;
            if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
              i = bw.K; 
            c.p[b4] = i;
          } 
        } else if (b1 == m) {
          c = new c(str2, c.b);
          c.l = null;
          c.m = null;
          c.n = null;
        } else {
          fn = new fn(es1, b, str2, b1, b3);
          if (b1 == a)
            fn.a(str1); 
        } 
        es2.a(fn);
        ft.v = new eu();
        if (b1 != j && b1 != k && b1 != l) {
          ft.v.a = 1;
        } else {
          ft.v.a = 0;
        } 
        ft.v.a(es2);
        ft.v.a(cn.b());
        ft.j();
        if (b1 == i || b1 == m || b1 == p) {
          fn.b();
          return;
        } 
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public static void q(eo parameo) {
    try {
      short s = parameo.b().readShort();
      int i;
      for (i = 0; i < s; i++) {
        short s2 = parameo.b().readShort();
        short s3 = parameo.b().readShort();
        long l = parameo.b().readLong();
        String str1 = parameo.b().readUTF();
        String str2 = parameo.b().readUTF();
        byte b3 = parameo.b().readByte();
        byte b4 = parameo.b().readByte();
        byte b5 = parameo.b().readByte();
        short s4 = parameo.b().readShort();
        boolean bool = parameo.b().readBoolean();
        fo fo = new fo(s2, s3, l, str1, str2, b3, b4, b5, s4, bool);
        fo.m.a(s2, fo);
      } 
      bw.d = new String[i = parameo.b().readUnsignedByte()];
      bw.e = new byte[i];
      bw.f = new byte[i];
      short s1;
      for (s1 = 0; s1 < i; s1++) {
        bw.d[s1] = parameo.b().readUTF();
        bw.e[s1] = parameo.b().readByte();
        bw.f[s1] = parameo.b().readByte();
      } 
      s1 = parameo.b().readShort();
      byte b1;
      for (b1 = 0; b1 < s1; b1++) {
        short s2 = parameo.b().readShort();
        short s3 = parameo.b().readShort();
        long l = parameo.b().readLong();
        String str1 = parameo.b().readUTF();
        String str2 = parameo.b().readUTF();
        byte b3 = parameo.b().readByte();
        byte b4 = parameo.b().readByte();
        byte b5 = parameo.b().readByte();
        short s4 = parameo.b().readShort();
        s = parameo.b().readByte();
        i = parameo.b().readByte();
        j j;
        (j = j.a(s2, str1, s3, 7, l, b4, str2, s4, b3, (short)1, b5, s)).d(i);
        fo.n.a(s2, j);
      } 
      fn.u = parameo.b().readShort();
      fn.v = parameo.b().readShort();
      fn.w = parameo.b().readShort();
      fn.x = parameo.b().readShort();
      fn.y = parameo.b().readShort();
      fn.z = parameo.b().readShort();
      fn.A = parameo.b().readShort();
      fn.B = parameo.b().readByte();
      bs.k = 0;
      b1 = parameo.b().readByte();
      "size pet template = " + b1;
      byte b2;
      for (b2 = 0; b2 < b1; b2++) {
        short s2 = parameo.b().readShort();
        byte b = parameo.b().readByte();
        fo.p.a(s2, new Byte(b));
      } 
      try {
        ez.dG = new short[b2 = parameo.b().readByte()];
        for (byte b = 0; b < b2; b++)
          ez.dG[b] = parameo.b().readShort(); 
      } catch (Exception exception) {
        dw.a("----Err Readmess:-- itemTemplate");
      } 
      b2 = 0;
      try {
        cf.W = b2 = parameo.b().readByte();
      } catch (Exception exception) {
        cf.W = 0;
      } 
      try {
        byte b;
        cn.b = new short[b = parameo.b().readByte()];
        for (byte b3 = 0; b3 < b; b3++)
          cn.b[b3] = (short)parameo.b().readUnsignedByte(); 
        return;
      } catch (Exception exception) {
        cn.b = new short[0];
        return;
      } 
    } catch (Exception exception) {
      l.a().c();
      es es = new es("ReadMessenge vec7");
      if (x.f && ft.a != ft.b)
        es.a(new bt(df.cL, 0)); 
      es.a(new bt(df.bR, 6));
      ft.a(df.ck, es);
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void r(eo parameo) {
    try {
      byte[][] arrayOfByte;
      byte[] arrayOfByte1;
      short s = parameo.b().readShort();
      byte b1;
      for (b1 = 0; b1 < s; b1++) {
        short s1 = parameo.b().readShort();
        arrayOfByte = (byte[][])parameo.b().readUTF();
        short s2 = (short)parameo.b().readUnsignedByte();
        int i = parameo.b().readInt();
        byte b = parameo.b().readByte();
        db db = new db(s1, s2, i, b, (String)arrayOfByte);
        au.L.a(db);
      } 
      ai.c = new byte[b1 = parameo.b().readByte()][];
      byte b2;
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.c[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.c[b2][b5] = parameo.b().readByte(); 
      } 
      ai.d = new byte[b1 = parameo.b().readByte()][];
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.d[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.d[b2][b5] = parameo.b().readByte(); 
      } 
      ai.e = new byte[b1 = parameo.b().readByte()][];
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.e[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.e[b2][b5] = parameo.b().readByte(); 
      } 
      ai.f = new byte[b1 = parameo.b().readByte()][];
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.f[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.f[b2][b5] = parameo.b().readByte(); 
      } 
      ai.g = new byte[b1 = parameo.b().readByte()][];
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.g[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.g[b2][b5] = parameo.b().readByte(); 
      } 
      ai.h = new byte[b1 = parameo.b().readByte()][];
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.h[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.h[b2][b5] = parameo.b().readByte(); 
      } 
      ai.i = new byte[b1 = parameo.b().readByte()][];
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.i[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.i[b2][b5] = parameo.b().readByte(); 
      } 
      ai.j = new byte[b1 = parameo.b().readByte()][];
      for (b2 = 0; b2 < b1; b2++) {
        byte b = parameo.b().readByte();
        ai.j[b2] = new byte[b];
        for (byte b5 = 0; b5 < b; b5++)
          ai.j[b2][b5] = parameo.b().readByte(); 
      } 
      ai.b = new byte[b1 = parameo.b().readByte()];
      for (b2 = 0; b2 < b1; b2++)
        ai.b[b2] = parameo.b().readByte(); 
      bw.al = new byte[b2 = parameo.b().readByte()];
      byte b3;
      for (b3 = 0; b3 < b2; b3++)
        bw.al[b3] = parameo.b().readByte(); 
      try {
        s.y = new byte[b3 = parameo.b().readByte()];
        for (byte b = 0; b < b3; b++)
          s.y[b] = parameo.b().readByte(); 
      } catch (Exception null) {
        s.y = new byte[] { 2, 1, 2, 1 };
      } 
      try {
        fo.k = new int[b3 = parameo.b().readByte()];
        for (byte b = 0; b < b3; b++)
          fo.k[b] = parameo.b().readByte(); 
      } catch (Exception null) {
        fo.k = new int[] { 
            -1, 3, 4, 5, 12, 2, 1, 6, 4, 7, 
            -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, 
            -2, -2, -2, -2 };
      } 
      try {
        fo.l = new int[b3 = parameo.b().readByte()];
        for (byte b = 0; b < b3; b++)
          fo.l[b] = parameo.b().readByte(); 
      } catch (Exception null) {
        fo.l = new int[] { 1, 7, 6, 2, -1, 4, 8, 10, 5 };
      } 
      try {
        au.S = new short[b3 = parameo.b().readByte()];
        for (byte b = 0; b < b3; b++)
          au.S[b] = parameo.b().readShort(); 
      } catch (Exception null) {
        au.S = new short[] { 104, 103, 105, 106, 135 };
      } 
      try {
        bq.E = new byte[b3 = parameo.b().readByte()];
        for (byte b = 0; b < b3; b++)
          bq.E[b] = parameo.b().readByte(); 
      } catch (Exception null) {
        bq.E = null;
      } 
      try {
        b3 = parameo.b().readByte();
        for (byte b = 0; b < b3; b++) {
          byte b5 = parameo.b().readByte();
          short s1;
          if ((s1 = parameo.b().readShort()) > 0) {
            byte[] arrayOfByte2 = new byte[s1];
            for (s = 0; s < s1; s++)
              arrayOfByte2[s] = parameo.b().readByte(); 
            es es = new es();
            fa fa = new fa(arrayOfByte2, b5);
            es.a(fa);
            s.b.a(b5, es);
          } 
        } 
      } catch (Exception null) {}
      try {
        short s1;
        arrayOfByte = new byte[s1 = parameo.b().readShort()][];
        for (byte b = 0; b < s1; b++) {
          byte b5 = parameo.b().readByte();
          arrayOfByte[b] = new byte[b5];
          for (b2 = 0; b2 < b5; b2++)
            arrayOfByte[b][b2] = parameo.b().readByte(); 
        } 
      } catch (Exception exception) {
        arrayOfByte = null;
      } 
      if (arrayOfByte != null)
        i.a = arrayOfByte; 
      byte b4 = 0;
      try {
        arrayOfByte1 = new byte[b4 = parameo.b().readByte()];
        for (byte b = 0; b < b4; b++)
          arrayOfByte1[b] = parameo.b().readByte(); 
      } catch (Exception exception) {
        arrayOfByte1 = null;
      } 
      if (arrayOfByte1 != null) {
        ai.a = arrayOfByte1;
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public static void s(eo parameo) {
    try {
      bs.g();
      bs.h();
      cn.f = new bq(0, (byte)0, "unname", 0, 0);
      bw.V.d();
      bw.W.d();
      x.a.d();
      byte b = parameo.b().readByte();
      es es = new es("ReadMessenge vList");
      int i = (ft.W - 150) / 4;
      int j = i;
      for (byte b1 = 0; b1 < b; b1++) {
        int k = ft.Z - 25 - 20 * (b1 + 1) % 2;
        int m = parameo.b().readInt();
        String str = parameo.b().readUTF();
        byte b2 = parameo.b().readByte();
        byte b3 = parameo.b().readByte();
        byte b4 = parameo.b().readByte();
        byte b5 = parameo.b().readByte();
        byte[] arrayOfByte = new byte[12];
        short s;
        for (s = 0; s < arrayOfByte.length; s++)
          arrayOfByte[s] = -1; 
        for (s = 0; s < b5; s++) {
          byte b7 = parameo.b().readByte();
          byte b8 = parameo.b().readByte();
          arrayOfByte[b7] = b8;
        } 
        s = parameo.b().readShort();
        byte b6 = parameo.b().readByte();
        parameo.b().readByte();
        parameo.b().readByte();
        bm bm = new bm(m, (byte)0, str, 0, 0);
        if ((m = parameo.b().readShort()) >= 0)
          bm.cO = new em(0, m, parameo.b().readUTF(), parameo.b().readByte()); 
        bm.bx = b6;
        bm.a(b2, b4, b3);
        bm.a(arrayOfByte);
        bm.by = s;
        bm.aY = j + 25;
        bm.aZ = k + 50;
        j += i + 50;
        es.a(bm);
      } 
      ft.i.a(es);
      if (b == 0) {
        (ft.j = new ep()).a((byte)0);
        return;
      } 
      ft.i.c();
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void t(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      for (byte b1 = 0; b1 < b; b1++) {
        String str1 = parameo.b().readUTF();
        String str2 = parameo.b().readUTF();
        byte b2 = parameo.b().readByte();
        byte b3 = parameo.b().readByte();
        short s1 = parameo.b().readShort();
        short s2 = parameo.b().readShort();
        byte b4 = parameo.b().readByte();
        byte b5 = parameo.b().readByte();
        byte b6 = parameo.b().readByte();
        ez ez;
        if ((ez = ez.a(b2, (byte)2)) == null) {
          ez = new ey(str1, str2, b2, b3, s1, s2, b4, b5, b6);
        } else {
          ez.cB = str1;
          ez.cC = str2;
          ez.cS = b3;
          ez.aY = s1;
          ez.aZ = s2;
        } 
        ez.cK = false;
        ez.cT = parameo.b().readByte() + 500;
        ez.cD = parameo.b().readUTF();
        ez.co = parameo.b().readByte();
        ez.bG = (parameo.b().readByte() == 1);
        ez.cu = 2;
        cn.a(ez);
        ex.a(new fk(b2, s1, s2));
        if (b2 == -52) {
          du du = new du((byte)0, (byte)2, s1 + 48, s2 + 10);
          if (!cn.i.b(du))
            cn.a(du); 
          du = new du((byte)2, (byte)0, s1 + 43, s2 - 4);
          if (!cn.i.b(du))
            cn.a(du); 
          du = new du((byte)3, (byte)3, s1 - 18, s2 + 7);
          if (!cn.i.b(du))
            cn.a(du); 
        } 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void u(eo parameo) {
    try {
      byte b;
      if ((b = parameo.b().readByte()) < 3) {
        byte b2 = parameo.b().readByte();
        short s = 0;
        boolean bool = false;
        byte b3 = 0;
        byte b4 = 0;
        String str1 = null;
        String str2 = null;
        if (b == 0) {
          ew.a.d();
        } else if (b == 1) {
          ew.b.d();
        } else if (b == 2) {
          ew.c.d();
          ew.d.d();
        } 
        for (byte b5 = 0; b5 < b2; b5 = (byte)(b5 + 1)) {
          String str3;
          byte b6;
          ew ew2;
          String str4;
          ew ew1;
          String str5;
          String str6;
          s = parameo.b().readShort();
          bool = parameo.b().readBoolean();
          str1 = parameo.b().readUTF();
          switch (b) {
            case 0:
              b4 = parameo.b().readByte();
              str2 = parameo.b().readUTF();
              b3 = parameo.b().readByte();
              str5 = parameo.b().readUTF();
              ew2 = new ew(s, bool, str1, b4, str2, b3, str5);
              ew.a.a(ew2);
              break;
            case 1:
              b4 = parameo.b().readByte();
              str3 = parameo.b().readUTF();
              str4 = parameo.b().readUTF();
              ew1 = new ew(s, bool, str1, b4, str3, str4);
              ew.b.a(ew1);
              break;
            case 2:
              b6 = parameo.b().readByte();
              str5 = parameo.b().readUTF();
              str6 = parameo.b().readUTF();
              b4 = parameo.b().readByte();
              if (b6 == 0) {
                byte b7;
                short[] arrayOfShort1 = new short[b7 = parameo.b().readByte()];
                short[] arrayOfShort2 = new short[b7];
                short[] arrayOfShort3 = new short[b7];
                for (byte b8 = 0; b8 < b7; b8 = (byte)(b8 + 1)) {
                  arrayOfShort1[b8] = parameo.b().readShort();
                  arrayOfShort3[b8] = parameo.b().readShort();
                  arrayOfShort2[b8] = parameo.b().readShort();
                } 
                ew ew = new ew(s, bool, str1, str6, b6, str5, b4, arrayOfShort1, arrayOfShort2, arrayOfShort3);
              } else if (b6 == 1) {
                byte b7;
                short[] arrayOfShort1 = new short[b7 = parameo.b().readByte()];
                short[] arrayOfShort2 = new short[b7];
                short[] arrayOfShort3 = new short[b7];
                for (byte b8 = 0; b8 < b7; b8 = (byte)(b8 + 1)) {
                  arrayOfShort1[b8] = parameo.b().readShort();
                  arrayOfShort3[b8] = parameo.b().readShort();
                  arrayOfShort2[b8] = parameo.b().readShort();
                } 
                ew ew = new ew(s, bool, str1, str6, b6, str5, b4, arrayOfShort1, arrayOfShort2, arrayOfShort3);
              } else if (b6 == 2) {
                b4 = parameo.b().readByte();
                String str = parameo.b().readUTF();
                ew1 = new ew(s, bool, str1, str6, b4, str);
              } 
              if (ew1 != null) {
                if (bool) {
                  ew.c.a(ew1);
                  break;
                } 
                ew.d.a(ew1);
              } 
              break;
          } 
        } 
        if (b != 0 && (b == 1 || b == 2))
          ((fl)ft.u.b.a(4)).b(); 
      } else {
        parameo.b().readByte();
        boolean bool1 = false;
        parameo.b().readByte();
        boolean bool2 = false;
      } 
      byte b1;
      for (b1 = 0; b1 < cn.i.c(); b1++) {
        ez ez;
        if ((ez = (ez)cn.i.a(b1)).cu == 2) {
          if (b == 0) {
            if (ez.cn == 1)
              ez.cn = 0; 
          } else if (b == 1) {
            if (ez.cn == 3)
              ez.cn = 0; 
          } else if (b == 2 && ez.cn == 2) {
            ez.cn = 0;
          } 
          byte b2;
          for (b2 = 0; b2 < ew.a.c(); b2++) {
            ew ew;
            if ((ew = (ew)ew.a.a(b2)).h == ez.ct && ez.cn != 3)
              ez.cn = 1; 
          } 
          for (b2 = 0; b2 < ew.b.c(); b2++) {
            ew ew;
            if ((ew = (ew)ew.b.a(b2)).g == ez.ct)
              ez.cn = 3; 
          } 
          for (b2 = 0; b2 < ew.c.c(); b2++) {
            ew ew;
            if ((ew = (ew)ew.c.a(b2)).g == ez.ct && ez.cn == 0)
              ez.cn = 2; 
          } 
          for (b2 = 0; b2 < ew.d.c(); b2++) {
            ew ew;
            if ((ew = (ew)ew.d.a(b2)).g == ez.ct && ez.cn == 0)
              ez.cn = 2; 
          } 
        } 
      } 
      for (b1 = 0; b1 < ex.f.c(); b1++) {
        fk fk = (fk)ex.f.a(b1);
        if (b == 0) {
          if (fk.d == 1)
            fk.d = 0; 
        } else if (b == 1) {
          if (fk.d == 3)
            fk.d = 0; 
        } else if (b == 2 && fk.d == 2) {
          fk.d = 0;
        } 
        ez ez;
        if ((ez = ez.a(fk.a, (byte)2)) != null && !ez.cK)
          fk.d = ez.cn; 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void v(eo parameo) {
    try {
      short s = parameo.b().readShort();
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      es es = new es("ReadMessenge cmd");
      for (byte b = 0; b < b2; b++) {
        bt bt = new bt(parameo.b().readUTF(), null);
        es.a(bt);
      } 
      String str = parameo.b().readUTF();
      ft.o.a(es, 2, b1, s, str);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void w(eo parameo) {
    try {
      byte b;
      af.c = new cz[b = parameo.b().readByte()];
      af.d = new cz[b];
      for (byte b1 = 0; b1 < b; b1++) {
        int i = parameo.b().readUnsignedByte();
        int j = parameo.b().readInt();
        cz cz;
        if ((cz = new cz(i, j)).a >= 16 && cz.a <= 20)
          af.e[cz.a - 16] = j.a(cz.b); 
        af.c[b1] = cz;
        af.d[b1] = cz;
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void x(eo parameo) {
    try {
      short s;
      ez ez;
      if ((ez = ez.a(s = parameo.b().readShort(), (byte)0)) != null && !ez.cK) {
        ez.bz = parameo.b().readShort();
        int i = parameo.b().readInt();
        if (!ft.B || ez == cn.f) {
          cn.a(String.valueOf(i) + "xp", ez.aY, ez.aZ - ez.be, 1, s);
          return;
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public static void y(eo parameo) {
    try {
      short s;
      ez ez;
      if ((ez = ez.a(s = parameo.b().readShort(), (byte)0)) != null && !ez.cK) {
        ez.by = parameo.b().readByte();
        cn.a(42, s, (byte)0, s, (byte)0, 0, 0);
        if (ez == cn.f && cn.p.d(5, 8)) {
          cn.p.f();
          cn.p.g();
          if (bq.o == -1) {
            bq.o = 0;
            return;
          } 
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public static void z(eo parameo) {
    try {
      short s;
      byte[] arrayOfByte = new byte[s = parameo.b().readShort()];
      parameo.b().read(arrayOfByte);
      cs.a(arrayOfByte);
      cn.X.d();
      cf.X = -1;
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void A(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      short s1 = parameo.b().readShort();
      short s2 = parameo.b().readShort();
      short s3 = parameo.b().readShort();
      String str = parameo.b().readUTF();
      byte b1 = 0;
      if (b == 3 || b == 4 || b == 7)
        b1 = parameo.b().readByte(); 
      int i = parameo.b().readShort();
      ez ez;
      if ((ez = ez.a(s1, (byte)1)) != null && !ez.cK) {
        i = ez.aY;
        int j = ez.aZ;
        fv fv;
        cn.a(fv = new fv(s3, b, str, i, j, s2, b1));
        return;
      } 
      if ((ez = ez.a(i, (byte)0)) != null) {
        i = ez.aY;
        int j = ez.aZ;
        fv fv;
        cn.a(fv = new fv(s3, b, str, i, j, s2, b1));
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void B(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      short s2 = parameo.b().readShort();
      short s1 = parameo.b().readShort();
      ez ez2;
      if ((ez2 = ez.e(s2, b)) == null || ez2.cK)
        return; 
      if (b == 5 && s1 == cn.f.ct)
        ew.a(ez2.cS, ez2.cB); 
      ez ez1;
      if ((ez1 = ez.a(s1, (byte)0)) != null && !ez1.cK) {
        if (!ft.B || ez2 == cn.f)
          if (ez2.cu == 3 && ez2.cs > 0) {
            cn.a(ez2.cB, ez1.aY, ez1.aZ - ez1.be / 2, -ez2.cs, s1);
          } else {
            cn.a(ez2.cB, ez1.aY, ez1.aZ - ez1.be / 2, 5, s1);
          }  
        ez2.i(ez1.aY, ez1.aZ - ez1.be / 2);
        ez2.cU = true;
        return;
      } 
      ez2.cK = true;
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void C(eo parameo) {
    try {
      short s1 = parameo.b().readShort();
      String str = parameo.b().readUTF();
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      short s2 = parameo.b().readShort();
      byte b4;
      int[] arrayOfInt = new int[b4 = parameo.b().readByte()];
      byte[] arrayOfByte = new byte[b4];
      for (byte b = 0; b < b4; b++) {
        arrayOfByte[b] = parameo.b().readByte();
        arrayOfInt[b] = parameo.b().readInt();
      } 
      fo fo = new fo(s1, str, b1, b2, b3, s2, arrayOfInt, arrayOfByte);
      fo.o.a(s1, fo);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void D(eo parameo) {
    try {
      ah.b = 0;
      es es = new es("ReadMessenge vec14");
      byte b = parameo.b().readByte();
      byte b1;
      for (b1 = 0; b1 < b; b1++) {
        ev ev;
        (ev = new ev()).b = parameo.b().readByte();
        ev.f = parameo.b().readByte();
        ev.c = parameo.b().readUTF();
        ev.e = parameo.b().readByte();
        if (ev.e == 1)
          ah.b = (byte)(ah.b + 1); 
        ev.h = parameo.b().readShort();
        ev.d = parameo.b().readUTF();
        ev.g = parameo.b().readByte();
        parameo.b().readByte();
        byte b3 = parameo.b().readByte();
        ev.k = new fc[b3];
        for (byte b4 = 0; b4 < b3; b4++) {
          ev.k[b4] = new fc();
          (ev.k[b4]).a = parameo.b().readShort();
          (ev.k[b4]).e = parameo.b().readShort();
          if (b4 == 0)
            ev.i = (ev.k[b4]).e; 
          (ev.k[b4]).g = parameo.b().readInt();
          (ev.k[b4]).h = parameo.b().readInt();
          (ev.k[b4]).i = parameo.b().readByte();
          (ev.k[b4]).b = parameo.b().readShort();
          (ev.k[b4]).c = parameo.b().readShort();
          (ev.k[b4]).d = parameo.b().readShort();
          byte b5 = parameo.b().readByte();
          (ev.k[b4]).k = new cz[b5];
          for (byte b6 = 0; b6 < b5; b6++)
            (ev.k[b4]).k[b6] = new cz(parameo.b().readUnsignedByte(), parameo.b().readInt()); 
          (ev.k[b4]).j = parameo.b().readByte();
          (ev.k[b4]).f = parameo.b().readShort();
        } 
        ev.j = parameo.b().readShort();
        ev.l = parameo.b().readByte();
        es.a(ev);
      } 
      y.a = ak.d(es = ak.c(es));
      ct.a(cn.f.bx);
      cn.f.U.a(y.a);
      ft.d.a = true;
      ah.f = dw.a(ah.b, 3);
      b1 = 0;
      for (byte b2 = 0; b2 < y.a.c(); b2++) {
        ev ev;
        if ((ev = (ev)y.a.a(b2)).e == 1) {
          ah.f[b1][0] = ev.b;
          ah.f[b1][1] = 0;
          ah.f[b1][2] = b2;
          b1++;
        } 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void E(eo parameo) {
    // Byte code:
    //   0: iconst_5
    //   1: putstatic eu.f : I
    //   4: aload_0
    //   5: invokevirtual b : ()Ljava/io/DataInputStream;
    //   8: invokevirtual readByte : ()B
    //   11: istore_1
    //   12: aload_0
    //   13: invokevirtual b : ()Ljava/io/DataInputStream;
    //   16: invokevirtual readShort : ()S
    //   19: istore_2
    //   20: aload_0
    //   21: invokevirtual b : ()Ljava/io/DataInputStream;
    //   24: invokevirtual readShort : ()S
    //   27: istore_3
    //   28: aconst_null
    //   29: astore #4
    //   31: iload_2
    //   32: iload_1
    //   33: invokestatic a : (IB)Lez;
    //   36: dup
    //   37: astore #5
    //   39: ifnull -> 50
    //   42: aload #5
    //   44: getfield cK : Z
    //   47: ifeq -> 51
    //   50: return
    //   51: iload_3
    //   52: iconst_m1
    //   53: if_icmpeq -> 102
    //   56: aload #5
    //   58: getstatic cn.f : Lbq;
    //   61: if_acmpne -> 102
    //   64: iconst_4
    //   65: iload_3
    //   66: invokestatic a : (IS)Lbw;
    //   69: dup
    //   70: astore #4
    //   72: ifnull -> 102
    //   75: aload #4
    //   77: dup
    //   78: getfield K : I
    //   81: iconst_1
    //   82: isub
    //   83: putfield K : I
    //   86: aload #4
    //   88: getfield K : I
    //   91: ifgt -> 102
    //   94: getstatic bw.V : Les;
    //   97: aload #4
    //   99: invokevirtual d : (Ljava/lang/Object;)V
    //   102: aload_0
    //   103: invokevirtual b : ()Ljava/io/DataInputStream;
    //   106: invokevirtual readByte : ()B
    //   109: dup
    //   110: istore_3
    //   111: ifne -> 404
    //   114: aload #5
    //   116: aload_0
    //   117: invokevirtual b : ()Ljava/io/DataInputStream;
    //   120: invokevirtual readInt : ()I
    //   123: putfield bs : I
    //   126: aload #5
    //   128: aload_0
    //   129: invokevirtual b : ()Ljava/io/DataInputStream;
    //   132: invokevirtual readInt : ()I
    //   135: putfield br : I
    //   138: aload_0
    //   139: invokevirtual b : ()Ljava/io/DataInputStream;
    //   142: invokevirtual readInt : ()I
    //   145: istore_0
    //   146: aload #5
    //   148: getfield br : I
    //   151: ifle -> 213
    //   154: aload #5
    //   156: getfield cF : I
    //   159: iconst_4
    //   160: if_icmpne -> 300
    //   163: aload #5
    //   165: invokevirtual N : ()V
    //   168: aload #5
    //   170: iconst_0
    //   171: putfield cF : I
    //   174: aload #5
    //   176: getfield df : Les;
    //   179: invokevirtual d : ()V
    //   182: aload #5
    //   184: getstatic cn.f : Lbq;
    //   187: if_acmpne -> 300
    //   190: invokestatic a : ()Lq;
    //   193: getstatic cn.f : Lbq;
    //   196: getfield aY : I
    //   199: i2s
    //   200: getstatic cn.f : Lbq;
    //   203: getfield aZ : I
    //   206: i2s
    //   207: invokevirtual a : (SS)V
    //   210: goto -> 300
    //   213: aload #5
    //   215: iconst_0
    //   216: putfield br : I
    //   219: aload #5
    //   221: iconst_0
    //   222: putfield bt : I
    //   225: aload #5
    //   227: getfield cF : I
    //   230: iconst_4
    //   231: if_icmpeq -> 300
    //   234: iload_1
    //   235: iconst_1
    //   236: if_icmpne -> 260
    //   239: aload #5
    //   241: checkcast au
    //   244: getstatic cn.f : Lbq;
    //   247: getfield ct : I
    //   250: iconst_3
    //   251: invokestatic f : (I)I
    //   254: invokestatic a : (Lau;II)V
    //   257: goto -> 300
    //   260: aload #5
    //   262: invokevirtual N : ()V
    //   265: aload #5
    //   267: iconst_4
    //   268: putfield cF : I
    //   271: aload #5
    //   273: getstatic ft.aj : J
    //   276: putfield aW : J
    //   279: aload #5
    //   281: iconst_0
    //   282: putfield ba : I
    //   285: bipush #11
    //   287: aload #5
    //   289: getfield aY : I
    //   292: aload #5
    //   294: getfield aZ : I
    //   297: invokestatic a : (III)V
    //   300: getstatic ft.B : Z
    //   303: ifeq -> 314
    //   306: aload #5
    //   308: getstatic cn.f : Lbq;
    //   311: if_acmpne -> 813
    //   314: iload_0
    //   315: ifle -> 360
    //   318: new java/lang/StringBuffer
    //   321: dup
    //   322: ldc '+'
    //   324: invokespecial <init> : (Ljava/lang/String;)V
    //   327: iload_0
    //   328: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   331: invokevirtual toString : ()Ljava/lang/String;
    //   334: aload #5
    //   336: getfield aY : I
    //   339: aload #5
    //   341: getfield aZ : I
    //   344: aload #5
    //   346: getfield be : I
    //   349: iconst_2
    //   350: idiv
    //   351: isub
    //   352: iconst_3
    //   353: iload_2
    //   354: invokestatic a : (Ljava/lang/String;IIII)V
    //   357: goto -> 813
    //   360: iload_0
    //   361: ifge -> 813
    //   364: new java/lang/StringBuffer
    //   367: dup
    //   368: invokespecial <init> : ()V
    //   371: iload_0
    //   372: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   375: invokevirtual toString : ()Ljava/lang/String;
    //   378: aload #5
    //   380: getfield aY : I
    //   383: aload #5
    //   385: getfield aZ : I
    //   388: aload #5
    //   390: getfield be : I
    //   393: iconst_2
    //   394: idiv
    //   395: isub
    //   396: iconst_3
    //   397: iload_2
    //   398: invokestatic a : (Ljava/lang/String;IIII)V
    //   401: goto -> 813
    //   404: iload_3
    //   405: iconst_1
    //   406: if_icmpne -> 545
    //   409: aload #5
    //   411: aload_0
    //   412: invokevirtual b : ()Ljava/io/DataInputStream;
    //   415: invokevirtual readInt : ()I
    //   418: putfield bu : I
    //   421: aload #5
    //   423: aload_0
    //   424: invokevirtual b : ()Ljava/io/DataInputStream;
    //   427: invokevirtual readInt : ()I
    //   430: putfield bt : I
    //   433: aload_0
    //   434: invokevirtual b : ()Ljava/io/DataInputStream;
    //   437: invokevirtual readInt : ()I
    //   440: istore_0
    //   441: getstatic ft.B : Z
    //   444: ifeq -> 455
    //   447: aload #5
    //   449: getstatic cn.f : Lbq;
    //   452: if_acmpne -> 813
    //   455: iload_0
    //   456: ifle -> 501
    //   459: new java/lang/StringBuffer
    //   462: dup
    //   463: ldc '+'
    //   465: invokespecial <init> : (Ljava/lang/String;)V
    //   468: iload_0
    //   469: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   472: invokevirtual toString : ()Ljava/lang/String;
    //   475: aload #5
    //   477: getfield aY : I
    //   480: aload #5
    //   482: getfield aZ : I
    //   485: aload #5
    //   487: getfield be : I
    //   490: iconst_2
    //   491: idiv
    //   492: isub
    //   493: iconst_4
    //   494: iload_2
    //   495: invokestatic a : (Ljava/lang/String;IIII)V
    //   498: goto -> 813
    //   501: iload_0
    //   502: ifge -> 813
    //   505: new java/lang/StringBuffer
    //   508: dup
    //   509: invokespecial <init> : ()V
    //   512: iload_0
    //   513: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   516: invokevirtual toString : ()Ljava/lang/String;
    //   519: aload #5
    //   521: getfield aY : I
    //   524: aload #5
    //   526: getfield aZ : I
    //   529: aload #5
    //   531: getfield be : I
    //   534: iconst_2
    //   535: idiv
    //   536: isub
    //   537: iconst_3
    //   538: iload_2
    //   539: invokestatic a : (Ljava/lang/String;IIII)V
    //   542: goto -> 813
    //   545: iload_3
    //   546: iconst_2
    //   547: if_icmpne -> 679
    //   550: aload #5
    //   552: aload_0
    //   553: invokevirtual b : ()Ljava/io/DataInputStream;
    //   556: invokevirtual readInt : ()I
    //   559: putfield bs : I
    //   562: aload #5
    //   564: aload_0
    //   565: invokevirtual b : ()Ljava/io/DataInputStream;
    //   568: invokevirtual readInt : ()I
    //   571: putfield br : I
    //   574: aload_0
    //   575: invokevirtual b : ()Ljava/io/DataInputStream;
    //   578: invokevirtual readInt : ()I
    //   581: istore_0
    //   582: getstatic ft.B : Z
    //   585: ifne -> 813
    //   588: iload_0
    //   589: ifle -> 634
    //   592: new java/lang/StringBuffer
    //   595: dup
    //   596: ldc '+'
    //   598: invokespecial <init> : (Ljava/lang/String;)V
    //   601: iload_0
    //   602: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   605: invokevirtual toString : ()Ljava/lang/String;
    //   608: aload #5
    //   610: getfield aY : I
    //   613: aload #5
    //   615: getfield aZ : I
    //   618: aload #5
    //   620: getfield be : I
    //   623: iconst_2
    //   624: idiv
    //   625: isub
    //   626: iconst_3
    //   627: iload_2
    //   628: invokestatic a : (Ljava/lang/String;IIII)V
    //   631: goto -> 813
    //   634: iload_0
    //   635: ifge -> 813
    //   638: new java/lang/StringBuffer
    //   641: dup
    //   642: invokespecial <init> : ()V
    //   645: iload_0
    //   646: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   649: invokevirtual toString : ()Ljava/lang/String;
    //   652: aload #5
    //   654: getfield aY : I
    //   657: aload #5
    //   659: getfield aZ : I
    //   662: aload #5
    //   664: getfield be : I
    //   667: iconst_2
    //   668: idiv
    //   669: isub
    //   670: bipush #6
    //   672: iload_2
    //   673: invokestatic a : (Ljava/lang/String;IIII)V
    //   676: goto -> 813
    //   679: iload_3
    //   680: iconst_3
    //   681: if_icmpne -> 813
    //   684: aload #5
    //   686: aload_0
    //   687: invokevirtual b : ()Ljava/io/DataInputStream;
    //   690: invokevirtual readInt : ()I
    //   693: putfield br : I
    //   696: aload_0
    //   697: invokevirtual b : ()Ljava/io/DataInputStream;
    //   700: invokevirtual readInt : ()I
    //   703: istore_0
    //   704: new java/lang/StringBuffer
    //   707: dup
    //   708: invokespecial <init> : ()V
    //   711: iload_0
    //   712: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   715: invokevirtual toString : ()Ljava/lang/String;
    //   718: aload #5
    //   720: getfield aY : I
    //   723: aload #5
    //   725: getfield aZ : I
    //   728: aload #5
    //   730: getfield be : I
    //   733: iconst_2
    //   734: idiv
    //   735: isub
    //   736: bipush #9
    //   738: iload_2
    //   739: invokestatic a : (Ljava/lang/String;IIII)V
    //   742: iconst_0
    //   743: aload #5
    //   745: getfield aY : I
    //   748: aload #5
    //   750: getfield aZ : I
    //   753: aload #5
    //   755: getfield bc : I
    //   758: iconst_1
    //   759: ishl
    //   760: sipush #1000
    //   763: idiv
    //   764: iadd
    //   765: iconst_5
    //   766: isub
    //   767: invokestatic a : (III)V
    //   770: bipush #9
    //   772: aload #5
    //   774: getfield aY : I
    //   777: aload #5
    //   779: getfield aZ : I
    //   782: aload #5
    //   784: getfield bc : I
    //   787: iconst_1
    //   788: ishl
    //   789: sipush #1000
    //   792: idiv
    //   793: iadd
    //   794: iconst_5
    //   795: iadd
    //   796: invokestatic a : (III)V
    //   799: iconst_4
    //   800: aload #5
    //   802: getfield aY : I
    //   805: aload #5
    //   807: getfield aZ : I
    //   810: invokestatic a : (III)V
    //   813: getstatic bq.N : Lw;
    //   816: ifnull -> 852
    //   819: getstatic bq.N : Lw;
    //   822: aload #5
    //   824: getfield cB : Ljava/lang/String;
    //   827: aload #5
    //   829: getfield aY : I
    //   832: aload #5
    //   834: getfield aZ : I
    //   837: aload #5
    //   839: getfield br : I
    //   842: aload #5
    //   844: getfield bs : I
    //   847: invokevirtual a : (Ljava/lang/String;IIII)V
    //   850: return
    //   851: pop
    //   852: return
    // Exception table:
    //   from	to	target	type
    //   0	50	851	java/lang/Exception
    //   51	850	851	java/lang/Exception
  }
  
  public static void F(eo parameo) {
    try {
      short s = parameo.b().readShort();
      byte b = parameo.b().readByte();
      ez ez;
      if ((ez = ez.a(s, b)) != null && !ez.cK) {
        String str;
        if ((str = parameo.b().readUTF()) == null || str.trim().length() == 0)
          return; 
        ez.cE = str;
        ft.g.a(df.cz, String.valueOf(ez.cB) + ": ", str, (byte)1, false);
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void G(eo parameo) {
    try {
      String str2 = parameo.b().readUTF();
      String str1;
      if ((str1 = parameo.b().readUTF()) == null || str1.trim().length() == 0)
        return; 
      if (str2.compareTo(df.cz) == 0) {
        ft.g.a(str2, String.valueOf(df.ew) + ": ", str1, (byte)1, false);
        return;
      } 
      if (str2.compareTo(df.eU) == 0) {
        ft.g.a(str2, "", str1, (byte)1, false);
        return;
      } 
      if (str2.compareTo(df.eV) == 0) {
        ft.g.a(str2, "", str1, (byte)0, false);
        return;
      } 
      if (str2.compareTo(df.aS) == 0) {
        ft.g.a(str2, "", str1, (byte)0, false);
        return;
      } 
      ft.g.a(str2, String.valueOf(str2) + ": ", str1, (byte)0, false);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void H(eo parameo) {
    try {
      String str1;
      String str2 = df.bd;
      byte b;
      if ((b = parameo.b().readByte()) == 0) {
        str1 = parameo.b().readUTF();
        ft.h.a(str1, (byte)1, df.ep, 0);
        return;
      } 
      if (b == 4 || b == 1) {
        if (b == 4) {
          str2 = str1.b().readUTF();
          str1.b().readByte();
        } 
        int i = 1;
        if (b == 4)
          i = str1.b().readUnsignedByte(); 
        "friend sizelist= " + i + " type=" + b;
        es es = new es("ReadMessenge vec6");
        for (byte b1 = 0; b1 < i; b1++) {
          "friend list i=" + b1;
          String str = str1.b().readUTF();
          "friendname list i=" + str;
          byte b2 = str1.b().readByte();
          byte b3 = str1.b().readByte();
          byte b4 = str1.b().readByte();
          "friendhair list i=" + b4;
          short s1 = str1.b().readShort();
          byte b5 = str1.b().readByte();
          "frienditemsize list i=" + b5;
          byte[] arrayOfByte = new byte[12];
          "friend11 list i=" + b1;
          byte b6;
          for (b6 = 0; b6 < arrayOfByte.length; b6++)
            arrayOfByte[b6] = -1; 
          for (b6 = 0; b6 < b5; b6++) {
            byte b7 = str1.b().readByte();
            byte b8 = str1.b().readByte();
            arrayOfByte[b8] = b7;
          } 
          "friend22 list i=" + b1;
          b6 = str1.b().readByte();
          ez ez = new ez(0, (byte)0, str, 0, 0);
          short s2;
          if ((s2 = str1.b().readShort()) >= 0)
            ez.cO = new em(0, s2, str1.b().readUTF(), str1.b().readByte()); 
          "friend33 list i=" + b1;
          ez.a(b2, b3, b4);
          ez.cw = b6;
          ez.by = s1;
          ez.a(arrayOfByte);
          ez.cD = String.valueOf(df.ac) + s1;
          "friend44 list i=" + b1;
          if (b == 1) {
            ft.c(String.valueOf(ez.cB) + df.dL);
            ag.b.a(ez);
            if ((ag.b()).i == 0) {
              ag.b().h();
              ag.b().i();
              ag.b().j();
            } 
          } else {
            es.a(ez);
          } 
          "ok i roi i=" + b1;
        } 
        if (b == 4) {
          ag.b.d();
          (ag.b()).i = 0;
          ag.b = es;
          (ag.b()).a = es;
          ag.b().a((byte)0);
          ag.b().k();
          ag.b().h();
          ag.b().i();
          ag.b().j();
          (ag.b()).g = str2;
          (ag.b()).h = 99;
          ag.f = true;
          if (ft.a != ag.b()) {
            if (ft.a.c != ag.b()) {
              ag.b().a(ft.a);
            } else {
              ag.b().a(ft.c);
            } 
          } else {
            ft.j();
          } 
        } 
        ft.j();
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void I(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      ft.J = dw.a() + (b * 1000);
      cn.f.N();
      l.a().c();
      cn.f = new bq(0, (byte)0, "unname", 0, 0);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void J(eo parameo) {
    try {
      String str;
      ft.a(str = parameo.b().readUTF());
      byte b = 0;
      try {
        b = parameo.b().readByte();
      } catch (Exception exception) {
        b = 0;
      } 
      if (b == 0)
        bv.c = false; 
      if (b == 1) {
        bv.c = true;
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void K(eo parameo) {
    try {
      boolean bool = parameo.b().readBoolean();
      String str = parameo.b().readUTF();
      if (bool) {
        ft.b.a = 0;
        ft.b.j();
      } 
      ft.a(str);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void L(eo parameo) {
    try {
      byte b;
      if ((b = parameo.b().readByte()) == 0) {
        bq.N = new w(cn.f.cB, cn.f.by, ft.p.d, cs.b());
        ft.a(df.cj);
      } else if (b == 1) {
        this.y = parameo.b().readUTF();
        ft.h.a(this.y, (byte)2, df.eq, 0);
      } else if (b == 2) {
        w w;
        this = null;
        b = parameo.b().readByte();
        for (byte b1 = 0; b1 < b; b1++) {
          if (b1 == 0) {
            w = new w(parameo.b().readUTF(), parameo.b().readShort(), parameo.b().readUnsignedByte(), parameo.b().readByte());
          } else {
            a(parameo.b().readUTF(), parameo.b().readShort(), parameo.b().readUnsignedByte(), parameo.b().readByte());
          } 
        } 
        bq.N = this;
        ah.a = -1;
      } else if (b == 3) {
        ft.a(df.cg);
        bq.N = null;
      } else if (b == 4) {
        ft.a(df.ch);
        bq.N = null;
      } else if (b == 5) {
        ft.a(df.ci);
        bq.N = null;
      } 
      if (bq.N != null) {
        w w = bq.N;
        byte b1;
        for (b1 = 0; b1 < this.b.c(); b1++) {
          aj aj;
          (aj = (aj)this.b.a(b1)).j = false;
        } 
        for (b1 = 0; b1 < cn.i.c(); b1++) {
          ez ez;
          if ((ez = (ez)cn.i.a(b1)).cu == 0 && ez != cn.f) {
            ez.cX = false;
            for (byte b2 = 0; b2 < this.b.c(); b2++) {
              aj aj;
              if (!(aj = (aj)this.b.a(b2)).j && aj.b.compareTo(ez.cB) == 0) {
                ez.cX = true;
                aj.j = true;
                break;
              } 
            } 
          } 
        } 
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public final void M(eo parameo) {
    try {
      byte b;
      if ((b = parameo.b().readByte()) == 0) {
        this.z = parameo.b().readUTF();
        ft.h.a(this.z, (byte)3, df.er, 0);
        return;
      } 
      if (b == 1) {
        String str = parameo.b().readUTF();
        (ft.x = new ec()).a(this);
        ft.x.a(ft.a);
        return;
      } 
      if (b == 2 || b == 3) {
        byte b1 = parameo.b().readByte();
        byte b2 = parameo.b().readByte();
        short s1 = parameo.b().readShort();
        short s2 = parameo.b().readShort();
        short s3 = 1;
        byte b3 = 0;
        byte b4 = 0;
        short s4 = 0;
        byte b5 = 0;
        String str1 = "";
        String str2 = null;
        cz[] arrayOfCz = null;
        if (b2 == 4) {
          s3 = parameo.b().readShort();
          fo fo;
          str2 = (fo = (fo)fo.m.a(s1)).j;
          str1 = fo.c;
        } else if (b2 == 3) {
          str1 = parameo.b().readUTF();
          b3 = parameo.b().readByte();
          b4 = parameo.b().readByte();
          s4 = parameo.b().readShort();
          b5 = parameo.b().readByte();
          byte b6;
          arrayOfCz = new cz[b6 = parameo.b().readByte()];
          for (byte b7 = 0; b7 < b6; b7++) {
            int i = parameo.b().readUnsignedByte();
            int k = parameo.b().readInt();
            arrayOfCz[b7] = new cz(i, k);
          } 
        } else if (b2 == 7) {
          s3 = parameo.b().readShort();
          j j1;
          if ((j1 = bw.b(s1)) != null) {
            str2 = j1.h;
            str1 = j1.g;
          } else {
            str2 = "";
            str1 = "";
          } 
        } 
        j j;
        ec.a(j = new j(s1, str1, s3, s2, b2, str2, arrayOfCz, b3, b4, s4, b5, (byte)0, (byte)0), b, b1);
        return;
      } 
      if (b == 4) {
        ft.x.g = parameo.b().readByte();
        if (ft.x.g == 1) {
          ft.x.aa = null;
          ft.x.Y = null;
        } 
        if (ft.x.g == 2) {
          ft.x.aa = null;
          ft.x.Y = ft.x.h;
          ft.x.b();
          return;
        } 
      } else if (b == 5) {
        byte b1;
        if ((b1 = parameo.b().readByte()) == 0) {
          ft.x.Y = null;
          ft.x.Z = null;
          ft.x.aa = new bt(df.as, 8);
          ft.x.b();
          ft.x.b = 0;
          ft.a(String.valueOf(df.cP) + ft.x.a + df.cQ);
          return;
        } 
        if (b1 == 1) {
          ft.x.b = 1;
          return;
        } 
        if (b1 == 2) {
          if (ft.x.c.c != null) {
            ft.x.c.a(ft.x.c.c);
          } else {
            ft.x.c.c();
          } 
          ft.x = null;
          ft.a(df.cq);
          return;
        } 
      } else {
        if (b == 6) {
          if (ft.x.c.c != null) {
            ft.x.c.a(ft.x.c.c);
          } else {
            ft.x.c.c();
          } 
          ft.x = null;
          ft.a(df.cm);
          return;
        } 
        if (b == 7) {
          ft.x.f[1] = parameo.b().readInt();
          return;
        } 
        if (b == 8) {
          ft.x.f[0] = parameo.b().readInt();
          return;
        } 
        if (b == 9) {
          String str = parameo.b().readUTF();
          ft.x.i[1] = this;
          return;
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public static void N(eo parameo) {
    try {
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      short s1 = parameo.b().readShort();
      byte b3 = parameo.b().readByte();
      int i = parameo.b().readInt();
      short s2 = parameo.b().readShort();
      byte b4 = parameo.b().readByte();
      ez ez2 = null;
      if (b2 == 6) {
        ez2 = ez.a(s1, (byte)9);
      } else if (b2 == 4) {
        ez2 = ez.a(s1, (byte)1);
      } else {
        ez2 = ez.a(s1, (byte)0);
      } 
      ez ez1 = ez.a(s2, b4);
      if (ez2 != null && !ez2.cK && ez2 != cn.f && b1 == 0 && ez2.cF != 4 && ez2.cF != 2)
        if (ez1 != null) {
          if (b2 == 4 && ez1 == ez2 && !ez1.cK)
            cn.b(ct.a[b2][b3], ez2.ct, ez2.cu, ez2.ct, ez2.cu, 0, ez2.br, (byte)ct.b[b2][b3]); 
        } else {
          es es = new es("ReadMessenge vec");
          bf bf = new bf((short)ez2.ct, ez2.cu);
          es.a(bf);
          if (b2 == 6) {
            s s;
            (s = (s)ez2).a((byte)2);
          } 
          ez2.dh.a(ez2, es, b3, b2);
        }  
      if (ez1 != null && !ez1.cK) {
        ez1.b(ct.b[b2][b3], i, 0);
        ei ei;
        if (ez1 == cn.f && (ei = ei.a(ct.b[b2][b3], 0)) != null) {
          parameo.b().readByte();
          s2 = parameo.b().readByte();
          ei.m = new cz[s2];
          cz[] arrayOfCz = new cz[s2];
          for (b2 = 0; b2 < arrayOfCz.length; b2++)
            arrayOfCz[b2] = new cz(parameo.b().readUnsignedByte(), parameo.b().readInt()); 
          ei.m = arrayOfCz;
          return;
        } 
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public final void O(eo parameo) {
    try {
      a(parameo, (byte)0, (byte)0);
      return;
    } catch (Exception exception) {
      (this = null).printStackTrace();
      return;
    } 
  }
  
  public static void P(eo parameo) {
    try {
      short s1 = parameo.b().readShort();
      short s2 = parameo.b().readShort();
      short s3 = parameo.b().readShort();
      byte b = parameo.b().readByte();
      ez ez1 = ez.a(s1, (byte)0);
      ez ez2;
      if ((ez2 = ez.a(s2, b)) != null && !ez2.cK && b == 0)
        ez2.cA = s3; 
      if (ez1 == null || ez1.cK || ez1.cF == 4)
        return; 
      ez1.br = 0;
      ez1.N();
      ez1.cF = 4;
      ez1.aW = ft.aj;
      cn.a(11, ez1.aY, ez1.aZ);
      if (cn.f == ez1 && !cf.b(ft.p.d)) {
        if (cs.w == 1) {
          (cn.b()).aa = bq.c;
          bq.c.a(ft.Y, ft.X - bt.k / 2 - 2, (ce)null, bq.c.a);
          return;
        } 
        if (cs.w == 2) {
          (cn.b()).aa = bq.b;
          bq.b.a(ft.Y, ft.X - bt.k / 2 - 2, (ce)null, bq.b.a);
          return;
        } 
        if (!cf.i()) {
          (cn.b()).Y = bq.b;
          (cn.b()).Z = bq.c;
          bq.b.a(bt.j / 2, ft.X - bt.k / 2 - 2, (ce)null, bq.b.a);
          bq.c.a(ft.W - bt.j / 2, ft.X - bt.k / 2 - 2, (ce)null, bq.c.a);
          return;
        } 
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public static void Q(eo parameo) {
    try {
      short s = parameo.b().readShort();
      byte b = parameo.b().readByte();
      ez ez;
      if ((ez = ez.a(s, (byte)0)) != null && !ez.cK) {
        ez.cv = b;
        if (ez == cn.f) {
          cn.f.cA = parameo.b().readShort();
          String str = String.valueOf(df.cw) + " " + df.cu;
          if (cn.f.cv != 0)
            str = String.valueOf(df.cv) + " " + df.cu; 
          (cn.b()).C.a = str;
          if (b > 0) {
            q.a().c((byte)2, "");
            return;
          } 
        } 
      } 
    } catch (Exception exception) {}
  }
  
  private static void a(eo parameo, byte paramByte1, byte paramByte2) {
    try {
      if (!eg.g)
        return; 
      short s;
      ez ez;
      if ((ez = ez.a(s = parameo.b().readShort(), (byte)0)) == null || ez.cK)
        return; 
      int i = parameo.b().readByte();
      byte b1;
      if ((b1 = parameo.b().readByte()) <= 0)
        return; 
      es es = new es("ReadMessenge vec5");
      int j;
      for (j = 0; j < b1; j++) {
        short s1 = parameo.b().readShort();
        bf bf = new bf(s1, paramByte2);
        int n = parameo.b().readInt();
        int i1 = parameo.b().readInt();
        bf.a(n, i1);
        if (s1 == cn.f.ct) {
          int i2 = cn.f.bs;
          int i3 = n / i2 * 100;
          cn.f.a((byte)4, (i3 > 20));
        } 
        byte b = parameo.b().readByte();
        bf.e = new int[b];
        bf.f = new int[b];
        for (byte b3 = 0; b3 < b; b3++) {
          bf.e[b3] = parameo.b().readByte();
          bf.f[b3] = parameo.b().readInt();
        } 
        ez ez1;
        if ((ez1 = ez.a(bf.a, paramByte2)) != null && !ez1.cK)
          es.a(bf); 
      } 
      j = parameo.b().readInt();
      int k = parameo.b().readInt();
      byte b2 = parameo.b().readByte();
      int m = parameo.b().readInt();
      if (s == cn.f.ct) {
        for (byte b = 0; b < es.c(); b++) {
          bf bf;
          ez ez1;
          if ((ez1 = ez.a((bf = (bf)es.a(b)).a, paramByte2)) != null && !ez1.cK) {
            int n = 2;
            if (ez != null && !ez.cK && (i = i.a(bf.e, ez, ez1, bf.f)) != -1)
              n = i; 
            if (ez1.ct != cn.f.ct) {
              if (bf.c == 0) {
                cn.a(df.cx, ez1.aY, ez1.aZ - ez1.be, 6, ez1.ct);
              } else {
                cn.a("-" + bf.c, ez1.aY, ez1.aZ - ez1.be, n, ez1.ct);
              } 
              if (m > 0)
                cn.a("-" + m, ez1.aY, ez1.aZ - ez1.be, b2, ez1.ct); 
            } 
            ez1.br = bf.d;
            if (ez1.cu == 1 && ez1.br <= 0) {
              ez.a((au)ez1, s, ak.f(3));
              if (ez1.dA >= 0)
                ew.a(ez1.ct); 
            } 
          } 
        } 
      } else if (ez != null && !ez.cK && es.c() > 0) {
        ez.cN = null;
        ez.cR = es;
        ez.dh.a(ez, es, i, (byte)-1);
      } 
      if (ez != null && !ez.cK) {
        ez.br = j;
        ez.bt = k;
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public static void R(eo parameo) {
    try {
      ez ez;
      (ez = new ez()).ct = parameo.b().readShort();
      ez.cB = parameo.b().readUTF();
      ez.bx = parameo.b().readByte();
      ez.bX = parameo.b().readByte();
      ez.ca = parameo.b().readByte();
      ez.cb = parameo.b().readByte();
      ez.by = parameo.b().readShort();
      ez.br = parameo.b().readInt();
      ez.bs = parameo.b().readInt();
      ez.cv = parameo.b().readByte();
      ez.cA = parameo.b().readShort();
      byte b1;
      byte[] arrayOfByte = new byte[b1 = parameo.b().readByte()];
      for (byte b = 0; b < arrayOfByte.length; b++)
        arrayOfByte[b] = -1; 
      ek ek;
      (ek = fw.f).a.clear();
      short s;
      for (s = 0; s < b1; s++) {
        byte b4;
        if ((b4 = parameo.b().readByte()) > -1) {
          String str = parameo.b().readUTF();
          byte b5 = parameo.b().readByte();
          byte b6 = parameo.b().readByte();
          short s1 = parameo.b().readShort();
          byte b7 = parameo.b().readByte();
          byte b8 = parameo.b().readByte();
          short s2 = parameo.b().readShort();
          byte b9 = parameo.b().readByte();
          arrayOfByte[s] = b7;
          byte b10;
          cz[] arrayOfCz = new cz[b10 = parameo.b().readByte()];
          byte b11;
          for (b11 = 0; b11 < b10; b11++) {
            int i = parameo.b().readUnsignedByte();
            int j = parameo.b().readInt();
            arrayOfCz[b11] = new cz(i, j);
          } 
          b11 = parameo.b().readByte();
          b5 = b11;
          j j1;
          j j2;
          (j2 = j1 = j.a(b4, str, s1, b8, b9, b5, 3, arrayOfCz, b6, false, (short)-1, 0L, s2, (byte)0, (byte)0, 0, (byte)0, (byte)0)).E = b5;
          fw.f.a(b4, j1);
        } else {
          arrayOfByte[s] = -1;
        } 
      } 
      ez.b(arrayOfByte);
      if ((s = parameo.b().readShort()) >= 0) {
        ez.cO = new em(0, s, parameo.b().readUTF(), parameo.b().readByte());
        ez.cO.d = parameo.b().readUTF();
      } 
      byte b2;
      if ((b2 = parameo.b().readByte()) > -1) {
        String str = parameo.b().readUTF();
        byte b4 = parameo.b().readByte();
        short s2 = parameo.b().readShort();
        short s3 = parameo.b().readShort();
        byte b5 = parameo.b().readByte();
        byte b6 = parameo.b().readByte();
        byte b7 = parameo.b().readByte();
        byte b8 = parameo.b().readByte();
        int i = parameo.b().readInt();
        short s4 = parameo.b().readShort();
        short s5 = parameo.b().readShort();
        short s6 = parameo.b().readShort();
        short s7 = parameo.b().readShort();
        short s8 = parameo.b().readShort();
        short s1 = parameo.b().readShort();
        s = parameo.b().readShort();
        byte b9;
        cz[] arrayOfCz = new cz[b9 = parameo.b().readByte()];
        for (byte b10 = 0; b10 < b9; b10++) {
          int j = parameo.b().readUnsignedByte();
          int k = parameo.b().readInt();
          int m = parameo.b().readInt();
          arrayOfCz[b10] = new cz(j, k, m);
        } 
        ea ea;
        (ea = new ea(b2, str, b5, b8, b4, 9, arrayOfCz, 14, s2, b5, b7, b6)).a(i, s4, s6, s7, s8, s1, s5, s, s3);
        fw.f.a(b2, ea);
        arrayOfByte[5] = b5;
        fw.a = ea;
      } else {
        fw.a = null;
      } 
      fw.b = ez;
      byte b3 = parameo.b().readByte();
      if (ft.l == null)
        ft.l = new fw(); 
      ft.l.a(b3);
      ft.l.a(ft.a);
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void S(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      ez ez;
      short s;
      if ((ez = ez.a(s = parameo.b().readShort(), b)) != null && !ez.cK) {
        s = parameo.b().readByte();
        byte b1 = parameo.b().readByte();
        ei.a(s, b1, ez);
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void T(eo parameo) {
    try {
      eg.g = false;
      if (ft.a != ft.d)
        ft.d.c(); 
      cn.l();
      eg.g = true;
      cs.u = parameo.b().readByte();
      cn.f.aY = parameo.b().readShort() * 24;
      cn.f.aZ = parameo.b().readShort() * 24;
      cn.f.u();
      cn.f.cN = null;
      cn.f.N();
      if (cn.g != null) {
        cn.g.aY = cn.f.aY;
        cn.g.aZ = cn.f.aZ;
        cn.g.c();
      } 
      ft.j();
      ft.m();
      ft.d.b = false;
      return;
    } catch (Exception exception) {
      (parameo = null).printStackTrace();
      return;
    } 
  }
  
  public static void U(eo parameo) {
    try {
      cs.o = new int[cs.v = parameo.b().readByte()];
      String[] arrayOfString = new String[cs.v];
      byte b1;
      for (b1 = 0; b1 < cs.v; b1++) {
        cs.o[b1] = parameo.b().readByte();
        byte b;
        if ((b = parameo.b().readByte()) != 0)
          cs.o[b1] = b; 
      } 
      for (b1 = 0; b1 < cs.v; b1++)
        arrayOfString[b1] = parameo.b().readUTF(); 
      ft.a(df.aD, new bt(df.Z, -1));
      es es = new es("ReadMessenge menu4");
      for (byte b2 = 0; b2 < cs.v; b2++) {
        bt bt;
        (bt = new bt(arrayOfString[b2], 13, b2, cn.b())).a(cf.s, 1, cs.o[b2]);
        es.a(bt);
      } 
      ft.o.a(es, 2, df.cX, false, (es)null);
      ft.j();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void V(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: istore_1
    //   8: aload_0
    //   9: invokevirtual b : ()Ljava/io/DataInputStream;
    //   12: invokevirtual readShort : ()S
    //   15: dup
    //   16: istore_2
    //   17: iload_1
    //   18: invokestatic e : (II)Lez;
    //   21: dup
    //   22: astore_3
    //   23: ifnull -> 261
    //   26: aload_3
    //   27: getfield cK : Z
    //   30: ifne -> 261
    //   33: iload_1
    //   34: iconst_1
    //   35: if_icmpne -> 178
    //   38: aload_3
    //   39: getfield cx : B
    //   42: iconst_4
    //   43: if_icmpne -> 76
    //   46: aload_0
    //   47: invokevirtual b : ()Ljava/io/DataInputStream;
    //   50: invokevirtual readByte : ()B
    //   53: dup
    //   54: istore_0
    //   55: ifne -> 70
    //   58: aload_3
    //   59: iconst_1
    //   60: putfield dq : Z
    //   63: aload_3
    //   64: bipush #6
    //   66: putfield bi : I
    //   69: return
    //   70: aload_3
    //   71: iconst_1
    //   72: putfield cL : Z
    //   75: return
    //   76: aload_3
    //   77: getfield cx : B
    //   80: iconst_3
    //   81: if_icmpne -> 114
    //   84: aload_0
    //   85: invokevirtual b : ()Ljava/io/DataInputStream;
    //   88: invokevirtual readByte : ()B
    //   91: dup
    //   92: istore_0
    //   93: ifne -> 108
    //   96: aload_3
    //   97: iconst_1
    //   98: putfield dq : Z
    //   101: aload_3
    //   102: bipush #6
    //   104: putfield bi : I
    //   107: return
    //   108: aload_3
    //   109: iconst_1
    //   110: putfield cL : Z
    //   113: return
    //   114: aload_3
    //   115: getfield cx : B
    //   118: iconst_2
    //   119: if_icmpne -> 172
    //   122: aload_0
    //   123: invokevirtual b : ()Ljava/io/DataInputStream;
    //   126: invokevirtual readByte : ()B
    //   129: dup
    //   130: istore_0
    //   131: iconst_1
    //   132: if_icmpne -> 162
    //   135: bipush #80
    //   137: aload_3
    //   138: getfield aY : I
    //   141: aload_3
    //   142: getfield aZ : I
    //   145: bipush #70
    //   147: isub
    //   148: sipush #200
    //   151: iload_2
    //   152: iconst_1
    //   153: invokestatic a : (IIIISB)V
    //   156: aload_3
    //   157: iconst_1
    //   158: putfield cL : Z
    //   161: return
    //   162: aload_3
    //   163: iconst_1
    //   164: putfield cL : Z
    //   167: aconst_null
    //   168: putstatic ez.de : Laq;
    //   171: return
    //   172: aload_3
    //   173: iconst_1
    //   174: putfield cL : Z
    //   177: return
    //   178: iload_1
    //   179: iconst_2
    //   180: if_icmpne -> 230
    //   183: aload_0
    //   184: invokevirtual b : ()Ljava/io/DataInputStream;
    //   187: invokevirtual readByte : ()B
    //   190: dup
    //   191: istore_0
    //   192: iconst_1
    //   193: if_icmpne -> 208
    //   196: aload_3
    //   197: iconst_1
    //   198: putfield dq : Z
    //   201: getstatic cs.j : B
    //   204: putstatic cs.i : B
    //   207: return
    //   208: bipush #35
    //   210: aload_3
    //   211: getfield aY : I
    //   214: aload_3
    //   215: getfield aZ : I
    //   218: bipush #20
    //   220: isub
    //   221: invokestatic a : (III)V
    //   224: aload_3
    //   225: iconst_1
    //   226: putfield cL : Z
    //   229: return
    //   230: iload_1
    //   231: ifne -> 250
    //   234: bipush #35
    //   236: aload_3
    //   237: getfield aY : I
    //   240: aload_3
    //   241: getfield aZ : I
    //   244: bipush #20
    //   246: isub
    //   247: invokestatic a : (III)V
    //   250: aload_3
    //   251: iconst_1
    //   252: putfield cL : Z
    //   255: return
    //   256: dup
    //   257: astore_1
    //   258: invokevirtual printStackTrace : ()V
    //   261: return
    // Exception table:
    //   from	to	target	type
    //   0	161	256	java/lang/Exception
    //   162	255	256	java/lang/Exception
  }
  
  public static void W(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      short s = parameo.b().readShort();
      byte[] arrayOfByte = null;
      if (s > 0) {
        arrayOfByte = new byte[s];
        for (byte b1 = 0; b1 < arrayOfByte.length; b1++)
          arrayOfByte[b1] = parameo.b().readByte(); 
      } 
      "nhan k=" + b + "   di=" + s;
      co.a(b, arrayOfByte);
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void X(eo parameo) {
    try {
      byte b;
      bq.T = new short[b = parameo.b().readByte()];
      for (byte b1 = 0; b1 < b; b1++)
        bq.T[b1] = parameo.b().readShort(); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void Y(eo parameo) {
    try {
      String str = null;
      byte b1 = parameo.b().readByte();
      str = parameo.b().readUTF();
      byte b2 = parameo.b().readByte();
      int i = parameo.b().readInt();
      int j = parameo.b().readUnsignedByte();
      es es = new es("ReadMessenge vec8");
      if (b1 == 3) {
        for (byte b = 0; b < j; b++) {
          String str1 = parameo.b().readUTF();
          int k = parameo.b().readInt();
          short s = parameo.b().readShort();
          String str2 = parameo.b().readUTF();
          String str3 = parameo.b().readUTF();
          em em;
          (em = new em(k, s, str2, (byte)122)).d = str1;
          em.e = str3;
          if (i > j && b == j - 1) {
            em.k = i;
          } else {
            em.k = b;
          } 
          es.a(em);
        } 
      } else {
        for (byte b = 0; b < j; b++) {
          String str1 = parameo.b().readUTF();
          byte b3 = parameo.b().readByte();
          byte b4 = parameo.b().readByte();
          byte b5 = parameo.b().readByte();
          short s2 = parameo.b().readShort();
          byte b6 = parameo.b().readByte();
          byte[] arrayOfByte = new byte[12];
          byte b7;
          for (b7 = 0; b7 < arrayOfByte.length; b7++)
            arrayOfByte[b7] = -1; 
          for (b7 = 0; b7 < b6; b7++) {
            byte b8 = parameo.b().readByte();
            byte b9 = parameo.b().readByte();
            arrayOfByte[b9] = b8;
          } 
          b7 = parameo.b().readByte();
          String str2 = parameo.b().readUTF();
          ez ez = new ez(0, (byte)0, str1, 0, 0);
          short s1;
          if ((s1 = parameo.b().readShort()) >= 0)
            ez.cO = new em(0, s1, parameo.b().readUTF(), parameo.b().readByte()); 
          ez.a(b3, b4, b5);
          ez.cw = b7;
          ez.by = s2;
          ez.a(arrayOfByte);
          ez.cD = str2;
          if (i > j && b == j - 1) {
            ez.bD = i;
          } else {
            ez.bD = b;
          } 
          es.a(ez);
        } 
      } 
      if (es.c() == 0)
        return; 
      if (b1 == 1) {
        if (i > j) {
          ez ez;
          (ez = new ez(0, (byte)0, "...", 0, 0)).bD = -1;
          es.b(ez, j - 1);
        } 
      } else if (b1 == 3) {
        if (i > j) {
          em em;
          (em = new em(0, (short)-1, "...", (byte)122)).k = -1;
          es.b(em, j - 1);
        } 
      } else if (b1 == 6 && i > j) {
        ez ez;
        (ez = new ez(0, (byte)0, "...", 0, 0)).bD = -1;
        es.b(ez, j - 1);
      } 
      (ag.b()).a = es;
      ag.b().a(b1);
      ag.b().k();
      ag.b().h();
      ag.b().i();
      ag.b().j();
      (ag.b()).g = str;
      (ag.b()).h = b2;
      if (ft.a != ag.b()) {
        if (ft.a.c != ag.b()) {
          ag.b().a(ft.a);
          return;
        } 
        ag.b().a(ft.c);
        return;
      } 
      ft.j();
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void Z(eo parameo) {
    try {
      bq.e = parameo.b().readInt();
      bq.i = parameo.b().readInt();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void aa(eo parameo) {
    try {
      ez ez;
      byte b;
      if ((ez = ez.a(b = parameo.b().readByte(), (byte)2)) != null && !ez.cK) {
        ez.cE = parameo.b().readUTF();
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void ab(eo parameo) {
    try {
      String str1 = parameo.b().readUTF();
      String str2 = parameo.b().readUTF();
      byte b = parameo.b().readByte();
      if (cn.f != null && cn.f.cF != 2 && cn.f.cF != 4) {
        cn.f.N();
        cn.f.cN = null;
      } 
      if (b == 15) {
        ft.a(str1, b);
        return;
      } 
      if (str2.length() == 0) {
        ft.a(str1);
        return;
      } 
      ft.a(str1, str2);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void ac(eo parameo) {
    try {
      int i;
      String[] arrayOfString2 = new String[i = parameo.b().readUnsignedByte()];
      byte b3;
      for (b3 = 0; b3 < i; b3++)
        arrayOfString2[b3] = parameo.b().readUTF(); 
      ck.a = arrayOfString2;
      String[] arrayOfString1 = new String[b3 = parameo.b().readByte()];
      byte b2;
      for (b2 = 0; b2 < b3; b2++)
        arrayOfString1[b2] = parameo.b().readUTF(); 
      dr.b = arrayOfString1;
      c.j = new String[b2 = parameo.b().readByte()];
      c.q = new short[b2];
      c.p = new int[b2];
      byte b1;
      for (b1 = 0; b1 < b2; b1++) {
        c.q[b1] = parameo.b().readShort();
        j j;
        if ((j = bw.b(c.q[b1])) != null)
          c.j[b1] = j.g; 
      } 
      c.k = new b[b1 = parameo.b().readByte()];
      for (b3 = 0; b3 < b1; b3++) {
        c.k[b3] = new b();
        parameo.b().readByte();
        (c.k[b3]).c = parameo.b().readInt();
        (c.k[b3]).d = parameo.b().readShort();
        (c.k[b3]).e = new byte[4];
        for (b2 = 0; b2 < 4; b2++)
          (c.k[b3]).e[b2] = parameo.b().readByte(); 
      } 
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void ad(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      bq.j = ft.aj;
      bq.g = parameo.b().readShort();
      return;
    } catch (IOException iOException2) {
      IOException iOException1;
      (iOException1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void ae(eo parameo) {
    try {
      cw cw;
      byte b = parameo.b().readByte();
      short s = parameo.b().readShort();
      int i;
      byte[] arrayOfByte1 = new byte[i = parameo.b().readInt()];
      parameo.b().read(arrayOfByte1);
      int j = 0;
      if (parameo.b().available() > 0)
        j = parameo.b().available(); 
      byte[] arrayOfByte2 = new byte[1];
      if (j > 0) {
        arrayOfByte2 = new byte[j];
        parameo.b().read(arrayOfByte2);
      } 
      if (b < 100) {
        aq aq = aq.a(arrayOfByte1);
        if (b < 50) {
          if ((cw = (cw)fe.a.a(String.valueOf(b) + "_" + s)) == null) {
            cw = new cw(aq, arrayOfByte2);
            fe.a.a(String.valueOf(b) + "_" + s, cw);
          } else {
            cw.a = aq;
            cw.c = arrayOfByte2;
          } 
        } else if ((cw = (cw)ak.a.a(String.valueOf(b - 50) + "_" + s)) == null) {
          cw = new cw(aq, arrayOfByte2);
          ak.a.a(String.valueOf(b - 50) + "_" + s, cw);
        } else {
          cw.a = aq;
          cw.c = arrayOfByte2;
        } 
      } else if (b == 110) {
        ay ay;
        if ((ay = (ay)ay.a.a(s)) != null) {
          ay.b = ft.aj;
          ay.c = aq.a((byte[])cw);
        } 
      } else {
        byte[] arrayOfByte;
        cb cb;
        if (b == 111) {
          cr cr;
          if ((cr = (cr)cr.a.a(s)) != null) {
            cr.b = ft.aj;
            cr.c = aq.a((byte[])cw);
          } 
          if ((cb = (cb)dq.b.a(s)) != null) {
            ak.a("data_eff" + s, arrayOfByte2);
            cb.b = ft.aj;
            arrayOfByte = arrayOfByte2;
            cb cb1;
            (cb1 = cb).a = arrayOfByte;
          } 
        } else {
          dj dj;
          if (arrayOfByte == 112) {
            el el;
            if ((el = (el)fp.b.a(s)) != null) {
              el.b = ft.aj;
              el.a = aq.a((byte[])cb);
            } 
            if ((dj = (dj)at.j.a(s)) != null) {
              dj.b = ft.aj;
              arrayOfByte = arrayOfByte2;
              dj dj1;
              (dj1 = dj).a = arrayOfByte;
            } 
          } else if (arrayOfByte == 113) {
            el el;
            if ((el = (el)fp.b.a(s)) != null) {
              el.b = ft.aj;
              el.a = aq.a((byte[])dj);
            } 
            at at;
            if ((at = ez.g(s)) != null)
              at.a(arrayOfByte2); 
          } 
        } 
      } 
      ah.h++;
      return;
    } catch (Exception exception) {
      dw.a("loi ne " + exception.toString());
      return;
    } 
  }
  
  public static void af(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_1
    //   9: bipush #100
    //   11: if_icmpeq -> 891
    //   14: iload_1
    //   15: iconst_4
    //   16: if_icmpne -> 150
    //   19: aload_0
    //   20: invokevirtual b : ()Ljava/io/DataInputStream;
    //   23: invokevirtual readShort : ()S
    //   26: dup
    //   27: istore_2
    //   28: newarray byte
    //   30: astore_3
    //   31: iconst_0
    //   32: istore #4
    //   34: goto -> 51
    //   37: aload_3
    //   38: iload #4
    //   40: aload_0
    //   41: invokevirtual b : ()Ljava/io/DataInputStream;
    //   44: invokevirtual readByte : ()B
    //   47: bastore
    //   48: iinc #4, 1
    //   51: iload #4
    //   53: aload_3
    //   54: arraylength
    //   55: if_icmplt -> 37
    //   58: aload_0
    //   59: invokevirtual b : ()Ljava/io/DataInputStream;
    //   62: invokevirtual readShort : ()S
    //   65: istore #4
    //   67: aload_0
    //   68: invokevirtual b : ()Ljava/io/DataInputStream;
    //   71: invokevirtual readByte : ()B
    //   74: istore #5
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -> 143
    //   81: aload_0
    //   82: invokevirtual b : ()Ljava/io/DataInputStream;
    //   85: invokevirtual readShort : ()S
    //   88: istore_1
    //   89: aload_0
    //   90: invokevirtual b : ()Ljava/io/DataInputStream;
    //   93: invokevirtual readByte : ()B
    //   96: istore #6
    //   98: iload_1
    //   99: iload #6
    //   101: invokestatic a : (SB)Lez;
    //   104: dup
    //   105: astore #7
    //   107: ifnull -> 140
    //   110: new dq
    //   113: dup
    //   114: iload #4
    //   116: aload #7
    //   118: getfield aY : I
    //   121: aload #7
    //   123: getfield aZ : I
    //   126: aload_3
    //   127: invokespecial <init> : (III[B)V
    //   130: astore #8
    //   132: getstatic cn.V : Les;
    //   135: aload #8
    //   137: invokevirtual a : (Ljava/lang/Object;)V
    //   140: iinc #2, 1
    //   143: iload_2
    //   144: iload #5
    //   146: if_icmplt -> 81
    //   149: return
    //   150: iload_1
    //   151: iconst_3
    //   152: if_icmpne -> 199
    //   155: aload_0
    //   156: invokevirtual b : ()Ljava/io/DataInputStream;
    //   159: invokevirtual readShort : ()S
    //   162: istore_2
    //   163: aload_0
    //   164: invokevirtual b : ()Ljava/io/DataInputStream;
    //   167: invokevirtual readByte : ()B
    //   170: istore_3
    //   171: aload_0
    //   172: invokevirtual b : ()Ljava/io/DataInputStream;
    //   175: invokevirtual readUnsignedByte : ()I
    //   178: istore #4
    //   180: iload_2
    //   181: iload_3
    //   182: invokestatic a : (IB)Lez;
    //   185: dup
    //   186: astore #5
    //   188: ifnull -> 1097
    //   191: aload #5
    //   193: iload #4
    //   195: invokevirtual j : (I)V
    //   198: return
    //   199: iload_1
    //   200: bipush #101
    //   202: if_icmpne -> 265
    //   205: aload_0
    //   206: invokevirtual b : ()Ljava/io/DataInputStream;
    //   209: invokevirtual readShort : ()S
    //   212: istore_2
    //   213: iconst_0
    //   214: istore_3
    //   215: goto -> 254
    //   218: getstatic cs.b : Les;
    //   221: iload_3
    //   222: invokevirtual a : (I)Ljava/lang/Object;
    //   225: checkcast z
    //   228: dup
    //   229: astore #4
    //   231: ifnull -> 251
    //   234: aload #4
    //   236: getfield l : S
    //   239: iload_2
    //   240: if_icmpne -> 251
    //   243: getstatic cs.b : Les;
    //   246: aload #4
    //   248: invokevirtual d : (Ljava/lang/Object;)V
    //   251: iinc #3, 1
    //   254: iload_3
    //   255: getstatic cs.b : Les;
    //   258: invokevirtual c : ()I
    //   261: if_icmplt -> 218
    //   264: return
    //   265: aload_0
    //   266: invokevirtual b : ()Ljava/io/DataInputStream;
    //   269: invokevirtual readShort : ()S
    //   272: dup
    //   273: istore_2
    //   274: newarray byte
    //   276: astore_3
    //   277: iconst_0
    //   278: istore #4
    //   280: goto -> 297
    //   283: aload_3
    //   284: iload #4
    //   286: aload_0
    //   287: invokevirtual b : ()Ljava/io/DataInputStream;
    //   290: invokevirtual readByte : ()B
    //   293: bastore
    //   294: iinc #4, 1
    //   297: iload #4
    //   299: aload_3
    //   300: arraylength
    //   301: if_icmplt -> 283
    //   304: aload_0
    //   305: invokevirtual b : ()Ljava/io/DataInputStream;
    //   308: invokevirtual readByte : ()B
    //   311: istore #4
    //   313: aload_0
    //   314: invokevirtual b : ()Ljava/io/DataInputStream;
    //   317: invokevirtual readByte : ()B
    //   320: istore #5
    //   322: aload_0
    //   323: invokevirtual b : ()Ljava/io/DataInputStream;
    //   326: invokevirtual readUnsignedByte : ()I
    //   329: istore_2
    //   330: iload_1
    //   331: tableswitch default -> 890, 0 -> 356, 1 -> 451, 2 -> 736
    //   356: aload_0
    //   357: invokevirtual b : ()Ljava/io/DataInputStream;
    //   360: invokevirtual readShort : ()S
    //   363: istore_1
    //   364: aload_0
    //   365: invokevirtual b : ()Ljava/io/DataInputStream;
    //   368: invokevirtual readByte : ()B
    //   371: istore #6
    //   373: aload_0
    //   374: invokevirtual b : ()Ljava/io/DataInputStream;
    //   377: invokevirtual readByte : ()B
    //   380: istore #7
    //   382: aload_0
    //   383: invokevirtual b : ()Ljava/io/DataInputStream;
    //   386: invokevirtual readShort : ()S
    //   389: istore #8
    //   391: aload_0
    //   392: invokevirtual b : ()Ljava/io/DataInputStream;
    //   395: invokevirtual readByte : ()B
    //   398: istore_0
    //   399: iload #8
    //   401: sipush #1000
    //   404: imul
    //   405: i2l
    //   406: invokestatic a : ()J
    //   409: ladd
    //   410: lstore #12
    //   412: iload_1
    //   413: iload #6
    //   415: invokestatic a : (IB)Lez;
    //   418: dup
    //   419: astore_1
    //   420: ifnull -> 1097
    //   423: aload_1
    //   424: iload_2
    //   425: aload_1
    //   426: getfield aY : I
    //   429: aload_1
    //   430: getfield aZ : I
    //   433: iconst_0
    //   434: iconst_0
    //   435: iconst_0
    //   436: iconst_0
    //   437: aload_3
    //   438: iload #7
    //   440: lload #12
    //   442: iload_0
    //   443: iload #4
    //   445: iload #5
    //   447: invokevirtual a : (IIIIIII[BBJBII)V
    //   450: return
    //   451: aload_0
    //   452: invokevirtual b : ()Ljava/io/DataInputStream;
    //   455: invokevirtual readShort : ()S
    //   458: istore_1
    //   459: aload_0
    //   460: invokevirtual b : ()Ljava/io/DataInputStream;
    //   463: invokevirtual readShort : ()S
    //   466: istore #6
    //   468: aload_0
    //   469: invokevirtual b : ()Ljava/io/DataInputStream;
    //   472: invokevirtual readByte : ()B
    //   475: istore #7
    //   477: aload_0
    //   478: invokevirtual b : ()Ljava/io/DataInputStream;
    //   481: invokevirtual readByte : ()B
    //   484: istore #8
    //   486: aload_0
    //   487: invokevirtual b : ()Ljava/io/DataInputStream;
    //   490: invokevirtual readShort : ()S
    //   493: istore #9
    //   495: aload_0
    //   496: invokevirtual b : ()Ljava/io/DataInputStream;
    //   499: invokevirtual readShort : ()S
    //   502: istore #10
    //   504: aload_0
    //   505: invokevirtual b : ()Ljava/io/DataInputStream;
    //   508: invokevirtual readByte : ()B
    //   511: istore_0
    //   512: iload #8
    //   514: ifeq -> 541
    //   517: iload #9
    //   519: ifeq -> 541
    //   522: iload #9
    //   524: iload_0
    //   525: invokestatic a : (IB)Lez;
    //   528: dup
    //   529: astore #11
    //   531: ifnull -> 541
    //   534: aload #11
    //   536: iload #8
    //   538: putfield be : I
    //   541: iload #7
    //   543: iconst_3
    //   544: if_icmpne -> 577
    //   547: new dq
    //   550: dup
    //   551: iload_2
    //   552: iload_1
    //   553: iload #6
    //   555: iconst_0
    //   556: iconst_0
    //   557: iload #7
    //   559: iconst_5
    //   560: aload_3
    //   561: iload #10
    //   563: invokespecial <init> : (IIIIIII[BS)V
    //   566: astore #11
    //   568: getstatic cn.V : Les;
    //   571: aload #11
    //   573: invokevirtual a : (Ljava/lang/Object;)V
    //   576: return
    //   577: iload_0
    //   578: iconst_1
    //   579: if_icmpne -> 683
    //   582: iconst_0
    //   583: istore #11
    //   585: goto -> 619
    //   588: getstatic cs.b : Les;
    //   591: iload #11
    //   593: invokevirtual a : (I)Ljava/lang/Object;
    //   596: checkcast z
    //   599: dup
    //   600: astore #8
    //   602: ifnull -> 616
    //   605: aload #8
    //   607: getfield l : S
    //   610: iload #9
    //   612: if_icmpne -> 616
    //   615: return
    //   616: iinc #11, 1
    //   619: iload #11
    //   621: getstatic cs.b : Les;
    //   624: invokevirtual c : ()I
    //   627: if_icmplt -> 588
    //   630: new dq
    //   633: dup
    //   634: iload_2
    //   635: iload_1
    //   636: iload #6
    //   638: iconst_0
    //   639: iconst_0
    //   640: iload #7
    //   642: iconst_0
    //   643: aload_3
    //   644: invokespecial <init> : (IIIIIII[B)V
    //   647: dup
    //   648: astore #11
    //   650: iload #9
    //   652: invokevirtual b : (I)V
    //   655: getstatic cs.b : Les;
    //   658: aload #11
    //   660: invokevirtual a : (Ljava/lang/Object;)V
    //   663: getstatic ft.p : Lcs;
    //   666: iload_1
    //   667: iload #6
    //   669: iload #4
    //   671: iload #5
    //   673: invokevirtual a : (IIII)V
    //   676: getstatic cs.b : Les;
    //   679: invokestatic b : (Les;)V
    //   682: return
    //   683: new dq
    //   686: dup
    //   687: iload_2
    //   688: iload_1
    //   689: iload #6
    //   691: iconst_0
    //   692: iconst_0
    //   693: iload #7
    //   695: iconst_0
    //   696: aload_3
    //   697: invokespecial <init> : (IIIIIII[B)V
    //   700: dup
    //   701: astore #11
    //   703: iload #9
    //   705: invokevirtual b : (I)V
    //   708: getstatic cs.b : Les;
    //   711: aload #11
    //   713: invokevirtual a : (Ljava/lang/Object;)V
    //   716: getstatic ft.p : Lcs;
    //   719: iload_1
    //   720: iload #6
    //   722: iload #4
    //   724: iload #5
    //   726: invokevirtual a : (IIII)V
    //   729: getstatic cs.b : Les;
    //   732: invokestatic b : (Les;)V
    //   735: return
    //   736: aload_0
    //   737: invokevirtual b : ()Ljava/io/DataInputStream;
    //   740: invokevirtual readShort : ()S
    //   743: istore #11
    //   745: aload_0
    //   746: invokevirtual b : ()Ljava/io/DataInputStream;
    //   749: invokevirtual readByte : ()B
    //   752: istore #8
    //   754: aload_0
    //   755: invokevirtual b : ()Ljava/io/DataInputStream;
    //   758: invokevirtual readByte : ()B
    //   761: istore_1
    //   762: aload_0
    //   763: invokevirtual b : ()Ljava/io/DataInputStream;
    //   766: invokevirtual readInt : ()I
    //   769: istore_0
    //   770: iload_1
    //   771: bipush #17
    //   773: if_icmpne -> 821
    //   776: iload_0
    //   777: ifge -> 793
    //   780: getstatic cn.f : Lbq;
    //   783: iload_2
    //   784: aload_3
    //   785: iload #4
    //   787: iload #5
    //   789: invokevirtual a : (I[BII)V
    //   792: return
    //   793: iload_0
    //   794: ifle -> 1097
    //   797: iload_0
    //   798: i2l
    //   799: invokestatic a : ()J
    //   802: ladd
    //   803: lstore #26
    //   805: getstatic cn.f : Lbq;
    //   808: iload_2
    //   809: aload_3
    //   810: iload #4
    //   812: iload #5
    //   814: lload #26
    //   816: iload_1
    //   817: invokevirtual a : (I[BIIJB)V
    //   820: return
    //   821: iload #11
    //   823: iload #8
    //   825: invokestatic a : (IB)Lez;
    //   828: dup
    //   829: astore #26
    //   831: ifnull -> 1097
    //   834: iload_0
    //   835: ifge -> 850
    //   838: aload #26
    //   840: iload_2
    //   841: aload_3
    //   842: iload #4
    //   844: iload #5
    //   846: invokevirtual a : (I[BII)V
    //   849: return
    //   850: iload_0
    //   851: ifle -> 877
    //   854: iload_0
    //   855: i2l
    //   856: invokestatic a : ()J
    //   859: ladd
    //   860: lstore #27
    //   862: aload #26
    //   864: iload_2
    //   865: aload_3
    //   866: iload #4
    //   868: iload #5
    //   870: lload #27
    //   872: iload_1
    //   873: invokevirtual a : (I[BIIJB)V
    //   876: return
    //   877: aload #26
    //   879: iload_2
    //   880: aload_3
    //   881: iload #4
    //   883: iload #5
    //   885: lconst_0
    //   886: iload_1
    //   887: invokevirtual b : (I[BIIJB)V
    //   890: return
    //   891: iload_1
    //   892: bipush #100
    //   894: if_icmpne -> 1097
    //   897: aload_0
    //   898: invokevirtual b : ()Ljava/io/DataInputStream;
    //   901: invokevirtual readShort : ()S
    //   904: istore_2
    //   905: aload_0
    //   906: invokevirtual b : ()Ljava/io/DataInputStream;
    //   909: invokevirtual readUnsignedByte : ()I
    //   912: istore_3
    //   913: aload_0
    //   914: invokevirtual b : ()Ljava/io/DataInputStream;
    //   917: invokevirtual readByte : ()B
    //   920: istore #4
    //   922: aload_0
    //   923: invokevirtual b : ()Ljava/io/DataInputStream;
    //   926: invokevirtual readByte : ()B
    //   929: istore #5
    //   931: iload #4
    //   933: ifeq -> 942
    //   936: iload #4
    //   938: iconst_1
    //   939: if_icmpne -> 1097
    //   942: iload_2
    //   943: iload #4
    //   945: invokestatic a : (IB)Lez;
    //   948: dup
    //   949: astore_2
    //   950: ifnull -> 1097
    //   953: iload #5
    //   955: ifne -> 1013
    //   958: iconst_0
    //   959: istore_1
    //   960: goto -> 1001
    //   963: aload_2
    //   964: getfield du : Les;
    //   967: iload_1
    //   968: invokevirtual a : (I)Ljava/lang/Object;
    //   971: checkcast dq
    //   974: dup
    //   975: astore #6
    //   977: ifnull -> 998
    //   980: aload #6
    //   982: getfield e : S
    //   985: iload_3
    //   986: if_icmpne -> 998
    //   989: aload_2
    //   990: getfield du : Les;
    //   993: aload #6
    //   995: invokevirtual d : (Ljava/lang/Object;)V
    //   998: iinc #1, 1
    //   1001: iload_1
    //   1002: aload_2
    //   1003: getfield du : Les;
    //   1006: invokevirtual c : ()I
    //   1009: if_icmplt -> 963
    //   1012: return
    //   1013: iload #5
    //   1015: iconst_1
    //   1016: if_icmpne -> 1097
    //   1019: iconst_0
    //   1020: istore_1
    //   1021: goto -> 1062
    //   1024: aload_2
    //   1025: getfield dv : Les;
    //   1028: iload_1
    //   1029: invokevirtual a : (I)Ljava/lang/Object;
    //   1032: checkcast dq
    //   1035: dup
    //   1036: astore #6
    //   1038: ifnull -> 1059
    //   1041: aload #6
    //   1043: getfield e : S
    //   1046: iload_3
    //   1047: if_icmpne -> 1059
    //   1050: aload_2
    //   1051: getfield dv : Les;
    //   1054: aload #6
    //   1056: invokevirtual d : (Ljava/lang/Object;)V
    //   1059: iinc #1, 1
    //   1062: iload_1
    //   1063: aload_2
    //   1064: getfield dv : Les;
    //   1067: invokevirtual c : ()I
    //   1070: if_icmplt -> 1024
    //   1073: return
    //   1074: astore_1
    //   1075: new java/lang/StringBuffer
    //   1078: dup
    //   1079: ldc 'loadImageDataAutoEff loi  '
    //   1081: invokespecial <init> : (Ljava/lang/String;)V
    //   1084: aload_1
    //   1085: invokevirtual toString : ()Ljava/lang/String;
    //   1088: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1091: invokevirtual toString : ()Ljava/lang/String;
    //   1094: invokestatic a : (Ljava/lang/String;)V
    //   1097: return
    // Exception table:
    //   from	to	target	type
    //   0	615	1074	java/lang/Exception
    //   616	1073	1074	java/lang/Exception
  }
  
  public final void ag(eo parameo) {
    try {
      short s = parameo.b().readShort();
      byte b;
      String[] arrayOfString = new String[b = parameo.b().readByte()];
      for (byte b1 = 0; b1 < b; b1++)
        arrayOfString[b1] = parameo.b().readUTF(); 
      String str2 = parameo.b().readUTF();
      String str1 = parameo.b().readUTF();
      if (s == 1) {
        ft.j();
        ft.a(arrayOfString, new bt(str2, 0), s, (short)-1, str1);
        return;
      } 
      ft.j();
      ft.a(arrayOfString, new bt(str2, 0), s, (short)-1, str1);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void ah(eo parameo) {
    try {
      if (ft.G != -1)
        TemMidlet.b(); 
      byte b = parameo.b().readByte();
      byte[] arrayOfByte = { b };
      ak.a("isIndexRes", arrayOfByte);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void ai(eo parameo) {
    a(parameo, bw.W, (byte)9);
  }
  
  private static ea aR(eo parameo) {
    try {
      String str = parameo.b().readUTF();
      byte b1 = parameo.b().readByte();
      short s1 = parameo.b().readShort();
      short s2 = parameo.b().readShort();
      short s3 = parameo.b().readShort();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      byte b4 = parameo.b().readByte();
      byte b5 = parameo.b().readByte();
      int i = parameo.b().readInt();
      short s4 = parameo.b().readShort();
      short s5 = parameo.b().readShort();
      short s6 = parameo.b().readShort();
      short s7 = parameo.b().readShort();
      short s8 = parameo.b().readShort();
      short s9 = parameo.b().readShort();
      short s10 = parameo.b().readShort();
      byte b6;
      cz[] arrayOfCz = new cz[b6 = parameo.b().readByte()];
      for (byte b = 0; b < b6; b++) {
        int j = parameo.b().readUnsignedByte();
        int k = parameo.b().readInt();
        int m = parameo.b().readInt();
        arrayOfCz[b] = new cz(j, k, m);
      } 
      ea ea;
      (ea = new ea(s1, str, b2, b5, b1, 9, arrayOfCz, 14, s2, b2, b4, b3)).a(i, s4, s6, s7, s8, s9, s5, s10, s3);
      return ea;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static j aS(eo parameo) {
    try {
      String str = parameo.b().readUTF();
      byte b1 = parameo.b().readByte();
      short s1 = parameo.b().readShort();
      byte b2 = parameo.b().readByte();
      short s2 = parameo.b().readShort();
      byte b3 = parameo.b().readByte();
      short s3 = parameo.b().readShort();
      byte b4 = parameo.b().readByte();
      byte b5 = parameo.b().readByte();
      byte b6 = parameo.b().readByte();
      byte b7;
      cz[] arrayOfCz = new cz[b7 = parameo.b().readByte()];
      int i;
      for (i = 0; i < b7; i++) {
        int k = parameo.b().readUnsignedByte();
        int m = parameo.b().readInt();
        arrayOfCz[i] = new cz(k, m);
      } 
      i = parameo.b().readInt();
      byte b8 = parameo.b().readByte();
      j j;
      return j = new j(s1, str, s2, b3, b4, b1, 3, arrayOfCz, b2, false, (short)-1, 0L, s3, b5, b6, i, (byte)0, b8);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public final void aj(eo parameo) {
    try {
      s s;
      parameo.b().readByte();
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      byte b = 0;
      es es = bw.X;
      if (b1 == 0) {
        fo.a(b2, es);
        if (b2 == 3) {
          parameo.b().readByte();
          b1 = parameo.b().readByte();
          for (b2 = 0; b2 < b1; b2++) {
            j j = aS(parameo);
            es.a(j);
          } 
          return;
        } 
        if (b2 == 9) {
          parameo.b().readByte();
          b1 = parameo.b().readByte();
          for (b2 = 0; b2 < b1; b2++) {
            ea ea = aR(parameo);
            es.a(ea);
          } 
          if (cn.W) {
            for (b2 = 0; b2 < bw.X.c(); b2++) {
              ea ea;
              s = (s)ez.a((ea = (ea)es.a(b2)).O, (byte)9);
              if (ft.s != null && ft.s.p == 14 && ah.j == 0) {
                " Id item pet in MsgDialog = " + ah.i.O;
                if (ah.i.O == ea.O)
                  ah.i = ea; 
              } 
              if (this == null)
                cn.a(s = s.a((short)ea.ao, ea.O, ea.an, ea.am)); 
            } 
            return;
          } 
        } 
      } else {
        ea ea;
        if (s == true) {
          bw bw;
          if (b2 == 3) {
            b = parameo.b().readByte();
            j j = aS(parameo);
            if ((bw = bw.a(b, (short)this.O, es)) == null) {
              es.a(this);
              return;
            } 
            es.a(this, es.c(bw));
            return;
          } 
          if (bw == 9) {
            b = parameo.b().readByte();
            ea = aR(parameo);
            if ((bw = bw.a(b, (short)this.O, es)) == null) {
              es.a(this);
            } else {
              es.a(this, es.c(bw));
            } 
            if (cn.W) {
              s s1;
              cn.a(s1 = s.a((short)this.ao, this.O, this.an, this.am));
              return;
            } 
          } 
        } else if (ea == 2) {
          b = parameo.b().readByte();
          short s2 = parameo.b().readShort();
          bw bw;
          if ((bw = bw.a(b, s2, es)) != null)
            es.d(bw); 
          s s1;
          ea ea1;
          if ((ea1 = (ea)bw) != null && ea1.ao >= 0 && (s1 = (s)ez.e(ea1.O, 9)) != null) {
            cn.i.d(this);
            return;
          } 
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public final void ak(eo parameo) {
    try {
      ft.j();
      this.b = parameo.b().readShort();
      this.c = parameo.b().readByte();
      String str = parameo.b().readUTF();
      es es;
      (es = new es("ReadMessenge vec4")).a(new bt("Ok", 2, 1, this));
      es.a(new bt(df.as, 2, 0, this));
      ft.a(str, es);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void a(eo parameo, es parames, byte paramByte) {
    try {
      fo.d = false;
      if (paramByte == 9)
        bq.y = parameo.b().readByte(); 
      short s = parameo.b().readByte();
      byte b = parameo.b().readByte();
      if (paramByte == 0) {
        long l = parameo.b().readLong();
        int i = parameo.b().readInt();
        cn.f.bC = l;
        cn.f.bB = i;
      } 
      byte b1 = 0;
      if (s == 0) {
        fo.a(b, parames);
        if (b == 4) {
          b1 = parameo.b().readByte();
          byte b3 = parameo.b().readByte();
          for (byte b2 = 0; b2 < b3; b2++) {
            short s1 = parameo.b().readShort();
            short s2 = parameo.b().readShort();
            byte b4 = parameo.b().readByte();
            byte b5 = parameo.b().readByte();
            fo fo = (fo)fo.m.a(s1);
            "content=" + fo.j;
            j j = new j(s1, fo.b, fo.c, fo.j, s2, b1, fo.h, fo.i, fo.g, b4, b5);
            parames.a(j);
          } 
          if (paramByte == 0) {
            j.a((byte)1, false);
            j.a((byte)0, false);
          } 
        } else if (b == 3) {
          b1 = parameo.b().readByte();
          byte b3 = parameo.b().readByte();
          "size item=" + b3;
          for (byte b2 = 0; b2 < b3; b2++) {
            String str1 = parameo.b().readUTF();
            byte b4 = parameo.b().readByte();
            short s1 = parameo.b().readShort();
            byte b5 = parameo.b().readByte();
            short s2 = parameo.b().readShort();
            byte b6 = parameo.b().readByte();
            short s3 = parameo.b().readShort();
            byte b7 = parameo.b().readByte();
            byte b8 = parameo.b().readByte();
            byte b9 = parameo.b().readByte();
            byte b10;
            cz[] arrayOfCz = new cz[b10 = parameo.b().readByte()];
            int i;
            for (i = 0; i < b10; i++) {
              int m = parameo.b().readUnsignedByte();
              int n = parameo.b().readInt();
              arrayOfCz[i] = new cz(m, n);
            } 
            i = parameo.b().readInt();
            byte b11 = parameo.b().readByte();
            byte b12 = parameo.b().readByte();
            int k = -1;
            String str2 = "-1";
            if (b12 == 1) {
              k = parameo.b().readInt();
              str2 = parameo.b().readUTF();
            } 
            parameo.b().readByte();
            b12 = 0;
            j j = null;
            j = new j(s1, this, s2, b6, b7, b4, b1, arrayOfCz, b5, false, (short)-1, 0L, s3, b8, b9, i, (byte)0, b11, k, Long.parseLong(str2));
            parames.a(j);
          } 
        } else if (b == 5) {
          parameo.b().readByte();
          byte b3 = parameo.b().readByte();
          "size item quest=" + b3;
          for (byte b2 = 0; b2 < b3; b2++) {
            short s1 = parameo.b().readShort();
            String str1 = parameo.b().readUTF();
            short s2 = parameo.b().readShort();
            String str2 = df.dQ;
            byte b4 = parameo.b().readByte();
            byte b5 = parameo.b().readByte();
            j j = new j(s1, str1, s2, str2, b4, b5);
            parames.a(j);
          } 
        } else if (b == 7) {
          parameo.b().readByte();
          byte b3 = parameo.b().readByte();
          "size material=" + b3;
          for (byte b2 = 0; b2 < b3; b2++) {
            s = parameo.b().readShort();
            short s1 = parameo.b().readShort();
            byte b4 = parameo.b().readByte();
            byte b5 = parameo.b().readByte();
            j j;
            if ((j = bw.b(s)) != null) {
              j j1 = j.a(s, j.g, j.t, 7, j.q, j.Q, j.h, j.P, j.A, s1, b4, b5);
              parames.a(j1);
            } else {
              j j1;
              (j1 = new j()).O = s;
              j1.K = s1;
              j1.x = b4;
              j1.y = b5;
              j1.u = 7;
              bw.c(s);
              parames.a(j1);
            } 
          } 
        } 
        if (paramByte == 0 && b != 3)
          fn.C = true; 
      } else {
        String str;
        if (s == 1) {
          if (b == 4) {
            b1 = parameo.b().readByte();
            short s2 = parameo.b().readShort();
            short s1 = parameo.b().readShort();
            s = parameo.b().readByte();
            byte b2 = parameo.b().readByte();
            bw bw;
            if ((bw = bw.a(b1, s2, parames)) != null) {
              bw.K = s1;
              bw.x = s;
              bw.y = b2;
            } else {
              fo fo = (fo)fo.m.a(s2);
              j j = new j(s2, fo.b, fo.c, fo.j, s1, b1, fo.h, fo.i, fo.g, s, b2);
              parames.a(j);
            } 
            if (paramByte == 0) {
              j.a((byte)1, false);
              j.a((byte)0, false);
              if (cn.p.d(1, 5)) {
                cn.p.b++;
                cn.p.g();
              } 
            } 
          } else if (b == 3) {
            b1 = parameo.b().readByte();
            String str1 = parameo.b().readUTF();
            byte b2 = parameo.b().readByte();
            s = parameo.b().readShort();
            bw bw = bw.a(b1, s, parames);
            byte b4 = parameo.b().readByte();
            short s2 = parameo.b().readShort();
            byte b5 = parameo.b().readByte();
            short s3 = parameo.b().readShort();
            byte b6 = parameo.b().readByte();
            byte b7 = parameo.b().readByte();
            byte b8 = parameo.b().readByte();
            byte b9;
            cz[] arrayOfCz2 = new cz[b9 = parameo.b().readByte()];
            int j;
            for (j = 0; j < b9; j++)
              arrayOfCz2[j] = new cz(parameo.b().readUnsignedByte(), parameo.b().readInt()); 
            j = parameo.b().readInt();
            byte b11 = parameo.b().readByte();
            byte b12 = parameo.b().readByte();
            int k = -1;
            String str2 = "-1";
            if (b12 == 1) {
              k = parameo.b().readInt();
              str2 = parameo.b().readUTF();
            } 
            parameo.b().readByte();
            long l2 = Long.parseLong(str2);
            j = k;
            byte b10 = b11;
            s = 0;
            int i = j;
            b8 = b8;
            b7 = b7;
            short s4 = s3;
            long l1 = 0L;
            s = -1;
            s = 0;
            s3 = b4;
            cz[] arrayOfCz1 = arrayOfCz2;
            s2 = b1;
            b4 = b2;
            byte b3 = b6;
            b1 = b5;
            short s1 = s2;
            str = str1;
            s = s;
            j j1 = new j(s, str, s1, b1, b3, b4, s2, arrayOfCz1, s3, false, (short)-1, 0L, s4, b7, b8, i, (byte)0, b10, j, l2);
            if (bw == null) {
              parames.a(j1);
            } else {
              parames.a(j1, parames.c(bw));
            } 
          } else if (b == 9) {
            b1 = str.b().readByte();
            ea ea = aR((eo)str);
            bw bw;
            if ((bw = bw.a(b1, (short)ea.O, parames)) == null) {
              parames.a(ea);
            } else {
              parames.a(ea, parames.c(bw));
            } 
          } else if (b == 5) {
            b1 = str.b().readByte();
            short s1 = str.b().readShort();
            String str1 = str.b().readUTF();
            s = str.b().readShort();
            String str2 = df.dQ;
            byte b2 = str.b().readByte();
            byte b3 = str.b().readByte();
            bw bw;
            if ((bw = bw.a(b1, s1, parames)) == null) {
              j j = new j(s1, str1, s, str2, b2, b3);
              parames.a(j);
            } else {
              bw.K = s;
              bw.x = b2;
              bw.y = b3;
            } 
          } else if (b == 7) {
            b1 = str.b().readByte();
            short s2 = str.b().readShort();
            short s1 = str.b().readShort();
            s = str.b().readByte();
            byte b2 = str.b().readByte();
            bw bw;
            if ((bw = bw.a(b1, s2, parames)) != null) {
              bw.K = s1;
              bw.x = s;
              bw.y = b2;
            } else {
              j j;
              if ((j = bw.b(s2)) != null) {
                bw = j.a(s2, j.g, j.t, 7, j.q, j.Q, j.h, j.y, j.A, s1, s, b2);
                parames.a(bw);
              } else {
                j j1;
                (j1 = new j()).O = s2;
                j1.K = s1;
                j1.x = s;
                j1.y = b2;
                j1.u = 7;
                bw.c(s2);
                parames.a(j1);
              } 
            } 
            if (paramByte == 0)
              for (byte b3 = 0; b3 < c.q.length; b3++) {
                j j = bw.b(c.q[b3]);
                int i = 0;
                bw bw1;
                if (j != null && (bw1 = bw.a(j.u, (short)j.O)) != null)
                  i = bw1.K; 
                c.p[b3] = i;
              }  
          } 
          if (paramByte == 0) {
            if (cn.p.a == 1 && cn.p.b == 5) {
              cn.p.b++;
              cn.p.g();
            } 
            if (b != 3)
              fn.C = true; 
          } 
        } else if (s == 2) {
          b1 = str.b().readByte();
          short s1 = str.b().readShort();
          bw bw;
          if ((bw = bw.a(b1, s1, parames)) != null)
            parames.d(bw); 
          if (paramByte == 0)
            if (b == 4) {
              j.a((byte)1, false);
              j.a((byte)0, false);
            } else if (b == 7 && paramByte == 0) {
              for (s = 0; s < c.q.length; s++) {
                j j = bw.b(c.q[s]);
                int i = 0;
                bw bw1;
                if (j != null && (bw1 = bw.a(j.u, (short)j.O)) != null)
                  i = bw1.K; 
                c.p[s] = i;
              } 
            }  
        } 
      } 
    } catch (Exception exception) {
      (this = null).printStackTrace();
    } 
    fo.d = true;
    fl.bi = 0;
  }
  
  public static void al(eo parameo) {
    try {
      j j1;
      String str;
      j j2;
      short s;
      if ((s = parameo.b().readByte()) == 0) {
        s = parameo.b().readShort();
        byte b;
        if ((b = parameo.b().readByte()) == 3) {
          bw bw;
          if ((bw = bw.a(b, s)) != null && c.B == 0)
            c.l = j.a(s, bw.i, bw.t, bw.z, bw.N, bw.M, b, bw.j, bw.R, false, bw.v, bw.q, (short)bw.S, bw.x, bw.y, 0, (byte)0, (byte)0); 
        } else {
          c.D = true;
        } 
        if (c.B == 0) {
          c.A = c.z = parameo.b().readUTF();
          return;
        } 
        c.A = parameo.b().readUTF();
        return;
      } 
      if (s == 1) {
        if ((s = parameo.b().readByte()) == 3) {
          c.l = null;
        } else {
          c.D = false;
        } 
        if (c.B == 0) {
          c.A = c.z = parameo.b().readUTF();
          return;
        } 
        c.A = parameo.b().readUTF();
        return;
      } 
      if (s == 2) {
        ft.j();
        c.B = 1;
        c.C = parameo.b().readByte();
        c.F = parameo.b().readUTF();
        "thanh cong hay that bai=" + c.C;
        return;
      } 
      if (s == 3) {
        ft.j();
        str = parameo.b().readUTF();
        ft.o.a(null, str, fq.f, (byte)2, false, 0);
        return;
      } 
      if (str == '\004') {
        short s1 = parameo.b().readShort();
        short s2 = parameo.b().readShort();
        String str1 = parameo.b().readUTF();
        byte b;
        bw bw;
        if ((bw = bw.a(b = parameo.b().readByte(), s1)) != null) {
          (c.l = j.a(s1, bw.i, bw.t, bw.z, bw.N, bw.M, b, bw.j, bw.R, false, bw.v, bw.q, (short)bw.S, bw.x, bw.y, 0, (byte)0, (byte)0)).ak = null;
          c.l.I = dw.a(str1, "|");
          j j;
          if ((j = bw.b(c.l.O)) != null)
            c.l.g = j.g; 
          short s3;
          if ((j2 = bw.b(s3 = s2)) != null) {
            if (((j1 = j2).u == 7 && ez.f(j1.O))) {
              j1 = j2;
              (j2 = new j()).i = j1.i;
              j2.g = j1.g;
              j2.t = j1.t;
              j2.O = j1.O;
              j2.z = j1.z;
              j2.N = j1.N;
              j2.M = j1.M;
              j2.u = j1.u;
              j2.j = j1.j;
              j2.R = j1.R;
              j2.v = j1.v;
              j2.q = j1.q;
              j2.S = j1.S;
              j2.x = j1.x;
              j2.y = j1.y;
              j2.p = j1.p;
              j2.B = j1.B;
              j2.D = j1.D;
              j2.K = j1.K;
              j2.Q = j1.Q;
              j2.j = j1.j;
              j2.C = j1.C;
              j2.I = new String[] { "", "" };
              c.l.ak = j2;
              return;
            } 
          } else {
            (j2 = new j()).O = j1;
            j2.u = 7;
            c.l.ak = j2;
            return;
          } 
        } 
      } else {
        if (j2 == 5) {
          ft.j();
          c.B = 1;
          c.C = j1.b().readByte();
          c.F = j1.b().readUTF();
          return;
        } 
        if (j2 == 6) {
          c.l = null;
          return;
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public final void am(eo parameo) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_2
    //   9: ifne -> 172
    //   12: aload_1
    //   13: invokevirtual b : ()Ljava/io/DataInputStream;
    //   16: invokevirtual readShort : ()S
    //   19: istore_2
    //   20: aload_1
    //   21: invokevirtual b : ()Ljava/io/DataInputStream;
    //   24: invokevirtual readByte : ()B
    //   27: istore_1
    //   28: iconst_3
    //   29: iload_2
    //   30: invokestatic a : (IS)Lbw;
    //   33: dup
    //   34: astore_0
    //   35: ifnull -> 171
    //   38: iload_1
    //   39: iconst_1
    //   40: if_icmpne -> 105
    //   43: iload_2
    //   44: aload_0
    //   45: getfield i : Ljava/lang/String;
    //   48: aload_0
    //   49: getfield t : I
    //   52: aload_0
    //   53: getfield z : B
    //   56: aload_0
    //   57: getfield N : I
    //   60: aload_0
    //   61: getfield M : I
    //   64: iconst_3
    //   65: aload_0
    //   66: getfield j : [Lcz;
    //   69: aload_0
    //   70: getfield R : I
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield v : S
    //   78: aload_0
    //   79: getfield q : J
    //   82: aload_0
    //   83: getfield S : I
    //   86: i2s
    //   87: aload_0
    //   88: getfield x : B
    //   91: aload_0
    //   92: getfield y : B
    //   95: iconst_0
    //   96: iconst_0
    //   97: iconst_0
    //   98: invokestatic a : (ILjava/lang/String;IBIII[Lcz;IZSJSBBIBB)Lj;
    //   101: putstatic c.m : Lj;
    //   104: return
    //   105: iload_1
    //   106: ifne -> 372
    //   109: iload_2
    //   110: aload_0
    //   111: getfield i : Ljava/lang/String;
    //   114: aload_0
    //   115: getfield t : I
    //   118: aload_0
    //   119: getfield z : B
    //   122: aload_0
    //   123: getfield N : I
    //   126: aload_0
    //   127: getfield M : I
    //   130: iconst_3
    //   131: aload_0
    //   132: getfield j : [Lcz;
    //   135: aload_0
    //   136: getfield R : I
    //   139: iconst_0
    //   140: aload_0
    //   141: getfield v : S
    //   144: aload_0
    //   145: getfield q : J
    //   148: aload_0
    //   149: getfield S : I
    //   152: i2s
    //   153: aload_0
    //   154: getfield x : B
    //   157: aload_0
    //   158: getfield y : B
    //   161: iconst_0
    //   162: iconst_0
    //   163: iconst_0
    //   164: invokestatic a : (ILjava/lang/String;IBIII[Lcz;IZSJSBBIBB)Lj;
    //   167: putstatic c.n : Lj;
    //   170: return
    //   171: return
    //   172: iload_2
    //   173: iconst_1
    //   174: if_icmpne -> 317
    //   177: invokestatic j : ()V
    //   180: aload_1
    //   181: invokevirtual b : ()Ljava/io/DataInputStream;
    //   184: invokevirtual readShort : ()S
    //   187: istore_2
    //   188: getstatic c.m : Lj;
    //   191: ifnull -> 200
    //   194: getstatic c.n : Lj;
    //   197: ifnonnull -> 201
    //   200: return
    //   201: new es
    //   204: dup
    //   205: ldc 'ReadMessenge menu3'
    //   207: invokespecial <init> : (Ljava/lang/String;)V
    //   210: dup
    //   211: astore_1
    //   212: new bt
    //   215: dup
    //   216: getstatic df.fk : Ljava/lang/String;
    //   219: iconst_4
    //   220: aload_0
    //   221: invokespecial <init> : (Ljava/lang/String;ILcg;)V
    //   224: invokevirtual a : (Ljava/lang/Object;)V
    //   227: getstatic ft.o : Lfq;
    //   230: aload_1
    //   231: new java/lang/StringBuffer
    //   234: dup
    //   235: getstatic df.fl : Ljava/lang/String;
    //   238: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   241: invokespecial <init> : (Ljava/lang/String;)V
    //   244: getstatic c.m : Lj;
    //   247: getfield g : Ljava/lang/String;
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   253: getstatic df.fm : Ljava/lang/String;
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   259: getstatic c.n : Lj;
    //   262: getfield g : Ljava/lang/String;
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   268: ldc '? '
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   273: getstatic df.fj : Ljava/lang/String;
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   279: ldc ': '
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   284: iload_2
    //   285: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   288: ldc ' '
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   293: getstatic df.bP : Ljava/lang/String;
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   299: ldc '.'
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   304: invokevirtual toString : ()Ljava/lang/String;
    //   307: getstatic fq.f : I
    //   310: iconst_2
    //   311: iconst_0
    //   312: iconst_0
    //   313: invokevirtual a : (Les;Ljava/lang/String;IBZI)V
    //   316: return
    //   317: iload_2
    //   318: iconst_2
    //   319: if_icmpne -> 340
    //   322: invokestatic j : ()V
    //   325: aload_1
    //   326: invokevirtual b : ()Ljava/io/DataInputStream;
    //   329: invokevirtual readUTF : ()Ljava/lang/String;
    //   332: putstatic c.F : Ljava/lang/String;
    //   335: iconst_1
    //   336: putstatic c.B : B
    //   339: return
    //   340: iload_2
    //   341: iconst_3
    //   342: if_icmpne -> 372
    //   345: invokestatic j : ()V
    //   348: aload_1
    //   349: invokevirtual b : ()Ljava/io/DataInputStream;
    //   352: invokevirtual readUTF : ()Ljava/lang/String;
    //   355: astore_2
    //   356: getstatic ft.o : Lfq;
    //   359: aconst_null
    //   360: aload_2
    //   361: getstatic fq.f : I
    //   364: iconst_2
    //   365: iconst_0
    //   366: iconst_0
    //   367: invokevirtual a : (Les;Ljava/lang/String;IBZI)V
    //   370: return
    //   371: pop
    //   372: return
    // Exception table:
    //   from	to	target	type
    //   0	200	371	java/lang/Exception
    //   201	370	371	java/lang/Exception
  }
  
  public static void an(eo parameo) {
    try {
      byte b;
      if ((b = parameo.b().readByte()) == 0) {
        String str = parameo.b().readUTF();
        short s = parameo.b().readShort();
        ft.h.a(str, (byte)4, df.eu, s);
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public final void ao(eo parameo) {
    try {
      byte b;
      ez ez;
      if ((ez = ez.a(b = parameo.b().readByte(), (byte)2)) == null || ez.cK)
        return; 
      String str;
      ez.cq = o.a(str = parameo.b().readUTF(), "\b");
      ez.cr = 0;
      es es = new es("ReadMessenge menu2");
      bt bt = new bt(df.aa, 3, b, this);
      es.a(this);
      ft.o.a(es, ez.cq[0], b, (byte)2, false, 2);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void ap(eo parameo) {
    try {
      short s1;
      byte b2;
      String str1;
      short s4;
      String str4;
      int j;
      ez ez;
      String str5;
      byte b3;
      byte b1 = parameo.b().readByte();
      String str2 = null;
      String str3 = "";
      long l = 0L;
      int i = 0;
      short s2 = 122;
      short s3 = 0;
      switch (b1) {
        case 10:
          str2 = parameo.b().readUTF();
          ft.h.a(str2, (byte)5, df.eD, 0);
          return;
        case 14:
          str2 = parameo.b().readUTF();
          s1 = parameo.b().readShort();
          s2 = parameo.b().readByte();
          l = parameo.b().readLong();
          i = parameo.b().readInt();
          ft.a(String.valueOf(df.eQ) + ": " + str2 + " " + df.ac + s1 + "\n" + df.eR + em.a(s2) + "\n" + df.eH + df.bO + ": " + l + "\n" + df.eH + df.bP + ": " + i);
          return;
        case 15:
          s1 = parameo.b().readByte();
          if ((b2 = parameo.b().readByte()) == 0) {
            int k = parameo.b().readInt();
            s3 = parameo.b().readShort();
            str3 = parameo.b().readUTF();
            str1 = parameo.b().readUTF();
            short s5 = parameo.b().readShort();
            short s6 = parameo.b().readShort();
            short s7 = parameo.b().readShort();
            short s8 = parameo.b().readShort();
            short s9 = parameo.b().readShort();
            String str6 = parameo.b().readUTF();
            String str7 = parameo.b().readUTF();
            String str8 = parameo.b().readUTF();
            l = parameo.b().readLong();
            i = parameo.b().readInt();
            byte b = parameo.b().readByte();
            dv[] arrayOfDv = null;
            if (b > 0) {
              arrayOfDv = new dv[b];
              for (b = 0; b < arrayOfDv.length; b++)
                arrayOfDv[b] = new dv(parameo.b().readByte(), parameo.b().readByte(), parameo.b().readUTF()); 
            } 
            if (s1 == 0) {
              if (cn.f.cO == null)
                cn.f.cO = new em(k, s3, str3, (byte)122); 
              cn.f.cO.a(str1, s5, s6, s7, s8, s9, str7, str8, str6, l, i, arrayOfDv);
              if (ft.m == null)
                ft.m = new by(); 
              ft.m.a(cn.f.cO, s1);
              ft.m.a(ft.a);
            } else {
              em em;
              (em = new em(k, s3, str3, (byte)122)).a(str1, s5, s6, s7, s8, s9, str7, str8, str6, l, i, arrayOfDv);
              if (ft.m == null)
                ft.m = new by(); 
              ft.m.a(em, s1);
              ft.m.a(ft.a);
            } 
            ft.j();
            return;
          } 
          if (str1 == '\001') {
            if (cn.f.cO != null) {
              cn.f.cO.n = parameo.b().readLong();
              cn.f.cO.l = parameo.b().readInt();
              return;
            } 
          } else if (str1 == '\002') {
            if (cn.f.cO != null) {
              cn.f.cO.g = parameo.b().readUTF();
              by.a = true;
              return;
            } 
          } else if (str1 == '\003' && cn.f.cO != null) {
            cn.f.cO.e = parameo.b().readUTF();
            by.a = true;
            return;
          } 
          return;
        case 19:
          s4 = parameo.b().readShort();
          str4 = parameo.b().readUTF();
          if ((j = parameo.b().readInt()) != -1) {
            parameo.b().readUTF();
            str3 = parameo.b().readUTF();
            s3 = parameo.b().readShort();
            s2 = parameo.b().readByte();
          } 
          ez = null;
          if (s4 != 32000 && (ez = ez.a(s4, (byte)0)) != null)
            if (j == -1) {
              if (ez.cO != null)
                ez.cO.q = true; 
            } else if (ez.cO == null) {
              ez.cO = new em(j, s3, str3, s2);
            } else {
              ez.cO.b = j;
              ez.cO.a = s3;
              ez.cO.c = str3.toUpperCase();
              ez.cO.o = s2;
            }  
          if (ft.a == ag.b() && (ag.b()).i == 4)
            for (byte b = 0;; b++) {
              if (b >= (ag.b()).a.c())
                return; 
              ez ez1;
              if ((ez1 = (ez)(ag.b()).a.a(b)).cB.compareTo(str4) == 0) {
                if (ez1.cO != null) {
                  if (j == -1) {
                    ez1.cO.o = 121;
                    return;
                  } 
                  ez1.cO.o = s2;
                  return;
                } 
                break;
              } 
            }  
          return;
        case 20:
          ft.a(str5 = parameo.b().readUTF());
          return;
        case 21:
          if ((b3 = parameo.b().readByte()) == 3) {
            bw.Y.d();
            s2 = parameo.b().readShort();
            for (byte b = 0; b < s2; b++) {
              short s5 = parameo.b().readShort();
              short s6 = parameo.b().readShort();
              fo fo = (fo)fo.m.a(s5);
              j j1 = new j(s5, fo.b, fo.c, fo.j, s6, 4, fo.h, fo.i, fo.g, (byte)0, (byte)0);
              bw.Y.a(j1);
            } 
            es es = new es("ReadMessenge vec3");
            fn fn = new fn(bw.Y, (byte)12, df.eV, -1, (byte)0);
            es.a(fn);
            (ft.v = new eu()).a = 0;
            ft.v.a(es);
            ft.v.a(cn.b());
            ft.j();
            return;
          } 
          if (b3 == 2) {
            s2 = parameo.b().readShort();
            bw bw;
            if ((bw = bw.a(4, s2, bw.Y)) != null) {
              bw.Y.d(bw);
              return;
            } 
          } else if (b3 == 0) {
            s2 = parameo.b().readShort();
            short s = parameo.b().readShort();
            bw bw;
            if ((bw = bw.a(4, s2, bw.Y)) != null) {
              bw.K = s;
              return;
            } 
            fo fo = (fo)fo.m.a(s2);
            j j1 = new j(s2, fo.b, fo.c, fo.j, s, 4, fo.h, fo.i, fo.g, (byte)0, (byte)0);
            bw.Y.a(j1);
            return;
          } 
          return;
        case 22:
          if (cn.f.cO != null) {
            parameo.b().readByte();
            parameo.b().readShort();
            break;
          } 
          return;
      } 
      return;
    } catch (Exception exception) {}
  }
  
  public static void aq(eo parameo) {
    try {
      parameo.b().readByte();
      short s1 = parameo.b().readShort();
      short s2 = parameo.b().readShort();
      ez ez;
      byte b;
      if ((ez = ez.a(b = parameo.b().readByte(), (byte)2)) != null && !ez.cK) {
        ez.br = s1;
        ez.bs = s2;
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public final void ar(eo parameo) {
    try {
      ft.j();
      this.b = parameo.b().readShort();
      this.c = parameo.b().readByte();
      String str = parameo.b().readUTF();
      byte b;
      String[] arrayOfString1 = new String[b = parameo.b().readByte()];
      String[] arrayOfString2 = new String[b];
      byte b1 = 1;
      byte[] arrayOfByte = new byte[b];
      byte b2;
      for (b2 = 0; b2 < b; b2++) {
        arrayOfString1[b2] = parameo.b().readUTF();
        arrayOfByte[b2] = parameo.b().readByte();
        arrayOfString2[b2] = "";
      } 
      try {
        for (b2 = 0; b2 < b; b2++)
          arrayOfString2[b2] = parameo.b().readUTF(); 
        b1 = parameo.b().readByte();
      } catch (Exception exception) {}
      ft.a(arrayOfString1, new bt("OK", 1), this.c, this.b, str, arrayOfString2, b1);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void as(eo parameo) {
    try {
      String str = parameo.b().readUTF();
      byte b;
      if ((b = parameo.b().readByte()) == 0) {
        ft.c(str);
        return;
      } 
      if (b == 1) {
        ft.b(str);
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void at(eo parameo) {
    try {
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      short s2 = parameo.b().readShort();
      short s3 = parameo.b().readShort();
      byte b3 = parameo.b().readByte();
      short s1 = parameo.b().readShort();
      ez ez = ez.a(s2, b2);
      "Effect from server type = " + ez.cB;
      if (b1 >= 0 && ez != null && !ez.cK) {
        switch (b1) {
          case 0:
            cn.a(38, ez.aY, ez.aZ - 20);
            return;
          case 1:
            for (s1 = 0; s1 < br.b.c(); s1++) {
              dx dx;
              if ((dx = (dx)br.b.a(s1)).d == 85 && dx.s != null && dx.s.ct == s2) {
                if (s3 == 0)
                  dx.y = true; 
                return;
              } 
            } 
            cn.a(85, ez.aY, ez.aZ, s3, s2, b2);
            return;
          case 2:
            for (s1 = 0; s1 < br.b.c(); s1++) {
              dx dx;
              if ((dx = (dx)br.b.a(s1)).d == 87 && dx.s != null && dx.s.ct == s2 && s3 == 0) {
                dx.y = true;
                return;
              } 
            } 
            cn.a(87, ez.aY, ez.aZ, s3, s2, b2);
            return;
          case 3:
            cn.a(43, ez.aY, ez.aZ);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 4:
            cn.a(94, ez.aY, ez.aZ, s3, s2, b2, s1, false);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 5:
            cn.a(100, ez.aY, ez.aZ, s3, s2, b2, s1, false);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 6:
            cn.a(101, ez.aY, ez.aZ, s3, s2, b2, s1, false);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 7:
            cn.a(102, ez.aY, ez.aZ, s3, s2, b2, s1, false);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 8:
            cn.a(107, ez.aY, ez.aZ, s3, s2, b2, s1, false);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 9:
            ez.t();
            cn.a(103, ez.aY, ez.aZ, s3, s2, b2, s1, false);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 10:
            ez.h(12, s3);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 11:
            ez.h(13, s3);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 12:
            ez.h(11, s3);
            if (b3 > 0) {
              cs.t = b3;
              return;
            } 
            return;
          case 13:
            ez.h(14, s3);
            if (b3 > 0) {
              cs.t = b3;
              break;
            } 
            return;
        } 
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void au(eo parameo) {
    try {
      ca ca;
      byte b;
      if ((b = parameo.b().readByte()) == -1) {
        for (byte b1 = 0; b1 < cn.o.c(); b1++) {
          if ((ca = (ca)cn.o.a(b1)).a == 0 || ca.a == 2 || ca.a == 1 || ca.a == 4)
            ca.b(); 
        } 
        return;
      } 
      short s2 = ca.b().readShort();
      short s1;
      if ((s1 = ca.b().readShort()) == 0) {
        for (byte b1 = 0; b1 < cn.o.c(); b1++) {
          ca ca1;
          if ((ca1 = (ca)cn.o.a(b1)).a == b) {
            ca1.c = true;
            return;
          } 
        } 
        return;
      } 
      if (b == 0 || b == 2 || b == 1 || b == 4) {
        for (byte b1 = 0; b1 < cn.o.c(); b1++) {
          ca ca1;
          if ((ca1 = (ca)cn.o.a(b1)).a == b) {
            ca1.c = true;
            break;
          } 
        } 
        cn.a(b, true, s2, s1);
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void av(eo parameo) {
    try {
      byte b2 = parameo.b().readByte();
      short s = parameo.b().readShort();
      String str = parameo.b().readUTF();
      byte b1 = parameo.b().readByte();
      ez ez;
      if ((ez = ez.a(s, b2)) != null && !ez.cK) {
        cn.a(str, ez.aY, ez.aZ - ez.be / 2, 8, b1, s);
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public static void aw(eo parameo) {
    try {
      bw bw;
      String str;
      short s;
      byte b;
      if ((b = parameo.b().readByte()) == 0) {
        c.w = parameo.b().readInt();
        c.v = parameo.b().readUTF();
        c.t = parameo.b().readInt();
        c.x = parameo.b().readShort();
        c.u = parameo.b().readInt();
        c.s = new b[b = parameo.b().readByte()];
        byte b1;
        for (b1 = 0; b1 < b; b1++) {
          short s1 = parameo.b().readShort();
          short s2 = parameo.b().readShort();
          c.s[b1] = new b(s1, s2);
        } 
        c.r = new int[b];
        for (b1 = 0; b1 < c.s.length; b1++) {
          j j = bw.b((c.s[b1]).a);
          int i = 0;
          if (j != null && (bw = bw.a(j.u, (short)j.O)) != null)
            i = bw.K; 
          c.r[b1] = i;
        } 
        return;
      } 
      if (b == 1) {
        str = bw.b().readUTF();
        c.o = null;
        es es = new es("ReadMessenge vec12");
        fn fn = new fn(bw.V, (byte)0, df.dx, -1, fn.g);
        es.a(fn);
        c c = null;
        c = new c(str, c.c);
        es.a(c);
        (ft.v = new eu()).a = 1;
        ft.v.a(es);
        ft.v.a(cn.b());
        ft.j();
        c.b();
        return;
      } 
      if (str == '\002') {
        if ((s = bw.b().readShort()) == -1) {
          c.o = null;
          return;
        } 
        bw bw1;
        if ((bw1 = bw.a(3, s)) != null && c.B == 0) {
          c.o = j.a(s, bw1.i, bw1.t, bw1.z, bw1.N, bw1.M, 3, bw1.j, bw1.R, false, bw1.v, bw1.q, (short)bw1.S, bw1.x, bw1.y, 0, (byte)0, (byte)0);
          return;
        } 
      } else {
        String str1;
        if (s == 5) {
          ft.j();
          c.F = bw.b().readUTF();
          c.y = bw.b().readShort();
          c.B = 1;
          return;
        } 
        if (s == 4) {
          ft.j();
          str1 = bw.b().readUTF();
          ft.o.a(null, str1, fq.f, (byte)2, false, 0);
          return;
        } 
        if (str1 == '\006') {
          c.o = null;
          c.s = null;
          c.t = 0;
          c.u = 0;
          c.v = "";
          c.w = 0;
          c.x = 0;
          c.y = 0;
          return;
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public static void ax(eo parameo) {
    try {
      String str1 = parameo.b().readUTF();
      byte b1;
      j[] arrayOfJ = new j[b1 = parameo.b().readByte()];
      for (byte b = 0; b < b1; b++) {
        String str = parameo.b().readUTF();
        short s = parameo.b().readShort();
        int i = parameo.b().readInt();
        byte b4 = parameo.b().readByte();
        byte b5 = parameo.b().readByte();
        byte b6 = parameo.b().readByte();
        arrayOfJ[b] = new j(str, s, i, b4, b5, b6);
      } 
      String str2 = parameo.b().readUTF();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      if (b1 == 0)
        return; 
      ft.a(str1, str2, arrayOfJ, b2, b3);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void ay(eo parameo) {
    try {
      ft.I = parameo.b().readShort();
      short s = parameo.b().readShort();
      ft.i();
      ah.h = 0;
      ah.g = s;
      "==========" + ft.I;
      return;
    } catch (Exception exception) {
      (parameo = null).printStackTrace();
      return;
    } 
  }
  
  public static void az(eo parameo) {
    try {
      ft.I = parameo.b().readShort();
      short s = parameo.b().readShort();
      byte b1 = 0;
      for (byte b2 = 0; b2 < s; b2++) {
        byte b = parameo.b().readByte();
        short s1 = parameo.b().readShort();
        int i = parameo.b().readInt();
        byte[] arrayOfByte = null;
        try {
          boolean bool = false;
          if ((arrayOfByte = ak.a("img_data_char_" + b + "_" + s1)) == null) {
            bool = true;
          } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
            DataInputStream dataInputStream;
            short s2 = (dataInputStream = new DataInputStream(byteArrayInputStream)).readShort();
            if (i != s2)
              bool = true; 
          } 
          if (bool) {
            q.a().a(b, s1);
            b1++;
          } 
        } catch (Exception exception) {}
      } 
      if (b1 > 0) {
        ft.i();
        ah.h = 0;
        ah.g = b1;
      } 
      "==========" + ft.I;
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void aA(eo parameo) {
    try {
      short s2;
      ez ez1;
      short s1;
      byte b2;
      short s3;
      ez ez2;
      byte b1;
      switch (b1 = parameo.b().readByte()) {
        case 0:
          b1 = parameo.b().readByte();
          if ((ez1 = ez.a(s2 = parameo.b().readShort(), (byte)0)) != null) {
            ez1.ee = b1;
            return;
          } 
          return;
        case 1:
          b1 = ez1.b().readByte();
          b2 = ez1.b().readByte();
          s3 = ez1.b().readShort();
          s1 = ez1.b().readShort();
          if ((ez2 = ez.a(s3, (byte)1)) != null) {
            ez2.a(b2, s1, b1);
            return;
          } 
          return;
      } 
      return;
    } catch (Exception exception) {}
  }
  
  public static void aB(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      "size = " + b;
      for (byte b1 = 0; b1 < b; b1++) {
        byte b2 = parameo.b().readByte();
        parameo.b().readByte();
        short s = parameo.b().readShort();
        do.d.a(b2, new Short(s));
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void aC(eo parameo) {
    try {
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      short s1 = parameo.b().readShort();
      short s2 = parameo.b().readShort();
      short s3 = parameo.b().readShort();
      byte b3 = parameo.b().readByte();
      byte b4 = parameo.b().readByte();
      byte b5 = parameo.b().readByte();
      byte b6 = parameo.b().readByte();
      parameo.b().readByte();
      parameo.b().readByte();
      au au = (au)ez.a(s1, b2);
      switch (b1) {
        case 0:
          au.bi = 8;
          au.bf = s2;
          au.bg = s3;
          au.dC = true;
          return;
        case 1:
          switch (b3) {
            case 0:
              cn.a(38, au.aY, au.aZ - 20);
              break;
            case 1:
              cn.a(85, au.aY, au.aZ, b4, s1, b2);
              break;
            case 2:
              cn.a(87, au.aY, au.aZ, b4, s1, b2);
              break;
            case 3:
              cn.a(36, au.aY, au.aZ);
              break;
          } 
          au.aY = s2;
          au.aZ = s3;
          switch (b5) {
            case 0:
              cn.a(38, au.aY, au.aZ - 20);
              return;
            case 1:
              cn.a(85, au.aY, au.aZ, b6, s1, b2);
              return;
            case 2:
              cn.a(87, au.aY, au.aZ, b6, s1, b2);
              return;
            case 3:
              au.dC = true;
              break;
          } 
          return;
      } 
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void aD(eo parameo) {
    try {
      byte b;
      if ((b = parameo.b().readByte()) == 0) {
        bw.Z.d();
        b = parameo.b().readByte();
        for (byte b1 = 0; b1 < b; b1++) {
          byte b2;
          if ((b2 = parameo.b().readByte()) == 3) {
            String str = parameo.b().readUTF();
            byte b3 = parameo.b().readByte();
            short s1 = parameo.b().readShort();
            byte b4 = parameo.b().readByte();
            short s2 = parameo.b().readShort();
            byte b5 = parameo.b().readByte();
            short s3 = parameo.b().readShort();
            byte b6 = parameo.b().readByte();
            byte b7;
            cz[] arrayOfCz = new cz[b7 = parameo.b().readByte()];
            for (byte b8 = 0; b8 < b7; b8++) {
              int i = parameo.b().readUnsignedByte();
              int k = parameo.b().readInt();
              arrayOfCz[b8] = new cz(i, k);
            } 
            j j = new j(s1, str, s2, b5, b6, b3, b2, arrayOfCz, b4, false, (short)-1, 0L, s3, (byte)0, (byte)0, -1, (byte)0, (byte)0);
            bw.Z.a(j);
          } else if (b2 == 4) {
            short s1 = parameo.b().readShort();
            short s2 = parameo.b().readShort();
            fo fo = (fo)fo.m.a(s1);
            j j = new j(s1, fo.b, fo.c, fo.j, s2, 4, fo.h, fo.i, fo.g, (byte)0, (byte)0);
            bw.Z.a(j);
          } else if (b2 == 7) {
            short s1 = parameo.b().readShort();
            short s2 = parameo.b().readShort();
            j j;
            if ((j = bw.b(s1)) != null) {
              j j1 = j.a(s1, j.g, j.t, 7, j.q, j.Q, j.h, j.P, j.A, s2, (byte)0, (byte)0);
              bw.Z.a(j1);
            } else {
              j j1;
              (j1 = new j()).O = s1;
              j1.u = 7;
              j1.K = s2;
              bw.Z.a(j1);
            } 
          } 
        } 
        es es = new es("ReadMessenge vec13");
        bb bb = new bb(df.fT, bw.Z, (byte)0);
        es.a(bb);
        (ft.v = new eu()).a = 0;
        ft.v.a(es);
        ft.v.a(cn.b());
        ft.j();
        return;
      } 
      if (b == 1) {
        b = parameo.b().readByte();
        byte b1 = parameo.b().readByte();
        bb.a((byte)1);
        bb.b(b1);
        bb.a = false;
        "itemIndex = " + b;
        "posIndex = " + b1;
        return;
      } 
      if (b == 2) {
        if ((b = parameo.b().readByte()) == 1) {
          parameo.b().readByte();
          boolean bool = false;
          byte b2;
          bb.b(b2 = parameo.b().readByte());
          bb.b = true;
          return;
        } 
        byte b1 = parameo.b().readByte();
        parameo.b().readByte();
        bb.b(b1);
        bb.b = false;
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public static void aE(eo parameo) {
    try {
      String str2 = parameo.b().readUTF();
      String str1 = parameo.b().readUTF();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream;
      (dataOutputStream = new DataOutputStream(byteArrayOutputStream)).writeUTF(str2);
      dataOutputStream.writeUTF(str1);
      ak.a("user_pass", byteArrayOutputStream.toByteArray());
      dataOutputStream.close();
      bs.m = str2;
      bs.f.b(str2);
      bs.g.b(str1);
      bs.h = str2;
      bs.i = str1;
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void aF(eo parameo) {
    try {
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      short s = parameo.b().readShort();
      byte b3 = parameo.b().readByte();
      cn.q.a(b1, b2, s);
      if (b3 == 0) {
        long l = parameo.b().readLong();
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public static void aG(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_1
    //   9: ifne -> 44
    //   12: aload_0
    //   13: invokevirtual b : ()Ljava/io/DataInputStream;
    //   16: invokevirtual readShort : ()S
    //   19: istore_1
    //   20: aload_0
    //   21: invokevirtual b : ()Ljava/io/DataInputStream;
    //   24: invokevirtual readShort : ()S
    //   27: istore_0
    //   28: iload_1
    //   29: iconst_0
    //   30: invokestatic a : (IB)Lez;
    //   33: dup
    //   34: astore_1
    //   35: ifnull -> 118
    //   38: aload_1
    //   39: iload_0
    //   40: putfield dH : S
    //   43: return
    //   44: iload_1
    //   45: iconst_1
    //   46: if_icmpne -> 54
    //   49: iconst_1
    //   50: putstatic v.a : Z
    //   53: return
    //   54: iload_1
    //   55: iconst_2
    //   56: if_icmpne -> 118
    //   59: aload_0
    //   60: invokevirtual b : ()Ljava/io/DataInputStream;
    //   63: invokevirtual readShort : ()S
    //   66: istore_1
    //   67: aload_0
    //   68: invokevirtual b : ()Ljava/io/DataInputStream;
    //   71: invokevirtual readByte : ()B
    //   74: istore_0
    //   75: iload_1
    //   76: iconst_1
    //   77: invokestatic a : (IB)Lez;
    //   80: dup
    //   81: astore_1
    //   82: ifnull -> 118
    //   85: iload_0
    //   86: ifeq -> 118
    //   89: aload_1
    //   90: iload_0
    //   91: aload_1
    //   92: getfield aY : I
    //   95: aload_1
    //   96: getfield aZ : I
    //   99: iconst_0
    //   100: iconst_0
    //   101: iload_0
    //   102: bipush #57
    //   104: if_icmpne -> 111
    //   107: iconst_2
    //   108: goto -> 112
    //   111: iconst_0
    //   112: iconst_0
    //   113: invokevirtual a : (IIIIIII)V
    //   116: return
    //   117: pop
    //   118: return
    // Exception table:
    //   from	to	target	type
    //   0	116	117	java/lang/Exception
  }
  
  public static void aH(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_1
    //   9: tableswitch default -> 134, 0 -> 36, 1 -> 59, 2 -> 91
    //   36: aload_0
    //   37: invokevirtual b : ()Ljava/io/DataInputStream;
    //   40: invokevirtual readByte : ()B
    //   43: dup
    //   44: istore_0
    //   45: iconst_1
    //   46: if_icmpne -> 54
    //   49: iconst_1
    //   50: putstatic bj.b : Z
    //   53: return
    //   54: iconst_0
    //   55: putstatic bj.b : Z
    //   58: return
    //   59: aload_0
    //   60: invokevirtual b : ()Ljava/io/DataInputStream;
    //   63: invokevirtual readShort : ()S
    //   66: istore_1
    //   67: aload_0
    //   68: invokevirtual b : ()Ljava/io/DataInputStream;
    //   71: invokevirtual readShort : ()S
    //   74: dup
    //   75: istore_0
    //   76: iconst_0
    //   77: invokestatic a : (IB)Lez;
    //   80: dup
    //   81: astore_0
    //   82: ifnull -> 136
    //   85: aload_0
    //   86: iload_1
    //   87: putfield bA : S
    //   90: return
    //   91: aload_0
    //   92: invokevirtual b : ()Ljava/io/DataInputStream;
    //   95: invokevirtual readByte : ()B
    //   98: istore_1
    //   99: aload_0
    //   100: invokevirtual b : ()Ljava/io/DataInputStream;
    //   103: invokevirtual readShort : ()S
    //   106: dup
    //   107: istore_0
    //   108: iconst_0
    //   109: invokestatic a : (IB)Lez;
    //   112: dup
    //   113: astore_0
    //   114: ifnull -> 136
    //   117: iload_1
    //   118: iconst_1
    //   119: if_icmpne -> 128
    //   122: aload_0
    //   123: iconst_1
    //   124: putfield dI : Z
    //   127: return
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield dI : Z
    //   133: return
    //   134: return
    //   135: pop
    //   136: return
    // Exception table:
    //   from	to	target	type
    //   0	134	135	java/lang/Exception
  }
  
  public static void aI(eo parameo) {
    try {
      short s1 = parameo.b().readShort();
      short s2 = parameo.b().readShort();
      short s3 = parameo.b().readShort();
      short s4 = parameo.b().readShort();
      byte b1 = parameo.b().readByte();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      byte b4 = parameo.b().readByte();
      byte b5 = parameo.b().readByte();
      String str1 = parameo.b().readUTF();
      String str2 = parameo.b().readUTF();
      byte b6 = parameo.b().readByte();
      byte b7;
      byte[] arrayOfByte1 = new byte[b7 = parameo.b().readByte()];
      short s;
      for (s = 0; s < arrayOfByte1.length; s++)
        arrayOfByte1[s] = (byte)parameo.b().readShort(); 
      byte[] arrayOfByte2 = new byte[s = parameo.b().readShort()];
      byte b8;
      for (b8 = 0; b8 < arrayOfByte2.length; b8++)
        arrayOfByte2[b8] = parameo.b().readByte(); 
      byte[] arrayOfByte3 = new byte[b8 = parameo.b().readByte()];
      byte b9;
      for (b9 = 0; b9 < arrayOfByte3.length; b9++)
        arrayOfByte3[b9] = parameo.b().readByte(); 
      b9 = parameo.b().readByte();
      for (byte b = 0; b < cn.i.c(); b++) {
        ez ez;
        if ((ez = (ez)cn.i.a(b)).j_() && ez.ct == b9) {
          ez.a(b6, s1, s2, b3, b4, b5, str1, str2, s3, s4, b1, b2, arrayOfByte1, arrayOfByte2, arrayOfByte3);
          return;
        } 
      } 
      bd bd;
      (bd = new bd(b6, s1, s2, b3, b4, b5, str1, str2, s3, s4, b1, b2, arrayOfByte1, arrayOfByte2, arrayOfByte3)).ct = b9;
      cn.i.a(bd);
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void aJ(eo parameo) {
    try {
      byte b = parameo.b().readByte();
      short s = parameo.b().readShort();
      cn.f.dQ = true;
      if (b == 0) {
        cn.q.U = true;
        n.b().a(s);
        return;
      } 
      if (b == 2) {
        (n.b()).b = true;
        return;
      } 
    } catch (IOException iOException2) {
      IOException iOException1;
      (iOException1 = null).printStackTrace();
    } 
  }
  
  public static void aK(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_1
    //   9: tableswitch default -> 99, 0 -> 32, 1 -> 77
    //   32: aload_0
    //   33: invokevirtual b : ()Ljava/io/DataInputStream;
    //   36: invokevirtual readShort : ()S
    //   39: istore_1
    //   40: aload_0
    //   41: invokevirtual b : ()Ljava/io/DataInputStream;
    //   44: invokevirtual readInt : ()I
    //   47: istore_2
    //   48: aload_0
    //   49: invokevirtual b : ()Ljava/io/DataInputStream;
    //   52: invokevirtual readInt : ()I
    //   55: istore_0
    //   56: iload_1
    //   57: iconst_0
    //   58: invokestatic a : (IB)Lez;
    //   61: dup
    //   62: astore_1
    //   63: ifnull -> 101
    //   66: aload_1
    //   67: iload_2
    //   68: putfield bt : I
    //   71: aload_1
    //   72: iload_0
    //   73: putfield bu : I
    //   76: return
    //   77: aload_0
    //   78: invokevirtual b : ()Ljava/io/DataInputStream;
    //   81: invokevirtual readByte : ()B
    //   84: istore_0
    //   85: invokestatic a : ()J
    //   88: ldc2_w 1000
    //   91: ldiv
    //   92: iload_0
    //   93: i2l
    //   94: ladd
    //   95: putstatic cf.Q : J
    //   98: return
    //   99: return
    //   100: pop
    //   101: return
    // Exception table:
    //   from	to	target	type
    //   0	99	100	java/lang/Exception
  }
  
  public static void aL(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_1
    //   9: tableswitch default -> 692, 1 -> 36, 2 -> 67, 3 -> 117
    //   36: aload_0
    //   37: invokevirtual b : ()Ljava/io/DataInputStream;
    //   40: invokevirtual readShort : ()S
    //   43: istore_1
    //   44: aload_0
    //   45: invokevirtual b : ()Ljava/io/DataInputStream;
    //   48: invokevirtual readUTF : ()Ljava/lang/String;
    //   51: astore_0
    //   52: iload_1
    //   53: invokestatic a : (S)Lez;
    //   56: dup
    //   57: astore_1
    //   58: ifnull -> 694
    //   61: aload_1
    //   62: aload_0
    //   63: invokevirtual b : (Ljava/lang/String;)V
    //   66: return
    //   67: aload_0
    //   68: invokevirtual b : ()Ljava/io/DataInputStream;
    //   71: invokevirtual readShort : ()S
    //   74: dup
    //   75: istore_0
    //   76: invokestatic a : (S)Lez;
    //   79: astore_1
    //   80: getstatic cn.f : Lbq;
    //   83: ifnull -> 108
    //   86: iload_0
    //   87: getstatic cn.f : Lbq;
    //   90: getfield ct : I
    //   93: if_icmpne -> 108
    //   96: getstatic bw.ab : Les;
    //   99: invokevirtual d : ()V
    //   102: getstatic bw.aa : Les;
    //   105: invokevirtual d : ()V
    //   108: aload_1
    //   109: ifnull -> 694
    //   112: aload_1
    //   113: invokevirtual k_ : ()V
    //   116: return
    //   117: getstatic bw.aa : Les;
    //   120: invokevirtual d : ()V
    //   123: aload_0
    //   124: invokevirtual b : ()Ljava/io/DataInputStream;
    //   127: invokevirtual readByte : ()B
    //   130: istore_1
    //   131: iconst_0
    //   132: istore_2
    //   133: goto -> 687
    //   136: aload_0
    //   137: invokevirtual b : ()Ljava/io/DataInputStream;
    //   140: invokevirtual readByte : ()B
    //   143: dup
    //   144: istore_3
    //   145: iconst_3
    //   146: if_icmpne -> 342
    //   149: aload_0
    //   150: invokevirtual b : ()Ljava/io/DataInputStream;
    //   153: invokevirtual readShort : ()S
    //   156: istore #4
    //   158: aload_0
    //   159: invokevirtual b : ()Ljava/io/DataInputStream;
    //   162: invokevirtual readUTF : ()Ljava/lang/String;
    //   165: astore #5
    //   167: aload_0
    //   168: invokevirtual b : ()Ljava/io/DataInputStream;
    //   171: invokevirtual readByte : ()B
    //   174: istore #12
    //   176: aload_0
    //   177: invokevirtual b : ()Ljava/io/DataInputStream;
    //   180: invokevirtual readByte : ()B
    //   183: istore #13
    //   185: aload_0
    //   186: invokevirtual b : ()Ljava/io/DataInputStream;
    //   189: invokevirtual readShort : ()S
    //   192: istore #14
    //   194: aload_0
    //   195: invokevirtual b : ()Ljava/io/DataInputStream;
    //   198: invokevirtual readByte : ()B
    //   201: istore #15
    //   203: aload_0
    //   204: invokevirtual b : ()Ljava/io/DataInputStream;
    //   207: invokevirtual readShort : ()S
    //   210: istore #6
    //   212: aload_0
    //   213: invokevirtual b : ()Ljava/io/DataInputStream;
    //   216: invokevirtual readByte : ()B
    //   219: istore #7
    //   221: aload_0
    //   222: invokevirtual b : ()Ljava/io/DataInputStream;
    //   225: invokevirtual readByte : ()B
    //   228: dup
    //   229: istore #8
    //   231: anewarray cz
    //   234: astore #9
    //   236: iconst_0
    //   237: istore #10
    //   239: goto -> 279
    //   242: aload_0
    //   243: invokevirtual b : ()Ljava/io/DataInputStream;
    //   246: invokevirtual readUnsignedByte : ()I
    //   249: istore #11
    //   251: aload_0
    //   252: invokevirtual b : ()Ljava/io/DataInputStream;
    //   255: invokevirtual readInt : ()I
    //   258: istore #16
    //   260: aload #9
    //   262: iload #10
    //   264: new cz
    //   267: dup
    //   268: iload #11
    //   270: iload #16
    //   272: invokespecial <init> : (II)V
    //   275: aastore
    //   276: iinc #10, 1
    //   279: iload #10
    //   281: iload #8
    //   283: if_icmplt -> 242
    //   286: aload_0
    //   287: invokevirtual b : ()Ljava/io/DataInputStream;
    //   290: invokevirtual readByte : ()B
    //   293: istore #10
    //   295: iload #4
    //   297: aload #5
    //   299: iload #14
    //   301: iload #15
    //   303: iload #7
    //   305: iload #12
    //   307: iconst_3
    //   308: aload #9
    //   310: iload #13
    //   312: iconst_0
    //   313: iload #4
    //   315: lconst_0
    //   316: iload #6
    //   318: iconst_0
    //   319: iconst_0
    //   320: iconst_0
    //   321: iload #10
    //   323: iconst_0
    //   324: invokestatic a : (ILjava/lang/String;IBIII[Lcz;IZSJSBBIBB)Lj;
    //   327: dup
    //   328: astore #11
    //   330: iconst_1
    //   331: putfield H : Z
    //   334: getstatic bw.aa : Les;
    //   337: aload #11
    //   339: invokevirtual a : (Ljava/lang/Object;)V
    //   342: iload_3
    //   343: bipush #7
    //   345: if_icmpne -> 538
    //   348: aload_0
    //   349: invokevirtual b : ()Ljava/io/DataInputStream;
    //   352: invokevirtual readShort : ()S
    //   355: istore #4
    //   357: aload_0
    //   358: invokevirtual b : ()Ljava/io/DataInputStream;
    //   361: invokevirtual readShort : ()S
    //   364: istore #5
    //   366: aload_0
    //   367: invokevirtual b : ()Ljava/io/DataInputStream;
    //   370: invokevirtual readByte : ()B
    //   373: istore #12
    //   375: aload_0
    //   376: invokevirtual b : ()Ljava/io/DataInputStream;
    //   379: invokevirtual readByte : ()B
    //   382: istore #13
    //   384: aload_0
    //   385: invokevirtual b : ()Ljava/io/DataInputStream;
    //   388: invokevirtual readLong : ()J
    //   391: lstore #14
    //   393: iload #4
    //   395: invokestatic b : (I)Lj;
    //   398: dup
    //   399: astore #6
    //   401: ifnull -> 463
    //   404: iload #4
    //   406: aload #6
    //   408: getfield g : Ljava/lang/String;
    //   411: aload #6
    //   413: getfield t : I
    //   416: bipush #7
    //   418: lload #14
    //   420: iconst_0
    //   421: aload #6
    //   423: getfield h : Ljava/lang/String;
    //   426: aload #6
    //   428: getfield P : I
    //   431: aload #6
    //   433: getfield A : B
    //   436: iload #5
    //   438: iload #12
    //   440: iload #13
    //   442: invokestatic a : (ILjava/lang/String;IIJBLjava/lang/String;IBSBB)Lj;
    //   445: dup
    //   446: astore #7
    //   448: iconst_1
    //   449: putfield H : Z
    //   452: getstatic bw.aa : Les;
    //   455: aload #7
    //   457: invokevirtual a : (Ljava/lang/Object;)V
    //   460: goto -> 538
    //   463: new j
    //   466: dup
    //   467: invokespecial <init> : ()V
    //   470: dup
    //   471: astore #7
    //   473: iload #4
    //   475: putfield O : I
    //   478: aload #7
    //   480: iload #5
    //   482: putfield K : I
    //   485: aload #7
    //   487: iload #12
    //   489: putfield x : B
    //   492: aload #7
    //   494: iload #13
    //   496: putfield y : B
    //   499: aload #7
    //   501: lload #14
    //   503: putfield q : J
    //   506: aload #7
    //   508: iconst_0
    //   509: putfield Q : B
    //   512: aload #7
    //   514: iconst_1
    //   515: putfield H : Z
    //   518: aload #7
    //   520: bipush #7
    //   522: putfield u : I
    //   525: iload #4
    //   527: invokestatic c : (I)V
    //   530: getstatic bw.aa : Les;
    //   533: aload #7
    //   535: invokevirtual a : (Ljava/lang/Object;)V
    //   538: iload_3
    //   539: iconst_4
    //   540: if_icmpne -> 684
    //   543: aload_0
    //   544: invokevirtual b : ()Ljava/io/DataInputStream;
    //   547: invokevirtual readShort : ()S
    //   550: istore #4
    //   552: aload_0
    //   553: invokevirtual b : ()Ljava/io/DataInputStream;
    //   556: invokevirtual readShort : ()S
    //   559: istore #5
    //   561: aload_0
    //   562: invokevirtual b : ()Ljava/io/DataInputStream;
    //   565: invokevirtual readInt : ()I
    //   568: i2l
    //   569: lstore #12
    //   571: iload #4
    //   573: invokestatic b : (S)Lfo;
    //   576: dup
    //   577: astore #14
    //   579: ifnull -> 684
    //   582: new j
    //   585: dup
    //   586: aload #14
    //   588: getfield a : I
    //   591: aload #14
    //   593: getfield b : I
    //   596: aload #14
    //   598: getfield c : Ljava/lang/String;
    //   601: new java/lang/StringBuffer
    //   604: dup
    //   605: aload #14
    //   607: getfield j : Ljava/lang/String;
    //   610: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   613: invokespecial <init> : (Ljava/lang/String;)V
    //   616: ldc '. '
    //   618: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   621: getstatic df.ba : Ljava/lang/String;
    //   624: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   627: ldc ' '
    //   629: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   632: lload #12
    //   634: invokestatic a : (J)Ljava/lang/String;
    //   637: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   640: ldc ' '
    //   642: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   645: getstatic df.bO : Ljava/lang/String;
    //   648: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   651: invokevirtual toString : ()Ljava/lang/String;
    //   654: iload #5
    //   656: iconst_4
    //   657: lload #12
    //   659: aload #14
    //   661: getfield i : B
    //   664: aload #14
    //   666: getfield g : B
    //   669: iconst_0
    //   670: iconst_0
    //   671: invokespecial <init> : (IILjava/lang/String;Ljava/lang/String;IIJBBBB)V
    //   674: astore #15
    //   676: getstatic bw.aa : Les;
    //   679: aload #15
    //   681: invokevirtual a : (Ljava/lang/Object;)V
    //   684: iinc #2, 1
    //   687: iload_2
    //   688: iload_1
    //   689: if_icmplt -> 136
    //   692: return
    //   693: pop
    //   694: return
    // Exception table:
    //   from	to	target	type
    //   0	692	693	java/lang/Exception
  }
  
  public static void aM(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_1
    //   9: tableswitch default -> 222, 0 -> 40, 1 -> 71, 2 -> 102, 3 -> 221
    //   40: aload_0
    //   41: invokevirtual b : ()Ljava/io/DataInputStream;
    //   44: invokevirtual readShort : ()S
    //   47: istore_1
    //   48: aload_0
    //   49: invokevirtual b : ()Ljava/io/DataInputStream;
    //   52: invokevirtual readUTF : ()Ljava/lang/String;
    //   55: astore_0
    //   56: iload_1
    //   57: invokestatic b : (S)Lez;
    //   60: dup
    //   61: astore_1
    //   62: ifnull -> 224
    //   65: aload_1
    //   66: aload_0
    //   67: invokevirtual a : (Ljava/lang/String;)V
    //   70: return
    //   71: aload_0
    //   72: invokevirtual b : ()Ljava/io/DataInputStream;
    //   75: invokevirtual readShort : ()S
    //   78: istore_1
    //   79: aload_0
    //   80: invokevirtual b : ()Ljava/io/DataInputStream;
    //   83: invokevirtual readShort : ()S
    //   86: istore_0
    //   87: getstatic cn.q : Lcf;
    //   90: iload_1
    //   91: putfield a : S
    //   94: getstatic cn.q : Lcf;
    //   97: iload_0
    //   98: putfield b : S
    //   101: return
    //   102: aload_0
    //   103: invokevirtual b : ()Ljava/io/DataInputStream;
    //   106: invokevirtual readShort : ()S
    //   109: istore_1
    //   110: aload_0
    //   111: invokevirtual b : ()Ljava/io/DataInputStream;
    //   114: invokevirtual readShort : ()S
    //   117: istore_2
    //   118: aload_0
    //   119: invokevirtual b : ()Ljava/io/DataInputStream;
    //   122: invokevirtual readShort : ()S
    //   125: istore_3
    //   126: aload_0
    //   127: invokevirtual b : ()Ljava/io/DataInputStream;
    //   130: invokevirtual readShort : ()S
    //   133: istore #4
    //   135: aload_0
    //   136: invokevirtual b : ()Ljava/io/DataInputStream;
    //   139: invokevirtual readByte : ()B
    //   142: istore #5
    //   144: iload_1
    //   145: invokestatic c : (S)Lez;
    //   148: dup
    //   149: astore_1
    //   150: ifnull -> 224
    //   153: iconst_0
    //   154: istore #6
    //   156: goto -> 213
    //   159: aload_0
    //   160: invokevirtual b : ()Ljava/io/DataInputStream;
    //   163: invokevirtual readShort : ()S
    //   166: istore #7
    //   168: aload_0
    //   169: invokevirtual b : ()Ljava/io/DataInputStream;
    //   172: invokevirtual readInt : ()I
    //   175: istore #8
    //   177: iload #7
    //   179: invokestatic c : (S)Lez;
    //   182: dup
    //   183: astore #7
    //   185: ifnull -> 210
    //   188: bipush #15
    //   190: aload_1
    //   191: aload #7
    //   193: aload_1
    //   194: getfield aY : I
    //   197: aload_1
    //   198: getfield aZ : I
    //   201: iload #8
    //   203: iload_2
    //   204: iload_3
    //   205: iload #4
    //   207: invokestatic a : (ILez;Lez;IIISII)V
    //   210: iinc #6, 1
    //   213: iload #6
    //   215: iload #5
    //   217: if_icmplt -> 159
    //   220: return
    //   221: return
    //   222: return
    //   223: pop
    //   224: return
    // Exception table:
    //   from	to	target	type
    //   0	222	223	java/lang/Exception
  }
  
  public static void aN(eo parameo) {
    try {
      String str;
      int i;
      byte b1;
      byte b;
      switch (b = parameo.b().readByte()) {
        case 0:
          i = parameo.b().readInt();
          str = parameo.b().readUTF();
          cf.X = i;
          cf.Y = str;
          return;
        case 1:
          cn.X.d();
          i = str.b().readByte();
          for (b1 = 0; b1 < i; b1++) {
            short s = str.b().readShort();
            String str1 = str.b().readUTF();
            if (s > 0) {
              dm dm = new dm(s, str1, ft.W / 2, ft.ab + 10 + b1 * ft.ab);
              cn.X.a(dm);
            } 
          } 
          return;
        case 2:
          if ((b1 = str.b().readByte()) > 0) {
            cn.aQ = new String[b1];
            for (byte b2 = 0; b2 < b1; b2++)
              cn.aQ[b2] = str.b().readUTF(); 
            return;
          } 
          cn.aQ = null;
          return;
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void aO(eo parameo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_1
    //   9: tableswitch default -> 797, 0 -> 48, 1 -> 131, 2 -> 138, 3 -> 236, 4 -> 558, 5 -> 680
    //   48: getstatic c.G : Les;
    //   51: invokevirtual d : ()V
    //   54: aload_0
    //   55: invokevirtual b : ()Ljava/io/DataInputStream;
    //   58: invokevirtual readByte : ()B
    //   61: istore_1
    //   62: aload_0
    //   63: invokevirtual b : ()Ljava/io/DataInputStream;
    //   66: invokevirtual readShort : ()S
    //   69: istore_0
    //   70: iconst_0
    //   71: istore_2
    //   72: goto -> 125
    //   75: iload_0
    //   76: invokestatic b : (I)Lj;
    //   79: dup
    //   80: astore_3
    //   81: ifnull -> 94
    //   84: getstatic c.G : Les;
    //   87: aload_3
    //   88: invokevirtual a : (Ljava/lang/Object;)V
    //   91: goto -> 122
    //   94: new j
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: dup
    //   102: astore_3
    //   103: iload_0
    //   104: putfield O : I
    //   107: getstatic c.l : Lj;
    //   110: bipush #7
    //   112: putfield u : I
    //   115: getstatic c.G : Les;
    //   118: aload_3
    //   119: invokevirtual a : (Ljava/lang/Object;)V
    //   122: iinc #2, 1
    //   125: iload_2
    //   126: iload_1
    //   127: if_icmplt -> 75
    //   130: return
    //   131: getstatic c.G : Les;
    //   134: invokevirtual d : ()V
    //   137: return
    //   138: invokestatic j : ()V
    //   141: iconst_1
    //   142: putstatic c.B : B
    //   145: aload_0
    //   146: invokevirtual b : ()Ljava/io/DataInputStream;
    //   149: invokevirtual readByte : ()B
    //   152: putstatic c.C : B
    //   155: aload_0
    //   156: invokevirtual b : ()Ljava/io/DataInputStream;
    //   159: invokevirtual readUTF : ()Ljava/lang/String;
    //   162: putstatic c.F : Ljava/lang/String;
    //   165: getstatic c.G : Les;
    //   168: invokevirtual d : ()V
    //   171: aload_0
    //   172: invokevirtual b : ()Ljava/io/DataInputStream;
    //   175: invokevirtual readShort : ()S
    //   178: istore_2
    //   179: aload_0
    //   180: invokevirtual b : ()Ljava/io/DataInputStream;
    //   183: invokevirtual readByte : ()B
    //   186: istore_3
    //   187: iload_2
    //   188: iconst_m1
    //   189: if_icmpeq -> 799
    //   192: iload_3
    //   193: bipush #7
    //   195: if_icmpne -> 799
    //   198: iload_2
    //   199: invokestatic b : (I)Lj;
    //   202: dup
    //   203: astore_3
    //   204: ifnull -> 212
    //   207: aload_3
    //   208: putstatic c.l : Lj;
    //   211: return
    //   212: new j
    //   215: dup
    //   216: invokespecial <init> : ()V
    //   219: dup
    //   220: putstatic c.l : Lj;
    //   223: iload_2
    //   224: putfield O : I
    //   227: getstatic c.l : Lj;
    //   230: bipush #7
    //   232: putfield u : I
    //   235: return
    //   236: invokestatic j : ()V
    //   239: iconst_1
    //   240: putstatic c.B : B
    //   243: aconst_null
    //   244: putstatic c.l : Lj;
    //   247: aload_0
    //   248: invokevirtual b : ()Ljava/io/DataInputStream;
    //   251: invokevirtual readByte : ()B
    //   254: putstatic c.C : B
    //   257: aload_0
    //   258: invokevirtual b : ()Ljava/io/DataInputStream;
    //   261: invokevirtual readUTF : ()Ljava/lang/String;
    //   264: putstatic c.F : Ljava/lang/String;
    //   267: getstatic c.G : Les;
    //   270: invokevirtual d : ()V
    //   273: getstatic c.C : B
    //   276: iconst_3
    //   277: if_icmpne -> 799
    //   280: aload_0
    //   281: invokevirtual b : ()Ljava/io/DataInputStream;
    //   284: invokevirtual readByte : ()B
    //   287: istore_3
    //   288: aload_0
    //   289: invokevirtual b : ()Ljava/io/DataInputStream;
    //   292: invokevirtual readUTF : ()Ljava/lang/String;
    //   295: astore_1
    //   296: aload_0
    //   297: invokevirtual b : ()Ljava/io/DataInputStream;
    //   300: invokevirtual readByte : ()B
    //   303: istore_2
    //   304: aload_0
    //   305: invokevirtual b : ()Ljava/io/DataInputStream;
    //   308: invokevirtual readShort : ()S
    //   311: istore #4
    //   313: aload_0
    //   314: invokevirtual b : ()Ljava/io/DataInputStream;
    //   317: invokevirtual readByte : ()B
    //   320: istore #5
    //   322: aload_0
    //   323: invokevirtual b : ()Ljava/io/DataInputStream;
    //   326: invokevirtual readShort : ()S
    //   329: istore #6
    //   331: aload_0
    //   332: invokevirtual b : ()Ljava/io/DataInputStream;
    //   335: invokevirtual readByte : ()B
    //   338: istore #7
    //   340: aload_0
    //   341: invokevirtual b : ()Ljava/io/DataInputStream;
    //   344: invokevirtual readShort : ()S
    //   347: istore #8
    //   349: aload_0
    //   350: invokevirtual b : ()Ljava/io/DataInputStream;
    //   353: invokevirtual readByte : ()B
    //   356: istore #9
    //   358: aload_0
    //   359: invokevirtual b : ()Ljava/io/DataInputStream;
    //   362: invokevirtual readByte : ()B
    //   365: istore #10
    //   367: aload_0
    //   368: invokevirtual b : ()Ljava/io/DataInputStream;
    //   371: invokevirtual readByte : ()B
    //   374: istore #11
    //   376: aload_0
    //   377: invokevirtual b : ()Ljava/io/DataInputStream;
    //   380: invokevirtual readByte : ()B
    //   383: dup
    //   384: istore #12
    //   386: anewarray cz
    //   389: astore #13
    //   391: iconst_0
    //   392: istore #14
    //   394: goto -> 434
    //   397: aload_0
    //   398: invokevirtual b : ()Ljava/io/DataInputStream;
    //   401: invokevirtual readUnsignedByte : ()I
    //   404: istore #15
    //   406: aload_0
    //   407: invokevirtual b : ()Ljava/io/DataInputStream;
    //   410: invokevirtual readInt : ()I
    //   413: istore #16
    //   415: aload #13
    //   417: iload #14
    //   419: new cz
    //   422: dup
    //   423: iload #15
    //   425: iload #16
    //   427: invokespecial <init> : (II)V
    //   430: aastore
    //   431: iinc #14, 1
    //   434: iload #14
    //   436: iload #12
    //   438: if_icmplt -> 397
    //   441: aload_0
    //   442: invokevirtual b : ()Ljava/io/DataInputStream;
    //   445: invokevirtual readInt : ()I
    //   448: istore #14
    //   450: aload_0
    //   451: invokevirtual b : ()Ljava/io/DataInputStream;
    //   454: invokevirtual readByte : ()B
    //   457: istore #15
    //   459: aload_0
    //   460: invokevirtual b : ()Ljava/io/DataInputStream;
    //   463: invokevirtual readByte : ()B
    //   466: istore #16
    //   468: iconst_m1
    //   469: istore #12
    //   471: ldc '-1'
    //   473: astore #17
    //   475: iload #16
    //   477: iconst_1
    //   478: if_icmpne -> 499
    //   481: aload_0
    //   482: invokevirtual b : ()Ljava/io/DataInputStream;
    //   485: invokevirtual readInt : ()I
    //   488: istore #12
    //   490: aload_0
    //   491: invokevirtual b : ()Ljava/io/DataInputStream;
    //   494: invokevirtual readUTF : ()Ljava/lang/String;
    //   497: astore #17
    //   499: aload_0
    //   500: invokevirtual b : ()Ljava/io/DataInputStream;
    //   503: invokevirtual readByte : ()B
    //   506: pop
    //   507: aconst_null
    //   508: astore_0
    //   509: new j
    //   512: dup
    //   513: iload #4
    //   515: aload_1
    //   516: iload #6
    //   518: iload #7
    //   520: iload #9
    //   522: iload_2
    //   523: iload_3
    //   524: aload #13
    //   526: iload #5
    //   528: iconst_0
    //   529: iconst_m1
    //   530: lconst_0
    //   531: iload #8
    //   533: iload #10
    //   535: iload #11
    //   537: iload #14
    //   539: iconst_0
    //   540: iload #15
    //   542: iload #12
    //   544: aload #17
    //   546: invokestatic parseLong : (Ljava/lang/String;)J
    //   549: invokespecial <init> : (ILjava/lang/String;IBIII[Lcz;IZSJSBBIBBIJ)V
    //   552: dup
    //   553: astore_0
    //   554: putstatic c.l : Lj;
    //   557: return
    //   558: aload_0
    //   559: invokevirtual b : ()Ljava/io/DataInputStream;
    //   562: invokevirtual readByte : ()B
    //   565: istore_3
    //   566: getstatic c.G : Les;
    //   569: invokevirtual d : ()V
    //   572: iconst_0
    //   573: istore_1
    //   574: goto -> 674
    //   577: aload_0
    //   578: invokevirtual b : ()Ljava/io/DataInputStream;
    //   581: invokevirtual readShort : ()S
    //   584: istore_2
    //   585: aload_0
    //   586: invokevirtual b : ()Ljava/io/DataInputStream;
    //   589: invokevirtual readShort : ()S
    //   592: istore #4
    //   594: iload_2
    //   595: iconst_m1
    //   596: if_icmpeq -> 671
    //   599: getstatic c.i : [B
    //   602: iload_1
    //   603: iload_2
    //   604: iload #4
    //   606: invokestatic a : (SI)B
    //   609: bastore
    //   610: getstatic c.h : [Ljava/lang/String;
    //   613: iload_1
    //   614: iload_2
    //   615: iload #4
    //   617: invokestatic b : (SI)Ljava/lang/String;
    //   620: aastore
    //   621: iload_2
    //   622: invokestatic b : (I)Lj;
    //   625: dup
    //   626: astore #6
    //   628: ifnull -> 642
    //   631: getstatic c.G : Les;
    //   634: aload #6
    //   636: invokevirtual a : (Ljava/lang/Object;)V
    //   639: goto -> 671
    //   642: new j
    //   645: dup
    //   646: invokespecial <init> : ()V
    //   649: dup
    //   650: astore #7
    //   652: iload_2
    //   653: putfield O : I
    //   656: aload #7
    //   658: bipush #7
    //   660: putfield u : I
    //   663: getstatic c.G : Les;
    //   666: aload #7
    //   668: invokevirtual a : (Ljava/lang/Object;)V
    //   671: iinc #1, 1
    //   674: iload_1
    //   675: iload_3
    //   676: if_icmplt -> 577
    //   679: return
    //   680: invokestatic j : ()V
    //   683: iconst_1
    //   684: putstatic c.B : B
    //   687: aconst_null
    //   688: putstatic c.l : Lj;
    //   691: aload_0
    //   692: invokevirtual b : ()Ljava/io/DataInputStream;
    //   695: invokevirtual readByte : ()B
    //   698: putstatic c.C : B
    //   701: aload_0
    //   702: invokevirtual b : ()Ljava/io/DataInputStream;
    //   705: invokevirtual readUTF : ()Ljava/lang/String;
    //   708: putstatic c.F : Ljava/lang/String;
    //   711: getstatic c.G : Les;
    //   714: invokevirtual d : ()V
    //   717: aload_0
    //   718: invokevirtual b : ()Ljava/io/DataInputStream;
    //   721: invokevirtual readShort : ()S
    //   724: istore_1
    //   725: iconst_3
    //   726: iload_1
    //   727: invokestatic a : (IS)Lbw;
    //   730: dup
    //   731: astore_2
    //   732: ifnull -> 799
    //   735: iload_1
    //   736: aload_2
    //   737: getfield i : Ljava/lang/String;
    //   740: aload_2
    //   741: getfield t : I
    //   744: aload_2
    //   745: getfield z : B
    //   748: aload_2
    //   749: getfield N : I
    //   752: aload_2
    //   753: getfield M : I
    //   756: iconst_3
    //   757: aload_2
    //   758: getfield j : [Lcz;
    //   761: aload_2
    //   762: getfield R : I
    //   765: iconst_0
    //   766: aload_2
    //   767: getfield v : S
    //   770: aload_2
    //   771: getfield q : J
    //   774: aload_2
    //   775: getfield S : I
    //   778: i2s
    //   779: aload_2
    //   780: getfield x : B
    //   783: aload_2
    //   784: getfield y : B
    //   787: iconst_0
    //   788: iconst_0
    //   789: iconst_0
    //   790: invokestatic a : (ILjava/lang/String;IBIII[Lcz;IZSJSBBIBB)Lj;
    //   793: putstatic c.l : Lj;
    //   796: return
    //   797: return
    //   798: pop
    //   799: return
    // Exception table:
    //   from	to	target	type
    //   0	797	798	java/lang/Exception
  }
  
  public static void aP(eo parameo) {
    try {
      short s1 = parameo.b().readShort();
      short s2 = parameo.b().readShort();
      long l = parameo.b().readLong();
      String str1 = parameo.b().readUTF();
      String str2 = parameo.b().readUTF();
      byte b2 = parameo.b().readByte();
      byte b3 = parameo.b().readByte();
      byte b4 = parameo.b().readByte();
      short s3 = parameo.b().readShort();
      byte b5 = parameo.b().readByte();
      byte b1 = parameo.b().readByte();
      j j;
      if ((j = (j)fo.n.a((new StringBuffer(String.valueOf(s1))).toString())) != null) {
        j.a(s1, str1, s2, 7, l, b3, str2, s3, b2, b4, b5);
        j.d(b1);
      } 
      for (byte b = 0; b < bw.V.c(); b++) {
        j j1;
        if ((j1 = (j)bw.V.a(b)) != null && j1.u == 7 && j1.O == s1) {
          j1.a(s1, str1, s2, 7, l, b3, str2, s3, b2, b4, b5);
          j1.d(b1);
        } 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void aQ(eo parameo) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual b : ()Ljava/io/DataInputStream;
    //   4: invokevirtual readByte : ()B
    //   7: dup
    //   8: istore_0
    //   9: tableswitch default -> 582, 0 -> 60, 1 -> 133, 2 -> 154, 3 -> 255, 4 -> 331, 5 -> 348, 6 -> 382, 7 -> 436, 8 -> 484
    //   60: getstatic ft.c : Lcn;
    //   63: iconst_0
    //   64: putfield aW : Z
    //   67: getstatic ft.c : Lcn;
    //   70: aload_1
    //   71: invokevirtual b : ()Ljava/io/DataInputStream;
    //   74: invokevirtual readInt : ()I
    //   77: putfield aV : I
    //   80: getstatic ft.c : Lcn;
    //   83: aload_1
    //   84: invokevirtual b : ()Ljava/io/DataInputStream;
    //   87: invokevirtual readShort : ()S
    //   90: putfield aR : I
    //   93: getstatic ft.c : Lcn;
    //   96: aload_1
    //   97: invokevirtual b : ()Ljava/io/DataInputStream;
    //   100: invokevirtual readShort : ()S
    //   103: putfield aS : I
    //   106: getstatic ft.c : Lcn;
    //   109: aload_1
    //   110: invokevirtual b : ()Ljava/io/DataInputStream;
    //   113: invokevirtual readShort : ()S
    //   116: putfield aT : I
    //   119: getstatic ft.c : Lcn;
    //   122: aload_1
    //   123: invokevirtual b : ()Ljava/io/DataInputStream;
    //   126: invokevirtual readShort : ()S
    //   129: putfield aU : I
    //   132: return
    //   133: getstatic ft.c : Lcn;
    //   136: aload_1
    //   137: invokevirtual b : ()Ljava/io/DataInputStream;
    //   140: invokevirtual readInt : ()I
    //   143: putfield aV : I
    //   146: getstatic ft.c : Lcn;
    //   149: iconst_1
    //   150: putfield aW : Z
    //   153: return
    //   154: aload_1
    //   155: invokevirtual b : ()Ljava/io/DataInputStream;
    //   158: invokevirtual readByte : ()B
    //   161: istore_0
    //   162: aload_1
    //   163: invokevirtual b : ()Ljava/io/DataInputStream;
    //   166: invokevirtual readShort : ()S
    //   169: istore_2
    //   170: aload_1
    //   171: invokevirtual b : ()Ljava/io/DataInputStream;
    //   174: invokevirtual readShort : ()S
    //   177: istore_3
    //   178: aload_1
    //   179: invokevirtual b : ()Ljava/io/DataInputStream;
    //   182: invokevirtual readUTF : ()Ljava/lang/String;
    //   185: astore #4
    //   187: iconst_0
    //   188: istore #5
    //   190: iload_0
    //   191: iconst_3
    //   192: if_icmpeq -> 206
    //   195: iload_0
    //   196: iconst_4
    //   197: if_icmpeq -> 206
    //   200: iload_0
    //   201: bipush #7
    //   203: if_icmpne -> 215
    //   206: aload_1
    //   207: invokevirtual b : ()Ljava/io/DataInputStream;
    //   210: invokevirtual readByte : ()B
    //   213: istore #5
    //   215: aload_1
    //   216: invokevirtual b : ()Ljava/io/DataInputStream;
    //   219: invokevirtual readShort : ()S
    //   222: istore #6
    //   224: aload_1
    //   225: invokevirtual b : ()Ljava/io/DataInputStream;
    //   228: invokevirtual readShort : ()S
    //   231: istore_1
    //   232: new fv
    //   235: dup
    //   236: iload_3
    //   237: iload_0
    //   238: aload #4
    //   240: iload #6
    //   242: iload_1
    //   243: iload_2
    //   244: iload #5
    //   246: invokespecial <init> : (IBLjava/lang/String;IISB)V
    //   249: dup
    //   250: astore_0
    //   251: invokestatic a : (Lez;)V
    //   254: return
    //   255: aload_1
    //   256: invokevirtual b : ()Ljava/io/DataInputStream;
    //   259: invokevirtual readInt : ()I
    //   262: istore_0
    //   263: getstatic ft.c : Lcn;
    //   266: aconst_null
    //   267: putfield aX : Laq;
    //   270: iload_0
    //   271: ifle -> 316
    //   274: iload_0
    //   275: newarray byte
    //   277: astore_2
    //   278: iload_0
    //   279: ifle -> 584
    //   282: iconst_0
    //   283: istore_3
    //   284: goto -> 300
    //   287: aload_2
    //   288: iload_3
    //   289: aload_1
    //   290: invokevirtual b : ()Ljava/io/DataInputStream;
    //   293: invokevirtual readByte : ()B
    //   296: bastore
    //   297: iinc #3, 1
    //   300: iload_3
    //   301: iload_0
    //   302: if_icmplt -> 287
    //   305: getstatic ft.c : Lcn;
    //   308: aload_2
    //   309: invokestatic a : ([B)Laq;
    //   312: putfield aX : Laq;
    //   315: return
    //   316: getstatic ft.c : Lcn;
    //   319: aconst_null
    //   320: putfield aX : Laq;
    //   323: getstatic cn.f : Lbq;
    //   326: iconst_m1
    //   327: putfield D : I
    //   330: return
    //   331: invokestatic s : ()V
    //   334: getstatic cn.f : Lbq;
    //   337: aload_1
    //   338: invokevirtual b : ()Ljava/io/DataInputStream;
    //   341: invokevirtual readInt : ()I
    //   344: putfield D : I
    //   347: return
    //   348: aload_1
    //   349: invokevirtual b : ()Ljava/io/DataInputStream;
    //   352: invokevirtual readByte : ()B
    //   355: dup
    //   356: istore_2
    //   357: iconst_1
    //   358: if_icmpne -> 584
    //   361: aconst_null
    //   362: putstatic cn.h : Lez;
    //   365: getstatic cn.f : Lbq;
    //   368: invokevirtual q : ()V
    //   371: getstatic cn.f : Lbq;
    //   374: invokevirtual v : ()V
    //   377: goto -> 584
    //   380: pop
    //   381: return
    //   382: aload_1
    //   383: invokevirtual b : ()Ljava/io/DataInputStream;
    //   386: invokevirtual readInt : ()I
    //   389: istore_3
    //   390: aload_1
    //   391: invokevirtual b : ()Ljava/io/DataInputStream;
    //   394: invokevirtual readUTF : ()Ljava/lang/String;
    //   397: astore_0
    //   398: iload_3
    //   399: ifle -> 427
    //   402: invokestatic a : ()J
    //   405: iload_3
    //   406: sipush #1000
    //   409: imul
    //   410: i2l
    //   411: ladd
    //   412: lstore #15
    //   414: new cy
    //   417: dup
    //   418: lload #15
    //   420: aload_0
    //   421: invokespecial <init> : (JLjava/lang/String;)V
    //   424: putstatic cn.aY : Lcy;
    //   427: iload_3
    //   428: ifge -> 584
    //   431: aconst_null
    //   432: putstatic cn.aY : Lcy;
    //   435: return
    //   436: aload_1
    //   437: invokevirtual b : ()Ljava/io/DataInputStream;
    //   440: invokevirtual readShort : ()S
    //   443: istore #15
    //   445: aload_1
    //   446: invokevirtual b : ()Ljava/io/DataInputStream;
    //   449: invokevirtual readShort : ()S
    //   452: istore #16
    //   454: aload_1
    //   455: invokevirtual b : ()Ljava/io/DataInputStream;
    //   458: invokevirtual readShort : ()S
    //   461: istore_0
    //   462: new at
    //   465: dup
    //   466: iload #15
    //   468: iload #16
    //   470: iload_0
    //   471: aconst_null
    //   472: invokespecial <init> : (SII[B)V
    //   475: astore_0
    //   476: getstatic cn.aZ : Les;
    //   479: aload_0
    //   480: invokevirtual a : (Ljava/lang/Object;)V
    //   483: return
    //   484: aload_1
    //   485: invokevirtual b : ()Ljava/io/DataInputStream;
    //   488: invokevirtual readShort : ()S
    //   491: istore_0
    //   492: aload_1
    //   493: invokevirtual b : ()Ljava/io/DataInputStream;
    //   496: invokevirtual readByte : ()B
    //   499: istore_2
    //   500: aload_1
    //   501: invokevirtual b : ()Ljava/io/DataInputStream;
    //   504: invokevirtual readShort : ()S
    //   507: istore_1
    //   508: iload_2
    //   509: ifne -> 547
    //   512: iload_1
    //   513: invokestatic a : (S)Lez;
    //   516: dup
    //   517: astore_1
    //   518: ifnull -> 584
    //   521: new at
    //   524: dup
    //   525: iload_0
    //   526: aload_1
    //   527: getfield aY : I
    //   530: aload_1
    //   531: getfield aZ : I
    //   534: aconst_null
    //   535: invokespecial <init> : (SII[B)V
    //   538: astore_0
    //   539: getstatic cn.aZ : Les;
    //   542: aload_0
    //   543: invokevirtual a : (Ljava/lang/Object;)V
    //   546: return
    //   547: iload_1
    //   548: invokestatic b : (S)Lez;
    //   551: dup
    //   552: astore_1
    //   553: ifnull -> 584
    //   556: new at
    //   559: dup
    //   560: iload_0
    //   561: aload_1
    //   562: getfield aY : I
    //   565: aload_1
    //   566: getfield aZ : I
    //   569: aconst_null
    //   570: invokespecial <init> : (SII[B)V
    //   573: astore_0
    //   574: getstatic cn.aZ : Les;
    //   577: aload_0
    //   578: invokevirtual a : (Ljava/lang/Object;)V
    //   581: return
    //   582: return
    //   583: pop
    //   584: return
    // Exception table:
    //   from	to	target	type
    //   0	582	583	java/lang/Exception
    //   361	377	380	java/lang/Exception
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\eq.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */