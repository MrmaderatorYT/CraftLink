package io.netty.util.a.c.a.a.b;

/* compiled from: Pow2.java */
/* loaded from: classes.dex */
public final class b {
    public static int a(int i) {
        if (i > 1073741824) {
            throw new IllegalArgumentException("There is no larger power of 2 int for value:" + i + " since it exceeds 2^31.");
        }
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
