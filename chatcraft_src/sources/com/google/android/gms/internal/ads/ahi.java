package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.io.File;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ahi extends aht implements ahb {
    private View.OnAttachStateChangeListener A;

    /* renamed from: a, reason: collision with root package name */
    private afu f1979a;
    private bqa d;
    private com.google.android.gms.ads.internal.overlay.n e;
    private ahc f;
    private ahd g;
    private com.google.android.gms.ads.internal.gmsg.j h;
    private com.google.android.gms.ads.internal.gmsg.l i;
    private ahe j;
    private volatile boolean l;

    @GuardedBy("mLock")
    private boolean m;

    @GuardedBy("mLock")
    private ViewTreeObserver.OnGlobalLayoutListener n;

    @GuardedBy("mLock")
    private ViewTreeObserver.OnScrollChangedListener o;

    @GuardedBy("mLock")
    private boolean p;
    private com.google.android.gms.ads.internal.overlay.t q;
    private ng r;
    private com.google.android.gms.ads.internal.bu s;
    private mx t;
    private ahf u;
    private vv v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;
    private final Object c = new Object();
    private boolean k = false;

    /* renamed from: b, reason: collision with root package name */
    private final hi<afu> f1980b = new hi<>();

    final void a(afu afuVar, boolean z) {
        ng ngVar = new ng(afuVar, afuVar.r(), new bue(afuVar.getContext()));
        this.f1979a = afuVar;
        this.l = z;
        this.r = ngVar;
        this.t = null;
        this.f1980b.a((hi<afu>) afuVar);
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(int i, int i2, boolean z) {
        this.r.a(i, i2);
        if (this.t != null) {
            this.t.a(i, i2, z);
        }
    }

    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        this.f1980b.a(str, acVar);
    }

    public final void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        this.f1980b.b(str, acVar);
    }

    public final void a(String str, com.google.android.gms.common.util.k<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> kVar) {
        this.f1980b.a(str, kVar);
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(bqa bqaVar, com.google.android.gms.ads.internal.gmsg.j jVar, com.google.android.gms.ads.internal.overlay.n nVar, com.google.android.gms.ads.internal.gmsg.l lVar, com.google.android.gms.ads.internal.overlay.t tVar, boolean z, com.google.android.gms.ads.internal.gmsg.ag agVar, com.google.android.gms.ads.internal.bu buVar, ni niVar, vv vvVar) {
        if (buVar == null) {
            buVar = new com.google.android.gms.ads.internal.bu(this.f1979a.getContext(), vvVar, null);
        }
        this.t = new mx(this.f1979a, niVar);
        this.v = vvVar;
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
        a("/mraid", new com.google.android.gms.ads.internal.gmsg.c(buVar, this.t, niVar));
        a("/mraidLoaded", this.r);
        a("/open", new com.google.android.gms.ads.internal.gmsg.d(buVar, this.t));
        a("/precache", new afd());
        a("/touch", com.google.android.gms.ads.internal.gmsg.n.i);
        a("/video", com.google.android.gms.ads.internal.gmsg.n.l);
        a("/videoMeta", com.google.android.gms.ads.internal.gmsg.n.m);
        if (com.google.android.gms.ads.internal.ax.E().a(this.f1979a.getContext())) {
            a("/logScionEvent", new com.google.android.gms.ads.internal.gmsg.b(this.f1979a.getContext()));
        }
        if (agVar != null) {
            a("/setInterstitialProperties", new com.google.android.gms.ads.internal.gmsg.af(agVar));
        }
        this.d = bqaVar;
        this.e = nVar;
        this.h = jVar;
        this.i = lVar;
        this.q = tVar;
        this.s = buVar;
        this.k = z;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final com.google.android.gms.ads.internal.bu a() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final boolean b() {
        return this.l;
    }

    public final boolean c() {
        boolean z;
        synchronized (this.c) {
            z = this.m;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener d() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.c) {
            onGlobalLayoutListener = this.n;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener e() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.c) {
            onScrollChangedListener = this.o;
        }
        return onScrollChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final boolean f() {
        boolean z;
        synchronized (this.c) {
            z = this.p;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.aht
    public final void a(ahu ahuVar) {
        this.w = true;
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view, vv vvVar, int i) {
        if (!vvVar.b() || i <= 0) {
            return;
        }
        vvVar.a(view);
        if (vvVar.b()) {
            xn.f3583a.postDelayed(new ahk(this, view, vvVar, i), 100L);
        }
    }

    private final void p() {
        if (this.A == null) {
            return;
        }
        this.f1979a.getView().removeOnAttachStateChangeListener(this.A);
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void g() {
        vv vvVar = this.v;
        if (vvVar != null) {
            WebView webView = this.f1979a.getWebView();
            if (androidx.core.g.q.A(webView)) {
                a(webView, vvVar, 10);
                return;
            }
            p();
            this.A = new ahl(this, vvVar);
            this.f1979a.getView().addOnAttachStateChangeListener(this.A);
        }
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void h() {
        synchronized (this.c) {
            this.p = true;
        }
        this.y++;
        q();
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void i() {
        this.y--;
        q();
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void j() {
        this.x = true;
        q();
    }

    private final void q() {
        if (this.f != null && ((this.w && this.y <= 0) || this.x)) {
            this.f.a(!this.x);
            this.f = null;
        }
        this.f1979a.I();
    }

    public final void a(com.google.android.gms.ads.internal.overlay.c cVar) {
        boolean zB = this.f1979a.B();
        a(new AdOverlayInfoParcel(cVar, (!zB || this.f1979a.u().e()) ? this.d : null, zB ? null : this.e, this.q, this.f1979a.k()));
    }

    public final void a(boolean z, int i) {
        a(new AdOverlayInfoParcel((!this.f1979a.B() || this.f1979a.u().e()) ? this.d : null, this.e, this.q, this.f1979a, z, i, this.f1979a.k()));
    }

    public final void a(boolean z, int i, String str) {
        boolean zB = this.f1979a.B();
        a(new AdOverlayInfoParcel((!zB || this.f1979a.u().e()) ? this.d : null, zB ? null : new ahm(this.f1979a, this.e), this.h, this.i, this.q, this.f1979a, z, i, str, this.f1979a.k()));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean zB = this.f1979a.B();
        a(new AdOverlayInfoParcel((!zB || this.f1979a.u().e()) ? this.d : null, zB ? null : new ahm(this.f1979a, this.e), this.h, this.i, this.q, this.f1979a, z, i, str, str2, this.f1979a.k()));
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean zA = this.t != null ? this.t.a() : false;
        com.google.android.gms.ads.internal.ax.c();
        com.google.android.gms.ads.internal.overlay.l.a(this.f1979a.getContext(), adOverlayInfoParcel, zA ? false : true);
        if (this.v != null) {
            String str = adOverlayInfoParcel.l;
            if (str == null && adOverlayInfoParcel.f1622a != null) {
                str = adOverlayInfoParcel.f1622a.f1624a;
            }
            this.v.a(str);
        }
    }

    public final void k() {
        if (this.v != null) {
            this.v.d();
            this.v = null;
        }
        p();
        this.f1980b.d();
        this.f1980b.a((hi<afu>) null);
        synchronized (this.c) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.q = null;
            this.j = null;
            if (this.t != null) {
                this.t.a(true);
                this.t = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahc ahcVar) {
        this.f = ahcVar;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahd ahdVar) {
        this.g = ahdVar;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahe aheVar) {
        this.j = aheVar;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ahf ahfVar) {
        this.u = ahfVar;
    }

    public final ahf l() {
        return this.u;
    }

    @Override // com.google.android.gms.internal.ads.aht
    public final void b(ahu ahuVar) {
        this.f1980b.a(ahuVar.f1996b);
    }

    @Override // com.google.android.gms.internal.ads.aht
    public final boolean c(ahu ahuVar) throws zzcv {
        String strValueOf = String.valueOf(ahuVar.f1995a);
        xe.a(strValueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(strValueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uriA = ahuVar.f1996b;
        if (this.f1980b.a(uriA)) {
            return true;
        }
        if (this.k) {
            String scheme = uriA.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                if (this.d != null) {
                    this.d.e();
                    if (this.v != null) {
                        this.v.a(ahuVar.f1995a);
                    }
                    this.d = null;
                }
                return false;
            }
        }
        if (!this.f1979a.getWebView().willNotDraw()) {
            try {
                axe axeVarZ = this.f1979a.z();
                if (axeVarZ != null && axeVarZ.a(uriA)) {
                    uriA = axeVarZ.a(uriA, this.f1979a.getContext(), this.f1979a.getView(), this.f1979a.d());
                }
            } catch (zzcv unused) {
                String strValueOf2 = String.valueOf(ahuVar.f1995a);
                xe.e(strValueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf2) : new String("Unable to append parameter to URL: "));
            }
            if (this.s == null || this.s.b()) {
                a(new com.google.android.gms.ads.internal.overlay.c("android.intent.action.VIEW", uriA.toString(), null, null, null, null, null));
            } else {
                this.s.a(ahuVar.f1995a);
            }
        } else {
            String strValueOf3 = String.valueOf(ahuVar.f1995a);
            xe.e(strValueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(strValueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.aht
    public final WebResourceResponse d(ahu ahuVar) {
        String str;
        WebResourceResponse webResourceResponseC;
        boa boaVarA;
        if (this.v != null) {
            this.v.a(ahuVar.f1995a, ahuVar.c, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(ahuVar.f1995a).getName())) {
            n();
            if (this.f1979a.u().e()) {
                str = (String) bra.e().a(o.H);
            } else if (this.f1979a.B()) {
                str = (String) bra.e().a(o.G);
            } else {
                str = (String) bra.e().a(o.F);
            }
            com.google.android.gms.ads.internal.ax.e();
            webResourceResponseC = xn.c(this.f1979a.getContext(), this.f1979a.k().f1790a, str);
        } else {
            webResourceResponseC = null;
        }
        if (webResourceResponseC != null) {
            return webResourceResponseC;
        }
        try {
            if (!wd.a(ahuVar.f1995a, this.f1979a.getContext(), this.z).equals(ahuVar.f1995a)) {
                return e(ahuVar);
            }
            bod bodVarA = bod.a(ahuVar.f1995a);
            if (bodVarA != null && (boaVarA = com.google.android.gms.ads.internal.ax.k().a(bodVarA)) != null && boaVarA.a()) {
                return new WebResourceResponse(BuildConfig.FLAVOR, BuildConfig.FLAVOR, boaVarA.b());
            }
            if (aag.c()) {
                if (((Boolean) bra.e().a(o.aR)).booleanValue()) {
                    return e(ahuVar);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e1, code lost:
    
        com.google.android.gms.ads.internal.ax.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e8, code lost:
    
        return com.google.android.gms.internal.ads.xn.a(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse e(com.google.android.gms.internal.ads.ahu r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahi.e(com.google.android.gms.internal.ads.ahu):android.webkit.WebResourceResponse");
    }

    public final void a(boolean z) {
        this.k = z;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final vv m() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.c) {
            this.m = true;
            this.f1979a.H();
            this.n = onGlobalLayoutListener;
            this.o = onScrollChangedListener;
        }
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void n() {
        synchronized (this.c) {
            this.k = false;
            this.l = true;
            abq.f1816a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ahj

                /* renamed from: a, reason: collision with root package name */
                private final ahi f1981a;

                {
                    this.f1981a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1981a.o();
                }
            });
        }
    }

    public final void b(boolean z) {
        this.z = z;
    }

    @Override // com.google.android.gms.internal.ads.ahb
    public final void a(int i, int i2) {
        if (this.t != null) {
            this.t.a(i, i2);
        }
    }

    final /* synthetic */ void o() {
        this.f1979a.H();
        com.google.android.gms.ads.internal.overlay.d dVarS = this.f1979a.s();
        if (dVarS != null) {
            dVarS.m();
        }
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
    }
}
