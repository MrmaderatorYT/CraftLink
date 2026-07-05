package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class tl implements sv {

    /* renamed from: a, reason: collision with root package name */
    private ix<JSONObject, JSONObject> f3475a;

    /* renamed from: b, reason: collision with root package name */
    private ix<JSONObject, JSONObject> f3476b;

    public tl(Context context) {
        this.f3475a = com.google.android.gms.ads.internal.ax.t().a(context, aar.a()).a("google.afma.request.getAdDictionary", jd.f3191a, jd.f3191a);
        this.f3476b = com.google.android.gms.ads.internal.ax.t().a(context, aar.a()).a("google.afma.sdkConstants.getSdkConstants", jd.f3191a, jd.f3191a);
    }

    @Override // com.google.android.gms.internal.ads.sv
    public final ix<JSONObject, JSONObject> a() {
        return this.f3475a;
    }

    @Override // com.google.android.gms.internal.ads.sv
    public final ix<JSONObject, JSONObject> b() {
        return this.f3476b;
    }
}
