package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.core.a.a.f;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
class w {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f445a;

    /* renamed from: b, reason: collision with root package name */
    private aq f446b;
    private aq c;
    private aq d;
    private aq e;
    private aq f;
    private aq g;
    private final y h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    w(TextView textView) {
        this.f445a = textView;
        this.h = new y(this.f445a);
    }

    @SuppressLint({"NewApi"})
    void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListE;
        ColorStateList colorStateListE2;
        boolean z;
        boolean zA;
        Context context = this.f445a.getContext();
        j jVarA = j.a();
        as asVarA = as.a(context, attributeSet, a.j.AppCompatTextHelper, i, 0);
        int iG = asVarA.g(a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (asVarA.g(a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.f446b = a(context, jVarA, asVarA.g(a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (asVarA.g(a.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, jVarA, asVarA.g(a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (asVarA.g(a.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, jVarA, asVarA.g(a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (asVarA.g(a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, jVarA, asVarA.g(a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (asVarA.g(a.j.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, jVarA, asVarA.g(a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (asVarA.g(a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, jVarA, asVarA.g(a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        asVarA.a();
        boolean z2 = this.f445a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z3 = true;
        if (iG != -1) {
            as asVarA2 = as.a(context, iG, a.j.TextAppearance);
            if (z2 || !asVarA2.g(a.j.TextAppearance_textAllCaps)) {
                z = false;
                zA = false;
            } else {
                zA = asVarA2.a(a.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, asVarA2);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList colorStateListE3 = asVarA2.g(a.j.TextAppearance_android_textColor) ? asVarA2.e(a.j.TextAppearance_android_textColor) : null;
                colorStateListE2 = asVarA2.g(a.j.TextAppearance_android_textColorHint) ? asVarA2.e(a.j.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList = colorStateListE3;
                colorStateListE = asVarA2.g(a.j.TextAppearance_android_textColorLink) ? asVarA2.e(a.j.TextAppearance_android_textColorLink) : null;
                colorStateListE = colorStateList;
            } else {
                colorStateListE = null;
                colorStateListE2 = null;
            }
            asVarA2.a();
        } else {
            colorStateListE = null;
            colorStateListE2 = null;
            z = false;
            zA = false;
        }
        as asVarA3 = as.a(context, attributeSet, a.j.TextAppearance, i, 0);
        if (z2 || !asVarA3.g(a.j.TextAppearance_textAllCaps)) {
            z3 = z;
        } else {
            zA = asVarA3.a(a.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (asVarA3.g(a.j.TextAppearance_android_textColor)) {
                colorStateListE = asVarA3.e(a.j.TextAppearance_android_textColor);
            }
            if (asVarA3.g(a.j.TextAppearance_android_textColorHint)) {
                colorStateListE2 = asVarA3.e(a.j.TextAppearance_android_textColorHint);
            }
            if (asVarA3.g(a.j.TextAppearance_android_textColorLink)) {
                colorStateListE = asVarA3.e(a.j.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && asVarA3.g(a.j.TextAppearance_android_textSize) && asVarA3.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.f445a.setTextSize(0, 0.0f);
        }
        a(context, asVarA3);
        asVarA3.a();
        if (colorStateListE != null) {
            this.f445a.setTextColor(colorStateListE);
        }
        if (colorStateListE2 != null) {
            this.f445a.setHintTextColor(colorStateListE2);
        }
        if (colorStateListE != null) {
            this.f445a.setLinkTextColor(colorStateListE);
        }
        if (!z2 && z3) {
            a(zA);
        }
        if (this.j != null) {
            this.f445a.setTypeface(this.j, this.i);
        }
        this.h.a(attributeSet, i);
        if (androidx.core.widget.b.d && this.h.a() != 0) {
            int[] iArrE = this.h.e();
            if (iArrE.length > 0) {
                if (this.f445a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f445a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.d(), this.h.b(), 0);
                } else {
                    this.f445a.setAutoSizeTextTypeUniformWithPresetSizes(iArrE, 0);
                }
            }
        }
        as asVarA4 = as.a(context, attributeSet, a.j.AppCompatTextView);
        int iE = asVarA4.e(a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int iE2 = asVarA4.e(a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int iE3 = asVarA4.e(a.j.AppCompatTextView_lineHeight, -1);
        asVarA4.a();
        if (iE != -1) {
            androidx.core.widget.i.b(this.f445a, iE);
        }
        if (iE2 != -1) {
            androidx.core.widget.i.c(this.f445a, iE2);
        }
        if (iE3 != -1) {
            androidx.core.widget.i.d(this.f445a, iE3);
        }
    }

    private void a(Context context, as asVar) {
        String strD;
        this.i = asVar.a(a.j.TextAppearance_android_textStyle, this.i);
        boolean z = true;
        if (asVar.g(a.j.TextAppearance_android_fontFamily) || asVar.g(a.j.TextAppearance_fontFamily)) {
            this.j = null;
            int i = asVar.g(a.j.TextAppearance_fontFamily) ? a.j.TextAppearance_fontFamily : a.j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f445a);
                try {
                    this.j = asVar.a(i, this.i, new f.a() { // from class: androidx.appcompat.widget.w.1
                        @Override // androidx.core.a.a.f.a
                        public void a(int i2) {
                        }

                        @Override // androidx.core.a.a.f.a
                        public void a(Typeface typeface) {
                            w.this.a(weakReference, typeface);
                        }
                    });
                    if (this.j != null) {
                        z = false;
                    }
                    this.k = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.j != null || (strD = asVar.d(i)) == null) {
                return;
            }
            this.j = Typeface.create(strD, this.i);
            return;
        }
        if (asVar.g(a.j.TextAppearance_android_typeface)) {
            this.k = false;
            switch (asVar.a(a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.j = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.j = Typeface.SERIF;
                    break;
                case 3:
                    this.j = Typeface.MONOSPACE;
                    break;
            }
        }
    }

    void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.i);
            }
        }
    }

    void a(Context context, int i) {
        ColorStateList colorStateListE;
        as asVarA = as.a(context, i, a.j.TextAppearance);
        if (asVarA.g(a.j.TextAppearance_textAllCaps)) {
            a(asVarA.a(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && asVarA.g(a.j.TextAppearance_android_textColor) && (colorStateListE = asVarA.e(a.j.TextAppearance_android_textColor)) != null) {
            this.f445a.setTextColor(colorStateListE);
        }
        if (asVarA.g(a.j.TextAppearance_android_textSize) && asVarA.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.f445a.setTextSize(0, 0.0f);
        }
        a(context, asVarA);
        asVarA.a();
        if (this.j != null) {
            this.f445a.setTypeface(this.j, this.i);
        }
    }

    void a(boolean z) {
        this.f445a.setAllCaps(z);
    }

    void a() {
        if (this.f446b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.f445a.getCompoundDrawables();
            a(compoundDrawables[0], this.f446b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f445a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, aq aqVar) {
        if (drawable == null || aqVar == null) {
            return;
        }
        j.a(drawable, aqVar, this.f445a.getDrawableState());
    }

    private static aq a(Context context, j jVar, int i) {
        ColorStateList colorStateListB = jVar.b(context, i);
        if (colorStateListB == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.d = true;
        aqVar.f364a = colorStateListB;
        return aqVar;
    }

    void a(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.d) {
            return;
        }
        b();
    }

    void a(int i, float f) {
        if (androidx.core.widget.b.d || c()) {
            return;
        }
        b(i, f);
    }

    void b() {
        this.h.f();
    }

    boolean c() {
        return this.h.g();
    }

    private void b(int i, float f) {
        this.h.a(i, f);
    }

    void a(int i) {
        this.h.a(i);
    }

    void a(int i, int i2, int i3, int i4) {
        this.h.a(i, i2, i3, i4);
    }

    void a(int[] iArr, int i) {
        this.h.a(iArr, i);
    }

    int d() {
        return this.h.a();
    }

    int e() {
        return this.h.b();
    }

    int f() {
        return this.h.c();
    }

    int g() {
        return this.h.d();
    }

    int[] h() {
        return this.h.e();
    }
}
