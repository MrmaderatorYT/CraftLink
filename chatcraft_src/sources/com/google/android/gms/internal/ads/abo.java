package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

@qj
/* loaded from: classes.dex */
final class abo<V> extends FutureTask<V> implements abl<V> {

    /* renamed from: a, reason: collision with root package name */
    private final abm f1815a;

    abo(Callable<V> callable) {
        super(callable);
        this.f1815a = new abm();
    }

    abo(Runnable runnable, @Nullable V v) {
        super(runnable, v);
        this.f1815a = new abm();
    }

    @Override // com.google.android.gms.internal.ads.abl
    public final void a(Runnable runnable, Executor executor) {
        this.f1815a.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        this.f1815a.a();
    }
}
