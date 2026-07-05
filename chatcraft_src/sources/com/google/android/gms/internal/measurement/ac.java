package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class ac extends m.b {
    private final /* synthetic */ Long c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ Bundle f;
    private final /* synthetic */ boolean g = true;
    private final /* synthetic */ boolean h;
    private final /* synthetic */ m i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ac(m mVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(mVar);
        this.i = mVar;
        this.c = l;
        this.d = str;
        this.e = str2;
        this.f = bundle;
        this.h = z2;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.i.j.a(this.d, this.e, this.f, this.g, this.h, this.c == null ? this.f3700a : this.c.longValue());
    }
}
