import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public final class bc {
  public static ek a = new ek();
  
  public ek b = new ek();
  
  public fy[] c;
  
  short[] d;
  
  public bc(int paramInt, byte[] paramArrayOfbyte) {
    a(paramInt, paramArrayOfbyte);
  }
  
  private void a(int paramInt, byte[] paramArrayOfbyte) {
    try {
      DataInputStream dataInputStream1;
      DataInputStream dataInputStream2;
      ByteArrayInputStream byteArrayInputStream = null;
      if (paramArrayOfbyte != null) {
        byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
      } else {
        dataInputStream2 = aq.b("/eff_" + paramInt);
      } 
      if (paramInt < 34) {
        dataInputStream1 = new DataInputStream(dataInputStream2);
      } else {
        dataInputStream1 = new DataInputStream(dataInputStream2);
      } 
      int i = dataInputStream1.readUnsignedByte();
      short s1;
      for (s1 = 0; s1 < i; s1++) {
        fg fg = new fg(dataInputStream1.readUnsignedByte(), dataInputStream1.readUnsignedByte(), dataInputStream1.readUnsignedByte(), dataInputStream1.readUnsignedByte(), dataInputStream1.readUnsignedByte());
        this.b.a(fg.e, fg);
      } 
      s1 = dataInputStream1.readShort();
      this.c = new fy[s1];
      short s2;
      for (s2 = 0; s2 < s1; s2++) {
        i = dataInputStream1.readByte();
        this.c[s2] = new fy();
        (this.c[s2]).a = new eb[i];
        for (byte b = 0; b < i; b++) {
          (this.c[s2]).a[b] = new eb();
          ((this.c[s2]).a[b]).a = dataInputStream1.readShort();
          ((this.c[s2]).a[b]).b = dataInputStream1.readShort();
          ((this.c[s2]).a[b]).c = dataInputStream1.readByte();
        } 
      } 
      s2 = dataInputStream1.readShort();
      this.d = new short[s2];
      for (i = 0; i < s2; i++)
        this.d[i] = dataInputStream1.readShort(); 
      dataInputStream1.readByte();
      dataInputStream1.readByte();
      return;
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      dw.a("err effauto 2 id=" + paramInt);
      return;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bc.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */