package io.netty.util;

/* compiled from: ReferenceCountUtil.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4782a = io.netty.util.a.b.d.a((Class<?>) m.class);

    public static <T> T a(T t, Object obj) {
        return t instanceof n ? (T) ((n) t).b(obj) : t;
    }

    public static boolean a(Object obj) {
        if (obj instanceof n) {
            return ((n) obj).D();
        }
        return false;
    }

    public static void b(Object obj) {
        try {
            a(obj);
        } catch (Throwable th) {
            f4782a.c("Failed to release a message: {}", obj, th);
        }
    }

    private m() {
    }
}
