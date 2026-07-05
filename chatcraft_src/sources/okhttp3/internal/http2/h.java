package okhttp3.internal.http2;

import b.r;
import b.s;
import b.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Http2Stream.java */
/* loaded from: classes.dex */
public final class h {
    static final /* synthetic */ boolean i = !h.class.desiredAssertionStatus();

    /* renamed from: b, reason: collision with root package name */
    long f5206b;
    final int c;
    final f d;
    final a e;
    private final List<okhttp3.internal.http2.b> j;
    private List<okhttp3.internal.http2.b> k;
    private boolean l;
    private final b m;

    /* renamed from: a, reason: collision with root package name */
    long f5205a = 0;
    final c f = new c();
    final c g = new c();
    okhttp3.internal.http2.a h = null;

    h(int i2, f fVar, boolean z, boolean z2, List<okhttp3.internal.http2.b> list) {
        if (fVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.c = i2;
        this.d = fVar;
        this.f5206b = fVar.l.d();
        this.m = new b(fVar.k.d());
        this.e = new a();
        this.m.f5210b = z2;
        this.e.f5208b = z;
        this.j = list;
    }

    public int a() {
        return this.c;
    }

    public synchronized boolean b() {
        if (this.h != null) {
            return false;
        }
        if ((this.m.f5210b || this.m.f5209a) && (this.e.f5208b || this.e.f5207a)) {
            if (this.l) {
                return false;
            }
        }
        return true;
    }

    public boolean c() {
        return this.d.f5186a == ((this.c & 1) == 1);
    }

    public synchronized List<okhttp3.internal.http2.b> d() {
        List<okhttp3.internal.http2.b> list;
        if (!c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f.c();
        while (this.k == null && this.h == null) {
            try {
                l();
            } catch (Throwable th) {
                this.f.b();
                throw th;
            }
        }
        this.f.b();
        list = this.k;
        if (list != null) {
            this.k = null;
        } else {
            throw new StreamResetException(this.h);
        }
        return list;
    }

    public t e() {
        return this.f;
    }

    public t f() {
        return this.g;
    }

    public s g() {
        return this.m;
    }

    public r h() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    public void a(okhttp3.internal.http2.a aVar) {
        if (d(aVar)) {
            this.d.b(this.c, aVar);
        }
    }

    public void b(okhttp3.internal.http2.a aVar) {
        if (d(aVar)) {
            this.d.a(this.c, aVar);
        }
    }

    private boolean d(okhttp3.internal.http2.a aVar) {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if (this.m.f5210b && this.e.f5208b) {
                return false;
            }
            this.h = aVar;
            notifyAll();
            this.d.b(this.c);
            return true;
        }
    }

    void a(List<okhttp3.internal.http2.b> list) {
        boolean zB;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zB = true;
            this.l = true;
            if (this.k == null) {
                this.k = list;
                zB = b();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.k = arrayList;
            }
        }
        if (zB) {
            return;
        }
        this.d.b(this.c);
    }

