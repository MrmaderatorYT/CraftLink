package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
final class bly implements aca<iu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JSONObject f2824a;

    bly(blv blvVar, JSONObject jSONObject) {
        this.f2824a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.aca
    public final /* synthetic */ void a(iu iuVar) {
        iuVar.b("AFMA_updateActiveView", this.f2824a);
    }
}
