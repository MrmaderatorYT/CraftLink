package com.google.gson.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: LinkedTreeMap.java */
/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f = !h.class.desiredAssertionStatus();
    private static final Comparator<Comparable> g = new Comparator<Comparable>() { // from class: com.google.gson.b.h.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    Comparator<? super K> f3999a;

    /* renamed from: b, reason: collision with root package name */
    d<K, V> f4000b;
    int c;
    int d;
    final d<K, V> e;
    private h<K, V>.a h;
    private h<K, V>.b i;

    public h() {
        this(g);
    }

    public h(Comparator<? super K> comparator) {
        this.c = 0;
        this.d = 0;
        this.e = new d<>();
        this.f3999a = comparator == null ? g : comparator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            return dVarA.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> dVarA = a((h<K, V>) k, true);
        V v2 = dVarA.g;
        dVarA.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f4000b = null;
        this.c = 0;
        this.d++;
        d<K, V> dVar = this.e;
        dVar.e = dVar;
        dVar.d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> dVarB = b(obj);
        if (dVarB != null) {
            return dVarB.g;
        }
        return null;
    }

    d<K, V> a(K k, boolean z) {
        int iCompare;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f3999a;
        d<K, V> dVar2 = this.f4000b;
        if (dVar2 != null) {
            Comparable comparable = comparator == g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    iCompare = comparable.compareTo(dVar2.f);
                } else {
                    iCompare = comparator.compare(k, dVar2.f);
                }
                if (iCompare == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = iCompare < 0 ? dVar2.f4007b : dVar2.c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            iCompare = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.e;
        if (dVar2 == null) {
            if (comparator == g && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            dVar = new d<>(dVar2, k, dVar4, dVar4.e);
            this.f4000b = dVar;
        } else {
            dVar = new d<>(dVar2, k, dVar4, dVar4.e);
            if (iCompare < 0) {
                dVar2.f4007b = dVar;
            } else {
                dVar2.c = dVar;
            }
            b(dVar2, true);
        }
        this.c++;
        this.d++;
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    d<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a((h<K, V>) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> dVarA = a(entry.getKey());
        if (dVarA != null && a(dVarA.g, entry.getValue())) {
            return dVarA;
        }
        return null;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void a(d<K, V> dVar, boolean z) {
        int i;
        if (z) {
            dVar.e.d = dVar.d;
            dVar.d.e = dVar.e;
        }
        d<K, V> dVar2 = dVar.f4007b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar.f4006a;
        int i2 = 0;
        if (dVar2 != null && dVar3 != null) {
            d<K, V> dVarB = dVar2.h > dVar3.h ? dVar2.b() : dVar3.a();
            a((d) dVarB, false);
            d<K, V> dVar5 = dVar.f4007b;
            if (dVar5 != null) {
                i = dVar5.h;
                dVarB.f4007b = dVar5;
                dVar5.f4006a = dVarB;
                dVar.f4007b = null;
            } else {
                i = 0;
            }
            d<K, V> dVar6 = dVar.c;
            if (dVar6 != null) {
                i2 = dVar6.h;
                dVarB.c = dVar6;
                dVar6.f4006a = dVarB;
                dVar.c = null;
            }
            dVarB.h = Math.max(i, i2) + 1;
            a((d) dVar, (d) dVarB);
            return;
        }
        if (dVar2 != null) {
            a((d) dVar, (d) dVar2);
            dVar.f4007b = null;
        } else if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar4, false);
        this.c--;
        this.d++;
    }

    d<K, V> b(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            a((d) dVarA, true);
        }
        return dVarA;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f4006a;
        dVar.f4006a = null;
        if (dVar2 != null) {
            dVar2.f4006a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f4007b == dVar) {
                dVar3.f4007b = dVar2;
                return;
            } else {
                if (!f && dVar3.c != dVar) {
                    throw new AssertionError();
                }
                dVar3.c = dVar2;
                return;
            }
        }
        this.f4000b = dVar2;
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f4007b;
            d<K, V> dVar3 = dVar.c;
            int i = dVar2 != null ? dVar2.h : 0;
            int i2 = dVar3 != null ? dVar3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.f4007b;
                d<K, V> dVar5 = dVar3.c;
                int i4 = (dVar4 != null ? dVar4.h : 0) - (dVar5 != null ? dVar5.h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    a((d) dVar);
                } else {
                    if (!f && i4 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar3);
                    a((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                d<K, V> dVar6 = dVar2.f4007b;
                d<K, V> dVar7 = dVar2.c;
                int i5 = (dVar6 != null ? dVar6.h : 0) - (dVar7 != null ? dVar7.h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    b((d) dVar);
                } else {
                    if (!f && i5 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar2);
                    b((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                dVar.h = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!f && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                dVar.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f4006a;
        }
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f4007b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar3.f4007b;
        d<K, V> dVar5 = dVar3.c;
        dVar.c = dVar4;
        if (dVar4 != null) {
            dVar4.f4006a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f4007b = dVar;
        dVar.f4006a = dVar3;
        dVar.h = Math.max(dVar2 != null ? dVar2.h : 0, dVar4 != null ? dVar4.h : 0) + 1;
        dVar3.h = Math.max(dVar.h, dVar5 != null ? dVar5.h : 0) + 1;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f4007b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar2.f4007b;
        d<K, V> dVar5 = dVar2.c;
        dVar.f4007b = dVar5;
        if (dVar5 != null) {
            dVar5.f4006a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.c = dVar;
        dVar.f4006a = dVar2;
        dVar.h = Math.max(dVar3 != null ? dVar3.h : 0, dVar5 != null ? dVar5.h : 0) + 1;
        dVar2.h = Math.max(dVar.h, dVar4 != null ? dVar4.h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.i = bVar2;
        return bVar2;
    }

    /* compiled from: LinkedTreeMap.java */
    static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        d<K, V> f4006a;

        /* renamed from: b, reason: collision with root package name */
        d<K, V> f4007b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        V g;
        int h;

        d() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f4006a = dVar;
            this.f = k;
            this.h = 1;
            this.d = dVar2;
            this.e = dVar3;
            dVar3.d = this;
            dVar2.e = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f.equals(entry.getKey())) {
                return false;
            }
            if (this.g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.f == null ? 0 : this.f.hashCode()) ^ (this.g != null ? this.g.hashCode() : 0);
        }

        public String toString() {
            return this.f + "=" + this.g;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f4007b; dVar2 != null; dVar2 = dVar2.f4007b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.c; dVar2 != null; dVar2 = dVar2.c) {
                dVar = dVar2;
            }
            return dVar;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    private abstract class c<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        d<K, V> f4005b;
        d<K, V> c = null;
        int d;

        c() {
            this.f4005b = h.this.e.d;
            this.d = h.this.d;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4005b != h.this.e;
        }

        final d<K, V> b() {
            d<K, V> dVar = this.f4005b;
            if (dVar == h.this.e) {
                throw new NoSuchElementException();
            }
            if (h.this.d != this.d) {
                throw new ConcurrentModificationException();
            }
            this.f4005b = dVar.d;
            this.c = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            h.this.a((d) this.c, true);
            this.c = null;
            this.d = h.this.d;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new h<K, V>.c<Map.Entry<K, V>>() { // from class: com.google.gson.b.h.a.1
                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> next() {
                    return b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            d<K, V> dVarA;
            if (!(obj instanceof Map.Entry) || (dVarA = h.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            h.this.a((d) dVarA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }
    }

    /* compiled from: LinkedTreeMap.java */
    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new h<K, V>.c<K>() { // from class: com.google.gson.b.h.b.1
                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return b().f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }
    }
}
