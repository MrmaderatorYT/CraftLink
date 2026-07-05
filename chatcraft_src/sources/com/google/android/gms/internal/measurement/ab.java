package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class ab extends m.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ m.a d;
    private final /* synthetic */ m e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ab(m mVar, String str, m.a aVar) {
        super(mVar);
        this.e = mVar;
        this.c = str;
        this.d = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.e.j.a(this.c, this.d);
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    protected final void a() {
        this.d.a((Bundle) null);
    }
}
