package com.google.android.gms.common.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class r extends com.google.android.gms.internal.b.b implements q {
    public r() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.internal.b.b
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                com.google.android.gms.dynamic.a aVarA = a();
                parcel2.writeNoException();
                com.google.android.gms.internal.b.c.a(parcel2, aVarA);
                return true;
            case 2:
                int iB = b();
                parcel2.writeNoException();
                parcel2.writeInt(iB);
                return true;
            default:
                return false;
        }
    }
}
