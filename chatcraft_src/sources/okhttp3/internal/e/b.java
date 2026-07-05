package okhttp3.internal.e;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import okhttp3.w;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

/* compiled from: ConscryptPlatform.java */
/* loaded from: classes.dex */
public class b extends f {
    private b() {
    }

    private Provider f() {
        return new OpenSSLProvider();
    }

    @Override // okhttp3.internal.e.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) f.a(list).toArray(new String[0]));
            return;
        }
        super.a(sSLSocket, str, list);
    }

    @Override // okhttp3.internal.e.f
    @Nullable
    public String a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.a(sSLSocket);
    }

    @Override // okhttp3.internal.e.f
    public SSLContext K_() {
        try {
            return SSLContext.getInstance("TLS", f());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public static f b() throws ClassNotFoundException {
        try {
            Class.forName("org.conscrypt.ConscryptEngineSocket");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            Conscrypt.setUseEngineSocketByDefault(true);
            return new b();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
