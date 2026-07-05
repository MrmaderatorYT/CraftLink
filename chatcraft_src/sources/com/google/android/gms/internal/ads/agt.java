package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@qj
@TargetApi(11)
/* loaded from: classes.dex */
public class agt extends afv {
    public agt(afu afuVar, bos bosVar, boolean z) {
        super(afuVar, bosVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final WebResourceResponse a(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof afu)) {
            xe.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        afu afuVar = (afu) webView;
        if (this.f1942a != null) {
            this.f1942a.a(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.a(str, map);
        }
        if (afuVar.w() != null) {
            afuVar.w().n();
        }
        if (afuVar.u().e()) {
            str2 = (String) bra.e().a(o.H);
        } else if (afuVar.B()) {
            str2 = (String) bra.e().a(o.G);
        } else {
            str2 = (String) bra.e().a(o.F);
        }
        com.google.android.gms.ads.internal.ax.e();
        return xn.c(afuVar.getContext(), afuVar.k().f1790a, str2);
    }
}
