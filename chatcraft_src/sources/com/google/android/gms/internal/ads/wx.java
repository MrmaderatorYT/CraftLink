package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class wx {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3565a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f3566b;

    @GuardedBy("mLock")
    private int c;
    private final wy d;
    private final String e;

    public wx(String str) {
        this(com.google.android.gms.ads.internal.ax.i().n(), str);
    }

    private wx(wy wyVar, String str) {
        this.f3565a = new Object();
        this.d = wyVar;
        this.e = str;
    }

    public final void a(int i, int i2) {
        synchronized (this.f3565a) {
            this.f3566b = i;
            this.c = i2;
            this.d.a(this);
        }
    }

    public final String a() {
        return this.e;
    }

    public final Bundle b() {
        Bundle bundle;
        synchronized (this.f3565a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f3566b);
            bundle.putInt("pmnll", this.c);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        wx wxVar = (wx) obj;
        return this.e != null ? this.e.equals(wxVar.e) : wxVar.e == null;
    }

    public final int hashCode() {
        if (this.e != null) {
            return this.e.hashCode();
        }
        return 0;
    }
}
