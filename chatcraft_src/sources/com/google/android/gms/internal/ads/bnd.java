package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class bnd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bmv f2866a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebView f2867b;
    final /* synthetic */ boolean c;
    final /* synthetic */ bnb d;
    private ValueCallback<String> e = new bnf(this);

    bnd(bnb bnbVar, bmv bmvVar, WebView webView, boolean z) {
        this.d = bnbVar;
        this.f2866a = bmvVar;
        this.f2867b = webView;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2867b.getSettings().getJavaScriptEnabled()) {
            try {
                this.f2867b.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.e);
            } catch (Throwable unused) {
                this.e.onReceiveValue(BuildConfig.FLAVOR);
            }
        }
    }
}
