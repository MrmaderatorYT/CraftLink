package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@qj
/* loaded from: classes.dex */
public final class xg extends Handler {
    public xg(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "AdMobHandler.handleMessage");
        }
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.ax.e();
            xn.a(com.google.android.gms.ads.internal.ax.i().l(), th);
            throw th;
        }
    }
}
