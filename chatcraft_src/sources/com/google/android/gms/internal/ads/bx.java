package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
final class bx implements bd {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f3041a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bv f3042b;

    bx(bv bvVar, View view) {
        this.f3042b = bvVar;
        this.f3041a = view;
    }

    @Override // com.google.android.gms.internal.ads.bd
    public final void a() {
        if (this.f3042b.a(bv.f3037a)) {
            this.f3042b.onClick(this.f3041a);
        }
    }

    @Override // com.google.android.gms.internal.ads.bd
    public final void a(MotionEvent motionEvent) {
        this.f3042b.onTouch(null, motionEvent);
    }
}
