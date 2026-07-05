package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bgk implements bcm {

    /* renamed from: a, reason: collision with root package name */
    public bab f2645a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2646b;
    private final int c;
    private final bab d;
    private bcm e;

    public bgk(int i, int i2, bab babVar) {
        this.f2646b = i;
        this.c = i2;
        this.d = babVar;
    }

    public final void a(bgl bglVar) {
        if (bglVar == null) {
            this.e = new bcb();
            return;
        }
        this.e = bglVar.a(this.f2646b, this.c);
        if (this.e != null) {
            this.e.a(this.f2645a);
        }
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(bab babVar) {
        this.f2645a = babVar.a(this.d);
        this.e.a(this.f2645a);
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final int a(bce bceVar, int i, boolean z) {
        return this.e.a(bceVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(bjz bjzVar, int i) {
        this.e.a(bjzVar, i);
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(long j, int i, int i2, int i3, bcn bcnVar) {
        this.e.a(j, i, i2, i3, bcnVar);
    }
}
