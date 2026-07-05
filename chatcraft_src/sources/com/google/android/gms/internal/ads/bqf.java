package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;

@qj
/* loaded from: classes.dex */
public final class bqf extends RemoteCreator<brq> {
    public bqf() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final brn a(Context context, String str, kk kkVar) {
        try {
            IBinder iBinderA = a(context).a(com.google.android.gms.dynamic.b.a(context), str, kkVar, 14300000);
            if (iBinderA == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (iInterfaceQueryLocalInterface instanceof brn) {
                return (brn) iInterfaceQueryLocalInterface;
            }
            return new brp(iBinderA);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            aan.c("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ brq a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (iInterfaceQueryLocalInterface instanceof brq) {
            return (brq) iInterfaceQueryLocalInterface;
        }
        return new brr(iBinder);
    }
}
