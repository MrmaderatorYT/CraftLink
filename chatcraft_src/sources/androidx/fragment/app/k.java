package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() { // from class: androidx.fragment.app.k.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    l[] f758a;

    /* renamed from: b, reason: collision with root package name */
    int[] f759b;
    b[] c;
    int d;
    int e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public k() {
        this.d = -1;
    }

    public k(Parcel parcel) {
        this.d = -1;
        this.f758a = (l[]) parcel.createTypedArray(l.CREATOR);
        this.f759b = parcel.createIntArray();
        this.c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f758a, i);
        parcel.writeIntArray(this.f759b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
