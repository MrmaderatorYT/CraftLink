package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class bkj {

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f2763a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2764b;
    public final float c;
    private final int d;
    private final int e;

    public static bkj a(bjz bjzVar) {
        int i;
        int i2;
        float f;
        try {
            bjzVar.d(4);
            int iF = (bjzVar.f() & 3) + 1;
            if (iF == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iF2 = bjzVar.f() & 31;
            for (int i3 = 0; i3 < iF2; i3++) {
                arrayList.add(b(bjzVar));
            }
            int iF3 = bjzVar.f();
            for (int i4 = 0; i4 < iF3; i4++) {
                arrayList.add(b(bjzVar));
            }
            if (iF2 > 0) {
                bjx bjxVarA = bjw.a((byte[]) arrayList.get(0), iF, ((byte[]) arrayList.get(0)).length);
                int i5 = bjxVarA.f2748a;
                int i6 = bjxVarA.f2749b;
                f = bjxVarA.c;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new bkj(arrayList, iF, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzfx("Error parsing AVC config", e);
        }
    }

    private bkj(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f2763a = list;
        this.f2764b = i;
        this.d = i2;
        this.e = i3;
        this.c = f;
    }

    private static byte[] b(bjz bjzVar) {
        int iG = bjzVar.g();
        int iD = bjzVar.d();
        bjzVar.d(iG);
        return bjr.a(bjzVar.f2752a, iD, iG);
    }
}
