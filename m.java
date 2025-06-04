public final class m extends fl {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e = 20;
  
  private int f = 0;
  
  private int g = 30;
  
  private bt h;
  
  private bt i;
  
  private bt j;
  
  private bt k;
  
  private int l = 0;
  
  private dy m;
  
  private bp n;
  
  private String o = "";
  
  public m(String paramString) {
    this.K = 2;
    this.X = paramString;
    if (ft.A)
      this.e = 22; 
    if (ft.X <= 200)
      this.e = 18; 
    this.f = this.e - 20;
    this.V = this.L + fl.aM + fl.aN * 3;
    this.W = 0 + ft.X / 5 + fl.aM;
    this.a = fl.S / 4;
    b();
    this.aT = new bt(df.af, -1, this);
    if (ft.A)
      this.aT.a = df.Z; 
    this.h = new bt(df.aB, 0, this);
    this.k = new bt(df.aC, 3, this);
    this.i = new bt(df.aC, 1, this);
    this.j = new bt(df.aC, 2, this);
  }
  
  public final void b() {
    int i = this.W + 4 + ft.ab + this.e * df.go.length + 2;
    int j = fl.T - ft.ab + 2 + this.e * df.go.length;
    this.c = cn.f.L.length * ft.ab - j + 5;
    this.n = new bp(this.V, i, fl.S, j, 0, 0, this.c);
    if (fl.aU > 0) {
      this.n.c = fl.aV;
      this.n.d = fl.aW + fl.aM;
      this.n.a = fl.aU;
      this.n.b = fl.T - fl.aM;
      this.n.g = cn.f.L.length * ft.ab - this.N + fl.aM + 10;
    } 
    if (this.c < 0)
      this.c = 0; 
    p.e.a(0, this.n.g, 0, 0);
    if (!ft.A) {
      this.Z = this.aT;
      if (bq.t > 0)
        this.aa = this.h; 
    } 
    this.l = 0;
    super.b();
    if (ft.C)
      for (i = 0; i < cn.f.L.length; i++) {
        cz cz;
        if ((cz = cn.f.L[i]).a < 23 || cz.a > 26)
          this.o = String.valueOf(this.o) + bw.d[cz.a] + ": " + bw.a(bw.f[cz.a], cz.b) + "\n"; 
      }  
  }
  
  public final void c() {
    fl.aO = 0;
    this.b = 0;
    super.c();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    short s;
    switch (paramInt1) {
      case -1:
        c();
        break;
      case 0:
        if (bq.t == 1) {
          ft.c(String.valueOf(df.aM) + df.go[this.b] + df.ca + c(1), this.j);
          break;
        } 
        if (bq.t > 0) {
          this.m = new dy();
          this.m.a(String.valueOf(df.aN) + df.go[this.b] + " (" + df.aO + bq.t + ") ", this.k, true, df.bB);
          ft.r = this.m;
        } 
        break;
      case 1:
        s = 0;
        try {
          s = Short.parseShort(this.m.a.j());
        } catch (Exception exception) {
          s = 0;
        } 
        if (s < 1)
          return; 
        if (s > bq.t) {
          ft.a(String.valueOf(df.cA) + bq.t);
          break;
        } 
        q.a().a((byte)0, (byte)this.b, s);
        ft.j();
        if (cn.p.d(7, 6)) {
          cn.p.b++;
          cn.p.g();
        } 
        break;
      case 2:
        q.a().a((byte)0, (byte)this.b, (short)1);
        if (cn.p.d(7, 6))
          cn.p.b++; 
        ft.j();
        break;
      case 3:
        s = 0;
        try {
          s = Short.parseShort(this.m.a.j());
        } catch (Exception exception) {
          s = 0;
        } 
        if (s < 1)
          return; 
        if (s > bq.t) {
          ft.a(String.valueOf(df.cA) + bq.t);
          break;
        } 
        ft.c(String.valueOf(s) + df.cb + df.go[this.b] + df.ca + c(s), this.i);
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  public final void a(bx parambx) {
    int i = this.W + 4;
    int j = this.V + 4;
    o.j.a(parambx, String.valueOf(df.al) + bq.t, j, i, 0, false);
    i += ft.ab + 2;
    int k;
    for (k = 0; k < df.go.length; k++) {
      int n = this.V + this.a - this.a / 4 + this.g;
      int i1 = i + this.e * k + this.f;
      if (ft.B) {
        fl.c(parambx, n + 2 - this.f / 2, i1 - 1 - this.f / 2, 24 + this.f, 13 + this.f, 4);
      } else {
        parambx.a(fl.aP[12], 0, 0, 24 + this.f, 13 + this.f, 0, n + 2 - this.f / 2, i1 - 1 - this.f / 2, 0);
      } 
      o.f.a(parambx, String.valueOf(df.go[k]) + ":", n - this.f / 2 - this.g - this.a / 2 - (ft.C ? 4 : 0), i1, 0, true);
      o.f.a(parambx, (new StringBuffer(String.valueOf(bq.v[0][k]))).toString(), n + 14, i1, 2, true);
      if (bq.v[1][k] > 0)
        o.b.a(parambx, "+" + bq.v[1][k], n + 26 + this.f, i1, 0, false); 
    } 
    parambx.a(fl.bf[3]);
    if (this.b != 4 && (this.l > 0 || !ft.A) && fl.aO == 1) {
      k = this.V + this.a - this.a / 4 + this.g + 2 - this.f / 2;
      int n = i + this.e * this.b + this.f / 2 - 1;
      parambx.b(k, n, 24 + this.f, 13 + this.f);
    } 
    i += this.e * df.go.length;
    if (fl.aU > 0)
      o.f.a(parambx, df.bK, fl.aV + fl.aU / 2, fl.aW + fl.aM / 4, 2, false); 
    if (fl.aU > 0) {
      ft.a(parambx);
      parambx.d(fl.aV, fl.aW + fl.aM + 4, fl.aU, this.N - fl.aM - 6);
      parambx.a(fl.aV, fl.aW + fl.aM);
      parambx.a(0, -p.e.b);
      j = 4;
      i = 4;
    } else {
      if (!ft.C && this.b == 4) {
        if (p.e.b > 0)
          parambx.a(fl.aP[7], 0, 0, 13, 8, 0, this.V + fl.S - 16, i - 2 + ft.ai % 3, 0); 
        if (p.e.b < p.e.f)
          parambx.a(fl.aP[7], 0, 8, 13, 8, 0, this.V + fl.S - 16, this.W + fl.T - 10 - ft.ai % 3, 0); 
      } 
      if (!ft.C) {
        parambx.d(this.V, i - 5, fl.S, this.W + fl.T - i + 3);
        parambx.a(0, -p.e.b);
      } 
    } 
    if (!ft.C) {
      for (byte b = 0; b < cn.f.L.length; b++) {
        cz cz;
        if ((cz = cn.f.L[b]).a < 23 || cz.a > 26) {
          o o = null;
          o = fl.a(bw.e[cz.a]);
          String str = String.valueOf(bw.d[cz.a]) + ": " + bw.a(bw.f[cz.a], cz.b);
          o.a(parambx, str, j, i, 0, true);
          int n = 0;
          if (cn.f.df != null)
            for (byte b1 = 0; b1 < cn.f.df.c(); b1++) {
              ei ei;
              if ((ei = (ei)cn.f.df.a(b1)).l != null)
                for (byte b2 = 0; b2 < ei.l.length; b2++) {
                  if (cz.a == (ei.l[b2]).a)
                    n += (ei.l[b2]).b; 
                }  
            }  
          if (n != 0) {
            String str1 = null;
            o o1 = o.o;
            if (n > 0) {
              str1 = " +" + bw.a(bw.f[cz.a], n);
            } else {
              str1 = " " + bw.a(bw.f[cz.a], n);
              o1 = o.m;
            } 
            int i1 = o.j.a(str);
            o1.a(parambx, " " + str1, j + i1, i, 0, true);
          } 
          i += ft.ab;
        } 
      } 
      return;
    } 
    o.f.a(parambx, df.bK, j + fl.S / 2, i - ft.ab / 2, 2, true);
  }
  
  public final void a() {
    if (ft.A) {
      this.n.c();
      this.n.a();
      p.e.b = this.n.f;
    } else {
      p.e.a();
    } 
    if (!ft.A)
      if (bq.t > 0 && this.b != 4) {
        if (this.aa == null)
          this.aa = this.h; 
      } else if (this.aa != null) {
        this.aa = null;
      }  
    if (this.l > 0 && ft.r == null)
      this.l--; 
  }
  
  public final void d() {
    if (fl.aO == 1)
      if (this.b == 4) {
        if (ft.C) {
          this.b = 3;
          ft.b(this.o, df.bK);
        } else if (ft.al[2]) {
          this.d -= ft.ab;
          if (this.d < 0)
            this.b = 3; 
          ft.d(2);
          p.e.a(0, this.d);
        } else if (ft.al[8]) {
          this.d += ft.ab;
          if (this.d > this.c)
            this.d = this.c; 
          ft.d(8);
          p.e.a(0, this.d);
        } 
      } else {
        if (ft.al[2]) {
          this.b--;
          ft.d(2);
        } else if (ft.al[8]) {
          this.b++;
          ft.d(8);
        } else if (ft.al[4] || ft.al[6]) {
          fl.aO = 0;
          ft.d(4);
          ft.d(6);
        } 
        int i = df.go.length - 1;
        if (this.c > 0)
          i++; 
        this.b = cg.a(this.b, i, false);
        this.d = 0;
      }  
    super.d();
  }
  
  public final void e() {
    if (ft.S)
      for (byte b = 0; b < 4; b++) {
        int i = this.V + this.a - this.a / 4 + this.g;
        int j = this.W + ft.ab + 4 + this.e * b + this.f + 2;
        if (ft.c(i - 2 - this.f / 2, j - 5 - this.f / 2, 32 + this.f, 21 + this.f)) {
          this.b = b;
          this.h.a();
          ft.S = false;
          this.l = 10;
          break;
        } 
      }  
    super.e();
  }
  
  private String c(int paramInt) {
    String str = "";
    switch (this.b) {
      case 0:
        str = String.valueOf(str) + "\n" + df.cY + d(2, paramInt);
        str = String.valueOf(str) + "\n" + df.cZ + d(20, paramInt);
        if (cn.f.bx == 0) {
          str = String.valueOf(str) + "\n" + df.da + "+" + (paramInt * 4);
          str = String.valueOf(str) + "\n" + df.db + "+" + (paramInt * 4);
          break;
        } 
        if (cn.f.bx == 1) {
          str = String.valueOf(str) + "\n" + df.da + "+" + (paramInt * 4);
          str = String.valueOf(str) + "\n" + df.dc + "+" + (paramInt * 4);
        } 
        break;
      case 1:
        str = String.valueOf(str) + "\n" + df.de + d(2, paramInt);
        str = String.valueOf(str) + "\n" + df.df + d(10, paramInt);
        if (cn.f.bx == 3) {
          str = String.valueOf(str) + "\n" + df.df + "+" + (paramInt * 22);
          break;
        } 
        if (cn.f.bx == 1) {
          str = String.valueOf(str) + "\n" + df.df + "+" + (paramInt * 22);
          break;
        } 
        str = String.valueOf(str) + "\n" + df.df + "+" + (paramInt * 20);
        break;
      case 2:
        str = String.valueOf(str) + "\n" + df.dy + d(2, paramInt);
        if (cn.f.bx == 0) {
          str = String.valueOf(str) + "\n" + df.dz + "+" + (paramInt * 320);
          break;
        } 
        if (cn.f.bx == 2) {
          str = String.valueOf(str) + "\n" + df.dz + "+" + (paramInt * 310);
          str = String.valueOf(str) + "\n" + df.bm + "+" + (paramInt * 1);
          break;
        } 
        str = String.valueOf(str) + "\n" + df.dz + "+" + (paramInt * 300);
        if (cn.f.bx == 2)
          str = String.valueOf(str) + "\n" + df.dA + d(5, paramInt); 
        break;
      case 3:
        str = String.valueOf(str) + "\n" + df.dB + d(2, paramInt);
        if (cn.f.bx == 2) {
          str = String.valueOf(str) + "\n" + df.bm + "+" + (paramInt * 11);
          str = String.valueOf(str) + "\n" + df.da + "+" + (paramInt * 4);
          str = String.valueOf(str) + "\n" + df.dC + "+" + (paramInt * 4);
          str = String.valueOf(str) + "\n" + df.da + d(18, paramInt);
          str = String.valueOf(str) + "\n" + df.dC + d(18, paramInt);
          break;
        } 
        if (cn.f.bx == 3) {
          str = String.valueOf(str) + "\n" + df.bm + "+" + (paramInt * 11);
          str = String.valueOf(str) + "\n" + df.da + "+" + (paramInt * 4);
          str = String.valueOf(str) + "\n" + df.dd + "+" + (paramInt * 4);
          str = String.valueOf(str) + "\n" + df.da + d(18, paramInt);
          str = String.valueOf(str) + "\n" + df.dd + d(18, paramInt);
          break;
        } 
        str = String.valueOf(str) + "\n" + df.bm + "+" + (paramInt * 10);
        break;
    } 
    return str;
  }
  
  private static String d(int paramInt1, int paramInt2) {
    String str = null;
    if ((paramInt1 *= paramInt2) % 100 == 0) {
      str = "+" + (paramInt1 / 100) + "%";
    } else if (paramInt1 % 10 == 0) {
      str = "+" + (paramInt1 / 100) + "." + (paramInt1 % 100 / 10) + "%";
    } else {
      str = "+" + (paramInt1 / 100) + "." + (paramInt1 % 100 / 10) + (paramInt1 % 10) + "%";
    } 
    return str;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\m.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */