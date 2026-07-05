package okhttp3.internal.e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.v;
import okhttp3.w;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final f f5164a = b();

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f5165b = Logger.getLogger(v.class.getName());

    @Nullable
    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }

    public String d() {
        return "OkHttp";
    }

    public static f c() {
        return f5164a;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        f5165b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f5165b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public okhttp3.internal.f.c a(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.f.a(b(x509TrustManager));
    }

    public static boolean e() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static f b() {
        f fVarB;
        f fVarA = a.a();
        if (fVarA != null) {
            return fVarA;
        }
        if (e() && (fVarB = b.b()) != null) {
            return fVarB;
        }
        c cVarB = c.b();
        if (cVarB != null) {
            return cVarB;
        }
        f fVarB2 = d.b();
        return fVarB2 != null ? fVarB2 : new f();
    }

    static byte[] b(List<w> list) {
        b.c cVar = new b.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                cVar.i(wVar.toString().length());
                cVar.b(wVar.toString());
            }
        }
        return cVar.r();
    }

    public SSLContext K_() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public okhttp3.internal.f.e b(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.f.b(x509TrustManager.getAcceptedIssuers());
    }
}
