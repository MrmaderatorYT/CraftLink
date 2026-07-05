package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f660a = versionedParcel.b(iconCompat.f660a, 1);
        iconCompat.c = versionedParcel.b(iconCompat.c, 2);
        iconCompat.d = versionedParcel.b((VersionedParcel) iconCompat.d, 3);
        iconCompat.e = versionedParcel.b(iconCompat.e, 4);
        iconCompat.f = versionedParcel.b(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) versionedParcel.b((VersionedParcel) iconCompat.g, 6);
        iconCompat.j = versionedParcel.b(iconCompat.j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(true, true);
        iconCompat.a(versionedParcel.a());
        versionedParcel.a(iconCompat.f660a, 1);
        versionedParcel.a(iconCompat.c, 2);
        versionedParcel.a(iconCompat.d, 3);
        versionedParcel.a(iconCompat.e, 4);
        versionedParcel.a(iconCompat.f, 5);
        versionedParcel.a(iconCompat.g, 6);
        versionedParcel.a(iconCompat.j, 7);
    }
}
