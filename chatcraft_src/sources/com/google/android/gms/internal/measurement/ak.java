package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class ak extends m.b {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ m.a d;
    private final /* synthetic */ m.c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ak(m.c cVar, Activity activity, m.a aVar) {
        super(m.this);
        this.e = cVar;
        this.c = activity;
        this.d = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        m.this.j.a(com.google.android.gms.dynamic.b.a(this.c), this.d, this.f3701b);
    }
}
