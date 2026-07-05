package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
final class bhg implements bjj<bjn<Long>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bgy f2667a;

    private bhg(bgy bgyVar) {
        this.f2667a = bgyVar;
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ int a(bjl bjlVar, long j, long j2, IOException iOException) {
        return this.f2667a.b((bjn) bjlVar, j, j2, iOException);
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2, boolean z) {
        this.f2667a.c((bjn) bjlVar, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2) {
        this.f2667a.b((bjn) bjlVar, j, j2);
    }

    /* synthetic */ bhg(bgy bgyVar, bgz bgzVar) {
        this(bgyVar);
    }
}
