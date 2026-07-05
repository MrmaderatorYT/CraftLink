package com.google.android.gms.ads.internal;

import android.os.Handler;

/* loaded from: classes.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f1525a;

    public ap(Handler handler) {
        this.f1525a = handler;
    }

    public final void a(Runnable runnable) {
        this.f1525a.removeCallbacks(runnable);
    }

    public final boolean a(Runnable runnable, long j) {
        return this.f1525a.postDelayed(runnable, j);
    }
}
