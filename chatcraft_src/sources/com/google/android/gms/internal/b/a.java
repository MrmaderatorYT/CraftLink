package com.google.android.gms.internal.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f3680a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3681b;

    protected a(IBinder iBinder, String str) {
        this.f3680a = iBinder;
        this.f3681b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3680a;
    }

    protected final Parcel b() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f3681b);
        return parcelObtain;
    }

    protected final Parcel a(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f3680a.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected final void b(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f3680a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
