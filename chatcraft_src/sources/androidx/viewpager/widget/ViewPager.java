package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.g.o;
import androidx.core.g.q;
import androidx.core.g.y;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private List<f> aa;
    private f ab;
    private f ac;
    private List<e> ad;
    private g ae;
    private int af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj;
    private int ak;

    /* renamed from: b, reason: collision with root package name */
    androidx.viewpager.widget.a f1142b;
    int c;
    private int d;
    private final ArrayList<b> g;
    private final b h;
    private final Rect i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private boolean n;
    private h o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t;
    private float u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* renamed from: a, reason: collision with root package name */
    static final int[] f1141a = {R.attr.layout_gravity};
    private static final Comparator<b> e = new Comparator<b>() { // from class: androidx.viewpager.widget.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f1147b - bVar2.f1147b;
        }
    };
    private static final Interpolator f = new Interpolator() { // from class: androidx.viewpager.widget.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final j ai = new j();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    public interface e {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface f {
        void a(int i);

        void a(int i, float f, int i2);

        void b(int i);
    }

    public interface g {
        void a(View view, float f);
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        Object f1146a;

        /* renamed from: b, reason: collision with root package name */
        int f1147b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.g = new ArrayList<>();
        this.h = new b();
        this.i = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.T = true;
        this.U = false;
        this.aj = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                ViewPager.this.setScrollState(0);
                ViewPager.this.c();
            }
        };
        this.ak = 0;
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ArrayList<>();
        this.h = new b();
        this.i = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.T = true;
        this.U = false;
        this.aj = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                ViewPager.this.setScrollState(0);
                ViewPager.this.c();
            }
        };
        this.ak = 0;
        a();
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F = viewConfiguration.getScaledPagingTouchSlop();
        this.M = (int) (400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context);
        this.S = new EdgeEffect(context);
        this.O = (int) (25.0f * f2);
        this.P = (int) (2.0f * f2);
        this.D = (int) (f2 * 16.0f);
        q.a(this, new d());
        if (q.e(this) == 0) {
            q.b(this, 1);
        }
        q.a(this, new o() { // from class: androidx.viewpager.widget.ViewPager.4

            /* renamed from: b, reason: collision with root package name */
            private final Rect f1145b = new Rect();

            @Override // androidx.core.g.o
            public y a(View view, y yVar) {
                y yVarA = q.a(view, yVar);
                if (yVarA.e()) {
                    return yVarA;
                }
                Rect rect = this.f1145b;
                rect.left = yVarA.a();
                rect.top = yVarA.b();
                rect.right = yVarA.c();
                rect.bottom = yVarA.d();
                int childCount = ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    y yVarB = q.b(ViewPager.this.getChildAt(i2), yVarA);
                    rect.left = Math.min(yVarB.a(), rect.left);
                    rect.top = Math.min(yVarB.b(), rect.top);
                    rect.right = Math.min(yVarB.c(), rect.right);
                    rect.bottom = Math.min(yVarB.d(), rect.bottom);
                }
                return yVarA.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (this.m != null && !this.m.isFinished()) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i2) {
        if (this.ak == i2) {
            return;
        }
        this.ak = i2;
        if (this.ae != null) {
            b(i2 != 0);
        }
        f(i2);
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) throws Resources.NotFoundException {
        if (this.f1142b != null) {
            this.f1142b.b((DataSetObserver) null);
            this.f1142b.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                b bVar = this.g.get(i2);
                this.f1142b.a((ViewGroup) this, bVar.f1147b, bVar.f1146a);
            }
            this.f1142b.b((ViewGroup) this);
            this.g.clear();
            f();
            this.c = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar2 = this.f1142b;
        this.f1142b = aVar;
        this.d = 0;
        if (this.f1142b != null) {
            if (this.o == null) {
                this.o = new h();
            }
            this.f1142b.b(this.o);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.d = this.f1142b.b();
            if (this.j >= 0) {
                this.f1142b.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!z) {
                c();
            } else {
                requestLayout();
            }
        }
        if (this.ad == null || this.ad.isEmpty()) {
            return;
        }
        int size = this.ad.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.ad.get(i3).a(this, aVar2, aVar);
        }
    }

    private void f() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f1148a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f1142b;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i2) throws Resources.NotFoundException {
        this.z = false;
        a(i2, !this.T, false);
    }

    public void a(int i2, boolean z) throws Resources.NotFoundException {
        this.z = false;
        a(i2, z, false);
    }

    public int getCurrentItem() {
        return this.c;
    }

    void a(int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        a(i2, z, z2, 0);
    }

    void a(int i2, boolean z, boolean z2, int i3) throws Resources.NotFoundException {
        if (this.f1142b == null || this.f1142b.b() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.c == i2 && this.g.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f1142b.b()) {
            i2 = this.f1142b.b() - 1;
        }
        int i4 = this.A;
        if (i2 > this.c + i4 || i2 < this.c - i4) {
            for (int i5 = 0; i5 < this.g.size(); i5++) {
                this.g.get(i5).c = true;
            }
        }
        boolean z3 = this.c != i2;
        if (this.T) {
            this.c = i2;
            if (z3) {
                e(i2);
            }
            requestLayout();
            return;
        }
        a(i2);
        a(i2, z, i3, z3);
    }

    private void a(int i2, boolean z, int i3, boolean z2) throws Resources.NotFoundException {
        b bVarB = b(i2);
        int clientWidth = bVarB != null ? (int) (getClientWidth() * Math.max(this.t, Math.min(bVarB.e, this.u))) : 0;
        if (z) {
            a(clientWidth, 0, i3);
            if (z2) {
                e(i2);
                return;
            }
            return;
        }
        if (z2) {
            e(i2);
        }
        a(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.ab = fVar;
    }

    public void a(f fVar) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(fVar);
    }

    public void b(f fVar) {
        if (this.aa != null) {
            this.aa.remove(fVar);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.ag == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ah.get(i3).getLayoutParams()).f;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public void setOffscreenPageLimit(int i2) throws Resources.NotFoundException {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.A) {
            this.A = i2;
            c();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.p;
        this.p = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.a.a.a(getContext(), i2));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    void a(int i2, int i3, int i4) throws Resources.NotFoundException {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if ((this.m == null || this.m.isFinished()) ? false : true) {
            scrollX = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fA = f3 + (a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs2 = Math.abs(i4);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fA / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i6) / ((f2 * this.f1142b.b(this.c)) + this.p)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.n = false;
        this.m.startScroll(i5, scrollY, i6, i7, iMin);
        q.d(this);
    }

    b a(int i2, int i3) {
        b bVar = new b();
        bVar.f1147b = i2;
        bVar.f1146a = this.f1142b.a((ViewGroup) this, i2);
        bVar.d = this.f1142b.b(i2);
        if (i3 < 0 || i3 >= this.g.size()) {
            this.g.add(bVar);
        } else {
            this.g.add(i3, bVar);
        }
        return bVar;
    }

    void b() throws Resources.NotFoundException {
        int iB = this.f1142b.b();
        this.d = iB;
        boolean z = this.g.size() < (this.A * 2) + 1 && this.g.size() < iB;
        int iMax = this.c;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.g.size()) {
            b bVar = this.g.get(i2);
            int iA = this.f1142b.a(bVar.f1146a);
            if (iA != -1) {
                if (iA == -2) {
                    this.g.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f1142b.a((ViewGroup) this);
                        z2 = true;
                    }
                    this.f1142b.a((ViewGroup) this, bVar.f1147b, bVar.f1146a);
                    if (this.c == bVar.f1147b) {
                        iMax = Math.max(0, Math.min(this.c, iB - 1));
                    }
                } else if (bVar.f1147b != iA) {
                    if (bVar.f1147b == this.c) {
                        iMax = iA;
                    }
                    bVar.f1147b = iA;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f1142b.b((ViewGroup) this);
        }
        Collections.sort(this.g, e);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                c cVar = (c) getChildAt(i3).getLayoutParams();
                if (!cVar.f1148a) {
                    cVar.c = 0.0f;
                }
            }
            a(iMax, false, true);
            requestLayout();
        }
    }

    void c() throws Resources.NotFoundException {
        a(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ff A[PHI: r7 r10 r15
      0x00ff: PHI (r7v14 float) = (r7v12 float), (r7v13 float), (r7v5 float) binds: [B:63:0x00f4, B:60:0x00de, B:54:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r10v7 int) = (r10v1 int), (r10v6 int), (r10v10 int) binds: [B:63:0x00f4, B:60:0x00de, B:54:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r15v6 int) = (r15v5 int), (r15v4 int), (r15v9 int) binds: [B:63:0x00f4, B:60:0x00de, B:54:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int):void");
    }

    private void g() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList<>();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ah.add(getChildAt(i2));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int iB = this.f1142b.b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.p / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.f1147b;
            if (i3 < bVar.f1147b) {
                float fB = bVar2.e + bVar2.d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f1147b && i5 < this.g.size()) {
                    b bVar5 = this.g.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 <= bVar4.f1147b || i5 >= this.g.size() - 1) {
                            break;
                        }
                        i5++;
                        bVar5 = this.g.get(i5);
                    }
                    while (i4 < bVar4.f1147b) {
                        fB += this.f1142b.b(i4) + f2;
                        i4++;
                    }
                    bVar4.e = fB;
                    fB += bVar4.d + f2;
                    i4++;
                }
            } else if (i3 > bVar.f1147b) {
                int size = this.g.size() - 1;
                float fB2 = bVar2.e;
                while (true) {
                    i3--;
                    if (i3 < bVar.f1147b || size < 0) {
                        break;
                    }
                    b bVar6 = this.g.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i3 >= bVar3.f1147b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.g.get(size);
                    }
                    while (i3 > bVar3.f1147b) {
                        fB2 -= this.f1142b.b(i3) + f2;
                        i3--;
                    }
                    fB2 -= bVar3.d + f2;
                    bVar3.e = fB2;
                }
            }
        }
        int size2 = this.g.size();
        float fB3 = bVar.e;
        int i6 = bVar.f1147b - 1;
        this.t = bVar.f1147b == 0 ? bVar.e : -3.4028235E38f;
        int i7 = iB - 1;
        this.u = bVar.f1147b == i7 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar7 = this.g.get(i8);
            while (i6 > bVar7.f1147b) {
                fB3 -= this.f1142b.b(i6) + f2;
                i6--;
            }
            fB3 -= bVar7.d + f2;
            bVar7.e = fB3;
            if (bVar7.f1147b == 0) {
                this.t = fB3;
            }
            i8--;
            i6--;
        }
        float fB4 = bVar.e + bVar.d + f2;
        int i9 = bVar.f1147b + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar8 = this.g.get(i10);
            while (i9 < bVar8.f1147b) {
                fB4 += this.f1142b.b(i9) + f2;
                i9++;
            }
            if (bVar8.f1147b == i7) {
                this.u = (bVar8.d + fB4) - 1.0f;
            }
            bVar8.e = fB4;
            fB4 += bVar8.d + f2;
            i10++;
            i9++;
        }
        this.U = false;
    }

    public static class i extends androidx.d.a.a {
        public static final Parcelable.Creator<i> CREATOR = new Parcelable.ClassLoaderCreator<i>() { // from class: androidx.viewpager.widget.ViewPager.i.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i) {
                return new i[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f1152a;

        /* renamed from: b, reason: collision with root package name */
        Parcelable f1153b;
        ClassLoader d;

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.d.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1152a);
            parcel.writeParcelable(this.f1153b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1152a + "}";
        }

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f1152a = parcel.readInt();
            this.f1153b = parcel.readParcelable(classLoader);
            this.d = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        iVar.f1152a = this.c;
        if (this.f1142b != null) {
            iVar.f1153b = this.f1142b.a();
        }
        return iVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        if (this.f1142b != null) {
            this.f1142b.a(iVar.f1153b, iVar.d);
            a(iVar.f1152a, false, true);
        } else {
            this.j = iVar.f1152a;
            this.k = iVar.f1153b;
            this.l = iVar.d;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f1148a |= c(view);
        if (this.x) {
            if (cVar != null && cVar.f1148a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.d = true;
            addViewInLayout(view, i2, layoutParams);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    b a(View view) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (this.f1142b.a(view, bVar.f1146a)) {
                return bVar;
            }
        }
        return null;
    }

    b b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return a(view);
            }
        }
    }

    b b(int i2) {
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            b bVar = this.g.get(i3);
            if (bVar.f1147b == i2) {
                return bVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r17, int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            a(i2, i4, this.p, this.p);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.g.isEmpty()) {
            if (!this.m.isFinished()) {
                this.m.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        b bVarB = b(this.c);
        int iMin = (int) ((bVarB != null ? Math.min(bVarB.e, this.u) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            a(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) throws Resources.NotFoundException {
        boolean z2;
        b bVarA;
        int iMax;
        int iMax2;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int measuredHeight = paddingBottom;
        int i8 = 0;
        int measuredHeight2 = paddingTop;
        int measuredWidth = paddingLeft;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1148a) {
                    int i10 = cVar.f1149b & 7;
                    int i11 = cVar.f1149b & 112;
                    if (i10 == 1) {
                        iMax = Math.max((i6 - childAt.getMeasuredWidth()) / 2, measuredWidth);
                    } else if (i10 == 3) {
                        iMax = measuredWidth;
                        measuredWidth = childAt.getMeasuredWidth() + measuredWidth;
                    } else if (i10 != 5) {
                        iMax = measuredWidth;
                    } else {
                        iMax = (i6 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i11 == 16) {
                        iMax2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, measuredHeight2);
                    } else if (i11 == 48) {
                        iMax2 = measuredHeight2;
                        measuredHeight2 = childAt.getMeasuredHeight() + measuredHeight2;
                    } else if (i11 != 80) {
                        iMax2 = measuredHeight2;
                    } else {
                        iMax2 = (i7 - measuredHeight) - childAt.getMeasuredHeight();
                        measuredHeight += childAt.getMeasuredHeight();
                    }
                    int i12 = iMax + scrollX;
                    childAt.layout(i12, iMax2, childAt.getMeasuredWidth() + i12, iMax2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i13 = (i6 - measuredWidth) - paddingRight;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f1148a && (bVarA = a(childAt2)) != null) {
                    float f2 = i13;
                    int i15 = ((int) (bVarA.e * f2)) + measuredWidth;
                    if (cVar2.d) {
                        cVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i7 - measuredHeight2) - measuredHeight, 1073741824));
                    }
                    childAt2.layout(i15, measuredHeight2, childAt2.getMeasuredWidth() + i15, childAt2.getMeasuredHeight() + measuredHeight2);
                }
            }
        }
        this.r = measuredHeight2;
        this.s = i7 - measuredHeight;
        this.W = i8;
        if (this.T) {
            z2 = false;
            a(this.c, false, 0, false);
        } else {
            z2 = false;
        }
        this.T = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.n = true;
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!d(currX)) {
                    this.m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            q.d(this);
            return;
        }
        a(true);
    }

    private boolean d(int i2) {
        if (this.g.size() == 0) {
            if (this.T) {
                return false;
            }
            this.V = false;
            a(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bVarI = i();
        int clientWidth = getClientWidth();
        int i3 = this.p + clientWidth;
        float f2 = clientWidth;
        int i4 = bVarI.f1147b;
        float f3 = ((i2 / f2) - bVarI.e) / (bVarI.d + (this.p / f2));
        this.V = false;
        a(i4, f3, (int) (i3 * f3));
        if (this.V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.W
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r9 = (androidx.viewpager.widget.ViewPager.c) r9
            boolean r10 = r9.f1148a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f1149b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$g r13 = r12.ae
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r0 = (androidx.viewpager.widget.ViewPager.c) r0
            boolean r0 = r0.f1148a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$g r3 = r12.ae
            r3.a(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.V = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int, float, int):void");
    }

    private void b(int i2, float f2, int i3) {
        if (this.ab != null) {
            this.ab.a(i2, f2, i3);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = this.aa.get(i4);
                if (fVar != null) {
                    fVar.a(i2, f2, i3);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i2, f2, i3);
        }
    }

    private void e(int i2) {
        if (this.ab != null) {
            this.ab.a(i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.aa.get(i3);
                if (fVar != null) {
                    fVar.a(i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i2);
        }
    }

    private void f(int i2) {
        if (this.ab != null) {
            this.ab.b(i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.aa.get(i3);
                if (fVar != null) {
                    fVar.b(i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.b(i2);
        }
    }

    private void a(boolean z) {
        boolean z2 = this.ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.c) {
                bVar.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                q.a(this, this.aj);
            } else {
                this.aj.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.E) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.E)) && f3 < 0.0f);
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.af : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            h();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.I = x;
            this.G = x;
            float y = motionEvent.getY();
            this.J = y;
            this.H = y;
            this.K = motionEvent.getPointerId(0);
            this.C = false;
            this.n = true;
            this.m.computeScrollOffset();
            if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                this.m.abortAnimation();
                this.z = false;
                c();
                this.B = true;
                c(true);
                setScrollState(1);
            } else {
                a(false);
                this.B = false;
            }
        } else if (action == 2) {
            int i2 = this.K;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.G;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.J);
                if (f2 != 0.0f && !a(this.G, f2) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.G = x2;
                    this.H = y2;
                    this.C = true;
                    return false;
                }
                if (fAbs > this.F && fAbs * 0.5f > fAbs2) {
                    this.B = true;
                    c(true);
                    setScrollState(1);
                    this.G = f2 > 0.0f ? this.I + this.F : this.I - this.F;
                    this.H = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > this.F) {
                    this.C = true;
                }
                if (this.B && b(x2)) {
                    q.d(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        return this.B;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean h() {
        this.K = -1;
        j();
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.G - f2;
        this.G = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.t * clientWidth;
        float f5 = this.u * clientWidth;
        boolean z3 = false;
        b bVar = this.g.get(0);
        b bVar2 = this.g.get(this.g.size() - 1);
        if (bVar.f1147b != 0) {
            f4 = bVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f1147b != this.f1142b.b() - 1) {
            f5 = bVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.R.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.S.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.G += scrollX - i2;
        scrollTo(i2, getScrollY());
        d(i2);
        return z3;
    }

    private b i() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.p / clientWidth : 0.0f;
        b bVar = null;
        int i3 = 0;
        boolean z = true;
        int i4 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.g.size()) {
            b bVar2 = this.g.get(i3);
            if (!z && bVar2.f1147b != (i2 = i4 + 1)) {
                bVar2 = this.h;
                bVar2.e = f3 + f4 + f2;
                bVar2.f1147b = i2;
                bVar2.d = this.f1142b.b(bVar2.f1147b);
                i3--;
            }
            f3 = bVar2.e;
            float f5 = bVar2.d + f3 + f2;
            if (!z && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i3 == this.g.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.f1147b;
            f4 = bVar2.d;
            i3++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.O || Math.abs(i3) <= this.M) {
            i2 += (int) (f2 + (i2 >= this.c ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.g.size() > 0) {
            return Math.max(this.g.get(0).f1147b, Math.min(i2, this.g.get(this.g.size() - 1).f1147b));
        }
        return i2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f1142b != null && this.f1142b.b() > 1)) {
            if (!this.R.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.t * width);
                this.R.setSize(height, width);
                zDraw = false | this.R.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.S.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.u + 1.0f)) * width2);
                this.S.setSize(height2, width2);
                zDraw |= this.S.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.R.finish();
            this.S.finish();
        }
        if (zDraw) {
            q.d(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.p <= 0 || this.q == null || this.g.size() <= 0 || this.f1142b == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f5 = this.p / width;
        int i2 = 0;
        b bVar = this.g.get(0);
        float f6 = bVar.e;
        int size = this.g.size();
        int i3 = bVar.f1147b;
        int i4 = this.g.get(size - 1).f1147b;
        while (i3 < i4) {
            while (i3 > bVar.f1147b && i2 < size) {
                i2++;
                bVar = this.g.get(i2);
            }
            if (i3 == bVar.f1147b) {
                f3 = (bVar.e + bVar.d) * width;
                f2 = bVar.e + bVar.d + f5;
            } else {
                float fB = this.f1142b.b(i3);
                float f7 = (f6 + fB) * width;
                f2 = f6 + fB + f5;
                f3 = f7;
            }
            if (this.p + f3 > scrollX) {
                f4 = f5;
                this.q.setBounds(Math.round(f3), this.r, Math.round(this.p + f3), this.s);
                this.q.draw(canvas);
            } else {
                f4 = f5;
            }
            if (f3 > scrollX + r2) {
                return;
            }
            i3++;
            f6 = f2;
            f5 = f4;
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.G = motionEvent.getX(i2);
            this.K = motionEvent.getPointerId(i2);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void j() {
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f1142b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.t)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.u));
    }

    protected boolean a(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasModifiers(2)) {
                            return d();
                        }
                        return c(17);
                    case 22:
                        if (keyEvent.hasModifiers(2)) {
                            return e();
                        }
                        return c(66);
                }
            }
            if (keyEvent.hasNoModifiers()) {
                return c(2);
            }
            if (keyEvent.hasModifiers(1)) {
                return c(1);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(int r8) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            android.view.View r0 = r7.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r7) goto La
            goto L69
        La:
            if (r0 == 0) goto L68
            android.view.ViewParent r4 = r0.getParent()
        L10:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1d
            if (r4 != r7) goto L18
            r4 = 1
            goto L1e
        L18:
            android.view.ViewParent r4 = r4.getParent()
            goto L10
        L1d:
            r4 = 0
        L1e:
            if (r4 != 0) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L34:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4d
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L34
        L4d:
            java.lang.String r0 = "ViewPager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "arrowScroll tried to find focus based on non-child current focused view "
            r5.append(r6)
            java.lang.String r4 = r4.toString()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.e(r0, r4)
            goto L69
        L68:
            r3 = r0
        L69:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r0 = r0.findNextFocus(r7, r3, r8)
            r4 = 66
            r5 = 17
            if (r0 == 0) goto Lba
            if (r0 == r3) goto Lba
            if (r8 != r5) goto L9a
            android.graphics.Rect r1 = r7.i
            android.graphics.Rect r1 = r7.a(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r7.i
            android.graphics.Rect r2 = r7.a(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto L94
            if (r1 < r2) goto L94
            boolean r0 = r7.d()
            goto L98
        L94:
            boolean r0 = r0.requestFocus()
        L98:
            r2 = r0
            goto Lcd
        L9a:
            if (r8 != r4) goto Lcd
            android.graphics.Rect r1 = r7.i
            android.graphics.Rect r1 = r7.a(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r7.i
            android.graphics.Rect r2 = r7.a(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto Lb5
            if (r1 > r2) goto Lb5
            boolean r0 = r7.e()
            goto L98
        Lb5:
            boolean r0 = r0.requestFocus()
            goto L98
        Lba:
            if (r8 == r5) goto Lc9
            if (r8 != r1) goto Lbf
            goto Lc9
        Lbf:
            if (r8 == r4) goto Lc4
            r0 = 2
            if (r8 != r0) goto Lcd
        Lc4:
            boolean r2 = r7.e()
            goto Lcd
        Lc9:
            boolean r2 = r7.d()
        Lcd:
            if (r2 == 0) goto Ld6
            int r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8)
            r7.playSoundEffect(r8)
        Ld6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c(int):boolean");
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean d() throws Resources.NotFoundException {
        if (this.c <= 0) {
            return false;
        }
        a(this.c - 1, true);
        return true;
    }

    boolean e() throws Resources.NotFoundException {
        if (this.f1142b == null || this.c >= this.f1142b.b() - 1) {
            return false;
        }
        a(this.c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b bVarA;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f1147b == this.c) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b bVarA;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f1147b == this.c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b bVarA;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f1147b == this.c && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b bVarA;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f1147b == this.c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    class d extends androidx.core.g.a {
        d() {
        }

        @Override // androidx.core.g.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() != 4096 || ViewPager.this.f1142b == null) {
                return;
            }
            accessibilityEvent.setItemCount(ViewPager.this.f1142b.b());
            accessibilityEvent.setFromIndex(ViewPager.this.c);
            accessibilityEvent.setToIndex(ViewPager.this.c);
        }

        @Override // androidx.core.g.a
        public void a(View view, androidx.core.g.a.c cVar) {
            super.a(view, cVar);
            cVar.a((CharSequence) ViewPager.class.getName());
            cVar.c(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        @Override // androidx.core.g.a
        public boolean a(View view, int i, Bundle bundle) throws Resources.NotFoundException {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager.this.setCurrentItem(ViewPager.this.c + 1);
                return true;
            }
            if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager.this.setCurrentItem(ViewPager.this.c - 1);
            return true;
        }

        private boolean b() {
            return ViewPager.this.f1142b != null && ViewPager.this.f1142b.b() > 1;
        }
    }

    private class h extends DataSetObserver {
        h() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.b();
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1148a;

        /* renamed from: b, reason: collision with root package name */
        public int f1149b;
        float c;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1141a);
            this.f1149b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class j implements Comparator<View> {
        j() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f1148a != cVar2.f1148a) {
                return cVar.f1148a ? 1 : -1;
            }
            return cVar.e - cVar2.e;
        }
    }
}
