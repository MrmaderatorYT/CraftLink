package com.crashlytics.android.a;

/* compiled from: RetryManager.java */
/* loaded from: classes.dex */
class v {

    /* renamed from: a, reason: collision with root package name */
    long f1286a;

    /* renamed from: b, reason: collision with root package name */
    private io.fabric.sdk.android.services.concurrency.a.e f1287b;

    public v(io.fabric.sdk.android.services.concurrency.a.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.f1287b = eVar;
    }

    public boolean a(long j) {
        return j - this.f1286a >= this.f1287b.a() * 1000000;
    }

    public void b(long j) {
        this.f1286a = j;
        this.f1287b = this.f1287b.b();
    }

    public void a() {
        this.f1286a = 0L;
        this.f1287b = this.f1287b.c();
    }
}
