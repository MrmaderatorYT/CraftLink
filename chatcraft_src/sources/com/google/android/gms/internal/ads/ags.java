package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

@qj
@TargetApi(11)
/* loaded from: classes.dex */
public final class ags extends agt {
    public ags(afu afuVar, bos bosVar, boolean z) {
        super(afuVar, bosVar, z);
    }

    @Override // com.google.android.gms.internal.ads.afv, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str, (Map<String, String>) null);
    }
}
