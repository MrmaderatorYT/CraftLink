package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* loaded from: classes.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdOverlayInfoParcel f1645a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ p f1646b;

    q(p pVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f1646b = pVar;
        this.f1645a = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.c();
        com.google.android.gms.ads.internal.overlay.l.a(this.f1646b.f1643a.e.c, this.f1645a, true);
    }
}
