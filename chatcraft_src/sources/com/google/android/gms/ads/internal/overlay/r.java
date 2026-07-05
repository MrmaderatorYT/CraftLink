package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;

@qj
/* loaded from: classes.dex */
public final class r extends d {
    public r(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.d, com.google.android.gms.internal.ads.nm
    public final void a(Bundle bundle) {
        xe.a("AdOverlayParcel is null or does not contain valid overlay type.");
        this.d = 3;
        this.f1626a.finish();
    }
}
