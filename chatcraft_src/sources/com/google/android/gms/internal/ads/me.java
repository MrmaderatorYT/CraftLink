package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class me extends azg implements md {
    public me() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static md a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (iInterfaceQueryLocalInterface instanceof md) {
            return (md) iInterfaceQueryLocalInterface;
        }
        return new mf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        mg mhVar = null;
        lz maVar = null;
        mb mcVar = null;
        lx lyVar = null;
        lu lvVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                String string = parcel.readString();
                Bundle bundle = (Bundle) azh.a(parcel, Bundle.CREATOR);
                Bundle bundle2 = (Bundle) azh.a(parcel, Bundle.CREATOR);
                bqn bqnVar = (bqn) azh.a(parcel, bqn.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                    if (iInterfaceQueryLocalInterface instanceof mg) {
                        mhVar = (mg) iInterfaceQueryLocalInterface;
                    } else {
                        mhVar = new mh(strongBinder);
                    }
                }
                a(aVarA, string, bundle, bundle2, bqnVar, mhVar);
                parcel2.writeNoException();
                return true;
            case 2:
                mp mpVarA = a();
                parcel2.writeNoException();
                azh.b(parcel2, mpVarA);
                return true;
            case 3:
                mp mpVarB = b();
                parcel2.writeNoException();
                azh.b(parcel2, mpVarB);
                return true;
            case 4:
                String string2 = parcel.readString();
                String string3 = parcel.readString();
                Bundle bundle3 = (Bundle) azh.a(parcel, Bundle.CREATOR);
                com.google.android.gms.dynamic.a aVarA2 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    if (iInterfaceQueryLocalInterface2 instanceof lu) {
                        lvVar = (lu) iInterfaceQueryLocalInterface2;
                    } else {
                        lvVar = new lv(strongBinder2);
                    }
                }
                a(string2, string3, bundle3, aVarA2, lvVar, kr.a(parcel.readStrongBinder()), (bqn) azh.a(parcel, bqn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                bsw bswVarC = c();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarC);
                return true;
            case 6:
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                Bundle bundle4 = (Bundle) azh.a(parcel, Bundle.CREATOR);
                com.google.android.gms.dynamic.a aVarA3 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    if (iInterfaceQueryLocalInterface3 instanceof lx) {
                        lyVar = (lx) iInterfaceQueryLocalInterface3;
                    } else {
                        lyVar = new ly(strongBinder3);
                    }
                }
                a(string4, string5, bundle4, aVarA3, lyVar, kr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                d();
                parcel2.writeNoException();
                return true;
            case 8:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                Bundle bundle5 = (Bundle) azh.a(parcel, Bundle.CREATOR);
                com.google.android.gms.dynamic.a aVarA4 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    if (iInterfaceQueryLocalInterface4 instanceof mb) {
                        mcVar = (mb) iInterfaceQueryLocalInterface4;
                    } else {
                        mcVar = new mc(strongBinder4);
                    }
                }
                a(string6, string7, bundle5, aVarA4, mcVar, kr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                e();
                parcel2.writeNoException();
                return true;
            case 10:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                a(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 12:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                Bundle bundle6 = (Bundle) azh.a(parcel, Bundle.CREATOR);
                com.google.android.gms.dynamic.a aVarA5 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    if (iInterfaceQueryLocalInterface5 instanceof lz) {
                        maVar = (lz) iInterfaceQueryLocalInterface5;
                    } else {
                        maVar = new ma(strongBinder5);
                    }
                }
                a(string8, string9, bundle6, aVarA5, maVar, kr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
