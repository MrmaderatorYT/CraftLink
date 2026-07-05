package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.c;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.t.b {
    private d A;
    private int B;
    private int[] G;

    /* renamed from: a, reason: collision with root package name */
    e[] f1054a;

    /* renamed from: b, reason: collision with root package name */
    l f1055b;
    l c;
    private int j;
    private int k;
    private final i l;
    private BitSet m;
    private boolean o;
    private boolean z;
    private int i = -1;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    c h = new c();
    private int n = 2;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F = true;
    private final Runnable H = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b bVarA = a(context, attributeSet, i, i2);
        b(bVarA.f1034a);
        a(bVarA.f1035b);
        a(bVarA.c);
        this.l = new i();
        M();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean c() {
        return this.n != 0;
    }

    private void M() {
        this.f1055b = l.a(this, this.j);
        this.c = l.a(this, 1 - this.j);
    }

    boolean g() {
        int iL;
        int iO;
        if (w() == 0 || this.n == 0 || !r()) {
            return false;
        }
        if (this.e) {
            iL = o();
            iO = L();
        } else {
            iL = L();
            iO = o();
        }
        if (iL == 0 && h() != null) {
            this.h.a();
            J();
            p();
            return true;
        }
        if (!this.E) {
            return false;
        }
        int i = this.e ? -1 : 1;
        int i2 = iO + 1;
        c.a aVarA = this.h.a(iL, i2, i, true);
        if (aVarA == null) {
            this.E = false;
            this.h.a(i2);
            return false;
        }
        c.a aVarA2 = this.h.a(iL, aVarA.f1063a, i * (-1), true);
        if (aVarA2 == null) {
            this.h.a(aVarA.f1063a);
        } else {
            this.h.a(aVarA2.f1063a + 1);
        }
        J();
        p();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void l(int i) {
        if (i == 0) {
            g();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.a(recyclerView, pVar);
        a(this.H);
        for (int i = 0; i < this.i; i++) {
            this.f1054a[i].e();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View h() {
        /*
            r12 = this;
            int r0 = r12.w()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.i
            r2.<init>(r3)
            int r3 = r12.i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.j
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.j()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.e
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.i(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f1059a
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f1059a
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f1059a
            int r9 = r9.e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f1060b
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.i(r9)
            boolean r10 = r12.e
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.l r10 = r12.f1055b
            int r10 = r10.b(r7)
            androidx.recyclerview.widget.l r11 = r12.f1055b
            int r11 = r11.b(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.l r10 = r12.f1055b
            int r10 = r10.a(r7)
            androidx.recyclerview.widget.l r11 = r12.f1055b
            int r11 = r11.a(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r8 = r8.f1059a
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r9.f1059a
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h():android.view.View");
    }

    private boolean a(e eVar) {
        if (this.e) {
            if (eVar.d() < this.f1055b.d()) {
                return !eVar.c(eVar.f1067a.get(eVar.f1067a.size() - 1)).f1060b;
            }
        } else if (eVar.b() > this.f1055b.c()) {
            return !eVar.c(eVar.f1067a.get(0)).f1060b;
        }
        return false;
    }

    public void a(int i) {
        a((String) null);
        if (i != this.i) {
            i();
            this.i = i;
            this.m = new BitSet(this.i);
            this.f1054a = new e[this.i];
            for (int i2 = 0; i2 < this.i; i2++) {
                this.f1054a[i2] = new e(i2);
            }
            p();
        }
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a((String) null);
        if (i == this.j) {
            return;
        }
        this.j = i;
        l lVar = this.f1055b;
        this.f1055b = this.c;
        this.c = lVar;
        p();
    }

    public void a(boolean z) {
        a((String) null);
        if (this.A != null && this.A.h != z) {
            this.A.h = z;
        }
        this.d = z;
        p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void i() {
        this.h.a();
        p();
    }

    private void N() {
        if (this.j == 1 || !j()) {
            this.e = this.d;
        } else {
            this.e = !this.d;
        }
    }

    boolean j() {
        return u() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        int iB = B() + D();
        int iC = C() + E();
        if (this.j == 1) {
            iA2 = a(i2, rect.height() + iC, H());
            iA = a(i, (this.k * this.i) + iB, G());
        } else {
            iA = a(i, rect.width() + iB, G());
            iA2 = a(i2, (this.k * this.i) + iC, H());
        }
        f(iA, iA2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.p pVar, RecyclerView.u uVar) {
        a(pVar, uVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(androidx.recyclerview.widget.RecyclerView.p r9, androidx.recyclerview.widget.RecyclerView.u r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.u uVar) {
        super.a(uVar);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    private void O() {
        if (this.c.h() == 1073741824) {
            return;
        }
        int iW = w();
        float fMax = 0.0f;
        for (int i = 0; i < iW; i++) {
            View viewI = i(i);
            float fE = this.c.e(viewI);
            if (fE >= fMax) {
                if (((b) viewI.getLayoutParams()).a()) {
                    fE = (fE * 1.0f) / this.i;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i2 = this.k;
        int iRound = Math.round(fMax * this.i);
        if (this.c.h() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.c.f());
        }
        f(iRound);
        if (this.k == i2) {
            return;
        }
        for (int i3 = 0; i3 < iW; i3++) {
            View viewI2 = i(i3);
            b bVar = (b) viewI2.getLayoutParams();
            if (!bVar.f1060b) {
                if (j() && this.j == 1) {
                    viewI2.offsetLeftAndRight(((-((this.i - 1) - bVar.f1059a.e)) * this.k) - ((-((this.i - 1) - bVar.f1059a.e)) * i2));
                } else {
                    int i4 = bVar.f1059a.e * this.k;
                    int i5 = bVar.f1059a.e * i2;
                    if (this.j == 1) {
                        viewI2.offsetLeftAndRight(i4 - i5);
                    } else {
                        viewI2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        if (this.A.c > 0) {
            if (this.A.c == this.i) {
                for (int i = 0; i < this.i; i++) {
                    this.f1054a[i].e();
                    int iC = this.A.d[i];
                    if (iC != Integer.MIN_VALUE) {
                        if (this.A.i) {
                            iC += this.f1055b.d();
                        } else {
                            iC += this.f1055b.c();
                        }
                    }
                    this.f1054a[i].c(iC);
                }
            } else {
                this.A.a();
                this.A.f1065a = this.A.f1066b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        N();
        if (this.A.f1065a != -1) {
            this.f = this.A.f1065a;
            aVar.c = this.A.i;
        } else {
            aVar.c = this.e;
        }
        if (this.A.e > 1) {
            this.h.f1061a = this.A.f;
            this.h.f1062b = this.A.g;
        }
    }

    void a(RecyclerView.u uVar, a aVar) {
        if (b(uVar, aVar) || c(uVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f1057a = 0;
    }

    private boolean c(RecyclerView.u uVar, a aVar) {
        int iV;
        if (this.o) {
            iV = w(uVar.e());
        } else {
            iV = v(uVar.e());
        }
        aVar.f1057a = iV;
        aVar.f1058b = Integer.MIN_VALUE;
        return true;
    }

    boolean b(RecyclerView.u uVar, a aVar) {
        int iC;
        if (uVar.a() || this.f == -1) {
            return false;
        }
        if (this.f < 0 || this.f >= uVar.e()) {
            this.f = -1;
            this.g = Integer.MIN_VALUE;
            return false;
        }
        if (this.A == null || this.A.f1065a == -1 || this.A.c < 1) {
            View viewC = c(this.f);
            if (viewC != null) {
                aVar.f1057a = this.e ? o() : L();
                if (this.g != Integer.MIN_VALUE) {
                    if (aVar.c) {
                        aVar.f1058b = (this.f1055b.d() - this.g) - this.f1055b.b(viewC);
                    } else {
                        aVar.f1058b = (this.f1055b.c() + this.g) - this.f1055b.a(viewC);
                    }
                    return true;
                }
                if (this.f1055b.e(viewC) > this.f1055b.f()) {
                    if (aVar.c) {
                        iC = this.f1055b.d();
                    } else {
                        iC = this.f1055b.c();
                    }
                    aVar.f1058b = iC;
                    return true;
                }
                int iA = this.f1055b.a(viewC) - this.f1055b.c();
                if (iA < 0) {
                    aVar.f1058b = -iA;
                    return true;
                }
                int iD = this.f1055b.d() - this.f1055b.b(viewC);
                if (iD < 0) {
                    aVar.f1058b = iD;
                    return true;
                }
                aVar.f1058b = Integer.MIN_VALUE;
            } else {
                aVar.f1057a = this.f;
                if (this.g == Integer.MIN_VALUE) {
                    aVar.c = u(aVar.f1057a) == 1;
                    aVar.b();
                } else {
                    aVar.a(this.g);
                }
                aVar.d = true;
            }
        } else {
            aVar.f1058b = Integer.MIN_VALUE;
            aVar.f1057a = this.f;
        }
        return true;
    }

    void f(int i) {
        this.k = i / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec(i, this.c.h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.A == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.u uVar) {
        return b(uVar);
    }

    private int b(RecyclerView.u uVar) {
        if (w() == 0) {
            return 0;
        }
        return n.a(uVar, this.f1055b, b(!this.F), c(!this.F), this, this.F, this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.u uVar) {
        return b(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.u uVar) {
        return i(uVar);
    }

    private int i(RecyclerView.u uVar) {
        if (w() == 0) {
            return 0;
        }
        return n.a(uVar, this.f1055b, b(!this.F), c(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.u uVar) {
        return i(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.u uVar) {
        return j(uVar);
    }

    private int j(RecyclerView.u uVar) {
        if (w() == 0) {
            return 0;
        }
        return n.b(uVar, this.f1055b, b(!this.F), c(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.u uVar) {
        return j(uVar);
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.f1060b) {
            if (this.j == 1) {
                a(view, this.B, a(A(), y(), C() + E(), bVar.height, true), z);
                return;
            } else {
                a(view, a(z(), x(), B() + D(), bVar.width, true), this.B, z);
                return;
            }
        }
        if (this.j == 1) {
            a(view, a(this.k, x(), 0, bVar.width, false), a(A(), y(), C() + E(), bVar.height, true), z);
        } else {
            a(view, a(z(), x(), B() + D(), bVar.width, true), a(this.k, y(), 0, bVar.height, false), z);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean zB;
        b(view, this.C);
        b bVar = (b) view.getLayoutParams();
        int iB = b(i, bVar.leftMargin + this.C.left, bVar.rightMargin + this.C.right);
        int iB2 = b(i2, bVar.topMargin + this.C.top, bVar.bottomMargin + this.C.bottom);
        if (z) {
            zB = a(view, iB, iB2, bVar);
        } else {
            zB = b(view, iB, iB2, bVar);
        }
        if (zB) {
            view.measure(iB, iB2);
        }
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.A = (d) parcelable;
            p();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable d() {
        int iA;
        if (this.A != null) {
            return new d(this.A);
        }
        d dVar = new d();
        dVar.h = this.d;
        dVar.i = this.o;
        dVar.j = this.z;
        if (this.h != null && this.h.f1061a != null) {
            dVar.f = this.h.f1061a;
            dVar.e = dVar.f.length;
            dVar.g = this.h.f1062b;
        } else {
            dVar.e = 0;
        }
        if (w() > 0) {
            dVar.f1065a = this.o ? o() : L();
            dVar.f1066b = k();
            dVar.c = this.i;
            dVar.d = new int[this.i];
            for (int i = 0; i < this.i; i++) {
                if (this.o) {
                    iA = this.f1054a[i].b(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iA -= this.f1055b.d();
                    }
                } else {
                    iA = this.f1054a[i].a(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iA -= this.f1055b.c();
                    }
                }
                dVar.d[i] = iA;
            }
        } else {
            dVar.f1065a = -1;
            dVar.f1066b = -1;
            dVar.c = 0;
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.p pVar, RecyclerView.u uVar, View view, androidx.core.g.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.j == 0) {
            cVar.b(c.b.a(bVar.b(), bVar.f1060b ? this.i : 1, -1, -1, bVar.f1060b, false));
        } else {
            cVar.b(c.b.a(-1, -1, bVar.b(), bVar.f1060b ? this.i : 1, bVar.f1060b, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (w() > 0) {
            View viewB = b(false);
            View viewC = c(false);
            if (viewB == null || viewC == null) {
                return;
            }
            int iD = d(viewB);
            int iD2 = d(viewC);
            if (iD < iD2) {
                accessibilityEvent.setFromIndex(iD);
                accessibilityEvent.setToIndex(iD2);
            } else {
                accessibilityEvent.setFromIndex(iD2);
                accessibilityEvent.setToIndex(iD);
            }
        }
    }

    int k() {
        View viewC = this.e ? c(true) : b(true);
        if (viewC == null) {
            return -1;
        }
        return d(viewC);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.j == 0) {
            return this.i;
        }
        return super.a(pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.j == 1) {
            return this.i;
        }
        return super.b(pVar, uVar);
    }

    View b(boolean z) {
        int iC = this.f1055b.c();
        int iD = this.f1055b.d();
        int iW = w();
        View view = null;
        for (int i = 0; i < iW; i++) {
            View viewI = i(i);
            int iA = this.f1055b.a(viewI);
            if (this.f1055b.b(viewI) > iC && iA < iD) {
                if (iA >= iC || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    View c(boolean z) {
        int iC = this.f1055b.c();
        int iD = this.f1055b.d();
        View view = null;
        for (int iW = w() - 1; iW >= 0; iW--) {
            View viewI = i(iW);
            int iA = this.f1055b.a(viewI);
            int iB = this.f1055b.b(viewI);
            if (iB > iC && iA < iD) {
                if (iB <= iD || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int iD;
        int iR = r(Integer.MIN_VALUE);
        if (iR != Integer.MIN_VALUE && (iD = this.f1055b.d() - iR) > 0) {
            int i = iD - (-c(-iD, pVar, uVar));
            if (!z || i <= 0) {
                return;
            }
            this.f1055b.a(i);
        }
    }

    private void c(RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int iC;
        int iQ = q(Integer.MAX_VALUE);
        if (iQ != Integer.MAX_VALUE && (iC = iQ - this.f1055b.c()) > 0) {
            int iC2 = iC - c(iC, pVar, uVar);
            if (!z || iC2 <= 0) {
                return;
            }
            this.f1055b.a(-iC2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.u r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.i r0 = r4.l
            r1 = 0
            r0.f1125b = r1
            androidx.recyclerview.widget.i r0 = r4.l
            r0.c = r5
            boolean r0 = r4.t()
            r2 = 1
            if (r0 == 0) goto L30
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L30
            boolean r0 = r4.e
            if (r6 >= r5) goto L1d
            r5 = 1
            goto L1e
        L1d:
            r5 = 0
        L1e:
            if (r0 != r5) goto L29
            androidx.recyclerview.widget.l r5 = r4.f1055b
            int r5 = r5.f()
            r6 = r5
            r5 = 0
            goto L32
        L29:
            androidx.recyclerview.widget.l r5 = r4.f1055b
            int r5 = r5.f()
            goto L31
        L30:
            r5 = 0
        L31:
            r6 = 0
        L32:
            boolean r0 = r4.s()
            if (r0 == 0) goto L4f
            androidx.recyclerview.widget.i r0 = r4.l
            androidx.recyclerview.widget.l r3 = r4.f1055b
            int r3 = r3.c()
            int r3 = r3 - r5
            r0.f = r3
            androidx.recyclerview.widget.i r5 = r4.l
            androidx.recyclerview.widget.l r0 = r4.f1055b
            int r0 = r0.d()
            int r0 = r0 + r6
            r5.g = r0
            goto L5f
        L4f:
            androidx.recyclerview.widget.i r0 = r4.l
            androidx.recyclerview.widget.l r3 = r4.f1055b
            int r3 = r3.e()
            int r3 = r3 + r6
            r0.g = r3
            androidx.recyclerview.widget.i r6 = r4.l
            int r5 = -r5
            r6.f = r5
        L5f:
            androidx.recyclerview.widget.i r5 = r4.l
            r5.h = r1
            androidx.recyclerview.widget.i r5 = r4.l
            r5.f1124a = r2
            androidx.recyclerview.widget.i r5 = r4.l
            androidx.recyclerview.widget.l r6 = r4.f1055b
            int r6 = r6.h()
            if (r6 != 0) goto L7a
            androidx.recyclerview.widget.l r6 = r4.f1055b
            int r6 = r6.e()
            if (r6 != 0) goto L7a
            r1 = 1
        L7a:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$u):void");
    }

    private void m(int i) {
        this.l.e = i;
        this.l.d = this.e != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void j(int i) {
        super.j(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f1054a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void k(int i) {
        super.k(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f1054a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.h.a();
        p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(int r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r5.e
            if (r0 == 0) goto L9
            int r0 = r5.o()
            goto Ld
        L9:
            int r0 = r5.L()
        Ld:
            r1 = 8
            if (r8 != r1) goto L1b
            if (r6 >= r7) goto L16
            int r2 = r7 + 1
            goto L1d
        L16:
            int r2 = r6 + 1
            r3 = r2
            r2 = r7
            goto L1f
        L1b:
            int r2 = r6 + r7
        L1d:
            r3 = r2
            r2 = r6
        L1f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r4 = r5.h
            r4.b(r2)
            if (r8 == r1) goto L36
            switch(r8) {
                case 1: goto L30;
                case 2: goto L2a;
                default: goto L29;
            }
        L29:
            goto L41
        L2a:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.h
            r8.a(r6, r7)
            goto L41
        L30:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.h
            r8.b(r6, r7)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.h
            r1 = 1
            r8.a(r6, r1)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r6 = r5.h
            r6.b(r7, r1)
        L41:
            if (r3 > r0) goto L44
            return
        L44:
            boolean r6 = r5.e
            if (r6 == 0) goto L4d
            int r6 = r5.L()
            goto L51
        L4d:
            int r6 = r5.o()
        L51:
            if (r2 > r6) goto L56
            r5.p()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a(RecyclerView.p pVar, i iVar, RecyclerView.u uVar) {
        int i;
        int i2;
        int iC;
        int iR;
        e eVarA;
        int iE;
        int i3;
        int iE2;
        int iE3;
        boolean zN;
        ?? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            i2 = iVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (iVar.e == 1) {
                i = iVar.g + iVar.f1125b;
            } else {
                i = iVar.f - iVar.f1125b;
            }
            i2 = i;
        }
        a(iVar.e, i2);
        if (this.e) {
            iC = this.f1055b.d();
        } else {
            iC = this.f1055b.c();
        }
        int i4 = iC;
        boolean z = false;
        while (iVar.a(uVar) && (this.l.i || !this.m.isEmpty())) {
            View viewA = iVar.a(pVar);
            b bVar = (b) viewA.getLayoutParams();
            int iF = bVar.f();
            int iC2 = this.h.c(iF);
            boolean z2 = iC2 == -1;
            if (z2) {
                eVarA = bVar.f1060b ? this.f1054a[r9] : a(iVar);
                this.h.a(iF, eVarA);
            } else {
                eVarA = this.f1054a[iC2];
            }
            e eVar = eVarA;
            bVar.f1059a = eVar;
            if (iVar.e == 1) {
                b(viewA);
            } else {
                b(viewA, (int) r9);
            }
            a(viewA, bVar, (boolean) r9);
            if (iVar.e == 1) {
                int iR2 = bVar.f1060b ? r(i4) : eVar.b(i4);
                int iE4 = this.f1055b.e(viewA) + iR2;
                if (z2 && bVar.f1060b) {
                    c.a aVarN = n(iR2);
                    aVarN.f1064b = -1;
                    aVarN.f1063a = iF;
                    this.h.a(aVarN);
                }
                i3 = iE4;
                iE = iR2;
            } else {
                int iQ = bVar.f1060b ? q(i4) : eVar.a(i4);
                iE = iQ - this.f1055b.e(viewA);
                if (z2 && bVar.f1060b) {
                    c.a aVarO = o(iQ);
                    aVarO.f1064b = 1;
                    aVarO.f1063a = iF;
                    this.h.a(aVarO);
                }
                i3 = iQ;
            }
            if (bVar.f1060b && iVar.d == -1) {
                if (z2) {
                    this.E = true;
                } else {
                    if (iVar.e == 1) {
                        zN = m();
                    } else {
                        zN = n();
                    }
                    if (!zN) {
                        c.a aVarF = this.h.f(iF);
                        if (aVarF != null) {
                            aVarF.d = true;
                        }
                        this.E = true;
                    }
                }
            }
            a(viewA, bVar, iVar);
            if (j() && this.j == 1) {
                int iD = bVar.f1060b ? this.c.d() : this.c.d() - (((this.i - 1) - eVar.e) * this.k);
                iE3 = iD;
                iE2 = iD - this.c.e(viewA);
            } else {
                int iC3 = bVar.f1060b ? this.c.c() : (eVar.e * this.k) + this.c.c();
                iE2 = iC3;
                iE3 = this.c.e(viewA) + iC3;
            }
            if (this.j == 1) {
                a(viewA, iE2, iE, iE3, i3);
            } else {
                a(viewA, iE, iE2, i3, iE3);
            }
            if (bVar.f1060b) {
                a(this.l.e, i2);
            } else {
                a(eVar, this.l.e, i2);
            }
            a(pVar, this.l);
            if (this.l.h && viewA.hasFocusable()) {
                if (bVar.f1060b) {
                    this.m.clear();
                } else {
                    this.m.set(eVar.e, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(pVar, this.l);
        }
        if (this.l.e == -1) {
            iR = this.f1055b.c() - q(this.f1055b.c());
        } else {
            iR = r(this.f1055b.d()) - this.f1055b.d();
        }
        if (iR > 0) {
            return Math.min(iVar.f1125b, iR);
        }
        return 0;
    }

    private c.a n(int i) {
        c.a aVar = new c.a();
        aVar.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.c[i2] = i - this.f1054a[i2].b(i);
        }
        return aVar;
    }

    private c.a o(int i) {
        c.a aVar = new c.a();
        aVar.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.c[i2] = this.f1054a[i2].a(i) - i;
        }
        return aVar;
    }

    private void a(View view, b bVar, i iVar) {
        if (iVar.e == 1) {
            if (bVar.f1060b) {
                p(view);
                return;
            } else {
                bVar.f1059a.b(view);
                return;
            }
        }
        if (bVar.f1060b) {
            q(view);
        } else {
            bVar.f1059a.a(view);
        }
    }

    private void a(RecyclerView.p pVar, i iVar) {
        int iMin;
        int iMin2;
        if (!iVar.f1124a || iVar.i) {
            return;
        }
        if (iVar.f1125b == 0) {
            if (iVar.e == -1) {
                b(pVar, iVar.g);
                return;
            } else {
                a(pVar, iVar.f);
                return;
            }
        }
        if (iVar.e == -1) {
            int iP = iVar.f - p(iVar.f);
            if (iP < 0) {
                iMin2 = iVar.g;
            } else {
                iMin2 = iVar.g - Math.min(iP, iVar.f1125b);
            }
            b(pVar, iMin2);
            return;
        }
        int iS = s(iVar.g) - iVar.g;
        if (iS < 0) {
            iMin = iVar.f;
        } else {
            iMin = Math.min(iS, iVar.f1125b) + iVar.f;
        }
        a(pVar, iMin);
    }

    private void p(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.f1054a[i].b(view);
        }
    }

    private void q(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.f1054a[i].a(view);
        }
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.i; i3++) {
            if (!this.f1054a[i3].f1067a.isEmpty()) {
                a(this.f1054a[i3], i, i2);
            }
        }
    }

    private void a(e eVar, int i, int i2) {
        int i3 = eVar.i();
        if (i == -1) {
            if (eVar.b() + i3 <= i2) {
                this.m.set(eVar.e, false);
            }
        } else if (eVar.d() - i3 >= i2) {
            this.m.set(eVar.e, false);
        }
    }

    private int p(int i) {
        int iA = this.f1054a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int iA2 = this.f1054a[i2].a(i);
            if (iA2 > iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    private int q(int i) {
        int iA = this.f1054a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int iA2 = this.f1054a[i2].a(i);
            if (iA2 < iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    boolean m() {
        int iB = this.f1054a[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.f1054a[i].b(Integer.MIN_VALUE) != iB) {
                return false;
            }
        }
        return true;
    }

    boolean n() {
        int iA = this.f1054a[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.f1054a[i].a(Integer.MIN_VALUE) != iA) {
                return false;
            }
        }
        return true;
    }

    private int r(int i) {
        int iB = this.f1054a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int iB2 = this.f1054a[i2].b(i);
            if (iB2 > iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private int s(int i) {
        int iB = this.f1054a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int iB2 = this.f1054a[i2].b(i);
            if (iB2 < iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private void a(RecyclerView.p pVar, int i) {
        while (w() > 0) {
            View viewI = i(0);
            if (this.f1055b.b(viewI) > i || this.f1055b.c(viewI) > i) {
                return;
            }
            b bVar = (b) viewI.getLayoutParams();
            if (bVar.f1060b) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    if (this.f1054a[i2].f1067a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.i; i3++) {
                    this.f1054a[i3].h();
                }
            } else if (bVar.f1059a.f1067a.size() == 1) {
                return;
            } else {
                bVar.f1059a.h();
            }
            a(viewI, pVar);
        }
    }

    private void b(RecyclerView.p pVar, int i) {
        for (int iW = w() - 1; iW >= 0; iW--) {
            View viewI = i(iW);
            if (this.f1055b.a(viewI) < i || this.f1055b.d(viewI) < i) {
                return;
            }
            b bVar = (b) viewI.getLayoutParams();
            if (bVar.f1060b) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    if (this.f1054a[i2].f1067a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.i; i3++) {
                    this.f1054a[i3].g();
                }
            } else if (bVar.f1059a.f1067a.size() == 1) {
                return;
            } else {
                bVar.f1059a.g();
            }
            a(viewI, pVar);
        }
    }

    private boolean t(int i) {
        if (this.j == 0) {
            return (i == -1) != this.e;
        }
        return ((i == -1) == this.e) == j();
    }

    private e a(i iVar) {
        int i;
        int i2;
        int i3 = -1;
        if (t(iVar.e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.i;
            i2 = 1;
        }
        e eVar = null;
        if (iVar.e == 1) {
            int i4 = Integer.MAX_VALUE;
            int iC = this.f1055b.c();
            while (i != i3) {
                e eVar2 = this.f1054a[i];
                int iB = eVar2.b(iC);
                if (iB < i4) {
                    eVar = eVar2;
                    i4 = iB;
                }
                i += i2;
            }
            return eVar;
        }
        int i5 = Integer.MIN_VALUE;
        int iD = this.f1055b.d();
        while (i != i3) {
            e eVar3 = this.f1054a[i];
            int iA = eVar3.a(iD);
            if (iA > i5) {
                eVar = eVar3;
                i5 = iA;
            }
            i += i2;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return this.j == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean e() {
        return this.j == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        return c(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        return c(i, pVar, uVar);
    }

    private int u(int i) {
        if (w() == 0) {
            return this.e ? 1 : -1;
        }
        return (i < L()) != this.e ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t.b
    public PointF d(int i) {
        int iU = u(i);
        PointF pointF = new PointF();
        if (iU == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = iU;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iU;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        if (this.A != null && this.A.f1065a != i) {
            this.A.b();
        }
        this.f = i;
        this.g = Integer.MIN_VALUE;
        p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.u uVar, RecyclerView.i.a aVar) {
        int iB;
        if (this.j != 0) {
            i = i2;
        }
        if (w() == 0 || i == 0) {
            return;
        }
        a(i, uVar);
        if (this.G == null || this.G.length < this.i) {
            this.G = new int[this.i];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.i; i4++) {
            if (this.l.d == -1) {
                iB = this.l.f - this.f1054a[i4].a(this.l.f);
            } else {
                iB = this.f1054a[i4].b(this.l.g) - this.l.g;
            }
            if (iB >= 0) {
                this.G[i3] = iB;
                i3++;
            }
        }
        Arrays.sort(this.G, 0, i3);
        for (int i5 = 0; i5 < i3 && this.l.a(uVar); i5++) {
            aVar.b(this.l.c, this.G[i5]);
            this.l.c += this.l.d;
        }
    }

    void a(int i, RecyclerView.u uVar) {
        int iL;
        int i2;
        if (i > 0) {
            iL = o();
            i2 = 1;
        } else {
            iL = L();
            i2 = -1;
        }
        this.l.f1124a = true;
        b(iL, uVar);
        m(i2);
        this.l.c = iL + this.l.d;
        this.l.f1125b = Math.abs(i);
    }

    int c(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (w() == 0 || i == 0) {
            return 0;
        }
        a(i, uVar);
        int iA = a(pVar, this.l, uVar);
        if (this.l.f1125b >= iA) {
            i = i < 0 ? -iA : iA;
        }
        this.f1055b.a(-i);
        this.o = this.e;
        this.l.f1125b = 0;
        a(pVar, this.l);
        return i;
    }

    int o() {
        int iW = w();
        if (iW == 0) {
            return 0;
        }
        return d(i(iW - 1));
    }

    int L() {
        if (w() == 0) {
            return 0;
        }
        return d(i(0));
    }

    private int v(int i) {
        int iW = w();
        for (int i2 = 0; i2 < iW; i2++) {
            int iD = d(i(i2));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    private int w(int i) {
        for (int iW = w() - 1; iW >= 0; iW--) {
            int iD = d(i(iW));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        if (this.j == 0) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        View viewE;
        int iL;
        int iK;
        int iK2;
        int iK3;
        View viewA;
        if (w() == 0 || (viewE = e(view)) == null) {
            return null;
        }
        N();
        int iX = x(i);
        if (iX == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) viewE.getLayoutParams();
        boolean z = bVar.f1060b;
        e eVar = bVar.f1059a;
        if (iX == 1) {
            iL = o();
        } else {
            iL = L();
        }
        b(iL, uVar);
        m(iX);
        this.l.c = this.l.d + iL;
        this.l.f1125b = (int) (this.f1055b.f() * 0.33333334f);
        this.l.h = true;
        this.l.f1124a = false;
        a(pVar, this.l, uVar);
        this.o = this.e;
        if (!z && (viewA = eVar.a(iL, iX)) != null && viewA != viewE) {
            return viewA;
        }
        if (t(iX)) {
            for (int i2 = this.i - 1; i2 >= 0; i2--) {
                View viewA2 = this.f1054a[i2].a(iL, iX);
                if (viewA2 != null && viewA2 != viewE) {
                    return viewA2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.i; i3++) {
                View viewA3 = this.f1054a[i3].a(iL, iX);
                if (viewA3 != null && viewA3 != viewE) {
                    return viewA3;
                }
            }
        }
        boolean z2 = (this.d ^ true) == (iX == -1);
        if (!z) {
            if (z2) {
                iK3 = eVar.j();
            } else {
                iK3 = eVar.k();
            }
            View viewC = c(iK3);
            if (viewC != null && viewC != viewE) {
                return viewC;
            }
        }
        if (t(iX)) {
            for (int i4 = this.i - 1; i4 >= 0; i4--) {
                if (i4 != eVar.e) {
                    if (z2) {
                        iK2 = this.f1054a[i4].j();
                    } else {
                        iK2 = this.f1054a[i4].k();
                    }
                    View viewC2 = c(iK2);
                    if (viewC2 != null && viewC2 != viewE) {
                        return viewC2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.i; i5++) {
                if (z2) {
                    iK = this.f1054a[i5].j();
                } else {
                    iK = this.f1054a[i5].k();
                }
                View viewC3 = c(iK);
                if (viewC3 != null && viewC3 != viewE) {
                    return viewC3;
                }
            }
        }
        return null;
    }

    private int x(int i) {
        if (i == 17) {
            return this.j == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.j == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.j == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.j == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.j != 1 && j()) ? 1 : -1;
            case 2:
                return (this.j != 1 && j()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public static class b extends RecyclerView.j {

        /* renamed from: a, reason: collision with root package name */
        e f1059a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1060b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean a() {
            return this.f1060b;
        }

        public final int b() {
            if (this.f1059a == null) {
                return -1;
            }
            return this.f1059a.e;
        }
    }

    class e {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<View> f1067a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        int f1068b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        e(int i) {
            this.e = i;
        }

        int a(int i) {
            if (this.f1068b != Integer.MIN_VALUE) {
                return this.f1068b;
            }
            if (this.f1067a.size() == 0) {
                return i;
            }
            a();
            return this.f1068b;
        }

        void a() {
            c.a aVarF;
            View view = this.f1067a.get(0);
            b bVarC = c(view);
            this.f1068b = StaggeredGridLayoutManager.this.f1055b.a(view);
            if (bVarC.f1060b && (aVarF = StaggeredGridLayoutManager.this.h.f(bVarC.f())) != null && aVarF.f1064b == -1) {
                this.f1068b -= aVarF.a(this.e);
            }
        }

        int b() {
            if (this.f1068b != Integer.MIN_VALUE) {
                return this.f1068b;
            }
            a();
            return this.f1068b;
        }

        int b(int i) {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            if (this.f1067a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        void c() {
            c.a aVarF;
            View view = this.f1067a.get(this.f1067a.size() - 1);
            b bVarC = c(view);
            this.c = StaggeredGridLayoutManager.this.f1055b.b(view);
            if (bVarC.f1060b && (aVarF = StaggeredGridLayoutManager.this.h.f(bVarC.f())) != null && aVarF.f1064b == 1) {
                this.c += aVarF.a(this.e);
            }
        }

        int d() {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            c();
            return this.c;
        }

        void a(View view) {
            b bVarC = c(view);
            bVarC.f1059a = this;
            this.f1067a.add(0, view);
            this.f1068b = Integer.MIN_VALUE;
            if (this.f1067a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (bVarC.d() || bVarC.e()) {
                this.d += StaggeredGridLayoutManager.this.f1055b.e(view);
            }
        }

        void b(View view) {
            b bVarC = c(view);
            bVarC.f1059a = this;
            this.f1067a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.f1067a.size() == 1) {
                this.f1068b = Integer.MIN_VALUE;
            }
            if (bVarC.d() || bVarC.e()) {
                this.d += StaggeredGridLayoutManager.this.f1055b.e(view);
            }
        }

        void a(boolean z, int i) {
            int iA;
            if (z) {
                iA = b(Integer.MIN_VALUE);
            } else {
                iA = a(Integer.MIN_VALUE);
            }
            e();
            if (iA == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iA >= StaggeredGridLayoutManager.this.f1055b.d()) {
                if (z || iA <= StaggeredGridLayoutManager.this.f1055b.c()) {
                    if (i != Integer.MIN_VALUE) {
                        iA += i;
                    }
                    this.c = iA;
                    this.f1068b = iA;
                }
            }
        }

        void e() {
            this.f1067a.clear();
            f();
            this.d = 0;
        }

        void f() {
            this.f1068b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void c(int i) {
            this.f1068b = i;
            this.c = i;
        }

        void g() {
            int size = this.f1067a.size();
            View viewRemove = this.f1067a.remove(size - 1);
            b bVarC = c(viewRemove);
            bVarC.f1059a = null;
            if (bVarC.d() || bVarC.e()) {
                this.d -= StaggeredGridLayoutManager.this.f1055b.e(viewRemove);
            }
            if (size == 1) {
                this.f1068b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void h() {
            View viewRemove = this.f1067a.remove(0);
            b bVarC = c(viewRemove);
            bVarC.f1059a = null;
            if (this.f1067a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (bVarC.d() || bVarC.e()) {
                this.d -= StaggeredGridLayoutManager.this.f1055b.e(viewRemove);
            }
            this.f1068b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.d;
        }

        b c(View view) {
            return (b) view.getLayoutParams();
        }

        void d(int i) {
            if (this.f1068b != Integer.MIN_VALUE) {
                this.f1068b += i;
            }
            if (this.c != Integer.MIN_VALUE) {
                this.c += i;
            }
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(this.f1067a.size() - 1, -1, true);
            }
            return a(0, this.f1067a.size(), true);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(0, this.f1067a.size(), true);
            }
            return a(this.f1067a.size() - 1, -1, true);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iC = StaggeredGridLayoutManager.this.f1055b.c();
            int iD = StaggeredGridLayoutManager.this.f1055b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f1067a.get(i);
                int iA = StaggeredGridLayoutManager.this.f1055b.a(view);
                int iB = StaggeredGridLayoutManager.this.f1055b.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iA >= iD : iA > iD;
                if (!z3 ? iB > iC : iB >= iC) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iA >= iC && iB <= iD) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                        if (iA < iC || iB > iD) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f1067a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f1067a.get(i3);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) <= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f1067a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f1067a.get(size2);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) >= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        int[] f1061a;

        /* renamed from: b, reason: collision with root package name */
        List<a> f1062b;

        c() {
        }

        int a(int i) {
            if (this.f1062b != null) {
                for (int size = this.f1062b.size() - 1; size >= 0; size--) {
                    if (this.f1062b.get(size).f1063a >= i) {
                        this.f1062b.remove(size);
                    }
                }
            }
            return b(i);
        }

        int b(int i) {
            if (this.f1061a == null || i >= this.f1061a.length) {
                return -1;
            }
            int iG = g(i);
            if (iG == -1) {
                Arrays.fill(this.f1061a, i, this.f1061a.length, -1);
                return this.f1061a.length;
            }
            int i2 = iG + 1;
            Arrays.fill(this.f1061a, i, i2, -1);
            return i2;
        }

        int c(int i) {
            if (this.f1061a == null || i >= this.f1061a.length) {
                return -1;
            }
            return this.f1061a[i];
        }

        void a(int i, e eVar) {
            e(i);
            this.f1061a[i] = eVar.e;
        }

        int d(int i) {
            int length = this.f1061a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.f1061a == null) {
                this.f1061a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f1061a, -1);
            } else if (i >= this.f1061a.length) {
                int[] iArr = this.f1061a;
                this.f1061a = new int[d(i)];
                System.arraycopy(iArr, 0, this.f1061a, 0, iArr.length);
                Arrays.fill(this.f1061a, iArr.length, this.f1061a.length, -1);
            }
        }

        void a() {
            if (this.f1061a != null) {
                Arrays.fill(this.f1061a, -1);
            }
            this.f1062b = null;
        }

        void a(int i, int i2) {
            if (this.f1061a == null || i >= this.f1061a.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            System.arraycopy(this.f1061a, i3, this.f1061a, i, (this.f1061a.length - i) - i2);
            Arrays.fill(this.f1061a, this.f1061a.length - i2, this.f1061a.length, -1);
            c(i, i2);
        }

        private void c(int i, int i2) {
            if (this.f1062b == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = this.f1062b.size() - 1; size >= 0; size--) {
                a aVar = this.f1062b.get(size);
                if (aVar.f1063a >= i) {
                    if (aVar.f1063a < i3) {
                        this.f1062b.remove(size);
                    } else {
                        aVar.f1063a -= i2;
                    }
                }
            }
        }

        void b(int i, int i2) {
            if (this.f1061a == null || i >= this.f1061a.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            System.arraycopy(this.f1061a, i, this.f1061a, i3, (this.f1061a.length - i) - i2);
            Arrays.fill(this.f1061a, i, i3, -1);
            d(i, i2);
        }

        private void d(int i, int i2) {
            if (this.f1062b == null) {
                return;
            }
            for (int size = this.f1062b.size() - 1; size >= 0; size--) {
                a aVar = this.f1062b.get(size);
                if (aVar.f1063a >= i) {
                    aVar.f1063a += i2;
                }
            }
        }

        private int g(int i) {
            if (this.f1062b == null) {
                return -1;
            }
            a aVarF = f(i);
            if (aVarF != null) {
                this.f1062b.remove(aVarF);
            }
            int size = this.f1062b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f1062b.get(i2).f1063a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = this.f1062b.get(i2);
            this.f1062b.remove(i2);
            return aVar.f1063a;
        }

        public void a(a aVar) {
            if (this.f1062b == null) {
                this.f1062b = new ArrayList();
            }
            int size = this.f1062b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f1062b.get(i);
                if (aVar2.f1063a == aVar.f1063a) {
                    this.f1062b.remove(i);
                }
                if (aVar2.f1063a >= aVar.f1063a) {
                    this.f1062b.add(i, aVar);
                    return;
                }
            }
            this.f1062b.add(aVar);
        }

        public a f(int i) {
            if (this.f1062b == null) {
                return null;
            }
            for (int size = this.f1062b.size() - 1; size >= 0; size--) {
                a aVar = this.f1062b.get(size);
                if (aVar.f1063a == i) {
                    return aVar;
                }
            }
            return null;
        }

        public a a(int i, int i2, int i3, boolean z) {
            if (this.f1062b == null) {
                return null;
            }
            int size = this.f1062b.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1062b.get(i4);
                if (aVar.f1063a >= i2) {
                    return null;
                }
                if (aVar.f1063a >= i && (i3 == 0 || aVar.f1064b == i3 || (z && aVar.d))) {
                    return aVar;
                }
            }
            return null;
        }

        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.c.a.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i) {
                    return new a[i];
                }
            };

            /* renamed from: a, reason: collision with root package name */
            int f1063a;

            /* renamed from: b, reason: collision with root package name */
            int f1064b;
            int[] c;
            boolean d;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            a(Parcel parcel) {
                this.f1063a = parcel.readInt();
                this.f1064b = parcel.readInt();
                this.d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    this.c = new int[i];
                    parcel.readIntArray(this.c);
                }
            }

            a() {
            }

            int a(int i) {
                if (this.c == null) {
                    return 0;
                }
                return this.c[i];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1063a);
                parcel.writeInt(this.f1064b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c != null && this.c.length > 0) {
                    parcel.writeInt(this.c.length);
                    parcel.writeIntArray(this.c);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1063a + ", mGapDir=" + this.f1064b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f1065a;

        /* renamed from: b, reason: collision with root package name */
        int f1066b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<c.a> g;
        boolean h;
        boolean i;
        boolean j;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f1065a = parcel.readInt();
            this.f1066b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public d(d dVar) {
            this.c = dVar.c;
            this.f1065a = dVar.f1065a;
            this.f1066b = dVar.f1066b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.h = dVar.h;
            this.i = dVar.i;
            this.j = dVar.j;
            this.g = dVar.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.f1065a = -1;
            this.f1066b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1065a);
            parcel.writeInt(this.f1066b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }
    }

    class a {

        /* renamed from: a, reason: collision with root package name */
        int f1057a;

        /* renamed from: b, reason: collision with root package name */
        int f1058b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            a();
        }

        void a() {
            this.f1057a = -1;
            this.f1058b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            if (this.f != null) {
                Arrays.fill(this.f, -1);
            }
        }

        void a(e[] eVarArr) {
            int length = eVarArr.length;
            if (this.f == null || this.f.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.f1054a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = eVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.f1058b = this.c ? StaggeredGridLayoutManager.this.f1055b.d() : StaggeredGridLayoutManager.this.f1055b.c();
        }

        void a(int i) {
            if (this.c) {
                this.f1058b = StaggeredGridLayoutManager.this.f1055b.d() - i;
            } else {
                this.f1058b = StaggeredGridLayoutManager.this.f1055b.c() + i;
            }
        }
    }
}
