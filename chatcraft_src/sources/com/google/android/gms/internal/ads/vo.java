package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class vo implements aaw<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ abl f3526a;

    vo(vk vkVar, abl ablVar) {
        this.f3526a = ablVar;
    }

    @Override // com.google.android.gms.internal.ads.aaw
    public final void a(Throwable th) {
        vk.f3520a.remove(this.f3526a);
    }

    @Override // com.google.android.gms.internal.ads.aaw
    public final /* synthetic */ void a(Void r2) {
        vk.f3520a.remove(this.f3526a);
    }
}
