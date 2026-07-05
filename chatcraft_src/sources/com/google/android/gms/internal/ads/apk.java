package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class apk {
    static int a(byte[] bArr, int i, apl aplVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return a(b2, bArr, i2, aplVar);
        }
        aplVar.f2145a = b2;
        return i2;
    }

    static int a(int i, byte[] bArr, int i2, apl aplVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            aplVar.f2145a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & 127) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            aplVar.f2145a = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            aplVar.f2145a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            aplVar.f2145a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                aplVar.f2145a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int b(byte[] bArr, int i, apl aplVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            aplVar.f2146b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & 127) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & 127) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        aplVar.f2146b = j2;
        return i3;
    }

    static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & Constants.DimensionIds.NETHER) << 24) | (bArr[i] & Constants.DimensionIds.NETHER) | ((bArr[i + 1] & Constants.DimensionIds.NETHER) << 8) | ((bArr[i + 2] & Constants.DimensionIds.NETHER) << 16);
    }

    static long b(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(b(bArr, i));
    }

    static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    static int c(byte[] bArr, int i, apl aplVar) {
        int iA = a(bArr, i, aplVar);
        int i2 = aplVar.f2145a;
        if (i2 < 0) {
            throw zzbrl.b();
        }
        if (i2 == 0) {
            aplVar.c = BuildConfig.FLAVOR;
            return iA;
        }
        aplVar.c = new String(bArr, iA, i2, ara.f2199a);
        return iA + i2;
    }

    static int d(byte[] bArr, int i, apl aplVar) {
        int iA = a(bArr, i, aplVar);
        int i2 = aplVar.f2145a;
        if (i2 < 0) {
            throw zzbrl.b();
        }
        if (i2 == 0) {
            aplVar.c = BuildConfig.FLAVOR;
            return iA;
        }
        aplVar.c = atx.b(bArr, iA, i2);
        return iA + i2;
    }

    static int e(byte[] bArr, int i, apl aplVar) {
        int iA = a(bArr, i, aplVar);
        int i2 = aplVar.f2145a;
        if (i2 < 0) {
            throw zzbrl.b();
        }
        if (i2 > bArr.length - iA) {
            throw zzbrl.a();
        }
        if (i2 == 0) {
            aplVar.c = apo.f2149a;
            return iA;
        }
        aplVar.c = apo.a(bArr, iA, i2);
        return iA + i2;
    }

    static int a(int i, byte[] bArr, int i2, int i3, arf<?> arfVar, apl aplVar) {
        aqz aqzVar = (aqz) arfVar;
        int iA = a(bArr, i2, aplVar);
        aqzVar.c(aplVar.f2145a);
        while (iA < i3) {
            int iA2 = a(bArr, iA, aplVar);
            if (i != aplVar.f2145a) {
                break;
            }
            iA = a(bArr, iA2, aplVar);
            aqzVar.c(aplVar.f2145a);
        }
        return iA;
    }

    static int a(byte[] bArr, int i, arf<?> arfVar, apl aplVar) {
        aqz aqzVar = (aqz) arfVar;
        int iA = a(bArr, i, aplVar);
        int i2 = aplVar.f2145a + iA;
        while (iA < i2) {
            iA = a(bArr, iA, aplVar);
            aqzVar.c(aplVar.f2145a);
        }
        if (iA == i2) {
            return iA;
        }
        throw zzbrl.a();
    }

    static int a(int i, byte[] bArr, int i2, int i3, atp atpVar, apl aplVar) {
        if ((i >>> 3) == 0) {
            throw zzbrl.d();
        }
        int i4 = i & 7;
        if (i4 != 5) {
            switch (i4) {
                case 0:
                    int iB = b(bArr, i2, aplVar);
                    atpVar.a(i, Long.valueOf(aplVar.f2146b));
                    return iB;
                case 1:
                    atpVar.a(i, Long.valueOf(b(bArr, i2)));
                    return i2 + 8;
                case 2:
                    int iA = a(bArr, i2, aplVar);
                    int i5 = aplVar.f2145a;
                    if (i5 < 0) {
                        throw zzbrl.b();
                    }
                    if (i5 > bArr.length - iA) {
                        throw zzbrl.a();
                    }
                    if (i5 == 0) {
                        atpVar.a(i, apo.f2149a);
                    } else {
                        atpVar.a(i, apo.a(bArr, iA, i5));
                    }
                    return iA + i5;
                case 3:
                    atp atpVarB = atp.b();
                    int i6 = (i & (-8)) | 4;
                    int i7 = 0;
                    while (true) {
                        if (i2 < i3) {
                            int iA2 = a(bArr, i2, aplVar);
                            int i8 = aplVar.f2145a;
                            if (i8 != i6) {
                                i7 = i8;
                                i2 = a(i8, bArr, iA2, i3, atpVarB, aplVar);
                            } else {
                                i7 = i8;
                                i2 = iA2;
                            }
                        }
                    }
                    if (i2 > i3 || i7 != i6) {
                        throw zzbrl.h();
                    }
                    atpVar.a(i, atpVarB);
                    return i2;
                default:
                    throw zzbrl.d();
            }
        }
        atpVar.a(i, Integer.valueOf(a(bArr, i2)));
        return i2 + 4;
    }

    static int a(int i, byte[] bArr, int i2, int i3, apl aplVar) {
        if ((i >>> 3) == 0) {
            throw zzbrl.d();
        }
        int i4 = i & 7;
        if (i4 == 5) {
            return i2 + 4;
        }
        switch (i4) {
            case 0:
                return b(bArr, i2, aplVar);
            case 1:
                return i2 + 8;
            case 2:
                return a(bArr, i2, aplVar) + aplVar.f2145a;
            case 3:
                int i5 = (i & (-8)) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = a(bArr, i2, aplVar);
                    i6 = aplVar.f2145a;
                    if (i6 == i5) {
                        if (i2 <= i3 || i6 != i5) {
                            throw zzbrl.h();
                        }
                        return i2;
                    }
                    i2 = a(i6, bArr, i2, i3, aplVar);
                }
                if (i2 <= i3) {
                }
                throw zzbrl.h();
            default:
                throw zzbrl.d();
        }
    }
}
