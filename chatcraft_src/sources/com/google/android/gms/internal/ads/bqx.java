package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class bqx extends bqz<bsk> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2991a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bqr f2992b;

    bqx(bqr bqrVar, Context context) {
        this.f2992b = bqrVar;
        this.f2991a = context;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    protected final /* synthetic */ bsk a() {
        bqr.b(this.f2991a, "mobile_ads_settings");
        return new btv();
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ bsk b() {
        return this.f2992b.c.b(this.f2991a);
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ bsk a(bsd bsdVar) {
        return bsdVar.getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.b.a(this.f2991a), 14300000);
    }
}
