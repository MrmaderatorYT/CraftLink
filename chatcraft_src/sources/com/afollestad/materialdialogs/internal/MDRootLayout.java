package com.afollestad.materialdialogs.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.e;
import com.afollestad.materialdialogs.g;
import com.afollestad.materialdialogs.h;

/* loaded from: classes.dex */
public class MDRootLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final MDButton[] f1226a;

    /* renamed from: b, reason: collision with root package name */
    private int f1227b;
    private View c;
    private View d;
    private boolean e;
    private boolean f;
    private h g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private e o;
    private int p;
    private Paint q;
    private ViewTreeObserver.OnScrollChangedListener r;
    private ViewTreeObserver.OnScrollChangedListener s;
    private int t;

    public MDRootLayout(Context context) {
        super(context);
        this.f1226a = new MDButton[3];
        this.e = false;
        this.f = false;
        this.g = h.ADAPTIVE;
        this.h = false;
        this.i = true;
        this.o = e.START;
        a(context, (AttributeSet) null, 0);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1226a = new MDButton[3];
        this.e = false;
        this.f = false;
        this.g = h.ADAPTIVE;
        this.h = false;
        this.i = true;
        this.o = e.START;
        a(context, attributeSet, 0);
    }

    @TargetApi(11)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1226a = new MDButton[3];
        this.e = false;
        this.f = false;
        this.g = h.ADAPTIVE;
        this.h = false;
        this.i = true;
        this.o = e.START;
        a(context, attributeSet, i);
    }

    @TargetApi(21)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1226a = new MDButton[3];
        this.e = false;
        this.f = false;
        this.g = h.ADAPTIVE;
        this.h = false;
        this.i = true;
        this.o = e.START;
        a(context, attributeSet, i);
    }

    private static boolean a(View view) {
        boolean z = (view == null || view.getVisibility() == 8) ? false : true;
        return (z && (view instanceof MDButton)) ? ((MDButton) view).getText().toString().trim().length() > 0 : z;
    }

    public static boolean a(RecyclerView recyclerView) {
        return (recyclerView == null || recyclerView.getLayoutManager() == null || !recyclerView.getLayoutManager().f()) ? false : true;
    }

    private static boolean a(ScrollView scrollView) {
        if (scrollView.getChildCount() == 0) {
            return false;
        }
        return (scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    private static boolean a(AdapterView adapterView) {
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        return !(adapterView.getFirstVisiblePosition() == 0) || !(adapterView.getLastVisiblePosition() == adapterView.getCount() - 1) || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop() || adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom();
    }

    private static View a(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    private static View b(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.h.MDRootLayout, i, 0);
        this.j = typedArrayObtainStyledAttributes.getBoolean(g.h.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        typedArrayObtainStyledAttributes.recycle();
        this.l = resources.getDimensionPixelSize(g.c.md_notitle_vertical_padding);
        this.m = resources.getDimensionPixelSize(g.c.md_button_frame_vertical_padding);
        this.p = resources.getDimensionPixelSize(g.c.md_button_padding_frame_side);
        this.n = resources.getDimensionPixelSize(g.c.md_button_height);
        this.q = new Paint();
        this.t = resources.getDimensionPixelSize(g.c.md_divider_height);
        this.q.setColor(com.afollestad.materialdialogs.a.a.a(context, g.a.md_divider_color));
        setWillNotDraw(false);
    }

    public void setMaxHeight(int i) {
        this.f1227b = i;
    }

    public void a() {
        this.k = true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == g.e.md_titleFrame) {
                this.c = childAt;
            } else if (childAt.getId() == g.e.md_buttonDefaultNeutral) {
                this.f1226a[0] = (MDButton) childAt;
            } else if (childAt.getId() == g.e.md_buttonDefaultNegative) {
                this.f1226a[1] = (MDButton) childAt;
            } else if (childAt.getId() == g.e.md_buttonDefaultPositive) {
                this.f1226a[2] = (MDButton) childAt;
            } else {
                this.d = childAt;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0114  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d != null) {
            if (this.e) {
                canvas.drawRect(0.0f, r0 - this.t, getMeasuredWidth(), this.d.getTop(), this.q);
            }
            if (this.f) {
                canvas.drawRect(0.0f, this.d.getBottom(), getMeasuredWidth(), r0 + this.t, this.q);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredWidth2;
        int measuredWidth3;
        int measuredWidth4;
        int measuredWidth5;
        int measuredWidth6;
        int measuredWidth7;
        int measuredWidth8;
        if (a(this.c)) {
            int measuredHeight = this.c.getMeasuredHeight() + i2;
            this.c.layout(i, i2, i3, measuredHeight);
            i2 = measuredHeight;
        } else if (!this.k && this.i) {
            i2 += this.l;
        }
        if (a(this.d)) {
            this.d.layout(i, i2, i3, this.d.getMeasuredHeight() + i2);
        }
        if (this.h) {
            int measuredHeight2 = i4 - this.m;
            for (MDButton mDButton : this.f1226a) {
                if (a(mDButton)) {
                    mDButton.layout(i, measuredHeight2 - mDButton.getMeasuredHeight(), i3, measuredHeight2);
                    measuredHeight2 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.i) {
                i4 -= this.m;
            }
            int i5 = i4 - this.n;
            int measuredWidth9 = this.p;
            if (a(this.f1226a[2])) {
                if (this.o == e.END) {
                    measuredWidth8 = i + measuredWidth9;
                    measuredWidth7 = this.f1226a[2].getMeasuredWidth() + measuredWidth8;
                    measuredWidth = -1;
                } else {
                    measuredWidth7 = i3 - measuredWidth9;
                    measuredWidth8 = measuredWidth7 - this.f1226a[2].getMeasuredWidth();
                    measuredWidth = measuredWidth8;
                }
                this.f1226a[2].layout(measuredWidth8, i5, measuredWidth7, i4);
                measuredWidth9 += this.f1226a[2].getMeasuredWidth();
            } else {
                measuredWidth = -1;
            }
            if (a(this.f1226a[1])) {
                if (this.o == e.END) {
                    measuredWidth5 = measuredWidth9 + i;
                    measuredWidth6 = this.f1226a[1].getMeasuredWidth() + measuredWidth5;
                } else if (this.o == e.START) {
                    measuredWidth6 = i3 - measuredWidth9;
                    measuredWidth5 = measuredWidth6 - this.f1226a[1].getMeasuredWidth();
                } else {
                    measuredWidth5 = this.p + i;
                    measuredWidth6 = this.f1226a[1].getMeasuredWidth() + measuredWidth5;
                    measuredWidth2 = measuredWidth6;
                    this.f1226a[1].layout(measuredWidth5, i5, measuredWidth6, i4);
                }
                measuredWidth2 = -1;
                this.f1226a[1].layout(measuredWidth5, i5, measuredWidth6, i4);
            } else {
                measuredWidth2 = -1;
            }
            if (a(this.f1226a[0])) {
                if (this.o == e.END) {
                    measuredWidth4 = i3 - this.p;
                    measuredWidth3 = measuredWidth4 - this.f1226a[0].getMeasuredWidth();
                } else if (this.o == e.START) {
                    measuredWidth3 = i + this.p;
                    measuredWidth4 = this.f1226a[0].getMeasuredWidth() + measuredWidth3;
                } else {
                    if (measuredWidth2 == -1 && measuredWidth != -1) {
                        measuredWidth2 = measuredWidth - this.f1226a[0].getMeasuredWidth();
                    } else if (measuredWidth == -1 && measuredWidth2 != -1) {
                        measuredWidth = measuredWidth2 + this.f1226a[0].getMeasuredWidth();
                    } else if (measuredWidth == -1) {
                        measuredWidth2 = ((i3 - i) / 2) - (this.f1226a[0].getMeasuredWidth() / 2);
                        measuredWidth = measuredWidth2 + this.f1226a[0].getMeasuredWidth();
                    }
                    measuredWidth3 = measuredWidth2;
                    measuredWidth4 = measuredWidth;
                }
                this.f1226a[0].layout(measuredWidth3, i5, measuredWidth4, i4);
            }
        }
        a(this.d, true, true);
    }

    public void setStackingBehavior(h hVar) {
        this.g = hVar;
        invalidate();
    }

    public void setDividerColor(int i) {
        this.q.setColor(i);
        invalidate();
    }

    public void setButtonGravity(e eVar) {
        this.o = eVar;
        b();
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1) {
            switch (this.o) {
                case START:
                    this.o = e.END;
                    break;
                case END:
                    this.o = e.START;
                    break;
            }
        }
    }

    public void setButtonStackedGravity(e eVar) {
        for (MDButton mDButton : this.f1226a) {
            if (mDButton != null) {
                mDButton.setStackedGravity(eVar);
            }
        }
    }

    private void a(final View view, final boolean z, final boolean z2) {
        if (view == null) {
            return;
        }
        if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            if (a(scrollView)) {
                a((ViewGroup) scrollView, z, z2);
                return;
            }
            if (z) {
                this.e = false;
            }
            if (z2) {
                this.f = false;
                return;
            }
            return;
        }
        if (view instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) view;
            if (a(adapterView)) {
                a((ViewGroup) adapterView, z, z2);
                return;
            }
            if (z) {
                this.e = false;
            }
            if (z2) {
                this.f = false;
                return;
            }
            return;
        }
        if (view instanceof WebView) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.afollestad.materialdialogs.internal.MDRootLayout.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (view.getMeasuredHeight() == 0) {
                        return true;
                    }
                    if (MDRootLayout.b((WebView) view)) {
                        MDRootLayout.this.a((ViewGroup) view, z, z2);
                    } else {
                        if (z) {
                            MDRootLayout.this.e = false;
                        }
                        if (z2) {
                            MDRootLayout.this.f = false;
                        }
                    }
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
            return;
        }
        if (view instanceof RecyclerView) {
            boolean zA = a((RecyclerView) view);
            if (z) {
                this.e = zA;
            }
            if (z2) {
                this.f = zA;
            }
            if (zA) {
                a((ViewGroup) view, z, z2);
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            View viewB = b(viewGroup);
            a(viewB, z, z2);
            View viewA = a(viewGroup);
            if (viewA != viewB) {
                a(viewA, false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ViewGroup viewGroup, final boolean z, final boolean z2) {
        if ((z2 || this.r != null) && !(z2 && this.s == null)) {
            return;
        }
        if (viewGroup instanceof RecyclerView) {
            RecyclerView.n nVar = new RecyclerView.n() { // from class: com.afollestad.materialdialogs.internal.MDRootLayout.2
                @Override // androidx.recyclerview.widget.RecyclerView.n
                public void a(RecyclerView recyclerView, int i, int i2) {
                    super.a(recyclerView, i, i2);
                    MDButton[] mDButtonArr = MDRootLayout.this.f1226a;
                    int length = mDButtonArr.length;
                    boolean z3 = false;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            MDButton mDButton = mDButtonArr[i3];
                            if (mDButton != null && mDButton.getVisibility() != 8) {
                                z3 = true;
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    }
                    MDRootLayout.this.a(viewGroup, z, z2, z3);
                    MDRootLayout.this.invalidate();
                }
            };
            RecyclerView recyclerView = (RecyclerView) viewGroup;
            recyclerView.a(nVar);
            nVar.a(recyclerView, 0, 0);
            return;
        }
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.afollestad.materialdialogs.internal.MDRootLayout.3
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                MDButton[] mDButtonArr = MDRootLayout.this.f1226a;
                int length = mDButtonArr.length;
                boolean z3 = false;
                int i = 0;
                while (true) {
                    if (i < length) {
                        MDButton mDButton = mDButtonArr[i];
                        if (mDButton != null && mDButton.getVisibility() != 8) {
                            z3 = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (viewGroup instanceof WebView) {
                    MDRootLayout.this.a((WebView) viewGroup, z, z2, z3);
                } else {
                    MDRootLayout.this.a(viewGroup, z, z2, z3);
                }
                MDRootLayout.this.invalidate();
            }
        };
        if (!z2) {
            this.r = onScrollChangedListener;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.r);
        } else {
            this.s = onScrollChangedListener;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.s);
        }
        onScrollChangedListener.onScrollChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        if (z && viewGroup.getChildCount() > 0) {
            this.e = (this.c == null || this.c.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (!z2 || viewGroup.getChildCount() <= 0) {
            return;
        }
        this.f = z3 && (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() < viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebView webView, boolean z, boolean z2, boolean z3) {
        if (z) {
            this.e = (this.c == null || this.c.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            this.f = z3 && ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) < ((float) webView.getContentHeight()) * webView.getScale();
        }
    }
}
