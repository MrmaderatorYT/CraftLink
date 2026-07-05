package com.google.android.gms.internal.ads;

import android.content.Context;

@qj
/* loaded from: classes.dex */
public final class vq implements vw {

    /* renamed from: a, reason: collision with root package name */
    private vx f3527a;

    public vq(vx vxVar) {
        this.f3527a = vxVar;
    }

    @Override // com.google.android.gms.internal.ads.vw
    public final vv a(Context context, aar aarVar, rm rmVar) {
        if (rmVar.K == null) {
            return null;
        }
        return new vk(context, aarVar, rmVar.K, rmVar.f3427a, this.f3527a);
    }
}
