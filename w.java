public final class w {
  public String a;
  
  public es b = new es("MainParty vecPartys");
  
  private boolean c = false;
  
  public w(String paramString, short paramShort, int paramInt, byte paramByte) {
    this.a = paramString;
    this.b.d();
    this.c = false;
    a(paramString, paramShort, paramInt, paramByte);
  }
  
  public final void a(String paramString, short paramShort, int paramInt, byte paramByte) {
    aj aj;
    (aj = new aj(paramString, paramShort, paramInt, paramByte)).h = 10;
    aj.g = 10;
    this.b.a(aj);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    for (byte b = 0; b < this.b.c(); b++) {
      aj aj;
      if ((aj = (aj)this.b.a(b)).b.compareTo(paramString) == 0) {
        aj.d = paramInt1;
        aj.e = paramInt2;
        if (paramInt3 > paramInt4)
          paramInt3 = paramInt4; 
        aj.g = paramInt3;
        aj.h = paramInt4;
        return;
      } 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\w.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */