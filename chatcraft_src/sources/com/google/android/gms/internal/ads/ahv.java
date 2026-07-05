package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class ahv extends ahs implements ahy {

    /* renamed from: a, reason: collision with root package name */
    private final aht f1997a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f1998b;

    @GuardedBy("this")
    private boolean c;

    public ahv(Context context, aht ahtVar) {
        super(context);
        com.google.android.gms.ads.internal.ax.i().h();
        this.f1997a = ahtVar;
        super.setWebViewClient(ahtVar);
    }

    @GuardedBy("this")
    protected void g(boolean z) {
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    public final synchronized boolean C() {
        return this.f1998b;
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (this.f1998b) {
            return;
        }
        this.f1998b = true;
        this.f1997a.a(this);
        g(false);
        xe.a("Initiating WebView self destruct sequence in 3...");
        xe.a("Loading blank page in WebView, 2...");
        try {
            super.loadUrl("about:blank");
        } catch (UnsatisfiedLinkError e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "AdWebViewImpl.loadUrlUnsafe");
            xe.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ahy
    public final synchronized void a(ahu ahuVar) {
        xe.a("Blank page loaded, 1...");
        D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void D() {
        xe.a("Destroying WebView!");
        a();
        abq.f1816a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ahw

            /* renamed from: a, reason: collision with root package name */
            private final ahv f1999a;

            {
                this.f1999a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1999a.M();
            }
        });
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!C()) {
                    g(true);
                }
                a();
            }
        } finally {
            super.finalize();
        }
    }

    private final synchronized void a() {
        if (!this.c) {
            this.c = true;
            com.google.android.gms.ads.internal.ax.i().i();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (C()) {
            xe.e("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.google.android.gms.internal.ads.ahs, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (!C()) {
            super.loadUrl(str);
        } else {
            xe.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (!C()) {
            super.loadData(str, str2, str3);
        } else {
            xe.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!C()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            xe.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !C() && super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (C()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public void onPause() {
        if (C()) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public void onResume() {
        if (C()) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public void stopLoading() {
        if (C()) {
            return;
        }
        super.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.ahs, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.google.android.gms.internal.ads.ahs, com.google.android.gms.internal.ads.hu
    public /* bridge */ /* synthetic */ void d(String str) {
        super.d(str);
    }

    final /* synthetic */ void M() {
        super.destroy();
    }
}
