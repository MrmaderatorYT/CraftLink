package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bfe implements bga {

    /* renamed from: a, reason: collision with root package name */
    private final bga[] f2609a;

    public bfe(bga[] bgaVarArr) {
        this.f2609a = bgaVarArr;
    }

    @Override // com.google.android.gms.internal.ads.bga
    public final long r_() {
        long jMin = Long.MAX_VALUE;
        for (bga bgaVar : this.f2609a) {
            long jR_ = bgaVar.r_();
            if (jR_ != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jR_);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.bga
    public final boolean a(long j) {
        boolean zA;
        boolean z = false;
        do {
            long jR_ = r_();
            if (jR_ == Long.MIN_VALUE) {
                break;
            }
            zA = false;
            for (bga bgaVar : this.f2609a) {
                if (bgaVar.r_() == jR_) {
                    zA |= bgaVar.a(j);
                }
            }
            z |= zA;
        } while (zA);
        return z;
    }
}
