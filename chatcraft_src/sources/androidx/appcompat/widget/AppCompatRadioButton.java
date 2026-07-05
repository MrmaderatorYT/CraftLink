package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements androidx.core.widget.j {

    /* renamed from: a, reason: collision with root package name */
    private final i f277a;

    /* renamed from: b, reason: collision with root package name */
    private final w f278b;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(ap.a(context), attributeSet, i);
        this.f277a = new i(this);
        this.f277a.a(attributeSet, i);
        this.f278b = new w(this);
        this.f278b.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f277a != null) {
            this.f277a.c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f277a != null ? this.f277a.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f277a != null) {
            this.f277a.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f277a != null) {
            return this.f277a.a();
        }
        return null;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f277a != null) {
            this.f277a.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f277a != null) {
            return this.f277a.b();
        }
        return null;
    }
}
