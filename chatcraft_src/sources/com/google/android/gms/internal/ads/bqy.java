package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class bqy extends bqz<ty> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2993a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kk f2994b;
    private final /* synthetic */ bqr c;

    bqy(bqr bqrVar, Context context, kk kkVar) {
        this.c = bqrVar;
        this.f2993a = context;
        this.f2994b = kkVar;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    protected final /* synthetic */ ty a() {
        bqr.b(this.f2993a, "rewarded_video");
        return new btw();
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ ty b() {
        return this.c.e.a(this.f2993a, this.f2994b);
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ ty a(bsd bsdVar) {
        return bsdVar.createRewardedVideoAd(com.google.android.gms.dynamic.b.a(this.f2993a), this.f2994b, 14300000);
    }
}
