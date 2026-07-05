package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f5077a = new a().a();

    /* renamed from: b, reason: collision with root package name */
    private final Set<b> f5078b;

    @Nullable
    private final okhttp3.internal.f.c c;

    g(Set<b> set, @Nullable okhttp3.internal.f.c cVar) {
        this.f5078b = set;
        this.c = cVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (okhttp3.internal.c.a(this.c, gVar.c) && this.f5078b.equals(gVar.f5078b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.c != null ? this.c.hashCode() : 0) * 31) + this.f5078b.hashCode();
    }

    public void a(String str, List<Certificate> list) {
        List<b> listA = a(str);
        if (listA.isEmpty()) {
            return;
        }
        if (this.c != null) {
            list = this.c.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listA.size();
            b.f fVarB = null;
            b.f fVarA = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = listA.get(i2);
                if (bVar.c.equals("sha256/")) {
                    if (fVarB == null) {
                        fVarB = b(x509Certificate);
                    }
                    if (bVar.d.equals(fVarB)) {
                        return;
                    }
                } else if (bVar.c.equals("sha1/")) {
                    if (fVarA == null) {
                        fVarA = a(x509Certificate);
                    }
                    if (bVar.d.equals(fVarA)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listA.size();
        for (int i4 = 0; i4 < size4; i4++) {
            b bVar2 = listA.get(i4);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<b> a(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f5078b) {
            if (bVar.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    g a(@Nullable okhttp3.internal.f.c cVar) {
        return okhttp3.internal.c.a(this.c, cVar) ? this : new g(this.f5078b, cVar);
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).b();
    }

    static b.f a(X509Certificate x509Certificate) {
        return b.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    static b.f b(X509Certificate x509Certificate) {
        return b.f.a(x509Certificate.getPublicKey().getEncoded()).e();
    }

    /* compiled from: CertificatePinner.java */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f5080a;

        /* renamed from: b, reason: collision with root package name */
        final String f5081b;
        final String c;
        final b.f d;

        boolean a(String str) {
            if (this.f5080a.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                return (str.length() - iIndexOf) - 1 == this.f5081b.length() && str.regionMatches(false, iIndexOf + 1, this.f5081b, 0, this.f5081b.length());
            }
            return str.equals(this.f5081b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f5080a.equals(bVar.f5080a) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f5080a.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.c + this.d.b();
        }
    }

    /* compiled from: CertificatePinner.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f5079a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f5079a), null);
        }
    }
}
