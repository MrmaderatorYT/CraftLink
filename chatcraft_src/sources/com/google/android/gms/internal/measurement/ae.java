package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class ae extends m.b {
    private final /* synthetic */ Bundle c;
    private final /* synthetic */ m d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ae(m mVar, Bundle bundle) {
        super(mVar);
        this.d = mVar;
        this.c = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.d.j.a(this.c, this.f3700a);
    }
}
