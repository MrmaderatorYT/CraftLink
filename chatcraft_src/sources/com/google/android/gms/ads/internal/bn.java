package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bsw;
import com.google.android.gms.internal.ads.cz;
import com.google.android.gms.internal.ads.dj;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.kw;
import com.google.android.gms.internal.ads.kz;
import com.google.android.gms.internal.ads.lc;
import com.google.android.gms.internal.ads.oi;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bn extends ba implements com.google.android.gms.internal.ads.bg {
    private boolean k;
    private wk l;
    private boolean m;

    public bn(Context context, bt btVar, bqn bqnVar, String str, kk kkVar, aar aarVar) {
        super(context, bqnVar, str, kkVar, aarVar, btVar);
        this.m = false;
    }

    @Override // com.google.android.gms.ads.internal.ba
    protected final boolean a(bqj bqjVar, wk wkVar, boolean z) {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final bsw t() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final boolean b(bqj bqjVar) {
        bqj bqjVar2 = bqjVar;
        if (this.e.C != null && this.e.C.size() == 1 && this.e.C.get(0).intValue() == 2) {
            xe.c("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            a(0);
            return false;
        }
        if (this.e.B != null) {
            if (bqjVar2.h != this.k) {
                bqjVar2 = new bqj(bqjVar2.f2969a, bqjVar2.f2970b, bqjVar2.c, bqjVar2.d, bqjVar2.e, bqjVar2.f, bqjVar2.g, bqjVar2.h || this.k, bqjVar2.i, bqjVar2.j, bqjVar2.k, bqjVar2.l, bqjVar2.m, bqjVar2.n, bqjVar2.o, bqjVar2.p, bqjVar2.q, bqjVar2.r, null, bqjVar2.t, bqjVar2.u);
            }
            return super.b(bqjVar2);
        }
        return super.b(bqjVar);
    }

    @Override // com.google.android.gms.ads.internal.a
    public final void a(wl wlVar, com.google.android.gms.internal.ads.ac acVar) {
        this.l = null;
        if (wlVar.e != -2) {
            this.l = a(wlVar, wlVar.e);
        } else if (!wlVar.f3546b.g) {
            xe.e("partialAdState is not mediation");
            this.l = a(wlVar, 0);
        }
        if (this.l != null) {
            xn.f3583a.post(new Runnable(this) { // from class: com.google.android.gms.ads.internal.bo

                /* renamed from: a, reason: collision with root package name */
                private final bn f1556a;

                {
                    this.f1556a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1556a.I();
                }
            });
            return;
        }
        if (wlVar.d != null) {
            this.e.i = wlVar.d;
        }
        this.e.L = 0;
        ay ayVar = this.e;
        ax.d();
        ayVar.h = oi.a(this.e.c, this, wlVar, this.e.d, null, this.j, this, acVar);
    }

    private static wk a(wl wlVar, int i) {
        return new wk(wlVar.f3545a.c, null, wlVar.f3546b.c, i, wlVar.f3546b.e, wlVar.f3546b.i, wlVar.f3546b.k, wlVar.f3546b.j, wlVar.f3545a.i, wlVar.f3546b.g, null, null, null, wlVar.c, null, wlVar.f3546b.h, wlVar.d, wlVar.f3546b.f, wlVar.f, wlVar.g, wlVar.f3546b.n, wlVar.h, null, wlVar.f3546b.A, wlVar.f3546b.B, wlVar.f3546b.B, wlVar.f3546b.D, wlVar.f3546b.E, null, wlVar.f3546b.H, wlVar.f3546b.L, wlVar.i, wlVar.f3546b.O, wlVar.j, wlVar.f3546b.Q, wlVar.f3546b.R, wlVar.f3546b.S, wlVar.f3546b.T, wlVar.f3546b.V);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final boolean a(com.google.android.gms.internal.ads.wk r5, com.google.android.gms.internal.ads.wk r6) {
        /*
            r4 = this;
            com.google.android.gms.ads.internal.ay r0 = r4.e
            boolean r0 = r0.d()
            if (r0 == 0) goto L9c
            boolean r0 = r6.n
            r1 = 0
            if (r0 != 0) goto L16
            r4.a(r1)
            java.lang.String r5 = "newState is not mediation."
            com.google.android.gms.internal.ads.xe.e(r5)
            return r1
        L16:
            com.google.android.gms.internal.ads.jt r0 = r6.o
            r2 = 1
            if (r0 == 0) goto L6a
            com.google.android.gms.internal.ads.jt r0 = r6.o
            boolean r0 = r0.a()
            if (r0 == 0) goto L6a
            com.google.android.gms.ads.internal.ay r0 = r4.e
            boolean r0 = r0.d()
            if (r0 == 0) goto L3e
            com.google.android.gms.ads.internal.ay r0 = r4.e
            com.google.android.gms.ads.internal.az r0 = r0.f
            if (r0 == 0) goto L3e
            com.google.android.gms.ads.internal.ay r0 = r4.e
            com.google.android.gms.ads.internal.az r0 = r0.f
            com.google.android.gms.internal.ads.yj r0 = r0.a()
            java.lang.String r3 = r6.A
            r0.c(r3)
        L3e:
            boolean r0 = super.a(r5, r6)
            if (r0 != 0) goto L46
        L44:
            r5 = 0
            goto L64
        L46:
            com.google.android.gms.ads.internal.ay r0 = r4.e
            boolean r0 = r0.d()
            if (r0 == 0) goto L58
            boolean r5 = r4.c(r5, r6)
            if (r5 != 0) goto L58
            r4.a(r1)
            goto L44
        L58:
            com.google.android.gms.ads.internal.ay r5 = r4.e
            boolean r5 = r5.e()
            if (r5 != 0) goto L63
            super.a(r6, r1)
        L63:
            r5 = 1
        L64:
            if (r5 != 0) goto L67
            return r1
        L67:
            r4.m = r2
            goto L7d
        L6a:
            com.google.android.gms.internal.ads.jt r0 = r6.o
            if (r0 == 0) goto L93
            com.google.android.gms.internal.ads.jt r0 = r6.o
            boolean r0 = r0.b()
            if (r0 == 0) goto L93
            boolean r5 = r4.b(r5, r6)
            if (r5 != 0) goto L7d
            return r1
        L7d:
            java.util.ArrayList r5 = new java.util.ArrayList
            java.lang.Integer[] r6 = new java.lang.Integer[r2]
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r1] = r0
            java.util.List r6 = java.util.Arrays.asList(r6)
            r5.<init>(r6)
            r4.c(r5)
            return r2
        L93:
            r4.a(r1)
            java.lang.String r5 = "Response is neither banner nor native."
            com.google.android.gms.internal.ads.xe.e(r5)
            return r1
        L9c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "AdLoader API does not support custom rendering."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bn.a(com.google.android.gms.internal.ads.wk, com.google.android.gms.internal.ads.wk):boolean");
    }

    private final boolean b(wk wkVar, wk wkVar2) {
        b((List<String>) null);
        if (!this.e.d()) {
            xe.e("Native ad does not have custom rendering mode.");
            a(0);
            return false;
        }
        try {
            lc lcVarP = wkVar2.p != null ? wkVar2.p.p() : null;
            kw kwVarH = wkVar2.p != null ? wkVar2.p.h() : null;
            kz kzVarI = wkVar2.p != null ? wkVar2.p.i() : null;
            cz czVarN = wkVar2.p != null ? wkVar2.p.n() : null;
            String strC = c(wkVar2);
            if (lcVarP != null && this.e.t != null) {
                com.google.android.gms.internal.ads.bb bbVar = new com.google.android.gms.internal.ads.bb(lcVarP.a(), lcVarP.b(), lcVarP.c(), lcVarP.d() != null ? lcVarP.d() : null, lcVarP.e(), lcVarP.f(), lcVarP.g(), lcVarP.h(), lcVarP.i(), null, lcVarP.j(), lcVarP.m() != null ? (View) com.google.android.gms.dynamic.b.a(lcVarP.m()) : null, lcVarP.n(), strC, lcVarP.o());
                bbVar.a(new com.google.android.gms.internal.ads.be(this.e.c, this, this.e.d, lcVarP, bbVar));
                a(bbVar);
            } else if (kwVarH != null && this.e.t != null) {
                com.google.android.gms.internal.ads.bb bbVar2 = new com.google.android.gms.internal.ads.bb(kwVarH.a(), kwVarH.b(), kwVarH.c(), kwVarH.d() != null ? kwVarH.d() : null, kwVarH.e(), null, kwVarH.f(), kwVarH.g(), kwVarH.h(), null, kwVarH.m(), kwVarH.p() != null ? (View) com.google.android.gms.dynamic.b.a(kwVarH.p()) : null, kwVarH.q(), strC, kwVarH.l());
                bbVar2.a(new com.google.android.gms.internal.ads.be(this.e.c, this, this.e.d, kwVarH, bbVar2));
                a(bbVar2);
            } else if (kwVarH != null && this.e.r != null) {
                com.google.android.gms.internal.ads.au auVar = new com.google.android.gms.internal.ads.au(kwVarH.a(), kwVarH.b(), kwVarH.c(), kwVarH.d() != null ? kwVarH.d() : null, kwVarH.e(), kwVarH.f(), kwVarH.g(), kwVarH.h(), null, kwVarH.l(), kwVarH.m(), kwVarH.p() != null ? (View) com.google.android.gms.dynamic.b.a(kwVarH.p()) : null, kwVarH.q(), strC);
                auVar.a(new com.google.android.gms.internal.ads.be(this.e.c, this, this.e.d, kwVarH, auVar));
                xn.f3583a.post(new bq(this, auVar));
            } else if (kzVarI != null && this.e.t != null) {
                com.google.android.gms.internal.ads.bb bbVar3 = new com.google.android.gms.internal.ads.bb(kzVarI.a(), kzVarI.b(), kzVarI.c(), kzVarI.d() != null ? kzVarI.d() : null, kzVarI.e(), kzVarI.f(), -1.0d, null, null, null, kzVarI.l(), kzVarI.n() != null ? (View) com.google.android.gms.dynamic.b.a(kzVarI.n()) : null, kzVarI.o(), strC, kzVarI.j());
                bbVar3.a(new com.google.android.gms.internal.ads.be(this.e.c, this, this.e.d, kzVarI, bbVar3));
                a(bbVar3);
            } else if (kzVarI != null && this.e.s != null) {
                com.google.android.gms.internal.ads.aw awVar = new com.google.android.gms.internal.ads.aw(kzVarI.a(), kzVarI.b(), kzVarI.c(), kzVarI.d() != null ? kzVarI.d() : null, kzVarI.e(), kzVarI.f(), null, kzVarI.j(), kzVarI.l(), kzVarI.n() != null ? (View) com.google.android.gms.dynamic.b.a(kzVarI.n()) : null, kzVarI.o(), strC);
                awVar.a(new com.google.android.gms.internal.ads.be(this.e.c, this, this.e.d, kzVarI, awVar));
                xn.f3583a.post(new br(this, awVar));
            } else if (czVarN != null && this.e.w != null && this.e.w.get(czVarN.b()) != null) {
                xn.f3583a.post(new bs(this, czVarN));
            } else {
                xe.e("No matching mapper/listener for retrieved native ad template.");
                a(0);
                return false;
            }
            return super.a(wkVar, wkVar2);
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
            a(0);
            return false;
        }
    }

    protected final void a(com.google.android.gms.dynamic.a aVar) {
        Object objA = aVar != null ? com.google.android.gms.dynamic.b.a(aVar) : null;
        if (objA instanceof com.google.android.gms.internal.ads.bf) {
            ((com.google.android.gms.internal.ads.bf) objA).e();
        }
        super.b(this.e.j, false);
    }

    private final void a(com.google.android.gms.internal.ads.bb bbVar) {
        xn.f3583a.post(new bp(this, bbVar));
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void b(View view) {
        aan.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void K() {
        aan.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void P() {
        aan.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void a(com.google.android.gms.internal.ads.bf bfVar) {
        aan.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void O() {
        aan.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void a(com.google.android.gms.internal.ads.bd bdVar) {
        aan.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final boolean R() {
        if (J() != null) {
            return J().p;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final boolean S() {
        if (J() != null) {
            return J().q;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final boolean T() {
        if (J() != null) {
            return J().r;
        }
        return false;
    }

    private final ju J() {
        if (this.e.j == null || !this.e.j.n) {
            return null;
        }
        return this.e.j.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean c(wk wkVar, wk wkVar2) {
        View viewA = t.a(wkVar2);
        if (viewA == null) {
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
                a(viewA);
            } catch (Throwable th) {
                ax.i().a(th, "AdLoaderManager.swapBannerViews");
                xe.c("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.e.f.getChildCount() > 1) {
            this.e.f.showNext();
        }
        if (wkVar != null) {
            View nextView2 = this.e.f.getNextView();
            if (nextView2 != null) {
                this.e.f.removeView(nextView2);
            }
            this.e.c();
        }
        this.e.f.setMinimumWidth(l().f);
        this.e.f.setMinimumHeight(l().c);
        this.e.f.requestLayout();
        this.e.f.setVisibility(0);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void o() {
        if (!this.m) {
            throw new IllegalStateException("Native Ad does not support pause().");
        }
        super.o();
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void p() {
        if (!this.m) {
            throw new IllegalStateException("Native Ad does not support resume().");
        }
        super.p();
    }

    public final void b(List<String> list) {
        com.google.android.gms.common.internal.i.b("setNativeTemplates must be called on the main UI thread.");
        this.e.I = list;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final dj c(String str) {
        com.google.android.gms.common.internal.i.b("getOnCustomClickListener must be called on the main UI thread.");
        return this.e.v.get(str);
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void b(boolean z) {
        com.google.android.gms.common.internal.i.b("setManualImpressionsEnabled must be called from the main thread.");
        this.k = z;
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void a(com.google.android.gms.internal.ads.ai aiVar) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.brs
    public final void H() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    public final void c(List<Integer> list) {
        com.google.android.gms.common.internal.i.b("setAllowedAdTypes must be called on the main UI thread.");
        this.e.C = list;
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final void x() {
        super.x();
        wk wkVar = this.e.j;
        if (wkVar == null || wkVar.o == null || !wkVar.o.a() || this.e.B == null) {
            return;
        }
        try {
            this.e.B.a(this, com.google.android.gms.dynamic.b.a(this.e.c));
            super.b(this.e.j, false);
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.jv
    public final void U() {
        if (this.e.j != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q) && this.e.j.o != null && this.e.j.o.b()) {
            z();
        } else {
            super.U();
        }
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.jv
    public final void V() {
        if (this.e.j != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q) && this.e.j.o != null && this.e.j.o.b()) {
            y();
        } else {
            super.V();
        }
    }

    final /* synthetic */ void I() {
        b(this.l);
    }
}
