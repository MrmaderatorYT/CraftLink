package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class asc {

    /* renamed from: a, reason: collision with root package name */
    private static final asa f2225a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final asa f2226b = new asb();

    static asa a() {
        return f2225a;
    }

    static asa b() {
        return f2226b;
    }

    private static asa c() {
        try {
            return (asa) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
