package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class bii implements bir {

    /* renamed from: a, reason: collision with root package name */
    private final bgd f2700a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2701b;
    private final int[] c;
    private final bab[] d;
    private final long[] e;
    private int f;

    public bii(bgd bgdVar, int... iArr) {
        bjq.b(iArr.length > 0);
        this.f2700a = (bgd) bjq.a(bgdVar);
        this.f2701b = iArr.length;
        this.d = new bab[this.f2701b];
        for (int i = 0; i < iArr.length; i++) {
            this.d[i] = bgdVar.a(iArr[i]);
        }
        Arrays.sort(this.d, new bik());
        this.c = new int[this.f2701b];
        for (int i2 = 0; i2 < this.f2701b; i2++) {
            this.c[i2] = bgdVar.a(this.d[i2]);
        }
        this.e = new long[this.f2701b];
    }

    @Override // com.google.android.gms.internal.ads.bir
    public final bgd a() {
        return this.f2700a;
    }

    @Override // com.google.android.gms.internal.ads.bir
    public final int b() {
        return this.c.length;
    }

    @Override // com.google.android.gms.internal.ads.bir
    public final bab a(int i) {
        return this.d[i];
    }

    @Override // com.google.android.gms.internal.ads.bir
    public final int b(int i) {
        return this.c[i];
    }

    @Override // com.google.android.gms.internal.ads.bir
    public final int a(bab babVar) {
        for (int i = 0; i < this.f2701b; i++) {
            if (this.d[i] == babVar) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.bir
    public final bab c() {
        return this.d[d()];
    }

    @Override // com.google.android.gms.internal.ads.bir
    public final boolean a(int i, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = b(i, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.f2701b && !zB) {
            zB = (i2 == i || b(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zB) {
            return false;
        }
        this.e[i] = Math.max(this.e[i], jElapsedRealtime + 60000);
        return true;
    }

    private final boolean b(int i, long j) {
        return this.e[i] > j;
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = (System.identityHashCode(this.f2700a) * 31) + Arrays.hashCode(this.c);
        }
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bii biiVar = (bii) obj;
        return this.f2700a == biiVar.f2700a && Arrays.equals(this.c, biiVar.c);
    }
}
