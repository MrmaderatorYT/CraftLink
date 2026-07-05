package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* loaded from: classes.dex */
final class yr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3612a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3613b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ boolean d;

    yr(yq yqVar, Context context, String str, boolean z, boolean z2) {
        this.f3612a = context;
        this.f3613b = str;
        this.c = z;
        this.d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f3612a);
        builder.setMessage(this.f3613b);
        if (this.c) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.d) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new ys(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
