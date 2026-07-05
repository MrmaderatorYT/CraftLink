package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

@qj
/* loaded from: classes.dex */
public final class bnn extends bni {

    /* renamed from: b, reason: collision with root package name */
    private MessageDigest f2879b;

    @Override // com.google.android.gms.internal.ads.bni
    public final byte[] a(String str) throws UnsupportedEncodingException {
        byte[] bArrArray;
        String[] strArrSplit = str.split(" ");
        int length = 4;
        if (strArrSplit.length == 1) {
            int iA = bnm.a(strArrSplit[0]);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putInt(iA);
            bArrArray = byteBufferAllocate.array();
        } else if (strArrSplit.length < 5) {
            bArrArray = new byte[strArrSplit.length << 1];
            for (int i = 0; i < strArrSplit.length; i++) {
                int iA2 = bnm.a(strArrSplit[i]);
                int i2 = (iA2 >> 16) ^ (65535 & iA2);
                byte[] bArr = {(byte) i2, (byte) (i2 >> 8)};
                int i3 = i << 1;
                bArrArray[i3] = bArr[0];
                bArrArray[i3 + 1] = bArr[1];
            }
        } else {
            bArrArray = new byte[strArrSplit.length];
            for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                int iA3 = bnm.a(strArrSplit[i4]);
                bArrArray[i4] = (byte) ((iA3 >> 24) ^ (((iA3 & 255) ^ ((iA3 >> 8) & 255)) ^ ((iA3 >> 16) & 255)));
            }
        }
        this.f2879b = a();
        synchronized (this.f2874a) {
            if (this.f2879b == null) {
                return new byte[0];
            }
            this.f2879b.reset();
            this.f2879b.update(bArrArray);
            byte[] bArrDigest = this.f2879b.digest();
            if (bArrDigest.length <= 4) {
                length = bArrDigest.length;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArrDigest, 0, bArr2, 0, bArr2.length);
            return bArr2;
        }
    }
}
