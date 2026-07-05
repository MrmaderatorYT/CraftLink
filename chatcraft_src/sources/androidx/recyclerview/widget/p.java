package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    final b f1130a;

    /* renamed from: b, reason: collision with root package name */
    a f1131b = new a();

    /* compiled from: ViewBoundsCheck.java */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    p(b bVar) {
        this.f1130a = bVar;
    }

    /* compiled from: ViewBoundsCheck.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f1132a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f1133b;
        int c;
        int d;
        int e;

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        void a(int i, int i2, int i3, int i4) {
            this.f1133b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        void a(int i) {
            this.f1132a = i | this.f1132a;
        }

        void a() {
            this.f1132a = 0;
        }

        boolean b() {
            if ((this.f1132a & 7) != 0 && (this.f1132a & (a(this.d, this.f1133b) << 0)) == 0) {
                return false;
            }
            if ((this.f1132a & 112) != 0 && (this.f1132a & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            if ((this.f1132a & 1792) == 0 || (this.f1132a & (a(this.e, this.f1133b) << 8)) != 0) {
                return (this.f1132a & 28672) == 0 || (this.f1132a & (a(this.e, this.c) << 12)) != 0;
            }
            return false;
        }
    }

    View a(int i, int i2, int i3, int i4) {
        int iA = this.f1130a.a();
        int iB = this.f1130a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewA = this.f1130a.a(i);
            this.f1131b.a(iA, iB, this.f1130a.a(viewA), this.f1130a.b(viewA));
            if (i3 != 0) {
                this.f1131b.a();
                this.f1131b.a(i3);
                if (this.f1131b.b()) {
                    return viewA;
                }
            }
            if (i4 != 0) {
                this.f1131b.a();
                this.f1131b.a(i4);
                if (this.f1131b.b()) {
                    view = viewA;
                }
            }
            i += i5;
        }
        return view;
    }

    boolean a(View view, int i) {
        this.f1131b.a(this.f1130a.a(), this.f1130a.b(), this.f1130a.a(view), this.f1130a.b(view));
        if (i == 0) {
            return false;
        }
        this.f1131b.a();
        this.f1131b.a(i);
        return this.f1131b.b();
    }
}
