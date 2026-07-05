package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class hd extends aht {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ gw f3126a;

    private hd(gw gwVar) {
        this.f3126a = gwVar;
    }

    @Override // com.google.android.gms.internal.ads.aht
    public final void a(ahu ahuVar) {
        if (this.f3126a.f3118b != null) {
            this.f3126a.f3118b.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.aht
    public final void b(ahu ahuVar) {
        this.f3126a.a(ahuVar.f1996b);
    }

    @Override // com.google.android.gms.internal.ads.aht
    public final boolean c(ahu ahuVar) {
        return this.f3126a.a(ahuVar.f1996b);
    }
}
