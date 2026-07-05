package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class qg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ aaq f3394a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3395b;

    qg(qd qdVar, aaq aaqVar, String str) {
        this.f3394a = aaqVar;
        this.f3395b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3394a.a(this.f3395b);
    }
}
