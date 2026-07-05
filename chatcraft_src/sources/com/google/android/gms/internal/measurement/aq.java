package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class aq {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f3689a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f3690b;

    static boolean a() {
        return (f3689a == null || f3690b) ? false : true;
    }

    static Class<?> b() {
        return f3689a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        f3690b = a("org.robolectric.Robolectric") != null;
    }
}
