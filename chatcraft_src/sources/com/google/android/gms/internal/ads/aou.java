package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
abstract class aou implements aoo {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f2124a = a(ByteBuffer.wrap(new byte[]{101, Constants.MobIds.VILLAGER, 112, Constants.MobIds.SNOWMAN, 110, 100, 32, 51, 50, 45, Constants.MobIds.OCELOT, 121, 116, 101, 32, 107}));

    /* renamed from: b, reason: collision with root package name */
    final aon f2125b;
    private final int c;

    aou(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f2125b = aon.a(bArr);
        this.c = i;
    }

    static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    abstract int a();

    abstract ByteBuffer a(byte[] bArr, int i);

    @Override // com.google.android.gms.internal.ads.aoo
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        a();
        if (length > 2147483635) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(a() + bArr.length);
        a(byteBufferAllocate, bArr);
        return byteBufferAllocate.array();
    }

    final void a(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() - a() < bArr.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] bArrA = aor.a(a());
        byteBuffer.put(bArrA);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        int iRemaining = byteBufferWrap.remaining();
        int i = (iRemaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBufferA = a(bArrA, this.c + i2);
            if (i2 == i - 1) {
                anp.a(byteBuffer, byteBufferWrap, byteBufferA, iRemaining % 64);
            } else {
                anp.a(byteBuffer, byteBufferWrap, byteBufferA, 64);
            }
        }
    }

    static int[] a(ByteBuffer byteBuffer) {
        IntBuffer intBufferAsIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }
}
