package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bhb extends baj {

    /* renamed from: b, reason: collision with root package name */
    private final long f2661b;
    private final long c;
    private final int d;
    private final long e;
    private final long f;
    private final long g;
    private final bho h;

    public bhb(long j, long j2, int i, long j3, long j4, long j5, bho bhoVar) {
        this.f2661b = j;
        this.c = j2;
        this.d = i;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = bhoVar;
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final int b() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final int c() {
        return this.h.a();
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final bal a(int i, bal balVar, boolean z) {
        bjq.a(i, 0, this.h.a());
        return balVar.a(z ? this.h.a(i).f2685a : null, z ? Integer.valueOf(this.d + bjq.a(i, 0, this.h.a())) : null, 0, this.h.b(i), azo.b(this.h.a(i).f2686b - this.h.a(0).f2686b) - this.e, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028 A[PHI: r5
      0x0028: PHI (r5v2 long) = (r5v1 long), (r5v5 long) binds: [B:6:0x0018, B:8:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.baj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.bam a(int r24, com.google.android.gms.internal.ads.bam r25, boolean r26, long r27) {
        /*
            r23 = this;
            r0 = r23
            r3 = 1
            r4 = 0
            r5 = r24
            com.google.android.gms.internal.ads.bjq.a(r5, r4, r3)
            long r5 = r0.g
            com.google.android.gms.internal.ads.bho r7 = r0.h
            boolean r7 = r7.f2678b
            if (r7 != 0) goto L14
        L11:
            r15 = r5
            goto L99
        L14:
            r7 = 0
            int r9 = (r27 > r7 ? 1 : (r27 == r7 ? 0 : -1))
            if (r9 <= 0) goto L28
            long r5 = r5 + r27
            long r1 = r0.f
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L28
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L11
        L28:
            long r1 = r0.e
            long r1 = r1 + r5
            com.google.android.gms.internal.ads.bho r7 = r0.h
            long r7 = r7.b(r4)
            r9 = r7
            r7 = r1
            r1 = 0
        L34:
            com.google.android.gms.internal.ads.bho r2 = r0.h
            int r2 = r2.a()
            int r2 = r2 - r3
            if (r1 >= r2) goto L4b
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 < 0) goto L4b
            long r7 = r7 - r9
            int r1 = r1 + 1
            com.google.android.gms.internal.ads.bho r2 = r0.h
            long r9 = r2.b(r1)
            goto L34
        L4b:
            com.google.android.gms.internal.ads.bho r2 = r0.h
            com.google.android.gms.internal.ads.bhs r1 = r2.a(r1)
            java.util.List<com.google.android.gms.internal.ads.bhn> r2 = r1.c
            int r2 = r2.size()
            r11 = 0
        L58:
            r12 = -1
            if (r11 >= r2) goto L6c
            java.util.List<com.google.android.gms.internal.ads.bhn> r13 = r1.c
            java.lang.Object r13 = r13.get(r11)
            com.google.android.gms.internal.ads.bhn r13 = (com.google.android.gms.internal.ads.bhn) r13
            int r13 = r13.f2676b
            r14 = 2
            if (r13 != r14) goto L69
            goto L6d
        L69:
            int r11 = r11 + 1
            goto L58
        L6c:
            r11 = -1
        L6d:
            if (r11 != r12) goto L70
            goto L11
        L70:
            java.util.List<com.google.android.gms.internal.ads.bhn> r1 = r1.c
            java.lang.Object r1 = r1.get(r11)
            com.google.android.gms.internal.ads.bhn r1 = (com.google.android.gms.internal.ads.bhn) r1
            java.util.List<com.google.android.gms.internal.ads.bhu> r1 = r1.c
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.ads.bhu r1 = (com.google.android.gms.internal.ads.bhu) r1
            com.google.android.gms.internal.ads.bhi r1 = r1.e()
            if (r1 == 0) goto L11
            int r2 = r1.a(r9)
            if (r2 != 0) goto L8d
            goto L11
        L8d:
            int r2 = r1.a(r7, r9)
            long r1 = r1.a(r2)
            long r5 = r5 + r1
            long r5 = r5 - r7
            goto L11
        L99:
            r8 = 0
            long r9 = r0.f2661b
            long r11 = r0.c
            r13 = 1
            com.google.android.gms.internal.ads.bho r1 = r0.h
            boolean r14 = r1.f2678b
            long r1 = r0.f
            r19 = 0
            com.google.android.gms.internal.ads.bho r4 = r0.h
            int r4 = r4.a()
            int r20 = r4 + (-1)
            long r3 = r0.e
            r7 = r25
            r17 = r1
            r21 = r3
            com.google.android.gms.internal.ads.bam r1 = r7.a(r8, r9, r11, r13, r14, r15, r17, r19, r20, r21)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bhb.a(int, com.google.android.gms.internal.ads.bam, boolean, long):com.google.android.gms.internal.ads.bam");
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final int a(Object obj) {
        int iIntValue;
        if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue()) >= this.d && iIntValue < this.d + c()) {
            return iIntValue - this.d;
        }
        return -1;
    }
}
