package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class bqw extends bqz<brn> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2989a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f2990b;
    private final /* synthetic */ kk c;
    private final /* synthetic */ bqr d;

    bqw(bqr bqrVar, Context context, String str, kk kkVar) {
        this.d = bqrVar;
        this.f2989a = context;
        this.f2990b = str;
        this.c = kkVar;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    protected final /* synthetic */ brn a() {
        bqr.b(this.f2989a, "native_ad");
        return new btp();
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brn b() {
        return this.d.f2980b.a(this.f2989a, this.f2990b, this.c);
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brn a(bsd bsdVar) {
        return bsdVar.createAdLoaderBuilder(com.google.android.gms.dynamic.b.a(this.f2989a), this.f2990b, this.c, 14300000);
    }
}
