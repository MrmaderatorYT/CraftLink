package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
final class aqx implements ase {

    /* renamed from: a, reason: collision with root package name */
    private static final aqx f2189a = new aqx();

    private aqx() {
    }

    public static aqx a() {
        return f2189a;
    }

    @Override // com.google.android.gms.internal.ads.ase
    public final boolean a(Class<?> cls) {
        return aqy.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.ase
    public final asd b(Class<?> cls) {
        if (!aqy.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (asd) aqy.a(cls.asSubclass(aqy.class)).a(aqy.e.c, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
