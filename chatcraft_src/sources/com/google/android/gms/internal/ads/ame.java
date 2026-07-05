package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public enum ame implements arb {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);

    private static final arc<ame> f = new arc<ame>() { // from class: com.google.android.gms.internal.ads.amf
    };
    private final int g;

    @Override // com.google.android.gms.internal.ads.arb
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.g;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static ame a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
            default:
                return null;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
        }
    }

    ame(int i) {
        this.g = i;
    }
}
