package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;

@qj
/* loaded from: classes.dex */
public final class aeq implements afe {
    @Override // com.google.android.gms.internal.ads.afe
    public final aex a(adk adkVar, int i, String str, adj adjVar) {
        if (Build.VERSION.SDK_INT < 16 || i <= 0 || !Arrays.asList(adjVar.e.split(",")).contains("3")) {
            return new aff(adkVar);
        }
        int iC = aee.c();
        return iC < adjVar.h ? new afj(adkVar, adjVar) : iC < adjVar.f1867b ? new afi(adkVar, adjVar) : new afg(adkVar);
    }
}
