package io.netty.util.concurrent;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: AbstractScheduledEventExecutor.java */
/* loaded from: classes.dex */
public abstract class d extends a {
    static final /* synthetic */ boolean d = !d.class.desiredAssertionStatus();
    Queue<ad<?>> c;

    protected d() {
    }

    protected d(l lVar) {
        super(lVar);
    }

    protected static long n() {
        return ad.c();
    }

    Queue<ad<?>> o() {
        if (this.c == null) {
            this.c = new PriorityQueue();
        }
        return this.c;
    }

    private static boolean a(Queue<ad<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    protected void p() {
        if (!d && !k()) {
            throw new AssertionError();
        }
        Queue<ad<?>> queue = this.c;
        if (a(queue)) {
            return;
        }
        for (ad adVar : (ad[]) queue.toArray(new ad[queue.size()])) {
            adVar.a(false);
        }
        queue.clear();
    }

    protected final Runnable a(long j) {
        if (!d && !k()) {
            throw new AssertionError();
        }
        Queue<ad<?>> queue = this.c;
        ad<?> adVarPeek = queue == null ? null : queue.peek();
        if (adVarPeek == null || adVarPeek.e() > j) {
            return null;
        }
        queue.remove();
        return adVarPeek;
    }

    final ad<?> q() {
        Queue<ad<?>> queue = this.c;
        if (queue == null) {
            return null;
        }
        return queue.peek();
    }

    protected final boolean r() {
        Queue<ad<?>> queue = this.c;
        ad<?> adVarPeek = queue == null ? null : queue.peek();
        return adVarPeek != null && adVarPeek.e() <= n();
    }

    @Override // io.netty.util.concurrent.a, java.util.concurrent.ScheduledExecutorService
    /* renamed from: a */
    public ac<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        io.netty.util.a.j.a(runnable, "command");
        io.netty.util.a.j.a(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: >= 0)", Long.valueOf(j)));
        }
        return a(new ad(this, runnable, (Object) null, ad.a(timeUnit.toNanos(j))));
    }

    @Override // io.netty.util.concurrent.a, java.util.concurrent.ScheduledExecutorService
    /* renamed from: a */
    public <V> ac<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        io.netty.util.a.j.a(callable, "callable");
        io.netty.util.a.j.a(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: >= 0)", Long.valueOf(j)));
        }
        return a((ad) new ad<>(this, callable, ad.a(timeUnit.toNanos(j))));
    }

    @Override // io.netty.util.concurrent.a, java.util.concurrent.ScheduledExecutorService
    /* renamed from: a */
    public ac<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        io.netty.util.a.j.a(runnable, "command");
        io.netty.util.a.j.a(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j2)));
        }
        return a(new ad(this, Executors.callable(runnable, null), ad.a(timeUnit.toNanos(j)), timeUnit.toNanos(j2)));
    }

    @Override // io.netty.util.concurrent.a, java.util.concurrent.ScheduledExecutorService
    /* renamed from: b */
    public ac<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        io.netty.util.a.j.a(runnable, "command");
        io.netty.util.a.j.a(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j2)));
        }
        return a(new ad(this, Executors.callable(runnable, null), ad.a(timeUnit.toNanos(j)), -timeUnit.toNanos(j2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    <V> ac<V> a(final ad<V> adVar) {
        if (k()) {
            o().add(adVar);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.o().add(adVar);
                }
            });
        }
        return adVar;
    }

    final void b(final ad<?> adVar) {
        if (k()) {
            o().remove(adVar);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.b(adVar);
                }
            });
        }
    }
}
