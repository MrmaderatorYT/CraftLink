package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.au;
import androidx.core.g.q;
import com.google.android.material.a;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends f implements p.a {
    private static final int[] d = {R.attr.state_checked};
    boolean c;
    private final int e;
    private boolean f;
    private final CheckedTextView g;
    private FrameLayout h;
    private androidx.appcompat.view.menu.j i;
    private ColorStateList j;
    private boolean k;
    private Drawable l;
    private final androidx.core.g.a m;

    @Override // androidx.appcompat.view.menu.p.a
    public boolean a() {
        return false;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new androidx.core.g.a() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // androidx.core.g.a
            public void a(View view, androidx.core.g.a.c cVar) {
                super.a(view, cVar);
                cVar.a(NavigationMenuItemView.this.c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.h.design_navigation_menu_item, (ViewGroup) this, true);
        this.e = context.getResources().getDimensionPixelSize(a.d.design_navigation_icon_size);
        this.g = (CheckedTextView) findViewById(a.f.design_menu_item_text);
        this.g.setDuplicateParentStateEnabled(true);
        q.a(this.g, this.m);
    }

    @Override // androidx.appcompat.view.menu.p.a
    public void a(androidx.appcompat.view.menu.j jVar, int i) {
        this.i = jVar;
        setVisibility(jVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            q.a(this, d());
        }
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setTitle(jVar.getTitle());
        setIcon(jVar.getIcon());
        setActionView(jVar.getActionView());
        setContentDescription(jVar.getContentDescription());
        au.a(this, jVar.getTooltipText());
        c();
    }

    private boolean b() {
        return this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null;
    }

    private void c() {
        if (b()) {
            this.g.setVisibility(8);
            if (this.h != null) {
                af.a aVar = (af.a) this.h.getLayoutParams();
                aVar.width = -1;
                this.h.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.g.setVisibility(0);
        if (this.h != null) {
            af.a aVar2 = (af.a) this.h.getLayoutParams();
            aVar2.width = -2;
            this.h.setLayoutParams(aVar2);
        }
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.h == null) {
                this.h = (FrameLayout) ((ViewStub) findViewById(a.f.design_menu_item_action_area_stub)).inflate();
            }
            this.h.removeAllViews();
            this.h.addView(view);
        }
    }

    private StateListDrawable d() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(a.C0018a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    @Override // androidx.appcompat.view.menu.p.a
    public androidx.appcompat.view.menu.j getItemData() {
        return this.i;
    }

    public void setTitle(CharSequence charSequence) {
        this.g.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.c != z) {
            this.c = z;
            this.m.a(this.g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
                androidx.core.graphics.drawable.a.a(drawable, this.j);
            }
            drawable.setBounds(0, 0, this.e, this.e);
        } else if (this.f) {
            if (this.l == null) {
                this.l = androidx.core.a.a.f.a(getResources(), a.e.navigation_empty_icon, getContext().getTheme());
                if (this.l != null) {
                    this.l.setBounds(0, 0, this.e, this.e);
                }
            }
            drawable = this.l;
        }
        androidx.core.widget.i.a(this.g, drawable, null, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.i != null && this.i.isCheckable() && this.i.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, d);
        }
        return iArrOnCreateDrawableState;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.k = this.j != null;
        if (this.i != null) {
            setIcon(this.i.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        androidx.core.widget.i.a(this.g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.g.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f = z;
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIconPadding(int i) {
        this.g.setCompoundDrawablePadding(i);
    }
}
