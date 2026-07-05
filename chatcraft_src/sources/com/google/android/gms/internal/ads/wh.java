package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

@qj
/* loaded from: classes.dex */
public final class wh implements wj {
    @Override // com.google.android.gms.internal.ads.wj
    public final abl<String> a(String str, PackageInfo packageInfo) {
        return aaz.a(str);
    }

    @Override // com.google.android.gms.internal.ads.wj
    public final abl<AdvertisingIdClient.Info> a(Context context) {
        abv abvVar = new abv();
        bra.a();
        if (aac.c(context)) {
            xl.a(new wi(this, context, abvVar));
        }
        return abvVar;
    }
}
