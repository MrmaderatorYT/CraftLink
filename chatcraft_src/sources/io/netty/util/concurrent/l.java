package io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: EventExecutorGroup.java */
/* loaded from: classes.dex */
public interface l extends Iterable<j>, ScheduledExecutorService {
    p<?> C_();

    boolean D_();

    ac<?> a(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    ac<?> a(Runnable runnable, long j, TimeUnit timeUnit);

    <V> ac<V> a(Callable<V> callable, long j, TimeUnit timeUnit);

    p<?> a(long j, long j2, TimeUnit timeUnit);

    <T> p<T> a(Runnable runnable, T t);

    <T> p<T> a(Callable<T> callable);

    ac<?> b(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    p<?> b(Runnable runnable);

    j c();

    p<?> l();

    @Deprecated
    void shutdown();
}
