package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class kg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ abl f3226a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ke f3227b;

    kg(ke keVar, abl ablVar) {
        this.f3227b = keVar;
        this.f3226a = ablVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (abl ablVar : this.f3227b.k.keySet()) {
            if (ablVar != this.f3226a) {
                ((jx) this.f3227b.k.get(ablVar)).a();
            }
        }
    }
}
