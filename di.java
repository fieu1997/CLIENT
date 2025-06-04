import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class di implements Runnable {
  public static es a = new es("SaveImageRMS vecSaveImage");
  
  private static es b = new es("SaveImageRMS vecSaveCharPart");
  
  public final void run() {
    while (true) {
      boolean bool = false;
      while (b.c() > 0) {
        bool = true;
        cw cw = (cw)b.a(0);
        try {
          ak.a("img_data_char_" + Character.MIN_VALUE + "_" + Character.MIN_VALUE, cw.a().toByteArray());
        } catch (Exception exception) {}
        b.b(0);
      } 
      if (bool) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
          dataOutputStream.writeShort(ft.I);
          ak.a("isIndexPart", byteArrayOutputStream.toByteArray());
          dataOutputStream.close();
        } catch (Exception exception) {}
      } 
      if (a.c() > 0) {
        try {
          an an;
          bk.a((an = (an)a.a(0)).b, an.a);
          a.b(0);
        } catch (Exception exception) {}
        continue;
      } 
      break;
    } 
  }
  
  public final void a() {
    (new Thread(this)).start();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\di.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */