package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.i f1127a;

    /* renamed from: b, reason: collision with root package name */
    final Rect f1128b;
    private int c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    private l(RecyclerView.i iVar) {
        this.c = Integer.MIN_VALUE;
        this.f1128b = new Rect();
        this.f1127a = iVar;
    }

    public void a() {
        this.c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE == this.c) {
            return 0;
        }
        return f() - this.c;
    }

    public static l a(RecyclerView.i iVar, int i) {
        switch (i) {
            case 0:
                return a(iVar);
            case 1:
                return b(iVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static l a(RecyclerView.i iVar) {
        return new l(iVar) { // from class: androidx.recyclerview.widget.l.1
            @Override // androidx.recyclerview.widget.l
            public int d() {
                return this.f1127a.z() - this.f1127a.D();
            }

            @Override // androidx.recyclerview.widget.l
            public int e() {
                return this.f1127a.z();
            }

            @Override // androidx.recyclerview.widget.l
            public void a(int i) {
                this.f1127a.j(i);
            }

            @Override // androidx.recyclerview.widget.l
            public int c() {
                return this.f1127a.B();
            }

            @Override // androidx.recyclerview.widget.l
            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1127a.f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1127a.g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int b(View view) {
                return this.f1127a.j(view) + ((RecyclerView.j) view.getLayoutParams()).rightMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int a(View view) {
                return this.f1127a.h(view) - ((RecyclerView.j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int c(View view) {
                this.f1127a.a(view, true, this.f1128b);
                return this.f1128b.right;
            }

            @Override // androidx.recyclerview.widget.l
            public int d(View view) {
                this.f1127a.a(view, true, this.f1128b);
                return this.f1128b.left;
            }

            @Override // androidx.recyclerview.widget.l
            public int f() {
                return (this.f1127a.z() - this.f1127a.B()) - this.f1127a.D();
            }

            @Override // androidx.recyclerview.widget.l
            public int g() {
                return this.f1127a.D();
            }

            @Override // androidx.recyclerview.widget.l
            public int h() {
                return this.f1127a.x();
            }

            @Override // androidx.recyclerview.widget.l
            public int i() {
                return this.f1127a.y();
            }
        };
    }

    public static l b(RecyclerView.i iVar) {
        return new l(iVar) { // from class: androidx.recyclerview.widget.l.2
            @Override // androidx.recyclerview.widget.l
            public int d() {
                return this.f1127a.A() - this.f1127a.E();
            }

            @Override // androidx.recyclerview.widget.l
            public int e() {
                return this.f1127a.A();
            }

            @Override // androidx.recyclerview.widget.l
            public void a(int i) {
                this.f1127a.k(i);
            }

            @Override // androidx.recyclerview.widget.l
            public int c() {
                return this.f1127a.C();
            }

            @Override // androidx.recyclerview.widget.l
            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1127a.g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1127a.f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int b(View view) {
                return this.f1127a.k(view) + ((RecyclerView.j) view.getLayoutParams()).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int a(View view) {
                return this.f1127a.i(view) - ((RecyclerView.j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.l
            public int c(View view) {
                this.f1127a.a(view, true, this.f1128b);
                return this.f1128b.bottom;
            }

            @Override // androidx.recyclerview.widget.l
            public int d(View view) {
                this.f1127a.a(view, true, this.f1128b);
                return this.f1128b.top;
            }

            @Override // androidx.recyclerview.widget.l
            public int f() {
                return (this.f1127a.A() - this.f1127a.C()) - this.f1127a.E();
            }

            @Override // androidx.recyclerview.widget.l
            public int g() {
                return this.f1127a.E();
            }

            @Override // androidx.recyclerview.widget.l
            public int h() {
                return this.f1127a.y();
            }

            @Override // androidx.recyclerview.widget.l
            public int i() {
                return this.f1127a.x();
            }
        };
    }
}
