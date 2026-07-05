package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public abstract class xa implements yi<abl> {

    /* renamed from: b, reason: collision with root package name */
    private volatile Thread f3571b;

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f3570a = new xb(this);
    private boolean c = false;

    public xa() {
    }

    public abstract void a();

    public abstract void c_();

    public xa(boolean z) {
    }

    public final abl h() {
        if (this.c) {
            return xl.f3580b.a(this.f3570a);
        }
        return xl.a(this.f3570a);
    }

    @Override // com.google.android.gms.internal.ads.yi
    public final void b() {
        c_();
        if (this.f3571b != null) {
            this.f3571b.interrupt();
        }
    }

    @Override // com.google.android.gms.internal.ads.yi
    public final /* synthetic */ abl c() {
        if (this.c) {
            return xl.f3580b.a(this.f3570a);
        }
        return xl.a(this.f3570a);
    }
}
