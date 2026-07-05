package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bbj implements bbc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bbh f2490a;

    private bbj(bbh bbhVar) {
        this.f2490a = bbhVar;
    }

    @Override // com.google.android.gms.internal.ads.bbc
    public final void a(int i) {
        this.f2490a.f2489b.a(i);
        bbh.b(i);
    }

    @Override // com.google.android.gms.internal.ads.bbc
    public final void a() {
        bbh.v();
        bbh.a(this.f2490a, true);
    }

    @Override // com.google.android.gms.internal.ads.bbc
    public final void a(int i, long j, long j2) {
        this.f2490a.f2489b.a(i, j, j2);
        bbh.a(i, j, j2);
    }
}
