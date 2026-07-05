package io.netty.channel.c.b;

import io.netty.b.i;
import io.netty.channel.ChannelException;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.ak;
import io.netty.channel.c.g;
import io.netty.channel.h;
import io.netty.channel.z;
import io.netty.util.a.b.d;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

/* compiled from: OioSocketChannel.java */
/* loaded from: classes.dex */
public class b extends io.netty.channel.b.c implements g {

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4547b = d.a((Class<?>) b.class);
    private final Socket c;
    private final c d;

    public b() {
        this(new Socket());
    }

    public b(Socket socket) {
        this(null, socket);
    }

    public b(io.netty.channel.d dVar, Socket socket) throws IOException {
        super(dVar);
        this.c = socket;
        this.d = new a(this, socket);
        try {
            try {
                if (socket.isConnected()) {
                    a(socket.getInputStream(), socket.getOutputStream());
                }
                socket.setSoTimeout(1000);
            } catch (Throwable th) {
                try {
                    socket.close();
                } catch (IOException e) {
                    f4547b.b("Failed to close a socket.", (Throwable) e);
                }
                throw th;
            }
        } catch (Exception e2) {
            throw new ChannelException("failed to initialize a socket", e2);
        }
    }

    @Override // io.netty.channel.d
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public c D() {
        return this.d;
    }

    @Override // io.netty.channel.d
    public boolean E() {
        return !this.c.isClosed();
    }

    @Override // io.netty.channel.b.c, io.netty.channel.d
    public boolean F() {
        return !this.c.isClosed() && this.c.isConnected();
    }

    @Override // io.netty.channel.b.a
    public boolean H() {
        return this.c.isInputShutdown() || !F();
    }

    @Override // io.netty.channel.b.a
    public h I() {
        return d(m());
    }

    @Override // io.netty.channel.b.c, io.netty.channel.b.a
    protected int a(i iVar) {
        if (this.c.isClosed()) {
            return -1;
        }
        try {
            return super.a(iVar);
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    public h d(final z zVar) {
        ak akVarF = f();
        if (akVarF.k()) {
            e(zVar);
        } else {
            akVarF.execute(new Runnable() { // from class: io.netty.channel.c.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.e(zVar);
                }
            });
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(z zVar) {
        try {
            this.c.shutdownInput();
            zVar.v_();
        } catch (Throwable th) {
            zVar.c(th);
        }
    }

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public InetSocketAddress g() {
        return (InetSocketAddress) super.g();
    }

    @Override // io.netty.channel.a, io.netty.channel.d
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public InetSocketAddress h() {
        return (InetSocketAddress) super.h();
    }

    @Override // io.netty.channel.a
    protected SocketAddress q() {
        return this.c.getLocalSocketAddress();
    }

    @Override // io.netty.channel.a
    protected SocketAddress r() {
        return this.c.getRemoteSocketAddress();
    }

    @Override // io.netty.channel.a
    protected void a(SocketAddress socketAddress) throws IOException {
        this.c.bind(socketAddress);
    }

    @Override // io.netty.channel.b.b
    protected void a(SocketAddress socketAddress, SocketAddress socketAddress2) throws IOException {
        if (socketAddress2 != null) {
            this.c.bind(socketAddress2);
        }
        try {
            try {
                this.c.connect(socketAddress, D().a());
                a(this.c.getInputStream(), this.c.getOutputStream());
            } catch (SocketTimeoutException e) {
                ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
                connectTimeoutException.setStackTrace(e.getStackTrace());
                throw connectTimeoutException;
            }
        } catch (Throwable th) {
            u();
            throw th;
        }
    }

    @Override // io.netty.channel.a
    protected void t() throws IOException {
        u();
    }

    @Override // io.netty.channel.b.c, io.netty.channel.a
    protected void u() throws IOException {
        this.c.close();
    }

    final void P() {
        L();
    }
}
