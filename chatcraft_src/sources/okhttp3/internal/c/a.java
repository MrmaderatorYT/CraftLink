package okhttp3.internal.c;

import b.l;
import b.r;
import b.s;
import b.t;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.internal.b.h;
import okhttp3.internal.b.i;
import okhttp3.internal.b.k;
import okhttp3.r;
import okhttp3.v;
import okhttp3.y;

/* compiled from: Http1Codec.java */
/* loaded from: classes.dex */
public final class a implements okhttp3.internal.b.c {

    /* renamed from: a, reason: collision with root package name */
    final v f5124a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.internal.connection.f f5125b;
    final b.e c;
    final b.d d;
    int e = 0;
    private long f = 262144;

    public a(v vVar, okhttp3.internal.connection.f fVar, b.e eVar, b.d dVar) {
        this.f5124a = vVar;
        this.f5125b = fVar;
        this.c = eVar;
        this.d = dVar;
    }

    @Override // okhttp3.internal.b.c
    public r a(y yVar, long j) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return d();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.b.c
    public void a(y yVar) {
        a(yVar.c(), i.a(yVar, this.f5125b.c().a().b().type()));
    }

    @Override // okhttp3.internal.b.c
    public ab a(aa aaVar) {
        this.f5125b.c.f(this.f5125b.f5145b);
        String strA = aaVar.a("Content-Type");
        if (!okhttp3.internal.b.e.d(aaVar)) {
            return new h(strA, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) {
            return new h(strA, -1L, l.a(a(aaVar.a().a())));
        }
        long jA = okhttp3.internal.b.e.a(aaVar);
        if (jA != -1) {
            return new h(strA, jA, l.a(b(jA)));
        }
        return new h(strA, -1L, l.a(e()));
    }

    @Override // okhttp3.internal.b.c
    public void a() {
        this.d.flush();
    }

    @Override // okhttp3.internal.b.c
    public void b() {
        this.d.flush();
    }

    public void a(okhttp3.r rVar, String str) {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.d.b(str).b("\r\n");
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            this.d.b(rVar.a(i)).b(": ").b(rVar.b(i)).b("\r\n");
        }
        this.d.b("\r\n");
        this.e = 1;
    }

    @Override // okhttp3.internal.b.c
    public aa.a a(boolean z) throws NumberFormatException, IOException {
        if (this.e != 1 && this.e != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            k kVarA = k.a(f());
            aa.a aVarA = new aa.a().a(kVarA.f5118a).a(kVarA.f5119b).a(kVarA.c).a(c());
            if (z && kVarA.f5119b == 100) {
                return null;
            }
            if (kVarA.f5119b == 100) {
                this.e = 3;
                return aVarA;
            }
            this.e = 4;
            return aVarA;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f5125b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    private String f() {
        String strE = this.c.e(this.f);
        this.f -= strE.length();
        return strE;
    }

    public okhttp3.r c() {
        r.a aVar = new r.a();
        while (true) {
            String strF = f();
            if (strF.length() != 0) {
                okhttp3.internal.a.f5084a.a(aVar, strF);
            } else {
                return aVar.a();
            }
        }
    }

    public b.r d() {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new b();
    }

    public b.r a(long j) {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new d(j);
    }

    public s b(long j) {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new e(j);
    }

    public s a(okhttp3.s sVar) {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new c(sVar);
    }

    public s e() throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        if (this.f5125b == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.e = 5;
        this.f5125b.e();
        return new f();
    }

    void a(b.i iVar) {
        t tVarA = iVar.a();
        iVar.a(t.c);
        tVarA.f();
        tVarA.J_();
    }

    /* compiled from: Http1Codec.java */
    private final class d implements b.r {

        /* renamed from: b, reason: collision with root package name */
        private final b.i f5131b;
        private boolean c;
        private long d;

        d(long j) {
            this.f5131b = new b.i(a.this.d.a());
            this.d = j;
        }

        @Override // b.r
        public t a() {
            return this.f5131b;
        }

        @Override // b.r
        public void a_(b.c cVar, long j) throws ProtocolException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            okhttp3.internal.c.a(cVar.b(), 0L, j);
            if (j > this.d) {
                throw new ProtocolException("expected " + this.d + " bytes but received " + j);
            }
            a.this.d.a_(cVar, j);
            this.d -= j;
        }

        @Override // b.r, java.io.Flushable
        public void flush() {
            if (this.c) {
                return;
            }
            a.this.d.flush();
        }

        @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws ProtocolException {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.f5131b);
            a.this.e = 3;
        }
    }

