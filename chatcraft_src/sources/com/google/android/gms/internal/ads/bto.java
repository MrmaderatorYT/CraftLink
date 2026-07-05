package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;

@qj
/* loaded from: classes.dex */
public final class bto extends RemoteCreator<bsn> {
    public bto() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final bsk b(Context context) {
        try {
            IBinder iBinderA = a(context).a(com.google.android.gms.dynamic.b.a(context), 14300000);
            if (iBinderA == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (iInterfaceQueryLocalInterface instanceof bsk) {
                return (bsk) iInterfaceQueryLocalInterface;
            }
            return new bsm(iBinderA);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            aan.c("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ bsn a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (iInterfaceQueryLocalInterface instanceof bsn) {
            return (bsn) iInterfaceQueryLocalInterface;
        }
        return new bso(iBinder);
    }
}
