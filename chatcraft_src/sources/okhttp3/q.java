package okhttp3;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final ad f5238a;

    /* renamed from: b, reason: collision with root package name */
    private final h f5239b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private q(ad adVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f5238a = adVar;
        this.f5239b = hVar;
        this.c = list;
        this.d = list2;
    }

    public static q a(SSLSession sSLSession) throws SSLPeerUnverifiedException {
        Certificate[] peerCertificates;
        List listEmptyList;
        List listEmptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        h hVarA = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ad adVarA = ad.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            listEmptyList = okhttp3.internal.c.a(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = okhttp3.internal.c.a(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new q(adVarA, hVarA, listEmptyList, listEmptyList2);
    }

    public static q a(ad adVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        if (adVar == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (hVar == null) {
            throw new NullPointerException("cipherSuite == null");
        }
        return new q(adVar, hVar, okhttp3.internal.c.a(list), okhttp3.internal.c.a(list2));
    }

    public ad a() {
        return this.f5238a;
    }

    public h b() {
        return this.f5239b;
    }

    public List<Certificate> c() {
        return this.c;
    }

    public List<Certificate> d() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f5238a.equals(qVar.f5238a) && this.f5239b.equals(qVar.f5239b) && this.c.equals(qVar.c) && this.d.equals(qVar.d);
    }

    public int hashCode() {
        return ((((((527 + this.f5238a.hashCode()) * 31) + this.f5239b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }
}
