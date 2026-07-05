package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* loaded from: classes.dex */
final class ms implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdOverlayInfoParcel f3275a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzanu f3276b;

    ms(zzanu zzanuVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f3276b = zzanuVar;
        this.f3275a = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.ax.c();
        com.google.android.gms.ads.internal.overlay.l.a(this.f3276b.f3655a, this.f3275a, true);
    }
}
