package com.google.android.gms.internal.ads;

import android.os.Trace;

/* loaded from: classes.dex */
public final class bke {
    public static void a(String str) {
        if (bkg.f2760a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (bkg.f2760a >= 18) {
            Trace.endSection();
        }
    }
}
