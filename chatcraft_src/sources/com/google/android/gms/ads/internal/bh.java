package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;

/* loaded from: classes.dex */
final class bh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ wl f1547a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bf f1548b;

    bh(bf bfVar, wl wlVar) {
        this.f1548b = bfVar;
        this.f1547a = wlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1548b.b(new wk(this.f1547a, null, null, null, null, null, null, null));
    }
}
