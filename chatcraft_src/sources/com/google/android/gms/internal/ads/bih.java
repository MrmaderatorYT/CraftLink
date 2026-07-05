package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bih {
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(long r16, com.google.android.gms.internal.ads.bjz r18, com.google.android.gms.internal.ads.bcm[] r19) {
        /*
            r0 = r18
            r1 = r19
        L4:
            int r2 = r18.b()
            r3 = 1
            if (r2 <= r3) goto L98
            int r2 = a(r18)
            int r4 = a(r18)
            r5 = -1
            if (r4 == r5) goto L88
            int r5 = r18.b()
            if (r4 <= r5) goto L1e
            goto L88
        L1e:
            r5 = 4
            r6 = 3
            r7 = 8
            r8 = 0
            if (r2 != r5) goto L50
            if (r4 >= r7) goto L28
            goto L50
        L28:
            int r2 = r18.d()
            int r5 = r18.f()
            int r9 = r18.g()
            int r10 = r18.l()
            int r11 = r18.f()
            r0.c(r2)
            r2 = 181(0xb5, float:2.54E-43)
            if (r5 != r2) goto L50
            r2 = 49
            if (r9 != r2) goto L50
            r2 = 1195456820(0x47413934, float:49465.203)
            if (r10 != r2) goto L50
            if (r11 != r6) goto L50
            r2 = 1
            goto L51
        L50:
            r2 = 0
        L51:
            if (r2 == 0) goto L83
            r0.d(r7)
            int r2 = r18.f()
            r2 = r2 & 31
            r0.d(r3)
            int r2 = r2 * 3
            int r3 = r18.d()
            int r5 = r1.length
        L66:
            if (r8 >= r5) goto L7c
            r9 = r1[r8]
            r0.c(r3)
            r9.a(r0, r2)
            r12 = 1
            r14 = 0
            r15 = 0
            r10 = r16
            r13 = r2
            r9.a(r10, r12, r13, r14, r15)
            int r8 = r8 + 1
            goto L66
        L7c:
            int r2 = r2 + 10
            int r4 = r4 - r2
            r0.d(r4)
            goto L4
        L83:
            r0.d(r4)
            goto L4
        L88:
            java.lang.String r2 = "CeaUtil"
            java.lang.String r3 = "Skipping remainder of malformed SEI NAL unit."
            android.util.Log.w(r2, r3)
            int r2 = r18.c()
            r0.c(r2)
            goto L4
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bih.a(long, com.google.android.gms.internal.ads.bjz, com.google.android.gms.internal.ads.bcm[]):void");
    }

    private static int a(bjz bjzVar) {
        int i = 0;
        while (bjzVar.b() != 0) {
            int iF = bjzVar.f();
            i += iF;
            if (iF != 255) {
                return i;
            }
        }
        return -1;
    }
}
