package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class af extends m.b {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ Bundle d;
    private final /* synthetic */ m.c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    af(m.c cVar, Activity activity, Bundle bundle) {
        super(m.this);
        this.e = cVar;
        this.c = activity;
        this.d = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        m.this.j.a(com.google.android.gms.dynamic.b.a(this.c), this.d, this.f3701b);
    }
}
