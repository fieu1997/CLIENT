public final class ca extends dx {
  public byte a = 0;
  
  private int z = 0;
  
  private int A;
  
  private int B;
  
  public es b = new es("AnimateEffect list");
  
  public boolean c;
  
  private static int C = 5;
  
  private static int D;
  
  private static int E = ak.g(2);
  
  private aq F;
  
  public final void b() {
    this.c = true;
  }
  
  public ca(byte paramByte, boolean paramBoolean, int paramInt1, int paramInt2) {
    this.A = paramInt2;
    this.B = (int)(ft.aj / 1000L);
    this.a = paramByte;
    paramInt2 = 1;
    switch (paramByte) {
      case 1:
        paramInt2 = 3;
        this.F = aq.a("/efleaf.img");
        break;
      case 2:
        paramInt2 = 2;
        this.F = aq.a("/efsnow.img");
        break;
      case 3:
        this.F = aq.a("/efhoa.img");
        break;
      case 4:
        paramInt2 = 12;
        break;
      case 5:
        this.c = true;
        return;
    } 
    if (paramInt1 > 0) {
      this.z = paramInt1;
    } else if (paramInt1 == -1) {
      this.z = ft.W * ft.X / paramInt2 * 8 * 200;
    } else if (paramInt1 == -2) {
      this.z = ft.W * ft.X / paramInt2 * 6 * 200;
    } else if (paramInt1 == -3) {
      this.z = ft.W * ft.X / paramInt2 * 3 * 200;
    } else if (paramInt1 == -4) {
      this.z = ft.W * ft.X / paramInt2 * 2 * 200;
    } else {
      this.z = 10;
    } 
    if (paramByte != 4)
      for (paramInt1 = 0; paramInt1 < this.z; paramInt1++) {
        en en = null;
        if (paramBoolean) {
          en = new en((p.d.a - ft.Y + ak.f(ft.W << 1)) * 10, (p.d.b - (ft.X << 1) + ak.f(ft.X << 1)) * 10);
        } else {
          en = new en();
          a(en);
        } 
        if (paramByte == 2 || this.a == 3) {
          en.f = ak.f(3);
        } else {
          en.f = ak.f(4);
        } 
        if (paramByte == 5) {
          en.i = ak.c(2, 8);
          en.j = ak.c(2, 12);
        } 
        en.h = 16 + (ak.f(3) << 2);
        en.d = ak.c(-1, 1);
        en.g = ak.f(en.h);
        en.p = ak.f(2);
        if (paramByte == 2) {
          en.m = (byte)ak.f(6);
        } else if (paramByte == 1) {
          en.m = (byte)ak.f(4);
        } else {
          en.m = (byte)ak.f(20);
        } 
        this.b.a(en);
      }  
  }
  
  public final void a(bx parambx) {
    int i;
    ft.a(parambx);
    parambx.a(-p.d.a, -p.d.b);
    switch (this.a) {
      case 0:
        parambx = parambx;
        this = this;
        parambx.a(-2236963);
        for (i = 0; i < this.z; i++) {
          en en;
          if ((en = (en)this.b.a(i)).a / 10 > p.d.a && en.a / 10 < p.d.a + ft.W && en.b / 10 > p.d.b)
            parambx.c(en.a / 10, en.b / 10, 1, en.f + 2); 
        } 
        return;
      case 1:
        parambx = parambx;
        if ((this = this).F != null)
          for (i = 0; i < this.z; i++) {
            en en;
            if ((en = (en)this.b.a(i)).a / 10 > p.d.a && en.a / 10 < p.d.a + ft.W && en.b / 10 > p.d.b) {
              if (ak.f(6) == 0)
                en.m = (byte)ak.f(4); 
              parambx.a(this.F, 0, en.m * 10, 16, 10, 0, en.a / 10, en.b / 10, 3);
            } 
          }  
        return;
      case 3:
        parambx = parambx;
        this = this;
        i = 0;
        if (this.F != null)
          for (byte b = 0; b < this.z; b++) {
            en en;
            if ((en = (en)this.b.a(b)).a / 10 > p.d.a && en.a / 10 < p.d.a + ft.W && en.b / 10 > p.d.b) {
              if ((i = 2 - en.f + 1) < 2)
                i = en.m / 10; 
              parambx.a(this.F, 0, i * 10, 10, 10, 0, en.a / 10, en.b / 10, 3);
              en.m++;
              if (en.m >= 20)
                en.m = 0; 
            } 
          }  
        return;
      case 2:
        parambx = parambx;
        if ((this = this).F != null)
          for (i = 0; i < this.z; i++) {
            en en;
            if ((en = (en)this.b.a(i)).a / 10 > p.d.a && en.a / 10 < p.d.a + ft.W && en.b / 10 > p.d.b)
              parambx.a(this.F, 0, 7 * en.m, 7, 7, 0, en.a / 10, en.b / 10, 3); 
          }  
        return;
      case 5:
        parambx = parambx;
        this = this;
        break;
    } 
  }
  
  public static void c() {
    int i = 1;
    if (ft.ai % 6 == 3)
      i = ak.f(15); 
    if (i == 0 && C == 5) {
      C = 5 + ak.f(20);
      D = 50 + ak.f(100);
    } 
    if (D > 0)
      D--; 
    if (D == 0 && C > 5 && ft.ai % 4 == 2)
      C--; 
  }
  
  public final void a() {
    int i;
    if (this.A > 0 && ft.aj / 1000L - this.B > this.A)
      this.c = true; 
    switch (this.a) {
      case 0:
        this = this;
        for (i = 0; i < this.z; i++) {
          en en;
          (en = (en)this.b.a(i)).b += (en.f + 1) * 15 + (3 - en.f) * 3;
          en.c++;
          en.a += (3 - en.f + 1 << 1) + C * E;
          if (en.b / 10 < p.d.b - ft.Y || en.b / 10 > p.d.b + ft.X + ft.Z - (4 - en.f) * 50 || en.a / 10 < p.d.a - ft.Y || en.a / 10 > p.d.a + ft.W + ft.Y)
            a(en); 
        } 
        return;
      case 1:
        this = this;
        for (i = 0; i < this.z; i++) {
          en en;
          (en = (en)this.b.a(i)).b += 15;
          en.a += en.d * 10 + C * E;
          en.g++;
          if (en.g >= en.h)
            en.g = 0; 
          if (en.b / 10 < p.d.b - ft.Y || en.b / 10 > p.d.b + ft.X + ft.Z - (4 - en.f) * 50 || en.a / 10 < p.d.a - ft.Y || en.a / 10 > p.d.a + ft.W + ft.Y)
            a(en); 
        } 
        return;
      case 3:
        this = this;
        for (i = 0; i < this.z; i++) {
          en en;
          (en = (en)this.b.a(i)).b += (en.f + 2) * 5;
          en.a += (en.f + 1 << 1) + C * E;
          if (en.b / 10 < p.d.b - ft.Y || en.b / 10 > p.d.b + ft.X + ft.Z - (4 - en.f) * 50 || en.a / 10 < p.d.a - ft.Y || en.a / 10 > p.d.a + ft.W + ft.Y)
            a(en); 
        } 
        return;
      case 2:
        this = this;
        for (i = 0; i < this.z; i++) {
          en en;
          (en = (en)this.b.a(i)).b += (en.f + 4) * 3;
          en.a += (en.f + 1 << 1) + C * E;
          if ((en.b / 10 < p.d.b - ft.Y || en.b / 10 > p.d.b + ft.X + ft.Z - (4 - en.f) * 50 || en.a / 10 < p.d.a - ft.Y || en.a / 10 > p.d.a + ft.W + ft.Y) && ak.f(40) == 0)
            a(en); 
        } 
        return;
      case 4:
        this = this;
        if (ak.f(250) < this.z) {
          i = ak.c(1, 3);
          cn.a(86, 0, 0, 0, (short)0, (byte)i);
        } 
        return;
      case 5:
        this = this;
        for (i = 0; i < this.b.c(); i++) {
          en en;
          (en = (en)this.b.a(i)).b += en.j;
          en.a += en.i * E;
          if (en.b / 10 < p.d.b - ft.Y || en.b / 10 > p.d.b + ft.X + ft.Z || en.a / 10 < p.d.a - ft.Y || en.a / 10 > p.d.a + ft.W + ft.Y) {
            this.b.d(en);
            i--;
          } 
        } 
        if ((this.A <= 0 || ft.aj / 1000L - this.B <= this.A) && !this.c && ak.f(350) < 0) {
          en en = null;
          en = new en();
          a(en);
          en.f = ak.f(4);
          en.h = 16 + (ak.f(3) << 2);
          en.d = ak.c(-1, 1);
          en.g = ak.f(en.h);
          en.p = ak.f(2);
          en.m = (byte)ak.f(20);
          en.i = ak.c(2, 8);
          en.j = ak.c(2, 12);
          this.b.a(en);
        } 
        break;
    } 
  }
  
  private void a(en paramen) {
    if (this.c) {
      this.b.d(paramen);
      this.z = this.b.c();
      if (this.b.c() == 0)
        return; 
    } else {
      if (this.a == 5) {
        paramen.b = (p.d.b - ft.Z + ak.f(ft.X / 2)) * 10;
        if (E > 0) {
          paramen.a = (p.d.a - ft.Y + ak.f(ft.W)) * 10;
        } else {
          paramen.a = (p.d.a + ft.Y + ak.f(ft.W)) * 10;
        } 
        paramen.p = ak.f(2);
        paramen.i = ak.c(2, 8);
        paramen.j = ak.c(2, 12);
      } else {
        paramen.b = (p.d.b - ft.Z + ak.f(ft.X << 1)) * 10;
        paramen.a = (p.d.a - ft.Y + ak.f(ft.W << 1)) * 10;
      } 
      if (this.a == 2 || this.a == 3) {
        paramen.f = ak.f(3);
        return;
      } 
      if (this.a == 0) {
        paramen.f = ak.c(1, 5);
        return;
      } 
      paramen.f = ak.f(4);
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ca.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */