package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* loaded from: classes.dex */
final class jk implements aca<iu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ il f3198a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Object f3199b;
    private final /* synthetic */ abv c;
    private final /* synthetic */ jj d;

    jk(jj jjVar, il ilVar, Object obj, abv abvVar) {
        this.d = jjVar;
        this.f3198a = ilVar;
        this.f3199b = obj;
        this.c = abvVar;
    }

    @Override // com.google.android.gms.internal.ads.aca
    public final /* synthetic */ void a(iu iuVar) throws JSONException {
        this.d.a(this.f3198a, iuVar, this.f3199b, this.c);
    }
}
