package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;

@qj
/* loaded from: classes.dex */
public final class ui extends RemoteCreator<ub> {
    public ui() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final ty a(Context context, kk kkVar) {
        try {
            IBinder iBinderA = a(context).a(com.google.android.gms.dynamic.b.a(context), kkVar, 14300000);
            if (iBinderA == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (iInterfaceQueryLocalInterface instanceof ty) {
                return (ty) iInterfaceQueryLocalInterface;
            }
            return new ua(iBinderA);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            aan.c("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ ub a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (iInterfaceQueryLocalInterface instanceof ub) {
            return (ub) iInterfaceQueryLocalInterface;
        }
        return new ud(iBinder);
    }
}
