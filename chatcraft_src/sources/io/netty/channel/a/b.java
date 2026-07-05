package io.netty.channel.a;

import io.netty.b.af;
import io.netty.b.j;
import io.netty.b.l;
import io.netty.channel.ChannelException;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.a;
import io.netty.channel.ak;
import io.netty.channel.d;
import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.z;
import io.netty.util.a.s;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.r;
import io.netty.util.m;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: AbstractNioChannel.java */
/* loaded from: classes.dex */
public abstract class b extends io.netty.channel.a {
    static final /* synthetic */ boolean d = !b.class.desiredAssertionStatus();
    private static final io.netty.util.a.b.c e = io.netty.util.a.b.d.a((Class<?>) b.class);
    private static final ClosedChannelException f = (ClosedChannelException) s.a(new ClosedChannelException(), b.class, "doClose()");

    /* renamed from: a, reason: collision with root package name */
    protected final int f4434a;

    /* renamed from: b, reason: collision with root package name */
    volatile SelectionKey f4435b;
    boolean c;
    private final SelectableChannel g;
    private final Runnable h;
    private z i;
    private ScheduledFuture<?> j;
    private SocketAddress k;

    /* compiled from: AbstractNioChannel.java */
    /* renamed from: io.netty.channel.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0102b extends d.a {
        void l();

        void n();

        void o();
    }

    protected abstract void Q();

    protected abstract boolean a(SocketAddress socketAddress, SocketAddress socketAddress2);

    protected b(io.netty.channel.d dVar, SelectableChannel selectableChannel, int i) throws IOException {
        super(dVar);
        this.h = new Runnable() { // from class: io.netty.channel.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.H();
            }
        };
        this.g = selectableChannel;
        this.f4434a = i;
        try {
            selectableChannel.configureBlocking(false);
        } catch (IOException e2) {
            try {
                selectableChannel.close();
            } catch (IOException e3) {
                if (e.c()) {
                    e.b("Failed to close a partially initialized socket.", (Throwable) e3);
                }
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e2);
        }
    }

    @Override // io.netty.channel.d
    public boolean E() {
        return this.g.isOpen();
    }

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public InterfaceC0102b n() {
        return (InterfaceC0102b) super.n();
    }

    protected SelectableChannel M() {
        return this.g;
    }

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public d f() {
        return (d) super.f();
    }

    protected SelectionKey O() {
        if (d || this.f4435b != null) {
            return this.f4435b;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P() {
        if (i()) {
            d dVarF = f();
            if (dVarF.k()) {
                H();
                return;
            } else {
                dVarF.execute(this.h);
                return;
            }
        }
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.c = false;
        ((a) n()).m();
    }

    /* compiled from: AbstractNioChannel.java */
    protected abstract class a extends a.AbstractC0100a implements InterfaceC0102b {
        static final /* synthetic */ boolean d = !b.class.desiredAssertionStatus();

        protected a() {
            super();
        }

        protected final void m() {
            SelectionKey selectionKeyO = b.this.O();
            if (selectionKeyO.isValid()) {
                int iInterestOps = selectionKeyO.interestOps();
                if ((b.this.f4434a & iInterestOps) != 0) {
                    selectionKeyO.interestOps(iInterestOps & (b.this.f4434a ^ (-1)));
                }
            }
        }

        @Override // io.netty.channel.d.a
        public final void a(final SocketAddress socketAddress, SocketAddress socketAddress2, z zVar) {
            if (zVar.z_() && d(zVar)) {
                try {
                    if (b.this.i != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean zF = b.this.F();
                    if (!b.this.a(socketAddress, socketAddress2)) {
                        b.this.i = zVar;
                        b.this.k = socketAddress;
                        int iA = b.this.D().a();
                        if (iA > 0) {
                            b.this.j = b.this.f().schedule(new Runnable() { // from class: io.netty.channel.a.b.a.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    z zVar2 = b.this.i;
                                    ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
                                    if (zVar2 == null || !zVar2.b((Throwable) connectTimeoutException)) {
                                        return;
                                    }
                                    a.this.b(a.this.i());
                                }
                            }, iA, TimeUnit.MILLISECONDS);
                        }
                        zVar.b((r<? extends p<? super Void>>) new i() { // from class: io.netty.channel.a.b.a.2
                            @Override // io.netty.util.concurrent.r
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void operationComplete(h hVar) {
                                if (hVar.isCancelled()) {
                                    if (b.this.j != null) {
                                        b.this.j.cancel(false);
                                    }
                                    b.this.i = null;
                                    a.this.b(a.this.i());
                                }
                            }
                        });
                        return;
                    }
                    a(zVar, zF);
                } catch (Throwable th) {
                    zVar.b(a(th, socketAddress));
                    j();
                }
            }
        }

