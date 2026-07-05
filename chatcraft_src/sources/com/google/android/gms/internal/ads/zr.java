package com.google.android.gms.internal.ads;

import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class zr {

    /* renamed from: a, reason: collision with root package name */
    private long f3642a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private long f3643b = Long.MIN_VALUE;
    private Object c = new Object();

    public zr(long j) {
        this.f3642a = j;
    }

    public final boolean a() {
        synchronized (this.c) {
            long jB = com.google.android.gms.ads.internal.ax.l().b();
            if (this.f3643b + this.f3642a > jB) {
                return false;
            }
            this.f3643b = jB;
            return true;
        }
    }
}
