package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class bsx extends azg implements bsw {
    public bsx() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static bsw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (iInterfaceQueryLocalInterface instanceof bsw) {
            return (bsw) iInterfaceQueryLocalInterface;
        }
        return new bsy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        bsz btbVar;
        switch (i) {
            case 1:
                a();
                parcel2.writeNoException();
                return true;
            case 2:
                b();
                parcel2.writeNoException();
                return true;
            case 3:
                a(azh.a(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zC = c();
                parcel2.writeNoException();
                azh.a(parcel2, zC);
                return true;
            case 5:
                int iD = d();
                parcel2.writeNoException();
                parcel2.writeInt(iD);
                return true;
            case 6:
                float fE = e();
                parcel2.writeNoException();
                parcel2.writeFloat(fE);
                return true;
            case 7:
                float f = f();
                parcel2.writeNoException();
                parcel2.writeFloat(f);
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    btbVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (iInterfaceQueryLocalInterface instanceof bsz) {
                        btbVar = (bsz) iInterfaceQueryLocalInterface;
                    } else {
                        btbVar = new btb(strongBinder);
                    }
                }
                a(btbVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float fH = h();
                parcel2.writeNoException();
                parcel2.writeFloat(fH);
                return true;
            case 10:
                boolean zI = i();
                parcel2.writeNoException();
                azh.a(parcel2, zI);
                return true;
            case 11:
                bsz bszVarG = g();
                parcel2.writeNoException();
                azh.a(parcel2, bszVarG);
                return true;
            case 12:
                boolean zJ = j();
                parcel2.writeNoException();
                azh.a(parcel2, zJ);
                return true;
            default:
                return false;
        }
    }
}
