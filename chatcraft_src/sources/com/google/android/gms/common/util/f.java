package com.google.android.gms.common.util;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final f f1754a = new f();

    public static c d() {
        return f1754a;
    }

    @Override // com.google.android.gms.common.util.c
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.c
    public long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.c
    public long c() {
        return System.nanoTime();
    }

    private f() {
    }
}
