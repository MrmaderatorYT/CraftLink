package io.netty.channel;

import io.netty.channel.ar;
import io.netty.channel.d;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: AbstractChannel.java */
/* loaded from: classes.dex */
public abstract class a extends io.netty.util.i implements io.netty.channel.d {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4414a = io.netty.util.a.b.d.a((Class<?>) a.class);

    /* renamed from: b, reason: collision with root package name */
    private static final ClosedChannelException f4415b = (ClosedChannelException) io.netty.util.a.s.a(new ClosedChannelException(), AbstractC0100a.class, "flush0()");
    private static final ClosedChannelException c = (ClosedChannelException) io.netty.util.a.s.a(new ClosedChannelException(), AbstractC0100a.class, "ensureOpen(...)");
    private static final ClosedChannelException d = (ClosedChannelException) io.netty.util.a.s.a(new ClosedChannelException(), AbstractC0100a.class, "close(...)");
    private static final ClosedChannelException e = (ClosedChannelException) io.netty.util.a.s.a(new ClosedChannelException(), AbstractC0100a.class, "write(...)");
    private static final NotYetConnectedException f = (NotYetConnectedException) io.netty.util.a.s.a(new NotYetConnectedException(), AbstractC0100a.class, "flush0()");
    private final io.netty.channel.d g;
    private volatile SocketAddress m;
    private volatile SocketAddress n;
    private volatile ak o;
    private volatile boolean p;
    private boolean q;
    private String r;
    private final bb k = new bb(this, false);
    private final e l = new e(this);
    private final m h = b();
    private final d.a i = o();
    private final ae j = c();

    protected abstract void a(s sVar);

    protected abstract void a(SocketAddress socketAddress);

    protected abstract boolean a(ak akVar);

