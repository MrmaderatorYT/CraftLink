package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class p extends m.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ m.a e;
    private final /* synthetic */ m f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    p(m mVar, String str, String str2, m.a aVar) {
        super(mVar);
        this.f = mVar;
        this.c = str;
        this.d = str2;
        this.e = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.f.j.a(this.c, this.d, this.e);
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    protected final void a() {
        this.e.a((Bundle) null);
    }
}
