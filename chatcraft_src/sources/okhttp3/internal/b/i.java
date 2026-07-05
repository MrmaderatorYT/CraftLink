package okhttp3.internal.b;

import java.net.Proxy;
import okhttp3.s;
import okhttp3.y;

/* compiled from: RequestLine.java */
/* loaded from: classes.dex */
public final class i {
    public static String a(y yVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.b());
        sb.append(' ');
        if (b(yVar, type)) {
            sb.append(yVar.a());
        } else {
            sb.append(a(yVar.a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(y yVar, Proxy.Type type) {
        return !yVar.g() && type == Proxy.Type.HTTP;
    }

    public static String a(s sVar) {
        String strH = sVar.h();
        String strJ = sVar.j();
        if (strJ == null) {
            return strH;
        }
        return strH + '?' + strJ;
    }
}
