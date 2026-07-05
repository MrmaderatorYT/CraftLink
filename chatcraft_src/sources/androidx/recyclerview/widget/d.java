package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    final b f1076a;

    /* renamed from: b, reason: collision with root package name */
    final a f1077b = new a();
    final List<View> c = new ArrayList();

    /* compiled from: ChildHelper.java */
    interface b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        View b(int i);

        RecyclerView.x b(View view);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    d(b bVar) {
        this.f1076a = bVar;
    }

    private void g(View view) {
        this.c.add(view);
        this.f1076a.c(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.f1076a.d(view);
        return true;
    }

    void a(View view, boolean z) {
        a(view, -1, z);
    }

    void a(View view, int i, boolean z) {
        int iF;
        if (i < 0) {
            iF = this.f1076a.a();
        } else {
            iF = f(i);
        }
        this.f1077b.a(iF, z);
        if (z) {
            g(view);
        }
        this.f1076a.a(view, iF);
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int iA = this.f1076a.a();
        int i2 = i;
        while (i2 < iA) {
            int iE = i - (i2 - this.f1077b.e(i2));
            if (iE == 0) {
                while (this.f1077b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iE;
        }
        return -1;
    }

    void a(View view) {
        int iA = this.f1076a.a(view);
        if (iA < 0) {
            return;
        }
        if (this.f1077b.d(iA)) {
            h(view);
        }
        this.f1076a.a(iA);
    }

    void a(int i) {
        int iF = f(i);
        View viewB = this.f1076a.b(iF);
        if (viewB == null) {
            return;
        }
        if (this.f1077b.d(iF)) {
            h(viewB);
        }
        this.f1076a.a(iF);
    }

    View b(int i) {
        return this.f1076a.b(f(i));
    }

    void a() {
        this.f1077b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.f1076a.d(this.c.get(size));
            this.c.remove(size);
        }
        this.f1076a.b();
    }

    View c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.x xVarB = this.f1076a.b(view);
            if (xVarB.f() == i && !xVarB.p() && !xVarB.s()) {
                return view;
            }
        }
        return null;
    }

    void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iF;
        if (i < 0) {
            iF = this.f1076a.a();
        } else {
            iF = f(i);
        }
        this.f1077b.a(iF, z);
        if (z) {
            g(view);
        }
        this.f1076a.a(view, iF, layoutParams);
    }

    int b() {
        return this.f1076a.a() - this.c.size();
    }

    int c() {
        return this.f1076a.a();
    }

    View d(int i) {
        return this.f1076a.b(i);
    }

    void e(int i) {
        int iF = f(i);
        this.f1077b.d(iF);
        this.f1076a.c(iF);
    }

    int b(View view) {
        int iA = this.f1076a.a(view);
        if (iA == -1 || this.f1077b.c(iA)) {
            return -1;
        }
        return iA - this.f1077b.e(iA);
    }

    boolean c(View view) {
        return this.c.contains(view);
    }

    void d(View view) {
        int iA = this.f1076a.a(view);
        if (iA < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f1077b.a(iA);
        g(view);
    }

    void e(View view) {
        int iA = this.f1076a.a(view);
        if (iA < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.f1077b.c(iA)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.f1077b.b(iA);
        h(view);
    }

    public String toString() {
        return this.f1077b.toString() + ", hidden list:" + this.c.size();
    }

    boolean f(View view) {
        int iA = this.f1076a.a(view);
        if (iA == -1) {
            h(view);
            return true;
        }
        if (!this.f1077b.c(iA)) {
            return false;
        }
        this.f1077b.d(iA);
        h(view);
        this.f1076a.a(iA);
        return true;
    }

    /* compiled from: ChildHelper.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        long f1078a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f1079b;

        a() {
        }

        void a(int i) {
            if (i >= 64) {
                b();
                this.f1079b.a(i - 64);
            } else {
                this.f1078a |= 1 << i;
            }
        }

        private void b() {
            if (this.f1079b == null) {
                this.f1079b = new a();
            }
        }

        void b(int i) {
            if (i >= 64) {
                if (this.f1079b != null) {
                    this.f1079b.b(i - 64);
                    return;
                }
                return;
            }
            this.f1078a &= (1 << i) ^ (-1);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f1078a & (1 << i)) != 0;
            }
            b();
            return this.f1079b.c(i - 64);
        }

        void a() {
            this.f1078a = 0L;
            if (this.f1079b != null) {
                this.f1079b.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f1079b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f1078a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f1078a = (this.f1078a & j) | (((j ^ (-1)) & this.f1078a) << 1);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.f1079b != null) {
                b();
                this.f1079b.a(0, z2);
            }
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f1079b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1078a & j) != 0;
            this.f1078a &= j ^ (-1);
            long j2 = j - 1;
            this.f1078a = (this.f1078a & j2) | Long.rotateRight((j2 ^ (-1)) & this.f1078a, 1);
            if (this.f1079b != null) {
                if (this.f1079b.c(0)) {
                    a(63);
                }
                this.f1079b.d(0);
            }
            return z;
        }

        int e(int i) {
            if (this.f1079b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f1078a);
                }
                return Long.bitCount(this.f1078a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.f1078a & ((1 << i) - 1));
            }
            return this.f1079b.e(i - 64) + Long.bitCount(this.f1078a);
        }

        public String toString() {
            if (this.f1079b == null) {
                return Long.toBinaryString(this.f1078a);
            }
            return this.f1079b.toString() + "xx" + Long.toBinaryString(this.f1078a);
        }
    }
}
