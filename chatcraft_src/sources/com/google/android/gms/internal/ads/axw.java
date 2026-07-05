package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class axw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2391a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f2392b;
    private final /* synthetic */ axt c;

    axw(axt axtVar, int i, boolean z) {
        this.c = axtVar;
        this.f2391a = i;
        this.f2392b = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        akp akpVarB = this.c.b(this.f2391a, this.f2392b);
        this.c.k = akpVarB;
        if (axt.b(this.f2391a, akpVarB)) {
            this.c.a(this.f2391a + 1, this.f2392b);
        }
    }
}
