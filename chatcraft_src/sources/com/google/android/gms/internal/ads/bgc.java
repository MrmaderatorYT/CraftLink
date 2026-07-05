package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bgc extends baj {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f2634b = new Object();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final boolean g;
    private final boolean h;

    public bgc(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final int b() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final int c() {
        return 1;
    }

    private bgc(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.c = j;
        this.d = j2;
        this.e = 0L;
        this.f = 0L;
        this.g = z;
        this.h = false;
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final bam a(int i, bam bamVar, boolean z, long j) {
        bjq.a(i, 0, 1);
        return bamVar.a(null, -9223372036854775807L, -9223372036854775807L, this.g, false, 0L, this.d, 0, 0, 0L);
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final bal a(int i, bal balVar, boolean z) {
        bjq.a(i, 0, 1);
        Object obj = z ? f2634b : null;
        return balVar.a(obj, obj, 0, this.c, 0L, false);
    }

    @Override // com.google.android.gms.internal.ads.baj
    public final int a(Object obj) {
        return f2634b.equals(obj) ? 0 : -1;
    }
}
