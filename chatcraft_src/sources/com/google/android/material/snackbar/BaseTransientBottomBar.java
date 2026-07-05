package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.a.b;
import androidx.core.g.o;
import androidx.core.g.q;
import androidx.core.g.y;
import com.google.android.material.a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.h;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    static final Handler f3840a;
    private static final boolean d;
    private static final int[] e;

    /* renamed from: b, reason: collision with root package name */
    protected final e f3841b;
    final b.a c = new b.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
        @Override // com.google.android.material.snackbar.b.a
        public void a() {
            BaseTransientBottomBar.f3840a.sendMessage(BaseTransientBottomBar.f3840a.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.a
        public void a(int i) {
            BaseTransientBottomBar.f3840a.sendMessage(BaseTransientBottomBar.f3840a.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    };
    private final ViewGroup f;
    private final Context g;
    private final com.google.android.material.snackbar.a h;
    private int i;
    private List<a<B>> j;
    private Behavior k;
    private final AccessibilityManager l;

    public static abstract class a<B> {
        public void a(B b2) {
        }

        public void a(B b2, int i) {
        }
    }

    protected interface c {
        void a(View view);

        void b(View view);
    }

    protected interface d {
        void a(View view, int i, int i2, int i3, int i4);
    }

    static {
        d = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        e = new int[]{a.b.snackbarStyle};
        f3840a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((BaseTransientBottomBar) message.obj).i();
                        break;
                    case 1:
                        ((BaseTransientBottomBar) message.obj).c(message.arg1);
                        break;
                }
                return true;
            }
        });
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f = viewGroup;
        this.h = aVar;
        this.g = viewGroup.getContext();
        h.a(this.g);
        this.f3841b = (e) LayoutInflater.from(this.g).inflate(a(), this.f, false);
        this.f3841b.addView(view);
        q.c(this.f3841b, 1);
        q.b(this.f3841b, 1);
        q.b((View) this.f3841b, true);
        q.a(this.f3841b, new o() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
            @Override // androidx.core.g.o
            public y a(View view2, y yVar) {
                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), yVar.d());
                return yVar;
            }
        });
        q.a(this.f3841b, new androidx.core.g.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
            @Override // androidx.core.g.a
            public void a(View view2, androidx.core.g.a.c cVar) {
                super.a(view2, cVar);
                cVar.a(1048576);
                cVar.e(true);
            }

            @Override // androidx.core.g.a
            public boolean a(View view2, int i, Bundle bundle) {
                if (i == 1048576) {
                    BaseTransientBottomBar.this.f();
                    return true;
                }
                return super.a(view2, i, bundle);
            }
        });
        this.l = (AccessibilityManager) this.g.getSystemService("accessibility");
    }

    protected int a() {
        return b() ? a.h.mtrl_layout_snackbar : a.h.design_layout_snackbar;
    }

    protected boolean b() {
        TypedArray typedArrayObtainStyledAttributes = this.g.obtainStyledAttributes(e);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public B a(int i) {
        this.i = i;
        return this;
    }

    public int c() {
        return this.i;
    }

    public View d() {
        return this.f3841b;
    }

    public void e() {
        com.google.android.material.snackbar.b.a().a(c(), this.c);
    }

    public void f() {
        b(3);
    }

    protected void b(int i) {
        com.google.android.material.snackbar.b.a().a(this.c, i);
    }

    public boolean g() {
        return com.google.android.material.snackbar.b.a().e(this.c);
    }

    protected SwipeDismissBehavior<? extends View> h() {
        return new Behavior();
    }

    final void i() {
        if (this.f3841b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f3841b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) layoutParams;
                SwipeDismissBehavior<? extends View> swipeDismissBehaviorH = this.k == null ? h() : this.k;
                if (swipeDismissBehaviorH instanceof Behavior) {
                    ((Behavior) swipeDismissBehaviorH).a((BaseTransientBottomBar<?>) this);
                }
                swipeDismissBehaviorH.a(new SwipeDismissBehavior.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
                    public void a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.b(0);
                    }

                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                com.google.android.material.snackbar.b.a().d(BaseTransientBottomBar.this.c);
                                break;
                            case 1:
                            case 2:
                                com.google.android.material.snackbar.b.a().c(BaseTransientBottomBar.this.c);
                                break;
                        }
                    }
                });
                eVar.a(swipeDismissBehaviorH);
                eVar.g = 80;
            }
            this.f.addView(this.f3841b);
        }
        this.f3841b.setOnAttachStateChangeListener(new c() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
            public void a(View view) {
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
            public void b(View view) {
                if (BaseTransientBottomBar.this.g()) {
                    BaseTransientBottomBar.f3840a.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseTransientBottomBar.this.d(3);
                        }
                    });
                }
            }
        });
        if (q.x(this.f3841b)) {
            if (l()) {
                j();
                return;
            } else {
                k();
                return;
            }
        }
        this.f3841b.setOnLayoutChangeListener(new d() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.d
            public void a(View view, int i, int i2, int i3, int i4) {
                BaseTransientBottomBar.this.f3841b.setOnLayoutChangeListener(null);
                if (BaseTransientBottomBar.this.l()) {
                    BaseTransientBottomBar.this.j();
                } else {
                    BaseTransientBottomBar.this.k();
                }
            }
        });
    }

    void j() {
        final int iN = n();
        if (d) {
            q.e(this.f3841b, iN);
        } else {
            this.f3841b.setTranslationY(iN);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iN, 0);
        valueAnimator.setInterpolator(com.google.android.material.a.a.f3706b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.a(70, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.k();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
            private int c;

            {
                this.c = iN;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.d) {
                    q.e(BaseTransientBottomBar.this.f3841b, iIntValue - this.c);
                } else {
                    BaseTransientBottomBar.this.f3841b.setTranslationY(iIntValue);
                }
                this.c = iIntValue;
            }
        });
        valueAnimator.start();
    }

    private void e(final int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, n());
        valueAnimator.setInterpolator(com.google.android.material.a.a.f3706b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.b(0, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.d(i);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3

            /* renamed from: b, reason: collision with root package name */
            private int f3848b = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.d) {
                    q.e(BaseTransientBottomBar.this.f3841b, iIntValue - this.f3848b);
                } else {
                    BaseTransientBottomBar.this.f3841b.setTranslationY(iIntValue);
                }
                this.f3848b = iIntValue;
            }
        });
        valueAnimator.start();
    }

    private int n() {
        int height = this.f3841b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f3841b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    final void c(int i) {
        if (l() && this.f3841b.getVisibility() == 0) {
            e(i);
        } else {
            d(i);
        }
    }

    void k() {
        com.google.android.material.snackbar.b.a().b(this.c);
        if (this.j != null) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                this.j.get(size).a(this);
            }
        }
    }

    void d(int i) {
        com.google.android.material.snackbar.b.a().a(this.c);
        if (this.j != null) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                this.j.get(size).a(this, i);
            }
        }
        ViewParent parent = this.f3841b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f3841b);
        }
    }

    boolean l() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.l.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    protected static class e extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        private final AccessibilityManager f3857a;

        /* renamed from: b, reason: collision with root package name */
        private final b.a f3858b;
        private d c;
        private c d;

        protected e(Context context) {
            this(context, null);
        }

        protected e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(a.k.SnackbarLayout_elevation)) {
                q.a(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(a.k.SnackbarLayout_elevation, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f3857a = (AccessibilityManager) context.getSystemService("accessibility");
            this.f3858b = new b.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.e.1
                @Override // androidx.core.g.a.b.a
                public void a(boolean z) {
                    e.this.setClickableOrFocusableBasedOnAccessibility(z);
                }
            };
            androidx.core.g.a.b.a(this.f3857a, this.f3858b);
            setClickableOrFocusableBasedOnAccessibility(this.f3857a.isTouchExplorationEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.c != null) {
                this.c.a(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.d != null) {
                this.d.a(this);
            }
            q.p(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.d != null) {
                this.d.b(this);
            }
            androidx.core.g.a.b.b(this.f3857a, this.f3858b);
        }

        void setOnLayoutChangeListener(d dVar) {
            this.c = dVar;
        }

        void setOnAttachStateChangeListener(c cVar) {
            this.d = cVar;
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final b g = new b(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.g.a(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.g.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.g.a(coordinatorLayout, view, motionEvent);
            return super.a(coordinatorLayout, (CoordinatorLayout) view, motionEvent);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private b.a f3856a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.a(0.1f);
            swipeDismissBehavior.b(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f3856a = baseTransientBottomBar.c;
        }

        public boolean a(View view) {
            return view instanceof e;
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            com.google.android.material.snackbar.b.a().c(this.f3856a);
                            break;
                        }
                        break;
                }
            }
            com.google.android.material.snackbar.b.a().d(this.f3856a);
        }
    }
}
