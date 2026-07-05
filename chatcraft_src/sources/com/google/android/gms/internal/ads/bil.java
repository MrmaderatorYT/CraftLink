package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class bil extends bio {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2702a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private final bis f2703b;
    private final AtomicReference<bim> c;

    public bil() {
        this(null);
    }

    private static int a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean b(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    private bil(bis bisVar) {
        this.f2703b = null;
        this.c = new AtomicReference<>(new bim());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:129:0x0266. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x01e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b4  */
    @Override // com.google.android.gms.internal.ads.bio
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.google.android.gms.internal.ads.bir[] a(com.google.android.gms.internal.ads.bah[] r47, com.google.android.gms.internal.ads.bgf[] r48, int[][][] r49) {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bil.a(com.google.android.gms.internal.ads.bah[], com.google.android.gms.internal.ads.bgf[], int[][][]):com.google.android.gms.internal.ads.bir[]");
    }

    private static boolean a(bab babVar, String str) {
        return str != null && TextUtils.equals(str, bkg.b(babVar.s));
    }
}
