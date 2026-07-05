package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.m;

/* loaded from: classes.dex */
final class z extends m.b {
    private final /* synthetic */ int c = 5;
    private final /* synthetic */ String d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ Object f;
    private final /* synthetic */ Object g;
    private final /* synthetic */ m h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    z(m mVar, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.h = mVar;
        this.d = str;
        this.e = obj;
        this.f = obj2;
        this.g = obj3;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    final void b() {
        this.h.j.a(this.c, this.d, com.google.android.gms.dynamic.b.a(this.e), com.google.android.gms.dynamic.b.a(this.f), com.google.android.gms.dynamic.b.a(this.g));
    }
}
