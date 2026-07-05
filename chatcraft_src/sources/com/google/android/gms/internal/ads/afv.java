package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.bou;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class afv extends WebViewClient implements ahb {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f1941b = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] c = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private boolean A;
    private int B;
    private boolean C;
    private View.OnAttachStateChangeListener D;

    /* renamed from: a, reason: collision with root package name */
    protected vv f1942a;
    private afu d;
    private final bos e;
    private final HashMap<String, List<com.google.android.gms.ads.internal.gmsg.ac<? super afu>>> f;
    private final Object g;
    private bqa h;
    private com.google.android.gms.ads.internal.overlay.n i;
    private ahc j;
    private ahd k;
    private com.google.android.gms.ads.internal.gmsg.j l;
    private com.google.android.gms.ads.internal.gmsg.l m;
    private ahe n;
    private boolean o;

    @GuardedBy("mLock")
    private boolean p;

    @GuardedBy("mLock")
    private boolean q;

    @GuardedBy("mLock")
    private ViewTreeObserver.OnGlobalLayoutListener r;

    @GuardedBy("mLock")
    private ViewTreeObserver.OnScrollChangedListener s;

    @GuardedBy("mLock")
    private boolean t;
    private com.google.android.gms.ads.internal.overlay.t u;
    private final ng v;
    private com.google.android.gms.ads.internal.bu w;
    private mx x;
    private ahf y;
    private boolean z;

    public afv(afu afuVar, bos bosVar, boolean z) {
        this(afuVar, bosVar, z, new ng(afuVar, afuVar.r(), new bue(afuVar.getContext())), null);
    }

    private afv(afu afuVar, bos bosVar, boolean z, ng ngVar, mx mxVar) {
        this.f = new HashMap<>();
        this.g = new Object();
        this.o = false;
        this.e = bosVar;
        this.d = afuVar;
        this.p = z;
        this.v = ngVar;
        this.x = null;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(int i, int i2, boolean z) {
        this.v.a(i, i2);
        if (this.x != null) {
            this.x.a(i, i2, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(bqa bqaVar, com.google.android.gms.ads.internal.gmsg.j jVar, com.google.android.gms.ads.internal.overlay.n nVar, com.google.android.gms.ads.internal.gmsg.l lVar, com.google.android.gms.ads.internal.overlay.t tVar, boolean z, com.google.android.gms.ads.internal.gmsg.ag agVar, com.google.android.gms.ads.internal.bu buVar, ni niVar, vv vvVar) {
        if (buVar == null) {
            buVar = new com.google.android.gms.ads.internal.bu(this.d.getContext(), vvVar, null);
        }
        this.x = new mx(this.d, niVar);
        this.f1942a = vvVar;
        if (((Boolean) bra.e().a(o.as)).booleanValue()) {
            a("/adMetadata", new com.google.android.gms.ads.internal.gmsg.a(jVar));
        }
        a("/appEvent", new com.google.android.gms.ads.internal.gmsg.k(lVar));
        a("/backButton", com.google.android.gms.ads.internal.gmsg.n.j);
        a("/refresh", com.google.android.gms.ads.internal.gmsg.n.k);
        a("/canOpenURLs", com.google.android.gms.ads.internal.gmsg.n.f1602a);
        a("/canOpenIntents", com.google.android.gms.ads.internal.gmsg.n.f1603b);
        a("/click", com.google.android.gms.ads.internal.gmsg.n.c);
        a("/close", com.google.android.gms.ads.internal.gmsg.n.d);
        a("/customClose", com.google.android.gms.ads.internal.gmsg.n.e);
        a("/instrument", com.google.android.gms.ads.internal.gmsg.n.n);
        a("/delayPageLoaded", com.google.android.gms.ads.internal.gmsg.n.p);
        a("/delayPageClosed", com.google.android.gms.ads.internal.gmsg.n.q);
        a("/getLocationInfo", com.google.android.gms.ads.internal.gmsg.n.r);
        a("/httpTrack", com.google.android.gms.ads.internal.gmsg.n.f);
        a("/log", com.google.android.gms.ads.internal.gmsg.n.g);
        a("/mraid", new com.google.android.gms.ads.internal.gmsg.c(buVar, this.x, niVar));
        a("/mraidLoaded", this.v);
        a("/open", new com.google.android.gms.ads.internal.gmsg.d(buVar, this.x));
        a("/precache", new afd());
        a("/touch", com.google.android.gms.ads.internal.gmsg.n.i);
        a("/video", com.google.android.gms.ads.internal.gmsg.n.l);
        a("/videoMeta", com.google.android.gms.ads.internal.gmsg.n.m);
        if (com.google.android.gms.ads.internal.ax.E().a(this.d.getContext())) {
            a("/logScionEvent", new com.google.android.gms.ads.internal.gmsg.b(this.d.getContext()));
        }
        if (agVar != null) {
            a("/setInterstitialProperties", new com.google.android.gms.ads.internal.gmsg.af(agVar));
        }
        this.h = bqaVar;
        this.i = nVar;
        this.l = jVar;
        this.m = lVar;
        this.u = tVar;
        this.w = buVar;
        this.o = z;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final com.google.android.gms.ads.internal.bu a() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final boolean b() {
        boolean z;
        synchronized (this.g) {
            z = this.p;
        }
        return z;
    }

    public final boolean c() {
        boolean z;
        synchronized (this.g) {
            z = this.q;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener d() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.g) {
            onGlobalLayoutListener = this.r;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener e() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.g) {
            onScrollChangedListener = this.s;
        }
        return onScrollChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final boolean f() {
        boolean z;
        synchronized (this.g) {
            z = this.t;
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.g) {
            if (this.d.C()) {
                xe.a("Blank page loaded, 1...");
                this.d.D();
                return;
            }
            this.z = true;
            if (this.k != null) {
                this.k.a();
                this.k = null;
            }
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view, vv vvVar, int i) {
        if (!vvVar.b() || i <= 0) {
            return;
        }
        vvVar.a(view);
        if (vvVar.b()) {
            xn.f3583a.postDelayed(new afx(this, view, vvVar, i), 100L);
        }
    }

    private final void p() {
        if (this.D == null) {
            return;
        }
        this.d.getView().removeOnAttachStateChangeListener(this.D);
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void g() {
        vv vvVar = this.f1942a;
        if (vvVar != null) {
            WebView webView = this.d.getWebView();
            if (androidx.core.g.q.A(webView)) {
                a(webView, vvVar, 10);
                return;
            }
            p();
            this.D = new afy(this, vvVar);
            this.d.getView().addOnAttachStateChangeListener(this.D);
        }
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void h() {
        synchronized (this.g) {
            this.t = true;
        }
        this.B++;
        q();
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void i() {
        this.B--;
        q();
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void j() {
        this.A = true;
        q();
    }

    private final void q() {
        if (this.j != null && ((this.z && this.B <= 0) || this.A)) {
            this.j.a(!this.A);
            this.j = null;
        }
        this.d.I();
    }

    public final void a(com.google.android.gms.ads.internal.overlay.c cVar) {
        boolean zB = this.d.B();
        a(new AdOverlayInfoParcel(cVar, (!zB || this.d.u().e()) ? this.h : null, zB ? null : this.i, this.u, this.d.k()));
    }

    public final void a(boolean z, int i) {
        a(new AdOverlayInfoParcel((!this.d.B() || this.d.u().e()) ? this.h : null, this.i, this.u, this.d, z, i, this.d.k()));
    }

    public final void a(boolean z, int i, String str) {
        boolean zB = this.d.B();
        a(new AdOverlayInfoParcel((!zB || this.d.u().e()) ? this.h : null, zB ? null : new afz(this.d, this.i), this.l, this.m, this.u, this.d, z, i, str, this.d.k()));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean zB = this.d.B();
        a(new AdOverlayInfoParcel((!zB || this.d.u().e()) ? this.h : null, zB ? null : new afz(this.d, this.i), this.l, this.m, this.u, this.d, z, i, str, str2, this.d.k()));
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean zA = this.x != null ? this.x.a() : false;
        com.google.android.gms.ads.internal.ax.c();
        com.google.android.gms.ads.internal.overlay.l.a(this.d.getContext(), adOverlayInfoParcel, zA ? false : true);
        if (this.f1942a != null) {
            String str = adOverlayInfoParcel.l;
            if (str == null && adOverlayInfoParcel.f1622a != null) {
                str = adOverlayInfoParcel.f1622a.f1624a;
            }
            this.f1942a.a(str);
        }
    }

    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        synchronized (this.g) {
            List<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> copyOnWriteArrayList = this.f.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(acVar);
        }
    }

    public final void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        synchronized (this.g) {
            List<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> list = this.f.get(str);
            if (list == null) {
                return;
            }
            list.remove(acVar);
        }
    }

    public final void a(String str, com.google.android.gms.common.util.k<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> kVar) {
        synchronized (this.g) {
            List<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> list = this.f.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar : list) {
                if (kVar.a(acVar)) {
                    arrayList.add(acVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void k() {
        if (this.f1942a != null) {
            this.f1942a.d();
            this.f1942a = null;
        }
        p();
        synchronized (this.g) {
            this.f.clear();
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.o = false;
            this.p = false;
            this.q = false;
            this.t = false;
            this.u = null;
            this.n = null;
            if (this.x != null) {
                this.x.a(true);
                this.x = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahc ahcVar) {
        this.j = ahcVar;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahd ahdVar) {
        this.k = ahdVar;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahe aheVar) {
        this.n = aheVar;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahf ahfVar) {
        this.y = ahfVar;
    }

    public final ahf l() {
        return this.y;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        xe.a(strValueOf.length() != 0 ? "Loading resource: ".concat(strValueOf) : new String("Loading resource: "));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            a(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String strValueOf;
        int i2;
        if (i < 0 && (-i) - 1 < f1941b.length) {
            strValueOf = f1941b[i2];
        } else {
            strValueOf = String.valueOf(i);
        }
        a(this.d.getContext(), "http_err", strValueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String strValueOf;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError >= 0 && primaryError < c.length) {
                strValueOf = c[primaryError];
            } else {
                strValueOf = String.valueOf(primaryError);
            }
            a(this.d.getContext(), "ssl_err", strValueOf, com.google.android.gms.ads.internal.ax.g().a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.d<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.o.aZ
            com.google.android.gms.internal.ads.l r1 = com.google.android.gms.internal.ads.bra.e()
            java.lang.Object r0 = r1.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L13
            return
        L13:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r0 = "err"
            r5.putString(r0, r9)
            java.lang.String r9 = "code"
            r5.putString(r9, r10)
            java.lang.String r9 = "host"
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L39
            android.net.Uri r10 = android.net.Uri.parse(r11)
            java.lang.String r11 = r10.getHost()
            if (r11 == 0) goto L39
            java.lang.String r10 = r10.getHost()
            goto L3b
        L39:
            java.lang.String r10 = ""
        L3b:
            r5.putString(r9, r10)
            com.google.android.gms.internal.ads.xn r1 = com.google.android.gms.ads.internal.ax.e()
            com.google.android.gms.internal.ads.afu r9 = r7.d
            com.google.android.gms.internal.ads.aar r9 = r9.k()
            java.lang.String r3 = r9.f1790a
            java.lang.String r4 = "gmob-apps"
            r6 = 1
            r2 = r8
            r1.a(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.afv.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) throws zzcv {
        String strValueOf = String.valueOf(str);
        xe.a(strValueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(strValueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uriA = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriA.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriA.getHost())) {
            a(uriA);
        } else {
            if (this.o && webView == this.d.getWebView()) {
                String scheme = uriA.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    if (this.h != null) {
                        this.h.e();
                        if (this.f1942a != null) {
                            this.f1942a.a(str);
                        }
                        this.h = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.d.getWebView().willNotDraw()) {
                try {
                    axe axeVarZ = this.d.z();
                    if (axeVarZ != null && axeVarZ.a(uriA)) {
                        uriA = axeVarZ.a(uriA, this.d.getContext(), this.d.getView(), this.d.d());
                    }
                } catch (zzcv unused) {
                    String strValueOf2 = String.valueOf(str);
                    xe.e(strValueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf2) : new String("Unable to append parameter to URL: "));
                }
                if (this.w == null || this.w.b()) {
                    a(new com.google.android.gms.ads.internal.overlay.c("android.intent.action.VIEW", uriA.toString(), null, null, null, null, null));
                } else {
                    this.w.a(str);
                }
            } else {
                String strValueOf3 = String.valueOf(str);
                xe.e(strValueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(strValueOf3) : new String("AdWebView unable to handle URL: "));
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(str, Collections.emptyMap());
    }

    protected final WebResourceResponse a(String str, Map<String, String> map) {
        boa boaVarA;
        try {
            String strA = wd.a(str, this.d.getContext(), this.C);
            if (!strA.equals(str)) {
                return b(strA, map);
            }
            bod bodVarA = bod.a(str);
            if (bodVarA != null && (boaVarA = com.google.android.gms.ads.internal.ax.k().a(bodVarA)) != null && boaVarA.a()) {
                return new WebResourceResponse(BuildConfig.FLAVOR, BuildConfig.FLAVOR, boaVarA.b());
            }
            if (aag.c()) {
                if (((Boolean) bra.e().a(o.aR)).booleanValue()) {
                    return b(str, map);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dd, code lost:
    
        com.google.android.gms.ads.internal.ax.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e4, code lost:
    
        return com.google.android.gms.internal.ads.xn.a(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse b(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.afv.b(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    public final void a(boolean z) {
        this.o = z;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final vv m() {
        return this.f1942a;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.g) {
            this.q = true;
            this.d.H();
            this.r = onGlobalLayoutListener;
            this.s = onScrollChangedListener;
        }
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void n() {
        synchronized (this.g) {
            this.o = false;
            this.p = true;
            abq.f1816a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.afw

                /* renamed from: a, reason: collision with root package name */
                private final afv f1943a;

                {
                    this.f1943a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1943a.o();
                }
            });
        }
    }

    public final void b(boolean z) {
        this.C = z;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(int i, int i2) {
        if (this.x != null) {
            this.x.a(i, i2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private final void a(Uri uri) {
        String path = uri.getPath();
        List<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> list = this.f.get(path);
        if (list != null) {
            com.google.android.gms.ads.internal.ax.e();
            Map<String, String> mapA = xn.a(uri);
            if (xe.a(2)) {
                String strValueOf = String.valueOf(path);
                xe.a(strValueOf.length() != 0 ? "Received GMSG: ".concat(strValueOf) : new String("Received GMSG: "));
                for (String str : mapA.keySet()) {
                    String str2 = mapA.get(str);
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length());
                    sb.append("  ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    xe.a(sb.toString());
                }
            }
            Iterator<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> it = list.iterator();
            while (it.hasNext()) {
                it.next().zza(this.d, mapA);
            }
            return;
        }
        String strValueOf2 = String.valueOf(uri);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 32);
        sb2.append("No GMSG handler found for GMSG: ");
        sb2.append(strValueOf2);
        xe.a(sb2.toString());
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (this.e != null) {
            this.e.a(bou.a.b.ANDROID_WEBVIEW_CRASH);
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) webView.getParent()).removeView(webView);
        }
        webView.destroy();
        return true;
    }

    final /* synthetic */ void o() {
        this.d.H();
        com.google.android.gms.ads.internal.overlay.d dVarS = this.d.s();
        if (dVarS != null) {
            dVarS.m();
        }
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
    }
}
