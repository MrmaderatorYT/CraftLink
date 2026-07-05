package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes.dex */
final class att implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<String> f2263a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ atr f2264b;

    att(atr atrVar) {
        this.f2264b = atrVar;
        this.f2263a = this.f2264b.f2260a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2263a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f2263a.next();
    }
}
