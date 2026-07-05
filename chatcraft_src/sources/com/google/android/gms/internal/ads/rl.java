package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

@qj
/* loaded from: classes.dex */
public final class rl extends ru {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<ra> f3426a;

    public rl(ra raVar) {
        this.f3426a = new WeakReference<>(raVar);
    }

    @Override // com.google.android.gms.internal.ads.rt
    public final void a(rm rmVar) {
        ra raVar = this.f3426a.get();
        if (raVar != null) {
            raVar.a(rmVar);
        }
    }
}
