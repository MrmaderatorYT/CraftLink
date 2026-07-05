package io.fabric.sdk.android.services.b;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable.java */
/* loaded from: classes.dex */
public abstract class h implements Runnable {
    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        a();
    }
}
