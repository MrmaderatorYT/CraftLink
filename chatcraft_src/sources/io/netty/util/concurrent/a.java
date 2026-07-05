package io.netty.util.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: AbstractEventExecutor.java */
/* loaded from: classes.dex */
public abstract class a extends AbstractExecutorService implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4714a = io.netty.util.a.b.d.a((Class<?>) a.class);

    /* renamed from: b, reason: collision with root package name */
    private final l f4715b;
    private final Collection<j> c;

    public j c() {
        return this;
    }

    @Override // java.util.concurrent.ExecutorService, io.netty.util.concurrent.l
    @Deprecated
    public abstract void shutdown();

    protected a() {
        this(null);
    }

    protected a(l lVar) {
        this.c = Collections.singleton(this);
        this.f4715b = lVar;
    }

    @Override // io.netty.util.concurrent.j
    public boolean k() {
        return a(Thread.currentThread());
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.c.iterator();
    }

    @Override // io.netty.util.concurrent.l
    public p<?> l() {
        return a(2L, 15L, TimeUnit.SECONDS);
    }

    @Override // java.util.concurrent.ExecutorService
    @Deprecated
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }

    @Override // io.netty.util.concurrent.j
    public <V> y<V> m() {
        return new h(this);
    }

    @Override // io.netty.util.concurrent.j
    public <V> p<V> a(V v) {
        return new af(this, v);
    }

    @Override // io.netty.util.concurrent.j
    public <V> p<V> a(Throwable th) {
        return new m(this, th);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: b */
    public p<?> submit(Runnable runnable) {
        return (p) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: a */
    public <T> p<T> submit(Runnable runnable, T t) {
        return (p) super.submit(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: a */
    public <T> p<T> submit(Callable<T> callable) {
        return (p) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new z(this, runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new z(this, callable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: a */
    public ac<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: a */
    public <V> ac<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: a */
    public ac<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: b */
    public ac<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    protected static void c(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            f4714a.c("A task raised an exception. Task: {}", runnable, th);
        }
    }
}
