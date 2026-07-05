package okhttp3.internal.b;

import b.r;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.aa;
import okhttp3.t;
import okhttp3.y;

/* compiled from: CallServerInterceptor.java */
/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5107a;

    public b(boolean z) {
        this.f5107a = z;
    }

    @Override // okhttp3.t
    public aa a(t.a aVar) throws IOException {
        aa aaVarA;
        g gVar = (g) aVar;
        c cVarG = gVar.g();
        okhttp3.internal.connection.f fVarF = gVar.f();
        okhttp3.internal.connection.c cVar = (okhttp3.internal.connection.c) gVar.e();
        y yVarA = gVar.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gVar.i().c(gVar.h());
        cVarG.a(yVarA);
        gVar.i().a(gVar.h(), yVarA);
        aa.a aVarA = null;
        if (f.c(yVarA.b()) && yVarA.d() != null) {
            if ("100-continue".equalsIgnoreCase(yVarA.a("Expect"))) {
                cVarG.a();
                gVar.i().e(gVar.h());
                aVarA = cVarG.a(true);
            }
            if (aVarA == null) {
                gVar.i().d(gVar.h());
                a aVar2 = new a(cVarG.a(yVarA, yVarA.d().b()));
                b.d dVarA = b.l.a(aVar2);
                yVarA.d().a(dVarA);
                dVarA.close();
                gVar.i().a(gVar.h(), aVar2.f5108a);
            } else if (!cVar.d()) {
                fVarF.e();
            }
        }
        cVarG.b();
        if (aVarA == null) {
            gVar.i().e(gVar.h());
            aVarA = cVarG.a(false);
        }
        aa aaVarA2 = aVarA.a(yVarA).a(fVarF.c().c()).a(jCurrentTimeMillis).b(System.currentTimeMillis()).a();
        int iC = aaVarA2.c();
        if (iC == 100) {
            aaVarA2 = cVarG.a(false).a(yVarA).a(fVarF.c().c()).a(jCurrentTimeMillis).b(System.currentTimeMillis()).a();
            iC = aaVarA2.c();
        }
        gVar.i().a(gVar.h(), aaVarA2);
        if (this.f5107a && iC == 101) {
            aaVarA = aaVarA2.i().a(okhttp3.internal.c.c).a();
        } else {
            aaVarA = aaVarA2.i().a(cVarG.a(aaVarA2)).a();
        }
        if ("close".equalsIgnoreCase(aaVarA.a().a("Connection")) || "close".equalsIgnoreCase(aaVarA.a("Connection"))) {
            fVarF.e();
        }
        if ((iC != 204 && iC != 205) || aaVarA.h().a() <= 0) {
            return aaVarA;
        }
        throw new ProtocolException("HTTP " + iC + " had non-zero Content-Length: " + aaVarA.h().a());
    }

    /* compiled from: CallServerInterceptor.java */
    static final class a extends b.g {

        /* renamed from: a, reason: collision with root package name */
        long f5108a;

        a(r rVar) {
            super(rVar);
        }

        @Override // b.g, b.r
        public void a_(b.c cVar, long j) {
            super.a_(cVar, j);
            this.f5108a += j;
        }
    }
}
