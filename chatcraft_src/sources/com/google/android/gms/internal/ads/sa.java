package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
final class sa extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f3436a;

    sa(HttpURLConnection httpURLConnection) {
        super(qz.b(httpURLConnection));
        this.f3436a = httpURLConnection;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f3436a.disconnect();
    }
}
