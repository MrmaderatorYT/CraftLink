package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class y extends m.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ m.a f;
    private final /* synthetic */ m g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    y(m mVar, String str, String str2, boolean z, m.a aVar) {
        super(mVar);
        this.g = mVar;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.g.j.a(this.c, this.d, this.e, this.f);
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    protected final void a() {
        this.f.a((Bundle) null);
    }
}
