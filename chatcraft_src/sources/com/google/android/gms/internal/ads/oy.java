package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class oy implements com.google.android.gms.ads.internal.gmsg.ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ay f3335a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ot f3336b;

    oy(ot otVar, ay ayVar) {
        this.f3336b = otVar;
        this.f3335a = ayVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        this.f3336b.a(this.f3335a, map.get("asset"));
    }
}
