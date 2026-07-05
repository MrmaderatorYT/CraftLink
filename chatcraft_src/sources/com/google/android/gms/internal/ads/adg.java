package com.google.android.gms.internal.ads;

import android.os.Looper;

/* loaded from: classes.dex */
final class adg implements Runnable {
    adg(adf adfVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
