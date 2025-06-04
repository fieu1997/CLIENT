import com.silverknight.TemMidlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public final class ak {
  private static short[] c = new short[] { 
      0, 18, 36, 54, 71, 89, 107, 125, 143, 160, 
      178, 195, 213, 230, 248, 265, 282, 299, 316, 333, 
      350, 367, 384, 400, 416, 433, 449, 465, 481, 496, 
      512, 527, 543, 558, 573, 587, 602, 616, 630, 644, 
      658, 672, 685, 698, 711, 724, 737, 749, 761, 773, 
      784, 796, 807, 818, 828, 839, 849, 859, 868, 878, 
      887, 896, 904, 912, 920, 928, 935, 943, 949, 956, 
      962, 968, 974, 979, 984, 989, 994, 998, 1002, 1005, 
      1008, 1011, 1014, 1016, 1018, 1020, 1022, 1023, 1023, 1024, 
      1024 };
  
  public static ek a = new ek();
  
  private static String d = "region_Rms";
  
  private static short[] e = new short[91];
  
  private static int[] f = new int[91];
  
  private static Random g = new Random();
  
  private static fe[][] h = new fe[7][];
  
  public static ap[][][] b = new ap[4][5][3];
  
  public static final int a(int paramInt) {
    return (paramInt >= 0 && paramInt < 90) ? c[paramInt] : ((paramInt >= 90 && paramInt < 180) ? c[180 - paramInt] : ((paramInt >= 180 && paramInt < 270) ? -c[paramInt - 180] : -c[360 - paramInt]));
  }
  
  public static final int b(int paramInt) {
    return (paramInt >= 0 && paramInt < 90) ? e[paramInt] : ((paramInt >= 90 && paramInt < 180) ? -e[180 - paramInt] : ((paramInt >= 180 && paramInt < 270) ? -e[paramInt - 180] : e[360 - paramInt]));
  }
  
  public static final int c(int paramInt) {
    return (paramInt >= 0 && paramInt < 90) ? f[paramInt] : ((paramInt >= 90 && paramInt < 180) ? -f[180 - paramInt] : ((paramInt >= 180 && paramInt < 270) ? f[paramInt - 180] : -f[360 - paramInt]));
  }
  
  public static final int a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_0
    //   1: ifeq -> 89
    //   4: iload_1
    //   5: bipush #10
    //   7: ishl
    //   8: iload_0
    //   9: idiv
    //   10: invokestatic abs : (I)I
    //   13: dup
    //   14: istore_2
    //   15: istore_2
    //   16: iconst_0
    //   17: istore_3
    //   18: goto -> 37
    //   21: getstatic ak.f : [I
    //   24: iload_3
    //   25: iaload
    //   26: iload_2
    //   27: if_icmplt -> 34
    //   30: iload_3
    //   31: goto -> 44
    //   34: iinc #3, 1
    //   37: iload_3
    //   38: bipush #90
    //   40: if_icmple -> 21
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_1
    //   46: iflt -> 59
    //   49: iload_0
    //   50: ifge -> 59
    //   53: sipush #180
    //   56: iload_2
    //   57: isub
    //   58: istore_2
    //   59: iload_1
    //   60: ifge -> 73
    //   63: iload_0
    //   64: ifge -> 73
    //   67: wide iinc #2 180
    //   73: iload_1
    //   74: ifge -> 102
    //   77: iload_0
    //   78: iflt -> 102
    //   81: sipush #360
    //   84: iload_2
    //   85: isub
    //   86: goto -> 101
    //   89: iload_1
    //   90: ifle -> 98
    //   93: bipush #90
    //   95: goto -> 101
    //   98: sipush #270
    //   101: istore_2
    //   102: iload_2
    //   103: ireturn
  }
  
  public static final int d(int paramInt) {
    if (paramInt >= 360)
      paramInt %= 360; 
    if (paramInt < 0)
      paramInt = 360 + paramInt % 360; 
    return paramInt;
  }
  
  public static int e(int paramInt) {
    return (paramInt < 0) ? -paramInt : paramInt;
  }
  
  public static int f(int paramInt) {
    return g.nextInt(paramInt);
  }
  
  public static int g(int paramInt) {
    for (int i = 0; !i; i = g.nextInt() % paramInt);
    return i;
  }
  
  public static int b(int paramInt1, int paramInt2) {
    paramInt1 += g.nextInt(paramInt2 - paramInt1);
    paramInt2 = 2;
    if (g.nextInt(paramInt2) == 0)
      paramInt1 = -paramInt1; 
    return paramInt1;
  }
  
  public static int c(int paramInt1, int paramInt2) {
    return paramInt1 + g.nextInt(paramInt2 - paramInt1);
  }
  
  public static int h(int paramInt) {
    if (paramInt <= 0)
      return 0; 
    int i = (paramInt + 1) / 2;
    while (true) {
      int j = i;
      i = i / 2 + paramInt / i * 2;
      if (Math.abs(j - i) <= 1)
        return i; 
    } 
  }
  
  public static float a(float paramFloat) {
    if (paramFloat <= 0.0F)
      return 0.0F; 
    float f = (paramFloat + 1.0F) / 2.0F;
    while (true) {
      float f1 = f;
      f = f / 2.0F + paramFloat / f * 2.0F;
      if (Math.abs(f1 - f) <= 1.0F)
        return f; 
    } 
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return e(paramInt1 - paramInt3) + e(paramInt2 - paramInt4);
  }
  
  public static void a(es parames) {
    a(parames, 0, parames.c() - 1);
  }
  
  private static void a(es parames, int paramInt1, int paramInt2) {
    if (paramInt2 - paramInt1 <= 0)
      return; 
    try {
      ez ez;
      int i = (ez = (ez)parames.a(paramInt2)).bp;
      i = a(parames, paramInt1, paramInt2, i);
      a(parames, paramInt1, i - 1);
      a(parames, i + 1, paramInt2);
      return;
    } catch (Exception exception) {
      dw.a("loi Cres 1");
      exception.printStackTrace();
      return;
    } 
  }
  
  private static int a(es parames, int paramInt1, int paramInt2, int paramInt3) {
    paramInt1--;
    int i = paramInt2;
    try {
      while (true) {
        if (((ez)parames.a(++paramInt1)).bp >= paramInt3) {
          do {
          
          } while (i > 0 && ((ez)parames.a(--i)).bp > paramInt3);
          if (paramInt1 < i) {
            b(parames, paramInt1, i);
            continue;
          } 
          b(parames, paramInt1, paramInt2);
          return paramInt1;
        } 
      } 
    } catch (Exception exception) {
      dw.a("loi Cres 2");
      exception.printStackTrace();
    } 
    return paramInt1;
  }
  
  private static void b(es parames, int paramInt1, int paramInt2) {
    Object object = parames.a(paramInt2);
    if (((ez)parames.a(paramInt2)).bp != ((ez)parames.a(paramInt1)).bp) {
      parames.a(parames.a(paramInt1), paramInt2);
      parames.a(object, paramInt1);
    } 
  }
  
  public static void b(es parames) {
    c(parames, 0, parames.c() - 1);
  }
  
  private static void c(es parames, int paramInt1, int paramInt2) {
    if (paramInt2 - paramInt1 <= 0)
      return; 
    try {
      z z;
      int i = (z = (z)parames.a(paramInt2)).i;
      i = b(parames, paramInt1, paramInt2, i);
      c(parames, paramInt1, i - 1);
      c(parames, i + 1, paramInt2);
      return;
    } catch (Exception exception) {
      dw.a("loi Cres 1");
      exception.printStackTrace();
      return;
    } 
  }
  
  private static int b(es parames, int paramInt1, int paramInt2, int paramInt3) {
    paramInt1--;
    int i = paramInt2;
    try {
      while (true) {
        if (((z)parames.a(++paramInt1)).i >= paramInt3) {
          do {
          
          } while (i > 0 && ((z)parames.a(--i)).i > paramInt3);
          if (paramInt1 < i) {
            d(parames, paramInt1, i);
            continue;
          } 
          d(parames, paramInt1, paramInt2);
          return paramInt1;
        } 
      } 
    } catch (Exception exception) {
      dw.a("loi Cres 2");
      exception.printStackTrace();
    } 
    return paramInt1;
  }
  
  private static void d(es parames, int paramInt1, int paramInt2) {
    Object object = parames.a(paramInt2);
    if (((z)parames.a(paramInt2)).i != ((z)parames.a(paramInt1)).i) {
      parames.a(parames.a(paramInt1), paramInt2);
      parames.a(object, paramInt1);
    } 
  }
  
  public static cz[] a(cz[] paramArrayOfcz) {
    int i = paramArrayOfcz.length;
    for (byte b = 0; b < i - 1; b++) {
      int k = b;
      for (int j = b + 1; j < i; j++) {
        if ((paramArrayOfcz[j]).a < (paramArrayOfcz[k]).a)
          k = j; 
      } 
      if (k != b) {
        cz cz1 = paramArrayOfcz[b];
        paramArrayOfcz[b] = paramArrayOfcz[k];
        paramArrayOfcz[k] = cz1;
      } 
    } 
    return paramArrayOfcz;
  }
  
  public static es c(es parames) {
    int i = parames.c();
    for (byte b = 0; b < i - 1; b++) {
      int k = b;
      for (int j = b + 1; j < i; j++) {
        if (((ev)parames.a(j)).b < ((ev)parames.a(k)).b)
          k = j; 
      } 
      if (k != b)
        e(parames, b, k); 
    } 
    return parames;
  }
  
  public static es d(es parames) {
    int i = parames.c();
    for (byte b = 0; b < i - 1; b++) {
      int k = b;
      for (int j = b + 1; j < i; j++) {
        if (((ev)parames.a(j)).i < ((ev)parames.a(k)).i)
          k = j; 
      } 
      if (k != b)
        e(parames, b, k); 
    } 
    return parames;
  }
  
  private static void e(es parames, int paramInt1, int paramInt2) {
    Object object = parames.a(paramInt2);
    if (((ev)parames.a(paramInt2)).i != ((ev)parames.a(paramInt1)).i) {
      parames.a(parames.a(paramInt1), paramInt2);
      parames.a(object, paramInt1);
    } 
  }
  
  public static es e(es parames) {
    int i = parames.c();
    for (byte b = 0; b < i - 1; b++) {
      int k = b;
      for (int j = b + 1; j < i; j++) {
        if (((j)parames.a(j)).C < ((j)parames.a(k)).C)
          k = j; 
      } 
      if (k != b) {
        int m = k;
        k = b;
        es es1;
        Object object = (es1 = parames).a(m);
        es1.a(es1.a(k), m);
        es1.a(object, k);
      } 
    } 
    return parames;
  }
  
  public static int a(InputStream paramInputStream) {
    byte[] arrayOfByte = new byte[1];
    try {
      paramInputStream.read(arrayOfByte, 0, 1);
    } catch (IOException iOException) {
      (paramInputStream = null).printStackTrace();
    } 
    return arrayOfByte[0];
  }
  
  public static void a() {
    if (h == null)
      return; 
    for (byte b = 0; b < h.length; b++) {
      for (byte b1 = 0; b1 < (h[b]).length; b1++) {
        if (h[b][b1] != null && (ft.aj - (h[b][b1]).b) / 1000L > 60L)
          h[b][b1] = null; 
      } 
    } 
  }
  
  public static synchronized fe d(int paramInt1, int paramInt2) {
    if (h[paramInt1][paramInt2] == null)
      h[paramInt1][paramInt2] = new fe((byte)paramInt1, (short)paramInt2); 
    return h[paramInt1][paramInt2];
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3) {
    try {
      ez.dY[paramInt1][paramInt2][paramInt3] = new am();
      if (dw.i) {
        String[] arrayOfString = { "kiem/", "songkiem/", "phapsu/", "sung/" };
        aq aq = null;
        try {
          aq = aq.a("/weapon/" + arrayOfString[paramInt1] + paramInt2 + ".img");
        } catch (Exception exception) {}
        if (aq != null && aq.a != null) {
          DataInputStream dataInputStream = null;
          try {
            dataInputStream = aq.b("/weapon/" + arrayOfString[paramInt1] + paramInt2 + "_data");
          } catch (Exception exception) {}
          if (dataInputStream != null) {
            (ez.dY[paramInt1][paramInt2][paramInt3]).a = aq;
            for (byte b = 0; b < 4; b++) {
              for (byte b1 = 0; b1 < 3; b1++) {
                (ez.dY[paramInt1][paramInt2][paramInt3]).b[b][b1][0] = (byte)dataInputStream.read();
                (ez.dY[paramInt1][paramInt2][paramInt3]).b[b][b1][1] = (byte)dataInputStream.read();
              } 
              (ez.dY[paramInt1][paramInt2][paramInt3]).c[b][0] = (byte)dataInputStream.read();
              (ez.dY[paramInt1][paramInt2][paramInt3]).c[b][1] = (byte)dataInputStream.read();
            } 
            (ez.dY[paramInt1][paramInt2][paramInt3]).d = aq.b((ez.dY[paramInt1][paramInt2][paramInt3]).a.a);
            return;
          } 
        } 
      } 
      cw cw;
      if ((cw = (cw)a.a(String.valueOf(paramInt1) + "_" + paramInt2)) == null) {
        cw = new cw();
        a.a(String.valueOf(paramInt1) + "_" + paramInt2, cw);
        cw.b = ft.aj;
        a((byte)paramInt1, (short)paramInt2);
        ez.dY[paramInt1][paramInt2][paramInt3] = null;
      } else if (cw.a != null) {
        (ez.dY[paramInt1][paramInt2][paramInt3]).a = cw.a;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cw.c);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        dp.a();
        try {
          for (byte b = 0; b < 4; b++) {
            for (byte b1 = 0; b1 < 3; b1++) {
              (ez.dY[paramInt1][paramInt2][paramInt3]).b[b][b1][0] = (byte)dataInputStream.read();
              (ez.dY[paramInt1][paramInt2][paramInt3]).b[b][b1][1] = (byte)dataInputStream.read();
            } 
            (ez.dY[paramInt1][paramInt2][paramInt3]).c[b][0] = (byte)dataInputStream.read();
            (ez.dY[paramInt1][paramInt2][paramInt3]).c[b][1] = (byte)dataInputStream.read();
          } 
          (ez.dY[paramInt1][paramInt2][paramInt3]).d = aq.b((ez.dY[paramInt1][paramInt2][paramInt3]).a.a);
        } catch (Exception exception) {}
        a.a(cw);
      } else if ((ft.aj - cw.b) / 1000L >= 15L) {
        a((byte)paramInt1, (short)paramInt2);
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
      dw.a("loi Cres 7");
    } 
    dp.a();
  }
  
  private static void a(byte paramByte, short paramShort) {
    cw cw;
    if ((cw = (cw)a.a(String.valueOf(paramByte) + "_" + paramShort)) != null)
      cw.b = ft.aj; 
    q.a().a((byte)(paramByte + 50), paramShort);
  }
  
  public static ap b(int paramInt1, int paramInt2, int paramInt3) {
    try {
      String[] arrayOfString = { "kiem/", "songkiem/", "phapsu/", "sung/" };
      b[paramInt1][paramInt2][paramInt3] = new ap();
      (b[paramInt1][paramInt2][paramInt3]).g = aq.a("/wps/" + arrayOfString[paramInt1] + paramInt2 + ".img");
      DataInputStream dataInputStream = aq.b("/wps/" + arrayOfString[paramInt1] + paramInt2 + "_data");
      for (byte b = 0; b < 4; b++) {
        for (byte b1 = 0; b1 < 8; b1++) {
          (b[paramInt1][paramInt2][paramInt3]).a[b][b1] = dataInputStream.read();
          (b[paramInt1][paramInt2][paramInt3]).b[b][b1] = dataInputStream.read();
          (b[paramInt1][paramInt2][paramInt3]).c[b][b1] = a(dataInputStream);
          (b[paramInt1][paramInt2][paramInt3]).d[b][b1] = a(dataInputStream);
          (b[paramInt1][paramInt2][paramInt3]).e[b][b1] = dataInputStream.read();
          (b[paramInt1][paramInt2][paramInt3]).f[b][b1] = dataInputStream.read();
        } 
      } 
      dp.a();
    } catch (IOException iOException) {
      b[paramInt1][paramInt2][paramInt3] = null;
      dw.a("loi Cres 8");
      iOException.printStackTrace();
    } 
    return b[paramInt1][paramInt2][paramInt3];
  }
  
  public static am c(int paramInt1, int paramInt2, int paramInt3) {
    if (ez.dY[paramInt1][paramInt2][0] == null)
      dt.a.a(paramInt1, paramInt2, 0); 
    return ez.dY[paramInt1][paramInt2][0];
  }
  
  public static void a(String paramString, byte[] paramArrayOfbyte) {
    TemMidlet.a(paramString, paramArrayOfbyte);
  }
  
  public static byte[] a(String paramString) {
    return TemMidlet.a(paramString);
  }
  
  public static void a(byte paramByte, byte[] paramArrayOfbyte) {
    q.a().a((byte)0, paramByte, paramArrayOfbyte);
  }
  
  public static boolean b(String paramString) {
    return !(paramString.compareTo("isLowDevice") == 0 || paramString.compareTo("isQty") == 0 || paramString.compareTo("user_pass") == 0 || paramString.compareTo("isIndexPart") == 0 || paramString.compareTo("isIndexServer") == 0);
  }
  
  public static void b() {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream;
      (dataOutputStream = new DataOutputStream(byteArrayOutputStream)).writeByte(dw.c);
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      String str;
      TemMidlet.a(str = d, arrayOfByte);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  static {
    byte b;
    for (b = 0; b <= 90; b++) {
      e[b] = c[90 - b];
      if (e[b] == 0) {
        f[b] = Integer.MAX_VALUE;
      } else {
        f[b] = (c[b] << 10) / e[b];
      } 
    } 
  }
  
  static {
    for (b = 0; b < h.length; b++)
      h[b] = new fe[256]; 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ak.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */