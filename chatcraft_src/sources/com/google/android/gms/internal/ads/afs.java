package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* loaded from: classes.dex */
final class afs implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f1938a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ EditText f1939b;

    afs(JsPromptResult jsPromptResult, EditText editText) {
        this.f1938a = jsPromptResult;
        this.f1939b = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1938a.confirm(this.f1939b.getText().toString());
    }
}
