package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.g;

/* compiled from: Http2Connection.java */
/* loaded from: classes.dex */
public final class f implements Closeable {
    static final /* synthetic */ boolean r = !f.class.desiredAssertionStatus();
    private static final ExecutorService s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Http2Connection", true));

    /* renamed from: a, reason: collision with root package name */
    final boolean f5186a;

    /* renamed from: b, reason: collision with root package name */
    final b f5187b;
    final String d;
    int e;
    int f;
    boolean g;
    final k h;
    long j;
    final Socket n;
    final i o;
    final d p;
    private final ScheduledExecutorService t;
    private final ExecutorService u;
    private boolean v;
    final Map<Integer, h> c = new LinkedHashMap();
    long i = 0;
    l k = new l();
    final l l = new l();
    boolean m = false;
    final Set<Integer> q = new LinkedHashSet();

    /* compiled from: Http2Connection.java */
    public static abstract class b {
        public static final b f = new b() { // from class: okhttp3.internal.http2.f.b.1
            @Override // okhttp3.internal.http2.f.b
            public void a(h hVar) {
                hVar.a(okhttp3.internal.http2.a.REFUSED_STREAM);
            }
        };

        public void a(f fVar) {
        }

        public abstract void a(h hVar);
    }

    boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    f(a aVar) {
        this.h = aVar.f;
        this.f5186a = aVar.g;
        this.f5187b = aVar.e;
        this.f = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.f += 2;
        }
        if (aVar.g) {
            this.k.a(7, 16777216);
        }
        this.d = aVar.f5195b;
        this.t = new ScheduledThreadPoolExecutor(1, okhttp3.internal.c.a(okhttp3.internal.c.a("OkHttp %s Writer", this.d), false));
        if (aVar.h != 0) {
            this.t.scheduleAtFixedRate(new c(false, 0, 0), aVar.h, aVar.h, TimeUnit.MILLISECONDS);
        }
        this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a(okhttp3.internal.c.a("OkHttp %s Push Observer", this.d), true));
        this.l.a(7, 65535);
        this.l.a(5, 16384);
        this.j = this.l.d();
        this.n = aVar.f5194a;
        this.o = new i(aVar.d, this.f5186a);
        this.p = new d(new g(aVar.c, this.f5186a));
    }

    synchronized h a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    synchronized h b(int i) {
        h hVarRemove;
        hVarRemove = this.c.remove(Integer.valueOf(i));
        notifyAll();
        return hVarRemove;
    }

    public synchronized int a() {
        return this.l.c(Integer.MAX_VALUE);
    }

    public h a(List<okhttp3.internal.http2.b> list, boolean z) {
        return b(0, list, z);
    }

    private h b(int i, List<okhttp3.internal.http2.b> list, boolean z) {
        int i2;
        h hVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.o) {
            synchronized (this) {
                if (this.f > 1073741823) {
                    a(okhttp3.internal.http2.a.REFUSED_STREAM);
                }
                if (this.g) {
                    throw new ConnectionShutdownException();
                }
                i2 = this.f;
                this.f += 2;
                hVar = new h(i2, this, z3, false, list);
                z2 = !z || this.j == 0 || hVar.f5206b == 0;
                if (hVar.b()) {
                    this.c.put(Integer.valueOf(i2), hVar);
                }
            }
            if (i == 0) {
                this.o.a(z3, i2, i, list);
            } else {
                if (this.f5186a) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.o.a(i, i2, list);
            }
        }
        if (z2) {
            this.o.b();
        }
        return hVar;
    }

    public void a(int i, boolean z, b.c cVar, long j) {
        int iMin;
        long j2;
        if (j == 0) {
            this.o.a(z, i, cVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.j <= 0) {
                    try {
                        if (!this.c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, this.j), this.o.c());
                j2 = iMin;
                this.j -= j2;
            }
            j -= j2;
            this.o.a(z && j == 0, i, cVar, iMin);
        }
    }

    void a(long j) {
        this.j += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void a(final int i, final okhttp3.internal.http2.a aVar) {
        try {
            this.t.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.f.1
                @Override // okhttp3.internal.b
                public void c() {
                    try {
                        f.this.b(i, aVar);
                    } catch (IOException unused) {
                        f.this.f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void b(int i, okhttp3.internal.http2.a aVar) {
        this.o.a(i, aVar);
    }

    void a(final int i, final long j) {
        try {
            this.t.execute(new okhttp3.internal.b("OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.f.2
                @Override // okhttp3.internal.b
                public void c() {
                    try {
                        f.this.o.a(i, j);
                    } catch (IOException unused) {
                        f.this.f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* compiled from: Http2Connection.java */
    final class c extends okhttp3.internal.b {

        /* renamed from: a, reason: collision with root package name */
        final boolean f5196a;
        final int c;
        final int d;

        c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", f.this.d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f5196a = z;
            this.c = i;
            this.d = i2;
        }

        @Override // okhttp3.internal.b
        public void c() {
            f.this.a(this.f5196a, this.c, this.d);
        }
    }

    void a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.v;
                this.v = true;
            }
            if (z2) {
                f();
                return;
            }
        }
        try {
            this.o.a(z, i, i2);
        } catch (IOException unused) {
            f();
        }
    }

    public void b() {
        this.o.b();
    }

    public void a(okhttp3.internal.http2.a aVar) {
        synchronized (this.o) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.o.a(this.e, aVar, okhttp3.internal.c.f5120a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(okhttp3.internal.http2.a.NO_ERROR, okhttp3.internal.http2.a.CANCEL);
    }

    void a(okhttp3.internal.http2.a aVar, okhttp3.internal.http2.a aVar2) throws IOException {
        if (!r && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        h[] hVarArr = null;
        try {
            a(aVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.c.isEmpty()) {
                hVarArr = (h[]) this.c.values().toArray(new h[this.c.size()]);
                this.c.clear();
            }
        }
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                try {
                    hVar.a(aVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.o.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.n.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.t.shutdown();
        this.u.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            a(okhttp3.internal.http2.a.PROTOCOL_ERROR, okhttp3.internal.http2.a.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public void c() {
        a(true);
    }

    void a(boolean z) {
        if (z) {
            this.o.a();
            this.o.b(this.k);
            if (this.k.d() != 65535) {
                this.o.a(0, r6 - 65535);
            }
        }
        new Thread(this.p).start();
    }

    public synchronized boolean d() {
        return this.g;
    }

    /* compiled from: Http2Connection.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Socket f5194a;

        /* renamed from: b, reason: collision with root package name */
        String f5195b;
        b.e c;
        b.d d;
        b e = b.f;
        k f = k.f5218a;
        boolean g;
        int h;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, b.e eVar, b.d dVar) {
            this.f5194a = socket;
            this.f5195b = str;
            this.c = eVar;
            this.d = dVar;
            return this;
        }

        public a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public a a(int i) {
            this.h = i;
            return this;
        }

        public f a() {
            return new f(this);
        }
    }

    /* compiled from: Http2Connection.java */
    class d extends okhttp3.internal.b implements g.b {

        /* renamed from: a, reason: collision with root package name */
        final g f5197a;

        @Override // okhttp3.internal.http2.g.b
        public void a() {
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        d(g gVar) {
            super("OkHttp %s", f.this.d);
            this.f5197a = gVar;
        }

        @Override // okhttp3.internal.b
        protected void c() throws Throwable {
            okhttp3.internal.http2.a aVar;
            okhttp3.internal.http2.a aVar2;
            f fVar;
            okhttp3.internal.http2.a aVar3 = okhttp3.internal.http2.a.INTERNAL_ERROR;
            okhttp3.internal.http2.a aVar4 = okhttp3.internal.http2.a.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f5197a.a(this);
                        while (this.f5197a.a(false, (g.b) this)) {
                        }
                        aVar = okhttp3.internal.http2.a.NO_ERROR;
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        f.this.a(aVar3, aVar4);
                    } catch (IOException unused2) {
                    }
                    okhttp3.internal.c.a(this.f5197a);
                    throw th;
                }
                try {
                    try {
                        aVar2 = okhttp3.internal.http2.a.CANCEL;
                        fVar = f.this;
                    } catch (IOException unused3) {
                        aVar3 = aVar;
                        aVar = okhttp3.internal.http2.a.PROTOCOL_ERROR;
                        aVar2 = okhttp3.internal.http2.a.PROTOCOL_ERROR;
                        fVar = f.this;
                        fVar.a(aVar, aVar2);
                        okhttp3.internal.c.a(this.f5197a);
                    }
                } catch (Throwable th2) {
                    okhttp3.internal.http2.a aVar5 = aVar;
                    th = th2;
                    aVar3 = aVar5;
                    f.this.a(aVar3, aVar4);
                    okhttp3.internal.c.a(this.f5197a);
                    throw th;
                }
            } catch (IOException unused4) {
            }
            fVar.a(aVar, aVar2);
            okhttp3.internal.c.a(this.f5197a);
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(boolean z, int i, b.e eVar, int i2) throws IOException {
            if (f.this.c(i)) {
                f.this.a(i, eVar, i2, z);
                return;
            }
            h hVarA = f.this.a(i);
            if (hVarA == null) {
                f.this.a(i, okhttp3.internal.http2.a.PROTOCOL_ERROR);
                eVar.h(i2);
            } else {
                hVarA.a(eVar, i2);
                if (z) {
                    hVarA.i();
                }
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(boolean z, int i, int i2, List<okhttp3.internal.http2.b> list) {
            if (f.this.c(i)) {
                f.this.a(i, list, z);
                return;
            }
            synchronized (f.this) {
                h hVarA = f.this.a(i);
                if (hVarA == null) {
                    if (f.this.g) {
                        return;
                    }
                    if (i <= f.this.e) {
                        return;
                    }
                    if (i % 2 == f.this.f % 2) {
                        return;
                    }
                    final h hVar = new h(i, f.this, false, z, list);
                    f.this.e = i;
                    f.this.c.put(Integer.valueOf(i), hVar);
                    f.s.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{f.this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.f.d.1
                        @Override // okhttp3.internal.b
                        public void c() {
                            try {
                                f.this.f5187b.a(hVar);
                            } catch (IOException e) {
                                okhttp3.internal.e.f.c().a(4, "Http2Connection.Listener failure for " + f.this.d, e);
                                try {
                                    hVar.a(okhttp3.internal.http2.a.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                hVarA.a(list);
                if (z) {
                    hVarA.i();
                }
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(int i, okhttp3.internal.http2.a aVar) {
            if (f.this.c(i)) {
                f.this.c(i, aVar);
                return;
            }
            h hVarB = f.this.b(i);
            if (hVarB != null) {
                hVarB.c(aVar);
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(boolean z, l lVar) {
            h[] hVarArr;
            long j;
            int i;
            synchronized (f.this) {
                int iD = f.this.l.d();
                if (z) {
                    f.this.l.a();
                }
                f.this.l.a(lVar);
                a(lVar);
                int iD2 = f.this.l.d();
                hVarArr = null;
                if (iD2 == -1 || iD2 == iD) {
                    j = 0;
                } else {
                    j = iD2 - iD;
                    if (!f.this.m) {
                        f.this.a(j);
                        f.this.m = true;
                    }
                    if (!f.this.c.isEmpty()) {
                        hVarArr = (h[]) f.this.c.values().toArray(new h[f.this.c.size()]);
                    }
                }
                f.s.execute(new okhttp3.internal.b("OkHttp %s settings", f.this.d) { // from class: okhttp3.internal.http2.f.d.2
                    @Override // okhttp3.internal.b
                    public void c() {
                        f.this.f5187b.a(f.this);
                    }
                });
            }
            if (hVarArr == null || j == 0) {
                return;
            }
            for (h hVar : hVarArr) {
                synchronized (hVar) {
                    hVar.a(j);
                }
            }
        }

        private void a(final l lVar) {
            try {
                f.this.t.execute(new okhttp3.internal.b("OkHttp %s ACK Settings", new Object[]{f.this.d}) { // from class: okhttp3.internal.http2.f.d.3
                    @Override // okhttp3.internal.b
                    public void c() {
                        try {
                            f.this.o.a(lVar);
                        } catch (IOException unused) {
                            f.this.f();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    f.this.t.execute(f.this.new c(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (f.this) {
                    f.this.v = false;
                    f.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(int i, okhttp3.internal.http2.a aVar, b.f fVar) {
            h[] hVarArr;
            fVar.h();
            synchronized (f.this) {
                hVarArr = (h[]) f.this.c.values().toArray(new h[f.this.c.size()]);
                f.this.g = true;
            }
            for (h hVar : hVarArr) {
                if (hVar.a() > i && hVar.c()) {
                    hVar.c(okhttp3.internal.http2.a.REFUSED_STREAM);
                    f.this.b(hVar.a());
                }
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (f.this) {
                    f.this.j += j;
                    f.this.notifyAll();
                }
                return;
            }
            h hVarA = f.this.a(i);
            if (hVarA != null) {
                synchronized (hVarA) {
                    hVarA.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a(int i, int i2, List<okhttp3.internal.http2.b> list) {
            f.this.a(i2, list);
        }
    }

    void a(final int i, final List<okhttp3.internal.http2.b> list) {
        synchronized (this) {
            if (this.q.contains(Integer.valueOf(i))) {
                a(i, okhttp3.internal.http2.a.PROTOCOL_ERROR);
                return;
            }
            this.q.add(Integer.valueOf(i));
            try {
                this.u.execute(new okhttp3.internal.b("OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.f.3
                    @Override // okhttp3.internal.b
                    public void c() {
                        if (f.this.h.a(i, list)) {
                            try {
                                f.this.o.a(i, okhttp3.internal.http2.a.CANCEL);
                                synchronized (f.this) {
                                    f.this.q.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(final int i, final List<okhttp3.internal.http2.b> list, final boolean z) {
        try {
            this.u.execute(new okhttp3.internal.b("OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.f.4
                @Override // okhttp3.internal.b
                public void c() {
                    boolean zA = f.this.h.a(i, list, z);
                    if (zA) {
                        try {
                            f.this.o.a(i, okhttp3.internal.http2.a.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (zA || z) {
                        synchronized (f.this) {
                            f.this.q.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(final int i, b.e eVar, final int i2, final boolean z) throws IOException {
        final b.c cVar = new b.c();
        long j = i2;
        eVar.a(j);
        eVar.a(cVar, j);
        if (cVar.b() != j) {
            throw new IOException(cVar.b() + " != " + i2);
        }
        this.u.execute(new okhttp3.internal.b("OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.f.5
            @Override // okhttp3.internal.b
            public void c() {
                try {
                    boolean zA = f.this.h.a(i, cVar, i2, z);
                    if (zA) {
                        f.this.o.a(i, okhttp3.internal.http2.a.CANCEL);
                    }
                    if (zA || z) {
                        synchronized (f.this) {
                            f.this.q.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    void c(final int i, final okhttp3.internal.http2.a aVar) {
        this.u.execute(new okhttp3.internal.b("OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.f.6
            @Override // okhttp3.internal.b
            public void c() {
                f.this.h.a(i, aVar);
                synchronized (f.this) {
                    f.this.q.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
