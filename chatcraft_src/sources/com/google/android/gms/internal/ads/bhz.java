package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public abstract class bhz extends bhy {
    final int d;
    final long e;
    final List<bic> f;

    public bhz(bht bhtVar, long j, long j2, int i, long j3, List<bic> list) {
        super(bhtVar, j, j2);
        this.d = i;
        this.e = j3;
        this.f = list;
    }

    public abstract int a(long j);

    public abstract bht a(bhu bhuVar, int i);

    public final long a(int i) {
        long j;
        if (this.f != null) {
            j = this.f.get(i - this.d).f2693a - this.c;
        } else {
            j = (i - this.d) * this.e;
        }
        return bkg.a(j, 1000000L, this.f2692b);
    }

    public boolean a() {
        return this.f != null;
    }
}
