package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.xe;
import java.util.Map;

/* loaded from: classes.dex */
final class v implements ac<Object> {
    v() {
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        String strValueOf = String.valueOf(map.get("string"));
        xe.d(strValueOf.length() != 0 ? "Received log message: ".concat(strValueOf) : new String("Received log message: "));
    }
}
