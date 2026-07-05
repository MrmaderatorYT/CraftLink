package okhttp3.internal.a;

import b.l;
import b.r;
import b.s;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.internal.a.c;
import okhttp3.internal.b.h;
import okhttp3.r;
import okhttp3.t;
import okhttp3.w;
import okhttp3.y;

/* compiled from: CacheInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    final f f5085a;

    public a(f fVar) {
        this.f5085a = fVar;
    }

    @Override // okhttp3.t
    public aa a(t.a aVar) throws IOException {
        aa aaVarA = this.f5085a != null ? this.f5085a.a(aVar.a()) : null;
        c cVarA = new c.a(System.currentTimeMillis(), aVar.a(), aaVarA).a();
        y yVar = cVarA.f5088a;
        aa aaVar = cVarA.f5089b;
        if (this.f5085a != null) {
            this.f5085a.a(cVarA);
        }
        if (aaVarA != null && aaVar == null) {
            okhttp3.internal.c.a(aaVarA.h());
        }
        if (yVar == null && aaVar == null) {
            return new aa.a().a(aVar.a()).a(w.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(okhttp3.internal.c.c).a(-1L).b(System.currentTimeMillis()).a();
        }
        if (yVar == null) {
            return aaVar.i().b(a(aaVar)).a();
        }
        try {
            aa aaVarA2 = aVar.a(yVar);
            if (aaVarA2 == null && aaVarA != null) {
            }
            if (aaVar != null) {
                if (aaVarA2.c() == 304) {
                    aa aaVarA3 = aaVar.i().a(a(aaVar.g(), aaVarA2.g())).a(aaVarA2.n()).b(aaVarA2.o()).b(a(aaVar)).a(a(aaVarA2)).a();
                    aaVarA2.h().close();
                    this.f5085a.a();
                    this.f5085a.a(aaVar, aaVarA3);
                    return aaVarA3;
                }
                okhttp3.internal.c.a(aaVar.h());
            }
            aa aaVarA4 = aaVarA2.i().b(a(aaVar)).a(a(aaVarA2)).a();
            if (this.f5085a != null) {
                if (okhttp3.internal.b.e.d(aaVarA4) && c.a(aaVarA4, yVar)) {
                    return a(this.f5085a.a(aaVarA4), aaVarA4);
                }
                if (okhttp3.internal.b.f.a(yVar.b())) {
                    try {
                        this.f5085a.b(yVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return aaVarA4;
        } finally {
            if (aaVarA != null) {
                okhttp3.internal.c.a(aaVarA.h());
            }
        }
    }

    private static aa a(aa aaVar) {
        return (aaVar == null || aaVar.h() == null) ? aaVar : aaVar.i().a((ab) null).a();
    }

    private aa a(final b bVar, aa aaVar) {
        r rVarB;
        if (bVar == null || (rVarB = bVar.b()) == null) {
            return aaVar;
        }
        final b.e eVarB = aaVar.h().b();
        final b.d dVarA = l.a(rVarB);
        return aaVar.i().a(new h(aaVar.a("Content-Type"), aaVar.h().a(), l.a(new s() { // from class: okhttp3.internal.a.a.1

            /* renamed from: a, reason: collision with root package name */
            boolean f5086a;

            @Override // b.s
            public long a(b.c cVar, long j) throws IOException {
                try {
                    long jA = eVarB.a(cVar, j);
                    if (jA == -1) {
                        if (!this.f5086a) {
                            this.f5086a = true;
                            dVarA.close();
                        }
                        return -1L;
                    }
                    cVar.a(dVarA.c(), cVar.b() - jA, jA);
                    dVarA.v();
                    return jA;
                } catch (IOException e) {
                    if (!this.f5086a) {
                        this.f5086a = true;
                        bVar.a();
                    }
                    throw e;
                }
            }

            @Override // b.s
            public b.t a() {
                return eVarB.a();
            }

            @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.f5086a && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f5086a = true;
                    bVar.a();
                }
                eVarB.close();
            }
        }))).a();
    }

    private static okhttp3.r a(okhttp3.r rVar, okhttp3.r rVar2) {
        r.a aVar = new r.a();
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = rVar.a(i);
            String strB = rVar.b(i);
            if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (b(strA) || !a(strA) || rVar2.a(strA) == null)) {
                okhttp3.internal.a.f5084a.a(aVar, strA, strB);
            }
        }
        int iA2 = rVar2.a();
        for (int i2 = 0; i2 < iA2; i2++) {
            String strA2 = rVar2.a(i2);
            if (!b(strA2) && a(strA2)) {
                okhttp3.internal.a.f5084a.a(aVar, strA2, rVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
