package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.a;
import androidx.appcompat.widget.m;
import androidx.core.g.q;

/* loaded from: classes.dex */
public class CheckableImageButton extends m implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3816a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    private boolean f3817b;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        q.a(this, new androidx.core.g.a() { // from class: com.google.android.material.internal.CheckableImageButton.1
            @Override // androidx.core.g.a
            public void d(View view, AccessibilityEvent accessibilityEvent) {
                super.d(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            @Override // androidx.core.g.a
            public void a(View view, androidx.core.g.a.c cVar) {
                super.a(view, cVar);
                cVar.a(true);
                cVar.b(CheckableImageButton.this.isChecked());
            }
        });
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f3817b != z) {
            this.f3817b = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f3817b;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f3817b);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.f3817b) {
            return mergeDrawableStates(super.onCreateDrawableState(i + f3816a.length), f3816a);
        }
        return super.onCreateDrawableState(i);
    }
}
