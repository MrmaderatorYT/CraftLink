package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class sh implements aca<iu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ sg f3445a;

    sh(sg sgVar) {
        this.f3445a = sgVar;
    }

    @Override // com.google.android.gms.internal.ads.aca
    public final /* synthetic */ void a(iu iuVar) {
        try {
            iuVar.b("AFMA_getAdapterLessMediationAd", this.f3445a.f3443a);
        } catch (Exception e) {
            xe.b("Error requesting an ad url", e);
            se.f.b(this.f3445a.f3444b);
        }
    }
}
