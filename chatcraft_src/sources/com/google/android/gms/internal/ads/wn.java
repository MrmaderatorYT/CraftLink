package com.google.android.gms.internal.ads;

import android.os.Bundle;

@qj
/* loaded from: classes.dex */
final class wn {

    /* renamed from: a, reason: collision with root package name */
    private long f3549a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f3550b = -1;
    private final /* synthetic */ wm c;

    public wn(wm wmVar) {
        this.c = wmVar;
    }

    public final long a() {
        return this.f3550b;
    }

    public final void b() {
        this.f3550b = this.c.f3547a.b();
    }

    public final void c() {
        this.f3549a = this.c.f3547a.b();
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.f3549a);
        bundle.putLong("tclose", this.f3550b);
        return bundle;
    }
}
