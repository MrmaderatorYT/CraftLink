package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class bjf implements biy {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2729a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2730b;
    private final byte[] c;
    private final bix[] d;
    private int e;
    private int f;
    private int g;
    private bix[] h;

    public bjf(boolean z, int i) {
        this(true, 65536, 0);
    }

    private bjf(boolean z, int i, int i2) {
        bjq.a(true);
        bjq.a(true);
        this.f2729a = true;
        this.f2730b = 65536;
        this.g = 0;
        this.h = new bix[100];
        this.c = null;
        this.d = new bix[1];
    }

    public final synchronized void d() {
        if (this.f2729a) {
            a(0);
        }
    }

    public final synchronized void a(int i) {
        boolean z = i < this.e;
        this.e = i;
        if (z) {
            b();
        }
    }

    @Override // com.google.android.gms.internal.ads.biy
    public final synchronized bix a() {
        bix bixVar;
        this.f++;
        if (this.g > 0) {
            bix[] bixVarArr = this.h;
            int i = this.g - 1;
            this.g = i;
            bixVar = bixVarArr[i];
            this.h[this.g] = null;
        } else {
            bixVar = new bix(new byte[this.f2730b], 0);
        }
        return bixVar;
    }

    @Override // com.google.android.gms.internal.ads.biy
    public final synchronized void a(bix bixVar) {
        this.d[0] = bixVar;
        a(this.d);
    }

    @Override // com.google.android.gms.internal.ads.biy
    public final synchronized void a(bix[] bixVarArr) {
        if (this.g + bixVarArr.length >= this.h.length) {
            this.h = (bix[]) Arrays.copyOf(this.h, Math.max(this.h.length << 1, this.g + bixVarArr.length));
        }
        for (bix bixVar : bixVarArr) {
            bjq.a(bixVar.f2717a == null || bixVar.f2717a.length == this.f2730b);
            bix[] bixVarArr2 = this.h;
            int i = this.g;
            this.g = i + 1;
            bixVarArr2[i] = bixVar;
        }
        this.f -= bixVarArr.length;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.biy
    public final synchronized void b() {
        int iMax = Math.max(0, bkg.a(this.e, this.f2730b) - this.f);
        if (iMax >= this.g) {
            return;
        }
        Arrays.fill(this.h, iMax, this.g, (Object) null);
        this.g = iMax;
    }

    public final synchronized int e() {
        return this.f * this.f2730b;
    }

    @Override // com.google.android.gms.internal.ads.biy
    public final int c() {
        return this.f2730b;
    }
}
