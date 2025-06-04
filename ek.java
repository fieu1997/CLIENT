import java.util.Hashtable;

public final class ek {
  public Hashtable a = new Hashtable();
  
  public final Object a(String paramString) {
    return this.a.get(paramString);
  }
  
  public final void a(String paramString, Object paramObject) {
    if (this.a.containsKey(paramString))
      this.a.remove(paramString); 
    this.a.put(paramString, paramObject);
  }
  
  public final void a(Object paramObject) {
    this.a.remove(paramObject);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ek.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */