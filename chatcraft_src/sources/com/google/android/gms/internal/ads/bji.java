package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class bji implements bjm {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f2735a;

    /* renamed from: b, reason: collision with root package name */
    private bjk<? extends bjl> f2736b;
    private IOException c;

    public bji(String str) {
        this.f2735a = bkg.a(str);
    }

    public final <T extends bjl> long a(T t, bjj<T> bjjVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        bjq.b(looperMyLooper != null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new bjk(this, looperMyLooper, t, bjjVar, i, jElapsedRealtime).a(0L);
        return jElapsedRealtime;
    }

    public final boolean a() {
        return this.f2736b != null;
    }

    public final void b() {
        this.f2736b.a(false);
    }

    public final void a(Runnable runnable) {
        if (this.f2736b != null) {
            this.f2736b.a(true);
        }
        if (runnable != null) {
            this.f2735a.execute(runnable);
        }
        this.f2735a.shutdown();
    }

    @Override // com.google.android.gms.internal.ads.bjm
    public final void c() throws IOException {
        if (this.c != null) {
            throw this.c;
        }
        if (this.f2736b != null) {
            this.f2736b.a(this.f2736b.f2737a);
        }
    }

    public final void a(int i) throws IOException {
        if (this.c != null) {
            throw this.c;
        }
        if (this.f2736b != null) {
            this.f2736b.a(this.f2736b.f2737a);
        }
    }
}
