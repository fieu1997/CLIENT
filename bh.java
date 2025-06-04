public final class bh implements Runnable {
  private int a = -1;
  
  private int b = -1;
  
  private int c = -1;
  
  private int d = -1;
  
  private int e = -1;
  
  public final void a(int paramInt1, int paramInt2, int paramInt3) {
    if (this.c == -1 && this.d == -1) {
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
    } 
  }
  
  public final void run() {
    while (true) {
      try {
        Thread.sleep(500L);
      } catch (InterruptedException interruptedException2) {
        InterruptedException interruptedException1;
        (interruptedException1 = null).printStackTrace();
        dw.a("loi Cres 6");
      } 
      if (this.a != -1 && this.b != -1) {
        ak.b(0, this.a, this.b);
        this.a = -1;
        this.b = -1;
      } 
      if (this.c != -1 && this.d != -1) {
        ak.a(this.c, this.d, this.e);
        this.c = -1;
        this.d = -1;
      } 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bh.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */