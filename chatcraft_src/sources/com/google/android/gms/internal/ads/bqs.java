package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class bqs extends bqz<brs> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2981a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bqn f2982b;
    private final /* synthetic */ String c;
    private final /* synthetic */ kk d;
    private final /* synthetic */ bqr e;

    bqs(bqr bqrVar, Context context, bqn bqnVar, String str, kk kkVar) {
        this.e = bqrVar;
        this.f2981a = context;
        this.f2982b = bqnVar;
        this.c = str;
        this.d = kkVar;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs a() {
        bqr.b(this.f2981a, "banner");
        return new btt();
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs b() {
        return this.e.f2979a.a(this.f2981a, this.f2982b, this.c, this.d, 1);
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs a(bsd bsdVar) {
        return bsdVar.createBannerAdManager(com.google.android.gms.dynamic.b.a(this.f2981a), this.f2982b, this.c, this.d, 14300000);
    }
}
