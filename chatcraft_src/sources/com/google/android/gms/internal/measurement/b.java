package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class b extends an implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (iInterfaceQueryLocalInterface instanceof a) {
            return (a) iInterfaceQueryLocalInterface;
        }
        return new c(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.an
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        d fVar = null;
        g hVar = null;
        g hVar2 = null;
        g hVar3 = null;
        d fVar2 = null;
        d fVar3 = null;
        d fVar4 = null;
        d fVar5 = null;
        d fVar6 = null;
        d fVar7 = null;
        i jVar = null;
        d fVar8 = null;
        d fVar9 = null;
        d fVar10 = null;
        d fVar11 = null;
        d fVar12 = null;
        switch (i) {
            case 1:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), (k) ao.a(parcel, k.CREATOR), parcel.readLong());
                break;
            case 2:
                a(parcel.readString(), parcel.readString(), (Bundle) ao.a(parcel, Bundle.CREATOR), ao.a(parcel), ao.a(parcel), parcel.readLong());
                break;
            case 3:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) ao.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface instanceof d) {
                        fVar = (d) iInterfaceQueryLocalInterface;
                    } else {
                        fVar = new f(strongBinder);
                    }
                }
                a(string, string2, bundle, fVar, parcel.readLong());
                break;
            case 4:
                a(parcel.readString(), parcel.readString(), a.AbstractBinderC0069a.a(parcel.readStrongBinder()), ao.a(parcel), parcel.readLong());
                break;
            case 5:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                boolean zA = ao.a(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface2 instanceof d) {
                        fVar12 = (d) iInterfaceQueryLocalInterface2;
                    } else {
                        fVar12 = new f(strongBinder2);
                    }
                }
                a(string3, string4, zA, fVar12);
                break;
            case 6:
                String string5 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface3 instanceof d) {
                        fVar11 = (d) iInterfaceQueryLocalInterface3;
                    } else {
                        fVar11 = new f(strongBinder3);
                    }
                }
                a(string5, fVar11);
                break;
            case 7:
                a(parcel.readString(), parcel.readLong());
                break;
            case 8:
                a((Bundle) ao.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                a(parcel.readString(), parcel.readString(), (Bundle) ao.a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface4 instanceof d) {
                        fVar10 = (d) iInterfaceQueryLocalInterface4;
                    } else {
                        fVar10 = new f(strongBinder4);
                    }
                }
                a(string6, string7, fVar10);
                break;
            case 11:
                a(ao.a(parcel), parcel.readLong());
                break;
            case 12:
                a(parcel.readLong());
                break;
            case 13:
                b(parcel.readLong());
                break;
            case 14:
                c(parcel.readLong());
                break;
            case 15:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface5 instanceof d) {
                        fVar9 = (d) iInterfaceQueryLocalInterface5;
                    } else {
                        fVar9 = new f(strongBinder5);
                    }
                }
                a(fVar9);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface6 instanceof d) {
                        fVar8 = (d) iInterfaceQueryLocalInterface6;
                    } else {
                        fVar8 = new f(strongBinder6);
                    }
                }
                b(fVar8);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (iInterfaceQueryLocalInterface7 instanceof i) {
                        jVar = (i) iInterfaceQueryLocalInterface7;
                    } else {
                        jVar = new j(strongBinder7);
                    }
                }
                a(jVar);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface8 instanceof d) {
                        fVar7 = (d) iInterfaceQueryLocalInterface8;
                    } else {
                        fVar7 = new f(strongBinder8);
                    }
                }
                c(fVar7);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface9 instanceof d) {
                        fVar6 = (d) iInterfaceQueryLocalInterface9;
                    } else {
                        fVar6 = new f(strongBinder9);
                    }
                }
                d(fVar6);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface10 instanceof d) {
                        fVar5 = (d) iInterfaceQueryLocalInterface10;
                    } else {
                        fVar5 = new f(strongBinder10);
                    }
                }
                e(fVar5);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface11 instanceof d) {
                        fVar4 = (d) iInterfaceQueryLocalInterface11;
                    } else {
                        fVar4 = new f(strongBinder11);
                    }
                }
                f(fVar4);
                break;
            case 23:
                b(parcel.readString(), parcel.readLong());
                break;
            case 24:
                c(parcel.readString(), parcel.readLong());
                break;
            case 25:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                b(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), (Bundle) ao.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                c(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                d(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                e(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface12 instanceof d) {
                        fVar3 = (d) iInterfaceQueryLocalInterface12;
                    } else {
                        fVar3 = new f(strongBinder12);
                    }
                }
                a(aVarA, fVar3, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) ao.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface13 instanceof d) {
                        fVar2 = (d) iInterfaceQueryLocalInterface13;
                    } else {
                        fVar2 = new f(strongBinder13);
                    }
                }
                a(bundle2, fVar2, parcel.readLong());
                break;
            case 33:
                a(parcel.readInt(), parcel.readString(), a.AbstractBinderC0069a.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface14 instanceof g) {
                        hVar3 = (g) iInterfaceQueryLocalInterface14;
                    } else {
                        hVar3 = new h(strongBinder14);
                    }
                }
                a(hVar3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface15 instanceof g) {
                        hVar2 = (g) iInterfaceQueryLocalInterface15;
                    } else {
                        hVar2 = new h(strongBinder15);
                    }
                }
                b(hVar2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface16 instanceof g) {
                        hVar = (g) iInterfaceQueryLocalInterface16;
                    } else {
                        hVar = new h(strongBinder16);
                    }
                }
                c(hVar);
                break;
            case 37:
                a(ao.b(parcel));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
