final class h implements Runnable {
  private final String b;
  
  private final int c;
  
  final l a;
  
  h(l paraml, String paramString, int paramInt) {
    this.a = paraml;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public final void run() {
    l.j = false;
    (new Thread(new cm(this))).start();
    this.a.d = true;
    Thread.currentThread().setPriority(1);
    this.a.c = true;
    try {
      int i = this.c;
      String str = this.b;
      h h1;
      l.a((h1 = this).a, new cl(str, i));
      l.a(h1.a, l.a(h1.a).b());
      h1.a.a = l.a(h1.a).c();
      (new Thread(l.b(h1.a))).start();
      h1.a.e = new Thread(new al(h1.a));
      h1.a.e.start();
      h1.a.i = dw.a();
      l.a(h1.a, new eo((byte)-40));
      h1.a.d = false;
      return;
    } catch (Exception exception) {
      try {
        Thread.sleep(500L);
      } catch (InterruptedException interruptedException) {}
      if (l.j)
        return; 
      if (this.a.b != null)
        this.a.c(); 
      return;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\h.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */