package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class ast<E> extends api<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final ast<Object> f2236a;

    /* renamed from: b, reason: collision with root package name */
    private final List<E> f2237b;

    public static <E> ast<E> d() {
        return (ast<E>) f2236a;
    }

    ast() {
        this(new ArrayList(10));
    }

    private ast(List<E> list) {
        this.f2237b = list;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        c();
        this.f2237b.add(i, e);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.f2237b.get(i);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        c();
        E eRemove = this.f2237b.remove(i);
        this.modCount++;
        return eRemove;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        c();
        E e2 = this.f2237b.set(i, e);
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2237b.size();
    }

    @Override // com.google.android.gms.internal.ads.arf
    public final /* synthetic */ arf a(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f2237b);
        return new ast(arrayList);
    }

    static {
        ast<Object> astVar = new ast<>();
        f2236a = astVar;
        astVar.b();
    }
}
