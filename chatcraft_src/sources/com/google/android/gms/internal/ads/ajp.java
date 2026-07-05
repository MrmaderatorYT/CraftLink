package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class ajp<P> {

    /* renamed from: a, reason: collision with root package name */
    private final P f2019a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2020b;
    private final amp c;
    private final ani d;

    public ajp(P p, byte[] bArr, amp ampVar, ani aniVar) {
        this.f2019a = p;
        this.f2020b = Arrays.copyOf(bArr, bArr.length);
        this.c = ampVar;
        this.d = aniVar;
    }

    public final P a() {
        return this.f2019a;
    }

    public final byte[] b() {
        if (this.f2020b == null) {
            return null;
        }
        return Arrays.copyOf(this.f2020b, this.f2020b.length);
    }
}
