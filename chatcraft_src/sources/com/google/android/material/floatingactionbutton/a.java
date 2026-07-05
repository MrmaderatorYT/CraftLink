package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.g.q;
import com.google.android.material.a;
import com.google.android.material.a.h;
import com.google.android.material.internal.g;
import com.google.android.material.internal.j;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    static final TimeInterpolator f3788a = com.google.android.material.a.a.c;
    static final int[] p = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] q = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] r = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] s = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] t = {R.attr.state_enabled};
    static final int[] u = new int[0];
    private float A;
    private ArrayList<Animator.AnimatorListener> B;
    private ArrayList<Animator.AnimatorListener> C;
    private ViewTreeObserver.OnPreDrawListener H;
    Animator c;
    h d;
    h e;
    com.google.android.material.h.a f;
    Drawable g;
    Drawable h;
    com.google.android.material.internal.a i;
    Drawable j;
    float k;
    float l;
    float m;
    int n;
    final j v;
    final com.google.android.material.h.b w;
    private h x;
    private h y;

    /* renamed from: b, reason: collision with root package name */
    int f3789b = 0;
    float o = 1.0f;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private final g z = new g();

    /* compiled from: FloatingActionButtonImpl.java */
    interface d {
        void a();

        void b();
    }

    void b(Rect rect) {
    }

    void i() {
    }

    boolean m() {
        return true;
    }

    a(j jVar, com.google.android.material.h.b bVar) {
        this.v = jVar;
        this.w = bVar;
        this.z.a(p, a((f) new c()));
        this.z.a(q, a((f) new b()));
        this.z.a(r, a((f) new b()));
        this.z.a(s, a((f) new b()));
        this.z.a(t, a((f) new e()));
        this.z.a(u, a((f) new C0084a()));
        this.A = this.v.getRotation();
    }

    void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable[] drawableArr;
        this.g = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.g, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.g, mode);
        }
        this.h = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.h, com.google.android.material.g.a.a(colorStateList2));
        if (i > 0) {
            this.i = a(i, colorStateList);
            drawableArr = new Drawable[]{this.i, this.g, this.h};
        } else {
            this.i = null;
            drawableArr = new Drawable[]{this.g, this.h};
        }
        this.j = new LayerDrawable(drawableArr);
        this.f = new com.google.android.material.h.a(this.v.getContext(), this.j, this.w.a(), this.k, this.k + this.m);
        this.f.a(false);
        this.w.a(this.f);
    }

    void a(ColorStateList colorStateList) {
        if (this.g != null) {
            androidx.core.graphics.drawable.a.a(this.g, colorStateList);
        }
        if (this.i != null) {
            this.i.a(colorStateList);
        }
    }

    void a(PorterDuff.Mode mode) {
        if (this.g != null) {
            androidx.core.graphics.drawable.a.a(this.g, mode);
        }
    }

    void b(ColorStateList colorStateList) {
        if (this.h != null) {
            androidx.core.graphics.drawable.a.a(this.h, com.google.android.material.g.a.a(colorStateList));
        }
    }

    final void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            a(this.k, this.l, this.m);
        }
    }

    float a() {
        return this.k;
    }

    float b() {
        return this.l;
    }

    float c() {
        return this.m;
    }

    final void b(float f2) {
        if (this.l != f2) {
            this.l = f2;
            a(this.k, this.l, this.m);
        }
    }

    final void c(float f2) {
        if (this.m != f2) {
            this.m = f2;
            a(this.k, this.l, this.m);
        }
    }

    final void a(int i) {
        if (this.n != i) {
            this.n = i;
            d();
        }
    }

    final void d() {
        d(this.o);
    }

    final void d(float f2) {
        this.o = f2;
        Matrix matrix = this.G;
        a(f2, matrix);
        this.v.setImageMatrix(matrix);
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.v.getDrawable() == null || this.n == 0) {
            return;
        }
        RectF rectF = this.E;
        RectF rectF2 = this.F;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        rectF2.set(0.0f, 0.0f, this.n, this.n);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        matrix.postScale(f2, f2, this.n / 2.0f, this.n / 2.0f);
    }

    final h e() {
        return this.d;
    }

    final void a(h hVar) {
        this.d = hVar;
    }

    final h f() {
        return this.e;
    }

    final void b(h hVar) {
        this.e = hVar;
    }

    void a(float f2, float f3, float f4) {
        if (this.f != null) {
            this.f.a(f2, this.m + f2);
            j();
        }
    }

    void a(int[] iArr) {
        this.z.a(iArr);
    }

    void g() {
        this.z.a();
    }

    void a(Animator.AnimatorListener animatorListener) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(animatorListener);
    }

    void b(Animator.AnimatorListener animatorListener) {
        if (this.B == null) {
            return;
        }
        this.B.remove(animatorListener);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            return;
        }
        this.C.remove(animatorListener);
    }

    void a(final d dVar, final boolean z) {
        if (s()) {
            return;
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (w()) {
            AnimatorSet animatorSetA = a(this.e != null ? this.e : u(), 0.0f, 0.0f, 0.0f);
            animatorSetA.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.a.1
                private boolean d;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    a.this.v.a(0, z);
                    a.this.f3789b = 1;
                    a.this.c = animator;
                    this.d = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.d = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.f3789b = 0;
                    a.this.c = null;
                    if (this.d) {
                        return;
                    }
                    a.this.v.a(z ? 8 : 4, z);
                    if (dVar != null) {
                        dVar.b();
                    }
                }
            });
            if (this.C != null) {
                Iterator<Animator.AnimatorListener> it = this.C.iterator();
                while (it.hasNext()) {
                    animatorSetA.addListener(it.next());
                }
            }
            animatorSetA.start();
            return;
        }
        this.v.a(z ? 8 : 4, z);
        if (dVar != null) {
            dVar.b();
        }
    }

    void b(final d dVar, final boolean z) {
        if (r()) {
            return;
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (w()) {
            if (this.v.getVisibility() != 0) {
                this.v.setAlpha(0.0f);
                this.v.setScaleY(0.0f);
                this.v.setScaleX(0.0f);
                d(0.0f);
            }
            AnimatorSet animatorSetA = a(this.d != null ? this.d : t(), 1.0f, 1.0f, 1.0f);
            animatorSetA.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.a.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    a.this.v.a(0, z);
                    a.this.f3789b = 2;
                    a.this.c = animator;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.f3789b = 0;
                    a.this.c = null;
                    if (dVar != null) {
                        dVar.a();
                    }
                }
            });
            if (this.B != null) {
                Iterator<Animator.AnimatorListener> it = this.B.iterator();
                while (it.hasNext()) {
                    animatorSetA.addListener(it.next());
                }
            }
            animatorSetA.start();
            return;
        }
        this.v.a(0, z);
        this.v.setAlpha(1.0f);
        this.v.setScaleY(1.0f);
        this.v.setScaleX(1.0f);
        d(1.0f);
        if (dVar != null) {
            dVar.a();
        }
    }

    private h t() {
        if (this.x == null) {
            this.x = h.a(this.v.getContext(), a.C0081a.design_fab_show_motion_spec);
        }
        return this.x;
    }

    private h u() {
        if (this.y == null) {
            this.y = h.a(this.v.getContext(), a.C0081a.design_fab_hide_motion_spec);
        }
        return this.y;
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.v, (Property<j, Float>) View.ALPHA, f2);
        hVar.b("opacity").a((Animator) objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.v, (Property<j, Float>) View.SCALE_X, f3);
        hVar.b("scale").a((Animator) objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.v, (Property<j, Float>) View.SCALE_Y, f3);
        hVar.b("scale").a((Animator) objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        a(f4, this.G);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.v, new com.google.android.material.a.f(), new com.google.android.material.a.g(), new Matrix(this.G));
        hVar.b("iconScale").a((Animator) objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    final Drawable h() {
        return this.j;
    }

    final void j() {
        Rect rect = this.D;
        a(rect);
        b(rect);
        this.w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void a(Rect rect) {
        this.f.getPadding(rect);
    }

    void k() {
        if (m()) {
            v();
            this.v.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    void l() {
        if (this.H != null) {
            this.v.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    com.google.android.material.internal.a a(int i, ColorStateList colorStateList) {
        Context context = this.v.getContext();
        com.google.android.material.internal.a aVarN = n();
        aVarN.a(androidx.core.a.a.c(context, a.c.design_fab_stroke_top_outer_color), androidx.core.a.a.c(context, a.c.design_fab_stroke_top_inner_color), androidx.core.a.a.c(context, a.c.design_fab_stroke_end_inner_color), androidx.core.a.a.c(context, a.c.design_fab_stroke_end_outer_color));
        aVarN.a(i);
        aVarN.a(colorStateList);
        return aVarN;
    }

    com.google.android.material.internal.a n() {
        return new com.google.android.material.internal.a();
    }

    void o() {
        float rotation = this.v.getRotation();
        if (this.A != rotation) {
            this.A = rotation;
            x();
        }
    }

    private void v() {
        if (this.H == null) {
            this.H = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.a.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    a.this.o();
                    return true;
                }
            };
        }
    }

    GradientDrawable p() {
        GradientDrawable gradientDrawableQ = q();
        gradientDrawableQ.setShape(1);
        gradientDrawableQ.setColor(-1);
        return gradientDrawableQ;
    }

    GradientDrawable q() {
        return new GradientDrawable();
    }

    boolean r() {
        return this.v.getVisibility() != 0 ? this.f3789b == 2 : this.f3789b != 1;
    }

    boolean s() {
        return this.v.getVisibility() == 0 ? this.f3789b == 1 : this.f3789b != 2;
    }

    private ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f3788a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    /* compiled from: FloatingActionButtonImpl.java */
    private abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3799a;
        private float c;
        private float d;

        protected abstract float a();

        private f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f3799a) {
                this.c = a.this.f.b();
                this.d = a();
                this.f3799a = true;
            }
            a.this.f.a(this.c + ((this.d - this.c) * valueAnimator.getAnimatedFraction()));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f.a(this.d);
            this.f3799a = false;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    private class e extends f {
        e() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    private class b extends f {
        b() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k + a.this.l;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    private class c extends f {
        c() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k + a.this.m;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    private class C0084a extends f {
        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return 0.0f;
        }

        C0084a() {
            super();
        }
    }

    private boolean w() {
        return q.x(this.v) && !this.v.isInEditMode();
    }

    private void x() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.A % 90.0f != 0.0f) {
                if (this.v.getLayerType() != 1) {
                    this.v.setLayerType(1, null);
                }
            } else if (this.v.getLayerType() != 0) {
                this.v.setLayerType(0, null);
            }
        }
        if (this.f != null) {
            this.f.b(-this.A);
        }
        if (this.i != null) {
            this.i.b(-this.A);
        }
    }
}
