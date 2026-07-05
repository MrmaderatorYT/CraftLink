package okhttp3.internal.b;

import java.util.List;
import okhttp3.aa;
import okhttp3.m;
import okhttp3.t;
import okhttp3.u;
import okhttp3.y;
import okhttp3.z;

/* compiled from: BridgeInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    private final m f5106a;

    public a(m mVar) {
        this.f5106a = mVar;
    }

    @Override // okhttp3.t
    public aa a(t.a aVar) {
        y yVarA = aVar.a();
        y.a aVarE = yVarA.e();
        z zVarD = yVarA.d();
        if (zVarD != null) {
            u uVarA = zVarD.a();
            if (uVarA != null) {
                aVarE.a("Content-Type", uVarA.toString());
            }
            long jB = zVarD.b();
            if (jB != -1) {
                aVarE.a("Content-Length", Long.toString(jB));
                aVarE.b("Transfer-Encoding");
            } else {
                aVarE.a("Transfer-Encoding", "chunked");
                aVarE.b("Content-Length");
            }
        }
        boolean z = false;
        if (yVarA.a("Host") == null) {
            aVarE.a("Host", okhttp3.internal.c.a(yVarA.a(), false));
        }
        if (yVarA.a("Connection") == null) {
            aVarE.a("Connection", "Keep-Alive");
        }
        if (yVarA.a("Accept-Encoding") == null && yVarA.a("Range") == null) {
            z = true;
            aVarE.a("Accept-Encoding", "gzip");
        }
        List<okhttp3.l> listA = this.f5106a.a(yVarA.a());
        if (!listA.isEmpty()) {
            aVarE.a("Cookie", a(listA));
        }
        if (yVarA.a("User-Agent") == null) {
            aVarE.a("User-Agent", okhttp3.internal.d.a());
        }
        aa aaVarA = aVar.a(aVarE.a());
        e.a(this.f5106a, yVarA.a(), aaVarA.g());
        aa.a aVarA = aaVarA.i().a(yVarA);
        if (z && "gzip".equalsIgnoreCase(aaVarA.a("Content-Encoding")) && e.d(aaVarA)) {
            b.j jVar = new b.j(aaVarA.h().b());
            aVarA.a(aaVarA.g().b().b("Content-Encoding").b("Content-Length").a());
            aVarA.a(new h(aaVarA.a("Content-Type"), -1L, b.l.a(jVar)));
        }
        return aVarA.a();
    }

    private String a(List<okhttp3.l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            okhttp3.l lVar = list.get(i);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
