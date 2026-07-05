package com.google.android.material.j;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.b.g;

/* compiled from: ExtendableSavedState.java */
/* loaded from: classes.dex */
public class a extends androidx.d.a.a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>() { // from class: com.google.android.material.j.a.1
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final g<String, Bundle> f3839a;

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f3839a = new g<>();
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f3839a = new g<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f3839a.put(strArr[i2], bundleArr[i2]);
        }
    }

    @Override // androidx.d.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f3839a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f3839a.b(i2);
            bundleArr[i2] = this.f3839a.c(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f3839a + "}";
    }
}
