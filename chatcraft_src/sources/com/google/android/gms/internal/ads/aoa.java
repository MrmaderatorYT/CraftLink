package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class aoa {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f2108a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f2109b = new int[aob.values().length];

    static {
        try {
            f2109b[aob.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2109b[aob.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2109b[aob.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f2108a = new int[aoc.values().length];
        try {
            f2108a[aoc.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f2108a[aoc.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f2108a[aoc.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
