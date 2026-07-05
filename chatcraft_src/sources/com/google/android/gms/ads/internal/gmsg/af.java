package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class af implements ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final ag f1589a;

    public af(ag agVar) {
        this.f1589a = agVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) throws NumberFormatException {
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat(map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            xe.b("Fail to parse float", e);
        }
        this.f1589a.a(zEquals);
        this.f1589a.a(zEquals2, f);
    }
}
