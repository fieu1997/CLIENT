import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class cs {
  private static es y = new es("LoadMap vecMapItem");
  
  public static es a = new es("LoadMap vecPointChange");
  
  public static es b = new es("LoadMap mItemMap");
  
  public static int[] c = new int[] { 5, 4, 1 };
  
  public int d;
  
  public int e;
  
  public int f;
  
  private int z;
  
  private int A;
  
  private int B;
  
  private int C = ft.W / l + 1;
  
  private int D = ft.X / l + 1;
  
  public int g;
  
  public int h;
  
  public static byte i = 0;
  
  private static byte E = 0;
  
  public static byte j = 1;
  
  public static int k = -1;
  
  public static int l = 24;
  
  public int[] m;
  
  public int[] n;
  
  public static int[] o;
  
  public byte[][] p;
  
  public static aq q;
  
  public static aq r;
  
  public static aq s;
  
  public static int t = 0;
  
  public static byte u = 0;
  
  public static byte v = 10;
  
  public static byte w = 0;
  
  private int F;
  
  private int G;
  
  private int H;
  
  private int I;
  
  public static es x = new es("LoadMap Thacnuoc");
  
  public cs() {
    d();
  }
  
  public static boolean a() {
    return cn.aP;
  }
  
  private static void d() {
    try {
      DataInputStream dataInputStream;
      short s = (dataInputStream = aq.b("/table_item")).readShort();
      for (short s1 = 0; s1 < s; s1 = (short)(s1 + 1)) {
        short s2 = dataInputStream.readShort();
        dataInputStream.readByte();
        short s3 = dataInputStream.readShort();
        short s4 = dataInputStream.readShort();
        byte b;
        int[][] arrayOfInt = dw.a(b = dataInputStream.readByte(), 2);
        for (byte b1 = 0; b1 < b; b1++) {
          arrayOfInt[b1][0] = dataInputStream.readByte();
          arrayOfInt[b1][1] = dataInputStream.readByte();
        } 
        y.a(new z(s1, s2, s3, s4, arrayOfInt));
      } 
      return;
    } catch (Exception exception) {
      dw.a("loi load map 1");
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(byte[] paramArrayOfbyte) {
    try {
      y.d();
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
      DataInputStream dataInputStream;
      short s = (dataInputStream = new DataInputStream(byteArrayInputStream)).readShort();
      for (short s1 = 0; s1 < s; s1 = (short)(s1 + 1)) {
        short s2 = dataInputStream.readShort();
        dataInputStream.readByte();
        short s3 = dataInputStream.readShort();
        short s4 = dataInputStream.readShort();
        byte b;
        int[][] arrayOfInt = dw.a(b = dataInputStream.readByte(), 2);
        for (byte b1 = 0; b1 < b; b1++) {
          arrayOfInt[b1][0] = dataInputStream.readByte();
          arrayOfInt[b1][1] = dataInputStream.readByte();
        } 
        y.a(new z(s1, s2, s3, s4, arrayOfInt));
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void b(byte[] paramArrayOfbyte) {
    try {
      x.d();
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
      DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
      this.e = dataInputStream.readByte();
      this.f = dataInputStream.readByte();
      byte b = dataInputStream.readByte();
      if (k != b) {
        k = b;
        q = null;
        r = null;
        s = null;
        if ((q = aq.a("/tile" + k + ".png")) == null || q.a == null)
          q = a((byte)100, (short)k); 
        if (q == null || q.a == null)
          q.a().d((short)(k + 10400)); 
        if ((r = aq.a("/tilewater" + k + ".png")) == null || r.a == null)
          r = a((byte)102, (short)k); 
        if (r == null || r.a == null)
          q.a().d((short)(k + 10500)); 
        if ((s = aq.a("/tile_small" + k + ".png")) == null || s.a == null)
          s = a((byte)101, (short)k); 
        if (s == null || s.a == null)
          q.a().d((short)(k + 10600)); 
        DataInputStream dataInputStream1 = aq.b("/tile_map_info_" + k);
        this.G = dataInputStream1.read();
        this.F = dataInputStream1.read();
        if (e())
          if (k == 9) {
            this.G = 127;
            this.F = 19;
            this.H = 19;
            this.I = 26;
          } else if (k == 10) {
            this.G = 127;
            this.F = 5;
            this.H = 4;
            this.I = 25;
          } else if (k == 11) {
            this.G = 127;
            this.F = 21;
            this.H = 20;
            this.I = 37;
          } else if (k == 12) {
            this.G = 127;
            this.F = 34;
            this.H = 35;
            this.I = 44;
          } else if (k == 13) {
            this.G = 0;
            this.F = 47;
            this.H = 0;
            this.I = 0;
          } else if (k == 14) {
            this.G = 0;
            this.F = 26;
            this.H = 0;
            this.I = 0;
          } else if (k == 15) {
            this.G = 0;
            this.F = 9;
            this.H = 0;
            this.I = 0;
          } else if (k == 16) {
            this.G = 0;
            this.F = 42;
            this.H = 0;
            this.I = 0;
          }  
      } 
      this.g = this.e * l;
      this.h = this.f * l;
      this.z = this.g - ft.W;
      this.A = this.h - ft.X;
      p.d.a(this.z, this.A, cn.f.aY - ft.Y, cn.f.aZ - ft.Z);
      this.m = new int[this.e * this.f];
      this.n = new int[this.e * this.f];
      this.p = new byte[this.e][this.f];
      this.B = this.e * this.f;
      for (b = 0; b < this.e * this.f; b++) {
        byte b1 = dataInputStream.readByte();
        this.m[b] = b1;
        if (!e()) {
          if (b1 >= this.F || b1 == 0) {
            this.n[b] = 1;
          } else if (b1 >= this.G) {
            this.n[b] = 2;
          } else {
            this.n[b] = 0;
          } 
        } else {
          if (k == 9) {
            if (b1 == 27 || b1 == 28 || b1 == 29 || b1 == 30 || b1 == 31) {
              fs fs = new fs(b1 - 27, b % this.e * 24, b / this.e * 24);
              x.a(fs);
            } 
          } else if (k == 10) {
            if (b1 == 18 || b1 == 19) {
              fs fs = new fs(b1 - 18 + 5, b % this.e * 24, b / this.e * 24);
              x.a(fs);
            } 
          } else if (k == 11 && (b1 == 38 || b1 == 39)) {
            fs fs = new fs(b1 - 38 + 7, b % this.e * 24, b / this.e * 24);
            x.a(fs);
          } 
          if (b1 >= this.F || b1 == 0) {
            this.n[b] = 1;
          } else {
            this.n[b] = 0;
          } 
        } 
      } 
      i = 0;
      return;
    } catch (IOException iOException) {
      (paramArrayOfbyte = null).printStackTrace();
      return;
    } 
  }
  
  public final void c(byte[] paramArrayOfbyte) {
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
      DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
      b.d();
      short s = dataInputStream.readShort();
      short s1;
      for (s1 = 0; s1 < s; s1++) {
        short s2;
        z z;
        if ((z = b(s2 = dataInputStream.readShort())) == null)
          z = b(85); 
        v v = new v(z.d, z.e, z.f, z.g, z.m);
        short s3 = dataInputStream.readShort();
        short s4 = dataInputStream.readShort();
        if (!ft.B || z.m.length > 0) {
          a(s3, s4, z.m);
          v.a(s3 * l, s4 * l);
          b.a(v);
        } 
      } 
      if (dataInputStream.available() > 0 && !ft.B) {
        s1 = dataInputStream.readShort();
        for (byte b = 0; b < s1; b++) {
          byte b1 = dataInputStream.readByte();
          String str1 = "";
          for (byte b2 = 0; b2 < b1; b2++)
            str1 = String.valueOf(str1) + (char)dataInputStream.readByte(); 
          b1 = dataInputStream.readByte();
          String str2 = "";
          for (byte b3 = 0; b3 < b1; b3++)
            str2 = String.valueOf(str2) + (char)dataInputStream.readByte(); 
          if (!dw.g)
            b.a(cn.a(str1, str2)); 
        } 
      } 
      ak.b(b);
      return;
    } catch (Exception exception) {
      dw.a("loi load map 3");
      exception.printStackTrace();
      return;
    } 
  }
  
  public final void a(bx parambx) {
    try {
      int i = p.d.a / l - 1;
      int j = p.d.b / l - 1;
      if (i < 0)
        i = 0; 
      if (j < 0)
        j = 0; 
      int k = i + this.C + 2;
      int m = j + this.D + 2;
      if (k > this.e)
        k = this.e; 
      if (m > this.f)
        m = this.f; 
      for (i = i; i < k; i++) {
        for (int n = j; n < m && eg.g; n++) {
          int i1 = this.m[n * this.e + i] - 1;
          if (!e()) {
            if (i1 >= this.G - 1 && i1 < this.F - 1 && ((ft.ai % 14 < 7 && i % 2 == 0) || (ft.ai % 14 > 7 && i % 2 != 0))) {
              if (r != null && r.a != null)
                parambx.a(r, (i1 - this.G - 1) / 10 * l, (i1 - this.G - 1) % 10 * l, l, l, 0, i * l, n * l, 0); 
            } else if (i1 > -1 && q != null && q.a != null) {
              parambx.a(q, 0, i1 * l, l, l, 0, i * l, n * l, 0);
            } 
          } else if (i1 >= this.H - 1 && i1 < this.I && ((ft.ai % 14 < 7 && i % 2 == 0) || (ft.ai % 14 > 7 && i % 2 != 0))) {
            if (r != null && r.a != null)
              parambx.a(r, (i1 - this.H - 1) / 10 * l, (i1 - this.H - 1) % 10 * l, l, l, 0, i * l, n * l, 0); 
          } else if (i1 > -1 && q != null && q.a != null) {
            parambx.a(q, 0, i1 * l, l, l, 0, i * l, n * l, 0);
          } 
        } 
      } 
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      return;
    } 
  }
  
  public final int a(int paramInt1, int paramInt2) {
    int i;
    return ((i = paramInt2 / l * this.e + paramInt1 / l) > this.B || paramInt1 < 0 || paramInt1 >= this.z + ft.W || paramInt2 < 0 || paramInt2 >= this.A + ft.X) ? 1 : this.n[i];
  }
  
  public final int b(int paramInt1, int paramInt2) {
    return paramInt2 / l * this.e + paramInt1 / l;
  }
  
  private static z b(int paramInt) {
    for (byte b = 0; b < y.c(); b++) {
      z z;
      if ((z = (z)y.a(b)).d == paramInt)
        return z; 
    } 
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int[][] paramArrayOfint) {
    try {
      for (byte b = 0; b < paramArrayOfint.length; b++) {
        if (paramInt1 + paramArrayOfint[b][0] >= 0 && paramInt1 + paramArrayOfint[b][0] < this.e && paramInt2 + paramArrayOfint[b][1] >= 0 && paramInt2 + paramArrayOfint[b][1] < this.f)
          this.n[(paramInt2 + paramArrayOfint[b][1]) * this.e + paramInt1 + paramArrayOfint[b][0]] = 1; 
      } 
      return;
    } catch (Exception exception) {
      dw.a("loi load map 4");
      exception.printStackTrace();
      return;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.e == 0)
      this.e = 1; 
    paramInt1 = b(paramInt1, paramInt2);
    for (paramInt2 = 0; paramInt2 < paramInt3; paramInt2++) {
      for (byte b = 0; b < paramInt4; b++) {
        if (paramInt1 % this.e - paramInt3 / 2 + paramInt2 >= 0 && paramInt1 % this.e - paramInt3 / 2 + paramInt2 < this.e && paramInt1 / this.e - paramInt4 / 2 + b >= 0 && paramInt1 / this.e - paramInt4 / 2 < this.f)
          this.n[(paramInt1 / this.e - paramInt4 / 2 + b) * this.e + paramInt1 % this.e - paramInt3 / 2 + paramInt2] = 1; 
      } 
    } 
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.e == 0)
      this.e = 1; 
    paramInt1 = b(paramInt1, paramInt2);
    for (paramInt2 = 0; paramInt2 < paramInt3; paramInt2++) {
      for (byte b = 0; b < paramInt4; b++) {
        if (paramInt1 % this.e - paramInt3 / 2 + paramInt2 >= 0 && paramInt1 % this.e - paramInt3 / 2 + paramInt2 < this.e && paramInt1 / this.e - paramInt4 / 2 + b >= 0 && paramInt1 / this.e - paramInt4 / 2 < this.f)
          this.n[(paramInt1 / this.e - paramInt4 / 2 + b) * this.e + paramInt1 % this.e + paramInt2] = 1; 
      } 
    } 
  }
  
  public static byte b() {
    return (byte)(u + 1);
  }
  
  public static String c() {
    String str = null;
    long l1;
    if ((l1 = (cn.T - dw.a()) / 1000L) <= 0L)
      return ""; 
    long l2 = l1 / 3600L;
    long l3 = l1 / 60L;
    long l4 = l1;
    if (l2 > 0L) {
      str = String.valueOf(l2) + "h" + (l1 % 3600L / 60L) + "'";
    } else if (l3 > 0L) {
      str = String.valueOf(l3) + "p" + (l1 % 60L) + "s";
    } else {
      str = String.valueOf(l4) + "s";
    } 
    return String.valueOf(cn.S) + str;
  }
  
  private static aq a(byte paramByte, short paramShort) {
    aq aq1 = new aq();
    q.a().a(paramByte, paramShort);
    return aq1;
  }
  
  private static boolean e() {
    return !(k < 9);
  }
  
  public static String a(long paramLong) {
    String str = null;
    long l1;
    if ((l1 = (paramLong + 3600000L - dw.a()) / 1000L) <= 0L)
      return ""; 
    long l2 = l1 / 60L;
    long l3 = l1;
    return str = (l2 > 0L) ? ((l2 < 10L) ? ((l1 % 60L >= 0L && l1 % 60L < 10L) ? ("0" + l2 + ":" + "0" + (l1 % 60L)) : ("0" + l2 + ":" + (l1 % 60L))) : ((l1 % 60L >= 0L && l1 % 60L < 10L) ? (String.valueOf(l2) + ":" + "0" + (l1 % 60L)) : (String.valueOf(l2) + ":" + (l1 % 60L)))) : ((l3 < 10L) ? ("0" + l3 + "s") : (String.valueOf(l3) + "s"));
  }
  
  public static String b(long paramLong) {
    int j = (int)(paramLong / 1000L) % 60;
    int k = (int)(paramLong / 60000L % 60L);
    int i = (int)(paramLong / 3600000L % 24L);
    return (j <= 0 && i <= 0 && k <= 0) ? "0h: 0': 0" : (String.valueOf(i) + "h: " + k + "': " + j);
  }
  
  public static String a(long paramLong, int paramInt) {
    String str = null;
    long l1;
    if ((l1 = (paramLong + (paramInt * 1000) - dw.a()) / 1000L) <= 0L)
      return ""; 
    long l2 = l1 / 60L;
    long l3 = l1;
    return str = (l2 > 0L) ? ((l2 < 10L) ? ((l1 % 60L >= 0L && l1 % 60L < 10L) ? ("0" + l2 + ":" + "0" + (l1 % 60L)) : ("0" + l2 + ":" + (l1 % 60L))) : ((l1 % 60L >= 0L && l1 % 60L < 10L) ? (String.valueOf(l2) + ":" + "0" + (l1 % 60L)) : (String.valueOf(l2) + ":" + (l1 % 60L)))) : ((l3 < 10L) ? ("0" + l3 + "s") : (String.valueOf(l3) + "s"));
  }
  
  public static String a(int paramInt) {
    int i = paramInt % 60;
    int j = (paramInt /= 60) % 60;
    return ((paramInt /= 60) > 0) ? (String.valueOf(paramInt) + ":" + j) : ((j > 0) ? (String.valueOf(j) + ":" + i) : ((i < 10) ? ("0:" + i) : (new StringBuffer(String.valueOf(i))).toString()));
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cs.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */