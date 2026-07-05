package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
final class qb implements aaw<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3386a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ JSONObject f3387b;

    qb(pr prVar, String str, JSONObject jSONObject) {
        this.f3386a = str;
        this.f3387b = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.aaw
    public final void a(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.aaw
    public final /* synthetic */ void a(afu afuVar) {
        afuVar.a(this.f3386a, this.f3387b);
    }
}
