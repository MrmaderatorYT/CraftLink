package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.internal.a.d;
import okhttp3.r;
import okhttp3.y;

/* compiled from: Cache.java */
/* loaded from: classes.dex */
public final class c implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    final okhttp3.internal.a.f f5060a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.internal.a.d f5061b;
    int c;
    int d;
    private int e;
    private int f;
    private int g;

    public c(File file, long j) {
        this(file, j, okhttp3.internal.d.a.f5147a);
    }

    c(File file, long j, okhttp3.internal.d.a aVar) {
        this.f5060a = new okhttp3.internal.a.f() { // from class: okhttp3.c.1
            @Override // okhttp3.internal.a.f
            public aa a(y yVar) {
                return c.this.a(yVar);
            }

            @Override // okhttp3.internal.a.f
            public okhttp3.internal.a.b a(aa aaVar) {
                return c.this.a(aaVar);
            }

            @Override // okhttp3.internal.a.f
            public void b(y yVar) {
                c.this.b(yVar);
            }

            @Override // okhttp3.internal.a.f
            public void a(aa aaVar, aa aaVar2) {
                c.this.a(aaVar, aaVar2);
            }

            @Override // okhttp3.internal.a.f
            public void a() {
                c.this.a();
            }

            @Override // okhttp3.internal.a.f
            public void a(okhttp3.internal.a.c cVar) {
                c.this.a(cVar);
            }
        };
        this.f5061b = okhttp3.internal.a.d.a(aVar, file, 201105, 2, j);
    }

    public static String a(s sVar) {
        return b.f.a(sVar.toString()).c().f();
    }

    @Nullable
    aa a(y yVar) throws IOException {
        try {
            d.c cVarA = this.f5061b.a(a(yVar.a()));
            if (cVarA == null) {
                return null;
            }
            try {
                C0122c c0122c = new C0122c(cVarA.a(0));
                aa aaVarA = c0122c.a(cVarA);
                if (c0122c.a(yVar, aaVarA)) {
                    return aaVarA;
                }
                okhttp3.internal.c.a(aaVarA.h());
                return null;
            } catch (IOException unused) {
                okhttp3.internal.c.a(cVarA);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    @Nullable
    okhttp3.internal.a.b a(aa aaVar) {
        d.a aVarB;
        String strB = aaVar.a().b();
        if (okhttp3.internal.b.f.a(aaVar.a().b())) {
            try {
                b(aaVar.a());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!strB.equals("GET") || okhttp3.internal.b.e.b(aaVar)) {
            return null;
        }
        C0122c c0122c = new C0122c(aaVar);
        try {
            aVarB = this.f5061b.b(a(aaVar.a().a()));
            if (aVarB == null) {
                return null;
            }
            try {
                c0122c.a(aVarB);
                return new a(aVarB);
            } catch (IOException unused2) {
                a(aVarB);
                return null;
            }
        } catch (IOException unused3) {
            aVarB = null;
        }
    }

    void b(y yVar) {
        this.f5061b.c(a(yVar.a()));
    }

    void a(aa aaVar, aa aaVar2) {
        d.a aVarA;
        C0122c c0122c = new C0122c(aaVar2);
        try {
            aVarA = ((b) aaVar.h()).f5067a.a();
            if (aVarA != null) {
                try {
                    c0122c.a(aVarA);
                    aVarA.b();
                } catch (IOException unused) {
                    a(aVarA);
                }
            }
        } catch (IOException unused2) {
            aVarA = null;
        }
    }

    private void a(@Nullable d.a aVar) {
        if (aVar != null) {
            try {
                aVar.c();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Flushable
    public void flush() {
        this.f5061b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5061b.close();
    }

    synchronized void a(okhttp3.internal.a.c cVar) {
        this.g++;
        if (cVar.f5088a != null) {
            this.e++;
        } else if (cVar.f5089b != null) {
            this.f++;
        }
    }

    synchronized void a() {
        this.f++;
    }

    /* compiled from: Cache.java */
    private final class a implements okhttp3.internal.a.b {

        /* renamed from: a, reason: collision with root package name */
        boolean f5063a;
        private final d.a c;
        private b.r d;
        private b.r e;

        a(final d.a aVar) {
            this.c = aVar;
            this.d = aVar.a(1);
            this.e = new b.g(this.d) { // from class: okhttp3.c.a.1
                @Override // b.g, b.r, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (c.this) {
                        if (a.this.f5063a) {
                            return;
                        }
                        a.this.f5063a = true;
                        c.this.c++;
                        super.close();
                        aVar.b();
                    }
                }
            };
        }

        @Override // okhttp3.internal.a.b
        public void a() throws IOException {
            synchronized (c.this) {
                if (this.f5063a) {
                    return;
                }
                this.f5063a = true;
                c.this.d++;
                okhttp3.internal.c.a(this.d);
                try {
                    this.c.c();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.a.b
        public b.r b() {
            return this.e;
        }
    }

    /* compiled from: Cache.java */
    /* renamed from: okhttp3.c$c, reason: collision with other inner class name */
    private static final class C0122c {

        /* renamed from: a, reason: collision with root package name */
        private static final String f5071a = okhttp3.internal.e.f.c().d() + "-Sent-Millis";

        /* renamed from: b, reason: collision with root package name */
        private static final String f5072b = okhttp3.internal.e.f.c().d() + "-Received-Millis";
        private final String c;
        private final r d;
        private final String e;
        private final w f;
        private final int g;
        private final String h;
        private final r i;

        @Nullable
        private final q j;
        private final long k;
        private final long l;

        C0122c(b.s sVar) {
            ad adVarA;
            try {
                b.e eVarA = b.l.a(sVar);
                this.c = eVarA.q();
                this.e = eVarA.q();
                r.a aVar = new r.a();
                int iA = c.a(eVarA);
                for (int i = 0; i < iA; i++) {
                    aVar.a(eVarA.q());
                }
                this.d = aVar.a();
                okhttp3.internal.b.k kVarA = okhttp3.internal.b.k.a(eVarA.q());
                this.f = kVarA.f5118a;
                this.g = kVarA.f5119b;
                this.h = kVarA.c;
                r.a aVar2 = new r.a();
                int iA2 = c.a(eVarA);
                for (int i2 = 0; i2 < iA2; i2++) {
                    aVar2.a(eVarA.q());
                }
                String strC = aVar2.c(f5071a);
                String strC2 = aVar2.c(f5072b);
                aVar2.b(f5071a);
                aVar2.b(f5072b);
                this.k = strC != null ? Long.parseLong(strC) : 0L;
                this.l = strC2 != null ? Long.parseLong(strC2) : 0L;
                this.i = aVar2.a();
                if (a()) {
                    String strQ = eVarA.q();
                    if (strQ.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strQ + "\"");
                    }
                    h hVarA = h.a(eVarA.q());
                    List<Certificate> listA = a(eVarA);
                    List<Certificate> listA2 = a(eVarA);
                    if (!eVarA.e()) {
                        adVarA = ad.a(eVarA.q());
                    } else {
                        adVarA = ad.SSL_3_0;
                    }
                    this.j = q.a(adVarA, hVarA, listA, listA2);
                } else {
                    this.j = null;
                }
            } finally {
                sVar.close();
            }
        }

        C0122c(aa aaVar) {
            this.c = aaVar.a().a().toString();
            this.d = okhttp3.internal.b.e.c(aaVar);
            this.e = aaVar.a().b();
            this.f = aaVar.b();
            this.g = aaVar.c();
            this.h = aaVar.e();
            this.i = aaVar.g();
            this.j = aaVar.f();
            this.k = aaVar.n();
            this.l = aaVar.o();
        }

        public void a(d.a aVar) throws IOException {
            b.d dVarA = b.l.a(aVar.a(0));
            dVarA.b(this.c).i(10);
            dVarA.b(this.e).i(10);
            dVarA.l(this.d.a()).i(10);
            int iA = this.d.a();
            for (int i = 0; i < iA; i++) {
                dVarA.b(this.d.a(i)).b(": ").b(this.d.b(i)).i(10);
            }
            dVarA.b(new okhttp3.internal.b.k(this.f, this.g, this.h).toString()).i(10);
            dVarA.l(this.i.a() + 2).i(10);
            int iA2 = this.i.a();
            for (int i2 = 0; i2 < iA2; i2++) {
                dVarA.b(this.i.a(i2)).b(": ").b(this.i.b(i2)).i(10);
            }
            dVarA.b(f5071a).b(": ").l(this.k).i(10);
            dVarA.b(f5072b).b(": ").l(this.l).i(10);
            if (a()) {
                dVarA.i(10);
                dVarA.b(this.j.b().a()).i(10);
                a(dVarA, this.j.c());
                a(dVarA, this.j.d());
                dVarA.b(this.j.a().a()).i(10);
            }
            dVarA.close();
        }

        private boolean a() {
            return this.c.startsWith("https://");
        }

        private List<Certificate> a(b.e eVar) throws IOException, CertificateException {
            int iA = c.a(eVar);
            if (iA == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iA);
                for (int i = 0; i < iA; i++) {
                    String strQ = eVar.q();
                    b.c cVar = new b.c();
                    cVar.a(b.f.b(strQ));
                    arrayList.add(certificateFactory.generateCertificate(cVar.f()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void a(b.d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.l(list.size()).i(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.b(b.f.a(list.get(i).getEncoded()).b()).i(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean a(y yVar, aa aaVar) {
            return this.c.equals(yVar.a().toString()) && this.e.equals(yVar.b()) && okhttp3.internal.b.e.a(aaVar, this.d, yVar);
        }

        public aa a(d.c cVar) {
            String strA = this.i.a("Content-Type");
            String strA2 = this.i.a("Content-Length");
            return new aa.a().a(new y.a().a(this.c).a(this.e, (z) null).a(this.d).a()).a(this.f).a(this.g).a(this.h).a(this.i).a(new b(cVar, strA, strA2)).a(this.j).a(this.k).b(this.l).a();
        }
    }

    static int a(b.e eVar) throws IOException {
        try {
            long jM = eVar.m();
            String strQ = eVar.q();
            if (jM >= 0 && jM <= 2147483647L && strQ.isEmpty()) {
                return (int) jM;
            }
            throw new IOException("expected an int but was \"" + jM + strQ + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* compiled from: Cache.java */
    private static class b extends ab {

        /* renamed from: a, reason: collision with root package name */
        final d.c f5067a;

        /* renamed from: b, reason: collision with root package name */
        private final b.e f5068b;

        @Nullable
        private final String c;

        @Nullable
        private final String d;

        b(final d.c cVar, String str, String str2) {
            this.f5067a = cVar;
            this.c = str;
            this.d = str2;
            this.f5068b = b.l.a(new b.h(cVar.a(1)) { // from class: okhttp3.c.b.1
                @Override // b.h, b.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    cVar.close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ab
        public long a() {
            try {
                if (this.d != null) {
                    return Long.parseLong(this.d);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ab
        public b.e b() {
            return this.f5068b;
        }
    }
}
