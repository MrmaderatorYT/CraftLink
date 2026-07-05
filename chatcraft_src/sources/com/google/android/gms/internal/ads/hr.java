package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class hr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3140a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hm f3141b;

    hr(hm hmVar, String str) {
        this.f3141b = hmVar;
        this.f3140a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3141b.f3132a.loadData(this.f3140a, "text/html", "UTF-8");
    }
}
