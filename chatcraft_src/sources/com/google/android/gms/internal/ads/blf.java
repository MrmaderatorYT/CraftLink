package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class blf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bbr f2799a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bkx f2800b;

    blf(bkx bkxVar, bbr bbrVar) {
        this.f2800b = bkxVar;
        this.f2799a = bbrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2799a.a();
        this.f2800b.f2782b.b(this.f2799a);
    }
}
