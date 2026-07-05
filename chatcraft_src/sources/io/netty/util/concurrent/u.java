package io.netty.util.concurrent;

import io.netty.util.concurrent.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MultithreadEventExecutorGroup.java */
/* loaded from: classes.dex */
public abstract class u extends b {

    /* renamed from: a, reason: collision with root package name */
    private final j[] f4753a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<j> f4754b;
    private final AtomicInteger c;
    private final y<?> d;
    private final k.a e;

    protected abstract j b(Executor executor, Object... objArr);

    protected u(int i, Executor executor, Object... objArr) {
        this(i, executor, f.f4728a, objArr);
    }

    protected u(int i, Executor executor, k kVar, Object... objArr) {
        this.c = new AtomicInteger();
        this.d = new h(t.f4748a);
        int i2 = 0;
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("nThreads: %d (expected: > 0)", Integer.valueOf(i)));
        }
        executor = executor == null ? new ag(a()) : executor;
        this.f4753a = new j[i];
        for (int i3 = 0; i3 < i; i3++) {
            try {
                try {
                    this.f4753a[i3] = b(executor, objArr);
                } catch (Exception e) {
                    throw new IllegalStateException("failed to create a child event loop", e);
                }
            } catch (Throwable th) {
                for (int i4 = 0; i4 < i3; i4++) {
                    this.f4753a[i4].l();
                }
                while (i2 < i3) {
                    j jVar = this.f4753a[i2];
                    while (!jVar.isTerminated()) {
                        try {
                            jVar.awaitTermination(2147483647L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw th;
                        }
                    }
                    i2++;
                }
                throw th;
            }
        }
        this.e = kVar.a(this.f4753a);
        q<Object> qVar = new q<Object>() { // from class: io.netty.util.concurrent.u.1
            @Override // io.netty.util.concurrent.r
            public void operationComplete(p<Object> pVar) {
                if (u.this.c.incrementAndGet() == u.this.f4753a.length) {
                    u.this.d.a(null);
                }
            }
        };
        j[] jVarArr = this.f4753a;
        int length = jVarArr.length;
        while (i2 < length) {
            jVarArr[i2].C_().b(qVar);
            i2++;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f4753a.length);
        Collections.addAll(linkedHashSet, this.f4753a);
        this.f4754b = Collections.unmodifiableSet(linkedHashSet);
    }

    protected ThreadFactory a() {
        return new i(getClass());
    }

    @Override // io.netty.util.concurrent.l
    public j c() {
        return this.e.a();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.f4754b.iterator();
    }

    @Override // io.netty.util.concurrent.l
    public p<?> a(long j, long j2, TimeUnit timeUnit) {
        for (j jVar : this.f4753a) {
            jVar.a(j, j2, timeUnit);
        }
        return C_();
    }

    @Override // io.netty.util.concurrent.l
    public p<?> C_() {
        return this.d;
    }

    @Override // io.netty.util.concurrent.b, io.netty.util.concurrent.l, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        for (j jVar : this.f4753a) {
            jVar.shutdown();
        }
    }

    @Override // io.netty.util.concurrent.l
    public boolean D_() {
        for (j jVar : this.f4753a) {
            if (!jVar.D_()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        for (j jVar : this.f4753a) {
            if (!jVar.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        for (j jVar : this.f4753a) {
            if (!jVar.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        long jNanoTime;
        long jNanoTime2 = System.nanoTime() + timeUnit.toNanos(j);
        loop0: for (j jVar : this.f4753a) {
            do {
                jNanoTime = jNanoTime2 - System.nanoTime();
                if (jNanoTime <= 0) {
                    break loop0;
                }
            } while (!jVar.awaitTermination(jNanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }
}
