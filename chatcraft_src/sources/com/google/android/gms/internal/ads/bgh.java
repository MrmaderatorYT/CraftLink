package com.google.android.gms.internal.ads;

import android.util.Log;

/* loaded from: classes.dex */
final class bgh implements bgl {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2639a;

    /* renamed from: b, reason: collision with root package name */
    private final bfw[] f2640b;

    public bgh(int[] iArr, bfw[] bfwVarArr) {
        this.f2639a = iArr;
        this.f2640b = bfwVarArr;
    }

    @Override // com.google.android.gms.internal.ads.bgl
    public final bcm a(int i, int i2) {
        for (int i3 = 0; i3 < this.f2639a.length; i3++) {
            if (i2 == this.f2639a[i3]) {
                return this.f2640b[i3];
            }
        }
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unmatched track of type: ");
        sb.append(i2);
        Log.e("BaseMediaChunkOutput", sb.toString());
        return new bcb();
    }

    public final int[] a() {
        int[] iArr = new int[this.f2640b.length];
        for (int i = 0; i < this.f2640b.length; i++) {
            if (this.f2640b[i] != null) {
                iArr[i] = this.f2640b[i].a();
            }
        }
        return iArr;
    }

    public final void a(long j) {
        for (bfw bfwVar : this.f2640b) {
            if (bfwVar != null) {
                bfwVar.a(j);
            }
        }
    }
}
