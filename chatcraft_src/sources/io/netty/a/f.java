package io.netty.a;

import io.netty.channel.al;
import io.netty.channel.av;
import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.j;
import io.netty.channel.l;
import io.netty.channel.o;
import io.netty.channel.p;
import io.netty.channel.r;
import io.netty.channel.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: ServerBootstrap.java */
/* loaded from: classes.dex */
public class f extends io.netty.a.a<f, av> {

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4356b = io.netty.util.a.b.d.a((Class<?>) f.class);
    private final Map<r<?>, Object> c;
    private final Map<io.netty.util.c<?>, Object> d;
    private final g e;
    private volatile al f;
    private volatile j g;

    public f() {
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new g(this);
    }

    private f(f fVar) {
        super(fVar);
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new g(this);
        this.f = fVar.f;
        this.g = fVar.g;
        synchronized (fVar.c) {
            this.c.putAll(fVar.c);
        }
        synchronized (fVar.d) {
            this.d.putAll(fVar.d);
        }
    }

    @Override // io.netty.a.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(al alVar) {
        return a(alVar, alVar);
    }

    public f a(al alVar, al alVar2) {
        super.a(alVar);
        if (alVar2 == null) {
            throw new NullPointerException("childGroup");
        }
        if (this.f != null) {
            throw new IllegalStateException("childGroup set already");
        }
        this.f = alVar2;
        return this;
    }

    public f b(j jVar) {
        if (jVar == null) {
            throw new NullPointerException("childHandler");
        }
        this.g = jVar;
        return this;
    }

    @Override // io.netty.a.a
    void a(io.netty.channel.d dVar) {
        final Map.Entry[] entryArr;
        final Map.Entry[] entryArr2;
        Map<r<?>, ?> mapG = g();
        synchronized (mapG) {
            dVar.D().a(mapG);
        }
        Map<io.netty.util.c<?>, Object> mapH = h();
        synchronized (mapH) {
            for (Map.Entry<io.netty.util.c<?>, Object> entry : mapH.entrySet()) {
                dVar.a((io.netty.util.c) entry.getKey()).set(entry.getValue());
            }
        }
        w wVarD = dVar.d();
        final al alVar = this.f;
        final j jVar = this.g;
        synchronized (this.c) {
            entryArr = (Map.Entry[]) this.c.entrySet().toArray(a(this.c.size()));
        }
        synchronized (this.d) {
            entryArr2 = (Map.Entry[]) this.d.entrySet().toArray(b(this.d.size()));
        }
        wVarD.a(new p<io.netty.channel.d>() { // from class: io.netty.a.f.1
            @Override // io.netty.channel.p
            public void initChannel(io.netty.channel.d dVar2) {
                final w wVarD2 = dVar2.d();
                j jVarC = f.this.e.c();
                if (jVarC != null) {
                    wVarD2.a(jVarC);
                }
                dVar2.f().execute(new Runnable() { // from class: io.netty.a.f.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        wVarD2.a(new a(alVar, jVar, entryArr, entryArr2));
                    }
                });
            }
        });
    }

    @Override // io.netty.a.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public f a() {
        super.a();
        if (this.g == null) {
            throw new IllegalStateException("childHandler not set");
        }
        if (this.f == null) {
            f4356b.c("childGroup is not set. Using parentGroup instead.");
            this.f = this.e.f();
        }
        return this;
    }

    private static Map.Entry<r<?>, Object>[] a(int i) {
        return new Map.Entry[i];
    }

    private static Map.Entry<io.netty.util.c<?>, Object>[] b(int i) {
        return new Map.Entry[i];
    }

    /* compiled from: ServerBootstrap.java */
    private static class a extends o {

        /* renamed from: a, reason: collision with root package name */
        private final al f4361a;

        /* renamed from: b, reason: collision with root package name */
        private final j f4362b;
        private final Map.Entry<r<?>, Object>[] c;
        private final Map.Entry<io.netty.util.c<?>, Object>[] d;

        a(al alVar, j jVar, Map.Entry<r<?>, Object>[] entryArr, Map.Entry<io.netty.util.c<?>, Object>[] entryArr2) {
            this.f4361a = alVar;
            this.f4362b = jVar;
            this.c = entryArr;
            this.d = entryArr2;
        }

        @Override // io.netty.channel.o, io.netty.channel.n
        public void channelRead(l lVar, Object obj) {
            final io.netty.channel.d dVar = (io.netty.channel.d) obj;
            dVar.d().a(this.f4362b);
            for (Map.Entry<r<?>, Object> entry : this.c) {
                try {
                    if (!dVar.D().a(entry.getKey(), entry.getValue())) {
                        f.f4356b.c("Unknown channel option: " + entry);
                    }
                } catch (Throwable th) {
                    f.f4356b.b("Failed to set a channel option: " + dVar, th);
                }
            }
            for (Map.Entry<io.netty.util.c<?>, Object> entry2 : this.d) {
                dVar.a((io.netty.util.c) entry2.getKey()).set(entry2.getValue());
            }
            try {
                this.f4361a.a(dVar).b(new i() { // from class: io.netty.a.f.a.1
                    @Override // io.netty.util.concurrent.r
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void operationComplete(h hVar) {
                        if (hVar.l()) {
                            return;
                        }
                        a.b(dVar, hVar.k());
                    }
                });
            } catch (Throwable th2) {
                b(dVar, th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(io.netty.channel.d dVar, Throwable th) {
            dVar.n().e();
            f.f4356b.b("Failed to register an accepted channel: " + dVar, th);
        }

        @Override // io.netty.channel.o, io.netty.channel.k, io.netty.channel.j
        public void exceptionCaught(l lVar, Throwable th) {
            final io.netty.channel.e eVarD = lVar.a().D();
            if (eVarD.e()) {
                eVarD.g(false);
                lVar.a().f().schedule(new Runnable() { // from class: io.netty.a.f.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        eVarD.g(true);
                    }
                }, 1L, TimeUnit.SECONDS);
            }
            lVar.a(th);
        }
    }

    @Override // io.netty.a.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public f clone() {
        return new f(this);
    }

    @Deprecated
    public al p() {
        return this.f;
    }

    final j q() {
        return this.g;
    }

    final Map<r<?>, Object> r() {
        return a(this.c);
    }

    final Map<io.netty.util.c<?>, Object> s() {
        return a(this.d);
    }

    @Override // io.netty.a.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final g f() {
        return this.e;
    }
}
