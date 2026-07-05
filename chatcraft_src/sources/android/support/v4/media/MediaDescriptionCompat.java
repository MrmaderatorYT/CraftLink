package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(android.support.v4.media.a.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final String f37a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f38b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f37a = str;
        this.f38b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f37a = parcel.readString();
        this.f38b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.e = (Bitmap) parcel.readParcelable(classLoader);
        this.f = (Uri) parcel.readParcelable(classLoader);
        this.g = parcel.readBundle(classLoader);
        this.h = (Uri) parcel.readParcelable(classLoader);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f37a);
            TextUtils.writeToParcel(this.f38b, parcel, i);
            TextUtils.writeToParcel(this.c, parcel, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f, i);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i);
            return;
        }
        android.support.v4.media.a.a(a(), parcel, i);
    }

    public String toString() {
        return ((Object) this.f38b) + ", " + ((Object) this.c) + ", " + ((Object) this.d);
    }

    public Object a() {
        if (this.i != null || Build.VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object objA = a.C0011a.a();
        a.C0011a.a(objA, this.f37a);
        a.C0011a.a(objA, this.f38b);
        a.C0011a.b(objA, this.c);
        a.C0011a.c(objA, this.d);
        a.C0011a.a(objA, this.e);
        a.C0011a.a(objA, this.f);
        Bundle bundle = this.g;
        if (Build.VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        a.C0011a.a(objA, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            b.a.a(objA, this.h);
        }
        this.i = a.C0011a.a(objA);
        return this.i;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        a aVar = new a();
        aVar.a(android.support.v4.media.a.a(obj));
        aVar.a(android.support.v4.media.a.b(obj));
        aVar.b(android.support.v4.media.a.c(obj));
        aVar.c(android.support.v4.media.a.d(obj));
        aVar.a(android.support.v4.media.a.e(obj));
        aVar.a(android.support.v4.media.a.f(obj));
        Bundle bundleG = android.support.v4.media.a.g(obj);
        if (bundleG != null) {
            MediaSessionCompat.a(bundleG);
            uri = (Uri) bundleG.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri == null) {
            bundle = bundleG;
        } else if (!bundleG.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleG.size() != 2) {
            bundleG.remove("android.support.v4.media.description.MEDIA_URI");
            bundleG.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleG;
        }
        aVar.a(bundle);
        if (uri != null) {
            aVar.b(uri);
        } else if (Build.VERSION.SDK_INT >= 23) {
            aVar.b(b.a(obj));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = aVar.a();
        mediaDescriptionCompatA.i = obj;
        return mediaDescriptionCompatA;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f39a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f40b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a a(String str) {
            this.f39a = str;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f40b = charSequence;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public a a(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f39a, this.f40b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }
}
