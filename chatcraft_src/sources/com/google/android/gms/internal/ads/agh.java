package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes.dex */
final class agh implements com.google.android.gms.ads.internal.gmsg.ac<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ agg f1960a;

    agh(agg aggVar) {
        this.f1960a = aggVar;
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
                synchronized (this.f1960a) {
                    if (this.f1960a.C != i) {
                        this.f1960a.C = i;
                        this.f1960a.requestLayout();
                    }
                }
            } catch (Exception e) {
                xe.c("Exception occurred while getting webview content height", e);
            }
        }
    }
}
