package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@qj
/* loaded from: classes.dex */
final class abi<T> implements abl<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f1807a;

    /* renamed from: b, reason: collision with root package name */
    private final abm f1808b = new abm();

    abi(Throwable th) {
        this.f1807a = th;
        this.f1808b.a();
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
    public final T get() throws ExecutionException {
        throw new ExecutionException(this.f1807a);
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.f1807a);
    }

    @Override // com.google.android.gms.internal.ads.abl
    public final void a(Runnable runnable, Executor executor) {
        this.f1808b.a(runnable, executor);
    }
}
