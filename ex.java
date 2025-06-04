import javax.microedition.lcdui.Image;

public final class ex {
  public int a;
  
  public int b;
  
  public static int c = 1;
  
  public aw d = new aw();
  
  public static aq e;
  
  public static es f = new es("MiniMap vecNPC_Map");
  
  public static en g;
  
  public ex() {
    (new int[4])[0] = -15731219;
    (new int[4])[1] = -661753;
    (new int[4])[2] = -4539997;
    (new int[4])[3] = -1173963;
  }
  
  public final void a() {
    if (ft.W > 300 && ft.X > 300) {
      c = 3;
    } else if (ft.W > 200 && ft.X > 200) {
      c = 2;
    } 
    this.a = 25;
    this.b = 20;
    if (this.a > ft.p.e)
      this.a = ft.p.e; 
    if (this.b > ft.p.f)
      this.b = ft.p.f; 
    if (ft.A)
      cf.N = ft.W - ft.q.a * c - 55; 
    this.d.a((ft.p.e - this.a) * c, (ft.p.f - this.b) * c, (cn.f.aY / cs.l - this.a / 2) * c, (cn.f.aZ / cs.l - this.b / 2) * c);
    e = a(c);
  }
  
  public final void a(bx parambx) {
    if (cf.i() || cf.j())
      return; 
    parambx.a(-9164782);
    parambx.c(-3, -3, this.a * c + 6, this.b * c + 6);
    parambx.a(-470164);
    parambx.c(-2, -2, this.a * c + 4, this.b * c + 4);
    parambx.a(-12052464);
    parambx.c(-1, -1, this.a * c + 2, this.b * c + 2);
    parambx.d(0, 0, this.a * c, this.b * c);
    parambx.a(-this.d.a, -this.d.b);
    if (e != null && e.a != null)
      parambx.a(e, 0, 0, 0); 
    if (cs.w == 2)
      for (byte b = 0; b < cn.i.c(); b++) {
        ez ez;
        if ((ez = (ez)cn.i.a(b)).cu == 1)
          cg.aD.b(11, ez.aY / cs.l * c, ez.aZ / cs.l * c, 0, 3, parambx); 
      }  
    int i;
    for (i = 0; i < f.c(); i++) {
      fk fk = (fk)f.a(i);
      cg.aD.b(fk.d + 4, fk.b / cs.l * c, fk.c / cs.l * c, 0, 3, parambx);
    } 
    cg.aD.b((cn.f.cF == 4) ? 9 : cn.f.cG, cn.f.aY / cs.l * c, cn.f.aZ / cs.l * c, 0, 3, parambx);
    if (cs.k == 9) {
      parambx.a(367554);
    } else {
      parambx.a(-16776961);
    } 
    if (bq.N != null)
      for (i = 0; i < bq.N.b.c(); i++) {
        aj aj;
        if ((aj = (aj)bq.N.b.a(i)).b.compareTo(cn.f.cB) != 0 && aj.f == ft.p.d)
          cg.aD.b(10, aj.d / cs.l * c, aj.e / cs.l * c, 0, 3, parambx); 
      }  
    if (g != null && g.p == ft.p.d) {
      i = g.a;
      int j = g.b;
      if (i < this.d.a + 3)
        i = this.d.a + 3; 
      if (i > this.d.a + this.a * c - 3)
        i = this.d.a + this.a * c - 3; 
      if (j < this.d.b + 3)
        j = this.d.b + 3; 
      if (j > this.d.b + this.b * c - 3)
        j = this.d.b + this.b * c - 3; 
      ck.b.b(ft.ai / 2 % ck.b.c, i, j, 0, 3, parambx);
    } 
  }
  
