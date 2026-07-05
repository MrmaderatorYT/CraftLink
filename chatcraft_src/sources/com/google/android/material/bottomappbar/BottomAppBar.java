package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.q;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.i.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {
    AnimatorListenerAdapter e;
    private final int f;
    private final c g;
    private final com.google.android.material.bottomappbar.a h;
    private Animator i;
    private Animator j;
    private Animator k;
    private int l;
    private boolean m;
    private boolean n;

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public int getFabAlignmentMode() {
        return this.l;
    }

    public void setFabAlignmentMode(int i) {
        a(i);
        a(i, this.n);
        this.l = i;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a(this.g, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.g.a();
    }

    public float getFabCradleMargin() {
        return this.h.d();
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            this.h.d(f);
            this.g.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.h.e();
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.h.e(f);
            this.g.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return this.h.b();
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            this.h.b(f);
            this.g.invalidateSelf();
        }
    }

    public boolean getHideOnScroll() {
        return this.m;
    }

    public void setHideOnScroll(boolean z) {
        this.m = z;
    }

    void setFabDiameter(int i) {
        float f = i;
        if (f != this.h.c()) {
            this.h.c(f);
            this.g.invalidateSelf();
        }
    }

    private void a(int i) {
        if (this.l == i || !q.x(this)) {
            return;
        }
        if (this.j != null) {
            this.j.cancel();
        }
        ArrayList arrayList = new ArrayList();
        a(i, arrayList);
        b(i, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.j = animatorSet;
        this.j.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BottomAppBar.this.j = null;
            }
        });
        this.j.start();
    }

    private void a(int i, List<Animator> list) {
        if (this.n) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.h.a(), b(i));
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.h.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    BottomAppBar.this.g.invalidateSelf();
                }
            });
            valueAnimatorOfFloat.setDuration(300L);
            list.add(valueAnimatorOfFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton m() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).d(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    private boolean n() {
        FloatingActionButton floatingActionButtonM = m();
        return floatingActionButtonM != null && floatingActionButtonM.d();
    }

    private void b(int i, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(m(), "translationX", b(i));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    private void a(int i, boolean z) {
        if (q.x(this)) {
            if (this.k != null) {
                this.k.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!n()) {
                i = 0;
                z = false;
            }
            a(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.k = animatorSet;
            this.k.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.k = null;
                }
            });
            this.k.start();
        }
    }

    private void a(final int i, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.n && (!z || !n())) || (this.l != 1 && i != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4

                /* renamed from: a, reason: collision with root package name */
                public boolean f3756a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.f3756a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.f3756a) {
                        return;
                    }
                    BottomAppBar.this.a(actionMenuView, i, z);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    private float a(boolean z) {
        FloatingActionButton floatingActionButtonM = m();
        if (floatingActionButtonM == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        floatingActionButtonM.a(rect);
        float fHeight = rect.height();
        if (fHeight == 0.0f) {
            fHeight = floatingActionButtonM.getMeasuredHeight();
        }
        float height = floatingActionButtonM.getHeight() - rect.bottom;
        float height2 = floatingActionButtonM.getHeight() - rect.height();
        float f = (-getCradleVerticalOffset()) + (fHeight / 2.0f) + height;
        float paddingBottom = height2 - floatingActionButtonM.getPaddingBottom();
        float f2 = -getMeasuredHeight();
        if (z) {
            paddingBottom = f;
        }
        return f2 + paddingBottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return a(this.n);
    }

    private int b(int i) {
        boolean z = q.f(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.f) * (z ? -1 : 1);
        }
        return 0;
    }

    private float getFabTranslationX() {
        return b(this.l);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = q.f(this) == 1;
        int iMax = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.b) && (((Toolbar.b) childAt.getLayoutParams()).f115a & 8388615) == 8388611) {
                iMax = Math.max(iMax, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i == 1 && z) ? iMax - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    private void o() {
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return (this.i != null && this.i.isRunning()) || (this.k != null && this.k.isRunning()) || (this.j != null && this.j.isRunning());
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        o();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.h.a(getFabTranslationX());
        FloatingActionButton floatingActionButtonM = m();
        this.g.a((this.n && n()) ? 1.0f : 0.0f);
        if (floatingActionButtonM != null) {
            floatingActionButtonM.setTranslationY(getFabTranslationY());
            floatingActionButtonM.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!n()) {
                a(actionMenuView, 0, false);
            } else {
                a(actionMenuView, this.l, this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.c(this.e);
        floatingActionButton.a(this.e);
    }

    private void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.d(this.e);
        floatingActionButton.b(this.e);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public CoordinatorLayout.b<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f3758a;

        public Behavior() {
            this.f3758a = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3758a = new Rect();
        }

        private boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton floatingActionButtonM = bottomAppBar.m();
            if (floatingActionButtonM != null) {
                a(floatingActionButtonM, bottomAppBar);
                floatingActionButtonM.b(this.f3758a);
                bottomAppBar.setFabDiameter(this.f3758a.height());
            }
            if (!bottomAppBar.p()) {
                bottomAppBar.q();
            }
            coordinatorLayout.a(bottomAppBar, i);
            return super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void a(BottomAppBar bottomAppBar) {
            super.a((Behavior) bottomAppBar);
            FloatingActionButton floatingActionButtonM = bottomAppBar.m();
            if (floatingActionButtonM != null) {
                floatingActionButtonM.clearAnimation();
                floatingActionButtonM.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(com.google.android.material.a.a.d).setDuration(225L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void b(BottomAppBar bottomAppBar) {
            super.b((Behavior) bottomAppBar);
            FloatingActionButton floatingActionButtonM = bottomAppBar.m();
            if (floatingActionButtonM != null) {
                floatingActionButtonM.a(this.f3758a);
                float measuredHeight = floatingActionButtonM.getMeasuredHeight() - this.f3758a.height();
                floatingActionButtonM.clearAnimation();
                floatingActionButtonM.animate().translationY((-floatingActionButtonM.getPaddingBottom()) + measuredHeight).setInterpolator(com.google.android.material.a.a.c).setDuration(175L);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f3759a = this.l;
        aVar.f3760b = this.n;
        return aVar;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.a());
        this.l = aVar.f3759a;
        this.n = aVar.f3760b;
    }

    static class a extends androidx.d.a.a {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.a.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f3759a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3760b;

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3759a = parcel.readInt();
            this.f3760b = parcel.readInt() != 0;
        }

        @Override // androidx.d.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3759a);
            parcel.writeInt(this.f3760b ? 1 : 0);
        }
    }
}
