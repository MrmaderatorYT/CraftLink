package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.as;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.x;
import androidx.core.g.q;
import com.google.android.material.a;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.d;
import com.google.android.material.internal.e;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private int A;
    private int B;
    private Drawable C;
    private final Rect D;
    private final RectF E;
    private Typeface F;
    private boolean G;
    private Drawable H;
    private CharSequence I;
    private CheckableImageButton J;
    private boolean K;
    private Drawable L;
    private Drawable M;
    private ColorStateList N;
    private boolean O;
    private PorterDuff.Mode P;
    private boolean Q;
    private ColorStateList R;
    private ColorStateList S;
    private final int T;
    private final int U;
    private int V;
    private final int W;

    /* renamed from: a, reason: collision with root package name */
    EditText f3869a;
    private boolean aa;
    private boolean ab;
    private ValueAnimator ac;
    private boolean ad;
    private boolean ae;
    private boolean af;

    /* renamed from: b, reason: collision with root package name */
    boolean f3870b;
    final com.google.android.material.internal.c c;
    private final FrameLayout d;
    private CharSequence e;
    private final com.google.android.material.textfield.b f;
    private int g;
    private boolean h;
    private TextView i;
    private final int j;
    private final int k;
    private boolean l;
    private CharSequence m;
    private boolean n;
    private GradientDrawable o;
    private final int p;
    private final int q;
    private int r;
    private final int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private int x;
    private final int y;
    private final int z;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new com.google.android.material.textfield.b(this);
        this.D = new Rect();
        this.E = new RectF();
        this.c = new com.google.android.material.internal.c(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.d = new FrameLayout(context);
        this.d.setAddStatesFromChildren(true);
        addView(this.d);
        this.c.a(com.google.android.material.a.a.f3705a);
        this.c.b(com.google.android.material.a.a.f3705a);
        this.c.b(8388659);
        as asVarB = h.b(context, attributeSet, a.k.TextInputLayout, i, a.j.Widget_Design_TextInputLayout, new int[0]);
        this.l = asVarB.a(a.k.TextInputLayout_hintEnabled, true);
        setHint(asVarB.c(a.k.TextInputLayout_android_hint));
        this.ab = asVarB.a(a.k.TextInputLayout_hintAnimationEnabled, true);
        this.p = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_bottom_offset);
        this.q = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_label_cutout_padding);
        this.s = asVarB.d(a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.t = asVarB.b(a.k.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.u = asVarB.b(a.k.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.v = asVarB.b(a.k.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.w = asVarB.b(a.k.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.B = asVarB.b(a.k.TextInputLayout_boxBackgroundColor, 0);
        this.V = asVarB.b(a.k.TextInputLayout_boxStrokeColor, 0);
        this.y = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_default);
        this.z = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_focused);
        this.x = this.y;
        setBoxBackgroundMode(asVarB.a(a.k.TextInputLayout_boxBackgroundMode, 0));
        if (asVarB.g(a.k.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListE = asVarB.e(a.k.TextInputLayout_android_textColorHint);
            this.S = colorStateListE;
            this.R = colorStateListE;
        }
        this.T = androidx.core.a.a.c(context, a.c.mtrl_textinput_default_box_stroke_color);
        this.W = androidx.core.a.a.c(context, a.c.mtrl_textinput_disabled_color);
        this.U = androidx.core.a.a.c(context, a.c.mtrl_textinput_hovered_box_stroke_color);
        if (asVarB.g(a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(asVarB.g(a.k.TextInputLayout_hintTextAppearance, 0));
        }
        int iG = asVarB.g(a.k.TextInputLayout_errorTextAppearance, 0);
        boolean zA = asVarB.a(a.k.TextInputLayout_errorEnabled, false);
        int iG2 = asVarB.g(a.k.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = asVarB.a(a.k.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceC = asVarB.c(a.k.TextInputLayout_helperText);
        boolean zA3 = asVarB.a(a.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(asVarB.a(a.k.TextInputLayout_counterMaxLength, -1));
        this.k = asVarB.g(a.k.TextInputLayout_counterTextAppearance, 0);
        this.j = asVarB.g(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.G = asVarB.a(a.k.TextInputLayout_passwordToggleEnabled, false);
        this.H = asVarB.a(a.k.TextInputLayout_passwordToggleDrawable);
        this.I = asVarB.c(a.k.TextInputLayout_passwordToggleContentDescription);
        if (asVarB.g(a.k.TextInputLayout_passwordToggleTint)) {
            this.O = true;
            this.N = asVarB.e(a.k.TextInputLayout_passwordToggleTint);
        }
        if (asVarB.g(a.k.TextInputLayout_passwordToggleTintMode)) {
            this.Q = true;
            this.P = i.a(asVarB.a(a.k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        asVarB.a();
        setHelperTextEnabled(zA2);
        setHelperText(charSequenceC);
        setHelperTextTextAppearance(iG2);
        setErrorEnabled(zA);
        setErrorTextAppearance(iG);
        setCounterEnabled(zA3);
        s();
        q.b(this, 2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.d.addView(view, layoutParams2);
            this.d.setLayoutParams(layoutParams);
            g();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private Drawable getBoxBackground() {
        if (this.r == 1 || this.r == 2) {
            return this.o;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.r) {
            return;
        }
        this.r = i;
        e();
    }

    private void e() {
        f();
        if (this.r != 0) {
            g();
        }
        h();
    }

    private void f() {
        if (this.r == 0) {
            this.o = null;
            return;
        }
        if (this.r == 2 && this.l && !(this.o instanceof com.google.android.material.textfield.a)) {
            this.o = new com.google.android.material.textfield.a();
        } else {
            if (this.o instanceof GradientDrawable) {
                return;
            }
            this.o = new GradientDrawable();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.V != i) {
            this.V = i;
            d();
        }
    }

    public int getBoxStrokeColor() {
        return this.V;
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(androidx.core.a.a.c(getContext(), i));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.B != i) {
            this.B = i;
            n();
        }
    }

    public int getBoxBackgroundColor() {
        return this.B;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.t;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.u;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.v;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.w;
    }

    private float[] getCornerRadiiAsArray() {
        if (!i.a(this)) {
            return new float[]{this.t, this.t, this.u, this.u, this.v, this.v, this.w, this.w};
        }
        return new float[]{this.u, this.u, this.t, this.t, this.w, this.w, this.v, this.v};
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.F) {
            this.F = typeface;
            this.c.a(typeface);
            this.f.a(typeface);
            if (this.i != null) {
                this.i.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.e == null || this.f3869a == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.n;
        this.n = false;
        CharSequence hint = this.f3869a.getHint();
        this.f3869a.setHint(this.e);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.f3869a.setHint(hint);
            this.n = z;
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3869a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof c)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f3869a = editText;
        e();
        setTextInputAccessibilityDelegate(new a(this));
        if (!q()) {
            this.c.a(this.f3869a.getTypeface());
        }
        this.c.a(this.f3869a.getTextSize());
        int gravity = this.f3869a.getGravity();
        this.c.b((gravity & (-113)) | 48);
        this.c.a(gravity);
        this.f3869a.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.a(!TextInputLayout.this.af);
                if (TextInputLayout.this.f3870b) {
                    TextInputLayout.this.a(editable.length());
                }
            }
        });
        if (this.R == null) {
            this.R = this.f3869a.getHintTextColors();
        }
        if (this.l) {
            if (TextUtils.isEmpty(this.m)) {
                this.e = this.f3869a.getHint();
                setHint(this.e);
                this.f3869a.setHint((CharSequence) null);
            }
            this.n = true;
        }
        if (this.i != null) {
            a(this.f3869a.getText().length());
        }
        this.f.d();
        p();
        a(false, true);
    }

    private void g() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        int iJ = j();
        if (iJ != layoutParams.topMargin) {
            layoutParams.topMargin = iJ;
            this.d.requestLayout();
        }
    }

    void a(boolean z) {
        a(z, false);
    }

    private void a(boolean z, boolean z2) {
        boolean zIsEnabled = isEnabled();
        boolean z3 = (this.f3869a == null || TextUtils.isEmpty(this.f3869a.getText())) ? false : true;
        boolean z4 = this.f3869a != null && this.f3869a.hasFocus();
        boolean zG = this.f.g();
        if (this.R != null) {
            this.c.a(this.R);
            this.c.b(this.R);
        }
        if (!zIsEnabled) {
            this.c.a(ColorStateList.valueOf(this.W));
            this.c.b(ColorStateList.valueOf(this.W));
        } else if (zG) {
            this.c.a(this.f.k());
        } else if (this.h && this.i != null) {
            this.c.a(this.i.getTextColors());
        } else if (z4 && this.S != null) {
            this.c.a(this.S);
        }
        if (z3 || (isEnabled() && (z4 || zG))) {
            if (z2 || this.aa) {
                c(z);
                return;
            }
            return;
        }
        if (z2 || !this.aa) {
            d(z);
        }
    }

    public EditText getEditText() {
        return this.f3869a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.l) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.m)) {
            return;
        }
        this.m = charSequence;
        this.c.a(charSequence);
        if (this.aa) {
            return;
        }
        u();
    }

    public CharSequence getHint() {
        if (this.l) {
            return this.m;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            if (!this.l) {
                this.n = false;
                if (!TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.f3869a.getHint())) {
                    this.f3869a.setHint(this.m);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f3869a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.m)) {
                        setHint(hint);
                    }
                    this.f3869a.setHint((CharSequence) null);
                }
                this.n = true;
            }
            if (this.f3869a != null) {
                g();
            }
        }
    }

    boolean a() {
        return this.n;
    }

    public void setHintTextAppearance(int i) {
        this.c.c(i);
        this.S = this.c.h();
        if (this.f3869a != null) {
            a(false);
            g();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.R = colorStateList;
        this.S = colorStateList;
        if (this.f3869a != null) {
            a(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.R;
    }

    public void setErrorEnabled(boolean z) {
        this.f.a(z);
    }

    public void setErrorTextAppearance(int i) {
        this.f.b(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f.a(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.f.j();
    }

    public void setHelperTextTextAppearance(int i) {
        this.f.c(i);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f.b(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (b()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!b()) {
                setHelperTextEnabled(true);
            }
            this.f.a(charSequence);
        }
    }

    public boolean b() {
        return this.f.f();
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f.b(colorStateList);
    }

    public int getHelperTextCurrentTextColor() {
        return this.f.l();
    }

    public void setError(CharSequence charSequence) {
        if (!this.f.e()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f.b(charSequence);
        } else {
            this.f.b();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.f3870b != z) {
            if (z) {
                this.i = new x(getContext());
                this.i.setId(a.f.textinput_counter);
                if (this.F != null) {
                    this.i.setTypeface(this.F);
                }
                this.i.setMaxLines(1);
                a(this.i, this.k);
                this.f.a(this.i, 2);
                if (this.f3869a == null) {
                    a(0);
                } else {
                    a(this.f3869a.getText().length());
                }
            } else {
                this.f.b(this.i, 2);
                this.i = null;
            }
            this.f3870b = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.g != i) {
            if (i > 0) {
                this.g = i;
            } else {
                this.g = -1;
            }
            if (this.f3870b) {
                a(this.f3869a == null ? 0 : this.f3869a.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        a(this, z);
        super.setEnabled(z);
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.g;
    }

    CharSequence getCounterOverflowDescription() {
        if (this.f3870b && this.h && this.i != null) {
            return this.i.getContentDescription();
        }
        return null;
    }

    void a(int i) {
        boolean z = this.h;
        if (this.g == -1) {
            this.i.setText(String.valueOf(i));
            this.i.setContentDescription(null);
            this.h = false;
        } else {
            if (q.g(this.i) == 1) {
                q.c(this.i, 0);
            }
            this.h = i > this.g;
            if (z != this.h) {
                a(this.i, this.h ? this.j : this.k);
                if (this.h) {
                    q.c(this.i, 1);
                }
            }
            this.i.setText(getContext().getString(a.i.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.g)));
            this.i.setContentDescription(getContext().getString(a.i.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.g)));
        }
        if (this.f3869a == null || z == this.h) {
            return;
        }
        a(false);
        d();
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.i.a(r3, r4)     // Catch: java.lang.Exception -> L1a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1a
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1a
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1a
        L18:
            r4 = 0
            r0 = 0
        L1a:
            if (r0 == 0) goto L2e
            int r4 = com.google.android.material.a.j.TextAppearance_AppCompat_Caption
            androidx.core.widget.i.a(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.a.c.design_error
            int r4 = androidx.core.a.a.c(r4, r0)
            r3.setTextColor(r4)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.a(android.widget.TextView, int):void");
    }

    private void h() {
        if (this.r == 0 || this.o == null || this.f3869a == null || getRight() == 0) {
            return;
        }
        int left = this.f3869a.getLeft();
        int i = i();
        int right = this.f3869a.getRight();
        int bottom = this.f3869a.getBottom() + this.p;
        if (this.r == 2) {
            left += this.z / 2;
            i -= this.z / 2;
            right -= this.z / 2;
            bottom += this.z / 2;
        }
        this.o.setBounds(left, i, right, bottom);
        n();
        l();
    }

    private int i() {
        if (this.f3869a == null) {
            return 0;
        }
        switch (this.r) {
        }
        return 0;
    }

    private int j() {
        if (!this.l) {
            return 0;
        }
        switch (this.r) {
        }
        return 0;
    }

    private int k() {
        switch (this.r) {
            case 1:
                return getBoxBackground().getBounds().top + this.s;
            case 2:
                return getBoxBackground().getBounds().top - j();
            default:
                return getPaddingTop();
        }
    }

    private void l() {
        Drawable background;
        if (this.f3869a == null || (background = this.f3869a.getBackground()) == null) {
            return;
        }
        if (ab.c(background)) {
            background = background.mutate();
        }
        d.b(this, this.f3869a, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f3869a.getBottom());
        }
    }

    private void m() {
        switch (this.r) {
            case 1:
                this.x = 0;
                break;
            case 2:
                if (this.V == 0) {
                    this.V = this.S.getColorForState(getDrawableState(), this.S.getDefaultColor());
                    break;
                }
                break;
        }
    }

    private void n() {
        if (this.o == null) {
            return;
        }
        m();
        if (this.f3869a != null && this.r == 2) {
            if (this.f3869a.getBackground() != null) {
                this.C = this.f3869a.getBackground();
            }
            q.a(this.f3869a, (Drawable) null);
        }
        if (this.f3869a != null && this.r == 1 && this.C != null) {
            q.a(this.f3869a, this.C);
        }
        if (this.x > -1 && this.A != 0) {
            this.o.setStroke(this.x, this.A);
        }
        this.o.setCornerRadii(getCornerRadiiAsArray());
        this.o.setColor(this.B);
        invalidate();
    }

    void c() {
        Drawable background;
        if (this.f3869a == null || (background = this.f3869a.getBackground()) == null) {
            return;
        }
        o();
        if (ab.c(background)) {
            background = background.mutate();
        }
        if (this.f.g()) {
            background.setColorFilter(j.a(this.f.j(), PorterDuff.Mode.SRC_IN));
        } else if (this.h && this.i != null) {
            background.setColorFilter(j.a(this.i.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.f(background);
            this.f3869a.refreshDrawableState();
        }
    }

    private void o() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.f3869a.getBackground()) == null || this.ad) {
            return;
        }
        Drawable drawableNewDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.ad = e.a((DrawableContainer) background, drawableNewDrawable.getConstantState());
        }
        if (this.ad) {
            return;
        }
        q.a(this.f3869a, drawableNewDrawable);
        this.ad = true;
        e();
    }

    static class b extends androidx.d.a.a {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() { // from class: com.google.android.material.textfield.TextInputLayout.b.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        CharSequence f3875a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3876b;

        b(Parcelable parcelable) {
            super(parcelable);
        }

        b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3875a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3876b = parcel.readInt() == 1;
        }

        @Override // androidx.d.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f3875a, parcel, i);
            parcel.writeInt(this.f3876b ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f3875a) + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        if (this.f.g()) {
            bVar.f3875a = getError();
        }
        bVar.f3876b = this.K;
        return bVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.a());
        setError(bVar.f3875a);
        if (bVar.f3876b) {
            b(true);
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.af = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.af = false;
    }

    public CharSequence getError() {
        if (this.f.e()) {
            return this.f.h();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.f.f()) {
            return this.f.i();
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.ab = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.o != null) {
            this.o.draw(canvas);
        }
        super.draw(canvas);
        if (this.l) {
            this.c.a(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        p();
        super.onMeasure(i, i2);
    }

    private void p() {
        if (this.f3869a == null) {
            return;
        }
        if (r()) {
            if (this.J == null) {
                this.J = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, (ViewGroup) this.d, false);
                this.J.setImageDrawable(this.H);
                this.J.setContentDescription(this.I);
                this.d.addView(this.J);
                this.J.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.TextInputLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TextInputLayout.this.b(false);
                    }
                });
            }
            if (this.f3869a != null && q.k(this.f3869a) <= 0) {
                this.f3869a.setMinimumHeight(q.k(this.J));
            }
            this.J.setVisibility(0);
            this.J.setChecked(this.K);
            if (this.L == null) {
                this.L = new ColorDrawable();
            }
            this.L.setBounds(0, 0, this.J.getMeasuredWidth(), 1);
            Drawable[] drawableArrA = androidx.core.widget.i.a(this.f3869a);
            if (drawableArrA[2] != this.L) {
                this.M = drawableArrA[2];
            }
            androidx.core.widget.i.a(this.f3869a, drawableArrA[0], drawableArrA[1], this.L, drawableArrA[3]);
            this.J.setPadding(this.f3869a.getPaddingLeft(), this.f3869a.getPaddingTop(), this.f3869a.getPaddingRight(), this.f3869a.getPaddingBottom());
            return;
        }
        if (this.J != null && this.J.getVisibility() == 0) {
            this.J.setVisibility(8);
        }
        if (this.L != null) {
            Drawable[] drawableArrA2 = androidx.core.widget.i.a(this.f3869a);
            if (drawableArrA2[2] == this.L) {
                androidx.core.widget.i.a(this.f3869a, drawableArrA2[0], drawableArrA2[1], this.M, drawableArrA2[3]);
                this.L = null;
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.H = drawable;
        if (this.J != null) {
            this.J.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.I = charSequence;
        if (this.J != null) {
            this.J.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.H;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.I;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.G != z) {
            this.G = z;
            if (!z && this.K && this.f3869a != null) {
                this.f3869a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.K = false;
            p();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.N = colorStateList;
        this.O = true;
        s();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.P = mode;
        this.Q = true;
        s();
    }

    public void b(boolean z) {
        if (this.G) {
            int selectionEnd = this.f3869a.getSelectionEnd();
            if (q()) {
                this.f3869a.setTransformationMethod(null);
                this.K = true;
            } else {
                this.f3869a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.K = false;
            }
            this.J.setChecked(this.K);
            if (z) {
                this.J.jumpDrawablesToCurrentState();
            }
            this.f3869a.setSelection(selectionEnd);
        }
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        if (this.f3869a != null) {
            q.a(this.f3869a, aVar);
        }
    }

    private boolean q() {
        return this.f3869a != null && (this.f3869a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean r() {
        return this.G && (q() || this.K);
    }

    private void s() {
        if (this.H != null) {
            if (this.O || this.Q) {
                this.H = androidx.core.graphics.drawable.a.g(this.H).mutate();
                if (this.O) {
                    androidx.core.graphics.drawable.a.a(this.H, this.N);
                }
                if (this.Q) {
                    androidx.core.graphics.drawable.a.a(this.H, this.P);
                }
                if (this.J == null || this.J.getDrawable() == this.H) {
                    return;
                }
                this.J.setImageDrawable(this.H);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.o != null) {
            h();
        }
        if (!this.l || this.f3869a == null) {
            return;
        }
        Rect rect = this.D;
        d.b(this, this.f3869a, rect);
        int compoundPaddingLeft = rect.left + this.f3869a.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f3869a.getCompoundPaddingRight();
        int iK = k();
        this.c.a(compoundPaddingLeft, rect.top + this.f3869a.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f3869a.getCompoundPaddingBottom());
        this.c.b(compoundPaddingLeft, iK, compoundPaddingRight, (i4 - i2) - getPaddingBottom());
        this.c.g();
        if (!t() || this.aa) {
            return;
        }
        u();
    }

    private void c(boolean z) {
        if (this.ac != null && this.ac.isRunning()) {
            this.ac.cancel();
        }
        if (z && this.ab) {
            a(1.0f);
        } else {
            this.c.b(1.0f);
        }
        this.aa = false;
        if (t()) {
            u();
        }
    }

    private boolean t() {
        return this.l && !TextUtils.isEmpty(this.m) && (this.o instanceof com.google.android.material.textfield.a);
    }

    private void u() {
        if (t()) {
            RectF rectF = this.E;
            this.c.a(rectF);
            a(rectF);
            ((com.google.android.material.textfield.a) this.o).a(rectF);
        }
    }

    private void v() {
        if (t()) {
            ((com.google.android.material.textfield.a) this.o).b();
        }
    }

    private void a(RectF rectF) {
        rectF.left -= this.q;
        rectF.top -= this.q;
        rectF.right += this.q;
        rectF.bottom += this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.ae) {
            return;
        }
        this.ae = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        a(q.x(this) && isEnabled());
        c();
        h();
        d();
        if (this.c != null ? this.c.a(drawableState) | false : false) {
            invalidate();
        }
        this.ae = false;
    }

    void d() {
        if (this.o == null || this.r == 0) {
            return;
        }
        boolean z = this.f3869a != null && this.f3869a.hasFocus();
        boolean z2 = this.f3869a != null && this.f3869a.isHovered();
        if (this.r == 2) {
            if (!isEnabled()) {
                this.A = this.W;
            } else if (this.f.g()) {
                this.A = this.f.j();
            } else if (this.h && this.i != null) {
                this.A = this.i.getCurrentTextColor();
            } else if (z) {
                this.A = this.V;
            } else if (z2) {
                this.A = this.U;
            } else {
                this.A = this.T;
            }
            if ((z2 || z) && isEnabled()) {
                this.x = this.z;
            } else {
                this.x = this.y;
            }
            n();
        }
    }

    private void d(boolean z) {
        if (this.ac != null && this.ac.isRunning()) {
            this.ac.cancel();
        }
        if (z && this.ab) {
            a(0.0f);
        } else {
            this.c.b(0.0f);
        }
        if (t() && ((com.google.android.material.textfield.a) this.o).a()) {
            v();
        }
        this.aa = true;
    }

    void a(float f) {
        if (this.c.e() == f) {
            return;
        }
        if (this.ac == null) {
            this.ac = new ValueAnimator();
            this.ac.setInterpolator(com.google.android.material.a.a.f3706b);
            this.ac.setDuration(167L);
            this.ac.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TextInputLayout.this.c.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        this.ac.setFloatValues(this.c.e(), f);
        this.ac.start();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.c.f();
    }

    final float getHintCollapsedTextHeight() {
        return this.c.b();
    }

    final int getErrorTextCurrentColor() {
        return this.f.j();
    }

    public static class a extends androidx.core.g.a {

        /* renamed from: a, reason: collision with root package name */
        private final TextInputLayout f3874a;

        public a(TextInputLayout textInputLayout) {
            this.f3874a = textInputLayout;
        }

        @Override // androidx.core.g.a
        public void a(View view, androidx.core.g.a.c cVar) {
            super.a(view, cVar);
            EditText editText = this.f3874a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f3874a.getHint();
            CharSequence error = this.f3874a.getError();
            CharSequence counterOverflowDescription = this.f3874a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                cVar.b((CharSequence) text);
            } else if (z2) {
                cVar.b(hint);
            }
            if (z2) {
                cVar.c(hint);
                if (!z && z2) {
                    z4 = true;
                }
                cVar.f(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                cVar.d(error);
                cVar.d(true);
            }
        }

        @Override // androidx.core.g.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            EditText editText = this.f3874a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f3874a.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }
}
