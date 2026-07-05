package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class aa extends m.b {
    private final /* synthetic */ Bundle c;
    private final /* synthetic */ m.a d;
    private final /* synthetic */ m e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aa(m mVar, Bundle bundle, m.a aVar) {
        super(mVar);
        this.e = mVar;
        this.c = bundle;
        this.d = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.e.j.a(this.c, this.d, this.f3700a);
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    protected final void a() {
        this.d.a((Bundle) null);
    }
}
