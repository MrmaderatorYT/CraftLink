package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
/* loaded from: classes.dex */
public final class yf extends ye {
    @Override // com.google.android.gms.internal.ads.ya, com.google.android.gms.internal.ads.xv
    public final int f() {
        return R.style.Theme.Material.Dialog.Alert;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final CookieManager c(Context context) {
        if (e()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            xe.b("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.ax.i().a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.xy, com.google.android.gms.internal.ads.xv
    public final afv a(afu afuVar, bos bosVar, boolean z) {
        return new agu(afuVar, bosVar, z);
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final WebResourceResponse a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
