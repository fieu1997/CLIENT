public final class cp {
  public float a = 0.0F;
  
  public float b = 0.0F;
  
  public cp() {}
  
  public cp(float paramFloat1, float paramFloat2) {}
  
  public final void a(cp paramcp) {
    this.a = paramcp.a;
    this.b = paramcp.b;
  }
  
  public final cp a(float paramFloat1, float paramFloat2) {
    this.a += paramFloat1;
    this.b += paramFloat2;
    return this;
  }
  
  public final cp a() {
    float f;
    cp cp1;
    if ((f = ak.a((cp1 = this).a * cp1.a + cp1.b * cp1.b)) != 0.0F) {
      this.a /= f;
      this.b /= f;
    } 
    return this;
  }
  
  public static cp a(cp paramcp1, cp paramcp2) {
    float f2 = paramcp2.a - paramcp1.a;
    float f1 = paramcp2.b - paramcp1.b;
    return new cp(f2, f1);
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cp.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */