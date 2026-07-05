package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class nn extends azg implements nm {
    public nn() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static nm a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (iInterfaceQueryLocalInterface instanceof nm) {
            return (nm) iInterfaceQueryLocalInterface;
        }
        return new no(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                a((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                f();
                parcel2.writeNoException();
                return true;
            case 3:
                g();
                parcel2.writeNoException();
                return true;
            case 4:
                h();
                parcel2.writeNoException();
                return true;
            case 5:
                i();
                parcel2.writeNoException();
                return true;
            case 6:
                Bundle bundle = (Bundle) azh.a(parcel, Bundle.CREATOR);
                b(bundle);
                parcel2.writeNoException();
                azh.b(parcel2, bundle);
                return true;
            case 7:
                j();
                parcel2.writeNoException();
                return true;
            case 8:
                k();
                parcel2.writeNoException();
                return true;
            case 9:
                l();
                parcel2.writeNoException();
                return true;
            case 10:
                d();
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zE = e();
                parcel2.writeNoException();
                azh.a(parcel2, zE);
                return true;
            case 12:
                a(parcel.readInt(), parcel.readInt(), (Intent) azh.a(parcel, Intent.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
