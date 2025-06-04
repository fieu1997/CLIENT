import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Enumeration;

public final class at {
  public es a = new es();
  
  private bi[] k;
  
  private byte[][] l = new byte[][] { new byte[1], new byte[1], new byte[1], new byte[1] };
  
  private byte[] m;
  
  private byte n;
  
  private byte o;
  
  public boolean b;
  
  public short c;
  
  public short d;
  
  public long e;
  
  int f = 0;
  
  private int p;
  
  private int q;
  
  public int g = 112;
  
  private byte r;
  
  public boolean h;
  
  public boolean i;
  
  private boolean s;
  
  public static ek j = new ek();
  
  private byte t;
  
  private long u;
  
  private long v;
  
  public at(byte[] paramArrayOfbyte, short paramShort, int paramInt1, int paramInt2) {
    this.f = paramShort;
    this.p = paramInt1;
    this.q = paramInt2;
    a(paramArrayOfbyte);
  }
  
  public at(byte[] paramArrayOfbyte, short paramShort, int paramInt1, int paramInt2, long paramLong, byte paramByte) {
    this.f = paramShort;
    this.p = paramInt1;
    this.q = paramInt2;
    this.r = paramByte;
    this.v = paramLong;
    this.h = true;
    a(paramArrayOfbyte);
  }
  
  public at(short paramShort, int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    this.f = paramShort;
    this.c = (short)paramInt1;
    this.d = (short)paramInt2;
    a(null);
    this.i = true;
  }
  
  public at(int paramInt) {
    this.f = paramInt;
  }
  
