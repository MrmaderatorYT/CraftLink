package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class agg extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, afu {

    @GuardedBy("this")
    private bd A;

    @GuardedBy("this")
    private int B;

    @GuardedBy("this")
    private int C;
    private z D;
    private z E;
    private z F;
    private aa G;
    private WeakReference<View.OnClickListener> H;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.d I;

    @GuardedBy("this")
    private boolean J;
    private aab K;
    private int L;
    private int M;
    private int N;
    private int O;
    private Map<String, aex> P;
    private final WindowManager Q;
    private final bos R;

    /* renamed from: a, reason: collision with root package name */
    private final ahg f1958a;

    /* renamed from: b, reason: collision with root package name */
    private final axe f1959b;
    private final aar c;
    private final com.google.android.gms.ads.internal.aq d;
    private final com.google.android.gms.ads.internal.bt e;
    private final DisplayMetrics f;
    private final float g;
    private boolean h;
    private boolean i;
    private afv j;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.d k;

    @GuardedBy("this")
    private com.google.android.gms.dynamic.a l;

    @GuardedBy("this")
    private ahh m;

    @GuardedBy("this")
    private String n;

    @GuardedBy("this")
    private boolean o;

    @GuardedBy("this")
    private boolean p;

    @GuardedBy("this")
    private boolean q;

    @GuardedBy("this")
    private boolean r;

    @GuardedBy("this")
    private Boolean s;

    @GuardedBy("this")
    private int t;

    @GuardedBy("this")
    private boolean u;

    @GuardedBy("this")
    private boolean v;

    @GuardedBy("this")
    private String w;

    @GuardedBy("this")
    private agj x;

    @GuardedBy("this")
    private boolean y;

    @GuardedBy("this")
    private boolean z;

    static agg a(Context context, ahh ahhVar, String str, boolean z, boolean z2, axe axeVar, aar aarVar, ac acVar, com.google.android.gms.ads.internal.aq aqVar, com.google.android.gms.ads.internal.bt btVar, bos bosVar) {
        return new agg(new ahg(context), ahhVar, str, z, z2, axeVar, aarVar, acVar, aqVar, btVar, bosVar);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final adb a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.aha
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final WebView getWebView() {
        return this;
    }

    private agg(ahg ahgVar, ahh ahhVar, String str, boolean z, boolean z2, axe axeVar, aar aarVar, ac acVar, com.google.android.gms.ads.internal.aq aqVar, com.google.android.gms.ads.internal.bt btVar, bos bosVar) {
        super(ahgVar);
        this.h = false;
        this.i = false;
        this.u = true;
        this.v = false;
        this.w = BuildConfig.FLAVOR;
        this.L = -1;
        this.M = -1;
        this.N = -1;
        this.O = -1;
        this.f1958a = ahgVar;
        this.m = ahhVar;
        this.n = str;
        this.q = z;
        this.t = -1;
        this.f1959b = axeVar;
        this.c = aarVar;
        this.d = aqVar;
        this.e = btVar;
        this.Q = (WindowManager) getContext().getSystemService("window");
        com.google.android.gms.ads.internal.ax.e();
        this.f = xn.a(this.Q);
        this.g = this.f.density;
        this.R = bosVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            xe.b("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        com.google.android.gms.ads.internal.ax.e().a(ahgVar, aarVar.f1790a, settings);
        com.google.android.gms.ads.internal.ax.g().a(getContext(), settings);
        setDownloadListener(this);
        Q();
        if (com.google.android.gms.common.util.j.d()) {
            addJavascriptInterface(agm.a(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.K = new aab(this.f1958a.a(), this, this, null);
        V();
        this.G = new aa(new ac(true, "make_wv", this.n));
        this.G.a().a(acVar);
        this.E = u.a(this.G.a());
        this.G.a("native:view_create", this.E);
        this.F = null;
        this.D = null;
        com.google.android.gms.ads.internal.ax.g().b(ahgVar);
        com.google.android.gms.ads.internal.ax.i().h();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof afv) {
            this.j = (afv) webViewClient;
        }
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final com.google.android.gms.ads.internal.bt e() {
        return this.e;
    }

    private final boolean M() throws JSONException {
        int i;
        int iB;
        if (!this.j.b() && !this.j.c()) {
            return false;
        }
        bra.a();
        int iB2 = aac.b(this.f, this.f.widthPixels);
        bra.a();
        int iB3 = aac.b(this.f, this.f.heightPixels);
        Activity activityA = this.f1958a.a();
        if (activityA == null || activityA.getWindow() == null) {
            i = iB2;
            iB = iB3;
        } else {
            com.google.android.gms.ads.internal.ax.e();
            int[] iArrA = xn.a(activityA);
            bra.a();
            int iB4 = aac.b(this.f, iArrA[0]);
            bra.a();
            iB = aac.b(this.f, iArrA[1]);
            i = iB4;
        }
        if (this.M == iB2 && this.L == iB3 && this.N == i && this.O == iB) {
            return false;
        }
        boolean z = (this.M == iB2 && this.L == iB3) ? false : true;
        this.M = iB2;
        this.L = iB3;
        this.N = i;
        this.O = iB;
        new nh(this).a(iB2, iB3, i, iB, this.f.density, this.Q.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, Map<String, ?> map) {
        try {
            a(str, com.google.android.gms.ads.internal.ax.e().a(map));
        } catch (JSONException unused) {
            xe.e("Could not convert parameters to JSON.");
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (C()) {
            xe.f("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    private final synchronized void c(String str) {
        if (!C()) {
            loadUrl(str);
        } else {
            xe.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final synchronized void loadUrl(String str) {
        if (!C()) {
            try {
                super.loadUrl(str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                com.google.android.gms.ads.internal.ax.i().a(e, "AdWebViewImpl.loadUrl");
                xe.c("Could not call loadUrl. ", e);
                return;
            }
        }
        xe.e("#004 The webview is destroyed. Ignoring action.");
    }

    private final synchronized void e(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "AdWebViewImpl.loadUrlUnsafe");
            xe.c("Could not call loadUrl. ", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!C()) {
            super.loadData(str, str2, str3);
        } else {
            xe.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!C()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            xe.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(String str, String str2, String str3) {
        if (!C()) {
            if (((Boolean) bra.e().a(o.ao)).booleanValue()) {
                str2 = agw.a(str2, agw.a());
            }
            super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", str3);
            return;
        }
        xe.e("#004 The webview is destroyed. Ignoring action.");
    }

    @TargetApi(19)
    private final synchronized void a(String str, ValueCallback<String> valueCallback) {
        if (!C()) {
            evaluateJavascript(str, null);
        } else {
            xe.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void f(String str) {
        if (com.google.android.gms.common.util.j.f()) {
            if (O() == null) {
                N();
            }
            if (O().booleanValue()) {
                a(str, (ValueCallback<String>) null);
                return;
            } else {
                String strValueOf = String.valueOf(str);
                c(strValueOf.length() != 0 ? "javascript:".concat(strValueOf) : new String("javascript:"));
                return;
            }
        }
        String strValueOf2 = String.valueOf(str);
        c(strValueOf2.length() != 0 ? "javascript:".concat(strValueOf2) : new String("javascript:"));
    }

    @Override // com.google.android.gms.internal.ads.hu
    public final void d(String str) {
        f(str);
    }

    private final synchronized void N() {
        this.s = com.google.android.gms.ads.internal.ax.i().b();
        if (this.s == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                a((Boolean) true);
            } catch (IllegalStateException unused) {
                a((Boolean) false);
            }
        }
    }

    private final void a(Boolean bool) {
        synchronized (this) {
            this.s = bool;
        }
        com.google.android.gms.ads.internal.ax.i().a(bool);
    }

    private final synchronized Boolean O() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.hu
    public final void b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(string).length());
        sb.append(str);
        sb.append("(");
        sb.append(string);
        sb.append(");");
        f(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(string);
        sb.append(");");
        String strValueOf = String.valueOf(sb.toString());
        xe.b(strValueOf.length() != 0 ? "Dispatching AFMA event: ".concat(strValueOf) : new String("Dispatching AFMA event: "));
        f(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void o() {
        P();
        HashMap map = new HashMap(1);
        map.put("version", this.c.f1790a);
        a("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(int i) {
        if (i == 0) {
            u.a(this.G.a(), this.E, "aebb2");
        }
        P();
        if (this.G.a() != null) {
            this.G.a().a("close_type", String.valueOf(i));
        }
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.c.f1790a);
        a("onhide", map);
    }

    private final void P() {
        u.a(this.G.a(), this.E, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void p() {
        if (this.D == null) {
            u.a(this.G.a(), this.E, "aes2");
            this.D = u.a(this.G.a());
            this.G.a("native:view_show", this.D);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.c.f1790a);
        a("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void q() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.ax.j().b()));
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.ax.j().a()));
        map.put("device_volume", String.valueOf(yh.a(getContext())));
        a("volume", map);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void a(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put("success", z ? "1" : "0");
        map.put("duration", Long.toString(j));
        a("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized com.google.android.gms.ads.internal.overlay.d s() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized com.google.android.gms.dynamic.a A() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized com.google.android.gms.ads.internal.overlay.d t() {
        return this.I;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agx
    public final synchronized ahh u() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized String v() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final WebViewClient x() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean y() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agy
    public final axe z() {
        return this.f1959b;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agz
    public final aar k() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agr
    public final synchronized boolean B() {
        return this.q;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.ax.e();
            xn.a(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            xe.b(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j.c()) {
            synchronized (this) {
                if (this.A != null) {
                    this.A.a(motionEvent);
                }
            }
        } else if (this.f1959b != null) {
            this.f1959b.a(motionEvent);
        }
        if (C()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0167  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agg.onMeasure(int, int):void");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() throws JSONException {
        boolean zM = M();
        com.google.android.gms.ads.internal.overlay.d dVarS = s();
        if (dVarS == null || !zM) {
            return;
        }
        dVarS.o();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(com.google.android.gms.ads.internal.overlay.d dVar) {
        this.k = dVar;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(com.google.android.gms.dynamic.a aVar) {
        this.l = aVar;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void b(com.google.android.gms.ads.internal.overlay.d dVar) {
        this.I = dVar;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(ahh ahhVar) {
        this.m = ahhVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void b(boolean z) {
        boolean z2 = z != this.q;
        this.q = z;
        Q();
        if (z2) {
            new nh(this).c(z ? "expanded" : "default");
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void H() {
        this.K.a();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!C()) {
            this.K.c();
        }
        boolean z = this.y;
        if (this.j != null && this.j.c()) {
            if (!this.z) {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerD = this.j.d();
                if (onGlobalLayoutListenerD != null) {
                    com.google.android.gms.ads.internal.ax.D();
                    acd.a(this, onGlobalLayoutListenerD);
                }
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListenerE = this.j.e();
                if (onScrollChangedListenerE != null) {
                    com.google.android.gms.ads.internal.ax.D();
                    acd.a(this, onScrollChangedListenerE);
                }
                this.z = true;
            }
            M();
            z = true;
        }
        g(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!C()) {
                this.K.d();
            }
            super.onDetachedFromWindow();
            if (this.z && this.j != null && this.j.c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerD = this.j.d();
                if (onGlobalLayoutListenerD != null) {
                    com.google.android.gms.ads.internal.ax.g().a(getViewTreeObserver(), onGlobalLayoutListenerD);
                }
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListenerE = this.j.e();
                if (onScrollChangedListenerE != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListenerE);
                }
                this.z = false;
            }
        }
        g(false);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(Context context) {
        this.f1958a.setBaseContext(context);
        this.K.a(this.f1958a.a());
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void c(boolean z) {
        if (this.k != null) {
            this.k.a(this.j.b(), z);
        } else {
            this.o = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized int getRequestedOrientation() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void setRequestedOrientation(int i) {
        this.t = i;
        if (this.k != null) {
            this.k.a(this.t);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agq
    public final Activity d() {
        return this.f1958a.a();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final Context r() {
        return this.f1958a.b();
    }

    private final synchronized void Q() {
        if (!this.q && !this.m.e()) {
            if (Build.VERSION.SDK_INT < 18) {
                xe.b("Disabling hardware acceleration on an AdView.");
                R();
                return;
            } else {
                xe.b("Enabling hardware acceleration on an AdView.");
                S();
                return;
            }
        }
        xe.b("Enabling hardware acceleration on an overlay.");
        S();
    }

    private final synchronized void R() {
        if (!this.r) {
            com.google.android.gms.ads.internal.ax.g().c(this);
        }
        this.r = true;
    }

    private final synchronized void S() {
        if (this.r) {
            com.google.android.gms.ads.internal.ax.g().b((View) this);
        }
        this.r = false;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final synchronized void destroy() {
        V();
        this.K.b();
        if (this.k != null) {
            this.k.a();
            this.k.k();
            this.k = null;
        }
        this.l = null;
        this.j.k();
        if (this.p) {
            return;
        }
        com.google.android.gms.ads.internal.ax.C();
        aew.a(this);
        U();
        this.p = true;
        xe.a("Initiating WebView self destruct sequence in 3...");
        xe.a("Loading blank page in WebView, 2...");
        e("about:blank");
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.p) {
                    this.j.k();
                    com.google.android.gms.ads.internal.ax.C();
                    aew.a(this);
                    U();
                    T();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void D() {
        xe.a("Destroying WebView!");
        T();
        xn.f3583a.post(new agi(this));
    }

    private final synchronized void T() {
        if (!this.J) {
            this.J = true;
            com.google.android.gms.ads.internal.ax.i().i();
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean C() {
        return this.p;
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (C()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        if (this.j == null || this.j.l() == null) {
            return;
        }
        this.j.l().a();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void I() {
        if (this.F == null) {
            this.F = u.a(this.G.a());
            this.G.a("native:view_load", this.F);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final void onPause() {
        if (C()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            xe.b("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final void onResume() {
        if (C()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            xe.b("Could not resume webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void L() {
        xe.a("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void f(boolean z) {
        this.j.b(z);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final void stopLoading() {
        if (C()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            xe.b("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void d(boolean z) {
        this.u = z;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean E() {
        return this.u;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean F() {
        return this.v;
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final synchronized void h_() {
        this.v = true;
        if (this.d != null) {
            this.d.h_();
        }
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final synchronized void i_() {
        this.v = false;
        if (this.d != null) {
            this.d.i_();
        }
    }

    private final synchronized void U() {
        if (this.P != null) {
            Iterator<aex> it = this.P.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
        this.P = null;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final synchronized void a(String str, aex aexVar) {
        if (this.P == null) {
            this.P = new HashMap();
        }
        this.P.put(str, aexVar);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final synchronized aex a(String str) {
        if (this.P == null) {
            return null;
        }
        return this.P.get(str);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void b(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        try {
            this.w = str;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final synchronized String g() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final synchronized void n() {
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final z c() {
        return this.E;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final aa j() {
        return this.G;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.afu
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.H = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final View.OnClickListener getOnClickListener() {
        return this.H.get();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(bd bdVar) {
        this.A = bdVar;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized bd J() {
        return this.A;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final synchronized agj b() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final synchronized void a(agj agjVar) {
        if (this.x != null) {
            xe.c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.x = agjVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean G() {
        return this.B > 0;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void e(boolean z) {
        this.B += z ? 1 : -1;
        if (this.B <= 0 && this.k != null) {
            this.k.q();
        }
    }

    private final void V() {
        ac acVarA;
        if (this.G == null || (acVarA = this.G.a()) == null || com.google.android.gms.ads.internal.ax.i().a() == null) {
            return;
        }
        com.google.android.gms.ads.internal.ax.i().a().a(acVarA);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void K() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void a(boolean z) {
        this.j.a(z);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void f() {
        com.google.android.gms.ads.internal.overlay.d dVarS = s();
        if (dVarS != null) {
            dVarS.p();
        }
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final int l() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final int m() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(com.google.android.gms.ads.internal.overlay.c cVar) {
        this.j.a(cVar);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i) {
        this.j.a(z, i);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i, String str) {
        this.j.a(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i, String str, String str2) {
        this.j.a(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.bmk
    public final void a(bmj bmjVar) {
        synchronized (this) {
            this.y = bmjVar.f2838a;
        }
        g(bmjVar.f2838a);
    }

    private final void g(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", z ? "1" : "0");
        a("onAdVisibilityChanged", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        if (this.j != null) {
            this.j.a(str, acVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        if (this.j != null) {
            this.j.b(str, acVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(String str, com.google.android.gms.common.util.k<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> kVar) {
        if (this.j != null) {
            this.j.a(str, kVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final /* synthetic */ ahb w() {
        return this.j;
    }
}
