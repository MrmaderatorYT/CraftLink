package io.netty.a;

import io.netty.a.a;
import io.netty.channel.af;
import io.netty.channel.al;
import io.netty.channel.as;
import io.netty.channel.d;
import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.j;
import io.netty.channel.r;
import io.netty.channel.z;
import io.netty.util.a.p;
import io.netty.util.concurrent.t;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: AbstractBootstrap.java */
/* loaded from: classes.dex */
public abstract class a<B extends a<B, C>, C extends io.netty.channel.d> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    volatile al f4341a;

    /* renamed from: b, reason: collision with root package name */
    private volatile e<? extends C> f4342b;
    private volatile SocketAddress c;
    private final Map<r<?>, Object> d = new LinkedHashMap();
    private final Map<io.netty.util.c<?>, Object> e = new LinkedHashMap();
    private volatile j f;

    abstract void a(io.netty.channel.d dVar);

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract B clone();

    public abstract b<B, C> f();

    a() {
    }

    a(a<B, C> aVar) {
        this.f4341a = aVar.f4341a;
        this.f4342b = aVar.f4342b;
        this.f = aVar.f;
        this.c = aVar.c;
        synchronized (aVar.d) {
            this.d.putAll(aVar.d);
        }
        synchronized (aVar.e) {
            this.e.putAll(aVar.e);
        }
    }

    public B a(al alVar) {
        if (alVar == null) {
            throw new NullPointerException("group");
        }
        if (this.f4341a != null) {
            throw new IllegalStateException("group set already");
        }
        this.f4341a = alVar;
        return this;
    }

    public B a(Class<? extends C> cls) {
        if (cls == null) {
            throw new NullPointerException("channelClass");
        }
        return (B) a((io.netty.channel.g) new as(cls));
    }

    @Deprecated
    public B a(e<? extends C> eVar) {
        if (eVar == null) {
            throw new NullPointerException("channelFactory");
        }
        if (this.f4342b != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.f4342b = eVar;
        return this;
    }

    public B a(io.netty.channel.g<? extends C> gVar) {
        return (B) a((e) gVar);
    }

    public B a(SocketAddress socketAddress) {
        this.c = socketAddress;
        return this;
    }

    public B a(String str, int i) {
        return (B) a(new InetSocketAddress(str, i));
    }

    public <T> B a(r<T> rVar, T t) {
        if (rVar == null) {
            throw new NullPointerException("option");
        }
        if (t == null) {
            synchronized (this.d) {
                this.d.remove(rVar);
            }
        } else {
            synchronized (this.d) {
                this.d.put(rVar, t);
            }
        }
        return this;
    }

    public B a() {
        if (this.f4341a == null) {
            throw new IllegalStateException("group not set");
        }
        if (this.f4342b != null) {
            return this;
        }
        throw new IllegalStateException("channel or channelFactory not set");
    }

    public h c() {
        a();
        SocketAddress socketAddress = this.c;
        if (socketAddress == null) {
            throw new IllegalStateException("localAddress not set");
        }
        return b(socketAddress);
    }

    private h b(final SocketAddress socketAddress) {
        final h hVarD = d();
        final io.netty.channel.d dVarE = hVarD.e();
        if (hVarD.k() != null) {
            return hVarD;
        }
        if (hVarD.isDone()) {
            z zVarM = dVarE.m();
            b(hVarD, dVarE, socketAddress, zVarM);
            return zVarM;
        }
        final C0097a c0097a = new C0097a(dVarE);
        hVarD.b(new i() { // from class: io.netty.a.a.1
            @Override // io.netty.util.concurrent.r
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(h hVar) {
                Throwable thK = hVar.k();
                if (thK != null) {
                    c0097a.c(thK);
                } else {
                    c0097a.a();
                    a.b(hVarD, dVarE, socketAddress, c0097a);
                }
            }
        });
        return c0097a;
    }

    final h d() {
        io.netty.channel.d dVar = null;
        try {
            io.netty.channel.d dVarNewChannel = this.f4342b.newChannel();
            try {
                a(dVarNewChannel);
                h hVarA = f().f().a(dVarNewChannel);
                if (hVarA.k() != null) {
                    if (dVarNewChannel.i()) {
                        dVarNewChannel.j();
                    } else {
                        dVarNewChannel.n().e();
                    }
                }
                return hVarA;
            } catch (Throwable th) {
                th = th;
                dVar = dVarNewChannel;
                if (dVar != null) {
                    dVar.n().e();
                }
                return new af(dVar, t.f4748a).c(th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final h hVar, final io.netty.channel.d dVar, final SocketAddress socketAddress, final z zVar) {
        dVar.f().execute(new Runnable() { // from class: io.netty.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (hVar.l()) {
                    dVar.a(socketAddress, zVar).b(i.g);
                } else {
                    zVar.c(hVar.k());
                }
            }
        });
    }

    public B a(j jVar) {
        if (jVar == null) {
            throw new NullPointerException("handler");
        }
        this.f = jVar;
        return this;
    }

    @Deprecated
    public final al e() {
        return this.f4341a;
    }

    static <K, V> Map<K, V> a(Map<K, V> map) {
        synchronized (map) {
            if (map.isEmpty()) {
                return Collections.emptyMap();
            }
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
    }

    final Map<r<?>, Object> g() {
        return this.d;
    }

    final Map<io.netty.util.c<?>, Object> h() {
        return this.e;
    }

    final SocketAddress i() {
        return this.c;
    }

    final e<? extends C> j() {
        return this.f4342b;
    }

    final j k() {
        return this.f;
    }

    final Map<r<?>, Object> l() {
        return a(this.d);
    }

    final Map<io.netty.util.c<?>, Object> m() {
        return a(this.e);
    }

    public String toString() {
        return p.a(this) + '(' + f() + ')';
    }

    /* compiled from: AbstractBootstrap.java */
    /* renamed from: io.netty.a.a$a, reason: collision with other inner class name */
    static final class C0097a extends af {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f4347a;

        C0097a(io.netty.channel.d dVar) {
            super(dVar);
        }

        void a() {
            this.f4347a = true;
        }

        @Override // io.netty.channel.af, io.netty.util.concurrent.h
        protected io.netty.util.concurrent.j b() {
            if (this.f4347a) {
                return super.b();
            }
            return t.f4748a;
        }
    }
}
