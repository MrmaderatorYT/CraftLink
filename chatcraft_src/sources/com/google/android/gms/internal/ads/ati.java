package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class ati<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private int f2254a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2255b;
    private Iterator<Map.Entry<K, V>> c;
    private final /* synthetic */ ata d;

    private ati(ata ataVar) {
        this.d = ataVar;
        this.f2254a = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2254a + 1 < this.d.f2246b.size() || (!this.d.c.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f2255b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f2255b = false;
        this.d.f();
        if (this.f2254a < this.d.f2246b.size()) {
            ata ataVar = this.d;
            int i = this.f2254a;
            this.f2254a = i - 1;
            ataVar.c(i);
            return;
        }
        a().remove();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.c == null) {
            this.c = this.d.c.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f2255b = true;
        int i = this.f2254a + 1;
        this.f2254a = i;
        if (i >= this.d.f2246b.size()) {
            return a().next();
        }
        return (Map.Entry) this.d.f2246b.get(this.f2254a);
    }

    /* synthetic */ ati(ata ataVar, atb atbVar) {
        this(ataVar);
    }
}
