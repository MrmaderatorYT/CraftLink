package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class atc<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private int f2247a;

    /* renamed from: b, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f2248b;
    private final /* synthetic */ ata c;

    private atc(ata ataVar) {
        this.c = ataVar;
        this.f2247a = this.c.f2246b.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return (this.f2247a > 0 && this.f2247a <= this.c.f2246b.size()) || a().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f2248b == null) {
            this.f2248b = this.c.f.entrySet().iterator();
        }
        return this.f2248b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return a().next();
        }
        List list = this.c.f2246b;
        int i = this.f2247a - 1;
        this.f2247a = i;
        return (Map.Entry) list.get(i);
    }

    /* synthetic */ atc(ata ataVar, atb atbVar) {
        this(ataVar);
    }
}
