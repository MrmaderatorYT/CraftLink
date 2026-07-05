package io.netty.channel;

import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPerChannelEventLoopGroup.java */
/* loaded from: classes.dex */
public class ba extends io.netty.util.concurrent.b implements al {

    /* renamed from: a, reason: collision with root package name */
    final Executor f4528a;

    /* renamed from: b, reason: collision with root package name */
    final Set<ak> f4529b;
    final Queue<ak> c;
    private final Object[] d;
    private final int e;
    private final ChannelException f;
    private volatile boolean g;
    private final io.netty.util.concurrent.y<?> h;
    private final io.netty.util.concurrent.q<Object> i;

    protected ba() {
        this(0);
    }

    protected ba(int i) {
        this(i, Executors.defaultThreadFactory(), new Object[0]);
    }

    protected ba(int i, ThreadFactory threadFactory, Object... objArr) {
        this(i, new io.netty.util.concurrent.ag(threadFactory), objArr);
    }

    protected ba(int i, Executor executor, Object... objArr) {
        this.f4529b = Collections.newSetFromMap(io.netty.util.a.l.k());
        this.c = new ConcurrentLinkedQueue();
        this.h = new io.netty.util.concurrent.h(io.netty.util.concurrent.t.f4748a);
        this.i = new io.netty.util.concurrent.q<Object>() { // from class: io.netty.channel.ba.1
            @Override // io.netty.util.concurrent.r
            public void operationComplete(io.netty.util.concurrent.p<Object> pVar) {
                if (ba.this.isTerminated()) {
                    ba.this.h.b((io.netty.util.concurrent.y) null);
                }
            }
        };
        if (i < 0) {
            throw new IllegalArgumentException(String.format("maxChannels: %d (expected: >= 0)", Integer.valueOf(i)));
        }
        if (executor == null) {
            throw new NullPointerException("executor");
        }
        if (objArr == null) {
            this.d = io.netty.util.a.b.c;
        } else {
            this.d = (Object[]) objArr.clone();
        }
        this.e = i;
        this.f4528a = executor;
        this.f = (ChannelException) io.netty.util.a.s.a(new ChannelException("too many channels (max: " + i + ')'), ba.class, "nextChild()");
    }

    protected ak a(Object... objArr) {
        return new az(this);
    }

    @Override // java.lang.Iterable
    public Iterator<io.netty.util.concurrent.j> iterator() {
        return new io.netty.util.a.o(this.f4529b.iterator());
    }

    @Override // io.netty.util.concurrent.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ak c() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.concurrent.l
    public io.netty.util.concurrent.p<?> a(long j, long j2, TimeUnit timeUnit) {
        this.g = true;
        Iterator<ak> it = this.f4529b.iterator();
        while (it.hasNext()) {
            it.next().a(j, j2, timeUnit);
        }
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            it2.next().a(j, j2, timeUnit);
        }
        if (isTerminated()) {
            this.h.b((io.netty.util.concurrent.y<?>) null);
        }
        return C_();
    }

    @Override // io.netty.util.concurrent.l
    public io.netty.util.concurrent.p<?> C_() {
        return this.h;
    }

    @Override // io.netty.util.concurrent.b, io.netty.util.concurrent.l, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        this.g = true;
        Iterator<ak> it = this.f4529b.iterator();
        while (it.hasNext()) {
            it.next().shutdown();
        }
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            it2.next().shutdown();
        }
        if (isTerminated()) {
            this.h.b((io.netty.util.concurrent.y<?>) null);
        }
    }

    @Override // io.netty.util.concurrent.l
    public boolean D_() {
        Iterator<ak> it = this.f4529b.iterator();
        while (it.hasNext()) {
            if (!it.next().D_()) {
                return false;
            }
        }
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            if (!it2.next().D_()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        Iterator<ak> it = this.f4529b.iterator();
        while (it.hasNext()) {
            if (!it.next().isShutdown()) {
                return false;
            }
        }
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        Iterator<ak> it = this.f4529b.iterator();
        while (it.hasNext()) {
            if (!it.next().isTerminated()) {
                return false;
            }
        }
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        long jNanoTime;
        long jNanoTime2;
        long jNanoTime3 = System.nanoTime() + timeUnit.toNanos(j);
        for (ak akVar : this.f4529b) {
            do {
                jNanoTime2 = jNanoTime3 - System.nanoTime();
                if (jNanoTime2 <= 0) {
                    return isTerminated();
                }
            } while (!akVar.awaitTermination(jNanoTime2, TimeUnit.NANOSECONDS));
        }
        for (ak akVar2 : this.c) {
            do {
                jNanoTime = jNanoTime3 - System.nanoTime();
                if (jNanoTime <= 0) {
                    return isTerminated();
                }
            } while (!akVar2.awaitTermination(jNanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }

    @Override // io.netty.channel.al
    public h a(d dVar) {
        if (dVar == null) {
            throw new NullPointerException("channel");
        }
        try {
            ak akVarE = e();
            return akVarE.a((z) new af(dVar, akVarE));
        } catch (Throwable th) {
            return new am(dVar, io.netty.util.concurrent.t.f4748a, th);
        }
    }

    @Override // io.netty.channel.al
    public h a(z zVar) {
        try {
            return e().a(zVar);
        } catch (Throwable th) {
            zVar.c(th);
            return zVar;
        }
    }

    private ak e() {
        if (this.g) {
            throw new RejectedExecutionException("shutting down");
        }
        ak akVarPoll = this.c.poll();
        if (akVarPoll == null) {
            if (this.e > 0 && this.f4529b.size() >= this.e) {
                throw this.f;
            }
            akVarPoll = a(this.d);
            akVarPoll.C_().b(this.i);
        }
        this.f4529b.add(akVarPoll);
        return akVarPoll;
    }
}
