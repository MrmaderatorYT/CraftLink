package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class sm implements com.google.android.gms.ads.internal.gmsg.ac<Object> {
    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("request_id");
        String strValueOf = String.valueOf(map.get("errors"));
        xe.e(strValueOf.length() != 0 ? "Invalid request: ".concat(strValueOf) : new String("Invalid request: "));
        se.f.b(str);
    }
}
