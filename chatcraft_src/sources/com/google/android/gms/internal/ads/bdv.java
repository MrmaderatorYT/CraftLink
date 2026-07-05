package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes.dex */
public final class bdv {
    public static byte[] a(UUID uuid, byte[] bArr) {
        int length = bArr.length + 32;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(bcz.U);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        byteBufferAllocate.putInt(bArr.length);
        byteBufferAllocate.put(bArr);
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.UUID a(byte[] r9) {
        /*
            com.google.android.gms.internal.ads.bjz r0 = new com.google.android.gms.internal.ads.bjz
            r0.<init>(r9)
            int r9 = r0.c()
            r1 = 0
            r2 = 32
            if (r9 >= r2) goto L10
        Le:
            r9 = r1
            goto L7a
        L10:
            r9 = 0
            r0.c(r9)
            int r2 = r0.l()
            int r3 = r0.b()
            int r3 = r3 + 4
            if (r2 == r3) goto L21
            goto Le
        L21:
            int r2 = r0.l()
            int r3 = com.google.android.gms.internal.ads.bcz.U
            if (r2 == r3) goto L2a
            goto Le
        L2a:
            int r2 = r0.l()
            int r2 = com.google.android.gms.internal.ads.bcz.a(r2)
            r3 = 1
            if (r2 <= r3) goto L4e
            java.lang.String r9 = "PsshAtomUtil"
            r0 = 37
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Unsupported pssh version: "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            android.util.Log.w(r9, r0)
            goto Le
        L4e:
            java.util.UUID r4 = new java.util.UUID
            long r5 = r0.m()
            long r7 = r0.m()
            r4.<init>(r5, r7)
            if (r2 != r3) goto L66
            int r2 = r0.o()
            int r2 = r2 << 4
            r0.d(r2)
        L66:
            int r2 = r0.o()
            int r3 = r0.b()
            if (r2 == r3) goto L71
            goto Le
        L71:
            byte[] r3 = new byte[r2]
            r0.a(r3, r9, r2)
            android.util.Pair r9 = android.util.Pair.create(r4, r3)
        L7a:
            if (r9 != 0) goto L7d
            return r1
        L7d:
            java.lang.Object r9 = r9.first
            java.util.UUID r9 = (java.util.UUID) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bdv.a(byte[]):java.util.UUID");
    }
}
