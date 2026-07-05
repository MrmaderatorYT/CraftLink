package io.netty.channel.c;

import io.netty.b.j;
import io.netty.channel.ChannelException;
import io.netty.channel.ab;
import io.netty.channel.ap;
import io.netty.channel.ar;
import io.netty.channel.bc;
import io.netty.channel.r;
import io.netty.util.k;
import java.net.ServerSocket;
import java.net.SocketException;

/* compiled from: DefaultServerSocketChannelConfig.java */
/* loaded from: classes.dex */
public class b extends ab implements f {

    /* renamed from: b, reason: collision with root package name */
    protected final ServerSocket f4546b;
    private volatile int c;

    public b(e eVar, ServerSocket serverSocket) {
        super(eVar);
        this.c = k.e;
        if (serverSocket == null) {
            throw new NullPointerException("javaSocket");
        }
        this.f4546b = serverSocket;
    }

    @Override // io.netty.channel.ab, io.netty.channel.e
    public <T> T a(r<T> rVar) {
        if (rVar == r.p) {
            return (T) Integer.valueOf(n());
        }
        if (rVar == r.q) {
            return (T) Boolean.valueOf(m());
        }
        if (rVar == r.s) {
            return (T) Integer.valueOf(o());
        }
        return (T) super.a(rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ab, io.netty.channel.e
    public <T> boolean a(r<T> rVar, T t) throws SocketException {
        b(rVar, t);
        if (rVar == r.p) {
            f(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.q) {
            c(((Boolean) t).booleanValue());
            return true;
        }
        if (rVar == r.s) {
            g(((Integer) t).intValue());
            return true;
        }
        return super.a((r<r<T>>) rVar, (r<T>) t);
    }

    public boolean m() {
        try {
            return this.f4546b.getReuseAddress();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public f c(boolean z) throws SocketException {
        try {
            this.f4546b.setReuseAddress(z);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public int n() {
        try {
            return this.f4546b.getReceiveBufferSize();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public f f(int i) throws SocketException {
        try {
            this.f4546b.setReceiveBufferSize(i);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.c.f
    public int o() {
        return this.c;
    }

    public f g(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("backlog: " + i);
        }
        this.c = i;
        return this;
    }

    @Override // io.netty.channel.ab
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public f j(int i) {
        super.j(i);
        return this;
    }

    @Override // io.netty.channel.ab
    @Deprecated
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public f k(int i) {
        super.k(i);
        return this;
    }

    @Override // io.netty.channel.ab
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public f l(int i) {
        super.l(i);
        return this;
    }

    @Override // io.netty.channel.ab
    public f b(j jVar) {
        super.b(jVar);
        return this;
    }

    @Override // io.netty.channel.ab
    public f b(ar arVar) {
        super.b(arVar);
        return this;
    }

    @Override // io.netty.channel.ab, io.netty.channel.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public f g(boolean z) {
        super.g(z);
        return this;
    }

    @Override // io.netty.channel.ab
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public f m(int i) {
        super.m(i);
        return this;
    }

    @Override // io.netty.channel.ab
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f n(int i) {
        super.n(i);
        return this;
    }

    @Override // io.netty.channel.ab
    public f b(bc bcVar) {
        super.b(bcVar);
        return this;
    }

    @Override // io.netty.channel.ab
    public f b(ap apVar) {
        super.b(apVar);
        return this;
    }
}
