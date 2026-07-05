package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bdd {

    /* renamed from: a, reason: collision with root package name */
    public final int f2537a;

    /* renamed from: b, reason: collision with root package name */
    public int f2538b;
    public int c;
    public long d;
    private final boolean e;
    private final bjz f;
    private final bjz g;
    private int h;
    private int i;

    public bdd(bjz bjzVar, bjz bjzVar2, boolean z) {
        this.g = bjzVar;
        this.f = bjzVar2;
        this.e = z;
        bjzVar2.c(12);
        this.f2537a = bjzVar2.o();
        bjzVar.c(12);
        this.i = bjzVar.o();
        bjq.b(bjzVar.l() == 1, "first_chunk must be 1");
        this.f2538b = -1;
    }

    public final boolean a() {
        int i = this.f2538b + 1;
        this.f2538b = i;
        if (i == this.f2537a) {
            return false;
        }
        this.d = this.e ? this.f.p() : this.f.j();
        if (this.f2538b == this.h) {
            this.c = this.g.o();
            this.g.d(4);
            int i2 = this.i - 1;
            this.i = i2;
            this.h = i2 > 0 ? this.g.o() - 1 : -1;
        }
        return true;
    }
}
