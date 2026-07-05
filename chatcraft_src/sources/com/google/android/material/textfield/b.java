package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.x;
import androidx.core.g.q;
import androidx.core.widget.i;
import com.google.android.material.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndicatorViewController.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3879a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f3880b;
    private LinearLayout c;
    private int d;
    private FrameLayout e;
    private int f;
    private Animator g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private CharSequence o;
    private boolean p;
    private TextView q;
    private int r;
    private Typeface s;

    boolean a(int i) {
        return i == 0 || i == 1;
    }

    public b(TextInputLayout textInputLayout) {
        this.f3879a = textInputLayout.getContext();
        this.f3880b = textInputLayout;
        this.h = this.f3879a.getResources().getDimensionPixelSize(a.d.design_textinput_caption_translate_y);
    }

    void a(CharSequence charSequence) {
        c();
        this.o = charSequence;
        this.q.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        a(this.i, this.j, a(this.q, charSequence));
    }

    void a() {
        c();
        if (this.i == 2) {
            this.j = 0;
        }
        a(this.i, this.j, a(this.q, (CharSequence) null));
    }

    void b(CharSequence charSequence) {
        c();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        a(this.i, this.j, a(this.m, charSequence));
    }

    void b() {
        this.k = null;
        c();
        if (this.i == 1) {
            if (this.p && !TextUtils.isEmpty(this.o)) {
                this.j = 2;
            } else {
                this.j = 0;
            }
        }
        a(this.i, this.j, a(this.m, (CharSequence) null));
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return q.x(this.f3880b) && this.f3880b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(final int i, final int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.p, this.q, 2, i, i2);
            a(arrayList, this.l, this.m, 1, i, i2);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            final TextView textViewD = d(i);
            final TextView textViewD2 = d(i2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    b.this.i = i2;
                    b.this.g = null;
                    if (textViewD != null) {
                        textViewD.setVisibility(4);
                        if (i != 1 || b.this.m == null) {
                            return;
                        }
                        b.this.m.setText((CharSequence) null);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (textViewD2 != null) {
                        textViewD2.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            a(i, i2);
        }
        this.f3880b.c();
        this.f3880b.a(z);
        this.f3880b.d();
    }

    private void a(int i, int i2) {
        TextView textViewD;
        TextView textViewD2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (textViewD2 = d(i2)) != null) {
            textViewD2.setVisibility(0);
            textViewD2.setAlpha(1.0f);
        }
        if (i != 0 && (textViewD = d(i)) != null) {
            textViewD.setVisibility(4);
            if (i == 1) {
                textViewD.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(a(textView, i3 == i));
            if (i3 == i) {
                list.add(a(textView));
            }
        }
    }

    private ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f3705a);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.h, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.d);
        return objectAnimatorOfFloat;
    }

    void c() {
        if (this.g != null) {
            this.g.cancel();
        }
    }

    private TextView d(int i) {
        switch (i) {
            case 1:
                return this.m;
            case 2:
                return this.q;
            default:
                return null;
        }
    }

    void d() {
        if (m()) {
            q.a(this.c, q.h(this.f3880b.getEditText()), 0, q.i(this.f3880b.getEditText()), 0);
        }
    }

    private boolean m() {
        return (this.c == null || this.f3880b.getEditText() == null) ? false : true;
    }

    void a(TextView textView, int i) {
        if (this.c == null && this.e == null) {
            this.c = new LinearLayout(this.f3879a);
            this.c.setOrientation(0);
            this.f3880b.addView(this.c, -1, -2);
            this.e = new FrameLayout(this.f3879a);
            this.c.addView(this.e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.c.addView(new androidx.g.a.a(this.f3879a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f3880b.getEditText() != null) {
                d();
            }
        }
        if (a(i)) {
            this.e.setVisibility(0);
            this.e.addView(textView);
            this.f++;
        } else {
            this.c.addView(textView, i);
        }
        this.c.setVisibility(0);
        this.d++;
    }

    void b(TextView textView, int i) {
        if (this.c == null) {
            return;
        }
        if (a(i) && this.e != null) {
            this.f--;
            a(this.e, this.f);
            this.e.removeView(textView);
        } else {
            this.c.removeView(textView);
        }
        this.d--;
        a(this.c, this.d);
    }

    private void a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    void a(boolean z) {
        if (this.l == z) {
            return;
        }
        c();
        if (z) {
            this.m = new x(this.f3879a);
            this.m.setId(a.f.textinput_error);
            if (this.s != null) {
                this.m.setTypeface(this.s);
            }
            b(this.n);
            this.m.setVisibility(4);
            q.c(this.m, 1);
            a(this.m, 0);
        } else {
            b();
            b(this.m, 0);
            this.m = null;
            this.f3880b.c();
            this.f3880b.d();
        }
        this.l = z;
    }

    boolean e() {
        return this.l;
    }

    boolean f() {
        return this.p;
    }

    void b(boolean z) {
        if (this.p == z) {
            return;
        }
        c();
        if (z) {
            this.q = new x(this.f3879a);
            this.q.setId(a.f.textinput_helper_text);
            if (this.s != null) {
                this.q.setTypeface(this.s);
            }
            this.q.setVisibility(4);
            q.c(this.q, 1);
            c(this.r);
            a(this.q, 1);
        } else {
            a();
            b(this.q, 1);
            this.q = null;
            this.f3880b.c();
            this.f3880b.d();
        }
        this.p = z;
    }

    boolean g() {
        return e(this.j);
    }

    private boolean e(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    CharSequence h() {
        return this.k;
    }

    CharSequence i() {
        return this.o;
    }

    void a(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            a(this.m, typeface);
            a(this.q, typeface);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    int j() {
        if (this.m != null) {
            return this.m.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList k() {
        if (this.m != null) {
            return this.m.getTextColors();
        }
        return null;
    }

    void a(ColorStateList colorStateList) {
        if (this.m != null) {
            this.m.setTextColor(colorStateList);
        }
    }

    void b(int i) {
        this.n = i;
        if (this.m != null) {
            this.f3880b.a(this.m, i);
        }
    }

    int l() {
        if (this.q != null) {
            return this.q.getCurrentTextColor();
        }
        return -1;
    }

    void b(ColorStateList colorStateList) {
        if (this.q != null) {
            this.q.setTextColor(colorStateList);
        }
    }

    void c(int i) {
        this.r = i;
        if (this.q != null) {
            i.a(this.q, i);
        }
    }
}
