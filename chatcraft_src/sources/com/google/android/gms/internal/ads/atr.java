package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class atr extends AbstractList<String> implements arn, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final arn f2260a;

    public atr(arn arnVar) {
        this.f2260a = arnVar;
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final arn e() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final Object b(int i) {
        return this.f2260a.b(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2260a.size();
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final void a(apo apoVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new ats(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new att(this);
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final List<?> d() {
        return this.f2260a.d();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.f2260a.get(i);
    }
}
