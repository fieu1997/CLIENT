import com.silverknight.TemMidlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

public final class fi extends cg {
  public int a;
  
  public int b;
  
  public int c;
  
  private int l = 0;
  
  public int d;
  
  public boolean e;
  
  private boolean m = false;
  
  public boolean f = true;
  
  private static int n = 1;
  
  private static int[] o = new int[] { 18, 14, 11, 9, 6, 4, 2 };
  
  private static String[] p = new String[] { 
      " 0", ".,@?!_1\"/$-():*+<=>;%&~#%^&*{}[];'/1", "abc2âă", "def3đê", "ghi4", "jkl5", "mno6ôơ", "pqrs7", "tuv8ư", "wxyz9", 
      "*", "#" };
  
  private static String[] q = new String[] { 
      "0", "1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", 
      "0", "0" };
  
  private static String[] r = new String[] { 
      " 0", "er1", "ty2", "ui3", "df4", "gh5", "jk6", "cv7", "bn8", "m9", 
      "0", "0", "qw!", "as?", "zx", "op.", "l," };
  
  private String s = "";
  
  private String t = "";
  
  private String u = "";
  
  public int g = 0;
  
  private int v = 0;
  
  private int w = 500;
  
  private int x = 0;
  
  private static int y = -1984;
  
  private int z = 0;
  
  private int A = 0;
  
  private int B = 10;
  
  private int C = 0;
  
  public static boolean h;
  
  private static int D = 0;
  
  private static int E = 11;
  
  private static int F;
  
  public bt i;
  
  private String G = "";
  
  public String j = "";
  
  private String H = "";
  
  private int I = 0;
  
  public static boolean k = false;
  
  private int J = -1;
  
  private int K = 0;
  
  private int L = 0;
  
  private long M = 0L;
  
  private static String N = "aáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵ";
  
  private int O = 0;
  
