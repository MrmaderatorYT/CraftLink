package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class aqj {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f2167a = c();

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static aqk a() {
        if (f2167a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return aqk.f2168a;
    }

    static aqk b() {
        aqk aqkVarA;
        if (f2167a != null) {
            try {
                aqkVarA = a("loadGeneratedRegistry");
            } catch (Exception unused) {
            }
        } else {
            aqkVarA = null;
        }
        if (aqkVarA == null) {
            aqkVarA = aqk.c();
        }
        return aqkVarA == null ? a() : aqkVarA;
    }

    private static final aqk a(String str) {
        return (aqk) f2167a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
