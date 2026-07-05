package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class ann implements aja {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2093a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2094b;
    private final SecretKeySpec c;
    private final int d;

    public ann(byte[] bArr, int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.d = i;
        aox.a(bArr.length);
        this.c = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.c);
        this.f2093a = a(cipher.doFinal(new byte[16]));
        this.f2094b = a(this.f2093a);
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i2] & Constants.DimensionIds.NETHER) >>> 7));
            i = i2;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    private final byte[] a(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrB;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(b(bArr2, this.f2093a));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        byte[] bArrDoFinal2 = bArrDoFinal;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArrDoFinal2[i5] = (byte) (bArrDoFinal2[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArrDoFinal2 = cipher.doFinal(bArrDoFinal2);
            i4 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (bArrCopyOfRange.length == 16) {
            bArrB = b(bArrCopyOfRange, this.f2093a);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(this.f2094b, 16);
            for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                bArrCopyOf[i6] = (byte) (bArrCopyOf[i6] ^ bArrCopyOfRange[i6]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
            bArrB = bArrCopyOf;
        }
        return cipher.doFinal(b(bArrDoFinal2, bArrB));
    }

    @Override // com.google.android.gms.internal.ads.aja
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > (Integer.MAX_VALUE - this.d) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[this.d + bArr.length + 16];
        byte[] bArrA = aor.a(this.d);
        System.arraycopy(bArrA, 0, bArr3, 0, this.d);
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.c);
        byte[] bArrA2 = a(cipher, 0, bArrA, 0, bArrA.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrA3 = a(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher2.init(1, this.c, new IvParameterSpec(bArrA2));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.d);
        byte[] bArrA4 = a(cipher, 2, bArr3, this.d, bArr.length);
        int length = bArr.length + this.d;
        for (int i = 0; i < 16; i++) {
            bArr3[length + i] = (byte) ((bArrA3[i] ^ bArrA2[i]) ^ bArrA4[i]);
        }
        return bArr3;
    }
}
