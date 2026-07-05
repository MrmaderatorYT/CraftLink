package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
final class bu implements bd {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f3031a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bt f3032b;

    bu(bt btVar, View view) {
        this.f3032b = btVar;
        this.f3031a = view;
    }

    @Override // com.google.android.gms.internal.ads.bd
    public final void a() {
        this.f3032b.onClick(this.f3031a);
    }

    @Override // com.google.android.gms.internal.ads.bd
    public final void a(MotionEvent motionEvent) {
        this.f3032b.onTouch(null, motionEvent);
    }
}
