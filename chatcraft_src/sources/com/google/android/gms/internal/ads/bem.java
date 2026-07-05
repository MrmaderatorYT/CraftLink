package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class bem implements Parcelable {
    public static final Parcelable.Creator<bem> CREATOR = new ben();

    /* renamed from: a, reason: collision with root package name */
    private final a[] f2588a;

    public interface a extends Parcelable {
    }

    public bem(List<? extends a> list) {
        this.f2588a = new a[list.size()];
        list.toArray(this.f2588a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    bem(Parcel parcel) {
        this.f2588a = new a[parcel.readInt()];
        for (int i = 0; i < this.f2588a.length; i++) {
            this.f2588a[i] = (a) parcel.readParcelable(a.class.getClassLoader());
        }
    }

    public final int a() {
        return this.f2588a.length;
    }

    public final a a(int i) {
        return this.f2588a[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f2588a, ((bem) obj).f2588a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2588a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2588a.length);
        for (a aVar : this.f2588a) {
            parcel.writeParcelable(aVar, 0);
        }
    }
}
