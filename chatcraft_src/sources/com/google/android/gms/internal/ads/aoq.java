package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.Arrays;

/* loaded from: classes.dex */
final class aoq {
    private static long a(byte[] bArr, int i) {
        return (((bArr[i + 3] & Constants.DimensionIds.NETHER) << 24) | (bArr[i] & Constants.DimensionIds.NETHER) | ((bArr[i + 1] & Constants.DimensionIds.NETHER) << 8) | ((bArr[i + 2] & Constants.DimensionIds.NETHER) << 16)) & 4294967295L;
    }

    private static long a(byte[] bArr, int i, int i2) {
        return (a(bArr, i) >> i2) & 67108863;
    }

    private static void a(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long jA = a(bArr, 0, 0) & 67108863;
        int i = 2;
        int i2 = 3;
        long jA2 = a(bArr, 3, 2) & 67108611;
        long jA3 = a(bArr, 6, 4) & 67092735;
        long jA4 = a(bArr, 9, 6) & 66076671;
        long jA5 = a(bArr, 12, 8) & 1048575;
        long j = jA2 * 5;
        long j2 = jA3 * 5;
        long j3 = jA4 * 5;
        long j4 = jA5 * 5;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        int i3 = 0;
        while (i3 < bArr2.length) {
            int iMin = Math.min(16, bArr2.length - i3);
            System.arraycopy(bArr2, i3, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, 17, (byte) 0);
            }
            long jA6 = j9 + a(bArr3, 0, 0);
            long jA7 = j5 + a(bArr3, i2, i);
            long jA8 = j6 + a(bArr3, 6, 4);
            long jA9 = j7 + a(bArr3, 9, 6);
            long jA10 = j8 + (a(bArr3, 12, 8) | (bArr3[16] << 24));
            long j10 = (jA6 * jA) + (jA7 * j4) + (jA8 * j3) + (jA9 * j2) + (jA10 * j);
            long j11 = (jA6 * jA2) + (jA7 * jA) + (jA8 * j4) + (jA9 * j3) + (jA10 * j2);
            long j12 = (jA6 * jA3) + (jA7 * jA2) + (jA8 * jA) + (jA9 * j4) + (jA10 * j3);
            long j13 = (jA6 * jA4) + (jA7 * jA3) + (jA8 * jA2) + (jA9 * jA) + (jA10 * j4);
            long j14 = j11 + (j10 >> 26);
            long j15 = j12 + (j14 >> 26);
            long j16 = j13 + (j15 >> 26);
            long j17 = (jA6 * jA5) + (jA7 * jA4) + (jA8 * jA3) + (jA9 * jA2) + (jA10 * jA) + (j16 >> 26);
            long j18 = (j10 & 67108863) + ((j17 >> 26) * 5);
            j5 = (j14 & 67108863) + (j18 >> 26);
            i3 += 16;
            j6 = j15 & 67108863;
            j7 = j16 & 67108863;
            j8 = j17 & 67108863;
            j9 = j18 & 67108863;
            i = 2;
            i2 = 3;
        }
        long j19 = j6 + (j5 >> 26);
        long j20 = j19 & 67108863;
        long j21 = j7 + (j19 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j8 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j9 + ((j23 >> 26) * 5);
        long j26 = j25 & 67108863;
        long j27 = (j5 & 67108863) + (j25 >> 26);
        long j28 = j26 + 5;
        long j29 = j28 & 67108863;
        long j30 = (j28 >> 26) + j27;
        long j31 = j20 + (j30 >> 26);
        long j32 = j22 + (j31 >> 26);
        long j33 = j32 & 67108863;
        long j34 = (j24 + (j32 >> 26)) - 67108864;
        long j35 = j34 >> 63;
        long j36 = j26 & j35;
        long j37 = j27 & j35;
        long j38 = j20 & j35;
        long j39 = j22 & j35;
        long j40 = j24 & j35;
        long j41 = j35 ^ (-1);
        long j42 = (j30 & 67108863 & j41) | j37;
        long j43 = (j31 & 67108863 & j41) | j38;
        long j44 = (j33 & j41) | j39;
        long j45 = (j34 & j41) | j40;
        long j46 = ((j42 << 26) | j36 | (j29 & j41)) & 4294967295L;
        long j47 = ((j42 >> 6) | (j43 << 20)) & 4294967295L;
        long j48 = ((j43 >> 12) | (j44 << 14)) & 4294967295L;
        long j49 = ((j44 >> 18) | (j45 << 8)) & 4294967295L;
        long jA11 = j46 + a(bArr, 16);
        long j50 = jA11 & 4294967295L;
        long jA12 = j47 + a(bArr, 20) + (jA11 >> 32);
        long j51 = jA12 & 4294967295L;
        long jA13 = j48 + a(bArr, 24) + (jA12 >> 32);
        long j52 = jA13 & 4294967295L;
        long jA14 = (j49 + a(bArr, 28) + (jA13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        a(bArr4, j50, 0);
        a(bArr4, j51, 4);
        a(bArr4, j52, 8);
        a(bArr4, jA14, 12);
        return bArr4;
    }
}
