package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.k;

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<k> f5135a;

    /* renamed from: b, reason: collision with root package name */
    private int f5136b = 0;
    private boolean c;
    private boolean d;

    public b(List<k> list) {
        this.f5135a = list;
    }

    public k a(SSLSocket sSLSocket) throws UnknownServiceException {
        k kVar;
        int i = this.f5136b;
        int size = this.f5135a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f5135a.get(i);
            if (kVar.a(sSLSocket)) {
                this.f5136b = i + 1;
                break;
            }
            i++;
        }
        if (kVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f5135a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.c = b(sSLSocket);
        okhttp3.internal.a.f5084a.a(kVar, sSLSocket, this.d);
        return kVar;
    }

    public boolean a(IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f5136b; i < this.f5135a.size(); i++) {
            if (this.f5135a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
