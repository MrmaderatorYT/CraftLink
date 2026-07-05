package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: DefaultPromise.java */
/* loaded from: classes.dex */
public class h<V> extends c<V> implements y<V> {
    private static final AtomicReferenceFieldUpdater<h, Object> d;
    private volatile Object h;
    private final j i;
    private Object j;
    private short k;
    private boolean l;

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4735a = io.netty.util.a.b.d.a((Class<?>) h.class);

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4736b = io.netty.util.a.b.d.a(h.class.getName() + ".rejectedExecution");
    private static final int c = Math.min(8, io.netty.util.a.q.a("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final io.netty.util.s e = io.netty.util.s.a(h.class, "SUCCESS");
    private static final io.netty.util.s f = io.netty.util.s.a(h.class, "UNCANCELLABLE");
    private static final a g = new a(io.netty.util.a.s.a(new CancellationException(), h.class, "cancel(...)"));

    static {
        AtomicReferenceFieldUpdater<h, Object> atomicReferenceFieldUpdaterA = io.netty.util.a.l.a(h.class, "result");
        if (atomicReferenceFieldUpdaterA == null) {
            atomicReferenceFieldUpdaterA = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "h");
        }
        d = atomicReferenceFieldUpdaterA;
    }

    public h(j jVar) {
        this.i = (j) io.netty.util.a.j.a(jVar, "executor");
    }

    protected h() {
        this.i = null;
    }

    public y<V> a(V v) {
        if (c((h<V>) v)) {
            a();
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    @Override // io.netty.util.concurrent.y
    public boolean b(V v) {
        if (!c((h<V>) v)) {
            return false;
        }
        a();
        return true;
    }

    public y<V> c(Throwable th) {
        if (a(th)) {
            a();
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th);
    }

    public boolean b(Throwable th) {
        if (!a(th)) {
            return false;
        }
        a();
        return true;
    }

    @Override // io.netty.util.concurrent.y
    public boolean z_() {
        if (d.compareAndSet(this, null, f)) {
            return true;
        }
        Object obj = this.h;
        return (f(obj) && e(obj)) ? false : true;
    }

    @Override // io.netty.util.concurrent.p
    public boolean l() {
        Object obj = this.h;
        return (obj == null || obj == f || (obj instanceof a)) ? false : true;
    }

    @Override // io.netty.util.concurrent.p
    public Throwable k() {
        Object obj = this.h;
        if (obj instanceof a) {
            return ((a) obj).f4740a;
        }
        return null;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y<V> b(r<? extends p<? super V>> rVar) {
        io.netty.util.a.j.a(rVar, "listener");
        synchronized (this) {
            a((r) rVar);
        }
        if (isDone()) {
            a();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public y<V> i() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        o();
        synchronized (this) {
            while (!isDone()) {
                f();
                try {
                    wait();
                    g();
                } catch (Throwable th) {
                    g();
                    throw th;
                }
            }
        }
        return this;
    }

    /* JADX WARN: Finally extract failed */
    public y<V> r() {
        if (isDone()) {
            return this;
        }
        o();
        boolean z = false;
        synchronized (this) {
            while (!isDone()) {
                f();
                try {
                    try {
                        wait();
                        g();
                    } catch (InterruptedException unused) {
                        z = true;
                        g();
                    }
                } catch (Throwable th) {
                    g();
                    throw th;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.p
    public boolean a(long j, TimeUnit timeUnit) {
        return a(timeUnit.toNanos(j), true);
    }

    @Override // io.netty.util.concurrent.p
    public V j() {
        V v = (V) this.h;
        if ((v instanceof a) || v == e) {
            return null;
        }
        return v;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!d.compareAndSet(this, null, g)) {
            return false;
        }
        e();
        a();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return e(this.h);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return f(this.h);
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public y<V> h() throws Throwable {
        i();
        n();
        return this;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public y<V> B_() throws Throwable {
        r();
        n();
        return this;
    }

    public String toString() {
        return t().toString();
    }

    protected StringBuilder t() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(io.netty.util.a.p.a(this));
        sb.append('@');
        sb.append(Integer.toHexString(hashCode()));
        Object obj = this.h;
        if (obj == e) {
            sb.append("(success)");
        } else if (obj == f) {
            sb.append("(uncancellable)");
        } else if (obj instanceof a) {
            sb.append("(failure: ");
            sb.append(((a) obj).f4740a);
            sb.append(')');
        } else if (obj != null) {
            sb.append("(success: ");
            sb.append(obj);
            sb.append(')');
        } else {
            sb.append("(incomplete)");
        }
        return sb;
    }

    protected j b() {
        return this.i;
    }

    protected void o() {
        j jVarB = b();
        if (jVarB != null && jVarB.k()) {
            throw new BlockingOperationException(toString());
        }
    }

    protected static void a(j jVar, p<?> pVar, r<?> rVar) {
        io.netty.util.a.j.a(jVar, "eventExecutor");
        io.netty.util.a.j.a(pVar, "future");
        io.netty.util.a.j.a(rVar, "listener");
        b(jVar, pVar, rVar);
    }

    private void a() {
        io.netty.util.a.d dVarB;
        int iF;
        j jVarB = b();
        if (jVarB.k() && (iF = (dVarB = io.netty.util.a.d.b()).f()) < c) {
            dVarB.a(iF + 1);
            try {
                c();
                return;
            } finally {
                dVarB.a(iF);
            }
        }
        a(jVarB, new Runnable() { // from class: io.netty.util.concurrent.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        });
    }

    private static void b(j jVar, final p<?> pVar, final r<?> rVar) {
        io.netty.util.a.d dVarB;
        int iF;
        if (jVar.k() && (iF = (dVarB = io.netty.util.a.d.b()).f()) < c) {
            dVarB.a(iF + 1);
            try {
                b(pVar, rVar);
                return;
            } finally {
                dVarB.a(iF);
            }
        }
        a(jVar, new Runnable() { // from class: io.netty.util.concurrent.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.b(pVar, rVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this) {
            if (!this.l && this.j != null) {
                this.l = true;
                Object obj = this.j;
                this.j = null;
                while (true) {
                    if (obj instanceof g) {
                        a((g) obj);
                    } else {
                        b(this, (r) obj);
                    }
                    synchronized (this) {
                        if (this.j == null) {
                            this.l = false;
                            return;
                        } else {
                            obj = this.j;
                            this.j = null;
                        }
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        r<? extends p<?>>[] rVarArrA = gVar.a();
        int iB = gVar.b();
        for (int i = 0; i < iB; i++) {
            b(this, rVarArrA[i]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(p pVar, r rVar) {
        try {
            rVar.operationComplete(pVar);
        } catch (Throwable th) {
            f4735a.b("An exception was thrown by " + rVar.getClass().getName() + ".operationComplete()", th);
        }
    }

    private void a(r<? extends p<? super V>> rVar) {
        if (this.j == null) {
            this.j = rVar;
        } else if (this.j instanceof g) {
            ((g) this.j).a(rVar);
        } else {
            this.j = new g((r) this.j, rVar);
        }
    }

    private boolean c(V v) {
        if (v == null) {
            v = (V) e;
        }
        return d(v);
    }

    private boolean a(Throwable th) {
        return d(new a((Throwable) io.netty.util.a.j.a(th, "cause")));
    }

    private boolean d(Object obj) {
        if (!d.compareAndSet(this, null, obj) && !d.compareAndSet(this, f, obj)) {
            return false;
        }
        e();
        return true;
    }

    private synchronized void e() {
        if (this.k > 0) {
            notifyAll();
        }
    }

    private void f() {
        if (this.k == Short.MAX_VALUE) {
            throw new IllegalStateException("too many waiters: " + this);
        }
        this.k = (short) (this.k + 1);
    }

    private void g() {
        this.k = (short) (this.k - 1);
    }

    private void n() throws Throwable {
        Throwable thK = k();
        if (thK == null) {
            return;
        }
        io.netty.util.a.l.a(thK);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0092 -> B:51:0x008d). Please report as a decompilation issue!!! */
    private boolean a(long j, boolean z) throws Throwable {
        boolean z2 = true;
        if (isDone()) {
            return true;
        }
        if (j <= 0) {
            return isDone();
        }
        if (z && Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        o();
        long jNanoTime = System.nanoTime();
        boolean z3 = false;
        long jNanoTime2 = j;
        do {
            try {
                synchronized (this) {
                    try {
                        if (isDone()) {
                            if (z3) {
                                Thread.currentThread().interrupt();
                            }
                            return true;
                        }
                        f();
                        try {
                            try {
                                wait(jNanoTime2 / 1000000, (int) (jNanoTime2 % 1000000));
                            } catch (InterruptedException e2) {
                                if (z) {
                                    throw e2;
                                }
                                try {
                                    z3 = true;
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z3 = z2;
                                        if (z3) {
                                            Thread.currentThread().interrupt();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            if (isDone()) {
                                if (z3) {
                                    Thread.currentThread().interrupt();
                                }
                                return true;
                            }
                            jNanoTime2 = j - (System.nanoTime() - jNanoTime);
                        } finally {
                            g();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z2 = z3;
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } while (jNanoTime2 > 0);
        boolean zIsDone = isDone();
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return zIsDone;
    }

    private static boolean e(Object obj) {
        return (obj instanceof a) && (((a) obj).f4740a instanceof CancellationException);
    }

    private static boolean f(Object obj) {
        return (obj == null || obj == f) ? false : true;
    }

    /* compiled from: DefaultPromise.java */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Throwable f4740a;

        a(Throwable th) {
            this.f4740a = th;
        }
    }

    private static void a(j jVar, Runnable runnable) {
        try {
            jVar.execute(runnable);
        } catch (Throwable th) {
            f4736b.c("Failed to submit a listener notification task. Event loop shut down?", th);
        }
    }
}
