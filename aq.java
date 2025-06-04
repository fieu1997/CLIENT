import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Image;

public final class aq {
  public Image a;
  
  private static aq c(String paramString) {
    aq aq1 = new aq();
    paramString = "/x" + bx.b + paramString;
    try {
      DataInputStream dataInputStream = null;
      int i;
      byte[] arrayOfByte = new byte[i = (dataInputStream = new DataInputStream("".getClass().getResourceAsStream(paramString))).available()];
      dataInputStream.read(arrayOfByte, 0, i);
      for (byte b = 0; b < arrayOfByte.length; b++)
        arrayOfByte[b] = (byte)(arrayOfByte[b] ^ 0x3); 
      aq1.a = Image.createImage(arrayOfByte, 0, i);
    } catch (IOException iOException) {
      "IOException :" + iOException.getMessage();
    } catch (IllegalArgumentException illegalArgumentException) {
      String.valueOf(paramString) + " IllegalArgumentException :" + illegalArgumentException.getMessage();
    } catch (NullPointerException nullPointerException) {
      String.valueOf(paramString) + " NullPointerException :" + nullPointerException.getMessage();
    } 
    return (aq1.a == null) ? null : aq1;
  }
  
  public static aq a(String paramString) {
    String str2 = "png";
    String str1 = "img";
    paramString = paramString;
    String str3 = "";
    String str4 = "";
    int j;
    if ((j = paramString.lastIndexOf('.')) > 0) {
      str3 = paramString.substring(j + 1, paramString.length());
      str4 = paramString.substring(0, j + 1);
    } 
    StringBuffer stringBuffer;
    (stringBuffer = new StringBuffer(str4)).append(str2);
    stringBuffer = (str3.compareTo(str1) == 0) ? (StringBuffer)stringBuffer.toString() : stringBuffer;
    str1 = "";
    int i;
    if ((i = stringBuffer.lastIndexOf('.')) > 0)
      str1 = stringBuffer.substring(i + 1, stringBuffer.length()); 
    if (str1.compareTo("img") == 0)
      return c((String)stringBuffer); 
    aq aq1 = new aq();
    try {
      aq1.a = Image.createImage("/x" + bx.b + stringBuffer);
    } catch (Exception exception) {}
    return (aq1.a == null) ? null : aq1;
  }
  
  public static DataInputStream b(String paramString) {
    DataInputStream dataInputStream = null;
    return dataInputStream = new DataInputStream("".getClass().getResourceAsStream(paramString = paramString));
  }
  
  public static aq a(byte[] paramArrayOfbyte) {
    aq aq1;
    (aq1 = new aq()).a = Image.createImage(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    return aq1;
  }
  
  public static int a(Image paramImage) {
    return paramImage.getWidth() / bx.b;
  }
  
  public static int b(Image paramImage) {
    return paramImage.getHeight() / bx.b;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\aq.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */