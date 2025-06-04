public final class dd extends bz {
  private int d;
  
  private int e;
  
  private int f;
  
  public int b;
  
  public int c;
  
  private ez g;
  
  private ab h = new ab();
  
  private ce i;
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short paramShort, ez paramez1, ez paramez2) {
    ez ez1 = paramez2;
    int i = paramez1.V();
    paramInt3 = paramInt3;
    paramInt2 = paramInt2;
    paramInt1 = paramInt1;
    ab ab1;
    (ab1 = this.h).e = paramInt2;
    ab1.f = paramInt3;
    ab1.h = ez1;
    ab1.k = false;
    switch (i) {
      case 0:
        ab1.a = 90;
        break;
      case 1:
        ab1.a = 270;
        break;
      case 2:
        ab1.a = 180;
        break;
      case 3:
        ab1.a = 0;
        break;
    } 
    ab1.d = 15360;
    ab1.i = 0;
    ab1.b = ab1.d * ak.b(ab1.a) >> 10;
    ab1.c = ab1.d * ak.a(ab1.a) >> 10;
    this.b = -1;
    this.c = -1;
    this.d = paramInt4;
    this.a = false;
    this.i = new ce(paramShort);
    this.g = paramez2;
  }
  
  public final void a() {
    ab ab1;
    if ((ab1 = this.h).h == null) {
      ab1.k = true;
    } else {
      int i = ab1.h.aY - ab1.e;
      int j = ab1.h.aZ - (ab1.h.U() >> 1) - ab1.f;
      ab1.i++;
      if (ak.e(i) < 16 && ak.e(j) < 16) {
        ab1.k = true;
      } else {
        int k;
        if (Math.abs((k = ak.a(i, j)) - ab1.a) < 90 || i * i + j * j > 4096)
          if (Math.abs(k - ab1.a) < 15) {
            ab1.a = k;
          } else if ((k - ab1.a >= 0 && k - ab1.a < 180) || k - ab1.a < -180) {
            ab1.a = ak.d(ab1.a + 15);
          } else {
            ab1.a = ak.d(ab1.a - 15);
          }  
        if (ab1.d < 8192)
          ab1.d = (short)(ab1.d + 1024); 
        ab1.b = ab1.d * ak.b(ab1.a) >> 10;
        ab1.c = ab1.d * ak.a(ab1.a) >> 10;
        i = (i += ab1.b) >> 10;
        ab1.e += i;
        j = (j += ab1.c) >> 10;
        ab1.f += j;
        ab1.g = ch.a(ak.a(i, -j));
        ab1.j = ch.b[ab1.g];
      } 
    } 
    this.e = this.h.e;
    this.f = this.h.f;
    if (this.b != -1) {
      cx cx;
      br.a(cx = new cx(57, this.b, this.e, this.f));
    } 
    if (this.h.k) {
      dd dd1;
      if ((dd1 = this).c != -1) {
        if (dd1.d < 0)
          cn.a(dd1.d, dd1.g.aY, dd1.g.aZ - dd1.g.be, 2, dd1.g.ct); 
        if (dd1.d > 0)
          cn.a("+" + dd1.d, dd1.g.aY, dd1.g.aZ - dd1.g.be, 0, dd1.g.ct); 
        cn.a(57, dd1.c, dd1.e, dd1.f);
      } 
      dd1.a = true;
    } 
  }
  
  public final void a(bx parambx) {
    if (this.i != null)
      this.i.c(0, this.e, this.f, this.h.j, 3, parambx); 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\dd.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */