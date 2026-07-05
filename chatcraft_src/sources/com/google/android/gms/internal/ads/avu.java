package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class avu {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f2328b = false;
    private static MessageDigest c;
    private static final Object d = new Object();
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    static CountDownLatch f2327a = new CountDownLatch(1);

    static void a() {
        synchronized (e) {
            if (!f2328b) {
                f2328b = true;
                new Thread(new awh()).start();
            }
        }
    }

    private static MessageDigest b() throws InterruptedException {
        boolean zAwait;
        a();
        try {
            zAwait = f2327a.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            zAwait = false;
        }
        if (zAwait && c != null) {
            return c;
        }
        return null;
    }

    static String a(akp akpVar, String str) throws GeneralSecurityException {
        byte[] bArrA;
        byte[] bArrA2 = aus.a(akpVar);
        if (!((Boolean) bra.e().a(o.bn)).booleanValue()) {
            if (axy.f2394a == null) {
                throw new GeneralSecurityException();
            }
            byte[] bArrA3 = axy.f2394a.a(bArrA2, str != null ? str.getBytes() : new byte[0]);
            art artVar = new art();
            artVar.f2214a = new byte[][]{bArrA3};
            artVar.c = 2;
            bArrA = aus.a(artVar);
        } else {
            Vector<byte[]> vectorA = a(bArrA2, 255);
            if (vectorA == null || vectorA.size() == 0) {
                bArrA = a(aus.a(a(4096L)), str, true);
            } else {
                art artVar2 = new art();
                artVar2.f2214a = new byte[vectorA.size()][];
                Iterator<byte[]> it = vectorA.iterator();
                int i = 0;
                while (it.hasNext()) {
                    artVar2.f2214a[i] = a(it.next(), str, false);
                    i++;
                }
                artVar2.f2215b = a(bArrA2);
                bArrA = aus.a(artVar2);
            }
        }
        return atu.a(bArrA, true);
    }

    private static Vector<byte[]> a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static akp a(long j) {
        akp akpVar = new akp();
        akpVar.k = 4096L;
        return akpVar;
    }

    private static byte[] a(byte[] bArr, String str, boolean z) {
        byte[] bArrArray;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = aus.a(a(4096L));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(a(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        for (awl awlVar : new awi().cN) {
            awlVar.a(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new ape(str.getBytes("UTF-8")).a(bArr3);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArrDigest;
        synchronized (d) {
            MessageDigest messageDigestB = b();
            if (messageDigestB == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            messageDigestB.reset();
            messageDigestB.update(bArr);
            bArrDigest = c.digest();
        }
        return bArrDigest;
    }
}
