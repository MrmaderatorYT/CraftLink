package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class hs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3142a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hm f3143b;

    hs(hm hmVar, String str) {
        this.f3143b = hmVar;
        this.f3142a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3143b.f3132a.loadUrl(this.f3142a);
    }
}
