package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class aiw extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<aiw> CREATOR = new aix();

    /* renamed from: a, reason: collision with root package name */
    private final int f2011a;

    /* renamed from: b, reason: collision with root package name */
    private akp f2012b = null;
    private byte[] c;

    aiw(int i, byte[] bArr) {
        this.f2011a = i;
        this.c = bArr;
        b();
    }

    public final akp a() {
        if (!(this.f2012b != null)) {
            try {
                this.f2012b = (akp) aus.a(new akp(), this.c);
                this.c = null;
            } catch (zzbuy e) {
                throw new IllegalStateException(e);
            }
        }
        b();
        return this.f2012b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        byte[] bArrA;
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f2011a);
        if (this.c != null) {
            bArrA = this.c;
        } else {
            bArrA = aus.a(this.f2012b);
        }
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, bArrA, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }

    private final void b() {
        if (this.f2012b != null || this.c == null) {
            if (this.f2012b == null || this.c != null) {
                if (this.f2012b != null && this.c != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.f2012b == null && this.c == null) {
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Impossible");
            }
        }
    }
}
