package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.DataInputStream;
import java.io.IOException;

@qj
/* loaded from: classes.dex */
public final class ry extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<ry> CREATOR = new sb();

    /* renamed from: a, reason: collision with root package name */
    private ParcelFileDescriptor f3431a;

    /* renamed from: b, reason: collision with root package name */
    private Parcelable f3432b;
    private boolean c;

    public ry(ParcelFileDescriptor parcelFileDescriptor) {
        this.f3431a = parcelFileDescriptor;
        this.f3432b = null;
        this.c = true;
    }

    public ry(com.google.android.gms.common.internal.safeparcel.c cVar) {
        this.f3431a = null;
        this.f3432b = cVar;
        this.c = false;
    }

    public final <T extends com.google.android.gms.common.internal.safeparcel.c> T a(Parcelable.Creator<T> creator) throws IOException {
        if (this.c) {
            if (this.f3431a == null) {
                xe.c("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.f3431a));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    com.google.android.gms.common.util.h.a(dataInputStream);
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, bArr.length);
                        parcelObtain.setDataPosition(0);
                        this.f3432b = creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        this.c = false;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (IOException e) {
                    xe.b("Could not read from parcel file descriptor", e);
                    com.google.android.gms.common.util.h.a(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                com.google.android.gms.common.util.h.a(dataInputStream);
                throw th2;
            }
        }
        return (T) this.f3432b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        a();
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (Parcelable) this.f3431a, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }

    private final ParcelFileDescriptor a() {
        if (this.f3431a == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.f3432b.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                this.f3431a = a(bArrMarshall);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        return this.f3431a;
    }

    private final <T> ParcelFileDescriptor a(byte[] bArr) throws IOException {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe;
        try {
            parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
        } catch (IOException e) {
            e = e;
            autoCloseOutputStream = null;
        }
        try {
            new Thread(new rz(this, autoCloseOutputStream, bArr)).start();
            return parcelFileDescriptorArrCreatePipe[0];
        } catch (IOException e2) {
            e = e2;
            xe.b("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.ax.i().a(e, "LargeParcelTeleporter.pipeData.2");
            com.google.android.gms.common.util.h.a(autoCloseOutputStream);
            return null;
        }
    }
}
