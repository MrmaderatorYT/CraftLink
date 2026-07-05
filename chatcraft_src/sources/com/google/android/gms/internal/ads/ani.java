package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public enum ani implements arb {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    private static final arc<ani> g = new arc<ani>() { // from class: com.google.android.gms.internal.ads.anj
    };
    private final int h;

    @Override // com.google.android.gms.internal.ads.arb
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static ani a(int i2) {
        switch (i2) {
            case 0:
                return UNKNOWN_PREFIX;
            case 1:
                return TINK;
            case 2:
                return LEGACY;
            case 3:
                return RAW;
            case 4:
                return CRUNCHY;
            default:
                return null;
        }
    }

    ani(int i2) {
        this.h = i2;
    }
}
