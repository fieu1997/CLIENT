import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

public final class cl {
  private SocketConnection a;
  
  public cl(String paramString, int paramInt) {
    try {
      this.a = (SocketConnection)Connector.open("socket://" + paramString + ":" + paramInt);
      return;
    } catch (IOException iOException) {
      (this = null).printStackTrace();
      return;
    } 
  }
  
  public final void a() {
    try {
      if (this.a != null) {
        this.a.close();
        return;
      } 
    } catch (IOException iOException) {
      (this = null).printStackTrace();
    } 
  }
  
  public final DataOutputStream b() {
    try {
      return this.a.openDataOutputStream();
    } catch (IOException iOException) {
      (this = null).printStackTrace();
      return null;
    } 
  }
  
  public final DataInputStream c() {
    try {
      return this.a.openDataInputStream();
    } catch (IOException iOException) {
      (this = null).printStackTrace();
      return null;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cl.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */