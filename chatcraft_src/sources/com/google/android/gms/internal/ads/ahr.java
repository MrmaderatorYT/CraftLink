package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes.dex */
final class ahr implements com.google.android.gms.ads.internal.gmsg.ac<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ahq f1992a;

    ahr(ahq ahqVar) {
        this.f1992a = ahqVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) throws NumberFormatException {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i = Integer.parseInt(str);
                synchronized (this.f1992a) {
                    if (this.f1992a.v != i) {
                        this.f1992a.v = i;
                        this.f1992a.requestLayout();
                    }
                }
            } catch (Exception e) {
                xe.c("Exception occurred while getting webview content height", e);
            }
        }
    }
}
