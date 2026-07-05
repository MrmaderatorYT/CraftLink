package okhttp3.internal.http2;

import b.r;
import b.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.r;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;

/* compiled from: Http2Codec.java */
/* loaded from: classes.dex */
public final class e implements okhttp3.internal.b.c {

    /* renamed from: b, reason: collision with root package name */
    private static final b.f f5182b = b.f.a("connection");
    private static final b.f c = b.f.a("host");
    private static final b.f d = b.f.a("keep-alive");
    private static final b.f e = b.f.a("proxy-connection");
    private static final b.f f = b.f.a("transfer-encoding");
    private static final b.f g = b.f.a("te");
    private static final b.f h = b.f.a("encoding");
    private static final b.f i = b.f.a("upgrade");
    private static final List<b.f> j = okhttp3.internal.c.a(f5182b, c, d, e, g, f, h, i, b.c, b.d, b.e, b.f);
    private static final List<b.f> k = okhttp3.internal.c.a(f5182b, c, d, e, g, f, h, i);

    /* renamed from: a, reason: collision with root package name */
    final okhttp3.internal.connection.f f5183a;
    private final v l;
    private final t.a m;
    private final f n;
    private h o;

    public e(v vVar, t.a aVar, okhttp3.internal.connection.f fVar, f fVar2) {
        this.l = vVar;
        this.m = aVar;
        this.f5183a = fVar;
        this.n = fVar2;
    }

    @Override // okhttp3.internal.b.c
    public r a(y yVar, long j2) {
        return this.o.h();
    }

    @Override // okhttp3.internal.b.c
    public void a(y yVar) {
        if (this.o != null) {
            return;
        }
        this.o = this.n.a(b(yVar), yVar.d() != null);
        this.o.e().a(this.m.c(), TimeUnit.MILLISECONDS);
        this.o.f().a(this.m.d(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.internal.b.c
    public void a() {
        this.n.b();
    }

    @Override // okhttp3.internal.b.c
    public void b() {
        this.o.h().close();
    }

    @Override // okhttp3.internal.b.c
    public aa.a a(boolean z) throws ProtocolException, NumberFormatException {
        aa.a aVarA = a(this.o.d());
        if (z && okhttp3.internal.a.f5084a.a(aVarA) == 100) {
            return null;
        }
        return aVarA;
    }

    public static List<b> b(y yVar) {
        okhttp3.r rVarC = yVar.c();
        ArrayList arrayList = new ArrayList(rVarC.a() + 4);
        arrayList.add(new b(b.c, yVar.b()));
        arrayList.add(new b(b.d, okhttp3.internal.b.i.a(yVar.a())));
        String strA = yVar.a("Host");
        if (strA != null) {
            arrayList.add(new b(b.f, strA));
        }
        arrayList.add(new b(b.e, yVar.a().b()));
        int iA = rVarC.a();
        for (int i2 = 0; i2 < iA; i2++) {
            b.f fVarA = b.f.a(rVarC.a(i2).toLowerCase(Locale.US));
            if (!j.contains(fVarA)) {
                arrayList.add(new b(fVarA, rVarC.b(i2)));
            }
        }
        return arrayList;
    }

    public static aa.a a(List<b> list) throws ProtocolException, NumberFormatException {
        r.a aVar = new r.a();
        int size = list.size();
        r.a aVar2 = aVar;
        okhttp3.internal.b.k kVarA = null;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = list.get(i2);
            if (bVar == null) {
                if (kVarA != null && kVarA.f5119b == 100) {
                    aVar2 = new r.a();
                    kVarA = null;
                }
            } else {
                b.f fVar = bVar.g;
                String strA = bVar.h.a();
                if (fVar.equals(b.f5173b)) {
                    kVarA = okhttp3.internal.b.k.a("HTTP/1.1 " + strA);
                } else if (!k.contains(fVar)) {
                    okhttp3.internal.a.f5084a.a(aVar2, fVar.a(), strA);
                }
            }
        }
        if (kVarA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new aa.a().a(w.HTTP_2).a(kVarA.f5119b).a(kVarA.c).a(aVar2.a());
    }

    @Override // okhttp3.internal.b.c
    public ab a(aa aaVar) {
        this.f5183a.c.f(this.f5183a.f5145b);
        return new okhttp3.internal.b.h(aaVar.a("Content-Type"), okhttp3.internal.b.e.a(aaVar), b.l.a(new a(this.o.g())));
    }

    /* compiled from: Http2Codec.java */
    class a extends b.h {

        /* renamed from: a, reason: collision with root package name */
        boolean f5184a;

        /* renamed from: b, reason: collision with root package name */
        long f5185b;

        a(s sVar) {
            super(sVar);
            this.f5184a = false;
            this.f5185b = 0L;
        }

        @Override // b.h, b.s
        public long a(b.c cVar, long j) throws IOException {
            try {
                long jA = b().a(cVar, j);
                if (jA > 0) {
                    this.f5185b += jA;
                }
                return jA;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }

        @Override // b.h, b.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        private void a(IOException iOException) throws IOException {
            if (this.f5184a) {
                return;
            }
            this.f5184a = true;
            e.this.f5183a.a(false, e.this, this.f5185b, iOException);
        }
    }
}
