package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;

@TargetApi(14)
/* loaded from: classes.dex */
public class ya extends xy {
    @Override // com.google.android.gms.internal.ads.xv
    public int f() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final String a(SslError sslError) {
        return sslError.getUrl();
    }
}
