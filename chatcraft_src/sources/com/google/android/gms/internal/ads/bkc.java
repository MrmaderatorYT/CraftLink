package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class bkc implements bju {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2758a;

    /* renamed from: b, reason: collision with root package name */
    private long f2759b;
    private long c;
    private baf d = baf.f2445a;

    public final void a() {
        if (this.f2758a) {
            return;
        }
        this.c = SystemClock.elapsedRealtime();
        this.f2758a = true;
    }

    public final void b() {
        if (this.f2758a) {
            a(w());
            this.f2758a = false;
        }
    }

    public final void a(long j) {
        this.f2759b = j;
        if (this.f2758a) {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    public final void a(bju bjuVar) {
        a(bjuVar.w());
        this.d = bjuVar.x();
    }

    @Override // com.google.android.gms.internal.ads.bju
    public final long w() {
        long j = this.f2759b;
        if (!this.f2758a) {
            return j;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        if (this.d.f2446b == 1.0f) {
            return j + azo.b(jElapsedRealtime);
        }
        return j + this.d.a(jElapsedRealtime);
    }

    @Override // com.google.android.gms.internal.ads.bju
    public final baf a(baf bafVar) {
        if (this.f2758a) {
            a(w());
        }
        this.d = bafVar;
        return bafVar;
    }

    @Override // com.google.android.gms.internal.ads.bju
    public final baf x() {
        return this.d;
    }
}
