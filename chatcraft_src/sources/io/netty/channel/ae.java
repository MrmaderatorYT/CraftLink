package io.netty.channel;

import io.netty.channel.ap;
import io.netty.channel.d;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: DefaultChannelPipeline.java */
/* loaded from: classes.dex */
public class ae implements w {
    private final io.netty.channel.d h;
    private final h i;
    private final bb j;
    private Map<io.netty.util.concurrent.l, io.netty.util.concurrent.j> l;
    private ap.a m;
    private c o;
    private boolean p;
    static final /* synthetic */ boolean d = !ae.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    static final io.netty.util.a.b.c f4454a = io.netty.util.a.b.d.a((Class<?>) ae.class);
    private static final String e = a((Class<?>) a.class);
    private static final String f = a((Class<?>) e.class);
    private static final io.netty.util.concurrent.n<Map<Class<?>, String>> g = new io.netty.util.concurrent.n<Map<Class<?>, String>>() { // from class: io.netty.channel.ae.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Class<?>, String> b() {
            return new WeakHashMap();
        }
    };
    private final boolean k = io.netty.util.p.a();
    private boolean n = true;
    final io.netty.channel.b c = new e(this);

    /* renamed from: b, reason: collision with root package name */
    final io.netty.channel.b f4455b = new a(this);

    protected ae(io.netty.channel.d dVar) {
        this.h = (io.netty.channel.d) io.netty.util.a.j.a(dVar, "channel");
        this.i = new ay(dVar, null);
        this.j = new bb(dVar, true);
        this.f4455b.f4490a = this.c;
        this.c.f4491b = this.f4455b;
    }

    final ap.a e() {
        if (this.m == null) {
            this.m = this.h.D().i().a();
        }
        return this.m;
    }

    final Object a(Object obj, io.netty.channel.b bVar) {
        return this.k ? io.netty.util.m.a(obj, bVar) : obj;
    }

    private io.netty.channel.b c(io.netty.util.concurrent.l lVar, String str, j jVar) {
        return new ac(this, a(lVar), str, jVar);
    }

    private io.netty.util.concurrent.j a(io.netty.util.concurrent.l lVar) {
        if (lVar == null) {
            return null;
        }
        Boolean bool = (Boolean) this.h.D().a(r.B);
        if (bool != null && !bool.booleanValue()) {
            return lVar.c();
        }
        Map identityHashMap = this.l;
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap(4);
            this.l = identityHashMap;
        }
        io.netty.util.concurrent.j jVar = (io.netty.util.concurrent.j) identityHashMap.get(lVar);
        if (jVar != null) {
            return jVar;
        }
        io.netty.util.concurrent.j jVarC = lVar.c();
        identityHashMap.put(lVar, jVarC);
        return jVarC;
    }

    public final io.netty.channel.d f() {
        return this.h;
    }

    @Override // io.netty.channel.w
    public final w a(String str, j jVar) {
        return a((io.netty.util.concurrent.l) null, str, jVar);
    }

    public final w a(io.netty.util.concurrent.l lVar, String str, j jVar) {
        synchronized (this) {
            d(jVar);
            final io.netty.channel.b bVarC = c(lVar, c(str, jVar), jVar);
            b(bVarC);
            if (!this.p) {
                bVarC.s();
                b(bVarC, true);
                return this;
            }
            io.netty.util.concurrent.j jVarD = bVarC.d();
            if (!jVarD.k()) {
                bVarC.s();
                jVarD.execute(new Runnable() { // from class: io.netty.channel.ae.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ae.this.f(bVarC);
                    }
                });
                return this;
            }
            f(bVarC);
            return this;
        }
    }

    private void b(io.netty.channel.b bVar) {
        io.netty.channel.b bVar2 = this.f4455b.f4490a;
        bVar.f4491b = this.f4455b;
        bVar.f4490a = bVar2;
        this.f4455b.f4490a = bVar;
        bVar2.f4491b = bVar;
    }

    @Override // io.netty.channel.w
    public final w b(String str, j jVar) {
        return b((io.netty.util.concurrent.l) null, str, jVar);
    }

    public final w b(io.netty.util.concurrent.l lVar, String str, j jVar) {
        synchronized (this) {
            d(jVar);
            final io.netty.channel.b bVarC = c(lVar, c(str, jVar), jVar);
            c(bVarC);
            if (!this.p) {
                bVarC.s();
                b(bVarC, true);
                return this;
            }
            io.netty.util.concurrent.j jVarD = bVarC.d();
            if (!jVarD.k()) {
                bVarC.s();
                jVarD.execute(new Runnable() { // from class: io.netty.channel.ae.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ae.this.f(bVarC);
                    }
                });
                return this;
            }
            f(bVarC);
            return this;
        }
    }

    private void c(io.netty.channel.b bVar) {
        io.netty.channel.b bVar2 = this.c.f4491b;
        bVar.f4491b = bVar2;
        bVar.f4490a = this.c;
        bVar2.f4490a = bVar;
        this.c.f4491b = bVar;
    }

    @Override // io.netty.channel.w
    public final w a(String str, String str2, j jVar) {
        return a((io.netty.util.concurrent.l) null, str, str2, jVar);
    }

    public final w a(io.netty.util.concurrent.l lVar, String str, String str2, j jVar) {
        synchronized (this) {
            d(jVar);
            String strC = c(str2, jVar);
            io.netty.channel.b bVarF = f(str);
            final io.netty.channel.b bVarC = c(lVar, strC, jVar);
            a(bVarF, bVarC);
            if (!this.p) {
                bVarC.s();
                b(bVarC, true);
                return this;
            }
            io.netty.util.concurrent.j jVarD = bVarC.d();
            if (!jVarD.k()) {
                bVarC.s();
                jVarD.execute(new Runnable() { // from class: io.netty.channel.ae.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ae.this.f(bVarC);
                    }
                });
                return this;
            }
            f(bVarC);
            return this;
        }
    }

    private static void a(io.netty.channel.b bVar, io.netty.channel.b bVar2) {
        bVar2.f4491b = bVar.f4491b;
        bVar2.f4490a = bVar;
        bVar.f4491b.f4490a = bVar2;
        bVar.f4491b = bVar2;
    }

    private String c(String str, j jVar) {
        if (str == null) {
            return c(jVar);
        }
        d(str);
        return str;
    }

    @Override // io.netty.channel.w
    public final w a(j... jVarArr) {
        return a((io.netty.util.concurrent.l) null, jVarArr);
    }

    public final w a(io.netty.util.concurrent.l lVar, j... jVarArr) {
        if (jVarArr == null) {
            throw new NullPointerException("handlers");
        }
        for (j jVar : jVarArr) {
            if (jVar == null) {
                break;
            }
            b(lVar, (String) null, jVar);
        }
        return this;
    }

    private String c(j jVar) {
        Map<Class<?>, String> mapD = g.d();
        Class<?> cls = jVar.getClass();
        String strA = mapD.get(cls);
        if (strA == null) {
            strA = a(cls);
            mapD.put(cls, strA);
        }
        if (e(strA) != null) {
            int i = 1;
            String strSubstring = strA.substring(0, strA.length() - 1);
            while (true) {
                strA = strSubstring + i;
                if (e(strA) == null) {
                    break;
                }
                i++;
            }
        }
        return strA;
    }

    private static String a(Class<?> cls) {
        return io.netty.util.a.p.a(cls) + "#0";
    }

    @Override // io.netty.channel.w
    public final w a(j jVar) {
        d(e(jVar));
        return this;
    }

    @Override // io.netty.channel.w
    public final j a(String str) {
        return d(f(str)).v();
    }

    private io.netty.channel.b d(final io.netty.channel.b bVar) {
        if (!d && (bVar == this.f4455b || bVar == this.c)) {
            throw new AssertionError();
        }
        synchronized (this) {
            e(bVar);
            if (!this.p) {
                b(bVar, false);
                return bVar;
            }
            io.netty.util.concurrent.j jVarD = bVar.d();
            if (!jVarD.k()) {
                jVarD.execute(new Runnable() { // from class: io.netty.channel.ae.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ae.this.g(bVar);
                    }
                });
                return bVar;
            }
            g(bVar);
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(io.netty.channel.b bVar) {
        io.netty.channel.b bVar2 = bVar.f4491b;
        io.netty.channel.b bVar3 = bVar.f4490a;
        bVar2.f4490a = bVar3;
        bVar3.f4491b = bVar2;
    }

    @Override // io.netty.channel.w
    public final j b(String str, String str2, j jVar) {
        return a(f(str), str2, jVar);
    }

    private j a(final io.netty.channel.b bVar, String str, j jVar) {
        if (!d && (bVar == this.f4455b || bVar == this.c)) {
            throw new AssertionError();
        }
        synchronized (this) {
            d(jVar);
            if (str == null) {
                str = c(jVar);
            } else if (!bVar.e().equals(str)) {
                d(str);
            }
            final io.netty.channel.b bVarC = c(bVar.c, str, jVar);
            b(bVar, bVarC);
            if (!this.p) {
                b(bVarC, true);
                b(bVar, false);
                return bVar.v();
            }
            io.netty.util.concurrent.j jVarD = bVar.d();
            if (!jVarD.k()) {
                jVarD.execute(new Runnable() { // from class: io.netty.channel.ae.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ae.this.f(bVarC);
                        ae.this.g(bVar);
                    }
                });
                return bVar.v();
            }
            f(bVarC);
            g(bVar);
            return bVar.v();
        }
    }

    private static void b(io.netty.channel.b bVar, io.netty.channel.b bVar2) {
        io.netty.channel.b bVar3 = bVar.f4491b;
        io.netty.channel.b bVar4 = bVar.f4490a;
        bVar2.f4491b = bVar3;
        bVar2.f4490a = bVar4;
        bVar3.f4490a = bVar2;
        bVar4.f4491b = bVar2;
        bVar.f4491b = bVar2;
        bVar.f4490a = bVar2;
    }

    private static void d(j jVar) {
        if (jVar instanceof k) {
            k kVar = (k) jVar;
            if (!kVar.isSharable() && kVar.added) {
                throw new ChannelPipelineException(kVar.getClass().getName() + " is not a @Sharable handler, so can't be added or removed multiple times.");
            }
            kVar.added = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(io.netty.channel.b bVar) {
        try {
            bVar.v().handlerAdded(bVar);
            bVar.r();
        } catch (Throwable th) {
            boolean z = false;
            try {
                e(bVar);
                try {
                    bVar.v().handlerRemoved(bVar);
                    bVar.q();
                    z = true;
                } catch (Throwable th2) {
                    bVar.q();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (f4454a.c()) {
                    f4454a.b("Failed to remove a handler: " + bVar.e(), th3);
                }
            }
            if (z) {
                a((Throwable) new ChannelPipelineException(bVar.v().getClass().getName() + ".handlerAdded() has thrown an exception; removed.", th));
                return;
            }
            a((Throwable) new ChannelPipelineException(bVar.v().getClass().getName() + ".handlerAdded() has thrown an exception; also failed to remove.", th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(io.netty.channel.b bVar) {
        try {
            try {
                bVar.v().handlerRemoved(bVar);
                bVar.q();
            } catch (Throwable th) {
                bVar.q();
                throw th;
            }
        } catch (Throwable th2) {
            a((Throwable) new ChannelPipelineException(bVar.v().getClass().getName() + ".handlerRemoved() has thrown an exception.", th2));
        }
    }

    final void g() {
        if (!d && !this.h.f().k()) {
            throw new AssertionError();
        }
        if (this.n) {
            this.n = false;
            s();
        }
    }

    @Override // io.netty.channel.w
    public final j b(String str) {
        l lVarC = c(str);
        if (lVarC == null) {
            return null;
        }
        return lVarC.v();
    }

    public final l c(String str) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        return e(str);
    }

    @Override // io.netty.channel.w
    public final l b(j jVar) {
        if (jVar == null) {
            throw new NullPointerException("handler");
        }
        for (io.netty.channel.b bVar = this.f4455b.f4490a; bVar != null; bVar = bVar.f4490a) {
            if (bVar.v() == jVar) {
                return bVar;
            }
        }
        return null;
    }

    public final Map<String, j> h() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (io.netty.channel.b bVar = this.f4455b.f4490a; bVar != this.c; bVar = bVar.f4490a) {
            linkedHashMap.put(bVar.e(), bVar.v());
        }
        return linkedHashMap;
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<String, j>> iterator() {
        return h().entrySet().iterator();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(io.netty.util.a.p.a(this));
        sb.append('{');
        io.netty.channel.b bVar = this.f4455b.f4490a;
        while (bVar != this.c) {
            sb.append('(');
            sb.append(bVar.e());
            sb.append(" = ");
            sb.append(bVar.v().getClass().getName());
            sb.append(')');
            bVar = bVar.f4490a;
            if (bVar == this.c) {
                break;
            }
            sb.append(", ");
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // io.netty.channel.w
    public final w a() {
        io.netty.channel.b.a(this.f4455b);
        return this;
    }

    public final w i() {
        io.netty.channel.b.b(this.f4455b);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r() {
        a(this.f4455b.f4490a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final io.netty.channel.b bVar, boolean z) {
        Thread threadCurrentThread = Thread.currentThread();
        io.netty.channel.b bVar2 = this.c;
        while (bVar != bVar2) {
            io.netty.util.concurrent.j jVarD = bVar.d();
            if (!z && !jVarD.a(threadCurrentThread)) {
                jVarD.execute(new Runnable() { // from class: io.netty.channel.ae.7
                    @Override // java.lang.Runnable
                    public void run() {
                        ae.this.a(bVar, true);
                    }
                });
                return;
            } else {
                bVar = bVar.f4490a;
                z = false;
            }
        }
        a(threadCurrentThread, bVar2.f4491b, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Thread thread, final io.netty.channel.b bVar, boolean z) {
        io.netty.channel.b bVar2 = this.f4455b;
        while (bVar != bVar2) {
            io.netty.util.concurrent.j jVarD = bVar.d();
            if (z || jVarD.a(thread)) {
                synchronized (this) {
                    e(bVar);
                }
                g(bVar);
                bVar = bVar.f4491b;
                z = false;
            } else {
                jVarD.execute(new Runnable() { // from class: io.netty.channel.ae.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ae.this.a(Thread.currentThread(), bVar, true);
                    }
                });
                return;
            }
        }
    }

    @Override // io.netty.channel.w
    public final w b() {
        io.netty.channel.b.c(this.f4455b);
        return this;
    }

    public final w k() {
        io.netty.channel.b.d(this.f4455b);
        return this;
    }

    @Override // io.netty.channel.w
    public final w a(Throwable th) {
        io.netty.channel.b.a(this.f4455b, th);
        return this;
    }

    @Override // io.netty.channel.w
    public final w b(Object obj) {
        io.netty.channel.b.a(this.f4455b, obj);
        return this;
    }

    @Override // io.netty.channel.w
    public final w c(Object obj) {
        io.netty.channel.b.b(this.f4455b, obj);
        return this;
    }

    @Override // io.netty.channel.w
    public final w c() {
        io.netty.channel.b.e(this.f4455b);
        return this;
    }

    @Override // io.netty.channel.w
    public final w d() {
        io.netty.channel.b.f(this.f4455b);
        return this;
    }

    @Override // io.netty.channel.v
    public final h j() {
        return this.c.j();
    }

    public final w l() {
        this.c.o();
        return this;
    }

    @Override // io.netty.channel.v
    public final h a(SocketAddress socketAddress, z zVar) {
        return this.c.a(socketAddress, zVar);
    }

    @Override // io.netty.channel.v
    public final h b(SocketAddress socketAddress, z zVar) {
        return this.c.b(socketAddress, zVar);
    }

    @Override // io.netty.channel.v
    public final h a(SocketAddress socketAddress, SocketAddress socketAddress2, z zVar) {
        return this.c.a(socketAddress, socketAddress2, zVar);
    }

    @Override // io.netty.channel.v
    public final h a(z zVar) {
        return this.c.a(zVar);
    }

    @Override // io.netty.channel.v
    public final h b(z zVar) {
        return this.c.b(zVar);
    }

    @Override // io.netty.channel.v
    public final h c(z zVar) {
        return this.c.c(zVar);
    }

    public final w n() {
        this.c.n();
        return this;
    }

    @Override // io.netty.channel.v
    public final h a(Object obj, z zVar) {
        return this.c.a(obj, zVar);
    }

    @Override // io.netty.channel.v
    public final h a(Object obj) {
        return this.c.a(obj);
    }

    @Override // io.netty.channel.v
    public final z m() {
        return new af(this.h);
    }

    @Override // io.netty.channel.v
    public final z p() {
        return this.j;
    }

    private void d(String str) {
        if (e(str) == null) {
            return;
        }
        throw new IllegalArgumentException("Duplicate handler name: " + str);
    }

    private io.netty.channel.b e(String str) {
        for (io.netty.channel.b bVar = this.f4455b.f4490a; bVar != this.c; bVar = bVar.f4490a) {
            if (bVar.e().equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    private io.netty.channel.b f(String str) {
        io.netty.channel.b bVar = (io.netty.channel.b) c(str);
        if (bVar != null) {
            return bVar;
        }
        throw new NoSuchElementException(str);
    }

    private io.netty.channel.b e(j jVar) {
        io.netty.channel.b bVar = (io.netty.channel.b) b(jVar);
        if (bVar != null) {
            return bVar;
        }
        throw new NoSuchElementException(jVar.getClass().getName());
    }

    private void s() {
        c cVar;
        synchronized (this) {
            if (!d && this.p) {
                throw new AssertionError();
            }
            this.p = true;
            this.o = null;
        }
        for (cVar = this.o; cVar != null; cVar = cVar.c) {
            cVar.a();
        }
    }

    private void b(io.netty.channel.b bVar, boolean z) {
        if (!d && this.p) {
            throw new AssertionError();
        }
        c bVar2 = z ? new b(bVar) : new d(bVar);
        c cVar = this.o;
        if (cVar == null) {
            this.o = bVar2;
            return;
        }
        while (cVar.c != null) {
            cVar = cVar.c;
        }
        cVar.c = bVar2;
    }

    protected void b(Throwable th) {
        try {
            f4454a.b("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", th);
        } finally {
            io.netty.util.m.a(th);
        }
    }

    protected void d(Object obj) {
        try {
            f4454a.b("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", obj);
        } finally {
            io.netty.util.m.a(obj);
        }
    }

    /* compiled from: DefaultChannelPipeline.java */
    final class e extends io.netty.channel.b implements n {
        @Override // io.netty.channel.n
        public void channelActive(l lVar) {
        }

        @Override // io.netty.channel.n
        public void channelInactive(l lVar) {
        }

        @Override // io.netty.channel.n
        public void channelReadComplete(l lVar) {
        }

        @Override // io.netty.channel.n
        public void channelRegistered(l lVar) {
        }

        @Override // io.netty.channel.n
        public void channelUnregistered(l lVar) {
        }

        @Override // io.netty.channel.n
        public void channelWritabilityChanged(l lVar) {
        }

        @Override // io.netty.channel.j
        public void handlerAdded(l lVar) {
        }

        @Override // io.netty.channel.j
        public void handlerRemoved(l lVar) {
        }

        @Override // io.netty.channel.l
        public j v() {
            return this;
        }

        e(ae aeVar) {
            super(aeVar, null, ae.f, true, false);
            r();
        }

        @Override // io.netty.channel.n
        public void userEventTriggered(l lVar, Object obj) {
            io.netty.util.m.a(obj);
        }

        @Override // io.netty.channel.j
        public void exceptionCaught(l lVar, Throwable th) {
            ae.this.b(th);
        }

        @Override // io.netty.channel.n
        public void channelRead(l lVar, Object obj) {
            ae.this.d(obj);
        }
    }

    /* compiled from: DefaultChannelPipeline.java */
    final class a extends io.netty.channel.b implements n, t {
        private final d.a f;

        @Override // io.netty.channel.j
        public void handlerAdded(l lVar) {
        }

        @Override // io.netty.channel.j
        public void handlerRemoved(l lVar) {
        }

        @Override // io.netty.channel.l
        public j v() {
            return this;
        }

        a(ae aeVar) {
            super(aeVar, null, ae.e, false, true);
            this.f = aeVar.f().n();
            r();
        }

        @Override // io.netty.channel.t
        public void bind(l lVar, SocketAddress socketAddress, z zVar) {
            this.f.a(socketAddress, zVar);
        }

        @Override // io.netty.channel.t
        public void connect(l lVar, SocketAddress socketAddress, SocketAddress socketAddress2, z zVar) {
            this.f.a(socketAddress, socketAddress2, zVar);
        }

        @Override // io.netty.channel.t
        public void disconnect(l lVar, z zVar) {
            this.f.a(zVar);
        }

        @Override // io.netty.channel.t
        public void close(l lVar, z zVar) {
            this.f.b(zVar);
        }

        @Override // io.netty.channel.t
        public void deregister(l lVar, z zVar) {
            this.f.c(zVar);
        }

        @Override // io.netty.channel.t
        public void read(l lVar) {
            this.f.f();
        }

        @Override // io.netty.channel.t
        public void write(l lVar, Object obj, z zVar) {
            this.f.a(obj, zVar);
        }

        @Override // io.netty.channel.t
        public void flush(l lVar) {
            this.f.g();
        }

        @Override // io.netty.channel.j
        public void exceptionCaught(l lVar, Throwable th) {
            lVar.a(th);
        }

        @Override // io.netty.channel.n
        public void channelRegistered(l lVar) {
            ae.this.g();
            lVar.f();
        }

        @Override // io.netty.channel.n
        public void channelUnregistered(l lVar) {
            lVar.g();
            if (ae.this.h.E()) {
                return;
            }
            ae.this.r();
        }

        @Override // io.netty.channel.n
        public void channelActive(l lVar) {
            lVar.h();
            w();
        }

        @Override // io.netty.channel.n
        public void channelInactive(l lVar) {
            lVar.i();
        }

        @Override // io.netty.channel.n
        public void channelRead(l lVar, Object obj) {
            lVar.c(obj);
        }

        @Override // io.netty.channel.n
        public void channelReadComplete(l lVar) {
            lVar.k();
            w();
        }

        private void w() {
            if (ae.this.h.D().e()) {
                ae.this.h.l();
            }
        }

        @Override // io.netty.channel.n
        public void userEventTriggered(l lVar, Object obj) {
            lVar.b(obj);
        }

        @Override // io.netty.channel.n
        public void channelWritabilityChanged(l lVar) {
            lVar.l();
        }
    }

    /* compiled from: DefaultChannelPipeline.java */
    private static abstract class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final io.netty.channel.b f4471b;
        c c;

        abstract void a();

        c(io.netty.channel.b bVar) {
            this.f4471b = bVar;
        }
    }

    /* compiled from: DefaultChannelPipeline.java */
    private final class b extends c {
        b(io.netty.channel.b bVar) {
            super(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            ae.this.f(this.f4471b);
        }

        @Override // io.netty.channel.ae.c
        void a() {
            io.netty.util.concurrent.j jVarD = this.f4471b.d();
            if (jVarD.k()) {
                ae.this.f(this.f4471b);
                return;
            }
            try {
                jVarD.execute(this);
            } catch (RejectedExecutionException e) {
                if (ae.f4454a.c()) {
                    ae.f4454a.b("Can't invoke handlerAdded() as the EventExecutor {} rejected it, removing handler {}.", jVarD, this.f4471b.e(), e);
                }
                ae.e(this.f4471b);
                this.f4471b.q();
            }
        }
    }

    /* compiled from: DefaultChannelPipeline.java */
    private final class d extends c {
        d(io.netty.channel.b bVar) {
            super(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            ae.this.g(this.f4471b);
        }

        @Override // io.netty.channel.ae.c
        void a() {
            io.netty.util.concurrent.j jVarD = this.f4471b.d();
            if (jVarD.k()) {
                ae.this.g(this.f4471b);
                return;
            }
            try {
                jVarD.execute(this);
            } catch (RejectedExecutionException e) {
                if (ae.f4454a.c()) {
                    ae.f4454a.b("Can't invoke handlerRemoved() as the EventExecutor {} rejected it, removing handler {}.", jVarD, this.f4471b.e(), e);
                }
                this.f4471b.q();
            }
        }
    }
}
