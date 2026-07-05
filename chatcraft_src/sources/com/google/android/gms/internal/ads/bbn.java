package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class bbn {

    /* renamed from: a, reason: collision with root package name */
    private int f2495a;

    public void a() {
        this.f2495a = 0;
    }

    public final boolean b() {
        return c(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return c(4);
    }

    public final boolean d() {
        return c(1);
    }

    public final void a(int i) {
        this.f2495a = i;
    }

    public final void b(int i) {
        this.f2495a |= Integer.MIN_VALUE;
    }

    protected final boolean c(int i) {
        return (this.f2495a & i) == i;
    }
}
