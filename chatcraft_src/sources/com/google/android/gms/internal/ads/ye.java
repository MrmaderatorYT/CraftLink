package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(19)
/* loaded from: classes.dex */
public class ye extends yc {
    @Override // com.google.android.gms.internal.ads.yc, com.google.android.gms.internal.ads.xv
    public final boolean a(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final ViewGroup.LayoutParams d() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
