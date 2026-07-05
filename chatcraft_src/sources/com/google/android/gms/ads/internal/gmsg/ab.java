package com.google.android.gms.ads.internal.gmsg;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class ab implements ac<afu> {
    ab() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        afu afuVar2 = afuVar;
        WindowManager windowManager = (WindowManager) afuVar2.getContext().getSystemService("window");
        ax.e();
        DisplayMetrics displayMetricsA = xn.a(windowManager);
        int i = displayMetricsA.widthPixels;
        int i2 = displayMetricsA.heightPixels;
        int[] iArr = new int[2];
        HashMap map2 = new HashMap();
        ((View) afuVar2).getLocationInWindow(iArr);
        map2.put("xInPixels", Integer.valueOf(iArr[0]));
        map2.put("yInPixels", Integer.valueOf(iArr[1]));
        map2.put("windowWidthInPixels", Integer.valueOf(i));
        map2.put("windowHeightInPixels", Integer.valueOf(i2));
        afuVar2.a("locationReady", map2);
        xe.e("GET LOCATION COMPILED");
    }
}
