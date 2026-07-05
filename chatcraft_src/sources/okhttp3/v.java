package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import okhttp3.e;
import okhttp3.p;
import okhttp3.r;

/* compiled from: OkHttpClient.java */
/* loaded from: classes.dex */
public class v implements Cloneable, e.a {

    /* renamed from: a, reason: collision with root package name */
    static final List<w> f5250a = okhttp3.internal.c.a(w.HTTP_2, w.HTTP_1_1);

    /* renamed from: b, reason: collision with root package name */
    static final List<k> f5251b = okhttp3.internal.c.a(k.f5226a, k.c);
    final int A;
    final int B;
    final int C;
    final n c;

    @Nullable
    final Proxy d;
    final List<w> e;
    final List<k> f;
    final List<t> g;
    final List<t> h;
    final p.a i;
    final ProxySelector j;
    final m k;

    @Nullable
    final c l;

    @Nullable
    final okhttp3.internal.a.f m;
    final SocketFactory n;

    @Nullable
    final SSLSocketFactory o;

    @Nullable
    final okhttp3.internal.f.c p;
    final HostnameVerifier q;
    final g r;
    final b s;
    final b t;
    final j u;
    final o v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        okhttp3.internal.a.f5084a = new okhttp3.internal.a() { // from class: okhttp3.v.1
            @Override // okhttp3.internal.a
            public void a(r.a aVar, String str) {
                aVar.a(str);
            }

            @Override // okhttp3.internal.a
            public void a(r.a aVar, String str, String str2) {
                aVar.b(str, str2);
            }

            @Override // okhttp3.internal.a
            public boolean a(j jVar, okhttp3.internal.connection.c cVar) {
                return jVar.b(cVar);
            }

            @Override // okhttp3.internal.a
            public okhttp3.internal.connection.c a(j jVar, okhttp3.a aVar, okhttp3.internal.connection.f fVar, ac acVar) {
                return jVar.a(aVar, fVar, acVar);
            }

            @Override // okhttp3.internal.a
            public boolean a(okhttp3.a aVar, okhttp3.a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // okhttp3.internal.a
            public Socket a(j jVar, okhttp3.a aVar, okhttp3.internal.connection.f fVar) {
                return jVar.a(aVar, fVar);
            }

            @Override // okhttp3.internal.a
            public void b(j jVar, okhttp3.internal.connection.c cVar) {
                jVar.a(cVar);
            }

            @Override // okhttp3.internal.a
            public okhttp3.internal.connection.d a(j jVar) {
                return jVar.f5223a;
            }

            @Override // okhttp3.internal.a
            public int a(aa.a aVar) {
                return aVar.c;
            }

            @Override // okhttp3.internal.a
            public void a(k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.a(sSLSocket, z);
            }
        };
    }

    public v() {
        this(new a());
    }

    v(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z;
        this.c = aVar.f5252a;
        this.d = aVar.f5253b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = okhttp3.internal.c.a(aVar.e);
        this.h = okhttp3.internal.c.a(aVar.f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<k> it = this.f.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().a();
            }
        }
        if (aVar.m != null || !z) {
            this.o = aVar.m;
            this.p = aVar.n;
        } else {
            X509TrustManager x509TrustManagerA = A();
            this.o = a(x509TrustManagerA);
            this.p = okhttp3.internal.f.c.a(x509TrustManagerA);
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        }
        if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    private X509TrustManager A() throws NoSuchAlgorithmException, KeyStoreException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e) {
            throw okhttp3.internal.c.a("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContextK_ = okhttp3.internal.e.f.c().K_();
            sSLContextK_.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextK_.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw okhttp3.internal.c.a("No System TLS", (Exception) e);
        }
    }

    public int a() {
        return this.z;
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public int d() {
        return this.C;
    }

    public Proxy e() {
        return this.d;
    }

    public ProxySelector f() {
        return this.j;
    }

    public m g() {
        return this.k;
    }

    public c h() {
        return this.l;
    }

    okhttp3.internal.a.f i() {
        return this.l != null ? this.l.f5060a : this.m;
    }

    public o j() {
        return this.v;
    }

    public SocketFactory k() {
        return this.n;
    }

    public SSLSocketFactory l() {
        return this.o;
    }

    public HostnameVerifier m() {
        return this.q;
    }

    public g n() {
        return this.r;
    }

    public b o() {
        return this.t;
    }

    public b p() {
        return this.s;
    }

    public j q() {
        return this.u;
    }

    public boolean r() {
        return this.w;
    }

    public boolean s() {
        return this.x;
    }

    public boolean t() {
        return this.y;
    }

    public n u() {
        return this.c;
    }

    public List<w> v() {
        return this.e;
    }

    public List<k> w() {
        return this.f;
    }

    public List<t> x() {
        return this.g;
    }

    public List<t> y() {
        return this.h;
    }

    public p.a z() {
        return this.i;
    }

    @Override // okhttp3.e.a
    public e a(y yVar) {
        return x.a(this, yVar, false);
    }

    /* compiled from: OkHttpClient.java */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        Proxy f5253b;

        @Nullable
        c j;

        @Nullable
        okhttp3.internal.a.f k;

        @Nullable
        SSLSocketFactory m;

        @Nullable
        okhttp3.internal.f.c n;
        final List<t> e = new ArrayList();
        final List<t> f = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        n f5252a = new n();
        List<w> c = v.f5250a;
        List<k> d = v.f5251b;
        p.a g = p.a(p.f5236a);
        ProxySelector h = ProxySelector.getDefault();
        m i = m.f5232a;
        SocketFactory l = SocketFactory.getDefault();
        HostnameVerifier o = okhttp3.internal.f.d.f5168a;
        g p = g.f5077a;
        b q = b.f5059a;
        b r = b.f5059a;
        j s = new j();
        o t = o.f5235a;
        boolean u = true;
        boolean v = true;
        boolean w = true;
        int x = 10000;
        int y = 10000;
        int z = 10000;
        int A = 0;

        public a a(@Nullable c cVar) {
            this.j = cVar;
            this.k = null;
            return this;
        }

        public v a() {
            return new v(this);
        }
    }
}
