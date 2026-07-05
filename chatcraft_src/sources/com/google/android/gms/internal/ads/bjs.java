package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bjs {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2743a;

    public final synchronized boolean a() {
        if (this.f2743a) {
            return false;
        }
        this.f2743a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean b() {
        boolean z;
        z = this.f2743a;
        this.f2743a = false;
        return z;
    }

    public final synchronized void c() {
        while (!this.f2743a) {
            wait();
        }
    }
}
