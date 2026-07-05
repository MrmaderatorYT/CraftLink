package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class azn implements bag, bah {

    /* renamed from: a, reason: collision with root package name */
    private final int f2422a;

    /* renamed from: b, reason: collision with root package name */
    private bai f2423b;
    private int c;
    private int d;
    private bfz e;
    private long f;
    private boolean g = true;
    private boolean h;

    public azn(int i) {
        this.f2422a = i;
    }

    @Override // com.google.android.gms.internal.ads.azr
    public void a(int i, Object obj) {
    }

    protected void a(long j, boolean z) {
    }

    protected void a(boolean z) {
    }

    protected void a(bab[] babVarArr, long j) {
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final bah b() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public bju c() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bah
    public int m() {
        return 0;
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void p() {
    }

    @Override // com.google.android.gms.internal.ads.bag, com.google.android.gms.internal.ads.bah
    public final int a() {
        return this.f2422a;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void a(int i) {
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final int d() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void a(bai baiVar, bab[] babVarArr, bfz bfzVar, long j, boolean z, long j2) {
        bjq.b(this.d == 0);
        this.f2423b = baiVar;
        this.d = 1;
        a(z);
        a(babVarArr, bfzVar, j2);
        a(j, z);
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void e() {
        bjq.b(this.d == 1);
        this.d = 2;
        n();
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void a(bab[] babVarArr, bfz bfzVar, long j) {
        bjq.b(!this.h);
        this.e = bfzVar;
        this.g = false;
        this.f = j;
        a(babVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final bfz f() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final boolean g() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void h() {
        this.h = true;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final boolean i() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void j() {
        this.e.b();
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void a(long j) {
        this.h = false;
        this.g = false;
        a(j, false);
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void k() {
        bjq.b(this.d == 2);
        this.d = 1;
        o();
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void l() {
        bjq.b(this.d == 1);
        this.d = 0;
        this.e = null;
        this.h = false;
        p();
    }

    protected final bai q() {
        return this.f2423b;
    }

    protected final int r() {
        return this.c;
    }

    protected final int a(bad badVar, bbs bbsVar, boolean z) {
        int iA = this.e.a(badVar, bbsVar, z);
        if (iA == -4) {
            if (bbsVar.c()) {
                this.g = true;
                return this.h ? -4 : -3;
            }
            bbsVar.c += this.f;
        } else if (iA == -5) {
            bab babVar = badVar.f2444a;
            if (babVar.q != Long.MAX_VALUE) {
                badVar.f2444a = babVar.a(babVar.q + this.f);
            }
        }
        return iA;
    }

    protected final void b(long j) {
        this.e.a_(j - this.f);
    }

    protected final boolean s() {
        return this.g ? this.h : this.e.a();
    }
}
