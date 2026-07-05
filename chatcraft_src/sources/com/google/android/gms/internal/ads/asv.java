package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
final class asv implements asd {

    /* renamed from: a, reason: collision with root package name */
    private final asf f2239a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2240b;
    private final Object[] c;
    private final int d;

    asv(asf asfVar, String str, Object[] objArr) {
        this.f2239a = asfVar;
        this.f2240b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String d() {
        return this.f2240b;
    }

    final Object[] e() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.asd
    public final asf c() {
        return this.f2239a;
    }

    @Override // com.google.android.gms.internal.ads.asd
    public final int a() {
        return (this.d & 1) == 1 ? aqy.e.h : aqy.e.i;
    }

    @Override // com.google.android.gms.internal.ads.asd
    public final boolean b() {
        return (this.d & 2) == 2;
    }
}
