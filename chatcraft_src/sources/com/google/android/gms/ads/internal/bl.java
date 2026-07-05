package com.google.android.gms.ads.internal;

import android.view.View;

/* loaded from: classes.dex */
final class bl implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bu f1554a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bi f1555b;

    bl(bi biVar, bu buVar) {
        this.f1555b = biVar;
        this.f1554a = buVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1554a.a();
        if (this.f1555b.f1550b != null) {
            this.f1555b.f1550b.c();
        }
    }
}
