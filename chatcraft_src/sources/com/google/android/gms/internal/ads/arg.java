package com.google.android.gms.internal.ads;

import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public enum arg {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, BuildConfig.FLAVOR),
    BYTE_STRING(apo.class, apo.class, apo.f2149a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> k;
    private final Class<?> l;
    private final Object m;

    arg(Class cls, Class cls2, Object obj) {
        this.k = cls;
        this.l = cls2;
        this.m = obj;
    }

    public final Class<?> a() {
        return this.l;
    }
}
