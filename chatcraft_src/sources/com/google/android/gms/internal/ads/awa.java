package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes.dex */
final class awa<E> implements Iterator<E> {

    /* renamed from: a, reason: collision with root package name */
    private int f2335a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ avz f2336b;

    awa(avz avzVar) {
        this.f2336b = avzVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2335a < this.f2336b.f2331a.size() || this.f2336b.f2332b.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.f2335a >= this.f2336b.f2331a.size()) {
            this.f2336b.f2331a.add(this.f2336b.f2332b.next());
        }
        List<E> list = this.f2336b.f2331a;
        int i = this.f2335a;
        this.f2335a = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
