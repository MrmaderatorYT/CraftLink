package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class aqn {

    /* renamed from: a, reason: collision with root package name */
    private static final aql<?> f2172a = new aqm();

    /* renamed from: b, reason: collision with root package name */
    private static final aql<?> f2173b = c();

    private static aql<?> c() {
        try {
            return (aql) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static aql<?> a() {
        return f2172a;
    }

    static aql<?> b() {
        if (f2173b == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return f2173b;
    }
}
