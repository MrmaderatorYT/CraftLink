package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(18)
/* loaded from: classes.dex */
public class yc extends yb {
    @Override // com.google.android.gms.internal.ads.xv
    public final int c() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public boolean a(View view) {
        return super.a(view) || view.getWindowId() != null;
    }
}
