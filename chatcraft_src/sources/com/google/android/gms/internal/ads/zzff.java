package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zzff extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final int f3666a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3667b;

    public static zzff a(Exception exc, int i) {
        return new zzff(1, null, exc, i);
    }

    public static zzff a(IOException iOException) {
        return new zzff(0, null, iOException, -1);
    }

    static zzff a(RuntimeException runtimeException) {
        return new zzff(2, null, runtimeException, -1);
    }

    private zzff(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.f3666a = i;
        this.f3667b = i2;
    }
}
