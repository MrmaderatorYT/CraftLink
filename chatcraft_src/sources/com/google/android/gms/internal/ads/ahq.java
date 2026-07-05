package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class ahq extends ahv implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, afu, he {
    private WeakReference<View.OnClickListener> A;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.d B;
    private aab C;
    private final AtomicReference<com.google.android.gms.dynamic.a> D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;
    private Map<String, aex> J;
    private final WindowManager K;

    /* renamed from: a, reason: collision with root package name */
    private final ahg f1990a;

    /* renamed from: b, reason: collision with root package name */
    private final ahi f1991b;
    private final axe c;
    private final aar d;
    private final com.google.android.gms.ads.internal.aq e;
    private final com.google.android.gms.ads.internal.bt f;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.d g;

    @GuardedBy("this")
    private ahh h;

    @GuardedBy("this")
    private String i;

    @GuardedBy("this")
    private boolean j;

    @GuardedBy("this")
    private boolean k;

    @GuardedBy("this")
    private boolean l;

    @GuardedBy("this")
    private int m;

    @GuardedBy("this")
    private boolean n;

    @GuardedBy("this")
    private boolean o;

    @GuardedBy("this")
    private String p;

    @GuardedBy("this")
    private agj q;

    @GuardedBy("this")
    private boolean r;

    @GuardedBy("this")
    private boolean s;

    @GuardedBy("this")
    private bd t;

    @GuardedBy("this")
    private int u;

    @GuardedBy("this")
    private int v;
    private z w;
    private z x;
    private z y;
    private aa z;

    protected ahq(ahg ahgVar, ahi ahiVar, ahh ahhVar, String str, boolean z, boolean z2, axe axeVar, aar aarVar, ac acVar, com.google.android.gms.ads.internal.aq aqVar, com.google.android.gms.ads.internal.bt btVar) {
        super(ahgVar, ahiVar);
        this.n = true;
        this.o = false;
        this.p = BuildConfig.FLAVOR;
        this.D = new AtomicReference<>();
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.f1990a = ahgVar;
        this.f1991b = ahiVar;
        this.h = ahhVar;
        this.i = str;
        this.k = z;
        this.m = -1;
        this.c = axeVar;
        this.d = aarVar;
        this.e = aqVar;
        this.f = btVar;
        this.K = (WindowManager) getContext().getSystemService("window");
        this.C = new aab(this.f1990a.a(), this, this, null);
        com.google.android.gms.ads.internal.ax.e().a(ahgVar, aarVar.f1790a, getSettings());
        setDownloadListener(this);
        this.I = ahgVar.getResources().getDisplayMetrics().density;
        P();
        if (com.google.android.gms.common.util.j.d()) {
            addJavascriptInterface(agm.a(this), "googleAdsJsInterface");
        }
        T();
        this.z = new aa(new ac(true, "make_wv", this.i));
        this.z.a().a(acVar);
        this.x = u.a(this.z.a());
        this.z.a("native:view_create", this.x);
        this.y = null;
        this.w = null;
        com.google.android.gms.ads.internal.ax.g().b(ahgVar);
    }

    @Override // com.google.android.gms.internal.ads.ahv, com.google.android.gms.internal.ads.afu
    public final void D() {
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final adb a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.he
    public final void a(String str, String str2) {
        hf.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, Map map) {
        hf.a(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, JSONObject jSONObject) {
        hf.b(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.hu
    public final void b(String str, JSONObject jSONObject) {
        hf.a(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.aha
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final com.google.android.gms.ads.internal.bt e() {
        return this.f;
    }

    private final boolean N() throws JSONException {
        int iB;
        int iB2;
        if (!this.f1991b.b() && !this.f1991b.c()) {
            return false;
        }
        com.google.android.gms.ads.internal.ax.e();
        DisplayMetrics displayMetricsA = xn.a(this.K);
        bra.a();
        int iB3 = aac.b(displayMetricsA, displayMetricsA.widthPixels);
        bra.a();
        int iB4 = aac.b(displayMetricsA, displayMetricsA.heightPixels);
        Activity activityA = this.f1990a.a();
        if (activityA == null || activityA.getWindow() == null) {
            iB = iB3;
            iB2 = iB4;
        } else {
            com.google.android.gms.ads.internal.ax.e();
            int[] iArrA = xn.a(activityA);
            bra.a();
            iB = aac.b(displayMetricsA, iArrA[0]);
            bra.a();
            iB2 = aac.b(displayMetricsA, iArrA[1]);
        }
        if (this.F == iB3 && this.E == iB4 && this.G == iB && this.H == iB2) {
            return false;
        }
        boolean z = (this.F == iB3 && this.E == iB4) ? false : true;
        this.F = iB3;
        this.E = iB4;
        this.G = iB;
        this.H = iB2;
        new nh(this).a(iB3, iB4, iB, iB2, displayMetricsA.density, this.K.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(String str, String str2, String str3) {
        if (((Boolean) bra.e().a(o.ao)).booleanValue()) {
            str2 = agw.a(str2, agw.a());
        }
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", str3);
    }

    @Override // com.google.android.gms.internal.ads.ahv, com.google.android.gms.internal.ads.ahs, com.google.android.gms.internal.ads.hu
    public final synchronized void d(String str) {
        if (!C()) {
            super.d(str);
        } else {
            xe.e("The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void o() {
        O();
        HashMap map = new HashMap(1);
        map.put("version", this.d.f1790a);
        hf.a(this, "onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(int i) {
        if (i == 0) {
            u.a(this.z.a(), this.x, "aebb2");
        }
        O();
        if (this.z.a() != null) {
            this.z.a().a("close_type", String.valueOf(i));
        }
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.d.f1790a);
        hf.a(this, "onhide", map);
    }

    private final void O() {
        u.a(this.z.a(), this.x, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void p() {
        if (this.w == null) {
            u.a(this.z.a(), this.x, "aes2");
            this.w = u.a(this.z.a());
            this.z.a("native:view_show", this.w);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.d.f1790a);
        hf.a(this, "onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void q() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.ax.j().b()));
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.ax.j().a()));
        map.put("device_volume", String.valueOf(yh.a(getContext())));
        hf.a(this, "volume", map);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void a(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put("success", z ? "1" : "0");
        map.put("duration", Long.toString(j));
        hf.a(this, "onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized com.google.android.gms.ads.internal.overlay.d s() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final com.google.android.gms.dynamic.a A() {
        return this.D.get();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized com.google.android.gms.ads.internal.overlay.d t() {
        return this.B;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agx
    public final synchronized ahh u() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized String v() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final WebViewClient x() {
        return this.f1991b;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean y() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agy
    public final axe z() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agz
    public final aar k() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agr
    public final synchronized boolean B() {
        return this.k;
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

    @Override // com.google.android.gms.internal.ads.ahv, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1991b.c()) {
            synchronized (this) {
                if (this.t != null) {
                    this.t.a(motionEvent);
                }
            }
        } else if (this.c != null) {
            this.c.a(motionEvent);
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

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected final synchronized void onMeasure(int i, int i2) {
        int size;
        if (C()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.k && !this.h.f()) {
            if (this.h.h()) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.h.g()) {
                if (((Boolean) bra.e().a(o.bE)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                agj agjVarB = b();
                float fH = agjVarB != null ? agjVarB.h() : 0.0f;
                if (fH == 0.0f) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size2 = View.MeasureSpec.getSize(i);
                int size3 = View.MeasureSpec.getSize(i2);
                int i3 = (int) (size3 * fH);
                int i4 = (int) (size2 / fH);
                if (size3 == 0 && i4 != 0) {
                    i3 = (int) (i4 * fH);
                    size3 = i4;
                } else if (size2 == 0 && i3 != 0) {
                    i4 = (int) (i3 / fH);
                    size2 = i3;
                }
                setMeasuredDimension(Math.min(i3, size2), Math.min(i4, size3));
                return;
            }
            if (this.h.d()) {
                if (!((Boolean) bra.e().a(o.bJ)).booleanValue() && com.google.android.gms.common.util.j.d()) {
                    a("/contentHeight", new ahr(this));
                    d("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                    int size4 = View.MeasureSpec.getSize(i);
                    if (this.v == -1) {
                        size = View.MeasureSpec.getSize(i2);
                    } else {
                        size = (int) (this.v * this.I);
                    }
                    setMeasuredDimension(size4, size);
                    return;
                }
                super.onMeasure(i, i2);
                return;
            }
            if (this.h.e()) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.K.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size5 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size6 = View.MeasureSpec.getSize(i2);
            int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size5 : Integer.MAX_VALUE;
            int i6 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size6 : Integer.MAX_VALUE;
            boolean z = true;
            boolean z2 = this.h.f1978b > i5 || this.h.f1977a > i6;
            if (((Boolean) bra.e().a(o.cE)).booleanValue()) {
                if (this.h.f1978b / this.I > i5 / this.I || this.h.f1977a / this.I > i6 / this.I) {
                    z = false;
                }
                if (z2) {
                    z2 = z;
                }
            }
            if (z2) {
                int i7 = (int) (this.h.f1978b / this.I);
                int i8 = (int) (this.h.f1977a / this.I);
                int i9 = (int) (size5 / this.I);
                int i10 = (int) (size6 / this.I);
                StringBuilder sb = new StringBuilder(103);
                sb.append("Not enough space to show ad. Needs ");
                sb.append(i7);
                sb.append("x");
                sb.append(i8);
                sb.append(" dp, but only has ");
                sb.append(i9);
                sb.append("x");
                sb.append(i10);
                sb.append(" dp.");
                xe.e(sb.toString());
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
                return;
            }
            if (getVisibility() != 8) {
                setVisibility(0);
            }
            setMeasuredDimension(this.h.f1978b, this.h.f1977a);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() throws JSONException {
        boolean zN = N();
        com.google.android.gms.ads.internal.overlay.d dVarS = s();
        if (dVarS == null || !zN) {
            return;
        }
        dVarS.o();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(com.google.android.gms.ads.internal.overlay.d dVar) {
        this.g = dVar;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(com.google.android.gms.dynamic.a aVar) {
        this.D.set(aVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void b(com.google.android.gms.ads.internal.overlay.d dVar) {
        this.B = dVar;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(ahh ahhVar) {
        this.h = ahhVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void b(boolean z) {
        boolean z2 = z != this.k;
        this.k = z;
        P();
        if (z2) {
            new nh(this).c(z ? "expanded" : "default");
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void H() {
        this.C.a();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!C()) {
            this.C.c();
        }
        boolean z = this.r;
        if (this.f1991b != null && this.f1991b.c()) {
            if (!this.s) {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerD = this.f1991b.d();
                if (onGlobalLayoutListenerD != null) {
                    com.google.android.gms.ads.internal.ax.D();
                    acd.a(this, onGlobalLayoutListenerD);
                }
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListenerE = this.f1991b.e();
                if (onScrollChangedListenerE != null) {
                    com.google.android.gms.ads.internal.ax.D();
                    acd.a(this, onScrollChangedListenerE);
                }
                this.s = true;
            }
            N();
            z = true;
        }
        h(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!C()) {
                this.C.d();
            }
            super.onDetachedFromWindow();
            if (this.s && this.f1991b != null && this.f1991b.c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerD = this.f1991b.d();
                if (onGlobalLayoutListenerD != null) {
                    com.google.android.gms.ads.internal.ax.g().a(getViewTreeObserver(), onGlobalLayoutListenerD);
                }
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListenerE = this.f1991b.e();
                if (onScrollChangedListenerE != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListenerE);
                }
                this.s = false;
            }
        }
        h(false);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(Context context) {
        this.f1990a.setBaseContext(context);
        this.C.a(this.f1990a.a());
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void c(boolean z) {
        if (this.g != null) {
            this.g.a(this.f1991b.b(), z);
        } else {
            this.j = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized int getRequestedOrientation() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void setRequestedOrientation(int i) {
        this.m = i;
        if (this.g != null) {
            this.g.a(this.m);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agq
    public final Activity d() {
        return this.f1990a.a();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final Context r() {
        return this.f1990a.b();
    }

    private final synchronized void P() {
        if (!this.k && !this.h.e()) {
            if (Build.VERSION.SDK_INT < 18) {
                xe.b("Disabling hardware acceleration on an AdView.");
                Q();
                return;
            } else {
                xe.b("Enabling hardware acceleration on an AdView.");
                R();
                return;
            }
        }
        xe.b("Enabling hardware acceleration on an overlay.");
        R();
    }

    private final synchronized void Q() {
        if (!this.l) {
            com.google.android.gms.ads.internal.ax.g().c(this);
        }
        this.l = true;
    }

    private final synchronized void R() {
        if (this.l) {
            com.google.android.gms.ads.internal.ax.g().b((View) this);
        }
        this.l = false;
    }

    @Override // com.google.android.gms.internal.ads.ahv
    protected final synchronized void g(boolean z) {
        if (!z) {
            try {
                T();
                this.C.b();
                if (this.g != null) {
                    this.g.a();
                    this.g.k();
                    this.g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.D.set(null);
        this.f1991b.k();
        com.google.android.gms.ads.internal.ax.C();
        aew.a(this);
        S();
    }

    @Override // com.google.android.gms.internal.ads.ahv, android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        if (this.f1991b == null || this.f1991b.l() == null) {
            return;
        }
        this.f1991b.l().a();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void I() {
        if (this.y == null) {
            this.y = u.a(this.z.a());
            this.z.a("native:view_load", this.y);
        }
    }

    @Override // com.google.android.gms.internal.ads.ahv, android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            xe.b("Could not pause webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ahv, android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final void onResume() {
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
        this.f1991b.b(z);
    }

    @Override // com.google.android.gms.internal.ads.ahv, android.webkit.WebView, com.google.android.gms.internal.ads.afu
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            xe.b("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void d(boolean z) {
        this.n = z;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean E() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean F() {
        return this.o;
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final synchronized void h_() {
        this.o = true;
        if (this.e != null) {
            this.e.h_();
        }
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final synchronized void i_() {
        this.o = false;
        if (this.e != null) {
            this.e.i_();
        }
    }

    private final synchronized void S() {
        if (this.J != null) {
            Iterator<aex> it = this.J.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
        this.J = null;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final synchronized void a(String str, aex aexVar) {
        if (this.J == null) {
            this.J = new HashMap();
        }
        this.J.put(str, aexVar);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final synchronized aex a(String str) {
        if (this.J == null) {
            return null;
        }
        return this.J.get(str);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void b(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        try {
            this.p = str;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final synchronized String g() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final z c() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final aa j() {
        return this.z;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.afu
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.A = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final View.OnClickListener getOnClickListener() {
        return this.A.get();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void a(bd bdVar) {
        this.t = bdVar;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized bd J() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final synchronized void n() {
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final synchronized agj b() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final synchronized void a(agj agjVar) {
        if (this.q != null) {
            xe.c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.q = agjVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized boolean G() {
        return this.u > 0;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final synchronized void e(boolean z) {
        this.u += z ? 1 : -1;
        if (this.u <= 0 && this.g != null) {
            this.g.q();
        }
    }

    private final void T() {
        ac acVarA;
        if (this.z == null || (acVarA = this.z.a()) == null || com.google.android.gms.ads.internal.ax.i().a() == null) {
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
        this.f1991b.a(z);
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
        this.f1991b.a(cVar);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i) {
        this.f1991b.a(z, i);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i, String str) {
        this.f1991b.a(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i, String str, String str2) {
        this.f1991b.a(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.bmk
    public final void a(bmj bmjVar) {
        synchronized (this) {
            this.r = bmjVar.f2838a;
        }
        h(bmjVar.f2838a);
    }

    private final void h(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", z ? "1" : "0");
        hf.a(this, "onAdVisibilityChanged", map);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        if (this.f1991b != null) {
            this.f1991b.a(str, acVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        if (this.f1991b != null) {
            this.f1991b.b(str, acVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(String str, com.google.android.gms.common.util.k<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> kVar) {
        if (this.f1991b != null) {
            this.f1991b.a(str, kVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final /* synthetic */ ahb w() {
        return this.f1991b;
    }
}
