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
public final class cu extends com.google.android.gms.ads.b.g {

    /* renamed from: a, reason: collision with root package name */
    private final cr f3047a;
    private final cg c;
    private final c.a e;

    /* renamed from: b, reason: collision with root package name */
    private final List<c.b> f3048b = new ArrayList();
    private final com.google.android.gms.ads.j d = new com.google.android.gms.ads.j();

    public cu(cr crVar) {
        cd cdVarH;
        cd cfVar;
        IBinder iBinder;
        this.f3047a = crVar;
        cc ccVar = null;
        try {
            List listF = this.f3047a.f();
            if (listF != null) {
                for (Object obj : listF) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        cfVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        cfVar = iInterfaceQueryLocalInterface instanceof cd ? (cd) iInterfaceQueryLocalInterface : new cf(iBinder);
                    }
                    if (cfVar != null) {
                        this.f3048b.add(new cg(cfVar));
                    }
                }
            }
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
        try {
            cdVarH = this.f3047a.h();
        } catch (RemoteException e2) {
            aan.b(BuildConfig.FLAVOR, e2);
        }
        cg cgVar = cdVarH != null ? new cg(cdVarH) : null;
        this.c = cgVar;
        try {
            if (this.f3047a.r() != null) {
                ccVar = new cc(this.f3047a.r());
            }
        } catch (RemoteException e3) {
            aan.b(BuildConfig.FLAVOR, e3);
        }
        this.e = ccVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.b.c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final com.google.android.gms.dynamic.a a() {
        try {
            return this.f3047a.n();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.g
    public final CharSequence b() {
        try {
            return this.f3047a.e();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.g
    public final List<c.b> c() {
        return this.f3048b;
    }

    @Override // com.google.android.gms.ads.b.g
    public final CharSequence d() {
        try {
            return this.f3047a.g();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.g
    public final c.b e() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.b.g
    public final CharSequence f() {
        try {
            return this.f3047a.i();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.g
    public final Double g() {
        try {
            double dJ = this.f3047a.j();
            if (dJ == -1.0d) {
                return null;
            }
            return Double.valueOf(dJ);
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.g
    public final CharSequence h() {
        try {
            return this.f3047a.k();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.g
    public final CharSequence i() {
        try {
            return this.f3047a.l();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.b.g
    public final com.google.android.gms.ads.j j() {
        try {
            if (this.f3047a.m() != null) {
                this.d.a(this.f3047a.m());
            }
        } catch (RemoteException e) {
            aan.b("Exception occurred while getting video controller", e);
        }
        return this.d;
    }
}
