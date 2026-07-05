package com.crashlytics.android.c;

import java.io.InputStream;

/* compiled from: CrashlyticsPinningInfoProvider.java */
/* loaded from: classes.dex */
class q implements io.fabric.sdk.android.services.network.f {

    /* renamed from: a, reason: collision with root package name */
    private final ai f1422a;

    @Override // io.fabric.sdk.android.services.network.f
    public long d() {
        return -1L;
    }

    public q(ai aiVar) {
        this.f1422a = aiVar;
    }

    @Override // io.fabric.sdk.android.services.network.f
    public InputStream a() {
        return this.f1422a.a();
    }

    @Override // io.fabric.sdk.android.services.network.f
    public String b() {
        return this.f1422a.b();
    }

    @Override // io.fabric.sdk.android.services.network.f
    public String[] c() {
        return this.f1422a.c();
    }
}
