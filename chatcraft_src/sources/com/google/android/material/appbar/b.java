package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.q;
import androidx.core.g.y;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes.dex */
abstract class b extends c<View> {

    /* renamed from: a, reason: collision with root package name */
    final Rect f3733a;

    /* renamed from: b, reason: collision with root package name */
    final Rect f3734b;
    private int c;
    private int d;

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    float a(View view) {
        return 1.0f;
    }

    abstract View b(List<View> list);

    public b() {
        this.f3733a = new Rect();
        this.f3734b = new Rect();
        this.c = 0;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3733a = new Rect();
        this.f3734b = new Rect();
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewB;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewB = b(coordinatorLayout.c(view))) == null) {
            return false;
        }
        if (q.q(viewB) && !q.q(view)) {
            q.b(view, true);
            if (q.q(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - viewB.getMeasuredHeight()) + b(viewB), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    @Override // com.google.android.material.appbar.c
    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewB = b(coordinatorLayout.c(view));
        if (viewB != null) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
            Rect rect = this.f3733a;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, viewB.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + viewB.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            y lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && q.q(coordinatorLayout) && !q.q(view)) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f3734b;
            androidx.core.g.c.a(c(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int iC = c(viewB);
            view.layout(rect2.left, rect2.top - iC, rect2.right, rect2.bottom - iC);
            this.c = rect2.top - viewB.getBottom();
            return;
        }
        super.b(coordinatorLayout, (CoordinatorLayout) view, i);
        this.c = 0;
    }

    final int c(View view) {
        if (this.d == 0) {
            return 0;
        }
        return androidx.core.c.a.a((int) (a(view) * this.d), 0, this.d);
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    final int b() {
        return this.c;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final int d() {
        return this.d;
    }
}
