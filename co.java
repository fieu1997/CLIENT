import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class co {
  public static boolean a = false;
  
  public static boolean b = true;
  
  public static String c = "";
  
  public static void a() {
    q.a().a((byte)1, (byte)0, (byte[])null);
    a((byte)0, null);
  }
  
  public static void a(byte paramByte, byte[] paramArrayOfbyte) {
    boolean bool;
    switch (paramByte) {
      case 0:
        if (cn.f != null) {
          y.a(paramArrayOfbyte);
          return;
        } 
        break;
      case 1:
        cn.p.b(paramArrayOfbyte);
        ft.d.f = true;
        if (!ft.D && !f.a && (cn.p.a > 0 || cn.p.b > -5)) {
          cn.M = true;
          ft.j();
          bq.m = false;
          return;
        } 
        break;
      case 2:
        cn.p.a(paramArrayOfbyte);
        a = true;
        return;
      case 3:
        if (paramArrayOfbyte != null) {
          byte[] arrayOfByte = paramArrayOfbyte;
          c = "";
          bool = false;
          bq.l = (arrayOfByte[0] == 1);
          ah.e[0] = arrayOfByte[1];
          ah.e[1] = arrayOfByte[2];
          if (bq.l && cf.J) {
            bool = true;
            c = String.valueOf(c) + df.cH + "\n  +" + df.gr[0] + ah.e[0] + "%\n  +" + df.gr[1] + ah.e[1] + "%";
          } 
          int i;
          if (i = (arrayOfByte[3] == 1) ? 1 : 0)
            bq.q = new be(arrayOfByte[4], arrayOfByte[5], arrayOfByte[6]); 
          if (i && cf.J) {
            if (bool) {
              c = String.valueOf(c) + "\n";
            } else {
              bool = true;
            } 
            c = String.valueOf(c = String.valueOf(c = String.valueOf(c) + df.di + "\n  +" + df.gu[0] + ": " + df.gI[0][bq.q.a]) + "\n  +" + df.gu[1] + ": " + df.gI[1][bq.q.b]) + "\n  +" + df.gu[2] + ": " + df.gI[2][bq.q.c];
          } 
          bq.p = arrayOfByte[7];
          i = ah.b;
          if (arrayOfByte.length - 7 >= i)
            i -= ak.e(i - arrayOfByte.length - 7) + 1; 
          byte b;
          for (b = 0; b < i; b++)
            ah.f[b][1] = arrayOfByte[b + 8]; 
          if (bq.p == 1 && cf.J) {
            if (bool)
              c = String.valueOf(c) + "\n"; 
            c = String.valueOf(c) + df.ev;
            for (b = 0; b < i; b++) {
              if (ah.f[b][1] == 1) {
                ev ev = (ev)y.a.a(ah.f[b][2]);
                c = String.valueOf(c) + "\n  " + ev.c;
              } 
            } 
          } 
          if (c.length() > 0 && b && ft.a == ft.c) {
            b = false;
            ft.b(String.valueOf(df.cJ) + "\n  " + c, df.cI);
          } 
          return;
        } 
        break;
      case 4:
        if (bool != null) {
          if (ft.A) {
            cf.I = (bool[0] == true);
            cf.h();
          } 
          if (bool.length > 1)
            cf.J = (bool[1] == true); 
        } 
        break;
    } 
  }
  
  public static void b() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      dataOutputStream.writeByte(bq.l ? 1 : 0);
      dataOutputStream.writeByte(ah.e[0]);
      dataOutputStream.writeByte(ah.e[1]);
      dataOutputStream.writeByte((bq.q == null) ? 0 : 1);
      if (bq.q == null) {
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
      } else {
        dataOutputStream.writeByte(bq.q.a);
        dataOutputStream.writeByte(bq.q.b);
        dataOutputStream.writeByte(bq.q.c);
      } 
      dataOutputStream.writeByte(bq.p);
      for (byte b = 0; b < ah.b; b++)
        dataOutputStream.writeByte(ah.f[b][1]); 
      ak.a((byte)3, byteArrayOutputStream.toByteArray());
      dataOutputStream.close();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void c() {
    byte[] arrayOfByte;
    (arrayOfByte = new byte[2])[0] = (byte)(cf.I ? 1 : 0);
    arrayOfByte[1] = (byte)(cf.J ? 1 : 0);
    try {
      ak.a((byte)4, arrayOfByte);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\co.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */