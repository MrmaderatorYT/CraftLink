package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class q extends m.b {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ m f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q(m mVar, Activity activity, String str, String str2) {
        super(mVar);
        this.f = mVar;
        this.c = activity;
        this.d = str;
        this.e = str2;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.f.j.a(com.google.android.gms.dynamic.b.a(this.c), this.d, this.e, this.f3700a);
    }
}
