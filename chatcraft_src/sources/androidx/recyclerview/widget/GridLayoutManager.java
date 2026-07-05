package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.a.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    boolean f1000a;

    /* renamed from: b, reason: collision with root package name */
    int f1001b;
    int[] c;
    View[] d;
    final SparseIntArray e;
    final SparseIntArray f;
    c g;
    final Rect h;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1000a = false;
        this.f1001b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(a(context, attributeSet, i, i2).f1035b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f1000a = false;
        this.f1001b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.i == 0) {
            return this.f1001b;
        }
        if (uVar.e() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.i == 1) {
            return this.f1001b;
        }
        if (uVar.e() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.p pVar, RecyclerView.u uVar, View view, androidx.core.g.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iA = a(pVar, uVar, bVar.f());
        if (this.i == 0) {
            cVar.b(c.b.a(bVar.a(), bVar.b(), iA, 1, this.f1001b > 1 && bVar.b() == this.f1001b, false));
        } else {
            cVar.b(c.b.a(iA, 1, bVar.a(), bVar.b(), this.f1001b > 1 && bVar.b() == this.f1001b, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (uVar.a()) {
            M();
        }
        super.c(pVar, uVar);
        L();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.u uVar) {
        super.a(uVar);
        this.f1000a = false;
    }

    private void L() {
        this.e.clear();
        this.f.clear();
    }

    private void M() {
        int iW = w();
        for (int i = 0; i < iW; i++) {
            b bVar = (b) i(i).getLayoutParams();
            int iF = bVar.f();
            this.e.put(iF, bVar.b());
            this.f.put(iF, bVar.a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        if (this.i == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    private void N() {
        int iA;
        if (g() == 1) {
            iA = (z() - D()) - B();
        } else {
            iA = (A() - E()) - C();
        }
        m(iA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int iB = B() + D();
        int iC = C() + E();
        if (this.i == 1) {
            iA2 = a(i2, rect.height() + iC, H());
            iA = a(i, this.c[this.c.length - 1] + iB, G());
        } else {
            iA = a(i, rect.width() + iB, G());
            iA2 = a(i2, this.c[this.c.length - 1] + iC, H());
        }
        f(iA, iA2);
    }

    private void m(int i) {
        this.c = a(this.c, this.f1001b, i);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    int a(int i, int i2) {
        if (this.i == 1 && h()) {
            return this.c[this.f1001b - i] - this.c[(this.f1001b - i) - i2];
        }
        return this.c[i2 + i] - this.c[i];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.a aVar, int i) {
        super.a(pVar, uVar, aVar, i);
        N();
        if (uVar.e() > 0 && !uVar.a()) {
            b(pVar, uVar, aVar, i);
        }
        O();
    }

    private void O() {
        if (this.d == null || this.d.length != this.f1001b) {
            this.d = new View[this.f1001b];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        N();
        O();
        return super.a(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        N();
        O();
        return super.b(i, pVar, uVar);
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iB = b(pVar, uVar, aVar.f1009b);
        if (z) {
            while (iB > 0 && aVar.f1009b > 0) {
                aVar.f1009b--;
                iB = b(pVar, uVar, aVar.f1009b);
            }
            return;
        }
        int iE = uVar.e() - 1;
        int i2 = aVar.f1009b;
        while (i2 < iE) {
            int i3 = i2 + 1;
            int iB2 = b(pVar, uVar, i3);
            if (iB2 <= iB) {
                break;
            }
            i2 = i3;
            iB = iB2;
        }
        aVar.f1009b = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View a(RecyclerView.p pVar, RecyclerView.u uVar, int i, int i2, int i3) {
        i();
        int iC = this.j.c();
        int iD = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewI = i(i);
            int iD2 = d(viewI);
            if (iD2 >= 0 && iD2 < i3 && b(pVar, uVar, iD2) == 0) {
                if (((RecyclerView.j) viewI.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.j.a(viewI) < iD && this.j.b(viewI) >= iC) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int a(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.a()) {
            return this.g.c(i, this.f1001b);
        }
        int iB = pVar.b(i);
        if (iB == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.g.c(iB, this.f1001b);
    }

    private int b(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.a()) {
            return this.g.b(i, this.f1001b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = pVar.b(i);
        if (iB == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.g.b(iB, this.f1001b);
    }

    private int c(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.a()) {
            return this.g.a(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = pVar.b(i);
        if (iB == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.g.a(iB);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.u uVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int iA = this.f1001b;
        for (int i = 0; i < this.f1001b && cVar.a(uVar) && iA > 0; i++) {
            int i2 = cVar.d;
            aVar.b(i2, Math.max(0, cVar.g));
            iA -= this.g.a(i2);
            cVar.d += cVar.e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0223  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(androidx.recyclerview.widget.RecyclerView.p r19, androidx.recyclerview.widget.RecyclerView.u r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    private void a(View view, int i, boolean z) {
        int iA;
        int iA2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.d;
        int i2 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i3 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int iA3 = a(bVar.f1002a, bVar.f1003b);
        if (this.i == 1) {
            iA2 = a(iA3, i, i3, bVar.width, false);
            iA = a(this.j.f(), y(), i2, bVar.height, true);
        } else {
            int iA4 = a(iA3, i, i2, bVar.height, false);
            int iA5 = a(this.j.f(), x(), i3, bVar.width, true);
            iA = iA4;
            iA2 = iA5;
        }
        a(view, iA2, iA, z);
    }

    private void a(float f, int i) {
        m(Math.max(Math.round(f * this.f1001b), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean zB;
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        if (z) {
            zB = a(view, i, i2, jVar);
        } else {
            zB = b(view, i, i2, jVar);
        }
        if (zB) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.p pVar, RecyclerView.u uVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = 0;
        if (z) {
            i5 = i;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = i - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View view = this.d[i3];
            b bVar = (b) view.getLayoutParams();
            bVar.f1003b = c(pVar, uVar, d(view));
            bVar.f1002a = i6;
            i6 += bVar.f1003b;
            i3 += i4;
        }
    }

    public void a(int i) {
        if (i == this.f1001b) {
            return;
        }
        this.f1000a = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.f1001b = i;
        this.g.a();
        p();
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final SparseIntArray f1004a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        private boolean f1005b = false;

        public abstract int a(int i);

        public void a() {
            this.f1004a.clear();
        }

        int b(int i, int i2) {
            if (!this.f1005b) {
                return a(i, i2);
            }
            int i3 = this.f1004a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iA = a(i, i2);
            this.f1004a.put(i, iA);
            return iA;
        }

        public int a(int i, int i2) {
            int i3;
            int iA;
            int iB;
            int iA2 = a(i);
            if (iA2 == i2) {
                return 0;
            }
            if (!this.f1005b || this.f1004a.size() <= 0 || (iB = b(i)) < 0) {
                i3 = 0;
                iA = 0;
            } else {
                iA = this.f1004a.get(iB) + a(iB);
                i3 = iB + 1;
            }
            while (i3 < i) {
                int iA3 = a(i3);
                iA += iA3;
                if (iA == i2) {
                    iA = 0;
                } else if (iA > i2) {
                    iA = iA3;
                }
                i3++;
            }
            if (iA2 + iA <= i2) {
                return iA;
            }
            return 0;
        }

        int b(int i) {
            int size = this.f1004a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1004a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f1004a.size()) {
                return -1;
            }
            return this.f1004a.keyAt(i4);
        }

        public int c(int i, int i2) {
            int iA = a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int iA2 = a(i5);
                i3 += iA2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = iA2;
                }
            }
            return i3 + iA > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d8, code lost:
    
        if (r13 == (r2 > r8)) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View a(android.view.View r26, int r27, androidx.recyclerview.widget.RecyclerView.p r28, androidx.recyclerview.widget.RecyclerView.u r29) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.n == null && !this.f1000a;
    }

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int a(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends RecyclerView.j {

        /* renamed from: a, reason: collision with root package name */
        int f1002a;

        /* renamed from: b, reason: collision with root package name */
        int f1003b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1002a = -1;
            this.f1003b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f1002a = -1;
            this.f1003b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1002a = -1;
            this.f1003b = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1002a = -1;
            this.f1003b = 0;
        }

        public int a() {
            return this.f1002a;
        }

        public int b() {
            return this.f1003b;
        }
    }
}
