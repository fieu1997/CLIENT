import java.util.Enumeration;

public final class bk {
  static {
  
  }
  
  public static fd a(short paramShort) {
    fd fd;
    if ((fd = (fd)cn.n.a(paramShort)) == null) {
      fd = new fd();
      cn.n.a(paramShort, fd);
      String str = "/resLocal/npc/" + paramShort + ".png";
      if (paramShort >= 500) {
        int i = paramShort - 500;
        str = "/resLocal/npc/icon/" + i + ".png";
      } 
      aq aq;
      if ((aq = aq.a(str)) == null) {
        fd.a = o((short)(paramShort + 3000));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 3000));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd b(short paramShort) {
    fd fd;
    if ((fd = (fd)cn.m.a(paramShort)) == null) {
      fd = new fd();
      cn.m.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/tree/" + paramShort + ".png")) == null) {
        fd.a = o((short)paramShort);
      } else {
        fd.a = aq;
      } 
    } else if (!ft.A) {
      fd.d = (int)(ft.aj / 1000L);
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)paramShort);
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd c(short paramShort) {
    fd fd;
    if ((fd = (fd)au.K.a(paramShort)) == null) {
      fd = new fd();
      au.K.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/mons/" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 1000));
      } else {
        fd.a = aq;
      } 
    } else if (!ft.A) {
      fd.d = (int)(ft.aj / 1000L);
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 1000));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd d(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.ac.a(paramShort)) == null) {
      fd = new fd();
      bw.ac.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/icon/icon_" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 2000));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 2000));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd e(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.ad.a(paramShort)) == null) {
      fd = new fd();
      bw.ad.a(paramShort, fd);
      String str;
      aq aq;
      if ((aq = aq.a(str = "/resLocal/potion/potionIcon_" + ((paramShort + 1 >= 10) ? (new StringBuffer(String.valueOf(paramShort + 1))).toString() : ("0" + (paramShort + 1))) + ".png")) == null) {
        fd.a = o((short)(paramShort + 4000));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 4000));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd f(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.ae.a(paramShort)) == null) {
      fd = new fd();
      bw.ae.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/iconq/" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 5000));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 5000));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd g(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.af.a(paramShort)) == null) {
      fd = new fd();
      bw.af.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/material/" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 5500));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 5500));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd h(short paramShort) {
    fd fd;
    if ((fd = (fd)ev.a.a(paramShort)) == null) {
      fd = new fd();
      ev.a.a(paramShort, fd);
      aq aq;
      String str;
      if ((aq = aq.a(str = (paramShort < 10) ? ("/resLocal/skill/iconSkill_0" + paramShort + ".png") : ("/resLocal/skill/iconSkill_" + paramShort + ".png"))) == null) {
        fd.a = o((short)(paramShort + 6000));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 6000));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd i(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.ag.a(paramShort)) == null) {
      fd = new fd();
      bw.ag.a(paramShort, fd);
      String str = "/resLocal/iconclan/" + paramShort + ".png";
      if (paramShort >= 500) {
        int i = paramShort - 500;
        str = "/resLocal/iconclan/shop/" + i + ".png";
      } 
      aq aq;
      if ((aq = aq.a(str)) == null) {
        fd.a = o((short)(paramShort + 7000));
      } else {
        fd.a = aq;
      } 
    } else if (!ft.A) {
      fd.d = (int)(ft.aj / 1000L);
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 7000));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd j(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.ah.a(paramShort)) == null) {
      fd = new fd();
      bw.ah.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/iconclan/huyhieu/" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 9500));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 9500));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  public static fd k(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.ai.a(paramShort)) == null) {
      fd = new fd();
      bw.ai.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/pet/icon/icon_pet_" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 10000));
      } else {
        fd.a = aq;
      } 
    } 
    return fd;
  }
  
  public static fd l(short paramShort) {
    fd fd;
    if ((fd = (fd)s.x.a(paramShort)) == null) {
      fd = new fd();
      s.x.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/pet/" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 10200));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 10200));
        fd.e = 0;
      } 
    } 
    return fd;
  }
  
  private static aq o(short paramShort) {
    aq aq;
    byte[] arrayOfByte = null;
    "image" + paramShort;
    arrayOfByte = null;
    if (m(paramShort))
      arrayOfByte = ak.a("image" + paramShort); 
    if (arrayOfByte == null) {
      q.a().d(paramShort);
      return null;
    } 
    try {
      aq = aq.a(arrayOfByte);
    } catch (Exception exception) {
      q.a().d(paramShort);
      return null;
    } 
    return aq;
  }
  
  public static boolean m(short paramShort) {
    return ((paramShort >= 4000 && paramShort < 5000) || (paramShort >= 3000 && paramShort < 3500) || (paramShort >= 6000 && paramShort < 7000));
  }
  
  public static void a(byte[] paramArrayOfbyte, short paramShort) {
    try {
      ak.a("image" + paramShort, paramArrayOfbyte);
      return;
    } catch (Exception exception) {
      (paramArrayOfbyte = null).printStackTrace();
      return;
    } 
  }
  
  public static void a(ek paramek) {
    ek ek1;
    Enumeration enumeration = (ek1 = paramek).a.keys();
    while (enumeration.hasMoreElements()) {
      String str = enumeration.nextElement();
      fd fd = (fd)paramek.a(str);
      if (ft.aj / 1000L - fd.d > 300L)
        paramek.a(str); 
    } 
  }
  
  public static fd n(short paramShort) {
    fd fd;
    if ((fd = (fd)bw.aj.a(paramShort)) == null) {
      fd = new fd();
      bw.aj.a(paramShort, fd);
      aq aq;
      if ((aq = aq.a("/resLocal/mount/" + paramShort + ".png")) == null) {
        fd.a = o((short)(paramShort + 10700));
      } else {
        fd.a = aq;
      } 
    } 
    if (fd.a == null) {
      fd.e++;
      if (fd.e >= 200) {
        q.a().d((short)(paramShort + 10700));
        fd.e = 0;
      } 
    } 
    return fd;
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\bk.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */