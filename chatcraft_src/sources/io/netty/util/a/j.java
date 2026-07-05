package io.netty.util.a;

/* compiled from: ObjectUtil.java */
/* loaded from: classes.dex */
public final class j {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: >= 0)");
    }

    public static long a(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + ": " + j + " (expected: >= 0)");
    }
}
