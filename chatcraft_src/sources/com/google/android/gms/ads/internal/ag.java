package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.ads.aaz;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.ri;
import com.google.android.gms.internal.ads.rj;
import com.google.android.gms.internal.ads.wl;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class ag implements Callable<com.google.android.gms.internal.ads.bh> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1507a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ JSONArray f1508b;
    private final /* synthetic */ int c;
    private final /* synthetic */ wl d;
    private final /* synthetic */ ad e;

    ag(ad adVar, int i, JSONArray jSONArray, int i2, wl wlVar) {
        this.e = adVar;
        this.f1507a = i;
        this.f1508b = jSONArray;
        this.c = i2;
        this.d = wlVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ com.google.android.gms.internal.ads.bh call() throws JSONException {
        Bundle bundle;
        if (this.f1507a >= this.f1508b.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f1508b.get(this.f1507a));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        ad adVar = new ad(this.e.e.c, this.e.i, this.e.e.i, this.e.e.f1537b, this.e.j, this.e.e.e, true);
        ad adVar2 = this.e;
        ad.a(this.e.e, adVar.e);
        adVar.k_();
        adVar.a(this.e.f1497b);
        com.google.android.gms.internal.ads.ac acVar = adVar.f1496a;
        int i = this.f1507a;
        acVar.a("num_ads_requested", String.valueOf(this.c));
        acVar.a("ad_index", String.valueOf(i));
        ri riVar = this.d.f3545a;
        String string = jSONObject.toString();
        if (riVar.c.c != null) {
            bundle = new Bundle(riVar.c.c);
        } else {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putString("_ad", string);
        adVar.a(new rj(riVar.f3423b, new bqj(riVar.c.f2969a, riVar.c.f2970b, bundle2, riVar.c.d, riVar.c.e, riVar.c.f, riVar.c.g, riVar.c.h, riVar.c.i, riVar.c.j, riVar.c.k, riVar.c.l, riVar.c.m, riVar.c.n, riVar.c.o, riVar.c.p, riVar.c.q, riVar.c.r, null, riVar.c.t, riVar.c.u), riVar.d, riVar.e, riVar.f, riVar.g, riVar.i, riVar.j, riVar.k, riVar.l, riVar.n, riVar.z, riVar.o, riVar.p, riVar.q, riVar.r, riVar.s, riVar.t, riVar.u, riVar.v, riVar.w, riVar.x, riVar.y, riVar.B, riVar.C, riVar.I, riVar.D, riVar.E, riVar.F, riVar.G, aaz.a(riVar.H), riVar.J, riVar.K, riVar.L, riVar.M, riVar.N, riVar.O, riVar.P, riVar.Q, riVar.U, aaz.a(riVar.h), riVar.V, riVar.W, riVar.X, 1, riVar.Z, riVar.aa, riVar.ab, riVar.ac, riVar.ad, riVar.ae, riVar.ag), adVar.f1496a);
        return adVar.J().get();
    }
}
