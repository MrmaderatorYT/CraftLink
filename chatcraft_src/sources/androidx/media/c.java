package androidx.media;

import java.util.Arrays;

/* compiled from: AudioAttributesImplBase.java */
/* loaded from: classes.dex */
class c implements a {

    /* renamed from: a, reason: collision with root package name */
    int f933a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f934b = 0;
    int c = 0;
    int d = -1;

    c() {
    }

    public int a() {
        if (this.d != -1) {
            return this.d;
        }
        return AudioAttributesCompat.a(false, this.c, this.f933a);
    }

    public int b() {
        return this.f934b;
    }

    public int c() {
        return this.f933a;
    }

    public int d() {
        int i = this.c;
        int iA = a();
        if (iA == 6) {
            i |= 4;
        } else if (iA == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f934b), Integer.valueOf(this.c), Integer.valueOf(this.f933a), Integer.valueOf(this.d)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f934b == cVar.b() && this.c == cVar.d() && this.f933a == cVar.c() && this.d == cVar.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f933a));
        sb.append(" content=");
        sb.append(this.f934b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }
}
