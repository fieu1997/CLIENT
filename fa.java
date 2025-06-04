import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public final class fa {
  private es b = new es();
  
  private es c = new es();
  
  private bi[] d;
  
  private byte[] e;
  
  private String f = "";
  
  public byte a = 0;
  
  private static byte[][] g = new byte[][] { { 
        0, 0, 1, 2, 3, 1, 1, 1, 1, 1, 
        1, 1, 1, 1 }, { 
        4, 4, 5, 6, 7, 5, 5, 5, 5, 5, 
        5, 5, 5, 5 } };
  
  static {
    (new byte[9])[2] = 1;
    (new byte[9])[3] = 2;
    (new byte[9])[4] = 3;
    (new byte[9])[5] = 1;
    (new byte[9])[6] = 1;
    (new byte[9])[7] = 1;
    (new byte[9])[8] = 1;
  }
  
  public fa(byte[] paramArrayOfbyte, int paramInt) {
    a(paramArrayOfbyte);
  }
  
  private void a(byte[] paramArrayOfbyte) {
    short s = 0;
    DataInputStream dataInputStream = null;
    ByteArrayInputStream byteArrayInputStream = null;
    this.b.d();
    this.c.d();
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3) {
    ed ed = (ed)this.c.a(g[paramInt3][paramInt2]);
    return (paramInt1 < this.a.length) ? this.a[paramInt1] : 0;
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, aq paramaq) {
    if (paramaq == null)
      return; 
    fj fj;
    if ((fj = (fj)this.b.a(paramInt1)) != null)
      fj.getClass(); 
    try {
      if (fj != null) {
        for (byte b = 0; b < fj.a.c(); b++) {
          fr fr = (fr)fj.a.a(b);
          bi bi1 = this.d[fr.e];
          int i = fr.a;
          int j = bi1.c;
          int k = bi1.d;
          short s2 = bi1.a;
          short s1 = bi1.b;
          if (s2 > aq.a(paramaq.a))
            s2 = 0; 
          if (s1 > aq.b(paramaq.a))
            s1 = 0; 
          if (s2 + j > aq.a(paramaq.a))
            j = aq.a(paramaq.a) - s2; 
          if (s1 + k > aq.b(paramaq.a))
            k = aq.b(paramaq.a) - s1; 
          if (paramInt4 == 2)
            i = -i - j; 
          parambx.a(paramaq, s2, s1, j, k, (fr.c != 1) ? paramInt4 : ((paramInt4 == 2) ? 0 : 2), paramInt2 + i, paramInt3 + fr.b, 0);
        } 
        return;
      } 
    } catch (Exception exception) {
      System.out.println("loi dataeff: " + this.f);
      exception.printStackTrace();
    } 
  }
  
  public final ed a(int paramInt1, int paramInt2) {
    return (ed)this.c.a(g[paramInt2][paramInt1]);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fa.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */