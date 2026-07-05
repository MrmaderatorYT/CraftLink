package mattecarra.usavsursschat.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;

/* compiled from: ColorRule.java */
/* loaded from: classes.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: mattecarra.usavsursschat.b.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private SpannableString f4925a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a(SpannableString spannableString) {
        this.f4925a = spannableString;
    }

    protected a(Parcel parcel) {
        this.f4925a = (SpannableString) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public SpannableString a() {
        return this.f4925a;
    }

    public String toString() {
        return this.f4925a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TextUtils.writeToParcel(this.f4925a, parcel, i);
    }
}
