package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class ano implements aja {

    /* renamed from: a, reason: collision with root package name */
    private final SecretKey f2095a;

    public ano(byte[] bArr) throws InvalidAlgorithmParameterException {
        aox.a(bArr.length);
        this.f2095a = new SecretKeySpec(bArr, "AES");
    }

    @Override // com.google.android.gms.internal.ads.aja
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        byte[] bArrA = aor.a(12);
        System.arraycopy(bArrA, 0, bArr3, 0, 12);
        Cipher cipherA = aoe.f2116a.a("AES/GCM/NoPadding");
        cipherA.init(1, this.f2095a, a(bArrA, 0, bArrA.length));
        if (bArr2 != null && bArr2.length != 0) {
            cipherA.updateAAD(bArr2);
        }
        int iDoFinal = cipherA.doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (iDoFinal == bArr.length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr.length)));
    }

    private static AlgorithmParameterSpec a(byte[] bArr, int i, int i2) throws GeneralSecurityException, ClassNotFoundException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i2);
        } catch (ClassNotFoundException unused) {
            if (aow.a()) {
                return new IvParameterSpec(bArr, 0, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }
}
