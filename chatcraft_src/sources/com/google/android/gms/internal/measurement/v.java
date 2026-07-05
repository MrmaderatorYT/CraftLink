package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class v extends m.b {
    private final /* synthetic */ m.a c;
    private final /* synthetic */ m d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v(m mVar, m.a aVar) {
        super(mVar);
        this.d = mVar;
        this.c = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.d.j.f(this.c);
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    protected final void a() {
        this.c.a((Bundle) null);
    }
}
