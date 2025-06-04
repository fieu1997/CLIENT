public final class ce {
  public int a;
  
  public int b;
  
  public int c;
  
  public aq d;
  
  private int e = -1;
  
  private int f;
  
  private static ek g = new ek();
  
  public ce(aq paramaq, int paramInt1, int paramInt2) {
    if (paramaq != null) {
      this.d = paramaq;
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = aq.b(paramaq.a) / paramInt2;
    } 
  }
  
  public final int a() {
    return this.c;
  }
  
  public ce(int paramInt) {
    this.e = paramInt;
    aq aq1;
    if ((aq1 = ay.a(paramInt)) != null)
      this.d = aq1; 
    this.a = i.a[paramInt][0];
    this.b = i.a[paramInt][1];
    this.c = i.a[paramInt][2];
  }
  
  public static ce a(short paramShort, int paramInt1, int paramInt2, int paramInt3) {
    ce ce1;
    if ((ce1 = (ce)g.a(paramShort)) == null) {
      ce1 = new ce(paramShort, 3, 5, 0);
      g.a(paramShort, ce1);
    } else if (ce1.d == null) {
      fd fd;
      if ((fd = bk.n(paramShort)) != null && fd.a != null) {
        ce1.d = fd.a;
        ce1.f = 5;
        ce1.a = aq.a(ce1.d.a) / 3;
        ce1.b = aq.b(ce1.d.a) / 5;
        if (ce1.d != null || ce1.d.a != null)
          ce1.c = 15; 
      } 
    } else {
      ce1.f = 5;
      ce1.a = aq.a(ce1.d.a) / 3;
      ce1.b = aq.b(ce1.d.a) / 5;
      if (ce1.d != null || ce1.d.a != null)
        ce1.c = 15; 
    } 
    return ce1;
  }
  
  private ce(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.e = paramInt1;
    this.f = paramInt3;
    fd fd;
    if ((fd = bk.n((short)paramInt1)) != null && fd.a != null) {
      this.d = fd.a;
      this.a = aq.a(this.d.a) / paramInt2;
      this.b = aq.b(this.d.a) / paramInt3;
      if (this.d != null || this.d.a != null)
        this.c = paramInt2 * paramInt3 - paramInt4; 
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bx parambx) {
    if (paramInt1 >= 0 && paramInt1 < this.c)
      try {
        paramInt5 = 0;
        int i = 0;
        paramInt5 = paramInt1 / this.f * this.a;
        i = paramInt1 % this.f * this.b;
        parambx.a(this.d, paramInt5, i, this.a, this.b, paramInt4, paramInt2, paramInt3, 33);
        return;
      } catch (Exception exception) {} 
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bx parambx) {
    aq aq1;
    if (this.d == null || this.d.a == null) {
      if ((aq1 = ay.a(this.e)) != null)
        this.d = aq1; 
      if (aq1.a != null) {
        this.c = aq.b(this.d.a) / this.b;
        return;
      } 
    } else if (aq1 >= null && aq1 < this.c && this.d != null && this.d.a != null) {
      parambx.a(this.d, 0, aq1 * this.b, this.a, this.b, paramInt4, paramInt2, paramInt3, paramInt5);
    } 
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bx parambx) {
    aq aq1;
    if ((aq1 = ay.a(this.e)) != null && aq1.a != null) {
      if (paramInt1 > this.c)
        paramInt1 = this.c; 
      if ((paramInt1 *= this.b) > this.b * (this.c - 1) || paramInt1 < 0)
        paramInt1 = this.b * (this.c - 1); 
      parambx.a(aq1, 0, paramInt1, this.a, this.b, paramInt4, paramInt2, paramInt3, paramInt5);
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bx parambx) {
    aq aq1;
    if ((aq1 = ay.a(this.e)) != null && aq1.a != null) {
      if (paramInt1 > this.c)
        paramInt1 = this.c; 
      if ((paramInt1 *= this.b) > this.b * (this.c - 1) || paramInt1 < 0)
        paramInt1 = this.b * (this.c - 1); 
      parambx.a(aq1, 0, paramInt1, this.a, this.b, 0, paramInt2, paramInt3, 0);
    } 
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bx parambx) {
    aq aq1;
    if (this.d == null || this.d.a == null) {
      if ((aq1 = ay.a(this.e)) != null)
        this.d = aq1; 
      if (this.d.a != null) {
        this.c = aq.b(this.d.a) / this.b;
        return;
      } 
    } else if (aq1 >= null && aq1 < this.c && this.d.a != null) {
      parambx.a(this.d, 0, aq1 * this.b, this.a, this.b, 0, paramInt2, paramInt3, 0);
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ce.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */