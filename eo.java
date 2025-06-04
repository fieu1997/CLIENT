import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public final class eo {
  public byte a;
  
  private ByteArrayOutputStream b = null;
  
  private DataOutputStream c = null;
  
  private ByteArrayInputStream d = null;
  
  private DataInputStream e = null;
  
  public eo() {}
  
  public eo(byte paramByte) {
    this.a = paramByte;
    this.b = new ByteArrayOutputStream();
    this.c = new DataOutputStream(this.b);
  }
  
  public eo(byte paramByte, byte[] paramArrayOfbyte) {
    this.a = paramByte;
    this.d = new ByteArrayInputStream(paramArrayOfbyte);
    this.e = new DataInputStream(this.d);
  }
  
  public final byte[] a() {
    return this.b.toByteArray();
  }
  
  public final DataInputStream b() {
    return this.e;
  }
  
  public final DataOutputStream c() {
    return this.c;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\eo.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */