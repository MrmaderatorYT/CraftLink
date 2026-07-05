package okhttp3.internal.e;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.w;

/* compiled from: AndroidPlatform.java */
/* loaded from: classes.dex */
class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f5148a;

    /* renamed from: b, reason: collision with root package name */
    private final e<Socket> f5149b;
    private final e<Socket> c;
    private final e<Socket> d;
    private final e<Socket> e;
    private final c f = c.a();

    a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f5148a = cls;
        this.f5149b = eVar;
        this.c = eVar2;
        this.d = eVar3;
        this.e = eVar4;
    }

    @Override // okhttp3.internal.e.f
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!okhttp3.internal.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // okhttp3.internal.e.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.f5149b.b(sSLSocket, true);
            this.c.b(sSLSocket, str);
        }
        if (this.e == null || !this.e.a((e<Socket>) sSLSocket)) {
            return;
        }
        this.e.d(sSLSocket, b(list));
    }

    @Override // okhttp3.internal.e.f
    @Nullable
    public String a(SSLSocket sSLSocket) {
        byte[] bArr;
        if (this.d == null || !this.d.a((e<Socket>) sSLSocket) || (bArr = (byte[]) this.d.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, okhttp3.internal.c.e);
    }

    @Override // okhttp3.internal.e.f
    public void a(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // okhttp3.internal.e.f
    public Object a(String str) {
        return this.f.a(str);
    }

    @Override // okhttp3.internal.e.f
    public void a(String str, Object obj) {
        if (this.f.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // okhttp3.internal.e.f
    public boolean b(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw okhttp3.internal.c.a("unable to determine cleartext support", e);
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    private static boolean b() throws ClassNotFoundException {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.e.f
    public okhttp3.internal.f.c a(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0124a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static f a() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (b()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // okhttp3.internal.e.f
    public okhttp3.internal.f.e b(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: okhttp3.internal.e.a$a, reason: collision with other inner class name */
    static final class C0124a extends okhttp3.internal.f.c {

        /* renamed from: a, reason: collision with root package name */
        private final Object f5150a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f5151b;

        public int hashCode() {
            return 0;
        }

        C0124a(Object obj, Method method) {
            this.f5150a = obj;
            this.f5151b = method;
        }

        @Override // okhttp3.internal.f.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f5151b.invoke(this.f5150a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0124a;
        }
    }

    /* compiled from: AndroidPlatform.java */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5154a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f5155b;
        private final Method c;

        c(Method method, Method method2, Method method3) {
            this.f5154a = method;
            this.f5155b = method2;
            this.c = method3;
        }

        Object a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f5154a != null) {
                try {
                    Object objInvoke = this.f5154a.invoke(null, new Object[0]);
                    this.f5155b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static c a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }
    }

    /* compiled from: AndroidPlatform.java */
    static final class b implements okhttp3.internal.f.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f5152a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f5153b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f5153b = method;
            this.f5152a = x509TrustManager;
        }

        @Override // okhttp3.internal.f.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5153b.invoke(this.f5152a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw okhttp3.internal.c.a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f5152a.equals(bVar.f5152a) && this.f5153b.equals(bVar.f5153b);
        }

        public int hashCode() {
            return this.f5152a.hashCode() + (this.f5153b.hashCode() * 31);
        }
    }
}
