package mattecarra.usavsursschat.b;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;

/* compiled from: ServerFat.java */
/* loaded from: classes.dex */
public class d extends c implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: mattecarra.usavsursschat.b.d.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    public int e;
    public int f;
    public long g;
    public SpannableString h;
    public Bitmap i;
    private boolean j;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public d(String str, String str2, int i, int i2) {
        super(str, str2, i, i2);
        this.e = 1;
        this.f = 0;
        this.g = -1L;
        this.j = true;
    }

    public d(c cVar) {
        this(cVar.a(), cVar.b(), cVar.c(), cVar.d());
    }

    public d(Parcel parcel) {
        this.e = 1;
        this.f = 0;
        this.g = -1L;
        this.j = true;
        this.f4928a = parcel.readString();
        this.f4929b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.h = (SpannableString) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = (Bitmap) parcel.readValue(Bitmap.class.getClassLoader());
    }

    public boolean e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.c == this.c && dVar.f4929b.equals(this.f4929b) && dVar.f4928a.equals(this.f4928a)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.f4928a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4928a);
        parcel.writeString(this.f4929b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        TextUtils.writeToParcel(this.h, parcel, 0);
        parcel.writeValue(this.i);
    }
}
