package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes.dex */
final class ga extends hb {

    /* renamed from: a, reason: collision with root package name */
    private final py f3093a;

    ga(py pyVar) {
        this.f3093a = pyVar;
    }

    @Override // com.google.android.gms.internal.ads.hb
    public final ox a(blc<?> blcVar, Map<String, String> map) throws IOException {
        try {
            HttpResponse httpResponseB = this.f3093a.b(blcVar, map);
            int statusCode = httpResponseB.getStatusLine().getStatusCode();
            Header[] allHeaders = httpResponseB.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new bfd(header.getName(), header.getValue()));
            }
            if (httpResponseB.getEntity() == null) {
                return new ox(statusCode, arrayList);
            }
            long contentLength = httpResponseB.getEntity().getContentLength();
            if (((int) contentLength) != contentLength) {
                StringBuilder sb = new StringBuilder(40);
                sb.append("Response too large: ");
                sb.append(contentLength);
                throw new IOException(sb.toString());
            }
            return new ox(statusCode, arrayList, (int) httpResponseB.getEntity().getContentLength(), httpResponseB.getEntity().getContent());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
