package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class uo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bqj f3495a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kn f3496b;
    private final /* synthetic */ un c;

    uo(un unVar, bqj bqjVar, kn knVar) {
        this.c = unVar;
        this.f3495a = bqjVar;
        this.f3496b = knVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f3495a, this.f3496b);
    }
}
