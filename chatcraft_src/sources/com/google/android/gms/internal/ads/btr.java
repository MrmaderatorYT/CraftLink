package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class btr extends brl {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ btp f3024a;

    private btr(btp btpVar) {
        this.f3024a = btpVar;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final String a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final String b() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final void a(bqj bqjVar) {
        a(bqjVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final void a(bqj bqjVar, int i) {
        aan.c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        aac.f1778a.post(new bts(this));
    }
}
