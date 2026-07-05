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
public final class cc extends c.a {

    /* renamed from: a, reason: collision with root package name */
    private final bz f3043a;

    /* renamed from: b, reason: collision with root package name */
    private final List<c.b> f3044b = new ArrayList();
    private String c;

    public cc(bz bzVar) {
        cd cfVar;
        IBinder iBinder;
        this.f3043a = bzVar;
        try {
            this.c = this.f3043a.a();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            this.c = BuildConfig.FLAVOR;
        }
        try {
            for (cd cdVar : bzVar.b()) {
                if (!(cdVar instanceof IBinder) || (iBinder = (IBinder) cdVar) == null) {
                    cfVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    cfVar = iInterfaceQueryLocalInterface instanceof cd ? (cd) iInterfaceQueryLocalInterface : new cf(iBinder);
                }
                if (cfVar != null) {
                    this.f3044b.add(new cg(cfVar));
                }
            }
        } catch (RemoteException e2) {
            aan.b(BuildConfig.FLAVOR, e2);
        }
    }
}
