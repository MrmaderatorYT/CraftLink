package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes.dex */
final class afm implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsResult f1932a;

    afm(JsResult jsResult) {
        this.f1932a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f1932a.cancel();
    }
}
