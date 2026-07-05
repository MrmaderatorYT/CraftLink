package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* loaded from: classes.dex */
public abstract class hb implements py {
    public abstract ox a(blc<?> blcVar, Map<String, String> map);

    @Override // com.google.android.gms.internal.ads.py
    @Deprecated
    public final HttpResponse b(blc<?> blcVar, Map<String, String> map) {
        ox oxVarA = a(blcVar, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), oxVarA.a(), BuildConfig.FLAVOR));
        ArrayList arrayList = new ArrayList();
        for (bfd bfdVar : oxVarA.b()) {
            arrayList.add(new BasicHeader(bfdVar.a(), bfdVar.b()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream inputStreamD = oxVarA.d();
        if (inputStreamD != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStreamD);
            basicHttpEntity.setContentLength(oxVarA.c());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
