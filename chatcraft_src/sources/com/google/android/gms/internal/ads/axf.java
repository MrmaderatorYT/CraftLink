package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class axf {

    /* renamed from: b, reason: collision with root package name */
    private static Cipher f2365b;
    private static final Object c = new Object();
    private static final Object d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final SecureRandom f2366a = null;

    public axf(SecureRandom secureRandom) {
    }

    public final byte[] a(String str) throws zzcx {
        try {
            byte[] bArrA = atu.a(str, false);
            if (bArrA.length != 32) {
                throw new zzcx(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(bArrA, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new zzcx(this, e);
        }
    }

    public final String a(byte[] bArr, byte[] bArr2) throws zzcx {
        byte[] bArrDoFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zzcx(this);
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (c) {
                a().init(1, secretKeySpec, (SecureRandom) null);
                bArrDoFinal = a().doFinal(bArr2);
                iv = a().getIV();
            }
            int length = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length];
            byteBufferAllocate.get(bArr3);
            return atu.a(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new zzcx(this, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new zzcx(this, e2);
        } catch (BadPaddingException e3) {
            throw new zzcx(this, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new zzcx(this, e4);
        } catch (NoSuchPaddingException e5) {
            throw new zzcx(this, e5);
        }
    }

    public final byte[] a(byte[] bArr, String str) throws zzcx {
        byte[] bArrDoFinal;
        if (bArr.length != 16) {
            throw new zzcx(this);
        }
        try {
            byte[] bArrA = atu.a(str, false);
            if (bArrA.length <= 16) {
                throw new zzcx(this);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrA.length);
            byteBufferAllocate.put(bArrA);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArrA.length - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (c) {
                a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = a().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e) {
            throw new zzcx(this, e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new zzcx(this, e2);
        } catch (InvalidKeyException e3) {
            throw new zzcx(this, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new zzcx(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzcx(this, e5);
        } catch (IllegalBlockSizeException e6) {
            throw new zzcx(this, e6);
        } catch (NoSuchPaddingException e7) {
            throw new zzcx(this, e7);
        }
    }

    private static Cipher a() {
        Cipher cipher;
        synchronized (d) {
            if (f2365b == null) {
                f2365b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f2365b;
        }
        return cipher;
    }
}
