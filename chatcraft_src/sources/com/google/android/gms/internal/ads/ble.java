package com.google.android.gms.internal.ads;

import android.view.Surface;

/* loaded from: classes.dex */
final class ble implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Surface f2797a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bkx f2798b;

    ble(bkx bkxVar, Surface surface) {
        this.f2798b = bkxVar;
        this.f2797a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2798b.f2782b.a(this.f2797a);
    }
}
