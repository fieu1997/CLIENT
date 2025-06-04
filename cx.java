public final class cx extends dx {
  private es a;
  
  private es b;
  
  private int c;
  
  private int z;
  
  private en A;
  
  private byte[] B;
  
  private int C;
  
  private long D;
  
  private int E;
  
  private dq F;
  
  private int G;
  
  private int H;
  
  public cx(int paramInt1, int paramInt2, int paramInt3) {
    int i;
    int j;
    this.a = new es("EffectEnd VecEffEnd");
    this.b = new es("EffectEnd VecSubEffEnd");
    this.C = 0;
    this.E = 2000;
    this.G = 0;
    this.k = -1;
    this.d = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    switch (paramInt1) {
      case 0:
        this.u = new ce(53);
        this.f = 6;
        return;
      case 51:
        this.u = new ce(140);
        this.f = 6;
        return;
      case 1:
        this.u = new ce(29);
        this.f = 3;
        return;
      case 2:
        this.u = new ce(18);
        this.f = 4;
        return;
      case 3:
        this.u = new ce(27);
        this.f = 15;
        for (paramInt1 = 0; paramInt1 < 7; paramInt1++) {
          en en1;
          (en1 = new en()).a = paramInt2 + ak.g(22);
          en1.b = paramInt3 + ak.g(8);
          en1.m = ak.f(this.u.c);
          this.a.a(en1);
        } 
        return;
      case 4:
        this.u = new ce(4);
        this.f = 5;
        return;
      case 5:
        this.u = new ce(51);
        this.f = 6;
        return;
      case 6:
        this.u = new ce(52);
        this.f = 4;
        return;
      case 7:
        this.u = new ce(54);
        this.f = 4;
        return;
      case 9:
        if (ft.B) {
          b();
          return;
        } 
        this.u = new ce(56);
        this.f = ak.c(11, 15);
        paramInt1 = ak.c(3, 7);
        for (i = 0; i < paramInt1; i++) {
          en en1;
          (en1 = new en()).a = paramInt2 + ak.g(5);
          en1.b = paramInt3 + ak.g(7);
          en1.p = ak.f(this.u.c);
          en1.m = ak.f(2);
          en1.j = -ak.c(6, 9);
          en1.i = ak.c(1, 4);
          if (i % 2 == 0)
            en1.i = -en1.i; 
          this.a.a(en1);
        } 
        return;
      case 10:
        this.u = new ce(58);
        this.f = 4;
        return;
      case 11:
        this.u = new ce(42);
        this.f = 9;
        return;
      case 12:
        this.u = new ce(60);
        this.f = 4;
        return;
      case 13:
        this.u = new ce(9);
        this.f = 4;
        return;
      case 14:
      case 15:
        if (ft.B) {
          b();
          return;
        } 
        i = 0;
        if (paramInt1 == 14) {
          this.u = new ce(1);
          i = ak.c(7, 12);
        } else {
          this.u = new ce(5);
          i = ak.c(7, 12);
        } 
        this.f = 12;
        for (j = 0; j < i; j++) {
          en en1;
          (en1 = new en()).a = paramInt2 + ak.g(4);
          en1.b = paramInt3 + ak.g(5);
          en1.p = ak.f(this.u.c);
          en1.j = -ak.c(5, 9);
          en1.i = ak.c(0, 3);
          if (j % 2 == 0)
            en1.i = -en1.i; 
          this.a.a(en1);
        } 
        return;
      case 26:
        this.r = -1;
        if ((j = ak.f(2)) == 0) {
          this.u = new ce(90);
        } else {
          this.u = new ce(13);
        } 
        this.f = ak.c(74, 85);
        a(20);
        return;
      case 19:
        if (ft.B) {
          b();
          return;
        } 
        this.u = new ce(28);
        this.l = (ak.f(2) == 0) ? 0 : 2;
        this.f = 2;
        return;
      case 21:
      case 33:
        if (this.d == 33) {
          this.u = new ce(2);
          i = 30;
          this.f = 30;
        } else {
          this.u = new ce(66);
          i = 40;
          this.f = 12;
        } 
        for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
          en en1;
          (en1 = new en()).a = paramInt2 + ak.g(10);
          en1.b = paramInt3 - ak.g(8);
          en1.p = ak.f(this.u.c);
          en1.j = -ak.c(3, 11);
          if (this.d == 33) {
            en1.i = ak.c(0, 4);
          } else {
            en1.i = ak.c(0, 3);
          } 
          if (paramInt1 % 2 == 0)
            en1.i = -en1.i; 
          this.a.a(en1);
        } 
        return;
      case 24:
        this.u = new ce(12);
        this.f = ak.c(18, 23);
        this.r = -1;
        return;
      case 25:
      case 28:
      case 40:
        if (this.d == 25) {
          this.u = new ce(86);
        } else if (this.d == 28) {
          this.u = new ce(96);
        } else if (this.d == 40) {
          if ((paramInt1 = ft.p.a(paramInt2, paramInt3)) == 2 || paramInt1 == -1)
            return; 
          this.u = new ce(19);
        } 
        this.r = -1;
        this.f = ak.c(74, 85);
        a(20);
        return;
      case 27:
      case 30:
        this.f = 20;
        this.r = -1;
        if (this.d == 27) {
          this.u = new ce(92);
        } else if (this.d == 30) {
          this.u = new ce(115);
        } 
        for (paramInt1 = 0; paramInt1 < 3; paramInt1++) {
          en en1;
          (en1 = new en()).a = paramInt2 + ak.g(3);
          en1.b = paramInt3 + ak.g(3);
          if (ak.f(2) == 0) {
            if (paramInt1 % 2 == 0) {
              en1.i = ak.f(3);
            } else {
              en1.i = -ak.f(3);
            } 
          } else {
            en1.i = ak.g(3);
          } 
          en1.j = -5;
          en1.o = ak.c(6, 12);
          en1.p = paramInt1;
          this.a.a(en1);
        } 
        return;
      case 29:
        this.u = new ce(105);
        this.f = ak.c(11, 15);
        paramInt1 = ak.c(3, 6);
        for (j = 0; j < paramInt1; j++) {
          en en1;
          (en1 = new en()).a = paramInt2 + ak.g(5);
          en1.b = paramInt3 + ak.g(7);
          en1.p = ak.f(this.u.c);
          en1.m = ak.f(2);
          en1.j = -ak.c(6, 9);
          en1.i = ak.c(1, 4);
          if (j % 2 == 0)
            en1.i = -en1.i; 
          this.a.a(en1);
        } 
        return;
      case 32:
        (this = this).v = new ce(67);
        this.f = 23;
        return;
      case 34:
        this.u = new ce(14);
        this.f = 18;
        return;
      case 54:
        this.u = new ce(144);
        this.f = 10;
        return;
      case 35:
        this.u = new ce(122);
        this.f = 6;
        return;
      case 36:
        this.u = new ce(4);
        this.f = 10;
        return;
      case 38:
        this.u = new ce(65);
        this.v = new ce(122);
        this.w = new ce(14);
        this.f = 12;
        return;
      case 39:
        this.f = 55;
        return;
      case 42:
        this.u = new ce(7);
        this.v = new ce(2);
        this.f = 20;
        this.z = 0;
        for (j = 0; j < 8; j++) {
          i = ak.c(4, 6);
          en en1;
          (en1 = new en()).a = paramInt2 * 1000;
          en1.b = paramInt3 * 1000;
          en1.i = ak.b(ak.d(this.z)) * i;
          en1.j = ak.a(ak.d(this.z)) * i;
          this.z += 45;
          this.a.a(en1);
        } 
        return;
      case 43:
        this.u = new ce(124);
        this.f = 10;
        return;
      case 44:
        this.u = new ce(70);
        this.f = 4;
        return;
      case 45:
        this.u = new ce(63);
        this.f = 8;
        return;
      case 46:
        this.u = new ce(86);
        this.r = -1;
        this.f = 6;
        return;
      case 48:
        this.u = new ce(134);
        this.f = 8;
        break;
    } 
  }
  
  public cx(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
    this.a = new es("EffectEnd VecEffEnd");
    this.b = new es("EffectEnd VecSubEffEnd");
    this.C = 0;
    this.E = 2000;
    this.G = 0;
    this.k = -1;
    this.d = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.m = paramInt4;
    switch (paramInt1) {
      case 55:
        this.B = new byte[] { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
        if ((paramInt1 = ft.p.a(paramInt2, paramInt3)) == 2 || paramInt1 == -1)
          return; 
        this.u = new ce(145);
        this.r = paramByte;
        return;
      case 56:
        this.u = new ce(152);
        this.r = paramByte;
        this.f = ak.c(20, 30);
        a(20);
        break;
    } 
  }
  
  public cx(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a = new es("EffectEnd VecEffEnd");
    this.b = new es("EffectEnd VecSubEffEnd");
    this.C = 0;
    this.E = 2000;
    this.G = 0;
    this.k = -1;
    this.d = paramInt1;
    this.g = paramInt3;
    this.h = paramInt4;
    this.u = new ce(paramInt2);
    this.f = this.u.a();
  }
  
  public cx(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    this.a = new es("EffectEnd VecEffEnd");
    this.b = new es("EffectEnd VecSubEffEnd");
    this.C = 0;
    this.E = 2000;
    this.G = 0;
    this.k = -1;
    this.d = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    switch (paramInt1) {
      case 47:
        this.D = paramLong + this.E;
        this.u = new ce(86);
        this.r = -1;
        this.f = ak.c(74, 85);
        a(20);
        return;
      case 49:
        this.D = paramLong;
        this.F = new dq(51, paramInt2, paramInt3, 0, 0, 0, 0);
        this.r = -1;
        this.f = 6;
        return;
      case 50:
        this.D = paramLong;
        this.u = new ce(137);
        this.r = -1;
        this.f = 12;
        break;
    } 
  }
  
  public cx(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    this.a = new es("EffectEnd VecEffEnd");
    this.b = new es("EffectEnd VecSubEffEnd");
    this.C = 0;
    this.E = 2000;
    this.G = 0;
    this.d = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramInt4;
    this.j = paramInt5;
    switch (paramInt1) {
      case 31:
        (this = this).u = new ce(7);
        this.v = new ce(2);
        this.f = 15;
        this.c = ez.c(this.i, this.j, this.g, this.h);
        this.z = ak.a(this.g - this.i, this.h - this.j);
        this.A = new en(this.i * 1000, this.j * 1000);
        this.A.k = this.i * 1000;
        this.A.l = this.j * 1000;
        this.A.n = this.z;
        this.A.j = ak.a(ak.d(this.A.n % 360)) * this.c;
        this.A.i = ak.b(ak.d(this.A.n % 360)) * this.c;
        this.A.d = 0;
        return;
      case 37:
        this.u = new ce(7);
        this.v = new ce(2);
        this.f = 100;
        this.c = 40;
        this.z = 0;
        this.G = paramInt6;
        this.H = 360 / paramInt6;
        return;
      case 41:
        this.u = new ce(7);
        this.v = new ce(2);
        this.f = 18;
        break;
    } 
  }
  
  public final void a(bx parambx) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : I
    //   4: tableswitch default -> 1771, 0 -> 252, 1 -> 408, 2 -> 252, 3 -> 332, 4 -> 408, 5 -> 252, 6 -> 408, 7 -> 408, 8 -> 1771, 9 -> 446, 10 -> 408, 11 -> 252, 12 -> 408, 13 -> 408, 14 -> 507, 15 -> 507, 16 -> 1771, 17 -> 1771, 18 -> 1771, 19 -> 812, 20 -> 1771, 21 -> 507, 22 -> 1771, 23 -> 1771, 24 -> 875, 25 -> 936, 26 -> 684, 27 -> 446, 28 -> 936, 29 -> 446, 30 -> 446, 31 -> 1008, 32 -> 1145, 33 -> 608, 34 -> 292, 35 -> 252, 36 -> 252, 37 -> 1186, 38 -> 1335, 39 -> 1771, 40 -> 936, 41 -> 1186, 42 -> 1186, 43 -> 1444, 44 -> 408, 45 -> 408, 46 -> 936, 47 -> 1484, 48 -> 1581, 49 -> 1565, 50 -> 1581, 51 -> 252, 52 -> 1771, 53 -> 1771, 54 -> 252, 55 -> 1696, 56 -> 1621, 57 -> 252
    //   252: aload_0
    //   253: getfield u : Lce;
    //   256: ifnull -> 1802
    //   259: aload_0
    //   260: getfield u : Lce;
    //   263: aload_0
    //   264: getfield k : I
    //   267: iconst_2
    //   268: idiv
    //   269: aload_0
    //   270: getfield u : Lce;
    //   273: getfield c : I
    //   276: irem
    //   277: aload_0
    //   278: getfield g : I
    //   281: aload_0
    //   282: getfield h : I
    //   285: iconst_0
    //   286: iconst_3
    //   287: aload_1
    //   288: invokevirtual c : (IIIIILbx;)V
    //   291: return
    //   292: aload_0
    //   293: getfield u : Lce;
    //   296: ifnull -> 1802
    //   299: aload_0
    //   300: getfield u : Lce;
    //   303: aload_0
    //   304: getfield k : I
    //   307: iconst_3
    //   308: idiv
    //   309: aload_0
    //   310: getfield u : Lce;
    //   313: getfield c : I
    //   316: irem
    //   317: aload_0
    //   318: getfield g : I
    //   321: aload_0
    //   322: getfield h : I
    //   325: iconst_0
    //   326: iconst_3
    //   327: aload_1
    //   328: invokevirtual c : (IIIIILbx;)V
    //   331: return
    //   332: iconst_0
    //   333: istore_2
    //   334: goto -> 396
    //   337: aload_0
    //   338: getfield a : Les;
    //   341: iload_2
    //   342: invokevirtual a : (I)Ljava/lang/Object;
    //   345: checkcast en
    //   348: astore_3
    //   349: aload_0
    //   350: getfield u : Lce;
    //   353: ifnull -> 393
    //   356: aload_0
    //   357: getfield u : Lce;
    //   360: aload_3
    //   361: getfield n : I
    //   364: aload_0
    //   365: getfield k : I
    //   368: iadd
    //   369: iconst_2
    //   370: idiv
    //   371: aload_0
    //   372: getfield u : Lce;
    //   375: getfield c : I
    //   378: irem
    //   379: aload_3
    //   380: getfield a : I
    //   383: aload_3
    //   384: getfield b : I
    //   387: iconst_0
    //   388: iconst_3
    //   389: aload_1
    //   390: invokevirtual c : (IIIIILbx;)V
    //   393: iinc #2, 1
    //   396: iload_2
    //   397: aload_0
    //   398: getfield a : Les;
    //   401: invokevirtual c : ()I
    //   404: if_icmplt -> 337
    //   407: return
    //   408: aload_0
    //   409: getfield u : Lce;
    //   412: ifnull -> 1802
    //   415: aload_0
    //   416: getfield u : Lce;
    //   419: aload_0
    //   420: getfield k : I
    //   423: aload_0
    //   424: getfield u : Lce;
    //   427: getfield c : I
    //   430: irem
    //   431: aload_0
    //   432: getfield g : I
    //   435: aload_0
    //   436: getfield h : I
    //   439: iconst_0
    //   440: iconst_3
    //   441: aload_1
    //   442: invokevirtual c : (IIIIILbx;)V
    //   445: return
    //   446: iconst_0
    //   447: istore_2
    //   448: goto -> 495
    //   451: aload_0
    //   452: getfield a : Les;
    //   455: iload_2
    //   456: invokevirtual a : (I)Ljava/lang/Object;
    //   459: checkcast en
    //   462: astore_3
    //   463: aload_0
    //   464: getfield u : Lce;
    //   467: ifnull -> 492
    //   470: aload_0
    //   471: getfield u : Lce;
    //   474: aload_3
    //   475: getfield p : I
    //   478: aload_3
    //   479: getfield a : I
    //   482: aload_3
    //   483: getfield b : I
    //   486: iconst_0
    //   487: iconst_3
    //   488: aload_1
    //   489: invokevirtual c : (IIIIILbx;)V
    //   492: iinc #2, 1
    //   495: iload_2
    //   496: aload_0
    //   497: getfield a : Les;
    //   500: invokevirtual c : ()I
    //   503: if_icmplt -> 451
    //   506: return
    //   507: iconst_0
    //   508: istore_2
    //   509: goto -> 596
    //   512: aload_0
    //   513: getfield a : Les;
    //   516: iload_2
    //   517: invokevirtual a : (I)Ljava/lang/Object;
    //   520: checkcast en
    //   523: astore_3
    //   524: aload_0
    //   525: getfield k : I
    //   528: aload_0
    //   529: getfield f : I
    //   532: iconst_3
    //   533: idiv
    //   534: iconst_1
    //   535: ishl
    //   536: if_icmpge -> 553
    //   539: aload_0
    //   540: getfield u : Lce;
    //   543: ifnull -> 593
    //   546: aload_0
    //   547: getfield u : Lce;
    //   550: goto -> 575
    //   553: aload_0
    //   554: getfield u : Lce;
    //   557: ifnull -> 593
    //   560: aload_0
    //   561: getfield u : Lce;
    //   564: aload_3
    //   565: getfield p : I
    //   568: ifne -> 575
    //   571: iconst_3
    //   572: goto -> 579
    //   575: aload_3
    //   576: getfield p : I
    //   579: aload_3
    //   580: getfield a : I
    //   583: aload_3
    //   584: getfield b : I
    //   587: iconst_0
    //   588: iconst_3
    //   589: aload_1
    //   590: invokevirtual c : (IIIIILbx;)V
    //   593: iinc #2, 1
    //   596: iload_2
    //   597: aload_0
    //   598: getfield a : Les;
    //   601: invokevirtual c : ()I
    //   604: if_icmplt -> 512
    //   607: return
    //   608: iconst_0
    //   609: istore_2
    //   610: goto -> 672
    //   613: aload_0
    //   614: getfield a : Les;
    //   617: iload_2
    //   618: invokevirtual a : (I)Ljava/lang/Object;
    //   621: checkcast en
    //   624: astore_3
    //   625: aload_0
    //   626: getfield u : Lce;
    //   629: ifnull -> 669
    //   632: aload_0
    //   633: getfield u : Lce;
    //   636: aload_3
    //   637: getfield p : I
    //   640: aload_3
    //   641: getfield n : I
    //   644: iconst_2
    //   645: idiv
    //   646: iadd
    //   647: aload_0
    //   648: getfield u : Lce;
    //   651: getfield c : I
    //   654: irem
    //   655: aload_3
    //   656: getfield a : I
    //   659: aload_3
    //   660: getfield b : I
    //   663: iconst_0
    //   664: iconst_3
    //   665: aload_1
    //   666: invokevirtual c : (IIIIILbx;)V
    //   669: iinc #2, 1
    //   672: iload_2
    //   673: aload_0
    //   674: getfield a : Les;
    //   677: invokevirtual c : ()I
    //   680: if_icmplt -> 613
    //   683: return
    //   684: aload_0
    //   685: getfield k : I
    //   688: iconst_2
    //   689: if_icmpge -> 722
    //   692: aload_0
    //   693: getfield u : Lce;
    //   696: ifnull -> 1802
    //   699: aload_0
    //   700: getfield u : Lce;
    //   703: aload_0
    //   704: getfield k : I
    //   707: aload_0
    //   708: getfield g : I
    //   711: aload_0
    //   712: getfield h : I
    //   715: iconst_0
    //   716: iconst_3
    //   717: aload_1
    //   718: invokevirtual c : (IIIIILbx;)V
    //   721: return
    //   722: aload_0
    //   723: getfield k : I
    //   726: aload_0
    //   727: getfield f : I
    //   730: iconst_4
    //   731: isub
    //   732: if_icmpge -> 762
    //   735: aload_0
    //   736: getfield u : Lce;
    //   739: ifnull -> 1802
    //   742: aload_0
    //   743: getfield u : Lce;
    //   746: iconst_2
    //   747: aload_0
    //   748: getfield g : I
    //   751: aload_0
    //   752: getfield h : I
    //   755: iconst_0
    //   756: iconst_3
    //   757: aload_1
    //   758: invokevirtual c : (IIIIILbx;)V
    //   761: return
    //   762: aload_0
    //   763: getfield k : I
    //   766: aload_0
    //   767: getfield f : I
    //   770: if_icmpge -> 1802
    //   773: aload_0
    //   774: getfield u : Lce;
    //   777: ifnull -> 1802
    //   780: aload_0
    //   781: getfield u : Lce;
    //   784: aload_0
    //   785: getfield f : I
    //   788: iconst_1
    //   789: isub
    //   790: aload_0
    //   791: getfield k : I
    //   794: isub
    //   795: iconst_2
    //   796: idiv
    //   797: aload_0
    //   798: getfield g : I
    //   801: aload_0
    //   802: getfield h : I
    //   805: iconst_0
    //   806: iconst_3
    //   807: aload_1
    //   808: invokevirtual c : (IIIIILbx;)V
    //   811: return
    //   812: aload_0
    //   813: getfield u : Lce;
    //   816: ifnull -> 1802
    //   819: aload_0
    //   820: getfield u : Lce;
    //   823: aload_0
    //   824: getfield l : I
    //   827: aload_0
    //   828: getfield k : I
    //   831: aload_0
    //   832: getfield u : Lce;
    //   835: getfield c : I
    //   838: irem
    //   839: iadd
    //   840: aload_0
    //   841: getfield g : I
    //   844: aload_0
    //   845: getfield u : Lce;
    //   848: getfield a : I
    //   851: iconst_2
    //   852: idiv
    //   853: isub
    //   854: aload_0
    //   855: getfield h : I
    //   858: aload_0
    //   859: getfield u : Lce;
    //   862: getfield b : I
    //   865: iconst_2
    //   866: idiv
    //   867: isub
    //   868: iconst_0
    //   869: iconst_0
    //   870: aload_1
    //   871: invokevirtual c : (IIIIILbx;)V
    //   874: return
    //   875: iconst_0
    //   876: istore_2
    //   877: aload_0
    //   878: getfield k : I
    //   881: aload_0
    //   882: getfield f : I
    //   885: iconst_5
    //   886: isub
    //   887: if_icmple -> 904
    //   890: aload_0
    //   891: getfield k : I
    //   894: aload_0
    //   895: getfield f : I
    //   898: iconst_4
    //   899: isub
    //   900: isub
    //   901: iconst_2
    //   902: idiv
    //   903: istore_2
    //   904: iload_2
    //   905: iconst_3
    //   906: if_icmpge -> 1802
    //   909: aload_0
    //   910: getfield u : Lce;
    //   913: ifnull -> 1802
    //   916: aload_0
    //   917: getfield u : Lce;
    //   920: iload_2
    //   921: aload_0
    //   922: getfield g : I
    //   925: aload_0
    //   926: getfield h : I
    //   929: iconst_0
    //   930: iconst_3
    //   931: aload_1
    //   932: invokevirtual c : (IIIIILbx;)V
    //   935: return
    //   936: aload_0
    //   937: getfield k : I
    //   940: aload_0
    //   941: getfield f : I
    //   944: if_icmpgt -> 1802
    //   947: iconst_0
    //   948: istore_3
    //   949: aload_0
    //   950: getfield k : I
    //   953: aload_0
    //   954: getfield f : I
    //   957: iconst_5
    //   958: isub
    //   959: if_icmple -> 979
    //   962: aload_0
    //   963: getfield f : I
    //   966: iconst_1
    //   967: isub
    //   968: aload_0
    //   969: getfield k : I
    //   972: isub
    //   973: iconst_2
    //   974: idiv
    //   975: istore_3
    //   976: goto -> 981
    //   979: iconst_2
    //   980: istore_3
    //   981: aload_0
    //   982: getfield u : Lce;
    //   985: ifnull -> 1802
    //   988: aload_0
    //   989: getfield u : Lce;
    //   992: iload_3
    //   993: aload_0
    //   994: getfield g : I
    //   997: aload_0
    //   998: getfield h : I
    //   1001: iconst_0
    //   1002: iconst_3
    //   1003: aload_1
    //   1004: invokevirtual c : (IIIIILbx;)V
    //   1007: return
    //   1008: iconst_0
    //   1009: istore_3
    //   1010: goto -> 1063
    //   1013: aload_0
    //   1014: getfield a : Les;
    //   1017: iload_3
    //   1018: invokevirtual a : (I)Ljava/lang/Object;
    //   1021: checkcast en
    //   1024: astore #4
    //   1026: aload_0
    //   1027: getfield v : Lce;
    //   1030: ifnull -> 1060
    //   1033: aload_0
    //   1034: getfield v : Lce;
    //   1037: aload #4
    //   1039: getfield n : I
    //   1042: iconst_2
    //   1043: idiv
    //   1044: aload #4
    //   1046: getfield a : I
    //   1049: aload #4
    //   1051: getfield b : I
    //   1054: iconst_0
    //   1055: iconst_3
    //   1056: aload_1
    //   1057: invokevirtual c : (IIIIILbx;)V
    //   1060: iinc #3, 1
    //   1063: iload_3
    //   1064: aload_0
    //   1065: getfield a : Les;
    //   1068: invokevirtual c : ()I
    //   1071: if_icmplt -> 1013
    //   1074: aload_0
    //   1075: getfield c : I
    //   1078: iconst_5
    //   1079: if_icmple -> 1802
    //   1082: aload_0
    //   1083: getfield u : Lce;
    //   1086: ifnull -> 1802
    //   1089: aload_0
    //   1090: getfield u : Lce;
    //   1093: aload_0
    //   1094: getfield A : Len;
    //   1097: getfield d : I
    //   1100: aload_0
    //   1101: getfield A : Len;
    //   1104: getfield k : I
    //   1107: aload_0
    //   1108: getfield A : Len;
    //   1111: getfield i : I
    //   1114: iadd
    //   1115: sipush #1000
    //   1118: idiv
    //   1119: aload_0
    //   1120: getfield A : Len;
    //   1123: getfield l : I
    //   1126: aload_0
    //   1127: getfield A : Len;
    //   1130: getfield j : I
    //   1133: iadd
    //   1134: sipush #1000
    //   1137: idiv
    //   1138: iconst_0
    //   1139: iconst_3
    //   1140: aload_1
    //   1141: invokevirtual c : (IIIIILbx;)V
    //   1144: return
    //   1145: aload_0
    //   1146: getfield v : Lce;
    //   1149: ifnull -> 1802
    //   1152: aload_0
    //   1153: getfield v : Lce;
    //   1156: iconst_0
    //   1157: aload_0
    //   1158: getfield g : I
    //   1161: aload_0
    //   1162: getfield h : I
    //   1165: aload_0
    //   1166: getfield k : I
    //   1169: aload_0
    //   1170: getfield f : I
    //   1173: iconst_2
    //   1174: idiv
    //   1175: isub
    //   1176: iconst_1
    //   1177: ishl
    //   1178: isub
    //   1179: iconst_0
    //   1180: iconst_3
    //   1181: aload_1
    //   1182: invokevirtual c : (IIIIILbx;)V
    //   1185: return
    //   1186: iconst_0
    //   1187: istore_3
    //   1188: goto -> 1257
    //   1191: aload_0
    //   1192: getfield a : Les;
    //   1195: iload_3
    //   1196: invokevirtual a : (I)Ljava/lang/Object;
    //   1199: checkcast en
    //   1202: astore #4
    //   1204: aload_0
    //   1205: getfield u : Lce;
    //   1208: ifnull -> 1254
    //   1211: aload_0
    //   1212: getfield u : Lce;
    //   1215: aload #4
    //   1217: getfield n : I
    //   1220: iconst_2
    //   1221: idiv
    //   1222: aload_0
    //   1223: getfield u : Lce;
    //   1226: getfield c : I
    //   1229: irem
    //   1230: aload #4
    //   1232: getfield a : I
    //   1235: sipush #1000
    //   1238: idiv
    //   1239: aload #4
    //   1241: getfield b : I
    //   1244: sipush #1000
    //   1247: idiv
    //   1248: iconst_0
    //   1249: iconst_3
    //   1250: aload_1
    //   1251: invokevirtual c : (IIIIILbx;)V
    //   1254: iinc #3, 1
    //   1257: iload_3
    //   1258: aload_0
    //   1259: getfield a : Les;
    //   1262: invokevirtual c : ()I
    //   1265: if_icmplt -> 1191
    //   1268: iconst_0
    //   1269: istore_3
    //   1270: goto -> 1323
    //   1273: aload_0
    //   1274: getfield b : Les;
    //   1277: iload_3
    //   1278: invokevirtual a : (I)Ljava/lang/Object;
    //   1281: checkcast en
    //   1284: astore #4
    //   1286: aload_0
    //   1287: getfield v : Lce;
    //   1290: ifnull -> 1320
    //   1293: aload_0
    //   1294: getfield v : Lce;
    //   1297: aload #4
    //   1299: getfield n : I
    //   1302: iconst_2
    //   1303: idiv
    //   1304: aload #4
    //   1306: getfield a : I
    //   1309: aload #4
    //   1311: getfield b : I
    //   1314: iconst_0
    //   1315: iconst_3
    //   1316: aload_1
    //   1317: invokevirtual c : (IIIIILbx;)V
    //   1320: iinc #3, 1
    //   1323: iload_3
    //   1324: aload_0
    //   1325: getfield b : Les;
    //   1328: invokevirtual c : ()I
    //   1331: if_icmplt -> 1273
    //   1334: return
    //   1335: aload_0
    //   1336: getfield k : I
    //   1339: bipush #6
    //   1341: if_icmpge -> 1408
    //   1344: aload_0
    //   1345: getfield u : Lce;
    //   1348: ifnull -> 1373
    //   1351: aload_0
    //   1352: getfield u : Lce;
    //   1355: aload_0
    //   1356: getfield k : I
    //   1359: aload_0
    //   1360: getfield g : I
    //   1363: aload_0
    //   1364: getfield h : I
    //   1367: iconst_0
    //   1368: iconst_3
    //   1369: aload_1
    //   1370: invokevirtual c : (IIIIILbx;)V
    //   1373: aload_0
    //   1374: getfield v : Lce;
    //   1377: ifnull -> 1802
    //   1380: aload_0
    //   1381: getfield v : Lce;
    //   1384: iconst_2
    //   1385: aload_0
    //   1386: getfield k : I
    //   1389: iconst_2
    //   1390: idiv
    //   1391: isub
    //   1392: aload_0
    //   1393: getfield g : I
    //   1396: aload_0
    //   1397: getfield h : I
    //   1400: iconst_0
    //   1401: bipush #33
    //   1403: aload_1
    //   1404: invokevirtual c : (IIIIILbx;)V
    //   1407: return
    //   1408: aload_0
    //   1409: getfield w : Lce;
    //   1412: ifnull -> 1802
    //   1415: aload_0
    //   1416: getfield w : Lce;
    //   1419: aload_0
    //   1420: getfield k : I
    //   1423: bipush #6
    //   1425: isub
    //   1426: aload_0
    //   1427: getfield g : I
    //   1430: aload_0
    //   1431: getfield h : I
    //   1434: bipush #20
    //   1436: isub
    //   1437: iconst_0
    //   1438: iconst_3
    //   1439: aload_1
    //   1440: invokevirtual c : (IIIIILbx;)V
    //   1443: return
    //   1444: aload_0
    //   1445: getfield u : Lce;
    //   1448: ifnull -> 1802
    //   1451: aload_0
    //   1452: getfield u : Lce;
    //   1455: aload_0
    //   1456: getfield k : I
    //   1459: iconst_2
    //   1460: idiv
    //   1461: aload_0
    //   1462: getfield u : Lce;
    //   1465: getfield c : I
    //   1468: irem
    //   1469: aload_0
    //   1470: getfield g : I
    //   1473: aload_0
    //   1474: getfield h : I
    //   1477: iconst_0
    //   1478: iconst_3
    //   1479: aload_1
    //   1480: invokevirtual c : (IIIIILbx;)V
    //   1483: return
    //   1484: aload_0
    //   1485: getfield D : J
    //   1488: invokestatic a : ()J
    //   1491: lsub
    //   1492: lconst_0
    //   1493: lcmp
    //   1494: iflt -> 1802
    //   1497: aload_0
    //   1498: getfield D : J
    //   1501: invokestatic a : ()J
    //   1504: lsub
    //   1505: ldc2_w 1000
    //   1508: ldiv
    //   1509: lstore_3
    //   1510: iconst_0
    //   1511: istore_2
    //   1512: lload_3
    //   1513: ldc2_w 2
    //   1516: lcmp
    //   1517: iflt -> 1525
    //   1520: iconst_2
    //   1521: istore_2
    //   1522: goto -> 1538
    //   1525: lload_3
    //   1526: lconst_1
    //   1527: lcmp
    //   1528: iflt -> 1536
    //   1531: iconst_1
    //   1532: istore_2
    //   1533: goto -> 1538
    //   1536: iconst_0
    //   1537: istore_2
    //   1538: aload_0
    //   1539: getfield u : Lce;
    //   1542: ifnull -> 1802
    //   1545: aload_0
    //   1546: getfield u : Lce;
    //   1549: iload_2
    //   1550: aload_0
    //   1551: getfield g : I
    //   1554: aload_0
    //   1555: getfield h : I
    //   1558: iconst_0
    //   1559: iconst_3
    //   1560: aload_1
    //   1561: invokevirtual c : (IIIIILbx;)V
    //   1564: return
    //   1565: aload_0
    //   1566: getfield F : Ldq;
    //   1569: ifnull -> 1802
    //   1572: aload_0
    //   1573: getfield F : Ldq;
    //   1576: aload_1
    //   1577: invokevirtual a : (Lbx;)V
    //   1580: return
    //   1581: aload_0
    //   1582: getfield u : Lce;
    //   1585: ifnull -> 1802
    //   1588: aload_0
    //   1589: getfield u : Lce;
    //   1592: aload_0
    //   1593: getfield k : I
    //   1596: iconst_2
    //   1597: idiv
    //   1598: aload_0
    //   1599: getfield u : Lce;
    //   1602: getfield c : I
    //   1605: irem
    //   1606: aload_0
    //   1607: getfield g : I
    //   1610: aload_0
    //   1611: getfield h : I
    //   1614: iconst_0
    //   1615: iconst_3
    //   1616: aload_1
    //   1617: invokevirtual c : (IIIIILbx;)V
    //   1620: return
    //   1621: aload_0
    //   1622: getfield k : I
    //   1625: aload_0
    //   1626: getfield f : I
    //   1629: if_icmpgt -> 1802
    //   1632: iconst_0
    //   1633: istore_3
    //   1634: aload_0
    //   1635: getfield k : I
    //   1638: aload_0
    //   1639: getfield f : I
    //   1642: iconst_5
    //   1643: isub
    //   1644: if_icmple -> 1664
    //   1647: aload_0
    //   1648: getfield f : I
    //   1651: iconst_1
    //   1652: isub
    //   1653: aload_0
    //   1654: getfield k : I
    //   1657: isub
    //   1658: iconst_2
    //   1659: idiv
    //   1660: istore_3
    //   1661: goto -> 1666
    //   1664: iconst_2
    //   1665: istore_3
    //   1666: aload_0
    //   1667: getfield u : Lce;
    //   1670: ifnull -> 1802
    //   1673: aload_0
    //   1674: getfield u : Lce;
    //   1677: iload_3
    //   1678: aload_0
    //   1679: getfield g : I
    //   1682: aload_0
    //   1683: getfield h : I
    //   1686: aload_0
    //   1687: getfield C : I
    //   1690: iconst_3
    //   1691: aload_1
    //   1692: invokevirtual c : (IIIIILbx;)V
    //   1695: return
    //   1696: aload_0
    //   1697: getfield u : Lce;
    //   1700: ifnull -> 1802
    //   1703: aload_0
    //   1704: getfield u : Lce;
    //   1707: aload_0
    //   1708: getfield B : [B
    //   1711: aload_0
    //   1712: getfield k : I
    //   1715: baload
    //   1716: aload_0
    //   1717: getfield g : I
    //   1720: aload_0
    //   1721: getfield h : I
    //   1724: aload_0
    //   1725: getfield C : I
    //   1728: iconst_3
    //   1729: aload_1
    //   1730: invokevirtual c : (IIIIILbx;)V
    //   1733: return
    //   1734: pop
    //   1735: new java/lang/StringBuffer
    //   1738: dup
    //   1739: ldc 'err mountdust f:'
    //   1741: invokespecial <init> : (Ljava/lang/String;)V
    //   1744: aload_0
    //   1745: getfield B : [B
    //   1748: arraylength
    //   1749: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1752: ldc '  '
    //   1754: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1757: aload_0
    //   1758: getfield k : I
    //   1761: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1764: invokevirtual toString : ()Ljava/lang/String;
    //   1767: invokestatic a : (Ljava/lang/String;)V
    //   1770: return
    //   1771: return
    //   1772: astore_2
    //   1773: new java/lang/StringBuffer
    //   1776: dup
    //   1777: ldc '/ '
    //   1779: invokespecial <init> : (Ljava/lang/String;)V
    //   1782: aload_0
    //   1783: getfield d : I
    //   1786: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1789: aload_2
    //   1790: invokevirtual toString : ()Ljava/lang/String;
    //   1793: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1796: invokevirtual toString : ()Ljava/lang/String;
    //   1799: invokestatic a : (Ljava/lang/String;)V
    //   1802: return
    // Exception table:
    //   from	to	target	type
    //   0	1771	1772	java/lang/Exception
    //   1696	1733	1734	java/lang/Exception
  }
  
  public final void a() {
    byte b;
    this.k++;
    this.q++;
    switch (this.d) {
      case 0:
      case 1:
      case 2:
      case 4:
      case 5:
      case 6:
      case 7:
      case 10:
      case 11:
      case 12:
      case 13:
      case 19:
      case 24:
      case 25:
      case 26:
      case 28:
      case 34:
      case 35:
      case 40:
      case 44:
      case 46:
      case 51:
      case 54:
      case 57:
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 56:
        if (this.m == 2) {
          this.C = 4;
        } else if (this.m == 3) {
          this.C = 7;
        } 
        if (this.m == 1)
          this.C = 0; 
        if (this.m == 0)
          this.C = 3; 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 3:
        for (b = 0; b < this.a.c(); b++) {
          en en1 = (en)this.a.a(b);
          if (ak.f(3) == 0) {
            en1.a = this.g + ak.g(22);
            en1.b = this.h + ak.g(8);
            en1.n = ak.f(this.u.c);
          } 
        } 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 9:
      case 14:
      case 15:
      case 29:
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).a();
          en1.j++;
          if (this.k == this.f && cn.d(en1.a, en1.b))
            cn.a(19, en1.a, en1.b); 
        } 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 21:
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).a();
          if (en1.j < 0) {
            en1.j++;
          } else {
            en1.j = 0;
            en1.i = 0;
          } 
        } 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 27:
      case 30:
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).n++;
          if (en1.n < en1.o) {
            en1.a += en1.i;
            en1.b += en1.j;
          } 
          en1.j++;
        } 
        if (this.k > this.f) {
          b();
          return;
        } 
        break;
      case 31:
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).n++;
          if (en1.n / 2 >= 4) {
            this.a.d(en1);
            b--;
          } 
        } 
        this.A.d = this.k / 2 % 2;
        if (this.k > 4) {
          if (this.c > 5) {
            this.A.n += 14;
            this.A.j = ak.a(ak.d(this.A.n % 360)) * this.c;
            this.A.i = ak.b(ak.d(this.A.n % 360)) * this.c;
            if (this.k % 2 == 0) {
              this.c--;
              this.A.n += 14;
            } 
            en en1;
            (en1 = new en()).a = (this.A.k + this.A.i) / 1000 + ak.b(-1, 2);
            en1.b = (this.A.l + this.A.j) / 1000 + ak.b(-1, 2);
            this.a.a(en1);
            return;
          } 
          if (this.a.c() == 0) {
            b();
            return;
          } 
        } 
        break;
      case 32:
        if (this.k >= this.f)
          b(); 
        if (this.k < this.f / 2) {
          for (b = 0; b < this.a.c(); b++) {
            en en1 = (en)this.a.a(b);
            if (ak.f(3) == 0)
              if (en1.o == 1) {
                en1.o = 0;
              } else {
                en1.o = 1;
                en1.p = ak.f(4);
              }  
          } 
          return;
        } 
        break;
      case 33:
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).a();
          en1.j++;
        } 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 36:
        if (this.k == 1)
          cn.a(14, this.g, this.h); 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 37:
        if (this.k % 3 == 0 && this.a.c() < this.G && this.k < 50) {
          en en1;
          (en1 = new en()).a = this.g * 1000;
          en1.b = this.h * 1000;
          en1.i = ak.b(ak.d(this.z)) << 2;
          en1.j = ak.a(ak.d(this.z)) << 2;
          en1.k = this.i * 1000;
          en1.l = this.j * 1000;
          this.z += this.H;
          this.a.a(en1);
          if (this.a.c() == this.G)
            this.k = 50; 
        } 
        if (this.k == 80)
          for (b = 0; b < this.a.c(); b++) {
            en en1;
            (en1 = (en)this.a.a(b)).i = (en1.k - en1.a) / 8;
            en1.j = (en1.l - en1.b) / 8;
            en1.n = 100;
          }  
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).a();
          if (en1.n % 3 == 0) {
            en en2;
            (en2 = new en()).a = en1.a / 1000 + ak.b(5, 12);
            en2.b = en1.b / 1000 + ak.b(5, 12);
            this.b.a(en2);
          } 
          if (en1.n == 10) {
            en1.i = 0;
            en1.j = 0;
          } 
          if (en1.n > 108) {
            this.a.d(en1);
            b--;
          } 
        } 
        for (b = 0; b < this.b.c(); b++) {
          en en1;
          (en1 = (en)this.b.a(b)).n++;
          if (en1.n / 2 >= 4) {
            this.b.d(en1);
            b--;
          } 
        } 
        if (this.k > 80 && this.a.c() == 0) {
          c.a(32, this.i, this.j - 11);
          c.a(33, this.i, this.j);
          c.a(34, this.i, this.j);
          b();
          return;
        } 
        break;
      case 38:
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 39:
        if (ak.f(2) == 0)
          cn.a(83, this.g, this.h, 400, (short)-1, (byte)0); 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 41:
        if (this.k == 1) {
          en en1;
          (en1 = new en()).a = this.g * 1000;
          en1.b = this.h * 1000;
          en1.k = this.i * 1000;
          en1.l = this.j * 1000;
          en1.i = 0;
          en1.j = 0;
          this.a.a(en1);
        } 
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).a();
          if (en1.n == 4) {
            en1.i = (en1.k - en1.a) / 12;
            en1.j = (en1.l - en1.b) / 12;
          } 
          if (en1.n % 3 == 0) {
            en en2;
            (en2 = new en()).a = en1.a / 1000 + ak.b(5, 12);
            en2.b = en1.b / 1000 + ak.b(5, 12);
            this.b.a(en2);
          } 
          if (en1.n == 16) {
            en1.i = 0;
            en1.j = 0;
            this.a.d(en1);
            b--;
          } 
        } 
        for (b = 0; b < this.b.c(); b++) {
          en en1;
          (en1 = (en)this.b.a(b)).n++;
          if (en1.n / 2 >= 4) {
            this.b.d(en1);
            b--;
          } 
        } 
        if (this.k >= this.f && this.b.c() == 0 && this.a.c() == 0) {
          b();
          return;
        } 
        break;
      case 42:
        for (b = 0; b < this.a.c(); b++) {
          en en1;
          (en1 = (en)this.a.a(b)).a();
          if (en1.n % 3 == 0) {
            en en2;
            (en2 = new en()).a = en1.a / 1000 + ak.b(5, 12);
            en2.b = en1.b / 1000 + ak.b(5, 12);
            this.b.a(en2);
          } 
          if (en1.n == this.f) {
            en1.i = 0;
            en1.j = 0;
            this.a.d(en1);
            b--;
          } 
        } 
        for (b = 0; b < this.b.c(); b++) {
          en en1;
          (en1 = (en)this.b.a(b)).n++;
          if (en1.n / 2 >= 4) {
            this.b.d(en1);
            b--;
          } 
        } 
        if (this.k >= this.f && this.a.c() == 0 && this.b.c() == 0) {
          b();
          return;
        } 
        break;
      case 43:
        if (this.k == 1)
          cn.a(14, this.g, this.h); 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 45:
        if (this.k == 1) {
          cn.a(9, this.g, this.h + 20);
          cn.a(46, this.g, this.h + 20);
        } 
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 49:
        if (this.F != null)
          this.F.a(); 
        if (this.D - dw.a() < 0L) {
          b();
          cn.a(15, this.g, this.h);
          return;
        } 
        break;
      case 47:
      case 50:
        if (this.D - dw.a() < 0L) {
          b();
          return;
        } 
        break;
      case 48:
        if (this.k >= this.f) {
          b();
          return;
        } 
        break;
      case 55:
        if (this.k < 0)
          this.k = 0; 
        if (this.m == 2) {
          this.C = 0;
        } else if (this.m == 3) {
          this.C = 2;
        } 
        if (this.m == 1)
          this.C = 3; 
        if (this.m == 0)
          this.C = 0; 
        if (this.k > this.B.length - 1) {
          this.k = 0;
          b();
        } 
        break;
    } 
  }
  
  private void b() {
    this.y = true;
    this.x = true;
  }
  
  private void a(int paramInt) {
    if (ft.B)
      this.f = ak.c(16, 25); 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\cx.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */