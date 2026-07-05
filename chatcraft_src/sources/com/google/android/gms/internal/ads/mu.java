package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;

/* loaded from: classes.dex */
final class mu implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ mt f3279a;

    mu(mt mtVar) {
        this.f3279a = mtVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intentB = this.f3279a.b();
        com.google.android.gms.ads.internal.ax.e();
        xn.a(this.f3279a.f3278b, intentB);
    }
}
