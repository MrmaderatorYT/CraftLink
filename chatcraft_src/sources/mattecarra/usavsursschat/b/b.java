package mattecarra.usavsursschat.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;

/* compiled from: PlayerParcelable.java */
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: mattecarra.usavsursschat.b.b.1
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
    private String f4926a;

    /* renamed from: b, reason: collision with root package name */
    private String f4927b;
    private SpannableString c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b(SpannableString spannableString, String str, String str2) {
        this.f4926a = str;
        this.f4927b = str2;
        this.c = spannableString;
    }

    protected b(Parcel parcel) {
        this.f4926a = parcel.readString();
        this.f4927b = parcel.readString();
        this.c = (SpannableString) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public String a() {
        return this.f4926a;
    }

    public String b() {
        return this.f4927b;
    }

    public SpannableString c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).b().equals(b()) || super.equals(obj);
        }
        return super.equals(obj);
    }

    public String toString() {
        return this.f4926a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4926a);
        parcel.writeString(this.f4927b);
        TextUtils.writeToParcel(this.c, parcel, i);
    }
}
