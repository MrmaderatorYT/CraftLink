package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager;

@TargetApi(9)
/* loaded from: classes.dex */
public class xx extends xv {
    public xx() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final int a() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final int b() {
        return 7;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public boolean a(DownloadManager.Request request) {
        request.setShowRunningNotification(true);
        return true;
    }
}
