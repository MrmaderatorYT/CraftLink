package io.netty.util.concurrent;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: GlobalEventExecutor.java */
/* loaded from: classes.dex */
public final class t extends d {
    volatile Thread g;
    private static final io.netty.util.a.b.c h = io.netty.util.a.b.d.a((Class<?>) t.class);
    private static final long i = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: a, reason: collision with root package name */
    public static final t f4748a = new t();

    /* renamed from: b, reason: collision with root package name */
    final BlockingQueue<Runnable> f4749b = new LinkedBlockingQueue();
    final ad<Void> e = new ad<>(this, Executors.callable(new Runnable() { // from class: io.netty.util.concurrent.t.1
        @Override // java.lang.Runnable
        public void run() {
        }
    }, null), ad.a(i), -i);
    final ThreadFactory f = new i(i.a(getClass()), false, 5, null);
    private final a j = new a();
    private final AtomicBoolean k = new AtomicBoolean();
    private final p<?> l = new m(this, new UnsupportedOperationException());

    @Override // io.netty.util.concurrent.l
    public boolean D_() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    private t() {
        o().add(this.e);
    }

    Runnable a() throws InterruptedException {
        Runnable runnablePoll;
        BlockingQueue<Runnable> blockingQueue = this.f4749b;
        do {
            ad<?> adVarQ = q();
            if (adVarQ == null) {
                try {
                    return blockingQueue.take();
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            long jF = adVarQ.f();
            if (jF > 0) {
                try {
                    runnablePoll = blockingQueue.poll(jF, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused2) {
                    return null;
                }
            } else {
                runnablePoll = blockingQueue.poll();
            }
            if (runnablePoll == null) {
                f();
                runnablePoll = blockingQueue.poll();
            }
        } while (runnablePoll == null);
        return runnablePoll;
    }

    private void f() {
        long jN = d.n();
        Runnable runnableA = a(jN);
        while (runnableA != null) {
            this.f4749b.add(runnableA);
            runnableA = a(jN);
        }
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        this.f4749b.add(runnable);
    }

    @Override // io.netty.util.concurrent.j
    public boolean a(Thread thread) {
        return thread == this.g;
    }

    @Override // io.netty.util.concurrent.l
    public p<?> a(long j, long j2, TimeUnit timeUnit) {
        return C_();
    }

    @Override // io.netty.util.concurrent.l
    public p<?> C_() {
        return this.l;
    }

    @Override // io.netty.util.concurrent.a, java.util.concurrent.ExecutorService, io.netty.util.concurrent.l
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        a(runnable);
        if (k()) {
            return;
        }
        g();
    }

    private void g() {
        if (this.k.compareAndSet(false, true)) {
            Thread threadNewThread = this.f.newThread(this.j);
            this.g = threadNewThread;
            threadNewThread.start();
        }
    }

    /* compiled from: GlobalEventExecutor.java */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f4751a = !t.class.desiredAssertionStatus();

        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (true) {
                Runnable runnableA = t.this.a();
                if (runnableA != null) {
                    try {
                        runnableA.run();
                    } catch (Throwable th) {
                        t.h.b("Unexpected exception from the global event executor: ", th);
                    }
                    if (runnableA != t.this.e) {
                        continue;
                    }
                }
                Queue<ad<?>> queue = t.this.c;
                if (t.this.f4749b.isEmpty() && (queue == null || queue.size() == 1)) {
                    boolean zCompareAndSet = t.this.k.compareAndSet(true, false);
                    if (!f4751a && !zCompareAndSet) {
                        throw new AssertionError();
                    }
                    if ((t.this.f4749b.isEmpty() && (queue == null || queue.size() == 1)) || !t.this.k.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }
}
