package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.aga;
import com.google.android.gms.internal.ads.ahb;
import com.google.android.gms.internal.ads.ahe;
import com.google.android.gms.internal.ads.ahh;
import com.google.android.gms.internal.ads.bmg;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.jt;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.rm;
import com.google.android.gms.internal.ads.sw;
import com.google.android.gms.internal.ads.tm;
import com.google.android.gms.internal.ads.vh;
import com.google.android.gms.internal.ads.vv;
import com.google.android.gms.internal.ads.vz;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import com.google.android.gms.internal.ads.xv;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class m extends bf implements com.google.android.gms.ads.internal.gmsg.ag, com.google.android.gms.ads.internal.gmsg.i {
    private transient boolean k;
    private int l;
    private boolean m;
    private float n;
    private boolean o;
    private vz p;
    private String q;
    private final String r;
    private final tm s;

    public m(Context context, bqn bqnVar, String str, kk kkVar, aar aarVar, bt btVar) {
        super(context, bqnVar, str, kkVar, aarVar, btVar);
        this.l = -1;
        boolean z = false;
        this.k = false;
        if (bqnVar != null && "reward_mb".equals(bqnVar.f2974a)) {
            z = true;
        }
        this.r = z ? "/Rewarded" : "/Interstitial";
        this.s = z ? new tm(this.e, this.j, new o(this), this, this) : null;
    }

    private final boolean e(boolean z) {
        return this.s != null && z;
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    public final boolean a(bqj bqjVar, com.google.android.gms.internal.ads.ac acVar) {
        if (this.e.j != null) {
            xe.e("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.p == null && a(bqjVar) && ax.E().a(this.e.c) && !TextUtils.isEmpty(this.e.f1537b)) {
            this.p = new vz(this.e.c, this.e.f1537b);
        }
        return super.a(bqjVar, acVar);
    }

    @Override // com.google.android.gms.ads.internal.bf, com.google.android.gms.ads.internal.a
    public final void a(wl wlVar, com.google.android.gms.internal.ads.ac acVar) {
        if (wlVar.e != -2) {
            super.a(wlVar, acVar);
            return;
        }
        if (e(wlVar.c != null)) {
            this.s.c();
            return;
        }
        if (!((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.aC)).booleanValue()) {
            super.a(wlVar, acVar);
            return;
        }
        boolean z = !wlVar.f3546b.g;
        if (a(wlVar.f3545a.c) && z) {
            this.e.k = b(wlVar);
        }
        super.a(this.e.k, acVar);
    }

    @Override // com.google.android.gms.ads.internal.bf
    protected final afu a(wl wlVar, bu buVar, vv vvVar) {
        ax.f();
        afu afuVarA = aga.a(this.e.c, ahh.a(this.e.i), this.e.i.f2974a, false, false, this.e.d, this.e.e, this.f1496a, this, this.i, wlVar.i);
        afuVarA.w().a(this, this, null, this, this, true, this, buVar, this, vvVar);
        a(afuVarA);
        afuVarA.b(wlVar.f3545a.v);
        afuVarA.a("/reward", new com.google.android.gms.ads.internal.gmsg.h(this));
        return afuVarA;
    }

    @Override // com.google.android.gms.ads.internal.ba
    protected final boolean a(bqj bqjVar, wk wkVar, boolean z) {
        if (this.e.d() && wkVar.f3544b != null) {
            ax.g();
            xv.a(wkVar.f3544b);
        }
        return this.d.e();
    }

    @Override // com.google.android.gms.ads.internal.bf, com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    public final boolean a(wk wkVar, wk wkVar2) {
        if (e(wkVar2.n)) {
            return tm.a(wkVar, wkVar2);
        }
        if (!super.a(wkVar, wkVar2)) {
            return false;
        }
        if (!this.e.d() && this.e.K != null && wkVar2.k != null) {
            this.g.a(this.e.i, wkVar2, this.e.K);
        }
        b(wkVar2, false);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.overlay.n
    public final void g() {
        ahb ahbVarW;
        ac();
        super.g();
        if (this.e.j != null && this.e.j.f3544b != null && (ahbVarW = this.e.j.f3544b.w()) != null) {
            ahbVarW.g();
        }
        if (ax.E().a(this.e.c) && this.e.j != null && this.e.j.f3544b != null) {
            ax.E().c(this.e.j.f3544b.getContext(), this.q);
        }
        if (this.p != null) {
            this.p.a(true);
        }
        if (this.h == null || this.e.j == null || this.e.j.f3544b == null) {
            return;
        }
        this.e.j.f3544b.a("onSdkImpression", new HashMap());
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.overlay.n
    public final void p_() {
        super.p_();
        this.g.a(this.e.j);
        if (this.p != null) {
            this.p.a(false);
        }
        this.h = null;
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final void u() {
        I();
        super.u();
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ag
    public final void a(boolean z) {
        this.e.M = z;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ag
    public final void a(boolean z, float f) {
        this.m = z;
        this.n = f;
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.brs
    public final void H() {
        Bitmap bitmapI;
        String packageName;
        com.google.android.gms.common.internal.i.b("showInterstitial must be called on the main UI thread.");
        if (e(this.e.j != null && this.e.j.n)) {
            this.s.a(this.o);
            return;
        }
        if (ax.E().a(this.e.c)) {
            this.q = ax.E().b(this.e.c);
            String strValueOf = String.valueOf(this.q);
            String strValueOf2 = String.valueOf(this.r);
            this.q = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        }
        if (this.e.j == null) {
            xe.e("The interstitial has not loaded.");
            return;
        }
        if (!this.k) {
            if (!((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.cG)).booleanValue()) {
                return;
            }
        }
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.al)).booleanValue()) {
            ax.e();
            if (xn.h(this.e.c)) {
                xe.e("It is not recommended to show an interstitial when app is not in foreground.");
                return;
            }
        }
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.aY)).booleanValue()) {
            if (this.e.c.getApplicationContext() != null) {
                packageName = this.e.c.getApplicationContext().getPackageName();
            } else {
                packageName = this.e.c.getPackageName();
            }
            if (!this.k) {
                xe.e("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                a(bundle);
            }
            ax.e();
            if (!xn.g(this.e.c)) {
                xe.e("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString("action", "show_interstitial_app_not_in_foreground");
                a(bundle2);
            }
        }
        if (this.e.e()) {
            return;
        }
        if (this.e.j.n && this.e.j.p != null) {
            try {
                this.e.j.p.a(this.o);
                this.e.j.p.b();
                return;
            } catch (RemoteException e) {
                xe.c("Could not show interstitial.", e);
                I();
                return;
            }
        }
        if (this.e.j.f3544b == null) {
            xe.e("The interstitial failed to load.");
            return;
        }
        if (this.e.j.f3544b.B()) {
            xe.e("The interstitial is already showing.");
            return;
        }
        this.e.j.f3544b.b(true);
        this.e.a(this.e.j.f3544b.getView());
        if (this.e.j.k != null) {
            this.g.a(this.e.i, this.e.j);
        }
        if (com.google.android.gms.common.util.j.a()) {
            final wk wkVar = this.e.j;
            if (wkVar.a()) {
                new bmg(this.e.c, wkVar.f3544b.getView()).a(wkVar.f3544b);
            } else {
                wkVar.f3544b.w().a(new ahe(this, wkVar) { // from class: com.google.android.gms.ads.internal.n

                    /* renamed from: a, reason: collision with root package name */
                    private final m f1619a;

                    /* renamed from: b, reason: collision with root package name */
                    private final wk f1620b;

                    {
                        this.f1619a = this;
                        this.f1620b = wkVar;
                    }

                    @Override // com.google.android.gms.internal.ads.ahe
                    public final void a() {
                        m mVar = this.f1619a;
                        wk wkVar2 = this.f1620b;
                        new bmg(mVar.e.c, wkVar2.f3544b.getView()).a(wkVar2.f3544b);
                    }
                });
            }
        }
        if (this.e.M) {
            ax.e();
            bitmapI = xn.i(this.e.c);
        } else {
            bitmapI = null;
        }
        this.l = ax.z().a(bitmapI);
        if (bitmapI != null) {
            new p(this, this.l).h();
            return;
        }
        boolean z = this.e.M;
        ax.e();
        r rVar = new r(z, xn.o(this.e.c), false, 0.0f, -1, this.o, this.e.j.L, this.e.j.O);
        int requestedOrientation = this.e.j.f3544b.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.e.j.h;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.e.j.f3544b, requestedOrientation, this.e.e, this.e.j.A, rVar);
        ax.c();
        com.google.android.gms.ads.internal.overlay.l.a(this.e.c, adOverlayInfoParcel, true);
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void c(boolean z) {
        com.google.android.gms.common.internal.i.b("setImmersiveMode must be called on the main UI thread.");
        this.o = z;
    }

    private final void a(Bundle bundle) {
        ax.e().b(this.e.c, this.e.e.f1790a, "gmob-apps", bundle, false);
    }

    @Override // com.google.android.gms.ads.internal.bf, com.google.android.gms.ads.internal.a
    protected final void x() {
        afu afuVar = this.e.j != null ? this.e.j.f3544b : null;
        wl wlVar = this.e.k;
        if (wlVar != null && wlVar.f3546b != null && wlVar.f3546b.Q && afuVar != null && ax.v().a(this.e.c)) {
            int i = this.e.e.f1791b;
            int i2 = this.e.e.c;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            this.h = ax.v().a(sb.toString(), afuVar.getWebView(), BuildConfig.FLAVOR, "javascript", G());
            if (this.h != null && afuVar.getView() != null) {
                ax.v().a(this.h, afuVar.getView());
                afuVar.a(this.h);
                ax.v().a(this.h);
            }
        }
        super.x();
        this.k = true;
    }

    public final void I() {
        ax.z().b(Integer.valueOf(this.l));
        if (this.e.d()) {
            this.e.b();
            this.e.j = null;
            this.e.M = false;
            this.k = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.i
    public final void d_() {
        if (e(this.e.j != null && this.e.j.n)) {
            this.s.g();
            A();
            return;
        }
        if (this.e.j != null && this.e.j.w != null) {
            ax.e();
            xn.a(this.e.c, this.e.e.f1790a, this.e.j.w);
        }
        A();
    }

    @Override // com.google.android.gms.ads.internal.gmsg.i
    public final void a(vh vhVar) {
        if (e(this.e.j != null && this.e.j.n)) {
            b(this.s.a(vhVar));
            return;
        }
        if (this.e.j != null) {
            if (this.e.j.x != null) {
                ax.e();
                xn.a(this.e.c, this.e.e.f1790a, this.e.j.x);
            }
            if (this.e.j.v != null) {
                vhVar = this.e.j.v;
            }
        }
        b(vhVar);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.i
    public final void e_() {
        if (e(this.e.j != null && this.e.j.n)) {
            this.s.h();
        }
        B();
    }

    private static wl b(wl wlVar) throws JSONException {
        try {
            String string = sw.a(wlVar.f3546b).toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, wlVar.f3545a.e);
            jt jtVar = new jt(string, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject.toString(), null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1L);
            rm rmVar = wlVar.f3546b;
            ju juVar = new ju(Collections.singletonList(jtVar), ((Long) bra.e().a(com.google.android.gms.internal.ads.o.bc)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), rmVar.H, rmVar.I, BuildConfig.FLAVOR, -1L, 0, 1, null, 0, -1, -1L, false);
            return new wl(wlVar.f3545a, new rm(wlVar.f3545a, rmVar.f3427a, rmVar.f3428b, Collections.emptyList(), Collections.emptyList(), rmVar.f, true, rmVar.h, Collections.emptyList(), rmVar.j, rmVar.k, rmVar.l, rmVar.m, rmVar.n, rmVar.o, rmVar.p, null, rmVar.r, rmVar.s, rmVar.t, rmVar.u, rmVar.v, rmVar.x, rmVar.y, rmVar.z, null, Collections.emptyList(), Collections.emptyList(), rmVar.D, rmVar.E, rmVar.F, rmVar.G, rmVar.H, rmVar.I, rmVar.J, null, rmVar.L, rmVar.M, rmVar.N, rmVar.O, 0, rmVar.Q, Collections.emptyList(), rmVar.S, rmVar.T, rmVar.U, rmVar.V), juVar, wlVar.d, wlVar.e, wlVar.f, wlVar.g, null, wlVar.i, null);
        } catch (JSONException e) {
            xe.b("Unable to generate ad state for an interstitial ad with pooling.", e);
            return wlVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.ni
    public final void J() {
        com.google.android.gms.ads.internal.overlay.d dVarS = this.e.j.f3544b.s();
        if (dVarS != null) {
            dVarS.a();
        }
    }
}
