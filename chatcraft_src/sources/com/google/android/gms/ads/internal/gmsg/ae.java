package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.xe;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JSONObject f1587a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ad f1588b;

    ae(ad adVar, JSONObject jSONObject) {
        this.f1588b = adVar;
        this.f1587a = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1588b.f1585a.a("fetchHttpRequestCompleted", this.f1587a);
        xe.b("Dispatched http response.");
    }
}
