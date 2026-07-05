package androidx.i;

import android.os.IBinder;

/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
class aj implements al {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f817a;

    aj(IBinder iBinder) {
        this.f817a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof aj) && ((aj) obj).f817a.equals(this.f817a);
    }

    public int hashCode() {
        return this.f817a.hashCode();
    }
}
