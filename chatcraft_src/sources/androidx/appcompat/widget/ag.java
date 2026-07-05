package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class ag implements androidx.appcompat.view.menu.s {

    /* renamed from: a, reason: collision with root package name */
    private static Method f335a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f336b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    ac c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    static {
        try {
            f335a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f336b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ag(Context context) {
        this(context, null, a.C0018a.listPopupWindowStyle);
    }

    public ag(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ag(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i, i2);
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.g = new q(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new b();
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(int i) {
        this.x = i;
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void b(int i) {
        this.g.setAnimationStyle(i);
    }

    public View i() {
        return this.z;
    }

    public void b(View view) {
        this.z = view;
    }

    public int j() {
        return this.m;
    }

    public void c(int i) {
        this.m = i;
    }

    public int k() {
        if (this.p) {
            return this.n;
        }
        return 0;
    }

    public void d(int i) {
        this.n = i;
        this.p = true;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void e(int i) {
        this.t = i;
    }

    public int l() {
        return this.l;
    }

    public void f(int i) {
        this.l = i;
    }

    public void g(int i) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = this.H.left + this.H.right + i;
        } else {
            f(i);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.s
    public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int width;
        int width2;
        int iF = f();
        boolean zN = n();
        androidx.core.widget.h.a(this.g, this.o);
        if (this.g.isShowing()) {
            if (androidx.core.g.q.A(i())) {
                if (this.l == -1) {
                    width2 = -1;
                } else if (this.l == -2) {
                    width2 = i().getWidth();
                } else {
                    width2 = this.l;
                }
                if (this.k == -1) {
                    if (!zN) {
                        iF = -1;
                    }
                    if (zN) {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(0);
                    } else {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(-1);
                    }
                } else if (this.k != -2) {
                    iF = this.k;
                }
                this.g.setOutsideTouchable((this.v || this.u) ? false : true);
                this.g.update(i(), this.m, this.n, width2 < 0 ? -1 : width2, iF < 0 ? -1 : iF);
                return;
            }
            return;
        }
        if (this.l == -1) {
            width = -1;
        } else if (this.l == -2) {
            width = i().getWidth();
        } else {
            width = this.l;
        }
        if (this.k == -1) {
            iF = -1;
        } else if (this.k != -2) {
            iF = this.k;
        }
        this.g.setWidth(width);
        this.g.setHeight(iF);
        c(true);
        this.g.setOutsideTouchable((this.v || this.u) ? false : true);
        this.g.setTouchInterceptor(this.D);
        if (this.s) {
            androidx.core.widget.h.a(this.g, this.r);
        }
        if (h != null) {
            try {
                h.invoke(this.g, this.I);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        androidx.core.widget.h.a(this.g, i(), this.m, this.n, this.t);
        this.c.setSelection(-1);
        if (!this.J || this.c.isInTouchMode()) {
            m();
        }
        if (this.J) {
            return;
        }
        this.f.post(this.F);
    }

    @Override // androidx.appcompat.view.menu.s
    public void c() {
        this.g.dismiss();
        b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    private void b() {
        if (this.w != null) {
            ViewParent parent = this.w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    public void h(int i) {
        this.g.setInputMethodMode(i);
    }

    public void i(int i) {
        ac acVar = this.c;
        if (!d() || acVar == null) {
            return;
        }
        acVar.setListSelectionHidden(false);
        acVar.setSelection(i);
        if (acVar.getChoiceMode() != 0) {
            acVar.setItemChecked(i, true);
        }
    }

    public void m() {
        ac acVar = this.c;
        if (acVar != null) {
            acVar.setListSelectionHidden(true);
            acVar.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public boolean d() {
        return this.g.isShowing();
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }

    @Override // androidx.appcompat.view.menu.s
    public ListView e() {
        return this.c;
    }

    ac a(Context context, boolean z) {
        return new ac(context, z);
    }

    private int f() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        int i2;
        int i3;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() { // from class: androidx.appcompat.widget.ag.1
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    View viewI = ag.this.i();
                    if (viewI == null || viewI.getWindowToken() == null) {
                        return;
                    }
                    ag.this.a();
                }
            };
            this.c = a(context, !this.J);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ag.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                    ac acVar;
                    if (i4 == -1 || (acVar = ag.this.c) == null) {
                        return;
                    }
                    acVar.setListSelectionHidden(false);
                }
            });
            this.c.setOnScrollListener(this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            View view = this.c;
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                if (this.l >= 0) {
                    i2 = this.l;
                    i3 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i2, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.g.setContentView(view);
        } else {
            View view3 = this.w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i = this.H.top + this.H.bottom;
            if (!this.p) {
                this.n = -this.H.top;
            }
        } else {
            this.H.setEmpty();
            i = 0;
        }
        int iA = a(i(), this.n, this.g.getInputMethodMode() == 2);
        if (this.u || this.k == -1) {
            return iA + i;
        }
        switch (this.l) {
            case -2:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
                break;
            case -1:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
                break;
            default:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
                break;
        }
        int iA2 = this.c.a(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iA2 > 0) {
            measuredHeight += i + this.c.getPaddingTop() + this.c.getPaddingBottom();
        }
        return iA2 + measuredHeight;
    }

    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    /* compiled from: ListPopupWindow.java */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (ag.this.d()) {
                ag.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ag.this.c();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ag.this.m();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (ag.this.c == null || !androidx.core.g.q.A(ag.this.c) || ag.this.c.getCount() <= ag.this.c.getChildCount() || ag.this.c.getChildCount() > ag.this.d) {
                return;
            }
            ag.this.g.setInputMethodMode(2);
            ag.this.a();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ag.this.g != null && ag.this.g.isShowing() && x >= 0 && x < ag.this.g.getWidth() && y >= 0 && y < ag.this.g.getHeight()) {
                ag.this.f.postDelayed(ag.this.e, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ag.this.f.removeCallbacks(ag.this.e);
            return false;
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class c implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (i != 1 || ag.this.n() || ag.this.g.getContentView() == null) {
                return;
            }
            ag.this.f.removeCallbacks(ag.this.e);
            ag.this.e.run();
        }
    }

    private void c(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f335a != null) {
            try {
                f335a.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int a(View view, int i, boolean z) {
        if (f336b != null) {
            try {
                return ((Integer) f336b.invoke(this.g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i);
    }
}
