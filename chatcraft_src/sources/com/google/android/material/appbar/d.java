package com.google.android.material.appbar;

import android.view.View;
import androidx.core.g.q;

/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final View f3737a;

    /* renamed from: b, reason: collision with root package name */
    private int f3738b;
    private int c;
    private int d;
    private int e;

    public d(View view) {
        this.f3737a = view;
    }

    public void a() {
        this.f3738b = this.f3737a.getTop();
        this.c = this.f3737a.getLeft();
        c();
    }

    private void c() {
        q.e(this.f3737a, this.d - (this.f3737a.getTop() - this.f3738b));
        q.f(this.f3737a, this.e - (this.f3737a.getLeft() - this.c));
    }

    public boolean a(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        c();
        return true;
    }

    public boolean b(int i) {
        if (this.e == i) {
            return false;
        }
        this.e = i;
        c();
        return true;
    }

    public int b() {
        return this.d;
    }
}
