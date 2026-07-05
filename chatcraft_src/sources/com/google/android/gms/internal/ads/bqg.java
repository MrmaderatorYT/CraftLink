package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;

@qj
/* loaded from: classes.dex */
public final class bqg extends RemoteCreator<brv> {
    public bqg() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final brs a(Context context, bqn bqnVar, String str, kk kkVar, int i) {
        try {
            IBinder iBinderA = a(context).a(com.google.android.gms.dynamic.b.a(context), bqnVar, str, kkVar, 14300000, i);
            if (iBinderA == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface instanceof brs) {
                return (brs) iInterfaceQueryLocalInterface;
            }
            return new bru(iBinderA);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            aan.a("Could not create remote AdManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ brv a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (iInterfaceQueryLocalInterface instanceof brv) {
            return (brv) iInterfaceQueryLocalInterface;
        }
        return new brw(iBinder);
    }
}
