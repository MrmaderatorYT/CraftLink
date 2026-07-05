package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class akk {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f2033a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f2034b;
    static final /* synthetic */ int[] c = new int[aln.values().length];

    static {
        try {
            c[aln.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            c[aln.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            c[aln.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f2034b = new int[amc.values().length];
        try {
            f2034b[amc.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f2034b[amc.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f2034b[amc.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        f2033a = new int[ame.values().length];
        try {
            f2033a[ame.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f2033a[ame.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f2033a[ame.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
