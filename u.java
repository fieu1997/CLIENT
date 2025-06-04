import com.silverknight.TemMidlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public final class u extends p {
  private int b;
  
  public static String a = "";
  
  public u() {
    try {
      byte[] arrayOfByte = ak.a("listServer");
      boolean bool = false;
      if (this != null) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this);
        DataInputStream dataInputStream;
        a = (dataInputStream = new DataInputStream(this)).readUTF();
        byte[] arrayOfByte1;
        if ((arrayOfByte1 = ak.a("isIndexServer")) == null)
          bool = true; 
      } else {
        a = TemMidlet.c(ft.O);
        bool = true;
      } 
      a(a, bool);
      return;
    } catch (Exception exception) {
      (this = null).printStackTrace();
      return;
    } 
  }
  
  public final void a(bx parambx) {
    parambx.a(0);
    parambx.c(0, 0, ft.W, ft.X);
  }
  
  public final void a() {
    this.b++;
    if (this.b > 60) {
      this.b = 0;
      ft.b.c();
    } 
  }
  
  public static void a(String paramString, boolean paramBoolean) {
    if (ft.H == 0 || ft.H == 1 || ft.H == 3 || ft.H == 4 || ft.H == 5 || ft.H == 6)
      return; 
    if (ft.H == 2) {
      b();
      return;
    } 
    if (paramString == null || paramString.length() == 0)
      return; 
    if (cd.a)
      return; 
    String str = paramString;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      dataOutputStream.writeUTF(str);
      ak.a("listServer", byteArrayOutputStream.toByteArray());
      dataOutputStream.close();
    } catch (Exception exception) {}
    String[] arrayOfString;
    dw.a = new String[(arrayOfString = o.a(paramString.trim(), ",")).length - 1][2];
    ft.L = new int[arrayOfString.length - 1];
    ft.M = new int[arrayOfString.length - 1];
    if (paramBoolean)
      ft.H = (byte)(arrayOfString.length - 1); 
    for (byte b = 0; b < arrayOfString.length - 1; b++) {
      String[] arrayOfString1 = o.a(arrayOfString[b].trim(), ":");
      dw.a[b][0] = arrayOfString1[0];
      dw.a[b][1] = arrayOfString1[1];
      ft.L[b] = Short.parseShort(arrayOfString1[2]);
      ft.M[b] = Byte.parseByte(arrayOfString1[3].trim());
      if (paramBoolean && ft.M[b] == 0 && ft.D)
        ft.H = (byte)b; 
    } 
    ft.D = (ft.M[ft.H] == 0);
    b();
  }
  
  public static void b() {
    co.c = "";
    bs.k = 1;
    if (ft.W < 200 || ft.X < 200) {
      bs.k = 2;
    } else if (ft.A && ft.W < 380 && ft.W > 315 && ft.W < 380) {
      bs.k = 2;
    } 
    ft.a(df.aG, (bt)null);
    if (!ft.D) {
      bs.l = aq.a("/interface/logoe.png");
    } else {
      bs.l = aq.a("/interface/logo.png");
    } 
    f.a();
    cd.a();
    ag.b().g();
    ft.a();
    ck.a = null;
    ft.j();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar\\u.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */