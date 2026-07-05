package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class baj {

    /* renamed from: a, reason: collision with root package name */
    public static final baj f2449a = new bak();

    public abstract int a(Object obj);

    public abstract bal a(int i, bal balVar, boolean z);

    public abstract bam a(int i, bam bamVar, boolean z, long j);

    public abstract int b();

    public abstract int c();

    public final boolean a() {
        return b() == 0;
    }

    private final bam a(int i, bam bamVar) {
        return a(i, bamVar, false, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(int r3, com.google.android.gms.internal.ads.bal r4, com.google.android.gms.internal.ads.bam r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.a(r3, r4, r0)
            com.google.android.gms.internal.ads.bam r4 = r2.a(r0, r5)
            int r4 = r4.c
            r1 = 1
            if (r4 != r3) goto L2f
            r3 = -1
            switch(r6) {
                case 0: goto L20;
                case 1: goto L1e;
                case 2: goto L17;
                default: goto L11;
            }
        L11:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L17:
            int r4 = r2.b()
            int r4 = r4 - r1
            if (r4 != 0) goto L28
        L1e:
            r1 = 0
            goto L28
        L20:
            int r4 = r2.b()
            int r4 = r4 - r1
            if (r4 != 0) goto L28
            r1 = -1
        L28:
            if (r1 != r3) goto L2b
            return r3
        L2b:
            r2.a(r1, r5)
            return r0
        L2f:
            int r3 = r3 + r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.baj.a(int, com.google.android.gms.internal.ads.bal, com.google.android.gms.internal.ads.bam, int):int");
    }
}
