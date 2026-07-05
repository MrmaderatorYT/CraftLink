package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class bcd implements a {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f2513a;

    public bcd(Handler handler) {
        this.f2513a = new bde(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.a
    public final void a(blc<?> blcVar, brg<?> brgVar) {
        a(blcVar, brgVar, null);
    }

    @Override // com.google.android.gms.internal.ads.a
    public final void a(blc<?> blcVar, brg<?> brgVar, Runnable runnable) {
        blcVar.l();
        blcVar.b("post-response");
        this.f2513a.execute(new bee(blcVar, brgVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.a
    public final void a(blc<?> blcVar, zzae zzaeVar) {
        blcVar.b("post-error");
        this.f2513a.execute(new bee(blcVar, brg.a(zzaeVar), null));
    }
}
