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
public final class ea extends com.google.android.gms.ads.b.k {

    /* renamed from: a, reason: collision with root package name */
    private final dx f3055a;
    private final cg c;
    private final c.a e;

    /* renamed from: b, reason: collision with root package name */
    private final List<c.b> f3056b = new ArrayList();
    private final com.google.android.gms.ads.j d = new com.google.android.gms.ads.j();
    private final List<Object> f = new ArrayList();

    public ea(dx dxVar) {
        cd cdVarJ;
        cd cfVar;
        IBinder iBinder;
        this.f3055a = dxVar;
        cc ccVar = null;
        try {
            List listF = this.f3055a.f();
            if (listF != null) {
                for (Object obj : listF) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        cfVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        cfVar = iInterfaceQueryLocalInterface instanceof cd ? (cd) iInterfaceQueryLocalInterface : new cf(iBinder);
                    }
                    if (cfVar != null) {
                        this.f3056b.add(new cg(cfVar));
                    }
                }
            }
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
        try {
            List listG = this.f3055a.g();
            if (listG != null) {
                for (Object obj2 : listG) {
                    bss bssVarA = obj2 instanceof IBinder ? bst.a((IBinder) obj2) : null;
                    if (bssVarA != null) {
                        this.f.add(new bsv(bssVarA));
                    }
                }
            }
        } catch (RemoteException e2) {
            aan.b(BuildConfig.FLAVOR, e2);
        }
        try {
            cdVarJ = this.f3055a.j();
        } catch (RemoteException e3) {
            aan.b(BuildConfig.FLAVOR, e3);
        }
        cg cgVar = cdVarJ != null ? new cg(cdVarJ) : null;
        this.c = cgVar;
        try {
            if (this.f3055a.u() != null) {
                ccVar = new cc(this.f3055a.u());
            }
        } catch (RemoteException e4) {
            aan.b(BuildConfig.FLAVOR, e4);
        }
        this.e = ccVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.b.k
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final com.google.android.gms.dynamic.a k() {
        try {
            return this.f3055a.q();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final Object l() {
        try {
            com.google.android.gms.dynamic.a aVarR = this.f3055a.r();
            if (aVarR != null) {
                return com.google.android.gms.dynamic.b.a(aVarR);
            }
            return null;
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final String a() {
        try {
            return this.f3055a.e();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final List<c.b> b() {
        return this.f3056b;
    }

    @Override // com.google.android.gms.ads.b.k
    public final String c() {
        try {
            return this.f3055a.i();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final c.b d() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.b.k
    public final String e() {
        try {
            return this.f3055a.k();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final Double g() {
        try {
            double dM = this.f3055a.m();
            if (dM == -1.0d) {
                return null;
            }
            return Double.valueOf(dM);
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final String h() {
        try {
            return this.f3055a.n();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final String i() {
        try {
            return this.f3055a.o();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.k
    public final com.google.android.gms.ads.j j() {
        try {
            if (this.f3055a.p() != null) {
                this.d.a(this.f3055a.p());
            }
        } catch (RemoteException e) {
            aan.b("Exception occurred while getting video controller", e);
        }
        return this.d;
    }

    @Override // com.google.android.gms.ads.b.k
    public final String f() {
        try {
            return this.f3055a.l();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }
}
