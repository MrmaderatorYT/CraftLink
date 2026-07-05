package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes.dex */
public final class k {
    final boolean d;
    final boolean e;

    @Nullable
    final String[] f;

    @Nullable
    final String[] g;
    private static final h[] h = {h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.aI, h.aJ, h.ag, h.ah, h.E, h.I, h.i};

    /* renamed from: a, reason: collision with root package name */
    public static final k f5226a = new a(true).a(h).a(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0).a(true).a();

    /* renamed from: b, reason: collision with root package name */
    public static final k f5227b = new a(f5226a).a(ad.TLS_1_0).a(true).a();
    public static final k c = new a(false).a();

    k(a aVar) {
        this.d = aVar.f5228a;
        this.f = aVar.f5229b;
        this.g = aVar.c;
        this.e = aVar.d;
    }

    public boolean a() {
        return this.d;
    }

    @Nullable
    public List<h> b() {
        if (this.f != null) {
            return h.a(this.f);
        }
        return null;
    }

    @Nullable
    public List<ad> c() {
        if (this.g != null) {
            return ad.a(this.g);
        }
        return null;
    }

    public boolean d() {
        return this.e;
    }

    void a(SSLSocket sSLSocket, boolean z) {
        k kVarB = b(sSLSocket, z);
        if (kVarB.g != null) {
            sSLSocket.setEnabledProtocols(kVarB.g);
        }
        if (kVarB.f != null) {
            sSLSocket.setEnabledCipherSuites(kVarB.f);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f != null) {
            enabledCipherSuites = okhttp3.internal.c.a(h.f5082a, sSLSocket.getEnabledCipherSuites(), this.f);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.g != null) {
            enabledProtocols = okhttp3.internal.c.a(okhttp3.internal.c.h, sSLSocket.getEnabledProtocols(), this.g);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iA = okhttp3.internal.c.a(h.f5082a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iA != -1) {
            enabledCipherSuites = okhttp3.internal.c.a(enabledCipherSuites, supportedCipherSuites[iA]);
        }
        return new a(this).a(enabledCipherSuites).b(enabledProtocols).a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (this.g == null || okhttp3.internal.c.b(okhttp3.internal.c.h, this.g, sSLSocket.getEnabledProtocols())) {
            return this.f == null || okhttp3.internal.c.b(h.f5082a, this.f, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        if (this.d != kVar.d) {
            return false;
        }
        return !this.d || (Arrays.equals(this.f, kVar.f) && Arrays.equals(this.g, kVar.g) && this.e == kVar.e);
    }

    public int hashCode() {
        if (this.d) {
            return ((((527 + Arrays.hashCode(this.f)) * 31) + Arrays.hashCode(this.g)) * 31) + (!this.e ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.g != null ? c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.e + ")";
    }

    /* compiled from: ConnectionSpec.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f5228a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        String[] f5229b;

        @Nullable
        String[] c;
        boolean d;

        a(boolean z) {
            this.f5228a = z;
        }

        public a(k kVar) {
            this.f5228a = kVar.d;
            this.f5229b = kVar.f;
            this.c = kVar.g;
            this.d = kVar.e;
        }

        public a a(h... hVarArr) {
            if (!this.f5228a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                strArr[i] = hVarArr[i].bj;
            }
            return a(strArr);
        }

        public a a(String... strArr) {
            if (!this.f5228a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f5229b = (String[]) strArr.clone();
            return this;
        }

        public a a(ad... adVarArr) {
            if (!this.f5228a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[adVarArr.length];
            for (int i = 0; i < adVarArr.length; i++) {
                strArr[i] = adVarArr[i].f;
            }
            return b(strArr);
        }

        public a b(String... strArr) {
            if (!this.f5228a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (String[]) strArr.clone();
            return this;
        }

        public a a(boolean z) {
            if (!this.f5228a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public k a() {
            return new k(this);
        }
    }
}
