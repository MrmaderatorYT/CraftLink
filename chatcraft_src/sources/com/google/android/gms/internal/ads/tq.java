package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class tq extends com.google.android.gms.ads.internal.ba implements uu {
    private static tq k;
    private boolean l;
    private boolean m;
    private final vz n;
    private final tm o;

    public static tq I() {
        return k;
    }

    @Override // com.google.android.gms.ads.internal.ba
    protected final boolean a(bqj bqjVar, wk wkVar, boolean z) {
        return false;
    }

    public tq(Context context, com.google.android.gms.ads.internal.bt btVar, bqn bqnVar, kk kkVar, aar aarVar) {
        super(context, bqnVar, null, kkVar, aarVar, btVar);
        k = this;
        this.n = new vz(context, null);
        this.o = new tm(this.e, this.j, this, this, this);
    }

    public final void a(uk ukVar) {
        com.google.android.gms.common.internal.i.b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(ukVar.f3490b)) {
            xe.e("Invalid ad unit id. Aborting.");
            xn.f3583a.post(new tr(this));
            return;
        }
        this.l = false;
        this.e.f1537b = ukVar.f3490b;
        this.n.a(ukVar.f3490b);
        super.b(ukVar.f3489a);
    }

    @Override // com.google.android.gms.ads.internal.a
    public final void a(wl wlVar, ac acVar) {
        if (wlVar.e != -2) {
            xn.f3583a.post(new ts(this, wlVar));
            return;
        }
        this.e.k = wlVar;
        if (wlVar.c == null) {
            this.e.k = b(wlVar);
        }
        this.o.c();
    }

    public final vb c(String str) {
        return this.o.a(str);
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    public final boolean a(wk wkVar, wk wkVar2) {
        b(wkVar2, false);
        return tm.a(wkVar, wkVar2);
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void o() {
        this.o.d();
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void p() {
        this.o.e();
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void j() {
        this.o.f();
        super.j();
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void c(boolean z) {
        com.google.android.gms.common.internal.i.b("setImmersiveMode must be called on the main UI thread.");
        this.m = z;
    }

    public final void J() {
        com.google.android.gms.common.internal.i.b("showAd must be called on the main UI thread.");
        if (!K()) {
            xe.e("The reward video has not loaded.");
        } else {
            this.o.a(this.m);
        }
    }

    public final boolean K() {
        com.google.android.gms.common.internal.i.b("isLoaded must be called on the main UI thread.");
        return this.e.g == null && this.e.h == null && this.e.j != null;
    }

    @Override // com.google.android.gms.internal.ads.uu
    public final void l_() {
        if (com.google.android.gms.ads.internal.ax.E().a(this.e.c)) {
            this.n.a(true);
        }
        a(this.e.j, false);
        w();
    }

    @Override // com.google.android.gms.internal.ads.uu
    public final void b() {
        this.o.g();
        A();
    }

    @Override // com.google.android.gms.internal.ads.uu
    public final void m_() {
        this.o.h();
        B();
    }

    @Override // com.google.android.gms.internal.ads.uu
    public final void c() {
        if (com.google.android.gms.ads.internal.ax.E().a(this.e.c)) {
            this.n.a(false);
        }
        u();
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final void u() {
        this.e.j = null;
        super.u();
    }

    @Override // com.google.android.gms.internal.ads.uu
    public final void a(vh vhVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        vh vhVarA = this.o.a(vhVar);
        if (com.google.android.gms.ads.internal.ax.E().a(this.e.c) && vhVarA != null) {
            com.google.android.gms.ads.internal.ax.E().a(this.e.c, com.google.android.gms.ads.internal.ax.E().e(this.e.c), this.e.f1537b, vhVarA.f3518a, vhVarA.f3519b);
        }
        b(vhVarA);
    }

    @Override // com.google.android.gms.internal.ads.uu
    public final void n_() {
        e();
    }

    @Override // com.google.android.gms.internal.ads.uu
    public final void o_() {
        v();
    }

    public final void a(Context context) {
        this.o.a(context);
    }

    private static wl b(wl wlVar) throws JSONException {
        xe.a("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            JSONObject jSONObjectA = sw.a(wlVar.f3546b);
            jSONObjectA.remove("impression_urls");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, wlVar.f3545a.e);
            return new wl(wlVar.f3545a, wlVar.f3546b, new ju(Arrays.asList(new jt(jSONObjectA.toString(), null, Arrays.asList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject.toString(), null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1L)), ((Long) bra.e().a(o.bc)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, BuildConfig.FLAVOR, -1L, 0, 1, null, 0, -1, -1L, false), wlVar.d, wlVar.e, wlVar.f, wlVar.g, wlVar.h, wlVar.i, null);
        } catch (JSONException e) {
            xe.b("Unable to generate ad state for non-mediated rewarded video.", e);
            return new wl(wlVar.f3545a, wlVar.f3546b, null, wlVar.d, 0, wlVar.f, wlVar.g, wlVar.h, wlVar.i, null);
        }
    }
}
