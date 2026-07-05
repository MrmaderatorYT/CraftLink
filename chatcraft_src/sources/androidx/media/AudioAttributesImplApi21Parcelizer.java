package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static b read(VersionedParcel versionedParcel) {
        b bVar = new b();
        bVar.f931a = (AudioAttributes) versionedParcel.b((VersionedParcel) bVar.f931a, 1);
        bVar.f932b = versionedParcel.b(bVar.f932b, 2);
        return bVar;
    }

    public static void write(b bVar, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.a(bVar.f931a, 1);
        versionedParcel.a(bVar.f932b, 2);
    }
}
