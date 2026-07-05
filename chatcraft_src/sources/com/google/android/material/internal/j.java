package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* compiled from: VisibilityAwareImageButton.java */
/* loaded from: classes.dex */
public class j extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    private int f3838a;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3838a = getVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f3838a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f3838a;
    }
}
