package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class asp {

    /* renamed from: a, reason: collision with root package name */
    private static final asn f2232a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final asn f2233b = new aso();

    static asn a() {
        return f2232a;
    }

    static asn b() {
        return f2233b;
    }

    private static asn c() {
        try {
            return (asn) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
