package com.google.ads.mediation;

/* loaded from: classes.dex */
final class g extends com.google.android.gms.ads.reward.a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AbstractAdViewAdapter f1461a;

    g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f1461a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.a
    public final void a() {
        if (this.f1461a.zzhw == null || this.f1461a.zzhx == null) {
            return;
        }
        this.f1461a.zzhx.a(this.f1461a.zzhw.d());
    }
}
