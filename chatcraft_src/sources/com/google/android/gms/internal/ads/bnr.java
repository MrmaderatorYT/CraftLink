package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bnr extends bni {

    /* renamed from: b, reason: collision with root package name */
    private MessageDigest f2882b;
    private final int c;
    private final int d;

    public bnr(int i) {
        int i2 = i / 8;
        this.c = i % 8 > 0 ? i2 + 1 : i2;
        this.d = i;
    }

    @Override // com.google.android.gms.internal.ads.bni
    public final byte[] a(String str) {
        synchronized (this.f2874a) {
            this.f2882b = a();
            if (this.f2882b == null) {
                return new byte[0];
            }
            this.f2882b.reset();
            this.f2882b.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] bArrDigest = this.f2882b.digest();
            byte[] bArr = new byte[bArrDigest.length > this.c ? this.c : bArrDigest.length];
            System.arraycopy(bArrDigest, 0, bArr, 0, bArr.length);
            if (this.d % 8 > 0) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    if (i > 0) {
                        j <<= 8;
                    }
                    j += bArr[i] & Constants.DimensionIds.NETHER;
                }
                long j2 = j >>> (8 - (this.d % 8));
                for (int i2 = this.c - 1; i2 >= 0; i2--) {
                    bArr[i2] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
