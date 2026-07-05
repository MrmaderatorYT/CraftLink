package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.ahf;
import com.google.android.gms.internal.ads.ahh;
import com.google.android.gms.internal.ads.bmg;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.bsw;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.kw;
import com.google.android.gms.internal.ads.kz;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.vv;
import com.google.android.gms.internal.ads.vz;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bv extends bf implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean k;
    private boolean l;
    private WeakReference<Object> m;

    public bv(Context context, bqn bqnVar, String str, kk kkVar, aar aarVar, bt btVar) {
        super(context, bqnVar, str, kkVar, aarVar, btVar);
        this.m = new WeakReference<>(null);
    }

    @Override // com.google.android.gms.ads.internal.bf
    protected final afu a(wl wlVar, bu buVar, vv vvVar) {
        com.google.android.gms.ads.d dVarB;
        bqn bqnVar;
        if (this.e.i.g == null && this.e.i.i) {
            ay ayVar = this.e;
            if (wlVar.f3546b.y) {
                bqnVar = this.e.i;
            } else {
                String str = wlVar.f3546b.l;
                if (str != null) {
                    String[] strArrSplit = str.split("[xX]");
                    strArrSplit[0] = strArrSplit[0].trim();
                    strArrSplit[1] = strArrSplit[1].trim();
                    dVarB = new com.google.android.gms.ads.d(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
                } else {
                    dVarB = this.e.i.b();
                }
                bqnVar = new bqn(this.e.c, dVarB);
            }
            ayVar.i = bqnVar;
        }
        return super.a(wlVar, buVar, vvVar);
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final boolean b(bqj bqjVar) {
        bqj bqjVar2 = bqjVar;
        this.l = false;
        this.h = null;
        if (bqjVar2.h != this.k) {
            bqjVar2 = new bqj(bqjVar2.f2969a, bqjVar2.f2970b, bqjVar2.c, bqjVar2.d, bqjVar2.e, bqjVar2.f, bqjVar2.g, bqjVar2.h || this.k, bqjVar2.i, bqjVar2.j, bqjVar2.k, bqjVar2.l, bqjVar2.m, bqjVar2.n, bqjVar2.o, bqjVar2.p, bqjVar2.q, bqjVar2.r, null, bqjVar2.t, bqjVar2.u);
        }
        return super.b(bqjVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    @Override // com.google.android.gms.ads.internal.bf, com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.google.android.gms.internal.ads.wk r5, final com.google.android.gms.internal.ads.wk r6) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bv.a(com.google.android.gms.internal.ads.wk, com.google.android.gms.internal.ads.wk):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean b(wk wkVar, wk wkVar2) {
        if (wkVar2.n) {
            View viewA = t.a(wkVar2);
            if (viewA == null) {
                xe.e("Could not get mediation view");
                return false;
            }
            View nextView = this.e.f.getNextView();
            if (nextView != 0) {
                if (nextView instanceof afu) {
                    ((afu) nextView).destroy();
                }
                this.e.f.removeView(nextView);
            }
            if (!t.b(wkVar2)) {
                try {
                    if (ax.E().a(this.e.c)) {
                        new bmg(this.e.c, viewA).a(new vz(this.e.c, this.e.f1537b));
                    }
                    if (wkVar2.u != null) {
                        this.e.f.setMinimumWidth(wkVar2.u.f);
                        this.e.f.setMinimumHeight(wkVar2.u.c);
                    }
                    a(viewA);
                } catch (Exception e) {
                    ax.i().a(e, "BannerAdManager.swapViews");
                    xe.c("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (wkVar2.u != null && wkVar2.f3544b != null) {
            wkVar2.f3544b.a(ahh.a(wkVar2.u));
            this.e.f.removeAllViews();
            this.e.f.setMinimumWidth(wkVar2.u.f);
            this.e.f.setMinimumHeight(wkVar2.u.c);
            a(wkVar2.f3544b.getView());
        }
        if (this.e.f.getChildCount() > 1) {
            this.e.f.showNext();
        }
        if (wkVar != null) {
            View nextView2 = this.e.f.getNextView();
            if (nextView2 instanceof afu) {
                ((afu) nextView2).destroy();
            } else if (nextView2 != 0) {
                this.e.f.removeView(nextView2);
            }
            this.e.c();
        }
        this.e.f.setVisibility(0);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.bf, com.google.android.gms.ads.internal.a
    protected final void x() {
        afu afuVar = this.e.j != null ? this.e.j.f3544b : null;
        if (!this.l && afuVar != null) {
            c(afuVar);
        }
        super.x();
    }

    private final void c(afu afuVar) {
        WebView webView;
        View view;
        if (K() && (webView = afuVar.getWebView()) != null && (view = afuVar.getView()) != null && ax.v().a(this.e.c)) {
            int i = this.e.e.f1791b;
            int i2 = this.e.e.c;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            this.h = ax.v().a(sb.toString(), webView, BuildConfig.FLAVOR, "javascript", G());
            if (this.h != null) {
                ax.v().a(this.h, view);
                afuVar.a(this.h);
                ax.v().a(this.h);
                this.l = true;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.ba
    protected final boolean X() {
        boolean z;
        ax.e();
        if (xn.a(this.e.c, "android.permission.INTERNET")) {
            z = true;
        } else {
            bra.a().a(this.e.f, this.e.i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        ax.e();
        if (!xn.a(this.e.c)) {
            bra.a().a(this.e.f, this.e.i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.e.f != null) {
            this.e.f.setVisibility(0);
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void b(boolean z) {
        com.google.android.gms.common.internal.i.b("setManualImpressionsEnabled must be called from the main thread.");
        this.k = z;
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.brs
    public final void H() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        d(this.e.j);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        d(this.e.j);
    }

    @Override // com.google.android.gms.ads.internal.ba
    protected final void a(wk wkVar, boolean z) {
        if (K()) {
            afu afuVar = wkVar != null ? wkVar.f3544b : null;
            if (afuVar != null) {
                if (!this.l) {
                    c(afuVar);
                }
                if (this.h != null) {
                    afuVar.a("onSdkImpression", new androidx.b.a());
                }
            }
        }
        super.a(wkVar, z);
        if (t.b(wkVar)) {
            c cVar = new c(this);
            if (wkVar == null || !t.b(wkVar)) {
                return;
            }
            afu afuVar2 = wkVar.f3544b;
            View view = afuVar2 != null ? afuVar2.getView() : null;
            if (view == null) {
                xe.e("AdWebView is null");
                return;
            }
            try {
                List<String> list = wkVar.o != null ? wkVar.o.r : null;
                if (list != null && !list.isEmpty()) {
                    kw kwVarH = wkVar.p != null ? wkVar.p.h() : null;
                    kz kzVarI = wkVar.p != null ? wkVar.p.i() : null;
                    if (list.contains("2") && kwVarH != null) {
                        kwVarH.b(com.google.android.gms.dynamic.b.a(view));
                        if (!kwVarH.j()) {
                            kwVarH.i();
                        }
                        afuVar2.a("/nativeExpressViewClicked", t.a(kwVarH, (kz) null, cVar));
                        return;
                    }
                    if (list.contains("1") && kzVarI != null) {
                        kzVarI.b(com.google.android.gms.dynamic.b.a(view));
                        if (!kzVarI.h()) {
                            kzVarI.g();
                        }
                        afuVar2.a("/nativeExpressViewClicked", t.a((kw) null, kzVarI, cVar));
                        return;
                    }
                    xe.e("No matching template id and mapper");
                    return;
                }
                xe.e("No template ids present in mediation response");
            } catch (RemoteException e) {
                xe.c("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    final void d(wk wkVar) {
        if (wkVar == null || wkVar.m || this.e.f == null || !ax.e().a(this.e.f, this.e.c) || !this.e.f.getGlobalVisibleRect(new Rect(), null)) {
            return;
        }
        if (wkVar != null && wkVar.f3544b != null && wkVar.f3544b.w() != null) {
            wkVar.f3544b.w().a((ahf) null);
        }
        a(wkVar, false);
        wkVar.m = true;
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final bsw t() {
        com.google.android.gms.common.internal.i.b("getVideoController must be called from the main thread.");
        if (this.e.j == null || this.e.j.f3544b == null) {
            return null;
        }
        return this.e.j.f3544b.b();
    }

    @Override // com.google.android.gms.internal.ads.ni
    public final void J() {
        this.d.d();
    }
}
