package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class bia extends bhz {
    final List<bht> g;

    public bia(bht bhtVar, long j, long j2, int i, long j3, List<bic> list, List<bht> list2) {
        super(bhtVar, j, j2, i, j3, list);
        this.g = list2;
    }

    @Override // com.google.android.gms.internal.ads.bhz
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bhz
    public final bht a(bhu bhuVar, int i) {
        return this.g.get(i - this.d);
    }

    @Override // com.google.android.gms.internal.ads.bhz
    public final int a(long j) {
        return this.g.size();
    }
}
