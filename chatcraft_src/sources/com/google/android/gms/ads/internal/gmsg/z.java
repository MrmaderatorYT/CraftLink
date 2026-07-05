package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.afu;
import java.util.Map;

/* loaded from: classes.dex */
final class z implements ac<afu> {
    z() {
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        afu afuVar2 = afuVar;
        if (map.keySet().contains("start")) {
            afuVar2.w().h();
        } else if (map.keySet().contains("stop")) {
            afuVar2.w().i();
        } else if (map.keySet().contains("cancel")) {
            afuVar2.w().j();
        }
    }
}