  private static int[][] P = new int[][] { 
      { 32, 48 }, { 49, 69 }, { 50, 84 }, { 51, 85 }, { 52, 68 }, { 53, 71 }, { 54, 74 }, { 55, 67 }, { 56, 66 }, { 57, 77 }, 
      { 42, 128 }, { 35, 137 }, { 33, 113 }, { 63, 97 }, { 64, 121, 122 }, { 46, 111 }, { 44, 108 } };
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 0:
        if (this.e)
          m(); 
        break;
    } 
  }
  
  public static void a(int paramInt) {
    p[0] = " 0";
    p[10] = "*";
    p[11] = "#";
    E = 35;
    F = 42;
  }
  
  public final void a(boolean paramBoolean) {
    if (this.e != paramBoolean)
      D = 0; 
    y = -1984;
    ft.p();
    this.e = paramBoolean;
  }
  
  public final bt b() {
    return this.i;
  }
  
  public static int c() {
    return ft.A ? 28 : 20;
  }
  
  private void k() {
    this.i = new bt(df.U, 0, this);
  }
  
  public fi() {
    this.s = "";
    k();
    a(false);
    l();
  }
  
  public fi(int paramInt1, int paramInt2, int paramInt3) {
    this.s = "";
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.l = 0;
    k();
    a(false);
    l();
  }
  
  public fi(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.s = "";
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.l = 40;
    k();
    a(false);
    l();
  }
  
  private void l() {
    this.d = 20;
    if (ft.A)
      this.d = 28; 
  }
  
  public final void a(String paramString) {
    this.H = paramString;
  }
  
  private void m() {
    if (this.g > 0 && this.s.length() > 0) {
      this.s = String.valueOf(this.s.substring(0, this.g - 1)) + this.s.substring(this.g, this.s.length());
      this.g--;
      f(0);
      o();
    } 
  }
  
  private void f(int paramInt) {
    if (this.C == 2) {
      this.u = this.t;
    } else {
      this.u = this.s;
    } 
    int i = o.i.a(this.u.substring(0, this.g));
    if (paramInt == -1) {
      if (i + this.x < 15 && this.g > 0 && this.g < this.u.length())
        this.x += o.i.a(this.u.substring(this.g, this.g + 1)); 
    } else if (paramInt == 1) {
      if (i + this.x > this.c - 25 && this.g < this.u.length() && this.g > 0)
        this.x -= o.i.a(this.u.substring(this.g - 1, this.g)); 
    } else {
      this.x = -(i - this.c - 12);
    } 
    if (this.x > 0) {
      this.x = 0;
      return;
    } 
    if (this.x < 0) {
      paramInt = o.i.a(this.u) - this.c - 12;
      if (this.x < -paramInt)
        this.x = -paramInt; 
    } 
  }
  
  private void g(int paramInt) {
    if ((this.C == 2 || this.C == 3) && (paramInt < 48 || paramInt > 57) && (paramInt < 65 || paramInt > 90) && (paramInt < 97 || paramInt > 122))
      return; 
    if (this.s.length() < this.w) {
      String str = String.valueOf(this.s.substring(0, this.g)) + (char)paramInt;
      if (this.g < this.s.length())
        str = String.valueOf(str) + this.s.substring(this.g, this.s.length()); 
      this.s = str;
      this.g++;
      o();
      f(0);
    } 
  }
  
  public final boolean b(int paramInt) {
    if (paramInt == 8 || paramInt == -8 || paramInt == 204) {
      m();
      return true;
    } 
    if (!ft.A && paramInt >= 65 && paramInt <= 122) {
      h = true;
      byte[] arrayOfByte = { 1 };
      try {
        ak.a("isQty", arrayOfByte);
      } catch (Exception exception) {
        (arrayOfByte = null).printStackTrace();
      } 
    } 
    if (h) {
      if (paramInt == 45) {
        if (paramInt == y && this.z < o[n]) {
          this.s = String.valueOf(this.s.substring(0, this.g - 1)) + '_';
          this.u = this.s;
          o();
          f(0);
          y = -1984;
          return false;
        } 
        y = 45;
      } 
      if (paramInt >= 32) {
        g(paramInt);
        return false;
      } 
    } 
    if (!h && paramInt == E) {
      if (++D > 3)
        D = 0; 
      y = E;
      ft.p();
      this.z = 1;
      y = paramInt;
      return false;
    } 
    if (paramInt == F && this.C == 0) {
      n();
      return false;
    } 
    if (paramInt == 42)
      paramInt = 58; 
    if (paramInt == 35)
      paramInt = 59; 
    if (paramInt >= 48 && paramInt <= 59) {
      paramInt = paramInt;
      if ((this = this).C == 0 || this.C == 2 || this.C == 3) {
        String str;
        paramInt = paramInt;
        this = this;
        String[] arrayOfString = null;
        if (this.C == 2 || this.C == 3) {
          arrayOfString = q;
        } else {
          arrayOfString = p;
        } 
        if (paramInt == y) {
          this.A = (this.A + 1) % arrayOfString[paramInt - 48].length();
          char c = arrayOfString[paramInt - 48].charAt(this.A);
          if (D == 0) {
            c = Character.toLowerCase(c);
          } else if (D == 1) {
            c = Character.toUpperCase(c);
          } else if (D == 2) {
            c = Character.toUpperCase(c);
          } else {
            c = arrayOfString[paramInt - 48].charAt(arrayOfString[paramInt - 48].length() - 1);
          } 
          str = String.valueOf(this.s.substring(0, this.g - 1)) + c;
          if (this.g < this.s.length())
            str = String.valueOf(str) + this.s.substring(this.g, this.s.length()); 
          this.s = str;
          this.z = o[n];
          o();
        } else if (this.s.length() < this.w) {
          if (D == 1 && y != -1984)
            D = 0; 
          this.A = 0;
          char c = str[paramInt - 48].charAt(this.A);
          if (D == 0) {
            c = Character.toLowerCase(c);
          } else if (D == 1) {
            c = Character.toUpperCase(c);
          } else if (D == 2) {
            c = Character.toUpperCase(c);
          } else {
            c = str[paramInt - 48].charAt(str[paramInt - 48].length() - 1);
          } 
          str = String.valueOf(this.s.substring(0, this.g)) + c;
          if (this.g < this.s.length())
            str = String.valueOf(str) + this.s.substring(this.g, this.s.length()); 
          this.s = str;
          this.z = o[n];
          this.g++;
          o();
          f(0);
        } 
        y = paramInt;
      } else if (this.C == 1) {
        g(paramInt);
        this.z = 1;
      } 
    } else {
      this.A = 0;
      y = -1984;
      if (paramInt == 14) {
        if (this.g > 0) {
          this.g--;
          f(0);
          this.B = 10;
          return false;
        } 
      } else if (paramInt == 15) {
        if (this.g < this.s.length()) {
          this.g++;
          f(0);
          this.B = 10;
          return false;
        } 
      } else {
        if (paramInt == 19) {
          m();
          return false;
        } 
        y = paramInt;
      } 
    } 
    return true;
  }
  
  private void n() {
    this.M = dw.a() / 100L;
    if (this.J == -1) {
      for (int i = this.g; i > 0; i--) {
        char c = this.s.charAt(i - 1);
        for (byte b = 0; b < N.length(); b++) {
          char c1 = N.charAt(b);
          if (c == c1) {
            this.K = b;
            this.L = 0;
            this.J = i - 1;
            return;
          } 
        } 
      } 
      this.J = -1;
      return;
    } 
    this.L++;
    if (this.L >= 6)
      this.L = 0; 
    String str1 = this.s.substring(0, this.J);
    String str2 = this.s.substring(this.J + 1);
    String str3 = N.substring(this.K + this.L, this.K + this.L + 1);
    this.s = String.valueOf(str1) + str3 + str2;
  }
  
  public final void b(bx parambx) {
    fi fi1;
    boolean bool = (fi1 = this).e;
    o o = o.i;
    byte b = 0;
    if (this.C == 2) {
      this.u = this.t;
      b = 3;
    } else {
      this.u = this.s;
    } 
    int i = 0;
    parambx.a(12621920);
    this.O++;
    int j;
    if (bool && (j = this.u.length()) > 0 && this.g > 0)
      i = o.i.a(this.u.substring(0, this.g)); 
    cg.a(parambx, this.a, this.b, this.c, this.d + 2, bool);
    if (this.u.length() == 0) {
      b = 0;
      this.u = this.H;
      o = o.j;
    } 
    o.a(parambx, this.u, this.a + 4, this.b + this.d / 2 - 5 + b, 0, true);
    if (bool && this.O % 16 > 12) {
      parambx.a(0);
      parambx.c(this.a + 3 + i, this.b + this.d / 2 - 7, 1, 14);
    } 
  }
  
  public final void a(bx parambx) {
    fi fi1;
    boolean bool = (fi1 = this).e;
    o o = o.i;
    byte b = 0;
    if (this.C == 2) {
      this.u = this.t;
      b = 3;
    } else {
      this.u = this.s;
    } 
    int i = 0;
    parambx.a(12621920);
    this.O++;
    int j;
    if (bool && (j = this.u.length()) > 0 && this.g > 0)
      i = o.i.a(this.u.substring(0, this.g)); 
    cg.a(parambx, this.a, this.b, this.c, this.d + 2, bool);
    parambx.d(this.a + 2, this.b + 2, this.c - 4, this.d - 3);
    j = parambx.a();
    int k = parambx.b();
    parambx.a(-this.I, 0);
    if (this.u.length() == 0) {
      b = 0;
      this.u = this.H;
      o = o.j;
    } 
    o.a(parambx, this.u, this.a + 4, this.b + this.d / 2 - 5 + b, 0, true);
    if (bool && this.O % 16 > 12) {
      parambx.a(0);
      parambx.c(this.a + 3 + i, this.b + this.d / 2 - 7, 1, 14);
    } 
    parambx.d(0, 0, ft.W, ft.X);
    ft.a(parambx);
    parambx.a(j, k);
  }
  
  public final boolean f() {
    return this.e;
  }
  
  private void o() {
    if (this.C == 2) {
      this.t = "";
      for (byte b = 0; b < this.s.length(); b++)
        this.t = String.valueOf(this.t) + "*"; 
      if (this.z > 0 && this.g > 0)
        this.t = String.valueOf(this.t.substring(0, this.g - 1)) + this.s.charAt(this.g - 1) + this.t.substring(this.g, this.t.length()); 
    } 
  }
  
  public final void g() {
    this = this;
    if (ft.S && ft.c(0, 0, ft.W, ft.X - ft.aa / 2))
      if (ft.c(this.a, this.b - 6, this.c - this.l, this.d + 12)) {
        if (!this.e) {
          this.e = true;
          if (!k) {
            k = true;
            ft.S = false;
            p();
            return;
          } 
        } else if (!k) {
          k = true;
          ft.S = false;
          p();
          return;
        } 
      } else if (this.f) {
        this.e = false;
      }  
  }
  
  public final void a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Z
    //   4: ifeq -> 84
    //   7: aload_0
    //   8: getfield C : I
    //   11: iconst_2
    //   12: if_icmpne -> 23
    //   15: aload_0
    //   16: getfield t : Ljava/lang/String;
    //   19: astore_1
    //   20: goto -> 28
    //   23: aload_0
    //   24: getfield s : Ljava/lang/String;
    //   27: astore_1
    //   28: aload_0
    //   29: aload_0
    //   30: getfield c : I
    //   33: ineg
    //   34: iconst_2
    //   35: idiv
    //   36: aload_0
    //   37: getfield g : I
    //   40: iconst_5
    //   41: imul
    //   42: iadd
    //   43: iconst_4
    //   44: iadd
    //   45: putfield I : I
    //   48: getstatic o.i : Lo;
    //   51: aload_1
    //   52: invokevirtual a : (Ljava/lang/String;)I
    //   55: aload_0
    //   56: getfield c : I
    //   59: isub
    //   60: bipush #8
    //   62: iadd
    //   63: istore_1
    //   64: aload_0
    //   65: getfield I : I
    //   68: iload_1
    //   69: if_icmple -> 77
    //   72: aload_0
    //   73: iload_1
    //   74: putfield I : I
    //   77: aload_0
    //   78: getfield I : I
    //   81: ifge -> 89
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield I : I
    //   89: aload_0
    //   90: dup
    //   91: getfield v : I
    //   94: iconst_1
    //   95: iadd
    //   96: putfield v : I
    //   99: aload_0
    //   100: getfield z : I
    //   103: ifle -> 172
    //   106: aload_0
    //   107: dup
    //   108: getfield z : I
    //   111: iconst_1
    //   112: isub
    //   113: putfield z : I
    //   116: aload_0
    //   117: getfield z : I
    //   120: ifeq -> 130
    //   123: getstatic fi.D : I
    //   126: iconst_2
    //   127: if_icmple -> 172
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield A : I
    //   135: aload_0
    //   136: getfield e : Z
    //   139: ifeq -> 162
    //   142: getstatic fi.D : I
    //   145: iconst_1
    //   146: if_icmpne -> 162
    //   149: getstatic fi.y : I
    //   152: getstatic fi.E : I
    //   155: if_icmpeq -> 162
    //   158: iconst_0
    //   159: putstatic fi.D : I
    //   162: sipush #-1984
    //   165: putstatic fi.y : I
    //   168: aload_0
    //   169: invokespecial o : ()V
    //   172: aload_0
    //   173: getfield B : I
    //   176: ifle -> 189
    //   179: aload_0
    //   180: dup
    //   181: getfield B : I
    //   184: iconst_1
    //   185: isub
    //   186: putfield B : I
    //   189: aload_0
    //   190: getfield J : I
    //   193: iconst_m1
    //   194: if_icmpeq -> 221
    //   197: invokestatic a : ()J
    //   200: ldc2_w 100
    //   203: ldiv
    //   204: aload_0
    //   205: getfield M : J
    //   208: lsub
    //   209: ldc2_w 5
    //   212: lcmp
    //   213: ifle -> 221
    //   216: aload_0
    //   217: iconst_m1
    //   218: putfield J : I
    //   221: aload_0
    //   222: getfield e : Z
    //   225: ifeq -> 330
    //   228: getstatic ft.ak : [Z
    //   231: iconst_4
    //   232: baload
    //   233: ifeq -> 270
    //   236: aload_0
    //   237: dup
    //   238: getfield g : I
    //   241: iconst_1
    //   242: isub
    //   243: putfield g : I
    //   246: aload_0
    //   247: getfield g : I
    //   250: ifge -> 258
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield g : I
    //   258: aload_0
    //   259: iconst_m1
    //   260: invokespecial f : (I)V
    //   263: getstatic ft.ak : [Z
    //   266: iconst_4
    //   267: iconst_0
    //   268: bastore
    //   269: return
    //   270: getstatic ft.ak : [Z
    //   273: bipush #6
    //   275: baload
    //   276: ifeq -> 330
    //   279: aload_0
    //   280: dup
    //   281: getfield g : I
    //   284: iconst_1
    //   285: iadd
    //   286: putfield g : I
    //   289: aload_0
    //   290: getfield g : I
    //   293: aload_0
    //   294: dup
    //   295: astore_1
    //   296: getfield s : Ljava/lang/String;
    //   299: invokevirtual length : ()I
    //   302: if_icmple -> 318
    //   305: aload_0
    //   306: aload_0
    //   307: dup
    //   308: astore_1
    //   309: getfield s : Ljava/lang/String;
    //   312: invokevirtual length : ()I
    //   315: putfield g : I
    //   318: aload_0
    //   319: iconst_1
    //   320: invokespecial f : (I)V
    //   323: getstatic ft.ak : [Z
    //   326: bipush #6
    //   328: iconst_0
    //   329: bastore
    //   330: return
  }
  
  public final void h() {
    if (!this.e) {
      this.e = true;
      if (!k) {
        k = true;
        ft.S = false;
        p();
        return;
      } 
    } else if (!k) {
      k = true;
      ft.S = false;
      p();
      return;
    } 
  }
  
  public final void i() {
    this.e = true;
    k = true;
    ft.S = false;
    p();
  }
  
  public final String j() {
    return this.s;
  }
  
  public final void b(String paramString) {
    if (paramString == null)
      return; 
    y = -1984;
    this.z = 0;
    this.A = 0;
    this.s = paramString;
    this.u = paramString;
    o();
    this.g = paramString.length();
    f(0);
  }
  
  public final void c(int paramInt) {
    this.w = paramInt;
  }
  
  public final void d(int paramInt) {
    this.C = paramInt;
  }
  
  private void p() {
    TextBox textBox;
    (textBox = new TextBox(this.j, this.G, 200, 0)).addCommand(new Command("OK", 4, 0));
    textBox.addCommand(new Command("Cancel", 3, 0));
    textBox.setCommandListener(new g(this, textBox));
    try {
      if (this.C == 2) {
        textBox.setConstraints(65536);
      } else if (this.C == 1) {
        textBox.setConstraints(2);
      } else {
        textBox.setConstraints(0);
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
    fi fi1;
    textBox.setString((fi1 = this).s);
    textBox.setMaxSize(this.w);
    Display.getDisplay((MIDlet)TemMidlet.b).setCurrent((Displayable)textBox);
  }
  
  static {
    (new String[4])[0] = "abc";
    (new String[4])[1] = "Abc";
    (new String[4])[2] = "ABC";
    (new String[4])[3] = "123";
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fi.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */