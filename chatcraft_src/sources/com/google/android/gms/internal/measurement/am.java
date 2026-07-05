package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class am implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f3685a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3686b;

    protected am(IBinder iBinder, String str) {
        this.f3685a = iBinder;
        this.f3686b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3685a;
    }

    protected final Parcel a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f3686b);
        return parcelObtain;
    }

    protected final void a(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f3685a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
