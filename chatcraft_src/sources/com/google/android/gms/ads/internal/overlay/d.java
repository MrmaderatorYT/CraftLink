package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.nh;
import com.google.android.gms.internal.ads.nn;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import com.google.android.gms.internal.ads.xv;
import java.util.Collections;
import org.json.JSONException;

@qj
/* loaded from: classes.dex */
public class d extends nn implements w {
    private static final int e = Color.argb(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    protected final Activity f1626a;

    /* renamed from: b, reason: collision with root package name */
    AdOverlayInfoParcel f1627b;
    afu c;
    private i f;
    private o g;
    private FrameLayout i;
    private WebChromeClient.CustomViewCallback j;
    private h m;
    private Runnable p;
    private boolean q;
    private boolean r;
    private boolean h = false;
    private boolean k = false;
    private boolean l = false;
    private boolean n = false;
    int d = 0;
    private final Object o = new Object();
    private boolean s = false;
    private boolean t = false;
    private boolean u = true;

    public d(Activity activity) {
        this.f1626a = activity;
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void f() {
    }

    public final void a() {
        this.d = 2;
        this.f1626a.finish();
    }

    public final void b() {
        if (this.f1627b != null && this.h) {
            a(this.f1627b.j);
        }
        if (this.i != null) {
            this.f1626a.setContentView(this.m);
            this.r = true;
            this.i.removeAllViews();
            this.i = null;
        }
        if (this.j != null) {
            this.j.onCustomViewHidden();
            this.j = null;
        }
        this.h = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.w
    public final void c() {
        this.d = 1;
        this.f1626a.finish();
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void d() {
        this.d = 0;
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final boolean e() {
        this.d = 0;
        if (this.c == null) {
            return true;
        }
        boolean zE = this.c.E();
        if (!zE) {
            this.c.a("onbackblocked", Collections.emptyMap());
        }
        return zE;
    }

    @Override // com.google.android.gms.internal.ads.nm
    public void a(Bundle bundle) throws JSONException, g {
        this.f1626a.requestWindowFeature(1);
        this.k = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.f1627b = AdOverlayInfoParcel.a(this.f1626a.getIntent());
            if (this.f1627b == null) {
                throw new g("Could not get info for ad overlay.");
            }
            if (this.f1627b.m.c > 7500000) {
                this.d = 3;
            }
            if (this.f1626a.getIntent() != null) {
                this.u = this.f1626a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f1627b.o != null) {
                this.l = this.f1627b.o.f1647a;
            } else {
                this.l = false;
            }
            if (this.l && this.f1627b.o.e != -1) {
                new j(this, null).h();
            }
            if (bundle == null) {
                if (this.f1627b.c != null && this.u) {
                    this.f1627b.c.g();
                }
                if (this.f1627b.k != 1 && this.f1627b.f1623b != null) {
                    this.f1627b.f1623b.e();
                }
            }
            this.m = new h(this.f1626a, this.f1627b.n, this.f1627b.m.f1790a);
            this.m.setId(1000);
            switch (this.f1627b.k) {
                case 1:
                    b(false);
                    return;
                case 2:
                    this.f = new i(this.f1627b.d);
                    b(false);
                    return;
                case 3:
                    b(true);
                    return;
                default:
                    throw new g("Could not determine ad overlay type.");
            }
        } catch (g e2) {
            xe.e(e2.getMessage());
            this.d = 3;
            this.f1626a.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void g() {
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.cr)).booleanValue()) {
            if (this.c != null && !this.c.C()) {
                ax.g();
                xv.b(this.c);
            } else {
                xe.e("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void h() {
        if (this.f1627b.c != null) {
            this.f1627b.c.f();
        }
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.cr)).booleanValue()) {
            return;
        }
        if (this.c != null && !this.c.C()) {
            ax.g();
            xv.b(this.c);
        } else {
            xe.e("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void i() {
        b();
        if (this.f1627b.c != null) {
            this.f1627b.c.d();
        }
        if (!((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.cr)).booleanValue() && this.c != null && (!this.f1626a.isFinishing() || this.f == null)) {
            ax.g();
            xv.a(this.c);
        }
        r();
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(com.google.android.gms.dynamic.a aVar) {
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.cq)).booleanValue() && com.google.android.gms.common.util.j.j()) {
            Configuration configuration = (Configuration) com.google.android.gms.dynamic.b.a(aVar);
            ax.e();
            if (xn.a(this.f1626a, configuration)) {
                this.f1626a.getWindow().addFlags(1024);
                this.f1626a.getWindow().clearFlags(2048);
            } else {
                this.f1626a.getWindow().addFlags(2048);
                this.f1626a.getWindow().clearFlags(1024);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.k);
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void j() {
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.cr)).booleanValue() && this.c != null && (!this.f1626a.isFinishing() || this.f == null)) {
            ax.g();
            xv.a(this.c);
        }
        r();
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void k() {
        if (this.c != null) {
            this.m.removeView(this.c.getView());
        }
        r();
    }

    private final void a(boolean z) throws JSONException {
        int iIntValue = ((Integer) bra.e().a(com.google.android.gms.internal.ads.o.ct)).intValue();
        p pVar = new p();
        pVar.e = 50;
        pVar.f1639a = z ? iIntValue : 0;
        pVar.f1640b = z ? 0 : iIntValue;
        pVar.c = 0;
        pVar.d = iIntValue;
        this.g = new o(this.f1626a, pVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        a(z, this.f1627b.g);
        this.m.addView(this.g, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void l() {
        this.r = true;
    }

    public final void a(boolean z, boolean z2) throws JSONException {
        boolean z3 = true;
        boolean z4 = ((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.aA)).booleanValue() && this.f1627b != null && this.f1627b.o != null && this.f1627b.o.g;
        boolean z5 = ((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.aB)).booleanValue() && this.f1627b != null && this.f1627b.o != null && this.f1627b.o.h;
        if (z && z2 && z4 && !z5) {
            new nh(this.c, "useCustomClose").a("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.g != null) {
            o oVar = this.g;
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            oVar.a(z3);
        }
    }

    public final void m() {
        this.m.removeView(this.g);
        a(true);
    }

    public final void a(int i) {
        if (this.f1626a.getApplicationInfo().targetSdkVersion >= ((Integer) bra.e().a(com.google.android.gms.internal.ads.o.cK)).intValue()) {
            if (this.f1626a.getApplicationInfo().targetSdkVersion <= ((Integer) bra.e().a(com.google.android.gms.internal.ads.o.cL)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) bra.e().a(com.google.android.gms.internal.ads.o.cM)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) bra.e().a(com.google.android.gms.internal.ads.o.cN)).intValue()) {
                        return;
                    }
                }
            }
        }
        this.f1626a.setRequestedOrientation(i);
    }

    public final void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.i = new FrameLayout(this.f1626a);
        this.i.setBackgroundColor(-16777216);
        this.i.addView(view, -1, -1);
        this.f1626a.setContentView(this.i);
        this.r = true;
        this.j = customViewCallback;
        this.h = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(boolean r19) throws org.json.JSONException, com.google.android.gms.ads.internal.overlay.g {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.d.b(boolean):void");
    }

    private final void r() {
        if (!this.f1626a.isFinishing() || this.s) {
            return;
        }
        this.s = true;
        if (this.c != null) {
            this.c.a(this.d);
            synchronized (this.o) {
                if (!this.q && this.c.G()) {
                    this.p = new f(this);
                    xn.f3583a.postDelayed(this.p, ((Long) bra.e().a(com.google.android.gms.internal.ads.o.az)).longValue());
                    return;
                }
            }
        }
        n();
    }

    final void n() {
        if (this.t) {
            return;
        }
        this.t = true;
        if (this.c != null) {
            this.m.removeView(this.c.getView());
            if (this.f != null) {
                this.c.a(this.f.d);
                this.c.b(false);
                this.f.c.addView(this.c.getView(), this.f.f1632a, this.f.f1633b);
                this.f = null;
            } else if (this.f1626a.getApplicationContext() != null) {
                this.c.a(this.f1626a.getApplicationContext());
            }
            this.c = null;
        }
        if (this.f1627b != null && this.f1627b.c != null) {
            this.f1627b.c.p_();
        }
        if (this.f1627b == null || this.f1627b.d == null) {
            return;
        }
        a(this.f1627b.d.A(), this.f1627b.d.getView());
    }

    private static void a(com.google.android.gms.dynamic.a aVar, View view) {
        if (aVar == null || view == null) {
            return;
        }
        ax.v().a(aVar, view);
    }

    public final void o() {
        if (this.n) {
            this.n = false;
            s();
        }
    }

    private final void s() {
        this.c.p();
    }

    public final void p() {
        this.m.f1630a = true;
    }

    public final void q() {
        synchronized (this.o) {
            this.q = true;
            if (this.p != null) {
                xn.f3583a.removeCallbacks(this.p);
                xn.f3583a.post(this.p);
            }
        }
    }
}
