import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public final class fb extends cg {
  public int a = -1;
  
  public int b = -5;
  
  private int e = -2;
  
  private int f = 0;
  
  public int c = 0;
  
  private bt g = new bt(df.aa, 0, this);
  
  private bt h = new bt(df.ga, 0, this);
  
  public en d;
  
  private ce i;
  
  private String[] j;
  
  private static int[] k = new int[] { -13427660, -16788 };
  
  private boolean l;
  
  public final void b() {
    this.g.a = df.aa;
    this.h.a = df.ga;
  }
  
  public final void a(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 0:
        this.b++;
        g();
        return;
      case 1:
        ft.k();
        this.d = null;
        this.a = -1;
        this.b = 0;
        g();
        c();
        break;
    } 
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null) {
      this.a = 0;
      this.b = -5;
    } 
  }
  
  public final void b(byte[] paramArrayOfbyte) {
    this.d = null;
    if (paramArrayOfbyte == null) {
      this.a = 0;
      this.b = -5;
      return;
    } 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
    try {
      this.a = dataInputStream.readByte();
      this.b = dataInputStream.readByte();
    } catch (Exception exception) {
      this.a = -1;
      this.b = 0;
    } 
    if (ft.a != ft.d)
      g(); 
  }
  
  public final void c() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      dataOutputStream.writeByte(this.a);
      dataOutputStream.writeByte(this.b);
      ak.a((byte)1, byteArrayOutputStream.toByteArray());
      dataOutputStream.close();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void a(byte paramByte1, byte paramByte2) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      dataOutputStream.writeByte(0);
      dataOutputStream.writeByte(0);
      ak.a((byte)1, byteArrayOutputStream.toByteArray());
      dataOutputStream.close();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void f() {
    this.a++;
    this.b = 0;
  }
  
  public final void g() {
    // Byte code:
    //   0: getstatic ft.p : Lcs;
    //   3: getfield d : I
    //   6: ifeq -> 10
    //   9: return
    //   10: getstatic cn.M : Z
    //   13: ifeq -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield g : Lbt;
    //   21: getstatic df.aa : Ljava/lang/String;
    //   24: putfield a : Ljava/lang/String;
    //   27: aload_0
    //   28: bipush #-2
    //   30: putfield e : I
    //   33: aload_0
    //   34: dup
    //   35: astore_1
    //   36: getfield a : I
    //   39: tableswitch default -> 270, 0 -> 92, 1 -> 103, 2 -> 124, 3 -> 145, 4 -> 270, 5 -> 166, 6 -> 186, 7 -> 205, 8 -> 227, 9 -> 249
    //   92: aload_1
    //   93: getfield b : I
    //   96: ifne -> 270
    //   99: iconst_1
    //   100: goto -> 271
    //   103: aload_1
    //   104: getfield b : I
    //   107: iconst_1
    //   108: if_icmpeq -> 120
    //   111: aload_1
    //   112: getfield b : I
    //   115: bipush #9
    //   117: if_icmpne -> 270
    //   120: iconst_1
    //   121: goto -> 271
    //   124: aload_1
    //   125: getfield b : I
    //   128: iconst_4
    //   129: if_icmpeq -> 141
    //   132: aload_1
    //   133: getfield b : I
    //   136: bipush #9
    //   138: if_icmpne -> 270
    //   141: iconst_1
    //   142: goto -> 271
    //   145: aload_1
    //   146: getfield b : I
    //   149: iconst_4
    //   150: if_icmpeq -> 162
    //   153: aload_1
    //   154: getfield b : I
    //   157: bipush #8
    //   159: if_icmpne -> 270
    //   162: iconst_1
    //   163: goto -> 271
    //   166: aload_1
    //   167: getfield b : I
    //   170: ifeq -> 182
    //   173: aload_1
    //   174: getfield b : I
    //   177: bipush #8
    //   179: if_icmpne -> 270
    //   182: iconst_1
    //   183: goto -> 271
    //   186: aload_1
    //   187: getfield b : I
    //   190: iconst_2
    //   191: if_icmpeq -> 201
    //   194: aload_1
    //   195: getfield b : I
    //   198: ifne -> 270
    //   201: iconst_1
    //   202: goto -> 271
    //   205: aload_1
    //   206: getfield b : I
    //   209: bipush #6
    //   211: if_icmpeq -> 223
    //   214: aload_1
    //   215: getfield b : I
    //   218: bipush #9
    //   220: if_icmpne -> 270
    //   223: iconst_1
    //   224: goto -> 271
    //   227: aload_1
    //   228: getfield b : I
    //   231: bipush #7
    //   233: if_icmpeq -> 245
    //   236: aload_1
    //   237: getfield b : I
    //   240: bipush #10
    //   242: if_icmpne -> 270
    //   245: iconst_1
    //   246: goto -> 271
    //   249: aload_1
    //   250: getfield b : I
    //   253: iconst_1
    //   254: if_icmpeq -> 266
    //   257: aload_1
    //   258: getfield b : I
    //   261: bipush #7
    //   263: if_icmpne -> 270
    //   266: iconst_1
    //   267: goto -> 271
    //   270: iconst_0
    //   271: ifeq -> 278
    //   274: aload_0
    //   275: invokevirtual c : ()V
    //   278: getstatic ft.D : Z
    //   281: ifne -> 479
    //   284: getstatic f.a : Z
    //   287: ifne -> 479
    //   290: aload_0
    //   291: getfield a : I
    //   294: ifne -> 319
    //   297: aload_0
    //   298: getfield b : I
    //   301: iconst_1
    //   302: if_icmpne -> 319
    //   305: aload_0
    //   306: iconst_0
    //   307: putfield a : I
    //   310: aload_0
    //   311: iconst_2
    //   312: putfield b : I
    //   315: aload_0
    //   316: invokevirtual c : ()V
    //   319: aload_0
    //   320: getfield a : I
    //   323: iconst_1
    //   324: if_icmpne -> 351
    //   327: aload_0
    //   328: getfield b : I
    //   331: bipush #8
    //   333: if_icmpne -> 351
    //   336: aload_0
    //   337: iconst_1
    //   338: putfield a : I
    //   341: aload_0
    //   342: bipush #9
    //   344: putfield b : I
    //   347: aload_0
    //   348: invokevirtual c : ()V
    //   351: aload_0
    //   352: getfield a : I
    //   355: iconst_2
    //   356: if_icmpne -> 383
    //   359: aload_0
    //   360: getfield b : I
    //   363: bipush #6
    //   365: if_icmpne -> 383
    //   368: aload_0
    //   369: iconst_2
    //   370: putfield a : I
    //   373: aload_0
    //   374: bipush #7
    //   376: putfield b : I
    //   379: aload_0
    //   380: invokevirtual c : ()V
    //   383: aload_0
    //   384: getfield a : I
    //   387: iconst_2
    //   388: if_icmpne -> 415
    //   391: aload_0
    //   392: getfield b : I
    //   395: bipush #11
    //   397: if_icmpne -> 415
    //   400: aload_0
    //   401: iconst_4
    //   402: putfield a : I
    //   405: aload_0
    //   406: bipush #9
    //   408: putfield b : I
    //   411: aload_0
    //   412: invokevirtual c : ()V
    //   415: aload_0
    //   416: getfield a : I
    //   419: bipush #7
    //   421: if_icmpne -> 447
    //   424: aload_0
    //   425: getfield b : I
    //   428: iconst_1
    //   429: if_icmpne -> 447
    //   432: aload_0
    //   433: bipush #8
    //   435: putfield a : I
    //   438: aload_0
    //   439: iconst_0
    //   440: putfield b : I
    //   443: aload_0
    //   444: invokevirtual c : ()V
    //   447: aload_0
    //   448: getfield a : I
    //   451: bipush #6
    //   453: if_icmpne -> 479
    //   456: aload_0
    //   457: getfield b : I
    //   460: iconst_1
    //   461: if_icmpne -> 479
    //   464: aload_0
    //   465: bipush #6
    //   467: putfield a : I
    //   470: aload_0
    //   471: iconst_2
    //   472: putfield b : I
    //   475: aload_0
    //   476: invokevirtual c : ()V
    //   479: getstatic df.gG : [[Ljava/lang/String;
    //   482: astore_1
    //   483: getstatic ft.A : Z
    //   486: ifeq -> 2839
    //   489: aload_0
    //   490: getfield a : I
    //   493: tableswitch default -> 2839, 0 -> 548, 1 -> 657, 2 -> 1029, 3 -> 1283, 4 -> 1792, 5 -> 1959, 6 -> 2590, 7 -> 2766, 8 -> 2807, 9 -> 2819
    //   548: aload_0
    //   549: getfield b : I
    //   552: iconst_2
    //   553: if_icmpne -> 646
    //   556: invokestatic k : ()V
    //   559: aload_0
    //   560: getfield b : I
    //   563: getstatic df.gH : [[Ljava/lang/String;
    //   566: aload_0
    //   567: getfield a : I
    //   570: aaload
    //   571: arraylength
    //   572: if_icmpge -> 645
    //   575: getstatic df.gH : [[Ljava/lang/String;
    //   578: aload_0
    //   579: getfield a : I
    //   582: aaload
    //   583: aload_0
    //   584: getfield b : I
    //   587: aaload
    //   588: invokevirtual length : ()I
    //   591: ifle -> 645
    //   594: new ah
    //   597: dup
    //   598: invokespecial <init> : ()V
    //   601: dup
    //   602: astore_1
    //   603: getstatic df.gH : [[Ljava/lang/String;
    //   606: aload_0
    //   607: getfield a : I
    //   610: aaload
    //   611: aload_0
    //   612: getfield b : I
    //   615: aaload
    //   616: aload_0
    //   617: getfield g : Lbt;
    //   620: getstatic cf.e : I
    //   623: bipush #45
    //   625: isub
    //   626: getstatic cf.f : I
    //   629: getstatic cf.j : I
    //   632: isub
    //   633: iconst_5
    //   634: isub
    //   635: iconst_2
    //   636: bipush #90
    //   638: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   641: aload_1
    //   642: putstatic ft.r : Lda;
    //   645: return
    //   646: aload_0
    //   647: getfield b : I
    //   650: iconst_3
    //   651: if_icmpne -> 2839
    //   654: goto -> 2835
    //   657: aload_0
    //   658: getfield b : I
    //   661: ifne -> 751
    //   664: invokestatic k : ()V
    //   667: aload_0
    //   668: getfield b : I
    //   671: getstatic df.gH : [[Ljava/lang/String;
    //   674: aload_0
    //   675: getfield a : I
    //   678: aaload
    //   679: arraylength
    //   680: if_icmpge -> 750
    //   683: getstatic df.gH : [[Ljava/lang/String;
    //   686: aload_0
    //   687: getfield a : I
    //   690: aaload
    //   691: aload_0
    //   692: getfield b : I
    //   695: aaload
    //   696: invokevirtual length : ()I
    //   699: ifle -> 750
    //   702: new ah
    //   705: dup
    //   706: invokespecial <init> : ()V
    //   709: dup
    //   710: astore_1
    //   711: getstatic df.gH : [[Ljava/lang/String;
    //   714: aload_0
    //   715: getfield a : I
    //   718: aaload
    //   719: aload_0
    //   720: getfield b : I
    //   723: aaload
    //   724: aload_0
    //   725: getfield g : Lbt;
    //   728: getstatic cf.D : I
    //   731: bipush #40
    //   733: isub
    //   734: getstatic cf.E : I
    //   737: bipush #40
    //   739: isub
    //   740: iconst_2
    //   741: bipush #80
    //   743: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   746: aload_1
    //   747: putstatic ft.r : Lda;
    //   750: return
    //   751: aload_0
    //   752: getfield b : I
    //   755: bipush #8
    //   757: if_icmpne -> 852
    //   760: invokestatic k : ()V
    //   763: aload_0
    //   764: getfield b : I
    //   767: getstatic df.gH : [[Ljava/lang/String;
    //   770: aload_0
    //   771: getfield a : I
    //   774: aaload
    //   775: arraylength
    //   776: if_icmpge -> 851
    //   779: getstatic df.gH : [[Ljava/lang/String;
    //   782: aload_0
    //   783: getfield a : I
    //   786: aaload
    //   787: aload_0
    //   788: getfield b : I
    //   791: aaload
    //   792: invokevirtual length : ()I
    //   795: ifle -> 851
    //   798: new ah
    //   801: dup
    //   802: invokespecial <init> : ()V
    //   805: dup
    //   806: astore_1
    //   807: getstatic df.gH : [[Ljava/lang/String;
    //   810: aload_0
    //   811: getfield a : I
    //   814: aaload
    //   815: aload_0
    //   816: getfield b : I
    //   819: aaload
    //   820: aload_0
    //   821: getfield g : Lbt;
    //   824: getstatic cf.B : [[I
    //   827: iconst_0
    //   828: aaload
    //   829: iconst_0
    //   830: iaload
    //   831: getstatic cf.B : [[I
    //   834: iconst_0
    //   835: aaload
    //   836: iconst_1
    //   837: iaload
    //   838: bipush #22
    //   840: iadd
    //   841: iconst_3
    //   842: bipush #90
    //   844: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   847: aload_1
    //   848: putstatic ft.r : Lda;
    //   851: return
    //   852: aload_0
    //   853: getfield b : I
    //   856: bipush #9
    //   858: if_icmpne -> 2839
    //   861: invokestatic k : ()V
    //   864: aload_0
    //   865: getfield b : I
    //   868: getstatic df.gH : [[Ljava/lang/String;
    //   871: aload_0
    //   872: getfield a : I
    //   875: aaload
    //   876: arraylength
    //   877: if_icmpge -> 1028
    //   880: getstatic df.gH : [[Ljava/lang/String;
    //   883: aload_0
    //   884: getfield a : I
    //   887: aaload
    //   888: aload_0
    //   889: getfield b : I
    //   892: aaload
    //   893: invokevirtual length : ()I
    //   896: ifle -> 1028
    //   899: aload_0
    //   900: new en
    //   903: dup
    //   904: invokespecial <init> : ()V
    //   907: putfield d : Len;
    //   910: aload_0
    //   911: getfield d : Len;
    //   914: getstatic cf.B : [[I
    //   917: iconst_0
    //   918: aaload
    //   919: iconst_0
    //   920: iaload
    //   921: putfield a : I
    //   924: aload_0
    //   925: getfield d : Len;
    //   928: bipush #80
    //   930: putfield e : I
    //   933: aload_0
    //   934: getstatic o.i : Lo;
    //   937: getstatic df.gH : [[Ljava/lang/String;
    //   940: aload_0
    //   941: getfield a : I
    //   944: aaload
    //   945: aload_0
    //   946: getfield b : I
    //   949: aaload
    //   950: aload_0
    //   951: getfield d : Len;
    //   954: getfield e : I
    //   957: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   960: putfield j : [Ljava/lang/String;
    //   963: aload_0
    //   964: getfield d : Len;
    //   967: aload_0
    //   968: getfield j : [Ljava/lang/String;
    //   971: arraylength
    //   972: getstatic ft.ab : I
    //   975: imul
    //   976: putfield f : I
    //   979: aload_0
    //   980: getfield d : Len;
    //   983: getstatic cf.B : [[I
    //   986: iconst_0
    //   987: aaload
    //   988: iconst_1
    //   989: iaload
    //   990: bipush #22
    //   992: iadd
    //   993: aload_0
    //   994: getfield d : Len;
    //   997: getfield f : I
    //   1000: iadd
    //   1001: putfield b : I
    //   1004: aload_0
    //   1005: getfield d : Len;
    //   1008: iconst_3
    //   1009: putfield o : I
    //   1012: aload_0
    //   1013: getfield d : Len;
    //   1016: iconst_1
    //   1017: putfield m : I
    //   1020: aload_0
    //   1021: getfield d : Len;
    //   1024: iconst_1
    //   1025: putfield p : I
    //   1028: return
    //   1029: aload_0
    //   1030: getfield b : I
    //   1033: tableswitch default -> 1280, 2 -> 1084, 3 -> 1084, 4 -> 1091, 5 -> 1280, 6 -> 1280, 7 -> 1084, 8 -> 1280, 9 -> 1091, 10 -> 1091
    //   1084: getstatic df.gH : [[Ljava/lang/String;
    //   1087: astore_1
    //   1088: goto -> 2839
    //   1091: invokestatic k : ()V
    //   1094: aload_0
    //   1095: getfield b : I
    //   1098: getstatic df.gH : [[Ljava/lang/String;
    //   1101: aload_0
    //   1102: getfield a : I
    //   1105: aaload
    //   1106: arraylength
    //   1107: if_icmpge -> 1274
    //   1110: getstatic df.gH : [[Ljava/lang/String;
    //   1113: aload_0
    //   1114: getfield a : I
    //   1117: aaload
    //   1118: aload_0
    //   1119: getfield b : I
    //   1122: aaload
    //   1123: invokevirtual length : ()I
    //   1126: ifle -> 1274
    //   1129: aload_0
    //   1130: new en
    //   1133: dup
    //   1134: invokespecial <init> : ()V
    //   1137: putfield d : Len;
    //   1140: aload_0
    //   1141: getfield d : Len;
    //   1144: invokestatic g : ()Lfl;
    //   1147: getfield L : I
    //   1150: getstatic fl.aM : B
    //   1153: iadd
    //   1154: getstatic fl.aN : B
    //   1157: iconst_2
    //   1158: ishl
    //   1159: iadd
    //   1160: putfield a : I
    //   1163: aload_0
    //   1164: getfield d : Len;
    //   1167: bipush #80
    //   1169: putfield e : I
    //   1172: aload_0
    //   1173: getstatic o.i : Lo;
    //   1176: getstatic df.gH : [[Ljava/lang/String;
    //   1179: aload_0
    //   1180: getfield a : I
    //   1183: aaload
    //   1184: aload_0
    //   1185: getfield b : I
    //   1188: aaload
    //   1189: aload_0
    //   1190: getfield d : Len;
    //   1193: getfield e : I
    //   1196: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1199: putfield j : [Ljava/lang/String;
    //   1202: aload_0
    //   1203: getfield d : Len;
    //   1206: aload_0
    //   1207: getfield j : [Ljava/lang/String;
    //   1210: arraylength
    //   1211: getstatic ft.ab : I
    //   1214: imul
    //   1215: putfield f : I
    //   1218: aload_0
    //   1219: getfield d : Len;
    //   1222: invokestatic g : ()Lfl;
    //   1225: pop
    //   1226: iconst_0
    //   1227: getstatic ft.X : I
    //   1230: iconst_5
    //   1231: idiv
    //   1232: iadd
    //   1233: getstatic fl.aM : B
    //   1236: iconst_1
    //   1237: ishl
    //   1238: iadd
    //   1239: aload_0
    //   1240: getfield d : Len;
    //   1243: getfield f : I
    //   1246: iadd
    //   1247: putfield b : I
    //   1250: aload_0
    //   1251: getfield d : Len;
    //   1254: iconst_3
    //   1255: putfield o : I
    //   1258: aload_0
    //   1259: getfield d : Len;
    //   1262: iconst_1
    //   1263: putfield m : I
    //   1266: aload_0
    //   1267: getfield d : Len;
    //   1270: iconst_1
    //   1271: putfield p : I
    //   1274: aload_0
    //   1275: iconst_0
    //   1276: putfield e : I
    //   1279: return
    //   1280: goto -> 2839
    //   1283: aload_0
    //   1284: getfield b : I
    //   1287: tableswitch default -> 1789, 4 -> 1320, 5 -> 1789, 6 -> 1789, 7 -> 1789, 8 -> 1785
    //   1320: getstatic ft.D : Z
    //   1323: ifne -> 1591
    //   1326: getstatic f.a : Z
    //   1329: ifne -> 1591
    //   1332: invokestatic k : ()V
    //   1335: iconst_3
    //   1336: istore_1
    //   1337: iconst_0
    //   1338: istore_2
    //   1339: goto -> 1371
    //   1342: getstatic bw.V : Les;
    //   1345: iload_2
    //   1346: invokevirtual a : (I)Ljava/lang/Object;
    //   1349: checkcast j
    //   1352: dup
    //   1353: astore_3
    //   1354: getfield u : I
    //   1357: iconst_3
    //   1358: if_icmpne -> 1368
    //   1361: iload_2
    //   1362: iconst_1
    //   1363: iadd
    //   1364: istore_1
    //   1365: goto -> 1381
    //   1368: iinc #2, 1
    //   1371: iload_2
    //   1372: getstatic bw.V : Les;
    //   1375: invokevirtual c : ()I
    //   1378: if_icmplt -> 1342
    //   1381: new java/lang/StringBuffer
    //   1384: dup
    //   1385: ldc 'index '
    //   1387: invokespecial <init> : (Ljava/lang/String;)V
    //   1390: iload_1
    //   1391: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   1394: invokevirtual toString : ()Ljava/lang/String;
    //   1397: invokestatic a : (Ljava/lang/String;)V
    //   1400: aload_0
    //   1401: getfield b : I
    //   1404: getstatic df.gH : [[Ljava/lang/String;
    //   1407: aload_0
    //   1408: getfield a : I
    //   1411: aaload
    //   1412: arraylength
    //   1413: if_icmpge -> 1585
    //   1416: getstatic df.gH : [[Ljava/lang/String;
    //   1419: aload_0
    //   1420: getfield a : I
    //   1423: aaload
    //   1424: aload_0
    //   1425: getfield b : I
    //   1428: aaload
    //   1429: invokevirtual length : ()I
    //   1432: ifle -> 1585
    //   1435: aload_0
    //   1436: new en
    //   1439: dup
    //   1440: invokespecial <init> : ()V
    //   1443: putfield d : Len;
    //   1446: aload_0
    //   1447: getfield d : Len;
    //   1450: invokestatic g : ()Lfl;
    //   1453: getfield L : I
    //   1456: getstatic fl.aM : B
    //   1459: iload_1
    //   1460: imul
    //   1461: iadd
    //   1462: bipush #40
    //   1464: isub
    //   1465: getstatic fl.aN : B
    //   1468: iconst_2
    //   1469: ishl
    //   1470: iadd
    //   1471: putfield a : I
    //   1474: aload_0
    //   1475: getfield d : Len;
    //   1478: bipush #80
    //   1480: putfield e : I
    //   1483: aload_0
    //   1484: getstatic o.i : Lo;
    //   1487: getstatic df.gH : [[Ljava/lang/String;
    //   1490: aload_0
    //   1491: getfield a : I
    //   1494: aaload
    //   1495: aload_0
    //   1496: getfield b : I
    //   1499: aaload
    //   1500: aload_0
    //   1501: getfield d : Len;
    //   1504: getfield e : I
    //   1507: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1510: putfield j : [Ljava/lang/String;
    //   1513: aload_0
    //   1514: getfield d : Len;
    //   1517: aload_0
    //   1518: getfield j : [Ljava/lang/String;
    //   1521: arraylength
    //   1522: getstatic ft.ab : I
    //   1525: imul
    //   1526: putfield f : I
    //   1529: aload_0
    //   1530: getfield d : Len;
    //   1533: invokestatic g : ()Lfl;
    //   1536: pop
    //   1537: iconst_0
    //   1538: getstatic ft.X : I
    //   1541: iconst_5
    //   1542: idiv
    //   1543: iadd
    //   1544: getstatic fl.aM : B
    //   1547: iconst_1
    //   1548: ishl
    //   1549: iadd
    //   1550: aload_0
    //   1551: getfield d : Len;
    //   1554: getfield f : I
    //   1557: iadd
    //   1558: putfield b : I
    //   1561: aload_0
    //   1562: getfield d : Len;
    //   1565: iconst_5
    //   1566: putfield o : I
    //   1569: aload_0
    //   1570: getfield d : Len;
    //   1573: iconst_1
    //   1574: putfield m : I
    //   1577: aload_0
    //   1578: getfield d : Len;
    //   1581: iconst_1
    //   1582: putfield p : I
    //   1585: aload_0
    //   1586: iconst_0
    //   1587: putfield e : I
    //   1590: return
    //   1591: invokestatic k : ()V
    //   1594: aload_0
    //   1595: getfield b : I
    //   1598: getstatic df.gH : [[Ljava/lang/String;
    //   1601: aload_0
    //   1602: getfield a : I
    //   1605: aaload
    //   1606: arraylength
    //   1607: if_icmpge -> 1779
    //   1610: getstatic df.gH : [[Ljava/lang/String;
    //   1613: aload_0
    //   1614: getfield a : I
    //   1617: aaload
    //   1618: aload_0
    //   1619: getfield b : I
    //   1622: aaload
    //   1623: invokevirtual length : ()I
    //   1626: ifle -> 1779
    //   1629: aload_0
    //   1630: new en
    //   1633: dup
    //   1634: invokespecial <init> : ()V
    //   1637: putfield d : Len;
    //   1640: aload_0
    //   1641: getfield d : Len;
    //   1644: invokestatic g : ()Lfl;
    //   1647: getfield L : I
    //   1650: getstatic fl.aM : B
    //   1653: iconst_3
    //   1654: imul
    //   1655: iadd
    //   1656: bipush #40
    //   1658: isub
    //   1659: getstatic fl.aN : B
    //   1662: iconst_2
    //   1663: ishl
    //   1664: iadd
    //   1665: putfield a : I
    //   1668: aload_0
    //   1669: getfield d : Len;
    //   1672: bipush #80
    //   1674: putfield e : I
    //   1677: aload_0
    //   1678: getstatic o.i : Lo;
    //   1681: getstatic df.gH : [[Ljava/lang/String;
    //   1684: aload_0
    //   1685: getfield a : I
    //   1688: aaload
    //   1689: aload_0
    //   1690: getfield b : I
    //   1693: aaload
    //   1694: aload_0
    //   1695: getfield d : Len;
    //   1698: getfield e : I
    //   1701: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1704: putfield j : [Ljava/lang/String;
    //   1707: aload_0
    //   1708: getfield d : Len;
    //   1711: aload_0
    //   1712: getfield j : [Ljava/lang/String;
    //   1715: arraylength
    //   1716: getstatic ft.ab : I
    //   1719: imul
    //   1720: putfield f : I
    //   1723: aload_0
    //   1724: getfield d : Len;
    //   1727: invokestatic g : ()Lfl;
    //   1730: pop
    //   1731: iconst_0
    //   1732: getstatic ft.X : I
    //   1735: iconst_5
    //   1736: idiv
    //   1737: iadd
    //   1738: getstatic fl.aM : B
    //   1741: iconst_1
    //   1742: ishl
    //   1743: iadd
    //   1744: aload_0
    //   1745: getfield d : Len;
    //   1748: getfield f : I
    //   1751: iadd
    //   1752: putfield b : I
    //   1755: aload_0
    //   1756: getfield d : Len;
    //   1759: iconst_5
    //   1760: putfield o : I
    //   1763: aload_0
    //   1764: getfield d : Len;
    //   1767: iconst_1
    //   1768: putfield m : I
    //   1771: aload_0
    //   1772: getfield d : Len;
    //   1775: iconst_1
    //   1776: putfield p : I
    //   1779: aload_0
    //   1780: iconst_0
    //   1781: putfield e : I
    //   1784: return
    //   1785: getstatic df.gH : [[Ljava/lang/String;
    //   1788: astore_1
    //   1789: goto -> 2839
    //   1792: aload_0
    //   1793: getfield b : I
    //   1796: bipush #9
    //   1798: if_icmpne -> 2839
    //   1801: invokestatic k : ()V
    //   1804: aload_0
    //   1805: getfield b : I
    //   1808: getstatic df.gH : [[Ljava/lang/String;
    //   1811: aload_0
    //   1812: getfield a : I
    //   1815: aaload
    //   1816: arraylength
    //   1817: if_icmpge -> 1953
    //   1820: getstatic df.gH : [[Ljava/lang/String;
    //   1823: aload_0
    //   1824: getfield a : I
    //   1827: aaload
    //   1828: aload_0
    //   1829: getfield b : I
    //   1832: aaload
    //   1833: invokevirtual length : ()I
    //   1836: ifle -> 1953
    //   1839: aload_0
    //   1840: new en
    //   1843: dup
    //   1844: invokespecial <init> : ()V
    //   1847: putfield d : Len;
    //   1850: aload_0
    //   1851: getfield d : Len;
    //   1854: getstatic eu.g : I
    //   1857: putfield a : I
    //   1860: aload_0
    //   1861: getfield d : Len;
    //   1864: getstatic eu.h : I
    //   1867: getstatic bt.k : I
    //   1870: isub
    //   1871: putfield b : I
    //   1874: aload_0
    //   1875: getfield d : Len;
    //   1878: bipush #80
    //   1880: putfield e : I
    //   1883: aload_0
    //   1884: getstatic o.i : Lo;
    //   1887: getstatic df.gH : [[Ljava/lang/String;
    //   1890: aload_0
    //   1891: getfield a : I
    //   1894: aaload
    //   1895: aload_0
    //   1896: getfield b : I
    //   1899: aaload
    //   1900: aload_0
    //   1901: getfield d : Len;
    //   1904: getfield e : I
    //   1907: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1910: putfield j : [Ljava/lang/String;
    //   1913: aload_0
    //   1914: getfield d : Len;
    //   1917: aload_0
    //   1918: getfield j : [Ljava/lang/String;
    //   1921: arraylength
    //   1922: getstatic ft.ab : I
    //   1925: imul
    //   1926: putfield f : I
    //   1929: aload_0
    //   1930: getfield d : Len;
    //   1933: iconst_0
    //   1934: putfield o : I
    //   1937: aload_0
    //   1938: getfield d : Len;
    //   1941: iconst_1
    //   1942: putfield m : I
    //   1945: aload_0
    //   1946: getfield d : Len;
    //   1949: iconst_1
    //   1950: putfield p : I
    //   1953: aload_0
    //   1954: iconst_m1
    //   1955: putfield e : I
    //   1958: return
    //   1959: aload_0
    //   1960: getfield b : I
    //   1963: tableswitch default -> 2587, 1 -> 2004, 2 -> 2098, 3 -> 2587, 4 -> 2205, 5 -> 2299, 6 -> 2397, 7 -> 2495
    //   2004: invokestatic k : ()V
    //   2007: aload_0
    //   2008: getfield b : I
    //   2011: getstatic df.gH : [[Ljava/lang/String;
    //   2014: aload_0
    //   2015: getfield a : I
    //   2018: aaload
    //   2019: arraylength
    //   2020: if_icmpge -> 2097
    //   2023: getstatic df.gH : [[Ljava/lang/String;
    //   2026: aload_0
    //   2027: getfield a : I
    //   2030: aaload
    //   2031: aload_0
    //   2032: getfield b : I
    //   2035: aaload
    //   2036: invokevirtual length : ()I
    //   2039: ifle -> 2097
    //   2042: new ah
    //   2045: dup
    //   2046: invokespecial <init> : ()V
    //   2049: dup
    //   2050: astore_1
    //   2051: getstatic df.gH : [[Ljava/lang/String;
    //   2054: aload_0
    //   2055: getfield a : I
    //   2058: aaload
    //   2059: aload_0
    //   2060: getfield b : I
    //   2063: aaload
    //   2064: aload_0
    //   2065: getfield g : Lbt;
    //   2068: getstatic ft.W : I
    //   2071: bipush #96
    //   2073: isub
    //   2074: getstatic ft.q : Lex;
    //   2077: getfield b : I
    //   2080: getstatic ex.c : I
    //   2083: imul
    //   2084: bipush #16
    //   2086: iadd
    //   2087: iconst_5
    //   2088: bipush #90
    //   2090: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   2093: aload_1
    //   2094: putstatic ft.r : Lda;
    //   2097: return
    //   2098: invokestatic k : ()V
    //   2101: aload_0
    //   2102: getfield b : I
    //   2105: getstatic df.gH : [[Ljava/lang/String;
    //   2108: aload_0
    //   2109: getfield a : I
    //   2112: aaload
    //   2113: arraylength
    //   2114: if_icmpge -> 2192
    //   2117: getstatic df.gH : [[Ljava/lang/String;
    //   2120: aload_0
    //   2121: getfield a : I
    //   2124: aaload
    //   2125: aload_0
    //   2126: getfield b : I
    //   2129: aaload
    //   2130: invokevirtual length : ()I
    //   2133: ifle -> 2192
    //   2136: new ah
    //   2139: dup
    //   2140: invokespecial <init> : ()V
    //   2143: dup
    //   2144: astore_1
    //   2145: getstatic df.gH : [[Ljava/lang/String;
    //   2148: aload_0
    //   2149: getfield a : I
    //   2152: aaload
    //   2153: aload_0
    //   2154: getfield b : I
    //   2157: aaload
    //   2158: aload_0
    //   2159: getfield g : Lbt;
    //   2162: getstatic ft.W : I
    //   2165: bipush #96
    //   2167: isub
    //   2168: getstatic ft.q : Lex;
    //   2171: getfield b : I
    //   2174: getstatic ex.c : I
    //   2177: imul
    //   2178: bipush #16
    //   2180: iadd
    //   2181: bipush #6
    //   2183: bipush #90
    //   2185: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   2188: aload_1
    //   2189: putstatic ft.r : Lda;
    //   2192: bipush #51
    //   2194: iconst_2
    //   2195: getstatic ft.p : Lcs;
    //   2198: getfield d : I
    //   2201: invokestatic a : (III)V
    //   2204: return
    //   2205: invokestatic k : ()V
    //   2208: aload_0
    //   2209: getfield b : I
    //   2212: getstatic df.gH : [[Ljava/lang/String;
    //   2215: aload_0
    //   2216: getfield a : I
    //   2219: aaload
    //   2220: arraylength
    //   2221: if_icmpge -> 2298
    //   2224: getstatic df.gH : [[Ljava/lang/String;
    //   2227: aload_0
    //   2228: getfield a : I
    //   2231: aaload
    //   2232: aload_0
    //   2233: getfield b : I
    //   2236: aaload
    //   2237: invokevirtual length : ()I
    //   2240: ifle -> 2298
    //   2243: new ah
    //   2246: dup
    //   2247: invokespecial <init> : ()V
    //   2250: dup
    //   2251: astore_1
    //   2252: getstatic df.gH : [[Ljava/lang/String;
    //   2255: aload_0
    //   2256: getfield a : I
    //   2259: aaload
    //   2260: aload_0
    //   2261: getfield b : I
    //   2264: aaload
    //   2265: aload_0
    //   2266: getfield g : Lbt;
    //   2269: getstatic ft.W : I
    //   2272: getstatic ft.q : Lex;
    //   2275: getfield a : I
    //   2278: getstatic ex.c : I
    //   2281: imul
    //   2282: isub
    //   2283: bipush #96
    //   2285: isub
    //   2286: bipush #45
    //   2288: iconst_4
    //   2289: bipush #90
    //   2291: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   2294: aload_1
    //   2295: putstatic ft.r : Lda;
    //   2298: return
    //   2299: invokestatic k : ()V
    //   2302: aload_0
    //   2303: getfield b : I
    //   2306: getstatic df.gH : [[Ljava/lang/String;
    //   2309: aload_0
    //   2310: getfield a : I
    //   2313: aaload
    //   2314: arraylength
    //   2315: if_icmpge -> 2396
    //   2318: getstatic df.gH : [[Ljava/lang/String;
    //   2321: aload_0
    //   2322: getfield a : I
    //   2325: aaload
    //   2326: aload_0
    //   2327: getfield b : I
    //   2330: aaload
    //   2331: invokevirtual length : ()I
    //   2334: ifle -> 2396
    //   2337: new ah
    //   2340: dup
    //   2341: invokespecial <init> : ()V
    //   2344: dup
    //   2345: astore_1
    //   2346: getstatic df.gH : [[Ljava/lang/String;
    //   2349: aload_0
    //   2350: getfield a : I
    //   2353: aaload
    //   2354: aload_0
    //   2355: getfield b : I
    //   2358: aaload
    //   2359: aload_0
    //   2360: getfield g : Lbt;
    //   2363: getstatic cf.B : [[I
    //   2366: iconst_3
    //   2367: aaload
    //   2368: iconst_0
    //   2369: iaload
    //   2370: bipush #96
    //   2372: isub
    //   2373: bipush #25
    //   2375: iadd
    //   2376: getstatic cf.B : [[I
    //   2379: iconst_3
    //   2380: aaload
    //   2381: iconst_1
    //   2382: iaload
    //   2383: bipush #10
    //   2385: isub
    //   2386: iconst_1
    //   2387: bipush #90
    //   2389: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   2392: aload_1
    //   2393: putstatic ft.r : Lda;
    //   2396: return
    //   2397: invokestatic k : ()V
    //   2400: aload_0
    //   2401: getfield b : I
    //   2404: getstatic df.gH : [[Ljava/lang/String;
    //   2407: aload_0
    //   2408: getfield a : I
    //   2411: aaload
    //   2412: arraylength
    //   2413: if_icmpge -> 2494
    //   2416: getstatic df.gH : [[Ljava/lang/String;
    //   2419: aload_0
    //   2420: getfield a : I
    //   2423: aaload
    //   2424: aload_0
    //   2425: getfield b : I
    //   2428: aaload
    //   2429: invokevirtual length : ()I
    //   2432: ifle -> 2494
    //   2435: new ah
    //   2438: dup
    //   2439: invokespecial <init> : ()V
    //   2442: dup
    //   2443: astore_1
    //   2444: getstatic df.gH : [[Ljava/lang/String;
    //   2447: aload_0
    //   2448: getfield a : I
    //   2451: aaload
    //   2452: aload_0
    //   2453: getfield b : I
    //   2456: aaload
    //   2457: aload_0
    //   2458: getfield g : Lbt;
    //   2461: getstatic cf.B : [[I
    //   2464: iconst_2
    //   2465: aaload
    //   2466: iconst_0
    //   2467: iaload
    //   2468: bipush #96
    //   2470: isub
    //   2471: bipush #25
    //   2473: iadd
    //   2474: getstatic cf.B : [[I
    //   2477: iconst_2
    //   2478: aaload
    //   2479: iconst_1
    //   2480: iaload
    //   2481: bipush #10
    //   2483: isub
    //   2484: iconst_1
    //   2485: bipush #90
    //   2487: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   2490: aload_1
    //   2491: putstatic ft.r : Lda;
    //   2494: return
    //   2495: invokestatic k : ()V
    //   2498: aload_0
    //   2499: getfield b : I
    //   2502: getstatic df.gH : [[Ljava/lang/String;
    //   2505: aload_0
    //   2506: getfield a : I
    //   2509: aaload
    //   2510: arraylength
    //   2511: if_icmpge -> 2586
    //   2514: getstatic df.gH : [[Ljava/lang/String;
    //   2517: aload_0
    //   2518: getfield a : I
    //   2521: aaload
    //   2522: aload_0
    //   2523: getfield b : I
    //   2526: aaload
    //   2527: invokevirtual length : ()I
    //   2530: ifle -> 2586
    //   2533: new ah
    //   2536: dup
    //   2537: invokespecial <init> : ()V
    //   2540: dup
    //   2541: astore_1
    //   2542: getstatic df.gH : [[Ljava/lang/String;
    //   2545: aload_0
    //   2546: getfield a : I
    //   2549: aaload
    //   2550: aload_0
    //   2551: getfield b : I
    //   2554: aaload
    //   2555: aload_0
    //   2556: getfield g : Lbt;
    //   2559: getstatic cf.B : [[I
    //   2562: iconst_1
    //   2563: aaload
    //   2564: iconst_0
    //   2565: iaload
    //   2566: getstatic cf.B : [[I
    //   2569: iconst_1
    //   2570: aaload
    //   2571: iconst_1
    //   2572: iaload
    //   2573: bipush #45
    //   2575: iadd
    //   2576: iconst_3
    //   2577: bipush #90
    //   2579: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   2582: aload_1
    //   2583: putstatic ft.r : Lda;
    //   2586: return
    //   2587: goto -> 2839
    //   2590: aload_0
    //   2591: getfield b : I
    //   2594: iconst_2
    //   2595: if_icmpne -> 2839
    //   2598: invokestatic k : ()V
    //   2601: aload_0
    //   2602: getfield b : I
    //   2605: getstatic df.gH : [[Ljava/lang/String;
    //   2608: aload_0
    //   2609: getfield a : I
    //   2612: aaload
    //   2613: arraylength
    //   2614: if_icmpge -> 2765
    //   2617: getstatic df.gH : [[Ljava/lang/String;
    //   2620: aload_0
    //   2621: getfield a : I
    //   2624: aaload
    //   2625: aload_0
    //   2626: getfield b : I
    //   2629: aaload
    //   2630: invokevirtual length : ()I
    //   2633: ifle -> 2765
    //   2636: aload_0
    //   2637: new en
    //   2640: dup
    //   2641: invokespecial <init> : ()V
    //   2644: putfield d : Len;
    //   2647: aload_0
    //   2648: getfield d : Len;
    //   2651: getstatic cf.B : [[I
    //   2654: iconst_0
    //   2655: aaload
    //   2656: iconst_0
    //   2657: iaload
    //   2658: putfield a : I
    //   2661: aload_0
    //   2662: getfield d : Len;
    //   2665: bipush #80
    //   2667: putfield e : I
    //   2670: aload_0
    //   2671: getstatic o.i : Lo;
    //   2674: getstatic df.gH : [[Ljava/lang/String;
    //   2677: aload_0
    //   2678: getfield a : I
    //   2681: aaload
    //   2682: aload_0
    //   2683: getfield b : I
    //   2686: aaload
    //   2687: aload_0
    //   2688: getfield d : Len;
    //   2691: getfield e : I
    //   2694: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   2697: putfield j : [Ljava/lang/String;
    //   2700: aload_0
    //   2701: getfield d : Len;
    //   2704: aload_0
    //   2705: getfield j : [Ljava/lang/String;
    //   2708: arraylength
    //   2709: getstatic ft.ab : I
    //   2712: imul
    //   2713: putfield f : I
    //   2716: aload_0
    //   2717: getfield d : Len;
    //   2720: getstatic cf.B : [[I
    //   2723: iconst_0
    //   2724: aaload
    //   2725: iconst_1
    //   2726: iaload
    //   2727: aload_0
    //   2728: getfield d : Len;
    //   2731: getfield f : I
    //   2734: iadd
    //   2735: bipush #22
    //   2737: iadd
    //   2738: putfield b : I
    //   2741: aload_0
    //   2742: getfield d : Len;
    //   2745: iconst_3
    //   2746: putfield o : I
    //   2749: aload_0
    //   2750: getfield d : Len;
    //   2753: iconst_1
    //   2754: putfield m : I
    //   2757: aload_0
    //   2758: getfield d : Len;
    //   2761: iconst_1
    //   2762: putfield p : I
    //   2765: return
    //   2766: aload_0
    //   2767: getfield b : I
    //   2770: tableswitch default -> 2804, 6 -> 2800, 7 -> 2804, 8 -> 2804, 9 -> 2800
    //   2800: getstatic df.gH : [[Ljava/lang/String;
    //   2803: astore_1
    //   2804: goto -> 2839
    //   2807: aload_0
    //   2808: getfield b : I
    //   2811: bipush #7
    //   2813: if_icmpne -> 2839
    //   2816: goto -> 2835
    //   2819: aload_0
    //   2820: getfield b : I
    //   2823: iconst_1
    //   2824: if_icmpeq -> 2835
    //   2827: aload_0
    //   2828: getfield b : I
    //   2831: iconst_5
    //   2832: if_icmpne -> 2839
    //   2835: getstatic df.gH : [[Ljava/lang/String;
    //   2838: astore_1
    //   2839: aload_0
    //   2840: getfield a : I
    //   2843: tableswitch default -> 7630, 0 -> 2896, 1 -> 2902, 2 -> 3213, 3 -> 4062, 4 -> 4685, 5 -> 5369, 6 -> 6065, 7 -> 6260, 8 -> 7049, 9 -> 7055
    //   2896: aload_0
    //   2897: aload_1
    //   2898: invokespecial a : ([[Ljava/lang/String;)V
    //   2901: return
    //   2902: aload_0
    //   2903: aload_1
    //   2904: astore_0
    //   2905: dup
    //   2906: astore_1
    //   2907: getfield b : I
    //   2910: lookupswitch default -> 3106, 2 -> 2944, 5 -> 2950, 9 -> 2956
    //   2944: invokestatic k : ()V
    //   2947: goto -> 7630
    //   2950: invokestatic k : ()V
    //   2953: goto -> 7630
    //   2956: invokestatic k : ()V
    //   2959: aload_1
    //   2960: getfield b : I
    //   2963: aload_0
    //   2964: aload_1
    //   2965: getfield a : I
    //   2968: aaload
    //   2969: arraylength
    //   2970: if_icmpge -> 3212
    //   2973: aload_0
    //   2974: aload_1
    //   2975: getfield a : I
    //   2978: aaload
    //   2979: aload_1
    //   2980: getfield b : I
    //   2983: aaload
    //   2984: invokevirtual length : ()I
    //   2987: ifle -> 3212
    //   2990: aload_1
    //   2991: new en
    //   2994: dup
    //   2995: invokespecial <init> : ()V
    //   2998: putfield d : Len;
    //   3001: aload_1
    //   3002: getfield d : Len;
    //   3005: iconst_3
    //   3006: putfield a : I
    //   3009: aload_1
    //   3010: getfield d : Len;
    //   3013: getstatic ft.X : I
    //   3016: getstatic ft.aa : I
    //   3019: isub
    //   3020: bipush #14
    //   3022: isub
    //   3023: putfield b : I
    //   3026: aload_1
    //   3027: getfield d : Len;
    //   3030: bipush #80
    //   3032: putfield e : I
    //   3035: aload_1
    //   3036: getstatic o.i : Lo;
    //   3039: aload_0
    //   3040: aload_1
    //   3041: getfield a : I
    //   3044: aaload
    //   3045: aload_1
    //   3046: getfield b : I
    //   3049: aaload
    //   3050: aload_1
    //   3051: getfield d : Len;
    //   3054: getfield e : I
    //   3057: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   3060: putfield j : [Ljava/lang/String;
    //   3063: aload_1
    //   3064: getfield d : Len;
    //   3067: aload_1
    //   3068: getfield j : [Ljava/lang/String;
    //   3071: arraylength
    //   3072: getstatic ft.ab : I
    //   3075: imul
    //   3076: putfield f : I
    //   3079: aload_1
    //   3080: getfield d : Len;
    //   3083: iconst_2
    //   3084: putfield o : I
    //   3087: aload_1
    //   3088: getfield d : Len;
    //   3091: iconst_1
    //   3092: putfield m : I
    //   3095: aload_1
    //   3096: getfield d : Len;
    //   3099: iconst_1
    //   3100: putfield p : I
    //   3103: goto -> 7630
    //   3106: aload_1
    //   3107: getfield b : I
    //   3110: aload_0
    //   3111: aload_1
    //   3112: getfield a : I
    //   3115: aaload
    //   3116: arraylength
    //   3117: if_icmpge -> 3212
    //   3120: aload_0
    //   3121: aload_1
    //   3122: getfield a : I
    //   3125: aaload
    //   3126: aload_1
    //   3127: getfield b : I
    //   3130: aaload
    //   3131: invokevirtual length : ()I
    //   3134: ifle -> 3212
    //   3137: getstatic ft.W : I
    //   3140: bipush #30
    //   3142: isub
    //   3143: dup
    //   3144: istore_2
    //   3145: sipush #200
    //   3148: if_icmple -> 3155
    //   3151: sipush #200
    //   3154: istore_2
    //   3155: getstatic ft.Y : I
    //   3158: iload_2
    //   3159: iconst_2
    //   3160: idiv
    //   3161: isub
    //   3162: istore_3
    //   3163: getstatic ft.X : I
    //   3166: getstatic ft.aa : I
    //   3169: iconst_1
    //   3170: ishl
    //   3171: isub
    //   3172: istore #4
    //   3174: new ah
    //   3177: dup
    //   3178: invokespecial <init> : ()V
    //   3181: dup
    //   3182: astore #5
    //   3184: aload_0
    //   3185: aload_1
    //   3186: getfield a : I
    //   3189: aaload
    //   3190: aload_1
    //   3191: getfield b : I
    //   3194: aaload
    //   3195: aload_1
    //   3196: getfield g : Lbt;
    //   3199: iload_3
    //   3200: iload #4
    //   3202: iconst_m1
    //   3203: iload_2
    //   3204: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   3207: aload #5
    //   3209: putstatic ft.r : Lda;
    //   3212: return
    //   3213: aload_0
    //   3214: aload_1
    //   3215: astore_0
    //   3216: dup
    //   3217: astore_1
    //   3218: getfield b : I
    //   3221: tableswitch default -> 4061, 0 -> 3292, 1 -> 3304, 2 -> 3411, 3 -> 3411, 4 -> 3518, 5 -> 3678, 6 -> 3678, 7 -> 3411, 8 -> 3411, 9 -> 3776, 10 -> 3936, 11 -> 3944, 12 -> 3944, 13 -> 4053
    //   3292: invokestatic k : ()V
    //   3295: aload_1
    //   3296: iconst_0
    //   3297: aload_0
    //   3298: invokespecial a : (I[[Ljava/lang/String;)V
    //   3301: goto -> 7630
    //   3304: invokestatic k : ()V
    //   3307: aload_1
    //   3308: getfield b : I
    //   3311: aload_0
    //   3312: aload_1
    //   3313: getfield a : I
    //   3316: aaload
    //   3317: arraylength
    //   3318: if_icmpge -> 4061
    //   3321: aload_0
    //   3322: aload_1
    //   3323: getfield a : I
    //   3326: aaload
    //   3327: aload_1
    //   3328: getfield b : I
    //   3331: aaload
    //   3332: invokevirtual length : ()I
    //   3335: ifle -> 4061
    //   3338: new ah
    //   3341: dup
    //   3342: invokespecial <init> : ()V
    //   3345: dup
    //   3346: astore_2
    //   3347: aload_0
    //   3348: aload_1
    //   3349: getfield a : I
    //   3352: aaload
    //   3353: aload_1
    //   3354: getfield b : I
    //   3357: aaload
    //   3358: aload_1
    //   3359: getfield g : Lbt;
    //   3362: invokestatic g : ()Lfl;
    //   3365: getfield L : I
    //   3368: getstatic fl.aM : B
    //   3371: iadd
    //   3372: getstatic fl.aN : B
    //   3375: iconst_3
    //   3376: imul
    //   3377: iadd
    //   3378: invokestatic g : ()Lfl;
    //   3381: pop
    //   3382: iconst_0
    //   3383: getstatic ft.X : I
    //   3386: iconst_5
    //   3387: idiv
    //   3388: iadd
    //   3389: getstatic fl.aM : B
    //   3392: iconst_1
    //   3393: ishl
    //   3394: iadd
    //   3395: bipush #22
    //   3397: iadd
    //   3398: iconst_5
    //   3399: bipush #90
    //   3401: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   3404: aload_2
    //   3405: putstatic ft.r : Lda;
    //   3408: goto -> 7630
    //   3411: invokestatic k : ()V
    //   3414: aload_1
    //   3415: getfield b : I
    //   3418: aload_0
    //   3419: aload_1
    //   3420: getfield a : I
    //   3423: aaload
    //   3424: arraylength
    //   3425: if_icmpge -> 4061
    //   3428: aload_0
    //   3429: aload_1
    //   3430: getfield a : I
    //   3433: aaload
    //   3434: aload_1
    //   3435: getfield b : I
    //   3438: aaload
    //   3439: invokevirtual length : ()I
    //   3442: ifle -> 4061
    //   3445: new ah
    //   3448: dup
    //   3449: invokespecial <init> : ()V
    //   3452: dup
    //   3453: astore_2
    //   3454: aload_0
    //   3455: aload_1
    //   3456: getfield a : I
    //   3459: aaload
    //   3460: aload_1
    //   3461: getfield b : I
    //   3464: aaload
    //   3465: aload_1
    //   3466: getfield g : Lbt;
    //   3469: invokestatic g : ()Lfl;
    //   3472: getfield L : I
    //   3475: getstatic fl.aM : B
    //   3478: iadd
    //   3479: getstatic fl.aN : B
    //   3482: iconst_2
    //   3483: ishl
    //   3484: iadd
    //   3485: invokestatic g : ()Lfl;
    //   3488: pop
    //   3489: iconst_0
    //   3490: getstatic ft.X : I
    //   3493: iconst_5
    //   3494: idiv
    //   3495: iadd
    //   3496: getstatic fl.aM : B
    //   3499: iconst_1
    //   3500: ishl
    //   3501: iadd
    //   3502: bipush #22
    //   3504: iadd
    //   3505: iconst_3
    //   3506: bipush #90
    //   3508: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   3511: aload_2
    //   3512: putstatic ft.r : Lda;
    //   3515: goto -> 7630
    //   3518: invokestatic k : ()V
    //   3521: aload_1
    //   3522: getfield b : I
    //   3525: aload_0
    //   3526: aload_1
    //   3527: getfield a : I
    //   3530: aaload
    //   3531: arraylength
    //   3532: if_icmpge -> 3670
    //   3535: aload_0
    //   3536: aload_1
    //   3537: getfield a : I
    //   3540: aaload
    //   3541: aload_1
    //   3542: getfield b : I
    //   3545: aaload
    //   3546: invokevirtual length : ()I
    //   3549: ifle -> 3670
    //   3552: aload_1
    //   3553: new en
    //   3556: dup
    //   3557: invokespecial <init> : ()V
    //   3560: putfield d : Len;
    //   3563: aload_1
    //   3564: getfield d : Len;
    //   3567: getstatic ft.Y : I
    //   3570: bipush #40
    //   3572: isub
    //   3573: putfield a : I
    //   3576: aload_1
    //   3577: getfield d : Len;
    //   3580: getstatic ft.X : I
    //   3583: getstatic ft.aa : I
    //   3586: isub
    //   3587: bipush #14
    //   3589: isub
    //   3590: putfield b : I
    //   3593: aload_1
    //   3594: getfield d : Len;
    //   3597: bipush #80
    //   3599: putfield e : I
    //   3602: aload_1
    //   3603: getstatic o.i : Lo;
    //   3606: aload_0
    //   3607: aload_1
    //   3608: getfield a : I
    //   3611: aaload
    //   3612: aload_1
    //   3613: getfield b : I
    //   3616: aaload
    //   3617: aload_1
    //   3618: getfield d : Len;
    //   3621: getfield e : I
    //   3624: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   3627: putfield j : [Ljava/lang/String;
    //   3630: aload_1
    //   3631: getfield d : Len;
    //   3634: aload_1
    //   3635: getfield j : [Ljava/lang/String;
    //   3638: arraylength
    //   3639: getstatic ft.ab : I
    //   3642: imul
    //   3643: putfield f : I
    //   3646: aload_1
    //   3647: getfield d : Len;
    //   3650: iconst_2
    //   3651: putfield o : I
    //   3654: aload_1
    //   3655: getfield d : Len;
    //   3658: iconst_1
    //   3659: putfield m : I
    //   3662: aload_1
    //   3663: getfield d : Len;
    //   3666: iconst_1
    //   3667: putfield p : I
    //   3670: aload_1
    //   3671: iconst_0
    //   3672: putfield e : I
    //   3675: goto -> 7630
    //   3678: invokestatic k : ()V
    //   3681: aload_1
    //   3682: getfield b : I
    //   3685: aload_0
    //   3686: aload_1
    //   3687: getfield a : I
    //   3690: aaload
    //   3691: arraylength
    //   3692: if_icmpge -> 4061
    //   3695: aload_0
    //   3696: aload_1
    //   3697: getfield a : I
    //   3700: aaload
    //   3701: aload_1
    //   3702: getfield b : I
    //   3705: aaload
    //   3706: invokevirtual length : ()I
    //   3709: ifle -> 4061
    //   3712: new ah
    //   3715: dup
    //   3716: invokespecial <init> : ()V
    //   3719: dup
    //   3720: astore_2
    //   3721: aload_0
    //   3722: aload_1
    //   3723: getfield a : I
    //   3726: aaload
    //   3727: aload_1
    //   3728: getfield b : I
    //   3731: aaload
    //   3732: aload_1
    //   3733: getfield g : Lbt;
    //   3736: getstatic ft.Y : I
    //   3739: bipush #45
    //   3741: isub
    //   3742: invokestatic g : ()Lfl;
    //   3745: pop
    //   3746: iconst_0
    //   3747: getstatic ft.X : I
    //   3750: iconst_5
    //   3751: idiv
    //   3752: iadd
    //   3753: getstatic fl.aM : B
    //   3756: iconst_1
    //   3757: ishl
    //   3758: iadd
    //   3759: bipush #22
    //   3761: iadd
    //   3762: bipush #6
    //   3764: bipush #90
    //   3766: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   3769: aload_2
    //   3770: putstatic ft.r : Lda;
    //   3773: goto -> 7630
    //   3776: invokestatic k : ()V
    //   3779: aload_1
    //   3780: getfield b : I
    //   3783: aload_0
    //   3784: aload_1
    //   3785: getfield a : I
    //   3788: aaload
    //   3789: arraylength
    //   3790: if_icmpge -> 3928
    //   3793: aload_0
    //   3794: aload_1
    //   3795: getfield a : I
    //   3798: aaload
    //   3799: aload_1
    //   3800: getfield b : I
    //   3803: aaload
    //   3804: invokevirtual length : ()I
    //   3807: ifle -> 3928
    //   3810: aload_1
    //   3811: new en
    //   3814: dup
    //   3815: invokespecial <init> : ()V
    //   3818: putfield d : Len;
    //   3821: aload_1
    //   3822: getfield d : Len;
    //   3825: getstatic ft.Y : I
    //   3828: bipush #40
    //   3830: isub
    //   3831: putfield a : I
    //   3834: aload_1
    //   3835: getfield d : Len;
    //   3838: getstatic ft.X : I
    //   3841: getstatic ft.aa : I
    //   3844: isub
    //   3845: bipush #14
    //   3847: isub
    //   3848: putfield b : I
    //   3851: aload_1
    //   3852: getfield d : Len;
    //   3855: bipush #80
    //   3857: putfield e : I
    //   3860: aload_1
    //   3861: getstatic o.i : Lo;
    //   3864: aload_0
    //   3865: aload_1
    //   3866: getfield a : I
    //   3869: aaload
    //   3870: aload_1
    //   3871: getfield b : I
    //   3874: aaload
    //   3875: aload_1
    //   3876: getfield d : Len;
    //   3879: getfield e : I
    //   3882: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   3885: putfield j : [Ljava/lang/String;
    //   3888: aload_1
    //   3889: getfield d : Len;
    //   3892: aload_1
    //   3893: getfield j : [Ljava/lang/String;
    //   3896: arraylength
    //   3897: getstatic ft.ab : I
    //   3900: imul
    //   3901: putfield f : I
    //   3904: aload_1
    //   3905: getfield d : Len;
    //   3908: iconst_2
    //   3909: putfield o : I
    //   3912: aload_1
    //   3913: getfield d : Len;
    //   3916: iconst_1
    //   3917: putfield m : I
    //   3920: aload_1
    //   3921: getfield d : Len;
    //   3924: iconst_1
    //   3925: putfield p : I
    //   3928: aload_1
    //   3929: iconst_0
    //   3930: putfield e : I
    //   3933: goto -> 7630
    //   3936: aload_1
    //   3937: iconst_0
    //   3938: putfield e : I
    //   3941: goto -> 7630
    //   3944: invokestatic k : ()V
    //   3947: aload_1
    //   3948: getfield b : I
    //   3951: aload_0
    //   3952: aload_1
    //   3953: getfield a : I
    //   3956: aaload
    //   3957: arraylength
    //   3958: if_icmpge -> 4061
    //   3961: aload_0
    //   3962: aload_1
    //   3963: getfield a : I
    //   3966: aaload
    //   3967: aload_1
    //   3968: getfield b : I
    //   3971: aaload
    //   3972: invokevirtual length : ()I
    //   3975: ifle -> 4061
    //   3978: new ah
    //   3981: dup
    //   3982: invokespecial <init> : ()V
    //   3985: dup
    //   3986: astore_2
    //   3987: aload_0
    //   3988: aload_1
    //   3989: getfield a : I
    //   3992: aaload
    //   3993: aload_1
    //   3994: getfield b : I
    //   3997: aaload
    //   3998: aload_1
    //   3999: getfield g : Lbt;
    //   4002: invokestatic g : ()Lfl;
    //   4005: getfield L : I
    //   4008: getstatic fl.aM : B
    //   4011: iconst_1
    //   4012: ishl
    //   4013: iadd
    //   4014: getstatic fl.aN : B
    //   4017: iconst_2
    //   4018: ishl
    //   4019: iadd
    //   4020: invokestatic g : ()Lfl;
    //   4023: pop
    //   4024: iconst_0
    //   4025: getstatic ft.X : I
    //   4028: iconst_5
    //   4029: idiv
    //   4030: iadd
    //   4031: getstatic fl.aM : B
    //   4034: iconst_1
    //   4035: ishl
    //   4036: iadd
    //   4037: bipush #22
    //   4039: iadd
    //   4040: iconst_3
    //   4041: bipush #90
    //   4043: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   4046: aload_2
    //   4047: putstatic ft.r : Lda;
    //   4050: goto -> 7630
    //   4053: aload_1
    //   4054: invokevirtual f : ()V
    //   4057: aload_1
    //   4058: invokevirtual g : ()V
    //   4061: return
    //   4062: aload_0
    //   4063: aload_1
    //   4064: astore_0
    //   4065: dup
    //   4066: astore_1
    //   4067: getfield b : I
    //   4070: tableswitch default -> 4684, 0 -> 4120, 1 -> 4120, 2 -> 4120, 3 -> 4120, 4 -> 4232, 5 -> 4392, 6 -> 4392, 7 -> 4487, 8 -> 4499
    //   4120: invokestatic k : ()V
    //   4123: aload_1
    //   4124: getfield b : I
    //   4127: aload_0
    //   4128: aload_1
    //   4129: getfield a : I
    //   4132: aaload
    //   4133: arraylength
    //   4134: if_icmpge -> 4684
    //   4137: aload_0
    //   4138: aload_1
    //   4139: getfield a : I
    //   4142: aaload
    //   4143: aload_1
    //   4144: getfield b : I
    //   4147: aaload
    //   4148: invokevirtual length : ()I
    //   4151: ifle -> 4684
    //   4154: new ah
    //   4157: dup
    //   4158: invokespecial <init> : ()V
    //   4161: dup
    //   4162: astore_2
    //   4163: aload_0
    //   4164: aload_1
    //   4165: getfield a : I
    //   4168: aaload
    //   4169: aload_1
    //   4170: getfield b : I
    //   4173: aaload
    //   4174: aload_1
    //   4175: getfield g : Lbt;
    //   4178: invokestatic g : ()Lfl;
    //   4181: getfield L : I
    //   4184: getstatic fl.aM : B
    //   4187: iconst_3
    //   4188: imul
    //   4189: iadd
    //   4190: bipush #40
    //   4192: isub
    //   4193: getstatic fl.aN : B
    //   4196: iconst_2
    //   4197: ishl
    //   4198: iadd
    //   4199: invokestatic g : ()Lfl;
    //   4202: pop
    //   4203: iconst_0
    //   4204: getstatic ft.X : I
    //   4207: iconst_5
    //   4208: idiv
    //   4209: iadd
    //   4210: getstatic fl.aM : B
    //   4213: iconst_1
    //   4214: ishl
    //   4215: iadd
    //   4216: bipush #22
    //   4218: iadd
    //   4219: iconst_5
    //   4220: bipush #90
    //   4222: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   4225: aload_2
    //   4226: putstatic ft.r : Lda;
    //   4229: goto -> 7630
    //   4232: invokestatic k : ()V
    //   4235: aload_1
    //   4236: getfield b : I
    //   4239: aload_0
    //   4240: aload_1
    //   4241: getfield a : I
    //   4244: aaload
    //   4245: arraylength
    //   4246: if_icmpge -> 4384
    //   4249: aload_0
    //   4250: aload_1
    //   4251: getfield a : I
    //   4254: aaload
    //   4255: aload_1
    //   4256: getfield b : I
    //   4259: aaload
    //   4260: invokevirtual length : ()I
    //   4263: ifle -> 4384
    //   4266: aload_1
    //   4267: new en
    //   4270: dup
    //   4271: invokespecial <init> : ()V
    //   4274: putfield d : Len;
    //   4277: aload_1
    //   4278: getfield d : Len;
    //   4281: getstatic ft.Y : I
    //   4284: bipush #40
    //   4286: isub
    //   4287: putfield a : I
    //   4290: aload_1
    //   4291: getfield d : Len;
    //   4294: getstatic ft.X : I
    //   4297: getstatic ft.aa : I
    //   4300: isub
    //   4301: bipush #14
    //   4303: isub
    //   4304: putfield b : I
    //   4307: aload_1
    //   4308: getfield d : Len;
    //   4311: bipush #80
    //   4313: putfield e : I
    //   4316: aload_1
    //   4317: getstatic o.i : Lo;
    //   4320: aload_0
    //   4321: aload_1
    //   4322: getfield a : I
    //   4325: aaload
    //   4326: aload_1
    //   4327: getfield b : I
    //   4330: aaload
    //   4331: aload_1
    //   4332: getfield d : Len;
    //   4335: getfield e : I
    //   4338: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   4341: putfield j : [Ljava/lang/String;
    //   4344: aload_1
    //   4345: getfield d : Len;
    //   4348: aload_1
    //   4349: getfield j : [Ljava/lang/String;
    //   4352: arraylength
    //   4353: getstatic ft.ab : I
    //   4356: imul
    //   4357: putfield f : I
    //   4360: aload_1
    //   4361: getfield d : Len;
    //   4364: iconst_2
    //   4365: putfield o : I
    //   4368: aload_1
    //   4369: getfield d : Len;
    //   4372: iconst_1
    //   4373: putfield m : I
    //   4376: aload_1
    //   4377: getfield d : Len;
    //   4380: iconst_1
    //   4381: putfield p : I
    //   4384: aload_1
    //   4385: iconst_0
    //   4386: putfield e : I
    //   4389: goto -> 7630
    //   4392: aload_1
    //   4393: getfield b : I
    //   4396: aload_0
    //   4397: aload_1
    //   4398: getfield a : I
    //   4401: aaload
    //   4402: arraylength
    //   4403: if_icmpge -> 4684
    //   4406: aload_0
    //   4407: aload_1
    //   4408: getfield a : I
    //   4411: aaload
    //   4412: aload_1
    //   4413: getfield b : I
    //   4416: aaload
    //   4417: invokevirtual length : ()I
    //   4420: ifle -> 4684
    //   4423: new ah
    //   4426: dup
    //   4427: invokespecial <init> : ()V
    //   4430: dup
    //   4431: astore_2
    //   4432: aload_0
    //   4433: aload_1
    //   4434: getfield a : I
    //   4437: aaload
    //   4438: aload_1
    //   4439: getfield b : I
    //   4442: aaload
    //   4443: aload_1
    //   4444: getfield g : Lbt;
    //   4447: getstatic ft.Y : I
    //   4450: bipush #45
    //   4452: isub
    //   4453: invokestatic g : ()Lfl;
    //   4456: pop
    //   4457: iconst_0
    //   4458: getstatic ft.X : I
    //   4461: iconst_5
    //   4462: idiv
    //   4463: iadd
    //   4464: getstatic fl.aM : B
    //   4467: iconst_1
    //   4468: ishl
    //   4469: iadd
    //   4470: bipush #22
    //   4472: iadd
    //   4473: bipush #6
    //   4475: bipush #90
    //   4477: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   4480: aload_2
    //   4481: putstatic ft.r : Lda;
    //   4484: goto -> 7630
    //   4487: invokestatic k : ()V
    //   4490: aload_1
    //   4491: iconst_1
    //   4492: aload_0
    //   4493: invokespecial a : (I[[Ljava/lang/String;)V
    //   4496: goto -> 7630
    //   4499: invokestatic k : ()V
    //   4502: aload_1
    //   4503: getfield b : I
    //   4506: aload_0
    //   4507: aload_1
    //   4508: getfield a : I
    //   4511: aaload
    //   4512: arraylength
    //   4513: if_icmpge -> 4679
    //   4516: aload_0
    //   4517: aload_1
    //   4518: getfield a : I
    //   4521: aaload
    //   4522: aload_1
    //   4523: getfield b : I
    //   4526: aaload
    //   4527: invokevirtual length : ()I
    //   4530: ifle -> 4679
    //   4533: aload_1
    //   4534: new en
    //   4537: dup
    //   4538: invokespecial <init> : ()V
    //   4541: putfield d : Len;
    //   4544: aload_1
    //   4545: getfield d : Len;
    //   4548: invokestatic g : ()Lfl;
    //   4551: getfield L : I
    //   4554: getstatic fl.aN : B
    //   4557: iadd
    //   4558: getstatic fl.aN : B
    //   4561: iconst_2
    //   4562: idiv
    //   4563: iadd
    //   4564: putfield a : I
    //   4567: aload_1
    //   4568: getfield d : Len;
    //   4571: bipush #80
    //   4573: putfield e : I
    //   4576: aload_1
    //   4577: getstatic o.i : Lo;
    //   4580: aload_0
    //   4581: aload_1
    //   4582: getfield a : I
    //   4585: aaload
    //   4586: aload_1
    //   4587: getfield b : I
    //   4590: aaload
    //   4591: aload_1
    //   4592: getfield d : Len;
    //   4595: getfield e : I
    //   4598: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   4601: putfield j : [Ljava/lang/String;
    //   4604: aload_1
    //   4605: getfield d : Len;
    //   4608: aload_1
    //   4609: getfield j : [Ljava/lang/String;
    //   4612: arraylength
    //   4613: getstatic ft.ab : I
    //   4616: imul
    //   4617: putfield f : I
    //   4620: aload_1
    //   4621: getfield d : Len;
    //   4624: invokestatic g : ()Lfl;
    //   4627: pop
    //   4628: iconst_0
    //   4629: getstatic ft.X : I
    //   4632: iconst_5
    //   4633: idiv
    //   4634: iadd
    //   4635: getstatic fl.aM : B
    //   4638: iconst_1
    //   4639: ishl
    //   4640: iadd
    //   4641: bipush #16
    //   4643: iadd
    //   4644: aload_1
    //   4645: getfield d : Len;
    //   4648: getfield f : I
    //   4651: iadd
    //   4652: putfield b : I
    //   4655: aload_1
    //   4656: getfield d : Len;
    //   4659: iconst_3
    //   4660: putfield o : I
    //   4663: aload_1
    //   4664: getfield d : Len;
    //   4667: iconst_1
    //   4668: putfield m : I
    //   4671: aload_1
    //   4672: getfield d : Len;
    //   4675: iconst_1
    //   4676: putfield p : I
    //   4679: aload_1
    //   4680: iconst_m1
    //   4681: putfield e : I
    //   4684: return
    //   4685: aload_0
    //   4686: aload_1
    //   4687: astore_0
    //   4688: dup
    //   4689: astore_1
    //   4690: getfield b : I
    //   4693: tableswitch default -> 5368, 0 -> 4748, 1 -> 4843, 2 -> 4971, 3 -> 5099, 4 -> 4748, 5 -> 4748, 6 -> 4748, 7 -> 4748, 8 -> 4748, 9 -> 5211
    //   4748: aload_1
    //   4749: getfield b : I
    //   4752: aload_0
    //   4753: aload_1
    //   4754: getfield a : I
    //   4757: aaload
    //   4758: arraylength
    //   4759: if_icmpge -> 5368
    //   4762: aload_0
    //   4763: aload_1
    //   4764: getfield a : I
    //   4767: aaload
    //   4768: aload_1
    //   4769: getfield b : I
    //   4772: aaload
    //   4773: invokevirtual length : ()I
    //   4776: ifle -> 5368
    //   4779: new ah
    //   4782: dup
    //   4783: invokespecial <init> : ()V
    //   4786: dup
    //   4787: astore_2
    //   4788: aload_0
    //   4789: aload_1
    //   4790: getfield a : I
    //   4793: aaload
    //   4794: aload_1
    //   4795: getfield b : I
    //   4798: aaload
    //   4799: aload_1
    //   4800: getfield g : Lbt;
    //   4803: getstatic ft.Y : I
    //   4806: bipush #45
    //   4808: isub
    //   4809: invokestatic g : ()Lfl;
    //   4812: pop
    //   4813: iconst_0
    //   4814: getstatic ft.X : I
    //   4817: iconst_5
    //   4818: idiv
    //   4819: iadd
    //   4820: getstatic fl.aM : B
    //   4823: iconst_1
    //   4824: ishl
    //   4825: iadd
    //   4826: bipush #22
    //   4828: iadd
    //   4829: bipush #6
    //   4831: bipush #90
    //   4833: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   4836: aload_2
    //   4837: putstatic ft.r : Lda;
    //   4840: goto -> 7630
    //   4843: aload_1
    //   4844: getfield b : I
    //   4847: aload_0
    //   4848: aload_1
    //   4849: getfield a : I
    //   4852: aaload
    //   4853: arraylength
    //   4854: if_icmpge -> 5368
    //   4857: aload_0
    //   4858: aload_1
    //   4859: getfield a : I
    //   4862: aaload
    //   4863: aload_1
    //   4864: getfield b : I
    //   4867: aaload
    //   4868: invokevirtual length : ()I
    //   4871: ifle -> 5368
    //   4874: new ah
    //   4877: dup
    //   4878: invokespecial <init> : ()V
    //   4881: dup
    //   4882: astore_2
    //   4883: aload_0
    //   4884: aload_1
    //   4885: getfield a : I
    //   4888: aaload
    //   4889: aload_1
    //   4890: getfield b : I
    //   4893: aaload
    //   4894: aload_1
    //   4895: getfield g : Lbt;
    //   4898: invokestatic g : ()Lfl;
    //   4901: getfield L : I
    //   4904: getstatic fl.aM : B
    //   4907: iadd
    //   4908: getstatic fl.aN : B
    //   4911: iconst_3
    //   4912: imul
    //   4913: iadd
    //   4914: getstatic fl.S : I
    //   4917: iconst_5
    //   4918: idiv
    //   4919: iconst_1
    //   4920: ishl
    //   4921: iadd
    //   4922: getstatic af.b : I
    //   4925: iadd
    //   4926: bipush #16
    //   4928: iadd
    //   4929: invokestatic g : ()Lfl;
    //   4932: pop
    //   4933: iconst_0
    //   4934: getstatic ft.X : I
    //   4937: iconst_5
    //   4938: idiv
    //   4939: iadd
    //   4940: getstatic fl.aM : B
    //   4943: iconst_1
    //   4944: ishl
    //   4945: iadd
    //   4946: getstatic fl.T : I
    //   4949: bipush #12
    //   4951: idiv
    //   4952: iconst_3
    //   4953: ishl
    //   4954: iconst_2
    //   4955: idiv
    //   4956: iadd
    //   4957: bipush #7
    //   4959: bipush #90
    //   4961: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   4964: aload_2
    //   4965: putstatic ft.r : Lda;
    //   4968: goto -> 7630
    //   4971: aload_1
    //   4972: getfield b : I
    //   4975: aload_0
    //   4976: aload_1
    //   4977: getfield a : I
    //   4980: aaload
    //   4981: arraylength
    //   4982: if_icmpge -> 5368
    //   4985: aload_0
    //   4986: aload_1
    //   4987: getfield a : I
    //   4990: aaload
    //   4991: aload_1
    //   4992: getfield b : I
    //   4995: aaload
    //   4996: invokevirtual length : ()I
    //   4999: ifle -> 5368
    //   5002: new ah
    //   5005: dup
    //   5006: invokespecial <init> : ()V
    //   5009: dup
    //   5010: astore_2
    //   5011: aload_0
    //   5012: aload_1
    //   5013: getfield a : I
    //   5016: aaload
    //   5017: aload_1
    //   5018: getfield b : I
    //   5021: aaload
    //   5022: aload_1
    //   5023: getfield g : Lbt;
    //   5026: invokestatic g : ()Lfl;
    //   5029: getfield L : I
    //   5032: getstatic fl.aM : B
    //   5035: iadd
    //   5036: getstatic fl.aN : B
    //   5039: iconst_3
    //   5040: imul
    //   5041: iadd
    //   5042: getstatic fl.S : I
    //   5045: iconst_5
    //   5046: idiv
    //   5047: iconst_1
    //   5048: ishl
    //   5049: iadd
    //   5050: getstatic af.b : I
    //   5053: iadd
    //   5054: bipush #16
    //   5056: isub
    //   5057: invokestatic g : ()Lfl;
    //   5060: pop
    //   5061: iconst_0
    //   5062: getstatic ft.X : I
    //   5065: iconst_5
    //   5066: idiv
    //   5067: iadd
    //   5068: getstatic fl.aM : B
    //   5071: iconst_1
    //   5072: ishl
    //   5073: iadd
    //   5074: getstatic fl.T : I
    //   5077: bipush #12
    //   5079: idiv
    //   5080: iconst_3
    //   5081: ishl
    //   5082: iconst_2
    //   5083: idiv
    //   5084: iadd
    //   5085: bipush #8
    //   5087: bipush #90
    //   5089: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5092: aload_2
    //   5093: putstatic ft.r : Lda;
    //   5096: goto -> 7630
    //   5099: aload_1
    //   5100: getfield b : I
    //   5103: aload_0
    //   5104: aload_1
    //   5105: getfield a : I
    //   5108: aaload
    //   5109: arraylength
    //   5110: if_icmpge -> 5368
    //   5113: aload_0
    //   5114: aload_1
    //   5115: getfield a : I
    //   5118: aaload
    //   5119: aload_1
    //   5120: getfield b : I
    //   5123: aaload
    //   5124: invokevirtual length : ()I
    //   5127: ifle -> 5368
    //   5130: new ah
    //   5133: dup
    //   5134: invokespecial <init> : ()V
    //   5137: dup
    //   5138: astore_2
    //   5139: aload_0
    //   5140: aload_1
    //   5141: getfield a : I
    //   5144: aaload
    //   5145: aload_1
    //   5146: getfield b : I
    //   5149: aaload
    //   5150: aload_1
    //   5151: getfield g : Lbt;
    //   5154: invokestatic g : ()Lfl;
    //   5157: getfield L : I
    //   5160: getstatic fl.S : I
    //   5163: iconst_2
    //   5164: idiv
    //   5165: iadd
    //   5166: invokestatic g : ()Lfl;
    //   5169: pop
    //   5170: iconst_0
    //   5171: getstatic ft.X : I
    //   5174: iconst_5
    //   5175: idiv
    //   5176: iadd
    //   5177: getstatic fl.aM : B
    //   5180: iadd
    //   5181: getstatic fl.T : I
    //   5184: iadd
    //   5185: getstatic fl.aM : B
    //   5188: iconst_1
    //   5189: ishl
    //   5190: isub
    //   5191: getstatic fl.aN : B
    //   5194: isub
    //   5195: bipush #20
    //   5197: isub
    //   5198: iconst_2
    //   5199: bipush #90
    //   5201: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5204: aload_2
    //   5205: putstatic ft.r : Lda;
    //   5208: goto -> 7630
    //   5211: invokestatic k : ()V
    //   5214: aload_1
    //   5215: getfield b : I
    //   5218: aload_0
    //   5219: aload_1
    //   5220: getfield a : I
    //   5223: aaload
    //   5224: arraylength
    //   5225: if_icmpge -> 5363
    //   5228: aload_0
    //   5229: aload_1
    //   5230: getfield a : I
    //   5233: aaload
    //   5234: aload_1
    //   5235: getfield b : I
    //   5238: aaload
    //   5239: invokevirtual length : ()I
    //   5242: ifle -> 5363
    //   5245: aload_1
    //   5246: new en
    //   5249: dup
    //   5250: invokespecial <init> : ()V
    //   5253: putfield d : Len;
    //   5256: aload_1
    //   5257: getfield d : Len;
    //   5260: getstatic ft.W : I
    //   5263: bipush #83
    //   5265: isub
    //   5266: putfield a : I
    //   5269: aload_1
    //   5270: getfield d : Len;
    //   5273: getstatic ft.X : I
    //   5276: getstatic ft.aa : I
    //   5279: isub
    //   5280: bipush #14
    //   5282: isub
    //   5283: putfield b : I
    //   5286: aload_1
    //   5287: getfield d : Len;
    //   5290: bipush #80
    //   5292: putfield e : I
    //   5295: aload_1
    //   5296: getstatic o.i : Lo;
    //   5299: aload_0
    //   5300: aload_1
    //   5301: getfield a : I
    //   5304: aaload
    //   5305: aload_1
    //   5306: getfield b : I
    //   5309: aaload
    //   5310: aload_1
    //   5311: getfield d : Len;
    //   5314: getfield e : I
    //   5317: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   5320: putfield j : [Ljava/lang/String;
    //   5323: aload_1
    //   5324: getfield d : Len;
    //   5327: aload_1
    //   5328: getfield j : [Ljava/lang/String;
    //   5331: arraylength
    //   5332: getstatic ft.ab : I
    //   5335: imul
    //   5336: putfield f : I
    //   5339: aload_1
    //   5340: getfield d : Len;
    //   5343: iconst_2
    //   5344: putfield o : I
    //   5347: aload_1
    //   5348: getfield d : Len;
    //   5351: iconst_1
    //   5352: putfield m : I
    //   5355: aload_1
    //   5356: getfield d : Len;
    //   5359: iconst_1
    //   5360: putfield p : I
    //   5363: aload_1
    //   5364: iconst_m1
    //   5365: putfield e : I
    //   5368: return
    //   5369: aload_0
    //   5370: aload_1
    //   5371: astore_0
    //   5372: dup
    //   5373: astore_1
    //   5374: getfield b : I
    //   5377: tableswitch default -> 6064, 0 -> 5428, 1 -> 5465, 2 -> 5562, 3 -> 5671, 4 -> 5745, 5 -> 5824, 6 -> 5908, 7 -> 5998, 8 -> 6009
    //   5428: getstatic ft.D : Z
    //   5431: ifne -> 5440
    //   5434: getstatic f.a : Z
    //   5437: ifeq -> 6064
    //   5440: invokestatic k : ()V
    //   5443: aload_1
    //   5444: aconst_null
    //   5445: putfield d : Len;
    //   5448: getstatic cn.f : Lbq;
    //   5451: getstatic df.cK : Ljava/lang/String;
    //   5454: putfield cE : Ljava/lang/String;
    //   5457: aload_1
    //   5458: iconst_0
    //   5459: putfield f : I
    //   5462: goto -> 7630
    //   5465: invokestatic k : ()V
    //   5468: aload_1
    //   5469: getfield b : I
    //   5472: aload_0
    //   5473: aload_1
    //   5474: getfield a : I
    //   5477: aaload
    //   5478: arraylength
    //   5479: if_icmpge -> 6064
    //   5482: aload_0
    //   5483: aload_1
    //   5484: getfield a : I
    //   5487: aaload
    //   5488: aload_1
    //   5489: getfield b : I
    //   5492: aaload
    //   5493: invokevirtual length : ()I
    //   5496: ifle -> 6064
    //   5499: new ah
    //   5502: dup
    //   5503: invokespecial <init> : ()V
    //   5506: dup
    //   5507: astore_2
    //   5508: aload_0
    //   5509: aload_1
    //   5510: getfield a : I
    //   5513: aaload
    //   5514: aload_1
    //   5515: getfield b : I
    //   5518: aaload
    //   5519: aload_1
    //   5520: getfield g : Lbt;
    //   5523: getstatic ft.W : I
    //   5526: bipush #96
    //   5528: isub
    //   5529: getstatic ft.X : I
    //   5532: bipush #23
    //   5534: isub
    //   5535: getstatic ft.q : Lex;
    //   5538: getfield b : I
    //   5541: getstatic ex.c : I
    //   5544: imul
    //   5545: isub
    //   5546: bipush #16
    //   5548: isub
    //   5549: iconst_2
    //   5550: bipush #90
    //   5552: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5555: aload_2
    //   5556: putstatic ft.r : Lda;
    //   5559: goto -> 7630
    //   5562: invokestatic k : ()V
    //   5565: aload_1
    //   5566: getfield b : I
    //   5569: aload_0
    //   5570: aload_1
    //   5571: getfield a : I
    //   5574: aaload
    //   5575: arraylength
    //   5576: if_icmpge -> 5656
    //   5579: aload_0
    //   5580: aload_1
    //   5581: getfield a : I
    //   5584: aaload
    //   5585: aload_1
    //   5586: getfield b : I
    //   5589: aaload
    //   5590: invokevirtual length : ()I
    //   5593: ifle -> 5656
    //   5596: new ah
    //   5599: dup
    //   5600: invokespecial <init> : ()V
    //   5603: dup
    //   5604: astore_2
    //   5605: aload_0
    //   5606: aload_1
    //   5607: getfield a : I
    //   5610: aaload
    //   5611: aload_1
    //   5612: getfield b : I
    //   5615: aaload
    //   5616: aload_1
    //   5617: getfield g : Lbt;
    //   5620: getstatic ft.W : I
    //   5623: bipush #96
    //   5625: isub
    //   5626: getstatic ft.X : I
    //   5629: bipush #23
    //   5631: isub
    //   5632: getstatic ft.q : Lex;
    //   5635: getfield b : I
    //   5638: getstatic ex.c : I
    //   5641: imul
    //   5642: isub
    //   5643: bipush #16
    //   5645: isub
    //   5646: iconst_m1
    //   5647: bipush #90
    //   5649: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5652: aload_2
    //   5653: putstatic ft.r : Lda;
    //   5656: bipush #51
    //   5658: iconst_2
    //   5659: getstatic ft.p : Lcs;
    //   5662: getfield d : I
    //   5665: invokestatic a : (III)V
    //   5668: goto -> 7630
    //   5671: invokestatic k : ()V
    //   5674: aload_1
    //   5675: getfield b : I
    //   5678: aload_0
    //   5679: aload_1
    //   5680: getfield a : I
    //   5683: aaload
    //   5684: arraylength
    //   5685: if_icmpge -> 6064
    //   5688: aload_0
    //   5689: aload_1
    //   5690: getfield a : I
    //   5693: aaload
    //   5694: aload_1
    //   5695: getfield b : I
    //   5698: aaload
    //   5699: invokevirtual length : ()I
    //   5702: ifle -> 6064
    //   5705: new ah
    //   5708: dup
    //   5709: invokespecial <init> : ()V
    //   5712: dup
    //   5713: astore_2
    //   5714: aload_0
    //   5715: aload_1
    //   5716: getfield a : I
    //   5719: aaload
    //   5720: aload_1
    //   5721: getfield b : I
    //   5724: aaload
    //   5725: aload_1
    //   5726: getfield g : Lbt;
    //   5729: iconst_3
    //   5730: bipush #60
    //   5732: iconst_5
    //   5733: bipush #90
    //   5735: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5738: aload_2
    //   5739: putstatic ft.r : Lda;
    //   5742: goto -> 7630
    //   5745: invokestatic k : ()V
    //   5748: aload_1
    //   5749: getfield b : I
    //   5752: aload_0
    //   5753: aload_1
    //   5754: getfield a : I
    //   5757: aaload
    //   5758: arraylength
    //   5759: if_icmpge -> 6064
    //   5762: aload_0
    //   5763: aload_1
    //   5764: getfield a : I
    //   5767: aaload
    //   5768: aload_1
    //   5769: getfield b : I
    //   5772: aaload
    //   5773: invokevirtual length : ()I
    //   5776: ifle -> 6064
    //   5779: new ah
    //   5782: dup
    //   5783: invokespecial <init> : ()V
    //   5786: dup
    //   5787: astore_2
    //   5788: aload_0
    //   5789: aload_1
    //   5790: getfield a : I
    //   5793: aaload
    //   5794: aload_1
    //   5795: getfield b : I
    //   5798: aaload
    //   5799: aload_1
    //   5800: getfield g : Lbt;
    //   5803: getstatic ft.W : I
    //   5806: bipush #93
    //   5808: isub
    //   5809: bipush #45
    //   5811: iconst_5
    //   5812: bipush #90
    //   5814: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5817: aload_2
    //   5818: putstatic ft.r : Lda;
    //   5821: goto -> 7630
    //   5824: invokestatic k : ()V
    //   5827: aload_1
    //   5828: getfield b : I
    //   5831: aload_0
    //   5832: aload_1
    //   5833: getfield a : I
    //   5836: aaload
    //   5837: arraylength
    //   5838: if_icmpge -> 6064
    //   5841: aload_0
    //   5842: aload_1
    //   5843: getfield a : I
    //   5846: aaload
    //   5847: aload_1
    //   5848: getfield b : I
    //   5851: aaload
    //   5852: invokevirtual length : ()I
    //   5855: ifle -> 6064
    //   5858: new ah
    //   5861: dup
    //   5862: invokespecial <init> : ()V
    //   5865: dup
    //   5866: astore_2
    //   5867: aload_0
    //   5868: aload_1
    //   5869: getfield a : I
    //   5872: aaload
    //   5873: aload_1
    //   5874: getfield b : I
    //   5877: aaload
    //   5878: aload_1
    //   5879: getfield g : Lbt;
    //   5882: getstatic ft.W : I
    //   5885: bipush #93
    //   5887: isub
    //   5888: getstatic ft.X : I
    //   5891: getstatic ft.aa : I
    //   5894: isub
    //   5895: iconst_2
    //   5896: bipush #90
    //   5898: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5901: aload_2
    //   5902: putstatic ft.r : Lda;
    //   5905: goto -> 7630
    //   5908: invokestatic k : ()V
    //   5911: aload_1
    //   5912: getfield b : I
    //   5915: aload_0
    //   5916: aload_1
    //   5917: getfield a : I
    //   5920: aaload
    //   5921: arraylength
    //   5922: if_icmpge -> 6064
    //   5925: aload_0
    //   5926: aload_1
    //   5927: getfield a : I
    //   5930: aaload
    //   5931: aload_1
    //   5932: getfield b : I
    //   5935: aaload
    //   5936: invokevirtual length : ()I
    //   5939: ifle -> 6064
    //   5942: new ah
    //   5945: dup
    //   5946: invokespecial <init> : ()V
    //   5949: dup
    //   5950: astore_2
    //   5951: aload_0
    //   5952: aload_1
    //   5953: getfield a : I
    //   5956: aaload
    //   5957: aload_1
    //   5958: getfield b : I
    //   5961: aaload
    //   5962: aload_1
    //   5963: getfield g : Lbt;
    //   5966: getstatic ft.Y : I
    //   5969: bipush #45
    //   5971: isub
    //   5972: getstatic ft.X : I
    //   5975: getstatic ft.aa : I
    //   5978: isub
    //   5979: bipush #14
    //   5981: isub
    //   5982: bipush #25
    //   5984: isub
    //   5985: iconst_2
    //   5986: bipush #90
    //   5988: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   5991: aload_2
    //   5992: putstatic ft.r : Lda;
    //   5995: goto -> 7630
    //   5998: invokestatic k : ()V
    //   6001: aload_1
    //   6002: aload_0
    //   6003: invokespecial c : ([[Ljava/lang/String;)V
    //   6006: goto -> 7630
    //   6009: getstatic ft.D : Z
    //   6012: ifne -> 6061
    //   6015: getstatic f.a : Z
    //   6018: ifne -> 6061
    //   6021: aload_1
    //   6022: getfield l : Z
    //   6025: ifne -> 6064
    //   6028: invokestatic k : ()V
    //   6031: aload_1
    //   6032: aconst_null
    //   6033: putfield d : Len;
    //   6036: getstatic cn.f : Lbq;
    //   6039: getstatic df.cK : Ljava/lang/String;
    //   6042: putfield cE : Ljava/lang/String;
    //   6045: aload_1
    //   6046: iconst_0
    //   6047: putfield f : I
    //   6050: invokestatic k : ()V
    //   6053: aload_1
    //   6054: iconst_1
    //   6055: putfield l : Z
    //   6058: goto -> 7630
    //   6061: invokestatic k : ()V
    //   6064: return
    //   6065: aload_0
    //   6066: aload_1
    //   6067: astore_0
    //   6068: dup
    //   6069: astore_1
    //   6070: getfield b : I
    //   6073: tableswitch default -> 6259, 0 -> 6100, 1 -> 6100, 2 -> 6108
    //   6100: aload_1
    //   6101: aload_0
    //   6102: invokespecial c : ([[Ljava/lang/String;)V
    //   6105: goto -> 7630
    //   6108: invokestatic k : ()V
    //   6111: aload_1
    //   6112: aload_0
    //   6113: astore_3
    //   6114: dup
    //   6115: astore_2
    //   6116: getfield b : I
    //   6119: aload_3
    //   6120: aload_2
    //   6121: getfield a : I
    //   6124: aaload
    //   6125: arraylength
    //   6126: if_icmpge -> 6259
    //   6129: aload_3
    //   6130: aload_2
    //   6131: getfield a : I
    //   6134: aaload
    //   6135: aload_2
    //   6136: getfield b : I
    //   6139: aaload
    //   6140: invokevirtual length : ()I
    //   6143: ifle -> 6259
    //   6146: aload_2
    //   6147: new en
    //   6150: dup
    //   6151: invokespecial <init> : ()V
    //   6154: putfield d : Len;
    //   6157: aload_2
    //   6158: getfield d : Len;
    //   6161: iconst_3
    //   6162: putfield a : I
    //   6165: aload_2
    //   6166: getfield d : Len;
    //   6169: getstatic ft.X : I
    //   6172: getstatic ft.aa : I
    //   6175: isub
    //   6176: bipush #14
    //   6178: isub
    //   6179: putfield b : I
    //   6182: aload_2
    //   6183: getfield d : Len;
    //   6186: bipush #80
    //   6188: putfield e : I
    //   6191: aload_2
    //   6192: getstatic o.i : Lo;
    //   6195: aload_3
    //   6196: aload_2
    //   6197: getfield a : I
    //   6200: aaload
    //   6201: aload_2
    //   6202: getfield b : I
    //   6205: aaload
    //   6206: aload_2
    //   6207: getfield d : Len;
    //   6210: getfield e : I
    //   6213: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   6216: putfield j : [Ljava/lang/String;
    //   6219: aload_2
    //   6220: getfield d : Len;
    //   6223: aload_2
    //   6224: getfield j : [Ljava/lang/String;
    //   6227: arraylength
    //   6228: getstatic ft.ab : I
    //   6231: imul
    //   6232: putfield f : I
    //   6235: aload_2
    //   6236: getfield d : Len;
    //   6239: iconst_2
    //   6240: putfield o : I
    //   6243: aload_2
    //   6244: getfield d : Len;
    //   6247: iconst_1
    //   6248: putfield m : I
    //   6251: aload_2
    //   6252: getfield d : Len;
    //   6255: iconst_1
    //   6256: putfield p : I
    //   6259: return
    //   6260: aload_0
    //   6261: aload_1
    //   6262: astore_0
    //   6263: dup
    //   6264: astore_1
    //   6265: getfield b : I
    //   6268: tableswitch default -> 7048, 0 -> 6324, 1 -> 6336, 2 -> 6336, 3 -> 6336, 4 -> 6454, 5 -> 6569, 6 -> 6667, 7 -> 6569, 8 -> 6569, 9 -> 6859
    //   6324: invokestatic k : ()V
    //   6327: aload_1
    //   6328: iconst_2
    //   6329: aload_0
    //   6330: invokespecial a : (I[[Ljava/lang/String;)V
    //   6333: goto -> 7630
    //   6336: invokestatic k : ()V
    //   6339: aload_1
    //   6340: getfield b : I
    //   6343: aload_0
    //   6344: aload_1
    //   6345: getfield a : I
    //   6348: aaload
    //   6349: arraylength
    //   6350: if_icmpge -> 7048
    //   6353: aload_0
    //   6354: aload_1
    //   6355: getfield a : I
    //   6358: aaload
    //   6359: aload_1
    //   6360: getfield b : I
    //   6363: aaload
    //   6364: invokevirtual length : ()I
    //   6367: ifle -> 7048
    //   6370: new ah
    //   6373: dup
    //   6374: invokespecial <init> : ()V
    //   6377: astore_2
    //   6378: bipush #20
    //   6380: istore_3
    //   6381: getstatic ft.A : Z
    //   6384: ifeq -> 6390
    //   6387: bipush #24
    //   6389: istore_3
    //   6390: aload_2
    //   6391: aload_0
    //   6392: aload_1
    //   6393: getfield a : I
    //   6396: aaload
    //   6397: aload_1
    //   6398: getfield b : I
    //   6401: aaload
    //   6402: aload_1
    //   6403: getfield g : Lbt;
    //   6406: invokestatic g : ()Lfl;
    //   6409: getfield L : I
    //   6412: getstatic fl.S : I
    //   6415: iconst_2
    //   6416: idiv
    //   6417: iadd
    //   6418: iload_3
    //   6419: getstatic df.go : [Ljava/lang/String;
    //   6422: arraylength
    //   6423: imul
    //   6424: invokestatic g : ()Lfl;
    //   6427: pop
    //   6428: getstatic ft.X : I
    //   6431: iconst_5
    //   6432: idiv
    //   6433: iadd
    //   6434: getstatic fl.aM : B
    //   6437: iadd
    //   6438: bipush #20
    //   6440: iadd
    //   6441: iconst_5
    //   6442: bipush #90
    //   6444: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   6447: aload_2
    //   6448: putstatic ft.r : Lda;
    //   6451: goto -> 7630
    //   6454: invokestatic k : ()V
    //   6457: aload_1
    //   6458: getfield b : I
    //   6461: aload_0
    //   6462: aload_1
    //   6463: getfield a : I
    //   6466: aaload
    //   6467: arraylength
    //   6468: if_icmpge -> 7048
    //   6471: aload_0
    //   6472: aload_1
    //   6473: getfield a : I
    //   6476: aaload
    //   6477: aload_1
    //   6478: getfield b : I
    //   6481: aaload
    //   6482: invokevirtual length : ()I
    //   6485: ifle -> 7048
    //   6488: new ah
    //   6491: dup
    //   6492: invokespecial <init> : ()V
    //   6495: astore_2
    //   6496: bipush #20
    //   6498: istore_3
    //   6499: getstatic ft.A : Z
    //   6502: ifeq -> 6508
    //   6505: bipush #24
    //   6507: istore_3
    //   6508: aload_2
    //   6509: aload_0
    //   6510: aload_1
    //   6511: getfield a : I
    //   6514: aaload
    //   6515: aload_1
    //   6516: getfield b : I
    //   6519: aaload
    //   6520: aload_1
    //   6521: getfield g : Lbt;
    //   6524: invokestatic g : ()Lfl;
    //   6527: getfield L : I
    //   6530: getstatic fl.S : I
    //   6533: iconst_2
    //   6534: idiv
    //   6535: iadd
    //   6536: iload_3
    //   6537: getstatic df.go : [Ljava/lang/String;
    //   6540: arraylength
    //   6541: imul
    //   6542: invokestatic g : ()Lfl;
    //   6545: pop
    //   6546: getstatic ft.X : I
    //   6549: iconst_5
    //   6550: idiv
    //   6551: iadd
    //   6552: getstatic fl.aM : B
    //   6555: iadd
    //   6556: iconst_2
    //   6557: bipush #90
    //   6559: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   6562: aload_2
    //   6563: putstatic ft.r : Lda;
    //   6566: goto -> 7630
    //   6569: invokestatic k : ()V
    //   6572: aload_1
    //   6573: getfield b : I
    //   6576: aload_0
    //   6577: aload_1
    //   6578: getfield a : I
    //   6581: aaload
    //   6582: arraylength
    //   6583: if_icmpge -> 7048
    //   6586: aload_0
    //   6587: aload_1
    //   6588: getfield a : I
    //   6591: aaload
    //   6592: aload_1
    //   6593: getfield b : I
    //   6596: aaload
    //   6597: invokevirtual length : ()I
    //   6600: ifle -> 7048
    //   6603: new ah
    //   6606: dup
    //   6607: invokespecial <init> : ()V
    //   6610: dup
    //   6611: astore_2
    //   6612: aload_0
    //   6613: aload_1
    //   6614: getfield a : I
    //   6617: aaload
    //   6618: aload_1
    //   6619: getfield b : I
    //   6622: aaload
    //   6623: aload_1
    //   6624: getfield g : Lbt;
    //   6627: getstatic ft.Y : I
    //   6630: bipush #45
    //   6632: isub
    //   6633: invokestatic g : ()Lfl;
    //   6636: pop
    //   6637: iconst_0
    //   6638: getstatic ft.X : I
    //   6641: iconst_5
    //   6642: idiv
    //   6643: iadd
    //   6644: getstatic fl.aM : B
    //   6647: iconst_1
    //   6648: ishl
    //   6649: iadd
    //   6650: bipush #22
    //   6652: iadd
    //   6653: bipush #6
    //   6655: bipush #90
    //   6657: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   6660: aload_2
    //   6661: putstatic ft.r : Lda;
    //   6664: goto -> 7630
    //   6667: invokestatic k : ()V
    //   6670: aload_1
    //   6671: getfield b : I
    //   6674: aload_0
    //   6675: aload_1
    //   6676: getfield a : I
    //   6679: aaload
    //   6680: arraylength
    //   6681: if_icmpge -> 6851
    //   6684: aload_0
    //   6685: aload_1
    //   6686: getfield a : I
    //   6689: aaload
    //   6690: aload_1
    //   6691: getfield b : I
    //   6694: aaload
    //   6695: invokevirtual length : ()I
    //   6698: ifle -> 6851
    //   6701: invokestatic g : ()Lfl;
    //   6704: getfield L : I
    //   6707: getstatic fl.S : I
    //   6710: iconst_4
    //   6711: idiv
    //   6712: iadd
    //   6713: bipush #30
    //   6715: iadd
    //   6716: istore_2
    //   6717: invokestatic g : ()Lfl;
    //   6720: pop
    //   6721: iconst_0
    //   6722: getstatic ft.ab : I
    //   6725: iadd
    //   6726: getstatic ft.X : I
    //   6729: iconst_5
    //   6730: idiv
    //   6731: iadd
    //   6732: iconst_4
    //   6733: iadd
    //   6734: getstatic ft.A : Z
    //   6737: ifeq -> 6744
    //   6740: iconst_4
    //   6741: goto -> 6745
    //   6744: iconst_0
    //   6745: iadd
    //   6746: istore_3
    //   6747: aload_1
    //   6748: new en
    //   6751: dup
    //   6752: invokespecial <init> : ()V
    //   6755: putfield d : Len;
    //   6758: aload_1
    //   6759: getfield d : Len;
    //   6762: iload_2
    //   6763: putfield a : I
    //   6766: aload_1
    //   6767: getfield d : Len;
    //   6770: bipush #80
    //   6772: putfield e : I
    //   6775: aload_1
    //   6776: getstatic o.i : Lo;
    //   6779: aload_0
    //   6780: aload_1
    //   6781: getfield a : I
    //   6784: aaload
    //   6785: aload_1
    //   6786: getfield b : I
    //   6789: aaload
    //   6790: aload_1
    //   6791: getfield d : Len;
    //   6794: getfield e : I
    //   6797: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   6800: putfield j : [Ljava/lang/String;
    //   6803: aload_1
    //   6804: getfield d : Len;
    //   6807: aload_1
    //   6808: getfield j : [Ljava/lang/String;
    //   6811: arraylength
    //   6812: getstatic ft.ab : I
    //   6815: imul
    //   6816: putfield f : I
    //   6819: aload_1
    //   6820: getfield d : Len;
    //   6823: iload_3
    //   6824: putfield b : I
    //   6827: aload_1
    //   6828: getfield d : Len;
    //   6831: iconst_2
    //   6832: putfield o : I
    //   6835: aload_1
    //   6836: getfield d : Len;
    //   6839: iconst_1
    //   6840: putfield m : I
    //   6843: aload_1
    //   6844: getfield d : Len;
    //   6847: iconst_1
    //   6848: putfield p : I
    //   6851: aload_1
    //   6852: iconst_2
    //   6853: putfield e : I
    //   6856: goto -> 7630
    //   6859: invokestatic k : ()V
    //   6862: aload_1
    //   6863: getfield b : I
    //   6866: aload_0
    //   6867: aload_1
    //   6868: getfield a : I
    //   6871: aaload
    //   6872: arraylength
    //   6873: if_icmpge -> 7043
    //   6876: aload_0
    //   6877: aload_1
    //   6878: getfield a : I
    //   6881: aaload
    //   6882: aload_1
    //   6883: getfield b : I
    //   6886: aaload
    //   6887: invokevirtual length : ()I
    //   6890: ifle -> 7043
    //   6893: aload_1
    //   6894: new en
    //   6897: dup
    //   6898: invokespecial <init> : ()V
    //   6901: putfield d : Len;
    //   6904: aload_1
    //   6905: getfield d : Len;
    //   6908: invokestatic g : ()Lfl;
    //   6911: getfield L : I
    //   6914: getstatic fl.aN : B
    //   6917: iadd
    //   6918: getstatic fl.aN : B
    //   6921: iconst_2
    //   6922: idiv
    //   6923: iadd
    //   6924: putfield a : I
    //   6927: aload_1
    //   6928: getfield d : Len;
    //   6931: bipush #80
    //   6933: putfield e : I
    //   6936: aload_1
    //   6937: getstatic o.i : Lo;
    //   6940: aload_0
    //   6941: aload_1
    //   6942: getfield a : I
    //   6945: aaload
    //   6946: aload_1
    //   6947: getfield b : I
    //   6950: aaload
    //   6951: aload_1
    //   6952: getfield d : Len;
    //   6955: getfield e : I
    //   6958: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   6961: putfield j : [Ljava/lang/String;
    //   6964: aload_1
    //   6965: getfield d : Len;
    //   6968: aload_1
    //   6969: getfield j : [Ljava/lang/String;
    //   6972: arraylength
    //   6973: getstatic ft.ab : I
    //   6976: imul
    //   6977: putfield f : I
    //   6980: aload_1
    //   6981: getfield d : Len;
    //   6984: invokestatic g : ()Lfl;
    //   6987: pop
    //   6988: iconst_0
    //   6989: getstatic ft.X : I
    //   6992: iconst_5
    //   6993: idiv
    //   6994: iadd
    //   6995: getstatic fl.aM : B
    //   6998: iadd
    //   6999: getstatic fl.aM : B
    //   7002: iconst_3
    //   7003: imul
    //   7004: iadd
    //   7005: bipush #16
    //   7007: iadd
    //   7008: aload_1
    //   7009: getfield d : Len;
    //   7012: getfield f : I
    //   7015: iadd
    //   7016: putfield b : I
    //   7019: aload_1
    //   7020: getfield d : Len;
    //   7023: iconst_3
    //   7024: putfield o : I
    //   7027: aload_1
    //   7028: getfield d : Len;
    //   7031: iconst_1
    //   7032: putfield m : I
    //   7035: aload_1
    //   7036: getfield d : Len;
    //   7039: iconst_1
    //   7040: putfield p : I
    //   7043: aload_1
    //   7044: iconst_m1
    //   7045: putfield e : I
    //   7048: return
    //   7049: aload_0
    //   7050: aload_1
    //   7051: invokespecial b : ([[Ljava/lang/String;)V
    //   7054: return
    //   7055: aload_0
    //   7056: aload_1
    //   7057: astore_0
    //   7058: dup
    //   7059: astore_1
    //   7060: getfield b : I
    //   7063: tableswitch default -> 7630, 0 -> 7108, 1 -> 7117, 2 -> 7303, 3 -> 7399, 4 -> 7505, 5 -> 7303, 6 -> 7303, 7 -> 7613
    //   7108: invokestatic k : ()V
    //   7111: aload_1
    //   7112: aload_0
    //   7113: invokespecial c : ([[Ljava/lang/String;)V
    //   7116: return
    //   7117: invokestatic k : ()V
    //   7120: aload_1
    //   7121: getfield b : I
    //   7124: aload_0
    //   7125: aload_1
    //   7126: getfield a : I
    //   7129: aaload
    //   7130: arraylength
    //   7131: if_icmpge -> 7297
    //   7134: aload_0
    //   7135: aload_1
    //   7136: getfield a : I
    //   7139: aaload
    //   7140: aload_1
    //   7141: getfield b : I
    //   7144: aaload
    //   7145: invokevirtual length : ()I
    //   7148: ifle -> 7297
    //   7151: aload_1
    //   7152: new en
    //   7155: dup
    //   7156: invokespecial <init> : ()V
    //   7159: putfield d : Len;
    //   7162: aload_1
    //   7163: getfield d : Len;
    //   7166: invokestatic g : ()Lfl;
    //   7169: getfield L : I
    //   7172: getstatic fl.aN : B
    //   7175: iadd
    //   7176: getstatic fl.aN : B
    //   7179: iconst_2
    //   7180: idiv
    //   7181: iadd
    //   7182: putfield a : I
    //   7185: aload_1
    //   7186: getfield d : Len;
    //   7189: bipush #80
    //   7191: putfield e : I
    //   7194: aload_1
    //   7195: getstatic o.i : Lo;
    //   7198: aload_0
    //   7199: aload_1
    //   7200: getfield a : I
    //   7203: aaload
    //   7204: aload_1
    //   7205: getfield b : I
    //   7208: aaload
    //   7209: aload_1
    //   7210: getfield d : Len;
    //   7213: getfield e : I
    //   7216: invokevirtual a : (Ljava/lang/String;I)[Ljava/lang/String;
    //   7219: putfield j : [Ljava/lang/String;
    //   7222: aload_1
    //   7223: getfield d : Len;
    //   7226: aload_1
    //   7227: getfield j : [Ljava/lang/String;
    //   7230: arraylength
    //   7231: getstatic ft.ab : I
    //   7234: imul
    //   7235: putfield f : I
    //   7238: aload_1
    //   7239: getfield d : Len;
    //   7242: invokestatic g : ()Lfl;
    //   7245: pop
    //   7246: iconst_0
    //   7247: getstatic ft.X : I
    //   7250: iconst_5
    //   7251: idiv
    //   7252: iadd
    //   7253: getstatic fl.aM : B
    //   7256: iconst_5
    //   7257: imul
    //   7258: iadd
    //   7259: bipush #16
    //   7261: iadd
    //   7262: aload_1
    //   7263: getfield d : Len;
    //   7266: getfield f : I
    //   7269: iadd
    //   7270: putfield b : I
    //   7273: aload_1
    //   7274: getfield d : Len;
    //   7277: iconst_3
    //   7278: putfield o : I
    //   7281: aload_1
    //   7282: getfield d : Len;
    //   7285: iconst_1
    //   7286: putfield m : I
    //   7289: aload_1
    //   7290: getfield d : Len;
    //   7293: iconst_1
    //   7294: putfield p : I
    //   7297: aload_1
    //   7298: iconst_m1
    //   7299: putfield e : I
    //   7302: return
    //   7303: invokestatic k : ()V
    //   7306: aload_1
    //   7307: getfield b : I
    //   7310: aload_0
    //   7311: aload_1
    //   7312: getfield a : I
    //   7315: aaload
    //   7316: arraylength
    //   7317: if_icmpge -> 7630
    //   7320: aload_0
    //   7321: aload_1
    //   7322: getfield a : I
    //   7325: aaload
    //   7326: aload_1
    //   7327: getfield b : I
    //   7330: aaload
    //   7331: invokevirtual length : ()I
    //   7334: ifle -> 7630
    //   7337: new ah
    //   7340: dup
    //   7341: invokespecial <init> : ()V
    //   7344: dup
    //   7345: astore_2
    //   7346: aload_0
    //   7347: aload_1
    //   7348: getfield a : I
    //   7351: aaload
    //   7352: aload_1
    //   7353: getfield b : I
    //   7356: aaload
    //   7357: aload_1
    //   7358: getfield g : Lbt;
    //   7361: getstatic ft.Y : I
    //   7364: bipush #45
    //   7366: isub
    //   7367: invokestatic g : ()Lfl;
    //   7370: pop
    //   7371: iconst_0
    //   7372: getstatic ft.X : I
    //   7375: iconst_5
    //   7376: idiv
    //   7377: iadd
    //   7378: getstatic fl.aM : B
    //   7381: iconst_1
    //   7382: ishl
    //   7383: iadd
    //   7384: bipush #22
    //   7386: iadd
    //   7387: bipush #6
    //   7389: bipush #90
    //   7391: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   7394: aload_2
    //   7395: putstatic ft.r : Lda;
    //   7398: return
    //   7399: invokestatic k : ()V
    //   7402: aload_1
    //   7403: getfield b : I
    //   7406: aload_0
    //   7407: aload_1
    //   7408: getfield a : I
    //   7411: aaload
    //   7412: arraylength
    //   7413: if_icmpge -> 7630
    //   7416: aload_0
    //   7417: aload_1
    //   7418: getfield a : I
    //   7421: aaload
    //   7422: aload_1
    //   7423: getfield b : I
    //   7426: aaload
    //   7427: invokevirtual length : ()I
    //   7430: ifle -> 7630
    //   7433: new ah
    //   7436: dup
    //   7437: invokespecial <init> : ()V
    //   7440: dup
    //   7441: astore_2
    //   7442: aload_0
    //   7443: aload_1
    //   7444: getfield a : I
    //   7447: aaload
    //   7448: aload_1
    //   7449: getfield b : I
    //   7452: aaload
    //   7453: aload_1
    //   7454: getfield g : Lbt;
    //   7457: invokestatic g : ()Lfl;
    //   7460: getfield L : I
    //   7463: getstatic fl.aM : B
    //   7466: iadd
    //   7467: getstatic fl.S : I
    //   7470: iconst_4
    //   7471: idiv
    //   7472: iadd
    //   7473: bipush #45
    //   7475: isub
    //   7476: invokestatic g : ()Lfl;
    //   7479: pop
    //   7480: iconst_0
    //   7481: getstatic fl.aM : B
    //   7484: iadd
    //   7485: getstatic ft.X : I
    //   7488: iconst_5
    //   7489: idiv
    //   7490: iadd
    //   7491: bipush #22
    //   7493: iadd
    //   7494: iconst_5
    //   7495: bipush #90
    //   7497: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   7500: aload_2
    //   7501: putstatic ft.r : Lda;
    //   7504: return
    //   7505: invokestatic k : ()V
    //   7508: aload_1
    //   7509: getfield b : I
    //   7512: aload_0
    //   7513: aload_1
    //   7514: getfield a : I
    //   7517: aaload
    //   7518: arraylength
    //   7519: if_icmpge -> 7630
    //   7522: aload_0
    //   7523: aload_1
    //   7524: getfield a : I
    //   7527: aaload
    //   7528: aload_1
    //   7529: getfield b : I
    //   7532: aaload
    //   7533: invokevirtual length : ()I
    //   7536: ifle -> 7630
    //   7539: new ah
    //   7542: dup
    //   7543: invokespecial <init> : ()V
    //   7546: dup
    //   7547: astore_2
    //   7548: aload_0
    //   7549: aload_1
    //   7550: getfield a : I
    //   7553: aaload
    //   7554: aload_1
    //   7555: getfield b : I
    //   7558: aaload
    //   7559: aload_1
    //   7560: getfield g : Lbt;
    //   7563: invokestatic g : ()Lfl;
    //   7566: getfield L : I
    //   7569: getstatic fl.aM : B
    //   7572: iadd
    //   7573: getstatic fl.S : I
    //   7576: iconst_4
    //   7577: idiv
    //   7578: iconst_3
    //   7579: imul
    //   7580: iadd
    //   7581: bipush #45
    //   7583: isub
    //   7584: invokestatic g : ()Lfl;
    //   7587: pop
    //   7588: iconst_0
    //   7589: getstatic fl.aM : B
    //   7592: iadd
    //   7593: getstatic ft.X : I
    //   7596: iconst_5
    //   7597: idiv
    //   7598: iadd
    //   7599: bipush #22
    //   7601: iadd
    //   7602: iconst_5
    //   7603: bipush #90
    //   7605: invokevirtual a : (Ljava/lang/String;Lbt;IIII)V
    //   7608: aload_2
    //   7609: putstatic ft.r : Lda;
    //   7612: return
    //   7613: invokestatic k : ()V
    //   7616: aload_1
    //   7617: iconst_m1
    //   7618: putfield a : I
    //   7621: aload_1
    //   7622: iconst_0
    //   7623: putfield b : I
    //   7626: aload_1
    //   7627: invokevirtual c : ()V
    //   7630: return
  }
  
  public final boolean d(int paramInt1, int paramInt2) {
    return (this.a == paramInt1 && this.b == paramInt2);
  }
  
  public final void h() {
    if (this.a >= 0) {
      if (this.c > 0) {
        this.c--;
        if (this.c == 1)
          if (ft.r == null && ft.s == null) {
            g();
          } else {
            this.c = 20;
          }  
      } 
      switch (this.a) {
        case 0:
          if (this.b == -4 || this.b == -2) {
            this.f++;
            if (ft.r != null) {
              ft.k();
              this.c = -1;
            } 
            if (cn.f.cN == null && this.f > 10) {
              this.b++;
              g();
            } 
          } 
          if (this.b == -3) {
            if (ft.r != null)
              ft.k(); 
            this.f++;
            if (this.f > 60) {
              this.b++;
              g();
              this.f = 0;
            } 
          } 
          if (this.b == 5 && this.d != null && ak.e(cn.f.aY - this.d.a) < 10 && ak.e(cn.f.aZ - this.d.b) < 10) {
            this.d = null;
            f();
            g();
            return;
          } 
          break;
        case 2:
          if (!ft.o.a && this.b == 10) {
            this.b = 9;
            return;
          } 
          break;
        case 5:
          if (this.b == 0) {
            this.f++;
            if (this.f >= 20) {
              this.b++;
              g();
            } 
          } 
          break;
      } 
    } 
  }
  
  public final void b(bx parambx) {
    if (this.a != 2 && this.a != 3 && this.a != 4 && this.a != 7 && this.a != 8 && (this.a != 9 || this.b == 0) && this.d != null && this.d.m == 0 && this.i != null)
      this.i.b(ft.ai / 2 % this.i.c, this.d.a, this.d.b, 0, 3, parambx); 
  }
  
  public final void e(bx parambx) {
    if (this.a != 2 && this.a != 3 && this.a != 4 && this.a != 7 && this.a != 8 && (this.a != 9 || this.b == 0) && this.d != null && this.d.m == 1)
      if (this.d.p == 0) {
        if (this.i != null) {
          this.i.b(ft.ai / 2 % this.i.c, this.d.a, this.d.b, 0, 3, parambx);
          return;
        } 
      } else if (this.d.p == 1) {
        a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
      }  
  }
  
  public final int i() {
    switch (this.a) {
      case 1:
        if (this.b == 9)
          return 0; 
        break;
      case 2:
        if (this.b == 4)
          return 0; 
        if (this.b == 9)
          return 1; 
        if (this.b == 10)
          return 4; 
        break;
      case 3:
        if (this.b == 4)
          return 0; 
        break;
      case 6:
        if (this.b == 2)
          return 0; 
        break;
    } 
    return -1;
  }
  
  public final void a(bx parambx, bw parambw, byte paramByte) {
    if (this.e != paramByte && this.e != -1)
      return; 
    switch (this.a) {
      case 2:
        if (!ft.D && !f.a && (this.b == 4 || this.b == 9))
          return; 
        if ((this.b == 4 || this.b == 9) && parambw != null && parambw.u == 4 && parambw.L == 0 && this.d != null) {
          ft.a(parambx);
          a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
          return;
        } 
        break;
      case 3:
        if (this.b == 4 && parambw != null && parambw.u == 3 && parambw.R == 6 && this.d != null) {
          ft.a(parambx);
          a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
        } 
        if (this.b == 8 && this.d != null) {
          ft.a(parambx);
          a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
          return;
        } 
        break;
      case 4:
        if (this.b == 9 && this.d != null) {
          ft.a(parambx);
          a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
          return;
        } 
        break;
      case 7:
        if ((this.b == 6 || this.b == 9) && this.d != null) {
          ft.a(parambx);
          a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
          return;
        } 
        break;
      case 8:
        if (this.b == 7 && this.d != null) {
          ft.a(parambx);
          a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
          return;
        } 
        break;
      case 9:
        if (this.b == 1 && this.d != null) {
          ft.a(parambx);
          a(parambx, this.d.a, this.d.b, this.d.e, this.d.f, this.d.o, this.j);
        } 
        break;
    } 
  }
  
  public static void a(bx parambx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String[] paramArrayOfString) {
    int i = paramInt2 - paramInt4;
    int j = paramInt1;
    parambx.a(k[0]);
    parambx.c(j - 3, i, paramInt3 + 6, paramInt4);
    parambx.c(j, i - 3, paramInt3, paramInt4 + 6);
    parambx.a(k[1]);
    parambx.c(j - 2, i - 2, paramInt3 + 4, paramInt4 + 4);
    parambx.a(cj.e[0], 0, 0, 3, 3, 0, j - 3, i - 3, 0);
    parambx.a(cj.e[0], 0, 3, 3, 3, 0, j + paramInt3, i - 3, 0);
    parambx.a(cj.e[0], 0, 9, 3, 3, 0, j - 3, i + paramInt4, 0);
    parambx.a(cj.e[0], 0, 6, 3, 3, 0, j + paramInt3, i + paramInt4, 0);
    for (byte b = 0; b < paramArrayOfString.length; b++)
      o.i.a(parambx, paramArrayOfString[b], j + paramInt3 / 2, i + 1 + b * ft.ab, 2, false); 
    switch (paramInt5) {
      case 0:
        parambx.a(cg.ak, paramInt1, paramInt2 + 2 + ft.ai / 2 % 4, 0);
        return;
      case 1:
        parambx.a(cg.ak, paramInt1 + paramInt3, paramInt2 + 2 + ft.ai / 2 % 4, 24);
        return;
      case 2:
        if (!ft.D && !f.a && cn.p.a == 8 && (cn.p.b == 3 || cn.p.b == 2))
          return; 
        parambx.a(cg.ak, paramInt1 + paramInt3 / 2, paramInt2 + 2 + ft.ai / 2 % 4, 17);
        return;
      case 3:
        parambx.a(cg.ak, 0, 0, 12, 16, 1, paramInt1, paramInt2 - paramInt4 - 20 + 2 + ft.ai / 2 % 4, 0);
        return;
      case 4:
        parambx.a(cg.ak, 0, 0, 12, 16, 1, paramInt1 + paramInt3, paramInt2 - paramInt4 - 20 + 2 + ft.ai / 2 % 4, 24);
        return;
      case 5:
        parambx.a(cg.ak, 0, 0, 12, 16, 1, paramInt1 + paramInt3 / 2, paramInt2 - paramInt4 - 20 + 2 + ft.ai / 2 % 4, 17);
        return;
      case 7:
        parambx.a(cg.ak, 0, 0, 12, 16, 5, paramInt1 + ft.ai / 2 % 4, paramInt2 - paramInt4 / 2, 10);
        return;
      case 8:
        parambx.a(cg.ak, 0, 0, 12, 16, 4, paramInt1 + paramInt3 + 1 + ft.ai / 2 % 4, paramInt2 - paramInt4 / 2, 6);
        break;
    } 
  }
  
  private void a(String[][] paramArrayOfString) {
    ByteArrayOutputStream byteArrayOutputStream;
    bt bt1;
    DataOutputStream dataOutputStream;
    es es;
    int i;
    byte b1;
    byte b2;
    boolean bool;
    switch (this.b) {
      case -5:
        return;
      case -4:
        this.f = 0;
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutputStream = new DataOutputStream(this);
        try {
          dataOutputStream.writeByte(0);
          ak.a((byte)2, toByteArray());
          dataOutputStream.close();
        } catch (Exception exception) {}
        bq.m = true;
        cn.f.cN = null;
        cn.f.N();
        cn.f.bf = cn.f.aY;
        cn.f.bg = cn.f.aZ;
        cn.f.cl = 0;
        cn.f.cm = 0;
        cn.f.cN = ft.c.a(10, 16, cn.f.aY / cs.l, cn.f.aZ / cs.l, 40);
        return;
      case -3:
        bq.m = true;
        cn.f.cN = null;
        cn.f.N();
        cn.f.cG = 2;
        cn.f.cE = "...";
        ((fb)super).f = 0;
        return;
      case -2:
        ((fb)super).f = 0;
        bq.m = true;
        cn.f.N();
        cn.f.bf = cn.f.aY;
        cn.f.bg = cn.f.aZ;
        cn.f.cl = 0;
        cn.f.cm = 0;
        cn.f.cN = ft.c.a(24 + ak.g(3), 21 + ak.g(3), cn.f.aY / cs.l, cn.f.aZ / cs.l, 40);
        return;
      case -1:
        (es = new es("MainHelp menu")).a(((fb)super).h);
        bt1 = new bt(df.gb, 1, (cg)this);
        es.a(this);
        ft.a(df.dg, es);
        return;
      case 4:
        if (bq.m)
          bq.m = false; 
        if (!bq.n)
          bq.n = true; 
        if (((fb)super).b < (es[((fb)super).a]).length && es[((fb)super).a][((fb)super).b].length() > 0) {
          int j;
          if ((j = ft.W - 30) > 200)
            j = 200; 
          int k = ft.Y - j / 2;
          int m = ft.X - (ft.aa << 1);
          ah ah;
          (ah = new ah()).a((String)es[((fb)super).a][((fb)super).b], ((fb)super).g, k, m, -1, j);
          ft.r = ah;
        } 
        b1 = 80;
        b2 = 0;
        bool = false;
        do {
          b2++;
          int j = cn.f.aY + ak.b(40, b1);
          i = cn.f.aZ + ak.b(40, b1);
          int k = ft.p.a(j, i);
          if (cn.e(j, i) && k != -1 && k != 1) {
            bool = true;
            ((fb)super).d = new en();
            ((fb)super).d.a = j;
            ((fb)super).d.b = i;
            ((fb)super).d.m = 0;
            ((fb)super).d.p = 0;
            ((fb)super).i = cf.p;
          } 
          if (b2 <= 10)
            continue; 
          b1 += 10;
          b2 = 0;
        } while (!bool);
        return;
      case 5:
        ft.k();
        return;
    } 
    ft.k();
    super.c(i);
  }
  
  private void b(String[][] paramArrayOfString) {
    switch (this.b) {
      case 0:
        if (!ft.D && !f.a) {
          ft.k();
          a(3, paramArrayOfString);
          ft.u.a = 3;
          return;
        } 
        ft.k();
        if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
          fl.g();
          ah ah;
          (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, ft.Y - 45, 0 + ft.X / 5 + (fl.aM << 1) + 22, 6, 90);
          ft.r = ah;
          return;
        } 
        break;
      case 4:
        if (!ft.D && !f.a) {
          ft.k();
          this.a = -1;
          this.b = 0;
          c();
          return;
        } 
        ft.k();
        if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
          fl.g();
          ah ah;
          (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, ft.Y - 45, 0 + ft.X / 5 + (fl.aM << 1) + 22, 6, 90);
          ft.r = ah;
          return;
        } 
        break;
      case 5:
      case 6:
      case 8:
      case 9:
        ft.k();
        if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
          fl.g();
          ah ah;
          (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, ft.Y - 45, 0 + ft.X / 5 + (fl.aM << 1) + 22, 6, 90);
          ft.r = ah;
          return;
        } 
        break;
      case 1:
        if (!ft.D && !f.a) {
          ft.k();
          a(4, paramArrayOfString);
          ft.u.a = 4;
          return;
        } 
        ft.k();
        if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
          fl.g();
          ah ah;
          (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, (fl.g()).L + fl.aN + fl.S / 2 + fl.S / 8, 0 + ft.X / 5 + fl.aM + fl.T / 2, 7, 90);
          ft.r = ah;
          return;
        } 
        break;
      case 2:
        if (!ft.D && !f.a) {
          ft.k();
          if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
            fl.g();
            ah ah;
            (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, (fl.g()).L + fl.aN + fl.S / 2 + fl.S / 8, 0 + ft.X / 5 + fl.aM + fl.T / 2, 2, 90);
            ft.r = ah;
            return;
          } 
          break;
        } 
        ft.k();
        if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
          fl.g();
          ah ah;
          (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, (fl.g()).L + fl.aN + fl.S / 2 + fl.S / 8, 0 + ft.X / 5 + fl.aM + fl.T / 2, 7, 90);
          ft.r = ah;
          return;
        } 
        break;
      case 3:
        if (!ft.D && !f.a) {
          ft.k();
          if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
            fl.g();
            ah ah;
            (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, (fl.g()).L + fl.aN + fl.S / 4 * 3, 0 + ft.X / 5 + fl.aM + fl.T / 2, 2, 90);
            ft.r = ah;
            return;
          } 
          break;
        } 
        ft.k();
        if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
          fl.g();
          ah ah;
          (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, (fl.g()).L + fl.aN + fl.S / 4 * 3, 0 + ft.X / 5 + fl.aM + fl.T / 2, 8, 90);
          ft.r = ah;
          return;
        } 
        break;
      case 7:
        ft.k();
        if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
          this.d = new en();
          this.d.a = (fl.g()).L + fl.aN + fl.aN / 2 + fl.S / 8 * 3;
          this.d.e = 80;
          this.j = o.i.a(paramArrayOfString[this.a][this.b], this.d.e);
          this.d.f = this.j.length * ft.ab;
          fl.g();
          this.d.b = 0 + ft.X / 5 + fl.aM;
          this.d.o = -1;
          this.d.m = 1;
          this.d.p = 1;
        } 
        this.e = 3;
        return;
      case 10:
        ft.k();
        break;
    } 
  }
  
  private void c(String[][] paramArrayOfString) {
    if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
      int i;
      if ((i = ft.W - 30) > 200)
        i = 200; 
      int j = ft.Y - i / 2;
      int k = ft.X - (ft.aa << 1);
      ah ah;
      (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, j, k, -1, i);
      ft.r = ah;
    } 
  }
  
  private void a(int paramInt, String[][] paramArrayOfString) {
    ft.k();
    if (this.b < (paramArrayOfString[this.a]).length && paramArrayOfString[this.a][this.b].length() > 0) {
      fl.g();
      ah ah;
      (ah = new ah()).a(paramArrayOfString[this.a][this.b], this.g, (fl.g()).L + fl.aN + fl.aN / 2, 0 + ft.X / 5 + fl.aM + 16 + paramInt * fl.aM, 3, 90);
      ft.r = ah;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\fb.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */