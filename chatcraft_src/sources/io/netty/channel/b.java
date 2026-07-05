package io.netty.channel;

import io.netty.channel.a;
import io.netty.channel.ax;
import io.netty.util.l;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: AbstractChannelHandlerContext.java */
/* loaded from: classes.dex */
abstract class b extends io.netty.util.i implements l, io.netty.util.r {
    static final /* synthetic */ boolean d = !b.class.desiredAssertionStatus();
    private static final io.netty.util.a.b.c e = io.netty.util.a.b.d.a((Class<?>) b.class);
    private static final AtomicIntegerFieldUpdater<b> f;

    /* renamed from: a, reason: collision with root package name */
    volatile b f4490a;

    /* renamed from: b, reason: collision with root package name */
    volatile b f4491b;
    final io.netty.util.concurrent.j c;
    private final boolean g;
    private final boolean h;
    private final ae i;
    private final String j;
    private final boolean k;
    private Runnable l;
    private Runnable m;
    private Runnable n;
    private Runnable o;
    private volatile int p = 0;

    static {
        AtomicIntegerFieldUpdater<b> atomicIntegerFieldUpdaterB = io.netty.util.a.l.b(b.class, "handlerState");
        if (atomicIntegerFieldUpdaterB == null) {
            atomicIntegerFieldUpdaterB = AtomicIntegerFieldUpdater.newUpdater(b.class, "p");
        }
        f = atomicIntegerFieldUpdaterB;
    }

    b(ae aeVar, io.netty.util.concurrent.j jVar, String str, boolean z, boolean z2) {
        this.j = (String) io.netty.util.a.j.a(str, "name");
        this.i = aeVar;
        this.c = jVar;
        this.g = z;
        this.h = z2;
        this.k = jVar == null || (jVar instanceof io.netty.util.concurrent.v);
    }

    @Override // io.netty.channel.l
    public d a() {
        return this.i.f();
    }

    @Override // io.netty.channel.l
    public w b() {
        return this.i;
    }

    @Override // io.netty.channel.l
    public io.netty.b.j c() {
        return a().D().c();
    }

    @Override // io.netty.channel.l
    public io.netty.util.concurrent.j d() {
        if (this.c == null) {
            return a().f();
        }
        return this.c;
    }

    public String e() {
        return this.j;
    }

    @Override // io.netty.channel.l
    public l f() {
        a(F());
        return this;
    }

