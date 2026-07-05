package io.netty.a;

import io.netty.a.a;
import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.z;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.q;
import io.netty.util.concurrent.r;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;

/* compiled from: Bootstrap.java */
/* loaded from: classes.dex */
public class c extends a<c, io.netty.channel.d> {

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4349b = io.netty.util.a.b.d.a((Class<?>) c.class);
    private static final io.netty.resolver.c<?> c = io.netty.resolver.d.f4615a;
    private final d d;
    private volatile io.netty.resolver.c<SocketAddress> e;
    private volatile SocketAddress f;

    public c() {
        this.d = new d(this);
        this.e = c;
    }

    private c(c cVar) {
        super(cVar);
        this.d = new d(this);
        this.e = c;
        this.e = cVar.e;
        this.f = cVar.f;
    }

    public c b(String str, int i) {
        this.f = InetSocketAddress.createUnresolved(str, i);
        return this;
    }

    public h n() {
        a();
        SocketAddress socketAddress = this.f;
        if (socketAddress == null) {
            throw new IllegalStateException("remoteAddress not set");
        }
        return a(socketAddress, this.d.a());
    }

    private h a(final SocketAddress socketAddress, final SocketAddress socketAddress2) {
        h hVarD = d();
        final io.netty.channel.d dVarE = hVarD.e();
        if (hVarD.isDone()) {
            return !hVarD.l() ? hVarD : a(dVarE, socketAddress, socketAddress2, dVarE.m());
        }
        final a.C0097a c0097a = new a.C0097a(dVarE);
        hVarD.b(new i() { // from class: io.netty.a.c.1
            @Override // io.netty.util.concurrent.r
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(h hVar) {
                Throwable thK = hVar.k();
                if (thK != null) {
                    c0097a.c(thK);
                } else {
                    c0097a.a();
                    c.this.a(dVarE, socketAddress, socketAddress2, c0097a);
                }
            }
        });
        return c0097a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(final io.netty.channel.d dVar, SocketAddress socketAddress, final SocketAddress socketAddress2, final z zVar) {
        io.netty.resolver.b<T> bVarA;
        try {
            bVarA = this.e.a(dVar.f());
        } catch (Throwable th) {
            zVar.b(th);
        }
        if (bVarA.a(socketAddress) && !bVarA.b(socketAddress)) {
            p pVarD = bVarA.d(socketAddress);
            if (pVarD.isDone()) {
                Throwable thK = pVarD.k();
                if (thK != null) {
                    dVar.j();
                    zVar.c(thK);
                } else {
                    b((SocketAddress) pVarD.j(), socketAddress2, zVar);
                }
                return zVar;
            }
            pVarD.b(new q<SocketAddress>() { // from class: io.netty.a.c.2
                @Override // io.netty.util.concurrent.r
                public void operationComplete(p<SocketAddress> pVar) {
                    if (pVar.k() == null) {
                        c.b(pVar.j(), socketAddress2, zVar);
                    } else {
                        dVar.j();
                        zVar.c(pVar.k());
                    }
                }
            });
            return zVar;
        }
        b(socketAddress, socketAddress2, zVar);
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final SocketAddress socketAddress, final SocketAddress socketAddress2, final z zVar) {
        final io.netty.channel.d dVarE = zVar.e();
        dVarE.f().execute(new Runnable() { // from class: io.netty.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (socketAddress2 == null) {
                    dVarE.b(socketAddress, zVar);
                } else {
                    dVarE.a(socketAddress, socketAddress2, zVar);
                }
                zVar.b((r<? extends p<? super Void>>) i.g);
            }
        });
    }

    @Override // io.netty.a.a
    void a(io.netty.channel.d dVar) {
        dVar.d().a(this.d.c());
        Map<io.netty.channel.r<?>, Object> mapG = g();
        synchronized (mapG) {
            for (Map.Entry<io.netty.channel.r<?>, Object> entry : mapG.entrySet()) {
                try {
                    if (!dVar.D().a(entry.getKey(), entry.getValue())) {
                        f4349b.c("Unknown channel option: " + entry);
                    }
                } catch (Throwable th) {
                    f4349b.b("Failed to set a channel option: " + dVar, th);
                }
            }
        }
        Map<io.netty.util.c<?>, Object> mapH = h();
        synchronized (mapH) {
            for (Map.Entry<io.netty.util.c<?>, Object> entry2 : mapH.entrySet()) {
                dVar.a((io.netty.util.c) entry2.getKey()).set(entry2.getValue());
            }
        }
    }

    @Override // io.netty.a.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public c a() {
        super.a();
        if (this.d.c() != null) {
            return this;
        }
        throw new IllegalStateException("handler not set");
    }

    @Override // io.netty.a.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public c clone() {
        return new c(this);
    }

    @Override // io.netty.a.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final d f() {
        return this.d;
    }

    final SocketAddress r() {
        return this.f;
    }

    final io.netty.resolver.c<?> s() {
        return this.e;
    }
}
