package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class beu extends bet {
    public static final Parcelable.Creator<beu> CREATOR = new bev();

    /* renamed from: a, reason: collision with root package name */
    private final String f2593a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2594b;

    public beu(String str, String str2, String str3) {
        super(str);
        this.f2593a = null;
        this.f2594b = str3;
    }

    beu(Parcel parcel) {
        super(parcel.readString());
        this.f2593a = parcel.readString();
        this.f2594b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        beu beuVar = (beu) obj;
        return this.c.equals(beuVar.c) && bkg.a(this.f2593a, beuVar.f2593a) && bkg.a(this.f2594b, beuVar.f2594b);
    }

    public final int hashCode() {
        return ((((this.c.hashCode() + 527) * 31) + (this.f2593a != null ? this.f2593a.hashCode() : 0)) * 31) + (this.f2594b != null ? this.f2594b.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.f2593a);
        parcel.writeString(this.f2594b);
    }
}
