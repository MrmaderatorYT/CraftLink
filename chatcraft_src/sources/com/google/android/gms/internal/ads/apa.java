package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
final class apa {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<apb, List<Throwable>> f2135a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<Throwable> f2136b = new ReferenceQueue<>();

    apa() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> referencePoll = this.f2136b.poll();
        while (referencePoll != null) {
            this.f2135a.remove(referencePoll);
            referencePoll = this.f2136b.poll();
        }
        return this.f2135a.get(new apb(th, null));
    }
}
