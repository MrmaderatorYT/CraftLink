package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class acw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final act f1848a;

    private acw(act actVar) {
        this.f1848a = actVar;
    }

    static Runnable a(act actVar) {
        return new acw(actVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1848a.b();
    }
}
