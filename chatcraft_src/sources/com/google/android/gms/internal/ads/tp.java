package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class tp extends tz {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3481a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3482b;
    private final aar c;

    @GuardedBy("mLock")
    private final tq d;

    public tp(Context context, com.google.android.gms.ads.internal.bt btVar, kk kkVar, aar aarVar) {
        this(context, aarVar, new tq(context, btVar, bqn.a(), kkVar, aarVar));
    }

    private tp(Context context, aar aarVar, tq tqVar) {
        this.f3482b = new Object();
        this.f3481a = context;
        this.c = aarVar;
        this.d = tqVar;
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(String str) throws RemoteException {
        if (this.f3481a instanceof to) {
            try {
                ((to) this.f3481a).a(str);
            } catch (PackageManager.NameNotFoundException unused) {
                if (Build.VERSION.SDK_INT > 15) {
                    throw new RemoteException(PackageManager.NameNotFoundException.class.getSimpleName());
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(uk ukVar) {
        synchronized (this.f3482b) {
            this.d.a(ukVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a() {
        synchronized (this.f3482b) {
            this.d.J();
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final synchronized void a(com.google.android.gms.dynamic.a aVar) {
        if (this.f3481a instanceof to) {
            ((to) this.f3481a).a((Activity) com.google.android.gms.dynamic.b.a(aVar));
        }
        a();
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(ue ueVar) {
        synchronized (this.f3482b) {
            this.d.a(ueVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(tw twVar) {
        synchronized (this.f3482b) {
            this.d.a(twVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(brx brxVar) {
        if (((Boolean) bra.e().a(o.as)).booleanValue()) {
            synchronized (this.f3482b) {
                this.d.a(brxVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final Bundle b() {
        Bundle bundleQ;
        if (((Boolean) bra.e().a(o.as)).booleanValue()) {
            synchronized (this.f3482b) {
                bundleQ = this.d.q();
            }
            return bundleQ;
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void b(String str) {
        synchronized (this.f3482b) {
            this.d.a(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void c(String str) {
        if (((Boolean) bra.e().a(o.at)).booleanValue()) {
            synchronized (this.f3482b) {
                this.d.b(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final boolean c() {
        boolean zK;
        synchronized (this.f3482b) {
            zK = this.d.K();
        }
        return zK;
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void d() {
        b((com.google.android.gms.dynamic.a) null);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void b(com.google.android.gms.dynamic.a aVar) {
        synchronized (this.f3482b) {
            this.d.o();
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void e() {
        c((com.google.android.gms.dynamic.a) null);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void c(com.google.android.gms.dynamic.a aVar) {
        Context context;
        synchronized (this.f3482b) {
            if (aVar == null) {
                context = null;
            } else {
                try {
                    context = (Context) com.google.android.gms.dynamic.b.a(aVar);
                } catch (Exception e) {
                    xe.c("Unable to extract updated context.", e);
                }
            }
            if (context != null) {
                this.d.a(context);
                this.d.p();
            } else {
                this.d.p();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void f() {
        d(null);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void d(com.google.android.gms.dynamic.a aVar) {
        synchronized (this.f3482b) {
            this.d.j();
        }
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final String g() {
        String strA;
        synchronized (this.f3482b) {
            strA = this.d.a();
        }
        return strA;
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(boolean z) {
        synchronized (this.f3482b) {
            this.d.c(z);
        }
    }
}
