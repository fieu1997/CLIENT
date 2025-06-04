public final class dz {
  private byte b;
  
  private byte[] c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private en[] q;
  
  private aq[] r;
  
  private aq[] s;
  
  private int t;
  
  public int a;
  
  public final void a(byte paramByte, short paramShort) {
    this.b = paramByte;
    this.l = paramShort;
    if (ft.B) {
      this.t = -9784873;
      this.a = -9784873;
      return;
    } 
    switch (this.b) {
      case 1:
        this.d = 256;
        this.f = ft.p.e * cs.l / this.d + 1;
        this.t = -8725531;
        this.a = -8725531;
        this.h = 92;
        this.i = 85;
        this.j = 110;
        this.m = this.l - this.h + this.i + this.j;
        this.k = ft.W / this.d + 1;
        this.r = new aq[3];
        this.r[0] = aq.a("/bg/bg1_0.img");
        this.r[1] = aq.a("/bg/bg1_1.img");
        this.r[2] = aq.a("/bg/bg1_2.img");
        this.n = (this.m + 30) / 2;
        break;
      case 2:
        this.d = 120;
        this.f = ft.p.e * cs.l / this.d + 1;
        this.t = -10836481;
        this.a = -11759720;
        this.h = 72;
        this.i = 28;
        this.j = 77;
        this.m = this.l - this.h + this.i + this.j;
        this.k = ft.W / this.d + 1;
        this.r = new aq[5];
        this.r[0] = aq.a("/bg/bg2_0.img");
        this.r[1] = aq.a("/bg/bg2_1.img");
        this.r[2] = aq.a("/bg/bg2_20.img");
        this.r[3] = aq.a("/bg/bg2_21.img");
        this.r[4] = aq.a("/bg/bg2_22.img");
        this.c = new byte[this.f];
        for (paramByte = 0; paramByte < this.f; paramByte++)
          this.c[paramByte] = (byte)ak.f(3); 
        this.n = 25;
        break;
      case 3:
        this.d = 253;
        this.e = 96;
        this.f = ft.p.e * cs.l / this.d + 1;
        this.g = ft.p.e * cs.l / this.e + 1;
        this.t = -9784873;
        this.a = -9784873;
        this.h = 108;
        this.i = 72;
        this.p = (this.l - 120) / this.i;
        if (this.p > 5)
          this.p = 5; 
        this.m = this.l - this.h + this.i * this.p;
        this.k = ft.W / this.d + 1;
        this.o = ft.W / this.e + 1;
        this.r = new aq[2];
        this.r[0] = aq.a("/bg/bg3_0.img");
        this.r[1] = aq.a("/bg/bg3_1.img");
        this.n = (this.m + 30) / 2;
        break;
    } 
    this.q = new en[ft.p.e * cs.l / 250 + 1];
    for (paramByte = 0; paramByte < this.q.length; paramByte++) {
      this.q[paramByte] = new en();
      (this.q[paramByte]).a = 125 + ak.g(125) + paramByte * 250;
      (this.q[paramByte]).b = this.n + ak.g(this.n);
      (this.q[paramByte]).i = -ak.c(1, 3);
      (this.q[paramByte]).p = ak.c(0, 2);
    } 
    this.s = new aq[2];
    this.s[0] = aq.a("/bg/may0.img");
    this.s[1] = aq.a("/bg/may1.img");
  }
  
  public final void a(bx parambx) {
    if (ft.B) {
      if (p.d.b <= this.l) {
        parambx.a(this.t);
        parambx.c(p.d.a, p.d.b, ft.W, ft.X);
      } 
      return;
    } 
    int i = 0;
    i = 0;
    int j = 0;
    j = 0;
    switch (this.b) {
      case 1:
        if ((j = (i = p.d.a / this.d) + this.k + 1) > this.f)
          j = this.f; 
        if (p.d.b <= this.m) {
          parambx.a(this.t);
          parambx.c(p.d.a, p.d.b, ft.W, this.m);
        } 
        for (i = i; i < j; i++) {
          if (p.d.b <= this.h + this.m)
            parambx.a(this.r[0], i * this.d, this.m, 0); 
          if (p.d.b <= this.i + this.h + this.m)
            parambx.a(this.r[1], i * this.d, this.h + this.m, 0); 
          if (p.d.b <= this.i + this.h + this.j + this.m)
            parambx.a(this.r[2], i * this.d, this.h + this.i + this.m, 0); 
        } 
        break;
      case 2:
        if ((i = p.d.a / this.d) < 0)
          i = 0; 
        if ((j = i + this.k + 1) > this.f)
          j = this.f; 
        if (p.d.b <= this.m) {
          parambx.a(this.t);
          parambx.c(p.d.a, p.d.b, ft.W, this.m);
        } 
        for (i = i; i < j; i++) {
          if (p.d.b <= this.h + this.m)
            parambx.a(this.r[0], i * this.d, this.m, 0); 
          if (p.d.b <= this.i + this.h + this.m)
            parambx.a(this.r[1], i * this.d, this.h + this.m, 0); 
          if (p.d.b <= this.i + this.h + this.j + this.m)
            parambx.a(this.r[2 + this.c[i]], i * this.d, this.h + this.i + this.m, 0); 
        } 
        break;
      case 3:
        if (p.d.b <= this.m) {
          parambx.a(this.t);
          parambx.c(p.d.a, p.d.b, ft.W, this.m);
        } 
        if ((i = p.d.a / this.e) < 0)
          i = 0; 
        if ((j = i + this.o + 1) > this.g)
          j = this.g; 
        for (i = i; i < j; i++) {
          for (byte b = 0; b < this.p; b++)
            parambx.a(this.r[1], i * this.e, this.m + this.h + b * this.i, 0); 
        } 
        if ((i = p.d.a / this.d) < 0)
          i = 0; 
        if ((j = i + this.k + 1) > this.f)
          j = this.f; 
        for (i = i; i < j; i++) {
          if (p.d.b <= this.h + this.m)
            parambx.a(this.r[0], i * this.d, this.m, 0); 
        } 
        break;
    } 
    for (i = 0; i < this.q.length; i++) {
      if (p.d.b - 10 <= (this.q[i]).b)
        parambx.a(this.s[(this.q[i]).p], (this.q[i]).a, (this.q[i]).b, 6); 
    } 
  }
  
  public final void a() {
    if (ft.B)
      return; 
    for (byte b = 0; b < this.q.length; b++) {
      (this.q[b]).a += (this.q[b]).i;
      if ((this.q[b]).a < -80) {
        (this.q[b]).a = ft.p.e * cs.l + ak.g(125);
        (this.q[b]).b = this.n + ak.g(this.n);
        (this.q[b]).i = -ak.c(1, 3);
        (this.q[b]).p = ak.c(0, 2);
      } 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dz.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */