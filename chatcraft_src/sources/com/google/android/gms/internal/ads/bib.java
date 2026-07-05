package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class bib extends bhz {
    final bif g;
    final bif h;

    public bib(bht bhtVar, long j, long j2, int i, long j3, List<bic> list, bif bifVar, bif bifVar2) {
        super(bhtVar, j, j2, i, j3, list);
        this.g = bifVar;
        this.h = bifVar2;
    }

    @Override // com.google.android.gms.internal.ads.bhy
    public final bht a(bhu bhuVar) {
        if (this.g != null) {
            return new bht(this.g.a(bhuVar.f2689a.f2442a, 0, bhuVar.f2689a.f2443b, 0L), 0L, -1L);
        }
        return super.a(bhuVar);
    }

    @Override // com.google.android.gms.internal.ads.bhz
    public final bht a(bhu bhuVar, int i) {
        long j;
        if (this.f != null) {
            j = this.f.get(i - this.d).f2693a;
        } else {
            j = (i - this.d) * this.e;
        }
        return new bht(this.h.a(bhuVar.f2689a.f2442a, i, bhuVar.f2689a.f2443b, j), 0L, -1L);
    }

    @Override // com.google.android.gms.internal.ads.bhz
    public final int a(long j) {
        if (this.f != null) {
            return this.f.size();
        }
        if (j != -9223372036854775807L) {
            return (int) bkg.a(j, (this.e * 1000000) / this.f2692b);
        }
        return -1;
    }
}
