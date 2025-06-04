public final class bn extends dx {
  private String a;
  
  private int b;
  
  private int c;
  
  private o z;
  
  private boolean A = false;
  
  public bn(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    this.A = false;
    this.a = paramString;
    this.g = paramInt1;
    this.h = paramInt2 + ak.g(5);
    this.b = paramInt3;
    this.z = o.f;
    if (this.b < 0) {
      this.z = fl.b(-paramInt3);
    } else {
      switch (paramInt3) {
        case 1:
          this.z = o.o;
          break;
        case 2:
        case 6:
        case 7:
        case 9:
          this.A = true;
          break;
        case 5:
          this.z = o.j;
          break;
        case 8:
          this.z = fl.a(paramInt3);
          break;
        case 10:
          this.z = o.d;
          break;
        case 11:
          this.z = o.e;
          break;
      } 
    } 
    if (this.A) {
      this.p = -ak.c(11, 14);
      this.c = ak.c(20, 25);
      return;
    } 
    this.p = -ak.c(2, 4);
    this.c = ak.c(24, 32);
  }
  
  public bn(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a = paramString;
    this.g = paramInt1;
    this.h = paramInt2 + ak.g(5);
    this.b = paramInt3;
    this.z = o.f;
    this.p = -ak.c(11, 14);
    this.A = true;
    this.c = ak.c(20, 25);
    if (this.b < 0) {
      this.z = fl.b(-paramInt4);
      return;
    } 
    switch (paramInt3) {
      case 8:
        this.z = fl.a(paramInt4);
        break;
    } 
  }
  
  public final void a(bx parambx) {
    switch (this.b) {
      case 2:
        cg.a(parambx, this.a, this.g, this.h, 2);
        return;
      case 6:
        cg.a(parambx, this.a, this.g, this.h, 2, (byte)4);
        return;
      case 7:
        cg.a(parambx, this.a, this.g, this.h, 2, (byte)2);
        return;
      case 4:
        cg.a(parambx, this.a, this.g, this.h, 2, (byte)1);
        return;
      case 3:
        cg.a(parambx, this.a, this.g, this.h, 2, (byte)5);
        return;
      case 1:
      case 5:
        this.z.a(parambx, this.a, this.g, this.h, 2, false);
        return;
      case 9:
        cg.a(parambx, this.a, this.g, this.h, 2, (byte)6);
        return;
    } 
    this.z.a(parambx, this.a, this.g, this.h, 2, false);
  }
  
  public final void a() {
    this.k++;
    if (this.A)
      this.p++; 
    super.a();
    if (this.k >= this.c)
      this.y = true; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bn.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */