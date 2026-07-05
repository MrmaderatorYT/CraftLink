package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class abr implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f1818a = new xg(Looper.getMainLooper());

    abr() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.ax.e();
                xn.a(com.google.android.gms.ads.internal.ax.i().l(), th);
                throw th;
            }
        }
        this.f1818a.post(runnable);
    }
}
