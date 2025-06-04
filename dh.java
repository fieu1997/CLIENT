public final class dh extends ct {
  private ez i;
  
  private ez j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private es o;
  
  public byte g = -1;
  
  private static short p = 0;
  
  private static long q = 0L;
  
  private static long r;
  
  public static int h = 600;
  
  public final void a(ez paramez, es parames, int paramInt, byte paramByte) {
    if (parames == null || parames.c() <= 0)
      return; 
    if (paramInt > (ct.a[paramez.bx]).length - 1)
      return; 
    this.g = paramByte;
    this.i = paramez;
    bf bf = (bf)parames.a(0);
    this.j = ez.a(bf.a, bf.b);
    this.o = parames;
    if (this.i == null || this.i.cF == 4 || this.j == null || this.j.cF == 4) {
      paramez.cz = -1;
      paramez.cQ = -1;
      paramez.cR = null;
      return;
    } 
    if (paramez.cu == 9) {
      this.k = ct.a[6][paramInt];
    } else {
      this.k = ct.a[paramez.bx][paramInt];
    } 
    this.n = paramInt;
    paramez.cz = paramInt;
    this.l = ct.d[this.k];
    this.m = ct.e[this.k];
    if (paramez.bx == 3) {
      this.l /= 2;
      this.m /= 2;
    } 
    if (paramez == cn.f) {
      d(ct.b(paramInt));
      return;
    } 
    d(ct.c[this.k]);
  }
  
  private void d(int paramInt) {
    int i;
    if ((i = ez.c(this.i.aY, this.i.aZ, this.j.aY, this.j.aZ - this.j.be / 4)) <= paramInt || this.i.cu == 9) {
      this.i.bf = this.i.aY;
      this.i.bg = this.i.aZ;
      this.i.bb = 0;
      this.i.bc = 0;
      if (this.i.cu != 9) {
        this.i.t();
        this.i.dg.a(this.l);
        this.i.cz = -1;
        if (this.k == 53) {
          this.i.cG = 1;
        } else {
          this.i.cG = ct.a(this.i, this.j);
        } 
        g();
        return;
      } 
    } else {
      i = ak.a(this.i.aY - this.j.aY, this.i.aZ - this.j.aZ);
      byte b = 0;
      while (true) {
        int k = this.j.aY + ak.b(ak.d(i % 360)) * (paramInt - 5) / 1000;
        int m = this.j.aZ + ak.a(ak.d(i % 360)) * (paramInt - 5) / 1000;
        int j = ft.p.a(k, m);
        i += ak.g(90);
        if (++b > 12) {
          this.i.cN = null;
          ft.c(df.aR);
          this.i.cz = -1;
          this.i.cQ = -1;
          this.i.cR = null;
          f();
          return;
        } 
        if (j != -1 && j != 1) {
          if (this.i == cn.f) {
            this.i.bf = this.i.aY;
            this.i.bg = this.i.aZ;
            cn.f.cl = 0;
            cn.f.cm = 0;
            this.i.cN = ft.c.a(k / cs.l, m / cs.l, this.i.aY / cs.l, this.i.aZ / cs.l, 12);
            bq.O = -1;
            bq.P = -1;
            if (this.i.cN == null) {
              this.i.bf = k;
              this.i.bg = m;
              this.i.bl = k;
              this.i.bm = m;
              this.i.cN = null;
            } else if (this.i.cN.length > 12) {
              this.i.cN = null;
              ft.c(df.aR);
              f();
              this.i.cz = -1;
              this.i.cQ = -1;
              this.i.cR = null;
            } else {
              this.i.bl = k;
              this.i.bm = m;
              cn.f.cl = this.i.bl;
              cn.f.cm = this.i.bm;
            } 
            this.i.cI = 0;
          } else {
            this.i.bf = k;
            this.i.bl = k;
            this.i.bg = m;
            this.i.bm = m;
          } 
          if (this.i.cu == 1) {
            this.i.cQ = this.j.ct;
            return;
          } 
          this.i.cR = this.o;
          return;
        } 
      } 
    } 
  }
  
  private void f() {
    if (this.i == cn.f && bq.o == 1 && bq.X) {
      this.j.dy = true;
      this.i.bf = this.i.aY;
      this.i.bg = this.i.aZ;
      this.i.cl = bq.R;
      this.i.cm = bq.S;
      this.i.cN = ft.c.a(this.i.cl / cs.l, this.i.cm / cs.l, this.i.aY / cs.l, this.i.aZ / cs.l, 20);
      bq.O = -1;
      bq.P = -1;
      if (this.i.cN != null && this.i.cN.length > 20)
        this.i.cN = null; 
    } 
  }
  
  public final void b() {
    if (this.i == null || this.j == null) {
      this.i.cz = -1;
      this.i.cQ = -1;
      this.i.cR = null;
      return;
    } 
    this.i.bf = this.i.aY;
    this.i.bg = this.i.aZ;
    this.i.bb = 0;
    this.i.bc = 0;
    this.i.t();
    this.i.dg.a(this.l);
    this.i.cz = -1;
    if (this.k == 53) {
      this.i.cG = 1;
    } else {
      this.i.cG = ct.a(this.i, this.j);
    } 
    g();
  }
  
  public final void c() {
    if (this.i == null || this.j == null) {
      this.i.cz = -1;
      this.i.cQ = -1;
      this.i.cR = null;
      return;
    } 
    if (this.i.cu == 9) {
      if (this.g > -1) {
        cn.a(ct.f[this.k], this.i.ct, this.i.cu, this.o, (byte)ct.b[this.g][this.n], 500);
        s s;
        (s = (s)this.i).a((byte)4);
        return;
      } 
    } else if (this.i.cP == this.m) {
      ev ev = ct.c(this.n);
      long l;
      if (this.i == cn.f && (l = ft.aj - q) > p) {
        p = ev.j;
        q = ft.aj;
        dh dh1 = this;
        es es1 = cn.f.a(dh1.n, dh1.j);
        dh1.o = es1;
        if (dh1.g > -1) {
          es1 = es1;
          dh1 = dh1;
          q.a().a((byte)dh1.n, dh1.j.cu, es1);
        } else if (dh1.j.cu == 1) {
          q.a().a(es1, (byte)dh1.n);
        } else if (dh1.j.cu == 0) {
          q.a().b(es1, (byte)dh1.n);
        } 
      } 
      if (this.g > -1) {
        cn.a(ct.f[this.k], this.i.ct, this.i.cu, this.o, (byte)ct.b[this.g][this.n], 1250);
        return;
      } 
      cn.a(ct.f[this.k], this.i.ct, this.i.cu, this.o);
    } 
  }
  
  private void g() {
    if (this.i == cn.f)
      cn.f.d(this.k, this.n); 
    switch (this.k) {
      case 23:
      case 41:
        cn.a(29, this.i.ct, this.i.cu, this.o, 300, 0);
        return;
      case 22:
      case 36:
      case 44:
        cn.a(29, this.i.ct, this.i.cu, this.o, 300, 3);
        return;
      case 20:
      case 46:
        cn.a(29, this.i.ct, this.i.cu, this.o, 300, 4);
        return;
      case 18:
      case 19:
        cn.a(29, this.i.ct, this.i.cu, this.o, 300, 1);
        return;
      case 5:
      case 21:
        cn.a(29, this.i.ct, this.i.cu, this.o, 400, 0);
        return;
      case 27:
      case 37:
        cn.a(29, this.i.ct, this.i.cu, this.o, 400, 3);
        return;
      case 39:
      case 51:
        cn.a(29, this.i.ct, this.i.cu, this.o, 400, 4);
        return;
      case 24:
      case 40:
        cn.a(29, this.i.ct, this.i.cu, this.o, 400, 1);
        return;
      case 42:
      case 43:
        cn.a(29, this.i.ct, this.i.cu, this.o, 600, 0);
        return;
      case 14:
      case 34:
        cn.a(29, this.i.ct, this.i.cu, this.o, 600, 3);
        return;
      case 6:
      case 47:
      case 48:
        cn.a(29, this.i.ct, this.i.cu, this.o, 600, 4);
        return;
      case 49:
      case 50:
        cn.a(29, this.i.ct, this.i.cu, this.o, 400, 1);
        return;
      case 52:
        cn.a(29, this.i.ct, this.i.cu, this.o, 600, 1);
        return;
      case 53:
        cn.a(30, this.i.ct, this.i.cu, this.o, 600, 1);
        return;
      case 56:
      case 61:
      case 62:
      case 66:
        cn.a(29, this.i.ct, this.i.cu, this.o, 300, 4);
        return;
      case 54:
      case 58:
      case 64:
      case 68:
        cn.a(29, this.i.ct, this.i.cu, this.o, 600, 0);
        return;
      case 55:
      case 59:
      case 65:
      case 69:
        cn.a(29, this.i.ct, this.i.cu, this.o, 600, 3);
        return;
      case 57:
      case 60:
      case 63:
      case 67:
        cn.a(29, this.i.ct, this.i.cu, this.o, 400, 1);
        break;
    } 
  }
  
  public static void d() {
    r = System.currentTimeMillis();
  }
  
  public static boolean e() {
    long l1;
    long l2;
    return ((l2 = (l1 = System.currentTimeMillis()) - r) > h);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dh.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */