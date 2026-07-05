package okhttp3.internal.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import okhttp3.w;

/* compiled from: Jdk9Platform.java */
/* loaded from: classes.dex */
final class c extends f {

    /* renamed from: a, reason: collision with root package name */
    final Method f5156a;

    /* renamed from: b, reason: collision with root package name */
    final Method f5157b;

    c(Method method, Method method2) {
        this.f5156a = method;
        this.f5157b = method2;
    }

    @Override // okhttp3.internal.e.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listA = a(list);
            this.f5156a.invoke(sSLParameters, listA.toArray(new String[listA.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.c.a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // okhttp3.internal.e.f
    @Nullable
    public String a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5157b.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals(BuildConfig.FLAVOR)) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.c.a("unable to get selected protocols", (Exception) e);
        }
    }

    public static c b() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
