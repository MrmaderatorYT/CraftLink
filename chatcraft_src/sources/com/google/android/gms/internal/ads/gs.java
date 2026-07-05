package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class gs extends brt {

    /* renamed from: a, reason: collision with root package name */
    private final String f3111a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3112b;
    private final fi c;
    private com.google.android.gms.ads.internal.m d;
    private final gk e;

    private gs(String str, fi fiVar) {
        this.f3111a = str;
        this.c = fiVar;
        this.e = new gk();
        com.google.android.gms.ads.internal.ax.s().a(fiVar);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(String str) {
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void b(String str) {
    }

    public gs(Context context, String str, kk kkVar, aar aarVar, com.google.android.gms.ads.internal.bt btVar) {
        this(str, new fi(context, kkVar, aarVar, btVar));
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final com.google.android.gms.dynamic.a k() {
        if (this.d != null) {
            return this.d.k();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void j() {
        if (this.d != null) {
            this.d.j();
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean m() {
        return this.d != null && this.d.m();
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean b(bqj bqjVar) {
        if (!gn.a(bqjVar).contains("gw")) {
            c();
        }
        if (gn.a(bqjVar).contains("_skipMediation")) {
            c();
        }
        if (bqjVar.j != null) {
            c();
        }
        if (this.d != null) {
            return this.d.b(bqjVar);
        }
        gn gnVarS = com.google.android.gms.ads.internal.ax.s();
        if (gn.a(bqjVar).contains("_ad")) {
            gnVarS.b(bqjVar, this.f3111a);
        }
        gq gqVarA = gnVarS.a(bqjVar, this.f3111a);
        if (gqVarA != null) {
            if (!gqVarA.e) {
                gqVarA.a();
                gr.a().e();
            } else {
                gr.a().d();
            }
            this.d = gqVarA.f3107a;
            gqVarA.c.a(this.e);
            this.e.a(this.d);
            return gqVarA.f;
        }
        c();
        gr.a().e();
        return this.d.b(bqjVar);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void o() {
        if (this.d != null) {
            this.d.o();
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void p() {
        if (this.d != null) {
            this.d.p();
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brh brhVar) {
        this.e.f3098a = brhVar;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(ue ueVar) {
        this.e.f = ueVar;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsa bsaVar) {
        this.e.c = bsaVar;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brx brxVar) {
        this.e.f3099b = brxVar;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final Bundle q() {
        if (this.d != null) {
            return this.d.q();
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void H() {
        if (this.d != null) {
            this.d.c(this.f3112b);
            this.d.H();
        } else {
            xe.e("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void r() {
        if (this.d != null) {
            this.d.r();
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void n() {
        if (this.d != null) {
            this.d.n();
        } else {
            xe.e("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bqn l() {
        if (this.d != null) {
            return this.d.l();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bqn bqnVar) {
        if (this.d != null) {
            this.d.a(bqnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(nt ntVar) {
        xe.e("setInAppPurchaseListener is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(oa oaVar, String str) {
        xe.e("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String a() {
        if (this.d != null) {
            return this.d.a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String q_() {
        if (this.d != null) {
            return this.d.q_();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(ai aiVar) {
        this.e.d = aiVar;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brd brdVar) {
        this.e.e = brdVar;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsg bsgVar) {
        c();
        if (this.d != null) {
            this.d.a(bsgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void b(boolean z) {
        c();
        if (this.d != null) {
            this.d.b(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean s() {
        return this.d != null && this.d.s();
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bsw t() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String D() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bsa E() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final brh F() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(buc bucVar) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(btc btcVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void c(boolean z) {
        this.f3112b = z;
    }

    private final void c() {
        if (this.d != null) {
            return;
        }
        this.d = this.c.a(this.f3111a);
        this.e.a(this.d);
    }
}
