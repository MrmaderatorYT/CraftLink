package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ada implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f1855a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ acv f1856b;

    ada(acv acvVar, boolean z) {
        this.f1856b = acvVar;
        this.f1855a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1856b.a("windowVisibilityChanged", "isVisible", String.valueOf(this.f1855a));
    }
}
