package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public final class j extends com.google.android.gms.internal.b.a implements i {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.i
    public final com.google.android.gms.dynamic.a a(com.google.android.gms.dynamic.a aVar, String str, int i) {
        Parcel parcelB = b();
        com.google.android.gms.internal.b.c.a(parcelB, aVar);
        parcelB.writeString(str);
        parcelB.writeInt(i);
        Parcel parcelA = a(2, parcelB);
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.dynamite.i
    public final int a(com.google.android.gms.dynamic.a aVar, String str, boolean z) {
        Parcel parcelB = b();
        com.google.android.gms.internal.b.c.a(parcelB, aVar);
        parcelB.writeString(str);
        com.google.android.gms.internal.b.c.a(parcelB, z);
        Parcel parcelA = a(3, parcelB);
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }

    @Override // com.google.android.gms.dynamite.i
    public final com.google.android.gms.dynamic.a b(com.google.android.gms.dynamic.a aVar, String str, int i) {
        Parcel parcelB = b();
        com.google.android.gms.internal.b.c.a(parcelB, aVar);
        parcelB.writeString(str);
        parcelB.writeInt(i);
        Parcel parcelA = a(4, parcelB);
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.dynamite.i
    public final int b(com.google.android.gms.dynamic.a aVar, String str, boolean z) {
        Parcel parcelB = b();
        com.google.android.gms.internal.b.c.a(parcelB, aVar);
        parcelB.writeString(str);
        com.google.android.gms.internal.b.c.a(parcelB, z);
        Parcel parcelA = a(5, parcelB);
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }

    @Override // com.google.android.gms.dynamite.i
    public final int a() {
        Parcel parcelA = a(6, b());
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }
}
