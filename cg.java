public class cg {
  public bt Y;
  
  public bt Z;
  
  public bt aa;
  
  public static aq[] ab = new aq[4];
  
  public static int ac;
  
  public static aq[] ad = new aq[3];
  
  public static aq ae;
  
  public static aq af;
  
  public static aq ag;
  
  public static aq ah;
  
  public static aq ai;
  
  public static aq aj;
  
  public static aq ak;
  
  public static aq al;
  
  public static aq am;
  
  public static aq an;
  
  public static aq ao;
  
  public static aq ap;
  
  public static aq aq;
  
  public static aq ar;
  
  public static aq as;
  
  public static aq at;
  
  public static aq au;
  
  public static aq av;
  
  public static aq aw;
  
  public static aq ax;
  
  public static aq ay;
  
  public static aq az;
  
  public static aq aA;
  
  public static aq aB;
  
  public static ce aC;
  
  public static ce aD;
  
  public static ce aE;
  
  public static ce aF;
  
  public static ce aG;
  
  public static ce aH;
  
  public static ce aI;
  
  public static ce aJ;
  
  public static ce aK;
  
  public static int[] aL = new int[] { -12052464, -477112, -6778760, -2043720, -6649744 };
  
  private static int[] a = new int[] { -8902126, -460632, -11467264, -477112, -477112 };
  
  public void a(bx parambx) {
    ft.a(parambx);
    if (ft.r == null && !ft.o.a)
      c(parambx); 
  }
  
  public void a() {}
  
  public void e(int paramInt) {}
  
  public final void c(bx parambx) {
    if (ft.C) {
      parambx = parambx;
      this = this;
      ft.a(parambx);
      if (this.Y != null)
        this.Y.a(parambx, ft.ac, ft.X - bt.k / 2 - 1); 
      if (this.Z != null)
        this.Z.a(parambx, ft.W - ft.ac, ft.X - bt.k / 2 - 1); 
      if (this.aa != null)
        this.aa.a(parambx, ft.Y, ft.X - bt.k / 2 - 1); 
      return;
    } 
    if (this.Y != null)
      this.Y.a(parambx, ft.ac, ft.X - bt.k / 2 - 1); 
    if (this.Z != null)
      this.Z.a(parambx, ft.W - ft.ac, ft.X - bt.k / 2 - 1); 
    if (this.aa != null)
      this.aa.a(parambx, ft.Y, ft.X - bt.k / 2 - 1); 
  }
  
  public final void d(bx parambx) {
    if (ft.o.a || ft.r != null)
      return; 
    ft.a(parambx);
    if (ft.C) {
      parambx = parambx;
      if ((this = this).Y != null)
        o.f.a(parambx, this.Y.a, 27, ft.X - ft.aa / 2 + 1, 2, false); 
      if (this.Z != null)
        o.f.a(parambx, this.Z.a, ft.W - 27, ft.X - ft.aa / 2 + 1, 2, false); 
      if (this.aa != null)
        o.f.a(parambx, this.aa.a, ft.Y, ft.X - ft.aa / 2 + 1, 2, false); 
      return;
    } 
    if (this.Y != null)
      a(parambx, this.Y.a, 30, ft.X - ft.aa / 2 - 4, 2); 
    if (this.Z != null)
      a(parambx, this.Z.a, ft.W - 30, ft.X - ft.aa / 2 - 4, 2); 
    if (this.aa != null)
      a(parambx, this.aa.a, ft.Y, ft.X - ft.aa / 2 - 4, 2); 
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void a_(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, Object paramObject) {}
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt3 < 35)
      paramInt3 = 35; 
    int i = (paramInt3 - 6) / 32;
    int j = (paramInt4 - 6) / 32;
    if (paramInt4 % 2 != 0)
      paramInt4++; 
    if (ft.B) {
      if (paramInt5 > 2)
        if (paramInt5 == 8 || paramInt5 == 12) {
          paramInt5 = 4;
        } else {
          paramInt5 = 3;
        }  
      parambx.a(a[0]);
      parambx.c(paramInt1, paramInt2, paramInt3, paramInt4);
      parambx.a(a[4]);
      parambx.b(paramInt1 + 1, paramInt2 + 1, paramInt3 - 3, paramInt4 - 3);
      fl.c(parambx, paramInt1 + 3, paramInt2 + 3, paramInt3 - 6, paramInt4 - 6, paramInt5);
      return;
    } 
    if (paramInt4 < 32) {
      for (byte b = 0; b <= i; b++) {
        for (byte b1 = 0; b1 <= j; b1++) {
          if (b == i) {
            if (b1 == j) {
              parambx.a(fl.aP[paramInt5], 0, 0, 32, paramInt4, 0, paramInt1 - 3 + paramInt3 - 32, paramInt2, 0);
            } else {
              parambx.a(fl.aP[paramInt5], 0, 0, 32, paramInt4, 0, paramInt1 - 3 + paramInt3 - 32, paramInt2 + 3 + b1 * 32, 0);
            } 
          } else if (b1 == j) {
            parambx.a(fl.aP[paramInt5], 0, 0, 32, paramInt4, 0, paramInt1 + 3 + (b << 5), paramInt2, 0);
          } else {
            parambx.a(fl.aP[paramInt5], 0, 0, 32, paramInt4, 0, paramInt1 + 3 + (b << 5), paramInt2 + 3 + b1 * 32, 0);
          } 
        } 
      } 
    } else {
      for (byte b = 0; b <= i; b++) {
        for (byte b1 = 0; b1 <= j; b1++) {
          if (b == i) {
            if (b1 == j) {
              parambx.a(fl.aP[paramInt5], paramInt1 - 3 + paramInt3 - 32, paramInt2 - 3 + paramInt4 - 32, 0);
            } else {
              parambx.a(fl.aP[paramInt5], paramInt1 - 3 + paramInt3 - 32, paramInt2 + 3 + b1 * 32, 0);
            } 
          } else if (b1 == j) {
            parambx.a(fl.aP[paramInt5], paramInt1 + 3 + (b << 5), paramInt2 - 3 + paramInt4 - 32, 0);
          } else {
            parambx.a(fl.aP[paramInt5], paramInt1 + 3 + (b << 5), paramInt2 + 3 + b1 * 32, 0);
          } 
        } 
      } 
    } 
    parambx.a(ai, 0, 0, 5, 5, 0, paramInt1, paramInt2, 0);
    parambx.a(ai, 0, 5, 5, 5, 0, paramInt1 + paramInt3 - 5, paramInt2, 0);
    parambx.a(ai, 0, 15, 5, 5, 0, paramInt1, paramInt2 + paramInt4 - 5, 0);
    parambx.a(ai, 0, 10, 5, 5, 0, paramInt1 + paramInt3 - 5, paramInt2 + paramInt4 - 5, 0);
    parambx.a(a[0]);
    parambx.c(paramInt1 + 3, paramInt2, paramInt3 - 6, 1);
    parambx.c(paramInt1, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[1]);
    parambx.c(paramInt1 + 3, paramInt2 + 1, paramInt3 - 6, 1);
    parambx.c(paramInt1 + 1, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[2]);
    parambx.c(paramInt1 + 3, paramInt2 + 2, paramInt3 - 6, 1);
    parambx.c(paramInt1 + 2, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[2]);
    parambx.c(paramInt1 + 3, paramInt2 + paramInt4 - 1, paramInt3 - 6, 1);
    parambx.c(paramInt1 + paramInt3 - 1, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[4]);
    parambx.c(paramInt1 + 3, paramInt2 + paramInt4 - 2, paramInt3 - 6, 1);
    parambx.c(paramInt1 + paramInt3 - 2, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[0]);
    parambx.c(paramInt1 + 3, paramInt2 + paramInt4 - 3, paramInt3 - 6, 1);
    parambx.c(paramInt1 + paramInt3 - 3, paramInt2 + 3, 1, paramInt4 - 6);
  }
  
  public static void b(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (ft.B) {
      a(parambx, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    } 
    int i = (paramInt3 - 6) / 32;
    int j = (paramInt4 - 6) / 32;
    if (paramInt4 % 2 != 0)
      paramInt4++; 
    for (byte b = 0; b <= i; b++) {
      for (byte b1 = 0; b1 <= j; b1++) {
        if (b1 <= 1 || b1 >= j - 1 || b == 0 || b == i)
          if (b == i) {
            if (b1 == j) {
              parambx.a(fl.aP[paramInt5], paramInt1 - 3 + paramInt3 - 32, paramInt2 - 3 + paramInt4 - 32, 0);
            } else {
              parambx.a(fl.aP[paramInt5], paramInt1 - 3 + paramInt3 - 32, paramInt2 + 3 + b1 * 32, 0);
            } 
          } else if (b1 == j) {
            parambx.a(fl.aP[paramInt5], paramInt1 + 3 + (b << 5), paramInt2 - 3 + paramInt4 - 32, 0);
          } else {
            parambx.a(fl.aP[paramInt5], paramInt1 + 3 + (b << 5), paramInt2 + 3 + b1 * 32, 0);
          }  
      } 
    } 
    parambx.a(ai, 0, 0, 5, 5, 0, paramInt1, paramInt2, 0);
    parambx.a(ai, 0, 5, 5, 5, 0, paramInt1 + paramInt3 - 5, paramInt2, 0);
    parambx.a(ai, 0, 15, 5, 5, 0, paramInt1, paramInt2 + paramInt4 - 5, 0);
    parambx.a(ai, 0, 10, 5, 5, 0, paramInt1 + paramInt3 - 5, paramInt2 + paramInt4 - 5, 0);
    parambx.a(a[0]);
    parambx.c(paramInt1 + 3, paramInt2, paramInt3 - 6, 1);
    parambx.c(paramInt1, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[1]);
    parambx.c(paramInt1 + 3, paramInt2 + 1, paramInt3 - 6, 1);
    parambx.c(paramInt1 + 1, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[2]);
    parambx.c(paramInt1 + 3, paramInt2 + 2, paramInt3 - 6, 1);
    parambx.c(paramInt1 + 2, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[2]);
    parambx.c(paramInt1 + 3, paramInt2 + paramInt4 - 1, paramInt3 - 6, 1);
    parambx.c(paramInt1 + paramInt3 - 1, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[4]);
    parambx.c(paramInt1 + 3, paramInt2 + paramInt4 - 2, paramInt3 - 6, 1);
    parambx.c(paramInt1 + paramInt3 - 2, paramInt2 + 3, 1, paramInt4 - 6);
    parambx.a(a[0]);
    parambx.c(paramInt1 + 3, paramInt2 + paramInt4 - 3, paramInt3 - 6, 1);
    parambx.c(paramInt1 + paramInt3 - 3, paramInt2 + 3, 1, paramInt4 - 6);
  }
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, byte paramByte) {
    if (ft.B) {
      a(parambx, paramInt1, paramInt2, paramInt3, paramInt4, paramByte);
      return;
    } 
    if (paramInt4 < 32)
      paramInt4 = 32; 
    parambx.a(aL[0]);
    parambx.c(paramInt1 + ac - 2, paramInt2 + 3, paramInt3 - 2 * ac + 4, paramInt4 - 5);
    parambx.c(paramInt1 + 4, paramInt2 + ac - 2, paramInt3 - 8, paramInt4 - 2 * ac + 4);
    parambx.a(aL[1]);
    parambx.c(paramInt1 + ac - 2, paramInt2 + 4, paramInt3 - 2 * ac + 4, paramInt4 - 7);
    parambx.c(paramInt1 + 5, paramInt2 + ac - 2, paramInt3 - 10, paramInt4 - 2 * ac + 4);
    parambx.a(aL[0]);
    parambx.c(paramInt1 + ac - 2, paramInt2 + 5, paramInt3 - 2 * ac + 4, paramInt4 - 9);
    parambx.c(paramInt1 + 6, paramInt2 + ac - 2, paramInt3 - 12, paramInt4 - 2 * ac + 4);
    parambx.a(aL[2]);
    parambx.c(paramInt1 + 7, paramInt2 + 6, paramInt3 - 14, paramInt4 - 12);
    for (paramBoolean = false; paramBoolean <= (paramInt3 - 15) / 32; paramBoolean++) {
      for (byte b = 0; b <= (paramInt4 - 11) / 32; b++) {
        if (paramBoolean == (paramInt3 - 15) / 32) {
          if (b == (paramInt4 - 11) / 32) {
            parambx.a(fl.aP[paramByte], paramInt1 + paramInt3 - 39, paramInt2 + paramInt4 - 37, 0);
          } else {
            parambx.a(fl.aP[paramByte], paramInt1 + paramInt3 - 39, paramInt2 + 7 + (b << 5), 0);
          } 
        } else if (b == (paramInt4 - 11) / 32) {
          parambx.a(fl.aP[paramByte], paramInt1 + 8 + (paramBoolean << 5), paramInt2 + paramInt4 - 37, 0);
        } else {
          parambx.a(fl.aP[paramByte], paramInt1 + 8 + (paramBoolean << 5), paramInt2 + 7 + (b << 5), 0);
        } 
      } 
    } 
    parambx.a(ab[0], paramInt1, paramInt2, 0);
    parambx.a(ab[0], 0, 0, ac, ac, 2, paramInt1 + paramInt3 - ac, paramInt2, 0);
    parambx.a(ab[1], paramInt1 + 2, paramInt2 + paramInt4 - ac, 0);
    parambx.a(ab[1], 0, 0, 30, 30, 2, paramInt1 + paramInt3 - 32, paramInt2 + paramInt4 - ac, 0);
    parambx.a(ab[2], paramInt1 + paramInt3 / 2, paramInt2 + 2, 3);
  }
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
    if (paramInt4 % 2 == 1)
      paramInt4++; 
    if (ft.B) {
      if (paramByte > 2)
        if (paramByte == 8 || paramByte == 12) {
          paramByte = 4;
        } else {
          paramByte = 3;
        }  
      fl.c(parambx, paramInt1, paramInt2, paramInt3, paramInt4, paramByte);
      return;
    } 
    for (byte b = 0; b <= paramInt3 / 32; b++) {
      for (byte b1 = 0; b1 <= paramInt4 / 32; b1++) {
        if (b == paramInt3 / 32) {
          if (b1 == paramInt4 / 32) {
            parambx.a(fl.aP[paramByte], paramInt1 + paramInt3 - 32, paramInt2 + paramInt4 - 32, 0);
          } else {
            parambx.a(fl.aP[paramByte], paramInt1 + paramInt3 - 32, paramInt2 + (b1 << 5), 0);
          } 
        } else if (b1 == paramInt4 / 32) {
          parambx.a(fl.aP[paramByte], paramInt1 + (b << 5), paramInt2 + paramInt4 - 32, 0);
        } else {
          parambx.a(fl.aP[paramByte], paramInt1 + (b << 5), paramInt2 + (b1 << 5), 0);
        } 
      } 
    } 
  }
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    parambx.a(-4155296);
    if (paramBoolean)
      parambx.a(-132648); 
    parambx.a(ae, 0, paramBoolean ? 30 : 0, 4, 15, 0, paramInt1, paramInt2, 0);
    parambx.a(ae, 0, (paramBoolean ? 30 : 0) + 15, 4, 15, 0, paramInt1 + paramInt3 - 4, paramInt2 + paramInt4 - 15, 0);
    parambx.a(ae, 0, (paramBoolean ? 30 : 0) + 11, 4, 4, 0, paramInt1, paramInt2 + paramInt4 - 4, 0);
    parambx.a(ae, 0, (paramBoolean ? 30 : 0) + 15, 4, 4, 0, paramInt1 + paramInt3 - 4, paramInt2, 0);
    parambx.c(paramInt1 + 4, paramInt2, paramInt3 - 8, paramInt4);
    parambx.c(paramInt1, paramInt2 + 4, paramInt3, paramInt4 - 8);
  }
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    parambx.a(-6517641);
    parambx.c(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString) {
    b(parambx, paramInt1 - 6, paramInt2 - 6, paramInt3 + 12, paramInt4 + 12, 0);
    a(parambx, paramInt1, paramInt2 + ft.aa, paramInt3, paramInt4 - ft.aa, (byte)2);
    fl.a(parambx, paramInt1 + paramInt3 / 2, paramInt2 + ft.aa / 4, paramInt3, paramString, 7);
  }
  
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramInt1 < 0) {
      if (!paramBoolean)
        return 0; 
    } else if (paramInt1 > paramInt2) {
      if (paramBoolean)
        return 0; 
    } else {
      return paramInt1;
    } 
    return paramInt2;
  }
  
  public void d() {
    if (ft.al[5]) {
      if (this.aa != null) {
        ft.c(5);
        ft.d(5);
        this.aa.a();
        return;
      } 
    } else if (ft.al[12]) {
      if (this.Y != null) {
        ft.c(12);
        ft.d(12);
        this.Y.a();
        return;
      } 
    } else if (ft.al[13] && this.Z != null) {
      ft.c(13);
      ft.d(13);
      this.Z.a();
    } 
  }
  
  public void e() {
    if (ft.A) {
      if (this.Y != null)
        if (this.Y.c()) {
          this.Y.b();
        } else if (ft.b(0, ft.X - ft.aa - 5, ft.ac << 1, ft.aa + 10)) {
          this.Y.a();
        }  
      if (this.Z != null)
        if (this.Z.c()) {
          this.Z.b();
        } else if (ft.b(ft.W - (ft.ac << 1), ft.X - ft.aa - 5, ft.ac << 1, ft.aa + 10)) {
          this.Z.a();
        }  
      if (this.aa != null) {
        if (this.aa.c()) {
          this.aa.b();
          return;
        } 
        if (ft.b(ft.Y - ft.ac, ft.X - ft.aa - 5, ft.ac << 1, ft.aa + 10))
          this.aa.a(); 
      } 
    } 
  }
  
  public static void a(bx parambx, String paramString, int paramInt1, int paramInt2, int paramInt3) {
    o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 + 1, paramInt3, true);
    o.f.a(parambx, paramString, paramInt1, paramInt2, paramInt3, true);
  }
  
  public static void a(bx parambx, String paramString, int paramInt1, int paramInt2, int paramInt3, byte paramByte) {
    o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 + 1, paramInt3, true);
    fl.b(paramByte).a(parambx, paramString, paramInt1, paramInt2, paramInt3, true);
  }
  
  public static void a(bx parambx, String paramString, int paramInt1, int paramInt2, int paramInt3, byte paramByte1, byte paramByte2) {
    fl.b(7).a(parambx, paramString, paramInt1 + 1, paramInt2 + 1, paramInt3, true);
    fl.b(paramByte2).a(parambx, paramString, paramInt1, paramInt2, paramInt3, true);
  }
  
  public static void a(bx parambx, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt4 == 2) {
      o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 + 1, paramInt3, true);
    } else {
      o.c.a(parambx, paramString, paramInt1 - 1, paramInt2 - 1, paramInt3, true);
      o.c.a(parambx, paramString, paramInt1 - 1, paramInt2 + 1, paramInt3, true);
      o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 - 1, paramInt3, true);
      o.c.a(parambx, paramString, paramInt1 + 1, paramInt2 + 1, paramInt3, true);
      o.c.a(parambx, paramString, paramInt1 - 1, paramInt2, paramInt3, true);
      o.c.a(parambx, paramString, paramInt1 + 1, paramInt2, paramInt3, true);
      o.c.a(parambx, paramString, paramInt1, paramInt2 - 1, paramInt3, true);
      o.c.a(parambx, paramString, paramInt1, paramInt2 + 1, paramInt3, true);
    } 
    fl.b(paramInt4).a(parambx, paramString, paramInt1, paramInt2, paramInt3, false);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cg.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */