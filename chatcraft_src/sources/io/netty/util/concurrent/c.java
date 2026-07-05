package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: AbstractFuture.java */
/* loaded from: classes.dex */
public abstract class c<V> implements p<V> {
    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException {
        i();
        Throwable thK = k();
        if (thK == null) {
            return j();
        }
        if (thK instanceof CancellationException) {
            throw ((CancellationException) thK);
        }
        throw new ExecutionException(thK);
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (a(j, timeUnit)) {
            Throwable thK = k();
            if (thK == null) {
                return j();
            }
            if (thK instanceof CancellationException) {
                throw ((CancellationException) thK);
            }
            throw new ExecutionException(thK);
        }
        throw new TimeoutException();
    }
}
