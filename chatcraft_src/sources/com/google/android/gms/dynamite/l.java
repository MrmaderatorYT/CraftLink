package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public final class l extends com.google.android.gms.internal.b.a implements k {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.k
    public final com.google.android.gms.dynamic.a a(com.google.android.gms.dynamic.a aVar, String str, int i, com.google.android.gms.dynamic.a aVar2) {
        Parcel parcelB = b();
        com.google.android.gms.internal.b.c.a(parcelB, aVar);
        parcelB.writeString(str);
        parcelB.writeInt(i);
        com.google.android.gms.internal.b.c.a(parcelB, aVar2);
        Parcel parcelA = a(2, parcelB);
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.dynamite.k
    public final com.google.android.gms.dynamic.a b(com.google.android.gms.dynamic.a aVar, String str, int i, com.google.android.gms.dynamic.a aVar2) {
        Parcel parcelB = b();
        com.google.android.gms.internal.b.c.a(parcelB, aVar);
        parcelB.writeString(str);
        parcelB.writeInt(i);
        com.google.android.gms.internal.b.c.a(parcelB, aVar2);
        Parcel parcelA = a(3, parcelB);
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }
}
