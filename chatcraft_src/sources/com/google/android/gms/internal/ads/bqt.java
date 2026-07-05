package com.google.android.gms.internal.ads;

import android.app.Activity;

/* loaded from: classes.dex */
final class bqt extends bqz<nm> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2983a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bqr f2984b;

    bqt(bqr bqrVar, Activity activity) {
        this.f2984b = bqrVar;
        this.f2983a = activity;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    protected final /* synthetic */ nm a() {
        bqr.b(this.f2983a, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ nm b() {
        return this.f2984b.g.a(this.f2983a);
    }

    @Override // com.google.android.gms.internal.ads.bqz
    public final /* synthetic */ nm a(bsd bsdVar) {
        return bsdVar.createAdOverlay(com.google.android.gms.dynamic.b.a(this.f2983a));
    }
}
