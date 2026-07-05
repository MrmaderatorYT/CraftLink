package io.netty.channel.c.a;

import io.netty.channel.ChannelException;
import io.netty.channel.a.c;
import io.netty.channel.c.e;
import io.netty.channel.c.f;
import io.netty.channel.q;
import io.netty.channel.s;
import io.netty.util.a.b.d;
import io.netty.util.a.l;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.List;

/* compiled from: NioServerSocketChannel.java */
/* loaded from: classes.dex */
public class a extends c implements e {
    private static final q f = new q(false, 16);
    private static final SelectorProvider g = SelectorProvider.provider();
    private static final io.netty.util.a.b.c h = d.a((Class<?>) a.class);
    private final f i;

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public InetSocketAddress h() {
        return null;
    }

    @Override // io.netty.channel.a
    protected SocketAddress r() {
        return null;
    }

    private static ServerSocketChannel a(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openServerSocketChannel();
        } catch (IOException e) {
            throw new ChannelException("Failed to open a server socket.", e);
        }
    }

    public a() {
        this(a(g));
    }

    public a(ServerSocketChannel serverSocketChannel) {
        super(null, serverSocketChannel, 16);
        this.i = new C0104a(this, M().socket());
    }

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public InetSocketAddress g() {
        return (InetSocketAddress) super.g();
    }

    @Override // io.netty.channel.d
    public q G() {
        return f;
    }

    @Override // io.netty.channel.d
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public f D() {
        return this.i;
    }

    @Override // io.netty.channel.d
    public boolean F() {
        return M().socket().isBound();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.a.b
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public ServerSocketChannel M() {
        return (ServerSocketChannel) super.M();
    }

    @Override // io.netty.channel.a
    protected SocketAddress q() {
        return M().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.a
    protected void a(SocketAddress socketAddress) throws IOException {
        if (l.d() >= 7) {
            M().bind(socketAddress, this.i.o());
        } else {
            M().socket().bind(socketAddress, this.i.o());
        }
    }

    @Override // io.netty.channel.a.b, io.netty.channel.a
    protected void u() {
        M().close();
    }

    @Override // io.netty.channel.a.c
    protected int a(List<Object> list) throws IOException {
        SocketChannel socketChannelAccept = M().accept();
        if (socketChannelAccept == null) {
            return 0;
        }
        try {
            list.add(new b(this, socketChannelAccept));
            return 1;
        } catch (Throwable th) {
            h.b("Failed to create a new channel from an accepted socket.", th);
            try {
                socketChannelAccept.close();
                return 0;
            } catch (Throwable th2) {
                h.b("Failed to close a socket.", th2);
                return 0;
            }
        }
    }

    @Override // io.netty.channel.a.b
    protected boolean a(SocketAddress socketAddress, SocketAddress socketAddress2) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.a.b
    protected void Q() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.a
    protected void t() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.a.c
    protected boolean a(Object obj, s sVar) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.a
    protected final Object b(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* compiled from: NioServerSocketChannel.java */
    /* renamed from: io.netty.channel.c.a.a$a, reason: collision with other inner class name */
    private final class C0104a extends io.netty.channel.c.b {
        private C0104a(a aVar, ServerSocket serverSocket) {
            super(aVar, serverSocket);
        }

        @Override // io.netty.channel.ab
        protected void k() {
            a.this.P();
        }
    }
}
