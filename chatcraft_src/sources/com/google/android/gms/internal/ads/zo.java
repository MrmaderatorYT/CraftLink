package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

@qj
/* loaded from: classes.dex */
public final class zo {

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f3636a = null;

    /* renamed from: b, reason: collision with root package name */
    private Handler f3637b = null;
    private int c = 0;
    private final Object d = new Object();

    public final Looper a() {
        Looper looper;
        synchronized (this.d) {
            if (this.c == 0) {
                if (this.f3636a == null) {
                    xe.a("Starting the looper thread.");
                    this.f3636a = new HandlerThread("LooperProvider");
                    this.f3636a.start();
                    this.f3637b = new Handler(this.f3636a.getLooper());
                    xe.a("Looper thread started.");
                } else {
                    xe.a("Resuming the looper thread");
                    this.d.notifyAll();
                }
            } else {
                com.google.android.gms.common.internal.i.a(this.f3636a, "Invalid state: mHandlerThread should already been initialized.");
            }
            this.c++;
            looper = this.f3636a.getLooper();
        }
        return looper;
    }

    public final Handler b() {
        return this.f3637b;
    }
}
