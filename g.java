import com.silverknight.TemMidlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

final class g implements CommandListener {
  private fi a;
  
  private final TextBox b;
  
  g(fi paramfi, TextBox paramTextBox) {
    this.a = paramfi;
    this.b = paramTextBox;
  }
  
  public final void commandAction(Command paramCommand, Displayable paramDisplayable) {
    fi.k = false;
    this.a.e = false;
    if (paramCommand.getLabel().equals("OK")) {
      this.a.b(this.b.getString());
      if (d.b) {
        if ((d.b()).a.j().length() > 0) {
          cn.f.cE = (d.b()).a.j();
          q.a().a((d.b()).a.j());
          (d.b()).a.b("");
        } 
        d.b = false;
      } else if (ft.s != null && ft.s == ft.g) {
        et.c.a();
      } 
    } 
    if (paramCommand.getLabel().equals("Cancel") && d.b)
      d.b = false; 
    Display.getDisplay((MIDlet)TemMidlet.b).setCurrent((Displayable)TemMidlet.a);
    TemMidlet.a.setFullScreenMode(true);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\g.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */