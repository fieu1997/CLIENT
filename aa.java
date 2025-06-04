public final class aa {
  private byte a;
  
  private byte b;
  
  private byte c;
  
  private byte d;
  
  private int e;
  
  private byte f;
  
  private int g;
  
  private int h;
  
  private long i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private static byte[][] m = new byte[][] { { 
        0, 1, 2, 3, 4, 3, 2, 1, 1, 2, 
        3, 4, 3, 2, 1, 1, 2, 3, 4, 3, 
        2, 1, 1, 2, 3, 4 }, { 
        0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 
        3, 3, 1, 1, 1, 2, 2, 2, 3, 3, 
        3 }, { 
        0, 0, 1, 1, 2, 2, 1, 3, 3, 3, 
        1, 1, 2, 2, 1, 3, 3, 3 } };
  
  private int n;
  
  public aa(byte paramByte, int paramInt) {
    this.e = paramInt;
    this.f = paramByte;
    this.i = dw.a();
    switch (this.f) {
      case 0:
        this.k = 5;
        this.l = -25;
        this.j = 1;
        return;
      case 1:
        this.k = 0;
        this.l = -12;
        this.j = 2;
        return;
      case 2:
        this.k = 5;
        this.l = 0;
        this.j = 3;
        break;
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    aq aq;
    if ((aq = ay.a(this.e)) != null && aq.a != null) {
      if (this.g == 0 || this.h == 0) {
        this.g = i.a[this.e][0];
        this.h = i.a[this.e][1];
      } 
      if (this.i - dw.a() < 0L)
        switch (this.f) {
          case 0:
            if (this.n == 0) {
              parambx.a(aq, 0, this.c * this.h, this.g, this.h, 0, paramInt1 + this.k, paramInt2 + this.l, 3);
              return;
            } 
            parambx.a(aq, 0, this.d * this.h, this.g, this.h, 0, paramInt1 - this.k, paramInt2 + this.l, 3);
            return;
          case 1:
            parambx.a(aq, 0, this.c * this.h, this.g, this.h, 0, paramInt1 + this.k, paramInt2 + this.l, 3);
            return;
          case 2:
            parambx.a(aq, 0, this.c * this.h, this.g, this.h, 0, paramInt1 + this.k, paramInt2 + this.l, 3);
            parambx.a(aq, 0, this.d * this.h, this.g, this.h, 0, paramInt1 - this.k, paramInt2 + this.l, 3);
            break;
        }  
    } 
  }
  
  public final void a() {
    if (this.i - dw.a() < 0L)
      switch (this.f) {
        case 0:
          if (ft.ai % 2 == 0)
            this.a = (byte)(this.a + 1); 
          if (this.a > (m[this.f]).length - 1) {
            this.a = 0;
            this.j = ak.f(10);
            this.i = (this.j * 1000) + dw.a();
            if (this.j % 2 == 0) {
              this.n = 0;
            } else {
              this.n = 1;
            } 
          } 
          this.c = m[this.f][this.a];
          if (ft.ai % 4 == 0)
            this.b = (byte)(this.b + 1); 
          if (this.b > (m[this.f]).length - 1)
            this.b = 0; 
          this.d = m[this.f][this.b];
          return;
        case 1:
          this.a = (byte)(this.a + 1);
          if (this.a > (m[this.f]).length - 1) {
            this.a = 0;
            this.j = ak.f(10);
            this.i = (this.j * 1000) + dw.a();
          } 
          this.c = m[this.f][this.a];
          return;
        case 2:
          if (ft.ai % 2 == 0)
            this.a = (byte)(this.a + 1); 
          if (this.a > (m[this.f]).length - 1) {
            this.a = 0;
            this.j = ak.f(10);
            this.i = (this.j * 1000) + dw.a();
          } 
          this.c = m[this.f][this.a];
          if (ft.ai % 3 == 0)
            this.b = (byte)(this.b + 1); 
          if (this.b > (m[this.f]).length - 1)
            this.b = 0; 
          this.d = m[this.f][this.b];
          break;
      }  
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\aa.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */