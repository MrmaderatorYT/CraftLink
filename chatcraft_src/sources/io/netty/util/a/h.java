package io.netty.util.a;

/* compiled from: MathUtil.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4685a = !h.class.desiredAssertionStatus();

    public static boolean a(int i, int i2, int i3) {
        int i4 = i | i2;
        int i5 = i + i2;
        return ((i4 | i5) | (i3 - i5)) < 0;
    }

    private h() {
    }

    public static int a(int i) {
        if (f4685a || (i > Integer.MIN_VALUE && i < 1073741824)) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        }
        throw new AssertionError();
    }

    public static int b(int i) {
        if (i <= 0) {
            return 1;
        }
        if (i >= 1073741824) {
            return 1073741824;
        }
        return a(i);
    }
}
