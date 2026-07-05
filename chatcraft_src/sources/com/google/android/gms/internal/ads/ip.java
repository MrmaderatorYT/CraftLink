package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ip extends acb<hk> {

    /* renamed from: b, reason: collision with root package name */
    private yu<hk> f3177b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3176a = new Object();
    private boolean c = false;
    private int d = 0;

    public ip(yu<hk> yuVar) {
        this.f3177b = yuVar;
    }

    public final il a() {
        il ilVar = new il(this);
        synchronized (this.f3176a) {
            a(new iq(this, ilVar), new ir(this, ilVar));
            com.google.android.gms.common.internal.i.a(this.d >= 0);
            this.d++;
        }
        return ilVar;
    }

    protected final void b() {
        synchronized (this.f3176a) {
            com.google.android.gms.common.internal.i.a(this.d > 0);
            xe.a("Releasing 1 reference for JS Engine");
            this.d--;
            f();
        }
    }

    public final void c() {
        synchronized (this.f3176a) {
            com.google.android.gms.common.internal.i.a(this.d >= 0);
            xe.a("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.c = true;
            f();
        }
    }

    private final void f() {
        synchronized (this.f3176a) {
            com.google.android.gms.common.internal.i.a(this.d >= 0);
            if (this.c && this.d == 0) {
                xe.a("No reference is left (including root). Cleaning up engine.");
                a(new is(this), new abz());
            } else {
                xe.a("There are still references to the engine. Not destroying.");
            }
        }
    }
}
