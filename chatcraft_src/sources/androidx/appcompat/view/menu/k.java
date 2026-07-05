package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public class k extends androidx.appcompat.view.menu.c<androidx.core.b.a.b> implements MenuItem {
    private Method c;

    k(Context context, androidx.core.b.a.b bVar) {
        super(context, bVar);
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((androidx.core.b.a.b) this.f220b).getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((androidx.core.b.a.b) this.f220b).getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((androidx.core.b.a.b) this.f220b).getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f220b).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((androidx.core.b.a.b) this.f220b).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((androidx.core.b.a.b) this.f220b).getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f220b).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((androidx.core.b.a.b) this.f220b).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((androidx.core.b.a.b) this.f220b).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((androidx.core.b.a.b) this.f220b).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((androidx.core.b.a.b) this.f220b).getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((androidx.core.b.a.b) this.f220b).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((androidx.core.b.a.b) this.f220b).getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((androidx.core.b.a.b) this.f220b).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        ((androidx.core.b.a.b) this.f220b).setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((androidx.core.b.a.b) this.f220b).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        ((androidx.core.b.a.b) this.f220b).setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((androidx.core.b.a.b) this.f220b).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((androidx.core.b.a.b) this.f220b).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((androidx.core.b.a.b) this.f220b).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        ((androidx.core.b.a.b) this.f220b).setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((androidx.core.b.a.b) this.f220b).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((androidx.core.b.a.b) this.f220b).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((androidx.core.b.a.b) this.f220b).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((androidx.core.b.a.b) this.f220b).isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((androidx.core.b.a.b) this.f220b).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((androidx.core.b.a.b) this.f220b).isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((androidx.core.b.a.b) this.f220b).setVisible(z);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((androidx.core.b.a.b) this.f220b).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((androidx.core.b.a.b) this.f220b).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((androidx.core.b.a.b) this.f220b).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((androidx.core.b.a.b) this.f220b).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(((androidx.core.b.a.b) this.f220b).getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((androidx.core.b.a.b) this.f220b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((androidx.core.b.a.b) this.f220b).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((androidx.core.b.a.b) this.f220b).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((androidx.core.b.a.b) this.f220b).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((androidx.core.b.a.b) this.f220b).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((androidx.core.b.a.b) this.f220b).setActionView(i);
        View actionView = ((androidx.core.b.a.b) this.f220b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((androidx.core.b.a.b) this.f220b).setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((androidx.core.b.a.b) this.f220b).getActionView();
        return actionView instanceof b ? ((b) actionView).c() : actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((androidx.core.b.a.b) this.f220b).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.g.b bVarA = ((androidx.core.b.a.b) this.f220b).a();
        if (bVarA instanceof a) {
            return ((a) bVarA).f243a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((androidx.core.b.a.b) this.f220b).expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((androidx.core.b.a.b) this.f220b).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((androidx.core.b.a.b) this.f220b).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((androidx.core.b.a.b) this.f220b).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f220b).setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return ((androidx.core.b.a.b) this.f220b).getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f220b).setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return ((androidx.core.b.a.b) this.f220b).getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((androidx.core.b.a.b) this.f220b).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return ((androidx.core.b.a.b) this.f220b).getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((androidx.core.b.a.b) this.f220b).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return ((androidx.core.b.a.b) this.f220b).getIconTintMode();
    }

    public void a(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.c == null) {
                this.c = ((androidx.core.b.a.b) this.f220b).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.c.invoke(this.f220b, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    a a(ActionProvider actionProvider) {
        return new a(this.f219a, actionProvider);
    }

    /* compiled from: MenuItemWrapperICS.java */
    private class d extends androidx.appcompat.view.menu.d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f220b).onMenuItemClick(k.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    private class c extends androidx.appcompat.view.menu.d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f220b).onMenuItemActionExpand(k.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f220b).onMenuItemActionCollapse(k.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    class a extends androidx.core.g.b {

        /* renamed from: a, reason: collision with root package name */
        final ActionProvider f243a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f243a = actionProvider;
        }

        @Override // androidx.core.g.b
        public View a() {
            return this.f243a.onCreateActionView();
        }

        @Override // androidx.core.g.b
        public boolean b() {
            return this.f243a.onPerformDefaultAction();
        }

        @Override // androidx.core.g.b
        public boolean c() {
            return this.f243a.hasSubMenu();
        }

        @Override // androidx.core.g.b
        public void a(SubMenu subMenu) {
            this.f243a.onPrepareSubMenu(k.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    static class b extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f245a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f245a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.c
        public void a() {
            this.f245a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c
        public void b() {
            this.f245a.onActionViewCollapsed();
        }

        View c() {
            return (View) this.f245a;
        }
    }
}
