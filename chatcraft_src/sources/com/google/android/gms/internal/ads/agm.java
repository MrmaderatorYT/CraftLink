package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import com.google.android.gms.internal.ads.agq;
import com.google.android.gms.internal.ads.agy;
import com.google.android.gms.internal.ads.aha;

@qj
@TargetApi(17)
/* loaded from: classes.dex */
public final class agm<WebViewT extends agq & agy & aha> {

    /* renamed from: a, reason: collision with root package name */
    private final agp f1968a;

    /* renamed from: b, reason: collision with root package name */
    private final WebViewT f1969b;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.ago, com.google.android.gms.internal.ads.agp] */
    public static agm<afu> a(final afu afuVar) {
        return new agm<>(afuVar, new Object(afuVar) { // from class: com.google.android.gms.internal.ads.ago

            /* renamed from: a, reason: collision with root package name */
            private final afu f1972a;

            {
                this.f1972a = afuVar;
            }
        });
    }

    private agm(WebViewT webviewt, agp agpVar) {
        this.f1968a = agpVar;
        this.f1969b = webviewt;
    }
}
