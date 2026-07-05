package com.google.android.gms.internal.ads;

import android.util.Pair;

/* loaded from: classes.dex */
public final class bjr {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2741a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2742b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> a(byte[] bArr) {
        bjy bjyVar = new bjy(bArr);
        int iA = a(bjyVar);
        int iB = b(bjyVar);
        int iA2 = bjyVar.a(4);
        if (iA == 5 || iA == 29) {
            iB = b(bjyVar);
            if (a(bjyVar) == 22) {
                iA2 = bjyVar.a(4);
            }
        }
        int i = c[iA2];
        bjq.a(i != -1);
        return Pair.create(Integer.valueOf(iB), Integer.valueOf(i));
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[f2741a.length + i2];
        System.arraycopy(f2741a, 0, bArr2, 0, f2741a.length);
        System.arraycopy(bArr, i, bArr2, f2741a.length, i2);
        return bArr2;
    }

    private static int a(bjy bjyVar) {
        int iA = bjyVar.a(5);
        return iA == 31 ? bjyVar.a(6) + 32 : iA;
    }

    private static int b(bjy bjyVar) {
        int iA = bjyVar.a(4);
        if (iA == 15) {
            return bjyVar.a(24);
        }
        bjq.a(iA < 13);
        return f2742b[iA];
    }
}
