package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.util.Arrays;

@qj
/* loaded from: classes.dex */
public final class adc extends acu {
    @Override // com.google.android.gms.internal.ads.acu
    public final act a(Context context, adk adkVar, int i, boolean z, ac acVar, adj adjVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(com.google.android.gms.common.util.j.a() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11))) {
            return null;
        }
        adm admVar = new adm(context, adkVar.k(), adkVar.g(), acVar, adkVar.c());
        if ((Build.VERSION.SDK_INT >= 16 && i == 2) && Arrays.asList(adjVar.e.split(",")).contains("3")) {
            return new adq(context, admVar, adkVar, z, a(adkVar), adjVar);
        }
        return new ach(context, z, a(adkVar), adjVar, new adm(context, adkVar.k(), adkVar.g(), acVar, adkVar.c()));
    }
}
