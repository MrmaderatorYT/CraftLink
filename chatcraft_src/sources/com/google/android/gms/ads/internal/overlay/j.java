package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xa;
import com.google.android.gms.internal.ads.xn;

@qj
/* loaded from: classes.dex */
final class j extends xa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f1634a;

    private j(d dVar) {
        this.f1634a = dVar;
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() {
        Bitmap bitmapA = ax.z().a(Integer.valueOf(this.f1634a.f1627b.o.e));
        if (bitmapA != null) {
            xn.f3583a.post(new k(this, ax.g().a(this.f1634a.f1626a, bitmapA, this.f1634a.f1627b.o.c, this.f1634a.f1627b.o.d)));
        }
    }

    /* synthetic */ j(d dVar, f fVar) {
        this(dVar);
    }
}
