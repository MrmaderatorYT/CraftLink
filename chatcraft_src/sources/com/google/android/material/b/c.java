package com.google.android.material.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.g.q;
import com.google.android.material.a;
import com.google.android.material.internal.i;

/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f3742a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3743b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private boolean w = false;

    static {
        f3742a = Build.VERSION.SDK_INT >= 21;
    }

    public c(a aVar) {
        this.f3743b = aVar;
    }

    public void a(TypedArray typedArray) {
        this.c = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetLeft, 0);
        this.d = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetRight, 0);
        this.e = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetBottom, 0);
        this.g = typedArray.getDimensionPixelSize(a.k.MaterialButton_cornerRadius, 0);
        this.h = typedArray.getDimensionPixelSize(a.k.MaterialButton_strokeWidth, 0);
        this.i = i.a(typedArray.getInt(a.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = com.google.android.material.f.a.a(this.f3743b.getContext(), typedArray, a.k.MaterialButton_backgroundTint);
        this.k = com.google.android.material.f.a.a(this.f3743b.getContext(), typedArray, a.k.MaterialButton_strokeColor);
        this.l = com.google.android.material.f.a.a(this.f3743b.getContext(), typedArray, a.k.MaterialButton_rippleColor);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.h);
        this.m.setColor(this.k != null ? this.k.getColorForState(this.f3743b.getDrawableState(), 0) : 0);
        int iH = q.h(this.f3743b);
        int paddingTop = this.f3743b.getPaddingTop();
        int i = q.i(this.f3743b);
        int paddingBottom = this.f3743b.getPaddingBottom();
        this.f3743b.setInternalBackground(f3742a ? k() : i());
        q.a(this.f3743b, iH + this.c, paddingTop + this.e, i + this.d, paddingBottom + this.f);
    }

    void a() {
        this.w = true;
        this.f3743b.setSupportBackgroundTintList(this.j);
        this.f3743b.setSupportBackgroundTintMode(this.i);
    }

    boolean b() {
        return this.w;
    }

    void a(Canvas canvas) {
        if (canvas == null || this.k == null || this.h <= 0) {
            return;
        }
        this.n.set(this.f3743b.getBackground().getBounds());
        this.o.set(this.n.left + (this.h / 2.0f) + this.c, this.n.top + (this.h / 2.0f) + this.e, (this.n.right - (this.h / 2.0f)) - this.d, (this.n.bottom - (this.h / 2.0f)) - this.f);
        float f = this.g - (this.h / 2.0f);
        canvas.drawRoundRect(this.o, f, f, this.m);
    }

    private Drawable i() {
        this.p = new GradientDrawable();
        this.p.setCornerRadius(this.g + 1.0E-5f);
        this.p.setColor(-1);
        this.q = androidx.core.graphics.drawable.a.g(this.p);
        androidx.core.graphics.drawable.a.a(this.q, this.j);
        if (this.i != null) {
            androidx.core.graphics.drawable.a.a(this.q, this.i);
        }
        this.r = new GradientDrawable();
        this.r.setCornerRadius(this.g + 1.0E-5f);
        this.r.setColor(-1);
        this.s = androidx.core.graphics.drawable.a.g(this.r);
        androidx.core.graphics.drawable.a.a(this.s, this.l);
        return a(new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.c, this.e, this.d, this.f);
    }

    void a(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (f3742a) {
                j();
            } else if (this.q != null) {
                androidx.core.graphics.drawable.a.a(this.q, this.j);
            }
        }
    }

    ColorStateList c() {
        return this.j;
    }

    void a(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (f3742a) {
                j();
            } else {
                if (this.q == null || this.i == null) {
                    return;
                }
                androidx.core.graphics.drawable.a.a(this.q, this.i);
            }
        }
    }

    PorterDuff.Mode d() {
        return this.i;
    }

    private void j() {
        if (this.t != null) {
            androidx.core.graphics.drawable.a.a(this.t, this.j);
            if (this.i != null) {
                androidx.core.graphics.drawable.a.a(this.t, this.i);
            }
        }
    }

    @TargetApi(21)
    private Drawable k() {
        this.t = new GradientDrawable();
        this.t.setCornerRadius(this.g + 1.0E-5f);
        this.t.setColor(-1);
        j();
        this.u = new GradientDrawable();
        this.u.setCornerRadius(this.g + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.h, this.k);
        InsetDrawable insetDrawableA = a(new LayerDrawable(new Drawable[]{this.t, this.u}));
        this.v = new GradientDrawable();
        this.v.setCornerRadius(this.g + 1.0E-5f);
        this.v.setColor(-1);
        return new b(com.google.android.material.g.a.a(this.l), insetDrawableA, this.v);
    }

    void a(int i, int i2) {
        if (this.v != null) {
            this.v.setBounds(this.c, this.e, i2 - this.d, i - this.f);
        }
    }

    void a(int i) {
        if (f3742a && this.t != null) {
            this.t.setColor(i);
        } else {
            if (f3742a || this.p == null) {
                return;
            }
            this.p.setColor(i);
        }
    }

    void b(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (f3742a && (this.f3743b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f3743b.getBackground()).setColor(colorStateList);
            } else {
                if (f3742a || this.s == null) {
                    return;
                }
                androidx.core.graphics.drawable.a.a(this.s, colorStateList);
            }
        }
    }

    ColorStateList e() {
        return this.l;
    }

    void c(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            this.m.setColor(colorStateList != null ? colorStateList.getColorForState(this.f3743b.getDrawableState(), 0) : 0);
            l();
        }
    }

    ColorStateList f() {
        return this.k;
    }

    void b(int i) {
        if (this.h != i) {
            this.h = i;
            this.m.setStrokeWidth(i);
            l();
        }
    }

    int g() {
        return this.h;
    }

    private void l() {
        if (f3742a && this.u != null) {
            this.f3743b.setInternalBackground(k());
        } else {
            if (f3742a) {
                return;
            }
            this.f3743b.invalidate();
        }
    }

    void c(int i) {
        if (this.g != i) {
            this.g = i;
            if (f3742a && this.t != null && this.u != null && this.v != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f = i + 1.0E-5f;
                    n().setCornerRadius(f);
                    m().setCornerRadius(f);
                }
                float f2 = i + 1.0E-5f;
                this.t.setCornerRadius(f2);
                this.u.setCornerRadius(f2);
                this.v.setCornerRadius(f2);
                return;
            }
            if (f3742a || this.p == null || this.r == null) {
                return;
            }
            float f3 = i + 1.0E-5f;
            this.p.setCornerRadius(f3);
            this.r.setCornerRadius(f3);
            this.f3743b.invalidate();
        }
    }

    int h() {
        return this.g;
    }

    private GradientDrawable m() {
        if (!f3742a || this.f3743b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f3743b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private GradientDrawable n() {
        if (!f3742a || this.f3743b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f3743b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }
}
