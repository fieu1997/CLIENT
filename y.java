import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public final class y extends fl {
  private static int[][] b;
  
  private int c = 22;
  
  private int d;
  
  private int e;
  
  private bt f;
  
  private bt g;
  
  private bt h;
  
  private bt i;
  
  private bt j;
  
  private bt k;
  
  private dy l;
  
  private bp m;
  
  private es n;
  
  public static es a = new es("TabSkillsNew vecPaintSkill");
  
  private boolean o = false;
  
  private es p = new es();
  
  private int[] q = new int[] { 1, -1, -1 };
  
  private int r = 4;
  
  private int s;
  
  public y(String paramString) {
    this.K = 3;
    this.X = paramString;
    this.V = this.L + fl.aM + fl.aN * 3 + fl.S % 8 / 2;
    this.W = 0 + ft.X / 5 + fl.aM;
    b = dw.a(bq.f, 2);
    int i = this.W + fl.aM / 2 + ft.ab;
    for (byte b = 0; b < bq.f; b++) {
      if (b == 0) {
        b[b][0] = this.V + fl.S / 2;
        b[b][1] = i;
        i += this.c << 1;
      } else {
        b[b][1] = i;
        if (b % 2 == 1) {
          b[b][0] = this.V + fl.S / 4;
        } else {
          b[b][0] = this.V + fl.S / 4 * 3;
          i += this.c << 1;
        } 
      } 
    } 
    b();
    this.aT = new bt(df.af, -1, this);
    if (ft.A)
      this.aT.a = df.Z; 
    this.f = new bt(df.aB, 0, this);
    this.g = new bt(df.aC, 1, this);
    this.h = new bt(df.aC, 2, this);
    this.i = new bt(df.aQ, 3, this);
    this.j = new bt(df.Y, 5, this);
    this.k = new bt(df.fx, 6, this);
    this.s = fl.S / 8;
    this.p.d();
  }
  
  public final void b() {
    fl.bi = 0;
    int i = b[bq.f - 1][1] - this.W + this.c - fl.T + 5;
    p.e.a(0, i, 0, 0);
    this.m = new bp(this.V, this.W + ft.ab + 2, fl.S, fl.T - ft.ab - 2, 0, 0, p.e.f);
    if (!ft.A) {
      this.Z = this.aT;
      this.aa = this.j;
    } 
    if (ft.A) {
      this.d = -1;
    } else {
      this.d = 0;
    } 
    this.aY = null;
  }
  
  public final void c() {
    if (this.o) {
      f();
      this.o = false;
    } 
    fl.bi = 0;
    fl.aO = 0;
    if (ft.A) {
      this.d = -1;
    } else {
      this.d = 0;
    } 
    super.c();
  }
  
  public final void a(int paramInt1, int paramInt2) {
    ev ev1;
    es es1;
    short s;
    ev ev2;
    es es2;
    if ((this.d == -1 || this.d > a.c() - 1) && paramInt1 != -1)
      return; 
    switch (paramInt1) {
      case -1:
        c();
        break;
      case 0:
        if ((ev1 = (ev)a.a(this.d)).i > cn.f.by) {
          ft.a(df.bZ);
          return;
        } 
        if (bq.u == 1) {
          ft.c(String.valueOf(df.aP) + ev1.c, this.h);
          break;
        } 
        if (bq.u > 0) {
          int i;
          if ((i = bq.u) > 10 - bq.I[ev1.b])
            i = 10 - bq.I[ev1.b]; 
          this.l = new dy();
          this.l.a(String.valueOf(df.aN) + ev1.c + " (" + df.aO + i + ")", this.g, true, df.dr);
          ft.r = this.l;
        } 
        break;
      case 1:
        s = 0;
        try {
          s = Short.parseShort(this.l.a.j());
        } catch (Exception exception) {
          s = 0;
        } 
        if (s < 1)
          return; 
        q.a().a((byte)1, (byte)((ev)a.a(this.d)).b, s);
        if (cn.p.d(8, 7)) {
          cn.p.b++;
          cn.p.g();
          break;
        } 
        ft.j();
        break;
      case 2:
        ft.j();
        q.a().a((byte)1, (byte)((ev)a.a(this.d)).b, (short)1);
        if (cn.p.d(8, 7)) {
          cn.p.b++;
          cn.p.g();
        } 
        fl.bi = 0;
        break;
      case 3:
        es1 = new es("TabSkillsNew menu");
        for (s = 0; s < 5; s++) {
          bt bt1 = null;
          if (!ft.A) {
            if (fi.h) {
              bt1 = new bt(String.valueOf(df.ag) + cf.A[s], 4, s, this);
            } else {
              bt1 = new bt(String.valueOf(df.ag) + cf.z[s], 4, s, this);
            } 
          } else {
            bt1 = new bt(String.valueOf(df.ce) + (s + 1), 4, s, this);
          } 
          es1.a(bt1);
        } 
        ft.o.a(es1, 2, df.aQ, false, (es)null);
        break;
      case 4:
        ev2 = (ev)a.a(this.d);
        bq.w[bq.d][paramInt2].a(ev2.b, 0, (byte)0);
        if (ft.A) {
          f();
          break;
        } 
        this.o = true;
        break;
      case 5:
        if (this.d == -1)
          return; 
        es2 = null;
        if ((es2 = h()) != null && es2.c() > 0)
          ft.o.a(es2, 2, df.bB, false, (es)null); 
        break;
      case 6:
        q.a().c((byte)2, (byte)((ev)a.a(this.d)).b);
        this.p.d();
        break;
    } 
    super.a(paramInt1, paramInt2);
  }
  
  public final void a(es parames) {
    b = null;
    this.V = this.L + fl.aM + fl.aN * 3 + fl.S % 8 / 2;
    this.W = 0 + ft.X / 5 + fl.aM;
    b = dw.a(bq.f, 2);
    int i = this.W + fl.aM / 2 + ft.ab;
    for (byte b = 0; b < parames.c(); b++) {
      ev ev;
      if ((ev = (ev)parames.a(b)) != null)
        if (b == 0) {
          b[b][0] = this.V + fl.S / 2;
          b[b][1] = i;
          i += this.c << 1;
        } else {
          b[b][1] = i;
          if (ev.l == 0) {
            b[b][0] = this.V + fl.S / 4;
          } else if (ev.l == 1) {
            b[b][0] = this.V + fl.S / 4 * 3;
            if (b < parames.c() - 2)
              i += this.c << 1; 
          } 
        }  
    } 
  }
  
  public final void a(bx parambx) {
    o.j.a(parambx, String.valueOf(df.am) + bq.u, this.V + 2, this.W + 3, 0, true);
    parambx.d(this.V, this.W + ft.ab + 2, fl.S, fl.T - 2 - ft.ab);
    parambx.a(0, -p.e.b);
    byte b;
    for (b = 0; b < a.c(); b++) {
      byte b1 = b;
      bx bx1 = parambx;
      y y1 = this;
      bx1.a(fl.bf[6]);
      if (y1.q[b1] == 0) {
        bx1.c(b[b1][0], b[b1][1] + y1.c, 1, (y1.r << 1) + y1.c);
      } else if (y1.q[b1] == 1) {
        bx1.c(b[b1][0], b[b1][1] + y1.c, 1, y1.c / 2);
        bx1.c(b[b1][0] - 2 * y1.s, b[b1][1] + y1.c + y1.c / 2, (y1.s << 2) + 1, 1);
        bx1.c(b[b1][0] - 2 * y1.s, b[b1][1] + y1.c + y1.c / 2 + 1, 1, y1.c / 2);
        bx1.c(b[b1][0] + 2 * y1.s, b[b1][1] + y1.c + y1.c / 2 + 1, 1, y1.c / 2);
      } else if (y1.q[b1] == 2) {
        bx1.c(b[b1][0], b[b1][1] + y1.c, 1, y1.r / 2);
        bx1.c(b[b1][0] - y1.s, b[b1][1] + y1.c + y1.r / 2, (y1.s << 1) + 1, 1);
        bx1.c(b[b1][0] - y1.s, b[b1][1] + y1.c + y1.r / 2 + 1, 1, y1.r / 2 + 4);
        bx1.c(b[b1][0] + y1.s, b[b1][1] + y1.c + y1.r / 2 + 1, 1, y1.r / 2 + 4);
      } 
      ev ev;
      if ((ev = (ev)a.a(b)) != null) {
        ev.a(parambx, b[b][0], b[b][1] + this.c / 2, 3);
        if (b == this.d && fl.aO == 1)
          parambx.a(cg.ax, b[b][0] - this.c / 2 - 2, b[b][1] - 2, 0); 
        if (ev.i > cn.f.by)
          parambx.a(cg.am, 0, 0, 20, 20, 0, b[b][0], b[b][1] + this.c / 2, 3); 
        if (b != 0) {
          cg.a(parambx, (new StringBuffer(String.valueOf(bq.I[ev.b]))).toString(), b[b][0] + this.c / 2 + 4, b[b][1] + this.c / 2 - 12, 0);
          if (bq.J[ev.b] > 0)
            cg.a(parambx, "+" + bq.J[ev.b], b[b][0] + this.c / 2 + 4, b[b][1] + this.c - 12, 0, (byte)1); 
        } 
      } 
    } 
    for (b = 0; b < this.p.c(); b++) {
      dx dx;
      (dx = (dx)this.p.a(b)).a(parambx);
    } 
    if (((!ft.o.a && ft.r == null) || fl.aU > 0) && fl.aO == 1 && fl.bi > fl.aX) {
      a(parambx, false);
      if (this.n != null)
        for (b = 0; b < this.n.c(); b++) {
          bt bt1;
          (bt1 = (bt)this.n.a(b)).a(parambx, bt1.h, bt1.i);
        }  
    } 
  }
  
  public final void a() {
    try {
      for (byte b = 0; b < this.p.c(); b++) {
        dx dx;
        (dx = (dx)this.p.a(b)).a();
        if (dx.y)
          this.p.d(dx); 
      } 
      if (fl.aO == 1) {
        if (this.aY != null)
          this.aY.c(); 
        if (fl.bi < fl.aX + 2 && ++fl.bi == fl.aX) {
          y y1;
          if ((y1 = this).d >= bq.H.length || y1.d == -1) {
            fl.bi = 0;
          } else {
            ev ev;
            if ((ev = (ev)a.a(y1.d)) == null) {
              y1.bj = null;
              y1.bl = null;
              y1.aY = null;
            } else {
              y1.bp = ev.c;
              if (bq.I[ev.b] > 0)
                y1.bp = String.valueOf(y1.bp) + " Lv" + (bq.I[ev.b] + bq.J[ev.b]); 
              y1.bj = ev.a();
              y1.bl = null;
              y1.aY = null;
              if (fl.aU > 0) {
                int i;
                if ((i = y1.bj.length) * ft.ab > fl.U - y1.e) {
                  y1.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U, 0, 0, i * ft.ab - fl.U - y1.e);
                } else if (ft.A) {
                  y1.aY = new bp(fl.aV, fl.aW, fl.aU, fl.U - y1.e, 0, 0, 0);
                } 
                y1.i();
              } else {
                int i = b[y1.d][0];
                y1.bs = i - 45;
                if (y1.bs < 2) {
                  y1.bs = 2;
                } else if (y1.bs + 92 > ft.W) {
                  y1.bs = ft.W - 92;
                } 
                y1.bq = 130;
                if ((i = b[y1.d][1] - p.e.b) < y1.W + fl.T / 2) {
                  y1.bt = i + y1.c + 2 + p.e.b;
                } else {
                  y1.bt = i + 1 - ft.ab * (y1.bj.length + 1) - y1.c / 2 + p.e.b;
                } 
                if (y1.bt - p.e.b + (y1.bj.length + 1) * ft.ab + 8 > ft.X - ft.aa)
                  y1.bt = ft.X - ft.aa - (y1.bj.length + 1) * ft.ab + 8 - p.e.b; 
                if (y1.bt < p.e.b)
                  y1.bt = p.e.b; 
                if ((i = y1.bj.length) * ft.ab > fl.U)
                  y1.aY = new bp(y1.bs, y1.bt, y1.bq, fl.U, 0, 0, i * ft.ab - fl.U); 
              } 
            } 
          } 
        } 
        if (ft.A) {
          this.m.c();
          return;
        } 
        p.e.a();
        if (this.bt < p.e.b + 4) {
          this.bt = p.e.b + 4;
          return;
        } 
      } else {
        fl.bi = 0;
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public final void d() {
    super.d();
    if (fl.aO == 1) {
      int i = this.d;
      if (ft.al[2] || ft.al[8] || ft.al[4] || ft.al[6]) {
        eu.f = 10;
        if (this.d == -1) {
          ft.m();
          this.d = 0;
          return;
        } 
      } 
      if (this.aY != null) {
        if (ft.al[2]) {
          if (this.aY.e > 0) {
            this.aY.e -= ft.ab;
          } else {
            this.aY.e = 0;
          } 
          ft.d(2);
        } else if (ft.al[8]) {
          if (this.aY.e < this.aY.g) {
            this.aY.e += ft.ab;
          } else {
            this.aY.e = this.aY.g;
          } 
          ft.d(8);
        } 
      } else if (ft.al[2]) {
        this.d -= 2;
        if (this.d < 0)
          this.d = 0; 
        eu.f = 10;
        ft.d(2);
      } else if (ft.al[8]) {
        eu.f = 10;
        this.d += 2;
        if (this.d > a.c() - 1)
          this.d = a.c() - 1; 
        ft.d(8);
      } 
      if (ft.al[4]) {
        eu.f = 10;
        if (this.d % 2 == 1 || this.d == 0) {
          fl.aO = 0;
          this.d = 0;
        } else {
          this.d--;
        } 
        ft.d(4);
      } else if (ft.al[6]) {
        eu.f = 10;
        if (this.d < a.c() - 1)
          this.d++; 
        ft.d(6);
      } 
      if (this.d >= 0) {
        this.d = cg.a(this.d, a.c() - 1, false);
      } else {
        this.d = -1;
        return;
      } 
      ev ev = null;
      if (this.d != i && this.d >= 0 && this.d <= a.c() - 1) {
        this.aY = null;
        i();
        fl.bi = 0;
        p.e.a(0, b[this.d][1] - this.W - fl.T / 2);
        ev = (ev)a.a(this.d);
      } 
      if (!ft.A && ev != null)
        if (this.aa == null) {
          if (ev.i <= cn.f.by && (bq.I[ev.b] != 0 || bq.u > 0)) {
            this.aa = this.j;
            return;
          } 
        } else if (ev.i > cn.f.by || (bq.I[ev.b] == 0 && bq.u == 0)) {
          this.aa = null;
        }  
    } 
  }
  
  public final void e() {
    byte b = 0;
    if (this.aY != null && ft.c(this.aY.c, this.aY.d, this.aY.a, this.aY.b)) {
      this.aY.a();
      b = 1;
    } 
    if (ft.A && !b) {
      this.m.a();
      p.e.b = this.m.f;
    } 
    if (ft.b(this.V, this.W, fl.S, fl.T) && !b) {
      for (b = 0; b < b.length; b++) {
        if (ft.c(b[b][0] - this.c / 2 - 2, b[b][1] - 2 - p.e.b, this.c + 4, this.c + 4)) {
          if (b != this.d) {
            this.aY = null;
            this.d = b;
            fl.bi = 0;
          } else if (fl.aU == 0) {
            if (this.d == -1)
              return; 
            es es1 = null;
            if ((es1 = h()) != null && es1.c() > 0)
              ft.o.a(es1, 2, df.bB, false, (es)null); 
          } 
          ft.S = false;
          i();
          break;
        } 
      } 
      if (fl.aU == 0)
        fl.bi = 0; 
      ft.S = false;
    } 
    if (this.n != null && fl.aO == 1 && fl.bi > fl.aX)
      for (b = 0; b < this.n.c(); b++) {
        bt bt1;
        (bt1 = (bt)this.n.a(b)).b();
      }  
    super.e();
  }
  
  private es h() {
    es es1 = new es("TabSkillsNew menu2");
    ev ev = null;
    ev = (ev)a.a(this.d);
    if (this.d < 0 && this.d >= a.c())
      return es1; 
    if (bq.u > 0 && this.d > 0 && bq.I[ev.b] < 10 && cn.f.by >= ev.i)
      es1.a(this.f); 
    if (ev.e != 2 && bq.I[ev.b] > 0) {
      if (es1.c() == 0 && fl.aU == 0) {
        this.i.a();
        return null;
      } 
      es1.a(this.i);
    } 
    es1.a(this.k);
    this.e = (es1.c() + 1) / 2 * bt.k;
    return es1;
  }
  
  public static void f() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      for (byte b = 0; b < bq.w.length; b++) {
        for (byte b1 = 0; b1 < (bq.w[0]).length; b1++) {
          ao ao = bq.w[b][b1];
          dataOutputStream.writeShort(ao.a);
          dataOutputStream.writeByte(ao.b);
          dataOutputStream.writeByte(ao.c);
        } 
      } 
      ak.a((byte)0, byteArrayOutputStream.toByteArray());
      dataOutputStream.close();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void i() {
    if (fl.aU > 0 && ft.A && this.d >= 0) {
      this.n = h();
      b(this.n);
    } 
  }
  
  public static void a(byte[] paramArrayOfbyte) {
    byte b;
    if (paramArrayOfbyte == null) {
      for (b = 0; b < (bq.w[0]).length; b++) {
        bq.w[0][b] = new ao();
        bq.w[1][b] = new ao();
        bq.w[2][b] = new ao();
        if (b == 2) {
          bq.w[0][b].a(0, 0, (byte)0);
          bq.w[1][b].a(0, 0, (byte)0);
          bq.w[2][b].a(0, 0, (byte)0);
        } else {
          bq.w[0][b].a(0, ao.d, (byte)0);
          bq.w[1][b].a(0, ao.d, (byte)0);
          bq.w[2][b].a(0, ao.d, (byte)0);
        } 
      } 
      if (cn.f.by > 1) {
        j.a((byte)1, false);
        j.a((byte)0, false);
      } 
      return;
    } 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
    try {
      for (byte b1 = 0; b1 < bq.w.length; b1++) {
        for (byte b2 = 0; b2 < (bq.w[0]).length; b2++) {
          bq.w[b1][b2] = new ao();
          bq.w[b1][b2].a(dataInputStream.readShort(), dataInputStream.readByte(), dataInputStream.readByte());
        } 
      } 
      return;
    } catch (Exception exception) {
      for (byte b1 = 0; b1 < (bq.w[0]).length; b1++) {
        bq.w[0][b1] = new ao();
        bq.w[1][b1] = new ao();
        bq.w[2][b1] = new ao();
        if (b1 == 2) {
          bq.w[0][b1].a(0, 0, (byte)0);
          bq.w[1][b1].a(0, 0, (byte)0);
          bq.w[2][b1].a(0, 0, (byte)0);
        } else {
          bq.w[0][b1].a(0, ao.d, (byte)0);
          bq.w[1][b1].a(0, ao.d, (byte)0);
          bq.w[2][b1].a(0, ao.d, (byte)0);
        } 
      } 
      if (cn.f.by > 1) {
        j.a((byte)1, false);
        j.a((byte)0, false);
      } 
      return;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\y.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */