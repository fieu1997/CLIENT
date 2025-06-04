import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class cw {
  public aq a;
  
  public long b = 0L;
  
  public byte[] c = null;
  
  private byte[] d = null;
  
  public cw() {}
  
  public cw(aq paramaq, byte[] paramArrayOfbyte) {
    this.a = paramaq;
    this.c = paramArrayOfbyte;
  }
  
  public final ByteArrayOutputStream a() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      dataOutputStream.writeShort(0);
      dataOutputStream.writeInt(null.length);
      dataOutputStream.write((byte[])null);
      dataOutputStream.writeShort(this.c.length);
      dataOutputStream.write(this.c);
    } catch (Exception exception) {}
    return byteArrayOutputStream;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cw.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */