package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
final class ahx {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("InvokeJavascriptWorkaround.class")
    private static Boolean f2000a;

    private ahx() {
    }

    @TargetApi(19)
    private static boolean a(WebView webView) {
        boolean zBooleanValue;
        synchronized (ahx.class) {
            if (f2000a == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    f2000a = true;
                } catch (IllegalStateException unused) {
                    f2000a = false;
                }
                zBooleanValue = f2000a.booleanValue();
            } else {
                zBooleanValue = f2000a.booleanValue();
            }
        }
        return zBooleanValue;
    }

    @TargetApi(19)
    static void a(WebView webView, String str) {
        if (com.google.android.gms.common.util.j.f() && a(webView)) {
            webView.evaluateJavascript(str, null);
        } else {
            String strValueOf = String.valueOf(str);
            webView.loadUrl(strValueOf.length() != 0 ? "javascript:".concat(strValueOf) : new String("javascript:"));
        }
    }
}
