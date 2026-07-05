package com.google.android.gms.internal.ads;

import java.util.UUID;

/* loaded from: classes.dex */
public final class azo {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2424a;

    /* renamed from: b, reason: collision with root package name */
    public static final UUID f2425b;
    public static final UUID c;
    private static final UUID d;
    private static final UUID e;

    public static long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j / 1000;
    }

    public static long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j * 1000;
    }

    static {
        f2424a = bkg.f2760a < 23 ? 1020 : 6396;
        f2425b = new UUID(0L, 0L);
        d = new UUID(1186680826959645954L, -5988876978535335093L);
        e = new UUID(-1301668207276963122L, -6645017420763422227L);
        c = new UUID(-7348484286925749626L, -6083546864340672619L);
    }
}
