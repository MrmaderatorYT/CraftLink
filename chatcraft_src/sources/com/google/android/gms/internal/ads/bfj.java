package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bfj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bfm f2614a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bfg f2615b;

    bfj(bfg bfgVar, bfm bfmVar) {
        this.f2615b = bfgVar;
        this.f2614a = bfmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2614a.a();
        int size = this.f2615b.p.size();
        for (int i = 0; i < size; i++) {
            ((bfw) this.f2615b.p.valueAt(i)).b();
        }
    }
}
