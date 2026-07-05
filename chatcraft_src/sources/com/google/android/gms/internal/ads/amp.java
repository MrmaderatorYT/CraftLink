package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public enum amp implements arb {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);

    private static final arc<amp> f = new arc<amp>() { // from class: com.google.android.gms.internal.ads.amq
    };
    private final int g;

    @Override // com.google.android.gms.internal.ads.arb
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.g;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static amp a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
            default:
                return null;
        }
    }

    amp(int i) {
        this.g = i;
    }
}
