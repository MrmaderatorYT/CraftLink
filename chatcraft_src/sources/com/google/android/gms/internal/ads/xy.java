package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import java.util.Set;

@TargetApi(11)
/* loaded from: classes.dex */
public class xy extends xx {
    @Override // com.google.android.gms.internal.ads.xv
    public boolean a(Context context, WebSettings webSettings) {
        super.a(context, webSettings);
        return ((Boolean) zt.a(context, new xz(this, context, webSettings))).booleanValue();
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final boolean c(View view) {
        view.setLayerType(1, null);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final boolean b(View view) {
        view.setLayerType(0, null);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final boolean a(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public afv a(afu afuVar, bos bosVar, boolean z) {
        return new ags(afuVar, bosVar, z);
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final Set<String> a(Uri uri) {
        return uri.getQueryParameterNames();
    }

    @Override // com.google.android.gms.internal.ads.xx, com.google.android.gms.internal.ads.xv
    public final boolean a(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }
}
