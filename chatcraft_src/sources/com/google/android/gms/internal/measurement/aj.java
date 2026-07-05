package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class aj extends m.b {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ m.c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aj(m.c cVar, Activity activity) {
        super(m.this);
        this.d = cVar;
        this.c = activity;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        m.this.j.b(com.google.android.gms.dynamic.b.a(this.c), this.f3701b);
    }
}
