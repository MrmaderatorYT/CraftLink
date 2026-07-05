package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;

/* loaded from: classes.dex */
final class t implements ac<afu> {
    t() {
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        afu afuVar2 = afuVar;
        com.google.android.gms.ads.internal.overlay.d dVarS = afuVar2.s();
        if (dVarS != null) {
            dVarS.a();
            return;
        }
        com.google.android.gms.ads.internal.overlay.d dVarT = afuVar2.t();
        if (dVarT != null) {
            dVarT.a();
        } else {
            xe.e("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
