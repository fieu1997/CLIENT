final class al implements Runnable {
  private l a;
  
  al(l paraml) {
    this.a = paraml;
  }
  
  public final void run() {
    try {
      while (this.a.b()) {
        int i;
        al al1 = this;
        l.k++;
        byte b = al1.a.a.readByte();
        if (al1.a.g)
          b = l.a(al1.a, b); 
        if (al1.a.g) {
          if (b == -51 || b == -52 || b == -54 || b == 126) {
            if (b == 126) {
              b = al1.a.a.readByte();
              b = l.a(al1.a, b);
            } 
            byte[] arrayOfByte1 = { al1.a.a.readByte(), al1.a.a.readByte(), al1.a.a.readByte(), al1.a.a.readByte() };
            i = l.a(al1.a, arrayOfByte1[3]) & 0xFF | (l.a(al1.a, arrayOfByte1[2]) & 0xFF) << 8 | (l.a(al1.a, arrayOfByte1[1]) & 0xFF) << 16 | (l.a(al1.a, arrayOfByte1[0]) & 0xFF) << 24;
          } else {
            byte b1 = al1.a.a.readByte();
            byte b2 = al1.a.a.readByte();
            i = (l.a(al1.a, b1) & 0xFF) << 8 | l.a(al1.a, b2) & 0xFF;
          } 
        } else {
          i = al1.a.a.readUnsignedShort();
        } 
        byte[] arrayOfByte = new byte[i];
        int j = 0;
        int k = 0;
        while (j != -1 && k < i) {
          if ((j = al1.a.a.read(arrayOfByte, k, i - k)) > 0) {
            k += j;
            al1.a.f += k + 5;
          } 
        } 
        if (al1.a.g)
          for (i = 0; i < arrayOfByte.length; i++)
            arrayOfByte[i] = l.a(al1.a, arrayOfByte[i]);  
        eo eo2 = new eo(b, arrayOfByte);
        eo eo1 = eo2;
        try {
          al al2;
          if (eo1.a == -40) {
            eo eo = eo1;
            al2 = this;
            byte b1 = eo.b().readByte();
            al2.a.h = new byte[b1];
            byte b2;
            for (b2 = 0; b2 < b1; b2++)
              al2.a.h[b2] = eo.b().readByte(); 
            for (b2 = 0; b2 < al2.a.h.length - 1; b2++)
              al2.a.h[b2 + 1] = (byte)(al2.a.h[b2 + 1] ^ al2.a.h[b2]); 
            al2.a.g = true;
            continue;
          } 
          al al3 = al2;
          bo bo = this.a.b;
          switch (((eo)al3).a) {
            case -96:
              eq.aI((eo)al3);
            case -92:
              eq.aH((eo)al3);
            case -95:
              eq.aG((eo)al3);
            case -94:
              eq.aF((eo)al3);
            case -93:
              dw.a("--Nap winphone ");
            case -91:
              eq.aD((eo)al3);
            case -57:
              eq.ay((eo)al3);
            case -54:
              eq.az((eo)al3);
            case -53:
              ft.t.ag((eo)al3);
            case -52:
              eq.ae((eo)al3);
            case -51:
              eq.n((eo)al3);
            case -49:
              eq.af((eo)al3);
            case -44:
              eq.d((eo)al3);
            case -100:
              eq.a((eo)al3);
            case 1:
              eq.z((eo)al3);
            case -99:
              eq.I((eo)al3);
            case 2:
              eq.J((eo)al3);
            case 3:
              eq.b((eo)al3);
            case 4:
              eq.c((eo)al3);
            case 5:
              eq.e((eo)al3);
            case 7:
              eq.f((eo)al3);
            case 8:
              eq.g((eo)al3);
            case 12:
              eq.h((eo)al3);
            case 37:
              eq.ab((eo)al3);
            case 9:
              ft.t.i((eo)al3);
            case 15:
              eq.j((eo)al3);
            case 17:
              eq.k((eo)al3);
            case 10:
              eq.m((eo)al3);
            case 16:
              ft.t.o((eo)al3);
            case 19:
              eq.A((eo)al3);
            case 20:
              eq.B((eo)al3);
            case 23:
              eq.p((eo)al3);
            case 25:
              eq.q((eo)al3);
            case 26:
              eq.r((eo)al3);
            case 13:
              eq.s((eo)al3);
            case -50:
              eq.t((eo)al3);
            case 52:
              eq.u((eo)al3);
            case -31:
              ft.t.ar((eo)al3);
            case -32:
              ft.t.ak((eo)al3);
            case -30:
              eq.v((eo)al3);
            case 21:
              eq.w((eo)al3);
            case 28:
              eq.C((eo)al3);
            case 29:
              eq.D((eo)al3);
            case 30:
              eq.x((eo)al3);
            case 31:
              eq.aE((eo)al3);
            case 33:
              eq.y((eo)al3);
            case 32:
              eq.E((eo)al3);
            case 27:
              eq.F((eo)al3);
            case 34:
              eq.G((eo)al3);
            case 35:
              eq.H((eo)al3);
            case 39:
              eq.K((eo)al3);
            case 48:
              ft.t.L((eo)al3);
            case 36:
              ft.t.M((eo)al3);
            case 40:
              eq.N((eo)al3);
            case 6:
              ft.t.O((eo)al3);
            case 41:
              eq.P((eo)al3);
            case 42:
              eq.Q((eo)al3);
            case 49:
              eq.R((eo)al3);
            case 50:
              eq.S((eo)al3);
            case 51:
              eq.T((eo)al3);
            case 53:
              eq.as((eo)al3);
            case 54:
              eq.U((eo)al3);
            case 55:
              eq.W((eo)al3);
            case 56:
              eq.Y((eo)al3);
            case 57:
              eq.X((eo)al3);
            case 59:
              eq.Z((eo)al3);
            case 60:
              eq.aa((eo)al3);
            case 61:
              eq.ac((eo)al3);
            case 62:
              eq.ad((eo)al3);
            case 63:
              eq.ah((eo)al3);
            case 64:
              ft.t.ao((eo)al3);
            case 65:
              ft.t.ai((eo)al3);
            case 67:
              eq.al((eo)al3);
            case 73:
              ft.t.am((eo)al3);
            case 68:
              eq.an((eo)al3);
            case 69:
              eq.ap((eo)al3);
            case 70:
              eq.aq((eo)al3);
            case 74:
              eq.av((eo)al3);
            case 75:
              eq.at((eo)al3);
            case 76:
              eq.au((eo)al3);
            case 77:
              eq.aw((eo)al3);
            case 78:
              eq.ax((eo)al3);
            case -90:
            case 90:
              eq.V((eo)al3);
            case 44:
              ft.t.aj((eo)al3);
            case 84:
              eq.l((eo)al3);
            case 85:
              eq.aC((eo)al3);
            case 86:
              eq.aB((eo)al3);
            case -97:
              eq.aA((eo)al3);
            case -98:
              eq.aJ((eo)al3);
            case -101:
              eq.aK((eo)al3);
            case -102:
              eq.aL((eo)al3);
            case -103:
              eq.aM((eo)al3);
            case -104:
              eq.aN((eo)al3);
            case -105:
              eq.aO((eo)al3);
            case -106:
              eq.aP((eo)al3);
            case -108:
              ft.t.aQ((eo)al3);
          } 
        } catch (Exception exception) {
          (eo1 = null).printStackTrace();
        } 
      } 
    } catch (Exception exception) {}
    if (this.a.c) {
      if (this.a.b != null && dw.a() - this.a.i > 500L) {
        bo bo = this.a.b;
        bv.a();
      } 
      if (l.a(this.a) != null)
        l.c(this.a); 
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\al.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */