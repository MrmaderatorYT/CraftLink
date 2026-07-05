package com.google.android.gms.internal.ads;

import android.content.Context;

@qj
/* loaded from: classes.dex */
public final class xc {
    public static void a(Context context) {
        if (aag.a(context) && !aag.b()) {
            abl ablVar = (abl) new xd(context).c();
            xe.d("Updating ad debug logging enablement.");
            aax.a(ablVar, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
