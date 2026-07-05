package io.netty.util.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: AbstractEventExecutorGroup.java */
/* loaded from: classes.dex */
public abstract class b implements l {
    @Override // io.netty.util.concurrent.l, java.util.concurrent.ExecutorService
    @Deprecated
    public abstract void shutdown();

    @Override // java.util.concurrent.ExecutorService
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p<?> submit(Runnable runnable) {
        return c().submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public <T> p<T> submit(Runnable runnable, T t) {
        return c().submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public <T> p<T> submit(Callable<T> callable) {
        return c().submit((Callable) callable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ac<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return c().schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public <V> ac<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return c().schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ac<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return c().scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return c().scheduleWithFixedDelay(runnable, j, j2, timeUnit);
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

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return c().invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return c().invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) c().invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) c().invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c().execute(runnable);
    }
}
