package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class bbt implements Parcelable, Comparator<a> {
    public static final Parcelable.Creator<bbt> CREATOR = new bbu();

    /* renamed from: a, reason: collision with root package name */
    public final int f2504a;

    /* renamed from: b, reason: collision with root package name */
    private final a[] f2505b;
    private int c;

    public bbt(List<a> list) {
        this(false, (a[]) list.toArray(new a[list.size()]));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new bbv();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2506a;

        /* renamed from: b, reason: collision with root package name */
        private int f2507b;
        private final UUID c;
        private final String d;
        private final byte[] e;

        public a(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public a(UUID uuid, String str, byte[] bArr, boolean z) {
            this.c = (UUID) bjq.a(uuid);
            this.d = (String) bjq.a(str);
            this.e = (byte[]) bjq.a(bArr);
            this.f2506a = z;
        }

        a(Parcel parcel) {
            this.c = new UUID(parcel.readLong(), parcel.readLong());
            this.d = parcel.readString();
            this.e = parcel.createByteArray();
            this.f2506a = parcel.readByte() != 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            return this.d.equals(aVar.d) && bkg.a(this.c, aVar.c) && Arrays.equals(this.e, aVar.e);
        }

        public final int hashCode() {
            if (this.f2507b == 0) {
                this.f2507b = (((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + Arrays.hashCode(this.e);
            }
            return this.f2507b;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.c.getMostSignificantBits());
            parcel.writeLong(this.c.getLeastSignificantBits());
            parcel.writeString(this.d);
            parcel.writeByteArray(this.e);
            parcel.writeByte(this.f2506a ? (byte) 1 : (byte) 0);
        }
    }

    public bbt(a... aVarArr) {
        this(true, aVarArr);
    }

    private bbt(boolean z, a... aVarArr) {
        aVarArr = z ? (a[]) aVarArr.clone() : aVarArr;
        Arrays.sort(aVarArr, this);
        for (int i = 1; i < aVarArr.length; i++) {
            if (aVarArr[i - 1].c.equals(aVarArr[i].c)) {
                String strValueOf = String.valueOf(aVarArr[i].c);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.f2505b = aVarArr;
        this.f2504a = aVarArr.length;
    }

    bbt(Parcel parcel) {
        this.f2505b = (a[]) parcel.createTypedArray(a.CREATOR);
        this.f2504a = this.f2505b.length;
    }

    public final a a(int i) {
        return this.f2505b[i];
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.f2505b);
        }
        return this.c;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f2505b, ((bbt) obj).f2505b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f2505b, 0);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(a aVar, a aVar2) {
        a aVar3 = aVar;
        a aVar4 = aVar2;
        if (azo.f2425b.equals(aVar3.c)) {
            return azo.f2425b.equals(aVar4.c) ? 0 : 1;
        }
        return aVar3.c.compareTo(aVar4.c);
    }
}
