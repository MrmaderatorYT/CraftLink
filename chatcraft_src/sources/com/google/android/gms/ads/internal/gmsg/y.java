package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.afu;
import java.util.Map;

/* loaded from: classes.dex */
final class y implements ac<afu> {
    y() {
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        afu afuVar2 = afuVar;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            afuVar2.h_();
        } else if ("resume".equals(str)) {
            afuVar2.i_();
        }
    }
}
