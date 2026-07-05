package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public abstract class rc implements ra, yi<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final abx<ri> f3414a;

    /* renamed from: b, reason: collision with root package name */
    private final ra f3415b;
    private final Object c = new Object();

    public rc(abx<ri> abxVar, ra raVar) {
        this.f3414a = abxVar;
        this.f3415b = raVar;
    }

    public abstract void a();

    public abstract rq d();

    @Override // com.google.android.gms.internal.ads.ra
    public final void a(rm rmVar) {
        synchronized (this.c) {
            this.f3415b.a(rmVar);
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.yi
    public final void b() {
        a();
    }

    final boolean a(rq rqVar, ri riVar) {
        try {
            rqVar.a(riVar, new rl(this));
            return true;
        } catch (Throwable th) {
            xe.c("Could not fetch ad response from ad request service due to an Exception.", th);
            com.google.android.gms.ads.internal.ax.i().a(th, "AdRequestClientTask.getAdResponseFromService");
            this.f3415b.a(new rm(0));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.yi
    public final /* synthetic */ Void c() {
        rq rqVarD = d();
        if (rqVarD == null) {
            this.f3415b.a(new rm(0));
            a();
            return null;
        }
        this.f3414a.a(new rd(this, rqVarD), new re(this));
        return null;
    }
}
