package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.a;
import java.lang.reflect.Field;

/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
class ac extends ListView {

    /* renamed from: a, reason: collision with root package name */
    b f325a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f326b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Field h;
    private a i;
    private boolean j;
    private boolean k;
    private boolean l;
    private androidx.core.g.u m;
    private androidx.core.widget.f n;

    ac(Context context, boolean z) {
        super(context, null, a.C0018a.dropDownListViewStyle);
        this.f326b = new Rect();
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.k = z;
        setCacheColorHint(0);
        try {
            this.h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.k && this.j) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.k || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.k || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.i = drawable != null ? new a(drawable) : null;
        super.setSelector(this.i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.c = rect.left;
        this.d = rect.top;
        this.e = rect.right;
        this.f = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f325a != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        a();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f325a != null) {
            this.f325a.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        int iMakeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int measuredHeight = i6;
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, iMakeMeasureSpec);
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || measuredHeight == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.i != null) {
            this.i.a(z);
        }
    }

    /* compiled from: DropDownListView.java */
    private static class a extends androidx.appcompat.b.a.c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f327a;

        a(Drawable drawable) {
            super(drawable);
            this.f327a = true;
        }

        void a(boolean z) {
            this.f327a = z;
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f327a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f327a) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f327a) {
                super.setHotspot(f, f2);
            }
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f327a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f327a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f325a == null) {
            this.f325a = new b();
            this.f325a.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                a();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f325a = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L11;
                case 2: goto Lf;
                case 3: goto Lc;
                default: goto L9;
            }
        L9:
            r9 = 0
            r3 = 1
            goto L41
        Lc:
            r9 = 0
            r3 = 0
            goto L41
        Lf:
            r3 = 1
            goto L12
        L11:
            r3 = 0
        L12:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L19
            goto Lc
        L19:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L2c
            r9 = 1
            goto L41
        L2c:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.a(r3, r5, r4, r9)
            if (r0 != r2) goto L9
            r7.a(r3, r5)
            goto L9
        L41:
            if (r3 == 0) goto L45
            if (r9 == 0) goto L48
        L45:
            r7.b()
        L48:
            if (r3 == 0) goto L60
            androidx.core.widget.f r9 = r7.n
            if (r9 != 0) goto L55
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.n = r9
        L55:
            androidx.core.widget.f r9 = r7.n
            r9.a(r2)
            androidx.core.widget.f r9 = r7.n
            r9.onTouch(r7, r8)
            goto L69
        L60:
            androidx.core.widget.f r8 = r7.n
            if (r8 == 0) goto L69
            androidx.core.widget.f r8 = r7.n
            r8.a(r1)
        L69:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ac.a(android.view.MotionEvent, int):boolean");
    }

    private void a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.j = z;
    }

    private void a() {
        Drawable selector = getSelector();
        if (selector != null && c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void a(Canvas canvas) {
        Drawable selector;
        if (this.f326b.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f326b);
        selector.draw(canvas);
    }

    private void a(int i, View view, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        a(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.a(selector, f, f2);
    }

    private void a(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        b(i, view);
        if (z) {
            Rect rect = this.f326b;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.a(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void b(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f326b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.c;
        rect.top -= this.d;
        rect.right += this.e;
        rect.bottom += this.f;
        try {
            boolean z = this.h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void b() {
        this.l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.m != null) {
            this.m.b();
            this.m = null;
        }
    }

    private void a(View view, int i, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.l = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.g != -1 && (childAt = getChildAt(this.g - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.g = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean c() {
        return this.l;
    }

    /* compiled from: DropDownListView.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ac.this.f325a = null;
            ac.this.drawableStateChanged();
        }

        public void a() {
            ac.this.f325a = null;
            ac.this.removeCallbacks(this);
        }

        public void b() {
            ac.this.post(this);
        }
    }
}