  private boolean f() {
    if (this.s)
      return true; 
    a(null);
    return false;
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    try {
      if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
        dj dj;
        if ((dj = (dj)j.a(this.f)) != null && dj.a != null) {
          paramArrayOfbyte = dj.a;
          dj.b = ft.aj;
        } 
        if (dj == null) {
          dj = new dj();
          j.a(this.f, dj);
          fp.b((short)this.f, this.g);
          dj.b = (int)(dw.a() / 1000L);
        } 
      } 
      if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0) {
        DataInputStream dataInputStream;
        byte b = (dataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfbyte))).readByte();
        this.k = new bi[b];
        short s1;
        for (s1 = 0; s1 < b; s1++)
          this.k[s1] = new bi(dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte()); 
        s1 = dataInputStream.readShort();
        for (b = 0; b < s1; b++) {
          byte b2 = dataInputStream.readByte();
          es es1 = new es();
          es es2 = new es();
          for (byte b3 = 0; b3 < b2; b3++) {
            fr fr;
            (fr = new fr(dataInputStream.readShort(), dataInputStream.readShort(), dataInputStream.readByte())).c = dataInputStream.readByte();
            fr.d = dataInputStream.readByte();
            if (fr.d == 0) {
              es1.a(fr);
            } else {
              es2.a(fr);
            } 
          } 
          this.a.a(new fj(es1, es2));
        } 
        short s = (short)dataInputStream.readUnsignedByte();
        this.m = new byte[s];
        byte b1;
        for (b1 = 0; b1 < s; b1++)
          this.m[b1] = (byte)dataInputStream.readShort(); 
        dataInputStream.readByte();
        s = dataInputStream.readByte();
        this.l[0] = new byte[s];
        for (b1 = 0; b1 < s; b1++)
          this.l[0][b1] = dataInputStream.readByte(); 
        s = dataInputStream.readByte();
        this.l[1] = new byte[s];
        for (b1 = 0; b1 < s; b1++)
          this.l[1][b1] = dataInputStream.readByte(); 
        s = dataInputStream.readByte();
        this.l[3] = new byte[s];
        for (b1 = 0; b1 < s; b1++)
          this.l[3][b1] = dataInputStream.readByte(); 
        this.s = true;
        return;
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    if (!f())
      return; 
    if (this.n < this.a.c()) {
      fj fj = (fj)this.a.a(this.n);
      try {
        es es1 = null;
        es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            short s2 = fr.a;
            int i = bi1.c;
            int j = bi1.d;
            short s3 = bi1.a;
            short s1 = bi1.b;
            int k = aq.a(el.a.a);
            int m = aq.b(el.a.a);
            if (s3 > k)
              s3 = 0; 
            if (s1 > m)
              s1 = 0; 
            if (s3 + i > k)
              i = k - s3; 
            if (s1 + j > m)
              j = m - s1; 
            parambx.a(el.a, s3, s1, i, j, (fr.c == 1) ? 2 : 0, paramInt1 + s2 + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception2) {
        Exception exception1;
        (exception1 = null).printStackTrace();
      } 
    } 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2) {
    if (!f())
      return; 
    if (this.n < this.a.c()) {
      fj fj = (fj)this.a.a(this.n);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            short s2 = fr.a;
            int i = bi1.c;
            int j = bi1.d;
            short s3 = bi1.a;
            short s1 = bi1.b;
            int k = aq.a(el.a.a);
            int m = aq.b(el.a.a);
            if (s3 > k)
              s3 = 0; 
            if (s1 > m)
              s1 = 0; 
            if (s3 + i > k)
              i = k - s3; 
            if (s1 + j > m)
              j = m - s1; 
            parambx.a(el.a, s3, s1, i, j, (fr.c == 1) ? 2 : 0, paramInt1 + s2 + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void c(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void d(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void e(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void f(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void g(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (paramInt4 = 0; paramInt4 < es1.c(); paramInt4++) {
          fr fr = (fr)es1.a(paramInt4);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            short s2 = fr.a;
            int i = bi1.c;
            int j = bi1.d;
            short s3 = bi1.a;
            short s1 = bi1.b;
            int k = aq.a(el.a.a);
            int m = aq.b(el.a.a);
            if (s3 > k)
              s3 = 0; 
            if (s1 > m)
              s1 = 0; 
            if (s3 + i > k)
              i = k - s3; 
            if (s1 + j > m)
              j = m - s1; 
            k = (fr.c == 1) ? 2 : 0;
            parambx.a(el.a, s3, s1, i, j, k, paramInt1 + s2 + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void h(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.a;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void i(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void j(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void k(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void l(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void m(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void n(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void o(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (paramInt4 = 0; paramInt4 < es1.c(); paramInt4++) {
          fr fr = (fr)es1.a(paramInt4);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            short s2 = fr.a;
            int i = bi1.c;
            int j = bi1.d;
            short s3 = bi1.a;
            short s1 = bi1.b;
            int k = aq.a(el.a.a);
            int m = aq.b(el.a.a);
            if (s3 > k)
              s3 = 0; 
            if (s1 > m)
              s1 = 0; 
            if (s3 + i > k)
              i = k - s3; 
            if (s1 + j > m)
              j = m - s1; 
            k = (fr.c == 1) ? 2 : 0;
            parambx.a(el.a, s3, s1, i, j, k, paramInt1 + s2 + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final void p(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!f())
      return; 
    if (paramInt3 < this.a.c()) {
      fj fj = (fj)this.a.a(paramInt3);
      try {
        es es1 = fj.b;
        for (byte b = 0; b < es1.c(); b++) {
          fr fr = (fr)es1.a(b);
          bi bi1 = this.k[fr.e];
          el el;
          if ((el = fp.a((short)this.f, this.g)) != null && el.a != null) {
            int i = fr.a;
            int j = bi1.c;
            int k = bi1.d;
            short s2 = bi1.a;
            short s1 = bi1.b;
            int m = aq.a(el.a.a);
            int n = aq.b(el.a.a);
            if (s2 > m)
              s2 = 0; 
            if (s1 > n)
              s1 = 0; 
            if (s2 + j > m)
              j = m - s2; 
            if (s1 + k > n)
              k = n - s1; 
            m = (fr.c == 1) ? 2 : 0;
            if (paramInt4 == 2 || paramInt4 == 6) {
              if (m == 2) {
                m = 0;
              } else {
                m = 2;
              } 
              i = -(i + j);
            } 
            parambx.a(el.a, s2, s1, j, k, m, paramInt1 + i + this.p, paramInt2 + fr.b + this.q, 0);
          } 
        } 
        return;
      } catch (Exception exception) {
        (fj = null).printStackTrace();
      } 
    } 
  }
  
  public final boolean a() {
    return (this.r == 1);
  }
  
  public final boolean b() {
    return (this.r == 2);
  }
  
  public final boolean c() {
    return (this.r == 17);
  }
  
  public final void d() {
    try {
      if (!f())
        return; 
      if (this.h && this.v - dw.a() < 0L)
        this.b = true; 
      this.o = (byte)(this.o + 1);
      if (this.o >= this.m.length) {
        if (this.i)
          this.b = true; 
        if (this.h)
          this.o = 0; 
        if (!this.h && dw.a() - this.u > (this.t * 1000)) {
          this.o = 0;
          this.u = dw.a();
          this.t = (byte)ak.c(1, 8);
        } 
      } 
      if (this.o > 0 && this.o < this.m.length) {
        this.n = this.m[this.o];
        return;
      } 
    } catch (Exception exception) {
      dw.a("loi update me day");
      printStackTrace();
    } 
  }
  
  public static void e() {
    ek ek1;
    Enumeration enumeration = (ek1 = j).a.keys();
    while (enumeration.hasMoreElements()) {
      String str = enumeration.nextElement();
      dj dj = (dj)j.a(str);
      if ((ft.aj - dj.b) / 1000L > 60L)
        j.a(str); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\at.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */