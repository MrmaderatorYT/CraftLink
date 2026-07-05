package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.aac;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.ahh;
import com.google.android.gms.internal.ads.bli;
import com.google.android.gms.internal.ads.bou;
import com.google.android.gms.internal.ads.bqa;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqk;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.brd;
import com.google.android.gms.internal.ads.brh;
import com.google.android.gms.internal.ads.brt;
import com.google.android.gms.internal.ads.brx;
import com.google.android.gms.internal.ads.bsa;
import com.google.android.gms.internal.ads.bsg;
import com.google.android.gms.internal.ads.bsw;
import com.google.android.gms.internal.ads.btc;
import com.google.android.gms.internal.ads.bua;
import com.google.android.gms.internal.ads.buc;
import com.google.android.gms.internal.ads.nt;
import com.google.android.gms.internal.ads.oa;
import com.google.android.gms.internal.ads.oj;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.ql;
import com.google.android.gms.internal.ads.tn;
import com.google.android.gms.internal.ads.tw;
import com.google.android.gms.internal.ads.ue;
import com.google.android.gms.internal.ads.vh;
import com.google.android.gms.internal.ads.wd;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.wm;
import com.google.android.gms.internal.ads.wv;
import com.google.android.gms.internal.ads.wx;
import com.google.android.gms.internal.ads.xc;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class a extends brt implements com.google.android.gms.ads.internal.gmsg.j, com.google.android.gms.ads.internal.gmsg.l, com.google.android.gms.ads.internal.overlay.t, bqa, oj, ql, wv {

    /* renamed from: a, reason: collision with root package name */
    protected com.google.android.gms.internal.ads.ac f1496a;

    /* renamed from: b, reason: collision with root package name */
    protected com.google.android.gms.internal.ads.z f1497b;
    protected final ay e;
    protected transient bqj f;
    protected final bli g;
    protected com.google.android.gms.dynamic.a h;
    protected final bt i;
    private com.google.android.gms.internal.ads.z j;
    protected boolean c = false;
    private final Bundle k = new Bundle();
    private boolean l = false;
    protected final an d = new an(this);

    protected static boolean a(bqj bqjVar) {
        Bundle bundle = bqjVar.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle == null || !bundle.containsKey("gw");
    }

    protected abstract void a(wl wlVar, com.google.android.gms.internal.ads.ac acVar);

    protected abstract boolean a(bqj bqjVar, com.google.android.gms.internal.ads.ac acVar);

    boolean a(wk wkVar) {
        return false;
    }

    protected abstract boolean a(wk wkVar, wk wkVar2);

    @Override // com.google.android.gms.internal.ads.brs
    public bsw t() {
        return null;
    }

    public final bt i() {
        return this.i;
    }

    a(ay ayVar, an anVar, bt btVar) {
        this.e = ayVar;
        this.i = btVar;
        ax.e().b(this.e.c);
        ax.e().c(this.e.c);
        xc.a(this.e.c);
        ax.q().a(this.e.c);
        ax.i().a(this.e.c, this.e.e);
        ax.k().a(this.e.c);
        this.g = ax.i().f();
        ax.h().a(this.e.c);
        ax.B().a(this.e.c);
    }

    public final void a(com.google.android.gms.internal.ads.z zVar) {
        this.f1496a = new com.google.android.gms.internal.ads.ac(((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.K)).booleanValue(), "load_ad", this.e.i.f2974a);
        this.j = new com.google.android.gms.internal.ads.z(-1L, null, null);
        if (zVar == null) {
            this.f1497b = new com.google.android.gms.internal.ads.z(-1L, null, null);
        } else {
            this.f1497b = new com.google.android.gms.internal.ads.z(zVar.a(), zVar.b(), zVar.c());
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public void j() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: destroy");
        this.d.a();
        this.g.b(this.e.j);
        ay ayVar = this.e;
        if (ayVar.f != null) {
            ayVar.f.b();
        }
        ayVar.n = null;
        ayVar.p = null;
        ayVar.o = null;
        ayVar.D = null;
        ayVar.q = null;
        ayVar.a(false);
        if (ayVar.f != null) {
            ayVar.f.removeAllViews();
        }
        ayVar.b();
        ayVar.c();
        ayVar.j = null;
        this.h = null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final com.google.android.gms.dynamic.a k() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: getAdFrame");
        return com.google.android.gms.dynamic.b.a(this.e.f);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bqn l() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: getAdSize");
        if (this.e.i == null) {
            return null;
        }
        return new bua(this.e.i);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean m() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: isLoaded");
        return this.e.g == null && this.e.h == null && this.e.j != null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public void b(boolean z) {
        xe.e("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public boolean b(bqj bqjVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: loadAd");
        ax.k().a();
        this.k.clear();
        this.l = false;
        bqj bqjVarA = bqjVar.a();
        bqjVarA.c.putInt("dv", DynamiteModule.b(this.e.c, ModuleDescriptor.MODULE_ID));
        bqjVarA.c.putBoolean(AdMobAdapter.NEW_BUNDLE, true);
        if (com.google.android.gms.common.util.g.c(this.e.c) && bqjVarA.k != null) {
            bqjVarA = new bqk(bqjVarA).a(null).a();
        }
        if (this.e.g != null || this.e.h != null) {
            if (this.f != null) {
                xe.e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            } else {
                xe.e("Loading already in progress, saving this object for future refreshes.");
            }
            this.f = bqjVarA;
            return false;
        }
        xe.d("Starting ad request.");
        String strValueOf = String.valueOf(this.e.e.f1790a);
        xe.d(strValueOf.length() != 0 ? "SDK version: ".concat(strValueOf) : new String("SDK version: "));
        a((com.google.android.gms.internal.ads.z) null);
        this.f1497b = this.f1496a.a();
        if (bqjVarA.f) {
            xe.d("This request is sent from a test device.");
        } else {
            bra.a();
            String strA = aac.a(this.e.c);
            StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 71);
            sb.append("Use AdRequest.Builder.addTestDevice(\"");
            sb.append(strA);
            sb.append("\") to get test ads on this device.");
            xe.d(sb.toString());
        }
        this.d.a(bqjVarA);
        this.c = a(bqjVarA, this.f1496a);
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.ql
    public final void a(wl wlVar) {
        if (wlVar.f3546b.m != -1 && !TextUtils.isEmpty(wlVar.f3546b.w)) {
            long jC = c(wlVar.f3546b.w);
            if (jC != -1) {
                this.f1496a.a(this.f1496a.a(wlVar.f3546b.m + jC), "stc");
            }
        }
        this.f1496a.a(wlVar.f3546b.w);
        this.f1496a.a(this.f1497b, "arf");
        this.j = this.f1496a.a();
        this.f1496a.a("gqi", wlVar.f3546b.x);
        this.e.g = null;
        this.e.k = wlVar;
        wlVar.i.a(new ab(this, wlVar));
        wlVar.i.a(bou.a.b.AD_LOADED);
        a(wlVar, this.f1496a);
    }

    @Override // com.google.android.gms.internal.ads.oj
    public void b(wk wkVar) {
        this.f1496a.a(this.j, "awr");
        this.e.h = null;
        if (wkVar.d != -2 && wkVar.d != 3 && this.e.a() != null) {
            ax.i().n().a(this.e.a());
        }
        if (wkVar.d == -1) {
            this.c = false;
            return;
        }
        if (a(wkVar)) {
            xe.b("Ad refresh scheduled.");
        }
        if (wkVar.d != -2) {
            if (wkVar.d == 3) {
                wkVar.K.a(bou.a.b.AD_FAILED_TO_LOAD_NO_FILL);
            } else {
                wkVar.K.a(bou.a.b.AD_FAILED_TO_LOAD);
            }
            a(wkVar.d);
            return;
        }
        if (this.e.J == null) {
            this.e.J = new wx(this.e.f1537b);
        }
        if (this.e.f != null) {
            this.e.f.a().d(wkVar.B);
        }
        this.g.a(this.e.j);
        if (a(this.e.j, wkVar)) {
            this.e.j = wkVar;
            ay ayVar = this.e;
            if (ayVar.l != null) {
                if (ayVar.j != null) {
                    ayVar.l.a(ayVar.j.y);
                    ayVar.l.b(ayVar.j.z);
                    ayVar.l.b(ayVar.j.n);
                }
                ayVar.l.a(ayVar.i.d);
            }
            this.f1496a.a("is_mraid", this.e.j.a() ? "1" : "0");
            this.f1496a.a("is_mediation", this.e.j.n ? "1" : "0");
            if (this.e.j.f3544b != null && this.e.j.f3544b.w() != null) {
                this.f1496a.a("is_delay_pl", this.e.j.f3544b.w().f() ? "1" : "0");
            }
            this.f1496a.a(this.f1497b, "ttc");
            if (ax.i().a() != null) {
                ax.i().a().a(this.f1496a);
            }
            C();
            if (this.e.d()) {
                x();
            }
        }
        if (wkVar.J != null) {
            ax.e().a(this.e.c, wkVar.J);
        }
    }

    @Override // com.google.android.gms.internal.ads.bqa
    public void e() {
        if (this.e.j == null) {
            xe.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        xe.b("Pinging click URLs.");
        if (this.e.l != null) {
            this.e.l.b();
        }
        if (this.e.j.c != null) {
            ax.e();
            xn.a(this.e.c, this.e.e.f1790a, a(this.e.j.c, this.e.j.P));
        }
        if (this.e.m != null) {
            try {
                this.e.m.a();
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.t
    public final void h() {
        v();
    }

    @Override // com.google.android.gms.ads.internal.gmsg.j
    public final void a(String str, Bundle bundle) {
        this.k.putAll(bundle);
        if (!this.l || this.e.p == null) {
            return;
        }
        try {
            this.e.p.a();
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.l
    public final void a(String str, String str2) {
        if (this.e.o != null) {
            try {
                this.e.o.a(str, str2);
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void n() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: recordManualImpression");
        if (this.e.j == null) {
            xe.e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        xe.b("Pinging manual tracking URLs.");
        if (this.e.j.H) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.e.j.g != null) {
            arrayList.addAll(this.e.j.g);
        }
        if (this.e.j.o != null && this.e.j.o.i != null) {
            arrayList.addAll(this.e.j.o.i);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ax.e();
        xn.a(this.e.c, this.e.e.f1790a, arrayList);
        this.e.j.H = true;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public void o() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: pause");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public void p() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: resume");
    }

    protected boolean c(bqj bqjVar) {
        if (this.e.f == null) {
            return false;
        }
        Object parent = this.e.f.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return ax.e().a(view, view.getContext());
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brh brhVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setAdListener");
        this.e.n = brhVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(ue ueVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setRewardedVideoAdListener");
        this.e.E = ueVar;
    }

    public final void a(tw twVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.e.F = twVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(String str) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setUserId");
        this.e.G = str;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void b(String str) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setCustomData");
        this.e.H = str;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brd brdVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setAdClickListener");
        this.e.m = brdVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bqn bqnVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setAdSize");
        this.e.i = bqnVar;
        if (this.e.j != null && this.e.j.f3544b != null && this.e.L == 0) {
            this.e.j.f3544b.a(ahh.a(bqnVar));
        }
        if (this.e.f == null) {
            return;
        }
        if (this.e.f.getChildCount() > 1) {
            this.e.f.removeView(this.e.f.getNextView());
        }
        this.e.f.setMinimumWidth(bqnVar.f);
        this.e.f.setMinimumHeight(bqnVar.c);
        this.e.f.requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsa bsaVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setAppEventListener");
        this.e.o = bsaVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brx brxVar) {
        this.e.p = brxVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final Bundle q() {
        if (this.l) {
            return this.k;
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.brs
    public void a(nt ntVar) {
        xe.e("#006 Unexpected call to a deprecated method.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public void a(com.google.android.gms.internal.ads.ai aiVar) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(oa oaVar, String str) {
        xe.e("#006 Unexpected call to a deprecated method.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsg bsgVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setCorrelationIdProvider");
        this.e.q = bsgVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void r() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: stopLoading");
        this.c = false;
        this.e.a(true);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean s() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(buc bucVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setVideoOptions");
        this.e.y = bucVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(btc btcVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setIconAdOptions");
        this.e.A = btcVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public void c(boolean z) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    private static long c(String str) {
        int iIndexOf = str.indexOf("ufe");
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(iIndexOf + 4, iIndexOf2));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return -1L;
        }
    }

    protected final void a(View view) {
        az azVar = this.e.f;
        if (azVar != null) {
            azVar.addView(view, ax.g().d());
        }
    }

    protected void u() {
        xe.a("Ad closing.");
        if (this.e.n != null) {
            try {
                this.e.n.a();
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.E != null) {
            try {
                this.e.E.d();
            } catch (RemoteException e2) {
                xe.d("#007 Could not call remote method.", e2);
            }
        }
    }

    protected final void v() {
        xe.a("Ad leaving application.");
        if (this.e.n != null) {
            try {
                this.e.n.b();
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.E != null) {
            try {
                this.e.E.e();
            } catch (RemoteException e2) {
                xe.d("#007 Could not call remote method.", e2);
            }
        }
    }

    protected final void w() {
        xe.a("Ad opening.");
        if (this.e.n != null) {
            try {
                this.e.n.d();
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.E != null) {
            try {
                this.e.E.b();
            } catch (RemoteException e2) {
                xe.d("#007 Could not call remote method.", e2);
            }
        }
    }

    protected void x() {
        d(false);
    }

    protected void d(boolean z) {
        xe.a("Ad finished loading.");
        this.c = z;
        this.l = true;
        if (this.e.n != null) {
            try {
                this.e.n.c();
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.E != null) {
            try {
                this.e.E.a();
            } catch (RemoteException e2) {
                xe.d("#007 Could not call remote method.", e2);
            }
        }
        if (this.e.p != null) {
            try {
                this.e.p.a();
            } catch (RemoteException e3) {
                xe.d("#007 Could not call remote method.", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        a(i, false);
    }

    protected void a(int i, boolean z) {
        StringBuilder sb = new StringBuilder(30);
        sb.append("Failed to load ad: ");
        sb.append(i);
        xe.e(sb.toString());
        this.c = z;
        if (this.e.n != null) {
            try {
                this.e.n.a(i);
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.E != null) {
            try {
                this.e.E.a(i);
            } catch (RemoteException e2) {
                xe.d("#007 Could not call remote method.", e2);
            }
        }
        if (this.e.u != null) {
            try {
                this.e.u.a(i);
            } catch (RemoteException e3) {
                xe.d("#007 Could not call remote method.", e3);
            }
        }
    }

    public final void y() {
        xe.d("Ad impression.");
        if (this.e.n != null) {
            try {
                this.e.n.e();
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void z() {
        xe.d("Ad clicked.");
        if (this.e.n != null) {
            try {
                this.e.n.f();
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }

    protected final void A() {
        if (this.e.E == null) {
            return;
        }
        try {
            this.e.E.c();
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }

    protected final void b(vh vhVar) {
        if (this.e.E == null) {
            return;
        }
        String str = BuildConfig.FLAVOR;
        int i = 1;
        if (vhVar != null) {
            try {
                str = vhVar.f3518a;
                i = vhVar.f3519b;
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
                return;
            }
        }
        tn tnVar = new tn(str, i);
        this.e.E.a(tnVar);
        if (this.e.F != null) {
            this.e.F.a(tnVar, this.e.k.f3545a.v);
        }
    }

    protected final void B() {
        if (this.e.E == null) {
            return;
        }
        try {
            this.e.E.f();
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }

    protected final List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(wd.a(it.next(), this.e.c));
        }
        return arrayList;
    }

    public final void C() {
        wk wkVar = this.e.j;
        if (wkVar == null || TextUtils.isEmpty(wkVar.B) || wkVar.I || !ax.o().b()) {
            return;
        }
        xe.b("Sending troubleshooting signals to the server.");
        ax.o().b(this.e.c, this.e.e.f1790a, wkVar.B, this.e.f1537b);
        wkVar.I = true;
    }

    @Override // com.google.android.gms.internal.ads.wv
    public final void a(HashSet<wm> hashSet) {
        this.e.a(hashSet);
    }

    protected final List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(wd.a(it.next(), this.e.c, z));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public String D() {
        return this.e.f1537b;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bsa E() {
        return this.e.o;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final brh F() {
        return this.e.n;
    }

    protected final String G() {
        wl wlVar = this.e.k;
        if (wlVar == null || wlVar.f3546b == null) {
            return "javascript";
        }
        String str = wlVar.f3546b.T;
        if (TextUtils.isEmpty(str)) {
            return "javascript";
        }
        try {
            if (new JSONObject(str).optInt("media_type", -1) == 0) {
                return null;
            }
            return "javascript";
        } catch (JSONException e) {
            aan.c(BuildConfig.FLAVOR, e);
            return "javascript";
        }
    }
}
