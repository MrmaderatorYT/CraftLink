package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
final class bhd implements bjj<bjn<bho>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bgy f2662a;

    private bhd(bgy bgyVar) {
        this.f2662a = bgyVar;
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ int a(bjl bjlVar, long j, long j2, IOException iOException) {
        return this.f2662a.a((bjn) bjlVar, j, j2, iOException);
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2, boolean z) {
        this.f2662a.c((bjn) bjlVar, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2) {
        this.f2662a.a((bjn<bho>) bjlVar, j, j2);
    }

    /* synthetic */ bhd(bgy bgyVar, bgz bgzVar) {
        this(bgyVar);
    }
}
