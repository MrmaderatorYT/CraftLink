package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.bem;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class bdc {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2535a = bkg.f("vide");

    /* renamed from: b, reason: collision with root package name */
    private static final int f2536b = bkg.f("soun");
    private static final int c = bkg.f("text");
    private static final int d = bkg.f("sbtl");
    private static final int e = bkg.f("subt");
    private static final int f = bkg.f("clcp");
    private static final int g = bkg.f("cenc");
    private static final int h = bkg.f("meta");

    /* JADX WARN: Removed duplicated region for block: B:199:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x07f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:411:0x07f5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.bdx a(com.google.android.gms.internal.ads.bda r49, com.google.android.gms.internal.ads.bdb r50, long r51, com.google.android.gms.internal.ads.bbt r53, boolean r54) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 2102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bdc.a(com.google.android.gms.internal.ads.bda, com.google.android.gms.internal.ads.bdb, long, com.google.android.gms.internal.ads.bbt, boolean):com.google.android.gms.internal.ads.bdx");
    }

    public static bea a(bdx bdxVar, bda bdaVar, bch bchVar) throws zzfx {
        bdf bdiVar;
        boolean z;
        int iO;
        int iO2;
        int i;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i2;
        long j;
        boolean z2;
        long[] jArr3;
        long[] jArr4;
        long[] jArr5;
        int[] iArr3;
        int[] iArr4;
        int i3;
        int[] iArr5;
        int[] iArr6;
        int i4;
        bdf bdfVar;
        bdx bdxVar2 = bdxVar;
        bdb bdbVarD = bdaVar.d(bcz.ap);
        if (bdbVarD != null) {
            bdiVar = new bdh(bdbVarD);
        } else {
            bdb bdbVarD2 = bdaVar.d(bcz.aq);
            if (bdbVarD2 == null) {
                throw new zzfx("Track has no sample table size information");
            }
            bdiVar = new bdi(bdbVarD2);
        }
        int iA = bdiVar.a();
        if (iA == 0) {
            return new bea(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        bdb bdbVarD3 = bdaVar.d(bcz.ar);
        if (bdbVarD3 == null) {
            bdbVarD3 = bdaVar.d(bcz.as);
            z = true;
        } else {
            z = false;
        }
        bjz bjzVar = bdbVarD3.aP;
        bjz bjzVar2 = bdaVar.d(bcz.ao).aP;
        bjz bjzVar3 = bdaVar.d(bcz.al).aP;
        bdb bdbVarD4 = bdaVar.d(bcz.am);
        bjz bjzVar4 = bdbVarD4 != null ? bdbVarD4.aP : null;
        bdb bdbVarD5 = bdaVar.d(bcz.an);
        bjz bjzVar5 = bdbVarD5 != null ? bdbVarD5.aP : null;
        bdd bddVar = new bdd(bjzVar2, bjzVar, z);
        bjzVar3.c(12);
        int iO3 = bjzVar3.o() - 1;
        int iO4 = bjzVar3.o();
        int iO5 = bjzVar3.o();
        if (bjzVar5 != null) {
            bjzVar5.c(12);
            iO = bjzVar5.o();
        } else {
            iO = 0;
        }
        int iO6 = -1;
        if (bjzVar4 != null) {
            bjzVar4.c(12);
            iO2 = bjzVar4.o();
            if (iO2 > 0) {
                iO6 = bjzVar4.o() - 1;
            } else {
                bjzVar4 = null;
            }
        } else {
            iO2 = 0;
        }
        long j2 = 0;
        if (!(bdiVar.c() && "audio/raw".equals(bdxVar2.f.e) && iO3 == 0 && iO == 0 && iO2 == 0)) {
            jArr = new long[iA];
            iArr = new int[iA];
            jArr2 = new long[iA];
            int i5 = iO2;
            iArr2 = new int[iA];
            int i6 = iO;
            int iO7 = iO6;
            long j3 = 0;
            int i7 = i5;
            int i8 = 0;
            int iL = 0;
            int i9 = 0;
            int iO8 = 0;
            int i10 = iO3;
            long j4 = 0;
            int i11 = 0;
            int i12 = iO4;
            int i13 = iO5;
            while (i11 < iA) {
                while (i9 == 0) {
                    bjq.b(bddVar.a());
                    int i14 = i13;
                    long j5 = bddVar.d;
                    i9 = bddVar.c;
                    i13 = i14;
                    i10 = i10;
                    j4 = j5;
                }
                int i15 = i13;
                int i16 = i10;
                if (bjzVar5 != null) {
                    while (iO8 == 0 && i6 > 0) {
                        iO8 = bjzVar5.o();
                        iL = bjzVar5.l();
                        i6--;
                    }
                    iO8--;
                }
                int i17 = iL;
                jArr[i11] = j4;
                iArr[i11] = bdiVar.b();
                if (iArr[i11] > i8) {
                    i4 = iA;
                    bdfVar = bdiVar;
                    i8 = iArr[i11];
                } else {
                    i4 = iA;
                    bdfVar = bdiVar;
                }
                jArr2[i11] = j3 + i17;
                iArr2[i11] = bjzVar4 == null ? 1 : 0;
                if (i11 == iO7) {
                    iArr2[i11] = 1;
                    i7--;
                    if (i7 > 0) {
                        iO7 = bjzVar4.o() - 1;
                    }
                }
                int i18 = i7;
                int i19 = iO7;
                int i20 = i15;
                j3 += i20;
                i12--;
                if (i12 != 0 || i16 <= 0) {
                    i10 = i16;
                } else {
                    int iO9 = bjzVar3.o();
                    int iO10 = bjzVar3.o();
                    i10 = i16 - 1;
                    i12 = iO9;
                    i20 = iO10;
                }
                j4 += iArr[i11];
                i9--;
                i11++;
                iL = i17;
                bdiVar = bdfVar;
                iA = i4;
                iO7 = i19;
                i13 = i20;
                i7 = i18;
            }
            i = iA;
            int i21 = i10;
            bjq.a(iO8 == 0);
            while (i6 > 0) {
                bjq.a(bjzVar5.o() == 0);
                bjzVar5.l();
                i6--;
            }
            if (i7 == 0 && i12 == 0 && i9 == 0 && i21 == 0) {
                bdxVar2 = bdxVar;
            } else {
                int i22 = i7;
                bdxVar2 = bdxVar;
                int i23 = bdxVar2.f2565a;
                StringBuilder sb = new StringBuilder(215);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i23);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i22);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i12);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i9);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i21);
                Log.w("AtomParsers", sb.toString());
            }
            j = j3;
            i2 = i8;
        } else {
            i = iA;
            bdf bdfVar2 = bdiVar;
            long[] jArr6 = new long[bddVar.f2537a];
            int[] iArr7 = new int[bddVar.f2537a];
            while (bddVar.a()) {
                jArr6[bddVar.f2538b] = bddVar.d;
                iArr7[bddVar.f2538b] = bddVar.c;
            }
            int iB = bdfVar2.b();
            long j6 = iO5;
            int i24 = 8192 / iB;
            int iA2 = 0;
            for (int i25 : iArr7) {
                iA2 += bkg.a(i25, i24);
            }
            long[] jArr7 = new long[iA2];
            int[] iArr8 = new int[iA2];
            long[] jArr8 = new long[iA2];
            int[] iArr9 = new int[iA2];
            int i26 = 0;
            int i27 = 0;
            int iMax = 0;
            for (int i28 = 0; i28 < iArr7.length; i28++) {
                int i29 = iArr7[i28];
                long j7 = jArr6[i28];
                while (i29 > 0) {
                    int iMin = Math.min(i24, i29);
                    jArr7[i27] = j7;
                    iArr8[i27] = iB * iMin;
                    iMax = Math.max(iMax, iArr8[i27]);
                    jArr8[i27] = i26 * j6;
                    iArr9[i27] = 1;
                    j7 += iArr8[i27];
                    i26 += iMin;
                    i29 -= iMin;
                    i27++;
                    jArr6 = jArr6;
                    iArr7 = iArr7;
                }
            }
            bdm bdmVar = new bdm(jArr7, iArr8, iMax, jArr8, iArr9);
            jArr = bdmVar.f2550a;
            iArr = bdmVar.f2551b;
            int i30 = bdmVar.c;
            jArr2 = bdmVar.d;
            iArr2 = bdmVar.e;
            i2 = i30;
            j = 0;
        }
        if (bdxVar2.i == null || bchVar.a()) {
            int[] iArr10 = iArr;
            bkg.a(jArr2, 1000000L, bdxVar2.c);
            return new bea(jArr, iArr10, i2, jArr2, iArr2);
        }
        if (bdxVar2.i.length == 1 && bdxVar2.f2566b == 1 && jArr2.length >= 2) {
            long j8 = bdxVar2.j[0];
            long jA = bkg.a(bdxVar2.i[0], bdxVar2.c, bdxVar2.d) + j8;
            if (jArr2[0] <= j8 && j8 < jArr2[1] && jArr2[jArr2.length - 1] < jA && jA <= j) {
                long j9 = j - jA;
                long jA2 = bkg.a(j8 - jArr2[0], bdxVar2.f.o, bdxVar2.c);
                long jA3 = bkg.a(j9, bdxVar2.f.o, bdxVar2.c);
                if ((jA2 != 0 || jA3 != 0) && jA2 <= 2147483647L && jA3 <= 2147483647L) {
                    bchVar.f2514a = (int) jA2;
                    bchVar.f2515b = (int) jA3;
                    bkg.a(jArr2, 1000000L, bdxVar2.c);
                    return new bea(jArr, iArr, i2, jArr2, iArr2);
                }
            }
        }
        if (bdxVar2.i.length == 1) {
            char c2 = 0;
            if (bdxVar2.i[0] == 0) {
                int i31 = 0;
                while (i31 < jArr2.length) {
                    jArr2[i31] = bkg.a(jArr2[i31] - bdxVar2.j[c2], 1000000L, bdxVar2.c);
                    i31++;
                    c2 = 0;
                }
                return new bea(jArr, iArr, i2, jArr2, iArr2);
            }
        }
        boolean z3 = bdxVar2.f2566b == 1;
        int i32 = 0;
        boolean z4 = false;
        int i33 = 0;
        int i34 = 0;
        while (i32 < bdxVar2.i.length) {
            long j10 = bdxVar2.j[i32];
            if (j10 != -1) {
                iArr6 = iArr;
                long jA4 = bkg.a(bdxVar2.i[i32], bdxVar2.c, bdxVar2.d);
                int iB2 = bkg.b(jArr2, j10, true, true);
                int iB3 = bkg.b(jArr2, j10 + jA4, z3, false);
                i33 += iB3 - iB2;
                z4 |= i34 != iB2;
                i34 = iB3;
            } else {
                iArr6 = iArr;
            }
            i32++;
            iArr = iArr6;
        }
        int[] iArr11 = iArr;
        boolean z5 = (i33 != i) | z4;
        long[] jArr9 = z5 ? new long[i33] : jArr;
        int[] iArr12 = z5 ? new int[i33] : iArr11;
        if (z5) {
            i2 = 0;
        }
        int[] iArr13 = z5 ? new int[i33] : iArr2;
        long[] jArr10 = new long[i33];
        int i35 = i2;
        int i36 = 0;
        int i37 = 0;
        while (i36 < bdxVar2.i.length) {
            long j11 = bdxVar2.j[i36];
            long j12 = bdxVar2.i[i36];
            if (j11 != -1) {
                int[] iArr14 = iArr13;
                i3 = i36;
                long[] jArr11 = jArr9;
                jArr4 = jArr10;
                long jA5 = bkg.a(j12, bdxVar2.c, bdxVar2.d) + j11;
                int iB4 = bkg.b(jArr2, j11, true, true);
                int iB5 = bkg.b(jArr2, jA5, z3, false);
                if (z5) {
                    int i38 = iB5 - iB4;
                    jArr3 = jArr11;
                    System.arraycopy(jArr, iB4, jArr3, i37, i38);
                    iArr5 = iArr11;
                    System.arraycopy(iArr5, iB4, iArr12, i37, i38);
                    z2 = z3;
                    iArr4 = iArr14;
                    System.arraycopy(iArr2, iB4, iArr4, i37, i38);
                } else {
                    z2 = z3;
                    iArr5 = iArr11;
                    iArr4 = iArr14;
                    jArr3 = jArr11;
                }
                int i39 = i35;
                while (iB4 < iB5) {
                    long[] jArr12 = jArr;
                    int[] iArr15 = iArr2;
                    long j13 = j11;
                    jArr4[i37] = bkg.a(j2, 1000000L, bdxVar2.d) + bkg.a(jArr2[iB4] - j11, 1000000L, bdxVar2.c);
                    if (z5 && iArr12[i37] > i39) {
                        i39 = iArr5[iB4];
                    }
                    i37++;
                    iB4++;
                    jArr = jArr12;
                    iArr2 = iArr15;
                    j11 = j13;
                }
                jArr5 = jArr;
                iArr3 = iArr2;
                i35 = i39;
            } else {
                z2 = z3;
                jArr3 = jArr9;
                jArr4 = jArr10;
                jArr5 = jArr;
                iArr3 = iArr2;
                iArr4 = iArr13;
                i3 = i36;
                iArr5 = iArr11;
            }
            j2 += j12;
            i36 = i3 + 1;
            iArr11 = iArr5;
            jArr9 = jArr3;
            jArr10 = jArr4;
            jArr = jArr5;
            iArr2 = iArr3;
            iArr13 = iArr4;
            z3 = z2;
        }
        long[] jArr13 = jArr9;
        long[] jArr14 = jArr10;
        int[] iArr16 = iArr13;
        boolean z6 = false;
        for (int i40 = 0; i40 < iArr16.length && !z6; i40++) {
            z6 |= (iArr16[i40] & 1) != 0;
        }
        if (!z6) {
            throw new zzfx("The edited sample sequence does not contain a sync sample.");
        }
        return new bea(jArr13, iArr12, i35, jArr14, iArr16);
    }

    public static bem a(bdb bdbVar, boolean z) {
        if (z) {
            return null;
        }
        bjz bjzVar = bdbVar.aP;
        bjzVar.c(8);
        while (bjzVar.b() >= 8) {
            int iD = bjzVar.d();
            int iL = bjzVar.l();
            if (bjzVar.l() == bcz.aA) {
                bjzVar.c(iD);
                int i = iD + iL;
                bjzVar.d(12);
                while (true) {
                    if (bjzVar.d() >= i) {
                        break;
                    }
                    int iD2 = bjzVar.d();
                    int iL2 = bjzVar.l();
                    if (bjzVar.l() == bcz.aB) {
                        bjzVar.c(iD2);
                        int i2 = iD2 + iL2;
                        bjzVar.d(8);
                        ArrayList arrayList = new ArrayList();
                        while (bjzVar.d() < i2) {
                            bem.a aVarA = bdr.a(bjzVar);
                            if (aVarA != null) {
                                arrayList.add(aVarA);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new bem(arrayList);
                        }
                    } else {
                        bjzVar.d(iL2 - 8);
                    }
                }
                return null;
            }
            bjzVar.d(iL - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> a(bjz bjzVar, int i) {
        bjzVar.c(i + 8 + 4);
        bjzVar.d(1);
        a(bjzVar);
        bjzVar.d(2);
        int iF = bjzVar.f();
        if ((iF & 128) != 0) {
            bjzVar.d(2);
        }
        if ((iF & 64) != 0) {
            bjzVar.d(bjzVar.g());
        }
        if ((iF & 32) != 0) {
            bjzVar.d(2);
        }
        bjzVar.d(1);
        a(bjzVar);
        String str = null;
        switch (bjzVar.f()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                str = "audio/ac3";
                break;
            case 166:
                str = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        bjzVar.d(12);
        bjzVar.d(1);
        int iA = a(bjzVar);
        byte[] bArr = new byte[iA];
        bjzVar.a(bArr, 0, iA);
        return Pair.create(str, bArr);
    }

    private static int a(bjz bjzVar, int i, int i2, bdg bdgVar, int i3) {
        bdy bdyVar;
        int iD = bjzVar.d();
        while (true) {
            if (iD - i >= i2) {
                return 0;
            }
            bjzVar.c(iD);
            int iL = bjzVar.l();
            bjq.a(iL > 0, "childAtomSize should be positive");
            if (bjzVar.l() == bcz.V) {
                int i4 = iD + 8;
                Pair pairCreate = null;
                Integer numValueOf = null;
                bdy bdyVar2 = null;
                boolean z = false;
                while (i4 - iD < iL) {
                    bjzVar.c(i4);
                    int iL2 = bjzVar.l();
                    int iL3 = bjzVar.l();
                    if (iL3 == bcz.ab) {
                        numValueOf = Integer.valueOf(bjzVar.l());
                    } else if (iL3 == bcz.W) {
                        bjzVar.d(4);
                        z = bjzVar.l() == g;
                    } else if (iL3 == bcz.X) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= iL2) {
                                bdyVar = null;
                                break;
                            }
                            bjzVar.c(i5);
                            int iL4 = bjzVar.l();
                            if (bjzVar.l() == bcz.Y) {
                                bjzVar.d(6);
                                boolean z2 = bjzVar.f() == 1;
                                int iF = bjzVar.f();
                                byte[] bArr = new byte[16];
                                bjzVar.a(bArr, 0, 16);
                                bdyVar = new bdy(z2, iF, bArr);
                            } else {
                                i5 += iL4;
                            }
                        }
                        bdyVar2 = bdyVar;
                    }
                    i4 += iL2;
                }
                if (z) {
                    bjq.a(numValueOf != null, "frma atom is mandatory");
                    bjq.a(bdyVar2 != null, "schi->tenc atom is mandatory");
                    pairCreate = Pair.create(numValueOf, bdyVar2);
                }
                if (pairCreate != null) {
                    bdgVar.f2540a[i3] = (bdy) pairCreate.second;
                    return ((Integer) pairCreate.first).intValue();
                }
            }
            iD += iL;
        }
    }

    private static int a(bjz bjzVar) {
        int iF = bjzVar.f();
        int i = iF & 127;
        while ((iF & 128) == 128) {
            iF = bjzVar.f();
            i = (i << 7) | (iF & 127);
        }
        return i;
    }
}
