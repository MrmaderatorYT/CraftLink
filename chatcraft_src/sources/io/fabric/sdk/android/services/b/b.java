package io.fabric.sdk.android.services.b;

/* compiled from: AdvertisingInfo.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f4202a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4203b;

    b(String str, boolean z) {
        this.f4202a = str;
        this.f4203b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4203b != bVar.f4203b) {
            return false;
        }
        return this.f4202a == null ? bVar.f4202a == null : this.f4202a.equals(bVar.f4202a);
    }

    public int hashCode() {
        return ((this.f4202a != null ? this.f4202a.hashCode() : 0) * 31) + (this.f4203b ? 1 : 0);
    }
}
