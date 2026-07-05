package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.b;

@qj
/* loaded from: classes.dex */
public final class rg extends rc implements b.a, b.InterfaceC0066b {

    /* renamed from: a, reason: collision with root package name */
    private Context f3420a;

    /* renamed from: b, reason: collision with root package name */
    private aar f3421b;
    private abx<ri> c;
    private yi d;
    private final ra e;
    private final Object f;
    private rh g;

    public rg(Context context, aar aarVar, abx<ri> abxVar, ra raVar) {
        super(abxVar, raVar);
        this.f = new Object();
        this.f3420a = context;
        this.f3421b = aarVar;
        this.c = abxVar;
        this.e = raVar;
        this.g = new rh(context, com.google.android.gms.ads.internal.ax.u().a(), this, this);
        this.g.e();
    }

    @Override // com.google.android.gms.internal.ads.rc
    public final rq d() {
        rq rqVarT;
        synchronized (this.f) {
            try {
                try {
                    rqVarT = this.g.t();
                } catch (DeadObjectException | IllegalStateException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return rqVarT;
    }

    @Override // com.google.android.gms.internal.ads.rc
    public final void a() {
        synchronized (this.f) {
            if (this.g.f() || this.g.g()) {
                this.g.h();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.b.InterfaceC0066b
    public final void a(com.google.android.gms.common.b bVar) {
        xe.b("Cannot connect to remote service, fallback to local instance.");
        this.d = new rf(this.f3420a, this.c, this.e);
        this.d.c();
        Bundle bundle = new Bundle();
        bundle.putString("action", "gms_connection_failed_fallback_to_local");
        com.google.android.gms.ads.internal.ax.e().b(this.f3420a, this.f3421b.f1790a, "gmob-apps", bundle, true);
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(Bundle bundle) {
        c();
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(int i) {
        xe.b("Disconnected from remote ad request service.");
    }
}
