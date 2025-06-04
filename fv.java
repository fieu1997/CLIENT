public final class fv extends ez {
  private long a;
  
  private int b;
  
  private int c;
  
  public fv(int paramInt1, byte paramByte1, String paramString, int paramInt2, int paramInt3, short paramShort, byte paramByte2) {
    this.ct = paramInt1;
    this.cu = paramByte1;
    this.cB = paramString;
    if (paramInt2 < 48)
      paramInt2 = 48; 
    if (paramInt2 > ft.p.g - 48)
      paramInt2 = ft.p.g - 48; 
    if (paramInt3 < 48)
      paramInt3 = 48; 
    if (paramInt3 > ft.p.h - 48)
      paramInt3 = ft.p.h - 48; 
    this.aY = paramInt2;
    this.aZ = paramInt3;
    this.cS = paramShort;
    this.cs = paramByte2;
    this.bb = ak.b(1, 5);
    this.bc = -ak.c(3, 10);
    this.bi = 16;
    this.dV = ak.c(3, 9);
    this.a = ft.aj;
    this.b = 60;
    this.dy = false;
  }
  
  public final void a(bx parambx) {
    fd fd = null;
    switch (this.cu) {
      case 3:
        fd = bk.d((short)this.cS);
        break;
      case 4:
        fd = bk.e((short)this.cS);
        break;
      case 5:
        fd = bk.f((short)this.cS);
        break;
      case 7:
        fd = bk.g((short)this.cS);
        break;
    } 
    if (fd.a != null) {
      if (this.be == 0)
        this.be = aq.b(fd.a.a); 
      parambx.a(fd.a, this.aY, this.aZ, 33);
      if (this.cu == 3 && this.cs > 1)
        bw.w.b((this.cs - 1) * 3 + ft.ai / 3 % 3, this.aY + 6, this.aZ - 14, 0, 3, parambx); 
    } 
    if (this.cV)
      parambx.a(ez.dd, 0, ft.ai / 2 % 2 * 17, 28, 17, 0, this.aY, this.aZ - 2 + this.bk, 3); 
    if (cf.I) {
      byte b = 0;
      if (this.cu == 3)
        b = this.cs; 
      a(parambx, b);
    } 
  }
  
  public final void a(bx parambx, int paramInt1, int paramInt2) {
    fd fd = null;
    switch (this.cu) {
      case 3:
        fd = bk.d((short)this.cS);
        break;
      case 4:
        fd = bk.e((short)this.cS);
        break;
      case 5:
        fd = bk.f((short)this.cS);
        break;
      case 7:
        fd = bk.g((short)this.cS);
        break;
    } 
    if (fd.a != null) {
      if (this.be == 0)
        this.be = aq.b(fd.a.a); 
      parambx.a(fd.a, paramInt1 - 1, paramInt2, 3);
    } 
  }
  
  public final void a() {
    if (this.dV > 0) {
      this.aY += this.bb;
      this.aZ += this.bc;
      this.bc += 2;
      this.dV--;
    } 
    if (this.dV == 0) {
      int i;
      if ((i = ft.p.a(this.aY, this.aZ)) == 2)
        this.cV = true; 
      this.cU = false;
      this.dV = -1;
    } 
    if (this.cU) {
      this.c++;
      this.aY += this.bb;
      this.aZ += this.bc;
      if (this.c >= this.bE) {
        this.cK = true;
        this.cU = false;
      } 
    } 
    if (this.dy) {
      this.dz++;
      if (this.dz > 40) {
        this.dy = false;
        this.dz = 0;
      } 
    } 
    if ((ft.aj - this.a) / 1000L >= this.b)
      this.cK = true; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fv.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */