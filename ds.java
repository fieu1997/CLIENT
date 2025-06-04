public final class ds {
  private int a = 0;
  
  private int b;
  
  private boolean c = false;
  
  public final void a(int paramInt) {
    this.a = paramInt;
    this.c = false;
    switch (this.a) {
      case 0:
        this.b = 4;
        return;
      case 1:
        this.b = 6;
        return;
      case 6:
        this.b = 30;
        this.c = true;
        return;
      case 2:
        this.b = 12;
        return;
      case 5:
        this.b = 8;
        return;
      case 10:
        this.b = 22;
        this.c = true;
        return;
      case 7:
        this.b = 16;
        return;
      case 8:
        this.b = 10;
        return;
      case 11:
        this.b = 11;
        this.c = true;
        return;
      case 16:
        this.b = 6;
        this.c = true;
        break;
    } 
  }
  
  public final void a(ez paramez) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : I
    //   4: tableswitch default -> 675, 3 -> 72, 4 -> 373, 5 -> 675, 6 -> 675, 7 -> 675, 8 -> 675, 9 -> 617, 10 -> 675, 11 -> 675, 12 -> 447, 13 -> 148, 14 -> 459, 15 -> 271
    //   72: aload_1
    //   73: getfield cP : I
    //   76: iconst_2
    //   77: if_icmpge -> 93
    //   80: aload_1
    //   81: iconst_5
    //   82: putfield ce : I
    //   85: aload_1
    //   86: iconst_4
    //   87: putfield dW : I
    //   90: goto -> 797
    //   93: aload_1
    //   94: iconst_1
    //   95: invokevirtual i : (I)V
    //   98: aload_1
    //   99: aload_1
    //   100: getfield cP : I
    //   103: iconst_2
    //   104: iadd
    //   105: putfield dW : I
    //   108: aload_1
    //   109: getfield cP : I
    //   112: bipush #6
    //   114: if_icmpge -> 125
    //   117: aload_1
    //   118: iconst_4
    //   119: putfield ce : I
    //   122: goto -> 797
    //   125: aload_1
    //   126: iconst_0
    //   127: putfield cF : I
    //   130: aload_1
    //   131: iconst_0
    //   132: putfield ce : I
    //   135: aload_1
    //   136: iconst_0
    //   137: putfield ba : I
    //   140: aload_1
    //   141: iconst_0
    //   142: putfield dW : I
    //   145: goto -> 797
    //   148: aload_1
    //   149: getfield cP : I
    //   152: bipush #12
    //   154: if_icmpge -> 170
    //   157: aload_1
    //   158: iconst_5
    //   159: putfield ce : I
    //   162: aload_1
    //   163: iconst_4
    //   164: putfield dW : I
    //   167: goto -> 797
    //   170: aload_1
    //   171: getfield cP : I
    //   174: bipush #30
    //   176: if_icmpge -> 248
    //   179: aload_1
    //   180: getfield cP : I
    //   183: bipush #14
    //   185: if_icmpge -> 207
    //   188: aload_1
    //   189: aload_1
    //   190: getfield cP : I
    //   193: bipush #8
    //   195: isub
    //   196: putfield dW : I
    //   199: aload_1
    //   200: iconst_4
    //   201: putfield ce : I
    //   204: goto -> 797
    //   207: aload_1
    //   208: getfield cP : I
    //   211: iconst_2
    //   212: irem
    //   213: ifne -> 234
    //   216: aload_1
    //   217: iconst_1
    //   218: invokevirtual i : (I)V
    //   221: aload_1
    //   222: iconst_4
    //   223: putfield dW : I
    //   226: aload_1
    //   227: iconst_5
    //   228: putfield ce : I
    //   231: goto -> 797
    //   234: aload_1
    //   235: bipush #7
    //   237: putfield dW : I
    //   240: aload_1
    //   241: iconst_4
    //   242: putfield ce : I
    //   245: goto -> 797
    //   248: aload_1
    //   249: iconst_0
    //   250: putfield cF : I
    //   253: aload_1
    //   254: iconst_0
    //   255: putfield ce : I
    //   258: aload_1
    //   259: iconst_0
    //   260: putfield ba : I
    //   263: aload_1
    //   264: iconst_0
    //   265: putfield dW : I
    //   268: goto -> 797
    //   271: aload_1
    //   272: getfield cP : I
    //   275: bipush #26
    //   277: if_icmpge -> 307
    //   280: aload_1
    //   281: iconst_5
    //   282: putfield ce : I
    //   285: aload_1
    //   286: iconst_4
    //   287: putfield dW : I
    //   290: aload_1
    //   291: getfield cP : I
    //   294: bipush #12
    //   296: if_icmplt -> 797
    //   299: aload_1
    //   300: iconst_1
    //   301: invokevirtual i : (I)V
    //   304: goto -> 797
    //   307: aload_1
    //   308: getfield cP : I
    //   311: bipush #30
    //   313: if_icmpge -> 350
    //   316: aload_1
    //   317: aload_1
    //   318: getfield cP : I
    //   321: bipush #22
    //   323: isub
    //   324: putfield dW : I
    //   327: aload_1
    //   328: iconst_4
    //   329: putfield ce : I
    //   332: aload_1
    //   333: getfield dW : I
    //   336: bipush #7
    //   338: if_icmple -> 797
    //   341: aload_1
    //   342: bipush #7
    //   344: putfield dW : I
    //   347: goto -> 797
    //   350: aload_1
    //   351: iconst_0
    //   352: putfield cF : I
    //   355: aload_1
    //   356: iconst_0
    //   357: putfield ce : I
    //   360: aload_1
    //   361: iconst_0
    //   362: putfield ba : I
    //   365: aload_1
    //   366: iconst_0
    //   367: putfield dW : I
    //   370: goto -> 797
    //   373: aload_1
    //   374: getfield cP : I
    //   377: iconst_4
    //   378: if_icmpge -> 394
    //   381: aload_1
    //   382: iconst_4
    //   383: putfield ce : I
    //   386: aload_1
    //   387: iconst_4
    //   388: putfield dW : I
    //   391: goto -> 797
    //   394: aload_1
    //   395: iconst_1
    //   396: invokevirtual i : (I)V
    //   399: aload_1
    //   400: aload_1
    //   401: getfield cP : I
    //   404: putfield dW : I
    //   407: aload_1
    //   408: getfield cP : I
    //   411: bipush #10
    //   413: if_icmpge -> 424
    //   416: aload_1
    //   417: iconst_5
    //   418: putfield ce : I
    //   421: goto -> 797
    //   424: aload_1
    //   425: iconst_0
    //   426: putfield cF : I
    //   429: aload_1
    //   430: iconst_0
    //   431: putfield ce : I
    //   434: aload_1
    //   435: iconst_0
    //   436: putfield ba : I
    //   439: aload_1
    //   440: iconst_0
    //   441: putfield dW : I
    //   444: goto -> 797
    //   447: aload_1
    //   448: getfield cP : I
    //   451: bipush #30
    //   453: if_icmplt -> 797
    //   456: goto -> 777
    //   459: aload_1
    //   460: getfield bx : B
    //   463: iconst_3
    //   464: if_icmpne -> 543
    //   467: aload_1
    //   468: getfield cP : I
    //   471: iconst_2
    //   472: if_icmpge -> 488
    //   475: aload_1
    //   476: iconst_5
    //   477: putfield ce : I
    //   480: aload_1
    //   481: iconst_4
    //   482: putfield dW : I
    //   485: goto -> 797
    //   488: aload_1
    //   489: iconst_1
    //   490: invokevirtual i : (I)V
    //   493: aload_1
    //   494: aload_1
    //   495: getfield cP : I
    //   498: iconst_2
    //   499: iadd
    //   500: putfield dW : I
    //   503: aload_1
    //   504: getfield cP : I
    //   507: bipush #6
    //   509: if_icmpge -> 520
    //   512: aload_1
    //   513: iconst_4
    //   514: putfield ce : I
    //   517: goto -> 797
    //   520: aload_1
    //   521: iconst_0
    //   522: putfield cF : I
    //   525: aload_1
    //   526: iconst_0
    //   527: putfield ce : I
    //   530: aload_1
    //   531: iconst_0
    //   532: putfield ba : I
    //   535: aload_1
    //   536: iconst_0
    //   537: putfield dW : I
    //   540: goto -> 797
    //   543: aload_1
    //   544: getfield cP : I
    //   547: iconst_4
    //   548: if_icmpge -> 564
    //   551: aload_1
    //   552: iconst_4
    //   553: putfield ce : I
    //   556: aload_1
    //   557: iconst_4
    //   558: putfield dW : I
    //   561: goto -> 797
    //   564: aload_1
    //   565: iconst_1
    //   566: invokevirtual i : (I)V
    //   569: aload_1
    //   570: aload_1
    //   571: getfield cP : I
    //   574: putfield dW : I
    //   577: aload_1
    //   578: getfield cP : I
    //   581: bipush #8
    //   583: if_icmpge -> 594
    //   586: aload_1
    //   587: iconst_5
    //   588: putfield ce : I
    //   591: goto -> 797
    //   594: aload_1
    //   595: iconst_0
    //   596: putfield cF : I
    //   599: aload_1
    //   600: iconst_0
    //   601: putfield ce : I
    //   604: aload_1
    //   605: iconst_0
    //   606: putfield ba : I
    //   609: aload_1
    //   610: iconst_0
    //   611: putfield dW : I
    //   614: goto -> 797
    //   617: aload_1
    //   618: getfield cP : I
    //   621: bipush #30
    //   623: if_icmpge -> 652
    //   626: aload_1
    //   627: iconst_4
    //   628: putfield ce : I
    //   631: aload_1
    //   632: getfield bx : B
    //   635: iconst_3
    //   636: if_icmpne -> 644
    //   639: aload_1
    //   640: iconst_5
    //   641: putfield ce : I
    //   644: aload_1
    //   645: iconst_4
    //   646: putfield dW : I
    //   649: goto -> 797
    //   652: aload_1
    //   653: iconst_0
    //   654: putfield cF : I
    //   657: aload_1
    //   658: iconst_0
    //   659: putfield ce : I
    //   662: aload_1
    //   663: iconst_0
    //   664: putfield ba : I
    //   667: aload_1
    //   668: iconst_0
    //   669: putfield dW : I
    //   672: goto -> 797
    //   675: aload_1
    //   676: getfield cP : I
    //   679: aload_0
    //   680: getfield b : I
    //   683: if_icmpge -> 724
    //   686: aload_1
    //   687: iconst_4
    //   688: putfield ce : I
    //   691: aload_0
    //   692: getfield c : Z
    //   695: ifeq -> 703
    //   698: aload_1
    //   699: iconst_5
    //   700: putfield ce : I
    //   703: aload_1
    //   704: iconst_4
    //   705: putfield dW : I
    //   708: aload_1
    //   709: getfield dW : I
    //   712: iconst_4
    //   713: if_icmple -> 797
    //   716: aload_1
    //   717: iconst_4
    //   718: putfield dW : I
    //   721: goto -> 797
    //   724: aload_1
    //   725: iconst_1
    //   726: invokevirtual i : (I)V
    //   729: aload_1
    //   730: aload_1
    //   731: getfield cP : I
    //   734: aload_0
    //   735: getfield b : I
    //   738: iconst_4
    //   739: isub
    //   740: isub
    //   741: putfield dW : I
    //   744: aload_1
    //   745: getfield cP : I
    //   748: aload_0
    //   749: getfield b : I
    //   752: iconst_4
    //   753: iadd
    //   754: if_icmpge -> 777
    //   757: aload_1
    //   758: iconst_5
    //   759: putfield ce : I
    //   762: aload_0
    //   763: getfield c : Z
    //   766: ifeq -> 797
    //   769: aload_1
    //   770: iconst_4
    //   771: putfield ce : I
    //   774: goto -> 797
    //   777: aload_1
    //   778: iconst_0
    //   779: putfield cF : I
    //   782: aload_1
    //   783: iconst_0
    //   784: putfield ce : I
    //   787: aload_1
    //   788: iconst_0
    //   789: putfield ba : I
    //   792: aload_1
    //   793: iconst_0
    //   794: putfield dW : I
    //   797: aload_1
    //   798: dup
    //   799: getfield cP : I
    //   802: iconst_1
    //   803: iadd
    //   804: putfield cP : I
    //   807: return
  }
}


/* Location:              C:\Users\Administrator\Desktop\HsoMobi.jar!\ds.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */