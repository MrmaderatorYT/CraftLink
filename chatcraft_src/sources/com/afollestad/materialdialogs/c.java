package com.afollestad.materialdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.internal.MDRootLayout;

/* compiled from: DialogBase.java */
/* loaded from: classes.dex */
class c extends Dialog implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    protected MDRootLayout f1204a;

    /* renamed from: b, reason: collision with root package name */
    private DialogInterface.OnShowListener f1205b;

    c(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    public View findViewById(int i) {
        return this.f1204a.findViewById(i);
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f1205b = onShowListener;
    }

    final void a() {
        super.setOnShowListener(this);
    }

    final void a(View view) {
        super.setContentView(view);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        if (this.f1205b != null) {
            this.f1205b.onShow(dialogInterface);
        }
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(int i) {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(View view) {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }
}
