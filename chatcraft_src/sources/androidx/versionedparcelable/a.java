package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
class a extends VersionedParcel {

    /* renamed from: a, reason: collision with root package name */
    private final SparseIntArray f1139a;

    /* renamed from: b, reason: collision with root package name */
    private final Parcel f1140b;
    private final int c;
    private final int d;
    private final String e;
    private int f;
    private int g;

    a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR);
    }

    a(Parcel parcel, int i, int i2, String str) {
        this.f1139a = new SparseIntArray();
        this.f = -1;
        this.g = 0;
        this.f1140b = parcel;
        this.c = i;
        this.d = i2;
        this.g = this.c;
        this.e = str;
    }

    private int d(int i) {
        while (this.g < this.d) {
            this.f1140b.setDataPosition(this.g);
            int i2 = this.f1140b.readInt();
            int i3 = this.f1140b.readInt();
            this.g += i2;
            if (i3 == i) {
                return this.f1140b.dataPosition();
            }
        }
        return -1;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean b(int i) {
        int iD = d(i);
        if (iD == -1) {
            return false;
        }
        this.f1140b.setDataPosition(iD);
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void c(int i) {
        b();
        this.f = i;
        this.f1139a.put(i, this.f1140b.dataPosition());
        a(0);
        a(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void b() {
        if (this.f >= 0) {
            int i = this.f1139a.get(this.f);
            int iDataPosition = this.f1140b.dataPosition();
            this.f1140b.setDataPosition(i);
            this.f1140b.writeInt(iDataPosition - i);
            this.f1140b.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel c() {
        return new a(this.f1140b, this.f1140b.dataPosition(), this.g == this.c ? this.d : this.g, this.e + "  ");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f1140b.writeInt(bArr.length);
            this.f1140b.writeByteArray(bArr);
        } else {
            this.f1140b.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(int i) {
        this.f1140b.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(String str) {
        this.f1140b.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(Parcelable parcelable) {
        this.f1140b.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int d() {
        return this.f1140b.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String e() {
        return this.f1140b.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] f() {
        int i = this.f1140b.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f1140b.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T g() {
        return (T) this.f1140b.readParcelable(getClass().getClassLoader());
    }
}
