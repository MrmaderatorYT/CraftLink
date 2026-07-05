package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
final class et implements aau<eq, ParcelFileDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ek f3072a;

    et(es esVar, ek ekVar) {
        this.f3072a = ekVar;
    }

    @Override // com.google.android.gms.internal.ads.aau
    public final /* synthetic */ abl<ParcelFileDescriptor> a(eq eqVar) {
        abv abvVar = new abv();
        eqVar.a(this.f3072a, new eu(this, abvVar));
        return abvVar;
    }
}
