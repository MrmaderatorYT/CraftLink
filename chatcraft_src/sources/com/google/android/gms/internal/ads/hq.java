package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class hq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3138a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hm f3139b;

    hq(hm hmVar, String str) {
        this.f3139b = hmVar;
        this.f3138a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3139b.f3132a.loadData(this.f3138a, "text/html", "UTF-8");
    }
}
