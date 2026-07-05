package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.acu;
import com.google.android.gms.internal.ads.adc;
import com.google.android.gms.internal.ads.aeq;
import com.google.android.gms.internal.ads.afe;
import com.google.android.gms.internal.ads.box;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.vq;
import com.google.android.gms.internal.ads.vr;
import com.google.android.gms.internal.ads.vw;

@qj
/* loaded from: classes.dex */
public final class bt {

    /* renamed from: a, reason: collision with root package name */
    public final afe f1565a;

    /* renamed from: b, reason: collision with root package name */
    public final acu f1566b;
    public final vw c;
    public final box d;

    private bt(afe afeVar, acu acuVar, vw vwVar, box boxVar) {
        this.f1565a = afeVar;
        this.f1566b = acuVar;
        this.c = vwVar;
        this.d = boxVar;
    }

    public static bt a(Context context) {
        return new bt(new aeq(), new adc(), new vq(new vr()), new box(context));
    }
}
