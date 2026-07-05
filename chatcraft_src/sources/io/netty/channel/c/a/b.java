package io.netty.channel.c.a;

import io.netty.b.i;
import io.netty.channel.ChannelException;
import io.netty.channel.a.a;
import io.netty.channel.a.b;
import io.netty.channel.an;
import io.netty.channel.ar;
import io.netty.channel.c.g;
import io.netty.channel.c.h;
import io.netty.channel.s;
import io.netty.channel.z;
import io.netty.util.a.b.c;
import io.netty.util.a.b.d;
import io.netty.util.a.l;
import io.netty.util.concurrent.t;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.Executor;

/* compiled from: NioSocketChannel.java */
/* loaded from: classes.dex */
public class b extends io.netty.channel.a.a implements g {
    private static final c e = d.a((Class<?>) b.class);
    private static final SelectorProvider f = SelectorProvider.provider();
    private final h g;

    private static SocketChannel a(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openSocketChannel();
        } catch (IOException e2) {
            throw new ChannelException("Failed to open a socket.", e2);
        }
    }

    public b() {
        this(f);
    }

    public b(SelectorProvider selectorProvider) {
        this(a(selectorProvider));
    }

    public b(SocketChannel socketChannel) {
        this(null, socketChannel);
    }

    public b(io.netty.channel.d dVar, SocketChannel socketChannel) {
        super(dVar, socketChannel);
        this.g = new a(this, this, socketChannel.socket(), null);
    }

    @Override // io.netty.channel.d
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public h D() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.a.b
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public SocketChannel M() {
        return (SocketChannel) super.M();
    }

    @Override // io.netty.channel.d
    public boolean F() {
        SocketChannel socketChannelM = M();
        return socketChannelM.isOpen() && socketChannelM.isConnected();
    }

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public InetSocketAddress g() {
        return (InetSocketAddress) super.g();
    }

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public InetSocketAddress h() {
        return (InetSocketAddress) super.h();
    }

    /* compiled from: NioSocketChannel.java */
    /* renamed from: io.netty.channel.c.a.b$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z f4540a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f4541b;

        @Override // java.lang.Runnable
        public void run() {
            this.f4541b.e(this.f4540a);
        }
    }

    @Override // io.netty.channel.a.a
    public io.netty.channel.h H() {
        return d(m());
    }

    public io.netty.channel.h d(final z zVar) {
        Executor executorK = ((C0105b) n()).k();
        if (executorK != null) {
            executorK.execute(new Runnable() { // from class: io.netty.channel.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f(zVar);
                }
            });
        } else {
            io.netty.channel.a.d dVarN = f();
            if (dVarN.k()) {
                f(zVar);
            } else {
                dVarN.execute(new Runnable() { // from class: io.netty.channel.c.a.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f(zVar);
                    }
                });
            }
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(z zVar) {
        try {
            V();
            zVar.v_();
        } catch (Throwable th) {
            zVar.c(th);
        }
    }

    private void V() throws IOException {
        if (l.d() >= 7) {
            M().shutdownOutput();
        } else {
            M().socket().shutdownOutput();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(z zVar) {
        try {
            W();
            zVar.v_();
        } catch (Throwable th) {
            zVar.c(th);
        }
    }

    private void W() throws IOException {
        if (l.d() >= 7) {
            M().shutdownInput();
        } else {
            M().socket().shutdownInput();
        }
    }

    @Override // io.netty.channel.a
    protected SocketAddress q() {
        return M().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.a
    protected SocketAddress r() {
        return M().socket().getRemoteSocketAddress();
    }

    @Override // io.netty.channel.a
    protected void a(SocketAddress socketAddress) throws IOException {
        b(socketAddress);
    }

    private void b(SocketAddress socketAddress) throws IOException {
        if (l.d() >= 7) {
            M().bind(socketAddress);
        } else {
            M().socket().bind(socketAddress);
        }
    }

    @Override // io.netty.channel.a.b
    protected boolean a(SocketAddress socketAddress, SocketAddress socketAddress2) throws IOException {
        if (socketAddress2 != null) {
            b(socketAddress2);
        }
        try {
            boolean zConnect = M().connect(socketAddress);
            if (!zConnect) {
                O().interestOps(8);
            }
            return zConnect;
        } catch (Throwable th) {
            u();
            throw th;
        }
    }

    @Override // io.netty.channel.a.b
    protected void Q() {
        if (!M().finishConnect()) {
            throw new Error();
        }
    }

    @Override // io.netty.channel.a
    protected void t() {
        u();
    }

    @Override // io.netty.channel.a.b, io.netty.channel.a
    protected void u() {
        super.u();
        M().close();
    }

    @Override // io.netty.channel.a.a
    protected int a(i iVar) {
        ar.a aVarA = n().a();
        aVarA.c(iVar.h());
        return iVar.a((ScatteringByteChannel) M(), aVarA.e());
    }

    @Override // io.netty.channel.a.a
    protected int b(i iVar) {
        return iVar.a((GatheringByteChannel) M(), iVar.g());
    }

    @Override // io.netty.channel.a.a
    protected long a(an anVar) {
        return anVar.a(M(), anVar.a());
    }

    @Override // io.netty.channel.a.a, io.netty.channel.a
    protected void a(s sVar) throws Throwable {
        s sVar2;
        long j;
        while (sVar.g() != 0) {
            ByteBuffer[] byteBufferArrD = sVar.d();
            int iE = sVar.e();
            long jF = sVar.f();
            SocketChannel socketChannelM = M();
            boolean z = false;
            boolean z2 = true;
            switch (iE) {
                case 0:
                    super.a(sVar);
                    return;
                case 1:
                    ByteBuffer byteBuffer = byteBufferArrD[0];
                    int iB = D().b() - 1;
                    long j2 = 0;
                    while (true) {
                        if (iB >= 0) {
                            int iWrite = socketChannelM.write(byteBuffer);
                            if (iWrite != 0) {
                                long j3 = iWrite;
                                jF -= j3;
                                j2 += j3;
                                if (jF == 0) {
                                    z = true;
                                } else {
                                    iB--;
                                }
                            }
                        }
                    }
                    z2 = false;
                    sVar2 = sVar;
                    j = j2;
                    break;
                default:
                    int iB2 = D().b() - 1;
                    j = 0;
                    while (true) {
                        if (iB2 >= 0) {
                            long jWrite = socketChannelM.write(byteBufferArrD, 0, iE);
                            if (jWrite == 0) {
                                sVar2 = sVar;
                                break;
                            } else {
                                jF -= jWrite;
                                j += jWrite;
                                if (jF == 0) {
                                    sVar2 = sVar;
                                    z = true;
                                } else {
                                    iB2--;
                                }
                            }
                        } else {
                            sVar2 = sVar;
                        }
                    }
                    z2 = false;
                    break;
            }
            sVar2.d(j);
            if (!z) {
                a(z2);
                return;
            }
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.a.a, io.netty.channel.a
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public b.a o() {
        return new C0105b(this, null);
    }

    /* compiled from: NioSocketChannel.java */
    /* renamed from: io.netty.channel.c.a.b$b, reason: collision with other inner class name */
    private final class C0105b extends a.C0101a {
        private C0105b() {
            super();
        }

        /* synthetic */ C0105b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.channel.a.AbstractC0100a
        protected Executor k() {
            try {
                if (!b.this.M().isOpen() || b.this.D().o() <= 0) {
                    return null;
                }
                b.this.v();
                return t.f4748a;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* compiled from: NioSocketChannel.java */
    private final class a extends io.netty.channel.c.c {
        /* synthetic */ a(b bVar, b bVar2, Socket socket, AnonymousClass1 anonymousClass1) {
            this(bVar2, socket);
        }

        private a(b bVar, Socket socket) {
            super(bVar, socket);
        }

        @Override // io.netty.channel.ab
        protected void k() {
            b.this.P();
        }
    }
}
