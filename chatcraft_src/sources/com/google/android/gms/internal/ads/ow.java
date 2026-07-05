package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ow implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ abv f3331a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3332b;
    private final /* synthetic */ ot c;

    ow(ot otVar, abv abvVar, String str) {
        this.c = otVar;
        this.f3331a = abvVar;
        this.f3332b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3331a.b(this.c.d.N().get(this.f3332b));
    }
}
