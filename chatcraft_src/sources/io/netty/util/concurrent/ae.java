package io.netty.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: SingleThreadEventExecutor.java */
/* loaded from: classes.dex */
public abstract class ae extends d implements v {
    private static final AtomicIntegerFieldUpdater<ae> h;
    private static final AtomicReferenceFieldUpdater<ae, ah> i;
    private static final long z;
    private final Queue<Runnable> j;
    private volatile Thread k;
    private volatile ah l;
    private final Executor m;
    private volatile boolean n;
    private final Semaphore o;
    private final Set<Runnable> p;
    private final boolean q;
    private final int r;
    private final aa s;
    private long t;
    private volatile int u;
    private volatile long v;
    private volatile long w;
    private long x;
    private final y<?> y;
    static final /* synthetic */ boolean f = !ae.class.desiredAssertionStatus();
    static final int e = Math.max(16, io.netty.util.a.q.a("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4718a = io.netty.util.a.b.d.a((Class<?>) ae.class);

    /* renamed from: b, reason: collision with root package name */
    private static final Runnable f4719b = new Runnable() { // from class: io.netty.util.concurrent.ae.1
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private static final Runnable g = new Runnable() { // from class: io.netty.util.concurrent.ae.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };

    protected boolean a(Runnable runnable) {
        return true;
    }

    protected void b() {
    }

    protected abstract void f();

    protected void h() {
    }

    static {
        AtomicIntegerFieldUpdater<ae> atomicIntegerFieldUpdaterB = io.netty.util.a.l.b(ae.class, "state");
        if (atomicIntegerFieldUpdaterB == null) {
            atomicIntegerFieldUpdaterB = AtomicIntegerFieldUpdater.newUpdater(ae.class, "u");
        }
        h = atomicIntegerFieldUpdaterB;
        AtomicReferenceFieldUpdater<ae, ah> atomicReferenceFieldUpdaterA = io.netty.util.a.l.a(ae.class, "threadProperties");
        if (atomicReferenceFieldUpdaterA == null) {
            atomicReferenceFieldUpdaterA = AtomicReferenceFieldUpdater.newUpdater(ae.class, ah.class, "l");
        }
        i = atomicReferenceFieldUpdaterA;
        z = TimeUnit.SECONDS.toNanos(1L);
    }

    protected ae(l lVar, Executor executor, boolean z2, int i2, aa aaVar) {
        super(lVar);
        this.o = new Semaphore(0);
        this.p = new LinkedHashSet();
        this.u = 1;
        this.y = new h(t.f4748a);
        this.q = z2;
        this.r = Math.max(16, i2);
        this.m = (Executor) io.netty.util.a.j.a(executor, "executor");
        this.j = a(this.r);
        this.s = (aa) io.netty.util.a.j.a(aaVar, "rejectedHandler");
    }

    protected Queue<Runnable> a(int i2) {
        return new LinkedBlockingQueue(i2);
    }

    protected Runnable i() {
        if (f || k()) {
            return a(this.j);
        }
        throw new AssertionError();
    }

    protected final Runnable a(Queue<Runnable> queue) {
        Runnable runnablePoll;
        do {
            runnablePoll = queue.poll();
        } while (runnablePoll == f4719b);
        return runnablePoll;
    }

    protected Runnable s() {
        Runnable runnable;
        if (!f && !k()) {
            throw new AssertionError();
        }
        if (!(this.j instanceof BlockingQueue)) {
            throw new UnsupportedOperationException();
        }
        BlockingQueue blockingQueue = (BlockingQueue) this.j;
        do {
            ad<?> adVarQ = q();
            if (adVarQ == null) {
                try {
                    Runnable runnable2 = (Runnable) blockingQueue.take();
                    try {
                        if (runnable2 != f4719b) {
                            return runnable2;
                        }
                    } catch (InterruptedException unused) {
                        return runnable2;
                    }
                } catch (InterruptedException unused2) {
                }
                return null;
            }
            long jF = adVarQ.f();
            if (jF > 0) {
                try {
                    runnable = (Runnable) blockingQueue.poll(jF, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused3) {
                    return null;
                }
            } else {
                runnable = null;
            }
            if (runnable == null) {
                a();
                runnable = (Runnable) blockingQueue.poll();
            }
        } while (runnable == null);
        return runnable;
    }

    private boolean a() {
        long jN = d.n();
        Runnable runnableA = a(jN);
        while (runnableA != null) {
            if (!this.j.offer(runnableA)) {
                o().add((ad) runnableA);
                return false;
            }
            runnableA = a(jN);
        }
        return true;
    }

    protected boolean d() {
        if (f || k()) {
            return !this.j.isEmpty();
        }
        throw new AssertionError();
    }

    public int e() {
        return this.j.size();
    }

    protected void d(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (e(runnable)) {
            return;
        }
        g(runnable);
    }

    final boolean e(Runnable runnable) {
        if (isShutdown()) {
            w();
        }
        return this.j.offer(runnable);
    }

    protected boolean f(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        return this.j.remove(runnable);
    }

    protected boolean t() {
        boolean zA;
        if (!f && !k()) {
            throw new AssertionError();
        }
        boolean z2 = false;
        do {
            zA = a();
            if (b(this.j)) {
                z2 = true;
            }
        } while (!zA);
        if (z2) {
            this.t = ad.c();
        }
        b();
        return z2;
    }

    protected final boolean b(Queue<Runnable> queue) {
        Runnable runnableA = a(queue);
        if (runnableA == null) {
            return false;
        }
        do {
            c(runnableA);
            runnableA = a(queue);
        } while (runnableA != null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean b(long r8) {
        /*
            r7 = this;
            r7.a()
            java.lang.Runnable r0 = r7.i()
            if (r0 != 0) goto Le
            r7.b()
            r8 = 0
            return r8
        Le:
            long r1 = io.netty.util.concurrent.ad.c()
            long r1 = r1 + r8
            r8 = 0
            r3 = r8
        L16:
            c(r0)
            r5 = 1
            long r3 = r3 + r5
            r5 = 63
            long r5 = r5 & r3
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 != 0) goto L2c
            long r5 = io.netty.util.concurrent.ad.c()
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 < 0) goto L2c
            goto L36
        L2c:
            java.lang.Runnable r0 = r7.i()
            if (r0 != 0) goto L16
            long r5 = io.netty.util.concurrent.ad.c()
        L36:
            r7.b()
            r7.t = r5
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.ae.b(long):boolean");
    }

    protected long c(long j) {
        ad<?> adVarQ = q();
        if (adVarQ == null) {
            return z;
        }
        return adVarQ.b(j);
    }

    protected void u() {
        this.t = ad.c();
    }

    protected void a(boolean z2) {
        if (!z2 || h.get(this) == 3) {
            this.j.offer(f4719b);
        }
    }

    @Override // io.netty.util.concurrent.j
    public boolean a(Thread thread) {
        return thread == this.k;
    }

    private boolean g() {
        boolean z2 = false;
        while (!this.p.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.p);
            this.p.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((Runnable) it.next()).run();
                } catch (Throwable th) {
                    f4718a.b("Shutdown hook raised an exception.", th);
                }
                z2 = true;
            }
        }
        if (z2) {
            this.t = ad.c();
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    @Override // io.netty.util.concurrent.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.netty.util.concurrent.p<?> a(long r7, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r6 = this;
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 < 0) goto L87
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 < 0) goto L63
            if (r11 == 0) goto L5b
            boolean r0 = r6.D_()
            if (r0 == 0) goto L17
            io.netty.util.concurrent.p r7 = r6.C_()
            return r7
        L17:
            boolean r0 = r6.k()
        L1b:
            boolean r1 = r6.D_()
            if (r1 == 0) goto L26
            io.netty.util.concurrent.p r7 = r6.C_()
            return r7
        L26:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.util.concurrent.ae> r1 = io.netty.util.concurrent.ae.h
            int r1 = r1.get(r6)
            r2 = 3
            r3 = 1
            if (r0 == 0) goto L32
        L30:
            r4 = 1
            goto L38
        L32:
            switch(r1) {
                case 1: goto L30;
                case 2: goto L30;
                default: goto L35;
            }
        L35:
            r2 = 0
            r2 = r1
            r4 = 0
        L38:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.util.concurrent.ae> r5 = io.netty.util.concurrent.ae.h
            boolean r2 = r5.compareAndSet(r6, r1, r2)
            if (r2 == 0) goto L1b
            long r7 = r11.toNanos(r7)
            r6.v = r7
            long r7 = r11.toNanos(r9)
            r6.w = r7
            if (r1 != r3) goto L51
            r6.z()
        L51:
            if (r4 == 0) goto L56
            r6.a(r0)
        L56:
            io.netty.util.concurrent.p r7 = r6.C_()
            return r7
        L5b:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "unit"
            r7.<init>(r8)
            throw r7
        L63:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "timeout: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " (expected >= quietPeriod ("
            r0.append(r9)
            r0.append(r7)
            java.lang.String r7 = "))"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r11.<init>(r7)
            throw r11
        L87:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "quietPeriod: "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r7 = " (expected >= 0)"
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            r9.<init>(r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.ae.a(long, long, java.util.concurrent.TimeUnit):io.netty.util.concurrent.p");
    }

    @Override // io.netty.util.concurrent.l
    public p<?> C_() {
        return this.y;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    @Override // io.netty.util.concurrent.a, java.util.concurrent.ExecutorService, io.netty.util.concurrent.l
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void shutdown() {
        /*
            r6 = this;
            boolean r0 = r6.isShutdown()
            if (r0 == 0) goto L7
            return
        L7:
            boolean r0 = r6.k()
        Lb:
            boolean r1 = r6.D_()
            if (r1 == 0) goto L12
            return
        L12:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.util.concurrent.ae> r1 = io.netty.util.concurrent.ae.h
            int r1 = r1.get(r6)
            r2 = 4
            r3 = 1
            if (r0 == 0) goto L1e
        L1c:
            r4 = 1
            goto L24
        L1e:
            switch(r1) {
                case 1: goto L1c;
                case 2: goto L1c;
                case 3: goto L1c;
                default: goto L21;
            }
        L21:
            r2 = 0
            r2 = r1
            r4 = 0
        L24:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.util.concurrent.ae> r5 = io.netty.util.concurrent.ae.h
            boolean r2 = r5.compareAndSet(r6, r1, r2)
            if (r2 == 0) goto Lb
            if (r1 != r3) goto L31
            r6.z()
        L31:
            if (r4 == 0) goto L36
            r6.a(r0)
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.ae.shutdown():void");
    }

    @Override // io.netty.util.concurrent.l
    public boolean D_() {
        return h.get(this) >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return h.get(this) >= 4;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return h.get(this) == 5;
    }

    protected boolean v() throws InterruptedException {
        if (!D_()) {
            return false;
        }
        if (!k()) {
            throw new IllegalStateException("must be invoked from an event loop");
        }
        p();
        if (this.x == 0) {
            this.x = ad.c();
        }
        if (t() || g()) {
            if (isShutdown() || this.v == 0) {
                return true;
            }
            a(true);
            return false;
        }
        long jC = ad.c();
        if (isShutdown() || jC - this.x > this.w || jC - this.t > this.v) {
            return true;
        }
        a(true);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused) {
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (k()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        if (this.o.tryAcquire(j, timeUnit)) {
            this.o.release();
        }
        return isTerminated();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        boolean zK = k();
        if (zK) {
            d(runnable);
        } else {
            j();
            d(runnable);
            if (isShutdown() && f(runnable)) {
                w();
            }
        }
        if (this.q || !a(runnable)) {
            return;
        }
        a(zK);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        a("invokeAny");
        return (T) super.invokeAny(collection);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        a("invokeAny");
        return (T) super.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        a("invokeAll");
        return super.invokeAll(collection);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        a("invokeAll");
        return super.invokeAll(collection, j, timeUnit);
    }

    private void a(String str) {
        if (k()) {
            throw new RejectedExecutionException("Calling " + str + " from within the EventLoop is not allowed");
        }
    }

    protected static void w() {
        throw new RejectedExecutionException("event executor terminated");
    }

    protected final void g(Runnable runnable) {
        this.s.a(runnable, this);
    }

    private void j() {
        if (h.get(this) == 1 && h.compareAndSet(this, 1, 2)) {
            z();
        }
    }

    private void z() {
        if (!f && this.k != null) {
            throw new AssertionError();
        }
        this.m.execute(new Runnable() { // from class: io.netty.util.concurrent.ae.3
            /* JADX WARN: Code restructure failed: missing block: B:22:0x00de, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x012b, code lost:
            
                throw r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x0229, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x022a, code lost:
            
                io.netty.util.concurrent.ae.h.set(r8.f4720a, 5);
                r8.f4720a.o.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x0246, code lost:
            
                if (r8.f4720a.j.isEmpty() == false) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x0248, code lost:
            
                io.netty.util.concurrent.ae.f4718a.c("An event executor terminated with non-empty task queue (" + r8.f4720a.j.size() + ')');
             */
            /* JADX WARN: Code restructure failed: missing block: B:60:0x026d, code lost:
            
                r8.f4720a.y.a(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x0276, code lost:
            
                throw r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:87:0x038a, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:88:0x038b, code lost:
            
                io.netty.util.concurrent.ae.h.set(r8.f4720a, 5);
                r8.f4720a.o.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:89:0x03a7, code lost:
            
                if (r8.f4720a.j.isEmpty() == false) goto L90;
             */
            /* JADX WARN: Code restructure failed: missing block: B:90:0x03a9, code lost:
            
                io.netty.util.concurrent.ae.f4718a.c("An event executor terminated with non-empty task queue (" + r8.f4720a.j.size() + ')');
             */
            /* JADX WARN: Code restructure failed: missing block: B:91:0x03ce, code lost:
            
                r8.f4720a.y.a(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x03d7, code lost:
            
                throw r0;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 1145
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.ae.AnonymousClass3.run():void");
            }
        });
    }
}
