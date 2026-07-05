package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* compiled from: AudioAttributesImplApi21.java */
@TargetApi(21)
/* loaded from: classes.dex */
class b implements a {

    /* renamed from: a, reason: collision with root package name */
    AudioAttributes f931a;

    /* renamed from: b, reason: collision with root package name */
    int f932b = -1;

    b() {
    }

    public int hashCode() {
        return this.f931a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f931a.equals(((b) obj).f931a);
        }
        return false;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f931a;
    }
}
