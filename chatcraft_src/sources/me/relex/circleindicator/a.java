package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import me.relex.circleindicator.c;

/* compiled from: BaseCircleIndicator.java */
/* loaded from: classes.dex */
class a extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    protected int f5041a;

    /* renamed from: b, reason: collision with root package name */
    protected int f5042b;
    protected int c;
    protected int d;
    protected int e;
    protected Animator f;
    protected Animator g;
    protected Animator h;
    protected Animator i;
    protected int j;

    public a(Context context) {
        super(context);
        this.f5041a = -1;
        this.f5042b = -1;
        this.c = -1;
        this.j = -1;
        a(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5041a = -1;
        this.f5042b = -1;
        this.c = -1;
        this.j = -1;
        a(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5041a = -1;
        this.f5042b = -1;
        this.c = -1;
        this.j = -1;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5041a = -1;
        this.f5042b = -1;
        this.c = -1;
        this.j = -1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        a(b(context, attributeSet));
    }

    private b b(Context context, AttributeSet attributeSet) {
        b bVar = new b();
        if (attributeSet == null) {
            return bVar;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.C0121c.BaseCircleIndicator);
        bVar.f5044a = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.C0121c.BaseCircleIndicator_ci_width, -1);
        bVar.f5045b = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.C0121c.BaseCircleIndicator_ci_height, -1);
        bVar.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.C0121c.BaseCircleIndicator_ci_margin, -1);
        bVar.d = typedArrayObtainStyledAttributes.getResourceId(c.C0121c.BaseCircleIndicator_ci_animator, c.a.scale_with_alpha);
        bVar.e = typedArrayObtainStyledAttributes.getResourceId(c.C0121c.BaseCircleIndicator_ci_animator_reverse, 0);
        bVar.f = typedArrayObtainStyledAttributes.getResourceId(c.C0121c.BaseCircleIndicator_ci_drawable, c.b.white_radius);
        bVar.g = typedArrayObtainStyledAttributes.getResourceId(c.C0121c.BaseCircleIndicator_ci_drawable_unselected, bVar.f);
        bVar.h = typedArrayObtainStyledAttributes.getInt(c.C0121c.BaseCircleIndicator_ci_orientation, -1);
        bVar.i = typedArrayObtainStyledAttributes.getInt(c.C0121c.BaseCircleIndicator_ci_gravity, -1);
        typedArrayObtainStyledAttributes.recycle();
        return bVar;
    }

    public void a(b bVar) {
        int iApplyDimension = (int) (TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()) + 0.5f);
        this.f5042b = bVar.f5044a < 0 ? iApplyDimension : bVar.f5044a;
        this.c = bVar.f5045b < 0 ? iApplyDimension : bVar.f5045b;
        if (bVar.c >= 0) {
            iApplyDimension = bVar.c;
        }
        this.f5041a = iApplyDimension;
        this.f = b(bVar);
        this.h = b(bVar);
        this.h.setDuration(0L);
        this.g = c(bVar);
        this.i = c(bVar);
        this.i.setDuration(0L);
        this.d = bVar.f == 0 ? c.b.white_radius : bVar.f;
        this.e = bVar.g == 0 ? bVar.f : bVar.g;
        setOrientation(bVar.h != 1 ? 0 : 1);
        setGravity(bVar.i >= 0 ? bVar.i : 17);
    }

    protected Animator b(b bVar) {
        return AnimatorInflater.loadAnimator(getContext(), bVar.d);
    }

    protected Animator c(b bVar) throws Resources.NotFoundException {
        if (bVar.e == 0) {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), bVar.d);
            animatorLoadAnimator.setInterpolator(new InterpolatorC0120a());
            return animatorLoadAnimator;
        }
        return AnimatorInflater.loadAnimator(getContext(), bVar.e);
    }

    protected void a(int i, int i2) {
        int orientation = getOrientation();
        for (int i3 = 0; i3 < i; i3++) {
            if (i2 == i3) {
                a(orientation, this.d, this.h);
            } else {
                a(orientation, this.e, this.i);
            }
        }
    }

    protected void a(int i, int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.f5042b, this.c);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = this.f5041a;
            layoutParams.rightMargin = this.f5041a;
        } else {
            layoutParams.topMargin = this.f5041a;
            layoutParams.bottomMargin = this.f5041a;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    protected void a(int i) {
        View childAt;
        if (this.g.isRunning()) {
            this.g.end();
            this.g.cancel();
        }
        if (this.f.isRunning()) {
            this.f.end();
            this.f.cancel();
        }
        if (this.j >= 0 && (childAt = getChildAt(this.j)) != null) {
            childAt.setBackgroundResource(this.e);
            this.g.setTarget(childAt);
            this.g.start();
        }
        View childAt2 = getChildAt(i);
        if (childAt2 != null) {
            childAt2.setBackgroundResource(this.d);
            this.f.setTarget(childAt2);
            this.f.start();
        }
    }

    /* compiled from: BaseCircleIndicator.java */
    /* renamed from: me.relex.circleindicator.a$a, reason: collision with other inner class name */
    protected class InterpolatorC0120a implements Interpolator {
        protected InterpolatorC0120a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }
}
