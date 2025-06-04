public final class cf {
  public short a = -1;
  
  public short b = -1;
  
  private int Z = 0;
  
  private int aa = 0;
  
  private int ab = 0;
  
  private int ac = 0;
  
  private int ad = 2;
  
  private int ae = 2;
  
  private int af;
  
  public int c;
  
  public int d;
  
  private int ag = 22;
  
  public static int e = 55;
  
  public static int f = ft.X - 55;
  
  public static int g;
  
  public static int h;
  
  public static int i;
  
  private static int ah;
  
  private static int ai;
  
  public static int j = 30;
  
  private static aq[] aj;
  
  private static aq[] ak;
  
  public static aq[] k;
  
  public static aq l;
  
  public static aq m;
  
  public static aq n;
  
  public static ce o;
  
  public static ce p;
  
  public static ce q;
  
  public static ce r;
  
  public static ce s;
  
  public static ce t;
  
  public static ce u;
  
  public static ce v;
  
  public static ce w;
  
  public static ce x;
  
  public static ce[] y;
  
  private int[] al = new int[] { 2, 3, 1 };
  
  private int[] am = new int[] { 4, 6, 2, 8 };
  
  private static int[] an = new int[] { 1, 3, 7, 9 };
  
  public static int[] z = new int[] { 1, 3, 5, 7, 9 };
  
  public static String[] A = new String[] { "R", "T", "Y", "U", "I" };
  
  private static int[][] ao = dw.a(4, 2);
  
  private static int[][] ap = dw.a(4, 2);
  
  public static int[][] B = dw.a(5, 2);
  
  private static int[][] aq = dw.a(5, 2);
  
  private static int ar = 0;
  
  private static int as;
  
  public static int C;
  
  private static int at;
  
  private static int au;
  
  private static int av;
  
  private static int aw;
  
  private static String ax = "";
  
  public static int D = ft.W - 35;
  
  public static int E = ft.X - 50;
  
  private static int ay = 24;
  
  private static int az = 50;
  
  private static int aA = 285;
  
  private static int aB = 50;
  
  private static int aC = ft.Y - 60;
  
  private static int aD = ft.X - ft.aa - 14;
  
  public String F;
  
  public String G;
  
  public String H;
  
  public static boolean I = false;
  
  public static boolean J = true;
  
  public static boolean K = false;
  
  public static int L = 0;
  
  public static boolean M = true;
  
  public static int N;
  
  private static int aE;
  
  private static int aF;
  
  public static int[] O = new int[3];
  
  public static int[] P = new int[3];
  
  public static long Q;
  
  public static int R;
  
  public static int S;
  
  private int aG;
  
  private int aH;
  
  private static int aI;
  
  private fm aJ;
  
  private long aK;
  
  private int aL;
  
  private short[] aM;
  
  private int aN;
  
  private boolean aO;
  
  private static es aP = new es("PaintInfoGameScr vecfocus");
  
  private static int aQ;
  
  private static int aR;
  
  private static boolean aS;
  
  private byte[] aT;
  
  private short[] aU;
  
  private byte[] aV;
  
  public static ce T;
  
  private byte[] aW;
  
  public boolean U;
  
  public dq V;
  
  private int aX;
  
  private int aY;
  
  public static byte W = 0;
  
  public static int X = -1;
  
  public static String Y;
  
  public cf() {
    (new int[4])[0] = 100;
    (new int[4])[1] = 101;
    (new int[4])[2] = 102;
    (new int[4])[3] = 103;
    this.F = null;
    this.aG = 0;
    this.aJ = null;
    this.aK = -1L;
    this.aL = 0;
    this.aO = true;
    this.aT = new byte[4];
    this.aU = new short[4];
    this.aV = new byte[] { 1, 4, 5, 2 };
    this.aW = new byte[] { 3, 2, 1, 4 };
    this.U = false;
    this.aX = 0;
    this.aY = 0;
  }
  
  public static void a() {
    ai = (ft.W << 1) / 3 - 63;
    if ((ah = ft.X / 4 - (ft.A ? 75 : 30)) < 1)
      ah = 1; 
    N = ft.W - 52;
    aE = 0;
    g = 70;
    h = 45;
    if (ft.A) {
      ay = 32;
      int i = aA;
      byte b;
      for (b = 0; b < ao.length; b++) {
        ao[b][0] = D + ak.b(ak.d(i)) * aB / 1000;
        ao[b][1] = E + ak.a(ak.d(i)) * aB / 1000;
        i -= 45;
      } 
      aC = ft.W - ay * 6;
      aD = ft.X - 24;
      B[0][0] = 8;
      B[0][1] = 43;
      B[1][0] = 8;
      B[1][1] = 73;
      B[2][0] = ft.W - 27;
      B[2][1] = ft.X - 145;
      B[3][0] = ft.W - 27;
      B[3][1] = ft.X - 175;
      B[4][0] = ft.Y - 20;
      B[4][1] = ft.X - 16;
      h();
      g = 45;
      h = 45;
      k = new aq[5];
      for (b = 0; b < k.length; b++) {
        k[b] = aq.a("/point/other_" + b + ".img");
        aq[b][0] = aq.a((k[b]).a);
        aq[b][1] = aq.b((k[b]).a) / 2;
      } 
      aj = new aq[3];
      for (b = 0; b < aj.length; b++) {
        if (b != 1)
          aj[b] = aq.a("/point/move_" + b + ".img"); 
      } 
      for (b = 0; b < ap.length; b++) {
        ap[b][0] = e + ((b < 2) ? (-j + (j << 1) * b % 2) : 0);
        ap[b][1] = f + ((b > 1) ? (-j + (j << 1) * b % 2) : 0);
      } 
      ak = new aq[2];
      for (b = 0; b < ak.length; b++)
        ak[b] = aq.a("/point/fire_" + b + ".img"); 
      o = new ce(aq.a("/point/close.img"), 14, 14);
      t = new ce(aq.a("/point/closemenu.img"), 21, 21);
      q = new ce(aq.a("/point/buttonback.png"), 57, 30);
      r = new ce(aq.a("/point/button.img"), 80, 30);
      v = new ce(aq.a("/point/button2.img"), 60, 19);
      w = new ce(aq.a("/point/contact.img"), 26, 26);
      y = new ce[11];
      for (b = 0; b < y.length; b++)
        y[b] = new ce(aq.a("/point/quick_" + b + ".png"), 30, 30); 
      n = aq.a("/point/backquick.img");
      aq.a("/interface/move.img");
      N = ft.Y;
    } 
    aI = 130;
  }
  
  public static void a(bx parambx, boolean paramBoolean) {
    if (paramBoolean) {
      aF = 0;
    } else {
      aF = 10;
    } 
    parambx.a(cg.ad[0], 0, 0, O[0], P[0], 0, ft.W - O[0] + aF, -aF, 0);
    parambx.a(cg.ad[0], 0, 0, O[0], P[0], 1, ft.W - O[0] + aF, ft.X - P[0] + aF, 0);
    parambx.a(cg.ad[0], 0, 0, O[0], P[0], 2, -aF, -aF, 0);
    parambx.a(cg.ad[0], 0, 0, O[0], P[0], 4, -aF, ft.X - P[0] + aF, 0);
    int i = (ft.W + aF - 2 * O[0]) / O[1] + 1;
    int j;
    for (j = 0; j < i; j++) {
      parambx.a(cg.ad[1], 0, 0, O[1], P[1], 0, O[0] + O[1] * j - aF, -aF, 0);
      parambx.a(cg.ad[1], 0, 0, O[1], P[1], 1, O[0] + O[1] * j - aF, ft.X - P[1] + aF, 0);
    } 
    j = (ft.W + aF - 2 * P[0]) / P[2] + 1;
    for (i = 0; i < j; i++) {
      parambx.a(cg.ad[2], 0, 0, O[2], P[2], 0, -aF, P[0] + P[2] * i - aF, 0);
      parambx.a(cg.ad[2], 0, 0, O[2], P[2], 2, ft.W - O[2] + aF, P[0] + P[2] * i - aF, 0);
    } 
  }
  
  public final void a(bx parambx) {
    if (C == 0) {
      int i = aD;
      if (cn.h != null && cn.h.cx == 2) {
        for (byte b1 = 0; b1 < 5; b1++) {
          parambx.a(cg.ap, aC + b1 * ay, i - 5, 0);
          if (!ft.A && fi.h) {
            cg.a(parambx, (new StringBuffer(String.valueOf(A[b1]))).toString(), aC + b1 * ay + 11, i, 2);
          } else {
            cg.a(parambx, (new StringBuffer(String.valueOf(z[b1]))).toString(), aC + b1 * ay + 11, i, 2);
          } 
        } 
        return;
      } 
      for (byte b = 0; b < (bq.w[0]).length; b++) {
        parambx.a(cg.ap, aC + b * ay, aD - 5, 0);
        ao ao = bq.w[bq.d][b];
        ad ad = null;
        if (this.b == 0) {
          ev ev;
          if ((ev = ct.c(this.a)) != null)
            ev.a(parambx, aC + b * ay + 11, aD - 5 + 11, 3); 
          ad = bq.r[this.a];
        } else if (this.b == ao.f && fo.d) {
          bw bw;
          if ((bw = bw.a(4, this.a)) != null && bw.L < 2) {
            bw.a(parambx, aC + b * ay + 11, aD + 11 - 5, fl.aM, 0, 3);
            ad = bq.s[bw.L];
          } else {
            a(0, ao.d, (byte)0);
            j.a((byte)1, false);
            j.a((byte)0, false);
          } 
        } 
        if (this.b != ao.d && ad != null && ad.c > 0)
          if (ad.b > 0) {
            int k;
            int m;
            if ((m = ad.b * 20 / ad.c) < 1)
              m = 1; 
            parambx.a(cg.am, 0, 0, 20, m, 0, aC + b * ay + 1, aD + 1 - 5, 0);
            int j = ad.b / 1000;
            String str = null;
            if (j == 0) {
              str = "0." + (ad.b % 1000 / 100);
            } else {
              k = j;
            } 
            o.f.a(parambx, k, aC + b * ay + 11, aD + 5 - 5, 2, false);
          } else if (ad.b > -150) {
            parambx.a(-1118516);
            parambx.a(aC + b * ay + 1, aD - 5 + 1, 20, 20, 4, 4);
          }  
        if (!ft.A)
          if (fi.h) {
            o.f.a(parambx, (new StringBuffer(String.valueOf(A[b]))).toString(), aC + b * ay + 12, aD - 5 - 11, 2, false);
          } else {
            o.f.a(parambx, (new StringBuffer(String.valueOf(z[b]))).toString(), aC + b * ay + 12, aD - 5 - 11, 2, false);
          }  
      } 
      return;
    } 
    l(parambx);
  }
  
  private static void l(bx parambx) {
    for (byte b = 0; b < 10; b++) {
      ev ev;
      int i = 0;
      int j = bq.d;
      if (b < 5) {
        i = C << 3;
      } else {
        i = 64 - (C << 3);
        if (bq.d == 0) {
          j = 1;
        } else {
          j = 0;
        } 
      } 
      parambx.a(cg.ap, aC + b % 5 * ay - 1, i + aD - 1, 0);
      ao ao;
      if ((ao = bq.w[j][b % 5]).b == 0) {
        (ev = ct.c(ao.a)).a(parambx, aC + b % 5 * ay + 11, i + aD + 11, 3);
      } else {
        bw bw;
        if (((ao)ev).b == ao.f && (bw = bw.a(4, ((ao)ev).a)) != null)
          bw.a(parambx, aC + b % 5 * ay + 11, i + aD + 11, fl.aM, 0, 3); 
      } 
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    if (!cn.aO)
      return; 
    ft.a(parambx);
    if (this.a != -1) {
      ez ez;
      if ((ez = cn.a(this.a, (byte)0)) != null) {
        int i;
        if ((i = (paramInt1 = ft.W / 2 - 20) / R / 2) < 0)
          i = 1; 
        if (i == 1) {
          parambx.a(cg.ay, 0, 0, R, 9, 0, 0, paramInt2 + 3, 0);
        } else {
          parambx.a(cg.ay, 0, 0, R - 2, 9, 0, 0, paramInt2 + 3, 0);
          parambx.a(cg.ay, 2, 0, R - 2, 9, 0, paramInt1 + 0 - R - 2 + 2, paramInt2 + 3, 0);
          int j;
          if ((j = (paramInt1 - (R - 2 << 1)) / 5) <= 0)
            j = 1; 
          for (byte b = 0; b < j + 1; b++)
            parambx.a(cg.ay, 10, 0, 15, 9, 0, 0 + R - 4 + b * 5, paramInt2 + 3, 0); 
        } 
        if (this.br > 0) {
          long l1 = this.bs;
          long l2 = this.br;
          long l3 = paramInt1;
          long l4;
          int k = (int)((l4 = l2 * l3) / l1);
          int j = paramInt1 + 1;
          parambx.d(0, paramInt2 + 4, j - paramInt1 - k, 7);
          if ((j = paramInt1 / S / 2) < 0)
            j = 1; 
          if (j == 1) {
            parambx.a(cg.ah, 0, 0, S, 7, 0, 1, paramInt2 + 4, 0);
          } else {
            parambx.a(cg.ah, 0, 0, S - 2, 7, 0, 1, paramInt2 + 4, 0);
            parambx.a(cg.ah, 2, 0, S - 2, 7, 0, paramInt1 + 1 - S - 2, paramInt2 + 4, 0);
            int m;
            if ((m = (paramInt1 - (S - 2 << 1)) / 5) <= 0)
              m = 1; 
            for (j = 0; j < m + 1; j++)
              parambx.a(cg.ah, 10, 0, 15, 7, 0, 0 + S - 2 + j * 5, paramInt2 + 4, 0); 
          } 
        } 
        getClass();
        ft.a(parambx);
        cg.a(parambx, String.valueOf(this.cB.toUpperCase()) + " Lv: " + this.by, 2, paramInt2 + 24 - 10, 0, (byte)0);
        if (!this.ds) {
          o.j.a(parambx, String.valueOf(this.br) + "/" + this.bs, paramInt1 / 2, paramInt2 + 2, 2, true);
        } else {
          o o = o.j;
          if (ez.dt > 5)
            o = o.m; 
          o.a(parambx, String.valueOf(this.br) + "/" + this.bs, paramInt1 / 2, paramInt2 + 2, 2, true);
        } 
        if (Q - dw.a() / 1000L > 0L) {
          long l = Q - dw.a() / 1000L;
          parambx.a(cg.aj, 0, 0, 140, 20, 0, ft.W / 2, paramInt2 + 35, 3);
          o.j.a(parambx, String.valueOf(df.G) + l, ft.W / 2, paramInt2 + 30, 2, false);
          return;
        } 
      } 
    } else {
      int i;
      if ((paramInt1 = (i = ft.W / 2 - 20) / R / 2) < 0)
        paramInt1 = 1; 
      if (paramInt1 == 1) {
        parambx.a(cg.ay, 0, 0, R, 9, 0, 0, paramInt2 + 3, 0);
        parambx.a(cg.ay, 0, 9, R, 9, 0, 0, paramInt2 + 15, 0);
      } else {
        parambx.a(cg.ay, 0, 0, R - 2, 9, 0, 0, paramInt2 + 3, 0);
        parambx.a(cg.ay, 0, 9, R - 2, 9, 0, 0, paramInt2 + 15, 0);
        parambx.a(cg.ay, 2, 0, R - 2, 9, 0, i + 0 - R - 2 + 2, paramInt2 + 3, 0);
        parambx.a(cg.ay, 2, 9, R - 2, 9, 0, i + 0 - R - 2 + 2, paramInt2 + 15, 0);
        int j;
        if ((j = (i - (R - 2 << 1)) / 5) <= 0)
          j = 1; 
        for (byte b = 0; b < j + 1; b++) {
          parambx.a(cg.ay, 10, 0, 15, 9, 0, 0 + R - 4 + b * 5, paramInt2 + 3, 0);
          parambx.a(cg.ay, 10, 9, 15, 9, 0, 0 + R - 4 + b * 5, paramInt2 + 15, 0);
        } 
      } 
      if (cn.f.br > 0) {
        long l1 = cn.f.bs;
        long l2 = cn.f.br;
        long l3 = i;
        long l4;
        int k = (int)((l4 = l2 * l3) / l1);
        int m = i + 1;
        parambx.d(0, paramInt2 + 4, m - i - k, 7);
        int j;
        if ((j = i / S / 2) < 0)
          j = 1; 
        if (j == 1) {
          parambx.a(cg.ah, 0, 0, S, 7, 0, 1, paramInt2 + 4, 0);
        } else {
          parambx.a(cg.ah, 0, 0, S - 2, 7, 0, 1, paramInt2 + 4, 0);
          parambx.a(cg.ah, 2, 0, S - 2, 7, 0, i + 1 - S - 2, paramInt2 + 4, 0);
          if ((j = (i - (S - 2 << 1)) / 5) <= 0)
            j = 1; 
          for (byte b = 0; b < j + 1; b++)
            parambx.a(cg.ah, 10, 0, 15, 7, 0, 0 + S - 2 + b * 5, paramInt2 + 4, 0); 
        } 
      } 
      if (cn.f.bt > 0) {
        long l1 = cn.f.bu;
        long l2 = cn.f.bt;
        long l3 = i;
        long l4 = l2 * l3;
        int m = i + 2;
        int k = (int)(l4 / l1);
        parambx.d(0, paramInt2 + 16, m - i - k, 7);
        int j;
        if ((j = i / S / 2) < 0)
          j = 1; 
        if (j == 1) {
          parambx.a(cg.ah, 0, 7, S, 7, 0, 1, paramInt2 + 16, 0);
        } else {
          parambx.a(cg.ah, 0, 7, S - 2, 7, 0, 1, paramInt2 + 16, 0);
          parambx.a(cg.ah, 2, 7, S - 2, 7, 0, i + 1 - S - 2, paramInt2 + 16, 0);
          if ((j = (i - (S - 2 << 1)) / 5) <= 0)
            j = 1; 
          for (byte b = 0; b < j + 1; b++)
            parambx.a(cg.ah, 10, 7, 15, 7, 0, 0 + S - 2 + b * 5, paramInt2 + 16, 0); 
        } 
      } 
      ft.a(parambx);
      cg.a(parambx, String.valueOf(cn.f.cB.toUpperCase()) + " Lv: " + cn.f.by, 2, paramInt2 + 24, 0, (byte)0);
      if (!cn.f.ds) {
        o.j.a(parambx, String.valueOf(cn.f.br) + "/" + cn.f.bs, i / 2, paramInt2 + 2, 2, true);
      } else {
        o o = o.j;
        if (ez.dt > 5)
          o = o.m; 
        o.a(parambx, String.valueOf(cn.f.br) + "/" + cn.f.bs, i / 2, paramInt2 + 2, 2, true);
      } 
      if (!cn.f.dr) {
        o.j.a(parambx, String.valueOf(cn.f.bt) + "/" + cn.f.bu, i / 2, paramInt2 + 14, 2, false);
      } else {
        o o = o.j;
        if (ez.dt > 5)
          o = o.n; 
        o.a(parambx, String.valueOf(cn.f.bt) + "/" + cn.f.bu, i / 2, paramInt2 + 14, 2, true);
      } 
      if (Q - dw.a() / 1000L > 0L) {
        long l = Q - dw.a() / 1000L;
        parambx.a(cg.aj, 0, 0, 140, 20, 0, ft.W / 2, paramInt2 + 35, 3);
        o.j.a(parambx, String.valueOf(df.G) + l, ft.W / 2, paramInt2 + 30, 2, false);
      } 
    } 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2) {
    if (!cn.aO)
      return; 
    if (this.b != -1) {
      ez ez;
      if ((ez = cn.a(this.b, (byte)0)) != null) {
        ft.a(parambx);
        int i;
        int j;
        if ((j = (i = ft.W / 2 - 20) / R / 2) < 0)
          j = 1; 
        if (j == 1) {
          parambx.a(cg.ay, 0, 0, R, 9, 0, paramInt1, paramInt2 + 3, 0);
        } else {
          parambx.a(cg.ay, 0, 0, R - 2, 9, 0, paramInt1, paramInt2 + 3, 0);
          parambx.a(cg.ay, 2, 0, R - 2, 9, 0, ft.W - R, paramInt2 + 3, 0);
          int k;
          if ((k = (i - (R - 2 << 1)) / 5) <= 0)
            k = 1; 
          for (byte b = 0; b < k + 1; b++)
            parambx.a(cg.ay, 10, 0, 15, 9, 0, paramInt1 + R - 4 + b * 5, paramInt2 + 3, 0); 
        } 
        if (this.br > 0) {
          long l1 = this.bs;
          long l2 = this.br;
          long l3 = i;
          long l4;
          int k = (int)((l4 = l2 * l3) / l1);
          parambx.d(paramInt1 + i - k, paramInt2 + 4, ft.W / 2 - i - k, 7);
          if ((j = i / S / 2) < 0)
            j = 1; 
          if (j == 1) {
            parambx.a(cg.ah, 0, 0, S, 7, 0, paramInt1 + 1, paramInt2 + 4, 0);
          } else {
            parambx.a(cg.ah, 0, 0, S - 2, 7, 0, paramInt1 + 1, paramInt2 + 4, 0);
            parambx.a(cg.ah, 2, 0, S - 2, 7, 0, ft.W - R, paramInt2 + 4, 0);
            int m;
            if ((m = (i - (S - 2 << 1)) / 5) <= 0)
              m = 1; 
            for (j = 0; j < m + 1; j++)
              parambx.a(cg.ah, 10, 0, 15, 7, 0, paramInt1 + S - 2 + j * 5, paramInt2 + 4, 0); 
          } 
        } 
        if (this.bt > 0)
          getClass(); 
        ft.a(parambx);
        cg.a(parambx, String.valueOf(this.cB.toUpperCase()) + " Lv: " + this.by, paramInt1 + i - 2, paramInt2 + 24 - 10, 1, (byte)0);
        if (!this.ds) {
          o.j.a(parambx, String.valueOf(this.br) + "/" + this.bs, paramInt1 + i / 2, paramInt2 + 2, 2, true);
          return;
        } 
        o o = o.j;
        if (ez.dt > 5)
          o = o.m; 
        o.a(parambx, String.valueOf(this.br) + "/" + this.bs, paramInt1 + i / 2, paramInt2 + 2, 2, true);
        return;
      } 
    } else {
      if (cn.h == null || (cn.h != null && cn.h.cu != 0))
        return; 
      ft.a(parambx);
      int i;
      int j;
      if ((j = (i = ft.W / 2 - 20) / R / 2) < 0)
        j = 1; 
      if (j == 1) {
        parambx.a(cg.ay, 0, 0, R, 9, 0, paramInt1, paramInt2 + 3, 0);
        parambx.a(cg.ay, 0, 9, R, 9, 0, paramInt1, paramInt2 + 15, 0);
      } else {
        parambx.a(cg.ay, 0, 0, R - 2, 9, 0, paramInt1, paramInt2 + 3, 0);
        parambx.a(cg.ay, 0, 9, R - 2, 9, 0, paramInt1, paramInt2 + 15, 0);
        parambx.a(cg.ay, 2, 0, R - 2, 9, 0, ft.W - R, paramInt2 + 3, 0);
        parambx.a(cg.ay, 2, 9, R - 2, 9, 0, ft.W - R, paramInt2 + 15, 0);
        int k;
        if ((k = (i - (R - 2 << 1)) / 5) <= 0)
          k = 1; 
        for (byte b = 0; b < k + 1; b++) {
          parambx.a(cg.ay, 10, 0, 15, 9, 0, paramInt1 + R - 4 + b * 5, paramInt2 + 3, 0);
          parambx.a(cg.ay, 10, 9, 15, 9, 0, paramInt1 + R - 4 + b * 5, paramInt2 + 15, 0);
        } 
      } 
      if (cn.h.br > 0) {
        long l1 = cn.h.bs;
        long l2 = cn.h.br;
        long l3 = i;
        long l4;
        int k = (int)((l4 = l2 * l3) / l1);
        parambx.d(paramInt1 + i - k, paramInt2 + 4, ft.W / 2 - i - k, 7);
        int m;
        if ((m = i / S / 2) < 0)
          m = 1; 
        if (m == 1) {
          parambx.a(cg.ah, 0, 0, S, 7, 0, paramInt1 + 1, paramInt2 + 4, 0);
        } else {
          parambx.a(cg.ah, 0, 0, S - 2, 7, 0, paramInt1 + 1, paramInt2 + 4, 0);
          parambx.a(cg.ah, 2, 0, S - 2, 7, 0, ft.W - R, paramInt2 + 4, 0);
          if ((k = (i - (S - 2 << 1)) / 5) <= 0)
            k = 1; 
          for (byte b = 0; b < k + 1; b++)
            parambx.a(cg.ah, 10, 0, 15, 7, 0, paramInt1 + S - 2 + b * 5, paramInt2 + 4, 0); 
        } 
      } 
      if (cn.h.bt > 0 && cn.h.bu > 0) {
        long l1 = cn.h.bu;
        long l2 = cn.h.bt;
        long l3 = i;
        long l4;
        int k = (int)((l4 = l2 * l3) / l1);
        parambx.d(paramInt1 + i - k, paramInt2 + 16, ft.W / 2 - i - k, 7);
        int m;
        if ((m = i / S / 2) < 0)
          m = 1; 
        if (m == 1) {
          parambx.a(cg.ah, 0, 7, S, 7, 0, paramInt1 + 1, paramInt2 + 16, 0);
        } else {
          parambx.a(cg.ah, 0, 7, S - 2, 7, 0, paramInt1 + 1, paramInt2 + 16, 0);
          parambx.a(cg.ah, 2, 7, S - 2, 7, 0, ft.W - R, paramInt2 + 16, 0);
          if ((k = (i - (S - 2 << 1)) / 5) <= 0)
            k = 1; 
          for (byte b = 0; b < k + 1; b++)
            parambx.a(cg.ah, 10, 7, 15, 7, 0, paramInt1 + S - 2 + b * 5, paramInt2 + 16, 0); 
        } 
      } 
      ft.a(parambx);
      cg.a(parambx, String.valueOf(cn.h.cB.toUpperCase()) + " Lv: " + cn.h.by, paramInt1 + i - 2, paramInt2 + 24, 1, (byte)0);
      if (!cn.h.ds) {
        o.j.a(parambx, String.valueOf(cn.h.br) + "/" + cn.h.bs, paramInt1 + i / 2, paramInt2 + 2, 2, true);
      } else {
        o o1 = o.j;
        if (ez.dt > 5)
          o1 = o.m; 
        o1.a(parambx, String.valueOf(cn.h.br) + "/" + cn.h.bs, paramInt1 + i / 2, paramInt2 + 2, 2, true);
      } 
      if (!cn.h.dr) {
        o.j.a(parambx, String.valueOf(cn.h.bt) + "/" + cn.h.bu, paramInt1 + i / 2, paramInt2 + 14, 2, false);
        return;
      } 
      o o = o.j;
      if (ez.dt > 5)
        o = o.n; 
      o.a(parambx, String.valueOf(cn.h.bt) + "/" + cn.h.bu, paramInt1 + i / 2, paramInt2 + 14, 2, true);
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, boolean paramBoolean, o paramo) {
    if (cn.aO)
      return; 
    if (paramBoolean) {
      parambx.a(cg.af, 0, 0, 16, 42, 0, 1, paramInt2 + 2, 0);
      parambx.a(cg.af, 0, 84, 16, 42, 0, 96, paramInt2 + 2, 24);
      for (byte b = 0; b < 4; b++)
        parambx.a(cg.af, 0, 42, 16, 42, 0, 17 + b * 16, paramInt2 + 2, 0); 
      paramInt1 += 8;
      paramInt2 += 4;
    } 
    parambx.a(cg.ag, paramInt1 + 2, paramInt2 + 3, 0);
    parambx.a(cg.ay, 0, 0, 62, 9, 0, paramInt1 + 19, paramInt2 + 3, 0);
    parambx.a(cg.ay, 0, 9, 62, 9, 0, paramInt1 + 19, paramInt2 + 15, 0);
    int i = 0;
    i = 0;
    if (cn.f.br > 0) {
      if ((i = cn.f.br * 60 / cn.f.bs) <= 0) {
        i = 1;
      } else if (i > 60) {
        i = 60;
      } 
      parambx.a(cg.ah, 0, 0, i, 7, 0, paramInt1 + 20, paramInt2 + 4, 0);
    } 
    if (cn.f.bt > 0) {
      if ((i = cn.f.bt * 60 / cn.f.bu) <= 0) {
        i = 1;
      } else if (i > 60) {
        i = 60;
      } 
      parambx.a(cg.ah, 0, 7, i, 7, 0, paramInt1 + 20, paramInt2 + 16, 0);
    } 
    paramo.a(parambx, "Lv." + cn.f.by + " + " + (cn.f.bz / 10) + "," + (cn.f.bz % 10) + "%", paramInt1 + 3, paramInt2 + 24, 0, false);
    i = 0;
    if (cn.f.bz > 0) {
      i = cn.f.bz / 10 * 77 / 100;
      parambx.a(-13263058);
      parambx.c(paramInt1 + 3, paramInt2 + 35, i, 2);
    } 
    if (!cn.f.ds) {
      o.j.a(parambx, String.valueOf(cn.f.br) + "/" + cn.f.bs, paramInt1 + 50, paramInt2 + 2, 2, false);
    } else {
      o o2 = o.j;
      if (ez.dt > 5)
        o2 = o.m; 
      a(parambx, String.valueOf(cn.f.br) + "/" + cn.f.bs, paramInt1 + 50, paramInt2 + 2, 2, false);
    } 
    if (!cn.f.dr) {
      o.j.a(parambx, String.valueOf(cn.f.bt) + "/" + cn.f.bu, paramInt1 + 50, paramInt2 + 14, 2, false);
      return;
    } 
    o o1 = o.j;
    if (ez.dt > 5)
      o1 = o.n; 
    a(parambx, String.valueOf(cn.f.bt) + "/" + cn.f.bu, paramInt1 + 50, paramInt2 + 14, 2, false);
  }
  
  public final void b(bx parambx) {
    ft.a(parambx);
    int i = ah;
    byte b = 0;
    if (ft.A)
      b = 25; 
    if (this.F != null) {
      parambx.d(ft.Y - ai / 2, i, ai - b, 20);
      for (byte b1 = 0; b1 < ai / 140 + 1; b1++) {
        if (b1 == ai / 140) {
          parambx.a(cg.aj, 0, 0, ai % 140, 20, 0, ft.Y - ai / 2 + b1 * 140, i, 0);
        } else {
          parambx.a(cg.aj, ft.Y - ai / 2 + b1 * 140, i, 0);
        } 
      } 
      o.k.a(parambx, this.F, ft.Y + ai / 2 - this.Z, i + 4, 0, true);
      i += this.ag;
    } 
    if (this.H != null) {
      parambx.d(ft.Y - ai / 2, i, ai - b, 20);
      for (byte b1 = 0; b1 < ai / 140 + 1; b1++) {
        if (b1 == ai / 140) {
          parambx.a(cg.aj, 0, 0, ai % 140, 20, 0, ft.Y - ai / 2 + b1 * 140, i, 0);
        } else {
          parambx.a(cg.aj, ft.Y - ai / 2 + b1 * 140, i, 0);
        } 
      } 
      o.f.a(parambx, this.H, ft.Y + ai / 2 - this.aa, i + 4, 0, true);
      i += this.ag;
    } 
    if (this.G != null) {
      parambx.d(ft.Y - 70, i, 140, 20);
      parambx.a(cg.aj, ft.Y - 70, i + this.d, 0);
      o.j.a(parambx, this.G, ft.Y, i + 4 + this.d, 2, true);
    } 
    ft.a(parambx);
  }
  
  public final void c(bx parambx) {
    byte b1 = 102;
    byte b2 = 8;
    if (ft.C) {
      b1 = 90;
      b2 = 7;
    } 
    if (bq.t > 0 && !cn.aO)
      u.b(ft.ai / 4 % 2, b1, b2, 0, 3, parambx); 
    if (bq.u > 0 && !cn.aO)
      u.b(2 + ft.ai / 4 % 2, b1, b2 + 14, 0, 3, parambx); 
    if (bq.o > -1)
      parambx.a(l, b1 + 1, b2 + 28, 3); 
    if (bq.A == 1) {
      if (ft.ai % 200 < 100) {
        parambx.a(m, b1 + 1, b2 + 42, 3);
        return;
      } 
      if (bq.g > 0 && (ft.aj - bq.j) / 1000L > 60L) {
        bq.j += 60000L;
        bq.g--;
      } 
      o.o.a(parambx, a(bq.g), b1 - 7, b2 + 36, 0, false);
    } 
  }
  
  public static String a(int paramInt) {
    return (paramInt >= 60) ? (String.valueOf(paramInt / 60) + "h" + (paramInt % 60) + "'") : (String.valueOf(paramInt) + "'");
  }
  
  public final void b() {
    if (cn.j.c() > 0)
      if (this.F == null) {
        this.F = (String)cn.j.a(0);
        if (this.F != null && this.F.trim().length() > 0)
          ft.g.a(df.cz, df.fr, this.F, (byte)1, false); 
        int i;
        if ((i = cn.j.c()) < 2) {
          this.ad = 2;
        } else if (i < 5) {
          this.ad = 3;
        } else {
          this.ad = 4;
        } 
        this.Z = 0;
        this.ab = o.j.a(this.F) + ai;
        if (this.ab < ai) {
          this.ab = ai;
          return;
        } 
      } else {
        if (this.Z >= this.ab) {
          this.af++;
          this.af = 0;
          this.F = null;
          cn.j.b(0);
        } 
        this.Z += this.ad;
      }  
  }
  
  public final void c() {
    if (cn.k.c() > 0)
      if (this.H == null) {
        this.H = (String)cn.k.a(0);
        int i;
        if ((i = cn.k.c()) < 2) {
          this.ae = 2;
        } else if (i < 5) {
          this.ae = 3;
        } else {
          this.ae = 4;
        } 
        this.aa = 0;
        this.ac = o.f.a(this.H) + ai;
        if (this.ac < ai) {
          this.ac = ai;
          return;
        } 
      } else {
        if (this.aa >= this.ac) {
          this.H = null;
          cn.k.b(0);
        } 
        this.aa += this.ae;
      }  
  }
  
  public final void d(bx parambx) {
    if (cn.aO)
      return; 
    if (!K && I)
      return; 
    if (cn.h != null) {
      int i = 0;
      int j = 2;
      i = N;
      if (j()) {
        i = ft.W - 62;
        j = 2 + ft.ab;
      } 
      ez ez;
      if ((ez = cn.h).cu == 3) {
        cg.a(parambx, ez.cB, i + 48, j + 2, 1, ez.cs);
      } else if (ez.cu == 0 || ez.cu == 1) {
        if (ez.cO != null && ez.cy == 0) {
          int k = o.f.a(ez.cB) + 1;
          ez.a(parambx, i + 48 - k / 2, j + 7, 2);
          j += 12;
        } 
        if (ez.cu == 1) {
          byte b = ez.cs;
          cg.a(parambx, ez.cB, i + 48, j + 2, 1, (byte)7, b);
        } else {
          cg.a(parambx, ez.cB, i + 48, j + 2, 1);
        } 
        j += 10;
        cg.a(parambx, String.valueOf(df.ah) + ez.by, i + 48, j + 2, 1, (byte)7, ez.cs);
      } else {
        cg.a(parambx, ez.cB, i + 48, j + 2, 1);
      } 
      if (ez.cu == 0 || ez.cu == 1 || ez.cu == 2) {
        parambx.a(cg.az, i - 4, j + 14, 0);
        int k = 0;
        if (ez.bs > 0 && ez.br > 0) {
          long l1 = 50L;
          long l2 = ez.br;
          long l3;
          if ((k = (int)((l3 = l1 * l2) / ez.bs)) <= 0) {
            k = 1;
          } else if (k > 50) {
            k = 50;
          } 
          parambx.a(cg.aA, 0, 0, k + 1, 7, 0, i - 4, j + 14, 0);
        } 
        o.j.a(parambx, String.valueOf(ez.br) + "/" + ez.bs, i + 48, j + 20, 1, false);
      } 
    } 
  }
  
  public final void d() {
    if (this.G != null) {
      this.c++;
      if (this.c >= 120) {
        this.c = 0;
        this.G = null;
      } 
      if (this.d > 0)
        this.d -= 2; 
    } 
    C = 0;
    if (!ft.A && C > 0 && ++C > 8 && ++bq.d > 2)
      bq.d = 0; 
    if (at > 0) {
      if (at == 20) {
        av = 10;
      } else if (at < 20 && av > -20) {
        av -= 4;
      } 
      if (aw > -30) {
        aw += av;
        return;
      } 
      at = 0;
    } 
  }
  
  public final void e() {
    if (ff.g.c() > 0) {
      if (this.aJ == null) {
        this.aJ = (fm)ff.g.a(0);
        this.aG = 100;
        this.aH = 0;
      } else {
        this.aG--;
        if (this.aG <= 0) {
          this.aJ = null;
          ff.g.b(0);
        } 
        if (this.aH < 35)
          this.aH += 10; 
        if (this.aH > 35)
          this.aH = 35; 
      } 
      if (ft.b(ft.Y - aI / 2, 0, aI, 35)) {
        fm fm1;
        if ((fm1 = ff.a(this.aJ.e, (byte)this.aJ.b)) != null)
          ff.a(false, fm1); 
        if (this.aG > 40)
          this.aG = 40; 
        ft.S = false;
      } 
      if (ft.al[11]) {
        ft.d(11);
        int i;
        if ((i = ff.b(this.aJ.e, (byte)this.aJ.b)) >= 0)
          ft.h.b = i; 
        ft.h.g();
        ft.h.a(ft.a);
        return;
      } 
    } else if (this.aH > 0) {
      this.aH -= 20;
    } 
  }
  
  public final void e(bx parambx) {
    if (this.aJ != null || this.aH > 0) {
      ft.a(parambx);
      int i = ft.Y - aI / 2;
      byte b = 2;
      if (ft.ai % 16 > 7)
        b = 12; 
      cg.b(parambx, i, -5, aI, this.aH + 5, b);
      if (this.aJ != null) {
        x.b(this.aJ.b << 1, i + 20, -35 + this.aH + 17 + 3, 0, 3, parambx);
        o.f.a(parambx, this.aJ.e, i + 35, -35 + this.aH + 5, 0, false);
        o.j.a(parambx, this.aJ.f, i + 42, -35 + this.aH + 18, 0, false);
      } 
    } 
  }
  
  public final void f(bx parambx) {
    if (!ft.A)
      return; 
    byte b;
    for (b = 0; b < B.length; b++) {
      if (b != 3 || !I) {
        byte b1 = 0;
        if (ar > 0 && as == b + 100)
          b1 = 1; 
        if (cn.f.cF != 4) {
          int i = B[b][0];
          int j = B[b][1];
          if (b == 0) {
            j = j;
          } else if (b == 1) {
            i = i;
          } else if (b == 4) {
            j = j;
          } else {
            i = i;
          } 
          boolean bool = true;
          if (b == 0 && cn.f.by > 10)
            bool = false; 
          if (bool)
            if (b != 1) {
              parambx.a(k[b], 0, b1 * aq[b][1], aq[b][0], aq[b][1], 0, i, j, 0);
            } else {
              parambx.a(k[b], 0, 0, aq[b][0], aq[b][1], 0, i, j, 0);
              if (this.aK != -1L && dw.a() - this.aK >= 100L) {
                if (ft.ai % 2 == 0)
                  this.aL++; 
                if (this.aL >= aq[b][1])
                  this.aL = aq[b][1]; 
              } 
              parambx.d(i, j, aq[b][0], this.aL);
              parambx.a(k[b], 0, aq[b][1], aq[b][0], aq[b][1], 0, i, j, 0);
              ft.a(parambx);
            }  
        } 
      } 
    } 
    if (cn.f.cF == 4)
      return; 
    if (I) {
      a(parambx);
      return;
    } 
    parambx.a(aj[0], e, f, 3);
    for (b = 0; b < 4; b++) {
      if (ar > 0 && this.am[b] == as)
        parambx.a(aj[2], 0, 0, 32, 56, this.al[b] + ((b > 1) ? 4 : 0), ap[b][0], ap[b][1], 3); 
    } 
    b = 0;
    if (ar > 0 && as == 5)
      b = 1; 
    parambx.a(cg.ap, D, E, 3);
    if (C == 0) {
      if (cn.h != null && cn.h.cx == 2) {
        for (byte b2 = 0; b2 < 5; b2++) {
          boolean bool = false;
          if (ar > 0 && as == z[b2])
            bool = true; 
          int i = 0;
          int j = 0;
          if (b2 == 2) {
            i = D;
            j = E;
          } else {
            i = ao[b2 - ((b2 > 2) ? 1 : 0)][0];
            j = ao[b2 - ((b2 > 2) ? 1 : 0)][1];
          } 
          parambx.a(ak[1], 0, bool, 50, 50, 0, i, j, 3);
          parambx.a(cg.ap, i, j, 3);
          cg.a(parambx, (new StringBuffer(String.valueOf(z[b2]))).toString(), i, j - 5, 2);
        } 
        return;
      } 
      ao ao = bq.w[bq.d][2];
      if (cn.f.y()) {
        parambx.a(cg.at, D, E, 3);
      } else if (ao != null && ao.b == 0) {
        ev ev;
        if ((ev = ct.c(ao.a)) != null)
          ev.a(parambx, D, E, 3); 
      } else {
        bw bw;
        if (ao != null && ao.b == ao.f && (bw = bw.a(4, ao.a)) != null)
          bw.a(parambx, D, E, fl.aM, 0, 3); 
      } 
      byte b1;
      for (b1 = 0; b1 < ao.length; b1++) {
        byte b2 = 0;
        if (ar > 0 && as == an[b1])
          b2 = 1; 
        parambx.a(ak[1], 0, b2 * 50, 50, 50, 0, ao[b1][0], ao[b1][1], 3);
        parambx.a(cg.ap, ao[b1][0], ao[b1][1], 3);
        if ((ao = bq.w[bq.d][b1 + ((b1 > 1) ? 1 : 0)]) != null && ao.b == 0) {
          ev ev;
          if ((ev = ct.c(ao.a)) != null)
            ev.a(parambx, ao[b1][0], ao[b1][1], 3); 
        } else if (ao != null && ao.b == ao.f && fo.d) {
          bw bw;
          if ((bw = bw.a(4, ao.a)) != null) {
            if (fo.d)
              bw.a(parambx, ao[b1][0], ao[b1][1], fl.aM, 0, 3); 
          } else {
            ao.a(0, ao.d, (byte)0);
            j.a((byte)1, false);
            j.a((byte)0, false);
          } 
        } 
      } 
      for (b1 = 0; b1 < 5; b1++) {
        ao ao1;
        if ((ao1 = bq.w[bq.d][b1]) != null && ao1.b != ao.d) {
          ad ad;
          int j = 0;
          int i = 0;
          if (b1 == 2) {
            j = D;
            i = E;
          } else {
            j = ao[b1 - ((b1 > 2) ? 1 : 0)][0];
            i = ao[b1 - ((b1 > 2) ? 1 : 0)][1];
          } 
          ao = null;
          if (ao1 != null && ao1.b == 0) {
            ad = bq.r[ao1.a];
          } else {
            bw bw;
            if (ao1 != null && ao1.b == ao.f && fo.d && (bw = bw.a(4, ao1.a)) != null && bw.L < 2)
              ad = bq.s[bw.L]; 
          } 
          if (ad != null && ad.c > 0)
            if (ad.b > 0) {
              int m;
              int k;
              if ((k = ad.b * 20 / ad.c) < 1)
                k = 1; 
              parambx.a(cg.am, 0, 0, 20, k, 0, j - 10, i - 10, 0);
              k = ad.b / 1000;
              String str = null;
              if (k == 0) {
                str = "0." + (ad.b % 1000 / 100);
              } else {
                m = k;
              } 
              o.f.a(parambx, m, j, i - 5, 2, false);
            } else if (ad.b > -150) {
              parambx.a(-1118516);
              parambx.a(j - 10, i - 10, 20, 20, 4, 4);
            }  
        } 
      } 
    } else {
      m(parambx);
    } 
    parambx.a(ak[0], 0, b * 50, 50, 50, 0, D, E, 3);
  }
  
  public final void f() {
    // Byte code:
    //   0: getstatic cf.ar : I
    //   3: ifle -> 14
    //   6: getstatic cf.ar : I
    //   9: iconst_1
    //   10: isub
    //   11: putstatic cf.ar : I
    //   14: getstatic cf.C : I
    //   17: ifle -> 55
    //   20: getstatic cf.C : I
    //   23: iconst_1
    //   24: iadd
    //   25: dup
    //   26: putstatic cf.C : I
    //   29: bipush #6
    //   31: if_icmple -> 55
    //   34: iconst_0
    //   35: putstatic cf.C : I
    //   38: getstatic bq.d : I
    //   41: iconst_1
    //   42: iadd
    //   43: dup
    //   44: putstatic bq.d : I
    //   47: iconst_2
    //   48: if_icmple -> 55
    //   51: iconst_0
    //   52: putstatic bq.d : I
    //   55: getstatic cs.i : B
    //   58: getstatic cs.j : B
    //   61: if_icmpne -> 65
    //   64: return
    //   65: iconst_1
    //   66: istore_1
    //   67: getstatic ft.S : Z
    //   70: ifeq -> 901
    //   73: getstatic cf.I : Z
    //   76: ifeq -> 243
    //   79: getstatic cf.aC : I
    //   82: bipush #11
    //   84: iadd
    //   85: getstatic cf.ay : I
    //   88: iconst_2
    //   89: idiv
    //   90: isub
    //   91: getstatic cf.aD : I
    //   94: bipush #11
    //   96: iadd
    //   97: getstatic cf.ay : I
    //   100: iconst_2
    //   101: idiv
    //   102: isub
    //   103: iconst_5
    //   104: getstatic cf.ay : I
    //   107: imul
    //   108: getstatic cf.ay : I
    //   111: invokestatic c : (IIII)Z
    //   114: ifeq -> 389
    //   117: getstatic ft.ae : I
    //   120: getstatic cf.aC : I
    //   123: isub
    //   124: bipush #11
    //   126: iadd
    //   127: getstatic cf.ay : I
    //   130: idiv
    //   131: istore_2
    //   132: iconst_0
    //   133: putstatic ft.S : Z
    //   136: iload_2
    //   137: iflt -> 389
    //   140: iload_2
    //   141: getstatic bq.w : [[Lao;
    //   144: getstatic bq.d : I
    //   147: aaload
    //   148: arraylength
    //   149: if_icmpge -> 389
    //   152: getstatic bq.w : [[Lao;
    //   155: getstatic bq.d : I
    //   158: aaload
    //   159: iload_2
    //   160: aaload
    //   161: astore_3
    //   162: getstatic cf.I : Z
    //   165: ifeq -> 234
    //   168: aload_3
    //   169: getfield b : B
    //   172: ifne -> 192
    //   175: getstatic cn.h : Lez;
    //   178: ifnull -> 234
    //   181: getstatic cn.f : Lbq;
    //   184: iload_2
    //   185: iconst_0
    //   186: invokevirtual a : (IZ)V
    //   189: goto -> 234
    //   192: iload_2
    //   193: iconst_2
    //   194: if_icmpne -> 204
    //   197: iconst_5
    //   198: putstatic cf.as : I
    //   201: goto -> 223
    //   204: getstatic cf.an : [I
    //   207: iload_2
    //   208: iconst_1
    //   209: if_icmple -> 218
    //   212: iload_2
    //   213: iconst_1
    //   214: isub
    //   215: goto -> 219
    //   218: iload_2
    //   219: iaload
    //   220: putstatic cf.as : I
    //   223: getstatic ft.ak : [Z
    //   226: bipush #20
    //   228: getstatic cf.as : I
    //   231: iadd
    //   232: iconst_1
    //   233: bastore
    //   234: iconst_3
    //   235: putstatic cf.ar : I
    //   238: iconst_0
    //   239: istore_1
    //   240: goto -> 389
    //   243: getstatic cf.D : I
    //   246: getstatic cf.az : I
    //   249: iconst_2
    //   250: idiv
    //   251: isub
    //   252: getstatic cf.E : I
    //   255: getstatic cf.az : I
    //   258: iconst_2
    //   259: idiv
    //   260: isub
    //   261: getstatic cf.az : I
    //   264: getstatic cf.az : I
    //   267: invokestatic c : (IIII)Z
    //   270: ifeq -> 303
    //   273: iconst_0
    //   274: putstatic ft.S : Z
    //   277: iconst_5
    //   278: putstatic cf.as : I
    //   281: iconst_3
    //   282: putstatic cf.ar : I
    //   285: getstatic ft.ak : [Z
    //   288: bipush #25
    //   290: iconst_1
    //   291: bastore
    //   292: getstatic ft.ak : [Z
    //   295: iconst_5
    //   296: iconst_1
    //   297: bastore
    //   298: iconst_0
    //   299: istore_1
    //   300: goto -> 389
    //   303: iconst_0
    //   304: istore_2
    //   305: goto -> 381
    //   308: getstatic cf.ao : [[I
    //   311: iload_2
    //   312: aaload
    //   313: iconst_0
    //   314: iaload
    //   315: getstatic cf.ay : I
    //   318: iconst_2
    //   319: idiv
    //   320: isub
    //   321: getstatic cf.ao : [[I
    //   324: iload_2
    //   325: aaload
    //   326: iconst_1
    //   327: iaload
    //   328: getstatic cf.ay : I
    //   331: iconst_2
    //   332: idiv
    //   333: isub
    //   334: getstatic cf.ay : I
    //   337: getstatic cf.ay : I
    //   340: invokestatic c : (IIII)Z
    //   343: ifeq -> 378
    //   346: iconst_0
    //   347: putstatic ft.S : Z
    //   350: getstatic cf.an : [I
    //   353: iload_2
    //   354: iaload
    //   355: putstatic cf.as : I
    //   358: getstatic ft.ak : [Z
    //   361: bipush #20
    //   363: getstatic cf.as : I
    //   366: iadd
    //   367: iconst_1
    //   368: bastore
    //   369: iconst_3
    //   370: putstatic cf.ar : I
    //   373: iconst_0
    //   374: istore_1
    //   375: goto -> 389
    //   378: iinc #2, 1
    //   381: iload_2
    //   382: getstatic cf.ao : [[I
    //   385: arraylength
    //   386: if_icmplt -> 308
    //   389: getstatic ft.S : Z
    //   392: ifeq -> 1290
    //   395: iconst_0
    //   396: istore_2
    //   397: goto -> 493
    //   400: iload_2
    //   401: iconst_3
    //   402: if_icmpne -> 411
    //   405: getstatic cf.I : Z
    //   408: ifne -> 490
    //   411: getstatic cf.B : [[I
    //   414: iload_2
    //   415: aaload
    //   416: iconst_0
    //   417: iaload
    //   418: iconst_2
    //   419: isub
    //   420: getstatic cf.B : [[I
    //   423: iload_2
    //   424: aaload
    //   425: iconst_1
    //   426: iaload
    //   427: iconst_2
    //   428: isub
    //   429: getstatic cf.aq : [[I
    //   432: iload_2
    //   433: aaload
    //   434: iconst_0
    //   435: iaload
    //   436: iconst_4
    //   437: iadd
    //   438: getstatic cf.aq : [[I
    //   441: iload_2
    //   442: aaload
    //   443: iconst_1
    //   444: iaload
    //   445: iconst_4
    //   446: iadd
    //   447: invokestatic c : (IIII)Z
    //   450: ifeq -> 490
    //   453: iconst_0
    //   454: putstatic ft.S : Z
    //   457: iload_2
    //   458: iconst_1
    //   459: if_icmpne -> 480
    //   462: aload_0
    //   463: getfield aK : J
    //   466: ldc2_w -1
    //   469: lcmp
    //   470: ifne -> 480
    //   473: aload_0
    //   474: invokestatic a : ()J
    //   477: putfield aK : J
    //   480: aload_0
    //   481: iload_2
    //   482: invokespecial f : (I)V
    //   485: iconst_0
    //   486: istore_1
    //   487: goto -> 501
    //   490: iinc #2, 1
    //   493: iload_2
    //   494: getstatic cf.B : [[I
    //   497: arraylength
    //   498: if_icmplt -> 400
    //   501: invokestatic g : ()Lfl;
    //   504: pop
    //   505: iconst_0
    //   506: invokestatic g : ()Lfl;
    //   509: getfield P : I
    //   512: bipush #90
    //   514: bipush #35
    //   516: invokestatic c : (IIII)Z
    //   519: ifeq -> 532
    //   522: iconst_0
    //   523: putstatic ft.S : Z
    //   526: aload_0
    //   527: iconst_0
    //   528: invokespecial f : (I)V
    //   531: return
    //   532: getstatic cf.g : I
    //   535: iconst_4
    //   536: isub
    //   537: getstatic cf.h : I
    //   540: iconst_4
    //   541: isub
    //   542: bipush #24
    //   544: bipush #20
    //   546: invokestatic c : (IIII)Z
    //   549: ifeq -> 561
    //   552: iconst_0
    //   553: putstatic ft.S : Z
    //   556: aload_0
    //   557: iconst_m1
    //   558: invokespecial f : (I)V
    //   561: getstatic ft.W : I
    //   564: bipush #50
    //   566: isub
    //   567: getstatic ft.q : Lex;
    //   570: getfield b : I
    //   573: getstatic ex.c : I
    //   576: imul
    //   577: bipush #8
    //   579: isub
    //   580: bipush #50
    //   582: bipush #30
    //   584: invokestatic c : (IIII)Z
    //   587: ifeq -> 603
    //   590: iconst_0
    //   591: putstatic ft.S : Z
    //   594: aload_0
    //   595: bipush #-2
    //   597: invokespecial f : (I)V
    //   600: goto -> 660
    //   603: getstatic ft.W : I
    //   606: getstatic ft.q : Lex;
    //   609: getfield a : I
    //   612: getstatic ex.c : I
    //   615: imul
    //   616: isub
    //   617: iconst_0
    //   618: getstatic ft.q : Lex;
    //   621: getfield a : I
    //   624: getstatic ex.c : I
    //   627: imul
    //   628: getstatic ft.q : Lex;
    //   631: getfield b : I
    //   634: getstatic ex.c : I
    //   637: imul
    //   638: invokestatic c : (IIII)Z
    //   641: ifeq -> 660
    //   644: getstatic cn.aO : Z
    //   647: ifne -> 660
    //   650: iconst_0
    //   651: putstatic ft.S : Z
    //   654: aload_0
    //   655: bipush #-4
    //   657: invokespecial f : (I)V
    //   660: bipush #95
    //   662: iconst_0
    //   663: bipush #24
    //   665: bipush #40
    //   667: invokestatic c : (IIII)Z
    //   670: ifeq -> 683
    //   673: iconst_0
    //   674: putstatic ft.S : Z
    //   677: aload_0
    //   678: bipush #-3
    //   680: invokespecial f : (I)V
    //   683: iconst_0
    //   684: istore_2
    //   685: goto -> 888
    //   688: getstatic cs.a : Les;
    //   691: iload_2
    //   692: invokevirtual a : (I)Ljava/lang/Object;
    //   695: checkcast en
    //   698: dup
    //   699: astore_3
    //   700: getfield a : I
    //   703: getstatic p.d : Law;
    //   706: getfield a : I
    //   709: isub
    //   710: istore #4
    //   712: aload_3
    //   713: getfield b : I
    //   716: getstatic p.d : Law;
    //   719: getfield b : I
    //   722: isub
    //   723: istore #5
    //   725: iload #4
    //   727: bipush #12
    //   729: isub
    //   730: iload #5
    //   732: bipush #12
    //   734: isub
    //   735: bipush #24
    //   737: bipush #24
    //   739: invokestatic c : (IIII)Z
    //   742: ifeq -> 885
    //   745: getstatic cn.f : Lbq;
    //   748: getstatic cn.f : Lbq;
    //   751: getfield aY : I
    //   754: putfield bf : I
    //   757: getstatic cn.f : Lbq;
    //   760: getstatic cn.f : Lbq;
    //   763: getfield aZ : I
    //   766: putfield bg : I
    //   769: aload_0
    //   770: getstatic ft.c : Lcn;
    //   773: aload_3
    //   774: getfield a : I
    //   777: getstatic cs.l : I
    //   780: idiv
    //   781: aload_3
    //   782: getfield b : I
    //   785: getstatic cs.l : I
    //   788: idiv
    //   789: getstatic cn.f : Lbq;
    //   792: getfield aY : I
    //   795: getstatic cs.l : I
    //   798: idiv
    //   799: getstatic cn.f : Lbq;
    //   802: getfield aZ : I
    //   805: getstatic cs.l : I
    //   808: idiv
    //   809: bipush #16
    //   811: invokevirtual a : (IIIII)[S
    //   814: putfield aM : [S
    //   817: aload_0
    //   818: getfield aM : [S
    //   821: ifnull -> 839
    //   824: aload_0
    //   825: getfield aM : [S
    //   828: arraylength
    //   829: bipush #16
    //   831: if_icmple -> 839
    //   834: aload_0
    //   835: aconst_null
    //   836: putfield aM : [S
    //   839: getstatic cn.f : Lbq;
    //   842: aload_0
    //   843: getfield aM : [S
    //   846: putfield cN : [S
    //   849: aload_3
    //   850: getfield a : I
    //   853: putstatic bq.O : I
    //   856: aload_3
    //   857: getfield b : I
    //   860: putstatic bq.P : I
    //   863: bipush #9
    //   865: putstatic bq.Q : I
    //   868: iconst_0
    //   869: putstatic ft.S : Z
    //   872: getstatic bq.o : B
    //   875: iconst_1
    //   876: if_icmpne -> 1290
    //   879: invokestatic o_ : ()V
    //   882: goto -> 1290
    //   885: iinc #2, 1
    //   888: iload_2
    //   889: getstatic cs.a : Les;
    //   892: invokevirtual c : ()I
    //   895: if_icmplt -> 688
    //   898: goto -> 1290
    //   901: getstatic cf.I : Z
    //   904: ifne -> 1175
    //   907: getstatic ft.Q : Z
    //   910: ifne -> 919
    //   913: getstatic ft.T : Z
    //   916: ifeq -> 1290
    //   919: iconst_0
    //   920: istore_2
    //   921: goto -> 1008
    //   924: getstatic cf.B : [[I
    //   927: iload_2
    //   928: aaload
    //   929: iconst_0
    //   930: iaload
    //   931: iconst_4
    //   932: isub
    //   933: getstatic cf.B : [[I
    //   936: iload_2
    //   937: aaload
    //   938: iconst_1
    //   939: iaload
    //   940: iconst_4
    //   941: isub
    //   942: getstatic cf.aq : [[I
    //   945: iload_2
    //   946: aaload
    //   947: iconst_0
    //   948: iaload
    //   949: bipush #8
    //   951: iadd
    //   952: getstatic cf.aq : [[I
    //   955: iload_2
    //   956: aaload
    //   957: iconst_1
    //   958: iaload
    //   959: bipush #8
    //   961: iadd
    //   962: invokestatic c : (IIII)Z
    //   965: ifeq -> 1005
    //   968: iload_2
    //   969: iconst_1
    //   970: if_icmpne -> 991
    //   973: aload_0
    //   974: getfield aK : J
    //   977: ldc2_w -1
    //   980: lcmp
    //   981: ifne -> 991
    //   984: aload_0
    //   985: invokestatic a : ()J
    //   988: putfield aK : J
    //   991: iload_2
    //   992: bipush #100
    //   994: iadd
    //   995: putstatic cf.as : I
    //   998: iconst_3
    //   999: putstatic cf.ar : I
    //   1002: goto -> 1016
    //   1005: iinc #2, 1
    //   1008: iload_2
    //   1009: getstatic cf.B : [[I
    //   1012: arraylength
    //   1013: if_icmplt -> 924
    //   1016: getstatic cf.e : I
    //   1019: iconst_2
    //   1020: getstatic cf.j : I
    //   1023: imul
    //   1024: isub
    //   1025: getstatic cf.f : I
    //   1028: iconst_2
    //   1029: getstatic cf.j : I
    //   1032: imul
    //   1033: isub
    //   1034: getstatic cf.j : I
    //   1037: iconst_2
    //   1038: ishl
    //   1039: getstatic cf.j : I
    //   1042: iconst_2
    //   1043: ishl
    //   1044: invokestatic d : (IIII)Z
    //   1047: ifeq -> 1290
    //   1050: getstatic ft.ae : I
    //   1053: getstatic cf.e : I
    //   1056: isub
    //   1057: getstatic ft.af : I
    //   1060: getstatic cf.f : I
    //   1063: isub
    //   1064: invokestatic a : (II)I
    //   1067: istore_2
    //   1068: iconst_0
    //   1069: istore_3
    //   1070: iload_2
    //   1071: bipush #45
    //   1073: if_icmple -> 1088
    //   1076: iload_2
    //   1077: sipush #135
    //   1080: if_icmpgt -> 1088
    //   1083: iconst_3
    //   1084: istore_3
    //   1085: goto -> 1128
    //   1088: iload_2
    //   1089: sipush #135
    //   1092: if_icmple -> 1107
    //   1095: iload_2
    //   1096: sipush #225
    //   1099: if_icmpgt -> 1107
    //   1102: iconst_0
    //   1103: istore_3
    //   1104: goto -> 1128
    //   1107: iload_2
    //   1108: sipush #225
    //   1111: if_icmple -> 1126
    //   1114: iload_2
    //   1115: sipush #315
    //   1118: if_icmpgt -> 1126
    //   1121: iconst_2
    //   1122: istore_3
    //   1123: goto -> 1128
    //   1126: iconst_1
    //   1127: istore_3
    //   1128: invokestatic m : ()V
    //   1131: iconst_1
    //   1132: putstatic ft.Q : Z
    //   1135: iconst_0
    //   1136: putstatic ft.S : Z
    //   1139: aload_0
    //   1140: getfield am : [I
    //   1143: iload_3
    //   1144: iaload
    //   1145: putstatic cf.as : I
    //   1148: getstatic ft.al : [Z
    //   1151: getstatic cf.as : I
    //   1154: iconst_1
    //   1155: bastore
    //   1156: iconst_3
    //   1157: putstatic cf.ar : I
    //   1160: iconst_0
    //   1161: istore_1
    //   1162: getstatic bq.o : B
    //   1165: iconst_1
    //   1166: if_icmpne -> 1290
    //   1169: invokestatic o_ : ()V
    //   1172: goto -> 1290
    //   1175: getstatic cf.I : Z
    //   1178: ifeq -> 1290
    //   1181: getstatic ft.Q : Z
    //   1184: ifne -> 1193
    //   1187: getstatic ft.T : Z
    //   1190: ifeq -> 1290
    //   1193: iconst_0
    //   1194: istore_2
    //   1195: goto -> 1282
    //   1198: getstatic cf.B : [[I
    //   1201: iload_2
    //   1202: aaload
    //   1203: iconst_0
    //   1204: iaload
    //   1205: iconst_4
    //   1206: isub
    //   1207: getstatic cf.B : [[I
    //   1210: iload_2
    //   1211: aaload
    //   1212: iconst_1
    //   1213: iaload
    //   1214: iconst_4
    //   1215: isub
    //   1216: getstatic cf.aq : [[I
    //   1219: iload_2
    //   1220: aaload
    //   1221: iconst_0
    //   1222: iaload
    //   1223: bipush #8
    //   1225: iadd
    //   1226: getstatic cf.aq : [[I
    //   1229: iload_2
    //   1230: aaload
    //   1231: iconst_1
    //   1232: iaload
    //   1233: bipush #8
    //   1235: iadd
    //   1236: invokestatic c : (IIII)Z
    //   1239: ifeq -> 1279
    //   1242: iload_2
    //   1243: iconst_1
    //   1244: if_icmpne -> 1265
    //   1247: aload_0
    //   1248: getfield aK : J
    //   1251: ldc2_w -1
    //   1254: lcmp
    //   1255: ifne -> 1265
    //   1258: aload_0
    //   1259: invokestatic a : ()J
    //   1262: putfield aK : J
    //   1265: iload_2
    //   1266: bipush #100
    //   1268: iadd
    //   1269: putstatic cf.as : I
    //   1272: iconst_3
    //   1273: putstatic cf.ar : I
    //   1276: goto -> 1290
    //   1279: iinc #2, 1
    //   1282: iload_2
    //   1283: getstatic cf.B : [[I
    //   1286: arraylength
    //   1287: if_icmplt -> 1198
    //   1290: iload_1
    //   1291: ifeq -> 2660
    //   1294: aload_0
    //   1295: astore_0
    //   1296: getstatic ft.S : Z
    //   1299: ifeq -> 2521
    //   1302: getstatic cf.I : Z
    //   1305: ifne -> 1413
    //   1308: getstatic cf.D : I
    //   1311: getstatic cf.aB : I
    //   1314: isub
    //   1315: bipush #25
    //   1317: isub
    //   1318: getstatic cf.E : I
    //   1321: getstatic cf.aB : I
    //   1324: isub
    //   1325: bipush #25
    //   1327: isub
    //   1328: getstatic cf.aB : I
    //   1331: iconst_1
    //   1332: ishl
    //   1333: bipush #50
    //   1335: iadd
    //   1336: getstatic cf.aB : I
    //   1339: iconst_1
    //   1340: ishl
    //   1341: bipush #50
    //   1343: iadd
    //   1344: invokestatic c : (IIII)Z
    //   1347: ifne -> 1392
    //   1350: getstatic cf.e : I
    //   1353: getstatic cf.j : I
    //   1356: isub
    //   1357: bipush #30
    //   1359: isub
    //   1360: getstatic cf.f : I
    //   1363: getstatic cf.j : I
    //   1366: isub
    //   1367: bipush #30
    //   1369: isub
    //   1370: getstatic cf.j : I
    //   1373: iconst_1
    //   1374: ishl
    //   1375: bipush #60
    //   1377: iadd
    //   1378: getstatic cf.j : I
    //   1381: iconst_1
    //   1382: ishl
    //   1383: bipush #60
    //   1385: iadd
    //   1386: invokestatic c : (IIII)Z
    //   1389: ifeq -> 1413
    //   1392: getstatic cn.f : Lbq;
    //   1395: getfield cF : I
    //   1398: iconst_4
    //   1399: if_icmpeq -> 1413
    //   1402: iconst_0
    //   1403: putstatic ft.S : Z
    //   1406: iconst_0
    //   1407: putstatic ft.Q : Z
    //   1410: goto -> 2660
    //   1413: getstatic ft.ae : I
    //   1416: getstatic p.d : Law;
    //   1419: getfield a : I
    //   1422: iadd
    //   1423: istore_1
    //   1424: getstatic ft.af : I
    //   1427: getstatic p.d : Law;
    //   1430: getfield b : I
    //   1433: iadd
    //   1434: istore_2
    //   1435: aconst_null
    //   1436: astore_3
    //   1437: getstatic cn.h : Lez;
    //   1440: ifnull -> 1453
    //   1443: getstatic cn.h : Lez;
    //   1446: getfield cx : B
    //   1449: iconst_2
    //   1450: if_icmpeq -> 1945
    //   1453: iload_1
    //   1454: iload_2
    //   1455: getstatic cn.f : Lbq;
    //   1458: getfield aY : I
    //   1461: getstatic cn.f : Lbq;
    //   1464: getfield aZ : I
    //   1467: invokestatic c : (IIII)I
    //   1470: getstatic cn.f : Lbq;
    //   1473: getfield bh : I
    //   1476: bipush #15
    //   1478: isub
    //   1479: if_icmple -> 1492
    //   1482: getstatic cn.f : Lbq;
    //   1485: getfield cF : I
    //   1488: iconst_4
    //   1489: if_icmpne -> 1945
    //   1492: iload_1
    //   1493: iload_2
    //   1494: istore #4
    //   1496: istore_3
    //   1497: aconst_null
    //   1498: astore #5
    //   1500: aconst_null
    //   1501: astore #6
    //   1503: bipush #40
    //   1505: istore #7
    //   1507: iconst_0
    //   1508: istore #8
    //   1510: iconst_0
    //   1511: istore #9
    //   1513: goto -> 1867
    //   1516: getstatic cn.i : Les;
    //   1519: iload #9
    //   1521: invokevirtual a : (I)Ljava/lang/Object;
    //   1524: checkcast ez
    //   1527: astore #10
    //   1529: getstatic cn.q : Lcf;
    //   1532: getstatic ft.p : Lcs;
    //   1535: getfield d : I
    //   1538: invokevirtual c : (I)Z
    //   1541: ifeq -> 1619
    //   1544: aload #10
    //   1546: getfield cv : B
    //   1549: getstatic cn.f : Lbq;
    //   1552: getfield cv : B
    //   1555: if_icmpeq -> 1607
    //   1558: aload #10
    //   1560: ifnull -> 1607
    //   1563: aload #10
    //   1565: getstatic cn.f : Lbq;
    //   1568: if_acmpeq -> 1607
    //   1571: aload #10
    //   1573: getfield cu : B
    //   1576: bipush #9
    //   1578: if_icmpeq -> 1607
    //   1581: aload #10
    //   1583: invokevirtual x : ()Z
    //   1586: ifne -> 1607
    //   1589: aload #10
    //   1591: getfield cu : B
    //   1594: bipush #10
    //   1596: if_icmpeq -> 1607
    //   1599: aload #10
    //   1601: getfield bI : Z
    //   1604: ifeq -> 1668
    //   1607: aload #10
    //   1609: getfield cu : B
    //   1612: iconst_2
    //   1613: if_icmpeq -> 1668
    //   1616: goto -> 1864
    //   1619: aload #10
    //   1621: ifnull -> 1864
    //   1624: aload #10
    //   1626: getstatic cn.f : Lbq;
    //   1629: if_acmpeq -> 1864
    //   1632: aload #10
    //   1634: getfield cu : B
    //   1637: bipush #9
    //   1639: if_icmpeq -> 1864
    //   1642: aload #10
    //   1644: getfield bI : Z
    //   1647: ifne -> 1864
    //   1650: aload #10
    //   1652: getfield cu : B
    //   1655: bipush #10
    //   1657: if_icmpeq -> 1864
    //   1660: aload #10
    //   1662: invokevirtual x : ()Z
    //   1665: ifne -> 1864
    //   1668: aload #10
    //   1670: getfield cF : I
    //   1673: iconst_4
    //   1674: if_icmpne -> 1686
    //   1677: aload #10
    //   1679: getfield cu : B
    //   1682: iconst_1
    //   1683: if_icmpeq -> 1864
    //   1686: iload_3
    //   1687: iload #4
    //   1689: aload #10
    //   1691: getfield aY : I
    //   1694: aload #10
    //   1696: getfield aZ : I
    //   1699: aload #10
    //   1701: getfield be : I
    //   1704: iconst_4
    //   1705: idiv
    //   1706: isub
    //   1707: invokestatic c : (IIII)I
    //   1710: dup
    //   1711: istore #11
    //   1713: iload #7
    //   1715: if_icmplt -> 1746
    //   1718: invokestatic a : ()Z
    //   1721: ifeq -> 1864
    //   1724: aload #10
    //   1726: getfield cu : B
    //   1729: iconst_2
    //   1730: if_icmpne -> 1864
    //   1733: iload #11
    //   1735: bipush #40
    //   1737: if_icmpge -> 1864
    //   1740: getstatic bq.V : Z
    //   1743: ifeq -> 1864
    //   1746: iload #8
    //   1748: ifne -> 1758
    //   1751: iconst_1
    //   1752: istore #8
    //   1754: aload #10
    //   1756: astore #6
    //   1758: iconst_1
    //   1759: istore #12
    //   1761: iconst_0
    //   1762: istore #13
    //   1764: goto -> 1806
    //   1767: getstatic cf.aP : Les;
    //   1770: iload #13
    //   1772: invokevirtual a : (I)Ljava/lang/Object;
    //   1775: checkcast ez
    //   1778: dup
    //   1779: astore #14
    //   1781: ifnull -> 1803
    //   1784: aload #10
    //   1786: getfield ct : I
    //   1789: aload #14
    //   1791: getfield ct : I
    //   1794: if_icmpne -> 1803
    //   1797: iconst_0
    //   1798: istore #12
    //   1800: goto -> 1817
    //   1803: iinc #13, 1
    //   1806: iload #13
    //   1808: getstatic cf.aP : Les;
    //   1811: invokevirtual c : ()I
    //   1814: if_icmplt -> 1767
    //   1817: iload #12
    //   1819: ifeq -> 1830
    //   1822: aload #10
    //   1824: astore #5
    //   1826: iload #11
    //   1828: istore #7
    //   1830: aload #10
    //   1832: getfield cu : B
    //   1835: iconst_2
    //   1836: if_icmpne -> 1864
    //   1839: getstatic bq.V : Z
    //   1842: ifeq -> 1864
    //   1845: getstatic cf.aP : Les;
    //   1848: aload #5
    //   1850: invokevirtual a : (Ljava/lang/Object;)V
    //   1853: iconst_0
    //   1854: putstatic bq.V : Z
    //   1857: iconst_0
    //   1858: putstatic bq.W : I
    //   1861: goto -> 1920
    //   1864: iinc #9, 1
    //   1867: iload #9
    //   1869: getstatic cn.i : Les;
    //   1872: invokevirtual c : ()I
    //   1875: if_icmplt -> 1516
    //   1878: iload #8
    //   1880: ifeq -> 1898
    //   1883: aload #5
    //   1885: ifnonnull -> 1898
    //   1888: getstatic cf.aP : Les;
    //   1891: invokevirtual d : ()V
    //   1894: aload #6
    //   1896: astore #5
    //   1898: aload #5
    //   1900: ifnull -> 1914
    //   1903: getstatic cf.aP : Les;
    //   1906: aload #5
    //   1908: invokevirtual a : (Ljava/lang/Object;)V
    //   1911: goto -> 1920
    //   1914: getstatic cf.aP : Les;
    //   1917: invokevirtual d : ()V
    //   1920: aload #5
    //   1922: dup
    //   1923: astore_3
    //   1924: ifnull -> 1945
    //   1927: aload_3
    //   1928: getfield cu : B
    //   1931: iconst_1
    //   1932: if_icmpeq -> 1945
    //   1935: getstatic bq.o : B
    //   1938: iconst_1
    //   1939: if_icmpne -> 1945
    //   1942: invokestatic o_ : ()V
    //   1945: aload_0
    //   1946: getfield aO : Z
    //   1949: ifeq -> 2405
    //   1952: getstatic ft.A : Z
    //   1955: ifeq -> 2405
    //   1958: aload_3
    //   1959: ifnull -> 2243
    //   1962: aload_3
    //   1963: invokevirtual b : ()Z
    //   1966: ifeq -> 2660
    //   1969: getstatic ft.p : Lcs;
    //   1972: getfield d : I
    //   1975: invokestatic e : (I)Z
    //   1978: ifeq -> 1995
    //   1981: aload_3
    //   1982: invokevirtual e_ : ()Z
    //   1985: ifne -> 1995
    //   1988: aload_3
    //   1989: getfield cu : B
    //   1992: ifeq -> 2660
    //   1995: aload_3
    //   1996: iconst_5
    //   1997: putfield dl : I
    //   2000: aload_3
    //   2001: putstatic cn.h : Lez;
    //   2004: iconst_0
    //   2005: putstatic ft.S : Z
    //   2008: aload_3
    //   2009: getfield aY : I
    //   2012: aload_3
    //   2013: getfield aZ : I
    //   2016: getstatic cn.f : Lbq;
    //   2019: getfield aY : I
    //   2022: getstatic cn.f : Lbq;
    //   2025: getfield aZ : I
    //   2028: invokestatic c : (IIII)I
    //   2031: getstatic cn.f : Lbq;
    //   2034: getfield bh : I
    //   2037: if_icmpgt -> 2102
    //   2040: getstatic cn.f : Lbq;
    //   2043: invokevirtual m_ : ()V
    //   2046: iconst_1
    //   2047: putstatic cf.K : Z
    //   2050: bipush #68
    //   2052: getstatic cn.f : Lbq;
    //   2055: getfield ct : I
    //   2058: iconst_0
    //   2059: getstatic cn.h : Lez;
    //   2062: getfield ct : I
    //   2065: getstatic cn.h : Lez;
    //   2068: getfield cu : B
    //   2071: iconst_0
    //   2072: getstatic cn.h : Lez;
    //   2075: getfield br : I
    //   2078: getstatic cn.h : Lez;
    //   2081: getfield cu : B
    //   2084: iconst_1
    //   2085: if_icmpne -> 2092
    //   2088: iconst_0
    //   2089: goto -> 2093
    //   2092: iconst_1
    //   2093: i2b
    //   2094: invokestatic a : (IIBIBIIB)V
    //   2097: aload_0
    //   2098: aconst_null
    //   2099: putfield aM : [S
    //   2102: getstatic ft.S : Z
    //   2105: ifeq -> 2521
    //   2108: getstatic ft.p : Lcs;
    //   2111: iload_1
    //   2112: iload_2
    //   2113: invokevirtual a : (II)I
    //   2116: dup
    //   2117: istore_3
    //   2118: iconst_m1
    //   2119: if_icmpeq -> 2235
    //   2122: iload_3
    //   2123: iconst_1
    //   2124: if_icmpeq -> 2235
    //   2127: getstatic cn.f : Lbq;
    //   2130: getstatic cn.f : Lbq;
    //   2133: getfield aY : I
    //   2136: putfield bf : I
    //   2139: getstatic cn.f : Lbq;
    //   2142: getstatic cn.f : Lbq;
    //   2145: getfield aZ : I
    //   2148: putfield bg : I
    //   2151: aload_0
    //   2152: getstatic ft.c : Lcn;
    //   2155: iload_1
    //   2156: getstatic cs.l : I
    //   2159: idiv
    //   2160: iload_2
    //   2161: getstatic cs.l : I
    //   2164: idiv
    //   2165: getstatic cn.f : Lbq;
    //   2168: getfield aY : I
    //   2171: getstatic cs.l : I
    //   2174: idiv
    //   2175: getstatic cn.f : Lbq;
    //   2178: getfield aZ : I
    //   2181: getstatic cs.l : I
    //   2184: idiv
    //   2185: bipush #100
    //   2187: invokevirtual a : (IIIII)[S
    //   2190: putfield aM : [S
    //   2193: aload_0
    //   2194: getfield aM : [S
    //   2197: ifnull -> 2215
    //   2200: aload_0
    //   2201: getfield aM : [S
    //   2204: arraylength
    //   2205: bipush #100
    //   2207: if_icmple -> 2215
    //   2210: aload_0
    //   2211: aconst_null
    //   2212: putfield aM : [S
    //   2215: aload_0
    //   2216: iconst_3
    //   2217: putfield aN : I
    //   2220: iconst_0
    //   2221: putstatic ft.S : Z
    //   2224: iload_1
    //   2225: putstatic bq.O : I
    //   2228: iload_2
    //   2229: putstatic bq.P : I
    //   2232: goto -> 2521
    //   2235: aload_0
    //   2236: aconst_null
    //   2237: putfield aM : [S
    //   2240: goto -> 2521
    //   2243: getstatic cn.f : Lbq;
    //   2246: getfield cF : I
    //   2249: iconst_4
    //   2250: if_icmpeq -> 2660
    //   2253: getstatic ft.p : Lcs;
    //   2256: iload_1
    //   2257: iload_2
    //   2258: invokevirtual a : (II)I
    //   2261: dup
    //   2262: istore_3
    //   2263: iconst_m1
    //   2264: if_icmpeq -> 2397
    //   2267: iload_3
    //   2268: iconst_1
    //   2269: if_icmpeq -> 2397
    //   2272: getstatic cn.f : Lbq;
    //   2275: getstatic cn.f : Lbq;
    //   2278: getfield aY : I
    //   2281: putfield bf : I
    //   2284: getstatic cn.f : Lbq;
    //   2287: getstatic cn.f : Lbq;
    //   2290: getfield aZ : I
    //   2293: putfield bg : I
    //   2296: aload_0
    //   2297: getstatic ft.c : Lcn;
    //   2300: iload_1
    //   2301: getstatic cs.l : I
    //   2304: idiv
    //   2305: iload_2
    //   2306: getstatic cs.l : I
    //   2309: idiv
    //   2310: getstatic cn.f : Lbq;
    //   2313: getfield aY : I
    //   2316: getstatic cs.l : I
    //   2319: idiv
    //   2320: getstatic cn.f : Lbq;
    //   2323: getfield aZ : I
    //   2326: getstatic cs.l : I
    //   2329: idiv
    //   2330: bipush #100
    //   2332: invokevirtual a : (IIIII)[S
    //   2335: putfield aM : [S
    //   2338: aload_0
    //   2339: getfield aM : [S
    //   2342: ifnull -> 2360
    //   2345: aload_0
    //   2346: getfield aM : [S
    //   2349: arraylength
    //   2350: bipush #100
    //   2352: if_icmple -> 2360
    //   2355: aload_0
    //   2356: aconst_null
    //   2357: putfield aM : [S
    //   2360: getstatic cn.f : Lbq;
    //   2363: getfield cN : [S
    //   2366: ifnull -> 2377
    //   2369: aload_0
    //   2370: iconst_1
    //   2371: putfield aN : I
    //   2374: goto -> 2382
    //   2377: aload_0
    //   2378: iconst_3
    //   2379: putfield aN : I
    //   2382: iconst_0
    //   2383: putstatic ft.S : Z
    //   2386: iload_1
    //   2387: putstatic bq.O : I
    //   2390: iload_2
    //   2391: putstatic bq.P : I
    //   2394: goto -> 2521
    //   2397: aload_0
    //   2398: aconst_null
    //   2399: putfield aM : [S
    //   2402: goto -> 2517
    //   2405: getstatic cf.I : Z
    //   2408: ifne -> 2521
    //   2411: aload_3
    //   2412: ifnull -> 2521
    //   2415: aload_3
    //   2416: getfield cu : B
    //   2419: bipush #9
    //   2421: if_icmpeq -> 2521
    //   2424: aload_3
    //   2425: getfield cu : B
    //   2428: bipush #10
    //   2430: if_icmpeq -> 2521
    //   2433: aload_3
    //   2434: invokevirtual x : ()Z
    //   2437: ifne -> 2521
    //   2440: aload_3
    //   2441: getfield bI : Z
    //   2444: ifne -> 2521
    //   2447: getstatic cf.aP : Les;
    //   2450: invokevirtual d : ()V
    //   2453: getstatic cn.h : Lez;
    //   2456: aload_3
    //   2457: if_acmpne -> 2501
    //   2460: getstatic bq.w : [[Lao;
    //   2463: getstatic bq.d : I
    //   2466: aaload
    //   2467: iconst_2
    //   2468: aaload
    //   2469: getfield b : B
    //   2472: ifne -> 2488
    //   2475: getstatic ft.ak : [Z
    //   2478: bipush #25
    //   2480: iconst_1
    //   2481: bastore
    //   2482: getstatic ft.ak : [Z
    //   2485: iconst_5
    //   2486: iconst_1
    //   2487: bastore
    //   2488: aload_0
    //   2489: iconst_0
    //   2490: putfield aN : I
    //   2493: aload_0
    //   2494: aconst_null
    //   2495: putfield aM : [S
    //   2498: goto -> 2517
    //   2501: aload_3
    //   2502: invokevirtual b : ()Z
    //   2505: ifeq -> 2660
    //   2508: aload_3
    //   2509: iconst_5
    //   2510: putfield dl : I
    //   2513: aload_3
    //   2514: putstatic cn.h : Lez;
    //   2517: iconst_0
    //   2518: putstatic ft.S : Z
    //   2521: getstatic cf.I : Z
    //   2524: ifeq -> 2660
    //   2527: aload_0
    //   2528: getfield aN : I
    //   2531: ifle -> 2660
    //   2534: aload_0
    //   2535: getfield aN : I
    //   2538: iconst_1
    //   2539: if_icmpne -> 2650
    //   2542: aload_0
    //   2543: getfield aM : [S
    //   2546: ifnull -> 2650
    //   2549: getstatic cn.f : Lbq;
    //   2552: getfield cF : I
    //   2555: iconst_4
    //   2556: if_icmpeq -> 2650
    //   2559: getstatic cn.f : Lbq;
    //   2562: getfield cF : I
    //   2565: iconst_2
    //   2566: if_icmpeq -> 2650
    //   2569: getstatic cn.f : Lbq;
    //   2572: getfield M : Lew;
    //   2575: ifnonnull -> 2650
    //   2578: getstatic cn.f : Lbq;
    //   2581: iconst_0
    //   2582: putfield cl : I
    //   2585: getstatic cn.f : Lbq;
    //   2588: iconst_0
    //   2589: putfield cm : I
    //   2592: getstatic cn.f : Lbq;
    //   2595: getfield cN : [S
    //   2598: ifnull -> 2608
    //   2601: getstatic cn.f : Lbq;
    //   2604: iconst_1
    //   2605: putfield cI : I
    //   2608: getstatic cn.f : Lbq;
    //   2611: invokevirtual u : ()V
    //   2614: getstatic cn.f : Lbq;
    //   2617: aload_0
    //   2618: getfield aM : [S
    //   2621: putfield cN : [S
    //   2624: aload_0
    //   2625: aconst_null
    //   2626: putfield aM : [S
    //   2629: bipush #9
    //   2631: putstatic bq.Q : I
    //   2634: getstatic bq.h : I
    //   2637: ifgt -> 2650
    //   2640: getstatic bq.o : B
    //   2643: iconst_1
    //   2644: if_icmpne -> 2650
    //   2647: invokestatic o_ : ()V
    //   2650: aload_0
    //   2651: dup
    //   2652: getfield aN : I
    //   2655: iconst_1
    //   2656: isub
    //   2657: putfield aN : I
    //   2660: getstatic cf.I : Z
    //   2663: ifeq -> 2779
    //   2666: getstatic ft.a : Lp;
    //   2669: getstatic ft.c : Lcn;
    //   2672: if_acmpne -> 2779
    //   2675: getstatic ft.T : Z
    //   2678: ifeq -> 2747
    //   2681: getstatic cn.L : Z
    //   2684: ifne -> 2721
    //   2687: getstatic ft.ae : I
    //   2690: getstatic ft.ag : I
    //   2693: isub
    //   2694: invokestatic e : (I)I
    //   2697: bipush #36
    //   2699: if_icmpgt -> 2717
    //   2702: getstatic ft.af : I
    //   2705: getstatic ft.ah : I
    //   2708: isub
    //   2709: invokestatic e : (I)I
    //   2712: bipush #36
    //   2714: if_icmple -> 2721
    //   2717: iconst_1
    //   2718: putstatic cn.L : Z
    //   2721: getstatic ft.ae : I
    //   2724: getstatic ft.ag : I
    //   2727: isub
    //   2728: putstatic cn.N : I
    //   2731: getstatic ft.af : I
    //   2734: getstatic ft.ah : I
    //   2737: isub
    //   2738: putstatic cn.O : I
    //   2741: bipush #40
    //   2743: putstatic cn.R : I
    //   2746: return
    //   2747: getstatic ft.Q : Z
    //   2750: ifeq -> 2779
    //   2753: getstatic p.d : Law;
    //   2756: getfield a : I
    //   2759: putstatic cn.P : I
    //   2762: getstatic p.d : Law;
    //   2765: getfield b : I
    //   2768: putstatic cn.Q : I
    //   2771: iconst_0
    //   2772: putstatic cn.N : I
    //   2775: iconst_0
    //   2776: putstatic cn.O : I
    //   2779: return
  }
  
  private static void m(bx parambx) {
    int i = aA;
    if (C > 0)
      i -= C * 30; 
    for (byte b = 0; b < 8; b++) {
      ev ev;
      int j = D + ak.b(ak.d(i)) * aB / 1000;
      int k = E + ak.a(ak.d(i)) * aB / 1000;
      parambx.a(cg.ap, j, k, 3);
      int m = bq.d;
      if (b > 3)
        if (bq.d == 0) {
          m = 1;
        } else {
          m = 0;
        }  
      ao ao;
      if ((ao = bq.w[m][b % 4 + ((b % 4 > 1) ? 1 : 0)]) != null && ao.b == 0) {
        (ev = ct.c(ao.a)).a(parambx, j, k, 3);
      } else {
        bw bw;
        if (ev != null && ((ao)ev).b == ao.f && (bw = bw.a(4, ((ao)ev).a)) != null)
          bw.a(parambx, j, k, fl.aM, 0, 3); 
      } 
      i -= 45;
    } 
  }
  
  private void f(int paramInt) {
    switch (paramInt) {
      case -4:
        if (!j()) {
          az.b().c();
          return;
        } 
        break;
      case -3:
        if (bq.t > 0) {
          ft.u.a(ft.a);
          ft.u.a = 2;
          return;
        } 
        if (bq.u > 0) {
          ft.u.a(ft.a);
          ft.u.a = 3;
          return;
        } 
        break;
      case -2:
        return;
      case -1:
        if (i > 0) {
          ft.h.g();
          ft.h.a(ft.a);
          return;
        } 
        break;
      case 0:
        if (cn.L) {
          cn.L = false;
          return;
        } 
        (cn.b()).r.a();
        return;
      case 1:
        if (dw.a() - this.aK <= 500L) {
          d.b().c();
          this.aK = -1L;
          this.aL = 0;
          return;
        } 
        (cn.b()).G.a();
        this.aK = -1L;
        this.aL = 0;
        return;
      case 2:
        if ((cn.h == null || cn.h.cx != 2) && C == 0) {
          C = 1;
          return;
        } 
        break;
      case 3:
        if (cn.h != null) {
          bq.a.a();
          return;
        } 
        break;
      case 4:
        if (!d.b) {
          ft.o.b();
          return;
        } 
        break;
      case 5:
        (cn.b()).G.a();
        break;
    } 
  }
  
  public static void g(bx parambx) {
    if (at > 0) {
      at--;
      cg.a(parambx, ft.Y - au / 2 - 10, aw, au + 20, 35, 12);
      o.f.a(parambx, ax, ft.Y, aw + 7, 2, false);
      o.j.a(parambx, "- " + df.cC + cs.b() + " -", ft.Y, aw + 20, 2, false);
    } 
  }
  
  public static void a(bx parambx, String paramString) {
    if (at > 0) {
      at--;
      cg.a(parambx, ft.Y - au / 2 - 10, aw, au + 20, 20, 12);
      o.f.a(parambx, paramString, ft.Y, aw + 4, 2, false);
    } 
  }
  
  public static void a(String paramString) {
    at = 80;
    au = o.f.a(paramString);
    aw = ft.X / 8;
    av = 0;
    if (au < 80)
      au = 80; 
  }
  
  public static void g() {
    at = 80;
    ax = "map";
    if (ck.a != null && ft.p.d < ck.a.length)
      ax = ck.a[ft.p.d]; 
    au = o.f.a(ax);
    aw = ft.X / 8;
    av = 0;
    if (au < 80)
      au = 80; 
  }
  
  public static void h() {
    if (I) {
      B[2][1] = ft.X - 31;
      B[4][0] = 0;
      return;
    } 
    B[2][1] = ft.X - 145;
    B[4][0] = ft.Y - 20;
  }
  
  private static boolean g(int paramInt) {
    return (paramInt == 59 || paramInt == 57 || paramInt == 55 || paramInt == 53);
  }
  
  public static boolean b(int paramInt) {
    return (paramInt == 61 || paramInt == 60 || paramInt == 58 || paramInt == 56 || paramInt == 54);
  }
  
  public final boolean c(int paramInt) {
    return !(!b(paramInt) && !g(paramInt));
  }
  
  public static boolean i() {
    return cn.aO;
  }
  
  public static boolean j() {
    return !(ft.p.d != 83 && ft.p.d != 84 && ft.p.d != 85 && ft.p.d != 86 && ft.p.d != 87);
  }
  
  public static boolean d(int paramInt) {
    return (paramInt == 60 || paramInt == 58 || paramInt == 56 || paramInt == 54);
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2) {
    if (g(paramInt1)) {
      aS = true;
      aR = (int)(paramLong / 1000L + 30L);
      return;
    } 
    aS = false;
    aQ = 0;
  }
  
  public static void k() {
    if (aS) {
      if (aQ >= 0) {
        aQ = (int)(aR - dw.a() / 1000L);
        return;
      } 
      aS = false;
      aQ = 0;
    } 
  }
  
  public static void h(bx parambx) {
    if (aS && aQ >= 0)
      cg.a(parambx, String.valueOf(df.ge) + aQ + "s", 70 - ft.W, B[0][1] + 15, 0); 
  }
  
  public final void a(byte paramByte1, byte paramByte2, short paramShort) {
    if (paramByte1 == -1)
      return; 
    byte b = 0;
    if (paramByte1 == 4) {
      b = 1;
    } else if (paramByte1 == 5) {
      b = 2;
    } else if (paramByte1 == 2) {
      b = 3;
    } else {
      b = 0;
    } 
    if (paramByte2 != -1)
      this.aT[b] = paramByte2; 
    if (paramShort != -1)
      this.aU[b] = paramShort; 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    cg.a(parambx, df.gf, 5, 0, 0);
    T.b(this.aW[4], 10, 20, 0, 3, parambx);
    cg.a(parambx, cn.f.dH, 30, 17, 0);
    for (paramInt1 = 0; paramInt1 < this.aT.length; paramInt1++) {
      if (this.aT[paramInt1] > 0) {
        cg.aE.b(this.aV[paramInt1] * 3 + ft.ai / 3 % 3, 10, 40 + paramInt1 * 20 + 2, 0, 3, parambx);
      } else {
        cg.aE.b(this.aV[4] * 3 + ft.ai / 3 % 3, 10, 40 + paramInt1 * 20, 0, 3, parambx);
      } 
      T.b(this.aW[paramInt1], 30, 40 + paramInt1 * 20 - 2, 0, 3, parambx);
      cg.a(parambx, this.aT[paramInt1], 40, 40 + paramInt1 * 20 - 3, 0);
      parambx.a(fl.aP[3], 0, 32, 16, 16, 0, 70, 40 + paramInt1 * 20, 3);
      cg.a(parambx, this.aU[paramInt1], 80, 40 + paramInt1 * 20 - 3, 0);
    } 
  }
  
  public final void l() {
    this.V = null;
    this.U = false;
  }
  
  public final void i(bx parambx) {
    if (ft.p.d == 19) {
      if (this.V == null) {
        this.V = new dq(50, 1080, 96, 0, 0, 1, 0);
        return;
      } 
      this.V.a();
      if (!this.U) {
        this.V.a(parambx);
        return;
      } 
      this.V.h += 2;
      this.V.a(parambx);
      cn.f.bk = 0;
      cn.f.cF = 0;
      cn.f.cG = 3;
      cn.f.aY = this.V.h + 30;
      cn.f.aZ = this.V.i - 40;
      cn.f.J();
      cn.f.c(parambx, -1);
      if (this.V.h > 1200) {
        (n.b()).a = 1;
        n.b().c();
        return;
      } 
    } else if (ft.p.d == 67) {
      if (this.V == null) {
        this.V = new dq(50, 360, 672, 0, 0, 1, 0);
        return;
      } 
      this.V.a();
      if (!this.U) {
        this.V.a(parambx);
        return;
      } 
      this.V.h += 2;
      this.V.a(parambx);
      cn.f.bk = 0;
      cn.f.cF = 0;
      cn.f.cG = 3;
      cn.f.aY = this.V.h + 30;
      cn.f.aZ = this.V.i - 40;
      cn.f.J();
      cn.f.c(parambx, -1);
      if (this.V.h > 480) {
        (n.b()).a = 3;
        n.b().c();
      } 
    } 
  }
  
  public static boolean e(int paramInt) {
    return (paramInt == 82);
  }
  
  public final void c(bx parambx, int paramInt1, int paramInt2) {
    if (cn.aO)
      return; 
    this.aX = cn.f.aY / cs.l;
    this.aY = cn.f.aZ / cs.l;
    o.k.a(parambx, String.valueOf(this.aX) + ":" + this.aY, paramInt1, 0, 1, false);
  }
  
  public static void j(bx parambx) {
    if (W == 0)
      return; 
    ft.a(parambx);
    byte b = 110;
    if (ft.a != ft.c)
      b = 0; 
    int i = o.j.a("18+ Chơi quá 180 phút mỗi ngày sẽ hại sức khỏe.");
    parambx.b(0);
    parambx.c(b, 0, i, 12);
    o.j.a(parambx, "18+ Chơi quá 180 phút mỗi ngày sẽ hại sức khỏe.", b, 0, 0, false);
  }
  
  public final void k(bx parambx) {
    fd fd;
    if (j() && X != -1 && (fd = bk.i((short)X)).a != null) {
      cg.a(parambx, Y.toUpperCase(), ft.W / 2, 5, 2, (byte)0);
      parambx.a(this.a, ft.W / 2 + o.i.a(Y), 10, 3);
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cf.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */