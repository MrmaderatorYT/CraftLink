package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* loaded from: classes.dex */
final class ats implements ListIterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private ListIterator<String> f2261a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f2262b;
    private final /* synthetic */ atr c;

    ats(atr atrVar, int i) {
        this.c = atrVar;
        this.f2262b = i;
        this.f2261a = this.c.f2260a.listIterator(this.f2262b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f2261a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2261a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2261a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2261a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f2261a.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f2261a.next();
    }
}
