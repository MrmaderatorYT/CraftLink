package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class azf implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f2417a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2418b;

    protected azf(IBinder iBinder, String str) {
        this.f2417a = iBinder;
        this.f2418b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2417a;
    }

    protected final Parcel z() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f2418b);
        return parcelObtain;
    }

    protected final Parcel a(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f2417a.transact(i, parcel, parcelObtain, 0);
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
            this.f2417a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected final void c(int i, Parcel parcel) {
        try {
            this.f2417a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
