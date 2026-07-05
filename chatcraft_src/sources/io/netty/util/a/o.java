package io.netty.util.a;

import java.util.Iterator;

/* compiled from: ReadOnlyIterator.java */
/* loaded from: classes.dex */
public final class o<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Iterator<? extends T> f4695a;

    public o(Iterator<? extends T> it) {
        if (it == null) {
            throw new NullPointerException("iterator");
        }
        this.f4695a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f4695a.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        return this.f4695a.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("read-only");
    }
}