  public static void a(fk paramfk) {
    ez ez;
    if ((ez = ez.a(paramfk.a, (byte)2)) != null) {
      ez ez1 = ez;
      byte b;
      for (b = 0; b < ew.a.c(); b++) {
        ew ew;
        if ((ew = (ew)ew.a.a(b)).h == ez1.ct && (ez1.cn == 0 || ez1.cn == 2))
          ez1.cn = 1; 
      } 
      for (b = 0; b < ew.b.c(); b++) {
        ew ew;
        if ((ew = (ew)ew.b.a(b)).g == ez1.ct)
          ez1.cn = 3; 
      } 
      for (b = 0; b < ew.c.c(); b++) {
        ew ew;
        if ((ew = (ew)ew.c.a(b)).g == ez1.ct && ez1.cn == 0)
          ez1.cn = 2; 
      } 
      for (b = 0; b < ew.d.c(); b++) {
        ew ew;
        if ((ew = (ew)ew.d.a(b)).g == ez1.ct && ez1.cn == 0)
          ez1.cn = 2; 
      } 
      paramfk.d = ez.cn;
      f.a(paramfk);
    } 
  }
  
  public static void a(int paramInt, byte paramByte) {
    ez ez;
    if ((ez = ez.a(paramInt, (byte)1)) != null) {
      fk fk;
      (fk = new fk(paramInt, ez.aY, ez.aZ)).d = 8;
      for (byte b = 0; b < f.c(); b++) {
        fk fk1;
        if ((fk1 = (fk)f.a(b)).a == paramInt && fk1.d == fk.d) {
          fk1.b = fk.b;
          fk1.c = fk.c;
          return;
        } 
      } 
      f.a(fk);
    } 
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3) {
    if (g == null)
      g = new en(); 
    g.a = 51 * c - c / 2;
    g.b = 2 * c - c / 2;
    g.p = paramInt3;
  }
  
  public static aq a(int paramInt) {
    try {
      int j = ft.p.f * paramInt;
      int i = ft.p.e * paramInt;
      aq aq1;
      (aq1 = new aq()).a = Image.createImage(i * bx.b, j * bx.b);
      aq aq2 = aq1 = aq1;
      bl bl2;
      (bl2 = new bl()).a = aq2.a.getGraphics();
      bl bl1 = bl2;
      if (ft.y != null) {
        bl1.a.setColor(ft.y.a);
        bl1.a.fillRect(0, 0, aq1.a.getWidth(), aq1.a.getHeight());
      } 
      byte b;
      for (b = 0; b < ft.p.e; b++) {
        for (byte b1 = 0; b1 < ft.p.f; b1++) {
          int k;
          if ((k = ft.p.m[b1 * ft.p.e + b] - 1) > -1 && cs.s.a != null)
            bl1.a.drawRegion(cs.s.a, 0 * bx.b, k * 3 * bx.b, paramInt * bx.b, paramInt * bx.b, 0, b * paramInt * bx.b, b1 * paramInt * bx.b, 0); 
        } 
      } 
      for (b = 0; b < cs.a.c(); b++) {
        en en1 = (en)cs.a.a(b);
        bl1.a.setColor(-10621185);
        switch (en1.n) {
          case 0:
            bl1.a.fillRect((en1.a * paramInt / cs.l - paramInt) * bx.b, (en1.b * paramInt / cs.l - paramInt * 2) * bx.b, paramInt * bx.b, (paramInt << 2) * bx.b);
            break;
          case 1:
            bl1.a.fillRect(en1.a * paramInt / cs.l * bx.b, (en1.b * paramInt / cs.l - paramInt * 2) * bx.b, paramInt * bx.b, (paramInt << 2) * bx.b);
            break;
          case 2:
            bl1.a.fillRect((en1.a * paramInt / cs.l - paramInt * 2) * bx.b, en1.b * paramInt / cs.l * bx.b, paramInt * 4 * bx.b, paramInt * bx.b);
            break;
          case 3:
            bl1.a.fillRect((en1.a * paramInt / cs.l - paramInt * 2) * bx.b, en1.b * paramInt / cs.l * bx.b, paramInt * 4 * bx.b, paramInt * bx.b);
            break;
        } 
      } 
      return aq1;
    } catch (Exception exception) {
      dw.a("--CreateMiniMap: " + exception.toString());
      return null;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ex.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */