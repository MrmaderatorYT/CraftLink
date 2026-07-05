package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.List;

/* loaded from: classes.dex */
public abstract class da extends azg implements cz {
    public da() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static cz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (iInterfaceQueryLocalInterface instanceof cz) {
            return (cz) iInterfaceQueryLocalInterface;
        }
        return new db(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String strA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 2:
                cd cdVarB = b(parcel.readString());
                parcel2.writeNoException();
                azh.a(parcel2, cdVarB);
                return true;
            case 3:
                List<String> listE = e();
                parcel2.writeNoException();
                parcel2.writeStringList(listE);
                return true;
            case 4:
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            case 5:
                c(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                h();
                parcel2.writeNoException();
                return true;
            case 7:
                bsw bswVarG = g();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarG);
                return true;
            case 8:
                j();
                parcel2.writeNoException();
                return true;
            case 9:
                com.google.android.gms.dynamic.a aVarI = i();
                parcel2.writeNoException();
                azh.a(parcel2, aVarI);
                return true;
            case 10:
                boolean zA = a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                azh.a(parcel2, zA);
                return true;
            case 11:
                com.google.android.gms.dynamic.a aVarF = f();
                parcel2.writeNoException();
                azh.a(parcel2, aVarF);
                return true;
            default:
                return false;
        }
    }
}
