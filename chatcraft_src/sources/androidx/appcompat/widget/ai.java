package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public class ai extends ag implements ah {

    /* renamed from: a, reason: collision with root package name */
    private static Method f344a;

    /* renamed from: b, reason: collision with root package name */
    private ah f345b;

    static {
        try {
            f344a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public ai(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.appcompat.widget.ag
    ac a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void a(ah ahVar) {
        this.f345b = ahVar;
    }

    public void c(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f344a != null) {
            try {
                f344a.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.ah
    public void b(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
        if (this.f345b != null) {
            this.f345b.b(hVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.ah
    public void a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
        if (this.f345b != null) {
            this.f345b.a(hVar, menuItem);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    public static class a extends ac {

        /* renamed from: b, reason: collision with root package name */
        final int f346b;
        final int c;
        private ah d;
        private MenuItem e;

        @Override // androidx.appcompat.widget.ac
        public /* bridge */ /* synthetic */ int a(int i, int i2, int i3, int i4, int i5) {
            return super.a(i, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.ac
        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i) {
            return super.a(motionEvent, i);
        }

        @Override // androidx.appcompat.widget.ac, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.ac, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.ac, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.ac, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.ac, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.ac, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f346b = 21;
                this.c = 22;
            } else {
                this.f346b = 22;
                this.c = 21;
            }
        }

        public void setHoverListener(ah ahVar) {
            this.d = ahVar;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f346b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i == this.c) {
                setSelection(-1);
                ((androidx.appcompat.view.menu.g) getAdapter()).a().a(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // androidx.appcompat.widget.ac, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            androidx.appcompat.view.menu.g gVar;
            int iPointToPosition;
            int i;
            if (this.d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    gVar = (androidx.appcompat.view.menu.g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    gVar = (androidx.appcompat.view.menu.g) adapter;
                }
                androidx.appcompat.view.menu.j item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < gVar.getCount()) {
                    item = gVar.getItem(i);
                }
                MenuItem menuItem = this.e;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.h hVarA = gVar.a();
                    if (menuItem != null) {
                        this.d.a(hVarA, menuItem);
                    }
                    this.e = item;
                    if (item != null) {
                        this.d.b(hVarA, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
