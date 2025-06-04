public final class fm extends cg {
  public int a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public String e;
  
  public String f;
  
  public boolean g = false;
  
  public fm(int paramInt1, int paramInt2, String paramString1, String paramString2) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = paramString1;
    this.f = paramString2;
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 1:
        q.a().a((byte)paramInt2, this.e);
        this.g = true;
        ft.j();
        break;
      case 2:
        if (paramInt2 == 1)
          q.a().b((byte)2, this.e); 
        this.g = true;
        ft.j();
        return;
      case 3:
        if (paramInt2 == 1)
          q.a().a((byte)1, this.e, (byte)0, (short)0, 0); 
        this.g = true;
        ft.j();
        return;
      case 4:
        if (paramInt2 == 1) {
          q.a().c((byte)1, this.e);
        } else if (paramInt2 == 2) {
          q.a().a(this.e, (byte)1);
        } 
        this.g = true;
        ft.j();
        return;
      case 5:
        if (paramInt2 == 1)
          q.a().d((byte)11, this.e); 
        this.g = true;
        ft.j();
        break;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fm.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */