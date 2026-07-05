package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
public final class blo implements bmu {

    /* renamed from: a, reason: collision with root package name */
    private final View f2811a;

    /* renamed from: b, reason: collision with root package name */
    private final wk f2812b;

    public blo(View view, wk wkVar) {
        this.f2811a = view;
        this.f2812b = wkVar;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final bmu c() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final View a() {
        return this.f2811a;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final boolean b() {
        return this.f2812b == null || this.f2811a == null;
    }
}
