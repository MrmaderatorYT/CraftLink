package com.crashlytics.android.c;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* loaded from: classes.dex */
class r implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final a f1423a;

    /* renamed from: b, reason: collision with root package name */
    private final b f1424b;
    private final boolean c;
    private final Thread.UncaughtExceptionHandler d;
    private final AtomicBoolean e = new AtomicBoolean(false);

    /* compiled from: CrashlyticsUncaughtExceptionHandler.java */
    interface a {
        void a(b bVar, Thread thread, Throwable th, boolean z);
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler.java */
    interface b {
        io.fabric.sdk.android.services.e.t a();
    }

    public r(a aVar, b bVar, boolean z, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1423a = aVar;
        this.f1424b = bVar;
        this.c = z;
        this.d = uncaughtExceptionHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.atomic.AtomicBoolean] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.e.set(true);
        try {
            try {
                this.f1423a.a(this.f1424b, thread, th, this.c);
            } catch (Exception e) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
            }
        } finally {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.d.uncaughtException(thread, th);
            this.e.set(false);
        }
    }

    boolean a() {
        return this.e.get();
    }
}
