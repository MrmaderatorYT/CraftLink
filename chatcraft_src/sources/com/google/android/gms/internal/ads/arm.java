package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class arm extends api<String> implements arn, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final arm f2207a;

    /* renamed from: b, reason: collision with root package name */
    private static final arn f2208b;
    private final List<Object> c;

    public arm() {
        this(10);
    }

    public arm(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private arm(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.size();
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        c();
        if (collection instanceof arn) {
            collection = ((arn) collection).d();
        }
        boolean zAddAll = this.c.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.c.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final void a(apo apoVar) {
        c();
        this.c.add(apoVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final Object b(int i) {
        return this.c.get(i);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof apo) {
            return ((apo) obj).c();
        }
        return ara.b((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final List<?> d() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.google.android.gms.internal.ads.arn
    public final arn e() {
        return a() ? new atr(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        c();
        return a(this.c.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        Object objRemove = this.c.remove(i);
        this.modCount++;
        return a(objRemove);
    }

    @Override // com.google.android.gms.internal.ads.api, com.google.android.gms.internal.ads.arf
    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        c();
        this.c.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.arf
    public final /* synthetic */ arf a(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new arm((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof apo) {
            apo apoVar = (apo) obj;
            String strC = apoVar.c();
            if (apoVar.d()) {
                this.c.set(i, strC);
            }
            return strC;
        }
        byte[] bArr = (byte[]) obj;
        String strB = ara.b(bArr);
        if (ara.a(bArr)) {
            this.c.set(i, strB);
        }
        return strB;
    }

    static {
        arm armVar = new arm();
        f2207a = armVar;
        armVar.b();
        f2208b = f2207a;
    }
}
