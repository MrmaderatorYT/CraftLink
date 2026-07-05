package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class axu implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f2389a = Executors.defaultThreadFactory();

    axu() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f2389a.newThread(runnable);
        threadNewThread.setName(String.valueOf(threadNewThread.getName()).concat(":"));
        return threadNewThread;
    }
}
