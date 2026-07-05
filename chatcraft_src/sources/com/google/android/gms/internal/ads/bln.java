package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
public final class bln implements bmu {

    /* renamed from: a, reason: collision with root package name */
    private bf f2810a;

    public bln(bf bfVar) {
        this.f2810a = bfVar;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final bmu c() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final View a() {
        if (this.f2810a != null) {
            return this.f2810a.o();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final boolean b() {
        return this.f2810a == null;
    }
}
