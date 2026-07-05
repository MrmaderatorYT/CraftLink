package okhttp3.internal.b;

import com.github.steveice10.mc.v1_13_1.protocol.MinecraftConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.p;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.y;
import okhttp3.z;

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes.dex */
public final class j implements t {

    /* renamed from: a, reason: collision with root package name */
    private final v f5116a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5117b;
    private volatile okhttp3.internal.connection.f c;
    private Object d;
    private volatile boolean e;

    public j(v vVar, boolean z) {
        this.f5116a = vVar;
        this.f5117b = z;
    }

    public boolean a() {
        return this.e;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    @Override // okhttp3.t
    public aa a(t.a aVar) throws IOException {
        aa aaVarA;
        y yVarA;
        y yVarA2 = aVar.a();
        g gVar = (g) aVar;
        okhttp3.e eVarH = gVar.h();
        p pVarI = gVar.i();
        okhttp3.internal.connection.f fVar = new okhttp3.internal.connection.f(this.f5116a.q(), a(yVarA2.a()), eVarH, pVarI, this.d);
        this.c = fVar;
        aa aaVar = null;
        int i = 0;
        while (!this.e) {
            try {
                try {
                    aa aaVarA2 = gVar.a(yVarA2, fVar, null, null);
                    aaVarA = aaVar != null ? aaVarA2.i().c(aaVar.i().a((ab) null).a()).a() : aaVarA2;
                    yVarA = a(aaVarA, fVar.b());
                } catch (IOException e) {
                    if (!a(e, fVar, !(e instanceof ConnectionShutdownException), yVarA2)) {
                        throw e;
                    }
                } catch (RouteException e2) {
                    if (!a(e2.a(), fVar, false, yVarA2)) {
                        throw e2.a();
                    }
                }
                if (yVarA == null) {
                    if (!this.f5117b) {
                        fVar.d();
                    }
                    return aaVarA;
                }
                okhttp3.internal.c.a(aaVarA.h());
                int i2 = i + 1;
                if (i2 > 20) {
                    fVar.d();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (yVarA.d() instanceof l) {
                    fVar.d();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", aaVarA.c());
                }
                if (!a(aaVarA, yVarA.a())) {
                    fVar.d();
                    fVar = new okhttp3.internal.connection.f(this.f5116a.q(), a(yVarA.a()), eVarH, pVarI, this.d);
                    this.c = fVar;
                } else if (fVar.a() != null) {
                    throw new IllegalStateException("Closing the body of " + aaVarA + " didn't close its backing stream. Bad interceptor?");
                }
                aaVar = aaVarA;
                yVarA2 = yVarA;
                i = i2;
            } catch (Throwable th) {
                fVar.a((IOException) null);
                fVar.d();
                throw th;
            }
        }
        fVar.d();
        throw new IOException("Canceled");
    }

    private okhttp3.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierM;
        okhttp3.g gVarN;
        if (sVar.c()) {
            SSLSocketFactory sSLSocketFactoryL = this.f5116a.l();
            hostnameVerifierM = this.f5116a.m();
            sSLSocketFactory = sSLSocketFactoryL;
            gVarN = this.f5116a.n();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierM = null;
            gVarN = null;
        }
        return new okhttp3.a(sVar.f(), sVar.g(), this.f5116a.j(), this.f5116a.k(), sSLSocketFactory, hostnameVerifierM, gVarN, this.f5116a.p(), this.f5116a.e(), this.f5116a.v(), this.f5116a.w(), this.f5116a.f());
    }

    private boolean a(IOException iOException, okhttp3.internal.connection.f fVar, boolean z, y yVar) throws IOException {
        fVar.a(iOException);
        if (this.f5116a.t()) {
            return !(z && (yVar.d() instanceof l)) && a(iOException, z) && fVar.f();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private y a(aa aaVar, ac acVar) throws ProtocolException {
        String strA;
        s sVarC;
        Proxy proxyE;
        if (aaVar == null) {
            throw new IllegalStateException();
        }
        int iC = aaVar.c();
        String strB = aaVar.a().b();
        switch (iC) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case 308:
                if (!strB.equals("GET") && !strB.equals("HEAD")) {
                    return null;
                }
                break;
            case MinecraftConstants.PROTOCOL_VERSION /* 401 */:
                return this.f5116a.o().a(acVar, aaVar);
            case 407:
                if (acVar != null) {
                    proxyE = acVar.b();
                } else {
                    proxyE = this.f5116a.e();
                }
                if (proxyE.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f5116a.p().a(acVar, aaVar);
            case 408:
                if (!this.f5116a.t() || (aaVar.a().d() instanceof l)) {
                    return null;
                }
                if ((aaVar.l() == null || aaVar.l().c() != 408) && a(aaVar, 0) <= 0) {
                    return aaVar.a();
                }
                return null;
            case 503:
                if ((aaVar.l() == null || aaVar.l().c() != 503) && a(aaVar, Integer.MAX_VALUE) == 0) {
                    return aaVar.a();
                }
                return null;
            default:
                return null;
        }
        if (!this.f5116a.s() || (strA = aaVar.a("Location")) == null || (sVarC = aaVar.a().a().c(strA)) == null) {
            return null;
        }
        if (!sVarC.b().equals(aaVar.a().a().b()) && !this.f5116a.r()) {
            return null;
        }
        y.a aVarE = aaVar.a().e();
        if (f.c(strB)) {
            boolean zD = f.d(strB);
            if (f.e(strB)) {
                aVarE.a("GET", (z) null);
            } else {
                aVarE.a(strB, zD ? aaVar.a().d() : null);
            }
            if (!zD) {
                aVarE.b("Transfer-Encoding");
                aVarE.b("Content-Length");
                aVarE.b("Content-Type");
            }
        }
        if (!a(aaVar, sVarC)) {
            aVarE.b("Authorization");
        }
        return aVarE.a(sVarC).a();
    }

    private int a(aa aaVar, int i) {
        String strA = aaVar.a("Retry-After");
        if (strA == null) {
            return i;
        }
        if (strA.matches("\\d+")) {
            return Integer.valueOf(strA).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean a(aa aaVar, s sVar) {
        s sVarA = aaVar.a().a();
        return sVarA.f().equals(sVar.f()) && sVarA.g() == sVar.g() && sVarA.b().equals(sVar.b());
    }
}
