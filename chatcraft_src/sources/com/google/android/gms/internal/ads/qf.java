package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* loaded from: classes.dex */
final class qf implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Thread.UncaughtExceptionHandler f3392a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ qd f3393b;

    qf(qd qdVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f3393b = qdVar;
        this.f3392a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.f3393b.a(thread, th);
                if (this.f3392a != null) {
                    this.f3392a.uncaughtException(thread, th);
                }
            } catch (Throwable unused) {
                aan.c("AdMob exception reporter failed reporting the exception.");
                if (this.f3392a != null) {
                    this.f3392a.uncaughtException(thread, th);
                }
            }
        } catch (Throwable th2) {
            if (this.f3392a != null) {
                this.f3392a.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
