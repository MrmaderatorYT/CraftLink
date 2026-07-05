package io.netty.channel.c.b;

import io.netty.b.j;
import io.netty.channel.ChannelException;
import io.netty.channel.ap;
import io.netty.channel.ar;
import io.netty.channel.bc;
import io.netty.channel.r;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/* compiled from: DefaultOioSocketChannelConfig.java */
/* loaded from: classes.dex */
public class a extends io.netty.channel.c.c implements c {
    a(b bVar, Socket socket) {
        super(bVar, socket);
    }

    @Override // io.netty.channel.c.c, io.netty.channel.ab, io.netty.channel.e
    public <T> T a(r<T> rVar) {
        if (rVar == r.t) {
            return (T) Integer.valueOf(u());
        }
        return (T) super.a(rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.c.c, io.netty.channel.ab, io.netty.channel.e
    public <T> boolean a(r<T> rVar, T t) throws SocketException {
        b(rVar, t);
        if (rVar == r.t) {
            o(((Integer) t).intValue());
            return true;
        }
        return super.a((r<r<T>>) rVar, (r<T>) t);
    }

    public c o(int i) throws SocketException {
        try {
            this.f4550b.setSoTimeout(i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int u() {
        try {
            return this.f4550b.getSoTimeout();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.c.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c e(boolean z) {
        super.e(z);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public c h(int i) {
        super.h(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public c g(int i) {
        super.g(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public c f(int i) {
        super.f(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public c c(boolean z) {
        super.c(z);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public c i(int i) {
        super.i(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c d(boolean z) {
        super.d(z);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c f(boolean z) {
        super.f(z);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: t, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c j(int i) {
        super.j(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    @Deprecated
    /* renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c k(int i) {
        super.k(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: v, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c l(int i) {
        super.l(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c b(j jVar) {
        super.b(jVar);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c b(ar arVar) {
        super.b(arVar);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c g(boolean z) {
        super.g(z);
        return this;
    }

    @Override // io.netty.channel.ab
    protected void k() {
        if (this.f4451a instanceof b) {
            ((b) this.f4451a).P();
        }
    }

    @Override // io.netty.channel.c.c
    /* renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c h(boolean z) {
        super.h(z);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m(int i) {
        super.m(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c n(int i) {
        super.n(i);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c b(bc bcVar) {
        super.b(bcVar);
        return this;
    }

    @Override // io.netty.channel.c.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c b(ap apVar) {
        super.b(apVar);
        return this;
    }
}
