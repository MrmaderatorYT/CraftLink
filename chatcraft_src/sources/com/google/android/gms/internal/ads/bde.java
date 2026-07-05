package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class bde implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Handler f2539a;

    bde(bcd bcdVar, Handler handler) {
        this.f2539a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f2539a.post(runnable);
    }
}
