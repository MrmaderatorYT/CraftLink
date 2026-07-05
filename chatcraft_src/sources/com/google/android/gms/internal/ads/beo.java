package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class beo extends bet {
    public static final Parcelable.Creator<beo> CREATOR = new bep();

    /* renamed from: a, reason: collision with root package name */
    private final String f2589a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2590b;
    private final int d;
    private final byte[] e;

    public beo(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f2589a = str;
        this.f2590b = null;
        this.d = 3;
        this.e = bArr;
    }

    beo(Parcel parcel) {
        super("APIC");
        this.f2589a = parcel.readString();
        this.f2590b = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        beo beoVar = (beo) obj;
        return this.d == beoVar.d && bkg.a(this.f2589a, beoVar.f2589a) && bkg.a(this.f2590b, beoVar.f2590b) && Arrays.equals(this.e, beoVar.e);
    }

    public final int hashCode() {
        return ((((((this.d + 527) * 31) + (this.f2589a != null ? this.f2589a.hashCode() : 0)) * 31) + (this.f2590b != null ? this.f2590b.hashCode() : 0)) * 31) + Arrays.hashCode(this.e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2589a);
        parcel.writeString(this.f2590b);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.e);
    }
}
