package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class apb extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f2137a;

    public apb(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f2137a = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.f2137a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        apb apbVar = (apb) obj;
        return this.f2137a == apbVar.f2137a && get() == apbVar.get();
    }
}
