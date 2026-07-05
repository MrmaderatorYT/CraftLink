package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public final class aed implements bae {

    /* renamed from: a, reason: collision with root package name */
    private final bjf f1891a;

    /* renamed from: b, reason: collision with root package name */
    private long f1892b;
    private long c;
    private long d;
    private long e;
    private int f;
    private boolean g;

    aed() {
        this(15000, 30000, 2500L, 5000L);
    }

    private aed(int i, int i2, long j, long j2) {
        this.f1891a = new bjf(true, 65536);
        this.f1892b = 15000000L;
        this.c = 30000000L;
        this.d = 2500000L;
        this.e = 5000000L;
    }

    @Override // com.google.android.gms.internal.ads.bae
    public final void a() {
        a(false);
    }

    @Override // com.google.android.gms.internal.ads.bae
    public final void a(bag[] bagVarArr, bgf bgfVar, bit bitVar) {
        this.f = 0;
        for (int i = 0; i < bagVarArr.length; i++) {
            if (bitVar.a(i) != null) {
                this.f += bkg.b(bagVarArr[i].a());
            }
        }
        this.f1891a.a(this.f);
    }

    @Override // com.google.android.gms.internal.ads.bae
    public final void b() {
        a(true);
    }

    @Override // com.google.android.gms.internal.ads.bae
    public final void c() {
        a(true);
    }

    @Override // com.google.android.gms.internal.ads.bae
    public final biy d() {
        return this.f1891a;
    }

    @Override // com.google.android.gms.internal.ads.bae
    public final synchronized boolean a(long j, boolean z) {
        long j2;
        try {
            j2 = z ? this.e : this.d;
        } catch (Throwable th) {
            throw th;
        }
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.gms.internal.ads.bae
    public final synchronized boolean a(long j) {
        boolean z = false;
        char c = j > this.c ? (char) 0 : j < this.f1892b ? (char) 2 : (char) 1;
        boolean z2 = this.f1891a.e() >= this.f;
        if (c == 2 || (c == 1 && this.g && !z2)) {
            z = true;
        }
        this.g = z;
        return this.g;
    }

    public final synchronized void a(int i) {
        this.f1892b = i * 1000;
    }

    public final synchronized void b(int i) {
        this.c = i * 1000;
    }

    public final synchronized void c(int i) {
        this.d = i * 1000;
    }

    public final synchronized void d(int i) {
        this.e = i * 1000;
    }

    private final void a(boolean z) {
        this.f = 0;
        this.g = false;
        if (z) {
            this.f1891a.d();
        }
    }
}
