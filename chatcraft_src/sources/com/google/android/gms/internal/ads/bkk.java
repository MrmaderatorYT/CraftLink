package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class bkk implements Parcelable {
    public static final Parcelable.Creator<bkk> CREATOR = new bkl();

    /* renamed from: a, reason: collision with root package name */
    public final int f2765a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2766b;
    public final int c;
    public final byte[] d;
    private int e;

    public bkk(int i, int i2, int i3, byte[] bArr) {
        this.f2765a = i;
        this.f2766b = i2;
        this.c = i3;
        this.d = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    bkk(Parcel parcel) {
        this.f2765a = parcel.readInt();
        this.f2766b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bkk bkkVar = (bkk) obj;
        return this.f2765a == bkkVar.f2765a && this.f2766b == bkkVar.f2766b && this.c == bkkVar.c && Arrays.equals(this.d, bkkVar.d);
    }

    public final String toString() {
        int i = this.f2765a;
        int i2 = this.f2766b;
        int i3 = this.c;
        boolean z = this.d != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = ((((((this.f2765a + 527) * 31) + this.f2766b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2765a);
        parcel.writeInt(this.f2766b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d != null ? 1 : 0);
        if (this.d != null) {
            parcel.writeByteArray(this.d);
        }
    }
}
