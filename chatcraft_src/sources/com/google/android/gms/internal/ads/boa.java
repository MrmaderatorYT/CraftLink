package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class boa extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<boa> CREATOR = new bob();

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private ParcelFileDescriptor f2895a;

    public boa() {
        this(null);
    }

    public boa(ParcelFileDescriptor parcelFileDescriptor) {
        this.f2895a = parcelFileDescriptor;
    }

    public final synchronized boolean a() {
        return this.f2895a != null;
    }

    public final synchronized InputStream b() {
        if (this.f2895a == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.f2895a);
        this.f2895a = null;
        return autoCloseInputStream;
    }

    private final synchronized ParcelFileDescriptor c() {
        return this.f2895a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (Parcelable) c(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
