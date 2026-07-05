package com.crashlytics.android.c;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: CrashlyticsBackgroundWorker.java */
/* loaded from: classes.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f1357a;

    public j(ExecutorService executorService) {
        this.f1357a = executorService;
    }

    <T> T a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f1357a.submit(callable).get(4L, TimeUnit.SECONDS);
            }
            return this.f1357a.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }

    Future<?> a(final Runnable runnable) {
        try {
            return this.f1357a.submit(new Runnable() { // from class: com.crashlytics.android.c.j.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> b(final Callable<T> callable) {
        try {
            return this.f1357a.submit(new Callable<T>() { // from class: com.crashlytics.android.c.j.2
                @Override // java.util.concurrent.Callable
                public T call() {
                    try {
                        return (T) callable.call();
                    } catch (Exception e) {
                        io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
