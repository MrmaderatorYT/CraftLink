package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ViewOffsetBehavior.java */
/* loaded from: classes.dex */
class c<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a, reason: collision with root package name */
    private d f3735a;

    /* renamed from: b, reason: collision with root package name */
    private int f3736b;
    private int c;

    public c() {
        this.f3736b = 0;
        this.c = 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3736b = 0;
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, (CoordinatorLayout) v, i);
        if (this.f3735a == null) {
            this.f3735a = new d(v);
        }
        this.f3735a.a();
        if (this.f3736b != 0) {
            this.f3735a.a(this.f3736b);
            this.f3736b = 0;
        }
        if (this.c == 0) {
            return true;
        }
        this.f3735a.b(this.c);
        this.c = 0;
        return true;
    }

    protected void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.a(v, i);
    }

    public boolean a(int i) {
        if (this.f3735a != null) {
            return this.f3735a.a(i);
        }
        this.f3736b = i;
        return false;
    }

    public int c() {
        if (this.f3735a != null) {
            return this.f3735a.b();
        }
        return 0;
    }
}
