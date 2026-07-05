package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bdi implements bdf {

    /* renamed from: a, reason: collision with root package name */
    private final bjz f2544a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2545b;
    private final int c;
    private int d;
    private int e;

    public bdi(bdb bdbVar) {
        this.f2544a = bdbVar.aP;
        this.f2544a.c(12);
        this.c = this.f2544a.o() & 255;
        this.f2545b = this.f2544a.o();
    }

    @Override // com.google.android.gms.internal.ads.bdf
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bdf
    public final int a() {
        return this.f2545b;
    }

    @Override // com.google.android.gms.internal.ads.bdf
    public final int b() {
        if (this.c == 8) {
            return this.f2544a.f();
        }
        if (this.c == 16) {
            return this.f2544a.g();
        }
        int i = this.d;
        this.d = i + 1;
        if (i % 2 == 0) {
            this.e = this.f2544a.f();
            return (this.e & 240) >> 4;
        }
        return this.e & 15;
    }
}
