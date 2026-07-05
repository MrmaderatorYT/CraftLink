package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;

@qj
/* loaded from: classes.dex */
public final class nl extends RemoteCreator<np> {
    public nl() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final nm a(Activity activity) {
        try {
            IBinder iBinderA = a((Context) activity).a(com.google.android.gms.dynamic.b.a(activity));
            if (iBinderA == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (iInterfaceQueryLocalInterface instanceof nm) {
                return (nm) iInterfaceQueryLocalInterface;
            }
            return new no(iBinderA);
        } catch (RemoteException e) {
            aan.c("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            aan.c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ np a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (iInterfaceQueryLocalInterface instanceof np) {
            return (np) iInterfaceQueryLocalInterface;
        }
        return new nq(iBinder);
    }
}
