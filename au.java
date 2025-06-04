public class au extends ez {
  byte[][][] z;
  
  public int A;
  
  public int B;
  
  private int a;
  
  public int C;
  
  public int D;
  
  public int E;
  
  public int F;
  
  public int G;
  
  public int H;
  
  public int I;
  
  private int b;
  
  private int c;
  
  int J;
  
  private int d;
  
  public static ek K = new ek();
  
  public static es L = new es("MainMonster VecCatalogyMonSter");
  
  public int M;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  int N;
  
  public int O;
  
  public long P;
  
  public es Q = null;
  
  private byte i;
  
  public String R = "";
  
  public static short[] S = new short[] { 104, 103, 105, 106, 135 };
  
  int T;
  
  public void a(int paramInt) {}
  
  public final boolean m() {
    for (byte b = 0; b < S.length; b++) {
      if (this.B == S[b])
        return true; 
    } 
    return false;
  }
  
  public void a(long paramLong) {}
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    db db;
    switch ((db = b(paramInt4)).d) {
      case 0:
      case 1:
      case 2:
      case 4:
      case 6:
      case 9:
        cn.a(new cc(paramInt1, db.a, db.d, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 3:
      case 5:
      case 8:
      case 10:
        cn.a(new ac(paramInt1, db.a, db.d, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 7:
        cn.a(new a(paramInt1, db.a, db.d, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 12:
        cn.a(new cc(paramInt1, db.a, 12, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 13:
        if (db.a == 110) {
          cn.a(new cu(paramInt1, db.a, 13, db.e, paramInt2, paramInt3, db.c, db.b));
          return;
        } 
        cn.a(new fu(paramInt1, db.a, 13, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 14:
        cn.a(new cv(paramInt1, db.a, 14, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 15:
        cn.a(new ba(paramInt1, db.a, 14, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 16:
        cn.a(new cc(paramInt1, db.a, 16, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 17:
        cn.a(new cc(paramInt1, db.a, 17, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 19:
        cn.a(new ac(paramInt1, db.a, 19, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
      case 18:
        cn.a(new cc(paramInt1, db.a, 18, db.e, paramInt2, paramInt3, db.c, db.b));
        return;
    } 
    cn.a(new cc(paramInt1, db.a, 0, db.e, paramInt2, paramInt3, db.c, db.b));
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    fd fd;
    if ((fd = bk.c((short)this.B)).a != null) {
      if (this.g <= 0) {
        if (this.bd < 0) {
          this.be = aq.b(fd.a.a) / this.N;
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
  
  public void a() {
    if (this.dj && this.cF != 4) {
      this.cF = 4;
      this.aW = ft.aj;
    } 
    if (this.dE && this.dD)
      h(); 
    I();
    super.a();
  }
  
  public void a(bx parambx) {
    h(parambx);
    d(parambx, this.aY, this.aZ);
  }
  
  public void b_() {
    if (this.dZ)
      return; 
    this.ba++;
    if (this.ba > (this.z[this.cF][(this.cG > 2) ? 2 : this.cG]).length - 1) {
      this.ba = 0;
      if (this.cF == 3) {
        this.cF = 0;
        this.bb = 0;
        this.bc = 0;
      } 
      if (this.cF == 2)
        if (!m()) {
          this.cF = 0;
          this.bb = 0;
          this.bc = 0;
        } else {
          if (this.i >= 0)
            this.i = (byte)(this.i - 1); 
          if (this.i <= 0) {
            this.cF = 0;
            this.bb = 0;
            this.bc = 0;
          } 
        }  
    } 
    if (this.cF == 1 && this.bb == 0 && this.bc == 0) {
      this.cF = 0;
      this.ba = 0;
    } 
    if (this.E > 0)
      this.E--; 
    if ((this.dj || this.cF == 4) && (this.cx == 3 || this.cx == 4)) {
      this.a++;
      if (this.a > 600)
        this.cK = true; 
    } 
  }
  
  public static db b(int paramInt) {
    for (byte b = 0; b < L.c(); b++) {
      db db;
      if ((db = (db)L.a(b)).a == paramInt)
        return db; 
    } 
    return null;
  }
  
  public final void o() {
    if (this.cx == 5)
      return; 
    if (q_() || w())
      return; 
    if (this.dJ || this.bH || this.bI || this.dK || this.dL || this.dZ)
      return; 
    if (this.cx == 3 || this.cx == 4) {
      this.bf = this.H;
      this.bg = this.I;
      h();
      if (ez.c(this.aY, this.aZ, this.bf, this.bg) <= cs.l / 2 && this.dq) {
        if (this.cx == 3) {
          cn.a(36, this.aY, this.aZ - this.be / 2);
          cs.t = 103;
        } else if (this.cx == 4) {
          for (byte b = 0; b < 3; b++) {
            int i = this.be;
            int j = this.bd;
            if (this.be <= 1)
              i = 40; 
            if (j <= 1)
              j = 40; 
            cn.a(36, this.aY + ak.g(j / 2), this.aZ - this.be / 2 + ak.g(i / 2));
          } 
          cs.t = 110;
        } 
        this.cK = true;
        this.dq = false;
        return;
      } 
    } else {
      if (ez.c(this.aY, this.aZ, this.F, this.G) > this.C + this.C / 2) {
        if (!ez.c(this) && !ez.d(this.F, this.G, this.bd, this.be)) {
          this.aY = this.F;
          this.aZ = this.G;
          this.bf = this.F;
          this.bg = this.G;
          return;
        } 
        this.bf = this.F;
        this.bg = this.G;
        h();
        return;
      } 
      if (!ez.c(this) && !ez.d(this.F, this.G, this.bd, this.be)) {
        this.aY = this.F;
        this.aZ = this.G;
        this.bf = this.F;
        this.bg = this.G;
        return;
      } 
      this.dV++;
      if (this.cF != 4) {
        if (this.dl > 0) {
          this.dV = 0;
          this.cF = 0;
          this.bb = 0;
          this.bc = 0;
          this.dl--;
        } else if (ez.c(this.aY + this.bb, this.aZ + this.bc, cn.f.aY, cn.f.aZ) < 50) {
          if (this.cF == 1) {
            if (this.dV > this.A / 2 || ak.f(12) == 0 || ez.c(this.aY + this.bb, this.aZ + this.bc, this.F, this.G) >= this.C - this.bi) {
              this.dV = 0;
              this.cF = 0;
              this.bb = 0;
              this.bc = 0;
              if (this.aY > cn.f.aY) {
                this.cG = 2;
              } else {
                this.cG = 3;
              } 
            } 
          } else if (this.cF == 0 || ak.f(30) == 0) {
            this.bb = 0;
            this.bc = 0;
            if (this.dV > this.A) {
              this.dV = 0;
              this.cF = 1;
              this.cG = ak.f(4);
              c(this.bi - 2);
            } 
            if (this.aY > cn.f.aY) {
              this.cG = 2;
            } else {
              this.cG = 3;
            } 
          } 
        } else if (this.cF == 1) {
          if (this.dV > this.A || ak.f(16) == 0 || ez.c(this.aY + this.bb, this.aZ + this.bc, this.F, this.G) >= this.C - this.bi) {
            this.dV = 0;
            this.cF = 0;
            this.bb = 0;
            this.bc = 0;
          } 
        } else if (this.cF == 0) {
          this.bb = 0;
          this.bc = 0;
          if (this.dV > this.A / 2 || ak.f(12) == 0) {
            this.dV = 0;
            this.cF = 1;
            this.cG = ak.f(4);
            c(this.bi);
          } 
        } 
        if (ez.c(this.aY, this.aZ, this.F, this.G) > this.C) {
          int i = ak.e(this.aY - this.F);
          int j = ak.e(this.aZ - this.G);
          if (i > j) {
            if (this.aY > this.F) {
              this.cG = 2;
            } else {
              this.cG = 3;
            } 
          } else if (this.aZ > this.G) {
            this.cG = 1;
          } else {
            this.cG = 0;
          } 
          c(this.bi);
        } 
      } 
    } 
  }
  
  public final void p() {
    if (this.cx == 5)
      return; 
    this.dV++;
    if (this.cF != 4)
      if (this.cF == 1) {
        this.dV = 0;
        this.cF = 0;
        this.bb = 0;
        this.bc = 0;
        ez ez1;
        if ((this.dV > this.A || ak.f(16) == 0) && (ez1 = ez.a(this.cQ, (byte)0)) != null) {
          if (this.aY > ez1.aY) {
            this.cG = 2;
            return;
          } 
          this.cG = 3;
          return;
        } 
      } else if (this.cF == 0) {
        this.bb = 0;
        this.bc = 0;
        if (this.dV > this.A / 2 || ak.f(12) == 0) {
          this.dV = 0;
          this.cF = 1;
          this.cG = ak.f(4);
          h(this.bi);
        } 
      }  
  }
  
  public void q() {
    if (this.cx == 5)
      return; 
    if (this.bH)
      return; 
    if (this.bI)
      return; 
    if (this.Q != null && this.Q.c() > 0) {
      bf bf = (bf)this.Q.a(0);
      if (ft.aj - this.P > this.O) {
        this.cQ = bf.a;
        bf.g = this.dn;
        t();
        s();
        return;
      } 
      ez ez1;
      if ((ez1 = ez.a(bf.a, bf.b)) == null) {
        this.cU = false;
        return;
      } 
      this.bf = ez1.aY;
      this.bg = ez1.aZ;
      int i = bf.g.c;
      if (ez.c(this.aY + this.bb, this.aZ + this.bc, ez1.aY, ez1.aZ) <= i) {
        this.cQ = bf.a;
        t();
        s();
        return;
      } 
      if (ak.e(this.aY - this.bf) >= 4 || ak.e(this.aZ - this.bg) >= 4) {
        p_();
        return;
      } 
    } else {
      ez ez1;
      if ((ez1 = ez.a(this.cQ, (byte)0)) == null) {
        this.cU = false;
        return;
      } 
      this.bf = ez1.aY;
      this.bg = ez1.aZ;
      if (ez.c(this.aY + this.bb, this.aZ + this.bc, ez1.aY, ez1.aZ) <= this.D) {
        this.bb = 0;
        this.bc = 0;
        this.cF = 0;
        this.bf = this.aY;
        this.bg = this.aZ;
        if (ak.f(30) == 0)
          this.E = 20; 
        if (this.aY > ez1.aY) {
          this.cG = 2;
          return;
        } 
        this.cG = 3;
        return;
      } 
      if (ak.e(this.aY - this.bf) >= 4 || ak.e(this.aZ - this.bg) >= 4)
        p_(); 
    } 
  }
  
  public final void r() {
    au au1 = this;
    byte b = 0;
    if (au1.di == 7) {
      au1.aY = au1.F;
      au1.aZ = au1.G;
    } else {
      int i;
      do {
        au1.aY = au1.F + ak.g(48);
        au1.aZ = au1.G + ak.g(48);
        i = ((i = ft.p.a(au1.aY, au1.aZ)) != 1 && i != -1) ? 1 : 0;
        if (++b <= 15)
          continue; 
        i = 1;
        au1.aY = au1.F;
        au1.aZ = au1.G;
      } while (i == 0);
    } 
    this.cU = false;
    M();
    this.e = 0;
    this.E = 0;
    this.f = 5;
    this.ba = 0;
    this.cF = 0;
    this.dV = 0;
    this.dj = false;
    this.b = 0;
    this.c = 0;
    this.br = this.bs;
    this.df.d();
    this.J = this.d = 0;
  }
  
  public void a_() {
    if (this.cF == 4) {
      this.e++;
      if (ft.ai % 10 == 0 && this.dA >= 0 && this.dj && (ft.aj - this.aW) / 1000L > this.dA)
        r(); 
      if (!this.dj) {
        this.aY += this.b;
        this.aZ += this.c;
        if (this.J > 0) {
          this.J -= 3;
          if (this.J <= 0 && this.d > 2) {
            this.d -= 2;
            this.J = this.d;
            if (ak.e(this.b) > 1)
              this.b -= this.b / ak.e(this.b); 
            if (ak.e(this.c) > 1)
              this.c -= this.c / ak.e(this.c); 
          } 
        } else {
          this.b >>= 1;
          this.c >>= 1;
        } 
        if (this.e >= this.f) {
          cn.a(11, this.aY, this.aZ - this.be / 4);
          if (!q_() || !w()) {
            this.dj = true;
          } else if (this.dx < -10) {
            this.dj = true;
          } 
        } 
      } 
      if (q_() || w() || this.di == 16) {
        this.dx--;
        if (this.dx > 0 && this.cJ < 70) {
          this.cJ++;
          if (ak.f(3) == 1) {
            if (ak.f(2) == 1)
              cs.t = 103; 
            int i = ak.c(1, 3);
            for (byte b = 0; b < i; b++) {
              int j = ak.g(25);
              int k = ak.g(30);
              cn.a(36, this.aY + j, this.aZ + k - this.be / 3 + 10);
              if (ak.f(3) == 1)
                cn.a(9, this.aY + j, this.aZ + k - this.be / 3 + 10); 
            } 
          } 
          if (this.cJ >= 70) {
            for (byte b = 0; b < 6; b++) {
              int i = ak.g(25);
              int j = ak.g(30);
              cn.a(36, this.aY + i, this.aZ + j - this.be / 3 + 10);
              if (ak.f(3) == 1)
                cn.a(9, this.aY + i, this.aZ + j - this.be / 2 + 10); 
            } 
            this.cK = true;
            return;
          } 
        } 
      } 
    } else if (this.br <= 0) {
      this.br = 0;
      this.cF = 4;
      this.aW = ft.aj;
      M();
    } 
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.aW = ft.aj;
    this.cF = 4;
    this.bb = 0;
    this.bc = 0;
    this.b = paramInt1;
    this.c = paramInt2;
    this.J = paramInt4;
    this.d = paramInt4;
    this.f = paramInt3;
    this.dj = false;
    if (q_() || w() || this.di == 16) {
      this.b = 0;
      this.c = 0;
      this.J = 0;
      this.d = 0;
    } 
  }
  
  public final void s() {
    if (this.Q != null && this.Q.c() > 0) {
      bf bf;
      if ((bf = (bf)this.Q.a(0)) != null && bf.g != null)
        if (bf.g.a == 124) {
          cn.a(this.ct, (byte)1);
        } else {
          cn.a(bf.g.a, this.ct, (byte)1, this.Q, bf.g.b);
        }  
      this.Q = null;
    } 
  }
  
  public final void t() {
    this.cF = 2;
    this.i = (byte)ak.c(3, 5);
    N();
    this.ba = 0;
  }
  
  public final boolean u() {
    return !(this.di != 17 && this.di != 19 && this.di != 18);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\au.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */