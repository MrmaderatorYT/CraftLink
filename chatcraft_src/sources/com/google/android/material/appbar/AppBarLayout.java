package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.i;
import androidx.core.g.o;
import androidx.core.g.q;
import androidx.core.g.y;
import com.google.android.material.a;
import com.google.android.material.internal.h;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.c(a = Behavior.class)
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f3719a;

    /* renamed from: b, reason: collision with root package name */
    private int f3720b;
    private int c;
    private boolean d;
    private int e;
    private y f;
    private List<a> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int[] l;

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f3719a = -1;
        this.f3720b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this);
            e.a(this, attributeSet, 0, a.j.Widget_Design_AppBarLayout);
        }
        TypedArray typedArrayA = h.a(context, attributeSet, a.k.AppBarLayout, 0, a.j.Widget_Design_AppBarLayout, new int[0]);
        q.a(this, typedArrayA.getDrawable(a.k.AppBarLayout_android_background));
        if (typedArrayA.hasValue(a.k.AppBarLayout_expanded)) {
            a(typedArrayA.getBoolean(a.k.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && typedArrayA.hasValue(a.k.AppBarLayout_elevation)) {
            e.a(this, typedArrayA.getDimensionPixelSize(a.k.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (typedArrayA.hasValue(a.k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayA.getBoolean(a.k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayA.hasValue(a.k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayA.getBoolean(a.k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = typedArrayA.getBoolean(a.k.AppBarLayout_liftOnScroll, false);
        typedArrayA.recycle();
        q.a(this, new o() { // from class: com.google.android.material.appbar.AppBarLayout.1
            @Override // androidx.core.g.o
            public y a(View view, y yVar) {
                return AppBarLayout.this.a(yVar);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        g();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g();
        this.d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (((b) getChildAt(i5).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            }
            i5++;
        }
        if (this.h) {
            return;
        }
        b(this.k || f());
    }

    private boolean f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((b) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        this.f3719a = -1;
        this.f3720b = -1;
        this.c = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        a(z, q.x(this));
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        this.e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new b((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    boolean b() {
        return this.d;
    }

    public final int getTotalScrollRange() {
        if (this.f3719a != -1) {
            return this.f3719a;
        }
        int childCount = getChildCount();
        int i = 0;
        int iK = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = bVar.f3727a;
            if ((i2 & 1) == 0) {
                break;
            }
            iK += measuredHeight + bVar.topMargin + bVar.bottomMargin;
            if ((i2 & 2) != 0) {
                iK -= q.k(childAt);
                break;
            }
            i++;
        }
        int iMax = Math.max(0, iK - getTopInset());
        this.f3719a = iMax;
        return iMax;
    }

    boolean c() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        if (this.f3720b != -1) {
            return this.f3720b;
        }
        int topInset = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = bVar.f3727a;
            if ((i & 5) != 5) {
                if (topInset > 0) {
                    break;
                }
            } else {
                int i2 = topInset + bVar.topMargin + bVar.bottomMargin;
                if ((i & 8) != 0) {
                    topInset = i2 + q.k(childAt);
                } else if ((i & 2) != 0) {
                    topInset = i2 + (measuredHeight - q.k(childAt));
                } else {
                    topInset = i2 + (measuredHeight - getTopInset());
                }
            }
        }
        int iMax = Math.max(0, topInset);
        this.f3720b = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        if (this.c != -1) {
            return this.c;
        }
        int childCount = getChildCount();
        int i = 0;
        int iK = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin;
            int i2 = bVar.f3727a;
            if ((i2 & 1) == 0) {
                break;
            }
            iK += measuredHeight;
            if ((i2 & 2) != 0) {
                iK -= q.k(childAt) + getTopInset();
                break;
            }
            i++;
        }
        int iMax = Math.max(0, iK);
        this.c = iMax;
        return iMax;
    }

    void a(int i) {
        if (this.g != null) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.g.get(i2);
                if (aVar != null) {
                    aVar.a(this, i);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iK = q.k(this);
        if (iK != 0) {
            return (iK * 2) + topInset;
        }
        int childCount = getChildCount();
        int iK2 = childCount >= 1 ? q.k(getChildAt(childCount - 1)) : 0;
        return iK2 != 0 ? (iK2 * 2) + topInset : getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.l == null) {
            this.l = new int[4];
        }
        int[] iArr = this.l;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.i ? a.b.state_liftable : -a.b.state_liftable;
        iArr[1] = (this.i && this.j) ? a.b.state_lifted : -a.b.state_lifted;
        iArr[2] = this.i ? a.b.state_collapsible : -a.b.state_collapsible;
        iArr[3] = (this.i && this.j) ? a.b.state_collapsed : -a.b.state_collapsed;
        return mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    private boolean b(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    boolean a(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    public boolean d() {
        return this.k;
    }

    @Deprecated
    public void setTargetElevation(float f) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this, f);
        }
    }

    int getPendingAction() {
        return this.e;
    }

    void e() {
        this.e = 0;
    }

    final int getTopInset() {
        if (this.f != null) {
            return this.f.b();
        }
        return 0;
    }

    y a(y yVar) {
        y yVar2 = q.q(this) ? yVar : null;
        if (!androidx.core.f.c.a(this.f, yVar2)) {
            this.f = yVar2;
            g();
        }
        return yVar;
    }

    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f3727a;

        /* renamed from: b, reason: collision with root package name */
        Interpolator f3728b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3727a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.AppBarLayout_Layout);
            this.f3727a = typedArrayObtainStyledAttributes.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f3728b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f3727a = 1;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3727a = 1;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3727a = 1;
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3727a = 1;
        }

        public int a() {
            return this.f3727a;
        }

        public Interpolator b() {
            return this.f3728b;
        }

        boolean c() {
            return (this.f3727a & 1) == 1 && (this.f3727a & 10) != 0;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: b */
        public /* bridge */ /* synthetic */ Parcelable d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* renamed from: b, reason: collision with root package name */
        private int f3722b;
        private int c;
        private ValueAnimator d;
        private int e;
        private boolean f;
        private float g;
        private WeakReference<View> h;
        private a i;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        public BaseBehavior() {
            this.e = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && (t.d() || a(coordinatorLayout, (CoordinatorLayout) t, view));
            if (z && this.d != null) {
                this.d.cancel();
            }
            this.h = null;
            this.c = i2;
            return z;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i5 = -t.getTotalScrollRange();
                    i4 = i5;
                    downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i5;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i4 != downNestedPreScrollRange) {
                    iArr[1] = b(coordinatorLayout, (CoordinatorLayout) t, i2, i4, downNestedPreScrollRange);
                    a(i2, (int) t, view, i3);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                b(coordinatorLayout, (CoordinatorLayout) t, i4, -t.getDownNestedScrollRange(), 0);
                a(i4, (int) t, view, i5);
            }
            if (t.d()) {
                t.a(view.getScrollY() > 0);
            }
        }

        private void a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int iB = b();
                if ((i >= 0 || iB != 0) && (i <= 0 || iB != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                q.d(view, 1);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.c == 0 || i == 1) {
                c(coordinatorLayout, (CoordinatorLayout) t);
            }
            this.h = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            int iAbs = Math.abs(b() - i);
            float fAbs = Math.abs(f);
            if (fAbs > 0.0f) {
                height = Math.round((iAbs / fAbs) * 1000.0f) * 3;
            } else {
                height = (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (CoordinatorLayout) t, i, height);
        }

        private void a(final CoordinatorLayout coordinatorLayout, final T t, int i, int i2) {
            int iB = b();
            if (iB == i) {
                if (this.d == null || !this.d.isRunning()) {
                    return;
                }
                this.d.cancel();
                return;
            }
            if (this.d == null) {
                this.d = new ValueAnimator();
                this.d.setInterpolator(com.google.android.material.a.a.e);
                this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.a_(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.d.cancel();
            }
            this.d.setDuration(Math.min(i2, 600));
            this.d.setIntValues(iB, i);
            this.d.start();
        }

        private int a(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (a(bVar.a(), 32)) {
                    top -= bVar.topMargin;
                    bottom += bVar.bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private void c(CoordinatorLayout coordinatorLayout, T t) {
            int iB = b();
            int iA = a((BaseBehavior<T>) t, iB);
            if (iA >= 0) {
                View childAt = t.getChildAt(iA);
                b bVar = (b) childAt.getLayoutParams();
                int iA2 = bVar.a();
                if ((iA2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int iK = -childAt.getBottom();
                    if (iA == t.getChildCount() - 1) {
                        iK += t.getTopInset();
                    }
                    if (a(iA2, 2)) {
                        iK += q.k(childAt);
                    } else if (a(iA2, 5)) {
                        int iK2 = q.k(childAt) + iK;
                        if (iB < iK2) {
                            i = iK2;
                        } else {
                            iK = iK2;
                        }
                    }
                    if (a(iA2, 32)) {
                        i += bVar.topMargin;
                        iK -= bVar.bottomMargin;
                    }
                    if (iB < (iK + i) / 2) {
                        i = iK;
                    }
                    a(coordinatorLayout, (CoordinatorLayout) t, androidx.core.c.a.a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.e) t.getLayoutParams()).height == -2) {
                coordinatorLayout.a(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.a(coordinatorLayout, (CoordinatorLayout) t, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int iRound;
            boolean zA = super.a(coordinatorLayout, (CoordinatorLayout) t, i);
            int pendingAction = t.getPendingAction();
            if (this.e >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(this.e);
                int i2 = -childAt.getBottom();
                if (this.f) {
                    iRound = i2 + q.k(childAt) + t.getTopInset();
                } else {
                    iRound = i2 + Math.round(childAt.getHeight() * this.g);
                }
                a_(coordinatorLayout, t, iRound);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, i3, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, 0);
                    }
                }
            }
            t.e();
            this.e = -1;
            a(androidx.core.c.a.a(c(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (CoordinatorLayout) t, c(), 0, true);
            t.a(c());
            return zA;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean c(T t) {
            if (this.i != null) {
                return this.i.a(t);
            }
            if (this.h == null) {
                return true;
            }
            View view = this.h.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(CoordinatorLayout coordinatorLayout, T t) {
            c(coordinatorLayout, (CoordinatorLayout) t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(T t) {
            return t.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        public int a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int iB = b();
            int i4 = 0;
            if (i2 != 0 && iB >= i2 && iB <= i3) {
                int iA = androidx.core.c.a.a(i, i2, i3);
                if (iB != iA) {
                    int iB2 = t.b() ? b((BaseBehavior<T>) t, iA) : iA;
                    boolean zA = a(iB2);
                    i4 = iB - iA;
                    this.f3722b = iA - iB2;
                    if (!zA && t.b()) {
                        coordinatorLayout.b(t);
                    }
                    t.a(c());
                    a(coordinatorLayout, (CoordinatorLayout) t, iA, iA < iB ? -1 : 1, false);
                }
            } else {
                this.f3722b = 0;
            }
            return i4;
        }

        private int b(T t, int i) {
            int iAbs = Math.abs(i);
            int childCount = t.getChildCount();
            int topInset = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                Interpolator interpolatorB = bVar.b();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i2++;
                } else if (interpolatorB != null) {
                    int iA = bVar.a();
                    if ((iA & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + bVar.topMargin + bVar.bottomMargin;
                        if ((iA & 2) != 0) {
                            topInset -= q.k(childAt);
                        }
                    }
                    if (q.q(childAt)) {
                        topInset -= t.getTopInset();
                    }
                    if (topInset > 0) {
                        float f = topInset;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * interpolatorB.getInterpolation((iAbs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = c(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$b r1 = (com.google.android.material.appbar.AppBarLayout.b) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = androidx.core.g.q.k(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = 1
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = 0
            L42:
                boolean r9 = r7.d()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.a(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L56
                r8 = 1
                goto L57
            L56:
                r8 = 0
            L57:
                boolean r8 = r7.a(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.d(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        private boolean d(CoordinatorLayout coordinatorLayout, T t) {
            List<View> listD = coordinatorLayout.d(t);
            int size = listD.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.b bVarB = ((CoordinatorLayout.e) listD.get(i).getLayoutParams()).b();
                if (bVarB instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) bVarB).d() != 0;
                }
            }
            return false;
        }

        private static View c(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof i) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.a
        int b() {
            return c() + this.f3722b;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable parcelableD = super.d(coordinatorLayout, (CoordinatorLayout) t);
            int iC = c();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + iC;
                if (childAt.getTop() + iC <= 0 && bottom >= 0) {
                    b bVar = new b(parcelableD);
                    bVar.f3725a = i;
                    bVar.d = bottom == q.k(childAt) + t.getTopInset();
                    bVar.f3726b = bottom / childAt.getHeight();
                    return bVar;
                }
            }
            return parcelableD;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof b) {
                b bVar = (b) parcelable;
                super.a(coordinatorLayout, (CoordinatorLayout) t, bVar.a());
                this.e = bVar.f3725a;
                this.g = bVar.f3726b;
                this.f = bVar.d;
                return;
            }
            super.a(coordinatorLayout, (CoordinatorLayout) t, parcelable);
            this.e = -1;
        }

        protected static class b extends androidx.d.a.a {
            public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.b.1
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
            int f3725a;

            /* renamed from: b, reason: collision with root package name */
            float f3726b;
            boolean d;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f3725a = parcel.readInt();
                this.f3726b = parcel.readFloat();
                this.d = parcel.readByte() != 0;
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.d.a.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f3725a);
                parcel.writeFloat(this.f3726b);
                parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            }
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, (CoordinatorLayout) view, i);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.b
        /* synthetic */ View b(List list) {
            return a((List<View>) list);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ScrollingViewBehavior_Layout);
            b(typedArrayObtainStyledAttributes.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutA = a(coordinatorLayout.c(view));
            if (appBarLayoutA != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f3733a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutA.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void a(View view, View view2) {
            CoordinatorLayout.b bVarB = ((CoordinatorLayout.e) view2.getLayoutParams()).b();
            if (bVarB instanceof BaseBehavior) {
                q.e(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) bVarB).f3722b) + b()) - c(view2));
            }
        }

        @Override // com.google.android.material.appbar.b
        float a(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iA = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iA > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iA / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.b bVarB = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).b();
            if (bVarB instanceof BaseBehavior) {
                return ((BaseBehavior) bVarB).b();
            }
            return 0;
        }

        AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.b
        int b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.b(view);
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.d()) {
                    appBarLayout.a(view.getScrollY() > 0);
                }
            }
        }
    }
}
