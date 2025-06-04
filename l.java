import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class l {
  private static l l = new l();
  
  private DataOutputStream m;
  
  public DataInputStream a;
  
  public bo b;
  
  private cl n;
  
  public boolean c;
  
  public boolean d;
  
  private final ax o = new ax(this);
  
  private Thread p;
  
  public Thread e;
  
  private int q;
  
  public int f;
  
  boolean g;
  
  public byte[] h = null;
  
  private byte r;
  
  private byte s;
  
  long i;
  
  public static boolean j;
  
  public static int k = 0;
  
  public static l a() {
    return l;
  }
  
  public final boolean b() {
    return this.c;
  }
  
  public final void a(bo parambo) {
    this.b = parambo;
  }
  
  public final void a(String paramString, int paramInt) {
    System.out.println("------------IP host:" + paramString + "--port:" + paramInt);
    if (this.c || this.d)
      return; 
    ax ax1;
    if ((ax1 = this.o).a != null)
      ax1.a.removeAllElements(); 
    this.g = false;
    this.n = null;
    this.p = new Thread(new h(this, paramString, paramInt));
    this.p.start();
  }
  
  public final void a(eo parameo) {
    parameo = parameo;
    ax ax1;
    (ax1 = this.o).a.addElement(parameo);
  }
  
  private synchronized void b(eo parameo) {
    byte[] arrayOfByte = parameo.a();
    try {
      byte b;
      if (this.g) {
        b = a(parameo.a);
        this.m.writeByte(b);
      } else {
        this.m.writeByte(b.a);
      } 
      if (arrayOfByte != null) {
        int i = arrayOfByte.length;
        if (this.g) {
          byte b1 = a((byte)(i >> 8));
          this.m.writeByte(b1);
          i = a((byte)i);
          this.m.writeByte(i);
        } else {
          this.m.writeShort(i);
        } 
        if (this.g)
          for (byte b1 = 0; b1 < arrayOfByte.length; b1++)
            arrayOfByte[b1] = a(arrayOfByte[b1]);  
        this.m.write(arrayOfByte);
        this.q += 5 + arrayOfByte.length;
      } else {
        this.m.writeShort(0);
        this.q += 5;
      } 
      this.m.flush();
      return;
    } catch (IOException iOException) {
      (parameo = null).printStackTrace();
      return;
    } 
  }
  
  private byte a(byte paramByte) {
    this.s = (byte)(this.s + 1);
    paramByte = (byte)(this.h[this.s] & 0xFF ^ paramByte & 0xFF);
    if (this.s >= this.h.length)
      this.s = (byte)(this.s % this.h.length); 
    return paramByte;
  }
  
  public final void c() {
    d();
  }
  
  private void d() {
    this.h = null;
    this.r = 0;
    this.s = 0;
    try {
      this.c = false;
      this.d = false;
      if (this.n != null) {
        this.n.a();
        this.n = null;
      } 
      if (this.m != null) {
        this.m.close();
        this.m = null;
      } 
      if (this.a != null) {
        this.a.close();
        this.a = null;
      } 
      this.e = null;
      System.gc();
      return;
    } catch (Exception exception) {
      (this = null).printStackTrace();
      return;
    } 
  }
  
  static cl a(l paraml) {
    return paraml.n;
  }
  
  static void a(l paraml, cl paramcl) {
    paraml.n = paramcl;
  }
  
  static void a(l paraml, DataOutputStream paramDataOutputStream) {
    paraml.m = paramDataOutputStream;
  }
  
  static ax b(l paraml) {
    return paraml.o;
  }
  
  static void a(l paraml, eo parameo) {
    paraml.b(parameo);
  }
  
  static void c(l paraml) {
    paraml.d();
  }
  
  static byte a(l paraml, byte paramByte) {
    paramByte = paramByte;
    paraml.r = (byte)(paraml.r + 1);
    paramByte = (byte)((paraml = paraml).h[paraml.r] & 0xFF ^ paramByte & 0xFF);
    if (paraml.r >= paraml.h.length)
      paraml.r = (byte)(paraml.r % paraml.h.length); 
    return paramByte;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\l.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */