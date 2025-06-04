import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public final class fe {
  public static ek a = new ek();
  
  private byte c;
  
  private short d;
  
  public long b = 0L;
  
  private long e = 0L;
  
  private int[][] f;
  
  private int[][] g;
  
  private int[][] h;
  
  private int[][] i;
  
  private int[][] j;
  
  private int[][] k;
  
  private aq l = null;
  
  private static byte[][] m = new byte[][] { { 0, 0, 1, 2, 3, 4 }, { 0, 0, 1, 2, 3, 4 }, new byte[6], new byte[6], new byte[6], new byte[6], { 0, 1, 1, 1 } };
  
  private void a(byte paramByte, short paramShort) {
    Exception exception;
    if (dw.i && this.e == 0L) {
      this.e = ft.aj;
      aq aq1 = null;
      try {
        aq1 = aq.a("/c/" + dp.a[paramByte] + "/b" + paramShort + "_" + dp.a[paramByte] + ".png");
      } catch (Exception exception1) {
        aq1 = null;
      } 
      if (aq1 != null && aq1.a != null) {
        DataInputStream dataInputStream = null;
        try {
          dataInputStream = aq.b("/c/" + dp.a[paramByte] + "/b" + paramShort + "_" + dp.a[paramByte] + "_data");
        } catch (Exception exception1) {}
        if (dataInputStream != null) {
          this.l = aq1;
          dp.a();
          try {
            byte b;
            for (b = 0; b < 3; b++) {
              for (paramByte = 0; paramByte < (this.f[b]).length; paramByte++) {
                this.f[b][paramByte] = dataInputStream.read();
                this.g[b][paramByte] = dataInputStream.read();
                this.h[b][paramByte] = dataInputStream.read();
                this.i[b][paramByte] = dataInputStream.read();
              } 
            } 
            for (b = 0; b < 4; b++) {
              for (paramByte = 0; paramByte < 6; paramByte++) {
                this.j[b][paramByte] = ak.a(dataInputStream);
                this.k[b][paramByte] = ak.a(dataInputStream);
              } 
            } 
            return;
          } catch (Exception exception1) {
            dw.a("loi ham char par" + exception1.toString());
            exception1.printStackTrace();
            return;
          } 
        } 
      } 
    } 
    cw cw;
    if ((cw = (cw)a.a(String.valueOf(paramByte) + "_" + paramShort)) == null) {
      this.b = ft.aj;
      cw = new cw();
      a.a(String.valueOf(paramByte) + "_" + paramShort, cw);
      b(paramByte, paramShort);
      return;
    } 
    if (cw.a != null) {
      this.l = cw.a;
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cw.c);
      DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
      dp.a();
      try {
        for (paramByte = 0; paramByte < 3; paramByte++) {
          for (paramShort = 0; paramShort < (this.f[paramByte]).length; paramShort++) {
            this.f[paramByte][paramShort] = dataInputStream.read();
            this.g[paramByte][paramShort] = dataInputStream.read();
            this.h[paramByte][paramShort] = dataInputStream.read();
            this.i[paramByte][paramShort] = dataInputStream.read();
          } 
        } 
        for (paramByte = 0; paramByte < 4; paramByte++) {
          for (paramShort = 0; paramShort < 6; paramShort++) {
            this.j[paramByte][paramShort] = ak.a(dataInputStream);
            this.k[paramByte][paramShort] = ak.a(dataInputStream);
          } 
        } 
      } catch (Exception exception1) {
        (exception = null).printStackTrace();
      } 
      a.a(cw);
      return;
    } 
    if ((ft.aj - this.b) / 1000L >= 15L)
      b(exception, paramShort); 
  }
  
  public fe(byte paramByte, short paramShort) {
    this.c = paramByte;
    this.d = paramShort;
    this.j = dw.a(4, 6);
    this.k = dw.a(4, 6);
    byte b = 0;
    switch (paramByte) {
      case 0:
      case 1:
        b = 5;
        break;
      case 2:
      case 3:
      case 4:
      case 5:
        b = 1;
        break;
      case 6:
        b = 2;
        break;
    } 
    this.f = dw.a(4, b);
    this.g = dw.a(4, b);
    this.h = dw.a(4, b);
    this.i = dw.a(4, b);
    a(paramByte, paramShort);
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      if (this.c < 0)
        return; 
      int i;
      if ((i = paramInt3) > 2)
        i = 2; 
      if (this.l != null && this.l.a != null) {
        int j = this.j[paramInt3][paramInt4];
        int k = this.k[paramInt3][paramInt4];
        if (paramInt3 > 2) {
          j = -this.j[i][paramInt4] - this.h[i][m[this.c][paramInt4]];
          k = this.k[i][paramInt4];
        } 
        parambx.a(this.l, this.f[i][m[this.c][paramInt4]], this.g[i][m[this.c][paramInt4]], this.h[i][m[this.c][paramInt4]], this.i[i][m[this.c][paramInt4]], (paramInt3 > 2) ? 2 : 0, paramInt1 + j, paramInt2 + k, 0);
        this.b = ft.aj;
        return;
      } 
      a(this.c, this.d);
      return;
    } catch (Exception exception) {
      dw.a("loi day ne " + this.d);
      return;
    } 
  }
  
  public final void b(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.c < 0)
      return; 
    if (this.l != null && this.l.a != null) {
      parambx.a(this.l, this.f[0][m[this.c][0]], this.g[0][m[this.c][0]], this.h[0][m[this.c][0]], this.i[0][m[this.c][0]], 0, paramInt1 + this.j[0][0], paramInt2 - this.i[0][m[this.c][0]] / 2, 0);
      this.b = ft.aj;
      return;
    } 
    a(this.c, this.d);
    parambx.a(cg.an, 0, ft.ai % 12 << 4, 16, 16, 0, paramInt1, paramInt2, 3);
  }
  
  private void b(byte paramByte, short paramShort) {
    this.b = ft.aj;
    q.a().a(paramByte, paramShort);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fe.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */