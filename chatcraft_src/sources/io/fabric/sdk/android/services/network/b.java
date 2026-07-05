package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.k;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: DefaultHttpRequestFactory.java */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final k f4332a;

    /* renamed from: b, reason: collision with root package name */
    private f f4333b;
    private SSLSocketFactory c;
    private boolean d;

    public b() {
        this(new io.fabric.sdk.android.b());
    }

    public b(k kVar) {
        this.f4332a = kVar;
    }

    @Override // io.fabric.sdk.android.services.network.d
    public void a(f fVar) {
        if (this.f4333b != fVar) {
            this.f4333b = fVar;
            a();
        }
    }

    private synchronized void a() {
        this.d = false;
        this.c = null;
    }

    @Override // io.fabric.sdk.android.services.network.d
    public HttpRequest a(c cVar, String str, Map<String, String> map) {
        HttpRequest httpRequestA;
        SSLSocketFactory sSLSocketFactoryB;
        switch (cVar) {
            case GET:
                httpRequestA = HttpRequest.a((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case POST:
                httpRequestA = HttpRequest.b((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case PUT:
                httpRequestA = HttpRequest.d((CharSequence) str);
                break;
            case DELETE:
                httpRequestA = HttpRequest.e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(str) && this.f4333b != null && (sSLSocketFactoryB = b()) != null) {
            ((HttpsURLConnection) httpRequestA.a()).setSSLSocketFactory(sSLSocketFactoryB);
        }
        return httpRequestA;
    }

    private boolean a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory b() {
        if (this.c == null && !this.d) {
            this.c = c();
        }
        return this.c;
    }

    private synchronized SSLSocketFactory c() {
        SSLSocketFactory sSLSocketFactoryA;
        this.d = true;
        try {
            sSLSocketFactoryA = e.a(this.f4333b);
            this.f4332a.a("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.f4332a.e("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return sSLSocketFactoryA;
    }
}
