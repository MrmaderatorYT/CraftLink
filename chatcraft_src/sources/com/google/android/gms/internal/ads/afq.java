package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes.dex */
final class afq implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f1936a;

    afq(JsPromptResult jsPromptResult) {
        this.f1936a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f1936a.cancel();
    }
}
