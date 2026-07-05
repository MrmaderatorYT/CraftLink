package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@qj
/* loaded from: classes.dex */
public final class abk<T> implements abl<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f1809a;

    /* renamed from: b, reason: collision with root package name */
    private final abm f1810b = new abm();

    abk(T t) {
        this.f1809a = t;
        this.f1810b.a();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // java.util.concurrent.Future
    public final T get() {
        return this.f1809a;
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) {
        return this.f1809a;
    }

    @Override // com.google.android.gms.internal.ads.abl
    public final void a(Runnable runnable, Executor executor) {
        this.f1810b.a(runnable, executor);
    }
}
