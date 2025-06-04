public final class bt {
  public String a;
  
  private String m = "";
  
  public String[] b;
  
  public dk c;
  
  public cg d;
  
  public byte e;
  
  public byte f = -1;
  
  public boolean g = false;
  
  private int n;
  
  private int o;
  
  private ce p;
  
  private ce q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private int v;
  
  public int h = -1;
  
  public int i = -1;
  
  private int w;
  
  private int x;
  
  private int y;
  
  public static int j = 70;
  
  public static int k = 24;
  
  public int l = 0;
  
  private Object z;
  
  private boolean A = false;
  
  public bt(String paramString, dk paramdk) {
    this.a = paramString;
    this.c = null;
  }
  
  public bt(String paramString, int paramInt) {
    this.a = paramString;
    this.e = (byte)paramInt;
  }
  
  public bt(String paramString, int paramInt, cg paramcg) {
    this.a = paramString;
    this.e = (byte)paramInt;
    this.d = paramcg;
  }
  
  public bt(String paramString, int paramInt1, int paramInt2, cg paramcg) {
    this.a = paramString;
    this.e = (byte)paramInt1;
    this.f = (byte)paramInt2;
    this.d = paramcg;
  }
  
  public bt(String paramString, int paramInt, Object paramObject, cg paramcg) {
    this.a = paramString;
    this.e = 43;
    this.d = paramcg;
    this.z = paramObject;
  }
  
  public final void a(ce paramce) {
    this.p = paramce;
    this.r = this.p.a;
    this.s = this.p.b;
    this.n = this.p.c;
    this.o = 0;
    if (ft.C) {
      this.t = o.j.a(this.a);
      return;
    } 
    this.t = o.f.a(this.a);
  }
  
  public final void a(ce paramce, int paramInt1, int paramInt2) {
    this.p = paramce;
    this.r = this.p.a;
    this.s = this.p.b;
    this.n = paramInt1;
    this.o = paramInt2;
    if (ft.C) {
      this.t = o.j.a(this.a);
      return;
    } 
    this.t = o.f.a(this.a);
  }
  
  public final void a(int paramInt1, int paramInt2, ce paramce, String paramString) {
    this.a = paramString;
    this.h = paramInt1;
    this.i = paramInt2;
    this.q = paramce;
    if (this.q != null) {
      this.u = this.q.a;
      this.v = this.q.b;
      if (this.u < 28)
        this.u = 28; 
      if (this.v < 28) {
        this.v = 28;
        return;
      } 
    } else {
      this.u = 70;
      this.v = k;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, ce paramce, String paramString, int paramInt3, int paramInt4) {
    this.A = true;
    this.a = paramString;
    this.h = paramInt1;
    this.i = paramInt2;
    this.q = null;
    if (this.q != null) {
      this.u = this.q.a;
      this.v = this.q.b;
      if (this.u < 28)
        this.u = 28; 
      if (this.v < 28) {
        this.v = 28;
        return;
      } 
    } else {
      this.u = paramInt3;
      this.v = paramInt4;
    } 
  }
  
  public final void b(int paramInt1, int paramInt2, ce paramce, String paramString, int paramInt3, int paramInt4) {
    this.a = "";
    this.m = paramString;
    this.h = paramInt1;
    this.i = paramInt2;
    this.x = 0;
    this.y = -32;
    this.q = paramce;
    if (this.q != null) {
      this.u = this.q.a;
      this.v = this.q.b;
      if (this.u < 28)
        this.u = 28; 
      if (this.v < 28) {
        this.v = 28;
        return;
      } 
    } else {
      this.u = 70;
      this.v = k;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public final void a() {
    eh eh;
    if (ft.o.a && (ft.o.b == null || (!((eh = ft.o.b).b < eh.a.length))))
      ft.o.f(); 
    if (this.c == null)
      if (this.d != null) {
        if (this.z != null) {
          this.d.a(this.e, this.z);
        } else {
          this.d.a(this.e, this.f);
        } 
      } else {
        if (ft.r != null) {
          ft.r.b(this.e, this.f);
          ft.S = false;
          ft.m();
          ft.l();
          return;
        } 
        if (d.b) {
          d.b().b(this.e, this.f);
          return;
        } 
        if (ft.o.a) {
          ft.a.a_(this.e, this.f);
          return;
        } 
        if (ft.s != null) {
          ft.s.b(this.e, this.f);
          return;
        } 
        ft.a.b(this.e, this.f);
        return;
      }  
    ft.S = false;
    ft.m();
    ft.l();
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    if (c()) {
      if (this.q != null) {
        this.q.b(this.w, this.h, this.i, 0, 3, parambx);
      } else {
        b(parambx, this.h, this.i);
      } 
      a(parambx, this.h, this.i - 6, 2);
      return;
    } 
    if (this.q != null) {
      this.q.b(this.w, paramInt1, paramInt2, 0, 3, parambx);
    } else {
      b(parambx, paramInt1, paramInt2);
    } 
    a(parambx, paramInt1, paramInt2 - 6, 2);
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3) {
    if (this.a == null)
      return; 
    paramInt3 = 0;
    if (this.p != null) {
      this.p.b(this.o + ft.ai / 2 % this.n, paramInt1 - this.r / 2 - this.t / 2, paramInt2 + this.s / 2 - 3, 0, 3, parambx);
      paramInt3 = this.r / 2;
    } 
    if (!this.A) {
      if (ft.C) {
        o.j.a(parambx, this.a, paramInt1 + paramInt3, paramInt2, 2, false);
        return;
      } 
      cg.a(parambx, this.a, paramInt1 + paramInt3, paramInt2, 2, (byte)0);
      return;
    } 
    if (ft.C) {
      o.j.a(parambx, this.a, paramInt1 + paramInt3 + this.u / 2, paramInt2 + this.v / 2 + 1, 2, false);
      return;
    } 
    cg.a(parambx, this.a, paramInt1 + paramInt3 + this.u / 2, paramInt2 + this.v / 2 + 1, 2, (byte)0);
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2, int paramInt3) {
    if (this.w == 1 && this.m.length() > 0)
      cg.a(parambx, this.m, paramInt1 + this.x, paramInt2 + this.y, 2, (byte)0); 
  }
  
  public final void c(bx parambx, int paramInt1, int paramInt2, int paramInt3) {
    int i = 0;
    if (this.p != null)
      if (paramInt3 == 2) {
        this.p.b(this.o + ft.ai / 2 % this.n, paramInt1 - this.r / 2 - this.t / 2, paramInt2 + this.s / 2, 0, 3, parambx);
        i = this.r / 2;
      } else if (paramInt3 == 0) {
        this.p.b(this.o + ft.ai / 2 % this.n, paramInt1 + this.r / 2, paramInt2 + this.s / 2, 0, 3, parambx);
        i = this.r + 6;
      }  
    if (ft.C) {
      o.j.a(parambx, this.a, paramInt1 + i, paramInt2, paramInt3, false);
      return;
    } 
    cg.a(parambx, this.a, paramInt1 + i, paramInt2, paramInt3, (byte)7, (byte)0);
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.p != null) {
      if ((paramInt3 = (this.o + this.w == 1) ? 1 : 0) > this.n)
        paramInt3 = this.o - 1; 
      this.p.b(paramInt3, paramInt1, paramInt2 + this.s / 2, 0, 3, parambx);
    } 
  }
  
  public final void b() {
    if (!this.A) {
      if (c()) {
        if (ft.Q || ft.T) {
          if (ft.c(this.h - this.u / 2 - 5, this.i - this.v / 2 - 5, this.u + 10, this.v + 10)) {
            this.w = 1;
          } else {
            this.w = 0;
          } 
        } else {
          this.w = 0;
        } 
        if (ft.b(this.h - this.u / 2 - 5, this.i - this.v / 2 - 5, this.u + 10, this.v + 10)) {
          a();
          ft.S = false;
          this.w = 0;
          return;
        } 
      } 
    } else if (c()) {
      if (ft.Q || ft.T) {
        if (ft.c(this.h - 5, this.i - 5, this.u + 10, this.v + 10)) {
          this.g = true;
          this.w = 1;
        } else {
          this.w = 0;
          this.g = false;
        } 
      } else {
        this.w = 0;
        this.g = false;
      } 
      if (ft.b(this.h - 5, this.i - 5, this.u + 10, this.v + 10)) {
        a();
        ft.S = false;
        this.w = 0;
        this.g = false;
      } 
    } 
  }
  
  public final void b(int paramInt1, int paramInt2) {
    if (c()) {
      if (ft.Q || ft.T) {
        if (ft.c(this.h - this.u / 2 - 3 - paramInt1, this.i - this.v / 2 - 3, this.u + 6, this.v + 6)) {
          this.w = 1;
          return;
        } 
        this.w = 0;
        return;
      } 
      this.w = 0;
    } 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2) {
    if (ft.A) {
      if (!this.A) {
        cf.r.b(this.w, paramInt1, paramInt2, 0, 3, parambx);
        return;
      } 
      cg.a(parambx, paramInt1, paramInt2, this.u, this.v, this.g ? 1 : 2);
      return;
    } 
    if (!this.A) {
      cg.a(parambx, paramInt1 - j / 2, paramInt2 - k / 2, j, k, this.g ? 1 : 2);
      return;
    } 
    cg.a(parambx, paramInt1, paramInt2, this.u, this.v, this.g ? 1 : 2);
  }
  
  public final boolean c() {
    return (this.h > 0 && this.i > 0);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bt.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */