package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class apj {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f2143a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f2144b;

    static boolean a() {
        return (f2143a == null || f2144b) ? false : true;
    }

    static Class<?> b() {
        return f2143a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        f2144b = a("org.robolectric.Robolectric") != null;
    }
}
