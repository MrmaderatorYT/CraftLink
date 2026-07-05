package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class qy implements rb {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f3409a;

    qy(Context context) {
        this.f3409a = context;
    }

    @Override // com.google.android.gms.internal.ads.rb
    public final boolean a(aar aarVar) {
        bra.a();
        boolean zC = aac.c(this.f3409a, 12451000);
        boolean z = ((Boolean) bra.e().a(o.cw)).booleanValue() && aarVar.d;
        com.google.android.gms.ads.internal.ax.e();
        return !qx.b(this.f3409a, aarVar.d) || !zC || z || xn.f(this.f3409a.getPackageName());
    }
}
