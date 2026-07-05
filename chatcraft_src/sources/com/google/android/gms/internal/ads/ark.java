package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class ark<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f2204a;

    public ark(Iterator<Map.Entry<K, Object>> it) {
        this.f2204a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2204a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f2204a.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f2204a.next();
        return next.getValue() instanceof arh ? new arj(next) : next;
    }
}
