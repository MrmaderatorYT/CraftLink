package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSpinner.java */
/* loaded from: classes.dex */
public class v extends Spinner implements androidx.core.g.p {
    private static final int[] d = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    b f432a;

    /* renamed from: b, reason: collision with root package name */
    int f433b;
    final Rect c;
    private final f e;
    private final Context f;
    private ae g;
    private SpinnerAdapter h;
    private final boolean i;

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.spinnerStyle);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public v(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[PHI: r11 r12
      0x0059: PHI (r11v3 int) = (r11v0 int), (r11v4 int) binds: [B:31:0x006b, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0059: PHI (r12v15 android.content.res.TypedArray) = (r12v14 android.content.res.TypedArray), (r12v17 android.content.res.TypedArray) binds: [B:31:0x006b, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.f432a != null) {
            return this.f;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f432a != null) {
            this.f432a.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.f432a != null) {
            return this.f432a.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.f432a != null) {
            this.f432a.d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.f432a != null) {
            return this.f432a.k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.f432a != null) {
            this.f432a.c(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.f432a != null) {
            return this.f432a.j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f432a != null) {
            this.f433b = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f432a != null) {
            return this.f433b;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.i) {
            this.h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f432a != null) {
            this.f432a.a(new a(spinnerAdapter, (this.f == null ? getContext() : this.f).getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f432a == null || !this.f432a.d()) {
            return;
        }
        this.f432a.c();
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g == null || !this.g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f432a == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f432a != null) {
            if (this.f432a.d()) {
                return true;
            }
            this.f432a.a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.f432a != null) {
            this.f432a.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.f432a != null ? this.f432a.b() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.e != null) {
            this.e.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.e != null) {
            this.e.a(drawable);
        }
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.e != null) {
            this.e.a(colorStateList);
        }
    }

    @Override // androidx.core.g.p
    public ColorStateList getSupportBackgroundTintList() {
        if (this.e != null) {
            return this.e.a();
        }
        return null;
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.e != null) {
            this.e.a(mode);
        }
    }

    @Override // androidx.core.g.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.e != null) {
            return this.e.b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null) {
            this.e.c();
        }
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.c);
        return iMax2 + this.c.left + this.c.right;
    }

    /* compiled from: AppCompatSpinner.java */
    private static class a implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f436a;

        /* renamed from: b, reason: collision with root package name */
        private ListAdapter f437b;

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f436a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f437b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof ao) {
                    ao aoVar = (ao) spinnerAdapter;
                    if (aoVar.a() == null) {
                        aoVar.a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f436a == null) {
                return 0;
            }
            return this.f436a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f436a == null) {
                return null;
            }
            return this.f436a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f436a == null) {
                return -1L;
            }
            return this.f436a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f436a == null) {
                return null;
            }
            return this.f436a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f436a != null && this.f436a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f436a != null) {
                this.f436a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f436a != null) {
                this.f436a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f437b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f437b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    private class b extends ag {

        /* renamed from: a, reason: collision with root package name */
        ListAdapter f438a;
        private CharSequence h;
        private final Rect i;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.i = new Rect();
            b(v.this);
            a(true);
            a(0);
            a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.v.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    v.this.setSelection(i2);
                    if (v.this.getOnItemClickListener() != null) {
                        v.this.performItemClick(view, i2, b.this.f438a.getItemId(i2));
                    }
                    b.this.c();
                }
            });
        }

        @Override // androidx.appcompat.widget.ag
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f438a = listAdapter;
        }

        public CharSequence b() {
            return this.h;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        void f() {
            Drawable drawableH = h();
            int i = 0;
            if (drawableH != null) {
                drawableH.getPadding(v.this.c);
                i = ay.a(v.this) ? v.this.c.right : -v.this.c.left;
            } else {
                Rect rect = v.this.c;
                v.this.c.right = 0;
                rect.left = 0;
            }
            int paddingLeft = v.this.getPaddingLeft();
            int paddingRight = v.this.getPaddingRight();
            int width = v.this.getWidth();
            if (v.this.f433b == -2) {
                int iA = v.this.a((SpinnerAdapter) this.f438a, h());
                int i2 = (v.this.getContext().getResources().getDisplayMetrics().widthPixels - v.this.c.left) - v.this.c.right;
                if (iA > i2) {
                    iA = i2;
                }
                g(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (v.this.f433b == -1) {
                g((width - paddingLeft) - paddingRight);
            } else {
                g(v.this.f433b);
            }
            c(ay.a(v.this) ? i + ((width - paddingRight) - l()) : i + paddingLeft);
        }

        @Override // androidx.appcompat.widget.ag, androidx.appcompat.view.menu.s
        public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ViewTreeObserver viewTreeObserver;
            boolean zD = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(v.this.getSelectedItemPosition());
            if (zD || (viewTreeObserver = v.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.v.b.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    if (!b.this.a(v.this)) {
                        b.this.c();
                    } else {
                        b.this.f();
                        b.super.a();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.v.b.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = v.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        boolean a(View view) {
            return androidx.core.g.q.A(view) && view.getGlobalVisibleRect(this.i);
        }
    }
}
