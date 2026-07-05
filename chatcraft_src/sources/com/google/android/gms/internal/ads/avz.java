package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class avz<E> extends AbstractList<E> {
    private static final awb c = awb.a(avz.class);

    /* renamed from: a, reason: collision with root package name */
    List<E> f2331a;

    /* renamed from: b, reason: collision with root package name */
    Iterator<E> f2332b;

    public avz(List<E> list, Iterator<E> it) {
        this.f2331a = list;
        this.f2332b = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.f2331a.size() > i) {
            return this.f2331a.get(i);
        }
        if (this.f2332b.hasNext()) {
            this.f2331a.add(this.f2332b.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new awa(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        c.a("potentially expensive size() call");
        c.a("blowup running");
        while (this.f2332b.hasNext()) {
            this.f2331a.add(this.f2332b.next());
        }
        return this.f2331a.size();
    }
}
