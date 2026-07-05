package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.n;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.p;
import androidx.core.g.q;
import androidx.core.widget.k;
import com.google.android.material.a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.d.c;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.d;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;
import com.google.android.material.internal.j;
import java.util.List;

@CoordinatorLayout.c(a = Behavior.class)
/* loaded from: classes.dex */
public class FloatingActionButton extends j implements p, k, com.google.android.material.d.a {

    /* renamed from: a, reason: collision with root package name */
    boolean f3781a;

    /* renamed from: b, reason: collision with root package name */
    final Rect f3782b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private int g;
    private ColorStateList h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final Rect m;
    private final n n;
    private final c o;
    private com.google.android.material.floatingactionbutton.a p;

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3782b = new Rect();
        this.m = new Rect();
        TypedArray typedArrayA = h.a(context, attributeSet, a.k.FloatingActionButton, i, a.j.Widget_Design_FloatingActionButton, new int[0]);
        this.c = com.google.android.material.f.a.a(context, typedArrayA, a.k.FloatingActionButton_backgroundTint);
        this.d = i.a(typedArrayA.getInt(a.k.FloatingActionButton_backgroundTintMode, -1), null);
        this.h = com.google.android.material.f.a.a(context, typedArrayA, a.k.FloatingActionButton_rippleColor);
        this.i = typedArrayA.getInt(a.k.FloatingActionButton_fabSize, -1);
        this.j = typedArrayA.getDimensionPixelSize(a.k.FloatingActionButton_fabCustomSize, 0);
        this.g = typedArrayA.getDimensionPixelSize(a.k.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayA.getDimension(a.k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayA.getDimension(a.k.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayA.getDimension(a.k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f3781a = typedArrayA.getBoolean(a.k.FloatingActionButton_useCompatPadding, false);
        this.l = typedArrayA.getDimensionPixelSize(a.k.FloatingActionButton_maxImageSize, 0);
        com.google.android.material.a.h hVarA = com.google.android.material.a.h.a(context, typedArrayA, a.k.FloatingActionButton_showMotionSpec);
        com.google.android.material.a.h hVarA2 = com.google.android.material.a.h.a(context, typedArrayA, a.k.FloatingActionButton_hideMotionSpec);
        typedArrayA.recycle();
        this.n = new n(this);
        this.n.a(attributeSet, i);
        this.o = new c(this);
        getImpl().a(this.c, this.d, this.h, this.g);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().c(dimension3);
        getImpl().a(this.l);
        getImpl().a(hVarA);
        getImpl().b(hVarA2);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.k = (sizeDimension - this.l) / 2;
        getImpl().j();
        int iMin = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension(this.f3782b.left + iMin + this.f3782b.right, iMin + this.f3782b.top + this.f3782b.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        if (this.h != null) {
            return this.h.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.h;
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            getImpl().b(this.h);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != colorStateList) {
            this.c = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            getImpl().a(mode);
        }
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.g.p
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.g.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            e();
        }
    }

    @Override // androidx.core.widget.k
    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            e();
        }
    }

    @Override // androidx.core.widget.k
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    private void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (this.e == null) {
            androidx.core.graphics.drawable.a.f(drawable);
            return;
        }
        int colorForState = this.e.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.j.a(colorForState, mode));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.n.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().d();
    }

    public void b() {
        a((a) null);
    }

    public void a(a aVar) {
        a(aVar, true);
    }

    void a(a aVar, boolean z) {
        getImpl().b(c(aVar), z);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public void c() {
        b((a) null);
    }

    public void b(a aVar) {
        b(aVar, true);
    }

    void b(a aVar, boolean z) {
        getImpl().a(c(aVar), z);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    @Override // com.google.android.material.d.b
    public boolean a() {
        return this.o.a();
    }

    public void setExpandedComponentIdHint(int i) {
        this.o.a(i);
    }

    public int getExpandedComponentIdHint() {
        return this.o.c();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f3781a != z) {
            this.f3781a = z;
            getImpl().i();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f3781a;
    }

    public void setSize(int i) {
        this.j = 0;
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.i;
    }

    private a.d c(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a.d() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.a.d
            public void a() {
                aVar.a(FloatingActionButton.this);
            }

            @Override // com.google.android.material.floatingactionbutton.a.d
            public void b() {
                aVar.b(FloatingActionButton.this);
            }
        };
    }

    public boolean d() {
        return getImpl().r();
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        this.j = i;
    }

    public int getCustomSize() {
        return this.j;
    }

    int getSizeDimension() {
        return a(this.i);
    }

    private int a(int i) {
        if (this.j != 0) {
            return this.j;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i == 1) {
                return resources.getDimensionPixelSize(a.d.design_fab_size_mini);
            }
            return resources.getDimensionPixelSize(a.d.design_fab_size_normal);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        }
        return a(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().k();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        com.google.android.material.j.a aVar = new com.google.android.material.j.a(super.onSaveInstanceState());
        aVar.f3839a.put("expandableWidgetHelper", this.o.b());
        return aVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.j.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.j.a aVar = (com.google.android.material.j.a) parcelable;
        super.onRestoreInstanceState(aVar.a());
        this.o.a(aVar.f3839a.get("expandableWidgetHelper"));
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!q.x(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    private void c(Rect rect) {
        rect.left += this.f3782b.left;
        rect.top += this.f3782b.top;
        rect.right -= this.f3782b.right;
        rect.bottom -= this.f3782b.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().h();
    }

    private static int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.m) && !this.m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout.e eVar) {
            super.a(eVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.a(coordinatorLayout, floatingActionButton, i);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.b(coordinatorLayout, floatingActionButton, view);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.b<T> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f3785a;

        /* renamed from: b, reason: collision with root package name */
        private a f3786b;
        private boolean c;

        public BaseBehavior() {
            this.c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.FloatingActionButton_Behavior_Layout);
            this.c = typedArrayObtainStyledAttributes.getBoolean(a.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout.e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, floatingActionButton);
            return false;
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.c && ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f3785a == null) {
                this.f3785a = new Rect();
            }
            Rect rect = this.f3785a;
            d.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.f3786b, false);
                return true;
            }
            floatingActionButton.a(this.f3786b, false);
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.b(this.f3786b, false);
                return true;
            }
            floatingActionButton.a(this.f3786b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> listC = coordinatorLayout.c(floatingActionButton);
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = listC.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.a(floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f3782b;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.f3782b;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= eVar.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                q.e(floatingActionButton, i2);
            }
            if (i != 0) {
                q.f(floatingActionButton, i);
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public void setCompatElevation(float f) {
        getImpl().a(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().b();
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().b(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().c();
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().c(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        return getImpl().e();
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().a(hVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        return getImpl().f();
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().b(hVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.p == null) {
            this.p = f();
        }
        return this.p;
    }

    private com.google.android.material.floatingactionbutton.a f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.material.floatingactionbutton.b(this, new b());
        }
        return new com.google.android.material.floatingactionbutton.a(this, new b());
    }

    private class b implements com.google.android.material.h.b {
        b() {
        }

        @Override // com.google.android.material.h.b
        public float a() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.h.b
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f3782b.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(i + FloatingActionButton.this.k, i2 + FloatingActionButton.this.k, i3 + FloatingActionButton.this.k, i4 + FloatingActionButton.this.k);
        }

        @Override // com.google.android.material.h.b
        public void a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.h.b
        public boolean b() {
            return FloatingActionButton.this.f3781a;
        }
    }
}
