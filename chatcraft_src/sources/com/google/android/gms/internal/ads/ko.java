package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class ko extends azg implements kn {
    public ko() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        kq ksVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                bqn bqnVar = (bqn) azh.a(parcel, bqn.CREATOR);
                bqj bqjVar = (bqj) azh.a(parcel, bqj.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (iInterfaceQueryLocalInterface instanceof kq) {
                        ksVar = (kq) iInterfaceQueryLocalInterface;
                    } else {
                        ksVar = new ks(strongBinder);
                    }
                }
                a(aVarA, bqnVar, bqjVar, string, ksVar);
                parcel2.writeNoException();
                return true;
            case 2:
                com.google.android.gms.dynamic.a aVarA2 = a();
                parcel2.writeNoException();
                azh.a(parcel2, aVarA2);
                return true;
            case 3:
                com.google.android.gms.dynamic.a aVarA3 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                bqj bqjVar2 = (bqj) azh.a(parcel, bqj.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (iInterfaceQueryLocalInterface2 instanceof kq) {
                        ksVar = (kq) iInterfaceQueryLocalInterface2;
                    } else {
                        ksVar = new ks(strongBinder2);
                    }
                }
                a(aVarA3, bqjVar2, string2, ksVar);
                parcel2.writeNoException();
                return true;
            case 4:
                b();
                parcel2.writeNoException();
                return true;
            case 5:
                c();
                parcel2.writeNoException();
                return true;
            case 6:
                com.google.android.gms.dynamic.a aVarA4 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                bqn bqnVar2 = (bqn) azh.a(parcel, bqn.CREATOR);
                bqj bqjVar3 = (bqj) azh.a(parcel, bqj.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (iInterfaceQueryLocalInterface3 instanceof kq) {
                        ksVar = (kq) iInterfaceQueryLocalInterface3;
                    } else {
                        ksVar = new ks(strongBinder3);
                    }
                }
                a(aVarA4, bqnVar2, bqjVar3, string3, string4, ksVar);
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.dynamic.a aVarA5 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                bqj bqjVar4 = (bqj) azh.a(parcel, bqj.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (iInterfaceQueryLocalInterface4 instanceof kq) {
                        ksVar = (kq) iInterfaceQueryLocalInterface4;
                    } else {
                        ksVar = new ks(strongBinder4);
                    }
                }
                a(aVarA5, bqjVar4, string5, string6, ksVar);
                parcel2.writeNoException();
                return true;
            case 8:
                d();
                parcel2.writeNoException();
                return true;
            case 9:
                e();
                parcel2.writeNoException();
                return true;
            case 10:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), (bqj) azh.a(parcel, bqj.CREATOR), parcel.readString(), ve.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                a((bqj) azh.a(parcel, bqj.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                f();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zG = g();
                parcel2.writeNoException();
                azh.a(parcel2, zG);
                return true;
            case 14:
                com.google.android.gms.dynamic.a aVarA6 = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                bqj bqjVar5 = (bqj) azh.a(parcel, bqj.CREATOR);
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (iInterfaceQueryLocalInterface5 instanceof kq) {
                        ksVar = (kq) iInterfaceQueryLocalInterface5;
                    } else {
                        ksVar = new ks(strongBinder5);
                    }
                }
                a(aVarA6, bqjVar5, string7, string8, ksVar, (br) azh.a(parcel, br.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                kw kwVarH = h();
                parcel2.writeNoException();
                azh.a(parcel2, kwVarH);
                return true;
            case 16:
                kz kzVarI = i();
                parcel2.writeNoException();
                azh.a(parcel2, kzVarI);
                return true;
            case 17:
                Bundle bundleJ = j();
                parcel2.writeNoException();
                azh.b(parcel2, bundleJ);
                return true;
            case 18:
                Bundle bundleK = k();
                parcel2.writeNoException();
                azh.b(parcel2, bundleK);
                return true;
            case 19:
                Bundle bundleL = l();
                parcel2.writeNoException();
                azh.b(parcel2, bundleL);
                return true;
            case 20:
                a((bqj) azh.a(parcel, bqj.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zM = m();
                parcel2.writeNoException();
                azh.a(parcel2, zM);
                return true;
            case 23:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), ve.a(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                cz czVarN = n();
                parcel2.writeNoException();
                azh.a(parcel2, czVarN);
                return true;
            case 25:
                a(azh.a(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                bsw bswVarO = o();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarO);
                return true;
            case 27:
                lc lcVarP = p();
                parcel2.writeNoException();
                azh.a(parcel2, lcVarP);
                return true;
            default:
                return false;
        }
    }
}
