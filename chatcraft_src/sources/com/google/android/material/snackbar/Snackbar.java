package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* loaded from: classes.dex */
public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] f = {a.b.snackbarButtonStyle};
    private final AccessibilityManager d;
    private boolean e;

    private Snackbar(ViewGroup viewGroup, View view, a aVar) {
        super(viewGroup, view, aVar);
        this.d = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void e() {
        super.e();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void f() {
        super.f();
    }

    public static Snackbar a(View view, CharSequence charSequence, int i) {
        ViewGroup viewGroupA = a(view);
        if (viewGroupA == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(viewGroupA.getContext()).inflate(a(viewGroupA.getContext()) ? a.h.mtrl_layout_snackbar_include : a.h.design_layout_snackbar_include, viewGroupA, false);
        Snackbar snackbar = new Snackbar(viewGroupA, snackbarContentLayout, snackbarContentLayout);
        snackbar.a(charSequence);
        snackbar.a(i);
        return snackbar;
    }

    protected static boolean a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public static Snackbar a(View view, int i, int i2) {
        return a(view, view.getResources().getText(i), i2);
    }

    private static ViewGroup a(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    public Snackbar a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f3841b.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar a(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f3841b.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.e = false;
        } else {
            this.e = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.Snackbar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.b(1);
                }
            });
        }
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int c() {
        if (this.e && this.d.isTouchExplorationEnabled()) {
            return -2;
        }
        return super.c();
    }

    public Snackbar e(int i) {
        ((SnackbarContentLayout) this.f3841b.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.e {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }
}