    void a(b.e eVar, int i2) throws EOFException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(eVar, i2);
    }

    void i() {
        boolean zB;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.f5210b = true;
            zB = b();
            notifyAll();
        }
        if (zB) {
            return;
        }
        this.d.b(this.c);
    }

    synchronized void c(okhttp3.internal.http2.a aVar) {
        if (this.h == null) {
            this.h = aVar;
            notifyAll();
        }
    }

    /* compiled from: Http2Stream.java */
    private final class b implements s {
        static final /* synthetic */ boolean c = !h.class.desiredAssertionStatus();

        /* renamed from: a, reason: collision with root package name */
        boolean f5209a;

        /* renamed from: b, reason: collision with root package name */
        boolean f5210b;
        private final b.c e = new b.c();
        private final b.c f = new b.c();
        private final long g;

        b(long j) {
            this.g = j;
        }

        @Override // b.s
        public long a(b.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (h.this) {
                b();
                c();
                if (this.f.b() == 0) {
                    return -1L;
                }
                long jA = this.f.a(cVar, Math.min(j, this.f.b()));
                h.this.f5205a += jA;
                if (h.this.f5205a >= h.this.d.k.d() / 2) {
                    h.this.d.a(h.this.c, h.this.f5205a);
                    h.this.f5205a = 0L;
                }
                synchronized (h.this.d) {
                    h.this.d.i += jA;
                    if (h.this.d.i >= h.this.d.k.d() / 2) {
                        h.this.d.a(0, h.this.d.i);
                        h.this.d.i = 0L;
                    }
                }
                return jA;
            }
        }

        private void b() throws IOException {
            h.this.f.c();
            while (this.f.b() == 0 && !this.f5210b && !this.f5209a && h.this.h == null) {
                try {
                    h.this.l();
                } finally {
                    h.this.f.b();
                }
            }
        }

        void a(b.e eVar, long j) throws EOFException {
            boolean z;
            boolean z2;
            if (!c && Thread.holdsLock(h.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (h.this) {
                    z = this.f5210b;
                    z2 = this.f.b() + j > this.g;
                }
                if (z2) {
                    eVar.h(j);
                    h.this.b(okhttp3.internal.http2.a.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.h(j);
                    return;
                }
                long jA = eVar.a(this.e, j);
                if (jA == -1) {
                    throw new EOFException();
                }
                j -= jA;
                synchronized (h.this) {
                    boolean z3 = this.f.b() == 0;
                    this.f.a(this.e);
                    if (z3) {
                        h.this.notifyAll();
                    }
                }
            }
        }

        @Override // b.s
        public t a() {
            return h.this.f;
        }

        @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (h.this) {
                this.f5209a = true;
                this.f.s();
                h.this.notifyAll();
            }
            h.this.j();
        }

        private void c() throws IOException {
            if (this.f5209a) {
                throw new IOException("stream closed");
            }
            if (h.this.h != null) {
                throw new StreamResetException(h.this.h);
            }
        }
    }

    void j() {
        boolean z;
        boolean zB;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.m.f5210b && this.m.f5209a && (this.e.f5208b || this.e.f5207a);
            zB = b();
        }
        if (z) {
            a(okhttp3.internal.http2.a.CANCEL);
        } else {
            if (zB) {
                return;
            }
            this.d.b(this.c);
        }
    }

    /* compiled from: Http2Stream.java */
    final class a implements r {
        static final /* synthetic */ boolean c = !h.class.desiredAssertionStatus();

        /* renamed from: a, reason: collision with root package name */
        boolean f5207a;

        /* renamed from: b, reason: collision with root package name */
        boolean f5208b;
        private final b.c e = new b.c();

        a() {
        }

        @Override // b.r
        public void a_(b.c cVar, long j) throws IOException {
            if (!c && Thread.holdsLock(h.this)) {
                throw new AssertionError();
            }
            this.e.a_(cVar, j);
            while (this.e.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) throws IOException {
            long jMin;
            synchronized (h.this) {
                h.this.g.c();
                while (h.this.f5206b <= 0 && !this.f5208b && !this.f5207a && h.this.h == null) {
                    try {
                        h.this.l();
                    } finally {
                    }
                }
                h.this.g.b();
                h.this.k();
                jMin = Math.min(h.this.f5206b, this.e.b());
                h.this.f5206b -= jMin;
            }
            h.this.g.c();
            try {
                h.this.d.a(h.this.c, z && jMin == this.e.b(), this.e, jMin);
            } finally {
            }
        }

        @Override // b.r, java.io.Flushable
        public void flush() throws IOException {
            if (!c && Thread.holdsLock(h.this)) {
                throw new AssertionError();
            }
            synchronized (h.this) {
                h.this.k();
            }
            while (this.e.b() > 0) {
                a(false);
                h.this.d.b();
            }
        }

        @Override // b.r
        public t a() {
            return h.this.g;
        }

        @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(h.this)) {
                throw new AssertionError();
            }
            synchronized (h.this) {
                if (this.f5207a) {
                    return;
                }
                if (!h.this.e.f5208b) {
                    if (this.e.b() > 0) {
                        while (this.e.b() > 0) {
                            a(true);
                        }
                    } else {
                        h.this.d.a(h.this.c, true, (b.c) null, 0L);
                    }
                }
                synchronized (h.this) {
                    this.f5207a = true;
                }
                h.this.d.b();
                h.this.j();
            }
        }
    }

    void a(long j) {
        this.f5206b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void k() throws IOException {
        if (this.e.f5207a) {
            throw new IOException("stream closed");
        }
        if (this.e.f5208b) {
            throw new IOException("stream finished");
        }
        if (this.h != null) {
            throw new StreamResetException(this.h);
        }
    }

    void l() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* compiled from: Http2Stream.java */
    class c extends b.a {
        c() {
        }

        @Override // b.a
        protected void a() {
            h.this.b(okhttp3.internal.http2.a.CANCEL);
        }

        @Override // b.a
        protected IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void b() throws IOException {
            if (G_()) {
                throw a((IOException) null);
            }
        }
    }
}
