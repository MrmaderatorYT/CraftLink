package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class oi {
    public static yi a(Context context, com.google.android.gms.ads.internal.a aVar, wl wlVar, axe axeVar, afu afuVar, kk kkVar, oj ojVar, ac acVar) {
        rm rmVar = wlVar.f3546b;
        yi ooVar = rmVar.g ? new oo(context, wlVar, kkVar, ojVar, acVar, afuVar) : (rmVar.s || (aVar instanceof com.google.android.gms.ads.internal.ad)) ? (rmVar.s && (aVar instanceof com.google.android.gms.ads.internal.ad)) ? new oq(context, (com.google.android.gms.ads.internal.ad) aVar, wlVar, axeVar, ojVar, acVar) : new ol(wlVar, ojVar) : (!com.google.android.gms.common.util.j.f() || com.google.android.gms.common.util.j.h() || afuVar == null || !afuVar.u().e()) ? new ok(context, wlVar, afuVar, ojVar) : new on(context, wlVar, afuVar, ojVar);
        String strValueOf = String.valueOf(ooVar.getClass().getName());
        xe.b(strValueOf.length() != 0 ? "AdRenderer: ".concat(strValueOf) : new String("AdRenderer: "));
        ooVar.c();
        return ooVar;
    }
}
