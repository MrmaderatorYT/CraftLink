package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.a;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a, reason: collision with root package name */
    private int f3744a;

    /* renamed from: b, reason: collision with root package name */
    private int f3745b;
    private ViewPropertyAnimator c;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior() {
        this.f3744a = 0;
        this.f3745b = 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3744a = 0;
        this.f3745b = 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f3744a = v.getMeasuredHeight();
        return super.a(coordinatorLayout, (CoordinatorLayout) v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.f3745b != 1 && i2 > 0) {
            b(v);
        } else {
            if (this.f3745b == 2 || i2 >= 0) {
                return;
            }
            a((HideBottomViewOnScrollBehavior<V>) v);
        }
    }

    protected void a(V v) {
        if (this.c != null) {
            this.c.cancel();
            v.clearAnimation();
        }
        this.f3745b = 2;
        a((HideBottomViewOnScrollBehavior<V>) v, 0, 225L, a.d);
    }

    protected void b(V v) {
        if (this.c != null) {
            this.c.cancel();
            v.clearAnimation();
        }
        this.f3745b = 1;
        a((HideBottomViewOnScrollBehavior<V>) v, this.f3744a, 175L, a.c);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.c = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.c = null;
            }
        });
    }
}
