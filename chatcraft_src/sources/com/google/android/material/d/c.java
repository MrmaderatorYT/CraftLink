package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ExpandableWidgetHelper.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final View f3779a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3780b = false;
    private int c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.f3779a = (View) bVar;
    }

    public boolean a() {
        return this.f3780b;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f3780b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void a(Bundle bundle) {
        this.f3780b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f3780b) {
            d();
        }
    }

    public void a(int i) {
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    private void d() {
        ViewParent parent = this.f3779a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).b(this.f3779a);
        }
    }
}
