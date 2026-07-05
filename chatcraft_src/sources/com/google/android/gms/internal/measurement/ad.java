package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class ad extends m.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ boolean f = true;
    private final /* synthetic */ m g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ad(m mVar, String str, String str2, Object obj, boolean z) {
        super(mVar);
        this.g = mVar;
        this.c = str;
        this.d = str2;
        this.e = obj;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.g.j.a(this.c, this.d, com.google.android.gms.dynamic.b.a(this.e), this.f, this.f3700a);
    }
}
