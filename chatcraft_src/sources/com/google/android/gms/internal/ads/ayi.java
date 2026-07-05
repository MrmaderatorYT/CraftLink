package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ayi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ blc f2406a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ axi f2407b;

    ayi(axi axiVar, blc blcVar) {
        this.f2407b = axiVar;
        this.f2406a = blcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        try {
            this.f2407b.c.put(this.f2406a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
