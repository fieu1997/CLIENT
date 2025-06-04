public final class ei {
  long a;
  
  boolean b = false;
  
  private boolean o = false;
  
  private int p;
  
  private int q;
  
  int c;
  
  int d;
  
  int e;
  
  private int r;
  
  long f;
  
  public boolean g = false;
  
  public int h;
  
  public int i;
  
  public byte[] j = new byte[] { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
  
  public byte k;
  
  public cz[] l = null;
  
  public cz[] m = null;
  
  private ce s;
  
  es n = new es("MainBuff VecEff");
  
  public ei(int paramInt1, int paramInt2) {
    this.h = paramInt1;
    this.f = dw.a() + (paramInt2 * 1000);
    switch (this.h) {
      case 11:
        this.s = new ce(149);
        return;
      case 12:
        this.s = new ce(147);
        return;
      case 13:
        this.s = new ce(146);
        return;
      case 14:
        this.s = new ce(148);
        break;
    } 
  }
  
  public ei(int paramInt1, int paramInt2, int paramInt3) {
    this.h = paramInt1;
    this.i = paramInt3;
    this.a = ft.aj;
    this.e = paramInt2;
    this.p = 0;
    this.q = 0;
    this.r = ak.f(9);
    switch (paramInt1) {
      case 0:
      case 2:
      case 5:
      case 7:
        this.s = new ce(88);
        return;
      case 1:
      case 3:
      case 6:
      case 8:
        this.s = new ce(89);
        return;
      case 9:
        this.b = true;
        return;
      case 4:
        this.b = true;
        if (paramInt3 == 3) {
          this.s = new ce(81);
          this.r = 0;
        } else {
          this.s = new ce(80);
          this.r = paramInt3;
          if (paramInt3 > 3)
            this.r--; 
        } 
        for (paramInt1 = 0; paramInt1 < 3; paramInt1++) {
          en en;
          (en = new en()).a = ak.g(16);
          en.b = ak.g(10);
          if (paramInt3 == 3) {
            en.i = ak.g(3);
            en.j = ak.g(2);
          } 
          this.n.a(en);
        } 
        return;
    } 
    this.g = true;
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    int i;
    if (this.g)
      return; 
    switch (this.h) {
      case 0:
      case 1:
      case 5:
      case 6:
      case 10:
        if (this.s == null)
          return; 
        this.s.c(2 - (ft.ai + this.r) / 3 % this.s.c, paramInt1, paramInt2, 0, 3, parambx);
        return;
      case 2:
      case 3:
      case 7:
      case 8:
        if (this.s == null)
          return; 
        this.s.c((ft.ai + this.r) / 3 % this.s.c, paramInt1, paramInt2, 0, 3, parambx);
        return;
      case 4:
        if (this.s == null || this.n == null)
          return; 
        for (i = 0; i < this.n.c(); i++) {
          en en;
          if ((en = (en)this.n.a(i)) != null)
            this.s.c(this.r * 3 + en.n % this.s.c, paramInt1 + en.a, paramInt2 + en.b, 0, 3, parambx); 
        } 
        return;
      case 9:
        for (i = this.n.c() - 1; i >= 0; i--) {
          ej ej;
          if ((ej = (ej)this.n.a(i)) != null) {
            int j = 0;
            j = i.c[0][ej.i];
            parambx.a(j);
            parambx.a(ej.a, ej.b, ej.c, ej.d);
            if (ej.j)
              parambx.a(ej.a + 1, ej.b, ej.c + 1, ej.d); 
          } 
        } 
        this.c = paramInt1;
        this.d = paramInt2;
        return;
      case 11:
      case 12:
      case 13:
      case 14:
        if (this.s != null)
          this.s.c(this.j[this.k], paramInt1, paramInt2 - 2, 0, 3, parambx); 
        break;
    } 
  }
  
  public static void a(int paramInt1, int paramInt2, ez paramez) {
    for (byte b = 0; b < paramez.df.c(); b++) {
      ei ei1;
      if ((ei1 = (ei)paramez.df.a(b)).h == 4 && ei1.i == paramInt1) {
        ei1.a = ft.aj;
        ei1.e = paramInt2 * 1000;
        return;
      } 
    } 
    paramez.b(4, paramInt2 * 1000, paramInt1);
  }
  
  public static ei a(int paramInt1, int paramInt2) {
    for (byte b = 0; b < cn.f.df.c(); b++) {
      ei ei1;
      if ((ei1 = (ei)cn.f.df.a(b)).h == paramInt1 && ei1.i == paramInt2)
        return ei1; 
    } 
    return null;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ei.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */