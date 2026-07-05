package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class ara {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2200b;
    private static final ByteBuffer d;
    private static final aqa e;

    /* renamed from: a, reason: collision with root package name */
    static final Charset f2199a = Charset.forName("UTF-8");
    private static final Charset c = Charset.forName("ISO-8859-1");

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    static boolean a(asf asfVar) {
        return false;
    }

    static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(byte[] bArr) {
        return atx.a(bArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f2199a);
    }

    public static int c(byte[] bArr) {
        int length = bArr.length;
        int iA = a(length, bArr, 0, length);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static Object a(Object obj, Object obj2) {
        return ((asf) obj).o().a((asf) obj2).e();
    }

    static {
        byte[] bArr = new byte[0];
        f2200b = bArr;
        d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = f2200b;
        e = aqa.a(bArr2, 0, bArr2.length, false);
    }
}
