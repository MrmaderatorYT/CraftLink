package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xa;
import com.google.android.gms.internal.ads.xn;

@qj
/* loaded from: classes.dex */
final class p extends xa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f1643a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1644b;

    public p(m mVar, int i) {
        this.f1643a = mVar;
        this.f1644b = i;
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() {
        boolean z = this.f1643a.e.M;
        ax.e();
        r rVar = new r(z, xn.o(this.f1643a.e.c), this.f1643a.m, this.f1643a.n, this.f1643a.e.M ? this.f1644b : -1, this.f1643a.o, this.f1643a.e.j.L, this.f1643a.e.j.O);
        int requestedOrientation = this.f1643a.e.j.f3544b.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.f1643a.e.j.h;
        }
        xn.f3583a.post(new q(this, new AdOverlayInfoParcel(this.f1643a, this.f1643a, this.f1643a, this.f1643a.e.j.f3544b, requestedOrientation, this.f1643a.e.e, this.f1643a.e.j.A, rVar)));
    }
}
