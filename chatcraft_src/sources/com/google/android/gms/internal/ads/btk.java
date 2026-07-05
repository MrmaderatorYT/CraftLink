package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class btk {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("lock")
    private static btk f3019a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3020b = new Object();
    private bsk c;
    private com.google.android.gms.ads.reward.c d;

    public static btk a() {
        btk btkVar;
        synchronized (f3020b) {
            if (f3019a == null) {
                f3019a = new btk();
            }
            btkVar = f3019a;
        }
        return btkVar;
    }

    public final void a(final Context context, String str, btn btnVar) {
        synchronized (f3020b) {
            if (this.c != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", false);
                jp.a(context, str, bundle);
                this.c = new bqx(bra.b(), context).a(context, false);
                this.c.a();
                this.c.a(new kj());
                if (str != null) {
                    this.c.a(str, com.google.android.gms.dynamic.b.a(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.btl

                        /* renamed from: a, reason: collision with root package name */
                        private final btk f3021a;

                        /* renamed from: b, reason: collision with root package name */
                        private final Context f3022b;

                        {
                            this.f3021a = this;
                            this.f3022b = context;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f3021a.a(this.f3022b);
                        }
                    }));
                }
            } catch (RemoteException e) {
                aan.c("MobileAdsSettingManager initialization failed", e);
            }
        }
    }

    public final com.google.android.gms.ads.reward.c a(Context context) {
        synchronized (f3020b) {
            if (this.d != null) {
                return this.d;
            }
            this.d = new um(context, new bqy(bra.b(), context, new kj()).a(context, false));
            return this.d;
        }
    }

    private btk() {
    }
}
