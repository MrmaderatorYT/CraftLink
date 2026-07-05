package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface f extends IInterface {
    void a(int i, Bundle bundle);

    void a(int i, IBinder iBinder, Bundle bundle);

    void a(int i, IBinder iBinder, k kVar);

    public static abstract class a extends com.google.android.gms.internal.b.b implements f {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.google.android.gms.internal.b.b
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) com.google.android.gms.internal.b.c.a(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    a(parcel.readInt(), (Bundle) com.google.android.gms.internal.b.c.a(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    a(parcel.readInt(), parcel.readStrongBinder(), (k) com.google.android.gms.internal.b.c.a(parcel, k.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
