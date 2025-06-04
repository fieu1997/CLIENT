import java.io.DataInputStream;
import java.io.IOException;

public final class o {
  private int s;
  
  private int t;
  
  private aq u;
  
  private String v;
  
  private int[][] w;
  
  private static String x = " 0123456789+-*='_?.,<>/[]{}!@#$%^&*():aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
  
  public static o a;
  
  public static o b;
  
  public static o c;
  
  public static o d;
  
  public static o e;
  
  public static o f;
  
  public static o g;
  
  public static o h;
  
  public static o i;
  
  public static o j;
  
  public static o k;
  
  public static o l;
  
  public static o m;
  
  public static o n;
  
  public static o o;
  
  public static o p;
  
  public static o q;
  
  public static o r;
  
  private String y;
  
  public static void a() {
    a = new o(x, "/mfont/tahoma_7b_orange.png", "/mfont/tahoma_7b", 0);
    b = new o(x, "/mfont/tahoma_7b_blue.png", "/mfont/tahoma_7b", 0);
    c = new o(x, "/mfont/tahoma_7b_black.png", "/mfont/tahoma_7b", 0);
    d = new o(x, "/mfont/tahoma_7b_yellow.png", "/mfont/tahoma_7b", 0);
    e = new o(x, "/mfont/tahoma_7b_violet.png", "/mfont/tahoma_7b", 0);
    f = new o(x, "/mfont/tahoma_7b_white.png", "/mfont/tahoma_7b", 0);
    g = new o(x, "/mfont/tahoma_7b_green.png", "/mfont/tahoma_7b", 0);
    h = new o(x, "/mfont/tahoma_7b_red.png", "/mfont/tahoma_7b", 0);
    i = new o(x, "/mfont/tahoma_7_black.png", "/mfont/tahoma_7", 0);
    j = new o(x, "/mfont/tahoma_7_white.png", "/mfont/tahoma_7", 0);
    k = new o(x, "/mfont/tahoma_7_yellow.png", "/mfont/tahoma_7", 0);
    l = new o(x, "/mfont/tahoma_7_orange.png", "/mfont/tahoma_7", 0);
    m = new o(x, "/mfont/tahoma_7_red.png", "/mfont/tahoma_7", 0);
    n = new o(x, "/mfont/tahoma_7_blue.png", "/mfont/tahoma_7", 0);
    o = new o(x, "/mfont/tahoma_7_green.png", "/mfont/tahoma_7", 0);
    p = new o(x, "/mfont/tahoma_7_violet.png", "/mfont/tahoma_7", 0);
    r = new o(x, "/mfont/tahoma_7_gray.png", "/mfont/tahoma_7", 0);
    q = new o(" 0123456789+-", "/mfont/number_yellow.png", "/mfont/number", 0);
  }
  
  private o(String paramString1, String paramString2, String paramString3, int paramInt) {
    try {
      DataInputStream dataInputStream;
      this.v = paramString1;
      this.s = 0;
      this.y = paramString2;
      paramString1 = null;
      o o1;
      (o1 = this).u = aq.a(o1.y);
      try {
        dataInputStream = aq.b(paramString3);
        this.w = new int[dataInputStream.readShort()][];
        for (byte b = 0; b < this.w.length; b++) {
          this.w[b] = new int[4];
          this.w[b][0] = dataInputStream.readShort();
          this.w[b][1] = dataInputStream.readShort();
          this.w[b][2] = dataInputStream.readShort();
          this.w[b][3] = dataInputStream.readShort();
        } 
        int i = this.w[this.w.length - 1][3];
        (o1 = this).t = i;
        return;
      } catch (Exception exception) {
        try {
          dataInputStream.close();
          return;
        } catch (IOException iOException) {
          (this = null).printStackTrace();
          return;
        } 
      } 
    } catch (Exception exception) {
      (paramString1 = null).printStackTrace();
      dw.a("paht data:" + paramString2);
      return;
    } 
  }
  
  public final int a(String paramString) {
    int i = 0;
    for (byte b = 0; b < paramString.length(); b++) {
      int j;
      if ((j = this.v.indexOf(paramString.charAt(b))) == -1)
        j = 0; 
      i += this.w[j][2] + this.s;
    } 
    return i;
  }
  
  public final void a(bx parambx, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i = paramString.length();
    if (paramInt3 == 0) {
      paramInt3 = paramInt1;
    } else if (paramInt3 == 1) {
      paramInt3 = paramInt1 - a(paramString);
    } else {
      paramInt3 = paramInt1 - (a(paramString) >> 1);
    } 
    for (byte b = 0; b < i; b++) {
      if ((paramInt1 = this.v.indexOf(paramString.charAt(b))) == -1)
        paramInt1 = 0; 
      if (paramInt1 > -1)
        parambx.a(this.u, this.w[paramInt1][0], this.w[paramInt1][1], this.w[paramInt1][2], this.w[paramInt1][3], 0, paramInt3, paramInt2, 20); 
      paramInt3 += this.w[paramInt1][2] + this.s;
    } 
  }
  
  public static String[] a(String paramString1, String paramString2) {
    es es = new es("mFont nodes");
    for (int i = paramString1.indexOf(paramString2); i >= 0; i = (paramString1 = paramString1.substring(i + paramString2.length())).indexOf(paramString2))
      es.a(paramString1.substring(0, i)); 
    es.a(paramString1);
    String[] arrayOfString = new String[es.c()];
    if (es.c() > 0)
      for (byte b = 0; b < es.c(); b++)
        arrayOfString[b] = (String)es.a(b);  
    return arrayOfString;
  }
  
  public final String[] a(String paramString, int paramInt) {
    paramInt = paramInt;
    paramString = paramString;
    this = this;
    es es2 = new es("mFont lines");
    String str = "";
    for (int i = 0; i < paramString.length(); i++) {
      if (paramString.charAt(i) == '\n') {
        es2.a(str);
        str = "";
      } else {
        str = String.valueOf(str) + paramString.charAt(i);
        if (a(str) > paramInt) {
          int j = 0;
          for (j = str.length() - 1; j >= 0 && str.charAt(j) != ' '; j--);
          if (j < 0)
            j = str.length() - 1; 
          es2.a(str.substring(0, j));
          i = i - str.length() - j + 1;
          str = "";
        } 
        if (i == paramString.length() - 1 && !str.trim().equals(""))
          es2.a(str); 
      } 
    } 
    es es1;
    String[] arrayOfString = new String[(es1 = es2).c()];
    for (paramInt = 0; paramInt < c(); paramInt++)
      arrayOfString[paramInt] = a(paramInt).toString(); 
    return arrayOfString;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\o.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */