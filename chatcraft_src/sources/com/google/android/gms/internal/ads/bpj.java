package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public enum bpj implements arb {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);

    private static final arc<bpj> d = new arc<bpj>() { // from class: com.google.android.gms.internal.ads.bpk
    };
    private final int e;

    @Override // com.google.android.gms.internal.ads.arb
    public final int a() {
        return this.e;
    }

    public static bpj a(int i) {
        if (i != 1000) {
            switch (i) {
                case 0:
                    return ENUM_FALSE;
                case 1:
                    return ENUM_TRUE;
                default:
                    return null;
            }
        }
        return ENUM_UNKNOWN;
    }

    public static ard b() {
        return bpl.f2942a;
    }

    bpj(int i) {
        this.e = i;
    }
}
