package com.crashlytics.android.a;

import android.content.Context;
import java.util.UUID;

/* compiled from: SessionAnalyticsFilesManager.java */
/* loaded from: classes.dex */
class x extends io.fabric.sdk.android.services.c.b<ab> {
    private io.fabric.sdk.android.services.e.b g;

    x(Context context, ad adVar, io.fabric.sdk.android.services.b.k kVar, io.fabric.sdk.android.services.c.c cVar) {
        super(context, adVar, kVar, cVar, 100);
    }

    @Override // io.fabric.sdk.android.services.c.b
    protected String a() {
        return "sa_" + UUID.randomUUID().toString() + "_" + this.c.a() + ".tap";
    }

    @Override // io.fabric.sdk.android.services.c.b
    protected int b() {
        return this.g == null ? super.b() : this.g.e;
    }

    @Override // io.fabric.sdk.android.services.c.b
    protected int c() {
        return this.g == null ? super.c() : this.g.c;
    }

    void a(io.fabric.sdk.android.services.e.b bVar) {
        this.g = bVar;
    }
}
