package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class or implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ wk f3324a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ oq f3325b;

    or(oq oqVar, wk wkVar) {
        this.f3325b = oqVar;
        this.f3324a = wkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3325b.f3322a.b(this.f3324a);
    }
}
