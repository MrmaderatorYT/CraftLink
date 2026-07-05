package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public interface abl<A> extends Future<A> {
    void a(Runnable runnable, Executor executor);
}
