package com.google.android.gms.internal.ads;

import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public enum auj {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(BuildConfig.FLAVOR),
    BYTE_STRING(apo.f2149a),
    ENUM(null),
    MESSAGE(null);

    private final Object j;

    auj(Object obj) {
        this.j = obj;
    }
}
