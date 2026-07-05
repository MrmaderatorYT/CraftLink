package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class beq extends bet {
    public static final Parcelable.Creator<beq> CREATOR = new ber();

    /* renamed from: a, reason: collision with root package name */
    public final String f2591a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2592b;
    private final String d;

    public beq(String str, String str2, String str3) {
        super("COMM");
        this.d = str;
        this.f2591a = str2;
        this.f2592b = str3;
    }

    beq(Parcel parcel) {
        super("COMM");
        this.d = parcel.readString();
        this.f2591a = parcel.readString();
        this.f2592b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        beq beqVar = (beq) obj;
        return bkg.a(this.f2591a, beqVar.f2591a) && bkg.a(this.d, beqVar.d) && bkg.a(this.f2592b, beqVar.f2592b);
    }

    public final int hashCode() {
        return (((((this.d != null ? this.d.hashCode() : 0) + 527) * 31) + (this.f2591a != null ? this.f2591a.hashCode() : 0)) * 31) + (this.f2592b != null ? this.f2592b.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.f2592b);
    }
}
