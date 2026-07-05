package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class aze<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, AtomicReference<T>> f2416a = new HashMap();

    public final AtomicReference<T> a(String str) {
        synchronized (this) {
            if (!this.f2416a.containsKey(str)) {
                this.f2416a.put(str, new AtomicReference<>());
            }
        }
        return this.f2416a.get(str);
    }
}