    protected Object b(Object obj) {
        return obj;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    protected abstract AbstractC0100a o();

    protected abstract SocketAddress q();

    protected abstract SocketAddress r();

    protected void s() {
    }

    protected abstract void t();

    protected abstract void u();

    protected void v() {
    }

    protected abstract void w();

    protected a(io.netty.channel.d dVar) {
        this.g = dVar;
    }

    @Override // io.netty.channel.d
    public final m a() {
        return this.h;
    }

    protected m b() {
        return ad.b();
    }

    protected ae c() {
        return new ae(this);
    }

    @Override // io.netty.channel.d
    public w d() {
        return this.j;
    }

    public io.netty.b.j e() {
        return D().c();
    }

    @Override // io.netty.channel.d
    public ak f() {
        ak akVar = this.o;
        if (akVar != null) {
            return akVar;
        }
        throw new IllegalStateException("channel not registered to an event loop");
    }

    @Override // io.netty.channel.d
    public SocketAddress g() {
        SocketAddress socketAddress = this.m;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress socketAddressC = n().c();
            this.m = socketAddressC;
            return socketAddressC;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.netty.channel.d
    public SocketAddress h() {
        SocketAddress socketAddress = this.n;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress socketAddressD = n().d();
            this.n = socketAddressD;
            return socketAddressD;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.netty.channel.d
    public boolean i() {
        return this.p;
    }

    @Override // io.netty.channel.v
    public h j() {
        return this.j.j();
    }

    @Override // io.netty.channel.d
    public io.netty.channel.d k() {
        this.j.l();
        return this;
    }

    @Override // io.netty.channel.v
    public h a(SocketAddress socketAddress, z zVar) {
        return this.j.a(socketAddress, zVar);
    }

    @Override // io.netty.channel.v
    public h b(SocketAddress socketAddress, z zVar) {
        return this.j.b(socketAddress, zVar);
    }

    @Override // io.netty.channel.v
    public h a(SocketAddress socketAddress, SocketAddress socketAddress2, z zVar) {
        return this.j.a(socketAddress, socketAddress2, zVar);
    }

    @Override // io.netty.channel.v
    public h a(z zVar) {
        return this.j.a(zVar);
    }

    @Override // io.netty.channel.v
    public h b(z zVar) {
        return this.j.b(zVar);
    }

    @Override // io.netty.channel.v
    public h c(z zVar) {
        return this.j.c(zVar);
    }

    @Override // io.netty.channel.d
    public io.netty.channel.d l() {
        this.j.n();
        return this;
    }

    @Override // io.netty.channel.v
    public h a(Object obj, z zVar) {
        return this.j.a(obj, zVar);
    }

    @Override // io.netty.channel.v
    public h a(Object obj) {
        return this.j.a(obj);
    }

    @Override // io.netty.channel.v
    public z m() {
        return this.j.m();
    }

    @Override // io.netty.channel.d
    public d.a n() {
        return this.i;
    }

    public final int hashCode() {
        return this.h.hashCode();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(io.netty.channel.d dVar) {
        if (this == dVar) {
            return 0;
        }
        return a().compareTo(dVar.a());
    }

    public String toString() {
        boolean zF = F();
        if (this.q == zF && this.r != null) {
            return this.r;
        }
        SocketAddress socketAddressH = h();
        SocketAddress socketAddressG = g();
        if (socketAddressH != null) {
            StringBuilder sb = new StringBuilder(96);
            sb.append("[id: 0x");
            sb.append(this.h.a());
            sb.append(", L:");
            sb.append(socketAddressG);
            sb.append(zF ? " - " : " ! ");
            sb.append("R:");
            sb.append(socketAddressH);
            sb.append(']');
            this.r = sb.toString();
        } else if (socketAddressG != null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("[id: 0x");
            sb2.append(this.h.a());
            sb2.append(", L:");
            sb2.append(socketAddressG);
            sb2.append(']');
            this.r = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder(16);
            sb3.append("[id: 0x");
            sb3.append(this.h.a());
            sb3.append(']');
            this.r = sb3.toString();
        }
        this.q = zF;
        return this.r;
    }

    @Override // io.netty.channel.v
    public final z p() {
        return this.j.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractChannel.java */
    /* renamed from: io.netty.channel.a$a, reason: collision with other inner class name */
    public abstract class AbstractC0100a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f4416a = !a.class.desiredAssertionStatus();
        private volatile s c;
        private ar.a d;
        private boolean e;
        private boolean f = true;

        protected Executor k() {
            return null;
        }

        protected AbstractC0100a() {
            this.c = new s(a.this);
        }

        private void m() {
            if (!f4416a && a.this.p && !a.this.o.k()) {
                throw new AssertionError();
            }
        }

        @Override // io.netty.channel.d.a
        public ar.a a() {
            if (this.d == null) {
                this.d = a.this.D().d().a();
            }
            return this.d;
        }

        @Override // io.netty.channel.d.a
        public final s b() {
            return this.c;
        }

        @Override // io.netty.channel.d.a
        public final SocketAddress c() {
            return a.this.q();
        }

        @Override // io.netty.channel.d.a
        public final SocketAddress d() {
            return a.this.r();
        }

        @Override // io.netty.channel.d.a
        public final void a(ak akVar, final z zVar) {
            if (akVar == null) {
                throw new NullPointerException("eventLoop");
            }
            if (a.this.i()) {
                zVar.c((Throwable) new IllegalStateException("registered to an event loop already"));
                return;
            }
            if (a.this.a(akVar)) {
                a.this.o = akVar;
                if (akVar.k()) {
                    f(zVar);
                    return;
                }
                try {
                    akVar.execute(new Runnable() { // from class: io.netty.channel.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractC0100a.this.f(zVar);
                        }
                    });
                    return;
                } catch (Throwable th) {
                    a.f4414a.c("Force-closing a channel whose registration task was not accepted by an event loop: {}", a.this, th);
                    e();
                    a.this.l.d();
                    a(zVar, th);
                    return;
                }
            }
            zVar.c((Throwable) new IllegalStateException("incompatible event loop type: " + akVar.getClass().getName()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(z zVar) {
            try {
                if (zVar.z_() && d(zVar)) {
                    boolean z = this.f;
                    a.this.s();
                    this.f = false;
                    a.this.p = true;
                    a.this.j.g();
                    e(zVar);
                    a.this.j.a();
                    if (a.this.F()) {
                        if (z) {
                            a.this.j.b();
                        } else if (a.this.D().e()) {
                            f();
                        }
                    }
                }
            } catch (Throwable th) {
                e();
                a.this.l.d();
                a(zVar, th);
            }
        }

        @Override // io.netty.channel.d.a
        public final void a(SocketAddress socketAddress, z zVar) {
            m();
            if (zVar.z_() && d(zVar)) {
                if (Boolean.TRUE.equals(a.this.D().a(r.m)) && (socketAddress instanceof InetSocketAddress) && !((InetSocketAddress) socketAddress).getAddress().isAnyLocalAddress() && !io.netty.util.a.l.b() && !io.netty.util.a.l.c()) {
                    a.f4414a.c("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (" + socketAddress + ") anyway as requested.");
                }
                boolean zF = a.this.F();
                try {
                    a.this.a(socketAddress);
                    if (!zF && a.this.F()) {
                        a(new Runnable() { // from class: io.netty.channel.a.a.2
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.j.b();
                            }
                        });
                    }
                    e(zVar);
                } catch (Throwable th) {
                    a(zVar, th);
                    j();
                }
            }
        }

        @Override // io.netty.channel.d.a
        public final void a(z zVar) {
            m();
            if (zVar.z_()) {
                boolean zF = a.this.F();
                try {
                    a.this.t();
                    if (zF && !a.this.F()) {
                        a(new Runnable() { // from class: io.netty.channel.a.a.3
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.j.k();
                            }
                        });
                    }
                    e(zVar);
                    j();
                } catch (Throwable th) {
                    a(zVar, th);
                    j();
                }
            }
        }

        @Override // io.netty.channel.d.a
        public final void b(z zVar) {
            m();
            a(zVar, a.d, a.d, false);
        }

        private void a(final z zVar, final Throwable th, final ClosedChannelException closedChannelException, final boolean z) {
            if (zVar.z_()) {
                final s sVar = this.c;
                if (sVar != null) {
                    if (a.this.l.isDone()) {
                        e(zVar);
                        return;
                    }
                    final boolean zF = a.this.F();
                    this.c = null;
                    Executor executorK = k();
                    if (executorK != null) {
                        executorK.execute(new Runnable() { // from class: io.netty.channel.a.a.5
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AbstractC0100a.this.g(zVar);
                                } finally {
                                    AbstractC0100a.this.a(new Runnable() { // from class: io.netty.channel.a.a.5.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            sVar.a(th, z);
                                            sVar.a(closedChannelException);
                                            AbstractC0100a.this.a(zF);
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                    try {
                        g(zVar);
                        sVar.a(th, z);
                        sVar.a(closedChannelException);
                        if (this.e) {
                            a(new Runnable() { // from class: io.netty.channel.a.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    AbstractC0100a.this.a(zF);
                                }
                            });
                            return;
                        } else {
                            a(zF);
                            return;
                        }
                    } catch (Throwable th2) {
                        sVar.a(th, z);
                        sVar.a(closedChannelException);
                        throw th2;
                    }
                }
                if (zVar instanceof bb) {
                    return;
                }
                a.this.l.b((io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>>) new i() { // from class: io.netty.channel.a.a.4
                    @Override // io.netty.util.concurrent.r
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void operationComplete(h hVar) {
                        zVar.v_();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(z zVar) {
            try {
                a.this.u();
                a.this.l.d();
                e(zVar);
            } catch (Throwable th) {
                a.this.l.d();
                a(zVar, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            a(i(), z && !a.this.F());
        }

        @Override // io.netty.channel.d.a
        public final void e() {
            m();
            try {
                a.this.u();
            } catch (Exception e) {
                a.f4414a.b("Failed to close a channel.", (Throwable) e);
            }
        }

        @Override // io.netty.channel.d.a
        public final void c(z zVar) {
            m();
            a(zVar, false);
        }

        private void a(final z zVar, final boolean z) {
            if (zVar.z_()) {
                if (!a.this.p) {
                    e(zVar);
                } else {
                    a(new Runnable() { // from class: io.netty.channel.a.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                try {
                                    a.this.v();
                                } catch (Throwable th) {
                                    a.f4414a.b("Unexpected exception occurred while deregistering a channel.", th);
                                    if (z) {
                                        a.this.j.k();
                                    }
                                    if (a.this.p) {
                                    }
                                }
                            } finally {
                                if (z) {
                                    a.this.j.k();
                                }
                                if (a.this.p) {
                                    a.this.p = false;
                                    a.this.j.i();
                                }
                                AbstractC0100a.this.e(zVar);
                            }
                        }
                    });
                }
            }
        }

        @Override // io.netty.channel.d.a
        public final void f() {
            m();
            if (a.this.F()) {
                try {
                    a.this.w();
                } catch (Exception e) {
                    a(new Runnable() { // from class: io.netty.channel.a.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.j.a((Throwable) e);
                        }
                    });
                    b(i());
                }
            }
        }

        @Override // io.netty.channel.d.a
        public final void a(Object obj, z zVar) {
            Object objB;
            Throwable th;
            m();
            s sVar = this.c;
            if (sVar == null) {
                a(zVar, a.e);
                io.netty.util.m.a(obj);
                return;
            }
            try {
                objB = a.this.b(obj);
                try {
                    int iA = a.this.j.e().a(objB);
                    if (iA < 0) {
                        iA = 0;
                    }
                    sVar.a(objB, iA, zVar);
                } catch (Throwable th2) {
                    th = th2;
                    a(zVar, th);
                    io.netty.util.m.a(objB);
                }
            } catch (Throwable th3) {
                objB = obj;
                th = th3;
            }
        }

        @Override // io.netty.channel.d.a
        public final void g() {
            m();
            s sVar = this.c;
            if (sVar == null) {
                return;
            }
            sVar.a();
            h();
        }

        protected void h() {
            s sVar;
            if (this.e || (sVar = this.c) == null || sVar.h()) {
                return;
            }
            this.e = true;
            try {
                if (!a.this.F()) {
                    try {
                        if (a.this.E()) {
                            sVar.a((Throwable) a.f, true);
                        } else {
                            sVar.a((Throwable) a.f4415b, false);
                        }
                        return;
                    } finally {
                    }
                }
                try {
                    a.this.a(sVar);
                } catch (Throwable th) {
                    if ((th instanceof IOException) && a.this.D().f()) {
                        a(i(), th, a.f4415b, false);
                    } else {
                        sVar.a(th, true);
                    }
                }
            } finally {
            }
        }

        @Override // io.netty.channel.d.a
        public final z i() {
            m();
            return a.this.k;
        }

        @Deprecated
        protected final boolean d(z zVar) {
            if (a.this.E()) {
                return true;
            }
            a(zVar, a.c);
            return false;
        }

        protected final void e(z zVar) {
            if ((zVar instanceof bb) || zVar.c()) {
                return;
            }
            a.f4414a.c("Failed to mark a promise as success because it is done already: {}", zVar);
        }

        protected final void a(z zVar, Throwable th) {
            if ((zVar instanceof bb) || zVar.b(th)) {
                return;
            }
            a.f4414a.c("Failed to mark a promise as failure because it's done already: {}", zVar, th);
        }

        protected final void j() {
            if (a.this.E()) {
                return;
            }
            b(i());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Runnable runnable) {
            try {
                a.this.f().execute(runnable);
            } catch (RejectedExecutionException e) {
                a.f4414a.b("Can't invoke task later as EventLoop rejected it", (Throwable) e);
            }
        }

        protected final Throwable a(Throwable th, SocketAddress socketAddress) {
            if (th instanceof ConnectException) {
                return new b((ConnectException) th, socketAddress);
            }
            if (th instanceof NoRouteToHostException) {
                return new c((NoRouteToHostException) th, socketAddress);
            }
            return th instanceof SocketException ? new d((SocketException) th, socketAddress) : th;
        }
    }

    /* compiled from: AbstractChannel.java */
    static final class e extends af {
        e(a aVar) {
            super(aVar);
        }

        @Override // io.netty.channel.af, io.netty.channel.z
        public z v_() {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.af, io.netty.util.concurrent.h, io.netty.util.concurrent.y
        /* renamed from: a */
        public z c(Throwable th) {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.af, io.netty.channel.z
        public boolean c() {
            throw new IllegalStateException();
        }

        @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
        public boolean b(Throwable th) {
            throw new IllegalStateException();
        }

        boolean d() {
            return super.c();
        }
    }

    /* compiled from: AbstractChannel.java */
    private static final class b extends ConnectException {
        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        b(ConnectException connectException, SocketAddress socketAddress) {
            super(connectException.getMessage() + ": " + socketAddress);
            setStackTrace(connectException.getStackTrace());
        }
    }

    /* compiled from: AbstractChannel.java */
    private static final class c extends NoRouteToHostException {
        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        c(NoRouteToHostException noRouteToHostException, SocketAddress socketAddress) {
            super(noRouteToHostException.getMessage() + ": " + socketAddress);
            setStackTrace(noRouteToHostException.getStackTrace());
        }
    }

    /* compiled from: AbstractChannel.java */
    private static final class d extends SocketException {
        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        d(SocketException socketException, SocketAddress socketAddress) {
            super(socketException.getMessage() + ": " + socketAddress);
            setStackTrace(socketException.getStackTrace());
        }
    }
}
