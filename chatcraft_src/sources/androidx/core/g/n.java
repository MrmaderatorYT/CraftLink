package androidx.core.g;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f636a;

    /* renamed from: b, reason: collision with root package name */
    private int f637b;

    public n(ViewGroup viewGroup) {
        this.f636a = viewGroup;
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        this.f637b = i;
    }

    public int a() {
        return this.f637b;
    }

    public void a(View view, int i) {
        this.f637b = 0;
    }
}
