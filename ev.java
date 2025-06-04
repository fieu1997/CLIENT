public final class ev {
  public static ek a = new ek();
  
  public int b;
  
  public String c;
  
  public String d;
  
  public byte e;
  
  public byte f;
  
  public byte g;
  
  public short h;
  
  public short i;
  
  public short j;
  
  public fc[] k;
  
  public byte l;
  
  private String[] m;
  
  public final void a(bx parambx, int paramInt1, int paramInt2, int paramInt3) {
    fd fd;
    if ((fd = bk.h((short)this.f)).a != null) {
      parambx.a(this.a, paramInt1, paramInt2, 3);
      return;
    } 
    parambx.a(cg.an, 0, ft.ai % 12 << 4, 16, 16, 0, paramInt1, paramInt2, 3);
  }
  
  public final String[] a() {
    if (this.m == null)
      if (cn.f.by < this.i) {
        String[] arrayOfString = o.j.a(this.d, (fl.aU > 0) ? (fl.aU - 10) : 126);
        this.m = new String[arrayOfString.length + 1];
        if (cn.f.by < this.i)
          this.m[0] = String.valueOf(df.bl) + df.ac + this.i; 
        for (byte b = 1; b < this.m.length; b++)
          this.m[b] = arrayOfString[b - 1]; 
      } else {
        int i;
        if ((i = bq.I[this.b]) > 0)
          i += bq.J[this.b]; 
        int j;
        if ((j = i - 1) < 0)
          j = 0; 
        if (this.b == 0 || j >= 15)
          j = 0; 
        fc fc1 = this.k[j];
        fc fc2 = fc1;
        String[] arrayOfString3 = null;
        byte b = 0;
        if (fc2.a > 0)
          b++; 
        if (fc2.h > 0)
          b++; 
        if (fc2.i > 0)
          b++; 
        if (fc2.b > 0)
          b++; 
        if (fc2.c > 0)
          b++; 
        if (fc2.d > 0)
          b++; 
        if (fc2.g > 0)
          b++; 
        arrayOfString3 = new String[b];
        b = 0;
        if (fc2.a > 0) {
          b++;
          arrayOfString3[0] = String.valueOf(df.bm) + fc2.a;
        } 
        if (fc2.g > 0)
          arrayOfString3[b++] = String.valueOf(df.bn) + (fc2.g / 1000) + "s"; 
        if (fc2.h > 0)
          arrayOfString3[b++] = String.valueOf(df.bo) + (fc2.h / 1000) + "s"; 
        if (fc2.i > 0)
          arrayOfString3[b++] = String.valueOf(df.bp) + fc2.i; 
        if (fc2.b > 0)
          arrayOfString3[b++] = String.valueOf(df.bq) + (fc2.b / 1000) + "s"; 
        if (fc2.c > 0)
          arrayOfString3[b++] = String.valueOf(df.br) + (fc2.c / 10) + "%"; 
        if (fc2.d > 0)
          arrayOfString3[b] = String.valueOf(df.bs) + (fc2.d / 10) + "%"; 
        String[] arrayOfString2 = arrayOfString3;
        String[] arrayOfString1 = a(j, (bq.I[this.b] == 0));
        int k = arrayOfString2.length + arrayOfString1.length + fc1.k.length;
        this.m = new String[k];
        k = 0;
        for (b = 0; b < arrayOfString1.length; b++) {
          this.m[k] = arrayOfString1[b];
          k++;
        } 
        for (b = 0; b < arrayOfString2.length; b++) {
          this.m[k] = arrayOfString2[b];
          k++;
        } 
        for (b = 0; b < fc1.k.length; b++) {
          this.m[k] = String.valueOf(bw.d[(fc1.k[b]).a]) + ": " + bw.a(bw.f[(fc1.k[b]).a], (fc1.k[b]).b);
          k++;
        } 
      }  
    return this.m;
  }
  
  private String[] a(int paramInt, boolean paramBoolean) {
    String[] arrayOfString1 = null;
    int i = 0;
    String[] arrayOfString2 = o.j.a(this.d, (fl.aU > 0) ? (fl.aU - 10) : 126);
    i = 0 + arrayOfString2.length + 1;
    if (paramBoolean) {
      i++;
    } else if (bq.I[this.b] < 10 && this.b != 0) {
      i++;
    } 
    if (this.e == 1)
      i++; 
    if ((this.k[paramInt]).f > 0)
      i++; 
    arrayOfString1 = new String[i];
    i = 0;
    if (paramBoolean) {
      arrayOfString1[0] = df.bk;
      i++;
    } else if (bq.I[this.b] < 10 && this.b != 0) {
      arrayOfString1[0] = String.valueOf(df.dN) + (this.k[paramInt]).e;
      i++;
    } 
    String str = "[" + df.bB + df.bz + "]";
    if (this.e == 1) {
      str = "[" + df.bB + df.by + "]";
    } else if (this.e == 2) {
      str = "[" + df.bB + df.bA + "]";
    } 
    arrayOfString1[i] = str;
    i++;
    for (byte b = 0; b < arrayOfString2.length; b++) {
      arrayOfString1[i] = arrayOfString2[b];
      i++;
    } 
    if (this.e == 1) {
      String str1 = String.valueOf(df.cM) + " : ";
      switch (this.g) {
        case 0:
          str1 = String.valueOf(str1) + df.bv;
          break;
        case 1:
          str1 = String.valueOf(str1) + df.bu;
          break;
        case 2:
          str1 = String.valueOf(str1) + df.bw;
          break;
        case 3:
          str1 = String.valueOf(str1) + df.bx;
          break;
      } 
      arrayOfString1[i++] = str1;
    } 
    if ((this.k[paramInt]).f > 0)
      arrayOfString1[i] = String.valueOf(df.bt) + (this.k[paramInt]).f; 
    return arrayOfString1;
  }
  
  public static void b() {
    for (byte b = 0; b < y.a.c(); b++) {
      ev ev1;
      (ev1 = (ev)y.a.a(b)).m = null;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ev.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */