package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f43a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44b;

    RatingCompat(int i, float f) {
        this.f43a = i;
        this.f44b = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f43a);
        sb.append(" rating=");
        sb.append(this.f44b < 0.0f ? "unrated" : String.valueOf(this.f44b));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f43a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f43a);
        parcel.writeFloat(this.f44b);
    }
}
