public final class bj {
  public static es a = new es("EffectMonster listEffectMonster");
  
  private ce c;
  
  private ce d;
  
  private boolean e = true;
  
  private boolean f = false;
  
  private boolean g = true;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private ez u;
  
  private byte[] v = new byte[] { 0, 0, 1, 1, 2, 2, 3, 3 };
  
  private byte[] w = new byte[8];
  
  public static boolean b = false;
  
  public static void a(au paramau) {
    bj bj1;
    (bj1 = new bj()).o = paramau.B;
    bj1.u = paramau;
    if (bj1.u.q_()) {
      if (bj1.o == 89) {
        bj1.c = new ce(aq.a("/eff/g128.png"), 53, 49);
        bj1.d = v.b[0];
        bj1.l = -3;
        bj1.m = 70;
        bj1.s = 0;
        bj1.t = -bj1.d.b - 2;
      } else if (bj1.o == 90) {
        bj1.c = new ce(aq.a("/eff/g129.png"), 44, 44);
        bj1.d = v.b[1];
        bj1.l = 0;
        bj1.m = 30;
        bj1.s = 0;
        bj1.t = -bj1.d.b;
      } else if (bj1.o == 91) {
        bj1.c = new ce(aq.a("/eff/g130.png"), 50, 51);
        bj1.d = v.b[2];
        bj1.l = 0;
        bj1.m = 20;
        bj1.s = 5;
        bj1.t = -bj1.d.b;
      } else if (bj1.o == 92) {
        bj1.c = new ce(aq.a("/eff/g131.png"), 40, 40);
        bj1.d = v.b[3];
        bj1.l = 22;
        bj1.m = 22;
        bj1.s = 5;
        bj1.t = -bj1.d.b;
      } 
      bj1.h = paramau.aY;
      bj1.i = paramau.aZ;
      bj1.j = bj1.k = -1;
      bj1.k = paramau.be;
      bj1.p = bj1.c.a;
      bj1.q = bj1.c.b;
      bj1.e = true;
      bj1.f = true;
      bj1.g = false;
      bj1.n = 0;
      bj1.r = 0;
      a.a(bj1);
    } 
  }
  
  private void b() {
    if (this.g)
      this.e = false; 
    if (!this.g)
      this.g = true; 
  }
  
  public final void a() {
    if (this.f) {
      if (b) {
        (new byte[8])[2] = 1;
        (new byte[8])[3] = 1;
        (new byte[8])[4] = 2;
        (new byte[8])[5] = 2;
        (new byte[8])[6] = 3;
        (new byte[8])[7] = 3;
        if (this.v != new byte[8])
          this.v = new byte[] { 0, 0, 1, 1, 2, 2, 3, 3 }; 
      } else {
        (new byte[12])[3] = 1;
        (new byte[12])[4] = 1;
        (new byte[12])[5] = 1;
        (new byte[12])[6] = 2;
        (new byte[12])[7] = 2;
        (new byte[12])[8] = 2;
        (new byte[12])[9] = 3;
        (new byte[12])[10] = 3;
        (new byte[12])[11] = 3;
        if (this.v != new byte[12])
          this.v = new byte[] { 
              0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 
              3, 3 }; 
      } 
      if (this.u.br > 0) {
        this.n++;
        if (this.n > this.v.length - 1)
          this.n = 0; 
        this.h = this.u.aY;
        this.i = this.u.aZ;
      } else {
        b();
      } 
      if (cn.U != 0L && dw.a() - cn.U > 2700000L)
        b(); 
    } 
  }
  
  public final void a(bx parambx) {
    try {
      if (this.e && this.c != null) {
        if (this.j < 0) {
          this.j = this.u.bd;
          this.k = this.u.be;
        } 
        this.c.b(this.v[this.n], this.h - this.p / 2 + this.l, this.i - this.k - this.q + this.m, 0, parambx);
        return;
      } 
    } catch (Exception exception) {
      this.e = false;
      this.f = false;
      this.g = false;
    } 
  }
  
  public final void b(bx parambx) {
    try {
      if (this.g && this.d != null) {
        if (this.j < 0) {
          this.j = this.u.bd;
          this.k = this.u.be;
        } 
        this.d.b(this.w[0], this.h - this.j / 2 + this.s, this.i + this.t, 0, parambx);
        return;
      } 
    } catch (Exception exception) {
      this.e = false;
      this.f = false;
      this.g = false;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bj.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */