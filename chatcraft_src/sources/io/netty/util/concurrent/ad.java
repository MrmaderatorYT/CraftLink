package io.netty.util.concurrent;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ScheduledFutureTask.java */
/* loaded from: classes.dex */
final class ad<V> extends z<V> implements ac<V> {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f4717b = !ad.class.desiredAssertionStatus();
    private static final AtomicLong c = new AtomicLong();
    private static final long d = System.nanoTime();
    private final long e;
    private long f;
    private final long g;

    static long c() {
        return System.nanoTime() - d;
    }

    static long a(long j) {
        return c() + j;
    }

    ad(d dVar, Runnable runnable, V v, long j) {
        this(dVar, a(runnable, v), j);
    }

    ad(d dVar, Callable<V> callable, long j, long j2) {
        super(dVar, callable);
        this.e = c.getAndIncrement();
        if (j2 == 0) {
            throw new IllegalArgumentException("period: 0 (expected: != 0)");
        }
        this.f = j;
        this.g = j2;
    }

    ad(d dVar, Callable<V> callable, long j) {
        super(dVar, callable);
        this.e = c.getAndIncrement();
        this.f = j;
        this.g = 0L;
    }

    @Override // io.netty.util.concurrent.h
    protected j b() {
        return super.b();
    }

    public long e() {
        return this.f;
    }

    public long f() {
        return Math.max(0L, e() - c());
    }

    public long b(long j) {
        return Math.max(0L, e() - (j - d));
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.NANOSECONDS);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ad adVar = (ad) delayed;
        long jE = e() - adVar.e();
        if (jE < 0) {
            return -1;
        }
        if (jE > 0) {
            return 1;
        }
        if (this.e < adVar.e) {
            return -1;
        }
        if (this.e != adVar.e) {
            return 1;
        }
        throw new Error();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.concurrent.z, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        if (!f4717b && !b().k()) {
            throw new AssertionError();
        }
        try {
            if (this.g == 0) {
                if (a()) {
                    c((ad<V>) this.f4756a.call());
                    return;
                }
                return;
            }
            if (isCancelled()) {
                return;
            }
            this.f4756a.call();
            if (b().isShutdown()) {
                return;
            }
            long j = this.g;
            if (j > 0) {
                this.f += j;
            } else {
                this.f = c() - j;
            }
            if (isCancelled()) {
                return;
            }
            Queue<ad<?>> queue = ((d) b()).c;
            if (!f4717b && queue == null) {
                throw new AssertionError();
            }
            queue.add(this);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // io.netty.util.concurrent.h, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean zCancel = super.cancel(z);
        if (zCancel) {
            ((d) b()).b((ad<?>) this);
        }
        return zCancel;
    }

    boolean a(boolean z) {
        return super.cancel(z);
    }

    @Override // io.netty.util.concurrent.z, io.netty.util.concurrent.h
    protected StringBuilder t() {
        StringBuilder sbT = super.t();
        sbT.setCharAt(sbT.length() - 1, ',');
        sbT.append(" id: ");
        sbT.append(this.e);
        sbT.append(", deadline: ");
        sbT.append(this.f);
        sbT.append(", period: ");
        sbT.append(this.g);
        sbT.append(')');
        return sbT;
    }
}
