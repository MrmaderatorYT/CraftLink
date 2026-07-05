package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class jw extends kr {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3213a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private kb f3214b;

    @GuardedBy("mLock")
    private jv c;

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(vh vhVar) {
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(String str) {
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void h() {
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void i() {
    }

    public final void a(kb kbVar) {
        synchronized (this.f3213a) {
            this.f3214b = kbVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a() {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.U();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void b() {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.Y();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(int i) {
        synchronized (this.f3213a) {
            if (this.f3214b != null) {
                this.f3214b.a(i == 3 ? 1 : 2);
                this.f3214b = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void c() {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.Z();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void d() {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.aa();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void e() {
        synchronized (this.f3213a) {
            if (this.f3214b != null) {
                this.f3214b.a(0);
                this.f3214b = null;
            } else {
                if (this.c != null) {
                    this.c.ab();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(kt ktVar) {
        synchronized (this.f3213a) {
            if (this.f3214b != null) {
                this.f3214b.a(0, ktVar);
                this.f3214b = null;
            } else {
                if (this.c != null) {
                    this.c.ab();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void f() {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.V();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(String str, String str2) {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.b(str, str2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(cz czVar, String str) {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.a(czVar, str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void g() {
        synchronized (this.f3213a) {
            if (this.c != null) {
                this.c.W();
            }
        }
    }

    public final void a(jv jvVar) {
        synchronized (this.f3213a) {
            this.c = jvVar;
        }
    }
}
