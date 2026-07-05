package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class bkp {

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f2771a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2772b;

    public static bkp a(bjz bjzVar) throws zzfx {
        try {
            bjzVar.d(21);
            int iF = bjzVar.f() & 3;
            int iF2 = bjzVar.f();
            int iD = bjzVar.d();
            int i = 0;
            int i2 = 0;
            while (i < iF2) {
                bjzVar.d(1);
                int iG = bjzVar.g();
                int i3 = i2;
                for (int i4 = 0; i4 < iG; i4++) {
                    int iG2 = bjzVar.g();
                    i3 += iG2 + 4;
                    bjzVar.d(iG2);
                }
                i++;
                i2 = i3;
            }
            bjzVar.c(iD);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < iF2) {
                bjzVar.d(1);
                int iG3 = bjzVar.g();
                int i7 = i6;
                for (int i8 = 0; i8 < iG3; i8++) {
                    int iG4 = bjzVar.g();
                    System.arraycopy(bjw.f2746a, 0, bArr, i7, bjw.f2746a.length);
                    int length = i7 + bjw.f2746a.length;
                    System.arraycopy(bjzVar.f2752a, bjzVar.d(), bArr, length, iG4);
                    i7 = length + iG4;
                    bjzVar.d(iG4);
                }
                i5++;
                i6 = i7;
            }
            return new bkp(i2 == 0 ? null : Collections.singletonList(bArr), iF + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzfx("Error parsing HEVC config", e);
        }
    }

    private bkp(List<byte[]> list, int i) {
        this.f2771a = list;
        this.f2772b = i;
    }
}
