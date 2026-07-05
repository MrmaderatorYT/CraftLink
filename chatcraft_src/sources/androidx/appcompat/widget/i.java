package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.a;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f410a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f411b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    i(CompoundButton compoundButton) {
        this.f410a = compoundButton;
    }

    void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f410a.getContext().obtainStyledAttributes(attributeSet, a.j.CompoundButton, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(a.j.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(a.j.CompoundButton_android_button, 0)) != 0) {
                this.f410a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f410a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(a.j.CompoundButton_buttonTint)) {
                androidx.core.widget.c.a(this.f410a, typedArrayObtainStyledAttributes.getColorStateList(a.j.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(a.j.CompoundButton_buttonTintMode)) {
                androidx.core.widget.c.a(this.f410a, ab.a(typedArrayObtainStyledAttributes.getInt(a.j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    void a(ColorStateList colorStateList) {
        this.f411b = colorStateList;
        this.d = true;
        d();
    }

    ColorStateList a() {
        return this.f411b;
    }

    void a(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        d();
    }

    PorterDuff.Mode b() {
        return this.c;
    }

    void c() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            d();
        }
    }

    void d() {
        Drawable drawableA = androidx.core.widget.c.a(this.f410a);
        if (drawableA != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.g(drawableA).mutate();
                if (this.d) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, this.f411b);
                }
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f410a.getDrawableState());
                }
                this.f410a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int a(int i) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = androidx.core.widget.c.a(this.f410a)) == null) ? i : i + drawableA.getIntrinsicWidth();
    }
}
