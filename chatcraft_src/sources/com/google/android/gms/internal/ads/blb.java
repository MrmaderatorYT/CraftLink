package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class blb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2791a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f2792b;
    private final /* synthetic */ bkx c;

    blb(bkx bkxVar, int i, long j) {
        this.c = bkxVar;
        this.f2791a = i;
        this.f2792b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f2782b.a(this.f2791a, this.f2792b);
    }
}
