package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* loaded from: classes.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    final a f5055a;

    /* renamed from: b, reason: collision with root package name */
    final Proxy f5056b;
    final InetSocketAddress c;

    public ac(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f5055a = aVar;
        this.f5056b = proxy;
        this.c = inetSocketAddress;
    }

    public a a() {
        return this.f5055a;
    }

    public Proxy b() {
        return this.f5056b;
    }

    public InetSocketAddress c() {
        return this.c;
    }

    public boolean d() {
        return this.f5055a.i != null && this.f5056b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ac) {
            ac acVar = (ac) obj;
            if (acVar.f5055a.equals(this.f5055a) && acVar.f5056b.equals(this.f5056b) && acVar.c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f5055a.hashCode()) * 31) + this.f5056b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + "}";
    }
}
