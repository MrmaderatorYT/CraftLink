package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;

/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
abstract class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected final C0025a f319a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f320b;
    protected ActionMenuView c;
    protected c d;
    protected int e;
    protected androidx.core.g.u f;
    private boolean g;
    private boolean h;

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f319a = new C0025a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.C0018a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f320b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f320b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, a.j.ActionBar, a.C0018a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        if (this.d != null) {
            this.d.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.e;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.f319a.f321a;
        }
        return getVisibility();
    }

    public androidx.core.g.u a(int i, long j) {
        if (this.f != null) {
            this.f.b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            androidx.core.g.u uVarA = androidx.core.g.q.l(this).a(1.0f);
            uVarA.a(j);
            uVarA.a(this.f319a.a(uVarA, i));
            return uVarA;
        }
        androidx.core.g.u uVarA2 = androidx.core.g.q.l(this).a(0.0f);
        uVarA2.a(j);
        uVarA2.a(this.f319a.a(uVarA2, i));
        return uVarA2;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f != null) {
                this.f.b();
            }
            super.setVisibility(i);
        }
    }

    public boolean a() {
        if (this.d != null) {
            return this.d.d();
        }
        return false;
    }

    protected int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0025a implements androidx.core.g.v {

        /* renamed from: a, reason: collision with root package name */
        int f321a;
        private boolean c = false;

        protected C0025a() {
        }

        public C0025a a(androidx.core.g.u uVar, int i) {
            a.this.f = uVar;
            this.f321a = i;
            return this;
        }

        @Override // androidx.core.g.v
        public void a(View view) {
            a.super.setVisibility(0);
            this.c = false;
        }

        @Override // androidx.core.g.v
        public void b(View view) {
            if (this.c) {
                return;
            }
            a.this.f = null;
            a.super.setVisibility(this.f321a);
        }

        @Override // androidx.core.g.v
        public void c(View view) {
            this.c = true;
        }
    }
}
