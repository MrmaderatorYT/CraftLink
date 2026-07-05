package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class pb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicInteger f3342a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f3343b;
    private final /* synthetic */ abv c;
    private final /* synthetic */ List d;

    pb(AtomicInteger atomicInteger, int i, abv abvVar, List list) {
        this.f3342a = atomicInteger;
        this.f3343b = i;
        this.c = abvVar;
        this.d = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3342a.incrementAndGet() >= this.f3343b) {
            try {
                this.c.b(ot.b(this.d));
            } catch (InterruptedException | ExecutionException e) {
                xe.c("Unable to convert list of futures to a future of list", e);
            }
        }
    }
}
