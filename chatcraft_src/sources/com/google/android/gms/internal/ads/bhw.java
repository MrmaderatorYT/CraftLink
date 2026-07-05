package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class bhw extends bhu implements bhi {
    private final bhz e;

    public bhw(String str, long j, bab babVar, String str2, bhz bhzVar, List<bhr> list) {
        super(str, -1L, babVar, str2, bhzVar, list);
        this.e = bhzVar;
    }

    @Override // com.google.android.gms.internal.ads.bhu
    public final bht d() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bhu
    public final bhi e() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.bhu
    public final String f() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final bht b(int i) {
        return this.e.a(this, i);
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final int a(long j, long j2) {
        bhz bhzVar = this.e;
        int i = bhzVar.d;
        int iA = bhzVar.a(j2);
        if (iA == 0) {
            return i;
        }
        if (bhzVar.f == null) {
            int i2 = bhzVar.d + ((int) (j / ((bhzVar.e * 1000000) / bhzVar.f2692b)));
            return i2 < i ? i : iA == -1 ? i2 : Math.min(i2, (i + iA) - 1);
        }
        int i3 = (iA + i) - 1;
        int i4 = i;
        while (i4 <= i3) {
            int i5 = ((i3 - i4) / 2) + i4;
            long jA = bhzVar.a(i5);
            if (jA < j) {
                i4 = i5 + 1;
            } else {
                if (jA <= j) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return i4 == i ? i4 : i3;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final long a(int i) {
        return this.e.a(i);
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final long a(int i, long j) {
        bhz bhzVar = this.e;
        if (bhzVar.f != null) {
            return (bhzVar.f.get(i - bhzVar.d).f2694b * 1000000) / bhzVar.f2692b;
        }
        if (bhzVar.a(j) != -1 && i == (bhzVar.d + r1) - 1) {
            return j - bhzVar.a(i);
        }
        return (bhzVar.e * 1000000) / bhzVar.f2692b;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final int a() {
        return this.e.d;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final int a(long j) {
        return this.e.a(j);
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final boolean b() {
        return this.e.a();
    }
}
