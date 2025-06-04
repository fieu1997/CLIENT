public final class du extends ez {
  private static byte[][] a = new byte[][] { { 
        5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 
        6, 6 }, { 
        0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 
        1, 1 }, { 
        0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 
        1, 1 }, { 
        0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 
        1, 1 } };
  
  public du(byte paramByte1, byte paramByte2, int paramInt1, int paramInt2) {
    this.ee = paramByte1;
    this.aY = paramInt1;
    this.aZ = paramInt2;
    this.cG = paramByte2;
    this.cF = 0;
    this.cu = 10;
  }
  
  public final void d_() {
    this.ef = (byte)(this.ef + 1);
    if (this.ef > (a[this.cG]).length - 1)
      this.ef = 0; 
  }
  
  public final void a(bx parambx) {
    if (this.ee == -1)
      return; 
    ce ce;
    if ((ce = ce.a(this.ee, 3, 5, 0)) != null) {
      parambx.a(ez.db, this.aY, this.aZ - 8, 3);
      ce.a(a[this.cG][this.ef], this.aY + this.ec, this.aZ - this.bo - this.bj + this.ed, (this.cG > 2) ? 2 : 0, 33, parambx);
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\du.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */