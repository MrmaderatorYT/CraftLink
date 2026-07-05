package okhttp3.internal.b;

import java.util.List;
import okhttp3.aa;
import okhttp3.p;
import okhttp3.t;
import okhttp3.y;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes.dex */
public final class g implements t.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<t> f5112a;

    /* renamed from: b, reason: collision with root package name */
    private final okhttp3.internal.connection.f f5113b;
    private final c c;
    private final okhttp3.internal.connection.c d;
    private final int e;
    private final y f;
    private final okhttp3.e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<t> list, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2, int i, y yVar, okhttp3.e eVar, p pVar, int i2, int i3, int i4) {
        this.f5112a = list;
        this.d = cVar2;
        this.f5113b = fVar;
        this.c = cVar;
        this.e = i;
        this.f = yVar;
        this.g = eVar;
        this.h = pVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public okhttp3.i e() {
        return this.d;
    }

    @Override // okhttp3.t.a
    public int b() {
        return this.i;
    }

    @Override // okhttp3.t.a
    public int c() {
        return this.j;
    }

    @Override // okhttp3.t.a
    public int d() {
        return this.k;
    }

    public okhttp3.internal.connection.f f() {
        return this.f5113b;
    }

    public c g() {
        return this.c;
    }

    public okhttp3.e h() {
        return this.g;
    }

    public p i() {
        return this.h;
    }

    @Override // okhttp3.t.a
    public y a() {
        return this.f;
    }

    @Override // okhttp3.t.a
    public aa a(y yVar) {
        return a(yVar, this.f5113b, this.c, this.d);
    }

    public aa a(y yVar, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2) {
        if (this.e >= this.f5112a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.c != null && !this.d.a(yVar.a())) {
            throw new IllegalStateException("network interceptor " + this.f5112a.get(this.e - 1) + " must retain the same host and port");
        }
        if (this.c != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f5112a.get(this.e - 1) + " must call proceed() exactly once");
        }
        g gVar = new g(this.f5112a, fVar, cVar, cVar2, this.e + 1, yVar, this.g, this.h, this.i, this.j, this.k);
        t tVar = this.f5112a.get(this.e);
        aa aaVarA = tVar.a(gVar);
        if (cVar != null && this.e + 1 < this.f5112a.size() && gVar.l != 1) {
            throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
        }
        if (aaVarA == null) {
            throw new NullPointerException("interceptor " + tVar + " returned null");
        }
        if (aaVarA.h() != null) {
            return aaVarA;
        }
        throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
    }
}
