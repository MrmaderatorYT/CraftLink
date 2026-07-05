package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static c read(VersionedParcel versionedParcel) {
        c cVar = new c();
        cVar.f933a = versionedParcel.b(cVar.f933a, 1);
        cVar.f934b = versionedParcel.b(cVar.f934b, 2);
        cVar.c = versionedParcel.b(cVar.c, 3);
        cVar.d = versionedParcel.b(cVar.d, 4);
        return cVar;
    }

    public static void write(c cVar, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.a(cVar.f933a, 1);
        versionedParcel.a(cVar.f934b, 2);
        versionedParcel.a(cVar.c, 3);
        versionedParcel.a(cVar.d, 4);
    }
}
