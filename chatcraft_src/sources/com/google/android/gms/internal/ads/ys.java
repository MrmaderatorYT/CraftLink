package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;

/* loaded from: classes.dex */
final class ys implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ yr f3614a;

    ys(yr yrVar) {
        this.f3614a = yrVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.ax.e();
        xn.a(this.f3614a.f3612a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
