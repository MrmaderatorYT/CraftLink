package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bhf {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2665a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2666b;
    public final long c;

    public static bhf a(bhs bhsVar, long j) {
        int i;
        int size = bhsVar.c.size();
        int i2 = 0;
        long jMin = Long.MAX_VALUE;
        int i3 = 0;
        boolean z = false;
        boolean zB = false;
        long j2 = 0;
        while (i3 < size) {
            bhi bhiVarE = bhsVar.c.get(i3).c.get(i2).e();
            if (bhiVarE == null) {
                return new bhf(true, 0L, j);
            }
            zB |= bhiVarE.b();
            int iA = bhiVarE.a(j);
            if (iA == 0) {
                i = i3;
                z = true;
                j2 = 0;
                jMin = 0;
            } else if (z) {
                i = i3;
            } else {
                int iA2 = bhiVarE.a();
                i = i3;
                long jMax = Math.max(j2, bhiVarE.a(iA2));
                if (iA != -1) {
                    int i4 = (iA2 + iA) - 1;
                    jMin = Math.min(jMin, bhiVarE.a(i4) + bhiVarE.a(i4, j));
                }
                j2 = jMax;
            }
            i3 = i + 1;
            i2 = 0;
        }
        return new bhf(zB, j2, jMin);
    }

    private bhf(boolean z, long j, long j2) {
        this.f2665a = z;
        this.f2666b = j;
        this.c = j2;
    }
}
