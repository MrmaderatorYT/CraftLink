package androidx.recyclerview.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.g.a.c;
import androidx.recyclerview.a;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.g.j {
    static final Interpolator L;
    private static final int[] M = {R.attr.nestedScrollingEnabled};
    private static final int[] N = {R.attr.clipToPadding};
    private static final boolean O;
    private static final boolean P;
    private static final Class<?>[] Q;

    /* renamed from: a, reason: collision with root package name */
    static final boolean f1016a;

    /* renamed from: b, reason: collision with root package name */
    static final boolean f1017b;
    static final boolean c;
    static final boolean d;
    final w A;
    androidx.recyclerview.widget.h B;
    h.a C;
    final u D;
    boolean E;
    boolean F;
    boolean G;
    androidx.recyclerview.widget.m H;
    final int[] I;
    final int[] J;
    final List<x> K;
    private final r R;
    private s S;
    private final Rect T;
    private final ArrayList<m> U;
    private m V;
    private int W;
    private List<n> aA;
    private f.b aB;
    private d aC;
    private final int[] aD;
    private androidx.core.g.k aE;
    private final int[] aF;
    private final int[] aG;
    private Runnable aH;
    private final q.b aI;
    private boolean aa;
    private int ab;
    private final AccessibilityManager ac;
    private List<k> ad;
    private int ae;
    private int af;
    private e ag;
    private EdgeEffect ah;
    private EdgeEffect ai;
    private EdgeEffect aj;
    private EdgeEffect ak;
    private int al;
    private int am;
    private VelocityTracker an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private l at;
    private final int au;
    private final int av;
    private float aw;
    private float ax;
    private boolean ay;
    private n az;
    final p e;
    androidx.recyclerview.widget.a f;
    androidx.recyclerview.widget.d g;
    final androidx.recyclerview.widget.q h;
    boolean i;
    final Runnable j;
    final Rect k;
    final RectF l;
    a m;
    i n;
    q o;
    final ArrayList<h> p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    f z;

    public interface d {
        int a(int i, int i2);
    }

    public interface k {
        void a(View view);

        void b(View view);
    }

    public static abstract class l {
        public abstract boolean a(int i, int i2);
    }

    public interface m {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class n {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public interface q {
        void a(x xVar);
    }

    public static abstract class v {
        public abstract View a(p pVar, int i, int i2);
    }

    public void g(int i2) {
    }

    public void h(int i2, int i3) {
    }

    public void h(View view) {
    }

    public void i(View view) {
    }

    static {
        f1016a = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        f1017b = Build.VERSION.SDK_INT >= 23;
        c = Build.VERSION.SDK_INT >= 16;
        d = Build.VERSION.SDK_INT >= 21;
        O = Build.VERSION.SDK_INT <= 15;
        P = Build.VERSION.SDK_INT <= 15;
        Q = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        L = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i2);
        this.R = new r();
        this.e = new p();
        this.h = new androidx.recyclerview.widget.q();
        this.j = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.t || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.q) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.v) {
                    RecyclerView.this.u = true;
                } else {
                    RecyclerView.this.d();
                }
            }
        };
        this.k = new Rect();
        this.T = new Rect();
        this.l = new RectF();
        this.p = new ArrayList<>();
        this.U = new ArrayList<>();
        this.W = 0;
        this.x = false;
        this.y = false;
        this.ae = 0;
        this.af = 0;
        this.ag = new e();
        this.z = new androidx.recyclerview.widget.e();
        this.al = 0;
        this.am = -1;
        this.aw = Float.MIN_VALUE;
        this.ax = Float.MIN_VALUE;
        boolean z = true;
        this.ay = true;
        this.A = new w();
        this.C = d ? new h.a() : null;
        this.D = new u();
        this.E = false;
        this.F = false;
        this.aB = new g();
        this.G = false;
        this.aD = new int[2];
        this.aF = new int[2];
        this.I = new int[2];
        this.aG = new int[2];
        this.J = new int[2];
        this.K = new ArrayList();
        this.aH = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.z != null) {
                    RecyclerView.this.z.a();
                }
                RecyclerView.this.G = false;
            }
        };
        this.aI = new q.b() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.q.b
            public void a(x xVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.e.c(xVar);
                RecyclerView.this.b(xVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.q.b
            public void b(x xVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.a(xVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.q.b
            public void c(x xVar, f.c cVar, f.c cVar2) {
                xVar.c(false);
                if (RecyclerView.this.x) {
                    if (RecyclerView.this.z.a(xVar, xVar, cVar, cVar2)) {
                        RecyclerView.this.p();
                    }
                } else if (RecyclerView.this.z.c(xVar, cVar, cVar2)) {
                    RecyclerView.this.p();
                }
            }

            @Override // androidx.recyclerview.widget.q.b
            public void a(x xVar) {
                RecyclerView.this.n.a(xVar.f1052a, RecyclerView.this.e);
            }
        };
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, N, i2, 0);
            this.i = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.i = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.as = viewConfiguration.getScaledTouchSlop();
        this.aw = androidx.core.g.r.a(viewConfiguration, context);
        this.ax = androidx.core.g.r.b(viewConfiguration, context);
        this.au = viewConfiguration.getScaledMinimumFlingVelocity();
        this.av = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.z.a(this.aB);
        b();
        A();
        z();
        if (androidx.core.g.q.e(this) == 0) {
            androidx.core.g.q.b(this, 1);
        }
        this.ac = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.m(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i2, 0);
            String string = typedArrayObtainStyledAttributes2.getString(a.b.RecyclerView_layoutManager);
            if (typedArrayObtainStyledAttributes2.getInt(a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.s = typedArrayObtainStyledAttributes2.getBoolean(a.b.RecyclerView_fastScrollEnabled, false);
            if (this.s) {
                a((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            typedArrayObtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, M, i2, 0);
                boolean z2 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
                typedArrayObtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    String a() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    @SuppressLint({"InlinedApi"})
    private void z() {
        if (androidx.core.g.q.a(this) == 0) {
            androidx.core.g.q.a((View) this, 8);
        }
    }

    public androidx.recyclerview.widget.m getCompatAccessibilityDelegate() {
        return this.H;
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.m mVar) {
        this.H = mVar;
        androidx.core.g.q.a(this, this.H);
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) throws NoSuchMethodException, SecurityException {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strA = a(context, strTrim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> clsAsSubclass = classLoader.loadClass(strA).asSubclass(i.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(Q);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strA, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((i) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strA, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strA, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strA, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strA, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strA, e8);
            }
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void A() {
        this.g = new androidx.recyclerview.widget.d(new d.b() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.d.b
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.d.b
            public void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.m(view);
            }

            @Override // androidx.recyclerview.widget.d.b
            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.d.b
            public void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.l(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // androidx.recyclerview.widget.d.b
            public View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // androidx.recyclerview.widget.d.b
            public void b() {
                int iA = a();
                for (int i2 = 0; i2 < iA; i2++) {
                    View viewB = b(i2);
                    RecyclerView.this.l(viewB);
                    viewB.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.d.b
            public x b(View view) {
                return RecyclerView.e(view);
            }

            @Override // androidx.recyclerview.widget.d.b
            public void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                x xVarE = RecyclerView.e(view);
                if (xVarE != null) {
                    if (!xVarE.t() && !xVarE.e()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + xVarE + RecyclerView.this.a());
                    }
                    xVarE.o();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // androidx.recyclerview.widget.d.b
            public void c(int i2) {
                x xVarE;
                View viewB = b(i2);
                if (viewB != null && (xVarE = RecyclerView.e(viewB)) != null) {
                    if (xVarE.t() && !xVarE.e()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + xVarE + RecyclerView.this.a());
                    }
                    xVarE.c(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // androidx.recyclerview.widget.d.b
            public void c(View view) {
                x xVarE = RecyclerView.e(view);
                if (xVarE != null) {
                    xVarE.a(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.d.b
            public void d(View view) {
                x xVarE = RecyclerView.e(view);
                if (xVarE != null) {
                    xVarE.b(RecyclerView.this);
                }
            }
        });
    }

    void b() {
        this.f = new androidx.recyclerview.widget.a(new a.InterfaceC0055a() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public x a(int i2) {
                x xVarA = RecyclerView.this.a(i2, true);
                if (xVarA == null || RecyclerView.this.g.c(xVarA.f1052a)) {
                    return null;
                }
                return xVarA;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public void a(int i2, int i3) {
                RecyclerView.this.a(i2, i3, true);
                RecyclerView.this.E = true;
                RecyclerView.this.D.c += i3;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public void b(int i2, int i3) {
                RecyclerView.this.a(i2, i3, false);
                RecyclerView.this.E = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public void a(int i2, int i3, Object obj) {
                RecyclerView.this.a(i2, i3, obj);
                RecyclerView.this.F = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public void a(a.b bVar) {
                c(bVar);
            }

            void c(a.b bVar) {
                int i2 = bVar.f1071a;
                if (i2 == 4) {
                    RecyclerView.this.n.a(RecyclerView.this, bVar.f1072b, bVar.d, bVar.c);
                    return;
                }
                if (i2 != 8) {
                    switch (i2) {
                        case 1:
                            RecyclerView.this.n.a(RecyclerView.this, bVar.f1072b, bVar.d);
                            break;
                        case 2:
                            RecyclerView.this.n.b(RecyclerView.this, bVar.f1072b, bVar.d);
                            break;
                    }
                    return;
                }
                RecyclerView.this.n.a(RecyclerView.this, bVar.f1072b, bVar.d, 1);
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public void b(a.b bVar) {
                c(bVar);
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public void c(int i2, int i3) {
                RecyclerView.this.g(i2, i3);
                RecyclerView.this.E = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0055a
            public void d(int i2, int i3) {
                RecyclerView.this.f(i2, i3);
                RecyclerView.this.E = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.r = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.i) {
            k();
        }
        this.i = z;
        super.setClipToPadding(z);
        if (this.t) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.i;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i2) {
            case 0:
                break;
            case 1:
                this.as = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
                break;
        }
        this.as = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        c(false);
        requestLayout();
    }

    void c() {
        if (this.z != null) {
            this.z.d();
        }
        if (this.n != null) {
            this.n.c(this.e);
            this.n.b(this.e);
        }
        this.e.a();
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (this.m != null) {
            this.m.b(this.R);
            this.m.b(this);
        }
        if (!z || z2) {
            c();
        }
        this.f.a();
        a aVar2 = this.m;
        this.m = aVar;
        if (aVar != null) {
            aVar.a(this.R);
            aVar.a(this);
        }
        if (this.n != null) {
            this.n.a(aVar2, this.m);
        }
        this.e.a(aVar2, this.m, z);
        this.D.f = true;
    }

    public a getAdapter() {
        return this.m;
    }

    public void setRecyclerListener(q qVar) {
        this.o = qVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.n != null) {
            return this.n.v();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(i iVar) {
        if (iVar == this.n) {
            return;
        }
        f();
        if (this.n != null) {
            if (this.z != null) {
                this.z.d();
            }
            this.n.c(this.e);
            this.n.b(this.e);
            this.e.a();
            if (this.q) {
                this.n.b(this, this.e);
            }
            this.n.b((RecyclerView) null);
            this.n = null;
        } else {
            this.e.a();
        }
        this.g.a();
        this.n = iVar;
        if (iVar != null) {
            if (iVar.q != null) {
                throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.q.a());
            }
            this.n.b(this);
            if (this.q) {
                this.n.c(this);
            }
        }
        this.e.b();
        requestLayout();
    }

    public void setOnFlingListener(l lVar) {
        this.at = lVar;
    }

    public l getOnFlingListener() {
        return this.at;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        s sVar = new s(super.onSaveInstanceState());
        if (this.S != null) {
            sVar.a(this.S);
        } else if (this.n != null) {
            sVar.f1043a = this.n.d();
        } else {
            sVar.f1043a = null;
        }
        return sVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.S = (s) parcelable;
        super.onRestoreInstanceState(this.S.a());
        if (this.n == null || this.S.f1043a == null) {
            return;
        }
        this.n.a(this.S.f1043a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void e(x xVar) {
        View view = xVar.f1052a;
        boolean z = view.getParent() == this;
        this.e.c(b(view));
        if (xVar.t()) {
            this.g.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.g.a(view, true);
        } else {
            this.g.d(view);
        }
    }

    boolean a(View view) {
        e();
        boolean zF = this.g.f(view);
        if (zF) {
            x xVarE = e(view);
            this.e.c(xVarE);
            this.e.b(xVarE);
        }
        a(!zF);
        return zF;
    }

    public i getLayoutManager() {
        return this.n;
    }

    public o getRecycledViewPool() {
        return this.e.g();
    }

    public void setRecycledViewPool(o oVar) {
        this.e.a(oVar);
    }

    public void setViewCacheExtension(v vVar) {
        this.e.a(vVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.e.a(i2);
    }

    public int getScrollState() {
        return this.al;
    }

    void setScrollState(int i2) {
        if (i2 == this.al) {
            return;
        }
        this.al = i2;
        if (i2 != 2) {
            C();
        }
        h(i2);
    }

    public void a(h hVar, int i2) {
        if (this.n != null) {
            this.n.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(hVar);
        } else {
            this.p.add(i2, hVar);
        }
        r();
        requestLayout();
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public void b(h hVar) {
        if (this.n != null) {
            this.n.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(hVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.aC) {
            return;
        }
        this.aC = dVar;
        setChildrenDrawingOrderEnabled(this.aC != null);
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.az = nVar;
    }

    public void a(n nVar) {
        if (this.aA == null) {
            this.aA = new ArrayList();
        }
        this.aA.add(nVar);
    }

    public void b(n nVar) {
        if (this.aA != null) {
            this.aA.remove(nVar);
        }
    }

    public void b(int i2) {
        if (this.v) {
            return;
        }
        f();
        if (this.n == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            this.n.e(i2);
            awakenScrollBars();
        }
    }

    void c(int i2) {
        if (this.n == null) {
            return;
        }
        this.n.e(i2);
        awakenScrollBars();
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        if (this.n == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.v) {
            return;
        }
        boolean zE = this.n.e();
        boolean zF = this.n.f();
        if (zE || zF) {
            if (!zE) {
                i2 = 0;
            }
            if (!zF) {
                i3 = 0;
            }
            a(i2, i3, (MotionEvent) null);
        }
    }

    void a(int i2, int i3, int[] iArr) {
        e();
        l();
        androidx.core.os.a.a("RV Scroll");
        a(this.D);
        int iA = i2 != 0 ? this.n.a(i2, this.e, this.D) : 0;
        int iB = i3 != 0 ? this.n.b(i3, this.e, this.D) : 0;
        androidx.core.os.a.a();
        x();
        m();
        a(false);
        if (iArr != null) {
            iArr[0] = iA;
            iArr[1] = iB;
        }
    }

    void d() {
        if (!this.t || this.x) {
            androidx.core.os.a.a("RV FullInvalidate");
            q();
            androidx.core.os.a.a();
            return;
        }
        if (this.f.d()) {
            if (this.f.a(4) && !this.f.a(11)) {
                androidx.core.os.a.a("RV PartialInvalidate");
                e();
                l();
                this.f.b();
                if (!this.u) {
                    if (B()) {
                        q();
                    } else {
                        this.f.c();
                    }
                }
                a(true);
                m();
                androidx.core.os.a.a();
                return;
            }
            if (this.f.d()) {
                androidx.core.os.a.a("RV FullInvalidate");
                q();
                androidx.core.os.a.a();
            }
        }
    }

    private boolean B() {
        int iB = this.g.b();
        for (int i2 = 0; i2 < iB; i2++) {
            x xVarE = e(this.g.b(i2));
            if (xVarE != null && !xVarE.e() && xVarE.B()) {
                return true;
            }
        }
        return false;
    }

    boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        d();
        if (this.m != null) {
            a(i2, i3, this.J);
            int i8 = this.J[0];
            int i9 = this.J[1];
            i5 = i8;
            i6 = i9;
            i7 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (a(i5, i6, i7, i4, this.aF, 0)) {
            this.aq -= this.aF[0];
            this.ar -= this.aF[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(this.aF[0], this.aF[1]);
            }
            int[] iArr = this.aG;
            iArr[0] = iArr[0] + this.aF[0];
            int[] iArr2 = this.aG;
            iArr2[1] = iArr2[1] + this.aF[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.g.h.a(motionEvent, 8194)) {
                a(motionEvent.getX(), i7, motionEvent.getY(), i10);
            }
            c(i2, i3);
        }
        if (i5 != 0 || i6 != 0) {
            i(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i6 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        if (this.n != null && this.n.e()) {
            return this.n.c(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        if (this.n != null && this.n.e()) {
            return this.n.e(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        if (this.n != null && this.n.e()) {
            return this.n.g(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        if (this.n != null && this.n.f()) {
            return this.n.d(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        if (this.n != null && this.n.f()) {
            return this.n.f(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        if (this.n != null && this.n.f()) {
            return this.n.h(this.D);
        }
        return 0;
    }

    void e() {
        this.W++;
        if (this.W != 1 || this.v) {
            return;
        }
        this.u = false;
    }

    void a(boolean z) {
        if (this.W < 1) {
            this.W = 1;
        }
        if (!z && !this.v) {
            this.u = false;
        }
        if (this.W == 1) {
            if (z && this.u && !this.v && this.n != null && this.m != null) {
                q();
            }
            if (!this.v) {
                this.u = false;
            }
        }
        this.W--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.v) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.v = false;
                if (this.u && this.n != null && this.m != null) {
                    requestLayout();
                }
                this.u = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.v = true;
            this.aa = true;
            f();
        }
    }

    public void a(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        if (this.n == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.v) {
            return;
        }
        if (!this.n.e()) {
            i2 = 0;
        }
        if (!this.n.f()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.A.a(i2, i3, interpolator);
    }

    public boolean b(int i2, int i3) {
        if (this.n == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.v) {
            return false;
        }
        boolean zE = this.n.e();
        boolean zF = this.n.f();
        if (!zE || Math.abs(i2) < this.au) {
            i2 = 0;
        }
        if (!zF || Math.abs(i3) < this.au) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = zE || zF;
            dispatchNestedFling(f2, f3, z);
            if (this.at != null && this.at.a(i2, i3)) {
                return true;
            }
            if (z) {
                int i4 = zE ? 1 : 0;
                if (zF) {
                    i4 |= 2;
                }
                j(i4, 1);
                this.A.a(Math.max(-this.av, Math.min(i2, this.av)), Math.max(-this.av, Math.min(i3, this.av)));
                return true;
            }
        }
        return false;
    }

    public void f() {
        setScrollState(0);
        C();
    }

    private void C() {
        this.A.b();
        if (this.n != null) {
            this.n.I();
        }
    }

    public int getMinFlingVelocity() {
        return this.au;
    }

    public int getMaxFlingVelocity() {
        return this.av;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.g()
            android.widget.EdgeEffect r3 = r6.ah
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.d.a(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.h()
            android.widget.EdgeEffect r3 = r6.aj
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.a(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.i()
            android.widget.EdgeEffect r9 = r6.ai
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.a(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.j()
            android.widget.EdgeEffect r9 = r6.ak
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.a(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.g.q.d(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void D() {
        boolean zIsFinished;
        if (this.ah != null) {
            this.ah.onRelease();
            zIsFinished = this.ah.isFinished();
        } else {
            zIsFinished = false;
        }
        if (this.ai != null) {
            this.ai.onRelease();
            zIsFinished |= this.ai.isFinished();
        }
        if (this.aj != null) {
            this.aj.onRelease();
            zIsFinished |= this.aj.isFinished();
        }
        if (this.ak != null) {
            this.ak.onRelease();
            zIsFinished |= this.ak.isFinished();
        }
        if (zIsFinished) {
            androidx.core.g.q.d(this);
        }
    }

    void c(int i2, int i3) {
        boolean zIsFinished;
        if (this.ah == null || this.ah.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.ah.onRelease();
            zIsFinished = this.ah.isFinished();
        }
        if (this.aj != null && !this.aj.isFinished() && i2 < 0) {
            this.aj.onRelease();
            zIsFinished |= this.aj.isFinished();
        }
        if (this.ai != null && !this.ai.isFinished() && i3 > 0) {
            this.ai.onRelease();
            zIsFinished |= this.ai.isFinished();
        }
        if (this.ak != null && !this.ak.isFinished() && i3 < 0) {
            this.ak.onRelease();
            zIsFinished |= this.ak.isFinished();
        }
        if (zIsFinished) {
            androidx.core.g.q.d(this);
        }
    }

    void d(int i2, int i3) {
        if (i2 < 0) {
            g();
            this.ah.onAbsorb(-i2);
        } else if (i2 > 0) {
            h();
            this.aj.onAbsorb(i2);
        }
        if (i3 < 0) {
            i();
            this.ai.onAbsorb(-i3);
        } else if (i3 > 0) {
            j();
            this.ak.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        androidx.core.g.q.d(this);
    }

    void g() {
        if (this.ah != null) {
            return;
        }
        this.ah = this.ag.a(this, 0);
        if (this.i) {
            this.ah.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.ah.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void h() {
        if (this.aj != null) {
            return;
        }
        this.aj = this.ag.a(this, 2);
        if (this.i) {
            this.aj.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.aj.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void i() {
        if (this.ai != null) {
            return;
        }
        this.ai = this.ag.a(this, 1);
        if (this.i) {
            this.ai.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.ai.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void j() {
        if (this.ak != null) {
            return;
        }
        this.ak = this.ag.a(this, 3);
        if (this.i) {
            this.ak.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.ak.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void k() {
        this.ak = null;
        this.ai = null;
        this.aj = null;
        this.ah = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.f.e.a(eVar);
        this.ag = eVar;
        k();
    }

    public e getEdgeEffectFactory() {
        return this.ag;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewA;
        boolean z;
        View viewD = this.n.d(view, i2);
        if (viewD != null) {
            return viewD;
        }
        boolean z2 = (this.m == null || this.n == null || o() || this.v) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.n.f()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (O) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.n.e()) {
                int i4 = (this.n.u() == 1) ^ (i2 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (O) {
                    i2 = i4;
                }
            }
            if (z) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.n.a(view, i2, this.e, this.D);
                a(false);
            }
            viewA = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                viewA = this.n.a(view, i2, this.e, this.D);
                a(false);
            } else {
                viewA = viewFindNextFocus;
            }
        }
        if (viewA == null || viewA.hasFocusable()) {
            return a(view, viewA, i2) ? viewA : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(viewA, (View) null);
        return view;
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.k.set(0, 0, view.getWidth(), view.getHeight());
        this.T.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.k);
        offsetDescendantRectToMyCoords(view2, this.T);
        char c2 = 65535;
        int i4 = this.n.u() == 1 ? -1 : 1;
        if ((this.k.left < this.T.left || this.k.right <= this.T.left) && this.k.right < this.T.right) {
            i3 = 1;
        } else {
            i3 = ((this.k.right > this.T.right || this.k.left >= this.T.right) && this.k.left > this.T.left) ? -1 : 0;
        }
        if ((this.k.top < this.T.top || this.k.bottom <= this.T.top) && this.k.bottom < this.T.bottom) {
            c2 = 1;
        } else if ((this.k.bottom <= this.T.bottom && this.k.top < this.T.bottom) || this.k.top <= this.T.top) {
            c2 = 0;
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        switch (i2) {
            case 1:
                return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
            case 2:
                return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
            default:
                throw new IllegalArgumentException("Invalid direction: " + i2 + a());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.n.a(this, this.D, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.e) {
                Rect rect = jVar.d;
                this.k.left -= rect.left;
                this.k.right += rect.right;
                this.k.top -= rect.top;
                this.k.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.k);
            offsetRectIntoDescendantCoords(view, this.k);
        }
        this.n.a(this, view, this.k, !this.t, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.n.a(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (this.n == null || !this.n.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (o()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.ae = r0
            r1 = 1
            r4.q = r1
            boolean r2 = r4.t
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.t = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.n
            if (r1 == 0) goto L20
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.n
            r1.c(r4)
        L20:
            r4.G = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.d
            if (r0 == 0) goto L6b
            java.lang.ThreadLocal<androidx.recyclerview.widget.h> r0 = androidx.recyclerview.widget.h.f1118a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.h r0 = (androidx.recyclerview.widget.h) r0
            r4.B = r0
            androidx.recyclerview.widget.h r0 = r4.B
            if (r0 != 0) goto L66
            androidx.recyclerview.widget.h r0 = new androidx.recyclerview.widget.h
            r0.<init>()
            r4.B = r0
            android.view.Display r0 = androidx.core.g.q.C(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L54
            if (r0 == 0) goto L54
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L54
            goto L56
        L54:
            r0 = 1114636288(0x42700000, float:60.0)
        L56:
            androidx.recyclerview.widget.h r1 = r4.B
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.h> r0 = androidx.recyclerview.widget.h.f1118a
            androidx.recyclerview.widget.h r1 = r4.B
            r0.set(r1)
        L66:
            androidx.recyclerview.widget.h r0 = r4.B
            r0.a(r4)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.z != null) {
            this.z.d();
        }
        f();
        this.q = false;
        if (this.n != null) {
            this.n.b(this, this.e);
        }
        this.K.clear();
        removeCallbacks(this.aH);
        this.h.b();
        if (!d || this.B == null) {
            return;
        }
        this.B.b(this);
        this.B = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.q;
    }

    void a(String str) {
        if (o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + a());
            }
            throw new IllegalStateException(str);
        }
        if (this.af > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.FLAVOR + a()));
        }
    }

    public void a(m mVar) {
        this.U.add(mVar);
    }

    public void b(m mVar) {
        this.U.remove(mVar);
        if (this.V == mVar) {
            this.V = null;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.V = null;
        }
        int size = this.U.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.U.get(i2);
            if (mVar.a(this, motionEvent) && action != 3) {
                this.V = mVar;
                return true;
            }
        }
        return false;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.V != null) {
            if (action == 0) {
                this.V = null;
            } else {
                this.V.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.V = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.U.size();
            for (int i2 = 0; i2 < size; i2++) {
                m mVar = this.U.get(i2);
                if (mVar.a(this, motionEvent)) {
                    this.V = mVar;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.v) {
            return false;
        }
        if (a(motionEvent)) {
            F();
            return true;
        }
        if (this.n == null) {
            return false;
        }
        boolean zE = this.n.e();
        boolean zF = this.n.f();
        if (this.an == null) {
            this.an = VelocityTracker.obtain();
        }
        this.an.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                if (this.aa) {
                    this.aa = false;
                }
                this.am = motionEvent.getPointerId(0);
                int x2 = (int) (motionEvent.getX() + 0.5f);
                this.aq = x2;
                this.ao = x2;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.ar = y;
                this.ap = y;
                if (this.al == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.aG;
                this.aG[1] = 0;
                iArr[0] = 0;
                int i2 = zE ? 1 : 0;
                if (zF) {
                    i2 |= 2;
                }
                j(i2, 0);
                break;
            case 1:
                this.an.clear();
                a(0);
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.am);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.am + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                if (this.al != 1) {
                    int i3 = x3 - this.ao;
                    int i4 = y2 - this.ap;
                    if (!zE || Math.abs(i3) <= this.as) {
                        z = false;
                    } else {
                        this.aq = x3;
                        z = true;
                    }
                    if (zF && Math.abs(i4) > this.as) {
                        this.ar = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                        break;
                    }
                }
                break;
            case 3:
                F();
                break;
            case 5:
                this.am = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.aq = x4;
                this.ao = x4;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.ar = y3;
                this.ap = y3;
                break;
            case 6:
                c(motionEvent);
                break;
        }
        return this.al == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.U.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.U.get(i2).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.v || this.aa) {
            return false;
        }
        if (b(motionEvent)) {
            F();
            return true;
        }
        if (this.n == null) {
            return false;
        }
        boolean zE = this.n.e();
        boolean zF = this.n.f();
        if (this.an == null) {
            this.an = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.aG;
            this.aG[1] = 0;
            iArr[0] = 0;
        }
        motionEventObtain.offsetLocation(this.aG[0], this.aG[1]);
        switch (actionMasked) {
            case 0:
                this.am = motionEvent.getPointerId(0);
                int x2 = (int) (motionEvent.getX() + 0.5f);
                this.aq = x2;
                this.ao = x2;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.ar = y;
                this.ap = y;
                int i2 = zE ? 1 : 0;
                if (zF) {
                    i2 |= 2;
                }
                j(i2, 0);
                break;
            case 1:
                this.an.addMovement(motionEventObtain);
                this.an.computeCurrentVelocity(1000, this.av);
                float f2 = zE ? -this.an.getXVelocity(this.am) : 0.0f;
                float f3 = zF ? -this.an.getYVelocity(this.am) : 0.0f;
                if ((f2 == 0.0f && f3 == 0.0f) || !b((int) f2, (int) f3)) {
                    setScrollState(0);
                }
                E();
                z2 = true;
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.am);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.am + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int i3 = this.aq - x3;
                int i4 = this.ar - y2;
                if (a(i3, i4, this.I, this.aF, 0)) {
                    i3 -= this.I[0];
                    i4 -= this.I[1];
                    motionEventObtain.offsetLocation(this.aF[0], this.aF[1]);
                    int[] iArr2 = this.aG;
                    iArr2[0] = iArr2[0] + this.aF[0];
                    int[] iArr3 = this.aG;
                    iArr3[1] = iArr3[1] + this.aF[1];
                }
                if (this.al != 1) {
                    if (!zE || Math.abs(i3) <= this.as) {
                        z = false;
                    } else {
                        if (i3 > 0) {
                            i3 -= this.as;
                        } else {
                            i3 += this.as;
                        }
                        z = true;
                    }
                    if (zF && Math.abs(i4) > this.as) {
                        if (i4 > 0) {
                            i4 -= this.as;
                        } else {
                            i4 += this.as;
                        }
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                if (this.al == 1) {
                    this.aq = x3 - this.aF[0];
                    this.ar = y2 - this.aF[1];
                    if (a(zE ? i3 : 0, zF ? i4 : 0, motionEventObtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (this.B != null && (i3 != 0 || i4 != 0)) {
                        this.B.a(this, i3, i4);
                        break;
                    }
                }
                break;
            case 3:
                F();
                break;
            case 5:
                this.am = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.aq = x4;
                this.ao = x4;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.ar = y3;
                this.ap = y3;
                break;
            case 6:
                c(motionEvent);
                break;
        }
        if (!z2) {
            this.an.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    private void E() {
        if (this.an != null) {
            this.an.clear();
        }
        a(0);
        D();
    }

    private void F() {
        E();
        setScrollState(0);
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.am) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.am = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.aq = x2;
            this.ao = x2;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.ar = y;
            this.ap = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.n
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.v
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.n
            boolean r0 = r0.f()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.n
            boolean r3 = r3.e()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.n
            boolean r3 = r3.f()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.n
            boolean r3 = r3.e()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.aw
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.ax
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.n == null) {
            e(i2, i3);
            return;
        }
        boolean z = false;
        if (this.n.c()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.a(this.e, this.D, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.m == null) {
                return;
            }
            if (this.D.d == 1) {
                N();
            }
            this.n.c(i2, i3);
            this.D.i = true;
            O();
            this.n.d(i2, i3);
            if (this.n.l()) {
                this.n.c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.D.i = true;
                O();
                this.n.d(i2, i3);
                return;
            }
            return;
        }
        if (this.r) {
            this.n.a(this.e, this.D, i2, i3);
            return;
        }
        if (this.w) {
            e();
            l();
            I();
            m();
            if (this.D.k) {
                this.D.g = true;
            } else {
                this.f.e();
                this.D.g = false;
            }
            this.w = false;
            a(false);
        } else if (this.D.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        if (this.m != null) {
            this.D.e = this.m.b();
        } else {
            this.D.e = 0;
        }
        e();
        this.n.a(this.e, this.D, i2, i3);
        a(false);
        this.D.g = false;
    }

    void e(int i2, int i3) {
        setMeasuredDimension(i.a(i2, getPaddingLeft() + getPaddingRight(), androidx.core.g.q.j(this)), i.a(i3, getPaddingTop() + getPaddingBottom(), androidx.core.g.q.k(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        k();
    }

    public void setItemAnimator(f fVar) {
        if (this.z != null) {
            this.z.d();
            this.z.a(null);
        }
        this.z = fVar;
        if (this.z != null) {
            this.z.a(this.aB);
        }
    }

    void l() {
        this.ae++;
    }

    void m() {
        b(true);
    }

    void b(boolean z) {
        this.ae--;
        if (this.ae < 1) {
            this.ae = 0;
            if (z) {
                G();
                y();
            }
        }
    }

    boolean n() {
        return this.ac != null && this.ac.isEnabled();
    }

    private void G() {
        int i2 = this.ab;
        this.ab = 0;
        if (i2 == 0 || !n()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        androidx.core.g.a.a.a(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public boolean o() {
        return this.ae > 0;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (!o()) {
            return false;
        }
        int iA = accessibilityEvent != null ? androidx.core.g.a.a.a(accessibilityEvent) : 0;
        if (iA == 0) {
            iA = 0;
        }
        this.ab = iA | this.ab;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public f getItemAnimator() {
        return this.z;
    }

    void p() {
        if (this.G || !this.q) {
            return;
        }
        androidx.core.g.q.a(this, this.aH);
        this.G = true;
    }

    private boolean H() {
        return this.z != null && this.n.b();
    }

    private void I() {
        if (this.x) {
            this.f.a();
            if (this.y) {
                this.n.a(this);
            }
        }
        if (H()) {
            this.f.b();
        } else {
            this.f.e();
        }
        boolean z = false;
        boolean z2 = this.E || this.F;
        this.D.j = this.t && this.z != null && (this.x || z2 || this.n.u) && (!this.x || this.m.c());
        u uVar = this.D;
        if (this.D.j && z2 && !this.x && H()) {
            z = true;
        }
        uVar.k = z;
    }

    void q() {
        if (this.m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.D.i = false;
        if (this.D.d == 1) {
            N();
            this.n.f(this);
            O();
        } else if (this.f.f() || this.n.z() != getWidth() || this.n.A() != getHeight()) {
            this.n.f(this);
            O();
        } else {
            this.n.f(this);
        }
        P();
    }

    private void J() {
        int iG;
        View focusedChild = (this.ay && hasFocus() && this.m != null) ? getFocusedChild() : null;
        x xVarD = focusedChild != null ? d(focusedChild) : null;
        if (xVarD == null) {
            K();
            return;
        }
        this.D.m = this.m.c() ? xVarD.i() : -1L;
        u uVar = this.D;
        if (this.x) {
            iG = -1;
        } else {
            iG = xVarD.s() ? xVarD.d : xVarD.g();
        }
        uVar.l = iG;
        this.D.n = n(xVarD.f1052a);
    }

    private void K() {
        this.D.m = -1L;
        this.D.l = -1;
        this.D.n = -1;
    }

    private View L() {
        x xVarD;
        int i2 = this.D.l != -1 ? this.D.l : 0;
        int iE = this.D.e();
        for (int i3 = i2; i3 < iE; i3++) {
            x xVarD2 = d(i3);
            if (xVarD2 == null) {
                break;
            }
            if (xVarD2.f1052a.hasFocusable()) {
                return xVarD2.f1052a;
            }
        }
        int iMin = Math.min(iE, i2);
        do {
            iMin--;
            if (iMin < 0 || (xVarD = d(iMin)) == null) {
                return null;
            }
        } while (!xVarD.f1052a.hasFocusable());
        return xVarD.f1052a;
    }

    private void M() {
        View viewFindViewById;
        if (!this.ay || this.m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (P && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.g.b() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.g.c(focusedChild)) {
                return;
            }
        }
        View viewL = null;
        x xVarA = (this.D.m == -1 || !this.m.c()) ? null : a(this.D.m);
        if (xVarA == null || this.g.c(xVarA.f1052a) || !xVarA.f1052a.hasFocusable()) {
            if (this.g.b() > 0) {
                viewL = L();
            }
        } else {
            viewL = xVarA.f1052a;
        }
        if (viewL != null) {
            if (this.D.n == -1 || (viewFindViewById = viewL.findViewById(this.D.n)) == null || !viewFindViewById.isFocusable()) {
                viewFindViewById = viewL;
            }
            viewFindViewById.requestFocus();
        }
    }

    private int n(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void a(u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.A.f1050a;
            uVar.o = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.p = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            uVar.o = 0;
            uVar.p = 0;
        }
    }

    private void N() {
        this.D.a(1);
        a(this.D);
        this.D.i = false;
        e();
        this.h.a();
        l();
        I();
        J();
        this.D.h = this.D.j && this.F;
        this.F = false;
        this.E = false;
        this.D.g = this.D.k;
        this.D.e = this.m.b();
        a(this.aD);
        if (this.D.j) {
            int iB = this.g.b();
            for (int i2 = 0; i2 < iB; i2++) {
                x xVarE = e(this.g.b(i2));
                if (!xVarE.e() && (!xVarE.p() || this.m.c())) {
                    this.h.a(xVarE, this.z.a(this.D, xVarE, f.e(xVarE), xVarE.w()));
                    if (this.D.h && xVarE.B() && !xVarE.s() && !xVarE.e() && !xVarE.p()) {
                        this.h.a(a(xVarE), xVarE);
                    }
                }
            }
        }
        if (this.D.k) {
            s();
            boolean z = this.D.f;
            this.D.f = false;
            this.n.c(this.e, this.D);
            this.D.f = z;
            for (int i3 = 0; i3 < this.g.b(); i3++) {
                x xVarE2 = e(this.g.b(i3));
                if (!xVarE2.e() && !this.h.d(xVarE2)) {
                    int iE = f.e(xVarE2);
                    boolean zB = xVarE2.b(8192);
                    if (!zB) {
                        iE |= 4096;
                    }
                    f.c cVarA = this.z.a(this.D, xVarE2, iE, xVarE2.w());
                    if (zB) {
                        a(xVarE2, cVarA);
                    } else {
                        this.h.b(xVarE2, cVarA);
                    }
                }
            }
            t();
        } else {
            t();
        }
        m();
        a(false);
        this.D.d = 2;
    }

    private void O() {
        e();
        l();
        this.D.a(6);
        this.f.e();
        this.D.e = this.m.b();
        this.D.c = 0;
        this.D.g = false;
        this.n.c(this.e, this.D);
        this.D.f = false;
        this.S = null;
        this.D.j = this.D.j && this.z != null;
        this.D.d = 4;
        m();
        a(false);
    }

    private void P() {
        this.D.a(4);
        e();
        l();
        this.D.d = 1;
        if (this.D.j) {
            for (int iB = this.g.b() - 1; iB >= 0; iB--) {
                x xVarE = e(this.g.b(iB));
                if (!xVarE.e()) {
                    long jA = a(xVarE);
                    f.c cVarA = this.z.a(this.D, xVarE);
                    x xVarA = this.h.a(jA);
                    if (xVarA != null && !xVarA.e()) {
                        boolean zA = this.h.a(xVarA);
                        boolean zA2 = this.h.a(xVarE);
                        if (zA && xVarA == xVarE) {
                            this.h.c(xVarE, cVarA);
                        } else {
                            f.c cVarB = this.h.b(xVarA);
                            this.h.c(xVarE, cVarA);
                            f.c cVarC = this.h.c(xVarE);
                            if (cVarB == null) {
                                a(jA, xVarE, xVarA);
                            } else {
                                a(xVarA, xVarE, cVarB, cVarC, zA, zA2);
                            }
                        }
                    } else {
                        this.h.c(xVarE, cVarA);
                    }
                }
            }
            this.h.a(this.aI);
        }
        this.n.b(this.e);
        this.D.f1049b = this.D.e;
        this.x = false;
        this.y = false;
        this.D.j = false;
        this.D.k = false;
        this.n.u = false;
        if (this.e.f1041b != null) {
            this.e.f1041b.clear();
        }
        if (this.n.y) {
            this.n.x = 0;
            this.n.y = false;
            this.e.b();
        }
        this.n.a(this.D);
        m();
        a(false);
        this.h.a();
        if (k(this.aD[0], this.aD[1])) {
            i(0, 0);
        }
        M();
        K();
    }

    private void a(long j2, x xVar, x xVar2) {
        int iB = this.g.b();
        for (int i2 = 0; i2 < iB; i2++) {
            x xVarE = e(this.g.b(i2));
            if (xVarE != xVar && a(xVarE) == j2) {
                if (this.m != null && this.m.c()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + xVarE + " \n View Holder 2:" + xVar + a());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + xVarE + " \n View Holder 2:" + xVar + a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + xVar2 + " cannot be found but it is necessary for " + xVar + a());
    }

    void a(x xVar, f.c cVar) {
        xVar.a(0, 8192);
        if (this.D.h && xVar.B() && !xVar.s() && !xVar.e()) {
            this.h.a(a(xVar), xVar);
        }
        this.h.a(xVar, cVar);
    }

    private void a(int[] iArr) {
        int iB = this.g.b();
        if (iB == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iB; i4++) {
            x xVarE = e(this.g.b(i4));
            if (!xVarE.e()) {
                int iF = xVarE.f();
                if (iF < i2) {
                    i2 = iF;
                }
                if (iF > i3) {
                    i3 = iF;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean k(int i2, int i3) {
        a(this.aD);
        return (this.aD[0] == i2 && this.aD[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        x xVarE = e(view);
        if (xVarE != null) {
            if (xVarE.t()) {
                xVarE.o();
            } else if (!xVarE.e()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + xVarE + a());
            }
        }
        view.clearAnimation();
        l(view);
        super.removeDetachedView(view, z);
    }

    long a(x xVar) {
        return this.m.c() ? xVar.i() : xVar.c;
    }

    void a(x xVar, f.c cVar, f.c cVar2) {
        xVar.c(false);
        if (this.z.b(xVar, cVar, cVar2)) {
            p();
        }
    }

    void b(x xVar, f.c cVar, f.c cVar2) {
        e(xVar);
        xVar.c(false);
        if (this.z.a(xVar, cVar, cVar2)) {
            p();
        }
    }

    private void a(x xVar, x xVar2, f.c cVar, f.c cVar2, boolean z, boolean z2) {
        xVar.c(false);
        if (z) {
            e(xVar);
        }
        if (xVar != xVar2) {
            if (z2) {
                e(xVar2);
            }
            xVar.h = xVar2;
            e(xVar);
            this.e.c(xVar);
            xVar2.c(false);
            xVar2.i = xVar;
        }
        if (this.z.a(xVar, xVar2, cVar, cVar2)) {
            p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        androidx.core.os.a.a("RV OnLayout");
        q();
        androidx.core.os.a.a();
        this.t = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.W == 0 && !this.v) {
            super.requestLayout();
        } else {
            this.u = true;
        }
    }

    void r() {
        int iC = this.g.c();
        for (int i2 = 0; i2 < iC; i2++) {
            ((j) this.g.d(i2).getLayoutParams()).e = true;
        }
        this.e.j();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.p.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).a(canvas, this, this.D);
        }
        if (this.ah == null || this.ah.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            z = this.ah != null && this.ah.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (this.ai != null && !this.ai.isFinished()) {
            int iSave2 = canvas.save();
            if (this.i) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            z |= this.ai != null && this.ai.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (this.aj != null && !this.aj.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            z |= this.aj != null && this.aj.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        if (this.ak == null || this.ak.isFinished()) {
            z2 = z;
        } else {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.i) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            if (this.ak != null && this.ak.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(iSave4);
        }
        if (!z2 && this.z != null && this.p.size() > 0 && this.z.b()) {
            z2 = true;
        }
        if (z2) {
            androidx.core.g.q.d(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).b(canvas, this, this.D);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.n.a((j) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
        }
        return this.n.a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
        }
        return this.n.a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
        }
        return this.n.a(layoutParams);
    }

    void s() {
        int iC = this.g.c();
        for (int i2 = 0; i2 < iC; i2++) {
            x xVarE = e(this.g.d(i2));
            if (!xVarE.e()) {
                xVarE.d();
            }
        }
    }

    void t() {
        int iC = this.g.c();
        for (int i2 = 0; i2 < iC; i2++) {
            x xVarE = e(this.g.d(i2));
            if (!xVarE.e()) {
                xVarE.c();
            }
        }
        this.e.i();
    }

    void f(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int iC = this.g.c();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < iC; i7++) {
            x xVarE = e(this.g.d(i7));
            if (xVarE != null && xVarE.c >= i5 && xVarE.c <= i4) {
                if (xVarE.c == i2) {
                    xVarE.a(i3 - i2, false);
                } else {
                    xVarE.a(i6, false);
                }
                this.D.f = true;
            }
        }
        this.e.a(i2, i3);
        requestLayout();
    }

    void g(int i2, int i3) {
        int iC = this.g.c();
        for (int i4 = 0; i4 < iC; i4++) {
            x xVarE = e(this.g.d(i4));
            if (xVarE != null && !xVarE.e() && xVarE.c >= i2) {
                xVarE.a(i3, false);
                this.D.f = true;
            }
        }
        this.e.b(i2, i3);
        requestLayout();
    }

    void a(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int iC = this.g.c();
        for (int i5 = 0; i5 < iC; i5++) {
            x xVarE = e(this.g.d(i5));
            if (xVarE != null && !xVarE.e()) {
                if (xVarE.c >= i4) {
                    xVarE.a(-i3, z);
                    this.D.f = true;
                } else if (xVarE.c >= i2) {
                    xVarE.a(i2 - 1, -i3, z);
                    this.D.f = true;
                }
            }
        }
        this.e.a(i2, i3, z);
        requestLayout();
    }

    void a(int i2, int i3, Object obj) {
        int iC = this.g.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < iC; i5++) {
            View viewD = this.g.d(i5);
            x xVarE = e(viewD);
            if (xVarE != null && !xVarE.e() && xVarE.c >= i2 && xVarE.c < i4) {
                xVarE.c(2);
                xVarE.a(obj);
                ((j) viewD.getLayoutParams()).e = true;
            }
        }
        this.e.c(i2, i3);
    }

    boolean b(x xVar) {
        return this.z == null || this.z.a(xVar, xVar.w());
    }

    void c(boolean z) {
        this.y = z | this.y;
        this.x = true;
        u();
    }

    void u() {
        int iC = this.g.c();
        for (int i2 = 0; i2 < iC; i2++) {
            x xVarE = e(this.g.d(i2));
            if (xVarE != null && !xVarE.e()) {
                xVarE.c(6);
            }
        }
        r();
        this.e.h();
    }

    public void v() {
        if (this.p.size() == 0) {
            return;
        }
        if (this.n != null) {
            this.n.a("Cannot invalidate item decorations during a scroll or layout");
        }
        r();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ay;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.ay = z;
    }

    public x b(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return e(view);
    }

    public View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public x d(View view) {
        View viewC = c(view);
        if (viewC == null) {
            return null;
        }
        return b(viewC);
    }

    static x e(View view) {
        if (view == null) {
            return null;
        }
        return ((j) view.getLayoutParams()).c;
    }

    public int f(View view) {
        x xVarE = e(view);
        if (xVarE != null) {
            return xVarE.g();
        }
        return -1;
    }

    public int g(View view) {
        x xVarE = e(view);
        if (xVarE != null) {
            return xVarE.f();
        }
        return -1;
    }

    public x d(int i2) {
        x xVar = null;
        if (this.x) {
            return null;
        }
        int iC = this.g.c();
        for (int i3 = 0; i3 < iC; i3++) {
            x xVarE = e(this.g.d(i3));
            if (xVarE != null && !xVarE.s() && d(xVarE) == i2) {
                if (!this.g.c(xVarE.f1052a)) {
                    return xVarE;
                }
                xVar = xVarE;
            }
        }
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.x a(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.d r0 = r5.g
            int r0 = r0.c()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.d r3 = r5.g
            android.view.View r3 = r3.d(r2)
            androidx.recyclerview.widget.RecyclerView$x r3 = e(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.s()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.f()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.d r1 = r5.g
            android.view.View r4 = r3.f1052a
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, boolean):androidx.recyclerview.widget.RecyclerView$x");
    }

    public x a(long j2) {
        x xVar = null;
        if (this.m == null || !this.m.c()) {
            return null;
        }
        int iC = this.g.c();
        for (int i2 = 0; i2 < iC; i2++) {
            x xVarE = e(this.g.d(i2));
            if (xVarE != null && !xVarE.s() && xVarE.i() == j2) {
                if (!this.g.c(xVarE.f1052a)) {
                    return xVarE;
                }
                xVar = xVarE;
            }
        }
        return xVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void e(int i2) {
        int iB = this.g.b();
        for (int i3 = 0; i3 < iB; i3++) {
            this.g.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void f(int i2) {
        int iB = this.g.b();
        for (int i3 = 0; i3 < iB; i3++) {
            this.g.b(i3).offsetLeftAndRight(i2);
        }
    }

    static void a(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.d;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    Rect j(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.e) {
            return jVar.d;
        }
        if (this.D.a() && (jVar.e() || jVar.c())) {
            return jVar.d;
        }
        Rect rect = jVar.d;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k.set(0, 0, 0, 0);
            this.p.get(i2).a(this.k, view, this, this.D);
            rect.left += this.k.left;
            rect.top += this.k.top;
            rect.right += this.k.right;
            rect.bottom += this.k.bottom;
        }
        jVar.e = false;
        return rect;
    }

    void i(int i2, int i3) {
        this.af++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        if (this.az != null) {
            this.az.a(this, i2, i3);
        }
        if (this.aA != null) {
            for (int size = this.aA.size() - 1; size >= 0; size--) {
                this.aA.get(size).a(this, i2, i3);
            }
        }
        this.af--;
    }

    void h(int i2) {
        if (this.n != null) {
            this.n.l(i2);
        }
        g(i2);
        if (this.az != null) {
            this.az.a(this, i2);
        }
        if (this.aA != null) {
            for (int size = this.aA.size() - 1; size >= 0; size--) {
                this.aA.get(size).a(this, i2);
            }
        }
    }

    public boolean w() {
        return !this.t || this.x || this.f.d();
    }

    class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        OverScroller f1050a;
        private int d;
        private int e;

        /* renamed from: b, reason: collision with root package name */
        Interpolator f1051b = RecyclerView.L;
        private boolean f = false;
        private boolean g = false;

        w() {
            this.f1050a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.L);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 432
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.w.run():void");
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                androidx.core.g.q.a(RecyclerView.this, this);
            }
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.f1050a.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        private float a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int b(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fA = f2 + (a(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fA / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.L);
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int iB = b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.L;
            }
            a(i, i2, iB, interpolator);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f1051b != interpolator) {
                this.f1051b = interpolator;
                this.f1050a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.f1050a.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1050a.computeScrollOffset();
            }
            a();
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f1050a.abortAnimation();
        }
    }

    void x() {
        int iB = this.g.b();
        for (int i2 = 0; i2 < iB; i2++) {
            View viewB = this.g.b(i2);
            x xVarB = b(viewB);
            if (xVarB != null && xVarB.i != null) {
                View view = xVarB.i.f1052a;
                int left = viewB.getLeft();
                int top = viewB.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private class r extends c {
        r() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView.this.D.f = true;
            RecyclerView.this.c(true);
            if (RecyclerView.this.f.d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a(int i, int i2, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f.a(i, i2, obj)) {
                b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void b(int i, int i2) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f.b(i, i2)) {
                b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void c(int i, int i2) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f.c(i, i2)) {
                b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a(int i, int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f.a(i, i2, i3)) {
                b();
            }
        }

        void b() {
            if (RecyclerView.c && RecyclerView.this.r && RecyclerView.this.q) {
                androidx.core.g.q.a(RecyclerView.this, RecyclerView.this.j);
            } else {
                RecyclerView.this.w = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    public static class e {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static class o {

        /* renamed from: a, reason: collision with root package name */
        SparseArray<a> f1036a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private int f1037b = 0;

        static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList<x> f1038a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            int f1039b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        public void a() {
            for (int i = 0; i < this.f1036a.size(); i++) {
                this.f1036a.valueAt(i).f1038a.clear();
            }
        }

        public x a(int i) {
            a aVar = this.f1036a.get(i);
            if (aVar == null || aVar.f1038a.isEmpty()) {
                return null;
            }
            return aVar.f1038a.remove(r2.size() - 1);
        }

        public void a(x xVar) {
            int iJ = xVar.j();
            ArrayList<x> arrayList = b(iJ).f1038a;
            if (this.f1036a.get(iJ).f1039b <= arrayList.size()) {
                return;
            }
            xVar.x();
            arrayList.add(xVar);
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void a(int i, long j) {
            a aVarB = b(i);
            aVarB.c = a(aVarB.c, j);
        }

        void b(int i, long j) {
            a aVarB = b(i);
            aVarB.d = a(aVarB.d, j);
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        void b() {
            this.f1037b++;
        }

        void c() {
            this.f1037b--;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f1037b == 0) {
                a();
            }
            if (aVar2 != null) {
                b();
            }
        }

        private a b(int i) {
            a aVar = this.f1036a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1036a.put(i, aVar2);
            return aVar2;
        }
    }

    static RecyclerView k(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewK = k(viewGroup.getChildAt(i2));
            if (recyclerViewK != null) {
                return recyclerViewK;
            }
        }
        return null;
    }

    static void c(x xVar) {
        if (xVar.f1053b != null) {
            RecyclerView recyclerView = xVar.f1053b.get();
            while (recyclerView != null) {
                if (recyclerView == xVar.f1052a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            xVar.f1053b = null;
        }
    }

    long getNanoTime() {
        if (d) {
            return System.nanoTime();
        }
        return 0L;
    }

    public final class p {
        o e;
        private v i;

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<x> f1040a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        ArrayList<x> f1041b = null;
        final ArrayList<x> c = new ArrayList<>();
        private final List<x> g = Collections.unmodifiableList(this.f1040a);
        private int h = 2;
        int d = 2;

        public p() {
        }

        public void a() {
            this.f1040a.clear();
            d();
        }

        public void a(int i) {
            this.h = i;
            b();
        }

        void b() {
            this.d = this.h + (RecyclerView.this.n != null ? RecyclerView.this.n.x : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
                d(size);
            }
        }

        public List<x> c() {
            return this.g;
        }

        boolean a(x xVar) {
            if (xVar.s()) {
                return RecyclerView.this.D.a();
            }
            if (xVar.c < 0 || xVar.c >= RecyclerView.this.m.b()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + xVar + RecyclerView.this.a());
            }
            if (RecyclerView.this.D.a() || RecyclerView.this.m.c(xVar.c) == xVar.j()) {
                return !RecyclerView.this.m.c() || xVar.i() == RecyclerView.this.m.b(xVar.c);
            }
            return false;
        }

        private boolean a(x xVar, int i, int i2, long j) {
            xVar.p = RecyclerView.this;
            int iJ = xVar.j();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.e.b(iJ, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.m.b((a) xVar, i);
            this.e.b(xVar.j(), RecyclerView.this.getNanoTime() - nanoTime);
            e(xVar);
            if (!RecyclerView.this.D.a()) {
                return true;
            }
            xVar.g = i2;
            return true;
        }

        public int b(int i) {
            if (i >= 0 && i < RecyclerView.this.D.e()) {
                return !RecyclerView.this.D.a() ? i : RecyclerView.this.f.b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.D.e() + RecyclerView.this.a());
        }

        public View c(int i) {
            return a(i, false);
        }

        View a(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).f1052a;
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x0232 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0235  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0189 A[PHI: r1 r4
          0x0189: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$x) = (r1v11 androidx.recyclerview.widget.RecyclerView$x), (r1v31 androidx.recyclerview.widget.RecyclerView$x) binds: [B:28:0x005d, B:58:0x0103] A[DONT_GENERATE, DONT_INLINE]
          0x0189: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:58:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0216  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        androidx.recyclerview.widget.RecyclerView.x a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 625
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$x");
        }

        private void e(x xVar) {
            if (RecyclerView.this.n()) {
                View view = xVar.f1052a;
                if (androidx.core.g.q.e(view) == 0) {
                    androidx.core.g.q.b(view, 1);
                }
                if (androidx.core.g.q.b(view)) {
                    return;
                }
                xVar.c(16384);
                androidx.core.g.q.a(view, RecyclerView.this.H.b());
            }
        }

        private void f(x xVar) {
            if (xVar.f1052a instanceof ViewGroup) {
                a((ViewGroup) xVar.f1052a, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void a(View view) {
            x xVarE = RecyclerView.e(view);
            if (xVarE.t()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (xVarE.k()) {
                xVarE.l();
            } else if (xVarE.m()) {
                xVarE.n();
            }
            b(xVarE);
        }

        void d() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.c.clear();
            if (RecyclerView.d) {
                RecyclerView.this.C.a();
            }
        }

        void d(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        void b(x xVar) {
            boolean z;
            if (xVar.k() || xVar.f1052a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.k());
                sb.append(" isAttached:");
                sb.append(xVar.f1052a.getParent() != null);
                sb.append(RecyclerView.this.a());
                throw new IllegalArgumentException(sb.toString());
            }
            if (xVar.t()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + xVar + RecyclerView.this.a());
            }
            if (xVar.e()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.a());
            }
            boolean zA = xVar.A();
            if ((RecyclerView.this.m != null && zA && RecyclerView.this.m.b((a) xVar)) || xVar.y()) {
                if (this.d <= 0 || xVar.b(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.d && size > 0) {
                        d(0);
                        size--;
                    }
                    if (RecyclerView.d && size > 0 && !RecyclerView.this.C.a(xVar.c)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.C.a(this.c.get(i).c)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, xVar);
                    z = true;
                }
                if (!z) {
                    a(xVar, true);
                    z = true;
                }
            } else {
                z = false;
            }
            RecyclerView.this.h.g(xVar);
            if (z || z || !zA) {
                return;
            }
            xVar.p = null;
        }

        void a(x xVar, boolean z) {
            RecyclerView.c(xVar);
            if (xVar.b(16384)) {
                xVar.a(0, 16384);
                androidx.core.g.q.a(xVar.f1052a, (androidx.core.g.a) null);
            }
            if (z) {
                d(xVar);
            }
            xVar.p = null;
            g().a(xVar);
        }

        void b(View view) {
            x xVarE = RecyclerView.e(view);
            xVarE.m = null;
            xVarE.n = false;
            xVarE.n();
            b(xVarE);
        }

        void c(View view) {
            x xVarE = RecyclerView.e(view);
            if (xVarE.b(12) || !xVarE.B() || RecyclerView.this.b(xVarE)) {
                if (xVarE.p() && !xVarE.s() && !RecyclerView.this.m.c()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.a());
                }
                xVarE.a(this, false);
                this.f1040a.add(xVarE);
                return;
            }
            if (this.f1041b == null) {
                this.f1041b = new ArrayList<>();
            }
            xVarE.a(this, true);
            this.f1041b.add(xVarE);
        }

        void c(x xVar) {
            if (xVar.n) {
                this.f1041b.remove(xVar);
            } else {
                this.f1040a.remove(xVar);
            }
            xVar.m = null;
            xVar.n = false;
            xVar.n();
        }

        int e() {
            return this.f1040a.size();
        }

        View e(int i) {
            return this.f1040a.get(i).f1052a;
        }

        void f() {
            this.f1040a.clear();
            if (this.f1041b != null) {
                this.f1041b.clear();
            }
        }

        x f(int i) {
            int size;
            int iB;
            if (this.f1041b == null || (size = this.f1041b.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = this.f1041b.get(i2);
                if (!xVar.m() && xVar.f() == i) {
                    xVar.c(32);
                    return xVar;
                }
            }
            if (RecyclerView.this.m.c() && (iB = RecyclerView.this.f.b(i)) > 0 && iB < RecyclerView.this.m.b()) {
                long jB = RecyclerView.this.m.b(iB);
                for (int i3 = 0; i3 < size; i3++) {
                    x xVar2 = this.f1041b.get(i3);
                    if (!xVar2.m() && xVar2.i() == jB) {
                        xVar2.c(32);
                        return xVar2;
                    }
                }
            }
            return null;
        }

        x b(int i, boolean z) {
            View viewC;
            int size = this.f1040a.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = this.f1040a.get(i2);
                if (!xVar.m() && xVar.f() == i && !xVar.p() && (RecyclerView.this.D.g || !xVar.s())) {
                    xVar.c(32);
                    return xVar;
                }
            }
            if (!z && (viewC = RecyclerView.this.g.c(i)) != null) {
                x xVarE = RecyclerView.e(viewC);
                RecyclerView.this.g.e(viewC);
                int iB = RecyclerView.this.g.b(viewC);
                if (iB == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + xVarE + RecyclerView.this.a());
                }
                RecyclerView.this.g.e(iB);
                c(viewC);
                xVarE.c(8224);
                return xVarE;
            }
            int size2 = this.c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                x xVar2 = this.c.get(i3);
                if (!xVar2.p() && xVar2.f() == i) {
                    if (!z) {
                        this.c.remove(i3);
                    }
                    return xVar2;
                }
            }
            return null;
        }

        x a(long j, int i, boolean z) {
            for (int size = this.f1040a.size() - 1; size >= 0; size--) {
                x xVar = this.f1040a.get(size);
                if (xVar.i() == j && !xVar.m()) {
                    if (i == xVar.j()) {
                        xVar.c(32);
                        if (xVar.s() && !RecyclerView.this.D.a()) {
                            xVar.a(2, 14);
                        }
                        return xVar;
                    }
                    if (!z) {
                        this.f1040a.remove(size);
                        RecyclerView.this.removeDetachedView(xVar.f1052a, false);
                        b(xVar.f1052a);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                x xVar2 = this.c.get(size2);
                if (xVar2.i() == j) {
                    if (i == xVar2.j()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return xVar2;
                    }
                    if (!z) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        void d(x xVar) {
            if (RecyclerView.this.o != null) {
                RecyclerView.this.o.a(xVar);
            }
            if (RecyclerView.this.m != null) {
                RecyclerView.this.m.a((a) xVar);
            }
            if (RecyclerView.this.D != null) {
                RecyclerView.this.h.g(xVar);
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.c.size();
            for (int i6 = 0; i6 < size; i6++) {
                x xVar = this.c.get(i6);
                if (xVar != null && xVar.c >= i4 && xVar.c <= i3) {
                    if (xVar.c == i) {
                        xVar.a(i2 - i, false);
                    } else {
                        xVar.a(i5, false);
                    }
                }
            }
        }

        void b(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                x xVar = this.c.get(i3);
                if (xVar != null && xVar.c >= i) {
                    xVar.a(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                x xVar = this.c.get(size);
                if (xVar != null) {
                    if (xVar.c >= i3) {
                        xVar.a(-i2, z);
                    } else if (xVar.c >= i) {
                        xVar.c(8);
                        d(size);
                    }
                }
            }
        }

        void a(v vVar) {
            this.i = vVar;
        }

        void a(o oVar) {
            if (this.e != null) {
                this.e.c();
            }
            this.e = oVar;
            if (this.e == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.e.b();
        }

        o g() {
            if (this.e == null) {
                this.e = new o();
            }
            return this.e;
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                x xVar = this.c.get(size);
                if (xVar != null && (i3 = xVar.c) >= i && i3 < i4) {
                    xVar.c(2);
                    d(size);
                }
            }
        }

        void h() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                x xVar = this.c.get(i);
                if (xVar != null) {
                    xVar.c(6);
                    xVar.a((Object) null);
                }
            }
            if (RecyclerView.this.m == null || !RecyclerView.this.m.c()) {
                d();
            }
        }

        void i() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).c();
            }
            int size2 = this.f1040a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f1040a.get(i2).c();
            }
            if (this.f1041b != null) {
                int size3 = this.f1041b.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f1041b.get(i3).c();
                }
            }
        }

        void j() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                j jVar = (j) this.c.get(i).f1052a.getLayoutParams();
                if (jVar != null) {
                    jVar.e = true;
                }
            }
        }
    }

    public static abstract class a<VH extends x> {

        /* renamed from: a, reason: collision with root package name */
        private final b f1023a = new b();

        /* renamed from: b, reason: collision with root package name */
        private boolean f1024b = false;

        public void a(VH vh) {
        }

        public abstract void a(VH vh, int i);

        public void a(RecyclerView recyclerView) {
        }

        public abstract int b();

        public long b(int i) {
            return -1L;
        }

        public abstract VH b(ViewGroup viewGroup, int i);

        public void b(RecyclerView recyclerView) {
        }

        public boolean b(VH vh) {
            return false;
        }

        public int c(int i) {
            return 0;
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }

        public void a(VH vh, int i, List<Object> list) {
            a((a<VH>) vh, i);
        }

        public final VH c(ViewGroup viewGroup, int i) {
            try {
                androidx.core.os.a.a("RV CreateView");
                VH vh = (VH) b(viewGroup, i);
                if (vh.f1052a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.f = i;
                return vh;
            } finally {
                androidx.core.os.a.a();
            }
        }

        public final void b(VH vh, int i) {
            vh.c = i;
            if (c()) {
                vh.e = b(i);
            }
            vh.a(1, 519);
            androidx.core.os.a.a("RV OnBindView");
            a((a<VH>) vh, i, vh.w());
            vh.v();
            ViewGroup.LayoutParams layoutParams = vh.f1052a.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).e = true;
            }
            androidx.core.os.a.a();
        }

        public void a(boolean z) {
            if (d()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f1024b = z;
        }

        public final boolean c() {
            return this.f1024b;
        }

        public final boolean d() {
            return this.f1023a.a();
        }

        public void a(c cVar) {
            this.f1023a.registerObserver(cVar);
        }

        public void b(c cVar) {
            this.f1023a.unregisterObserver(cVar);
        }

        public final void e() {
            this.f1023a.b();
        }

        public final void d(int i) {
            this.f1023a.a(i, 1);
        }

        public final void a(int i, Object obj) {
            this.f1023a.a(i, 1, obj);
        }

        public final void a(int i, int i2, Object obj) {
            this.f1023a.a(i, i2, obj);
        }

        public final void e(int i) {
            this.f1023a.b(i, 1);
        }

        public final void a(int i, int i2) {
            this.f1023a.d(i, i2);
        }

        public final void b(int i, int i2) {
            this.f1023a.b(i, i2);
        }

        public final void f(int i) {
            this.f1023a.c(i, 1);
        }

        public final void c(int i, int i2) {
            this.f1023a.c(i, i2);
        }
    }

    void l(View view) {
        x xVarE = e(view);
        i(view);
        if (this.m != null && xVarE != null) {
            this.m.d((a) xVarE);
        }
        if (this.ad != null) {
            for (int size = this.ad.size() - 1; size >= 0; size--) {
                this.ad.get(size).b(view);
            }
        }
    }

    void m(View view) {
        x xVarE = e(view);
        h(view);
        if (this.m != null && xVarE != null) {
            this.m.c((a) xVarE);
        }
        if (this.ad != null) {
            for (int size = this.ad.size() - 1; size >= 0; size--) {
                this.ad.get(size).a(view);
            }
        }
    }

    public static abstract class i {
        private int e;
        private int f;
        private int g;
        private int h;
        androidx.recyclerview.widget.d p;
        RecyclerView q;
        t t;
        int x;
        boolean y;

        /* renamed from: a, reason: collision with root package name */
        private final p.b f1030a = new p.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.1
            @Override // androidx.recyclerview.widget.p.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.p.b
            public int a() {
                return i.this.B();
            }

            @Override // androidx.recyclerview.widget.p.b
            public int b() {
                return i.this.z() - i.this.D();
            }

            @Override // androidx.recyclerview.widget.p.b
            public int a(View view) {
                return i.this.h(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.p.b
            public int b(View view) {
                return i.this.j(view) + ((j) view.getLayoutParams()).rightMargin;
            }
        };

        /* renamed from: b, reason: collision with root package name */
        private final p.b f1031b = new p.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.2
            @Override // androidx.recyclerview.widget.p.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.p.b
            public int a() {
                return i.this.C();
            }

            @Override // androidx.recyclerview.widget.p.b
            public int b() {
                return i.this.A() - i.this.E();
            }

            @Override // androidx.recyclerview.widget.p.b
            public int a(View view) {
                return i.this.i(view) - ((j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.p.b
            public int b(View view) {
                return i.this.k(view) + ((j) view.getLayoutParams()).bottomMargin;
            }
        };
        androidx.recyclerview.widget.p r = new androidx.recyclerview.widget.p(this.f1030a);
        androidx.recyclerview.widget.p s = new androidx.recyclerview.widget.p(this.f1031b);
        boolean u = false;
        boolean v = false;
        boolean w = false;
        private boolean c = true;
        private boolean d = true;

        public interface a {
            void b(int i, int i2);
        }

        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public int f1034a;

            /* renamed from: b, reason: collision with root package name */
            public int f1035b;
            public boolean c;
            public boolean d;
        }

        public int a(int i, p pVar, u uVar) {
            return 0;
        }

        public View a(View view, int i, p pVar, u uVar) {
            return null;
        }

        public abstract j a();

        public void a(int i, int i2, u uVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(u uVar) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public boolean a(j jVar) {
            return jVar != null;
        }

        public boolean a(p pVar, u uVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int b(int i, p pVar, u uVar) {
            return 0;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public boolean b() {
            return false;
        }

        public int c(u uVar) {
            return 0;
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public int d(p pVar, u uVar) {
            return 0;
        }

        public int d(u uVar) {
            return 0;
        }

        public Parcelable d() {
            return null;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(RecyclerView recyclerView) {
        }

        public int e(u uVar) {
            return 0;
        }

        public void e(int i) {
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(p pVar, u uVar) {
            return false;
        }

        public int f(u uVar) {
            return 0;
        }

        public boolean f() {
            return false;
        }

        public int g(u uVar) {
            return 0;
        }

        public int h(u uVar) {
            return 0;
        }

        public void l(int i) {
        }

        boolean l() {
            return false;
        }

        public int v() {
            return -1;
        }

        void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.g = 0;
                this.h = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.g;
                this.g = recyclerView.getWidth();
                this.h = recyclerView.getHeight();
            }
            this.e = 1073741824;
            this.f = 1073741824;
        }

        void c(int i, int i2) {
            this.g = View.MeasureSpec.getSize(i);
            this.e = View.MeasureSpec.getMode(i);
            if (this.e == 0 && !RecyclerView.f1017b) {
                this.g = 0;
            }
            this.h = View.MeasureSpec.getSize(i2);
            this.f = View.MeasureSpec.getMode(i2);
            if (this.f != 0 || RecyclerView.f1017b) {
                return;
            }
            this.h = 0;
        }

        void d(int i, int i2) {
            int iW = w();
            if (iW == 0) {
                this.q.e(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < iW; i7++) {
                View viewI = i(i7);
                Rect rect = this.q.k;
                a(viewI, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.q.k.set(i3, i4, i5, i6);
            a(this.q.k, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            f(a(i, rect.width() + B() + D(), G()), a(i2, rect.height() + C() + E(), H()));
        }

        public void p() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        public boolean c() {
            return this.w;
        }

        public final boolean q() {
            return this.d;
        }

        void c(RecyclerView recyclerView) {
            this.v = true;
            d(recyclerView);
        }

        void b(RecyclerView recyclerView, p pVar) {
            this.v = false;
            a(recyclerView, pVar);
        }

        public boolean r() {
            return this.v;
        }

        public boolean a(Runnable runnable) {
            if (this.q != null) {
                return this.q.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, p pVar) {
            e(recyclerView);
        }

        public boolean s() {
            return this.q != null && this.q.i;
        }

        public void c(p pVar, u uVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public j a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public boolean t() {
            return this.t != null && this.t.d();
        }

        public int u() {
            return androidx.core.g.q.f(this.q);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        private void a(View view, int i, boolean z) {
            x xVarE = RecyclerView.e(view);
            if (z || xVarE.s()) {
                this.q.h.e(xVarE);
            } else {
                this.q.h.f(xVarE);
            }
            j jVar = (j) view.getLayoutParams();
            if (xVarE.m() || xVarE.k()) {
                if (xVarE.k()) {
                    xVarE.l();
                } else {
                    xVarE.n();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int iB = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (iB == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view) + this.q.a());
                }
                if (iB != i) {
                    this.q.n.e(iB, i);
                }
            } else {
                this.p.a(view, i, false);
                jVar.e = true;
                if (this.t != null && this.t.d()) {
                    this.t.b(view);
                }
            }
            if (jVar.f) {
                xVarE.f1052a.invalidate();
                jVar.f = false;
            }
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void g(int i) {
            if (i(i) != null) {
                this.p.a(i);
            }
        }

        public int d(View view) {
            return ((j) view.getLayoutParams()).f();
        }

        public View e(View view) {
            View viewC;
            if (this.q == null || (viewC = this.q.c(view)) == null || this.p.c(viewC)) {
                return null;
            }
            return viewC;
        }

        public View c(int i) {
            int iW = w();
            for (int i2 = 0; i2 < iW; i2++) {
                View viewI = i(i2);
                x xVarE = RecyclerView.e(viewI);
                if (xVarE != null && xVarE.f() == i && !xVarE.e() && (this.q.D.a() || !xVarE.s())) {
                    return viewI;
                }
            }
            return null;
        }

        public void h(int i) {
            a(i, i(i));
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        public void a(View view, int i, j jVar) {
            x xVarE = RecyclerView.e(view);
            if (xVarE.s()) {
                this.q.h.e(xVarE);
            } else {
                this.q.h.f(xVarE);
            }
            this.p.a(view, i, jVar, xVarE.s());
        }

        public void c(View view, int i) {
            a(view, i, (j) view.getLayoutParams());
        }

        public void e(int i, int i2) {
            View viewI = i(i);
            if (viewI == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.q.toString());
            }
            h(i);
            c(viewI, i2);
        }

        public void a(View view, p pVar) {
            c(view);
            pVar.a(view);
        }

        public void a(int i, p pVar) {
            View viewI = i(i);
            g(i);
            pVar.a(viewI);
        }

        public int w() {
            if (this.p != null) {
                return this.p.b();
            }
            return 0;
        }

        public View i(int i) {
            if (this.p != null) {
                return this.p.b(i);
            }
            return null;
        }

        public int x() {
            return this.e;
        }

        public int y() {
            return this.f;
        }

        public int z() {
            return this.g;
        }

        public int A() {
            return this.h;
        }

        public int B() {
            if (this.q != null) {
                return this.q.getPaddingLeft();
            }
            return 0;
        }

        public int C() {
            if (this.q != null) {
                return this.q.getPaddingTop();
            }
            return 0;
        }

        public int D() {
            if (this.q != null) {
                return this.q.getPaddingRight();
            }
            return 0;
        }

        public int E() {
            if (this.q != null) {
                return this.q.getPaddingBottom();
            }
            return 0;
        }

        public View F() {
            View focusedChild;
            if (this.q == null || (focusedChild = this.q.getFocusedChild()) == null || this.p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.f(i);
            }
        }

        public void k(int i) {
            if (this.q != null) {
                this.q.e(i);
            }
        }

        public void a(p pVar) {
            for (int iW = w() - 1; iW >= 0; iW--) {
                a(pVar, iW, i(iW));
            }
        }

        private void a(p pVar, int i, View view) {
            x xVarE = RecyclerView.e(view);
            if (xVarE.e()) {
                return;
            }
            if (xVarE.p() && !xVarE.s() && !this.q.m.c()) {
                g(i);
                pVar.b(xVarE);
            } else {
                h(i);
                pVar.c(view);
                this.q.h.h(xVarE);
            }
        }

        void b(p pVar) {
            int iE = pVar.e();
            for (int i = iE - 1; i >= 0; i--) {
                View viewE = pVar.e(i);
                x xVarE = RecyclerView.e(viewE);
                if (!xVarE.e()) {
                    xVarE.c(false);
                    if (xVarE.t()) {
                        this.q.removeDetachedView(viewE, false);
                    }
                    if (this.q.z != null) {
                        this.q.z.d(xVarE);
                    }
                    xVarE.c(true);
                    pVar.b(viewE);
                }
            }
            pVar.f();
            if (iE > 0) {
                this.q.invalidate();
            }
        }

        boolean a(View view, int i, int i2, j jVar) {
            return (this.c && b(view.getMeasuredWidth(), i, jVar.width) && b(view.getMeasuredHeight(), i2, jVar.height)) ? false : true;
        }

        boolean b(View view, int i, int i2, j jVar) {
            return (!view.isLayoutRequested() && this.c && b(view.getWidth(), i, jVar.width) && b(view.getHeight(), i2, jVar.height)) ? false : true;
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void a(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect rectJ = this.q.j(view);
            int i3 = i + rectJ.left + rectJ.right;
            int i4 = i2 + rectJ.top + rectJ.bottom;
            int iA = a(z(), x(), B() + D() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, e());
            int iA2 = a(A(), y(), C() + E() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, f());
            if (b(view, iA, iA2, jVar)) {
                view.measure(iA, iA2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int a(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L23
                if (r7 < 0) goto L14
            L10:
                r4 = r7
                r6 = 1073741824(0x40000000, float:2.0)
                goto L34
            L14:
                if (r7 != r1) goto L33
                if (r5 == r2) goto L1f
                if (r5 == 0) goto L1c
                if (r5 == r3) goto L1f
            L1c:
                r5 = 0
                r7 = 0
                goto L20
            L1f:
                r7 = r4
            L20:
                r6 = r5
                r4 = r7
                goto L34
            L23:
                if (r7 < 0) goto L26
                goto L10
            L26:
                if (r7 != r1) goto L2a
                r6 = r5
                goto L34
            L2a:
                if (r7 != r0) goto L33
                if (r5 == r2) goto L30
                if (r5 != r3) goto L34
            L30:
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L34
            L33:
                r4 = 0
            L34:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.a(int, int, int, int, boolean):int");
        }

        public int f(View view) {
            Rect rect = ((j) view.getLayoutParams()).d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int g(View view) {
            Rect rect = ((j) view.getLayoutParams()).d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.d;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.q.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.j(view));
            }
        }

        public int l(View view) {
            return ((j) view.getLayoutParams()).d.top;
        }

        public int m(View view) {
            return ((j) view.getLayoutParams()).d.bottom;
        }

        public int n(View view) {
            return ((j) view.getLayoutParams()).d.left;
        }

        public int o(View view) {
            return ((j) view.getLayoutParams()).d.right;
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iB = B();
            int iC = C();
            int iZ = z() - D();
            int iA = A() - E();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iB;
            int iMin = Math.min(0, i);
            int i2 = top - iC;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iZ;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iA);
            if (u() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrB = b(recyclerView, view, rect, z);
            int i = iArrB[0];
            int i2 = iArrB[1];
            if ((z2 && !d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.a(i, i2);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iB = B();
            int iC = C();
            int iZ = z() - D();
            int iA = A() - E();
            Rect rect = this.q.k;
            a(focusedChild, rect);
            return rect.left - i < iZ && rect.right - i > iB && rect.top - i2 < iA && rect.bottom - i2 > iC;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return t() || recyclerView.o();
        }

        public boolean a(RecyclerView recyclerView, u uVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(p pVar, u uVar, int i, int i2) {
            this.q.e(i, i2);
        }

        public void f(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public int G() {
            return androidx.core.g.q.j(this.q);
        }

        public int H() {
            return androidx.core.g.q.k(this.q);
        }

        void I() {
            if (this.t != null) {
                this.t.b();
            }
        }

        void a(t tVar) {
            if (this.t == tVar) {
                this.t = null;
            }
        }

        public void c(p pVar) {
            for (int iW = w() - 1; iW >= 0; iW--) {
                if (!RecyclerView.e(i(iW)).e()) {
                    a(iW, pVar);
                }
            }
        }

        void a(androidx.core.g.a.c cVar) {
            a(this.q.e, this.q.D, cVar);
        }

        public void a(p pVar, u uVar, androidx.core.g.a.c cVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.c(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.c(true);
            }
            cVar.a(c.a.a(a(pVar, uVar), b(pVar, uVar), e(pVar, uVar), d(pVar, uVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.e, this.q.D, accessibilityEvent);
        }

        public void a(p pVar, u uVar, AccessibilityEvent accessibilityEvent) {
            if (this.q == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!this.q.canScrollVertically(1) && !this.q.canScrollVertically(-1) && !this.q.canScrollHorizontally(-1) && !this.q.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.q.m != null) {
                accessibilityEvent.setItemCount(this.q.m.b());
            }
        }

        void a(View view, androidx.core.g.a.c cVar) {
            x xVarE = RecyclerView.e(view);
            if (xVarE == null || xVarE.s() || this.p.c(xVarE.f1052a)) {
                return;
            }
            a(this.q.e, this.q.D, view, cVar);
        }

        public void a(p pVar, u uVar, View view, androidx.core.g.a.c cVar) {
            cVar.b(c.b.a(f() ? d(view) : 0, 1, e() ? d(view) : 0, 1, false, false));
        }

        public void J() {
            this.u = true;
        }

        public int a(p pVar, u uVar) {
            if (this.q == null || this.q.m == null || !f()) {
                return 1;
            }
            return this.q.m.b();
        }

        public int b(p pVar, u uVar) {
            if (this.q == null || this.q.m == null || !e()) {
                return 1;
            }
            return this.q.m.b();
        }

        boolean a(int i, Bundle bundle) {
            return a(this.q.e, this.q.D, i, bundle);
        }

        public boolean a(p pVar, u uVar, int i, Bundle bundle) {
            int iA;
            int iZ;
            if (this.q == null) {
                return false;
            }
            if (i != 4096) {
                if (i != 8192) {
                    iA = 0;
                } else {
                    iA = this.q.canScrollVertically(-1) ? -((A() - C()) - E()) : 0;
                    if (this.q.canScrollHorizontally(-1)) {
                        iZ = -((z() - B()) - D());
                    }
                }
            } else {
                iA = this.q.canScrollVertically(1) ? (A() - C()) - E() : 0;
                iZ = this.q.canScrollHorizontally(1) ? (z() - B()) - D() : 0;
            }
            if (iA == 0 && iZ == 0) {
                return false;
            }
            this.q.a(iZ, iA);
            return true;
        }

        boolean a(View view, int i, Bundle bundle) {
            return a(this.q.e, this.q.D, view, i, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i, i2);
            bVar.f1034a = typedArrayObtainStyledAttributes.getInt(a.b.RecyclerView_android_orientation, 1);
            bVar.f1035b = typedArrayObtainStyledAttributes.getInt(a.b.RecyclerView_spanCount, 1);
            bVar.c = typedArrayObtainStyledAttributes.getBoolean(a.b.RecyclerView_reverseLayout, false);
            bVar.d = typedArrayObtainStyledAttributes.getBoolean(a.b.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        void f(RecyclerView recyclerView) {
            c(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean K() {
            int iW = w();
            for (int i = 0; i < iW; i++) {
                ViewGroup.LayoutParams layoutParams = i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, u uVar) {
            a(canvas, recyclerView);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, u uVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, u uVar) {
            a(rect, ((j) view.getLayoutParams()).f(), recyclerView);
        }
    }

    public static abstract class x {
        private static final List<Object> q = Collections.emptyList();

        /* renamed from: a, reason: collision with root package name */
        public final View f1052a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f1053b;
        int j;
        RecyclerView p;
        int c = -1;
        int d = -1;
        long e = -1;
        int f = -1;
        int g = -1;
        x h = null;
        x i = null;
        List<Object> k = null;
        List<Object> l = null;
        private int r = 0;
        p m = null;
        boolean n = false;
        private int s = 0;
        int o = -1;

        public x(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1052a = view;
        }

        void a(int i, int i2, boolean z) {
            c(8);
            a(i2, z);
            this.c = i;
        }

        void a(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i;
            }
            this.c += i;
            if (this.f1052a.getLayoutParams() != null) {
                ((j) this.f1052a.getLayoutParams()).e = true;
            }
        }

        void c() {
            this.d = -1;
            this.g = -1;
        }

        void d() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        boolean e() {
            return (this.j & 128) != 0;
        }

        public final int f() {
            return this.g == -1 ? this.c : this.g;
        }

        public final int g() {
            if (this.p == null) {
                return -1;
            }
            return this.p.d(this);
        }

        public final int h() {
            return this.d;
        }

        public final long i() {
            return this.e;
        }

        public final int j() {
            return this.f;
        }

        boolean k() {
            return this.m != null;
        }

        void l() {
            this.m.c(this);
        }

        boolean m() {
            return (this.j & 32) != 0;
        }

        void n() {
            this.j &= -33;
        }

        void o() {
            this.j &= -257;
        }

        void a(p pVar, boolean z) {
            this.m = pVar;
            this.n = z;
        }

        boolean p() {
            return (this.j & 4) != 0;
        }

        boolean q() {
            return (this.j & 2) != 0;
        }

        boolean r() {
            return (this.j & 1) != 0;
        }

        boolean s() {
            return (this.j & 8) != 0;
        }

        boolean b(int i) {
            return (i & this.j) != 0;
        }

        boolean t() {
            return (this.j & 256) != 0;
        }

        boolean u() {
            return (this.j & 512) != 0 || p();
        }

        void a(int i, int i2) {
            this.j = (i & i2) | (this.j & (i2 ^ (-1)));
        }

        void c(int i) {
            this.j = i | this.j;
        }

        void a(Object obj) {
            if (obj == null) {
                c(1024);
            } else if ((1024 & this.j) == 0) {
                a();
                this.k.add(obj);
            }
        }

        private void a() {
            if (this.k == null) {
                this.k = new ArrayList();
                this.l = Collections.unmodifiableList(this.k);
            }
        }

        void v() {
            if (this.k != null) {
                this.k.clear();
            }
            this.j &= -1025;
        }

        List<Object> w() {
            if ((this.j & 1024) == 0) {
                if (this.k == null || this.k.size() == 0) {
                    return q;
                }
                return this.l;
            }
            return q;
        }

        void x() {
            this.j = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.r = 0;
            this.h = null;
            this.i = null;
            v();
            this.s = 0;
            this.o = -1;
            RecyclerView.c(this);
        }

        void a(RecyclerView recyclerView) {
            if (this.o != -1) {
                this.s = this.o;
            } else {
                this.s = androidx.core.g.q.e(this.f1052a);
            }
            recyclerView.a(this, 4);
        }

        void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.s);
            this.s = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (k()) {
                sb.append(" scrap ");
                sb.append(this.n ? "[changeScrap]" : "[attachedScrap]");
            }
            if (p()) {
                sb.append(" invalid");
            }
            if (!r()) {
                sb.append(" unbound");
            }
            if (q()) {
                sb.append(" update");
            }
            if (s()) {
                sb.append(" removed");
            }
            if (e()) {
                sb.append(" ignored");
            }
            if (t()) {
                sb.append(" tmpDetached");
            }
            if (!y()) {
                sb.append(" not recyclable(" + this.r + ")");
            }
            if (u()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1052a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void c(boolean z) {
            this.r = z ? this.r - 1 : this.r + 1;
            if (this.r < 0) {
                this.r = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && this.r == 1) {
                this.j |= 16;
            } else if (z && this.r == 0) {
                this.j &= -17;
            }
        }

        public final boolean y() {
            return (this.j & 16) == 0 && !androidx.core.g.q.c(this.f1052a);
        }

        boolean z() {
            return (this.j & 16) != 0;
        }

        boolean A() {
            return (this.j & 16) == 0 && androidx.core.g.q.c(this.f1052a);
        }

        boolean B() {
            return (this.j & 2) != 0;
        }
    }

    boolean a(x xVar, int i2) {
        if (o()) {
            xVar.o = i2;
            this.K.add(xVar);
            return false;
        }
        androidx.core.g.q.b(xVar.f1052a, i2);
        return true;
    }

    void y() {
        int i2;
        for (int size = this.K.size() - 1; size >= 0; size--) {
            x xVar = this.K.get(size);
            if (xVar.f1052a.getParent() == this && !xVar.e() && (i2 = xVar.o) != -1) {
                androidx.core.g.q.b(xVar.f1052a, i2);
                xVar.o = -1;
            }
        }
        this.K.clear();
    }

    int d(x xVar) {
        if (xVar.b(524) || !xVar.r()) {
            return -1;
        }
        return this.f.c(xVar.c);
    }

    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + a());
        }
        Resources resources = getContext().getResources();
        new androidx.recyclerview.widget.g(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.C0054a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.C0054a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.C0054a.fastscroll_margin));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    @Override // android.view.View, androidx.core.g.i
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    @Override // android.view.View, androidx.core.g.i
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    @Override // androidx.core.g.j
    public void a(int i2) {
        getScrollingChildHelper().c(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean i(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public static class j extends ViewGroup.MarginLayoutParams {
        x c;
        final Rect d;
        boolean e;
        boolean f;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(int i, int i2) {
            super(i, i2);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(j jVar) {
            super((ViewGroup.LayoutParams) jVar);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public boolean c() {
            return this.c.p();
        }

        public boolean d() {
            return this.c.s();
        }

        public boolean e() {
            return this.c.B();
        }

        public int f() {
            return this.c.f();
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void a(int i, int i2, int i3) {
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2) {
        }

        public void a(int i, int i2, Object obj) {
            a(i, i2);
        }
    }

    public static abstract class t {

        /* renamed from: a, reason: collision with root package name */
        private int f1044a;

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f1045b;
        private i c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g;

        public interface b {
            PointF d(int i);
        }

        protected abstract void a(int i, int i2, u uVar, a aVar);

        protected abstract void a(View view, u uVar, a aVar);

        protected abstract void f();

        public void a(int i) {
            this.f1044a = i;
        }

        public PointF b(int i) {
            Object objA = a();
            if (objA instanceof b) {
                return ((b) objA).d(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public i a() {
            return this.c;
        }

        protected final void b() {
            if (this.e) {
                this.e = false;
                f();
                this.f1045b.D.f1048a = -1;
                this.f = null;
                this.f1044a = -1;
                this.d = false;
                this.c.a(this);
                this.c = null;
                this.f1045b = null;
            }
        }

        public boolean c() {
            return this.d;
        }

        public boolean d() {
            return this.e;
        }

        public int e() {
            return this.f1044a;
        }

        void a(int i, int i2) {
            PointF pointFB;
            RecyclerView recyclerView = this.f1045b;
            if (!this.e || this.f1044a == -1 || recyclerView == null) {
                b();
            }
            if (this.d && this.f == null && this.c != null && (pointFB = b(this.f1044a)) != null && (pointFB.x != 0.0f || pointFB.y != 0.0f)) {
                recyclerView.a((int) Math.signum(pointFB.x), (int) Math.signum(pointFB.y), (int[]) null);
            }
            this.d = false;
            if (this.f != null) {
                if (a(this.f) == this.f1044a) {
                    a(this.f, recyclerView.D, this.g);
                    this.g.a(recyclerView);
                    b();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, recyclerView.D, this.g);
                boolean zA = this.g.a();
                this.g.a(recyclerView);
                if (zA) {
                    if (this.e) {
                        this.d = true;
                        recyclerView.A.a();
                    } else {
                        b();
                    }
                }
            }
        }

        public int a(View view) {
            return this.f1045b.g(view);
        }

        protected void b(View view) {
            if (a(view) == e()) {
                this.f = view;
            }
        }

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f1046a;

            /* renamed from: b, reason: collision with root package name */
            private int f1047b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            boolean a() {
                return this.d >= 0;
            }

            void a(RecyclerView recyclerView) {
                if (this.d >= 0) {
                    int i = this.d;
                    this.d = -1;
                    recyclerView.c(i);
                    this.f = false;
                    return;
                }
                if (this.f) {
                    b();
                    if (this.e == null) {
                        if (this.c == Integer.MIN_VALUE) {
                            recyclerView.A.b(this.f1046a, this.f1047b);
                        } else {
                            recyclerView.A.a(this.f1046a, this.f1047b, this.c);
                        }
                    } else {
                        recyclerView.A.a(this.f1046a, this.f1047b, this.c, this.e);
                    }
                    this.g++;
                    if (this.g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                    return;
                }
                this.g = 0;
            }

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }

        public void a(int i, int i2) {
            a(i, i2, null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, obj);
            }
        }

        public void b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).b(i, i2);
            }
        }

        public void c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i, i2);
            }
        }

        public void d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, 1);
            }
        }
    }

    public static class s extends androidx.d.a.a {
        public static final Parcelable.Creator<s> CREATOR = new Parcelable.ClassLoaderCreator<s>() { // from class: androidx.recyclerview.widget.RecyclerView.s.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public s createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new s(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public s createFromParcel(Parcel parcel) {
                return new s(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public s[] newArray(int i) {
                return new s[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        Parcelable f1043a;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1043a = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.d.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1043a, 0);
        }

        void a(s sVar) {
            this.f1043a = sVar.f1043a;
        }
    }

    public static class u {

        /* renamed from: a, reason: collision with root package name */
        int f1048a = -1;

        /* renamed from: b, reason: collision with root package name */
        int f1049b = 0;
        int c = 0;
        int d = 1;
        int e = 0;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        void a(int i) {
            if ((this.d & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.d));
        }

        void a(a aVar) {
            this.d = 1;
            this.e = aVar.b();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.f1048a;
        }

        public boolean d() {
            return this.f1048a != -1;
        }

        public int e() {
            return this.g ? this.f1049b - this.c : this.e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1048a + ", mData=" + this.q + ", mItemCount=" + this.e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f1049b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    private class g implements f.b {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f.b
        public void a(x xVar) {
            xVar.c(true);
            if (xVar.h != null && xVar.i == null) {
                xVar.h = null;
            }
            xVar.i = null;
            if (xVar.z() || RecyclerView.this.a(xVar.f1052a) || !xVar.t()) {
                return;
            }
            RecyclerView.this.removeDetachedView(xVar.f1052a, false);
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        private b f1025a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<a> f1026b = new ArrayList<>();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(x xVar);
        }

        public abstract void a();

        public abstract boolean a(x xVar, c cVar, c cVar2);

        public abstract boolean a(x xVar, x xVar2, c cVar, c cVar2);

        public abstract boolean b();

        public abstract boolean b(x xVar, c cVar, c cVar2);

        public abstract boolean c(x xVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(x xVar);

        public void g(x xVar) {
        }

        public boolean h(x xVar) {
            return true;
        }

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public long g() {
            return this.d;
        }

        public long h() {
            return this.f;
        }

        void a(b bVar) {
            this.f1025a = bVar;
        }

        public c a(u uVar, x xVar, int i, List<Object> list) {
            return j().a(xVar);
        }

        public c a(u uVar, x xVar) {
            return j().a(xVar);
        }

        static int e(x xVar) {
            int i = xVar.j & 14;
            if (xVar.p()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iH = xVar.h();
            int iG = xVar.g();
            return (iH == -1 || iG == -1 || iH == iG) ? i : i | 2048;
        }

        public final void f(x xVar) {
            g(xVar);
            if (this.f1025a != null) {
                this.f1025a.a(xVar);
            }
        }

        public boolean a(x xVar, List<Object> list) {
            return h(xVar);
        }

        public final void i() {
            int size = this.f1026b.size();
            for (int i = 0; i < size; i++) {
                this.f1026b.get(i).a();
            }
            this.f1026b.clear();
        }

        public c j() {
            return new c();
        }

        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f1027a;

            /* renamed from: b, reason: collision with root package name */
            public int f1028b;
            public int c;
            public int d;

            public c a(x xVar) {
                return a(xVar, 0);
            }

            public c a(x xVar, int i) {
                View view = xVar.f1052a;
                this.f1027a = view.getLeft();
                this.f1028b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.aC == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return this.aC.a(i2, i3);
    }

    private androidx.core.g.k getScrollingChildHelper() {
        if (this.aE == null) {
            this.aE = new androidx.core.g.k(this);
        }
        return this.aE;
    }
}
