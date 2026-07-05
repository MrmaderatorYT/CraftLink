package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.a;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: androidx.fragment.app.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final int[] f718a;

    /* renamed from: b, reason: collision with root package name */
    final int f719b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b(a aVar) {
        int size = aVar.f715b.size();
        this.f718a = new int[size * 6];
        if (!aVar.i) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            a.C0046a c0046a = aVar.f715b.get(i);
            int i3 = i2 + 1;
            this.f718a[i2] = c0046a.f716a;
            int i4 = i3 + 1;
            this.f718a[i3] = c0046a.f717b != null ? c0046a.f717b.o : -1;
            int i5 = i4 + 1;
            this.f718a[i4] = c0046a.c;
            int i6 = i5 + 1;
            this.f718a[i5] = c0046a.d;
            int i7 = i6 + 1;
            this.f718a[i6] = c0046a.e;
            this.f718a[i7] = c0046a.f;
            i++;
            i2 = i7 + 1;
        }
        this.f719b = aVar.g;
        this.c = aVar.h;
        this.d = aVar.k;
        this.e = aVar.m;
        this.f = aVar.n;
        this.g = aVar.o;
        this.h = aVar.p;
        this.i = aVar.q;
        this.j = aVar.r;
        this.k = aVar.s;
        this.l = aVar.t;
    }

    public b(Parcel parcel) {
        this.f718a = parcel.createIntArray();
        this.f719b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public a a(i iVar) {
        a aVar = new a(iVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f718a.length) {
            a.C0046a c0046a = new a.C0046a();
            int i3 = i + 1;
            c0046a.f716a = this.f718a[i];
            if (i.f731a) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f718a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f718a[i3];
            if (i5 >= 0) {
                c0046a.f717b = iVar.f.get(i5);
            } else {
                c0046a.f717b = null;
            }
            int i6 = i4 + 1;
            c0046a.c = this.f718a[i4];
            int i7 = i6 + 1;
            c0046a.d = this.f718a[i6];
            int i8 = i7 + 1;
            c0046a.e = this.f718a[i7];
            c0046a.f = this.f718a[i8];
            aVar.c = c0046a.c;
            aVar.d = c0046a.d;
            aVar.e = c0046a.e;
            aVar.f = c0046a.f;
            aVar.a(c0046a);
            i2++;
            i = i8 + 1;
        }
        aVar.g = this.f719b;
        aVar.h = this.c;
        aVar.k = this.d;
        aVar.m = this.e;
        aVar.i = true;
        aVar.n = this.f;
        aVar.o = this.g;
        aVar.p = this.h;
        aVar.q = this.i;
        aVar.r = this.j;
        aVar.s = this.k;
        aVar.t = this.l;
        aVar.a(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f718a);
        parcel.writeInt(this.f719b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }
}
