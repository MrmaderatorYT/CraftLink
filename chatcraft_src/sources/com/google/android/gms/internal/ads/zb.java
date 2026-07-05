package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class zb<T> implements aau<Throwable, T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zf f3626a;

    zb(yz yzVar, zf zfVar) {
        this.f3626a = zfVar;
    }

    @Override // com.google.android.gms.internal.ads.aau
    public final /* synthetic */ abl a(Throwable th) {
        Throwable th2 = th;
        xe.b("Error occurred while dispatching http response in getter.", th2);
        com.google.android.gms.ads.internal.ax.i().a(th2, "HttpGetter.deliverResponse.1");
        return aaz.a(this.f3626a.a());
    }
}