        private void a(z zVar, boolean z) {
            if (zVar == null) {
                return;
            }
            boolean zF = b.this.F();
            boolean zC = zVar.c();
            if (!z && zF) {
                b.this.d().b();
            }
            if (zC) {
                return;
            }
            b(i());
        }

        private void b(z zVar, Throwable th) {
            if (zVar == null) {
                return;
            }
            zVar.b(th);
            j();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v3, types: [io.netty.channel.a.b] */
        /* JADX WARN: Type inference failed for: r1v4 */
        @Override // io.netty.channel.a.b.InterfaceC0102b
        public final void n() {
            if (!d && !b.this.f().k()) {
                throw new AssertionError();
            }
            boolean z = 0;
            z = 0;
            try {
                try {
                    boolean zF = b.this.F();
                    b.this.Q();
                    a(b.this.i, zF);
                } catch (Throwable th) {
                    b(b.this.i, a(th, b.this.k));
                    if (b.this.j != null) {
                    }
                }
            } finally {
                if (b.this.j != null) {
                    b.this.j.cancel(z);
                }
                b.this.i = null;
            }
        }

        @Override // io.netty.channel.a.AbstractC0100a
        protected final void h() {
            if (p()) {
                return;
            }
            super.h();
        }

        @Override // io.netty.channel.a.b.InterfaceC0102b
        public final void o() {
            super.h();
        }

        private boolean p() {
            SelectionKey selectionKeyO = b.this.O();
            return selectionKeyO.isValid() && (selectionKeyO.interestOps() & 4) != 0;
        }
    }

    @Override // io.netty.channel.a
    protected boolean a(ak akVar) {
        return akVar instanceof d;
    }

    @Override // io.netty.channel.a
    protected void s() {
        boolean z = false;
        while (true) {
            try {
                this.f4435b = M().register(f().f4440b, 0, this);
                return;
            } catch (CancelledKeyException e2) {
                if (!z) {
                    f().j();
                    z = true;
                } else {
                    throw e2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.a
    public void v() {
        f().a(O());
    }

    @Override // io.netty.channel.a
    protected void w() {
        SelectionKey selectionKey = this.f4435b;
        if (selectionKey.isValid()) {
            this.c = true;
            int iInterestOps = selectionKey.interestOps();
            if ((this.f4434a & iInterestOps) == 0) {
                selectionKey.interestOps(iInterestOps | this.f4434a);
            }
        }
    }

    protected final io.netty.b.i c(io.netty.b.i iVar) {
        int iG = iVar.g();
        if (iG == 0) {
            m.b(iVar);
            return af.c;
        }
        j jVarE = e();
        if (jVarE.c()) {
            io.netty.b.i iVarD = jVarE.d(iG);
            iVarD.a(iVar, iVar.b(), iG);
            m.b(iVar);
            return iVarD;
        }
        io.netty.b.i iVarA = l.a();
        if (iVarA == null) {
            return iVar;
        }
        iVarA.a(iVar, iVar.b(), iG);
        m.b(iVar);
        return iVarA;
    }

    @Override // io.netty.channel.a
    protected void u() {
        z zVar = this.i;
        if (zVar != null) {
            zVar.b((Throwable) f);
            this.i = null;
        }
        ScheduledFuture<?> scheduledFuture = this.j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.j = null;
        }
    }
}
