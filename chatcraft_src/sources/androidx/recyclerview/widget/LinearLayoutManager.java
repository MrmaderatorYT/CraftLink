package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.t.b {

    /* renamed from: a, reason: collision with root package name */
    private c f1006a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1007b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final b g;
    private int h;
    int i;
    l j;
    boolean k;
    int l;
    int m;
    d n;
    final a o;

    void a(RecyclerView.p pVar, RecyclerView.u uVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean c() {
        return true;
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        b(i);
        b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        RecyclerView.i.b bVarA = a(context, attributeSet, i, i2);
        b(bVarA.f1034a);
        b(bVarA.c);
        a(bVarA.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        return new RecyclerView.j(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.a(recyclerView, pVar);
        if (this.f) {
            c(pVar);
            pVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (w() > 0) {
            accessibilityEvent.setFromIndex(m());
            accessibilityEvent.setToIndex(n());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable d() {
        if (this.n != null) {
            return new d(this.n);
        }
        d dVar = new d();
        if (w() > 0) {
            i();
            boolean z = this.f1007b ^ this.k;
            dVar.c = z;
            if (z) {
                View viewN = N();
                dVar.f1015b = this.j.d() - this.j.b(viewN);
                dVar.f1014a = d(viewN);
            } else {
                View viewM = M();
                dVar.f1014a = d(viewM);
                dVar.f1015b = this.j.a(viewM) - this.j.c();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.n = (d) parcelable;
            p();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean e() {
        return this.i == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return this.i == 1;
    }

    public void a(boolean z) {
        a((String) null);
        if (this.d == z) {
            return;
        }
        this.d = z;
        p();
    }

    public int g() {
        return this.i;
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        a((String) null);
        if (i != this.i || this.j == null) {
            this.j = l.a(this, i);
            this.o.f1008a = this.j;
            this.i = i;
            p();
        }
    }

    private void L() {
        if (this.i == 1 || !h()) {
            this.k = this.c;
        } else {
            this.k = !this.c;
        }
    }

    public void b(boolean z) {
        a((String) null);
        if (z == this.c) {
            return;
        }
        this.c = z;
        p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View c(int i) {
        int iW = w();
        if (iW == 0) {
            return null;
        }
        int iD = i - d(i(0));
        if (iD >= 0 && iD < iW) {
            View viewI = i(iD);
            if (d(viewI) == i) {
                return viewI;
            }
        }
        return super.c(i);
    }

    protected int b(RecyclerView.u uVar) {
        if (uVar.d()) {
            return this.j.f();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t.b
    public PointF d(int i) {
        if (w() == 0) {
            return null;
        }
        int i2 = (i < d(i(0))) != this.k ? -1 : 1;
        if (this.i == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.p pVar, RecyclerView.u uVar) {
        int i;
        int i2;
        int i3;
        View viewC;
        int iA;
        int i4 = -1;
        if ((this.n != null || this.l != -1) && uVar.e() == 0) {
            c(pVar);
            return;
        }
        if (this.n != null && this.n.a()) {
            this.l = this.n.f1014a;
        }
        i();
        this.f1006a.f1012a = false;
        L();
        View viewF = F();
        if (!this.o.e || this.l != -1 || this.n != null) {
            this.o.a();
            this.o.d = this.k ^ this.d;
            a(pVar, uVar, this.o);
            this.o.e = true;
        } else if (viewF != null && (this.j.a(viewF) >= this.j.d() || this.j.b(viewF) <= this.j.c())) {
            this.o.a(viewF, d(viewF));
        }
        int iB = b(uVar);
        if (this.f1006a.j >= 0) {
            i = iB;
            iB = 0;
        } else {
            i = 0;
        }
        int iC = iB + this.j.c();
        int iG = i + this.j.g();
        if (uVar.a() && this.l != -1 && this.m != Integer.MIN_VALUE && (viewC = c(this.l)) != null) {
            if (this.k) {
                iA = (this.j.d() - this.j.b(viewC)) - this.m;
            } else {
                iA = this.m - (this.j.a(viewC) - this.j.c());
            }
            if (iA > 0) {
                iC += iA;
            } else {
                iG -= iA;
            }
        }
        if (!this.o.d ? !this.k : this.k) {
            i4 = 1;
        }
        a(pVar, uVar, this.o, i4);
        a(pVar);
        this.f1006a.l = k();
        this.f1006a.i = uVar.a();
        if (this.o.d) {
            b(this.o);
            this.f1006a.h = iC;
            a(pVar, this.f1006a, uVar, false);
            i3 = this.f1006a.f1013b;
            int i5 = this.f1006a.d;
            if (this.f1006a.c > 0) {
                iG += this.f1006a.c;
            }
            a(this.o);
            this.f1006a.h = iG;
            this.f1006a.d += this.f1006a.e;
            a(pVar, this.f1006a, uVar, false);
            i2 = this.f1006a.f1013b;
            if (this.f1006a.c > 0) {
                int i6 = this.f1006a.c;
                g(i5, i3);
                this.f1006a.h = i6;
                a(pVar, this.f1006a, uVar, false);
                i3 = this.f1006a.f1013b;
            }
        } else {
            a(this.o);
            this.f1006a.h = iG;
            a(pVar, this.f1006a, uVar, false);
            i2 = this.f1006a.f1013b;
            int i7 = this.f1006a.d;
            if (this.f1006a.c > 0) {
                iC += this.f1006a.c;
            }
            b(this.o);
            this.f1006a.h = iC;
            this.f1006a.d += this.f1006a.e;
            a(pVar, this.f1006a, uVar, false);
            i3 = this.f1006a.f1013b;
            if (this.f1006a.c > 0) {
                int i8 = this.f1006a.c;
                a(i7, i2);
                this.f1006a.h = i8;
                a(pVar, this.f1006a, uVar, false);
                i2 = this.f1006a.f1013b;
            }
        }
        if (w() > 0) {
            if (this.k ^ this.d) {
                int iA2 = a(i2, pVar, uVar, true);
                int i9 = i3 + iA2;
                int i10 = i2 + iA2;
                int iB2 = b(i9, pVar, uVar, false);
                i3 = i9 + iB2;
                i2 = i10 + iB2;
            } else {
                int iB3 = b(i3, pVar, uVar, true);
                int i11 = i3 + iB3;
                int i12 = i2 + iB3;
                int iA3 = a(i12, pVar, uVar, false);
                i3 = i11 + iA3;
                i2 = i12 + iA3;
            }
        }
        b(pVar, uVar, i3, i2);
        if (!uVar.a()) {
            this.j.a();
        } else {
            this.o.a();
        }
        this.f1007b = this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.u uVar) {
        super.a(uVar);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, int i, int i2) {
        if (!uVar.b() || w() == 0 || uVar.a() || !b()) {
            return;
        }
        List<RecyclerView.x> listC = pVar.c();
        int size = listC.size();
        int iD = d(i(0));
        int iE = 0;
        int iE2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.x xVar = listC.get(i3);
            if (!xVar.s()) {
                if (((xVar.f() < iD) != this.k ? (char) 65535 : (char) 1) == 65535) {
                    iE += this.j.e(xVar.f1052a);
                } else {
                    iE2 += this.j.e(xVar.f1052a);
                }
            }
        }
        this.f1006a.k = listC;
        if (iE > 0) {
            g(d(M()), i);
            this.f1006a.h = iE;
            this.f1006a.c = 0;
            this.f1006a.a();
            a(pVar, this.f1006a, uVar, false);
        }
        if (iE2 > 0) {
            a(d(N()), i2);
            this.f1006a.h = iE2;
            this.f1006a.c = 0;
            this.f1006a.a();
            a(pVar, this.f1006a, uVar, false);
        }
        this.f1006a.k = null;
    }

    private void a(RecyclerView.p pVar, RecyclerView.u uVar, a aVar) {
        if (a(uVar, aVar) || b(pVar, uVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f1009b = this.d ? uVar.e() - 1 : 0;
    }

    private boolean b(RecyclerView.p pVar, RecyclerView.u uVar, a aVar) {
        View viewG;
        int iC;
        if (w() == 0) {
            return false;
        }
        View viewF = F();
        if (viewF != null && aVar.a(viewF, uVar)) {
            aVar.a(viewF, d(viewF));
            return true;
        }
        if (this.f1007b != this.d) {
            return false;
        }
        if (aVar.d) {
            viewG = f(pVar, uVar);
        } else {
            viewG = g(pVar, uVar);
        }
        if (viewG == null) {
            return false;
        }
        aVar.b(viewG, d(viewG));
        if (!uVar.a() && b()) {
            if (this.j.a(viewG) >= this.j.d() || this.j.b(viewG) < this.j.c()) {
                if (aVar.d) {
                    iC = this.j.d();
                } else {
                    iC = this.j.c();
                }
                aVar.c = iC;
            }
        }
        return true;
    }

    private boolean a(RecyclerView.u uVar, a aVar) {
        int iA;
        if (uVar.a() || this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= uVar.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        aVar.f1009b = this.l;
        if (this.n != null && this.n.a()) {
            aVar.d = this.n.c;
            if (aVar.d) {
                aVar.c = this.j.d() - this.n.f1015b;
            } else {
                aVar.c = this.j.c() + this.n.f1015b;
            }
            return true;
        }
        if (this.m == Integer.MIN_VALUE) {
            View viewC = c(this.l);
            if (viewC != null) {
                if (this.j.e(viewC) > this.j.f()) {
                    aVar.b();
                    return true;
                }
                if (this.j.a(viewC) - this.j.c() < 0) {
                    aVar.c = this.j.c();
                    aVar.d = false;
                    return true;
                }
                if (this.j.d() - this.j.b(viewC) < 0) {
                    aVar.c = this.j.d();
                    aVar.d = true;
                    return true;
                }
                if (aVar.d) {
                    iA = this.j.b(viewC) + this.j.b();
                } else {
                    iA = this.j.a(viewC);
                }
                aVar.c = iA;
            } else {
                if (w() > 0) {
                    aVar.d = (this.l < d(i(0))) == this.k;
                }
                aVar.b();
            }
            return true;
        }
        aVar.d = this.k;
        if (this.k) {
            aVar.c = this.j.d() - this.m;
        } else {
            aVar.c = this.j.c() + this.m;
        }
        return true;
    }

    private int a(int i, RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int iD;
        int iD2 = this.j.d() - i;
        if (iD2 <= 0) {
            return 0;
        }
        int i2 = -c(-iD2, pVar, uVar);
        int i3 = i + i2;
        if (!z || (iD = this.j.d() - i3) <= 0) {
            return i2;
        }
        this.j.a(iD);
        return iD + i2;
    }

    private int b(int i, RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int iC;
        int iC2 = i - this.j.c();
        if (iC2 <= 0) {
            return 0;
        }
        int i2 = -c(iC2, pVar, uVar);
        int i3 = i + i2;
        if (!z || (iC = i3 - this.j.c()) <= 0) {
            return i2;
        }
        this.j.a(-iC);
        return i2 - iC;
    }

    private void a(a aVar) {
        a(aVar.f1009b, aVar.c);
    }

    private void a(int i, int i2) {
        this.f1006a.c = this.j.d() - i2;
        this.f1006a.e = this.k ? -1 : 1;
        this.f1006a.d = i;
        this.f1006a.f = 1;
        this.f1006a.f1013b = i2;
        this.f1006a.g = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        g(aVar.f1009b, aVar.c);
    }

    private void g(int i, int i2) {
        this.f1006a.c = i2 - this.j.c();
        this.f1006a.d = i;
        this.f1006a.e = this.k ? 1 : -1;
        this.f1006a.f = -1;
        this.f1006a.f1013b = i2;
        this.f1006a.g = Integer.MIN_VALUE;
    }

    protected boolean h() {
        return u() == 1;
    }

    void i() {
        if (this.f1006a == null) {
            this.f1006a = j();
        }
    }

    c j() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.i == 1) {
            return 0;
        }
        return c(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.i == 0) {
            return 0;
        }
        return c(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.u uVar) {
        return i(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.u uVar) {
        return i(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.u uVar) {
        return j(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.u uVar) {
        return j(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.u uVar) {
        return k(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.u uVar) {
        return k(uVar);
    }

    private int i(RecyclerView.u uVar) {
        if (w() == 0) {
            return 0;
        }
        i();
        return n.a(uVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e, this.k);
    }

    private int j(RecyclerView.u uVar) {
        if (w() == 0) {
            return 0;
        }
        i();
        return n.a(uVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    private int k(RecyclerView.u uVar) {
        if (w() == 0) {
            return 0;
        }
        i();
        return n.b(uVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    private void a(int i, int i2, boolean z, RecyclerView.u uVar) {
        int iC;
        this.f1006a.l = k();
        this.f1006a.h = b(uVar);
        this.f1006a.f = i;
        if (i == 1) {
            this.f1006a.h += this.j.g();
            View viewN = N();
            this.f1006a.e = this.k ? -1 : 1;
            this.f1006a.d = d(viewN) + this.f1006a.e;
            this.f1006a.f1013b = this.j.b(viewN);
            iC = this.j.b(viewN) - this.j.d();
        } else {
            View viewM = M();
            this.f1006a.h += this.j.c();
            this.f1006a.e = this.k ? 1 : -1;
            this.f1006a.d = d(viewM) + this.f1006a.e;
            this.f1006a.f1013b = this.j.a(viewM);
            iC = (-this.j.a(viewM)) + this.j.c();
        }
        this.f1006a.c = i2;
        if (z) {
            this.f1006a.c -= iC;
        }
        this.f1006a.g = iC;
    }

    boolean k() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    void a(RecyclerView.u uVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.d;
        if (i < 0 || i >= uVar.e()) {
            return;
        }
        aVar.b(i, Math.max(0, cVar.g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        if (this.n != null && this.n.a()) {
            z = this.n.c;
            i2 = this.n.f1014a;
        } else {
            L();
            z = this.k;
            if (this.l == -1) {
                i2 = z ? i - 1 : 0;
            } else {
                i2 = this.l;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.h && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.u uVar, RecyclerView.i.a aVar) {
        if (this.i != 0) {
            i = i2;
        }
        if (w() == 0 || i == 0) {
            return;
        }
        i();
        a(i > 0 ? 1 : -1, Math.abs(i), true, uVar);
        a(uVar, this.f1006a, aVar);
    }

    int c(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (w() == 0 || i == 0) {
            return 0;
        }
        this.f1006a.f1012a = true;
        i();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        a(i2, iAbs, true, uVar);
        int iA = this.f1006a.g + a(pVar, this.f1006a, uVar, false);
        if (iA < 0) {
            return 0;
        }
        if (iAbs > iA) {
            i = i2 * iA;
        }
        this.j.a(-i);
        this.f1006a.j = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.p pVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                a(i, pVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                a(i3, pVar);
            }
        }
    }

    private void a(RecyclerView.p pVar, int i) {
        if (i < 0) {
            return;
        }
        int iW = w();
        if (!this.k) {
            for (int i2 = 0; i2 < iW; i2++) {
                View viewI = i(i2);
                if (this.j.b(viewI) > i || this.j.c(viewI) > i) {
                    a(pVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = iW - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View viewI2 = i(i4);
            if (this.j.b(viewI2) > i || this.j.c(viewI2) > i) {
                a(pVar, i3, i4);
                return;
            }
        }
    }

    private void b(RecyclerView.p pVar, int i) {
        int iW = w();
        if (i < 0) {
            return;
        }
        int iE = this.j.e() - i;
        if (this.k) {
            for (int i2 = 0; i2 < iW; i2++) {
                View viewI = i(i2);
                if (this.j.a(viewI) < iE || this.j.d(viewI) < iE) {
                    a(pVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = iW - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View viewI2 = i(i4);
            if (this.j.a(viewI2) < iE || this.j.d(viewI2) < iE) {
                a(pVar, i3, i4);
                return;
            }
        }
    }

    private void a(RecyclerView.p pVar, c cVar) {
        if (!cVar.f1012a || cVar.l) {
            return;
        }
        if (cVar.f == -1) {
            b(pVar, cVar.g);
        } else {
            a(pVar, cVar.g);
        }
    }

    int a(RecyclerView.p pVar, c cVar, RecyclerView.u uVar, boolean z) {
        int i = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            a(pVar, cVar);
        }
        int i2 = cVar.c + cVar.h;
        b bVar = this.g;
        while (true) {
            if ((!cVar.l && i2 <= 0) || !cVar.a(uVar)) {
                break;
            }
            bVar.a();
            a(pVar, uVar, cVar, bVar);
            if (!bVar.f1011b) {
                cVar.f1013b += bVar.f1010a * cVar.f;
                if (!bVar.c || this.f1006a.k != null || !uVar.a()) {
                    cVar.c -= bVar.f1010a;
                    i2 -= bVar.f1010a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.f1010a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    a(pVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    void a(RecyclerView.p pVar, RecyclerView.u uVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int iB;
        int iF;
        View viewA = cVar.a(pVar);
        if (viewA == null) {
            bVar.f1011b = true;
            return;
        }
        RecyclerView.j jVar = (RecyclerView.j) viewA.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f == -1)) {
                b(viewA);
            } else {
                b(viewA, 0);
            }
        } else {
            if (this.k == (cVar.f == -1)) {
                a(viewA);
            } else {
                a(viewA, 0);
            }
        }
        a(viewA, 0, 0);
        bVar.f1010a = this.j.e(viewA);
        if (this.i == 1) {
            if (h()) {
                iF = z() - D();
                iB = iF - this.j.f(viewA);
            } else {
                iB = B();
                iF = this.j.f(viewA) + iB;
            }
            if (cVar.f == -1) {
                int i4 = cVar.f1013b;
                i2 = cVar.f1013b - bVar.f1010a;
                i = iF;
                i3 = i4;
            } else {
                int i5 = cVar.f1013b;
                i3 = cVar.f1013b + bVar.f1010a;
                i = iF;
                i2 = i5;
            }
        } else {
            int iC = C();
            int iF2 = this.j.f(viewA) + iC;
            if (cVar.f == -1) {
                i2 = iC;
                i = cVar.f1013b;
                i3 = iF2;
                iB = cVar.f1013b - bVar.f1010a;
            } else {
                int i6 = cVar.f1013b;
                i = cVar.f1013b + bVar.f1010a;
                i2 = iC;
                i3 = iF2;
                iB = i6;
            }
        }
        a(viewA, iB, i2, i, i3);
        if (jVar.d() || jVar.e()) {
            bVar.c = true;
        }
        bVar.d = viewA.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    boolean l() {
        return (y() == 1073741824 || x() == 1073741824 || !K()) ? false : true;
    }

    int f(int i) {
        if (i == 17) {
            return this.i == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.i == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.i == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.i == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.i != 1 && h()) ? 1 : -1;
            case 2:
                return (this.i != 1 && h()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View M() {
        return i(this.k ? w() - 1 : 0);
    }

    private View N() {
        return i(this.k ? 0 : w() - 1);
    }

    private View a(boolean z, boolean z2) {
        if (this.k) {
            return a(w() - 1, -1, z, z2);
        }
        return a(0, w(), z, z2);
    }

    private View b(boolean z, boolean z2) {
        if (this.k) {
            return a(0, w(), z, z2);
        }
        return a(w() - 1, -1, z, z2);
    }

    private View f(RecyclerView.p pVar, RecyclerView.u uVar) {
        return this.k ? h(pVar, uVar) : i(pVar, uVar);
    }

    private View g(RecyclerView.p pVar, RecyclerView.u uVar) {
        return this.k ? i(pVar, uVar) : h(pVar, uVar);
    }

    private View h(RecyclerView.p pVar, RecyclerView.u uVar) {
        return a(pVar, uVar, 0, w(), uVar.e());
    }

    private View i(RecyclerView.p pVar, RecyclerView.u uVar) {
        return a(pVar, uVar, w() - 1, -1, uVar.e());
    }

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
            if (iD2 >= 0 && iD2 < i3) {
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

    private View j(RecyclerView.p pVar, RecyclerView.u uVar) {
        return this.k ? l(pVar, uVar) : m(pVar, uVar);
    }

    private View k(RecyclerView.p pVar, RecyclerView.u uVar) {
        return this.k ? m(pVar, uVar) : l(pVar, uVar);
    }

    private View l(RecyclerView.p pVar, RecyclerView.u uVar) {
        return b(0, w());
    }

    private View m(RecyclerView.p pVar, RecyclerView.u uVar) {
        return b(w() - 1, -1);
    }

    public int m() {
        View viewA = a(0, w(), false, true);
        if (viewA == null) {
            return -1;
        }
        return d(viewA);
    }

    public int n() {
        View viewA = a(w() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return d(viewA);
    }

    public int o() {
        View viewA = a(w() - 1, -1, true, false);
        if (viewA == null) {
            return -1;
        }
        return d(viewA);
    }

    View a(int i, int i2, boolean z, boolean z2) {
        i();
        int i3 = ModuleDescriptor.MODULE_VERSION;
        int i4 = z ? 24579 : ModuleDescriptor.MODULE_VERSION;
        if (!z2) {
            i3 = 0;
        }
        if (this.i == 0) {
            return this.r.a(i, i2, i4, i3);
        }
        return this.s.a(i, i2, i4, i3);
    }

    View b(int i, int i2) {
        int i3;
        int i4;
        i();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return i(i);
        }
        if (this.j.a(i(i)) < this.j.c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.i == 0) {
            return this.r.a(i, i2, i3, i4);
        }
        return this.s.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        int iF;
        View viewJ;
        View viewN;
        L();
        if (w() == 0 || (iF = f(i)) == Integer.MIN_VALUE) {
            return null;
        }
        i();
        i();
        a(iF, (int) (this.j.f() * 0.33333334f), false, uVar);
        this.f1006a.g = Integer.MIN_VALUE;
        this.f1006a.f1012a = false;
        a(pVar, this.f1006a, uVar, true);
        if (iF == -1) {
            viewJ = k(pVar, uVar);
        } else {
            viewJ = j(pVar, uVar);
        }
        if (iF == -1) {
            viewN = M();
        } else {
            viewN = N();
        }
        if (!viewN.hasFocusable()) {
            return viewJ;
        }
        if (viewJ == null) {
            return null;
        }
        return viewN;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.n == null && this.f1007b == this.d;
    }

    static class c {

        /* renamed from: b, reason: collision with root package name */
        int f1013b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int j;
        boolean l;

        /* renamed from: a, reason: collision with root package name */
        boolean f1012a = true;
        int h = 0;
        boolean i = false;
        List<RecyclerView.x> k = null;

        c() {
        }

        boolean a(RecyclerView.u uVar) {
            return this.d >= 0 && this.d < uVar.e();
        }

        View a(RecyclerView.p pVar) {
            if (this.k != null) {
                return b();
            }
            View viewC = pVar.c(this.d);
            this.d += this.e;
            return viewC;
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).f1052a;
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (!jVar.d() && this.d == jVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View viewB = b(view);
            if (viewB == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.j) viewB.getLayoutParams()).f();
            }
        }

        public View b(View view) {
            int iF;
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.k.get(i2).f1052a;
                RecyclerView.j jVar = (RecyclerView.j) view3.getLayoutParams();
                if (view3 != view && !jVar.d() && (iF = (jVar.f() - this.d) * this.e) >= 0 && iF < i) {
                    if (iF == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = iF;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.d.1
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
        int f1014a;

        /* renamed from: b, reason: collision with root package name */
        int f1015b;
        boolean c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f1014a = parcel.readInt();
            this.f1015b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f1014a = dVar.f1014a;
            this.f1015b = dVar.f1015b;
            this.c = dVar.c;
        }

        boolean a() {
            return this.f1014a >= 0;
        }

        void b() {
            this.f1014a = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1014a);
            parcel.writeInt(this.f1015b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    static class a {

        /* renamed from: a, reason: collision with root package name */
        l f1008a;

        /* renamed from: b, reason: collision with root package name */
        int f1009b;
        int c;
        boolean d;
        boolean e;

        a() {
            a();
        }

        void a() {
            this.f1009b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        void b() {
            int iC;
            if (this.d) {
                iC = this.f1008a.d();
            } else {
                iC = this.f1008a.c();
            }
            this.c = iC;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1009b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        boolean a(View view, RecyclerView.u uVar) {
            RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
            return !jVar.d() && jVar.f() >= 0 && jVar.f() < uVar.e();
        }

        public void a(View view, int i) {
            int iB = this.f1008a.b();
            if (iB >= 0) {
                b(view, i);
                return;
            }
            this.f1009b = i;
            if (this.d) {
                int iD = (this.f1008a.d() - iB) - this.f1008a.b(view);
                this.c = this.f1008a.d() - iD;
                if (iD > 0) {
                    int iE = this.c - this.f1008a.e(view);
                    int iC = this.f1008a.c();
                    int iMin = iE - (iC + Math.min(this.f1008a.a(view) - iC, 0));
                    if (iMin < 0) {
                        this.c += Math.min(iD, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iA = this.f1008a.a(view);
            int iC2 = iA - this.f1008a.c();
            this.c = iA;
            if (iC2 > 0) {
                int iD2 = (this.f1008a.d() - Math.min(0, (this.f1008a.d() - iB) - this.f1008a.b(view))) - (iA + this.f1008a.e(view));
                if (iD2 < 0) {
                    this.c -= Math.min(iC2, -iD2);
                }
            }
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.f1008a.b(view) + this.f1008a.b();
            } else {
                this.c = this.f1008a.a(view);
            }
            this.f1009b = i;
        }
    }

    protected static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f1010a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1011b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.f1010a = 0;
            this.f1011b = false;
            this.c = false;
            this.d = false;
        }
    }
}