    static void a(b bVar) {
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.w();
        } else {
            jVarD.execute(new Runnable() { // from class: io.netty.channel.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.w();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (H()) {
            try {
                ((n) v()).channelRegistered(this);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        f();
    }

    @Override // io.netty.channel.l
    public l g() {
        b(F());
        return this;
    }

    static void b(b bVar) {
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.x();
        } else {
            jVarD.execute(new Runnable() { // from class: io.netty.channel.b.9
                @Override // java.lang.Runnable
                public void run() {
                    b.this.x();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (H()) {
            try {
                ((n) v()).channelUnregistered(this);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        g();
    }

    @Override // io.netty.channel.l
    public l h() {
        c(F());
        return this;
    }

    static void c(b bVar) {
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.y();
        } else {
            jVarD.execute(new Runnable() { // from class: io.netty.channel.b.10
                @Override // java.lang.Runnable
                public void run() {
                    b.this.y();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (H()) {
            try {
                ((n) v()).channelActive(this);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        h();
    }

    @Override // io.netty.channel.l
    public l i() {
        d(F());
        return this;
    }

    static void d(b bVar) {
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.z();
        } else {
            jVarD.execute(new Runnable() { // from class: io.netty.channel.b.11
                @Override // java.lang.Runnable
                public void run() {
                    b.this.z();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (H()) {
            try {
                ((n) v()).channelInactive(this);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        i();
    }

    @Override // io.netty.channel.l
    public l a(Throwable th) {
        a(this.f4490a, th);
        return this;
    }

    static void a(b bVar, final Throwable th) {
        io.netty.util.a.j.a(th, "cause");
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.b(th);
            return;
        }
        try {
            jVarD.execute(new Runnable() { // from class: io.netty.channel.b.12
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(th);
                }
            });
        } catch (Throwable th2) {
            if (e.c()) {
                e.b("Failed to submit an exceptionCaught() event.", th2);
                e.b("The exceptionCaught() event that was failed to submit was:", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Throwable th) {
        if (H()) {
            try {
                v().exceptionCaught(this, th);
                return;
            } catch (Throwable th2) {
                if (e.b()) {
                    e.b("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", io.netty.util.a.s.a(th2), th);
                    return;
                } else {
                    if (e.c()) {
                        e.c("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                        return;
                    }
                    return;
                }
            }
        }
        a(th);
    }

    @Override // io.netty.channel.l
    public l b(Object obj) {
        a(F(), obj);
        return this;
    }

    static void a(b bVar, final Object obj) {
        io.netty.util.a.j.a(obj, "event");
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.d(obj);
        } else {
            jVarD.execute(new Runnable() { // from class: io.netty.channel.b.13
                @Override // java.lang.Runnable
                public void run() {
                    b.this.d(obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Object obj) {
        if (H()) {
            try {
                ((n) v()).userEventTriggered(this, obj);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        b(obj);
    }

    @Override // io.netty.channel.l
    public l c(Object obj) {
        b(F(), obj);
        return this;
    }

    static void b(b bVar, Object obj) {
        final Object objA = bVar.i.a(io.netty.util.a.j.a(obj, "msg"), bVar);
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.e(objA);
        } else {
            jVarD.execute(new Runnable() { // from class: io.netty.channel.b.14
                @Override // java.lang.Runnable
                public void run() {
                    b.this.e(objA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Object obj) {
        if (H()) {
            try {
                ((n) v()).channelRead(this, obj);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        c(obj);
    }

    @Override // io.netty.channel.l
    public l k() {
        e(F());
        return this;
    }

    static void e(b bVar) {
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.A();
            return;
        }
        Runnable runnable = bVar.l;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.b.15
                @Override // java.lang.Runnable
                public void run() {
                    b.this.A();
                }
            };
            bVar.l = runnable;
        }
        jVarD.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (H()) {
            try {
                ((n) v()).channelReadComplete(this);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        k();
    }

    @Override // io.netty.channel.l
    public l l() {
        f(F());
        return this;
    }

    static void f(b bVar) {
        io.netty.util.concurrent.j jVarD = bVar.d();
        if (jVarD.k()) {
            bVar.B();
            return;
        }
        Runnable runnable = bVar.n;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.b.16
                @Override // java.lang.Runnable
                public void run() {
                    b.this.B();
                }
            };
            bVar.n = runnable;
        }
        jVarD.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (H()) {
            try {
                ((n) v()).channelWritabilityChanged(this);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        l();
    }

    @Override // io.netty.channel.v
    public h j() {
        return b(m());
    }

    @Override // io.netty.channel.v
    public h a(final SocketAddress socketAddress, final z zVar) {
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        if (!a(zVar, false)) {
            return zVar;
        }
        final b bVarG = G();
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            bVarG.c(socketAddress, zVar);
        } else {
            a(jVarD, new Runnable() { // from class: io.netty.channel.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVarG.c(socketAddress, zVar);
                }
            }, zVar, (Object) null);
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SocketAddress socketAddress, z zVar) {
        if (H()) {
            try {
                ((t) v()).bind(this, socketAddress, zVar);
                return;
            } catch (Throwable th) {
                a(th, zVar);
                return;
            }
        }
        a(socketAddress, zVar);
    }

    @Override // io.netty.channel.v
    public h b(SocketAddress socketAddress, z zVar) {
        return a(socketAddress, (SocketAddress) null, zVar);
    }

    @Override // io.netty.channel.v
    public h a(final SocketAddress socketAddress, final SocketAddress socketAddress2, final z zVar) {
        if (socketAddress == null) {
            throw new NullPointerException("remoteAddress");
        }
        if (!a(zVar, false)) {
            return zVar;
        }
        final b bVarG = G();
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            bVarG.b(socketAddress, socketAddress2, zVar);
        } else {
            a(jVarD, new Runnable() { // from class: io.netty.channel.b.3
                @Override // java.lang.Runnable
                public void run() {
                    bVarG.b(socketAddress, socketAddress2, zVar);
                }
            }, zVar, (Object) null);
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SocketAddress socketAddress, SocketAddress socketAddress2, z zVar) {
        if (H()) {
            try {
                ((t) v()).connect(this, socketAddress, socketAddress2, zVar);
                return;
            } catch (Throwable th) {
                a(th, zVar);
                return;
            }
        }
        a(socketAddress, socketAddress2, zVar);
    }

    @Override // io.netty.channel.v
    public h a(final z zVar) {
        if (!a(zVar, false)) {
            return zVar;
        }
        final b bVarG = G();
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            if (!a().G().a()) {
                bVarG.e(zVar);
            } else {
                bVarG.d(zVar);
            }
        } else {
            a(jVarD, new Runnable() { // from class: io.netty.channel.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!b.this.a().G().a()) {
                        bVarG.e(zVar);
                    } else {
                        bVarG.d(zVar);
                    }
                }
            }, zVar, (Object) null);
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(z zVar) {
        if (H()) {
            try {
                ((t) v()).disconnect(this, zVar);
                return;
            } catch (Throwable th) {
                a(th, zVar);
                return;
            }
        }
        a(zVar);
    }

    @Override // io.netty.channel.v
    public h b(final z zVar) {
        if (!a(zVar, false)) {
            return zVar;
        }
        final b bVarG = G();
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            bVarG.e(zVar);
        } else {
            a(jVarD, new Runnable() { // from class: io.netty.channel.b.5
                @Override // java.lang.Runnable
                public void run() {
                    bVarG.e(zVar);
                }
            }, zVar, (Object) null);
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(z zVar) {
        if (H()) {
            try {
                ((t) v()).close(this, zVar);
                return;
            } catch (Throwable th) {
                a(th, zVar);
                return;
            }
        }
        b(zVar);
    }

    @Override // io.netty.channel.v
    public h c(final z zVar) {
        if (!a(zVar, false)) {
            return zVar;
        }
        final b bVarG = G();
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            bVarG.f(zVar);
        } else {
            a(jVarD, new Runnable() { // from class: io.netty.channel.b.6
                @Override // java.lang.Runnable
                public void run() {
                    bVarG.f(zVar);
                }
            }, zVar, (Object) null);
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(z zVar) {
        if (H()) {
            try {
                ((t) v()).deregister(this, zVar);
                return;
            } catch (Throwable th) {
                a(th, zVar);
                return;
            }
        }
        c(zVar);
    }

    @Override // io.netty.channel.l
    public l n() {
        final b bVarG = G();
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            bVarG.C();
        } else {
            Runnable runnable = bVarG.m;
            if (runnable == null) {
                runnable = new Runnable() { // from class: io.netty.channel.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        bVarG.C();
                    }
                };
                bVarG.m = runnable;
            }
            jVarD.execute(runnable);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (H()) {
            try {
                ((t) v()).read(this);
                return;
            } catch (Throwable th) {
                c(th);
                return;
            }
        }
        n();
    }

    @Override // io.netty.channel.v
    public h a(Object obj, z zVar) {
        if (obj == null) {
            throw new NullPointerException("msg");
        }
        try {
            if (!a(zVar, true)) {
                io.netty.util.m.a(obj);
                return zVar;
            }
            a(obj, false, zVar);
            return zVar;
        } catch (RuntimeException e2) {
            io.netty.util.m.a(obj);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj, z zVar) {
        if (H()) {
            d(obj, zVar);
        } else {
            a(obj, zVar);
        }
    }

    private void d(Object obj, z zVar) {
        try {
            ((t) v()).write(this, obj, zVar);
        } catch (Throwable th) {
            a(th, zVar);
        }
    }

    @Override // io.netty.channel.l
    public l o() {
        final b bVarG = G();
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            bVarG.D();
        } else {
            Runnable runnable = bVarG.o;
            if (runnable == null) {
                runnable = new Runnable() { // from class: io.netty.channel.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        bVarG.D();
                    }
                };
                bVarG.o = runnable;
            }
            a(jVarD, runnable, a().p(), (Object) null);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (H()) {
            E();
        } else {
            o();
        }
    }

    private void E() {
        try {
            ((t) v()).flush(this);
        } catch (Throwable th) {
            c(th);
        }
    }

    public h b(Object obj, z zVar) {
        if (obj == null) {
            throw new NullPointerException("msg");
        }
        if (!a(zVar, true)) {
            io.netty.util.m.a(obj);
            return zVar;
        }
        a(obj, true, zVar);
        return zVar;
    }

    private void e(Object obj, z zVar) {
        if (H()) {
            d(obj, zVar);
            E();
        } else {
            b(obj, zVar);
        }
    }

    private void a(Object obj, boolean z, z zVar) {
        Runnable runnableC;
        b bVarG = G();
        Object objA = this.i.a(obj, bVarG);
        io.netty.util.concurrent.j jVarD = bVarG.d();
        if (jVarD.k()) {
            if (z) {
                bVarG.e(objA, zVar);
                return;
            } else {
                bVarG.c(objA, zVar);
                return;
            }
        }
        if (!z) {
            runnableC = c.c(bVarG, objA, zVar);
        } else {
            runnableC = C0103b.c(bVarG, objA, zVar);
        }
        a(jVarD, runnableC, zVar, objA);
    }

    @Override // io.netty.channel.v
    public h a(Object obj) {
        return b(obj, m());
    }

    private static void a(Throwable th, z zVar) {
        if (zVar instanceof bb) {
            return;
        }
        io.netty.util.a.n.a((io.netty.util.concurrent.y<?>) zVar, th, e);
    }

    private void c(Throwable th) {
        if (d(th)) {
            if (e.c()) {
                e.b("An exception was thrown by a user handler while handling an exceptionCaught event", th);
                return;
            }
            return;
        }
        b(th);
    }

    private static boolean d(Throwable th) {
        do {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement == null) {
                        break;
                    }
                    if ("exceptionCaught".equals(stackTraceElement.getMethodName())) {
                        return true;
                    }
                }
            }
            th = th.getCause();
        } while (th != null);
        return false;
    }

    @Override // io.netty.channel.v
    public z m() {
        return new af(a(), d());
    }

    private boolean a(z zVar, boolean z) {
        if (zVar == null) {
            throw new NullPointerException("promise");
        }
        if (zVar.isDone()) {
            if (zVar.isCancelled()) {
                return false;
            }
            throw new IllegalArgumentException("promise already done: " + zVar);
        }
        if (zVar.e() != a()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", zVar.e(), a()));
        }
        if (zVar.getClass() == af.class) {
            return true;
        }
        if (!z && (zVar instanceof bb)) {
            throw new IllegalArgumentException(io.netty.util.a.p.a((Class<?>) bb.class) + " not allowed for this operation");
        }
        if (!(zVar instanceof a.e)) {
            return true;
        }
        throw new IllegalArgumentException(io.netty.util.a.p.a((Class<?>) a.e.class) + " not allowed in a pipeline");
    }

    private b F() {
        b bVar = this;
        do {
            bVar = bVar.f4490a;
        } while (!bVar.g);
        return bVar;
    }

    private b G() {
        b bVar = this;
        do {
            bVar = bVar.f4491b;
        } while (!bVar.h);
        return bVar;
    }

    @Override // io.netty.channel.v
    public z p() {
        return a().p();
    }

    final void q() {
        this.p = 3;
    }

    final void r() {
        int i;
        do {
            i = this.p;
            if (i == 3) {
                return;
            }
        } while (!f.compareAndSet(this, i, 2));
    }

    final void s() {
        boolean zCompareAndSet = f.compareAndSet(this, 0, 1);
        if (!d && !zCompareAndSet) {
            throw new AssertionError();
        }
    }

    private boolean H() {
        int i = this.p;
        if (i != 2) {
            return !this.k && i == 1;
        }
        return true;
    }

    @Override // io.netty.channel.l
    public boolean t() {
        return this.p == 3;
    }

    @Override // io.netty.util.i, io.netty.util.d
    public <T> io.netty.util.b<T> a(io.netty.util.c<T> cVar) {
        return a().a((io.netty.util.c) cVar);
    }

    private static void a(io.netty.util.concurrent.j jVar, Runnable runnable, z zVar, Object obj) {
        try {
            jVar.execute(runnable);
        } catch (Throwable th) {
            try {
                zVar.c(th);
            } finally {
                if (obj != null) {
                    io.netty.util.m.a(obj);
                }
            }
        }
    }

    @Override // io.netty.util.r
    public String u() {
        return '\'' + this.j + "' will handle the message from this point.";
    }

    public String toString() {
        return io.netty.util.a.p.a((Class<?>) l.class) + '(' + this.j + ", " + a() + ')';
    }

    /* compiled from: AbstractChannelHandlerContext.java */
    static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private static final boolean f4519a = io.netty.util.a.q.a("io.netty.transport.estimateSizeOnSubmit", true);

        /* renamed from: b, reason: collision with root package name */
        private static final int f4520b = io.netty.util.a.q.a("io.netty.transport.writeTaskSizeOverhead", 48);
        private final l.b<a> c;
        private b d;
        private Object e;
        private z f;
        private int g;

        /* JADX WARN: Multi-variable type inference failed */
        private a(l.b<? extends a> bVar) {
            this.c = bVar;
        }

        protected static void a(a aVar, b bVar, Object obj, z zVar) {
            aVar.d = bVar;
            aVar.e = obj;
            aVar.f = zVar;
            if (f4519a) {
                s sVarB = bVar.a().n().b();
                if (sVarB != null) {
                    aVar.g = bVar.i.e().a(obj) + f4520b;
                    sVarB.a(aVar.g);
                    return;
                } else {
                    aVar.g = 0;
                    return;
                }
            }
            aVar.g = 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            try {
                s sVarB = this.d.a().n().b();
                if (f4519a && sVarB != null) {
                    sVarB.b(this.g);
                }
                a(this.d, this.e, this.f);
            } finally {
                this.d = null;
                this.e = null;
                this.f = null;
                this.c.a(this);
            }
        }

        protected void a(b bVar, Object obj, z zVar) {
            bVar.c(obj, zVar);
        }
    }

    /* compiled from: AbstractChannelHandlerContext.java */
    static final class c extends a implements ax.a {

        /* renamed from: a, reason: collision with root package name */
        private static final io.netty.util.l<c> f4527a = new io.netty.util.l<c>() { // from class: io.netty.channel.b.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c b(l.b<c> bVar) {
                return new c(bVar);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static c c(b bVar, Object obj, z zVar) {
            c cVarA = f4527a.a();
            a(cVarA, bVar, obj, zVar);
            return cVarA;
        }

        private c(l.b<c> bVar) {
            super(bVar);
        }
    }

    /* compiled from: AbstractChannelHandlerContext.java */
    /* renamed from: io.netty.channel.b$b, reason: collision with other inner class name */
    static final class C0103b extends a {

        /* renamed from: a, reason: collision with root package name */
        private static final io.netty.util.l<C0103b> f4523a = new io.netty.util.l<C0103b>() { // from class: io.netty.channel.b.b.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0103b b(l.b<C0103b> bVar) {
                return new C0103b(bVar);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static C0103b c(b bVar, Object obj, z zVar) {
            C0103b c0103bA = f4523a.a();
            a(c0103bA, bVar, obj, zVar);
            return c0103bA;
        }

        private C0103b(l.b<C0103b> bVar) {
            super(bVar);
        }

        @Override // io.netty.channel.b.a
        public void a(b bVar, Object obj, z zVar) {
            super.a(bVar, obj, zVar);
            bVar.D();
        }
    }
}