    /* compiled from: Http1Codec.java */
    private final class b implements b.r {

        /* renamed from: b, reason: collision with root package name */
        private final b.i f5129b;
        private boolean c;

        b() {
            this.f5129b = new b.i(a.this.d.a());
        }

        @Override // b.r
        public t a() {
            return this.f5129b;
        }

        @Override // b.r
        public void a_(b.c cVar, long j) {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.d.k(j);
            a.this.d.b("\r\n");
            a.this.d.a_(cVar, j);
            a.this.d.b("\r\n");
        }

        @Override // b.r, java.io.Flushable
        public synchronized void flush() {
            if (this.c) {
                return;
            }
            a.this.d.flush();
        }

        @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.c) {
                return;
            }
            this.c = true;
            a.this.d.b("0\r\n\r\n");
            a.this.a(this.f5129b);
            a.this.e = 3;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.c.a$a, reason: collision with other inner class name */
    private abstract class AbstractC0123a implements s {

        /* renamed from: a, reason: collision with root package name */
        protected final b.i f5126a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f5127b;
        protected long c;

        private AbstractC0123a() {
            this.f5126a = new b.i(a.this.c.a());
            this.c = 0L;
        }

        @Override // b.s
        public t a() {
            return this.f5126a;
        }

        @Override // b.s
        public long a(b.c cVar, long j) throws IOException {
            try {
                long jA = a.this.c.a(cVar, j);
                if (jA > 0) {
                    this.c += jA;
                }
                return jA;
            } catch (IOException e) {
                a(false, e);
                throw e;
            }
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            if (a.this.e == 6) {
                return;
            }
            if (a.this.e != 5) {
                throw new IllegalStateException("state: " + a.this.e);
            }
            a.this.a(this.f5126a);
            a.this.e = 6;
            if (a.this.f5125b != null) {
                a.this.f5125b.a(!z, a.this, this.c, iOException);
            }
        }
    }

    /* compiled from: Http1Codec.java */
    private class e extends AbstractC0123a {
        private long f;

        e(long j) {
            super();
            this.f = j;
            if (this.f == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // okhttp3.internal.c.a.AbstractC0123a, b.s
        public long a(b.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5127b) {
                throw new IllegalStateException("closed");
            }
            if (this.f == 0) {
                return -1L;
            }
            long jA = super.a(cVar, Math.min(this.f, j));
            if (jA == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            }
            this.f -= jA;
            if (this.f == 0) {
                a(true, (IOException) null);
            }
            return jA;
        }

        @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5127b) {
                return;
            }
            if (this.f != 0 && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f5127b = true;
        }
    }

    /* compiled from: Http1Codec.java */
    private class c extends AbstractC0123a {
        private final okhttp3.s f;
        private long g;
        private boolean h;

        c(okhttp3.s sVar) {
            super();
            this.g = -1L;
            this.h = true;
            this.f = sVar;
        }

        @Override // okhttp3.internal.c.a.AbstractC0123a, b.s
        public long a(b.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5127b) {
                throw new IllegalStateException("closed");
            }
            if (!this.h) {
                return -1L;
            }
            if (this.g == 0 || this.g == -1) {
                b();
                if (!this.h) {
                    return -1L;
                }
            }
            long jA = super.a(cVar, Math.min(j, this.g));
            if (jA == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            }
            this.g -= jA;
            return jA;
        }

        private void b() throws ProtocolException {
            if (this.g != -1) {
                a.this.c.q();
            }
            try {
                this.g = a.this.c.n();
                String strTrim = a.this.c.q().trim();
                if (this.g < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + strTrim + "\"");
                }
                if (this.g == 0) {
                    this.h = false;
                    okhttp3.internal.b.e.a(a.this.f5124a.g(), this.f, a.this.c());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5127b) {
                return;
            }
            if (this.h && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f5127b = true;
        }
    }

    /* compiled from: Http1Codec.java */
    private class f extends AbstractC0123a {
        private boolean f;

        f() {
            super();
        }

        @Override // okhttp3.internal.c.a.AbstractC0123a, b.s
        public long a(b.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5127b) {
                throw new IllegalStateException("closed");
            }
            if (this.f) {
                return -1L;
            }
            long jA = super.a(cVar, j);
            if (jA != -1) {
                return jA;
            }
            this.f = true;
            a(true, (IOException) null);
            return -1L;
        }

        @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5127b) {
                return;
            }
            if (!this.f) {
                a(false, (IOException) null);
            }
            this.f5127b = true;
        }
    }
}
