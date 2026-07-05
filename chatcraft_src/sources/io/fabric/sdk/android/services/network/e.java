package io.fabric.sdk.android.services.network;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils.java */
/* loaded from: classes.dex */
public final class e {
    public static final SSLSocketFactory a(f fVar) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new g(new h(fVar.a(), fVar.b()), fVar)}, null);
        return sSLContext.getSocketFactory();
    }
}
