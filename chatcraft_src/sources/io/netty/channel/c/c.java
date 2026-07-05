package io.netty.channel.c;

import io.netty.b.j;
import io.netty.channel.ChannelException;
import io.netty.channel.ab;
import io.netty.channel.ap;
import io.netty.channel.ar;
import io.netty.channel.bc;
import io.netty.channel.r;
import io.netty.util.a.l;
import java.net.Socket;
import java.net.SocketException;

/* compiled from: DefaultSocketChannelConfig.java */
/* loaded from: classes.dex */
public class c extends ab implements h {

    /* renamed from: b, reason: collision with root package name */
    protected final Socket f4550b;
    private volatile boolean c;

    public c(g gVar, Socket socket) {
        super(gVar);
        if (socket == null) {
            throw new NullPointerException("javaSocket");
        }
        this.f4550b = socket;
        if (l.e()) {
            try {
                e(true);
            } catch (Exception unused) {
            }
        }
    }

    @Override // io.netty.channel.ab, io.netty.channel.e
    public <T> T a(r<T> rVar) {
        if (rVar == r.p) {
            return (T) Integer.valueOf(m());
        }
        if (rVar == r.o) {
            return (T) Integer.valueOf(n());
        }
        if (rVar == r.z) {
            return (T) Boolean.valueOf(s());
        }
        if (rVar == r.n) {
            return (T) Boolean.valueOf(q());
        }
        if (rVar == r.q) {
            return (T) Boolean.valueOf(r());
        }
        if (rVar == r.r) {
            return (T) Integer.valueOf(o());
        }
        if (rVar == r.u) {
            return (T) Integer.valueOf(p());
        }
        if (rVar == r.j) {
            return (T) Boolean.valueOf(t());
        }
        return (T) super.a(rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ab, io.netty.channel.e
    public <T> boolean a(r<T> rVar, T t) {
        b(rVar, t);
        if (rVar == r.p) {
            f(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.o) {
            g(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.z) {
            e(((Boolean) t).booleanValue());
            return true;
        }
        if (rVar == r.n) {
            c(((Boolean) t).booleanValue());
            return true;
        }
        if (rVar == r.q) {
            d(((Boolean) t).booleanValue());
            return true;
        }
        if (rVar == r.r) {
            h(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.u) {
            i(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.j) {
            f(((Boolean) t).booleanValue());
            return true;
        }
        return super.a((r<r<T>>) rVar, (r<T>) t);
    }

    public int m() {
        try {
            return this.f4550b.getReceiveBufferSize();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public int n() {
        try {
            return this.f4550b.getSendBufferSize();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.c.h
    public int o() {
        try {
            return this.f4550b.getSoLinger();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public int p() {
        try {
            return this.f4550b.getTrafficClass();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public boolean q() {
        try {
            return this.f4550b.getKeepAlive();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public boolean r() {
        try {
            return this.f4550b.getReuseAddress();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public boolean s() {
        try {
            return this.f4550b.getTcpNoDelay();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public h c(boolean z) {
        try {
            this.f4550b.setKeepAlive(z);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public h f(int i) {
        try {
            this.f4550b.setReceiveBufferSize(i);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public h d(boolean z) {
        try {
            this.f4550b.setReuseAddress(z);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public h g(int i) {
        try {
            this.f4550b.setSendBufferSize(i);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public h h(int i) {
        try {
            if (i < 0) {
                this.f4550b.setSoLinger(false, 0);
            } else {
                this.f4550b.setSoLinger(true, i);
            }
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public h e(boolean z) {
        try {
            this.f4550b.setTcpNoDelay(z);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public h i(int i) {
        try {
            this.f4550b.setTrafficClass(i);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public boolean t() {
        return this.c;
    }

    public h f(boolean z) {
        this.c = z;
        return this;
    }

    @Override // io.netty.channel.ab
    public h j(int i) {
        super.j(i);
        return this;
    }

    @Override // io.netty.channel.ab
    @Deprecated
    public h k(int i) {
        super.k(i);
        return this;
    }

    @Override // io.netty.channel.ab
    public h l(int i) {
        super.l(i);
        return this;
    }

    @Override // io.netty.channel.ab
    public h b(j jVar) {
        super.b(jVar);
        return this;
    }

    @Override // io.netty.channel.ab
    public h b(ar arVar) {
        super.b(arVar);
        return this;
    }

    @Override // io.netty.channel.ab, io.netty.channel.e
    public h g(boolean z) {
        super.g(z);
        return this;
    }

    @Override // io.netty.channel.ab
    public h h(boolean z) {
        super.h(z);
        return this;
    }

    @Override // io.netty.channel.ab
    public h m(int i) {
        super.m(i);
        return this;
    }

    @Override // io.netty.channel.ab
    public h n(int i) {
        super.n(i);
        return this;
    }

    @Override // io.netty.channel.ab
    public h b(bc bcVar) {
        super.b(bcVar);
        return this;
    }

    @Override // io.netty.channel.ab
    public h b(ap apVar) {
        super.b(apVar);
        return this;
    }
}
