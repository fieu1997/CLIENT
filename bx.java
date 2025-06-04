import javax.microedition.lcdui.Graphics;

public final class bx {
  public Graphics a;
  
  public static int b = 1;
  
  private int c;
  
  private int d;
  
  public final void a(aq paramaq, int paramInt1, int paramInt2, int paramInt3) {
    paramInt1 *= b;
    paramInt2 *= b;
    this.a.drawImage(paramaq.a, paramInt1, paramInt2, paramInt3);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    for (byte b = 0; b < b; b++) {
      this.a.drawLine(paramInt1 + b, paramInt2 + b, paramInt3 + b, paramInt4 + b);
      if (b > 0) {
        this.a.drawLine(paramInt1 + b, paramInt2, paramInt3 + b, paramInt4);
        this.a.drawLine(paramInt1, paramInt2 + b, paramInt3, paramInt4 + b);
      } 
    } 
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    for (byte b = 0; b < b; b++)
      this.a.drawRect(paramInt1 + b, paramInt2 + b, paramInt3 - (b << 1), paramInt4 - (b << 1)); 
  }
  
  public final void a(aq paramaq, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    paramInt6 *= b;
    paramInt7 *= b;
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    this.a.drawRegion(paramaq.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    this.a.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    paramInt5 *= b;
    paramInt6 *= b;
    this.a.fillRoundRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    paramInt5 *= b;
    paramInt6 *= b;
    this.a.fillTriangle(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public final int a() {
    return this.a.getTranslateX() / b;
  }
  
  public final int b() {
    return this.a.getTranslateY() / b;
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    this.a.setClip(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(int paramInt) {
    this.a.setColor(paramInt);
  }
  
  public final void b(int paramInt) {
    this.a.setColor(0);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    paramInt1 *= b;
    paramInt2 *= b;
    this.a.translate(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    b(0, 0, ft.p.e * 24, paramInt2, paramInt5);
    b(0, paramInt2, paramInt1, ft.p.f * 24 - paramInt2, paramInt5);
    b(paramInt1, paramInt2 + paramInt4, ft.p.e * 24 - paramInt1, ft.p.f * 24 - paramInt2 + paramInt4, paramInt5);
    b(paramInt1 + paramInt3, paramInt2, ft.p.e * 24 - paramInt1 + paramInt3, paramInt4, paramInt5);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    a(paramInt5);
    c(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 *= b;
    paramInt2 *= b;
    paramInt3 *= b;
    paramInt4 *= b;
    if (this.c != aq.a(cg.aw.a))
      this.c = aq.a(cg.aw.a); 
    if (this.d != aq.b(cg.aw.a))
      this.d = aq.b(cg.aw.a); 
    d(paramInt1, paramInt2, paramInt3, paramInt4);
    for (int i = paramInt1 % this.c; i < paramInt3 + this.c; i += this.c) {
      for (int j = paramInt2 % this.d; j < paramInt4 + this.d; j += this.d)
        a(cg.aw, paramInt1 + paramInt3 - i, paramInt2 + paramInt4 - j, 20); 
    } 
    d(-this.a.getTranslateX(), -this.a.getTranslateY(), ft.W, ft.X);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bx.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */