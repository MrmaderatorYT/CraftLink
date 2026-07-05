package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class anm implements aoo {

    /* renamed from: a, reason: collision with root package name */
    private final SecretKeySpec f2091a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2092b;
    private final int c;

    public anm(byte[] bArr, int i) throws GeneralSecurityException {
        aox.a(bArr.length);
        this.f2091a = new SecretKeySpec(bArr, "AES");
        this.c = aoe.f2116a.a("AES/CTR/NoPadding").getBlockSize();
        if (i < 12 || i > this.c) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f2092b = i;
    }

    @Override // com.google.android.gms.internal.ads.aoo
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - this.f2092b) {
            int i = Integer.MAX_VALUE - this.f2092b;
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(i);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[this.f2092b + bArr.length];
        byte[] bArrA = aor.a(this.f2092b);
        System.arraycopy(bArrA, 0, bArr2, 0, this.f2092b);
        int length = bArr.length;
        int i2 = this.f2092b;
        Cipher cipherA = aoe.f2116a.a("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.c];
        System.arraycopy(bArrA, 0, bArr3, 0, this.f2092b);
        cipherA.init(1, this.f2091a, new IvParameterSpec(bArr3));
        if (cipherA.doFinal(bArr, 0, length, bArr2, i2) == length) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
