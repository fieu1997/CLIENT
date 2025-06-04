public final class q extends ee {
  private static q a;
  
  public static q a() {
    if (a == null)
      a = new q(); 
    return a;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, byte paramByte) {
    n((byte)1);
    try {
      this.b.c().writeUTF(paramString1);
      this.b.c().writeUTF(paramString2);
      this.b.c().writeUTF(paramString3);
      this.b.c().writeUTF(paramString4);
      this.b.c().writeUTF(paramString5);
      this.b.c().writeUTF(paramString6);
      this.b.c().writeByte(bx.b);
      this.b.c().writeByte(0);
      this.b.c().writeInt(paramInt);
      this.b.c().writeByte(paramByte);
      this.b.c().writeByte((byte)(fi.h ? 1 : 0));
      this.b.c().writeByte(ft.G);
      this.b.c().writeByte(bs.k);
      this.b.c().writeByte(ft.B ? 1 : 0);
      this.b.c().writeShort(ft.I);
      this.b.c().writeUTF(ft.F);
      bv.a = false;
      bv.b = 0L;
      bv.c = false;
    } catch (Exception exception) {}
    b();
    if (paramInt == -1) {
      ft.a(df.bS, new bt(df.Z, 7));
      ft.N = dw.a();
      return;
    } 
    ft.a(df.dj, new bt(df.Z, 7));
  }
  
  public final void a(short paramShort1, short paramShort2) {
    n((byte)4);
    try {
      this.b.c().writeShort(paramShort1);
      this.b.c().writeShort(paramShort2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(short paramShort) {
    n((byte)5);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(short paramShort) {
    n((byte)-44);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(short paramShort) {
    n((byte)7);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(es parames, byte paramByte) {
    n((byte)9);
    try {
      dw.a("id skill " + paramByte);
      this.b.c().writeByte(paramByte);
      this.b.c().writeByte(parames.c());
      for (paramByte = 0; paramByte < parames.c(); paramByte++) {
        bf bf = (bf)parames.a(paramByte);
        this.b.c().writeShort(bf.a);
      } 
      dh.d();
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(short paramShort, String[] paramArrayOfString) {
    n((byte)-53);
    try {
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramArrayOfString.length);
      for (paramShort = 0; paramShort < paramArrayOfString.length; paramShort++)
        this.b.c().writeUTF(paramArrayOfString[paramShort]); 
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte, short paramShort) {
    n((byte)-52);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void d(short paramShort) {
    n((byte)-51);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, String paramString, byte paramByte2, byte paramByte3, byte paramByte4) {
    n((byte)14);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeUTF(paramString);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeByte(paramByte3);
      this.b.c().writeByte(paramByte4);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte, int paramInt) {
    n((byte)13);
    try {
      this.b.c().writeByte(0);
      this.b.c().writeInt(paramInt);
    } catch (Exception exception) {}
    b();
    ft.a(df.aG, (bt)null);
  }
  
  public final void a(byte paramByte) {
    n((byte)23);
    try {
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte, short paramShort1, short paramShort2) {
    n((byte)24);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeShort(paramShort1);
      this.b.c().writeShort(paramShort2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(short paramShort, byte paramByte1, byte paramByte2) {
    n((byte)52);
    try {
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeByte(paramByte1);
    } catch (Exception exception) {}
    b();
    if (cn.p.d(0, -5)) {
      cn.p.b++;
      fb.a((byte)0, (byte)0);
      cn.p.g();
      return;
    } 
    if (cn.p.d(8, 10)) {
      ft.j();
      cn.p.d = null;
      cn.p.f();
      cn.p.g();
      cn.p.c();
    } 
  }
  
  public final void b(short paramShort, byte paramByte1, byte paramByte2) {
    "Gui command -30 idNPC = " + paramShort + " , idMenu = " + paramByte1 + " , index = " + paramByte2;
    n((byte)-30);
    try {
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, byte paramByte2) {
    n((byte)21);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(byte paramByte1, byte paramByte2) {
    n((byte)11);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void e(short paramShort) {
    n((byte)32);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, short paramShort, byte paramByte2) {
    n((byte)18);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(short paramShort, byte paramByte) {
    n((byte)20);
    try {
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, byte paramByte2, short paramShort) {
    n((byte)22);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(byte paramByte1, byte paramByte2) {
    n((byte)22);
    try {
      this.b.c().writeByte(2);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void f(short paramShort) {
    n((byte)28);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(byte paramByte) {
    n((byte)31);
    try {
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(String paramString) {
    if (paramString == null || paramString.trim().length() == 0)
      return; 
    n((byte)27);
    try {
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
    ft.g.a(df.cz, String.valueOf(cn.f.cB) + ": ", paramString, (byte)1, false);
  }
  
  public final void a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      return; 
    n((byte)34);
    try {
      this.b.c().writeUTF(paramString1);
      this.b.c().writeUTF(paramString2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte, String paramString) {
    n((byte)35);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(byte paramByte, String paramString) {
    n((byte)48);
    try {
      this.b.c().writeByte(paramByte);
      if (paramByte != 0 && paramByte != 5 && paramByte != 4)
        this.b.c().writeUTF(paramString); 
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, String paramString, byte paramByte2, short paramShort, int paramInt) {
    n((byte)36);
    try {
      this.b.c().writeByte(paramByte1);
      switch (paramByte1) {
        case 0:
        case 1:
          this.b.c().writeUTF(paramString);
          break;
        case 2:
        case 3:
          this.b.c().writeByte(paramByte2);
          this.b.c().writeShort(paramShort);
          break;
        case 7:
          this.b.c().writeInt(paramInt);
          break;
        case 9:
          this.b.c().writeUTF(paramString);
          break;
      } 
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, byte paramByte2, es parames) {
    n((byte)40);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeByte(parames.c());
      for (paramByte1 = 0; paramByte1 < parames.c(); paramByte1++) {
        bf bf = (bf)parames.a(paramByte1);
        this.b.c().writeShort(bf.a);
      } 
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(es parames, byte paramByte) {
    n((byte)6);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeByte(parames.c());
      for (paramByte = 0; paramByte < parames.c(); paramByte++) {
        bf bf = (bf)parames.a(paramByte);
        this.b.c().writeShort(bf.a);
      } 
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(byte paramByte) {
    n((byte)42);
    try {
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(String paramString, byte paramByte) {
    n((byte)49);
    try {
      this.b.c().writeUTF(paramString);
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void d(byte paramByte) {
    n((byte)51);
    try {
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, byte paramByte2, byte[] paramArrayOfbyte) {
    n((byte)55);
    try {
      int i;
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
      paramByte1 = 0;
      if (paramArrayOfbyte != null)
        i = paramArrayOfbyte.length; 
      this.b.c().writeShort(i);
      for (paramByte2 = 0; paramByte2 < i; paramByte2++)
        this.b.c().writeByte(paramArrayOfbyte[paramByte2]); 
    } catch (Exception exception) {}
    b();
  }
  
  public final void e(byte paramByte) {
    n((byte)56);
    try {
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void f(byte paramByte) {
    n((byte)-28);
    try {
      this.b.c().writeByte(cf.z[paramByte]);
      "so goi len" + paramByte;
    } catch (Exception exception) {}
    b();
    int i;
    if ((i = ez.do.c()) == 5)
      ez.do.b(0); 
    if (!ft.A && fi.h) {
      ez.do.a(cf.A[paramByte]);
    } else {
      ez.do.a(cf.z[paramByte]);
    } 
    ez.dp = "";
    for (byte b = 0; b < ez.do.c(); b++)
      ez.dp = String.valueOf(ez.dp) + ez.do.a(b); 
  }
  
  public final void a(byte paramByte1, short paramShort1, byte paramByte2, short paramShort2) {
    n((byte)65);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeShort(paramShort1);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeShort(paramShort2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(byte paramByte1, short paramShort1, byte paramByte2, short paramShort2) {
    n((byte)44);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeShort(paramShort1);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeShort(1);
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(short paramShort, byte paramByte1, byte paramByte2) {
    n((byte)-32);
    try {
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void g(byte paramByte) {
    n(paramByte);
    b();
  }
  
  public final void b(byte paramByte1, short paramShort, byte paramByte2) {
    n((byte)67);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    n((byte)-100);
    try {
      switch (paramByte) {
        case 0:
          this.b.c().writeByte(paramByte);
          this.b.c().writeShort(paramInt1);
          this.b.c().writeShort(paramInt2);
          this.b.c().writeShort(paramInt3);
          this.b.c().writeShort(paramInt4);
          break;
        case 1:
          this.b.c().writeByte(paramByte);
          this.b.c().writeShort(paramInt1);
          break;
        case 2:
          this.b.c().writeByte(paramByte);
          this.b.c().writeShort(paramInt1);
          this.b.c().writeShort(paramInt2);
          break;
      } 
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(byte paramByte, short paramShort) {
    n((byte)73);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void h(byte paramByte) {
    n((byte)-97);
    try {
      this.b.c().writeByte(-1);
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(byte paramByte, String paramString) {
    n((byte)68);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void i(byte paramByte) {
    n((byte)69);
    try {
      this.b.c().writeByte(8);
    } catch (Exception exception) {}
    b();
  }
  
  public final void j(byte paramByte) {
    n((byte)69);
    try {
      this.b.c().writeByte(21);
    } catch (Exception exception) {}
    b();
  }
  
  public final void d(byte paramByte, String paramString) {
    n((byte)69);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(byte paramByte, int paramInt) {
    n((byte)69);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeInt(paramInt);
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(byte paramByte, int paramInt) {
    n((byte)69);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeInt(paramInt);
    } catch (Exception exception) {}
    b();
  }
  
  public final void e(byte paramByte, String paramString) {
    n((byte)69);
    try {
      this.b.c().writeByte(14);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte1, byte paramByte2, String paramString) {
    n((byte)69);
    try {
      this.b.c().writeByte(4);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void f(byte paramByte, String paramString) {
    n((byte)69);
    try {
      this.b.c().writeByte(18);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void g(byte paramByte, String paramString) {
    n((byte)69);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(String paramString) {
    n((byte)71);
    try {
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(byte paramByte, int paramInt, short paramShort) {
    n((byte)77);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeInt(paramInt);
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(short paramShort1, short paramShort2, byte paramByte1, byte paramByte2) {
    n((byte)45);
    try {
      this.b.c().writeShort(paramShort1);
      this.b.c().writeShort(paramShort2);
      this.b.c().writeByte(paramByte1);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(byte paramByte, short paramShort) {
    n((byte)44);
    try {
      this.b.c().writeByte(paramByte);
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void d(byte paramByte1, byte paramByte2) {
    n((byte)-91);
    try {
      this.b.c().writeByte(paramByte1);
      if (paramByte1 == 1) {
        this.b.c().writeByte(paramByte2);
      } else if (paramByte1 == 2) {
        this.b.c().writeByte(paramByte2);
      } 
    } catch (Exception exception) {}
    b();
  }
  
  public final void b(byte paramByte1, byte paramByte2, short paramShort) {
    n((byte)-91);
    try {
      this.b.c().writeByte(6);
      this.b.c().writeByte(paramByte2);
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(short paramShort1, short paramShort2, es parames) {
    n((byte)-31);
    try {
      this.b.c().writeShort(paramShort1);
      this.b.c().writeShort(paramShort2);
      paramShort1 = (byte)parames.c();
      this.b.c().writeByte(paramShort1);
      for (paramShort2 = 0; paramShort2 < paramShort1; paramShort2++) {
        String str = (String)parames.a(paramShort2);
        this.b.c().writeUTF(str);
      } 
    } catch (Exception exception2) {
      Exception exception1;
      (exception1 = null).printStackTrace();
    } 
    b();
  }
  
  public final void k(byte paramByte) {
    n((byte)37);
    try {
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void l(byte paramByte) {
    n((byte)-98);
    try {
      this.b.c().writeByte(paramByte);
    } catch (Exception exception) {}
    b();
  }
  
  public final void h(byte paramByte, String paramString) {
    n((byte)-101);
    try {
      this.b.c().writeByte(0);
      this.b.c().writeUTF(paramString);
    } catch (Exception exception) {}
    b();
  }
  
  public final void a(int paramInt1, es parames, String paramString, short paramShort, int paramInt2, byte paramByte) {
    n((byte)-102);
    try {
      fh fh;
      this.b.c().writeByte(paramInt1);
      switch (paramInt1) {
        case 0:
          this.b.c().writeByte(parames.c());
          for (paramInt1 = 0; paramInt1 < parames.c(); paramInt1++) {
            if ((fh = (fh)parames.a(paramInt1)) != null) {
              this.b.c().writeShort(fh.b);
              this.b.c().writeInt(fh.a);
              this.b.c().writeShort(fh.c);
              this.b.c().writeByte(fh.d);
            } 
          } 
          this.b.c().writeUTF(paramString);
          break;
        case 1:
          this.b.c().writeShort(fh);
          break;
        case 2:
          this.b.c().writeShort(paramInt2);
          this.b.c().writeShort(fh);
          this.b.c().writeByte(paramByte);
          break;
        case 5:
          this.b.c().writeShort(fh);
          this.b.c().writeShort(paramInt2);
          break;
      } 
      b();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void d(byte paramByte, short paramShort) {
    n((byte)-103);
    try {
      this.b.c().writeByte(0);
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void g(short paramShort) {
    n((byte)-106);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
  
  public final void c(byte paramByte1, short paramShort, byte paramByte2) {
    n((byte)-105);
    try {
      this.b.c().writeByte(paramByte1);
      this.b.c().writeShort(paramShort);
      this.b.c().writeByte(paramByte2);
    } catch (Exception exception) {}
    b();
  }
  
  public final void m(byte paramByte) {
    n((byte)-105);
    try {
      this.b.c().writeByte(3);
    } catch (Exception exception) {}
    b();
  }
  
  public final void h(short paramShort) {
    n((byte)-107);
    try {
      this.b.c().writeShort(paramShort);
    } catch (Exception exception) {}
    b();
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\q.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */