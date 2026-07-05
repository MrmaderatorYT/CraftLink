package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public enum amc implements arb {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);

    private static final arc<amc> f = new arc<amc>() { // from class: com.google.android.gms.internal.ads.amd
    };
    private final int g;

    @Override // com.google.android.gms.internal.ads.arb
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.g;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static amc a(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        switch (i) {
            case 2:
                return NIST_P256;
            case 3:
                return NIST_P384;
            case 4:
                return NIST_P521;
            default:
                return null;
        }
    }

    amc(int i) {
        this.g = i;
    }
}
