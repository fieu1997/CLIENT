public final class ew extends cg {
  public static es a = new es("MainQuest vecQuestList");
  
  public static es b = new es("MainQuest vecQuestFinish");
  
  public static es c = new es("MainQuest vecQuestDoing_Main");
  
  public static es d = new es("MainQuest vecQuestDoing_Sub");
  
  public byte e;
  
  public int f;
  
  public int g;
  
  public int h;
  
  public int i;
  
  private int r;
  
  public boolean j;
  
  public String k;
  
  public String l;
  
  private String[] s;
  
  public String[] m;
  
  private String t;
  
  public String n;
  
  public short[] o;
  
  public short[] p;
  
  public short[] q;
  
  private int u = 0;
  
  public ew(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2, byte paramByte, String paramString3) {
    this.f = paramInt1;
    this.j = paramBoolean;
    this.h = paramInt2;
    this.i = paramInt2;
    this.k = paramString1;
    this.t = paramString3;
    this.e = paramByte;
    this.r = 0;
    this.s = o.a(paramString2, ">");
  }
  
  public ew(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2, String paramString3) {
    this.f = paramInt1;
    this.j = paramBoolean;
    this.g = paramInt2;
    this.i = paramInt2;
    this.k = paramString1;
    this.t = paramString3;
    this.m = o.j.a(paramString3, fl.S - 35);
    this.r = 1;
    this.s = o.a(paramString2, ">");
  }
  
  public ew(int paramInt1, boolean paramBoolean, String paramString1, String paramString2, byte paramByte, String paramString3, int paramInt2, short[] paramArrayOfshort1, short[] paramArrayOfshort2, short[] paramArrayOfshort3) {
    this.f = paramInt1;
    this.j = paramBoolean;
    this.g = paramInt2;
    this.i = paramInt2;
    this.k = paramString1;
    this.e = paramByte;
    this.l = paramString3;
    this.t = paramString2;
    this.o = paramArrayOfshort1;
    this.p = paramArrayOfshort2;
    this.q = paramArrayOfshort3;
  }
  
  public ew(int paramInt1, boolean paramBoolean, String paramString1, String paramString2, int paramInt2, String paramString3) {
    this.f = paramInt1;
    this.j = paramBoolean;
    this.k = paramString1;
    this.l = paramString3;
    this.t = paramString2;
    this.g = paramInt2;
    this.i = paramInt2;
  }
  
  public final void a(int paramInt1, int paramInt2) {
    ez ez;
    String str;
    switch (paramInt1) {
      case 0:
        if (ft.o.b != null && !ft.o.b.a())
          return; 
        g();
        return;
      case 1:
        if (ft.o.b != null && !ft.o.b.a())
          return; 
        if ((ez = ez.a(this.i, (byte)2)) != null)
          ez.dk = null; 
        if ((str = this.t) == null)
          str = "sai roi"; 
        cn.f.dk = null;
        if (this.e == 3) {
          q.a().a((short)this.f, (byte)(this.j ? 0 : 1), (byte)1);
        } else {
          ft.a(str, this.k, this.f, this.r, (byte)(this.j ? 0 : 1));
        } 
        cn.f.M = null;
        (cn.b()).aa = null;
        ft.m();
        ft.S = false;
        break;
    } 
  }
  
  public final void b() {
    this.u = 0;
    cn.f.M = this;
    g();
  }
  
  public final void c() {
    if (this.l == null || ez.a(this.i, (byte)2) == null)
      return; 
    (ez.a(this.i, (byte)2)).cE = this.t;
  }
  
  private bt f() {
    bt bt = null;
    if (this.u < this.s.length - 1) {
      bt = new bt(df.aa, 0, this);
    } else {
      bt = new bt(df.aa, 1, this);
    } 
    return bt;
  }
  
  private void g() {
    if (ez.a(this.i, (byte)2) == null) {
      cn.f.M = null;
      return;
    } 
    if (this.s[this.u].trim().startsWith("0")) {
      (ez.a(this.i, (byte)2)).dk = null;
      es es1 = new es("MainQuest menu");
      bt bt = f();
      es1.a(bt);
      ft.o.a(es1, this.s[this.u].substring(1, this.s[this.u].length()), cn.f.ct, (byte)0, true, 0);
    } else {
      cn.f.dk = null;
      es es1 = new es("MainQuest menu2");
      bt bt = f();
      es1.a(bt);
      ft.o.a(es1, this.s[this.u].substring(1, this.s[this.u].length()), this.i, (byte)2, true, 0);
    } 
    this.u++;
  }
  
  public static void a(int paramInt) {
    au au;
    if ((au = (au)ez.a(paramInt, (byte)1)) == null)
      return; 
    String str = "";
    byte b;
    for (b = 0; b < c.c(); b++) {
      ew ew1;
      if ((ew1 = (ew)c.a(b)).e == 1)
        for (byte b1 = 0; b1 < ew1.o.length; b1++) {
          if (ew1.o[b1] == au.B && ew1.q[b1] < ew1.p[b1]) {
            ew1.q[b1] = (short)(ew1.q[b1] + 1);
            if (str.length() > 0)
              str = String.valueOf(str) + " , "; 
            str = String.valueOf(str) + ew1.q[b1] + "/" + ew1.p[b1];
          } 
        }  
    } 
    for (b = 0; b < d.c(); b++) {
      ew ew1;
      if ((ew1 = (ew)d.a(b)).e == 1)
        for (byte b1 = 0; b1 < ew1.o.length; b1++) {
          if (ew1.o[b1] == au.B && ew1.q[b1] < ew1.p[b1]) {
            ew1.q[b1] = (short)(ew1.q[b1] + 1);
            if (str.length() > 0)
              str = String.valueOf(str) + " , "; 
            str = String.valueOf(str) + ew1.q[b1] + "/" + ew1.p[b1];
          } 
        }  
    } 
    if (str.length() > 0)
      ft.c(str = String.valueOf(df.dD) + au.cB + ": " + str); 
  }
  
  public static void a(int paramInt, String paramString) {
    String str = "";
    byte b;
    for (b = 0; b < c.c(); b++) {
      ew ew1;
      if ((ew1 = (ew)c.a(b)).e == 0)
        for (byte b1 = 0; b1 < ew1.o.length; b1++) {
          if (ew1.o[b1] == paramInt && ew1.q[b1] < ew1.p[b1]) {
            ew1.q[b1] = (short)(ew1.q[b1] + 1);
            if (str.length() > 0)
              str = String.valueOf(str) + " , "; 
            str = String.valueOf(str) + ew1.q[b1] + "/" + ew1.p[b1];
          } 
        }  
    } 
    for (b = 0; b < d.c(); b++) {
      ew ew1;
      if ((ew1 = (ew)d.a(b)).e == 0)
        for (byte b1 = 0; b1 < ew1.o.length; b1++) {
          System.out.println(String.valueOf(ew1.o[b1]) + "  " + paramInt);
          if (ew1.o[b1] == paramInt && ew1.q[b1] < ew1.p[b1]) {
            ew1.q[b1] = (short)(ew1.q[b1] + 1);
            if (str.length() > 0)
              str = String.valueOf(str) + " , "; 
            str = String.valueOf(str) + ew1.q[b1] + "/" + ew1.p[b1];
          } 
        }  
    } 
    if (str.length() > 0)
      ft.c(str = String.valueOf(df.dE) + paramString + ": " + str); 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ew.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */