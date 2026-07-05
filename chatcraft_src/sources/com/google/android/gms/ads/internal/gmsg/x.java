package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.afu;
import java.util.Map;

/* loaded from: classes.dex */
final class x implements ac<afu> {
    x() {
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        afuVar.d(!Boolean.parseBoolean((String) map.get("disabled")));
    }
}
