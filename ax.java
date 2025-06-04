import java.io.IOException;
import java.util.Vector;

final class ax implements Runnable {
  public final Vector a;
  
  private l b;
  
  public ax(l paraml) {
    this.b = paraml;
    this.a = new Vector();
  }
  
  public final void run() {
    try {
      while (this.b.c) {
        if (this.b.g)
          while (this.a.size() > 0) {
            eo eo = this.a.elementAt(0);
            this.a.removeElementAt(0);
            l.a(this.b, eo);
          }  
        try {
          Thread.sleep(10L);
        } catch (InterruptedException interruptedException) {}
      } 
      return;
    } catch (IOException iOException2) {
      IOException iOException1;
      (iOException1 = null).printStackTrace();
      return;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ax.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */