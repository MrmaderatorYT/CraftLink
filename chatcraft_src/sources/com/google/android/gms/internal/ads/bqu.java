package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class bqu extends bqz<brs> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2985a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bqn f2986b;
    private final /* synthetic */ String c;
    private final /* synthetic */ bqr d;

    bqu(bqr bqrVar, Context context, bqn bqnVar, String str) {
        this.d = bqrVar;
        this.f2985a = context;
        this.f2986b = bqnVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs a() {
        bqr.b(this.f2985a, "search");
        return new btt();
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs b() {
        return this.d.f2979a.a(this.f2985a, this.f2986b, this.c, null, 3);
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ brs a(bsd bsdVar) {
        return bsdVar.createSearchAdManager(com.google.android.gms.dynamic.b.a(this.f2985a), this.f2986b, this.c, 14300000);
    }
}
