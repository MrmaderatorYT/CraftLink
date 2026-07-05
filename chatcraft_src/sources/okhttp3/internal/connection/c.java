package okhttp3.internal.connection;

import b.l;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.g;
import okhttp3.i;
import okhttp3.internal.http2.f;
import okhttp3.internal.http2.h;
import okhttp3.j;
import okhttp3.k;
import okhttp3.p;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;

/* compiled from: RealConnection.java */
/* loaded from: classes.dex */
public final class c extends f.b implements i {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5137a;

    /* renamed from: b, reason: collision with root package name */
    public int f5138b;
    public int c = 1;
    public final List<Reference<f>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final j g;
    private final ac h;
    private Socket i;
    private Socket j;
    private q k;
    private w l;
    private okhttp3.internal.http2.f m;
    private b.e n;
    private b.d o;

    public c(j jVar, ac acVar) {
        this.g = jVar;
        this.h = acVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e2 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.e r22, okhttp3.p r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.c.a(int, int, int, int, boolean, okhttp3.e, okhttp3.p):void");
    }

    private void a(int i, int i2, int i3, okhttp3.e eVar, p pVar) throws IOException {
        y yVarE = e();
        s sVarA = yVarE.a();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, eVar, pVar);
            yVarE = a(i2, i3, yVarE, sVarA);
            if (yVarE == null) {
                return;
            }
            okhttp3.internal.c.a(this.i);
            this.i = null;
            this.o = null;
            this.n = null;
            pVar.a(eVar, this.h.c(), this.h.b(), null);
        }
    }

    private void a(int i, int i2, okhttp3.e eVar, p pVar) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.h.b();
        okhttp3.a aVarA = this.h.a();
        if (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) {
            socketCreateSocket = aVarA.c().createSocket();
        } else {
            socketCreateSocket = new Socket(proxyB);
        }
        this.i = socketCreateSocket;
        pVar.a(eVar, this.h.c(), proxyB);
        this.i.setSoTimeout(i2);
        try {
            okhttp3.internal.e.f.c().a(this.i, this.h.c(), i);
            try {
                this.n = l.a(l.b(this.i));
                this.o = l.a(l.a(this.i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, int i, okhttp3.e eVar, p pVar) throws Throwable {
        if (this.h.a().i() == null) {
            this.l = w.HTTP_1_1;
            this.j = this.i;
            return;
        }
        pVar.b(eVar);
        a(bVar);
        pVar.a(eVar, this.k);
        if (this.l == w.HTTP_2) {
            this.j.setSoTimeout(0);
            this.m = new f.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a(i).a();
            this.m.c();
        }
    }

    private void a(b bVar) throws Throwable {
        SSLSocket sSLSocket;
        w wVarA;
        okhttp3.a aVarA = this.h.a();
        try {
            try {
                sSLSocket = (SSLSocket) aVarA.i().createSocket(this.i, aVarA.a().f(), aVarA.a().g(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
            sSLSocket = null;
        }
        try {
            k kVarA = bVar.a(sSLSocket);
            if (kVarA.d()) {
                okhttp3.internal.e.f.c().a(sSLSocket, aVarA.a().f(), aVarA.e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            if (!a(session)) {
                throw new IOException("a valid ssl session was not established");
            }
            q qVarA = q.a(session);
            if (!aVarA.j().verify(aVarA.a().f(), session)) {
                X509Certificate x509Certificate = (X509Certificate) qVarA.c().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + aVarA.a().f() + " not verified:\n    certificate: " + g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.internal.f.d.a(x509Certificate));
            }
            aVarA.k().a(aVarA.a().f(), qVarA.c());
            String strA = kVarA.d() ? okhttp3.internal.e.f.c().a(sSLSocket) : null;
            this.j = sSLSocket;
            this.n = l.a(l.b(this.j));
            this.o = l.a(l.a(this.j));
            this.k = qVarA;
            if (strA != null) {
                wVarA = w.a(strA);
            } else {
                wVarA = w.HTTP_1_1;
            }
            this.l = wVarA;
            if (sSLSocket != null) {
                okhttp3.internal.e.f.c().b(sSLSocket);
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!okhttp3.internal.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                okhttp3.internal.e.f.c().b(sSLSocket);
            }
            okhttp3.internal.c.a((Socket) sSLSocket);
            throw th;
        }
    }

    private boolean a(SSLSession sSLSession) {
        return ("NONE".equals(sSLSession.getProtocol()) || "SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite())) ? false : true;
    }

    private y a(int i, int i2, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + okhttp3.internal.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            okhttp3.internal.c.a aVar = new okhttp3.internal.c.a(null, null, this.n, this.o);
            this.n.a().a(i, TimeUnit.MILLISECONDS);
            this.o.a().a(i2, TimeUnit.MILLISECONDS);
            aVar.a(yVar.c(), str);
            aVar.b();
            aa aaVarA = aVar.a(false).a(yVar).a();
            long jA = okhttp3.internal.b.e.a(aaVarA);
            if (jA == -1) {
                jA = 0;
            }
            b.s sVarB = aVar.b(jA);
            okhttp3.internal.c.b(sVarB, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            sVarB.close();
            int iC = aaVarA.c();
            if (iC == 200) {
                if (this.n.c().e() && this.o.c().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iC == 407) {
                y yVarA = this.h.a().d().a(this.h, aaVarA);
                if (yVarA == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(aaVarA.a("Connection"))) {
                    return yVarA;
                }
                yVar = yVarA;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + aaVarA.c());
            }
        }
    }

    private y e() {
        return new y.a().a(this.h.a().a()).a("Host", okhttp3.internal.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", okhttp3.internal.d.a()).a();
    }

    public boolean a(okhttp3.a aVar, @Nullable ac acVar) {
        if (this.d.size() >= this.c || this.f5137a || !okhttp3.internal.a.f5084a.a(this.h.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(a().a().a().f())) {
            return true;
        }
        if (this.m == null || acVar == null || acVar.b().type() != Proxy.Type.DIRECT || this.h.b().type() != Proxy.Type.DIRECT || !this.h.c().equals(acVar.c()) || acVar.a().j() != okhttp3.internal.f.d.f5168a || !a(aVar.a())) {
            return false;
        }
        try {
            aVar.k().a(aVar.a().f(), c().c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.h.a().a().g()) {
            return false;
        }
        if (sVar.f().equals(this.h.a().a().f())) {
            return true;
        }
        return this.k != null && okhttp3.internal.f.d.f5168a.a(sVar.f(), (X509Certificate) this.k.c().get(0));
    }

    public okhttp3.internal.b.c a(v vVar, t.a aVar, f fVar) throws SocketException {
        if (this.m != null) {
            return new okhttp3.internal.http2.e(vVar, aVar, fVar, this.m);
        }
        this.j.setSoTimeout(aVar.c());
        this.n.a().a(aVar.c(), TimeUnit.MILLISECONDS);
        this.o.a().a(aVar.d(), TimeUnit.MILLISECONDS);
        return new okhttp3.internal.c.a(vVar, fVar, this.n, this.o);
    }

    public ac a() {
        return this.h;
    }

    public Socket b() {
        return this.j;
    }

    public boolean a(boolean z) throws SocketException {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        if (this.m != null) {
            return !this.m.d();
        }
        if (z) {
            try {
                int soTimeout = this.j.getSoTimeout();
                try {
                    this.j.setSoTimeout(1);
                    return !this.n.e();
                } finally {
                    this.j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.f.b
    public void a(h hVar) {
        hVar.a(okhttp3.internal.http2.a.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.f.b
    public void a(okhttp3.internal.http2.f fVar) {
        synchronized (this.g) {
            this.c = fVar.a();
        }
    }

    public q c() {
        return this.k;
    }

    public boolean d() {
        return this.m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.h.a().a().f());
        sb.append(":");
        sb.append(this.h.a().a().g());
        sb.append(", proxy=");
        sb.append(this.h.b());
        sb.append(" hostAddress=");
        sb.append(this.h.c());
        sb.append(" cipherSuite=");
        sb.append(this.k != null ? this.k.b() : "none");
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }
}
