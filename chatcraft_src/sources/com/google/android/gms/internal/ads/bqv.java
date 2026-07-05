package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class bqv extends bqz<brs> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2987a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bqn f2988b;
    private final /* synthetic */ String c;
    private final /* synthetic */ kk d;
    private final /* synthetic */ bqr e;

    bqv(bqr bqrVar, Context context, bqn bqnVar, String str, kk kkVar) {
        this.e = bqrVar;
        this.f2987a = context;
        this.f2988b = bqnVar;
        this.c = str;
        this.d = kkVar;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs a() {
        bqr.b(this.f2987a, "interstitial");
        return new btt();
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs b() {
        return this.e.f2979a.a(this.f2987a, this.f2988b, this.c, this.d, 2);
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs a(bsd bsdVar) {
        return bsdVar.createInterstitialAdManager(com.google.android.gms.dynamic.b.a(this.f2987a), this.f2988b, this.c, this.d, 14300000);
    }
}
