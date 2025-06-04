import java.util.Vector;

public class es {
  private Vector a = new Vector();
  
  public es() {}
  
  public es(String paramString) {}
  
  public final void a(Object paramObject) {
    this.a.addElement(paramObject);
  }
  
  public final boolean b(Object paramObject) {
    return this.a.contains(paramObject);
  }
  
  public final int c() {
    return (this.a == null) ? 0 : this.a.size();
  }
  
  public final Object a(int paramInt) {
    return (paramInt > -1 && paramInt < this.a.size()) ? this.a.elementAt(paramInt) : null;
  }
  
  public final void a(Object paramObject, int paramInt) {
    if (paramInt > -1 && paramInt < this.a.size())
      this.a.setElementAt(paramObject, paramInt); 
  }
  
  public final int c(Object paramObject) {
    return this.a.indexOf(paramObject);
  }
  
  public final void b(int paramInt) {
    if (paramInt > -1 && paramInt < this.a.size())
      this.a.removeElementAt(paramInt); 
  }
  
  public final void d(Object paramObject) {
    this.a.removeElement(paramObject);
  }
  
  public final void d() {
    this.a.removeAllElements();
  }
  
  public final void b(Object paramObject, int paramInt) {
    this.a.insertElementAt(paramObject, paramInt);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\es.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */