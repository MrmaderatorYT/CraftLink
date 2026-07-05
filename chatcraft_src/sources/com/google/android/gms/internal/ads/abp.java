package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public interface abp extends ExecutorService {
    abl<?> a(Runnable runnable);

    <T> abl<T> a(Callable<T> callable);
}
