package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public enum aln implements arb {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);

    private static final arc<aln> f = new arc<aln>() { // from class: com.google.android.gms.internal.ads.alo
    };
    private final int g;

    @Override // com.google.android.gms.internal.ads.arb
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.g;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static aln a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return UNCOMPRESSED;
            case 2:
                return COMPRESSED;
            case 3:
                return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            default:
                return null;
        }
    }

    aln(int i) {
        this.g = i;
    }
}
