package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.bsw;
import com.google.android.gms.internal.ads.bub;
import com.google.android.gms.internal.ads.qj;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1659a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private bsw f1660b;

    @GuardedBy("mLock")
    private a c;

    public static abstract class a {
        public void a() {
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public final void a(bsw bswVar) {
        synchronized (this.f1659a) {
            this.f1660b = bswVar;
            if (this.c != null) {
                a(this.c);
            }
        }
    }

    public final bsw a() {
        bsw bswVar;
        synchronized (this.f1659a) {
            bswVar = this.f1660b;
        }
        return bswVar;
    }

    public final void a(a aVar) {
        com.google.android.gms.common.internal.i.a(aVar, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f1659a) {
            this.c = aVar;
            if (this.f1660b == null) {
                return;
            }
            try {
                this.f1660b.a(new bub(aVar));
            } catch (RemoteException e) {
                aan.b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }
}
