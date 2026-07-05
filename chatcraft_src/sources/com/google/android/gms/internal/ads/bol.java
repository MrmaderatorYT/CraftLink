package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* loaded from: classes.dex */
final class bol extends abv<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bok f2902a;

    bol(bok bokVar) {
        this.f2902a = bokVar;
    }

    @Override // com.google.android.gms.internal.ads.abv, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.f2902a.a();
        return super.cancel(z);
    }
}
