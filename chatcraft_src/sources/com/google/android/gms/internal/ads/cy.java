package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.b.c;
import java.util.ArrayList;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class cy extends com.google.android.gms.ads.b.h {

    /* renamed from: a, reason: collision with root package name */
    private final cv f3049a;
    private final cg c;
    private final c.a e;

    /* renamed from: b, reason: collision with root package name */
    private final List<c.b> f3050b = new ArrayList();
    private final com.google.android.gms.ads.j d = new com.google.android.gms.ads.j();

    public cy(cv cvVar) {
        cd cdVarJ;
        cd cfVar;
        IBinder iBinder;
        this.f3049a = cvVar;
        cc ccVar = null;
        try {
            List listF = this.f3049a.f();
            if (listF != null) {
                for (Object obj : listF) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        cfVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        cfVar = iInterfaceQueryLocalInterface instanceof cd ? (cd) iInterfaceQueryLocalInterface : new cf(iBinder);
                    }
                    if (cfVar != null) {
                        this.f3050b.add(new cg(cfVar));
                    }
                }
            }
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
        try {
            cdVarJ = this.f3049a.j();
        } catch (RemoteException e2) {
            aan.b(BuildConfig.FLAVOR, e2);
        }
        cg cgVar = cdVarJ != null ? new cg(cdVarJ) : null;
        this.c = cgVar;
        try {
            if (this.f3049a.p() != null) {
                ccVar = new cc(this.f3049a.p());
            }
        } catch (RemoteException e3) {
            aan.b(BuildConfig.FLAVOR, e3);
        }
        this.e = ccVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.b.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final com.google.android.gms.dynamic.a a() {
        try {
            return this.f3049a.n();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.h
    public final CharSequence b() {
        try {
            return this.f3049a.e();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.h
    public final List<c.b> c() {
        return this.f3050b;
    }

    @Override // com.google.android.gms.ads.b.h
    public final CharSequence d() {
        try {
            return this.f3049a.i();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.h
    public final c.b e() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.b.h
    public final CharSequence f() {
        try {
            return this.f3049a.k();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.h
    public final CharSequence g() {
        try {
            return this.f3049a.l();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.h
    public final com.google.android.gms.ads.j h() {
        try {
            if (this.f3049a.m() != null) {
                this.d.a(this.f3049a.m());
            }
        } catch (RemoteException e) {
            aan.b("Exception occurred while getting video controller", e);
        }
        return this.d;
    }
}
