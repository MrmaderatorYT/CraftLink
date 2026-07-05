package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bld implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2795a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f2796b;
    private final /* synthetic */ int c;
    private final /* synthetic */ float d;
    private final /* synthetic */ bkx e;

    bld(bkx bkxVar, int i, int i2, int i3, float f) {
        this.e = bkxVar;
        this.f2795a = i;
        this.f2796b = i2;
        this.c = i3;
        this.d = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.f2782b.a(this.f2795a, this.f2796b, this.c, this.d);
    }
}
