package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class o extends m.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Bundle e;
    private final /* synthetic */ m f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    o(m mVar, String str, String str2, Bundle bundle) {
        super(mVar);
        this.f = mVar;
        this.c = str;
        this.d = str2;
        this.e = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.f.j.a(this.c, this.d, this.e);
    }
}
