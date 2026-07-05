package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bla implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bab f2789a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bkx f2790b;

    bla(bkx bkxVar, bab babVar) {
        this.f2790b = bkxVar;
        this.f2789a = babVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2790b.f2782b.a(this.f2789a);
    }
}
