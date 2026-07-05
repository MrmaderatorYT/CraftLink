package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class il extends acb<iu> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3172a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ip f3173b;
    private boolean c;

    public il(ip ipVar) {
        this.f3173b = ipVar;
    }

    public final void a() {
        synchronized (this.f3172a) {
            if (this.c) {
                return;
            }
            this.c = true;
            a(new im(this), new abz());
            a(new in(this), new io(this));
        }
    }
}
