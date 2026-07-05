package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor.java */
/* loaded from: classes.dex */
public class k extends ThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4286a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b, reason: collision with root package name */
    private static final int f4287b = f4286a + 1;
    private static final int c = (f4286a * 2) + 1;

    <T extends Runnable & b & l & i> k(int i, int i2, long j, TimeUnit timeUnit, c<T> cVar, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, cVar, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & b & l & i> k a(int i, int i2) {
        return new k(i, i2, 1L, TimeUnit.SECONDS, new c(), new a(10));
    }

    public static k a() {
        return a(f4287b, c);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new h(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new h(callable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (j.a(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        l lVar = (l) runnable;
        lVar.b(true);
        lVar.a(th);
        getQueue().d();
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c getQueue() {
        return (c) super.getQueue();
    }

    /* compiled from: PriorityThreadPoolExecutor.java */
    protected static final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final int f4288a;

        public a(int i) {
            this.f4288a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f4288a);
            thread.setName("Queue");
            return thread;
        }
    }
}
