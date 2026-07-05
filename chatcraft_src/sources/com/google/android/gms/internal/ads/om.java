package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class om implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ wk f3318a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ol f3319b;

    om(ol olVar, wk wkVar) {
        this.f3319b = olVar;
        this.f3318a = wkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3319b.f3316a.b(this.f3318a);
    }
}
